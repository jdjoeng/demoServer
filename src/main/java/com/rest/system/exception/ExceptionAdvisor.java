package com.rest.system.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rest.web.advice.exception.Exception400;
import com.rest.web.advice.exception.Exception401;
import com.rest.web.advice.exception.Exception403;
import com.rest.common.CommonResult;
import com.rest.common.ResponseService;

import lombok.RequiredArgsConstructor;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionAdvisor {

	private final ResponseService responseService;

	private final MessageSource messageSource;

//    public ResponseEntity exception400(Exception e){
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseService.getFailResult(getMessage("CODE400.code"), getMessage("CODE400.msg")));
//    }
//
//    public ResponseEntity exception401(Exception e){
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseService.getFailResult(getMessage("CODE401.code"), getMessage("CODE401.msg")));
//    }
//
//    public ResponseEntity exception403(Exception e){
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(responseService.getFailResult(getMessage("CODE403.code"), getMessage("CODE403.msg")));
//    }
//
//	@ExceptionHandler(Exception.class)
//    public ResponseEntity exception500(Exception e){
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseService.getFailResult(getMessage("CODE500.code"), getMessage("CODE500.msg")));
//    }

	@ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult defaultException(HttpServletRequest request, Exception e) {
        return responseService.getFailResult(getMessage("CODE500.code"), getMessage("CODE500.msg"));
    }

	@ExceptionHandler(Exception400.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected CommonResult exception400(HttpServletRequest request, Exception400 e) {
        return responseService.getFailResult(getMessage("CODE400.code"), getMessage("CODE400.msg"));
    }

	@ExceptionHandler(Exception401.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected CommonResult exception401(HttpServletRequest request, Exception401 e) {
        return responseService.getFailResult(getMessage("CODE401.code"), getMessage("CODE401.msg"));
    }

	@ExceptionHandler(Exception403.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    protected CommonResult exception403(HttpServletRequest request, Exception403 e) {
        return responseService.getFailResult(getMessage("CODE403.code"), getMessage("CODE403.msg"));
    }

	// code정보에 해당하는 메시지를 조회합니다.
    private String getMessage(String code) {
        return getMessage(code, null);
    }
    // code정보, 추가 argument로 현재 locale에 맞는 메시지를 조회합니다.
    private String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }

}
