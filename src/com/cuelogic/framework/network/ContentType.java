package com.cuelogic.framework.network;

/**
 * Created by ninad on 14/01/16.
 */
public enum ContentType {
    JSON ("application/json"),
    XML ("application/xml");

    private final String name;

    private ContentType(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}