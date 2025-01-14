package h.b.a.e.d;

import a.b.h.a.c;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.transition.Fade;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import h.b.a.d.f;
import h.b.a.d.o;
import h.b.a.d.u;
import h.b.a.e.d.n3;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import pt.card4b.backendbeacons.BackEnd;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: HomeFragment.java */
/* loaded from: classes.dex */
public class n3 extends g3 implements BottomNavigationView.c, View.OnClickListener, o.c, u.e, h.b.a.d.f, h.b.a.d.a {
    public h.b.a.c c0;
    public Snackbar d0;
    public View e0;
    public AppBarLayout f0;
    public Toolbar g0;
    public g h0;
    public View i0;
    public WebView j0;
    public BottomNavigationView k0;
    public Runnable m0;
    public Snackbar n0;
    public a.b.h.a.c o0;
    public ObjectAnimator p0;
    public int l0 = 0;
    public h q0 = new d(this);

    /* compiled from: HomeFragment.java */
    /* loaded from: classes.dex */
    public class a implements BackendListeners.GetTermsAndConditionsListener {
        public a() {
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            n3 n3Var = n3.this;
            n3Var.d0 = n3Var.c0.a(String.format("%s: %s", n3.this.a(2131755195), error.getMessageToUser()), -1);
            n3.this.d0.m();
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.GetTermsAndConditionsListener
        public void onSuccess(String str) {
            n3.this.a(new Intent("android.intent.action.VIEW", Uri.parse(String.format("https://docs.google.com/gview?url=%s", str))));
        }
    }

    /* compiled from: HomeFragment.java */
    /* loaded from: classes.dex */
    public class b extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        public a.b.h.a.c f7275a = null;

        /* renamed from: b  reason: collision with root package name */
        public boolean f7276b = true;

        public b() {
        }

        public /* synthetic */ void a(Long l) {
            n3.this.e0.post(new Runnable() { // from class: h.b.a.e.d.l
                @Override // java.lang.Runnable
                public final void run() {
                    n3.b.this.a();
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            d.c.o.b(500L, TimeUnit.MILLISECONDS).a(new d.c.e0.f() { // from class: h.b.a.e.d.m
                @Override // d.c.e0.f
                public final void accept(Object obj) {
                    n3.b.this.a((Long) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (n3.this.K()) {
                this.f7276b = false;
                a.b.h.a.c cVar = this.f7275a;
                if (cVar != null) {
                    cVar.dismiss();
                }
            }
            n3 n3Var = n3.this;
            n3Var.d0 = n3Var.c0.a(String.format("%s: %s", n3.this.b0.getString(2131755195), n3.this.b0.getString(2131755251)), -1);
            n3.this.d0.m();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return false;
        }

        public /* synthetic */ void a() {
            if (n3.this.K() && this.f7276b) {
                n3.this.a0.a(true);
                n3.this.j0.animate().alpha(1.0f).setDuration(200L).setListener(new o3(this));
            }
        }
    }

    /* compiled from: HomeFragment.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TextView f7278a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ o.c.a f7279b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f7280c;

        public c(TextView textView, o.c.a aVar, View view) {
            this.f7278a = textView;
            this.f7279b = aVar;
            this.f7280c = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n3.this.o0 == null) {
                return;
            }
            this.f7278a.setText(DateUtils.formatElapsedTime((this.f7279b.d() - System.currentTimeMillis()) / 1000));
            this.f7280c.postDelayed(this, 500L);
        }
    }

    /* compiled from: HomeFragment.java */
    /* loaded from: classes.dex */
    public class d implements h {
        public d(n3 n3Var) {
        }

        @Override // h.b.a.e.d.n3.h
        public int a() {
            return 0;
        }

        @Override // h.b.a.e.d.n3.h
        public void a(int i2, int i3, int i4, boolean z) {
        }

        @Override // h.b.a.e.d.n3.h
        public void a(Snackbar snackbar) {
        }

        @Override // h.b.a.e.d.n3.h
        public void a(Snackbar snackbar, int i2) {
        }

        @Override // h.b.a.e.d.n3.h
        public void b() {
        }
    }

    /* compiled from: HomeFragment.java */
    /* loaded from: classes.dex */
    public class e extends Snackbar.b {
        public e() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.support.design.widget.BaseTransientBottomBar.l
        public void a(Snackbar snackbar, int i2) {
            super.a(snackbar, i2);
            n3.this.t0().a(snackbar, i2);
            n3.this.n0 = null;
        }
    }

    /* compiled from: HomeFragment.java */
    /* loaded from: classes.dex */
    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            n3.this.j0.setVisibility(8);
            n3.this.a0.a(false);
        }
    }

    /* compiled from: HomeFragment.java */
    /* loaded from: classes.dex */
    public class g extends Drawable {

        /* renamed from: a  reason: collision with root package name */
        public final Paint f7284a = new Paint();

        /* renamed from: b  reason: collision with root package name */
        public int f7285b = -1;

        public g() {
            a(n3.this.u0());
        }

        public void a(int i2) {
            this.f7284a.setColor(i2);
            n3.this.f0.setBackgroundColor(i2);
            invalidateSelf();
        }

        public void b(int i2) {
            if (i2 != this.f7285b) {
                this.f7285b = i2;
                invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            int i2 = this.f7285b;
            if (i2 == -1) {
                i2 = canvas.getHeight();
            }
            canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), i2, this.f7284a);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i2) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    /* compiled from: HomeFragment.java */
    /* loaded from: classes.dex */
    public interface h {
        int a();

        void a(int i2, int i3, int i4, boolean z);

        void a(Snackbar snackbar);

        void a(Snackbar snackbar, int i2);

        void b();
    }

    public static String H0() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return b(str2);
        }
        return b(str) + " " + str2;
    }

    public static /* synthetic */ void b(View view) {
    }

    @SuppressLint({"ApplySharedPref"})
    public final void A0() {
        if (PreferenceManager.getDefaultSharedPreferences(this.b0).getBoolean("showProtectedAppsDialog", true)) {
            final Intent intent = null;
            Intent[] n = h.b.a.c.b(this.b0).n();
            int length = n.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    Intent intent2 = n[i2];
                    if (intent2 != null && this.b0.getPackageManager().resolveActivity(intent2, 65536) != null) {
                        intent = intent2;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            if (intent != null) {
                BackEnd.addToLog(String.format("[%s] openProtectedAppsDialog: Showing protected Apps dialog for the first time", "HomeFragment.class"));
                c.a aVar = new c.a(this.b0);
                int applyDimension = (int) TypedValue.applyDimension(1, 21.0f, this.b0.getResources().getDisplayMetrics());
                LinearLayout linearLayout = new LinearLayout(this.b0);
                linearLayout.setOrientation(1);
                int i3 = applyDimension / 4;
                linearLayout.setPadding(applyDimension, i3, applyDimension, i3);
                TextView textView = new TextView(this.b0);
                textView.setText(2131755309);
                textView.setPadding(0, 0, 0, applyDimension / 3);
                linearLayout.addView(textView);
                final CheckBox checkBox = new CheckBox(this.b0);
                checkBox.setText(2131755114);
                linearLayout.addView(checkBox);
                aVar.b(linearLayout);
                aVar.b(this.b0.getString(2131755308));
                aVar.b(this.b0.getString(2131755308));
                aVar.b(17039370, new DialogInterface.OnClickListener() { // from class: h.b.a.e.d.o
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        n3.this.a(checkBox, intent, dialogInterface, i4);
                    }
                });
                aVar.c();
                return;
            }
            BackEnd.addToLog(String.format("[%s] openProtectedAppsActivity: Could not find a valid Activity", "HomeFragment.class"));
        }
    }

    public final void B0() {
        d(new g4());
    }

    public void C0() {
        b((Runnable) null);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void D0() {
        this.d0 = this.c0.a(this.b0.getString(2131755250), -1);
        this.d0.m();
        this.j0.getSettings().setJavaScriptEnabled(true);
        this.j0.setWebViewClient(new b());
        WebView webView = this.j0;
        webView.loadUrl(this.b0.getString(2131755252) + "?r=" + h.b.a.f.a.a(8));
    }

    public final void E0() {
        this.d0 = this.c0.a(this.b0.getString(2131755340), -1);
        this.d0.m();
        BackEnd.getTermsAndConditions(new a());
    }

    public final void F0() {
        c.a aVar = new c.a(this.b0);
        int applyDimension = (int) TypedValue.applyDimension(1, 21.0f, this.b0.getResources().getDisplayMetrics());
        LinearLayout linearLayout = new LinearLayout(this.b0);
        linearLayout.setOrientation(1);
        int i2 = applyDimension / 4;
        linearLayout.setPadding(applyDimension, i2, applyDimension, i2);
        TextView textView = new TextView(this.b0);
        textView.setText(2131755333);
        textView.setPadding(0, 0, 0, applyDimension / 3);
        linearLayout.addView(textView);
        final CheckBox checkBox = new CheckBox(this.b0);
        checkBox.setText(2131755114);
        linearLayout.addView(checkBox);
        aVar.b(linearLayout);
        aVar.b(2131755423);
        aVar.b(17039370, new DialogInterface.OnClickListener() { // from class: h.b.a.e.d.s
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                n3.this.a(checkBox, dialogInterface, i3);
            }
        });
        aVar.a(17039360, (DialogInterface.OnClickListener) null);
        aVar.a(false);
        aVar.c();
    }

    public final void G0() {
        c.a aVar = new c.a(this.b0);
        int applyDimension = (int) TypedValue.applyDimension(1, 21.0f, this.b0.getResources().getDisplayMetrics());
        LinearLayout linearLayout = new LinearLayout(this.b0);
        linearLayout.setOrientation(1);
        int i2 = applyDimension / 4;
        linearLayout.setPadding(applyDimension, i2, applyDimension, i2);
        TextView textView = new TextView(this.b0);
        textView.setText(2131755113);
        textView.setPadding(0, 0, 0, applyDimension / 3);
        linearLayout.addView(textView);
        final CheckBox checkBox = new CheckBox(this.b0);
        checkBox.setText(2131755114);
        linearLayout.addView(checkBox);
        aVar.b(linearLayout);
        aVar.b(2131755423);
        aVar.b(17039370, new DialogInterface.OnClickListener() { // from class: h.b.a.e.d.u
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                n3.this.b(checkBox, dialogInterface, i3);
            }
        });
        aVar.a(17039360, (DialogInterface.OnClickListener) null);
        aVar.a(false);
        aVar.c();
    }

    @Override // android.support.v4.app.Fragment
    public void U() {
        this.c0.b((o.c) this);
        this.c0.b((h.b.a.d.f) this);
        this.c0.c(this);
        this.c0.o().b(this);
        super.U();
    }

    @Override // android.support.v4.app.Fragment
    public void Y() {
        Menu menu = this.k0.getMenu();
        int size = menu.size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            } else if (menu.getItem(i3).isChecked()) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        this.l0 = i2;
        super.Y();
    }

    @Override // android.support.v4.app.Fragment
    public void Z() {
        super.Z();
        Runnable runnable = this.m0;
        if (runnable != null) {
            this.e0.post(runnable);
            this.m0 = null;
        }
        this.e0.post(new Runnable() { // from class: h.b.a.e.d.e3
            @Override // java.lang.Runnable
            public final void run() {
                n3.this.p0();
            }
        });
    }

    @Override // h.b.a.d.a
    public Snackbar a(String str, int i2) {
        return null;
    }

    @Override // h.b.a.d.f
    public void a(f.b bVar) {
    }

    @Override // h.b.a.d.o.c
    public void a(h.b.a.d.o oVar) {
    }

    @Override // h.b.a.d.o.c
    public void a(h.b.a.d.o oVar, h.b.a.d.q qVar) {
    }

    @Override // h.b.a.d.a
    public void a(boolean z, boolean z2) {
    }

    @Override // h.b.a.d.f
    public void b(f.b bVar) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List<Fragment> c2 = p().c();
        int size = c2.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = c2.get(i2);
            if (fragment instanceof h3) {
                ((h3) fragment).b(view);
            }
        }
    }

    @Override // h.b.a.d.a
    @SuppressLint({"ApplySharedPref"})
    public void onTripAppActivityBlocked() {
        PreferenceManager.getDefaultSharedPreferences(this.b0).edit().putBoolean("showProtectedAppsDialog", true).commit();
        A0();
    }

    @Override // h.b.a.d.a
    public void onWakeUpRequired() {
    }

    public void p0() {
        if (j() == null) {
            return;
        }
        for (Fragment fragment : p().c()) {
            if (fragment instanceof h3) {
                b((h3) fragment);
            }
        }
    }

    public void q0() {
        b(new Runnable() { // from class: h.b.a.e.d.p
            @Override // java.lang.Runnable
            public final void run() {
                n3.this.v0();
            }
        });
    }

    public int r0() {
        return this.i0.getHeight() - this.g0.getHeight();
    }

    public int s0() {
        return this.k0.getHeight();
    }

    public h t0() {
        return this.q0;
    }

    public final int u0() {
        TypedValue typedValue = new TypedValue();
        j().getTheme().resolveAttribute(2130903230, typedValue, true);
        return typedValue.data;
    }

    public /* synthetic */ void v0() {
        Fragment a2 = a(p());
        if (a2 == null || !(a2 instanceof g4)) {
            return;
        }
        ((g4) a2).t0();
    }

    public /* synthetic */ void w0() {
        t0().a(this.n0);
    }

    public final void x0() {
        d(new k3());
    }

    public final void y0() {
        d(new m3());
    }

    public final void z0() {
        d(new p3());
    }

    @Override // android.support.v4.app.Fragment
    public void c(Bundle bundle) {
        super.c(bundle);
        this.c0 = h.b.a.c.b(q());
        if (!this.c0.o().a()) {
            c((Fragment) new q3());
            return;
        }
        this.c0.a((o.c) this);
        this.c0.a((h.b.a.d.f) this);
        this.c0.a((h.b.a.d.a) this);
        this.c0.o().a(this);
        A0();
        if ((H0().contains("Pixel") || H0().contains("Nexus")) && PreferenceManager.getDefaultSharedPreferences(this.b0).getBoolean("showPixelNexusWarningDialog", true)) {
            G0();
        }
    }

    public final void d(Fragment fragment) {
        if (j() == null) {
            return;
        }
        a.b.g.a.k p = p();
        Fragment a2 = a(p);
        if (a2 == null || a2.getClass() != fragment.getClass()) {
            List<Fragment> c2 = p.c();
            a.b.g.a.q a3 = p.a();
            if (c2 != null) {
                for (Fragment fragment2 : c2) {
                    if (fragment2 != null) {
                        a3.a(fragment2);
                    }
                }
            }
            a3.b(2131230841, fragment);
            a3.a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void e(Bundle bundle) {
        super.e(bundle);
        Menu menu = this.k0.getMenu();
        int size = menu.size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            } else if (menu.getItem(i3).isChecked()) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        bundle.putInt("p", i2);
    }

    public /* synthetic */ void f(MenuItem menuItem) {
        a(menuItem);
        p0();
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (char c2 : charArray) {
            if (z && Character.isLetter(c2)) {
                sb.append(Character.toUpperCase(c2));
                z = false;
            } else {
                if (Character.isWhitespace(c2)) {
                    z = true;
                }
                sb.append(c2);
            }
        }
        return sb.toString();
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.b.a.c.b(this.b0).a(j(), false);
        f(true);
        View inflate = layoutInflater.inflate(2131427380, viewGroup, false);
        this.e0 = inflate;
        Toolbar toolbar = (Toolbar) inflate.findViewById(2131231152);
        this.g0 = toolbar;
        a.b.h.a.d dVar = (a.b.h.a.d) j();
        ((a.b.h.a.d) Objects.requireNonNull(dVar)).a(toolbar);
        dVar.l().d(false);
        this.f0 = (AppBarLayout) inflate.findViewById(2131230804);
        this.f0.setBackgroundColor(u0());
        this.i0 = inflate.findViewById(2131230811);
        View view = this.i0;
        g gVar = this.h0;
        if (gVar == null) {
            gVar = new g();
            this.h0 = gVar;
        }
        view.setBackground(gVar);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) inflate.findViewById(2131230972);
        this.k0 = bottomNavigationView;
        this.j0 = (WebView) inflate.findViewById(2131231183);
        if (this.c0.A()) {
            this.h0.a(-13070788);
        }
        if (bundle == null && this.l0 == 0) {
            B0();
        } else {
            final MenuItem item = bottomNavigationView.getMenu().getItem(bundle == null ? this.l0 : bundle.getInt("p"));
            item.setChecked(true);
            inflate.post(new Runnable() { // from class: h.b.a.e.d.r
                @Override // java.lang.Runnable
                public final void run() {
                    n3.this.f(item);
                }
            });
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        return inflate;
    }

    public void e(int i2) {
        float f2;
        int height = this.g0.getHeight();
        if (i2 == -1) {
            f2 = 0.0f;
        } else {
            int[] iArr = new int[2];
            this.g0.getLocationInWindow(iArr);
            f2 = 1.0f - (i2 / ((iArr[1] + height) / 3));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            ObjectAnimator objectAnimator = this.p0;
            boolean z = objectAnimator != null;
            if (f2 <= 0.0f) {
                if (!z || !objectAnimator.isRunning() || (objectAnimator.isRunning() && objectAnimator.getDuration() != 120)) {
                    if (z) {
                        objectAnimator.cancel();
                        this.p0 = null;
                    }
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f0, "elevation", TypedValue.applyDimension(1, 8.0f, B().getDisplayMetrics()));
                    ofFloat.setDuration(120L).start();
                    this.p0 = ofFloat;
                    f2 = 0.0f;
                }
            } else if (!z || !objectAnimator.isRunning() || (objectAnimator.isRunning() && objectAnimator.getDuration() != 160)) {
                if (z) {
                    objectAnimator.cancel();
                    this.p0 = null;
                }
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f0, "elevation", 0.0f);
                ofFloat2.setDuration(160L).start();
                this.p0 = ofFloat2;
            }
        }
        int height2 = this.i0.getHeight() - height;
        this.i0.setVisibility(f2 <= 0.0f ? 8 : 0);
        this.h0.b((int) (height + (height2 * f2)));
    }

    public /* synthetic */ void b(CheckBox checkBox, DialogInterface dialogInterface, int i2) {
        if (checkBox.isChecked()) {
            PreferenceManager.getDefaultSharedPreferences(this.b0).edit().putBoolean("showPixelNexusWarningDialog", false).apply();
            Log.d("HomeFragment.class", "The user chose not to show the start dialog again. Saved to preferences");
        }
    }

    @Override // h.b.a.d.o.c
    public void d(h.b.a.d.o oVar) {
        this.h0.a(-13070788);
        if (PreferenceManager.getDefaultSharedPreferences(this.b0).getBoolean("showDialogStartTrip", true)) {
            F0();
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean c(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 2131230839:
                Fragment j3Var = new j3();
                j3Var.a(new h.b.a.e.b.a());
                j3Var.c(new Fade(2).setDuration(150L));
                b(new h.b.a.e.b.a());
                b(j3Var);
                return true;
            case 2131230908:
                D0();
                return true;
            case 2131231003:
                if (!h.b.a.c.X().D()) {
                    Toast.makeText(this.b0, a(2131755266), 0).show();
                    return false;
                }
                Fragment y3Var = new y3();
                y3Var.a(new h.b.a.e.b.a());
                y3Var.c(new Fade(2).setDuration(150L));
                b(new h.b.a.e.b.a());
                b(y3Var);
                return true;
            case 2131231016:
                a.b.g.a.k v = v();
                if (v != null) {
                    c4 c4Var = new c4();
                    c4Var.b(H());
                    c4Var.a(v, "report");
                }
                return true;
            case 2131231066:
                e4 e4Var = new e4();
                e4Var.a(new Fade(1));
                e4Var.b(new Fade(2));
                b(new h.b.a.e.b.a());
                if (j() instanceof h.b.a.e.a.h) {
                    e4Var.a((h.b.a.e.a.h) j());
                }
                b((Fragment) e4Var);
                return true;
            case 2131231132:
                E0();
                return true;
            default:
                return super.c(menuItem);
        }
    }

    public void d(int i2) {
        o.c.a a2;
        h.b.a.d.o m = this.c0.m();
        if (m == null || (a2 = m.a()) == null) {
            return;
        }
        if (i2 == -1) {
            a2.a();
        } else if (i2 != 0) {
            if (i2 != 1) {
                return;
            }
            a2.c();
        } else {
            a.b.h.a.c cVar = this.o0;
            if (cVar == null || !cVar.isShowing()) {
                a(m, a2);
            }
        }
    }

    public void b(final Runnable runnable) {
        Runnable runnable2 = new Runnable() { // from class: h.b.a.e.d.n
            @Override // java.lang.Runnable
            public final void run() {
                n3.this.a(runnable);
            }
        };
        if (Q()) {
            this.e0.post(runnable2);
        } else {
            this.m0 = runnable2;
        }
    }

    @Override // h.b.a.d.o.c
    public void b(h.b.a.d.o oVar) {
        a.b.h.a.c cVar = this.o0;
        if (cVar != null) {
            cVar.cancel();
        }
    }

    @Override // h.b.a.d.a
    public void b() {
        WebView webView = this.j0;
        if (webView == null || webView.getVisibility() != 0) {
            return;
        }
        this.j0.animate().alpha(0.0f).setDuration(200L).setListener(new f());
    }

    public /* synthetic */ void a(CheckBox checkBox, Intent intent, DialogInterface dialogInterface, int i2) {
        if (checkBox.isChecked()) {
            PreferenceManager.getDefaultSharedPreferences(this.b0).edit().putBoolean("showProtectedAppsDialog", false).commit();
        } else {
            BackEnd.addToLog(String.format("[%s] openProtectedAppsActivity: (Don't show again) wasn't checked", "HomeFragment.class"));
        }
        this.b0.startActivity(intent);
    }

    @Override // h.b.a.e.d.g3, android.support.v4.app.Fragment
    public void a(Context context) {
        super.a(context);
    }

    @Override // android.support.v4.app.Fragment
    public void a(Fragment fragment) {
        super.a(fragment);
        View view = this.e0;
        if (view != null && (fragment instanceof h3)) {
            final h3 h3Var = (h3) fragment;
            view.post(new Runnable() { // from class: h.b.a.e.d.x
                @Override // java.lang.Runnable
                public final void run() {
                    n3.this.b(h3Var);
                }
            });
        }
    }

    /* renamed from: a */
    public final void b(h3 h3Var) {
        h3Var.p0();
    }

    @Override // android.support.v4.app.Fragment
    public void a(Menu menu, MenuInflater menuInflater) {
        super.a(menu, menuInflater);
        menuInflater.inflate(2131492864, menu);
    }

    @Override // h.b.a.d.o.c
    public void c(h.b.a.d.o oVar) {
        Log.d("HomeFragment.class", "onConfirmStageFinished() was called");
        a.b.h.a.c cVar = this.o0;
        if (cVar != null) {
            cVar.cancel();
        }
    }

    @Override // android.support.design.widget.BottomNavigationView.c
    public boolean a(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 2131230885:
                x0();
                return true;
            case 2131230910:
                y0();
                return true;
            case 2131230925:
                z0();
                return true;
            case 2131231163:
                B0();
                return true;
            default:
                return false;
        }
    }

    public /* synthetic */ void a(Runnable runnable) {
        Menu menu = this.k0.getMenu();
        menu.performIdentifierAction(2131231163, 0);
        menu.getItem(0).setChecked(true);
        if (runnable != null) {
            this.e0.post(runnable);
        }
    }

    public final Fragment a(a.b.g.a.k kVar) {
        List<Fragment> c2 = kVar.c();
        if (c2 == null) {
            return null;
        }
        for (int size = c2.size() - 1; size >= 0; size--) {
            if (c2.get(size) != null) {
                return c2.get(size);
            }
        }
        return null;
    }

    @Override // h.b.a.d.o.c
    public void a(h.b.a.d.o oVar, f.a aVar) {
        a(aVar);
    }

    public /* synthetic */ void a(CheckBox checkBox, DialogInterface dialogInterface, int i2) {
        if (checkBox.isChecked()) {
            PreferenceManager.getDefaultSharedPreferences(this.b0).edit().putBoolean("showDialogStartTrip", false).apply();
            Log.d("HomeFragment.class", "The user chose not to show the start dialog again. Saved to preferences");
        }
    }

    @Override // h.b.a.d.o.c
    public void a(h.b.a.d.o oVar, o.a aVar) {
        this.h0.a(-13615201);
    }

    @Override // h.b.a.d.o.c
    public void a(h.b.a.d.o oVar, final o.c.a aVar) {
        c.a aVar2 = new c.a(this.b0);
        View inflate = View.inflate(this.b0, 2131427371, null);
        aVar2.b(2131755351);
        aVar2.b(inflate);
        aVar2.b(2131755351, new DialogInterface.OnClickListener() { // from class: h.b.a.e.d.v
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                o.c.a.this.c();
            }
        });
        aVar2.a(2131755283, new DialogInterface.OnClickListener() { // from class: h.b.a.e.d.t
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                o.c.a.this.a();
            }
        });
        aVar2.a(false);
        aVar2.a(new DialogInterface.OnDismissListener() { // from class: h.b.a.e.d.y
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                n3.this.a(dialogInterface);
            }
        });
        this.o0 = aVar2.c();
        inflate.post(new c((TextView) inflate.findViewById(2131231148), aVar, inflate));
    }

    public /* synthetic */ void a(DialogInterface dialogInterface) {
        this.o0 = null;
    }

    @Override // h.b.a.d.u.e
    public void a(h.b.a.d.x xVar) {
        n0();
        a((Fragment) new q3(), false);
    }

    @Override // h.b.a.d.f
    public void a(f.a aVar) {
        f.a.EnumC0164a b2 = aVar.b();
        if (b2 == f.a.EnumC0164a.missingData || b2 == f.a.EnumC0164a.bluetoothOff || b2 == f.a.EnumC0164a.locationOff || b2 == f.a.EnumC0164a.nfcOff || b2 == f.a.EnumC0164a.hceError || b2 == f.a.EnumC0164a.hceOff || b2 == f.a.EnumC0164a.hce_notAuthorized || b2 == f.a.EnumC0164a.noInternet || b2 == f.a.EnumC0164a.paymentMethod_missing || b2 == f.a.EnumC0164a.paymentMethod_invalid || b2 == f.a.EnumC0164a.invalidEquipment || b2 == f.a.EnumC0164a.account_notConfirmed || b2 == f.a.EnumC0164a.card_not_enrolled || b2 == f.a.EnumC0164a.failed_to_enroll_card) {
            return;
        }
        String c2 = aVar.c();
        h.b.a.c cVar = this.c0;
        this.d0 = cVar.a(this.b0.getString(2131755195) + ": " + c2, -2);
        Snackbar snackbar = this.d0;
        this.n0 = snackbar;
        snackbar.a(17039370, w.f7384a);
        snackbar.f(-12532481);
        Snackbar snackbar2 = this.d0;
        snackbar2.a(new e());
        snackbar2.m();
        this.e0.postDelayed(new Runnable() { // from class: h.b.a.e.d.q
            @Override // java.lang.Runnable
            public final void run() {
                n3.this.w0();
            }
        }, 50L);
        aVar.e();
    }
}
