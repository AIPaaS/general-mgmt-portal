package com.ai.slp.common.api.subjectmaintain.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.common.api.subjectmaintain.param.GnSubjectCondition;
import com.ai.slp.common.api.subjectmaintain.param.GnSubjectFundVo;
import com.ai.slp.common.api.subjectmaintain.param.GnSubjectKeyParam;
import com.ai.slp.common.api.subjectmaintain.param.GnSubjectVo;

@Path("/subjectmaintain")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IGnSubjectMaintainSV {

    /**
     * 科目ID，类型，名称－多条件分页查询
     * 
     * @param condition
     * @return
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL subjectmaintain/querySubejctCond
	 */
	@POST
	@Path("/querySubejctCond")
    PageInfo<GnSubjectVo> querySubejct(GnSubjectCondition condition) throws BusinessException,SystemException;

    /**
     * 行业、租户、科目ID－主键查询
     * 
     * @return
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL subjectmaintain/querySubejctKey
	 */
	@POST
	@Path("/querySubejctKey")
    GnSubjectVo querySubject(GnSubjectKeyParam key) throws BusinessException,SystemException;

    /**
     * 增加科目
     * 
     * @param vo
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL subjectmaintain/addSubject
	 */
	@POST
	@Path("/addSubject")
    void addSubject(GnSubjectVo vo) throws BusinessException,SystemException;

    /**
     * 删除科目
     * 
     * @param vo
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL subjectmaintain/deleteSubject
	 */
	@POST
	@Path("/deleteSubject")
    void deleteSubject(GnSubjectKeyParam key) throws BusinessException,SystemException;

    /**
     * 修改科目
     * 
     * @param vo
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL subjectmaintain/modifySubject
	 */
	@POST
	@Path("/modifySubject")
    void modifySubject(GnSubjectVo vo) throws BusinessException,SystemException;

    /**
     * 
     * @param key
     * @return
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL subjectmaintain/querySubjectFund
	 */
	@POST
	@Path("/querySubjectFund")
    GnSubjectFundVo querySubjectFund(GnSubjectKeyParam key) throws BusinessException,SystemException;

    /**
     * 增加科目资金属性
     * 
     * @param vo
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL subjectmaintain/addSubjectFund
	 */
	@POST
	@Path("/addSubjectFund")
    void addSubjectFund(GnSubjectFundVo vo) throws BusinessException,SystemException;

    /**
     * 删除科目资金属性
     * 
     * @param vo
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL subjectmaintain/deleteSubjectFund
	 */
	@POST
	@Path("/deleteSubjectFund")
    void deleteSubjectFund(GnSubjectKeyParam key) throws BusinessException,SystemException;

    /**
     * 修改科目资金属性
     * 
     * @param vo
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL subjectmaintain/modifySubjectFund
	 */
	@POST
	@Path("/modifySubjectFund")
    void modifySubjectFund(GnSubjectFundVo vo) throws BusinessException,SystemException;
}
