package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.CoronaDto;
import com.ssafy.model.Hospital;
import com.ssafy.model.HouseDealDto;
import com.ssafy.model.dao.HousedealDAOImpl;

public class HousedealServiceImpl implements HousedealService {
	
	private static HousedealService housedealservice;
	private HousedealServiceImpl() {}
	public static HousedealService getHousedealService()
	{
		if(housedealservice == null)
			housedealservice = new HousedealServiceImpl();
		return housedealservice;
	}
		
	

	@Override
	public List<String> gungu(String city) {
		return HouseDealDAOImpl.getHousedealDAO().gungu(city);
	}

	@Override
	public List<String> dong(String gu) {
		return HouseDealDAOImpl.getHousedealDAO().dong(gu);
	}
	@Override
	public List<HouseDealDto> treadInfo(String dong) {
		return HouseDealDAOImpl.getHousedealDAO().treadInfo(dong);
	}
	@Override
	public List<HouseDealDto> getReal(String name) {
		
		return HouseDealDAOImpl.getHousedealDAO().getReal(name);
	}
	@Override
	public List<CoronaDto> getCorona(String gu) {
		return HouseDealDAOImpl.getHousedealDAO().getCorona(gu);
	}
	@Override
	public List<Hospital> getHospital(String gu) {
		return HouseDealDAOImpl.getHousedealDAO().getHospital(gu);
	}

}
