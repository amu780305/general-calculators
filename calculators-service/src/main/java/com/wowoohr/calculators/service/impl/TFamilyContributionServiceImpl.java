package com.wowoohr.calculators.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wowoohr.calculators.entity.TFamilyContributionCopys;
import com.wowoohr.calculators.form.FamilyContributionCalculateForm;
import com.wowoohr.calculators.mapper.TFamilyContributionCopysMapper;
import com.wowoohr.calculators.service.ITFamilyContributionCopysService;
import com.wowoohr.calculators.service.ITFamilyContributionService;
import com.wowoohr.calculators.vo.TFamilyContributionResult;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenhaomu
 * @since 2022-05-07
 */
@Service
public class TFamilyContributionServiceImpl  implements ITFamilyContributionService {

    @Override
    public TFamilyContributionResult getFamilyContributionResult(FamilyContributionCalculateForm form) {
        return null;
    }

}
