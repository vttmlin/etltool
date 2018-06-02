package com.tmdaq.etltool.core;

import com.tmdaq.etltool.annotation.Etl;
import com.tmdaq.etltool.handler.TypeHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author vttmlin
 */
public class Copy {
    private Configuration configuration;

    public Copy(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * 操作的核心方法
     *
     * @param src       复制的源 目前支持map object 两大类型
     * @param dest      目标类
     * @param convertId 配置文件中的id
     */
    public <T> T copy(Object src, Object dest, String convertId) throws NoSuchFieldException, IllegalAccessException {
        Convert convert = configuration.getMap().get(convertId);
        for (Field field : convert.getFieldList()) {
            java.lang.reflect.Field destField = dest.getClass().getDeclaredField(field.getDest());
            String src1 = field.getSrc();
            Object value = null;
            if (src instanceof Map) {
                value = ((Map) src).get(src1);
                if (((Map) src).get(src1) != null) {
                    value = getObject(field, value);
                } else {
                    continue;
                }
            } else if (src.getClass().getAnnotation(Etl.class) != null) {
                java.lang.reflect.Field srcField = src.getClass().getDeclaredField(field.getSrc());
                srcField.setAccessible(true);
                value = srcField.get(src);
                if (value != null) {
                    value = getObject(field, value);
                } else {
                    continue;
                }
            }
            destField.setAccessible(true);
            destField.set(dest, value);
        }
        return (T) dest;
    }

    public <T> List<T> copy(List<Object> src, List<T> dest, final String convertId) throws NoSuchFieldException, IllegalAccessException {
        if (src != null && src.size() > 0 && dest != null && dest.size() > 0 && src.size() == dest.size()) {
            for (int i = 0; i < src.size(); i++) {
                copy(src.get(i), dest.get(i), convertId);
            }
        }
        return dest;
    }

    public <T> List<T> copy(List<Object> src, Class<T> dest, final String convertId) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        List<Object> list = new ArrayList<>();
        if (src != null && src.size() > 0 && dest != null) {
            for (int i = 0; i < src.size(); i++) {
                list.add(copy(src.get(i), dest.newInstance(), convertId));
            }
        }
        return (List<T>) list;
    }

    private Object getObject(Field field, Object value) {
        if (field.getTypeHandle() != null && !"".equals(field.getTypeHandle())) {
            TypeHandler typeHandler = configuration.getTypeHandler(field.getTypeHandle());
            if (typeHandler != null) {
                value = typeHandler.convert(value);
            }
        }
        return value;
    }
}
