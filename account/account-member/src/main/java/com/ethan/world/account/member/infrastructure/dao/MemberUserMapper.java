package com.ethan.world.account.member.infrastructure.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethan.world.account.member.infrastructure.dao.po.MemberUserPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhenghui
 * @Description 用户数据访问接口
 * @Date 2022/6/3
 */
@Mapper
public interface MemberUserMapper extends BaseMapper<MemberUserPo> {
}
