package com.ai.platform.common.api.office.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseInfo;
import com.ai.platform.common.api.office.param.OfficeAllQueryResponse;
import com.ai.platform.common.api.office.param.OfficeChildrenListQueryRequest;
import com.ai.platform.common.api.office.param.OfficeChildrenListQueryResponse;
import com.ai.platform.common.api.office.param.OfficeDetailQueryRequest;
import com.ai.platform.common.api.office.param.OfficeDetailQueryResponse;
import com.ai.platform.common.api.office.param.OfficeParentListQueryRequest;
import com.ai.platform.common.api.office.param.OfficeParentListQueryResponse;

/**
 * 组织机构对外接口
 * @author jiaxs
 *
 */
public interface ISysOfficeQuerySV {
	/**
	 * 通过id查询组织机构信息
	 * @param queryRequest id必填 tenantId必填
	 * @return 组织机构信息
	 * @throws BusinessException,SystemException
	 * @author jiaxs
	 * @ApiCode PLAT_004
	 */
	OfficeDetailQueryResponse queryOfficeDetail(OfficeDetailQueryRequest queryRequest) throws BusinessException,SystemException;
	
	/**
	 * 通过id查询所属组织机构信息(上级及本身)
	 * @param queryRequest id必填 tenantId必填
	 * @return 组织机构List信息
	 * @throws BusinessException,SystemException
	 * @author jiaxs
	 * @ApiCode PLAT_005
	 */
	OfficeParentListQueryResponse queryParentOfficeList(OfficeParentListQueryRequest queryRequest) throws BusinessException,SystemException;

	/**
	 * 通过id查询子组织机构信息(下级所有)
	 * @param queryRequest id必填 tenantId必填
	 * @return 组织机构List信息
	 * @throws BusinessException,SystemException
	 * @author jiaxs
	 * @ApiCode PLAT_006
	 */
	OfficeChildrenListQueryResponse queryChildrenOfficeList(OfficeChildrenListQueryRequest queryRequest) throws BusinessException,SystemException;

	
	/**
	 * 查询当前租户所有组织机构信息
	 * @param queryRequest 租户id必填
	 * @return 组织机构信息
	 * @throws BusinessException,SystemException
	 * @author jiaxs
	 * @ApiCode PLAT_007
	 */
	OfficeAllQueryResponse queryOfficeAll(BaseInfo queryRequest) throws BusinessException,SystemException;

}
