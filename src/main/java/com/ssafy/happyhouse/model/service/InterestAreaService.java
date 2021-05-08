package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.dto.InterestAreaDto;

public interface InterestAreaService {
	
	public int insert(InterestAreaDto interestArea);
	public int delete(Map<String, String> map);	//String code, String userId
	public List<InterestAreaDto> list (String userId);
	
}
