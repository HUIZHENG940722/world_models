package com.ethan.world.account.member.interfaces.controller;

import com.ethan.world.account.member.application.service.MemberUserService;
import com.ethan.world.account.member.domain.bo.CreateMemberUserBo;
import com.ethan.world.account.member.interfaces.api.AccountMemberApi;
import com.ethan.world.account.member.interfaces.api.dto.CreateMemberUserReq;
import com.ethan.world.account.member.interfaces.assembler.MemberUserDtoConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhenghui
 * @Description 会员用户用户接口层实现
 * @Date 2022/6/12
 */
@RestController
public class MemberUserController implements AccountMemberApi {

    @Autowired
    private MemberUserService memberUserService;

    @Override
    public ResponseEntity<Integer> createMemberUser(CreateMemberUserReq createMemberUserReq) {
        // 1 数据转换
        CreateMemberUserBo memberUserBo = MemberUserDtoConvert.INSTANCE.toBo(createMemberUserReq);
        // 2 业务
        Integer memberId = memberUserService.createMemberUser(memberUserBo);
        // 3 返回结果
        return new ResponseEntity<>(memberId, HttpStatus.OK);
    }
}
