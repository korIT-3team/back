package com.team.back.common.response;

public interface ResponseMessage {
     String Success = "Sucess";
     String DATABASE_ERROR = "Database Error";
     String SIGN_IN_FAIL = "Sign In Fail";
     String NO_EXISTED_USER = "No Existed User";
     String NO_EXISTED_COMPANY_INFO = "No Existed Company Info";
     String VALIDATE_FAIL = "Validation Fail";
     String NO_PERMISSION = "No Permission";

     String NO_EXISTED_DEPARTMENT_INFO = "No Existed Department Info";
     String NO_EXISTED_INVOICE = "No Existed Invoice";
     String EXISTED_DEPARTMENT_NAME = "Existed Department Name";
     String NO_EXISTED_DEPARTMENT_CODE = "No Existed Department Code";

     String NO_EXISTED_CUSTOMER_INFO = "No Existed Customer Info";
     String EXISTED_CUSTOMER_NAME = "Existed Customer Name";
     String NO_EXISTED_CUSTOMER_CODE = "No Existed Customer Code"; 

     String NO_EXISTED_PRODUCT_INFO = "No Existed Product Info";
     String EXISTED_PRODUCT_NAME = "Existed Product Name";
     String NO_EXISTED_PRODUCT_CODE = "No Existed Product Code"; 
}
