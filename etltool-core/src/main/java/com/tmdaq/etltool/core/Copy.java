package com.tmdaq.etltool.core;

import com.tmdaq.etltool.annotation.Etl;
import com.tmdaq.etltool.handler.TypeHandler;

import java.util.Map;

/**
 * @author vttmlin
 * */
public class Copy<SRC, DEST> {
    private Configuration configuration;

    public Copy(Configuration configuration) {
        this.configuration = configuration;
    }

    public DEST copy(SRC src, DEST dest, String convertId) throws NoSuchFieldException, IllegalAccessException {
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
        return dest;
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
