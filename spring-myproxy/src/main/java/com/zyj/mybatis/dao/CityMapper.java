package com.zyj.mybatis.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface CityMapper {
	@Select("select * from city")
	public List<Map<String, Object>> list();
}
