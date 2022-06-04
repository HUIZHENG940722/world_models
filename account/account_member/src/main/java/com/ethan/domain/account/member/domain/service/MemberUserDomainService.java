package com.ethan.domain.account.member.domain.service;

import com.ethan.domain.account.member.domain.bo.ContentMemberUserBo;
import com.ethan.domain.account.member.domain.bo.CreateMemberUserBo;
import com.ethan.domain.account.member.domain.repository.MemberUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhenghui
 * @Description 会员用户领域服务
 * @Date 2022/6/4
 */
@Service
public class MemberUserDomainService {

    @Autowired
    private MemberUserRepository memberUserRepository;

    /**
     * 领域服务：创建会员用户
     * @param createMemberUserBo
     * @return
     */
    public Long createMemberUser(CreateMemberUserBo createMemberUserBo) {
        // 1 核心校验
        // 1.1 校验用户名是否重复
        ContentMemberUserBo byName = memberUserRepository.getByName(createMemberUserBo.getUsername());
        if (byName!=null) {
            throw new RuntimeException("用户名已存在");
        }
        // 1.2 校验手机号是否存在
        ContentMemberUserBo byMobile = memberUserRepository.getByMobile(createMemberUserBo.getMobile());
        if (byMobile!=null) {
            throw new RuntimeException("手机号已注册");
        }
        // 2 核心业务
        return memberUserRepository.add(createMemberUserBo);
        // 3 返回结果
    }
}
