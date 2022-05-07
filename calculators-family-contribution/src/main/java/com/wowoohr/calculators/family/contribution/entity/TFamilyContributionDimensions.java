package com.wowoohr.calculators.family.contribution.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenhaomu
 * @since 2022-05-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TFamilyContributionDimensions对象", description="")
public class TFamilyContributionDimensions implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id（唯一约束）")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "维度id")
    private String dimensionsId;

    @ApiModelProperty(value = "维度名称")
    private String dimensionName;

    @ApiModelProperty(value = "估值范围，(0,5000]")
    private String range;

    @ApiModelProperty(value = "对应结果")
    private String result;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "建立时间")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "创建人")
    private String createdBy;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updatedTime;

    @ApiModelProperty(value = "操作人")
    private String updatedBy;


}
