package p000a.p006b.p030g.p031a;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import p000a.p006b.p030g.p031a.NotificationCompat;

/* renamed from: a.b.g.a.a0 */
/* loaded from: classes.dex */
public class NotificationCompatJellybean {

    /* renamed from: a */
    public static final Object f1018a = new Object();

    /* renamed from: b */
    public static Field f1019b;

    /* renamed from: c */
    public static boolean f1020c;

    /* renamed from: a */
    public static SparseArray<Bundle> m10406a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    /* renamed from: a */
    public static Bundle m10407a(Notification notification) {
        synchronized (f1018a) {
            if (f1020c) {
                return null;
            }
            try {
                if (f1019b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f1020c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f1019b = declaredField;
                }
                Bundle bundle = (Bundle) f1019b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f1019b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                f1020c = true;
                return null;
            } catch (NoSuchFieldException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f1020c = true;
                return null;
            }
        }
    }

    /* renamed from: a */
    public static Bundle m10408a(Notification.Builder builder, NotificationCompat.C0186a c0186a) {
        builder.addAction(c0186a.m10064e(), c0186a.m10060i(), c0186a.m10068a());
        Bundle bundle = new Bundle(c0186a.m10065d());
        if (c0186a.m10063f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", m10405a(c0186a.m10063f()));
        }
        if (c0186a.m10066c() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", m10405a(c0186a.m10066c()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", c0186a.m10067b());
        return bundle;
    }

    /* renamed from: a */
    public static Bundle m10409a(NotificationCompat.C0186a c0186a) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putInt("icon", c0186a.m10064e());
        bundle2.putCharSequence("title", c0186a.m10060i());
        bundle2.putParcelable("actionIntent", c0186a.m10068a());
        if (c0186a.m10065d() != null) {
            bundle = new Bundle(c0186a.m10065d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", c0186a.m10067b());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", m10405a(c0186a.m10063f()));
        bundle2.putBoolean("showsUserInterface", c0186a.m10061h());
        bundle2.putInt("semanticAction", c0186a.m10062g());
        return bundle2;
    }

    /* renamed from: a */
    public static Bundle m10410a(RemoteInput remoteInput) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", remoteInput.m10354f());
        bundle.putCharSequence("label", remoteInput.m10355e());
        bundle.putCharSequenceArray("choices", remoteInput.m10357c());
        bundle.putBoolean("allowFreeFormInput", remoteInput.m10361a());
        bundle.putBundle("extras", remoteInput.m10356d());
        Set<String> m10358b = remoteInput.m10358b();
        if (m10358b != null && !m10358b.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(m10358b.size());
            for (String str : m10358b) {
                arrayList.add(str);
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    /* renamed from: a */
    public static Bundle[] m10405a(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            bundleArr[i] = m10410a(remoteInputArr[i]);
        }
        return bundleArr;
    }
}
