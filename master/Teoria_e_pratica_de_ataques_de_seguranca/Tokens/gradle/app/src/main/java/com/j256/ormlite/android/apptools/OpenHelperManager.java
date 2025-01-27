package com.j256.ormlite.android.apptools;

import android.content.Context;
import android.content.res.Resources;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public class OpenHelperManager {
    public static final String HELPER_CLASS_RESOURCE_NAME = "open_helper_classname";
    public static Logger logger = LoggerFactory.getLogger(OpenHelperManager.class);
    public static Class<? extends OrmLiteSqliteOpenHelper> helperClass = null;
    public static volatile OrmLiteSqliteOpenHelper helper = null;
    public static boolean wasClosed = false;
    public static int instanceCount = 0;

    public static OrmLiteSqliteOpenHelper constructHelper(Context context, Class<? extends OrmLiteSqliteOpenHelper> cls) {
        try {
            try {
                return cls.getConstructor(Context.class).newInstance(context);
            } catch (Exception e) {
                throw new IllegalStateException("Could not construct instance of helper class " + cls, e);
            }
        } catch (Exception e2) {
            throw new IllegalStateException("Could not find public constructor that has a single (Context) argument for helper class " + cls, e2);
        }
    }

    public static synchronized <T extends OrmLiteSqliteOpenHelper> T getHelper(Context context, Class<T> cls) {
        T t;
        synchronized (OpenHelperManager.class) {
            if (cls != null) {
                innerSetHelperClass(cls);
                t = (T) loadHelper(context, cls);
            } else {
                throw new IllegalArgumentException("openHelperClass argument is null");
            }
        }
        return t;
    }

    public static void innerSetHelperClass(Class<? extends OrmLiteSqliteOpenHelper> cls) {
        if (cls != null) {
            Class<? extends OrmLiteSqliteOpenHelper> cls2 = helperClass;
            if (cls2 == null) {
                helperClass = cls;
                return;
            } else if (cls2 == cls) {
                return;
            } else {
                throw new IllegalStateException("Helper class was " + helperClass + " but is trying to be reset to " + cls);
            }
        }
        throw new IllegalStateException("Helper class was trying to be reset to null");
    }

    public static <T extends OrmLiteSqliteOpenHelper> T loadHelper(Context context, Class<T> cls) {
        if (helper == null) {
            if (wasClosed) {
                logger.info("helper was already closed and is being re-opened");
            }
            if (context != null) {
                helper = constructHelper(context.getApplicationContext(), cls);
                logger.trace("zero instances, created helper {}", helper);
                BaseDaoImpl.clearAllInternalObjectCaches();
                DaoManager.clearDaoCache();
                instanceCount = 0;
            } else {
                throw new IllegalArgumentException("context argument is null");
            }
        }
        instanceCount++;
        logger.trace("returning helper {}, instance count = {} ", helper, Integer.valueOf(instanceCount));
        return (T) helper;
    }

    public static Class<? extends OrmLiteSqliteOpenHelper> lookupHelperClass(Context context, Class<?> cls) {
        Type[] actualTypeArguments;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(HELPER_CLASS_RESOURCE_NAME, "string", context.getPackageName());
        if (identifier != 0) {
            String string = resources.getString(identifier);
            try {
                return Class.forName(string);
            } catch (Exception e) {
                throw new IllegalStateException("Could not create helper instance for class " + string, e);
            }
        }
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            Type genericSuperclass = cls2.getGenericSuperclass();
            if (genericSuperclass != null && (genericSuperclass instanceof ParameterizedType) && (actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments()) != null && actualTypeArguments.length != 0) {
                for (Type type : actualTypeArguments) {
                    if (type instanceof Class) {
                        Class<? extends OrmLiteSqliteOpenHelper> cls3 = (Class) type;
                        if (OrmLiteSqliteOpenHelper.class.isAssignableFrom(cls3)) {
                            return cls3;
                        }
                    }
                }
                continue;
            }
        }
        throw new IllegalStateException("Could not find OpenHelperClass because none of the generic parameters of class " + cls + " extends OrmLiteSqliteOpenHelper.  You should use getHelper(Context, Class) instead.");
    }

    public static synchronized void releaseHelper() {
        synchronized (OpenHelperManager.class) {
            instanceCount--;
            logger.trace("releasing helper {}, instance count = {}", helper, Integer.valueOf(instanceCount));
            if (instanceCount <= 0) {
                if (helper != null) {
                    logger.trace("zero instances, closing helper {}", helper);
                    helper.close();
                    helper = null;
                    wasClosed = true;
                }
                if (instanceCount < 0) {
                    logger.error("too many calls to release helper, instance count = {}", Integer.valueOf(instanceCount));
                }
            }
        }
    }

    public static synchronized void setHelper(OrmLiteSqliteOpenHelper ormLiteSqliteOpenHelper) {
        synchronized (OpenHelperManager.class) {
            helper = ormLiteSqliteOpenHelper;
        }
    }

    public static synchronized void setOpenHelperClass(Class<? extends OrmLiteSqliteOpenHelper> cls) {
        synchronized (OpenHelperManager.class) {
            if (cls == null) {
                helperClass = null;
            } else {
                innerSetHelperClass(cls);
            }
        }
    }

    @Deprecated
    public static synchronized OrmLiteSqliteOpenHelper getHelper(Context context) {
        OrmLiteSqliteOpenHelper loadHelper;
        synchronized (OpenHelperManager.class) {
            if (helperClass == null) {
                if (context != null) {
                    innerSetHelperClass(lookupHelperClass(context.getApplicationContext(), context.getClass()));
                } else {
                    throw new IllegalArgumentException("context argument is null");
                }
            }
            loadHelper = loadHelper(context, helperClass);
        }
        return loadHelper;
    }
}
