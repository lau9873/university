package p070c.p074b.p075a.p078d;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.concurrent.CountDownLatch;
import p136d.p137a.p138a.p139a.p140m.p148g.PromptSettingsData;

/* renamed from: c.b.a.d.f */
/* loaded from: classes.dex */
public class CrashPromptDialog {

    /* renamed from: a */
    public final C0821e f4807a;

    /* renamed from: b */
    public final AlertDialog.Builder f4808b;

    /* compiled from: CrashPromptDialog.java */
    /* renamed from: c.b.a.d.f$a */
    /* loaded from: classes.dex */
    public static class DialogInterface$OnClickListenerC0817a implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ C0821e f4809a;

        public DialogInterface$OnClickListenerC0817a(C0821e c0821e) {
            this.f4809a = c0821e;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f4809a.m5902a(true);
            dialogInterface.dismiss();
        }
    }

    /* compiled from: CrashPromptDialog.java */
    /* renamed from: c.b.a.d.f$b */
    /* loaded from: classes.dex */
    public static class DialogInterface$OnClickListenerC0818b implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ C0821e f4810a;

        public DialogInterface$OnClickListenerC0818b(C0821e c0821e) {
            this.f4810a = c0821e;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f4810a.m5902a(false);
            dialogInterface.dismiss();
        }
    }

    /* compiled from: CrashPromptDialog.java */
    /* renamed from: c.b.a.d.f$c */
    /* loaded from: classes.dex */
    public static class DialogInterface$OnClickListenerC0819c implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC0820d f4811a;

        /* renamed from: b */
        public final /* synthetic */ C0821e f4812b;

        public DialogInterface$OnClickListenerC0819c(InterfaceC0820d interfaceC0820d, C0821e c0821e) {
            this.f4811a = interfaceC0820d;
            this.f4812b = c0821e;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f4811a.mo5783a(true);
            this.f4812b.m5902a(true);
            dialogInterface.dismiss();
        }
    }

    /* compiled from: CrashPromptDialog.java */
    /* renamed from: c.b.a.d.f$d */
    /* loaded from: classes.dex */
    public interface InterfaceC0820d {
        /* renamed from: a */
        void mo5783a(boolean z);
    }

    public CrashPromptDialog(AlertDialog.Builder builder, C0821e c0821e) {
        this.f4807a = c0821e;
        this.f4808b = builder;
    }

    /* renamed from: a */
    public static int m5908a(float f, int i) {
        return (int) (f * i);
    }

    /* renamed from: a */
    public static CrashPromptDialog m5907a(Activity activity, PromptSettingsData promptSettingsData, InterfaceC0820d interfaceC0820d) {
        C0821e c0821e = new C0821e(null);
        DialogStringResolver dialogStringResolver = new DialogStringResolver(activity, promptSettingsData);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        ScrollView m5906a = m5906a(activity, dialogStringResolver.m5734c());
        builder.setView(m5906a).setTitle(dialogStringResolver.m5732e()).setCancelable(false).setNeutralButton(dialogStringResolver.m5733d(), new DialogInterface$OnClickListenerC0817a(c0821e));
        if (promptSettingsData.f6642d) {
            builder.setNegativeButton(dialogStringResolver.m5736b(), new DialogInterface$OnClickListenerC0818b(c0821e));
        }
        if (promptSettingsData.f6644f) {
            builder.setPositiveButton(dialogStringResolver.m5739a(), new DialogInterface$OnClickListenerC0819c(interfaceC0820d, c0821e));
        }
        return new CrashPromptDialog(builder, c0821e);
    }

    /* renamed from: b */
    public boolean m5905b() {
        return this.f4807a.m5901b();
    }

    /* renamed from: c */
    public void m5904c() {
        this.f4808b.show();
    }

    /* compiled from: CrashPromptDialog.java */
    /* renamed from: c.b.a.d.f$e */
    /* loaded from: classes.dex */
    public static class C0821e {

        /* renamed from: a */
        public boolean f4813a;

        /* renamed from: b */
        public final CountDownLatch f4814b;

        public C0821e() {
            this.f4813a = false;
            this.f4814b = new CountDownLatch(1);
        }

        /* renamed from: a */
        public void m5902a(boolean z) {
            this.f4813a = z;
            this.f4814b.countDown();
        }

        /* renamed from: b */
        public boolean m5901b() {
            return this.f4813a;
        }

        /* renamed from: a */
        public void m5903a() {
            try {
                this.f4814b.await();
            } catch (InterruptedException unused) {
            }
        }

        public /* synthetic */ C0821e(DialogInterface$OnClickListenerC0817a dialogInterface$OnClickListenerC0817a) {
            this();
        }
    }

    /* renamed from: a */
    public static ScrollView m5906a(Activity activity, String str) {
        float f = activity.getResources().getDisplayMetrics().density;
        int m5908a = m5908a(f, 5);
        TextView textView = new TextView(activity);
        textView.setAutoLinkMask(15);
        textView.setText(str);
        textView.setTextAppearance(activity, 16973892);
        textView.setPadding(m5908a, m5908a, m5908a, m5908a);
        textView.setFocusable(false);
        ScrollView scrollView = new ScrollView(activity);
        scrollView.setPadding(m5908a(f, 14), m5908a(f, 2), m5908a(f, 10), m5908a(f, 12));
        scrollView.addView(textView);
        return scrollView;
    }

    /* renamed from: a */
    public void m5909a() {
        this.f4807a.m5903a();
    }
}
