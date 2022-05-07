package com.wowoohr.calculators.family.contribution.enums;

import com.wowoohr.calculators.family.contribution.constant.CityRate;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * 照顾孩子
 *
 */
@Getter
public enum KidCareEnum {
    /**
     * kid年龄
     */
    KID1(16000,"2月龄内孩子"),
    KID2(12000,"2月龄内-入学前孩子"),
    KID3(4000,"9年义务教育期孩子"),
    KID4(12000,"小孩心理辅导");
    float rate;
    String kid;
    KidCareEnum(float rate, String kid) {
        this.rate = rate;
        this.kid = kid;
    }

    public static KidCareEnum getKidRate(String kid){
        return Arrays.stream(values()).filter(KidCareEnum -> Objects.equals(KidCareEnum.getKid(),kid)).findFirst().orElse(null);
    }


}
