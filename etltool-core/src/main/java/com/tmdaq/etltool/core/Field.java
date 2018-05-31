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

    public Field setSrc(String src) {
        this.src = src;
        return this;
    }

    public String getDest() {
        return dest;
    }

    public Field setDest(String dest) {
        this.dest = dest;
        return this;
    }

    public String getTypeHandle() {
        return typeHandle;
    }

    public Field setTypeHandle(String typeHandle) {
        this.typeHandle = typeHandle;
        return this;
    }

    public TypeHandler getTypeHandler() {
        return typeHandler;
    }

    public Field setTypeHandler(TypeHandler typeHandler) {
        this.typeHandler = typeHandler;
        return this;
    }
}
