package com.tmdaq.etltool.json.wapper;

import com.tmdaq.etltool.core.Configuration;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vttmlin
 */
public class JsonLibWapper extends Json {
    JsonLibWapper(Configuration config) {
        super(config);
    }

    @Override
    Map readValue(String json) {
        if (json == null || "".equals(json)) {
            return new HashMap(0);
        }
        return JSONObject.fromObject(json);
    }
}
