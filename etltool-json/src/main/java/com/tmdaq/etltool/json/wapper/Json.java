package com.tmdaq.etltool.json.wapper;

import com.tmdaq.etltool.core.Configuration;
import com.tmdaq.etltool.core.Copy;

import java.util.List;
import java.util.Map;

/**
 * @author vttmlin
 */
public abstract class Json {
    private static Configuration configuration = null;
    private static Copy copy = null;

    Json(Configuration config) {
        if (configuration == null) {
            configuration = config;
            copy = new Copy(config);
        }
    }

    /**
     * @param json json字符串
     * @return 返回解析后的map 永远不会返回null 只应该返回一个空的hashmap
     */
    abstract Map readValue(String json);

    abstract List readValueFromList(String json);

    public <T> T copy(String src, Object dest, String convertId) throws NoSuchFieldException, IllegalAccessException {
        return (T) (copy.copy(readValue(src), dest, convertId));
    }

    public <T> List<T> copy(String src, List<T> dest, final String convertId) throws NoSuchFieldException, IllegalAccessException {
        return (List<T>) (copy.copy(readValueFromList(src), dest, convertId));
    }

    public <T> List<T> copy(String src, Class<T> dest, final String convertId) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        return (List<T>) (copy.copy(readValueFromList(src), dest, convertId));
    }
}
