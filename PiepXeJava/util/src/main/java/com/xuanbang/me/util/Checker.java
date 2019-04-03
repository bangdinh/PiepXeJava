package com.xuanbang.me.util;

public final class Checker {
    private Checker() {
    }

    public static <T> boolean isEmpty(T object) {
        return object == null;
    }
}
