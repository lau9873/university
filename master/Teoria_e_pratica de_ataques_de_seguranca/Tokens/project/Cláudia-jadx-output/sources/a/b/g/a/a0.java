package a.b.g.a;

import a.b.g.a.y;
import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* compiled from: NotificationCompatJellybean.java */
/* loaded from: classes.dex */
public class a0 {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f605a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static Field f606b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f607c;

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            Bundle bundle = list.get(i2);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i2, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle a(Notification notification) {
        synchronized (f605a) {
            if (f607c) {
                return null;
            }
            try {
                if (f606b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f607c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f606b = declaredField;
                }
                Bundle bundle = (Bundle) f606b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f606b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f607c = true;
                return null;
            } catch (NoSuchFieldException e3) {
                Log.e("NotificationCompat", "Unable to access notification extras", e3);
                f607c = true;
                return null;
            }
        }
    }

    public static Bundle a(Notification.Builder builder, y.a aVar) {
        builder.addAction(aVar.e(), aVar.i(), aVar.a());
        Bundle bundle = new Bundle(aVar.d());
        if (aVar.f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", a(aVar.f()));
        }
        if (aVar.c() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", a(aVar.c()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        return bundle;
    }

    public static Bundle a(y.a aVar) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putInt("icon", aVar.e());
        bundle2.putCharSequence("title", aVar.i());
        bundle2.putParcelable("actionIntent", aVar.a());
        if (aVar.d() != null) {
            bundle = new Bundle(aVar.d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", a(aVar.f()));
        bundle2.putBoolean("showsUserInterface", aVar.h());
        bundle2.putInt("semanticAction", aVar.g());
        return bundle2;
    }

    public static Bundle a(d0 d0Var) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", d0Var.f());
        bundle.putCharSequence("label", d0Var.e());
        bundle.putCharSequenceArray("choices", d0Var.c());
        bundle.putBoolean("allowFreeFormInput", d0Var.a());
        bundle.putBundle("extras", d0Var.d());
        Set<String> b2 = d0Var.b();
        if (b2 != null && !b2.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(b2.size());
            for (String str : b2) {
                arrayList.add(str);
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    public static Bundle[] a(d0[] d0VarArr) {
        if (d0VarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[d0VarArr.length];
        for (int i2 = 0; i2 < d0VarArr.length; i2++) {
            bundleArr[i2] = a(d0VarArr[i2]);
        }
        return bundleArr;
    }
}
