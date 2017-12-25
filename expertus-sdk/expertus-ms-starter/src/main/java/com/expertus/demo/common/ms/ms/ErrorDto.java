package com.expertus.demo.common.ms.ms;

import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class ErrorDto {

    private final String url;
    private final Integer code;
    private final String message;
    private final List<FieldErrorDto> errors = Lists.newArrayList();

    public static ErrorDto of(String url, HttpStatus code){
        return new ErrorDto(url,code.value(),code.getReasonPhrase());
    }

    public void addError(String key){
        errors.add(new FieldErrorDto(null,key,null));
    }

    public void addError(String field,String key){
        errors.add(new FieldErrorDto(field,key,null));
    }


}
