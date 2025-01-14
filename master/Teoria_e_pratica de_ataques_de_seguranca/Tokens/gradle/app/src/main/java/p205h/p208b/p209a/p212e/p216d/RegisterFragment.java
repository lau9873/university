package p205h.p208b.p209a.p212e.p216d;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.p065v4.app.Fragment;
import android.support.p067v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.hbb20.C1444R;
import java.util.Objects;
import p000a.p006b.p030g.p031a.FragmentManager;
import p000a.p006b.p030g.p031a.FragmentStatePagerAdapter;
import p000a.p006b.p030g.p045k.GravityCompat;
import p000a.p006b.p030g.p045k.ViewPager;
import p000a.p006b.p030g.p045k.p047f0.LinearOutSlowInInterpolator;
import p205h.p208b.p209a.Anda;
import p205h.p208b.p209a.p210d.AsyncResult;
import p205h.p208b.p209a.p210d.Session;
import p205h.p208b.p209a.p212e.p214b.Interpolators;
import p205h.p208b.p209a.p212e.p217e.RegisterListener;

/* renamed from: h.b.a.e.d.a4 */
/* loaded from: classes.dex */
public class RegisterFragment extends AbstractFragment implements View.OnClickListener, RegisterListener {

    /* renamed from: c0 */
    public ViewPager f9757c0;

    /* renamed from: d0 */
    public RegisterFirstStepFragment f9758d0;

    /* renamed from: e0 */
    public RegisterSecondStepFragment f9759e0;

    /* renamed from: f0 */
    public FloatingActionButton f9760f0;

    /* renamed from: g0 */
    public ProgressBar f9761g0;

    /* compiled from: RegisterFragment.java */
    /* renamed from: h.b.a.e.d.a4$a */
    /* loaded from: classes.dex */
    public class C2392a extends FragmentStatePagerAdapter {
        public C2392a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // p000a.p006b.p030g.p045k.PagerAdapter
        /* renamed from: a */
        public int mo1193a() {
            return 2;
        }

        @Override // p000a.p006b.p030g.p031a.FragmentStatePagerAdapter
        /* renamed from: b */
        public Fragment mo1192b(int i) {
            if (i == 0) {
                if (RegisterFragment.this.f9758d0 == null) {
                    RegisterFragment.this.f9758d0 = new RegisterFirstStepFragment();
                    RegisterFragment.this.f9758d0.m708a((RegisterListener) RegisterFragment.this);
                }
                return RegisterFragment.this.f9758d0;
            } else if (i == 1) {
                if (RegisterFragment.this.f9759e0 == null) {
                    RegisterFragment.this.f9759e0 = new RegisterSecondStepFragment();
                }
                return RegisterFragment.this.f9759e0;
            } else {
                return null;
            }
        }
    }

    @Override // p205h.p208b.p209a.p212e.p217e.RegisterListener
    /* renamed from: g */
    public void mo693g() {
        int currentItem = this.f9757c0.getCurrentItem();
        if (currentItem == 0) {
            this.f9757c0.setCurrentItem(currentItem + 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f9760f0) {
            Anda m1443b = Anda.m1443b(this.f9860b0);
            int currentItem = this.f9757c0.getCurrentItem();
            if (currentItem == 0) {
                m1204a(m1443b);
            } else if (currentItem != 1) {
            } else {
                m1204a(m1443b);
            }
        } else if (this.f9757c0.getCurrentItem() == 0) {
            m1151n0();
        } else {
            ViewPager viewPager = this.f9757c0;
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    /* renamed from: p0 */
    public final boolean m1195p0() {
        boolean m1198a = m1198a(this.f9758d0.m699u0(), this.f9758d0.m700t0(), this.f9758d0.m698v0(), this.f9758d0.m697w0(), this.f9758d0.m696x0());
        boolean m4276i = this.f9758d0.m702r0().m4276i();
        if (!m4276i) {
            this.f9758d0.m696x0().setError(m7528a(C1444R.string.error_register_phone));
        }
        return m1198a && m1197a(this.f9758d0.m701s0()) && m4276i;
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: q0 */
    public final void m1194q0() {
        if (m1195p0() && this.f9758d0.m703q0() && this.f9758d0.m704p0()) {
            m1199a(false, this.f9758d0.m699u0(), this.f9758d0.m700t0(), this.f9758d0.m698v0(), this.f9758d0.m697w0(), this.f9758d0.m696x0(), this.f9759e0.m1185s0(), this.f9759e0.m1183u0(), this.f9759e0.m1181w0(), this.f9759e0.m1186r0(), this.f9760f0, this.f9759e0.m1188p0(), this.f9759e0.m1182v0());
            final LinearOutSlowInInterpolator linearOutSlowInInterpolator = Interpolators.f9741b;
            this.f9761g0.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setInterpolator(linearOutSlowInInterpolator);
            String fullNumberWithPlus = this.f9758d0.m702r0().getFullNumberWithPlus();
            Session.InterfaceC2367b mo1274e = Anda.m1443b(this.f9860b0).m1400o().mo1274e();
            mo1274e.mo1233b(((EditText) Objects.requireNonNull(this.f9758d0.m699u0().getEditText())).getText().toString());
            mo1274e.mo1232c(((EditText) Objects.requireNonNull(this.f9758d0.m700t0().getEditText())).getText().toString());
            mo1274e.mo1226i(((EditText) Objects.requireNonNull(this.f9758d0.m698v0().getEditText())).getText().toString());
            mo1274e.mo1230e(fullNumberWithPlus);
            mo1274e.mo1228g(((EditText) Objects.requireNonNull(this.f9759e0.m1185s0().getEditText())).getText().toString());
            mo1274e.mo1231d(((EditText) Objects.requireNonNull(this.f9759e0.m1186r0().getEditText())).getText().toString());
            mo1274e.mo1229f(((EditText) Objects.requireNonNull(this.f9759e0.m1181w0().getEditText())).getText().toString());
            mo1274e.mo1227h(((EditText) Objects.requireNonNull(this.f9759e0.m1184t0().getEditText())).getText().toString());
            mo1274e.mo1234a(this.f9759e0.m1187q0());
            try {
                mo1274e.mo1225j(((EditText) Objects.requireNonNull(this.f9759e0.m1183u0().getEditText())).getText().toString());
            } catch (NumberFormatException unused) {
                mo1274e.mo1225j("");
            }
            mo1274e.mo1235a(((EditText) Objects.requireNonNull(this.f9759e0.m1182v0().getEditText())).getText().toString());
            mo1274e.mo1271p();
            mo1274e.mo1272n().m1375a(new AsyncResult.InterfaceC2279a() { // from class: h.b.a.e.d.t1
                @Override // p205h.p208b.p209a.p210d.AsyncResult.InterfaceC2279a
                /* renamed from: a */
                public final void mo723a(AsyncResult asyncResult) {
                    RegisterFragment.this.m1205a(linearOutSlowInInterpolator, asyncResult);
                }
            });
            return;
        }
        this.f9757c0.setCurrentItem(0);
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public View mo717a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Anda.m1443b(this.f9860b0).m1465a(m7468j(), false);
        View inflate = layoutInflater.inflate(C1444R.layout.fragment_register, viewGroup, false);
        Toolbar toolbar = (Toolbar) inflate.findViewById(C1444R.C1446id.toolbar);
        toolbar.setNavigationIcon(C1444R.C1445drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationContentDescription(C1444R.string.action_back);
        toolbar.setNavigationOnClickListener(this);
        this.f9757c0 = (ViewPager) inflate.findViewById(C1444R.C1446id.pager);
        this.f9757c0.setAdapter(new C2392a(m7453p()));
        this.f9760f0 = (FloatingActionButton) inflate.findViewById(C1444R.C1446id.register);
        this.f9760f0.setOnClickListener(this);
        this.f9761g0 = (ProgressBar) inflate.findViewById(C1444R.C1446id.progress);
        return inflate;
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public void mo1200a(Object obj) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.mo1200a(new Explode());
        }
    }

    /* renamed from: a */
    public final void m1204a(Anda anda) {
        if (anda.m1392s()) {
            Toast.makeText(m7468j(), (int) C1444R.string.error_fetchingData_hint, 0).show();
        } else if (anda.m1398p()) {
            Toast.makeText(m7468j(), (int) C1444R.string.error_checkNetwork_hint, 0).show();
        } else if (this.f9758d0.m721B0()) {
            Toast.makeText(m7468j(), (int) C1444R.string.error_termsAndConditions_hint, 0).show();
        } else {
            m1194q0();
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m1205a(LinearOutSlowInInterpolator linearOutSlowInInterpolator, AsyncResult asyncResult) {
        if (m7468j() == null) {
            return;
        }
        Session.AbstractC2368c abstractC2368c = (Session.AbstractC2368c) asyncResult.mo1334a();
        if (abstractC2368c.m1268c()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f9860b0);
            builder.setTitle(C1444R.string.user_action_register_success);
            builder.setMessage(C1444R.string.user_action_register_checkEmail);
            builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
            builder.show();
            if (Build.VERSION.SDK_INT >= 21) {
                m7498b(new Slide(GravityCompat.m9579a(8388613, m7549B().getConfiguration().getLayoutDirection())));
            }
            PreferenceManager.getDefaultSharedPreferences(this.f9860b0).edit().putString("lastUsername", this.f9758d0.m700t0().getEditText().getText().toString()).commit();
            m1151n0();
            m1153b((Fragment) new LoginFragment(this.f9758d0.m700t0().getEditText().getText().toString(), this.f9758d0.m698v0().getEditText().getText().toString()));
            return;
        }
        m1199a(true, this.f9758d0.m699u0(), this.f9758d0.m700t0(), this.f9758d0.m698v0(), this.f9758d0.m697w0(), this.f9758d0.m696x0(), this.f9759e0.m1185s0(), this.f9759e0.m1183u0(), this.f9759e0.m1181w0(), this.f9759e0.m1186r0(), this.f9760f0, this.f9759e0.m1188p0(), this.f9759e0.m1182v0());
        this.f9761g0.animate().scaleX(0.8f).scaleY(0.8f).alpha(0.0f).setInterpolator(linearOutSlowInInterpolator);
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this.f9860b0);
        String mo1269b = abstractC2368c.mo1269b();
        if (mo1269b == null || mo1269b.length() == 0) {
            mo1269b = abstractC2368c.mo1270a();
        }
        if (mo1269b != null && mo1269b.length() != 0) {
            builder2.setMessage(mo1269b);
        } else {
            builder2.setTitle(C1444R.string.error);
        }
        builder2.setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
        builder2.show();
    }

    /* renamed from: a */
    public final void m1199a(boolean z, View... viewArr) {
        for (View view : viewArr) {
            view.setEnabled(z);
        }
    }

    /* renamed from: a */
    public final boolean m1198a(TextInputLayout... textInputLayoutArr) {
        boolean z = true;
        for (TextInputLayout textInputLayout : textInputLayoutArr) {
            if (textInputLayout.getEditText().getText().length() == 0) {
                textInputLayout.setError(this.f9860b0.getString(C1444R.string.error_register_fillIn));
                z = false;
            } else {
                textInputLayout.setError(null);
            }
        }
        return z;
    }

    /* renamed from: a */
    public final boolean m1197a(CheckBox... checkBoxArr) {
        boolean z = true;
        for (CheckBox checkBox : checkBoxArr) {
            if (!checkBox.isChecked()) {
                checkBox.setError(this.f9860b0.getString(C1444R.string.error_register_toc));
                z = false;
            } else {
                checkBox.setError(null);
            }
        }
        return z;
    }
}
