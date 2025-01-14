package com.j256.ormlite.logger;

import com.j256.ormlite.logger.Log;

/* loaded from: classes.dex */
public class Slf4jLoggingLog implements Log {
    public final org.slf4j.Logger logger;

    /* renamed from: com.j256.ormlite.logger.Slf4jLoggingLog$1 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C14681 {
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

    public Slf4jLoggingLog(String str) {
        this.logger = org.slf4j.LoggerFactory.getLogger(str);
    }

    @Override // com.j256.ormlite.logger.Log
    public boolean isLevelEnabled(Log.Level level) {
        switch (C14681.$SwitchMap$com$j256$ormlite$logger$Log$Level[level.ordinal()]) {
            case 1:
                return this.logger.isTraceEnabled();
            case 2:
                return this.logger.isDebugEnabled();
            case 3:
                return this.logger.isInfoEnabled();
            case 4:
                return this.logger.isWarnEnabled();
            case 5:
                return this.logger.isErrorEnabled();
            case 6:
                return this.logger.isErrorEnabled();
            default:
                return this.logger.isInfoEnabled();
        }
    }

    @Override // com.j256.ormlite.logger.Log
    public void log(Log.Level level, String str) {
        switch (C14681.$SwitchMap$com$j256$ormlite$logger$Log$Level[level.ordinal()]) {
            case 1:
                this.logger.trace(str);
                return;
            case 2:
                this.logger.debug(str);
                return;
            case 3:
                this.logger.info(str);
                return;
            case 4:
                this.logger.warn(str);
                return;
            case 5:
                this.logger.error(str);
                return;
            case 6:
                this.logger.error(str);
                return;
            default:
                this.logger.info(str);
                return;
        }
    }

    @Override // com.j256.ormlite.logger.Log
    public void log(Log.Level level, String str, Throwable th) {
        switch (C14681.$SwitchMap$com$j256$ormlite$logger$Log$Level[level.ordinal()]) {
            case 1:
                this.logger.trace(str, th);
                return;
            case 2:
                this.logger.debug(str, th);
                return;
            case 3:
                this.logger.info(str, th);
                return;
            case 4:
                this.logger.warn(str, th);
                return;
            case 5:
                this.logger.error(str, th);
                return;
            case 6:
                this.logger.error(str, th);
                return;
            default:
                this.logger.info(str, th);
                return;
        }
    }
}
