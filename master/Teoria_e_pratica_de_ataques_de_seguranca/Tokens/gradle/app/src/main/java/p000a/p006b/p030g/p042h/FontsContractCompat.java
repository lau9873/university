package p000a.p006b.p030g.p042h;

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
import p000a.p006b.p030g.p032b.p033g.FontResourcesParserCompat;
import p000a.p006b.p030g.p032b.p033g.ResourcesCompat;
import p000a.p006b.p030g.p034c.TypefaceCompat;
import p000a.p006b.p030g.p034c.TypefaceCompatUtil;
import p000a.p006b.p030g.p042h.SelfDestructiveThread;
import p000a.p006b.p030g.p044j.LruCache;
import p000a.p006b.p030g.p044j.Preconditions;
import p000a.p006b.p030g.p044j.SimpleArrayMap;

/* renamed from: a.b.g.h.b */
/* loaded from: classes.dex */
public class FontsContractCompat {

    /* renamed from: a */
    public static final LruCache<String, Typeface> f1485a = new LruCache<>(16);

    /* renamed from: b */
    public static final SelfDestructiveThread f1486b = new SelfDestructiveThread("fonts", 10, 10000);

    /* renamed from: c */
    public static final Object f1487c = new Object();

    /* renamed from: d */
    public static final SimpleArrayMap<String, ArrayList<SelfDestructiveThread.InterfaceC0257d<C0252g>>> f1488d = new SimpleArrayMap<>();

    /* renamed from: e */
    public static final Comparator<byte[]> f1489e = new C0249d();

    /* compiled from: FontsContractCompat.java */
    /* renamed from: a.b.g.h.b$a */
    /* loaded from: classes.dex */
    public static class CallableC0246a implements Callable<C0252g> {

        /* renamed from: a */
        public final /* synthetic */ Context f1490a;

        /* renamed from: b */
        public final /* synthetic */ FontRequest f1491b;

        /* renamed from: c */
        public final /* synthetic */ int f1492c;

        /* renamed from: d */
        public final /* synthetic */ String f1493d;

        public CallableC0246a(Context context, FontRequest fontRequest, int i, String str) {
            this.f1490a = context;
            this.f1491b = fontRequest;
            this.f1492c = i;
            this.f1493d = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public C0252g call() {
            C0252g m9728a = FontsContractCompat.m9728a(this.f1490a, this.f1491b, this.f1492c);
            Typeface typeface = m9728a.f1504a;
            if (typeface != null) {
                FontsContractCompat.f1485a.m9651a(this.f1493d, typeface);
            }
            return m9728a;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: a.b.g.h.b$b */
    /* loaded from: classes.dex */
    public static class C0247b implements SelfDestructiveThread.InterfaceC0257d<C0252g> {

        /* renamed from: a */
        public final /* synthetic */ ResourcesCompat.AbstractC0210a f1494a;

        /* renamed from: b */
        public final /* synthetic */ Handler f1495b;

        public C0247b(ResourcesCompat.AbstractC0210a abstractC0210a, Handler handler) {
            this.f1494a = abstractC0210a;
            this.f1495b = handler;
        }

        @Override // p000a.p006b.p030g.p042h.SelfDestructiveThread.InterfaceC0257d
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo9705a(C0252g c0252g) {
            if (c0252g == null) {
                this.f1494a.m9948a(1, this.f1495b);
                return;
            }
            int i = c0252g.f1505b;
            if (i == 0) {
                this.f1494a.m9947a(c0252g.f1504a, this.f1495b);
            } else {
                this.f1494a.m9948a(i, this.f1495b);
            }
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: a.b.g.h.b$c */
    /* loaded from: classes.dex */
    public static class C0248c implements SelfDestructiveThread.InterfaceC0257d<C0252g> {

        /* renamed from: a */
        public final /* synthetic */ String f1496a;

        public C0248c(String str) {
            this.f1496a = str;
        }

        @Override // p000a.p006b.p030g.p042h.SelfDestructiveThread.InterfaceC0257d
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo9705a(C0252g c0252g) {
            synchronized (FontsContractCompat.f1487c) {
                ArrayList<SelfDestructiveThread.InterfaceC0257d<C0252g>> arrayList = FontsContractCompat.f1488d.get(this.f1496a);
                if (arrayList == null) {
                    return;
                }
                FontsContractCompat.f1488d.remove(this.f1496a);
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList.get(i).mo9705a(c0252g);
                }
            }
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: a.b.g.h.b$d */
    /* loaded from: classes.dex */
    public static class C0249d implements Comparator<byte[]> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            int i;
            int i2;
            if (bArr.length != bArr2.length) {
                i = bArr.length;
                i2 = bArr2.length;
            } else {
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    if (bArr[i3] != bArr2[i3]) {
                        i = bArr[i3];
                        i2 = bArr2[i3];
                    }
                }
                return 0;
            }
            return i - i2;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: a.b.g.h.b$e */
    /* loaded from: classes.dex */
    public static class C0250e {

        /* renamed from: a */
        public final int f1497a;

        /* renamed from: b */
        public final C0251f[] f1498b;

        public C0250e(int i, C0251f[] c0251fArr) {
            this.f1497a = i;
            this.f1498b = c0251fArr;
        }

        /* renamed from: a */
        public C0251f[] m9717a() {
            return this.f1498b;
        }

        /* renamed from: b */
        public int m9716b() {
            return this.f1497a;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: a.b.g.h.b$f */
    /* loaded from: classes.dex */
    public static class C0251f {

        /* renamed from: a */
        public final Uri f1499a;

        /* renamed from: b */
        public final int f1500b;

        /* renamed from: c */
        public final int f1501c;

        /* renamed from: d */
        public final boolean f1502d;

        /* renamed from: e */
        public final int f1503e;

        public C0251f(Uri uri, int i, int i2, boolean z, int i3) {
            Preconditions.m9621a(uri);
            this.f1499a = uri;
            this.f1500b = i;
            this.f1501c = i2;
            this.f1502d = z;
            this.f1503e = i3;
        }

        /* renamed from: a */
        public int m9715a() {
            return this.f1503e;
        }

        /* renamed from: b */
        public int m9714b() {
            return this.f1500b;
        }

        /* renamed from: c */
        public Uri m9713c() {
            return this.f1499a;
        }

        /* renamed from: d */
        public int m9712d() {
            return this.f1501c;
        }

        /* renamed from: e */
        public boolean m9711e() {
            return this.f1502d;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: a.b.g.h.b$g */
    /* loaded from: classes.dex */
    public static final class C0252g {

        /* renamed from: a */
        public final Typeface f1504a;

        /* renamed from: b */
        public final int f1505b;

        public C0252g(Typeface typeface, int i) {
            this.f1504a = typeface;
            this.f1505b = i;
        }
    }

    /* renamed from: a */
    public static C0252g m9728a(Context context, FontRequest fontRequest, int i) {
        try {
            C0250e m9725a = m9725a(context, (CancellationSignal) null, fontRequest);
            if (m9725a.m9716b() == 0) {
                Typeface m9907a = TypefaceCompat.m9907a(context, null, m9725a.m9717a(), i);
                return new C0252g(m9907a, m9907a != null ? 0 : -3);
            }
            return new C0252g(null, m9725a.m9716b() == 1 ? -2 : -3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new C0252g(null, -1);
        }
    }

    /* renamed from: a */
    public static Typeface m9727a(Context context, FontRequest fontRequest, ResourcesCompat.AbstractC0210a abstractC0210a, Handler handler, boolean z, int i, int i2) {
        String str = fontRequest.m9733c() + "-" + i2;
        Typeface m9649b = f1485a.m9649b(str);
        if (m9649b != null) {
            if (abstractC0210a != null) {
                abstractC0210a.mo7971a(m9649b);
            }
            return m9649b;
        } else if (z && i == -1) {
            C0252g m9728a = m9728a(context, fontRequest, i2);
            if (abstractC0210a != null) {
                int i3 = m9728a.f1505b;
                if (i3 == 0) {
                    abstractC0210a.m9947a(m9728a.f1504a, handler);
                } else {
                    abstractC0210a.m9948a(i3, handler);
                }
            }
            return m9728a.f1504a;
        } else {
            CallableC0246a callableC0246a = new CallableC0246a(context, fontRequest, i2, str);
            if (z) {
                try {
                    return ((C0252g) f1486b.m9708a(callableC0246a, i)).f1504a;
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            C0247b c0247b = abstractC0210a == null ? null : new C0247b(abstractC0210a, handler);
            synchronized (f1487c) {
                if (f1488d.containsKey(str)) {
                    if (c0247b != null) {
                        f1488d.get(str).add(c0247b);
                    }
                    return null;
                }
                if (c0247b != null) {
                    ArrayList<SelfDestructiveThread.InterfaceC0257d<C0252g>> arrayList = new ArrayList<>();
                    arrayList.add(c0247b);
                    f1488d.put(str, arrayList);
                }
                f1486b.m9707a(callableC0246a, new C0248c(str));
                return null;
            }
        }
    }

    /* renamed from: a */
    public static Map<Uri, ByteBuffer> m9724a(Context context, C0251f[] c0251fArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (C0251f c0251f : c0251fArr) {
            if (c0251f.m9715a() == 0) {
                Uri m9713c = c0251f.m9713c();
                if (!hashMap.containsKey(m9713c)) {
                    hashMap.put(m9713c, TypefaceCompatUtil.m9870a(context, cancellationSignal, m9713c));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    /* renamed from: a */
    public static C0250e m9725a(Context context, CancellationSignal cancellationSignal, FontRequest fontRequest) {
        ProviderInfo m9723a = m9723a(context.getPackageManager(), fontRequest, context.getResources());
        if (m9723a == null) {
            return new C0250e(1, null);
        }
        return new C0250e(0, m9726a(context, fontRequest, m9723a.authority, cancellationSignal));
    }

    /* renamed from: a */
    public static ProviderInfo m9723a(PackageManager packageManager, FontRequest fontRequest, Resources resources) {
        String m9732d = fontRequest.m9732d();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(m9732d, 0);
        if (resolveContentProvider != null) {
            if (resolveContentProvider.packageName.equals(fontRequest.m9731e())) {
                List<byte[]> m9721a = m9721a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
                Collections.sort(m9721a, f1489e);
                List<List<byte[]>> m9729a = m9729a(fontRequest, resources);
                for (int i = 0; i < m9729a.size(); i++) {
                    ArrayList arrayList = new ArrayList(m9729a.get(i));
                    Collections.sort(arrayList, f1489e);
                    if (m9722a(m9721a, arrayList)) {
                        return resolveContentProvider;
                    }
                }
                return null;
            }
            throw new PackageManager.NameNotFoundException("Found content provider " + m9732d + ", but package was not " + fontRequest.m9731e());
        }
        throw new PackageManager.NameNotFoundException("No package found for authority: " + m9732d);
    }

    /* renamed from: a */
    public static List<List<byte[]>> m9729a(FontRequest fontRequest, Resources resources) {
        if (fontRequest.m9735a() != null) {
            return fontRequest.m9735a();
        }
        return FontResourcesParserCompat.m9977a(resources, fontRequest.m9734b());
    }

    /* renamed from: a */
    public static boolean m9722a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static List<byte[]> m9721a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    /* renamed from: a */
    public static C0251f[] m9726a(Context context, FontRequest fontRequest, String str, CancellationSignal cancellationSignal) {
        Uri withAppendedId;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        Cursor cursor = null;
        try {
            if (Build.VERSION.SDK_INT > 16) {
                cursor = context.getContentResolver().query(build, new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX, "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{fontRequest.m9730f()}, null, cancellationSignal);
            } else {
                cursor = context.getContentResolver().query(build, new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX, "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{fontRequest.m9730f()}, null);
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
                    int i = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                    int i2 = columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0;
                    if (columnIndex3 == -1) {
                        withAppendedId = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                    } else {
                        withAppendedId = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                    }
                    arrayList2.add(new C0251f(withAppendedId, i2, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, i));
                }
                arrayList = arrayList2;
            }
            return (C0251f[]) arrayList.toArray(new C0251f[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
