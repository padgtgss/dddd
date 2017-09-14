package com.repository.entity.common;

/**
 * @Description: AvailableEnum
 * @Author: lin.shi
 * @CreateTime: 2017-09-13 15:34
 */
public enum AvailableEnum implements BaseEnum<AvailableEnum,String>{

    AVAILABLE("available","可用"),
    UNAVAILABLE("unAvailable","不可用");

    private String value;
    private String description;
    AvailableEnum(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public static AvailableEnum getAvailableEnum(String value){
        for (AvailableEnum availableEnum : AvailableEnum.values()) {
            if(availableEnum.getValue().equals(value))
                return availableEnum;
        }
        throw new IllegalArgumentException(value + "\t is not in " + AvailableEnum.class);
    }



    public void setValue(String value) {
        this.value = value;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public String getDescription() {
        return this.description;
    }



}
