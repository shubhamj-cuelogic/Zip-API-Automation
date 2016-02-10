package com.cuelogic.framework.network;

/**
 * Created by Shubham on 10/02/16.
 */
public enum Authorization {
    Type ("Authorization");

    private final String name;

    private Authorization(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}