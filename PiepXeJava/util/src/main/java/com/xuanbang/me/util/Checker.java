package com.xuanbang.me.util;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public final class Checker {
    private Checker() {
    }

    public static boolean isEmpty(List<?> objects) {
        return objects == null || objects.size() == 0;
    }

    public static <T> boolean isEmpty(T object) {
        return object == null;
    }

    public static Date getMaxRefreshTime(Date currentTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentTime);
        calendar.add(Calendar.MINUTE, -Constant.FRESH_TIMEOUT_IN_MINUTES);
        return calendar.getTime();
    }
}
