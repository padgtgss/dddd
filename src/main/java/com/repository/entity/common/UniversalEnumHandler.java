package com.repository.entity.common;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description: mybatis 枚举转换器
 * @Author: lin.shi
 * @CreateTime: 2017-09-13 16:07
 */
public final class UniversalEnumHandler<E extends BaseEnum> extends BaseTypeHandler<E> {

    private Class<E> type;
    private E [] enums;


    public UniversalEnumHandler(Class<E> type) {
        if (type == null)
            throw new IllegalArgumentException("Type argument cannot be null");
        this.type = type;
        this.enums = type.getEnumConstants();
        if (this.enums == null)
            throw new IllegalArgumentException(type.getSimpleName()
                    + " does not represent an enum type.");
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, E e, JdbcType jdbcType) throws SQLException {
        preparedStatement.setObject(i,(String)e.getValue(), jdbcType.TYPE_CODE);
    }

    @Override
    public E getNullableResult(ResultSet resultSet, String s) throws SQLException {
        if (resultSet.wasNull()) {
            return null;
        }
        String value = resultSet.getString(s);
        return this.locateEnumStatus(value);

    }

    @Override
    public E getNullableResult(ResultSet resultSet, int i) throws SQLException {
        if (resultSet.wasNull()) {
            return null;
        }
        String value = resultSet.getString(i);
        return this.locateEnumStatus(value);
    }

    @Override
    public E getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        if (callableStatement.wasNull()) {
            return null;
        }
        String value = callableStatement.getString(i);
        return this.locateEnumStatus(value);
    }

    private E locateEnumStatus(String value) {
        for(E e : enums) {
            if(e.getValue().toString().equalsIgnoreCase(value) ) {
                return e;
            }
        }
        throw new IllegalArgumentException("未知的枚举类型：" + value + ",请核对" + type.getSimpleName());
    }
}
