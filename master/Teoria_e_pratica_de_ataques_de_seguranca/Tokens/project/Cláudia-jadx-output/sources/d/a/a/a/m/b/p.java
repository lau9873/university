package d.a.a.a.m.b;

import android.content.Context;
/* compiled from: InstallerPackageNameProvider.java */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final d.a.a.a.m.a.d<String> f4288a = new a(this);

    /* renamed from: b  reason: collision with root package name */
    public final d.a.a.a.m.a.b<String> f4289b = new d.a.a.a.m.a.b<>();

    /* compiled from: InstallerPackageNameProvider.java */
    /* loaded from: classes.dex */
    public class a implements d.a.a.a.m.a.d<String> {
        public a(p pVar) {
        }

        @Override // d.a.a.a.m.a.d
        public String a(Context context) {
            String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            return installerPackageName == null ? "" : installerPackageName;
        }
    }

    public String a(Context context) {
        try {
            String a2 = this.f4289b.a(context, this.f4288a);
            if ("".equals(a2)) {
                return null;
            }
            return a2;
        } catch (Exception e2) {
            d.a.a.a.c.h().c("Fabric", "Failed to determine installer package name", e2);
            return null;
        }
    }
}
