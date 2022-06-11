package com.ethan.world.account.member.application.service;

import com.ethan.world.account.member.domain.bo.CreateMemberUserBo;
import com.ethan.world.account.member.domain.service.MemberUserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhenghui
 * @Description 会员用户应用服务
 * @Date 2022/6/12
 */
@Service
public class MemberUserService {

    @Autowired
    private MemberUserDomainService memberUserDomainService;

    public Integer createMemberUser(CreateMemberUserBo memberUserBo) {
        // 1 校验
        // 2 业务
        return memberUserDomainService.createMemberUser(memberUserBo);
        // 3 返回结果
    }
}
