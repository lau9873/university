package p193g.p194a.p195a.p199n.p200r;

import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;

/* renamed from: g.a.a.n.r.f */
/* loaded from: classes.dex */
public class DistinctPacketDetector {

    /* renamed from: a */
    public final Set<ByteBuffer> f8702a = new HashSet();

    /* renamed from: a */
    public void m2244a() {
        this.f8702a.clear();
    }

    /* renamed from: a */
    public boolean m2243a(String str, byte[] bArr) {
        byte[] bytes = str.getBytes();
        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + bArr.length);
        allocate.put(bytes);
        allocate.put(bArr);
        allocate.rewind();
        if (this.f8702a.size() == 1000) {
            return this.f8702a.contains(allocate);
        }
        return this.f8702a.add(allocate);
    }
}
