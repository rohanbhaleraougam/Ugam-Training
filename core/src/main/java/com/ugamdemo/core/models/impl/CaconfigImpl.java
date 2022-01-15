
package com.ugamdemo.core.models.impl;

import com.day.cq.wcm.api.Page;
import com.ugamdemo.core.config.UgamCAconfig;
import com.ugamdemo.core.models.Caconfig;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.caconfig.ConfigurationBuilder;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.annotation.PostConstruct;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = Caconfig.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CaconfigImpl implements Caconfig {

    @SlingObject
    ResourceResolver resourceResolver;

    @ScriptVariable
    Page currentPage;

    private String siteCountry;
    private String siteAdmin;
    private String siteSection;

    @Override
    public String getSiteCountry() {
        return siteCountry;
    }

    @Override
    public String getSiteAdmin() {
        return siteAdmin;
    }

    @Override
    public String getSiteSection() {
        return siteSection;
    }

    @PostConstruct
    public void postConstruct() {
        UgamCAconfig caConfig = getContextAwareConfig(currentPage.getPath(), resourceResolver);
        siteCountry = caConfig.siteCountry();
        siteAdmin = caConfig.siteAdmin();
        siteSection = caConfig.siteSection();
    }

    public UgamCAconfig getContextAwareConfig(String currentPage, ResourceResolver resourceResolver) {
        String currentPath = StringUtils.isNoneBlank(currentPage) ? currentPage : StringUtils.EMPTY;
        Resource contentResource = resourceResolver.getResource(currentPath);
        if (contentResource != null) {
            ConfigurationBuilder configurationBuilder = contentResource.adaptTo(ConfigurationBuilder.class);
            if (configurationBuilder != null) {
                return configurationBuilder.as(UgamCAconfig.class);
            }
        }
        return null;
    }
}