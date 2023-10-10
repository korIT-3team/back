package com.team.back.common.response;

public interface ResponseCode {
     String Success = "SU";
     String DATABASE_ERROR = "DE";
     String SIGN_IN_FAIL = "SF";
     String NO_EXISTED_USER = "NU";
     String NO_EXISTED_COMPANY_INFO = "NC";
     String VALIDATE_FAIL = "VF";
     String NO_PERMISSION = "NP";

     String NO_EXISTED_DEPARTMENT_INFO = "ND";
     String NO_EXISTED_INVOICE = "NI";
     String EXISTED_DEPARTMENT_NAME = "ED";
     String NO_EXISTED_DEPARTMENT_CODE = "NDC";

     String NO_EXISTED_CUSTOMER_INFO = "NEC";
     String EXISTED_CUSTOMER_NAME = "EC";
     String NO_EXISTED_CUSTOMER_CODE = "NCC";
     String EXISTED_CUSTOMER_BUSINESS_NUMBER = "ECB";

     String NO_EXISTED_PRODUCT_INFO = "NEP";
     String EXISTED_PRODUCT_NAME = "EP";
     String NO_EXISTED_PRODUCT_CODE = "NPC";
}
