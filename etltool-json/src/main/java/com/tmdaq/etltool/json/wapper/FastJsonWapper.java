package com.tmdaq.etltool.json.wapper;

import com.alibaba.fastjson.JSON;
import com.tmdaq.etltool.core.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author vttmlin
 */
public class FastJsonWapper extends Json {
    FastJsonWapper(Configuration config) {
        super(config);
    }

    @Override
    Map<String, Object> readValue(String json) {
        if (json == null || "".equals(json)) {
            return new HashMap<>(0);
        }
        return JSON.parseObject(json, Map.class);
    }

    @Override
    List readValueFromList(String json) {
        if (json == null || "".equals(json)) {
            return new ArrayList();
        }
        return JSON.parseObject(json, List.class);
    }
}
