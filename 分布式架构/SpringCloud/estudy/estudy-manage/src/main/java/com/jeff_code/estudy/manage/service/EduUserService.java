package com.jeff_code.estudy.manage.service;

import com.jeff_code.estudy.bean.EduUser;
import com.jeff_code.estudy.bean.SysUser;
import com.jeff_code.estudy.util.Page;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @Author: jefflike
 * @create: 2018/10/12
 * @describe:
 */
@FeignClient("user-service")
public interface EduUserService {
    // 查询管理员用户是否存在
    @RequestMapping("/query/queryUser")
    public SysUser queryUser(@RequestBody Map<String, String> map);

    // 查询所有学生用户
    @RequestMapping("/query/queryEduUserList")
    public List<EduUser> queryEduUserList();

    @RequestMapping("/getEduUserPage/getEduUserPage")
    public Page<EduUser> getEduUserPage(@RequestBody Map<String, Integer> map);

    @RequestMapping("/eduUserList/selectEduByParam")
    Page<EduUser> selectEduByParam(@RequestBody Map<String, String> map);

    @RequestMapping("/pdateStatus/pdateStatus/{userId}")
    public String pdateStatus(@PathVariable("userId")String userId);

    @RequestMapping("/getEduUserById/getEduUserById/{userId}")
    EduUser getEduUserById(@PathVariable("userId")String userId);

    @RequestMapping("/updatePass/updatePass")
    String updatePass(@RequestBody EduUser eduUser);
/*    // 读取excel文件保存到本地
    @RequestMapping("/eduUser/uploadFile")
    public Boolean uploadFile(@RequestBody List<EduUser> eduUsers);*/


    // 读取excel文件并且保存到数据库
    @RequestMapping("/eduUser/establishEduUser")
    public void establishEduUser(@RequestBody List<EduUser> eduUsers);

    @RequestMapping("/selectEduBy/selectEduBy/{allIDCheck}")
    List<EduUser> selectEduBy(@PathVariable("allIDCheck")String allIDCheck);
}
