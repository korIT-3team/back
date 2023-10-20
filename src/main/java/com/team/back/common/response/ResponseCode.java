package com.team.back.common.response;

public interface ResponseCode {
     String Success = "SU";
     String DATABASE_ERROR = "DE";
     String SIGN_IN_FAIL = "SF";
     String NO_EXISTED_USER = "NU";
     String NO_EXISTED_COMPANY_INFO = "NC";
     String VALIDATE_FAIL = "VF";
     String NO_PERMISSION = "NP";

     String NO_EXISTED_INVOICE = "NI";

     String NO_EXISTED_DEPARTMENT_INFO = "ND";
     String EXISTED_DEPARTMENT_NAME = "ED";
     String EXISTED_DEPARTMENT_TELNUMBER = "EDT";
     String EXISTED_DEPARTMENT_FAX = "EDF";

     String NO_EXISTED_SYSTEM_EMPLOYEE_INFO = "NSE";
     String EXISTED_SYSTEM_EMPLOYEE_NAME = "ESE";
     String EXISTED_SYSTEM_EMPLOYEE_GENDER = "ESEG";
     String EXISTED_SYSTEM_EMPLOYEE_DEPARTMENT = "ESED";
     String EXISTED_SYSTEM_EMPLOYEE_JOIN_DATE = "ESEJ";
     String EXISTED_SYSTEM_EMPLOYEE_PASSWORD = "ESEP";
     String EXISTED_SYSTEM_EMPLOYEE_REGISTRATION_NUMBER = "ESER";

     String NO_EXISTED_USER_DEFINE_INFO = "NUD";

     String NO_EXISTED_CUSTOMER_INFO = "NEC";
     String EXISTED_CUSTOMER_NAME = "ECN";
     String EXISTED_CUSTOMER_CODE = "ECC";
     String NO_EXISTED_CUSTOMER_CODE = "NCC";
     String EXISTED_CUSTOMER_BUSINESS_NUMBER = "ECB";

     String NO_EXISTED_PRODUCT_INFO = "NEP";
     String EXISTED_PRODUCT_NAME = "EPN";
     String NO_EXISTED_PRODUCT_NAME = "NPN";
     String EXISTED_PRODUCT_CODE = "EPC";
     String NO_EXISTED_PRODUCT_CODE = "NPC";

     String NO_EXISTED_SALES_PLAN_CODE = "NSPC";
     String EXISTED_SALES_PLAN_CODE = "ESPC";
     String NO_EXISTED_SALES_PLAN = "NSP";

     String NO_EXISTED_ORDER_INFO = "NEOI";
     String NO_EXISTED_ORDER_CODE = "NEOC";
     String EXISTED_ORDER_CODE = "EOC";

     String NO_REQUIRED_CONTENT = "NRC";
}
