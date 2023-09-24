package com.example.basic.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.basic.model.MemberEntity;

@Mapper
public interface MemberMapper {

  List<MemberEntity> selectEntityAll(@Param("memberName") String memberName, @Param("memberAddr") String memberAddr);
  MemberEntity selectEntityById(@Param("memberId") String memberId);
  int insertEntity(MemberEntity memberEntity);
  int updateEntity(MemberEntity memberEntity);
  int deleteEntity(@Param("memberId") String memberId);
}
