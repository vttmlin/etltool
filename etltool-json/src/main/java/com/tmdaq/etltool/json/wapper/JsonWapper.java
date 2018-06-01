package com.tmdaq.etltool.json.wapper;

import com.tmdaq.etltool.core.Configuration;
import org.json.JSONObject;

import java.util.HashMap;
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
}
