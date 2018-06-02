package com.tmdaq.etltool.json.wapper;

import com.tmdaq.etltool.core.Configuration;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author vttmlin
 */
public class JsonWapper extends Json {
    JsonWapper(Configuration config) {
        super(config);
    }

    @Override
    Map readValue(String json) {
        if (json == null || "".equals(json)) {
            return new HashMap(0);
        } else {
            return new JSONObject(json).toMap();
        }
    }

    @Override
    List readValueFromList(String json) {
        if (json == null || "".equals(json)) {
            return new ArrayList();
        }
        return new JSONArray(json).toList();
    }
}
