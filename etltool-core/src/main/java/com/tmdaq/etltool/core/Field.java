package com.tmdaq.etltool.core;

import com.tmdaq.etltool.handler.TypeHandler;

/**
 * @author vttmlin
 */
public class Field {
    private String src;
    private String dest;
    private String typeHandle;
    private TypeHandler typeHandler;

    Field(String src, String dest, String typeHandle) {
        this.src = src;
        this.dest = dest;
        this.typeHandle = typeHandle;
    }

    public String getSrc() {
        return src;
    }

    Field setSrc(String src) {
        this.src = src;
        return this;
    }

    String getDest() {
        return dest;
    }

    Field setDest(String dest) {
        this.dest = dest;
        return this;
    }

    String getTypeHandle() {
        return typeHandle;
    }

    Field setTypeHandle(String typeHandle) {
        this.typeHandle = typeHandle;
        return this;
    }

    TypeHandler getTypeHandler() {
        return typeHandler;
    }

    Field setTypeHandler(TypeHandler typeHandler) {
        this.typeHandler = typeHandler;
        return this;
    }
}
