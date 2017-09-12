package com.util.converters;


import org.apache.commons.lang.StringUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * @Description: StringTrimToString
 * @Author: lin.shi
 * @CreateTime: 2017-04-20 16:16
 */
public class StringTrimToString implements Converter<String,String> {
    @Override
    public String convert(String s) {
        if (StringUtils.isBlank(s)) {
            return null;
        }
        return StringUtils.trim(s);
    }
}
