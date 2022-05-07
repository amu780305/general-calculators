package com.wowoohr.calculators.family.contribution.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * 做家务枚举
 *
 */
@Getter
public enum HouseWorkEnum {
    /**
     * 做家务枚举
     */
    HOUSEWORK1(600,"整理收纳"),
    HOUSEWORK2(800,"日常保洁"),
    HOUSEWORK3(1000,"洗衣洗鞋"),
    HOUSEWORK4(2000,"深度清洁");
    float rate;
    String housewok;
    HouseWorkEnum(float rate, String housewok) {
        this.rate = rate;
        this.housewok = housewok;
    }

    public static HouseWorkEnum getKidRate(String housework){
        return Arrays.stream(values()).filter(HouseWorkEnum -> Objects.equals(HouseWorkEnum.getHousewok(),housework)).findFirst().orElse(null);
    }


}
