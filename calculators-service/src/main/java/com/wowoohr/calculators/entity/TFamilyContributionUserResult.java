package com.wowoohr.calculators.entity;

import java.math.BigDecimal;
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
 * @since 2022-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TFamilyContributionUserResult对象", description="")
public class TFamilyContributionUserResult implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id（唯一约束）")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "结果id")
    private String resultId;

    @ApiModelProperty(value = "用户id，alipayid")
    private String userId;

    @ApiModelProperty(value = "平台类型")
    private String plateform;

    @ApiModelProperty(value = "市场价值")
    private String marketSalary;

    @ApiModelProperty(value = "贡献值")
    private BigDecimal contribution;

    @ApiModelProperty(value = "建立时间")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "创建人")
    private String createdBy;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updatedTime;

    @ApiModelProperty(value = "操作人")
    private String updatedBy;


}
