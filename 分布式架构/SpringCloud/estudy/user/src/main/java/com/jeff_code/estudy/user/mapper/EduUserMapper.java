package com.jeff_code.estudy.user.mapper;

import com.jeff_code.estudy.bean.EduUser;
import com.jeff_code.estudy.util.EduUserParam;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author: jefflike
 * @create: 2018/10/14
 * @describe:
 */
public interface EduUserMapper extends Mapper<EduUser> {
    List<EduUser> selectByPr(EduUserParam eduUserPar);

    List<EduUser> getEduUserPage(int startindex, int pagesize);

    List<EduUser> selectByPrLi(EduUserParam eduUserPar);
}
