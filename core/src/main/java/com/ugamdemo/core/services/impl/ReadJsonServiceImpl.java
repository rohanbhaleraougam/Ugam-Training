package com.ugamdemo.core.services.impl;

import com.ugamdemo.core.models.impl.APIModelImpl;
import com.ugamdemo.core.services.ReadJsonService;
import com.ugamdemo.core.utils.Network;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = ReadJsonService.class)
public class ReadJsonServiceImpl implements ReadJsonService {

    //String URL = "https://reqres.in/api/users/1";

    APIModelImpl json = new APIModelImpl();
    String url = json.getUrl();



    @Override
    public String getData() {

        String response = Network.readJson(url);
        return response;

    }
}
