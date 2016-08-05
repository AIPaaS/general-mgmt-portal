package com.ai.platform.common.constants;

public class VOConstants {
	private VOConstants(){}
	
	/**
	 * 是否删除
	 * @author jiaxs
	 *
	 */
	public class DeleteFlagConstant{
		private DeleteFlagConstant(){}
		/**
		 * 删除
		 */
		public static final String YES = "1";
		/**
		 * 未删除
		 */
		public static final String NO = "0";
	}
	
	/**
	 * 是否启用
	 * @author jiaxs
	 *
	 */
	public class UseableFlagConstant{
		private UseableFlagConstant(){}
		/**
		 * 启用
		 */
		public static final String YES = "1";
		/**
		 * 未启用
		 */
		public static final String NO = "0";
	}
	
	/**
	 * 代办事物状态
	 * @author jiaxs
	 *
	 */
	public class WaitjobsStatusConstant{
		private WaitjobsStatusConstant(){}
		
		/**
		 * 代办
		 */
		public static final String WAIT = "0";
		
		/**
		 * 办结
		 */
		public static final String END = "1";
	}

}
