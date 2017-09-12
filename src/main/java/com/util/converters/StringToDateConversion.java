package com.util.converters;


import org.apache.commons.lang.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: StringToDateConversion
 * @Author: lin.shi
 * @CreateTime: 2017-04-20 11:05
 */
public class StringToDateConversion implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        if (StringUtils.isBlank(source)) {
            return null;
        }
        source = StringUtils.trim(source);
        // 直接采用系统统一的时间格式yyyy-MM-dd HH:mm:ss
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 尝试解析时间戳格式
        try {
            return new Date(Long.parseLong(source));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 尝试解析时间格式yyyy-MM-dd
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
