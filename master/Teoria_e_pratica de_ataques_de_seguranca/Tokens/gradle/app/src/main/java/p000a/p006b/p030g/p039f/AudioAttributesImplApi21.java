package p000a.p006b.p030g.p039f;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

@TargetApi(21)
/* renamed from: a.b.g.f.b */
/* loaded from: classes.dex */
public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a */
    public AudioAttributes f1455a;

    /* renamed from: b */
    public int f1456b = -1;

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f1455a.equals(((AudioAttributesImplApi21) obj).f1455a);
        }
        return false;
    }

    public int hashCode() {
        return this.f1455a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f1455a;
    }
}
