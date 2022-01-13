package com.ugamdemo.core.models.impl;

import com.ugamdemo.core.models.APIModel;
import com.ugamdemo.core.utils.Network;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = APIModel.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class APIModelImpl implements APIModel {

    final Logger LOG = LoggerFactory.getLogger(APIModelImpl.class);
    @Inject
    String url;

    @Override
    public String getUrl(){
        return "https://reqres.in/api/users/"+url;
    }
    @Override
    public String getMessage() {

        return Network.readJson(getUrl());
    }

}
