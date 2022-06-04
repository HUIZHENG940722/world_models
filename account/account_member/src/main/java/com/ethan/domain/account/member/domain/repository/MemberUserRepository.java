package com.ethan.domain.account.member.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ethan.domain.account.member.domain.bo.ContentMemberUserBo;
import com.ethan.domain.account.member.domain.bo.CreateMemberUserBo;
import com.ethan.domain.account.member.domain.convert.MemberUserPoConvert;
import com.ethan.domain.account.member.infrastructure.dao.MemberUserMapper;
import com.ethan.domain.account.member.infrastructure.dao.po.MemberUserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author zhenghui
 * @Description 会员用户数据仓库
 * @Date 2022/6/4
 */
@Repository
public class MemberUserRepository {

    @Autowired
    private MemberUserMapper memberUserMapper;

    public ContentMemberUserBo getByName(String username) {
        LambdaQueryWrapper<MemberUserPo> lambdaQueryWrapper = getLambdaQueryWrapper();
        lambdaQueryWrapper.eq(MemberUserPo::getUsername, username);
        return MemberUserPoConvert.INSTANCE.toContentBo(memberUserMapper.selectOne(lambdaQueryWrapper));
    }

    public ContentMemberUserBo getByMobile(String mobile) {
        LambdaQueryWrapper<MemberUserPo> lambdaQueryWrapper = getLambdaQueryWrapper();
        lambdaQueryWrapper.eq(MemberUserPo::getMobile, mobile);
        return MemberUserPoConvert.INSTANCE.toContentBo(memberUserMapper.selectOne(lambdaQueryWrapper));
    }

    public Long add(CreateMemberUserBo createMemberUserBo) {
        MemberUserPo memberUserPo = MemberUserPoConvert.INSTANCE.createBotoPo(createMemberUserBo);
        return Long.valueOf(memberUserMapper.insert(memberUserPo));
    }

    private LambdaQueryWrapper<MemberUserPo> getLambdaQueryWrapper() {
        return Wrappers.lambdaQuery(MemberUserPo.class);
    }
}
