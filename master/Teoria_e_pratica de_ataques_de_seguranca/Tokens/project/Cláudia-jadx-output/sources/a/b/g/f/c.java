package a.b.g.f;

import android.support.v4.media.AudioAttributesCompat;
import java.util.Arrays;
/* compiled from: AudioAttributesImplBase.java */
/* loaded from: classes.dex */
public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public int f947a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f948b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f949c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f950d = -1;

    public int a() {
        return this.f948b;
    }

    public int b() {
        int i2 = this.f949c;
        int c2 = c();
        if (c2 == 6) {
            i2 |= 4;
        } else if (c2 == 7) {
            i2 |= 1;
        }
        return i2 & 273;
    }

    public int c() {
        int i2 = this.f950d;
        return i2 != -1 ? i2 : AudioAttributesCompat.a(false, this.f949c, this.f947a);
    }

    public int d() {
        return this.f947a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.f948b == cVar.a() && this.f949c == cVar.b() && this.f947a == cVar.d() && this.f950d == cVar.f950d;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f948b), Integer.valueOf(this.f949c), Integer.valueOf(this.f947a), Integer.valueOf(this.f950d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f950d != -1) {
            sb.append(" stream=");
            sb.append(this.f950d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.a(this.f947a));
        sb.append(" content=");
        sb.append(this.f948b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f949c).toUpperCase());
        return sb.toString();
    }
}
