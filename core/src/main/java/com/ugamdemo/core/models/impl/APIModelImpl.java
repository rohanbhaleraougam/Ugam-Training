package com.ugamdemo.core.models.impl;

import com.google.gson.Gson;
import com.ugamdemo.core.models.APIModel;
import com.ugamdemo.core.services.ReadJsonService;
import com.ugamdemo.core.utils.Network;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.json.JSONException;
import org.json.JSONObject;
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

    @Inject
    ReadJsonService rj;

    private String message;

    @Override
    public String getUrl(){
        return url;
    }
    @Override
    public String getMessage() throws JSONException {

        String response = Network.readJson(url);

        /*JSONObject jsonObject = new JSONObject(response);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        //System.out.println(jsonArray);*/

        JSONObject jsonObject = new JSONObject(response);
        //JSONArray jsonArray = jsonObject.getJSONArray("data");

        Gson gson = new Gson();
        APIModelImpl apiModelImpl = new APIModelImpl();
        String jsonString = gson.toJson(response);

        LOG.error("UniqueArray"+String.valueOf(jsonObject));
        return response;


    }
}
