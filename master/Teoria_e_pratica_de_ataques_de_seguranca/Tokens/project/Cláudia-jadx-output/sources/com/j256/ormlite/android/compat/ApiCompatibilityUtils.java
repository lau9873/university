package com.j256.ormlite.android.compat;

import android.os.Build;
/* loaded from: classes.dex */
public class ApiCompatibilityUtils {
    public static final int BASE = 1;
    public static final int BASE_1_1 = 2;
    public static final int CUPCAKE = 3;
    public static final int DONUT = 4;
    public static final int ECLAIR = 5;
    public static final int ECLAIR_0_1 = 6;
    public static final int ECLAIR_MR1 = 7;
    public static final int FROYO = 8;
    public static final int GINGERBREAD = 9;
    public static final int GINGERBREAD_MR1 = 10;
    public static final int HONEYCOMB = 11;
    public static final int HONEYCOMB_MR1 = 12;
    public static final int HONEYCOMB_MR2 = 13;
    public static final int ICE_CREAM_SANDWICH = 14;
    public static final int ICE_CREAM_SANDWICH_MR1 = 15;
    public static final int JELLY_BEAN = 16;
    public static final int JELLY_BEAN_MR1 = 17;
    public static final int JELLY_BEAN_MR2 = 18;
    public static ApiCompatibility compatibility;

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            compatibility = new JellyBeanApiCompatibility();
        } else {
            compatibility = new BasicApiCompatibility();
        }
    }

    public static ApiCompatibility getCompatibility() {
        return compatibility;
    }
}
