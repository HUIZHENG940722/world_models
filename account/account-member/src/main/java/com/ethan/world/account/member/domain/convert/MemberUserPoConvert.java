package com.ethan.world.account.member.domain.convert;

import com.ethan.world.account.member.domain.bo.ContentMemberUserBo;
import com.ethan.world.account.member.domain.bo.CreateMemberUserBo;
import com.ethan.world.account.member.domain.bo.UpdateMemberUserBo;
import com.ethan.world.account.member.infrastructure.dao.po.MemberUserPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author zhenghui
 * @Description 会员用户PO转换器
 * @Date 2022/6/4
 */
@Mapper
public interface MemberUserPoConvert {
    MemberUserPoConvert INSTANCE = Mappers.getMapper(MemberUserPoConvert.class);

    ContentMemberUserBo toContentBo(MemberUserPo selectOne);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "status", expression = "java(1)"),
        @Mapping(target = "loginIp", ignore = true),
        @Mapping(target = "loginDate", ignore = true),
        @Mapping(target = "deleted", expression = "java(1)"),
        @Mapping(target = "createTime", expression = "java(new java.util.Date(System.currentTimeMillis()))"),
        @Mapping(target = "updateTime", ignore = true)
    })
    MemberUserPo createBotoPo(CreateMemberUserBo createMemberUserBo);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "registerIp", ignore = true),
        @Mapping(target = "loginDate", expression = "java(new java.util.Date(System.currentTimeMillis()))"),
        @Mapping(target = "createTime", ignore = true),
        @Mapping(target = "updateTime", expression = "java(new java.util.Date(System.currentTimeMillis()))")
    })
    MemberUserPo updateBoToPo(UpdateMemberUserBo updateMemberUserBo);
}
