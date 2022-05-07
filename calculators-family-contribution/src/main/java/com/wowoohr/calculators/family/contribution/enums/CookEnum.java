package com.wowoohr.calculators.family.contribution.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * 做饭枚举
 *
 */
@Getter
public enum CookEnum {
    /**
     * 做饭枚举
     */
    COOK1(2400,"一日一餐"),
    COOK2(4800,"一日两餐"),
    COOK3(7200,"一日三餐"),
    COOK4(9600,"一日四餐");
    float rate;
    String cook;
    CookEnum(float rate, String cook) {
        this.rate = rate;
        this.cook = cook;
    }

    public static CookEnum getKidRate(String cook){
        return Arrays.stream(values()).filter(CookEnum -> Objects.equals(CookEnum.getCook(),cook)).findFirst().orElse(null);
    }


}
