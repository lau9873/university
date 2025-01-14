package g.a.a.n.r;

import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;
/* compiled from: DistinctPacketDetector.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final Set<ByteBuffer> f6211a = new HashSet();

    public void a() {
        this.f6211a.clear();
    }

    public boolean a(String str, byte[] bArr) {
        byte[] bytes = str.getBytes();
        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + bArr.length);
        allocate.put(bytes);
        allocate.put(bArr);
        allocate.rewind();
        if (this.f6211a.size() == 1000) {
            return this.f6211a.contains(allocate);
        }
        return this.f6211a.add(allocate);
    }
}
