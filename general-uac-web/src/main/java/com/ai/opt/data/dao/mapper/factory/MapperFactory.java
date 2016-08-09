package com.ai.opt.data.dao.mapper.factory;

import javax.annotation.PostConstruct;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.data.dao.mapper.interfaces.SysUserMapper;

@Component
public class MapperFactory {
	
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    private static SqlSessionTemplate st;

    @PostConstruct
    void init() {
        setSqlSessionTemplate(sqlSessionTemplate);
    }

    public static void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        MapperFactory.st = sqlSessionTemplate;
    }

    public static SysUserMapper getSysUserMapper() {
        return st.getMapper(SysUserMapper.class);
    }
    
}
