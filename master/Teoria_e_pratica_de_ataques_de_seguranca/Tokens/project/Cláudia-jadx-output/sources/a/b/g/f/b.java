package a.b.g.f;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
/* compiled from: AudioAttributesImplApi21.java */
@TargetApi(21)
/* loaded from: classes.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public AudioAttributes f945a;

    /* renamed from: b  reason: collision with root package name */
    public int f946b = -1;

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f945a.equals(((b) obj).f945a);
        }
        return false;
    }

    public int hashCode() {
        return this.f945a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f945a;
    }
}
