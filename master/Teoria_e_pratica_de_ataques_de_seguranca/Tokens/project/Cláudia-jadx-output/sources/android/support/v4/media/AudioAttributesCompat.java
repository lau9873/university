package android.support.v4.media;

import a.b.g.f.a;
import android.util.SparseIntArray;
import b.a.b;
/* loaded from: classes.dex */
public class AudioAttributesCompat implements b {

    /* renamed from: b  reason: collision with root package name */
    public static final SparseIntArray f2290b = new SparseIntArray();

    /* renamed from: a  reason: collision with root package name */
    public a f2291a;

    static {
        f2290b.put(5, 1);
        f2290b.put(6, 2);
        f2290b.put(7, 2);
        f2290b.put(8, 1);
        f2290b.put(9, 1);
        f2290b.put(10, 1);
    }

    public static String a(int i2) {
        switch (i2) {
            case 0:
                return "USAGE_UNKNOWN";
            case 1:
                return "USAGE_MEDIA";
            case 2:
                return "USAGE_VOICE_COMMUNICATION";
            case 3:
                return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
            case 4:
                return "USAGE_ALARM";
            case 5:
                return "USAGE_NOTIFICATION";
            case 6:
                return "USAGE_NOTIFICATION_RINGTONE";
            case 7:
                return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
            case 8:
                return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
            case 9:
                return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
            case 10:
                return "USAGE_NOTIFICATION_EVENT";
            case 11:
                return "USAGE_ASSISTANCE_ACCESSIBILITY";
            case 12:
                return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
            case 13:
                return "USAGE_ASSISTANCE_SONIFICATION";
            case 14:
                return "USAGE_GAME";
            case 15:
            default:
                return "unknown usage " + i2;
            case 16:
                return "USAGE_ASSISTANT";
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesCompat) {
            AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
            a aVar = this.f2291a;
            if (aVar == null) {
                return audioAttributesCompat.f2291a == null;
            }
            return aVar.equals(audioAttributesCompat.f2291a);
        }
        return false;
    }

    public int hashCode() {
        return this.f2291a.hashCode();
    }

    public String toString() {
        return this.f2291a.toString();
    }

    public static int a(boolean z, int i2, int i3) {
        if ((i2 & 1) == 1) {
            return z ? 1 : 7;
        } else if ((i2 & 4) == 4) {
            return z ? 0 : 6;
        } else {
            switch (i3) {
                case 0:
                    return z ? Integer.MIN_VALUE : 3;
                case 1:
                case 12:
                case 14:
                case 16:
                    return 3;
                case 2:
                    return 0;
                case 3:
                    return z ? 0 : 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                case 11:
                    return 10;
                case 13:
                    return 1;
                case 15:
                default:
                    if (z) {
                        throw new IllegalArgumentException("Unknown usage value " + i3 + " in audio attributes");
                    }
                    return 3;
            }
        }
    }
}
