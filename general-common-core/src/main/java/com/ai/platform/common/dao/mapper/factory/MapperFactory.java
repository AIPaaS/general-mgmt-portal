package com.ai.platform.common.dao.mapper.factory;


import javax.annotation.PostConstruct;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.platform.common.dao.mapper.interfaces.SysOfficeMapper;
import com.ai.platform.common.dao.mapper.interfaces.SysUserMapper;
import com.ai.platform.common.dao.mapper.interfaces.SysWaitjobsMapper;

@Component
public class MapperFactory {

    private static SqlSessionTemplate sqlSessionTemplate;
    
    @Autowired
    private SqlSessionTemplate st;

    @PostConstruct
    void init() {
        setSqlSessionTemplate(st);
    }
    
    public static SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    public static void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        MapperFactory.sqlSessionTemplate = sqlSessionTemplate;
    }

    public static SysOfficeMapper getSysOfficeMapper(){
    	return sqlSessionTemplate.getMapper(SysOfficeMapper.class);
    }
    
    public static SysUserMapper getSysUserMapper(){
    	return sqlSessionTemplate.getMapper(SysUserMapper.class);
    }
    
    public static SysWaitjobsMapper getSysWaitjobsMapper(){
    	return sqlSessionTemplate.getMapper(SysWaitjobsMapper.class);
    }
}
