package com.util.converters;


import org.apache.commons.lang.StringUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * @Description: StringToLongConversion
 * @Author: lin.shi
 * @CreateTime: 2017-04-20 16:12
 */
public class StringToLongConversion implements Converter<String,Long> {

    @Override
    public Long convert(String s) {
        if (StringUtils.isBlank(s)) {
            return null;
        }
        return Long.valueOf(StringUtils.trim(s));
    }
}
