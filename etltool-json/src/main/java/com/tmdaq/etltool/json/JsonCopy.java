package com.tmdaq.etltool.json;

import com.tmdaq.etltool.core.Configuration;
import com.tmdaq.etltool.json.wapper.Json;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class JsonCopy {
    private static Json json;

    public JsonCopy(Configuration config) {
        if (config.getJsonExecutor() != null) {
            try {
                Constructor constructor = config.getJsonExecutor().getDeclaredConstructor(Configuration.class);
                constructor.setAccessible(true);
                json = (Json) constructor.newInstance(config);
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public <T> T copy(String src, Object dest, String convertId) {
        try {
            return json.copy(src, dest, convertId);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return (T) new Object();
    }
}
