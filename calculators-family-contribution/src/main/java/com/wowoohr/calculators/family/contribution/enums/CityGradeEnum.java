package com.wowoohr.calculators.family.contribution.enums;

import com.wowoohr.calculators.family.contribution.constant.CityRate;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 城市等级划分
 * @author luolihua
 */
@Getter
public enum CityGradeEnum {
    /**
     * 城市枚举
     */
    CITY1(CityRate.level1,"上海市"),
    CITY2(CityRate.level1,"北京市"),
    CITY3(CityRate.level1,"深圳市"),
    CITY4(CityRate.level1,"广州市"),
    CITY5(CityRate.level2,"苏州市"),
    CITY6(CityRate.level2,"杭州市"),
    CITY7(CityRate.level2,"南京市"),
    CITY8(CityRate.level2,"宁波市"),
    CITY9(CityRate.level2,"厦门市"),
    CITY10(CityRate.level2,"无锡市"),
    CITY11(CityRate.level2,"绍兴市"),
    CITY12(CityRate.level2,"东莞市"),
    CITY13(CityRate.level2,"佛山市"),
    CITY14(CityRate.level2,"珠海市"),
    CITY15(CityRate.level2,"舟山市"),
    CITY16(CityRate.level2,"嘉兴市"),
    CITY17(CityRate.level2,"温州市"),
    CITY18(CityRate.level2,"中山市"),
    CITY19(CityRate.level3,"湖州市"),
    CITY20(CityRate.level3,"常州市"),
    CITY21(CityRate.level3,"金华市"),
    CITY22(CityRate.level3,"长沙市"),
    CITY23(CityRate.level3,"台州市"),
    CITY24(CityRate.level3,"克拉玛依市"),
    CITY25(CityRate.level3,"青岛市"),
    CITY26(CityRate.level3,"武汉市"),
    CITY27(CityRate.level3,"镇江市"),
    CITY28(CityRate.level3,"包头市"),
    CITY29(CityRate.level3,"乌海市"),
    CITY30(CityRate.level3,"天津市"),
    CITY31(CityRate.level4,"三沙市"),
    CITY32(CityRate.level4,"南通市"),
    CITY33(CityRate.level4,"济南市"),
    CITY34(CityRate.level4,"马孩山市"),
    CITY35(CityRate.level4,"合肥市"),
    CITY36(CityRate.level4,"东营市"),
    CITY37(CityRate.level4,"成都市"),
    CITY38(CityRate.level4,"鄂尔多斯市"),
    CITY39(CityRate.level4,"沈阳市"),
    CITY40(CityRate.level4,"大连市"),
    CITY41(CityRate.level4,"乌鲁木齐市"),
    CITY42(CityRate.level4,"威海市"),
    CITY43(CityRate.level4,"泉州市"),
    CITY44(CityRate.level4,"泰州市"),
    CITY45(CityRate.level4,"惠州市"),
    CITY46(CityRate.level4,"南昌市"),
    CITY47(CityRate.level4,"衢州市"),
    CITY48(CityRate.level4,"烟台市"),
    CITY49(CityRate.level4,"福州市"),
    CITY50(CityRate.level4,"嘉峪关"),
    CITY51(CityRate.level5,"其他");
    float rate;
    String city;
    CityGradeEnum(float rate, String city) {
        this.rate = rate;
        this.city = city;
    }

    public static CityGradeEnum getCityGradeRate(String city){
        return Arrays.stream(values()).filter(CityGradeEnum -> Objects.equals(CityGradeEnum.getCity(),city)).findFirst().orElse(CITY51);
    }


}
