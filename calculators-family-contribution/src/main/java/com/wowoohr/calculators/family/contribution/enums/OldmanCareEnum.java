package com.wowoohr.calculators.family.contribution.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * 照顾孩子
 *
 */
@Getter
public enum OldmanCareEnum {
    /**
     * kid年龄
     */
    MAN1(5000,"一位老人"),
    MAN2(10000,"两位老人"),
    MAN3(15000,"三位老人"),
    MAN4(20000,"四位老人");
    float rate;
    String man;
    OldmanCareEnum(float rate, String man) {
        this.rate = rate;
        this.man = man;
    }

    public static OldmanCareEnum getKidRate(String man){
        return Arrays.stream(values()).filter(OldmanCareEnum -> Objects.equals(OldmanCareEnum.getMan(),man)).findFirst().orElse(null);
    }


}
