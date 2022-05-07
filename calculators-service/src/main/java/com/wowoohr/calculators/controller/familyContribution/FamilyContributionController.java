package com.wowoohr.calculators.controller.familyContribution;


import com.wowoohr.calculators.form.BaseForm;
import com.wowoohr.calculators.form.FamilyContributionCalculateForm;
import com.wowoohr.calculators.service.ITFamilyContributionCopysService;
import com.wowoohr.calculators.service.ITFamilyContributionService;
import com.wowoohr.calculators.service.impl.TFamilyContributionCopysServiceImpl;
import com.wowoohr.core.common.core.annotation.UserAccess;
import com.wowoohr.core.common.core.result.ApiResponseT;
import com.wowoohr.core.common.core.user.WowooUserInfoContainer;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenhaomu
 * @since 2022-05-07
 */
@RestController
@RequestMapping("/calculators/familyContribution")
public class FamilyContributionController {
    @Resource
    ITFamilyContributionService itFamilyContributionService;

    @RequestMapping(value = "/calculateFamilyContribution", method = RequestMethod.POST)
    public ApiResponseT calculateFamilyContribution(@UserAccess WowooUserInfoContainer token, FamilyContributionCalculateForm form) {
        return ApiResponseT.success(itFamilyContributionService.getFamilyContributionResult(form));
    }

}
