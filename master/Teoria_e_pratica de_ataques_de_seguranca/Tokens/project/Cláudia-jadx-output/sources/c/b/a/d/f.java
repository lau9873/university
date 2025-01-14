package c.b.a.d;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.concurrent.CountDownLatch;
/* compiled from: CrashPromptDialog.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final e f2994a;

    /* renamed from: b  reason: collision with root package name */
    public final AlertDialog.Builder f2995b;

    /* compiled from: CrashPromptDialog.java */
    /* loaded from: classes.dex */
    public static class a implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f2996a;

        public a(e eVar) {
            this.f2996a = eVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            this.f2996a.a(true);
            dialogInterface.dismiss();
        }
    }

    /* compiled from: CrashPromptDialog.java */
    /* loaded from: classes.dex */
    public static class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f2997a;

        public b(e eVar) {
            this.f2997a = eVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            this.f2997a.a(false);
            dialogInterface.dismiss();
        }
    }

    /* compiled from: CrashPromptDialog.java */
    /* loaded from: classes.dex */
    public static class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f2998a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f2999b;

        public c(d dVar, e eVar) {
            this.f2998a = dVar;
            this.f2999b = eVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            this.f2998a.a(true);
            this.f2999b.a(true);
            dialogInterface.dismiss();
        }
    }

    /* compiled from: CrashPromptDialog.java */
    /* loaded from: classes.dex */
    public interface d {
        void a(boolean z);
    }

    public f(AlertDialog.Builder builder, e eVar) {
        this.f2994a = eVar;
        this.f2995b = builder;
    }

    public static int a(float f2, int i2) {
        return (int) (f2 * i2);
    }

    public static f a(Activity activity, d.a.a.a.m.g.p pVar, d dVar) {
        e eVar = new e(null);
        r rVar = new r(activity, pVar);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        ScrollView a2 = a(activity, rVar.c());
        builder.setView(a2).setTitle(rVar.e()).setCancelable(false).setNeutralButton(rVar.d(), new a(eVar));
        if (pVar.f4436d) {
            builder.setNegativeButton(rVar.b(), new b(eVar));
        }
        if (pVar.f4438f) {
            builder.setPositiveButton(rVar.a(), new c(dVar, eVar));
        }
        return new f(builder, eVar);
    }

    public boolean b() {
        return this.f2994a.b();
    }

    public void c() {
        this.f2995b.show();
    }

    /* compiled from: CrashPromptDialog.java */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public boolean f3000a;

        /* renamed from: b  reason: collision with root package name */
        public final CountDownLatch f3001b;

        public e() {
            this.f3000a = false;
            this.f3001b = new CountDownLatch(1);
        }

        public void a(boolean z) {
            this.f3000a = z;
            this.f3001b.countDown();
        }

        public boolean b() {
            return this.f3000a;
        }

        public void a() {
            try {
                this.f3001b.await();
            } catch (InterruptedException unused) {
            }
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    public static ScrollView a(Activity activity, String str) {
        float f2 = activity.getResources().getDisplayMetrics().density;
        int a2 = a(f2, 5);
        TextView textView = new TextView(activity);
        textView.setAutoLinkMask(15);
        textView.setText(str);
        textView.setTextAppearance(activity, 16973892);
        textView.setPadding(a2, a2, a2, a2);
        textView.setFocusable(false);
        ScrollView scrollView = new ScrollView(activity);
        scrollView.setPadding(a(f2, 14), a(f2, 2), a(f2, 10), a(f2, 12));
        scrollView.addView(textView);
        return scrollView;
    }

    public void a() {
        this.f2994a.a();
    }
}
