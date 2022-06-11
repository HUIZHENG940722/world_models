package com.ethan.world.account.member.interfaces.assembler;

import com.ethan.world.account.member.domain.bo.CreateMemberUserBo;
import com.ethan.world.account.member.interfaces.api.dto.CreateMemberUserReq;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author zhenghui
 * @Description 会员用户DTO转换器
 * @Date 2022/6/12
 */
@Mapper
public interface MemberUserDtoConvert {
    MemberUserDtoConvert INSTANCE = Mappers.getMapper(MemberUserDtoConvert.class);

    CreateMemberUserBo toBo(CreateMemberUserReq createMemberUserReq);
}
