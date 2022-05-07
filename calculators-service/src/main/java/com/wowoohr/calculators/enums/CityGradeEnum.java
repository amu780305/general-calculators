package com.wowoohr.calculators.enums;


import com.wowoohr.calculators.constant.CityRate;
import lombok.Getter;

import java.util.Arrays;
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
    CITY1(CityRate.level1,"上海"),
    CITY2(CityRate.level1,"北京"),
    CITY3(CityRate.level1,"深圳"),
    CITY4(CityRate.level1,"广州"),
    CITY5(CityRate.level2,"苏州"),
    CITY6(CityRate.level2,"杭州"),
    CITY7(CityRate.level2,"南京"),
    CITY8(CityRate.level2,"宁波"),
    CITY9(CityRate.level2,"厦门"),
    CITY10(CityRate.level2,"无锡"),
    CITY11(CityRate.level2,"绍兴"),
    CITY12(CityRate.level2,"东莞"),
    CITY13(CityRate.level2,"佛山"),
    CITY14(CityRate.level2,"珠海"),
    CITY15(CityRate.level2,"舟山"),
    CITY16(CityRate.level2,"嘉兴"),
    CITY17(CityRate.level2,"温州"),
    CITY18(CityRate.level2,"中山"),
    CITY19(CityRate.level3,"湖州"),
    CITY20(CityRate.level3,"常州"),
    CITY21(CityRate.level3,"金华"),
    CITY22(CityRate.level3,"长沙"),
    CITY23(CityRate.level3,"台州"),
    CITY24(CityRate.level3,"克拉玛依"),
    CITY25(CityRate.level3,"青岛"),
    CITY26(CityRate.level3,"武汉"),
    CITY27(CityRate.level3,"镇江"),
    CITY28(CityRate.level3,"包头"),
    CITY29(CityRate.level3,"乌海"),
    CITY30(CityRate.level3,"天津"),
    CITY31(CityRate.level4,"三沙"),
    CITY32(CityRate.level4,"南通"),
    CITY33(CityRate.level4,"济南"),
    CITY34(CityRate.level4,"马孩山"),
    CITY35(CityRate.level4,"合肥"),
    CITY36(CityRate.level4,"东营"),
    CITY37(CityRate.level4,"成都"),
    CITY38(CityRate.level4,"鄂尔多斯"),
    CITY39(CityRate.level4,"沈阳"),
    CITY40(CityRate.level4,"大连"),
    CITY41(CityRate.level4,"乌鲁木齐"),
    CITY42(CityRate.level4,"威海"),
    CITY43(CityRate.level4,"泉州"),
    CITY44(CityRate.level4,"泰州"),
    CITY45(CityRate.level4,"惠州"),
    CITY46(CityRate.level4,"南昌"),
    CITY47(CityRate.level4,"衢州"),
    CITY48(CityRate.level4,"烟台"),
    CITY49(CityRate.level4,"福州"),
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
