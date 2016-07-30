package com.ai.slp.common.constants;

/**
 * Created by astraea on 2015/7/27.
 */
public final class Constants {

    private Constants() {
        // non
    }

    public final static class TenantId {
        private TenantId() {
        }

        public final static String ALL_TENANT = "ALL";
    }

    public final static class StaffState {
        private StaffState() {
        }

        public final static String ONLINE = "1";

        public final static String OFFLINE = "0";
    }

    public final static class DepartState {
        private DepartState() {
        }

        public final static String ACTIVITY = "1";

        public final static String INACTIVITY = "0";
    }

    public final static class AreaState {
        private AreaState() {
        }

        public final static String ACTIVITY = "1";

        public final static String INACTIVITY = "0";
    }

    public final static class DepartLevel {
        private DepartLevel() {
        }

        // 全国对应的部门级别
        public final static String NATION = "0";

        // 省级对应的部门级别
        public final static String PROVINCE = "1";

        // 市级对应的部门级别
        public final static String CITY = "2";

        // 区域对应的部门级别
        public final static String AREA = "3";

        // 全国默认地区代码
        public final static String NATION_CODE = "00";

        // 默认省级地区代码
        public final static String PROVINCE_CODE = "000";
    }

    public final static class GnSubject {
        private GnSubject() {
        }

        public final static class SubjectType {
            private SubjectType() {
            }

            // 科目类型，资金科目
            public final static String FUND = "9";
        }

        // 所有行业0
        public final static String ALL_INDUSTRY = "0";
    }

    public final static class ErrorCode {
        private ErrorCode() {
        }

        public static final String RESULT_NULL_ERROR = "10001";

        public static final String RESULT_ERROR = "10002";
    }

    public final static class SEQ {
        private SEQ() {
        }

        public static final String DEPART_ID_SEQ = "GN_DEPART$DEPART_ID$SEQ";

        public static final String STAFF_ID_SEQ = "GN_STAFF$STAFF_ID$SEQ";

        public static final String AREA_CODE_SEQ = "GN_AREA$AREA_CODE$SEQ";
    }
}
