package com.tmdaq.etltool.json.wapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tmdaq.etltool.core.Configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author vttmlin
 */
public class JackSonWapper extends Json {
    private static ObjectMapper holder = new ObjectMapper();

    JackSonWapper(Configuration config) {
        super(config);
    }

    @Override
    Map readValue(String json) {
        try {
            if (json == null || "".equals(json)) {
                return new HashMap<>(0);
            }
            return holder.readValue(json, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>(0);
    }
}
