package c.a.a;

import c.a.a.a;
import com.android.volley.VolleyError;
/* compiled from: Response.java */
/* loaded from: classes.dex */
public class k<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f2799a;

    /* renamed from: b  reason: collision with root package name */
    public final a.C0051a f2800b;

    /* renamed from: c  reason: collision with root package name */
    public final VolleyError f2801c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2802d;

    /* compiled from: Response.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(VolleyError volleyError);
    }

    /* compiled from: Response.java */
    /* loaded from: classes.dex */
    public interface b<T> {
        void a(T t);
    }

    public k(T t, a.C0051a c0051a) {
        this.f2802d = false;
        this.f2799a = t;
        this.f2800b = c0051a;
        this.f2801c = null;
    }

    public static <T> k<T> a(T t, a.C0051a c0051a) {
        return new k<>(t, c0051a);
    }

    public static <T> k<T> a(VolleyError volleyError) {
        return new k<>(volleyError);
    }

    public boolean a() {
        return this.f2801c == null;
    }

    public k(VolleyError volleyError) {
        this.f2802d = false;
        this.f2799a = null;
        this.f2800b = null;
        this.f2801c = volleyError;
    }
}
