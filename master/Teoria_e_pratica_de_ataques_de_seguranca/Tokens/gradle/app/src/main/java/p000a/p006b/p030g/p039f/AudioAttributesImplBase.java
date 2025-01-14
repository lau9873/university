package p000a.p006b.p030g.p039f;

import android.support.p065v4.media.AudioAttributesCompat;
import java.util.Arrays;

/* renamed from: a.b.g.f.c */
/* loaded from: classes.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a */
    public int f1457a = 0;

    /* renamed from: b */
    public int f1458b = 0;

    /* renamed from: c */
    public int f1459c = 0;

    /* renamed from: d */
    public int f1460d = -1;

    /* renamed from: a */
    public int m9829a() {
        return this.f1458b;
    }

    /* renamed from: b */
    public int m9828b() {
        int i = this.f1459c;
        int m9827c = m9827c();
        if (m9827c == 6) {
            i |= 4;
        } else if (m9827c == 7) {
            i |= 1;
        }
        return i & 273;
    }

    /* renamed from: c */
    public int m9827c() {
        int i = this.f1460d;
        return i != -1 ? i : AudioAttributesCompat.m7399a(false, this.f1459c, this.f1457a);
    }

    /* renamed from: d */
    public int m9826d() {
        return this.f1457a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplBase) {
            AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
            return this.f1458b == audioAttributesImplBase.m9829a() && this.f1459c == audioAttributesImplBase.m9828b() && this.f1457a == audioAttributesImplBase.m9826d() && this.f1460d == audioAttributesImplBase.f1460d;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f1458b), Integer.valueOf(this.f1459c), Integer.valueOf(this.f1457a), Integer.valueOf(this.f1460d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f1460d != -1) {
            sb.append(" stream=");
            sb.append(this.f1460d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.m7400a(this.f1457a));
        sb.append(" content=");
        sb.append(this.f1458b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f1459c).toUpperCase());
        return sb.toString();
    }
}
