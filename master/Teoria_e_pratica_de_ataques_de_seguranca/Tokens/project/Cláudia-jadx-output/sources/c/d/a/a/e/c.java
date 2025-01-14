package c.d.a.a.e;

import a.b.g.a.g;
import a.b.g.a.y;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import c.d.a.a.e.e.l.a1;
import c.d.a.a.e.e.l.u0;
import c.d.a.a.e.e.l.v0;
import c.d.a.a.e.f.c0;
import c.d.a.a.e.f.x0;
import c.d.a.a.e.f.y0;
import c.d.a.a.e.h.e;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiActivity;
/* loaded from: classes.dex */
public class c extends m {

    /* renamed from: d  reason: collision with root package name */
    public static final Object f3219d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static final c f3220e = new c();

    /* renamed from: c  reason: collision with root package name */
    public String f3221c;

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    public class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final Context f3222a;

        public a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f3222a = context.getApplicationContext();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 1) {
                StringBuilder sb = new StringBuilder(50);
                sb.append("Don't know how to handle this message: ");
                sb.append(i2);
                Log.w("GoogleApiAvailability", sb.toString());
                return;
            }
            int a2 = c.this.a(this.f3222a);
            if (c.this.b(a2)) {
                c.this.c(this.f3222a, a2);
            }
        }
    }

    public static Dialog a(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(x0.c(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        a(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    public static Dialog a(Context context, int i2, y0 y0Var, DialogInterface.OnCancelListener onCancelListener) {
        if (i2 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(x0.c(context, i2));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String e2 = x0.e(context, i2);
        if (e2 != null) {
            builder.setPositiveButton(e2, y0Var);
        }
        String a2 = x0.a(context, i2);
        if (a2 != null) {
            builder.setTitle(a2);
        }
        return builder.create();
    }

    public static u0 a(Context context, v0 v0Var) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        u0 u0Var = new u0(v0Var);
        context.registerReceiver(u0Var, intentFilter);
        u0Var.a(context);
        if (u.zzr(context, "com.google.android.gms")) {
            return u0Var;
        }
        v0Var.a();
        u0Var.a();
        return null;
    }

    public static void a(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof g) {
            d.a(dialog, onCancelListener).a(((g) activity).f(), str);
            return;
        }
        b.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    public static c c() {
        return f3220e;
    }

    @Override // c.d.a.a.e.m
    public int a(Context context) {
        return super.a(context);
    }

    public Dialog a(Activity activity, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        return a(activity, i2, y0.a(activity, m.a(activity, i2, "d"), i3), onCancelListener);
    }

    @Override // c.d.a.a.e.m
    public PendingIntent a(Context context, int i2, int i3) {
        return super.a(context, i2, i3);
    }

    public PendingIntent a(Context context, c.d.a.a.e.a aVar) {
        return aVar.e() ? aVar.d() : a(context, aVar.b(), 0);
    }

    @Override // c.d.a.a.e.m
    public final String a(int i2) {
        return super.a(i2);
    }

    @TargetApi(26)
    public final String a(Context context, NotificationManager notificationManager) {
        c0.b(e.b());
        String b2 = b();
        if (b2 == null) {
            b2 = "com.google.android.gms.availability";
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
            String b3 = x0.b(context);
            if (notificationChannel == null) {
                notificationChannel = new NotificationChannel("com.google.android.gms.availability", b3, 4);
            } else if (!b3.equals(notificationChannel.getName())) {
                notificationChannel.setName(b3);
            }
            notificationManager.createNotificationChannel(notificationChannel);
        }
        return b2;
    }

    @TargetApi(20)
    public final void a(Context context, int i2, String str, PendingIntent pendingIntent) {
        Notification a2;
        int i3;
        if (i2 == 18) {
            c(context);
        } else if (pendingIntent == null) {
            if (i2 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
            }
        } else {
            String b2 = x0.b(context, i2);
            String d2 = x0.d(context, i2);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (c.d.a.a.e.h.d.b(context)) {
                c0.b(e.g());
                Notification.Builder addAction = new Notification.Builder(context).setSmallIcon(context.getApplicationInfo().icon).setPriority(2).setAutoCancel(true).setContentTitle(b2).setStyle(new Notification.BigTextStyle().bigText(d2)).addAction(c.d.a.a.a.common_full_open_on_phone, resources.getString(c.d.a.a.b.common_open_on_phone), pendingIntent);
                if (e.b() && e.b()) {
                    addAction.setChannelId(a(context, notificationManager));
                }
                a2 = addAction.build();
            } else {
                y.c cVar = new y.c(context);
                cVar.c(17301642);
                cVar.c((CharSequence) resources.getString(c.d.a.a.b.common_google_play_services_notification_ticker));
                cVar.a(System.currentTimeMillis());
                cVar.a(true);
                cVar.a(pendingIntent);
                cVar.b((CharSequence) b2);
                cVar.a((CharSequence) d2);
                cVar.b(true);
                y.b bVar = new y.b();
                bVar.a(d2);
                cVar.a(bVar);
                if (e.b() && e.b()) {
                    cVar.b(a(context, notificationManager));
                }
                a2 = cVar.a();
            }
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                i3 = 10436;
                u.zzfrv.set(false);
            } else {
                i3 = 39789;
            }
            notificationManager.notify(i3, a2);
        }
    }

    public final boolean a(Activity activity, a1 a1Var, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        Dialog a2 = a(activity, i2, y0.a(a1Var, m.a(activity, i2, "d"), 2), onCancelListener);
        if (a2 == null) {
            return false;
        }
        a(activity, a2, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    public final boolean a(Context context, c.d.a.a.e.a aVar, int i2) {
        PendingIntent a2 = a(context, aVar);
        if (a2 != null) {
            a(context, aVar.b(), (String) null, GoogleApiActivity.a(context, a2, i2));
            return true;
        }
        return false;
    }

    public final String b() {
        String str;
        synchronized (f3219d) {
            str = this.f3221c;
        }
        return str;
    }

    @Override // c.d.a.a.e.m
    public final boolean b(int i2) {
        return super.b(i2);
    }

    public boolean b(Activity activity, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        Dialog a2 = a(activity, i2, i3, onCancelListener);
        if (a2 == null) {
            return false;
        }
        a(activity, a2, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    public final void c(Context context) {
        new a(context).sendEmptyMessageDelayed(1, 120000L);
    }

    public void c(Context context, int i2) {
        a(context, i2, (String) null, a(context, i2, 0, "n"));
    }
}
