package p070c.p084d.p085a.p086a.p093e;

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
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiActivity;
import p000a.p006b.p030g.p031a.FragmentActivity;
import p000a.p006b.p030g.p031a.NotificationCompat;
import p070c.p084d.p085a.p086a.C0893a;
import p070c.p084d.p085a.p086a.C0894b;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.AbstractC1019v0;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.C1015u0;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0935a1;
import p070c.p084d.p085a.p086a.p093e.p096f.AbstractDialogInterface$OnClickListenerC1094y0;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;
import p070c.p084d.p085a.p086a.p093e.p096f.C1092x0;
import p070c.p084d.p085a.p086a.p093e.p098h.C1101d;
import p070c.p084d.p085a.p086a.p093e.p098h.C1102e;

/* renamed from: c.d.a.a.e.c */
/* loaded from: classes.dex */
public class C0902c extends C1109m {

    /* renamed from: d */
    public static final Object f5057d = new Object();

    /* renamed from: e */
    public static final C0902c f5058e = new C0902c();

    /* renamed from: c */
    public String f5059c;

    @SuppressLint({"HandlerLeak"})
    /* renamed from: c.d.a.a.e.c$a */
    /* loaded from: classes.dex */
    public class HandlerC0903a extends Handler {

        /* renamed from: a */
        public final Context f5060a;

        public HandlerC0903a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f5060a = context.getApplicationContext();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                StringBuilder sb = new StringBuilder(50);
                sb.append("Don't know how to handle this message: ");
                sb.append(i);
                Log.w("GoogleApiAvailability", sb.toString());
                return;
            }
            int mo5123a = C0902c.this.mo5123a(this.f5060a);
            if (C0902c.this.mo5117b(mo5123a)) {
                C0902c.this.m5625c(this.f5060a, mo5123a);
            }
        }
    }

    /* renamed from: a */
    public static Dialog m5637a(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(C1092x0.m5158c(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        m5638a(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    /* renamed from: a */
    public static Dialog m5635a(Context context, int i, AbstractDialogInterface$OnClickListenerC1094y0 abstractDialogInterface$OnClickListenerC1094y0, DialogInterface.OnCancelListener onCancelListener) {
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(C1092x0.m5158c(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String m5156e = C1092x0.m5156e(context, i);
        if (m5156e != null) {
            builder.setPositiveButton(m5156e, abstractDialogInterface$OnClickListenerC1094y0);
        }
        String m5163a = C1092x0.m5163a(context, i);
        if (m5163a != null) {
            builder.setTitle(m5163a);
        }
        return builder.create();
    }

    /* renamed from: a */
    public static C1015u0 m5630a(Context context, AbstractC1019v0 abstractC1019v0) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        C1015u0 c1015u0 = new C1015u0(abstractC1019v0);
        context.registerReceiver(c1015u0, intentFilter);
        c1015u0.m5366a(context);
        if (C1117u.zzr(context, "com.google.android.gms")) {
            return c1015u0;
        }
        abstractC1019v0.mo5343a();
        c1015u0.m5367a();
        return null;
    }

    /* renamed from: a */
    public static void m5638a(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof FragmentActivity) {
            C0904d.m5623a(dialog, onCancelListener).mo5624a(((FragmentActivity) activity).m10333f(), str);
            return;
        }
        DialogFragmentC0901b.m5640a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    /* renamed from: c */
    public static C0902c m5627c() {
        return f5058e;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.C1109m
    /* renamed from: a */
    public int mo5123a(Context context) {
        return super.mo5123a(context);
    }

    /* renamed from: a */
    public Dialog m5639a(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return m5635a(activity, i, AbstractDialogInterface$OnClickListenerC1094y0.m5153a(activity, C1109m.m5119a(activity, i, "d"), i2), onCancelListener);
    }

    @Override // p070c.p084d.p085a.p086a.p093e.C1109m
    /* renamed from: a */
    public PendingIntent mo5121a(Context context, int i, int i2) {
        return super.mo5121a(context, i, i2);
    }

    /* renamed from: a */
    public PendingIntent m5632a(Context context, C0900a c0900a) {
        return c0900a.m5642e() ? c0900a.m5643d() : mo5121a(context, c0900a.m5645b(), 0);
    }

    @Override // p070c.p084d.p085a.p086a.p093e.C1109m
    /* renamed from: a */
    public final String mo5124a(int i) {
        return super.mo5124a(i);
    }

    @TargetApi(26)
    /* renamed from: a */
    public final String m5633a(Context context, NotificationManager notificationManager) {
        C1049c0.m5286b(C1102e.m5136b());
        String m5629b = m5629b();
        if (m5629b == null) {
            m5629b = "com.google.android.gms.availability";
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
            String m5160b = C1092x0.m5160b(context);
            if (notificationChannel == null) {
                notificationChannel = new NotificationChannel("com.google.android.gms.availability", m5160b, 4);
            } else if (!m5160b.equals(notificationChannel.getName())) {
                notificationChannel.setName(m5160b);
            }
            notificationManager.createNotificationChannel(notificationChannel);
        }
        return m5629b;
    }

    @TargetApi(20)
    /* renamed from: a */
    public final void m5634a(Context context, int i, String str, PendingIntent pendingIntent) {
        Notification m10057a;
        int i2;
        if (i == 18) {
            m5626c(context);
        } else if (pendingIntent == null) {
            if (i == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
            }
        } else {
            String m5159b = C1092x0.m5159b(context, i);
            String m5157d = C1092x0.m5157d(context, i);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (C1101d.m5140b(context)) {
                C1049c0.m5286b(C1102e.m5131g());
                Notification.Builder addAction = new Notification.Builder(context).setSmallIcon(context.getApplicationInfo().icon).setPriority(2).setAutoCancel(true).setContentTitle(m5159b).setStyle(new Notification.BigTextStyle().bigText(m5157d)).addAction(C0893a.common_full_open_on_phone, resources.getString(C0894b.common_open_on_phone), pendingIntent);
                if (C1102e.m5136b() && C1102e.m5136b()) {
                    addAction.setChannelId(m5633a(context, notificationManager));
                }
                m10057a = addAction.build();
            } else {
                NotificationCompat.C0189c c0189c = new NotificationCompat.C0189c(context);
                c0189c.m10041c(17301642);
                c0189c.m10040c((CharSequence) resources.getString(C0894b.common_google_play_services_notification_ticker));
                c0189c.m10054a(System.currentTimeMillis());
                c0189c.m10048a(true);
                c0189c.m10051a(pendingIntent);
                c0189c.m10044b((CharSequence) m5159b);
                c0189c.m10050a((CharSequence) m5157d);
                c0189c.m10042b(true);
                NotificationCompat.C0188b c0188b = new NotificationCompat.C0188b();
                c0188b.m10058a(m5157d);
                c0189c.m10052a(c0188b);
                if (C1102e.m5136b() && C1102e.m5136b()) {
                    c0189c.m10043b(m5633a(context, notificationManager));
                }
                m10057a = c0189c.m10057a();
            }
            if (i == 1 || i == 2 || i == 3) {
                i2 = 10436;
                C1117u.zzfrv.set(false);
            } else {
                i2 = 39789;
            }
            notificationManager.notify(i2, m10057a);
        }
    }

    /* renamed from: a */
    public final boolean m5636a(Activity activity, InterfaceC0935a1 interfaceC0935a1, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog m5635a = m5635a(activity, i, AbstractDialogInterface$OnClickListenerC1094y0.m5151a(interfaceC0935a1, C1109m.m5119a(activity, i, "d"), 2), onCancelListener);
        if (m5635a == null) {
            return false;
        }
        m5638a(activity, m5635a, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    /* renamed from: a */
    public final boolean m5631a(Context context, C0900a c0900a, int i) {
        PendingIntent m5632a = m5632a(context, c0900a);
        if (m5632a != null) {
            m5634a(context, c0900a.m5645b(), (String) null, GoogleApiActivity.m4376a(context, m5632a, i));
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public final String m5629b() {
        String str;
        synchronized (f5057d) {
            str = this.f5059c;
        }
        return str;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.C1109m
    /* renamed from: b */
    public final boolean mo5117b(int i) {
        return super.mo5117b(i);
    }

    /* renamed from: b */
    public boolean m5628b(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog m5639a = m5639a(activity, i, i2, onCancelListener);
        if (m5639a == null) {
            return false;
        }
        m5638a(activity, m5639a, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    /* renamed from: c */
    public final void m5626c(Context context) {
        new HandlerC0903a(context).sendEmptyMessageDelayed(1, 120000L);
    }

    /* renamed from: c */
    public void m5625c(Context context, int i) {
        m5634a(context, i, (String) null, m5120a(context, i, 0, "n"));
    }
}
