package com.util.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: ServerExceptionResolver
 * @Author: lin.shi
 * @CreateTime: 2017-04-28 14:44
 */
public class ServerExceptionResolver extends AbstractHandlerExceptionResolver {
    private ObjectMapper objectMapper;
    private String contentType;


    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        if (logger.isDebugEnabled()) {
            logger.debug("ServerExceptionResolver [ex:" + ex.getMessage() + "]");
        }

        PrintWriter pw = null;

        try {
            response.setContentType(contentType);
            response.setStatus(508);
            pw = response.getWriter();
            pw.write(objectMapper.writeValueAsString(handleException(ex)));
        } catch (IOException e) {
            logger.error(e);
        } finally {
            if (pw != null)
                pw.close();
        }

        return null;


    }

    private Object handleException(Exception ex) {
        Map<String, Object> map = new HashMap<>();
        if (ex instanceof BaseBusinessException) {
            BaseBusinessException baseBusinessException = (BaseBusinessException) ex;
            map.put("code", baseBusinessException.getCode());
            map.put("message", baseBusinessException.getMessage());
        }else {
            map.put("code", BaseBusinessException.defaultExceptionCode);
            map.put("message", BaseBusinessException.defaultExceptionMessage);
        }
        return map;
    }

    //===========================================getter  and setter=========================

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

}
