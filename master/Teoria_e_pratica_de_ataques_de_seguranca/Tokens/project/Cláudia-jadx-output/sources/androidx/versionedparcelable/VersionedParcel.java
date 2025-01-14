package androidx.versionedparcelable;

import android.os.Parcelable;
import b.a.b;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public abstract class VersionedParcel {

    /* loaded from: classes.dex */
    public static class ParcelException extends RuntimeException {
    }

    public static <T extends b> Class c(T t) {
        return a((Class<? extends b>) t.getClass());
    }

    public int a(int i2, int i3) {
        return !a(i3) ? i2 : e();
    }

    public abstract void a();

    public abstract void a(Parcelable parcelable);

    public abstract void a(String str);

    public void a(boolean z, boolean z2) {
    }

    public abstract void a(byte[] bArr);

    public abstract boolean a(int i2);

    public abstract VersionedParcel b();

    public abstract void b(int i2);

    public void b(byte[] bArr, int i2) {
        b(i2);
        a(bArr);
    }

    public abstract void c(int i2);

    public boolean c() {
        return false;
    }

    public abstract byte[] d();

    public abstract int e();

    public abstract <T extends Parcelable> T f();

    public abstract String g();

    public <T extends b> T h() {
        String g2 = g();
        if (g2 == null) {
            return null;
        }
        return (T) a(g2, b());
    }

    public String a(String str, int i2) {
        return !a(i2) ? str : g();
    }

    public void b(int i2, int i3) {
        b(i3);
        c(i2);
    }

    public byte[] a(byte[] bArr, int i2) {
        return !a(i2) ? bArr : d();
    }

    public void b(String str, int i2) {
        b(i2);
        a(str);
    }

    public <T extends Parcelable> T a(T t, int i2) {
        return !a(i2) ? t : (T) f();
    }

    public void b(Parcelable parcelable, int i2) {
        b(i2);
        a(parcelable);
    }

    public void a(b bVar) {
        if (bVar == null) {
            a((String) null);
            return;
        }
        b(bVar);
        VersionedParcel b2 = b();
        a(bVar, b2);
        b2.a();
    }

    public void b(b bVar, int i2) {
        b(i2);
        a(bVar);
    }

    public final void b(b bVar) {
        try {
            a(a((Class<? extends b>) bVar.getClass()).getName());
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(bVar.getClass().getSimpleName() + " does not have a Parcelizer", e2);
        }
    }

    public <T extends b> T a(T t, int i2) {
        return !a(i2) ? t : (T) h();
    }

    public static <T extends b> T a(String str, VersionedParcel versionedParcel) {
        try {
            return (T) Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class).invoke(null, versionedParcel);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (InvocationTargetException e5) {
            if (e5.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e5.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e5);
        }
    }

    public static <T extends b> void a(T t, VersionedParcel versionedParcel) {
        try {
            c(t).getDeclaredMethod("write", t.getClass(), VersionedParcel.class).invoke(null, t, versionedParcel);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (InvocationTargetException e5) {
            if (e5.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e5.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e5);
        }
    }

    public static Class a(Class<? extends b> cls) {
        return Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
    }
}
