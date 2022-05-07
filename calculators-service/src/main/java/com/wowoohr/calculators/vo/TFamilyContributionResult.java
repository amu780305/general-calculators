package com.wowoohr.calculators.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenhaomu
 * @since 2022-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TFamilyContributionUserResult对象", description="")
public class TFamilyContributionResult {


    @ApiModelProperty(value = "市场价格")
    private float marketingPrice;

    @ApiModelProperty(value = "综合贡献")
    private float contribution;

    @ApiModelProperty(value = "推荐文案")
    private String copy;

    @ApiModelProperty(value = "超过人数百分比")
    private String rate;

    @ApiModelProperty(value = "耐心度")
    private String patient;

    @ApiModelProperty(value = "孝顺度")
    private String filialPiety;

    @ApiModelProperty(value = "勤劳度")
    private String diligent;

    @ApiModelProperty(value = "爱心值")
    private String compassion;

    @ApiModelProperty(value = "总产能")
    private String total;



}
