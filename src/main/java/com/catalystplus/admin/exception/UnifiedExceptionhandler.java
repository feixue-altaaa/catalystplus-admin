package com.catalystplus.admin.exception;




import com.catalystplus.admin.response.Response;
import com.catalystplus.admin.response.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@RestControllerAdvice
public class UnifiedExceptionhandler {

    @ExceptionHandler(value = Exception.class)
    public Response<String> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return Response.error( null, e.getMessage());
    }

    @ExceptionHandler(value = BadSqlGrammarException.class)
    public Response<String> handleException(BadSqlGrammarException e) {
        log.error(e.getMessage(), e);
        return Response.error( null, ResponseCode.BAD_SQL_GRAMMAR_ERROR.getMsg());
    }


    @ExceptionHandler(value = BusinessException.class)
    public Response<String> handleException(BusinessException e) {
        log.error(e.getMessage(), e);
        return Response.error( null, e.getCode(), e.getMessage());
    }

    /**
     * Controller上一层相关异常
     */
    @ExceptionHandler({
            NoHandlerFoundException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            MethodArgumentNotValidException.class,
            HttpMediaTypeNotAcceptableException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            MissingServletRequestPartException.class,
            AsyncRequestTimeoutException.class
    })
    public Response<String> handleServletException(Exception e) {
        log.error(e.getMessage(), e);
        //SERVLET_ERROR(-102, "servlet请求异常"),
        return Response.error( null, ResponseCode.SERVLET_ERROR.getCode(), ResponseCode.SERVLET_ERROR.getMsg());
    }
}
