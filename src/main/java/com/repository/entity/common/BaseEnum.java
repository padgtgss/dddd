package com.repository.entity.common;

/**
 * @Description: 实体enum column 通用类，所有实体enum字段都必须实现此类方法
 * @Author: lin.shi
 * @CreateTime: 2017-09-13 15:35
 */
public  interface BaseEnum<E extends  Enum<?>,T> {
    T getValue();

     String getDescription();



}
