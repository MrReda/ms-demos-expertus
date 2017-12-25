package com.expertus.demo.common.ms.ms;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@ControllerAdvice
public class GlobalDefaultExceptionHandler {



    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    public ErrorDto handleHttpClientErroException(HttpServletRequest req, HttpClientErrorException err){
        log.error("Exception while handling a http request url : {} . Exception cause : ",req.getRequestURL(),err);
        return ErrorDto.of(req.getRequestURL().toString(),BAD_REQUEST);
    }

    @ExceptionHandler(HttpServerErrorException.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorDto handleHttpServerErrorException(HttpServletRequest req,HttpClientErrorException err){
        log.error("Exception while handling a http request url : {} . Exception cause : ",req.getRequestURL(),err);
        return ErrorDto.of(req.getRequestURL().toString(),INTERNAL_SERVER_ERROR);
    }





}
