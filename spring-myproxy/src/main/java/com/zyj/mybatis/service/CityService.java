package com.zyj.mybatis.service;

import com.zyj.mybatis.dao.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CityService {
	@Autowired
	CityMapper cityMapper;

	public List<Map<String,Object>> list() {
		return cityMapper.list();
	}
}
