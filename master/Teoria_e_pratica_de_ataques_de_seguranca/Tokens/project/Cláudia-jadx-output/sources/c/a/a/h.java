package c.a.a;

import com.j256.ormlite.android.AndroidLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* compiled from: NetworkResponse.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f2769a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, String> f2770b;

    /* renamed from: c  reason: collision with root package name */
    public final List<e> f2771c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f2772d;

    @Deprecated
    public h(int i2, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this(i2, bArr, map, a(map), z, j);
    }

    public static Map<String, String> a(List<e> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (e eVar : list) {
            treeMap.put(eVar.a(), eVar.b());
        }
        return treeMap;
    }

    public h(int i2, byte[] bArr, boolean z, long j, List<e> list) {
        this(i2, bArr, a(list), list, z, j);
    }

    @Deprecated
    public h(byte[] bArr, Map<String, String> map) {
        this((int) AndroidLog.REFRESH_LEVEL_CACHE_EVERY, bArr, map, false, 0L);
    }

    public h(int i2, byte[] bArr, Map<String, String> map, List<e> list, boolean z, long j) {
        this.f2769a = bArr;
        this.f2770b = map;
        if (list == null) {
            this.f2771c = null;
        } else {
            this.f2771c = Collections.unmodifiableList(list);
        }
        this.f2772d = z;
    }

    public static List<e> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new e(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }
}
