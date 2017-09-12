package com.util.converters;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * @Description: StringToIntegerConversion
 * @Author: lin.shi
 * @CreateTime: 2017-04-20 16:18
 */
public class StringToIntegerConversion implements Converter<String,Integer> {
    @Override
    public Integer convert(String s) {
        if (StringUtils.isBlank(s)) {
            return null;
        }
        return Integer.parseInt(StringUtils.trim(s));

    }
}
