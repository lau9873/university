package p205h.p208b.p209a.p212e.p216d;

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
import android.support.p065v4.app.Fragment;
import android.support.p067v7.widget.Toolbar;
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
import com.hbb20.C1444R;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import p000a.p006b.p030g.p031a.FragmentManager;
import p000a.p006b.p030g.p031a.FragmentTransaction;
import p000a.p006b.p049h.p050a.AlertDialog;
import p000a.p006b.p049h.p050a.AppCompatActivity;
import p136d.p153c.Observable;
import p136d.p153c.p159e0.Consumer;
import p205h.p208b.p209a.Anda;
import p205h.p208b.p209a.p210d.AndaActionsListener;
import p205h.p208b.p209a.p210d.ErrorListener;
import p205h.p208b.p209a.p210d.OngoingTrip;
import p205h.p208b.p209a.p210d.Passing;
import p205h.p208b.p209a.p210d.Session;
import p205h.p208b.p209a.p210d.User;
import p205h.p208b.p209a.p212e.p213a.NavigationActivity;
import p205h.p208b.p209a.p212e.p214b.ExplodeVertically;
import p205h.p208b.p209a.p212e.p216d.HomeFragment;
import p205h.p208b.p209a.p219f.StringHelper;
import pt.card4b.backendbeacons.BackEnd;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.b.a.e.d.n3 */
/* loaded from: classes.dex */
public class HomeFragment extends AbstractFragment implements BottomNavigationView.InterfaceC0564c, View.OnClickListener, OngoingTrip.InterfaceC2364c, Session.InterfaceC2370e, ErrorListener, AndaActionsListener {

    /* renamed from: c0 */
    public Anda f10090c0;

    /* renamed from: d0 */
    public Snackbar f10091d0;

    /* renamed from: e0 */
    public View f10092e0;

    /* renamed from: f0 */
    public AppBarLayout f10093f0;

    /* renamed from: g0 */
    public Toolbar f10094g0;

    /* renamed from: h0 */
    public C2507g f10095h0;

    /* renamed from: i0 */
    public View f10096i0;

    /* renamed from: j0 */
    public WebView f10097j0;

    /* renamed from: k0 */
    public BottomNavigationView f10098k0;

    /* renamed from: m0 */
    public Runnable f10100m0;

    /* renamed from: n0 */
    public Snackbar f10101n0;

    /* renamed from: o0 */
    public AlertDialog f10102o0;

    /* renamed from: p0 */
    public ObjectAnimator f10103p0;

    /* renamed from: l0 */
    public int f10099l0 = 0;

    /* renamed from: q0 */
    public InterfaceC2508h f10104q0 = new C2504d(this);

    /* compiled from: HomeFragment.java */
    /* renamed from: h.b.a.e.d.n3$a */
    /* loaded from: classes.dex */
    public class C2501a implements BackendListeners.GetTermsAndConditionsListener {
        public C2501a() {
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            HomeFragment homeFragment = HomeFragment.this;
            homeFragment.f10091d0 = homeFragment.f10090c0.m1447a(String.format("%s: %s", HomeFragment.this.m7528a(C1444R.string.error), error.getMessageToUser()), -1);
            HomeFragment.this.f10091d0.mo7619m();
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.GetTermsAndConditionsListener
        public void onSuccess(String str) {
            HomeFragment.this.m7518a(new Intent("android.intent.action.VIEW", Uri.parse(String.format("https://docs.google.com/gview?url=%s", str))));
        }
    }

    /* compiled from: HomeFragment.java */
    /* renamed from: h.b.a.e.d.n3$b */
    /* loaded from: classes.dex */
    public class C2502b extends WebViewClient {

        /* renamed from: a */
        public AlertDialog f10106a = null;

        /* renamed from: b */
        public boolean f10107b = true;

        public C2502b() {
        }

        /* renamed from: a */
        public /* synthetic */ void m907a(Long l) {
            HomeFragment.this.f10092e0.post(new Runnable() { // from class: h.b.a.e.d.l
                @Override // java.lang.Runnable
                public final void run() {
                    HomeFragment.C2502b.this.m908a();
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Observable.m3300b(500L, TimeUnit.MILLISECONDS).m3316a(new Consumer() { // from class: h.b.a.e.d.m
                @Override // p136d.p153c.p159e0.Consumer
                public final void accept(Object obj) {
                    HomeFragment.C2502b.this.m907a((Long) obj);
                }
            });
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (HomeFragment.this.m7540K()) {
                this.f10107b = false;
                AlertDialog alertDialog = this.f10106a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
            HomeFragment homeFragment = HomeFragment.this;
            homeFragment.f10091d0 = homeFragment.f10090c0.m1447a(String.format("%s: %s", HomeFragment.this.f9860b0.getString(C1444R.string.error), HomeFragment.this.f9860b0.getString(C1444R.string.faq_loading_error)), -1);
            HomeFragment.this.f10091d0.mo7619m();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return false;
        }

        /* renamed from: a */
        public /* synthetic */ void m908a() {
            if (HomeFragment.this.m7540K() && this.f10107b) {
                HomeFragment.this.f9859a0.mo22a(true);
                HomeFragment.this.f10097j0.animate().alpha(1.0f).setDuration(200L).setListener(new C2513o3(this));
            }
        }
    }

    /* compiled from: HomeFragment.java */
    /* renamed from: h.b.a.e.d.n3$c */
    /* loaded from: classes.dex */
    public class RunnableC2503c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ TextView f10109a;

        /* renamed from: b */
        public final /* synthetic */ OngoingTrip.InterfaceC2364c.AbstractRunnableC2365a f10110b;

        /* renamed from: c */
        public final /* synthetic */ View f10111c;

        public RunnableC2503c(TextView textView, OngoingTrip.InterfaceC2364c.AbstractRunnableC2365a abstractRunnableC2365a, View view) {
            this.f10109a = textView;
            this.f10110b = abstractRunnableC2365a;
            this.f10111c = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HomeFragment.this.f10102o0 == null) {
                return;
            }
            this.f10109a.setText(DateUtils.formatElapsedTime((this.f10110b.m1292d() - System.currentTimeMillis()) / 1000));
            this.f10111c.postDelayed(this, 500L);
        }
    }

    /* compiled from: HomeFragment.java */
    /* renamed from: h.b.a.e.d.n3$d */
    /* loaded from: classes.dex */
    public class C2504d implements InterfaceC2508h {
        public C2504d(HomeFragment homeFragment) {
        }

        @Override // p205h.p208b.p209a.p212e.p216d.HomeFragment.InterfaceC2508h
        /* renamed from: a */
        public int mo902a() {
            return 0;
        }

        @Override // p205h.p208b.p209a.p212e.p216d.HomeFragment.InterfaceC2508h
        /* renamed from: a */
        public void mo901a(int i, int i2, int i3, boolean z) {
        }

        @Override // p205h.p208b.p209a.p212e.p216d.HomeFragment.InterfaceC2508h
        /* renamed from: a */
        public void mo900a(Snackbar snackbar) {
        }

        @Override // p205h.p208b.p209a.p212e.p216d.HomeFragment.InterfaceC2508h
        /* renamed from: a */
        public void mo899a(Snackbar snackbar, int i) {
        }

        @Override // p205h.p208b.p209a.p212e.p216d.HomeFragment.InterfaceC2508h
        /* renamed from: b */
        public void mo898b() {
        }
    }

    /* compiled from: HomeFragment.java */
    /* renamed from: h.b.a.e.d.n3$e */
    /* loaded from: classes.dex */
    public class C2505e extends Snackbar.C0587b {
        public C2505e() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.support.design.widget.BaseTransientBottomBar.AbstractC0556l
        /* renamed from: a */
        public void mo905a(Snackbar snackbar, int i) {
            super.mo906a(snackbar, i);
            HomeFragment.this.m915t0().mo899a(snackbar, i);
            HomeFragment.this.f10101n0 = null;
        }
    }

    /* compiled from: HomeFragment.java */
    /* renamed from: h.b.a.e.d.n3$f */
    /* loaded from: classes.dex */
    public class C2506f extends AnimatorListenerAdapter {
        public C2506f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            HomeFragment.this.f10097j0.setVisibility(8);
            HomeFragment.this.f9859a0.mo22a(false);
        }
    }

    /* compiled from: HomeFragment.java */
    /* renamed from: h.b.a.e.d.n3$g */
    /* loaded from: classes.dex */
    public class C2507g extends Drawable {

        /* renamed from: a */
        public final Paint f10115a = new Paint();

        /* renamed from: b */
        public int f10116b = -1;

        public C2507g() {
            m904a(HomeFragment.this.m914u0());
        }

        /* renamed from: a */
        public void m904a(int i) {
            this.f10115a.setColor(i);
            HomeFragment.this.f10093f0.setBackgroundColor(i);
            invalidateSelf();
        }

        /* renamed from: b */
        public void m903b(int i) {
            if (i != this.f10116b) {
                this.f10116b = i;
                invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            int i = this.f10116b;
            if (i == -1) {
                i = canvas.getHeight();
            }
            canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), i, this.f10115a);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    /* compiled from: HomeFragment.java */
    /* renamed from: h.b.a.e.d.n3$h */
    /* loaded from: classes.dex */
    public interface InterfaceC2508h {
        /* renamed from: a */
        int mo902a();

        /* renamed from: a */
        void mo901a(int i, int i2, int i3, boolean z);

        /* renamed from: a */
        void mo900a(Snackbar snackbar);

        /* renamed from: a */
        void mo899a(Snackbar snackbar, int i);

        /* renamed from: b */
        void mo898b();
    }

    /* renamed from: H0 */
    public static String m951H0() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return m931b(str2);
        }
        return m931b(str) + " " + str2;
    }

    /* renamed from: b */
    public static /* synthetic */ void m938b(View view) {
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: A0 */
    public final void m958A0() {
        if (PreferenceManager.getDefaultSharedPreferences(this.f9860b0).getBoolean("showProtectedAppsDialog", true)) {
            final Intent intent = null;
            Intent[] m1402n = Anda.m1443b(this.f9860b0).m1402n();
            int length = m1402n.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    Intent intent2 = m1402n[i];
                    if (intent2 != null && this.f9860b0.getPackageManager().resolveActivity(intent2, 65536) != null) {
                        intent = intent2;
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
            if (intent != null) {
                BackEnd.addToLog(String.format("[%s] openProtectedAppsDialog: Showing protected Apps dialog for the first time", "HomeFragment.class"));
                AlertDialog.C0325a c0325a = new AlertDialog.C0325a(this.f9860b0);
                int applyDimension = (int) TypedValue.applyDimension(1, 21.0f, this.f9860b0.getResources().getDisplayMetrics());
                LinearLayout linearLayout = new LinearLayout(this.f9860b0);
                linearLayout.setOrientation(1);
                int i2 = applyDimension / 4;
                linearLayout.setPadding(applyDimension, i2, applyDimension, i2);
                TextView textView = new TextView(this.f9860b0);
                textView.setText(C1444R.string.protected_apps_message);
                textView.setPadding(0, 0, 0, applyDimension / 3);
                linearLayout.addView(textView);
                final CheckBox checkBox = new CheckBox(this.f9860b0);
                checkBox.setText(C1444R.string.dont_show_again);
                linearLayout.addView(checkBox);
                c0325a.m9132b(linearLayout);
                c0325a.m9131b(this.f9860b0.getString(C1444R.string.protected_apps));
                c0325a.m9131b(this.f9860b0.getString(C1444R.string.protected_apps));
                c0325a.m9133b(17039370, new DialogInterface.OnClickListener() { // from class: h.b.a.e.d.o
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        HomeFragment.this.m945a(checkBox, intent, dialogInterface, i3);
                    }
                });
                c0325a.m9129c();
                return;
            }
            BackEnd.addToLog(String.format("[%s] openProtectedAppsActivity: Could not find a valid Activity", "HomeFragment.class"));
        }
    }

    /* renamed from: B0 */
    public final void m957B0() {
        m927d(new TripFragment());
    }

    /* renamed from: C0 */
    public void m956C0() {
        m932b((Runnable) null);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: D0 */
    public final void m955D0() {
        this.f10091d0 = this.f10090c0.m1447a(this.f9860b0.getString(C1444R.string.faq_loading), -1);
        this.f10091d0.mo7619m();
        this.f10097j0.getSettings().setJavaScriptEnabled(true);
        this.f10097j0.setWebViewClient(new C2502b());
        WebView webView = this.f10097j0;
        webView.loadUrl(this.f9860b0.getString(C1444R.string.faq_url) + "?r=" + StringHelper.m691a(8));
    }

    /* renamed from: E0 */
    public final void m954E0() {
        this.f10091d0 = this.f10090c0.m1447a(this.f9860b0.getString(C1444R.string.terms_and_conditions_loading), -1);
        this.f10091d0.mo7619m();
        BackEnd.getTermsAndConditions(new C2501a());
    }

    /* renamed from: F0 */
    public final void m953F0() {
        AlertDialog.C0325a c0325a = new AlertDialog.C0325a(this.f9860b0);
        int applyDimension = (int) TypedValue.applyDimension(1, 21.0f, this.f9860b0.getResources().getDisplayMetrics());
        LinearLayout linearLayout = new LinearLayout(this.f9860b0);
        linearLayout.setOrientation(1);
        int i = applyDimension / 4;
        linearLayout.setPadding(applyDimension, i, applyDimension, i);
        TextView textView = new TextView(this.f9860b0);
        textView.setText(C1444R.string.starttrip_warning_message);
        textView.setPadding(0, 0, 0, applyDimension / 3);
        linearLayout.addView(textView);
        final CheckBox checkBox = new CheckBox(this.f9860b0);
        checkBox.setText(C1444R.string.dont_show_again);
        linearLayout.addView(checkBox);
        c0325a.m9132b(linearLayout);
        c0325a.m9134b(C1444R.string.warning);
        c0325a.m9133b(17039370, new DialogInterface.OnClickListener() { // from class: h.b.a.e.d.s
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                HomeFragment.this.m946a(checkBox, dialogInterface, i2);
            }
        });
        c0325a.m9146a(17039360, (DialogInterface.OnClickListener) null);
        c0325a.m9138a(false);
        c0325a.m9129c();
    }

    /* renamed from: G0 */
    public final void m952G0() {
        AlertDialog.C0325a c0325a = new AlertDialog.C0325a(this.f9860b0);
        int applyDimension = (int) TypedValue.applyDimension(1, 21.0f, this.f9860b0.getResources().getDisplayMetrics());
        LinearLayout linearLayout = new LinearLayout(this.f9860b0);
        linearLayout.setOrientation(1);
        int i = applyDimension / 4;
        linearLayout.setPadding(applyDimension, i, applyDimension, i);
        TextView textView = new TextView(this.f9860b0);
        textView.setText(C1444R.string.devices_stop_working_hint);
        textView.setPadding(0, 0, 0, applyDimension / 3);
        linearLayout.addView(textView);
        final CheckBox checkBox = new CheckBox(this.f9860b0);
        checkBox.setText(C1444R.string.dont_show_again);
        linearLayout.addView(checkBox);
        c0325a.m9132b(linearLayout);
        c0325a.m9134b(C1444R.string.warning);
        c0325a.m9133b(17039370, new DialogInterface.OnClickListener() { // from class: h.b.a.e.d.u
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                HomeFragment.this.m937b(checkBox, dialogInterface, i2);
            }
        });
        c0325a.m9146a(17039360, (DialogInterface.OnClickListener) null);
        c0325a.m9138a(false);
        c0325a.m9129c();
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: U */
    public void mo897U() {
        this.f10090c0.m1435b((OngoingTrip.InterfaceC2364c) this);
        this.f10090c0.m1437b((ErrorListener) this);
        this.f10090c0.m1431c(this);
        this.f10090c0.m1400o().mo1277b(this);
        super.mo897U();
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: Y */
    public void mo887Y() {
        Menu menu = this.f10098k0.getMenu();
        int size = menu.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            } else if (menu.getItem(i2).isChecked()) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        this.f10099l0 = i;
        super.mo887Y();
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: Z */
    public void mo873Z() {
        super.mo873Z();
        Runnable runnable = this.f10100m0;
        if (runnable != null) {
            this.f10092e0.post(runnable);
            this.f10100m0 = null;
        }
        this.f10092e0.post(new Runnable() { // from class: h.b.a.e.d.e3
            @Override // java.lang.Runnable
            public final void run() {
                HomeFragment.this.m919p0();
            }
        });
    }

    @Override // p205h.p208b.p209a.p210d.AndaActionsListener
    /* renamed from: a */
    public Snackbar mo23a(String str, int i) {
        return null;
    }

    @Override // p205h.p208b.p209a.p210d.ErrorListener
    /* renamed from: a */
    public void mo31a(ErrorListener.EnumC2360b enumC2360b) {
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo30a(OngoingTrip ongoingTrip) {
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo26a(OngoingTrip ongoingTrip, Passing passing) {
    }

    @Override // p205h.p208b.p209a.p210d.AndaActionsListener
    /* renamed from: a */
    public void mo21a(boolean z, boolean z2) {
    }

    @Override // p205h.p208b.p209a.p210d.ErrorListener
    /* renamed from: b */
    public void mo17b(ErrorListener.EnumC2360b enumC2360b) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List<Fragment> mo10206c = m7453p().mo10206c();
        int size = mo10206c.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = mo10206c.get(i);
            if (fragment instanceof AbstractHomeFragment) {
                ((AbstractHomeFragment) fragment).mo998b(view);
            }
        }
    }

    @Override // p205h.p208b.p209a.p210d.AndaActionsListener
    @SuppressLint({"ApplySharedPref"})
    public void onTripAppActivityBlocked() {
        PreferenceManager.getDefaultSharedPreferences(this.f9860b0).edit().putBoolean("showProtectedAppsDialog", true).commit();
        m958A0();
    }

    @Override // p205h.p208b.p209a.p210d.AndaActionsListener
    public void onWakeUpRequired() {
    }

    /* renamed from: p0 */
    public void m919p0() {
        if (m7468j() == null) {
            return;
        }
        for (Fragment fragment : m7453p().mo10206c()) {
            if (fragment instanceof AbstractHomeFragment) {
                m935b((AbstractHomeFragment) fragment);
            }
        }
    }

    /* renamed from: q0 */
    public void m918q0() {
        m932b(new Runnable() { // from class: h.b.a.e.d.p
            @Override // java.lang.Runnable
            public final void run() {
                HomeFragment.this.m913v0();
            }
        });
    }

    /* renamed from: r0 */
    public int m917r0() {
        return this.f10096i0.getHeight() - this.f10094g0.getHeight();
    }

    /* renamed from: s0 */
    public int m916s0() {
        return this.f10098k0.getHeight();
    }

    /* renamed from: t0 */
    public InterfaceC2508h m915t0() {
        return this.f10104q0;
    }

    /* renamed from: u0 */
    public final int m914u0() {
        TypedValue typedValue = new TypedValue();
        m7468j().getTheme().resolveAttribute(C1444R.attr.colorPrimary, typedValue, true);
        return typedValue.data;
    }

    /* renamed from: v0 */
    public /* synthetic */ void m913v0() {
        Fragment m950a = m950a(m7453p());
        if (m950a == null || !(m950a instanceof TripFragment)) {
            return;
        }
        ((TripFragment) m950a).m1070t0();
    }

    /* renamed from: w0 */
    public /* synthetic */ void m912w0() {
        m915t0().mo900a(this.f10101n0);
    }

    /* renamed from: x0 */
    public final void m911x0() {
        m927d(new FaresFragment());
    }

    /* renamed from: y0 */
    public final void m910y0() {
        m927d(new HistoryFragment());
    }

    /* renamed from: z0 */
    public final void m909z0() {
        m927d(new InspectionFragment());
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: c */
    public void mo728c(Bundle bundle) {
        super.mo728c(bundle);
        this.f10090c0 = Anda.m1443b(m7452q());
        if (!this.f10090c0.m1400o().mo1284a()) {
            m1152c((Fragment) new IntroFragment());
            return;
        }
        this.f10090c0.m1450a((OngoingTrip.InterfaceC2364c) this);
        this.f10090c0.m1454a((ErrorListener) this);
        this.f10090c0.m1457a((AndaActionsListener) this);
        this.f10090c0.m1400o().mo1281a(this);
        m958A0();
        if ((m951H0().contains("Pixel") || m951H0().contains("Nexus")) && PreferenceManager.getDefaultSharedPreferences(this.f9860b0).getBoolean("showPixelNexusWarningDialog", true)) {
            m952G0();
        }
    }

    /* renamed from: d */
    public final void m927d(Fragment fragment) {
        if (m7468j() == null) {
            return;
        }
        FragmentManager m7453p = m7453p();
        Fragment m950a = m950a(m7453p);
        if (m950a == null || m950a.getClass() != fragment.getClass()) {
            List<Fragment> mo10206c = m7453p.mo10206c();
            FragmentTransaction mo10264a = m7453p.mo10264a();
            if (mo10206c != null) {
                for (Fragment fragment2 : mo10206c) {
                    if (fragment2 != null) {
                        mo10264a.mo10143a(fragment2);
                    }
                }
            }
            mo10264a.mo10139b(C1444R.C1446id.content, fragment);
            mo10264a.mo10146a();
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: e */
    public void mo924e(Bundle bundle) {
        super.mo924e(bundle);
        Menu menu = this.f10098k0.getMenu();
        int size = menu.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            } else if (menu.getItem(i2).isChecked()) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        bundle.putInt("p", i);
    }

    /* renamed from: f */
    public /* synthetic */ void m922f(MenuItem menuItem) {
        mo735a(menuItem);
        m919p0();
    }

    /* renamed from: b */
    public static String m931b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (char c : charArray) {
            if (z && Character.isLetter(c)) {
                sb.append(Character.toUpperCase(c));
                z = false;
            } else {
                if (Character.isWhitespace(c)) {
                    z = true;
                }
                sb.append(c);
            }
        }
        return sb.toString();
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public View mo717a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Anda.m1443b(this.f9860b0).m1465a(m7468j(), false);
        m7481f(true);
        View inflate = layoutInflater.inflate(C1444R.layout.fragment_home, viewGroup, false);
        this.f10092e0 = inflate;
        Toolbar toolbar = (Toolbar) inflate.findViewById(C1444R.C1446id.toolbar);
        this.f10094g0 = toolbar;
        AppCompatActivity appCompatActivity = (AppCompatActivity) m7468j();
        ((AppCompatActivity) Objects.requireNonNull(appCompatActivity)).m9125a(toolbar);
        appCompatActivity.m9119l().mo8991d(false);
        this.f10093f0 = (AppBarLayout) inflate.findViewById(C1444R.C1446id.appbar);
        this.f10093f0.setBackgroundColor(m914u0());
        this.f10096i0 = inflate.findViewById(C1444R.C1446id.background);
        View view = this.f10096i0;
        C2507g c2507g = this.f10095h0;
        if (c2507g == null) {
            c2507g = new C2507g();
            this.f10095h0 = c2507g;
        }
        view.setBackground(c2507g);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) inflate.findViewById(C1444R.C1446id.navigation);
        this.f10098k0 = bottomNavigationView;
        this.f10097j0 = (WebView) inflate.findViewById(C1444R.C1446id.webView);
        if (this.f10090c0.m1492A()) {
            this.f10095h0.m904a(-13070788);
        }
        if (bundle == null && this.f10099l0 == 0) {
            m957B0();
        } else {
            final MenuItem item = bottomNavigationView.getMenu().getItem(bundle == null ? this.f10099l0 : bundle.getInt("p"));
            item.setChecked(true);
            inflate.post(new Runnable() { // from class: h.b.a.e.d.r
                @Override // java.lang.Runnable
                public final void run() {
                    HomeFragment.this.m922f(item);
                }
            });
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        return inflate;
    }

    /* renamed from: e */
    public void m925e(int i) {
        float f;
        int height = this.f10094g0.getHeight();
        if (i == -1) {
            f = 0.0f;
        } else {
            int[] iArr = new int[2];
            this.f10094g0.getLocationInWindow(iArr);
            f = 1.0f - (i / ((iArr[1] + height) / 3));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            ObjectAnimator objectAnimator = this.f10103p0;
            boolean z = objectAnimator != null;
            if (f <= 0.0f) {
                if (!z || !objectAnimator.isRunning() || (objectAnimator.isRunning() && objectAnimator.getDuration() != 120)) {
                    if (z) {
                        objectAnimator.cancel();
                        this.f10103p0 = null;
                    }
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f10093f0, "elevation", TypedValue.applyDimension(1, 8.0f, m7549B().getDisplayMetrics()));
                    ofFloat.setDuration(120L).start();
                    this.f10103p0 = ofFloat;
                    f = 0.0f;
                }
            } else if (!z || !objectAnimator.isRunning() || (objectAnimator.isRunning() && objectAnimator.getDuration() != 160)) {
                if (z) {
                    objectAnimator.cancel();
                    this.f10103p0 = null;
                }
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f10093f0, "elevation", 0.0f);
                ofFloat2.setDuration(160L).start();
                this.f10103p0 = ofFloat2;
            }
        }
        int height2 = this.f10096i0.getHeight() - height;
        this.f10096i0.setVisibility(f <= 0.0f ? 8 : 0);
        this.f10095h0.m903b((int) (height + (height2 * f)));
    }

    /* renamed from: b */
    public /* synthetic */ void m937b(CheckBox checkBox, DialogInterface dialogInterface, int i) {
        if (checkBox.isChecked()) {
            PreferenceManager.getDefaultSharedPreferences(this.f9860b0).edit().putBoolean("showPixelNexusWarningDialog", false).apply();
            Log.d("HomeFragment.class", "The user chose not to show the start dialog again. Saved to preferences");
        }
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: d */
    public void mo10d(OngoingTrip ongoingTrip) {
        this.f10095h0.m904a(-13070788);
        if (PreferenceManager.getDefaultSharedPreferences(this.f9860b0).getBoolean("showDialogStartTrip", true)) {
            m953F0();
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: c */
    public boolean mo930c(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case C1444R.C1446id.contacts /* 2131230839 */:
                Fragment contactsFragment = new ContactsFragment();
                contactsFragment.mo1200a(new ExplodeVertically());
                contactsFragment.m7494c(new Fade(2).setDuration(150L));
                m7498b(new ExplodeVertically());
                m1153b(contactsFragment);
                return true;
            case C1444R.C1446id.help /* 2131230908 */:
                m955D0();
                return true;
            case C1444R.C1446id.profile /* 2131231003 */:
                if (!Anda.m1467X().m1487D()) {
                    Toast.makeText(this.f9860b0, m7528a(C1444R.string.loading_userdata_not_ready), 0).show();
                    return false;
                }
                Fragment profileFragment = new ProfileFragment();
                profileFragment.mo1200a(new ExplodeVertically());
                profileFragment.m7494c(new Fade(2).setDuration(150L));
                m7498b(new ExplodeVertically());
                m1153b(profileFragment);
                return true;
            case C1444R.C1446id.report /* 2131231016 */:
                FragmentManager m7447v = m7447v();
                if (m7447v != null) {
                    ReportDialogFragment reportDialogFragment = new ReportDialogFragment();
                    reportDialogFragment.m1177b(m7543H());
                    reportDialogFragment.mo5624a(m7447v, "report");
                }
                return true;
            case C1444R.C1446id.settings /* 2131231066 */:
                View$OnClickListenerC2417e4 view$OnClickListenerC2417e4 = new View$OnClickListenerC2417e4();
                view$OnClickListenerC2417e4.mo1200a(new Fade(1));
                view$OnClickListenerC2417e4.m7498b(new Fade(2));
                m7498b(new ExplodeVertically());
                if (m7468j() instanceof NavigationActivity) {
                    view$OnClickListenerC2417e4.m1170a((NavigationActivity) m7468j());
                }
                m1153b((Fragment) view$OnClickListenerC2417e4);
                return true;
            case C1444R.C1446id.termsAndConditions /* 2131231132 */:
                m954E0();
                return true;
            default:
                return super.mo930c(menuItem);
        }
    }

    /* renamed from: d */
    public void m928d(int i) {
        OngoingTrip.InterfaceC2364c.AbstractRunnableC2365a mo1301a;
        OngoingTrip m1404m = this.f10090c0.m1404m();
        if (m1404m == null || (mo1301a = m1404m.mo1301a()) == null) {
            return;
        }
        if (i == -1) {
            mo1301a.m1297a();
        } else if (i != 0) {
            if (i != 1) {
                return;
            }
            mo1301a.m1293c();
        } else {
            AlertDialog alertDialog = this.f10102o0;
            if (alertDialog == null || !alertDialog.isShowing()) {
                mo27a(m1404m, mo1301a);
            }
        }
    }

    /* renamed from: b */
    public void m932b(final Runnable runnable) {
        Runnable runnable2 = new Runnable() { // from class: h.b.a.e.d.n
            @Override // java.lang.Runnable
            public final void run() {
                HomeFragment.this.m939a(runnable);
            }
        };
        if (m7534Q()) {
            this.f10092e0.post(runnable2);
        } else {
            this.f10100m0 = runnable2;
        }
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: b */
    public void mo16b(OngoingTrip ongoingTrip) {
        AlertDialog alertDialog = this.f10102o0;
        if (alertDialog != null) {
            alertDialog.cancel();
        }
    }

    @Override // p205h.p208b.p209a.p210d.AndaActionsListener
    /* renamed from: b */
    public void mo20b() {
        WebView webView = this.f10097j0;
        if (webView == null || webView.getVisibility() != 0) {
            return;
        }
        this.f10097j0.animate().alpha(0.0f).setDuration(200L).setListener(new C2506f());
    }

    /* renamed from: a */
    public /* synthetic */ void m945a(CheckBox checkBox, Intent intent, DialogInterface dialogInterface, int i) {
        if (checkBox.isChecked()) {
            PreferenceManager.getDefaultSharedPreferences(this.f9860b0).edit().putBoolean("showProtectedAppsDialog", false).commit();
        } else {
            BackEnd.addToLog(String.format("[%s] openProtectedAppsActivity: (Don't show again) wasn't checked", "HomeFragment.class"));
        }
        this.f9860b0.startActivity(intent);
    }

    @Override // p205h.p208b.p209a.p212e.p216d.AbstractFragment, android.support.p065v4.app.Fragment
    /* renamed from: a */
    public void mo778a(Context context) {
        super.mo778a(context);
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public void mo948a(Fragment fragment) {
        super.mo948a(fragment);
        View view = this.f10092e0;
        if (view != null && (fragment instanceof AbstractHomeFragment)) {
            final AbstractHomeFragment abstractHomeFragment = (AbstractHomeFragment) fragment;
            view.post(new Runnable() { // from class: h.b.a.e.d.x
                @Override // java.lang.Runnable
                public final void run() {
                    HomeFragment.this.m935b(abstractHomeFragment);
                }
            });
        }
    }

    /* renamed from: a */
    public final void m935b(AbstractHomeFragment abstractHomeFragment) {
        abstractHomeFragment.mo892p0();
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public void mo947a(Menu menu, MenuInflater menuInflater) {
        super.mo947a(menu, menuInflater);
        menuInflater.inflate(C1444R.C1447menu.menu_home, menu);
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: c */
    public void mo12c(OngoingTrip ongoingTrip) {
        Log.d("HomeFragment.class", "onConfirmStageFinished() was called");
        AlertDialog alertDialog = this.f10102o0;
        if (alertDialog != null) {
            alertDialog.cancel();
        }
    }

    @Override // android.support.design.widget.BottomNavigationView.InterfaceC0564c
    /* renamed from: a */
    public boolean mo735a(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case C1444R.C1446id.fares /* 2131230885 */:
                m911x0();
                return true;
            case C1444R.C1446id.history /* 2131230910 */:
                m910y0();
                return true;
            case C1444R.C1446id.inspection /* 2131230925 */:
                m909z0();
                return true;
            case C1444R.C1446id.trip /* 2131231163 */:
                m957B0();
                return true;
            default:
                return false;
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m939a(Runnable runnable) {
        Menu menu = this.f10098k0.getMenu();
        menu.performIdentifierAction(C1444R.C1446id.trip, 0);
        menu.getItem(0).setChecked(true);
        if (runnable != null) {
            this.f10092e0.post(runnable);
        }
    }

    /* renamed from: a */
    public final Fragment m950a(FragmentManager fragmentManager) {
        List<Fragment> mo10206c = fragmentManager.mo10206c();
        if (mo10206c == null) {
            return null;
        }
        for (int size = mo10206c.size() - 1; size >= 0; size--) {
            if (mo10206c.get(size) != null) {
                return mo10206c.get(size);
            }
        }
        return null;
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo29a(OngoingTrip ongoingTrip, ErrorListener.C2358a c2358a) {
        mo32a(c2358a);
    }

    /* renamed from: a */
    public /* synthetic */ void m946a(CheckBox checkBox, DialogInterface dialogInterface, int i) {
        if (checkBox.isChecked()) {
            PreferenceManager.getDefaultSharedPreferences(this.f9860b0).edit().putBoolean("showDialogStartTrip", false).apply();
            Log.d("HomeFragment.class", "The user chose not to show the start dialog again. Saved to preferences");
        }
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo28a(OngoingTrip ongoingTrip, OngoingTrip.C2362a c2362a) {
        this.f10095h0.m904a(-13615201);
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo27a(OngoingTrip ongoingTrip, final OngoingTrip.InterfaceC2364c.AbstractRunnableC2365a abstractRunnableC2365a) {
        AlertDialog.C0325a c0325a = new AlertDialog.C0325a(this.f9860b0);
        View inflate = View.inflate(this.f9860b0, C1444R.layout.dialog_confirmtripend, null);
        c0325a.m9134b(C1444R.string.trip_action_end);
        c0325a.m9132b(inflate);
        c0325a.m9133b(C1444R.string.trip_action_end, new DialogInterface.OnClickListener() { // from class: h.b.a.e.d.v
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                OngoingTrip.InterfaceC2364c.AbstractRunnableC2365a.this.m1293c();
            }
        });
        c0325a.m9146a(C1444R.string.f6337no, new DialogInterface.OnClickListener() { // from class: h.b.a.e.d.t
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                OngoingTrip.InterfaceC2364c.AbstractRunnableC2365a.this.m1297a();
            }
        });
        c0325a.m9138a(false);
        c0325a.m9145a(new DialogInterface.OnDismissListener() { // from class: h.b.a.e.d.y
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                HomeFragment.this.m949a(dialogInterface);
            }
        });
        this.f10102o0 = c0325a.m9129c();
        inflate.post(new RunnableC2503c((TextView) inflate.findViewById(C1444R.C1446id.time), abstractRunnableC2365a, inflate));
    }

    /* renamed from: a */
    public /* synthetic */ void m949a(DialogInterface dialogInterface) {
        this.f10102o0 = null;
    }

    @Override // p205h.p208b.p209a.p210d.Session.InterfaceC2370e
    /* renamed from: a */
    public void mo943a(User user) {
        m1151n0();
        m1154a((Fragment) new IntroFragment(), false);
    }

    @Override // p205h.p208b.p209a.p210d.ErrorListener
    /* renamed from: a */
    public void mo32a(ErrorListener.C2358a c2358a) {
        ErrorListener.C2358a.EnumC2359a m1323b = c2358a.m1323b();
        if (m1323b == ErrorListener.C2358a.EnumC2359a.missingData || m1323b == ErrorListener.C2358a.EnumC2359a.bluetoothOff || m1323b == ErrorListener.C2358a.EnumC2359a.locationOff || m1323b == ErrorListener.C2358a.EnumC2359a.nfcOff || m1323b == ErrorListener.C2358a.EnumC2359a.hceError || m1323b == ErrorListener.C2358a.EnumC2359a.hceOff || m1323b == ErrorListener.C2358a.EnumC2359a.hce_notAuthorized || m1323b == ErrorListener.C2358a.EnumC2359a.noInternet || m1323b == ErrorListener.C2358a.EnumC2359a.paymentMethod_missing || m1323b == ErrorListener.C2358a.EnumC2359a.paymentMethod_invalid || m1323b == ErrorListener.C2358a.EnumC2359a.invalidEquipment || m1323b == ErrorListener.C2358a.EnumC2359a.account_notConfirmed || m1323b == ErrorListener.C2358a.EnumC2359a.card_not_enrolled || m1323b == ErrorListener.C2358a.EnumC2359a.failed_to_enroll_card) {
            return;
        }
        String m1322c = c2358a.m1322c();
        Anda anda = this.f10090c0;
        this.f10091d0 = anda.m1447a(this.f9860b0.getString(C1444R.string.error) + ": " + m1322c, -2);
        Snackbar snackbar = this.f10091d0;
        this.f10101n0 = snackbar;
        snackbar.m7629a(17039370, View$OnClickListenerC2570w.f10297a);
        snackbar.m7621f(-12532481);
        Snackbar snackbar2 = this.f10091d0;
        snackbar2.m7802a(new C2505e());
        snackbar2.mo7619m();
        this.f10092e0.postDelayed(new Runnable() { // from class: h.b.a.e.d.q
            @Override // java.lang.Runnable
            public final void run() {
                HomeFragment.this.m912w0();
            }
        }, 50L);
        c2358a.m1320e();
    }
}
