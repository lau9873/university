package p000a.p006b.p030g.p031a;

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
import p000a.p006b.p030g.p031a.INotificationSideChannel;

/* renamed from: a.b.g.a.b0 */
/* loaded from: classes.dex */
public final class NotificationManagerCompat {

    /* renamed from: d */
    public static String f1022d;

    /* renamed from: g */
    public static ServiceConnectionC0138d f1025g;

    /* renamed from: a */
    public final Context f1026a;

    /* renamed from: b */
    public final NotificationManager f1027b;

    /* renamed from: c */
    public static final Object f1021c = new Object();

    /* renamed from: e */
    public static Set<String> f1023e = new HashSet();

    /* renamed from: f */
    public static final Object f1024f = new Object();

    /* compiled from: NotificationManagerCompat.java */
    /* renamed from: a.b.g.a.b0$a */
    /* loaded from: classes.dex */
    public static class C0135a implements InterfaceC0140e {

        /* renamed from: a */
        public final String f1028a;

        /* renamed from: b */
        public final int f1029b;

        /* renamed from: c */
        public final String f1030c;

        /* renamed from: d */
        public final boolean f1031d = false;

        public C0135a(String str, int i, String str2) {
            this.f1028a = str;
            this.f1029b = i;
            this.f1030c = str2;
        }

        @Override // p000a.p006b.p030g.p031a.NotificationManagerCompat.InterfaceC0140e
        /* renamed from: a */
        public void mo10384a(INotificationSideChannel iNotificationSideChannel) {
            if (this.f1031d) {
                iNotificationSideChannel.mo10079a(this.f1028a);
            } else {
                iNotificationSideChannel.mo10078a(this.f1028a, this.f1029b, this.f1030c);
            }
        }

        public String toString() {
            return "CancelTask[packageName:" + this.f1028a + ", id:" + this.f1029b + ", tag:" + this.f1030c + ", all:" + this.f1031d + "]";
        }
    }

    /* compiled from: NotificationManagerCompat.java */
    /* renamed from: a.b.g.a.b0$b */
    /* loaded from: classes.dex */
    public static class C0136b implements InterfaceC0140e {

        /* renamed from: a */
        public final String f1032a;

        /* renamed from: b */
        public final int f1033b;

        /* renamed from: c */
        public final String f1034c;

        /* renamed from: d */
        public final Notification f1035d;

        public C0136b(String str, int i, String str2, Notification notification) {
            this.f1032a = str;
            this.f1033b = i;
            this.f1034c = str2;
            this.f1035d = notification;
        }

        @Override // p000a.p006b.p030g.p031a.NotificationManagerCompat.InterfaceC0140e
        /* renamed from: a */
        public void mo10384a(INotificationSideChannel iNotificationSideChannel) {
            iNotificationSideChannel.mo10077a(this.f1032a, this.f1033b, this.f1034c, this.f1035d);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.f1032a + ", id:" + this.f1033b + ", tag:" + this.f1034c + "]";
        }
    }

    /* compiled from: NotificationManagerCompat.java */
    /* renamed from: a.b.g.a.b0$c */
    /* loaded from: classes.dex */
    public static class C0137c {

        /* renamed from: a */
        public final ComponentName f1036a;

        /* renamed from: b */
        public final IBinder f1037b;

        public C0137c(ComponentName componentName, IBinder iBinder) {
            this.f1036a = componentName;
            this.f1037b = iBinder;
        }
    }

    /* compiled from: NotificationManagerCompat.java */
    /* renamed from: a.b.g.a.b0$d */
    /* loaded from: classes.dex */
    public static class ServiceConnectionC0138d implements Handler.Callback, ServiceConnection {

        /* renamed from: a */
        public final Context f1038a;

        /* renamed from: c */
        public final Handler f1040c;

        /* renamed from: d */
        public final Map<ComponentName, C0139a> f1041d = new HashMap();

        /* renamed from: e */
        public Set<String> f1042e = new HashSet();

        /* renamed from: b */
        public final HandlerThread f1039b = new HandlerThread("NotificationManagerCompat");

        /* compiled from: NotificationManagerCompat.java */
        /* renamed from: a.b.g.a.b0$d$a */
        /* loaded from: classes.dex */
        public static class C0139a {

            /* renamed from: a */
            public final ComponentName f1043a;

            /* renamed from: c */
            public INotificationSideChannel f1045c;

            /* renamed from: b */
            public boolean f1044b = false;

            /* renamed from: d */
            public ArrayDeque<InterfaceC0140e> f1046d = new ArrayDeque<>();

            /* renamed from: e */
            public int f1047e = 0;

            public C0139a(ComponentName componentName) {
                this.f1043a = componentName;
            }
        }

        public ServiceConnectionC0138d(Context context) {
            this.f1038a = context;
            this.f1039b.start();
            this.f1040c = new Handler(this.f1039b.getLooper(), this);
        }

        /* renamed from: a */
        public final void m10392a(InterfaceC0140e interfaceC0140e) {
            m10394a();
            for (C0139a c0139a : this.f1041d.values()) {
                c0139a.f1046d.add(interfaceC0140e);
                m10386c(c0139a);
            }
        }

        /* renamed from: b */
        public void m10388b(InterfaceC0140e interfaceC0140e) {
            this.f1040c.obtainMessage(0, interfaceC0140e).sendToTarget();
        }

        /* renamed from: c */
        public final void m10386c(C0139a c0139a) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + c0139a.f1043a + ", " + c0139a.f1046d.size() + " queued tasks");
            }
            if (c0139a.f1046d.isEmpty()) {
                return;
            }
            if (m10393a(c0139a) && c0139a.f1045c != null) {
                while (true) {
                    InterfaceC0140e peek = c0139a.f1046d.peek();
                    if (peek == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Sending task " + peek);
                        }
                        peek.mo10384a(c0139a.f1045c);
                        c0139a.f1046d.remove();
                    } catch (DeadObjectException unused) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Remote service has died: " + c0139a.f1043a);
                        }
                    } catch (RemoteException e) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + c0139a.f1043a, e);
                    }
                }
                if (c0139a.f1046d.isEmpty()) {
                    return;
                }
                m10385d(c0139a);
                return;
            }
            m10385d(c0139a);
        }

        /* renamed from: d */
        public final void m10385d(C0139a c0139a) {
            if (this.f1040c.hasMessages(3, c0139a.f1043a)) {
                return;
            }
            c0139a.f1047e++;
            int i = c0139a.f1047e;
            if (i > 6) {
                Log.w("NotifManCompat", "Giving up on delivering " + c0139a.f1046d.size() + " tasks to " + c0139a.f1043a + " after " + c0139a.f1047e + " retries");
                c0139a.f1046d.clear();
                return;
            }
            int i2 = (1 << (i - 1)) * 1000;
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Scheduling retry for " + i2 + " ms");
            }
            this.f1040c.sendMessageDelayed(this.f1040c.obtainMessage(3, c0139a.f1043a), i2);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                m10392a((InterfaceC0140e) message.obj);
                return true;
            } else if (i == 1) {
                C0137c c0137c = (C0137c) message.obj;
                m10390a(c0137c.f1036a, c0137c.f1037b);
                return true;
            } else if (i == 2) {
                m10387b((ComponentName) message.obj);
                return true;
            } else if (i != 3) {
                return false;
            } else {
                m10391a((ComponentName) message.obj);
                return true;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f1040c.obtainMessage(1, new C0137c(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f1040c.obtainMessage(2, componentName).sendToTarget();
        }

        /* renamed from: b */
        public final void m10387b(ComponentName componentName) {
            C0139a c0139a = this.f1041d.get(componentName);
            if (c0139a != null) {
                m10389b(c0139a);
            }
        }

        /* renamed from: b */
        public final void m10389b(C0139a c0139a) {
            if (c0139a.f1044b) {
                this.f1038a.unbindService(this);
                c0139a.f1044b = false;
            }
            c0139a.f1045c = null;
        }

        /* renamed from: a */
        public final void m10390a(ComponentName componentName, IBinder iBinder) {
            C0139a c0139a = this.f1041d.get(componentName);
            if (c0139a != null) {
                c0139a.f1045c = INotificationSideChannel.AbstractBinderC0184a.m10080a(iBinder);
                c0139a.f1047e = 0;
                m10386c(c0139a);
            }
        }

        /* renamed from: a */
        public final void m10391a(ComponentName componentName) {
            C0139a c0139a = this.f1041d.get(componentName);
            if (c0139a != null) {
                m10386c(c0139a);
            }
        }

        /* renamed from: a */
        public final void m10394a() {
            Set<String> m10395b = NotificationManagerCompat.m10395b(this.f1038a);
            if (m10395b.equals(this.f1042e)) {
                return;
            }
            this.f1042e = m10395b;
            List<ResolveInfo> queryIntentServices = this.f1038a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : queryIntentServices) {
                if (m10395b.contains(resolveInfo.serviceInfo.packageName)) {
                    ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.f1041d.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    this.f1041d.put(componentName2, new C0139a(componentName2));
                }
            }
            Iterator<Map.Entry<ComponentName, C0139a>> it = this.f1041d.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<ComponentName, C0139a> next = it.next();
                if (!hashSet.contains(next.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Removing listener record for " + next.getKey());
                    }
                    m10389b(next.getValue());
                    it.remove();
                }
            }
        }

        /* renamed from: a */
        public final boolean m10393a(C0139a c0139a) {
            if (c0139a.f1044b) {
                return true;
            }
            c0139a.f1044b = this.f1038a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(c0139a.f1043a), this, 33);
            if (c0139a.f1044b) {
                c0139a.f1047e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + c0139a.f1043a);
                this.f1038a.unbindService(this);
            }
            return c0139a.f1044b;
        }
    }

    /* compiled from: NotificationManagerCompat.java */
    /* renamed from: a.b.g.a.b0$e */
    /* loaded from: classes.dex */
    public interface InterfaceC0140e {
        /* renamed from: a */
        void mo10384a(INotificationSideChannel iNotificationSideChannel);
    }

    public NotificationManagerCompat(Context context) {
        this.f1026a = context;
        this.f1027b = (NotificationManager) this.f1026a.getSystemService("notification");
    }

    /* renamed from: a */
    public static NotificationManagerCompat m10398a(Context context) {
        return new NotificationManagerCompat(context);
    }

    /* renamed from: b */
    public static Set<String> m10395b(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f1021c) {
            if (string != null) {
                if (!string.equals(f1022d)) {
                    String[] split = string.split(":", -1);
                    HashSet hashSet = new HashSet(split.length);
                    for (String str : split) {
                        ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                        if (unflattenFromString != null) {
                            hashSet.add(unflattenFromString.getPackageName());
                        }
                    }
                    f1023e = hashSet;
                    f1022d = string;
                }
            }
            set = f1023e;
        }
        return set;
    }

    /* renamed from: a */
    public void m10402a(int i) {
        m10397a((String) null, i);
    }

    /* renamed from: a */
    public void m10397a(String str, int i) {
        this.f1027b.cancel(str, i);
        if (Build.VERSION.SDK_INT <= 19) {
            m10400a(new C0135a(this.f1026a.getPackageName(), i, str));
        }
    }

    /* renamed from: a */
    public void m10401a(int i, Notification notification) {
        m10396a(null, i, notification);
    }

    /* renamed from: a */
    public void m10396a(String str, int i, Notification notification) {
        if (m10399a(notification)) {
            m10400a(new C0136b(this.f1026a.getPackageName(), i, str, notification));
            this.f1027b.cancel(str, i);
            return;
        }
        this.f1027b.notify(str, i, notification);
    }

    /* renamed from: a */
    public static boolean m10399a(Notification notification) {
        Bundle m10069a = NotificationCompat.m10069a(notification);
        return m10069a != null && m10069a.getBoolean("android.support.useSideChannel");
    }

    /* renamed from: a */
    public final void m10400a(InterfaceC0140e interfaceC0140e) {
        synchronized (f1024f) {
            if (f1025g == null) {
                f1025g = new ServiceConnectionC0138d(this.f1026a.getApplicationContext());
            }
            f1025g.m10388b(interfaceC0140e);
        }
    }
}
