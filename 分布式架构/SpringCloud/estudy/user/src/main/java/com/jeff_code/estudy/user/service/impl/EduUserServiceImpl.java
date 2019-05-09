package com.jeff_code.estudy.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.jeff_code.estudy.bean.EduUser;
import com.jeff_code.estudy.user.mapper.EduUserMapper;
import com.jeff_code.estudy.user.service.EduUserService;
import com.jeff_code.estudy.util.EduUserParam;
import com.jeff_code.estudy.util.ExcelUtil;
import com.jeff_code.estudy.util.Page;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: jefflike
 * @create: 2018/10/15
 * @describe:
 */
@Service
public class EduUserServiceImpl implements EduUserService {
    @Autowired
    private EduUserMapper eduUserMapper;

    @Override
    public List<EduUser> getAllEduUser() {
        return eduUserMapper.selectAll();
    }

/*
    @Override
    public Boolean saveFile(String jsonFile){
        MultipartFile jsonFile2 = (MultipartFile) JSON.parseObject(jsonFile);
*/
/*        Map map = JSON.parseObject(jsonFile, Map.class);
        String jsonFile1 = (String) map.get("bytes");
        MultipartFile jsonFile2 = JSON.parseObject(jsonFile1, MultipartFile.class);*//*

        String fileName = jsonFile2.getOriginalFilename();

        // 暂时放硬盘，后面放文件服务器
        String path = "E:\\test" ;
        File dest = new File(path + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            jsonFile2.transferTo(dest); //保存文件
//            parseExcel(dest);
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
*/

    public Page<EduUser> getEduUserPage(Map<String, Integer> map) {

        Page<EduUser> page = new Page<>(map.get("pageno"),map.get("pagasize"));
        // 把当前页码和每页显示条数
        List<EduUser> listEduUser = eduUserMapper.getEduUserPage(page.getStartindex(),page.getPagesize());
        List<EduUser> eduUsers = getAllEduUser();
        // 设置总页数
        page.setTotalsize(eduUsers.size());
        // 当前查到的数据
        page.setDatas(listEduUser);
        return page;
    }

    @Override
    public void saveEduUser(List<EduUser> eduUsers) {
        for (EduUser eduUser : eduUsers) {
            eduUserMapper.insert(eduUser);
        }
    }

    public Page<EduUser> selectEduByParam(Map<String, String> map) {
        EduUserParam eduUserPar = JSON.parseObject(map.get("eduUserPar"),EduUserParam.class);
        eduUserPar.setParam(eduUserPar.getParam().trim());
        eduUserPar.setCreateTime(eduUserPar.getCreateTime().trim());
        eduUserPar.setLastSystemTime(eduUserPar.getLastSystemTime().trim());
        eduUserPar.setIsAvalible(eduUserPar.getIsAvalible());
        Page<EduUser> page = new Page<>();
        page.setPageno(Integer.parseInt(map.get("pageno")));
        page.setPagesize(5);
        List<EduUser> listEduUserAll = eduUserMapper.selectByPr(eduUserPar);
        eduUserPar.setPageno(page.getStartindex());
        eduUserPar.setPagasize(page.getPagesize());
        List<EduUser> listEduUser =  eduUserMapper.selectByPrLi(eduUserPar);
        page.setDatas(listEduUser);
        page.setTotalsize(listEduUserAll.size());
        return page;
    }

    public void pdateStatus(String userId) {
        EduUser eduUser = new EduUser();
        eduUser.setUserId(Integer.parseInt(userId));
        EduUser eduUser1 = eduUserMapper.selectOne(eduUser);
        EduUser eduUserPa = new EduUser();
        eduUserPa.setUserId(eduUser1.getUserId());
        eduUserPa.setIsAvalible(!eduUser1.getIsAvalible());
        eduUserMapper.updateByPrimaryKeySelective(eduUserPa);
    }

    @Override
    public EduUser getEduUserById(String userId) {
        return eduUserMapper.selectByPrimaryKey(Integer.parseInt(userId));
    }

    @Override
    public void updatePass(EduUser eduUser) {
        eduUser.setPassword(DigestUtils.md5DigestAsHex(eduUser.getPassword().getBytes()));
        eduUserMapper.updateByPrimaryKeySelective(eduUser);
    }

    @Override
    public List<EduUser> selectEduBy(String allIDCheck) {
        List<EduUser> list = new ArrayList<>();
        int i = allIDCheck.indexOf(',');
        if(i==-1){
            EduUser user = eduUserMapper.selectByPrimaryKey(Integer.parseInt(allIDCheck));
            list.add(user);
            return list;
        }

        String[] ids = allIDCheck.split(",");
        for (String id : ids) {
            EduUser eduUser = eduUserMapper.selectByPrimaryKey(Integer.parseInt(id));
            list.add(eduUser);
        }
        return list;
    }
}

