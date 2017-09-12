package com.util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @Description: JacksonObjectMapperHttpMessageConvert
 * @Author: lin.shi
 * @CreateTime: 2017-04-20 09:11
 */
public class JacksonObjectMapperHttpMessageConvert extends AbstractHttpMessageConverter<Object> {

    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private ObjectMapper objectMapper;

    public JacksonObjectMapperHttpMessageConvert() {
        super(new MediaType("application", "json", DEFAULT_CHARSET));
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        JavaType javaType = this.objectMapper.getTypeFactory().uncheckedSimpleType(clazz);
        return (this.objectMapper.canDeserialize(javaType) && canRead(mediaType));
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return true;
    }

    @Override
    protected boolean supports(Class clazz) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {

        try {
            return this.objectMapper.readValue(inputMessage.getBody(), clazz);
        } catch (JsonProcessingException ex) {
            throw new HttpMessageNotReadableException("Could not read JSON: " + ex.getMessage(), ex);
        }
    }

    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

        try {
            if (logger.isDebugEnabled()) {
                logger.info("object" + object);
            }
            this.objectMapper.writeValue(outputMessage.getBody(), handleResponse(object));
        } catch (JsonProcessingException ex) {
            logger.error("Could not write JSON: " + ex.getMessage());
            throw new HttpMessageNotWritableException("Could not write JSON: " + ex.getMessage(), ex);
        }
    }


    private Response handleResponse(Object o) {
        Response response = new Response();
        response.setData(o);
        return response;
    }
}
