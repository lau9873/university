package a.b.g.a;

import a.b.g.a.u;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* compiled from: NotificationManagerCompat.java */
/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: d  reason: collision with root package name */
    public static String f609d;

    /* renamed from: g  reason: collision with root package name */
    public static d f612g;

    /* renamed from: a  reason: collision with root package name */
    public final Context f613a;

    /* renamed from: b  reason: collision with root package name */
    public final NotificationManager f614b;

    /* renamed from: c  reason: collision with root package name */
    public static final Object f608c = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static Set<String> f610e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    public static final Object f611f = new Object();

    /* compiled from: NotificationManagerCompat.java */
    /* loaded from: classes.dex */
    public static class a implements e {

        /* renamed from: a  reason: collision with root package name */
        public final String f615a;

        /* renamed from: b  reason: collision with root package name */
        public final int f616b;

        /* renamed from: c  reason: collision with root package name */
        public final String f617c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f618d = false;

        public a(String str, int i2, String str2) {
            this.f615a = str;
            this.f616b = i2;
            this.f617c = str2;
        }

        @Override // a.b.g.a.b0.e
        public void a(u uVar) {
            if (this.f618d) {
                uVar.a(this.f615a);
            } else {
                uVar.a(this.f615a, this.f616b, this.f617c);
            }
        }

        public String toString() {
            return "CancelTask[packageName:" + this.f615a + ", id:" + this.f616b + ", tag:" + this.f617c + ", all:" + this.f618d + "]";
        }
    }

    /* compiled from: NotificationManagerCompat.java */
    /* loaded from: classes.dex */
    public static class b implements e {

        /* renamed from: a  reason: collision with root package name */
        public final String f619a;

        /* renamed from: b  reason: collision with root package name */
        public final int f620b;

        /* renamed from: c  reason: collision with root package name */
        public final String f621c;

        /* renamed from: d  reason: collision with root package name */
        public final Notification f622d;

        public b(String str, int i2, String str2, Notification notification) {
            this.f619a = str;
            this.f620b = i2;
            this.f621c = str2;
            this.f622d = notification;
        }

        @Override // a.b.g.a.b0.e
        public void a(u uVar) {
            uVar.a(this.f619a, this.f620b, this.f621c, this.f622d);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.f619a + ", id:" + this.f620b + ", tag:" + this.f621c + "]";
        }
    }

    /* compiled from: NotificationManagerCompat.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final ComponentName f623a;

        /* renamed from: b  reason: collision with root package name */
        public final IBinder f624b;

        public c(ComponentName componentName, IBinder iBinder) {
            this.f623a = componentName;
            this.f624b = iBinder;
        }
    }

    /* compiled from: NotificationManagerCompat.java */
    /* loaded from: classes.dex */
    public static class d implements Handler.Callback, ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final Context f625a;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f627c;

        /* renamed from: d  reason: collision with root package name */
        public final Map<ComponentName, a> f628d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        public Set<String> f629e = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        public final HandlerThread f626b = new HandlerThread("NotificationManagerCompat");

        /* compiled from: NotificationManagerCompat.java */
        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public final ComponentName f630a;

            /* renamed from: c  reason: collision with root package name */
            public u f632c;

            /* renamed from: b  reason: collision with root package name */
            public boolean f631b = false;

            /* renamed from: d  reason: collision with root package name */
            public ArrayDeque<e> f633d = new ArrayDeque<>();

            /* renamed from: e  reason: collision with root package name */
            public int f634e = 0;

            public a(ComponentName componentName) {
                this.f630a = componentName;
            }
        }

        public d(Context context) {
            this.f625a = context;
            this.f626b.start();
            this.f627c = new Handler(this.f626b.getLooper(), this);
        }

        public final void a(e eVar) {
            a();
            for (a aVar : this.f628d.values()) {
                aVar.f633d.add(eVar);
                c(aVar);
            }
        }

        public void b(e eVar) {
            this.f627c.obtainMessage(0, eVar).sendToTarget();
        }

        public final void c(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.f630a + ", " + aVar.f633d.size() + " queued tasks");
            }
            if (aVar.f633d.isEmpty()) {
                return;
            }
            if (a(aVar) && aVar.f632c != null) {
                while (true) {
                    e peek = aVar.f633d.peek();
                    if (peek == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Sending task " + peek);
                        }
                        peek.a(aVar.f632c);
                        aVar.f633d.remove();
                    } catch (DeadObjectException unused) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Remote service has died: " + aVar.f630a);
                        }
                    } catch (RemoteException e2) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f630a, e2);
                    }
                }
                if (aVar.f633d.isEmpty()) {
                    return;
                }
                d(aVar);
                return;
            }
            d(aVar);
        }

        public final void d(a aVar) {
            if (this.f627c.hasMessages(3, aVar.f630a)) {
                return;
            }
            aVar.f634e++;
            int i2 = aVar.f634e;
            if (i2 > 6) {
                Log.w("NotifManCompat", "Giving up on delivering " + aVar.f633d.size() + " tasks to " + aVar.f630a + " after " + aVar.f634e + " retries");
                aVar.f633d.clear();
                return;
            }
            int i3 = (1 << (i2 - 1)) * 1000;
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Scheduling retry for " + i3 + " ms");
            }
            this.f627c.sendMessageDelayed(this.f627c.obtainMessage(3, aVar.f630a), i3);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                a((e) message.obj);
                return true;
            } else if (i2 == 1) {
                c cVar = (c) message.obj;
                a(cVar.f623a, cVar.f624b);
                return true;
            } else if (i2 == 2) {
                b((ComponentName) message.obj);
                return true;
            } else if (i2 != 3) {
                return false;
            } else {
                a((ComponentName) message.obj);
                return true;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f627c.obtainMessage(1, new c(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f627c.obtainMessage(2, componentName).sendToTarget();
        }

        public final void b(ComponentName componentName) {
            a aVar = this.f628d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        public final void b(a aVar) {
            if (aVar.f631b) {
                this.f625a.unbindService(this);
                aVar.f631b = false;
            }
            aVar.f632c = null;
        }

        public final void a(ComponentName componentName, IBinder iBinder) {
            a aVar = this.f628d.get(componentName);
            if (aVar != null) {
                aVar.f632c = u.a.a(iBinder);
                aVar.f634e = 0;
                c(aVar);
            }
        }

        public final void a(ComponentName componentName) {
            a aVar = this.f628d.get(componentName);
            if (aVar != null) {
                c(aVar);
            }
        }

        public final void a() {
            Set<String> b2 = b0.b(this.f625a);
            if (b2.equals(this.f629e)) {
                return;
            }
            this.f629e = b2;
            List<ResolveInfo> queryIntentServices = this.f625a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : queryIntentServices) {
                if (b2.contains(resolveInfo.serviceInfo.packageName)) {
                    ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.f628d.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    this.f628d.put(componentName2, new a(componentName2));
                }
            }
            Iterator<Map.Entry<ComponentName, a>> it = this.f628d.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<ComponentName, a> next = it.next();
                if (!hashSet.contains(next.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Removing listener record for " + next.getKey());
                    }
                    b(next.getValue());
                    it.remove();
                }
            }
        }

        public final boolean a(a aVar) {
            if (aVar.f631b) {
                return true;
            }
            aVar.f631b = this.f625a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f630a), this, 33);
            if (aVar.f631b) {
                aVar.f634e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f630a);
                this.f625a.unbindService(this);
            }
            return aVar.f631b;
        }
    }

    /* compiled from: NotificationManagerCompat.java */
    /* loaded from: classes.dex */
    public interface e {
        void a(u uVar);
    }

    public b0(Context context) {
        this.f613a = context;
        this.f614b = (NotificationManager) this.f613a.getSystemService("notification");
    }

    public static b0 a(Context context) {
        return new b0(context);
    }

    public static Set<String> b(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f608c) {
            if (string != null) {
                if (!string.equals(f609d)) {
                    String[] split = string.split(":", -1);
                    HashSet hashSet = new HashSet(split.length);
                    for (String str : split) {
                        ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                        if (unflattenFromString != null) {
                            hashSet.add(unflattenFromString.getPackageName());
                        }
                    }
                    f610e = hashSet;
                    f609d = string;
                }
            }
            set = f610e;
        }
        return set;
    }

    public void a(int i2) {
        a((String) null, i2);
    }

    public void a(String str, int i2) {
        this.f614b.cancel(str, i2);
        if (Build.VERSION.SDK_INT <= 19) {
            a(new a(this.f613a.getPackageName(), i2, str));
        }
    }

    public void a(int i2, Notification notification) {
        a(null, i2, notification);
    }

    public void a(String str, int i2, Notification notification) {
        if (a(notification)) {
            a(new b(this.f613a.getPackageName(), i2, str, notification));
            this.f614b.cancel(str, i2);
            return;
        }
        this.f614b.notify(str, i2, notification);
    }

    public static boolean a(Notification notification) {
        Bundle a2 = y.a(notification);
        return a2 != null && a2.getBoolean("android.support.useSideChannel");
    }

    public final void a(e eVar) {
        synchronized (f611f) {
            if (f612g == null) {
                f612g = new d(this.f613a.getApplicationContext());
            }
            f612g.b(eVar);
        }
    }
}
