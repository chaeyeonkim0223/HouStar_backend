package com.ssafy.happyhouse.model.service;

import java.util.Map;

import com.ssafy.happyhouse.model.dto.MemberDto;



public interface MemberService {
	
	public boolean login(Map<String, String> map);
//	
//	public void insertMember(Member member);
//	public void update(Member member);
//	public void deleteMember(String id);
	public MemberDto lookupmember(String id);
//	public String findPassword(String id, String name, String phoneNumber);
	
}