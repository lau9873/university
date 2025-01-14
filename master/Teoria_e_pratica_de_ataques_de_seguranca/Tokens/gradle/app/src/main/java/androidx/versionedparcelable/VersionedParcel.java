package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import p068b.p069a.VersionedParcelable;

/* loaded from: classes.dex */
public abstract class VersionedParcel {

    /* loaded from: classes.dex */
    public static class ParcelException extends RuntimeException {
    }

    /* renamed from: c */
    public static <T extends VersionedParcelable> Class m6254c(T t) {
        return m6266a((Class<? extends VersionedParcelable>) t.getClass());
    }

    /* renamed from: a */
    public int m6271a(int i, int i2) {
        return !mo6251a(i2) ? i : mo6242e();
    }

    /* renamed from: a */
    public abstract void mo6252a();

    /* renamed from: a */
    public abstract void mo6250a(Parcelable parcelable);

    /* renamed from: a */
    public abstract void mo6249a(String str);

    /* renamed from: a */
    public void m6263a(boolean z, boolean z2) {
    }

    /* renamed from: a */
    public abstract void mo6248a(byte[] bArr);

    /* renamed from: a */
    public abstract boolean mo6251a(int i);

    /* renamed from: b */
    public abstract VersionedParcel mo6247b();

    /* renamed from: b */
    public abstract void mo6246b(int i);

    /* renamed from: b */
    public void m6256b(byte[] bArr, int i) {
        mo6246b(i);
        mo6248a(bArr);
    }

    /* renamed from: c */
    public abstract void mo6245c(int i);

    /* renamed from: c */
    public boolean m6255c() {
        return false;
    }

    /* renamed from: d */
    public abstract byte[] mo6244d();

    /* renamed from: e */
    public abstract int mo6242e();

    /* renamed from: f */
    public abstract <T extends Parcelable> T mo6241f();

    /* renamed from: g */
    public abstract String mo6240g();

    /* renamed from: h */
    public <T extends VersionedParcelable> T m6253h() {
        String mo6240g = mo6240g();
        if (mo6240g == null) {
            return null;
        }
        return (T) m6264a(mo6240g, mo6247b());
    }

    /* renamed from: a */
    public String m6265a(String str, int i) {
        return !mo6251a(i) ? str : mo6240g();
    }

    /* renamed from: b */
    public void m6261b(int i, int i2) {
        mo6246b(i2);
        mo6245c(i);
    }

    /* renamed from: a */
    public byte[] m6262a(byte[] bArr, int i) {
        return !mo6251a(i) ? bArr : mo6244d();
    }

    /* renamed from: b */
    public void m6257b(String str, int i) {
        mo6246b(i);
        mo6249a(str);
    }

    /* renamed from: a */
    public <T extends Parcelable> T m6270a(T t, int i) {
        return !mo6251a(i) ? t : (T) mo6241f();
    }

    /* renamed from: b */
    public void m6260b(Parcelable parcelable, int i) {
        mo6246b(i);
        mo6250a(parcelable);
    }

    /* renamed from: a */
    public void m6269a(VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            mo6249a((String) null);
            return;
        }
        m6259b(versionedParcelable);
        VersionedParcel mo6247b = mo6247b();
        m6267a(versionedParcelable, mo6247b);
        mo6247b.mo6252a();
    }

    /* renamed from: b */
    public void m6258b(VersionedParcelable versionedParcelable, int i) {
        mo6246b(i);
        m6269a(versionedParcelable);
    }

    /* renamed from: b */
    public final void m6259b(VersionedParcelable versionedParcelable) {
        try {
            mo6249a(m6266a((Class<? extends VersionedParcelable>) versionedParcelable.getClass()).getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(versionedParcelable.getClass().getSimpleName() + " does not have a Parcelizer", e);
        }
    }

    /* renamed from: a */
    public <T extends VersionedParcelable> T m6268a(T t, int i) {
        return !mo6251a(i) ? t : (T) m6253h();
    }

    /* renamed from: a */
    public static <T extends VersionedParcelable> T m6264a(String str, VersionedParcel versionedParcel) {
        try {
            return (T) Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class).invoke(null, versionedParcel);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    /* renamed from: a */
    public static <T extends VersionedParcelable> void m6267a(T t, VersionedParcel versionedParcel) {
        try {
            m6254c(t).getDeclaredMethod("write", t.getClass(), VersionedParcel.class).invoke(null, t, versionedParcel);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    /* renamed from: a */
    public static Class m6266a(Class<? extends VersionedParcelable> cls) {
        return Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
    }
}
