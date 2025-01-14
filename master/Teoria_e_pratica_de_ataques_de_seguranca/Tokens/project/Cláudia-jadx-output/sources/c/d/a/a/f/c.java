package c.d.a.a.f;

import android.os.IBinder;
import c.d.a.a.f.a;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public final class c<T> extends a.AbstractBinderC0059a {

    /* renamed from: a  reason: collision with root package name */
    public final T f3580a;

    public c(T t) {
        this.f3580a = t;
    }

    public static <T> a a(T t) {
        return new c(t);
    }

    public static <T> T a(a aVar) {
        if (aVar instanceof c) {
            return ((c) aVar).f3580a;
        }
        IBinder asBinder = aVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i2 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i2++;
                field = field2;
            }
        }
        if (i2 != 1) {
            int length = declaredFields.length;
            StringBuilder sb = new StringBuilder(64);
            sb.append("Unexpected number of IObjectWrapper declared fields: ");
            sb.append(length);
            throw new IllegalArgumentException(sb.toString());
        } else if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        } else {
            field.setAccessible(true);
            try {
                return (T) field.get(asBinder);
            } catch (IllegalAccessException e2) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e2);
            } catch (NullPointerException e3) {
                throw new IllegalArgumentException("Binder object is null.", e3);
            }
        }
    }
}
