package com.ai.platform.common.test.ccs;

import org.junit.Before;
import org.junit.Test;

import com.ai.opt.sdk.components.ccs.CCSClientFactory;
import com.ai.opt.sdk.constants.SDKConstants;
import com.ai.paas.ipaas.ccs.IConfigClient;
import com.ai.paas.ipaas.ccs.constants.ConfigException;

public class IConfigCenterClientTest {

    private IConfigClient client;

    @Before
    public void initData() {
        this.client = CCSClientFactory.getDefaultConfigClient();
    }
    
    @Test
    //@Ignore
    public void addMcsConfig() throws ConfigException {
        // 缓存服务主机
        String baasopwebRedisHost = "MCS008";
        // 缓存空间
        String cachesnsConfig = "{\"com.ai.slp.common.cache.gnsysparam\":\"" + baasopwebRedisHost
                + "\",\"com.ai.slp.common.cache.gnarea\":\"" + baasopwebRedisHost
                + "\",\"com.ai.slp.common.cache.gnservicenum\":\"" + baasopwebRedisHost
                + "\",\"com.ai.slp.common.cache.gnsubject\":\"" + baasopwebRedisHost
                + "\",\"com.ai.slp.common.cache.gnsubjectfund\":\"" + baasopwebRedisHost
                + "\",\"com.ai.slp.common.cache.gnsettlerule\":\"" + baasopwebRedisHost
                + "\"}";
        

        // 缓存空间配置
        if (!client.exists(SDKConstants.PAAS_CACHENS_MCS_MAPPED_PATH))
            client.add(SDKConstants.PAAS_CACHENS_MCS_MAPPED_PATH, cachesnsConfig);
        else {
            client.modify(SDKConstants.PAAS_CACHENS_MCS_MAPPED_PATH, cachesnsConfig);
        }
    }
    
    //@Ignore
    @Test
    public void readMcsConfig() throws ConfigException {
    	
    	String cachesns=client.get(SDKConstants.PAAS_CACHENS_MCS_MAPPED_PATH);

    	System.out.println("cachesns:"+cachesns);

    }
    
    @Test
    public void addServiceIdPwdMap() throws ConfigException {
        String cachesnsConfig = "{\"MCS008\":\"" + "123456"
                + "\"}";

        // paas serviceid password 映射配置
        if (!client.exists(SDKConstants.PAAS_SERVICE_PWD_MAPPED_PATH))
            client.add(SDKConstants.PAAS_SERVICE_PWD_MAPPED_PATH,
                    cachesnsConfig);
        else {
            client.modify(SDKConstants.PAAS_SERVICE_PWD_MAPPED_PATH,
                    cachesnsConfig);
        }
    }
    
    @Test
    public void addDbConfInfo() throws ConfigException {
        System.out.println("DBConf config ... start");
        StringBuilder sb = new StringBuilder();

        sb.append("{																																																				");
        sb.append("		\"slp-common-db\":                                                                                   ");
        sb.append("		{                                                                                                     ");
        sb.append("			\"driverClassName\":\"com.mysql.jdbc.Driver\",                                                          ");
        sb.append("			\"jdbcUrl\":\"jdbc:mysql://10.1.245.7:31306/devcommondb1?useUnicode=true&characterEncoding=UTF-8\",   ");
        sb.append("			\"username\":\"devcommonusr1\",                                                                         ");
        sb.append("			\"password\":\"devslpcomusr1@8899\",                                                                         ");

//        sb.append("			\"jdbcUrl\":\"jdbc:mysql://127.0.0.1:3306/system?useUnicode=true&characterEncoding=UTF-8\",   ");
//        sb.append("			\"username\":\"root\",                                                                         ");
//        sb.append("			\"password\":\"123456\",                                                                         ");

        
        sb.append("			\"autoCommit\":\"true\",                                                                                ");
        sb.append("			\"connectionTimeout\":\"30000\",                                                                        ");
        sb.append("			\"idleTimeout\":\"600000\",                                                                             ");
        sb.append("			\"maxLifetime\":\"1800000\",                                                                            ");
        sb.append("			\"maximumPoolSize\":\"10\"                                                                              ");
        sb.append("		}                                                                                                     ");
        sb.append("}                                                                                                        ");

        if (!client.exists(SDKConstants.DB_CONF_PATH)) {
            client.add(SDKConstants.DB_CONF_PATH, sb.toString());
        } else {
            client.modify(SDKConstants.DB_CONF_PATH, sb.toString());
        }

        System.out.println("DBConf config ... end");
    }

}