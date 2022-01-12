package com.ugamdemo.core.models;

import org.json.JSONException;

public interface APIModel {
    public String getMessage() throws JSONException;

    public default String getUrl() {
        return "https://reqres.in/api/users/10";
    }
}
