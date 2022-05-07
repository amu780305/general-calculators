package com.wowoohr.calculators.family.contribution.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public enum EffectiveTimeTypeEnum {

    //生效时间周期类型,0.无限制一直生效（生效开始和结束时间可不填），1.每周（生效开始和结束时间都填周几），2.日期（生效开始和结束填具体日期时间）
    UNLIMIT((short)0,"无限制"),
    WEEKLY((short)1,"每周"),
    DATE((short)2,"日期");

    private Short code;

    private String desc;

    EffectiveTimeTypeEnum(Short code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Short getCode() {
        return code;
    }

    public void setCode(Short code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static List<Short> getEffectiveTimeTypeList(){
        return Arrays.stream(values()).map(effectiveTimeType -> effectiveTimeType.getCode()).collect(Collectors.toList());
    }

    public static EffectiveTimeTypeEnum getEffectiveTimeTypeByCode(Short code){
        return Arrays.stream(values()).filter(effectiveTimeType -> Objects.equals(effectiveTimeType.getCode(),code)).findFirst().orElse(null);
    }
}
