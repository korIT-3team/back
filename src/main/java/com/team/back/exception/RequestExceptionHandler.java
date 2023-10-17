package com.team.back.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.response.ResponseDto;

@RestControllerAdvice
public class RequestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        String bindingCode = bindingResult.getFieldError().getCode();
        
        if (bindingCode.equals("NotBlank")) {
            ResponseDto result = new ResponseDto(ResponseCode.NO_REQUIRED_CONTENT, ResponseMessage.NO_REQUIRED_CONTENT);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
        if (bindingCode.equals("NotNull")) {
            ResponseDto result = new ResponseDto(ResponseCode.NO_REQUIRED_CONTENT, ResponseMessage.NO_REQUIRED_CONTENT);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
        ResponseDto result = new ResponseDto(ResponseCode.VALIDATE_FAIL, ResponseMessage.VALIDATE_FAIL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
