package com.expertus.demo.common.ms.ms;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
public class FieldErrorDto {

    private String field;
    private String key;
    private String message;
}
