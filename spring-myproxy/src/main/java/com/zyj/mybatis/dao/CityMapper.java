package com.zyj.mybatis.dao;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 由于将session交给spring去管理，每次去查询是spring都会将session关闭，所以mybatis的一级缓存会失效
 * 这里使用@CacheNamespace来开启mybatis的二级缓存
 * mybatis的二级缓存是基于命名空间隔离的，所以只有在同一个命名空间中才不会获取旧的数据
 * 一般不适用mybatis的二级缓存，而是使用第三方缓存技术
 */

@CacheNamespace
public interface CityMapper {
	@Select("select * from city")
	public List<Map<String, Object>> list();
}
