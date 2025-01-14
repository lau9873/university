package c.d.a.a.h;

import c.d.a.a.e.e.a;
import com.google.android.gms.common.api.Scope;
/* loaded from: classes.dex */
public final class u0 {

    /* renamed from: a  reason: collision with root package name */
    public static a.g<h1> f3639a = new a.g<>();

    /* renamed from: b  reason: collision with root package name */
    public static a.g<h1> f3640b = new a.g<>();

    /* renamed from: c  reason: collision with root package name */
    public static final a.b<h1, y0> f3641c = new v0();

    /* renamed from: d  reason: collision with root package name */
    public static a.b<h1, Object> f3642d = new w0();

    /* renamed from: e  reason: collision with root package name */
    public static final c.d.a.a.e.e.a<y0> f3643e;

    static {
        new Scope("profile");
        new Scope("email");
        f3643e = new c.d.a.a.e.e.a<>("SignIn.API", f3641c, f3639a);
        new c.d.a.a.e.e.a("SignIn.INTERNAL_API", f3642d, f3640b);
    }
}
