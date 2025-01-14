package a.b.g.h;

import a.b.g.b.g.f;
import a.b.g.c.i;
import a.b.g.h.c;
import a.b.g.j.m;
import a.b.g.j.n;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import com.j256.ormlite.field.FieldType;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
/* compiled from: FontsContractCompat.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final a.b.g.j.g<String, Typeface> f975a = new a.b.g.j.g<>(16);

    /* renamed from: b  reason: collision with root package name */
    public static final a.b.g.h.c f976b = new a.b.g.h.c("fonts", 10, 10000);

    /* renamed from: c  reason: collision with root package name */
    public static final Object f977c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static final n<String, ArrayList<c.d<g>>> f978d = new n<>();

    /* renamed from: e  reason: collision with root package name */
    public static final Comparator<byte[]> f979e = new d();

    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    public static class a implements Callable<g> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f980a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.b.g.h.a f981b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f982c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f983d;

        public a(Context context, a.b.g.h.a aVar, int i2, String str) {
            this.f980a = context;
            this.f981b = aVar;
            this.f982c = i2;
            this.f983d = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public g call() {
            g a2 = b.a(this.f980a, this.f981b, this.f982c);
            Typeface typeface = a2.f994a;
            if (typeface != null) {
                b.f975a.a(this.f983d, typeface);
            }
            return a2;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: a.b.g.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0027b implements c.d<g> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f.a f984a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Handler f985b;

        public C0027b(f.a aVar, Handler handler) {
            this.f984a = aVar;
            this.f985b = handler;
        }

        @Override // a.b.g.h.c.d
        public void a(g gVar) {
            if (gVar == null) {
                this.f984a.a(1, this.f985b);
                return;
            }
            int i2 = gVar.f995b;
            if (i2 == 0) {
                this.f984a.a(gVar.f994a, this.f985b);
            } else {
                this.f984a.a(i2, this.f985b);
            }
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    public static class c implements c.d<g> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f986a;

        public c(String str) {
            this.f986a = str;
        }

        @Override // a.b.g.h.c.d
        public void a(g gVar) {
            synchronized (b.f977c) {
                ArrayList<c.d<g>> arrayList = b.f978d.get(this.f986a);
                if (arrayList == null) {
                    return;
                }
                b.f978d.remove(this.f986a);
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    arrayList.get(i2).a(gVar);
                }
            }
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    public static class d implements Comparator<byte[]> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            int i2;
            int i3;
            if (bArr.length != bArr2.length) {
                i2 = bArr.length;
                i3 = bArr2.length;
            } else {
                for (int i4 = 0; i4 < bArr.length; i4++) {
                    if (bArr[i4] != bArr2[i4]) {
                        i2 = bArr[i4];
                        i3 = bArr2[i4];
                    }
                }
                return 0;
            }
            return i2 - i3;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final int f987a;

        /* renamed from: b  reason: collision with root package name */
        public final f[] f988b;

        public e(int i2, f[] fVarArr) {
            this.f987a = i2;
            this.f988b = fVarArr;
        }

        public f[] a() {
            return this.f988b;
        }

        public int b() {
            return this.f987a;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f989a;

        /* renamed from: b  reason: collision with root package name */
        public final int f990b;

        /* renamed from: c  reason: collision with root package name */
        public final int f991c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f992d;

        /* renamed from: e  reason: collision with root package name */
        public final int f993e;

        public f(Uri uri, int i2, int i3, boolean z, int i4) {
            m.a(uri);
            this.f989a = uri;
            this.f990b = i2;
            this.f991c = i3;
            this.f992d = z;
            this.f993e = i4;
        }

        public int a() {
            return this.f993e;
        }

        public int b() {
            return this.f990b;
        }

        public Uri c() {
            return this.f989a;
        }

        public int d() {
            return this.f991c;
        }

        public boolean e() {
            return this.f992d;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        public final Typeface f994a;

        /* renamed from: b  reason: collision with root package name */
        public final int f995b;

        public g(Typeface typeface, int i2) {
            this.f994a = typeface;
            this.f995b = i2;
        }
    }

    public static g a(Context context, a.b.g.h.a aVar, int i2) {
        try {
            e a2 = a(context, (CancellationSignal) null, aVar);
            if (a2.b() == 0) {
                Typeface a3 = a.b.g.c.c.a(context, null, a2.a(), i2);
                return new g(a3, a3 != null ? 0 : -3);
            }
            return new g(null, a2.b() == 1 ? -2 : -3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new g(null, -1);
        }
    }

    public static Typeface a(Context context, a.b.g.h.a aVar, f.a aVar2, Handler handler, boolean z, int i2, int i3) {
        String str = aVar.c() + "-" + i3;
        Typeface b2 = f975a.b(str);
        if (b2 != null) {
            if (aVar2 != null) {
                aVar2.a(b2);
            }
            return b2;
        } else if (z && i2 == -1) {
            g a2 = a(context, aVar, i3);
            if (aVar2 != null) {
                int i4 = a2.f995b;
                if (i4 == 0) {
                    aVar2.a(a2.f994a, handler);
                } else {
                    aVar2.a(i4, handler);
                }
            }
            return a2.f994a;
        } else {
            a aVar3 = new a(context, aVar, i3, str);
            if (z) {
                try {
                    return ((g) f976b.a(aVar3, i2)).f994a;
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            C0027b c0027b = aVar2 == null ? null : new C0027b(aVar2, handler);
            synchronized (f977c) {
                if (f978d.containsKey(str)) {
                    if (c0027b != null) {
                        f978d.get(str).add(c0027b);
                    }
                    return null;
                }
                if (c0027b != null) {
                    ArrayList<c.d<g>> arrayList = new ArrayList<>();
                    arrayList.add(c0027b);
                    f978d.put(str, arrayList);
                }
                f976b.a(aVar3, new c(str));
                return null;
            }
        }
    }

    public static Map<Uri, ByteBuffer> a(Context context, f[] fVarArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (f fVar : fVarArr) {
            if (fVar.a() == 0) {
                Uri c2 = fVar.c();
                if (!hashMap.containsKey(c2)) {
                    hashMap.put(c2, i.a(context, cancellationSignal, c2));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public static e a(Context context, CancellationSignal cancellationSignal, a.b.g.h.a aVar) {
        ProviderInfo a2 = a(context.getPackageManager(), aVar, context.getResources());
        if (a2 == null) {
            return new e(1, null);
        }
        return new e(0, a(context, aVar, a2.authority, cancellationSignal));
    }

    public static ProviderInfo a(PackageManager packageManager, a.b.g.h.a aVar, Resources resources) {
        String d2 = aVar.d();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(d2, 0);
        if (resolveContentProvider != null) {
            if (resolveContentProvider.packageName.equals(aVar.e())) {
                List<byte[]> a2 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
                Collections.sort(a2, f979e);
                List<List<byte[]>> a3 = a(aVar, resources);
                for (int i2 = 0; i2 < a3.size(); i2++) {
                    ArrayList arrayList = new ArrayList(a3.get(i2));
                    Collections.sort(arrayList, f979e);
                    if (a(a2, arrayList)) {
                        return resolveContentProvider;
                    }
                }
                return null;
            }
            throw new PackageManager.NameNotFoundException("Found content provider " + d2 + ", but package was not " + aVar.e());
        }
        throw new PackageManager.NameNotFoundException("No package found for authority: " + d2);
    }

    public static List<List<byte[]>> a(a.b.g.h.a aVar, Resources resources) {
        if (aVar.a() != null) {
            return aVar.a();
        }
        return a.b.g.b.g.c.a(resources, aVar.b());
    }

    public static boolean a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!Arrays.equals(list.get(i2), list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    public static f[] a(Context context, a.b.g.h.a aVar, String str, CancellationSignal cancellationSignal) {
        Uri withAppendedId;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        Cursor cursor = null;
        try {
            if (Build.VERSION.SDK_INT > 16) {
                cursor = context.getContentResolver().query(build, new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX, "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.f()}, null, cancellationSignal);
            } else {
                cursor = context.getContentResolver().query(build, new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX, "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.f()}, null);
            }
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex(FieldType.FOREIGN_ID_FIELD_SUFFIX);
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    int i2 = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                    int i3 = columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0;
                    if (columnIndex3 == -1) {
                        withAppendedId = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                    } else {
                        withAppendedId = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                    }
                    arrayList2.add(new f(withAppendedId, i3, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, i2));
                }
                arrayList = arrayList2;
            }
            return (f[]) arrayList.toArray(new f[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
