package com.jeff_code.estudy.manage.controller;

import com.alibaba.fastjson.JSON;
import com.jeff_code.estudy.bean.EduTeacher;
import com.jeff_code.estudy.bean.SysSubject;
import com.jeff_code.estudy.manage.service.EduTeacherService;
import com.jeff_code.estudy.util.Page;
import com.jeff_code.estudy.util.TeacherParam;
import org.apache.commons.lang.StringUtils;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jefflike
 * @create: 2018/10/17
 * @describe:
 */
@Controller
@RequestMapping("/teacher")
public class TeacherManageController {
    @Value("${fileServer.url}")
    private String fileUrl;

    @Autowired
    private EduTeacherService eduTeacherService;

    @RequestMapping("/getTeacherList")
    public String getTeacherList(HttpServletRequest request){
        return setDatas(request);
    }

    private String setDatas(HttpServletRequest request) {
        String pageno = request.getParameter("page");
        pageno = (pageno==null || pageno.length()==0)? "1" : pageno.trim();
        Page<EduTeacher> list =  eduTeacherService.selectTeacher(pageno);
        request.setAttribute("teaList",list.getDatas());
        request.setAttribute("page",list.getPageno());
        request.setAttribute("resPag",list);
        return "teacher/teac_list";
    }

    @RequestMapping("/teaUpdate")
    public String teaUpdate(HttpServletRequest request){
        String userId1 = request.getParameter("userId");
        String page = request.getParameter("page");
        EduTeacher eduTeacher =  eduTeacherService.selectOne(Integer.parseInt(userId1));

        List<SysSubject> sysSubjectli = getSysSubjectli();

        List<SysSubject> list =  eduTeacherService.selectBroth(eduTeacher.getSubjectId());
        request.setAttribute("eduTeacher",eduTeacher);
        request.setAttribute("subList",sysSubjectli);
        request.setAttribute("subListChil",list);
        request.setAttribute("parentId",list.get(0).getParentId());
        request.setAttribute("pageno",page);
        return "teacher/teac_edit";
    }

    private List<SysSubject> getSysSubjectli(){
        List<SysSubject> list =  eduTeacherService.selectSubj();

        List<SysSubject> parent= new ArrayList<>();
        for (SysSubject sysSubject : list) {
            if(sysSubject.getParentId()==0){
                parent.add(sysSubject);
            }
        }
        return parent;
    }

    @RequestMapping("/teaSearch")
    public String teaSearch(TeacherParam param, HttpServletRequest request){
        return setDatasParam(param,request);
    }

    private String setDatasParam(TeacherParam param, HttpServletRequest request) {
        String page = request.getParameter("page");
        param.setPageno(Integer.parseInt(page));
        Page<EduTeacher> list =  eduTeacherService.selectTeacherBy(param);
        request.setAttribute("teaList",list.getDatas());
        request.setAttribute("page",list.getPageno());
        request.setAttribute("resPag",list);
        request.setAttribute("param",param);
        return "teac/teac_list";
    }

    @RequestMapping("selectChi")
    @ResponseBody
    public List<SysSubject> selectChi(Integer parentId){
        List<SysSubject> list =  eduTeacherService.selectChild(parentId);
        return list;
    }

    @RequestMapping("/fileUpload")
    public String fileUpload(){
        return "/teacher/teacher_edit";
    }

    /**
     * 保存上传图片
     * @param file
     * @return
     * @throws IOException
     * @throws MyException
     */
    @RequestMapping(value = "/saveTeacherImg", method = RequestMethod.POST)
    @ResponseBody
    public String  saveTeacherImg(@RequestParam("file") MultipartFile file) throws IOException, MyException {

        String imgUrl =null;
        if (file!=null){
            String configFile = this.getClass().getResource("/tracker.conf").getFile();
            ClientGlobal.init(configFile);
            TrackerClient trackerClient=new TrackerClient();
            TrackerServer trackerServer=trackerClient.getConnection();
            StorageClient storageClient=new StorageClient(trackerServer,null);
            // 获取上传文件名
            String filename = file.getOriginalFilename();
            //  jpg 后缀名
            String extName =  StringUtils.substringAfterLast(filename,".");
            String[] upload_file = storageClient.upload_file(file.getBytes(), extName, null);
            imgUrl = fileUrl;
            for (int i = 0; i < upload_file.length; i++) {
                String path = upload_file[i];
                imgUrl += "/"+path;
            }
        }
        return JSON.toJSONString(imgUrl);//返回json对象
    }

    @RequestMapping(value = "/saveTeacher", method = RequestMethod.POST)
    public String saveTeacher(EduTeacher eduTeacher){
        Boolean flag = eduTeacherService.saveTeacher(eduTeacher);
        if(!flag){
            return "teac/teac_list";
        }
        return "teac/teac_list";
    }

/*    @RequestMapping(value = "/saveTeacher", method = RequestMethod.POST)
    public String saveTeacher(Map<String, String> map){
        System.out.println(map);
        Boolean flag = true;
//        Boolean flag = eduTeacherService.saveTeacher(eduTeacher);
        if(!flag){
            return "失败";
        }
        return "成功";
    }*/
}
