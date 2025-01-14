package p070c.p084d.p085a.p086a.p099f;

import android.os.IBinder;
import java.lang.reflect.Field;
import p070c.p084d.p085a.p086a.p099f.InterfaceC1119a;

/* renamed from: c.d.a.a.f.c */
/* loaded from: classes.dex */
public final class BinderC1122c<T> extends InterfaceC1119a.AbstractBinderC1120a {

    /* renamed from: a */
    public final T f5513a;

    public BinderC1122c(T t) {
        this.f5513a = t;
    }

    /* renamed from: a */
    public static <T> InterfaceC1119a m5101a(T t) {
        return new BinderC1122c(t);
    }

    /* renamed from: a */
    public static <T> T m5102a(InterfaceC1119a interfaceC1119a) {
        if (interfaceC1119a instanceof BinderC1122c) {
            return ((BinderC1122c) interfaceC1119a).f5513a;
        }
        IBinder asBinder = interfaceC1119a.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i++;
                field = field2;
            }
        }
        if (i != 1) {
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
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e);
            } catch (NullPointerException e2) {
                throw new IllegalArgumentException("Binder object is null.", e2);
            }
        }
    }
}
