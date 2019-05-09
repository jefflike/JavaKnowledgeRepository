package com.jeff_code.estudy.manage.controller;

import com.alibaba.fastjson.JSON;
import com.jeff_code.estudy.bean.EduUser;
import com.jeff_code.estudy.bean.SysUser;
import com.jeff_code.estudy.manage.service.EduUserService;
import com.jeff_code.estudy.util.EduUserParam;
import com.jeff_code.estudy.util.ExcelUtil;
import com.jeff_code.estudy.util.Page;
import com.jeff_code.estudy.util.RedisUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;

/**
 * @Author: jefflike
 * @create: 2018/10/12
 * @describe:
 */
@Controller
@RequestMapping("/user")
public class UserManageController {
    private static Logger logger = Logger.getLogger(UserManageController.class);
    public String userKey_prefix = "user:";
    public String userinfoKey_suffix = ":info";
    public int userKey_timeOut = 60 * 60 * 24;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private EduUserService eduUserService;

    @Autowired
    private ExcelUtil excelUtil;

    /**
     * 展示登录页面
     *
     * @return
     */
    @RequestMapping("/login")
    public String LoginPage() {
        return "/user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String Login(HttpServletRequest request) {
        String username = request.getParameter("sysUser.loginName");
        String password = request.getParameter("sysUser.loginPwd");
        String newPassword = DigestUtils.md5DigestAsHex(password.getBytes());

        Map map = new HashMap<String, String>();
        map.put("username", username);
        map.put("password", newPassword);
//        Jedis jedis = redisUtil.getJedis();
        String userKey = userKey_prefix + username + userinfoKey_suffix;
//        String userinfo = jedis.get(userKey);
        SysUser user = new SysUser();
        String userinfo = null;
        if (userinfo != null) {
            user = JSON.parseObject(userinfo, SysUser.class);
        } else {
            // 查询数据库
            user = eduUserService.queryUser(map);
            if (user != null) {
                System.out.println(user);
//                jedis.setex(userKey, userKey_timeOut, JSON.toJSONString(user));
            } else {
                return "redirect:login";
            }
        }
        request.setAttribute("user", user);
        return "redirect:index";
    }

    @RequestMapping("/index")
    public String Index(HttpServletRequest request) {
        String userKey = userKey_prefix + "admin" + userinfoKey_suffix;
/*        Jedis jedis = redisUtil.getJedis();
        String userinfo = jedis.get(userKey);
        SysUser user = JSON.parseObject(userinfo, SysUser.class);*/
//        request.setAttribute("user", user);
        return "/user/index";
    }

    @RequestMapping(value = "/getUserList")
    public String getUserList(EduUserParam eduUserParam, HttpServletRequest request) {
        if(eduUserParam.getParam() == null){
            return setDatas(request);
        }else {
            return setDatas(eduUserParam, request);
        }

    }

    private String setDatas(EduUserParam eduUserParam, HttpServletRequest request){
        String pageno = request.getParameter("page");

        Map<String,String> map =  new HashMap<>();
        map.put("pageno",(pageno==null || pageno.length()==0)? "1" : pageno.trim());
        map.put("eduUserPar",JSON.toJSONString(eduUserParam));

        Page<EduUser> resPag = eduUserService.selectEduByParam(map);

        request.setAttribute("resPag",resPag);
        request.setAttribute("eduUsers",resPag.getDatas());
        return "/user/user_list";
    }

    private String setDatas(HttpServletRequest request){
        String pageno = request.getParameter("page");
        Map<String,Integer> map =  new HashMap<>();
        map.put("pageno",(pageno==null || pageno.length()==0)? 1 : Integer.parseInt(pageno.trim()));
        map.put("pagasize",5);
        Page<EduUser> resPag = eduUserService.getEduUserPage(map);

        request.setAttribute("resPag",resPag);
        request.setAttribute("eduUsers",resPag.getDatas());
        return "/user/user_list";
    }

    @RequestMapping("/updateStatus")
    public String updateStatus(String userId, HttpServletRequest request) {
        String pageno = request.getParameter("page");
        eduUserService.pdateStatus(userId + "");
        Map<String,Integer> map =  new HashMap<>();
        map.put("pageno",(pageno==null || pageno.length()==0)? 1 : Integer.parseInt(pageno.trim()));
        map.put("pagasize",5);
        Page<EduUser> resPag = eduUserService.getEduUserPage(map);

        request.setAttribute("resPag",resPag);
        request.setAttribute("eduUsers",resPag.getDatas());
        return "/user/user_list";
    }

    @RequestMapping("/pdateStatus/pdateStatus/{userId}")
    String pdateStatus(@PathVariable("userId")String userId){
        eduUserService.pdateStatus(userId);
        return "";
    }

    @RequestMapping("/updatePass")
    public String updatePass(String userId,HttpServletRequest request){
        EduUser eduUser = eduUserService.getEduUserById(userId);

        String pageno = request.getParameter("page");
        request.setAttribute("pageno",pageno);
        request.setAttribute("eduUser",eduUser);
        return "/user/uppass";
    }

    @RequestMapping("/doUpdatePass")
    public String doUpdatePass(EduUser eduUser,HttpServletRequest request){
        String res =  eduUserService.updatePass(eduUser);
        String page = request.getParameter("page");
        request.setAttribute("pageno",page);
        return "/user/upsuccess";
    }

    /**
     * 批量上传页面展示
     * @return
     */
    @RequestMapping("/establish")
    public String multiEstablishEduUser() {
        return "/user/establish";
    }

    /**
     * 批量上传操作
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
    public String fileUpload(@RequestParam("fileName") MultipartFile file) {
        if (file.isEmpty()) {
            return "失败";
        }
/*// 远程传递对象失败
       String jsonFile = JSON.toJSONString(file);
        Map map = new HashMap<String, String>();
        map.put("jsonFile", jsonFile);
        // 保存文件
        Boolean flag = eduUserService.uploadFile(map);*/
        Boolean flag = uploadFile(file);
        if (flag == true) {
            return "成功";
        } else {
            return "失败";
        }
    }

    private Boolean uploadFile(MultipartFile jsonFile) {
        String fileName = jsonFile.getOriginalFilename();

        // 暂时放硬盘，后面放文件服务器
        String path = "E:\\test";
        File dest = new File(path + "/" + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
            // 保存文件
            jsonFile.transferTo(dest);
            // 读文件存储
            List<EduUser> eduUsers = parseExcel(dest);
            eduUserService.establishEduUser(eduUsers);
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Deprecated
    private List<EduUser> parseExcel(File excelFile) {
        try {
            // 同时支持Excel 2003、2007
            FileInputStream in = new FileInputStream(excelFile);
            excelUtil.checkExcelVaild(excelFile);
            Workbook workbook = excelUtil.getWorkbok(in, excelFile);
            EduUser eduUser = new EduUser();
            List<EduUser> list = new ArrayList<EduUser>();

            Sheet sheet = workbook.getSheetAt(0);

            int count = 0;
            for (Row row : sheet) {
                //如果当前行没有数据，跳出循环
                if (row.getCell(0).toString().equals("")) {
                    return null;
                }
                // 跳过第一行的目录
                if(count < 1 ) {
                    count++;
                    continue;
                }

                Cell email = row.getCell(0);
                Cell name = row.getCell(1);
                Cell passwd = row.getCell(2);
                eduUser = new EduUser();
                eduUser.setEmail(getValue(email));
                eduUser.setMobile(getValue(name));
                eduUser.setPassword(getValue(passwd));
                list.add(eduUser);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("static-access")
    @Deprecated
    private String getValue(Cell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            // 返回字符串类型的值
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }

    /**
     * 导出数据到excel
     * @param request
     * @return
     */
    @RequestMapping("/exportExcel")
    public String exportExcel(HttpServletRequest request){
        String allIDCheck = request.getParameter("allIDCheck");
        List<EduUser> list = eduUserService.selectEduBy(allIDCheck);
        try {
            excleOut(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/user/upsuccess";
    }

    private void excleOut(List<EduUser> list) throws IOException {
        // 创建Excel文档XSSFWorkbook
        XSSFWorkbook hwb = new XSSFWorkbook();
        // 通过excle对象创建一个选项卡对象
        XSSFSheet sheet1 = hwb.createSheet("sheet1");

        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        XSSFRow row=sheet1.createRow(0);
        EduUser eduUser = null;

        row.createCell(0).setCellValue("姓名");
        row.createCell(1).setCellValue("电话");
        row.createCell(2).setCellValue("邮件");
        row.createCell(3).setCellValue("年龄");
        row.createCell(4).setCellValue("昵称");
        row.createCell(5).setCellValue("性别");
        row.createCell(6).setCellValue("状态");
        row.createCell(7).setCellValue("注册时间");

        for (int i = 0; i < list.size(); i++) {
            // 新建一行
            XSSFRow row1 = sheet1.createRow(i+1);
            eduUser = list.get(i);
            row1.createCell(0).setCellValue(eduUser.getUserName());
            row1.createCell(1).setCellValue(eduUser.getMobile());
            row1.createCell(2).setCellValue(eduUser.getEmail());
            row1.createCell(3).setCellValue(eduUser.getAge());
            row1.createCell(4).setCellValue(eduUser.getShowName());
            row1.createCell(5).setCellValue(eduUser.getSex());
            row1.createCell(6).setCellValue(eduUser.getIsAvalible());
            row1.createCell(7).setCellValue(eduUser.getCreateTime());
        }
        OutputStream out = null;
        String path = "E:\\test";

        File file = new File(path+"/eduUser"+System.currentTimeMillis()+".xlsx");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdir();
        }
        out = new FileOutputStream(file);
        hwb.write(out);
        out.close();
    }
}
