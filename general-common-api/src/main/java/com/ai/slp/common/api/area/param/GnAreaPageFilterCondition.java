package com.ai.slp.common.api.area.param;

import java.util.List;

public class GnAreaPageFilterCondition extends GnAreaPageCondition {
	private static final long serialVersionUID = 1L;
	private List<String> filterAreaCodeList;

	public List<String> getFilterAreaCodeList() {
		return filterAreaCodeList;
	}

	public void setFilterAreaCodeList(List<String> filterAreaCodeList) {
		this.filterAreaCodeList = filterAreaCodeList;
	}
}
