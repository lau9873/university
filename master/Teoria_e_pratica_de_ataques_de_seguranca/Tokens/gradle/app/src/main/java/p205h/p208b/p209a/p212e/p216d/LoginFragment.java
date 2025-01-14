package p205h.p208b.p209a.p212e.p216d;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.p065v4.app.Fragment;
import android.transition.Slide;
import android.transition.Transition;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.hbb20.C1444R;
import p000a.p006b.p030g.p031a.FragmentActivity;
import p000a.p006b.p030g.p031a.FragmentManager;
import p000a.p006b.p030g.p032b.ContextCompat;
import p000a.p006b.p030g.p045k.GravityCompat;
import p000a.p006b.p030g.p045k.p047f0.FastOutLinearInInterpolator;
import p000a.p006b.p030g.p045k.p047f0.LinearOutSlowInInterpolator;
import p205h.p208b.p209a.Anda;
import p205h.p208b.p209a.p210d.AsyncResult;
import p205h.p208b.p209a.p210d.Session;
import p205h.p208b.p209a.p212e.p214b.Interpolators;
import pt.card4b.backendbeacons.BackEnd;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.b.a.e.d.r3 */
/* loaded from: classes.dex */
public class LoginFragment extends AbstractFragment implements View.OnClickListener, AsyncResult.InterfaceC2279a<Session.C2366a>, TextView.OnEditorActionListener {

    /* renamed from: c0 */
    public Anda f10178c0;

    /* renamed from: d0 */
    public Interpolator f10179d0;

    /* renamed from: e0 */
    public TextInputLayout f10180e0;

    /* renamed from: f0 */
    public boolean f10181f0 = false;

    /* renamed from: g0 */
    public int f10182g0 = 0;

    /* compiled from: LoginFragment.java */
    /* renamed from: h.b.a.e.d.r3$a */
    /* loaded from: classes.dex */
    public class C2529a implements BackendListeners.ResetPasswordRequestListener {

        /* renamed from: a */
        public final /* synthetic */ View f10183a;

        public C2529a(View view) {
            this.f10183a = view;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            TextView textView = (TextView) LoginFragment.this.m7543H().findViewById(C1444R.C1446id.error);
            textView.setText(error.getMessageToUser());
            textView.setVisibility(0);
            textView.setTranslationY(-textView.getHeight());
            textView.animate().alpha(1.0f).translationY(0.0f).setInterpolator(Interpolators.f9741b).setDuration(120L);
            LoginFragment.this.m869a(this.f10183a, new FastOutLinearInInterpolator(), (View) null, false);
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.ResetPasswordRequestListener
        public void onSuccess() {
            Toast.makeText(LoginFragment.this.f9860b0, (int) C1444R.string.user_action_recover_checkEmail, 1).show();
            LoginFragment.this.m869a(this.f10183a, new FastOutLinearInInterpolator(), (View) null, false);
        }
    }

    /* compiled from: LoginFragment.java */
    /* renamed from: h.b.a.e.d.r3$b */
    /* loaded from: classes.dex */
    public class RunnableC2530b implements Runnable {
        public RunnableC2530b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LoginFragment.this.m852s0();
        }
    }

    public LoginFragment() {
    }

    /* renamed from: b */
    public static /* synthetic */ void m863b(DialogInterface dialogInterface, int i) {
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: Z */
    public void mo873Z() {
        super.mo873Z();
        FragmentActivity m7468j = m7468j();
        if (m7468j != null) {
            m7468j.getWindow().setSoftInputMode(32);
        }
    }

    /* renamed from: b */
    public /* synthetic */ void m860b(AsyncResult asyncResult) {
        m857c((AsyncResult<Session.C2366a>) asyncResult);
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: c */
    public void mo728c(Bundle bundle) {
        super.mo728c(bundle);
        this.f10178c0 = Anda.m1443b(this.f9860b0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f10179d0 == null) {
            this.f10179d0 = Interpolators.f9740a;
        }
        if (view != null && view.getId() != C1444R.C1446id.login) {
            if (view.getId() == C1444R.C1446id.recover) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this.f9860b0);
                builder.setTitle(C1444R.string.reset_password);
                builder.setMessage(m7528a(C1444R.string.reset_password_confirm));
                builder.setCancelable(false);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: h.b.a.e.d.k0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        LoginFragment.this.m871a(dialogInterface, i);
                    }
                });
                builder.setNegativeButton(17039360, DialogInterface$OnClickListenerC2460i0.f9955a);
                builder.show();
            } else if (view.getId() == C1444R.C1446id.closeRecover) {
            } else {
                m851t0();
            }
        } else if (Build.VERSION.SDK_INT >= 23 && ContextCompat.m10021a(this.f9860b0, "android.permission.READ_PHONE_STATE") != 0) {
            m7506a(new String[]{"android.permission.READ_PHONE_STATE"}, 1);
        } else if (this.f10181f0) {
            m849v0();
        } else {
            Anda m1443b = Anda.m1443b(this.f9860b0);
            if (m1443b.m1392s()) {
                Toast.makeText(m7468j(), (int) C1444R.string.error_fetchingData_hint, 0).show();
            } else if (m1443b.m1398p()) {
                if (!m1443b.m1392s() && !m1443b.m1490B()) {
                    m1443b.m1477N();
                }
                Toast.makeText(m7468j(), (int) C1444R.string.error_checkNetwork_hint, 0).show();
            } else {
                m850u0();
            }
        }
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 2) {
            onClick(null);
            return true;
        }
        return false;
    }

    /* renamed from: r0 */
    public final void m854q0() {
        View m7543H = m7543H();
        if (m7543H == null) {
            return;
        }
        FastOutLinearInInterpolator fastOutLinearInInterpolator = new FastOutLinearInInterpolator();
        View findViewById = m7543H.findViewById(C1444R.C1446id.vehicle);
        m7543H.findViewById(C1444R.C1446id.progress).animate().scaleX(0.8f).scaleY(0.8f).alpha(0.0f).setInterpolator(fastOutLinearInInterpolator);
        ((FloatingActionButton) m7543H.findViewById(C1444R.C1446id.login)).setBackgroundTintList(ColorStateList.valueOf(-13070788));
        findViewById.animate().translationX(m7543H.getWidth()).setDuration(800L).setInterpolator(Interpolators.f9741b).withEndAction(new RunnableC2530b());
    }

    /* renamed from: s0 */
    public final void m852s0() {
        if (Build.VERSION.SDK_INT >= 21) {
            m7498b(new Slide(GravityCompat.m9579a(8388613, m7549B().getConfiguration().getLayoutDirection())));
        }
        final View m7543H = m7543H();
        m7543H.findViewById(C1444R.C1446id.register).setVisibility(8);
        m7543H.post(new Runnable() { // from class: h.b.a.e.d.m0
            @Override // java.lang.Runnable
            public final void run() {
                LoginFragment.this.m859c(m7543H);
            }
        });
    }

    /* renamed from: t0 */
    public void m851t0() {
        RegisterFragment registerFragment = new RegisterFragment();
        registerFragment.mo1200a((Object) null);
        m1153b((Fragment) registerFragment);
    }

    /* renamed from: u0 */
    public void m850u0() {
        final View m7543H = m7543H();
        TextInputLayout textInputLayout = (TextInputLayout) m7543H.findViewById(C1444R.C1446id.username);
        TextInputLayout textInputLayout2 = (TextInputLayout) m7543H.findViewById(C1444R.C1446id.password);
        LinearOutSlowInInterpolator linearOutSlowInInterpolator = Interpolators.f9741b;
        m867a(m7543H, textInputLayout, textInputLayout2, linearOutSlowInInterpolator);
        View findViewById = m7543H.findViewById(C1444R.C1446id.ground);
        findViewById.setVisibility(0);
        findViewById.animate().alpha(1.0f);
        View findViewById2 = m7543H.findViewById(C1444R.C1446id.vehicle);
        findViewById2.setVisibility(0);
        findViewById2.setAlpha(1.0f);
        findViewById2.setTranslationY(0.0f);
        findViewById2.setTranslationX(-findViewById2.getWidth());
        findViewById2.animate().translationX((m7543H.getWidth() / 3) - (findViewById2.getWidth() / 2)).setDuration(800L).setInterpolator(this.f10179d0);
        m868a(m7543H, linearOutSlowInInterpolator);
        this.f10178c0.m1400o().mo1279a(textInputLayout.getEditText().getText().toString(), textInputLayout2.getEditText().getText().toString()).m1375a(new AsyncResult.InterfaceC2279a() { // from class: h.b.a.e.d.f0
            @Override // p205h.p208b.p209a.p210d.AsyncResult.InterfaceC2279a
            /* renamed from: a */
            public final void mo723a(AsyncResult asyncResult) {
                LoginFragment.this.m858c(m7543H, asyncResult);
            }
        });
    }

    /* renamed from: v0 */
    public final void m849v0() {
        View m7543H = m7543H();
        TextInputLayout textInputLayout = (TextInputLayout) m7543H.findViewById(C1444R.C1446id.username);
        if (textInputLayout.getEditText().getText().toString().isEmpty()) {
            Toast.makeText(this.f9860b0, (int) C1444R.string.user_action_recover_password_missing_email, 1).show();
            return;
        }
        LinearOutSlowInInterpolator linearOutSlowInInterpolator = Interpolators.f9741b;
        m868a(m7543H, linearOutSlowInInterpolator);
        m867a(m7543H, textInputLayout, this.f10180e0, linearOutSlowInInterpolator);
        BackEnd.resetUserPassword(textInputLayout.getEditText().getText().toString(), new C2529a(m7543H));
    }

    /* renamed from: b */
    public /* synthetic */ void m861b(View view, AsyncResult asyncResult) {
        view.post(new Runnable() { // from class: h.b.a.e.d.e0
            @Override // java.lang.Runnable
            public final void run() {
                LoginFragment.this.m854q0();
            }
        });
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public View mo717a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1444R.layout.fragment_login, viewGroup, false);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(C1444R.C1446id.register);
        if (Anda.m1443b(this.f9860b0).m1409k() != null) {
            linearLayout.setVisibility(4);
        } else {
            linearLayout.setOnClickListener(this);
            inflate.findViewById(C1444R.C1446id.bRegister).setOnClickListener(this);
        }
        inflate.findViewById(C1444R.C1446id.login).setOnClickListener(this);
        inflate.findViewById(C1444R.C1446id.recover).setOnClickListener(this);
        final TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(C1444R.C1446id.username);
        this.f10180e0 = (TextInputLayout) inflate.findViewById(C1444R.C1446id.password);
        EditText editText = this.f10180e0.getEditText();
        editText.setOnEditorActionListener(this);
        Bundle m7454o = m7454o();
        if (m7454o == null) {
            String string = PreferenceManager.getDefaultSharedPreferences(this.f9860b0).getString("lastUsername", null);
            if (string != null) {
                textInputLayout.setEnabled(false);
                textInputLayout.getEditText().setText(string);
            }
        } else {
            textInputLayout.getEditText().setText(m7454o.getString("username"));
            textInputLayout.setEnabled(false);
            editText.setText(m7454o.getString("password"));
        }
        final Transition transition = (Transition) m7451r();
        inflate.postDelayed(new Runnable() { // from class: h.b.a.e.d.p0
            @Override // java.lang.Runnable
            public final void run() {
                LoginFragment.this.m870a(transition, textInputLayout);
            }
        }, 500L);
        return inflate;
    }

    /* renamed from: b */
    public /* synthetic */ void m862b(View view) {
        view.post(new Runnable() { // from class: h.b.a.e.d.a
            @Override // java.lang.Runnable
            public final void run() {
                LoginFragment.this.m1151n0();
            }
        });
    }

    /* renamed from: c */
    public /* synthetic */ void m858c(View view, final AsyncResult asyncResult) {
        view.post(new Runnable() { // from class: h.b.a.e.d.g0
            @Override // java.lang.Runnable
            public final void run() {
                LoginFragment.this.m860b(asyncResult);
            }
        });
    }

    @SuppressLint({"ValidFragment"})
    public LoginFragment(String str, String str2) {
        Bundle bundle = new Bundle(2);
        bundle.putString("username", str);
        bundle.putString("password", str2);
        m7457m(bundle);
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: c */
    public final void m857c(AsyncResult<Session.C2366a> asyncResult) {
        final View m7543H = m7543H();
        if (m7543H == null) {
            return;
        }
        FastOutLinearInInterpolator fastOutLinearInInterpolator = new FastOutLinearInInterpolator();
        View findViewById = m7543H.findViewById(C1444R.C1446id.vehicle);
        Session.C2366a mo1334a = asyncResult.mo1334a();
        if (mo1334a.m1268c()) {
            findViewById.animate().translationX(((m7543H.getWidth() * 2) / 3) - (findViewById.getWidth() / 2)).setDuration(800L).setInterpolator(this.f10179d0);
            PreferenceManager.getDefaultSharedPreferences(this.f9860b0).edit().putString("lastUsername", mo1334a.m1273d()).commit();
            this.f10178c0.m1400o().mo1278b().mo1250a(null).m1375a(new AsyncResult.InterfaceC2279a() { // from class: h.b.a.e.d.h0
                @Override // p205h.p208b.p209a.p210d.AsyncResult.InterfaceC2279a
                /* renamed from: a */
                public final void mo723a(AsyncResult asyncResult2) {
                    LoginFragment.this.m866a(m7543H, asyncResult2);
                }
            });
            return;
        }
        this.f10182g0++;
        if (this.f10182g0 == 3) {
            FragmentManager m7447v = m7447v();
            if (m7447v != null) {
                ReportDialogFragment reportDialogFragment = new ReportDialogFragment();
                reportDialogFragment.m1177b(m7543H());
                reportDialogFragment.mo5624a(m7447v, "report");
            }
            this.f10182g0 = 0;
        }
        Anda.m1443b(this.f9860b0).m1409k();
        m869a(m7543H, fastOutLinearInInterpolator, findViewById, false);
        TextView textView = (TextView) m7543H.findViewById(C1444R.C1446id.error);
        String mo1269b = mo1334a.mo1269b();
        if (mo1269b != null && mo1269b.length() > 0) {
            textView.setText(mo1269b);
        } else {
            textView.setText(C1444R.string.error);
        }
        textView.setVisibility(0);
        textView.setTranslationY(-textView.getHeight());
        textView.animate().alpha(1.0f).translationY(0.0f).setInterpolator(Interpolators.f9741b).setDuration(120L);
    }

    /* renamed from: a */
    public /* synthetic */ void m870a(Transition transition, TextInputLayout textInputLayout) {
        if (transition != null) {
            transition.setStartDelay(0L);
        }
        if (m7468j() == null) {
            return;
        }
        textInputLayout.setHint(this.f9860b0.getString(C1444R.string.user_email));
        this.f10180e0.setHint(this.f9860b0.getString(C1444R.string.user_password));
    }

    /* renamed from: a */
    public /* synthetic */ void m871a(DialogInterface dialogInterface, int i) {
        m849v0();
    }

    /* renamed from: a */
    public void m868a(View view, LinearOutSlowInInterpolator linearOutSlowInInterpolator) {
        final View findViewById = view.findViewById(C1444R.C1446id.error);
        if (findViewById.getAlpha() > 0.0f) {
            findViewById.animate().alpha(0.0f).translationY(-findViewById.getHeight()).setInterpolator(linearOutSlowInInterpolator).withEndAction(new Runnable() { // from class: h.b.a.e.d.l0
                @Override // java.lang.Runnable
                public final void run() {
                    findViewById.setVisibility(8);
                }
            });
        }
    }

    /* renamed from: c */
    public /* synthetic */ void m859c(final View view) {
        view.post(new Runnable() { // from class: h.b.a.e.d.o0
            @Override // java.lang.Runnable
            public final void run() {
                LoginFragment.this.m862b(view);
            }
        });
    }

    /* renamed from: a */
    public void m867a(View view, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, LinearOutSlowInInterpolator linearOutSlowInInterpolator) {
        textInputLayout.setEnabled(false);
        textInputLayout2.setEnabled(false);
        view.findViewById(C1444R.C1446id.login).setEnabled(false);
        view.findViewById(C1444R.C1446id.recover).setEnabled(false);
        if (Build.VERSION.SDK_INT >= 21) {
            view.findViewById(C1444R.C1446id.progress).animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setInterpolator(linearOutSlowInInterpolator);
        } else {
            view.findViewById(C1444R.C1446id.progress).animate().scaleX(1.2f).scaleY(1.2f).alpha(1.0f).setInterpolator(linearOutSlowInInterpolator);
        }
        View findViewById = view.findViewById(C1444R.C1446id.register);
        findViewById.animate().alpha(0.0f).translationY(findViewById.getHeight()).setDuration(160L).setInterpolator(linearOutSlowInInterpolator);
    }

    /* renamed from: a */
    public /* synthetic */ void m866a(View view, AsyncResult asyncResult) {
        view.post(new Runnable() { // from class: h.b.a.e.d.n0
            @Override // java.lang.Runnable
            public final void run() {
                LoginFragment.this.m855p0();
            }
        });
    }

    @Override // p205h.p208b.p209a.p210d.AsyncResult.InterfaceC2279a
    @SuppressLint({"ApplySharedPref"})
    /* renamed from: a */
    public void mo723a(AsyncResult<Session.C2366a> asyncResult) {
        final View m7543H = m7543H();
        if (m7543H == null) {
            return;
        }
        FastOutLinearInInterpolator fastOutLinearInInterpolator = new FastOutLinearInInterpolator();
        View findViewById = m7543H.findViewById(C1444R.C1446id.vehicle);
        Session.C2366a mo1334a = asyncResult.mo1334a();
        if (mo1334a.m1268c()) {
            findViewById.animate().translationX(((m7543H.getWidth() * 2) / 3) - (findViewById.getWidth() / 2)).setDuration(800L).setInterpolator(this.f10179d0);
            PreferenceManager.getDefaultSharedPreferences(this.f9860b0).edit().putString("lastUsername", mo1334a.m1273d()).commit();
            this.f10178c0.m1400o().mo1278b().mo1250a(null).m1375a(new AsyncResult.InterfaceC2279a() { // from class: h.b.a.e.d.j0
                @Override // p205h.p208b.p209a.p210d.AsyncResult.InterfaceC2279a
                /* renamed from: a */
                public final void mo723a(AsyncResult asyncResult2) {
                    LoginFragment.this.m861b(m7543H, asyncResult2);
                }
            });
            return;
        }
        m869a(m7543H, fastOutLinearInInterpolator, findViewById, false);
        TextView textView = (TextView) m7543H.findViewById(C1444R.C1446id.error);
        String mo1269b = mo1334a.mo1269b();
        if (mo1269b != null && mo1269b.length() > 0) {
            textView.setText(mo1269b);
        } else {
            textView.setText(C1444R.string.error);
        }
        textView.setVisibility(0);
        textView.setTranslationY(-textView.getHeight());
        textView.animate().alpha(1.0f).translationY(0.0f).setInterpolator(Interpolators.f9741b).setDuration(120L);
    }

    /* renamed from: a */
    public final void m869a(View view, FastOutLinearInInterpolator fastOutLinearInInterpolator, View view2, boolean z) {
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C1444R.C1446id.username);
        TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(C1444R.C1446id.password);
        if (z) {
            textInputLayout.setEnabled(true);
        }
        textInputLayout2.setEnabled(true);
        view.findViewById(C1444R.C1446id.login).setEnabled(true);
        view.findViewById(C1444R.C1446id.recover).setEnabled(true);
        view.findViewById(C1444R.C1446id.progress).animate().scaleX(0.8f).scaleY(0.8f).alpha(0.0f).setInterpolator(fastOutLinearInInterpolator);
        view.findViewById(C1444R.C1446id.register).animate().alpha(1.0f).translationY(0.0f).setDuration(160L).setInterpolator(fastOutLinearInInterpolator);
        if (view2 != null) {
            view.findViewById(C1444R.C1446id.ground).animate().alpha(0.0f);
            view2.animate().alpha(0.0f).translationY(view2.getHeight()).setDuration(80L).setInterpolator(this.f10179d0);
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public void mo872a(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (iArr.length == 1 && iArr[0] == 0) {
                onClick(null);
                return;
            }
            TextView textView = (TextView) m7543H().findViewById(C1444R.C1446id.error);
            textView.setText(C1444R.string.user_action_login_noPermission);
            textView.setVisibility(0);
            textView.setTranslationY(-textView.getHeight());
            textView.animate().alpha(1.0f).translationY(0.0f).setInterpolator(Interpolators.f9741b).setDuration(120L);
            return;
        }
        super.mo872a(i, strArr, iArr);
    }
}
