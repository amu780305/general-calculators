package com.wowoohr.calculators.family.contribution.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * 照顾宠物枚举
 *
 */
@Getter
public enum PetCareEnum {
    /**
     * 照顾宠物枚举
     */
    PET1(3000,"小型宠物"),
    PET2(4500,"中型宠物"),
    PET3(6000,"大型宠物");

    float rate;
    String pet;
    PetCareEnum(float rate, String pet) {
        this.rate = rate;
        this.pet = pet;
    }

    public static PetCareEnum getPetRate(String pet){
        return Arrays.stream(values()).filter(PetCareEnum -> Objects.equals(PetCareEnum.getPet(),pet)).findFirst().orElse(null);
    }


}
