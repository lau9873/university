package p136d.p137a.p138a.p139a.p140m.p142b;

import android.content.Context;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.p140m.p141a.MemoryValueCache;
import p136d.p137a.p138a.p139a.p140m.p141a.ValueLoader;

/* renamed from: d.a.a.a.m.b.p */
/* loaded from: classes.dex */
public class InstallerPackageNameProvider {

    /* renamed from: a */
    public final ValueLoader<String> f6487a = new C1498a(this);

    /* renamed from: b */
    public final MemoryValueCache<String> f6488b = new MemoryValueCache<>();

    /* compiled from: InstallerPackageNameProvider.java */
    /* renamed from: d.a.a.a.m.b.p$a */
    /* loaded from: classes.dex */
    public class C1498a implements ValueLoader<String> {
        public C1498a(InstallerPackageNameProvider installerPackageNameProvider) {
        }

        @Override // p136d.p137a.p138a.p139a.p140m.p141a.ValueLoader
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public String mo4037a(Context context) {
            String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            return installerPackageName == null ? "" : installerPackageName;
        }
    }

    /* renamed from: a */
    public String m4038a(Context context) {
        try {
            String mo4141a = this.f6488b.mo4141a(context, this.f6487a);
            if ("".equals(mo4141a)) {
                return null;
            }
            return mo4141a;
        } catch (Exception e) {
            Fabric.m4197h().mo4159c("Fabric", "Failed to determine installer package name", e);
            return null;
        }
    }
}
