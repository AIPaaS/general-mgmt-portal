package com.ai.slp.common.api.subject.interfaces;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.common.api.subject.param.Subject;
import com.ai.slp.common.api.subject.param.SubjectFund;
import com.ai.slp.common.api.subject.param.SubjectIdParam;
import com.ai.slp.common.api.subject.param.SubjectTypeParam;
/**
 * 
 *科目查询服务
 * Date: 2016年6月29日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gucl
 */
@Path("/subjectquery")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IGnSubjectQuerySV {

    /**
     * 
     * 查询科目名称，翻译科目ID[全部科目] <br>
     * 
     * @param subjectId
     * @return 科目名称
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0038
     * @RestRelativeURL subjectquery/getSubjectName
	 */
	@POST
	@Path("/getSubjectName")
    public String getSubjectName(SubjectIdParam subjectId) throws BusinessException,SystemException;

    /**
     * 查询科目定义[全部科目] <br>
     * 
     * @return 科目结果对象
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0040
     * @RestRelativeURL subjectquery/getSubject
	 */
	@POST
	@Path("/getSubject")
    public Subject getSubject(SubjectIdParam subjectId) throws BusinessException,SystemException;

    /**
     * 根据科目类型查询科目[全部科目]
     * 
     * @param subjectType
     * @return 科目结果列表
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0041
     * @RestRelativeURL subjectquery/getSubjectByType
	 */
	@POST
	@Path("/getSubjectByType")
    public List<Subject> getSubjectByType(SubjectTypeParam subjectType) throws BusinessException,SystemException;

    /**
     * 
     * 根据科目ID查询[资金科目] <br>
     * 
     * @param subjectId
     * @return 资金科目结果对象
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0039
     * @RestRelativeURL subjectquery/getSubjectFund
	 */
	@POST
	@Path("/getSubjectFund")
    public SubjectFund getSubjectFund(SubjectIdParam subjectId) throws BusinessException,SystemException;

}
