package com.tmdaq.etltool.json.wapper;

import com.tmdaq.etltool.core.Configuration;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @Override
    List readValueFromList(String json) {
        if (json == null || "".equals(json)) {
            return new ArrayList();
        }
        return JSONArray.fromObject(json);
    }
}
