package com.ugamdemo.core.utils;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;

import java.util.HashMap;
import java.util.Map;

public class ResolverUtils {

    public static final String UGAMDEMO_SERVICE_USER = "ugamdemoserviceuser";
    public static ResourceResolver newResolver(ResourceResolverFactory resourceResolverFactory ) throws LoginException, LoginException {
        final Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put( ResourceResolverFactory.SUBSERVICE, UGAMDEMO_SERVICE_USER );
        ResourceResolver resolver = resourceResolverFactory.getServiceResourceResolver(paramMap);
        return resolver;
    }
}
