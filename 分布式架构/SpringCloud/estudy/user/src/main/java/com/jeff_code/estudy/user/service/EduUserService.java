package com.jeff_code.estudy.user.service;

import com.jeff_code.estudy.bean.EduUser;
import com.jeff_code.estudy.util.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @Author: jefflike
 * @create: 2018/10/15
 * @describe:
 */
public interface EduUserService {

    List<EduUser> getAllEduUser();

//    Boolean saveFile(String file);

    void saveEduUser(List<EduUser> eduUsers);

    Page<EduUser> getEduUserPage(Map<String, Integer> map);

    Page<EduUser> selectEduByParam(Map<String,String> map);

    void pdateStatus(String userId);

    EduUser getEduUserById(String userId);

    void updatePass(EduUser eduUser);

    List<EduUser> selectEduBy(String allIDCheck);
}
