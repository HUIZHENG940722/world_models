package com.ethan.world.account.member.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ethan.world.account.member.domain.bo.ContentMemberUserBo;
import com.ethan.world.account.member.domain.bo.CreateMemberUserBo;
import com.ethan.world.account.member.domain.bo.UpdateMemberUserBo;
import com.ethan.world.account.member.domain.convert.MemberUserPoConvert;
import com.ethan.world.account.member.infrastructure.dao.MemberUserMapper;
import com.ethan.world.account.member.infrastructure.dao.po.MemberUserPo;
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

    public ContentMemberUserBo getById(Long memberUserId) {
        return MemberUserPoConvert.INSTANCE.toContentBo(memberUserMapper.selectById(memberUserId));
    }

    public Integer updateById(Long memberUserId, UpdateMemberUserBo updateMemberUserBo) {
        MemberUserPo memberUserPo = MemberUserPoConvert.INSTANCE.updateBoToPo(updateMemberUserBo);
        memberUserPo.setId(memberUserId);
        return memberUserMapper.updateById(memberUserPo);
    }

    private LambdaQueryWrapper<MemberUserPo> getLambdaQueryWrapper() {
        return Wrappers.lambdaQuery(MemberUserPo.class);
    }

}
