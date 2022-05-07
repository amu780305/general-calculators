package com.wowoohr.calculators.enums;

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
    MAN1(5000,"anOldMan"),
    MAN2(10000,"twoOldPeople"),
    MAN3(15000,"threeOldPeople"),
    MAN4(20000,"fourOldPeople");
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
