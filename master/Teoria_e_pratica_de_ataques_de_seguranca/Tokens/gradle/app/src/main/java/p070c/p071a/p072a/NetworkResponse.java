package p070c.p071a.p072a;

import com.j256.ormlite.android.AndroidLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: c.a.a.h */
/* loaded from: classes.dex */
public class NetworkResponse {

    /* renamed from: a */
    public final byte[] f4559a;

    /* renamed from: b */
    public final Map<String, String> f4560b;

    /* renamed from: c */
    public final List<Header> f4561c;

    /* renamed from: d */
    public final boolean f4562d;

    @Deprecated
    public NetworkResponse(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this(i, bArr, map, m6221a(map), z, j);
    }

    /* renamed from: a */
    public static Map<String, String> m6222a(List<Header> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Header header : list) {
            treeMap.put(header.m6229a(), header.m6228b());
        }
        return treeMap;
    }

    public NetworkResponse(int i, byte[] bArr, boolean z, long j, List<Header> list) {
        this(i, bArr, m6222a(list), list, z, j);
    }

    @Deprecated
    public NetworkResponse(byte[] bArr, Map<String, String> map) {
        this((int) AndroidLog.REFRESH_LEVEL_CACHE_EVERY, bArr, map, false, 0L);
    }

    public NetworkResponse(int i, byte[] bArr, Map<String, String> map, List<Header> list, boolean z, long j) {
        this.f4559a = bArr;
        this.f4560b = map;
        if (list == null) {
            this.f4561c = null;
        } else {
            this.f4561c = Collections.unmodifiableList(list);
        }
        this.f4562d = z;
    }

    /* renamed from: a */
    public static List<Header> m6221a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new Header(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }
}
