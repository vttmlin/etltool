package com.tmdaq.etltool.handler;

/**
 * @author vttmlin
 */
public interface TypeHandler {
    /**
     * 把传入的类型 转为传出类型
     *
     * @param paramIn 传入类型可以是复杂类型 也可以是简单类型
     * @return 转换后的对象
     */
    Object convert(Object paramIn);
}
