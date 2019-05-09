package com.jeff_code.estudy.user.controller;

import com.jeff_code.estudy.bean.EduUser;
import com.jeff_code.estudy.bean.SysUser;
import com.jeff_code.estudy.user.mapper.EduUserMapper;
import com.jeff_code.estudy.user.mapper.SysuserMapper;
import com.jeff_code.estudy.user.service.EduUserService;
import com.jeff_code.estudy.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @Author: jefflike
 * @create: 2018/10/13
 * @describe:
 */
@RestController
public class UserInfoController {
    @Autowired
    private SysuserMapper sysuserMapper;

    @Autowired
    private EduUserService eduUserService;

    @RequestMapping("/query/queryUser")
    public SysUser queryUser(@RequestBody Map<String, String> map){
        String username = map.get("username");
        String password = map.get("password");
        SysUser sysUser = new SysUser();
        sysUser.setLoginName(username);
        sysUser.setLoginPwd(password);
        SysUser sysUser1 = sysuserMapper.selectOne(sysUser);
        return sysUser1;
    }

    // 查询所有学生用户
    @RequestMapping("/query/queryEduUserList")
    public List<EduUser> queryEduUserList(){
        List<EduUser> eduUsers = eduUserService.getAllEduUser();
//        List<EduUser> eduUsers = eduUserMapper.selectAll();
        return eduUsers;
    }

    @RequestMapping("/getEduUserPage/getEduUserPage")
    public Page<EduUser> getEduUserPage(@RequestBody Map<String, Integer> map){
        return eduUserService.getEduUserPage(map);
    }

    @RequestMapping("/eduUserList/selectEduByParam")
    Page<EduUser> selectEduByParam(@RequestBody Map<String, String> map){
        Page<EduUser> result = eduUserService.selectEduByParam(map);
        return result;
    }

    @RequestMapping("/pdateStatus/pdateStatus/{userId}")
    public String pdateStatus(@PathVariable("userId")String userId){
        eduUserService.pdateStatus(userId);
        return "";
    }

    @RequestMapping("/getEduUserById/getEduUserById/{userId}")
    EduUser getEduUserById(@PathVariable("userId")String userId){
        return  eduUserService.getEduUserById(userId);
    }

    @RequestMapping("/updatePass/updatePass")
    String updatePass(@RequestBody EduUser eduUser){
        eduUserService.updatePass(eduUser);
        return "success";
    }

/*    // 读取excel文件保存到本地
    @RequestMapping("/eduUser/uploadFile")
    public Boolean uploadFile(@RequestBody Map<String, String> map){
        String jsonFile = map.get("jsonFile");
        Boolean flag = eduUserService.saveFile(jsonFile);
        return flag;
    }*/

    // 读取excel文件并且保存到数据库
    @RequestMapping("/eduUser/establishEduUser")
    public void establishEduUser(@RequestBody List<EduUser> eduUsers){
        eduUserService.saveEduUser(eduUsers);
    }

    @RequestMapping("/selectEduBy/selectEduBy/{allIDCheck}")
    List<EduUser> selectEduBy(@PathVariable("allIDCheck")String allIDCheck) {
        return eduUserService.selectEduBy(allIDCheck);
    }
}
