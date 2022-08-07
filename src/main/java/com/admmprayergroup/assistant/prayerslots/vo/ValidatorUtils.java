package com.admmprayergroup.assistant.prayerslots.vo;

public final class ValidatorUtils {

    private ValidatorUtils() {
    }

    public static boolean isAnyNull(Object... values) {
        for (Object value : values) {
            if (value != null) {
                return false;
            }
        }
        return true;
    }

}
