package com.j256.ormlite.android;

import com.j256.ormlite.logger.Log;
import com.j256.ormlite.logger.LoggerFactory;
/* loaded from: classes.dex */
public class AndroidLog implements Log {
    public static final String ALL_LOGS_NAME = "ORMLite";
    public static final int MAX_TAG_LENGTH = 23;
    public static final int REFRESH_LEVEL_CACHE_EVERY = 200;
    public String className;
    public final boolean[] levelCache;
    public volatile int levelCacheC = 0;

    /* renamed from: com.j256.ormlite.android.AndroidLog$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$j256$ormlite$logger$Log$Level = new int[Log.Level.values().length];

        static {
            try {
                $SwitchMap$com$j256$ormlite$logger$Log$Level[Log.Level.TRACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$j256$ormlite$logger$Log$Level[Log.Level.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$j256$ormlite$logger$Log$Level[Log.Level.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$j256$ormlite$logger$Log$Level[Log.Level.WARNING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$j256$ormlite$logger$Log$Level[Log.Level.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$j256$ormlite$logger$Log$Level[Log.Level.FATAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public AndroidLog(String str) {
        this.className = LoggerFactory.getSimpleClassName(str);
        int length = this.className.length();
        if (length > 23) {
            this.className = this.className.substring(length - 23, length);
        }
        int i2 = 0;
        for (Log.Level level : Log.Level.values()) {
            int levelToAndroidLevel = levelToAndroidLevel(level);
            if (levelToAndroidLevel > i2) {
                i2 = levelToAndroidLevel;
            }
        }
        this.levelCache = new boolean[i2 + 1];
        refreshLevelCache();
    }

    private boolean isLevelEnabledInternal(int i2) {
        return android.util.Log.isLoggable(this.className, i2) || android.util.Log.isLoggable(ALL_LOGS_NAME, i2);
    }

    private int levelToAndroidLevel(Log.Level level) {
        switch (AnonymousClass1.$SwitchMap$com$j256$ormlite$logger$Log$Level[level.ordinal()]) {
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
            case 6:
                return 6;
            default:
                return 4;
        }
    }

    private void refreshLevelCache() {
        for (Log.Level level : Log.Level.values()) {
            int levelToAndroidLevel = levelToAndroidLevel(level);
            boolean[] zArr = this.levelCache;
            if (levelToAndroidLevel < zArr.length) {
                zArr[levelToAndroidLevel] = isLevelEnabledInternal(levelToAndroidLevel);
            }
        }
    }

    @Override // com.j256.ormlite.logger.Log
    public boolean isLevelEnabled(Log.Level level) {
        int i2 = this.levelCacheC + 1;
        this.levelCacheC = i2;
        if (i2 >= 200) {
            refreshLevelCache();
            this.levelCacheC = 0;
        }
        int levelToAndroidLevel = levelToAndroidLevel(level);
        boolean[] zArr = this.levelCache;
        if (levelToAndroidLevel < zArr.length) {
            return zArr[levelToAndroidLevel];
        }
        return isLevelEnabledInternal(levelToAndroidLevel);
    }

    @Override // com.j256.ormlite.logger.Log
    public void log(Log.Level level, String str) {
        switch (AnonymousClass1.$SwitchMap$com$j256$ormlite$logger$Log$Level[level.ordinal()]) {
            case 1:
                android.util.Log.v(this.className, str);
                return;
            case 2:
                android.util.Log.d(this.className, str);
                return;
            case 3:
                android.util.Log.i(this.className, str);
                return;
            case 4:
                android.util.Log.w(this.className, str);
                return;
            case 5:
                android.util.Log.e(this.className, str);
                return;
            case 6:
                android.util.Log.e(this.className, str);
                return;
            default:
                android.util.Log.i(this.className, str);
                return;
        }
    }

    @Override // com.j256.ormlite.logger.Log
    public void log(Log.Level level, String str, Throwable th) {
        switch (AnonymousClass1.$SwitchMap$com$j256$ormlite$logger$Log$Level[level.ordinal()]) {
            case 1:
                android.util.Log.v(this.className, str, th);
                return;
            case 2:
                android.util.Log.d(this.className, str, th);
                return;
            case 3:
                android.util.Log.i(this.className, str, th);
                return;
            case 4:
                android.util.Log.w(this.className, str, th);
                return;
            case 5:
                android.util.Log.e(this.className, str, th);
                return;
            case 6:
                android.util.Log.e(this.className, str, th);
                return;
            default:
                android.util.Log.i(this.className, str, th);
                return;
        }
    }
}
