package com.cuelogic.framework.json;

import com.google.gson.Gson;

/**
 * Created by ninad on 18/01/16.
 */
public class JSONFactory {

    private static JSONFactory instance = null;
    protected JSONFactory() {
        // Exists only to defeat instantiation.
    }

    public static JSONFactory factory() {
        if(instance == null) {
            instance = new JSONFactory();
        }
        return instance;
    }

    public String toJSON(Object object) throws Exception {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    public <T> T fromJSON(String json, Class<T> classofT) throws Exception {
        Gson gson = new Gson();
        return gson.fromJson(json, classofT);
    }
}