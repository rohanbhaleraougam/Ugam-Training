package com.ugamdemo.core.models.impl;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import com.ugamdemo.core.services.UgamService;

import com.ugamdemo.core.models.UgamServiceModel;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = UgamServiceModel.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class UgamServiceModelImpl implements UgamServiceModel {
    @OSGiService
    UgamService ugamService;
    @Override
    public String getServiceName() {
        return ugamService.getServiceName();
    }

    @Override
    public int getServiceCount() {
        return ugamService.getServiceCount();
    }

    @Override
    public String getRunModes() {
        return ugamService.getRunModes();
    }
}
