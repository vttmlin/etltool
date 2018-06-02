package com.tmdaq.etltool.json.wapper;

import com.google.gson.Gson;
import com.tmdaq.etltool.core.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author vttmlin
 */
public class GsonWapper extends Json {
    private static Gson gson = new Gson();

    GsonWapper(Configuration config) {
        super(config);
    }

    @Override
    Map readValue(String json) {
        if (json == null || "".equals(json)) {
            return new HashMap<>(0);
        }
        return gson.fromJson(json, Map.class);
    }

    @Override
    List readValueFromList(String json) {
        if (json == null || "".equals(json)) {
            return new ArrayList();
        }
        return gson.fromJson(json, List.class);
    }


}
