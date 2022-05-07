package com.wowoohr.calculators.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wowoohr.calculators.entity.TFamilyContributionCopys;
import com.wowoohr.calculators.form.FamilyContributionCalculateForm;
import com.wowoohr.calculators.vo.TFamilyContributionResult;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenhaomu
 * @since 2022-05-07
 */
public interface ITFamilyContributionService  {

    TFamilyContributionResult getFamilyContributionResult(FamilyContributionCalculateForm form) ;

    }
