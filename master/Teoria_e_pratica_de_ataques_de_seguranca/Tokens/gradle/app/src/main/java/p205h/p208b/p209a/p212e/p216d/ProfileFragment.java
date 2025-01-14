package p205h.p208b.p209a.p212e.p216d;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.p065v4.app.Fragment;
import android.support.p067v7.widget.Toolbar;
import android.text.method.PasswordTransformationMethod;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.hbb20.C1444R;
import com.j256.ormlite.logger.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import p000a.p006b.p030g.p031a.FragmentManager;
import p000a.p006b.p030g.p031a.FragmentTransaction;
import p000a.p006b.p049h.p050a.AlertDialog;
import p205h.p208b.p209a.Anda;
import p205h.p208b.p209a.p210d.AsyncResult;
import p205h.p208b.p209a.p210d.RemoteUserListener;
import p205h.p208b.p209a.p210d.RemoteUserResultListener;
import p205h.p208b.p209a.p210d.Session;
import p205h.p208b.p209a.p210d.UserProfile;
import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.b.a.e.d.y3 */
/* loaded from: classes.dex */
public class ProfileFragment extends AbstractFragment implements View.OnClickListener, DialogInterface.OnClickListener, TextView.OnEditorActionListener, DialogInterface.OnDismissListener, RemoteUserListener, BottomNavigationView.InterfaceC0564c {

    /* renamed from: c0 */
    public Anda f10338c0;

    /* renamed from: d0 */
    public UserProfile f10339d0;

    /* renamed from: e0 */
    public boolean f10340e0 = false;

    /* renamed from: f0 */
    public List<RemoteUserResultListener> f10341f0 = new ArrayList();

    /* renamed from: g0 */
    public AlertDialog f10342g0;

    /* renamed from: h0 */
    public C2589b f10343h0;

    /* renamed from: i0 */
    public EditText f10344i0;

    /* renamed from: j0 */
    public EditText f10345j0;

    /* renamed from: k0 */
    public EditText f10346k0;

    /* renamed from: l0 */
    public AsyncResult.InterfaceC2279a<Session.AbstractC2369d> f10347l0;

    /* compiled from: ProfileFragment.java */
    /* renamed from: h.b.a.e.d.y3$a */
    /* loaded from: classes.dex */
    public class C2588a implements AsyncResult.InterfaceC2279a<Session.AbstractC2369d> {
        public C2588a() {
        }

        @Override // p205h.p208b.p209a.p210d.AsyncResult.InterfaceC2279a
        /* renamed from: a */
        public void mo723a(AsyncResult<Session.AbstractC2369d> asyncResult) {
            Session.AbstractC2369d mo1334a = asyncResult.mo1334a();
            if (!mo1334a.m1268c()) {
                ProfileFragment.this.f10338c0.m1447a(mo1334a.mo1269b(), -1).mo7619m();
            } else {
                Anda.m1443b(ProfileFragment.this.f9860b0).m1400o().mo1282a(ProfileFragment.this);
                ProfileFragment.this.f10338c0.m1447a(ProfileFragment.this.f9860b0.getString(C1444R.string.profile_action_change_success), 0).mo7619m();
            }
            ProfileFragment.this.f10342g0 = null;
            ProfileFragment.this.f10344i0 = null;
        }
    }

    /* compiled from: ProfileFragment.java */
    /* renamed from: h.b.a.e.d.y3$b */
    /* loaded from: classes.dex */
    public static class C2589b {

        /* renamed from: a */
        public final int f10349a;

        /* renamed from: b */
        public final boolean f10350b;

        /* renamed from: c */
        public final String f10351c;

        /* renamed from: d */
        public final String f10352d;

        public C2589b(int i, String str, String str2, boolean z) {
            this.f10349a = i;
            this.f10351c = str;
            this.f10352d = str2;
            this.f10350b = z;
        }
    }

    static {
        new HashMap(2);
    }

    public ProfileFragment() {
        new HashMap(2);
        this.f10347l0 = new C2588a();
    }

    /* renamed from: b */
    public /* synthetic */ void m730b(Context context) {
        ((InputMethodManager) Objects.requireNonNull(context.getSystemService("input_method"))).toggleSoftInput(2, 0);
        this.f10345j0.selectAll();
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: c */
    public void mo728c(Bundle bundle) {
        super.mo728c(bundle);
        this.f10338c0 = Anda.m1443b(this.f9860b0);
    }

    /* renamed from: d */
    public /* synthetic */ void m727d(Context context) {
        ((InputMethodManager) Objects.requireNonNull(context.getSystemService("input_method"))).toggleSoftInput(2, 0);
        this.f10344i0.selectAll();
    }

    /* renamed from: f */
    public /* synthetic */ boolean m725f(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == C1444R.C1446id.edit) {
            Toast.makeText(this.f9860b0, (int) C1444R.string.profile_action_edit_hint, 0).show();
            return true;
        } else if (itemId == C1444R.C1446id.logout) {
            Anda.m1443b(this.f9860b0).m1400o().mo1278b().mo1251a();
            m1151n0();
            return true;
        } else if (itemId != C1444R.C1446id.password) {
            return false;
        } else {
            m734a(new C2589b(-1, this.f9860b0.getString(C1444R.string.user_password), "", true));
            return true;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m1151n0();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        ((InputMethodManager) this.f9860b0.getSystemService("input_method")).toggleSoftInput(1, 0);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            this.f10342g0.dismiss();
            m724p0();
            return true;
        }
        return false;
    }

    @Override // p205h.p208b.p209a.p210d.RemoteUserListener
    public void onError(DataModels.Error error) {
        this.f10340e0 = false;
        for (RemoteUserResultListener remoteUserResultListener : this.f10341f0) {
            remoteUserResultListener.onError(error);
        }
    }

    @Override // p205h.p208b.p209a.p210d.RemoteUserListener
    public void onSuccess(DataModels.UserAccountInfo userAccountInfo) {
        AsyncResult<UserProfile> mo1250a = Anda.m1467X().m1400o().mo1278b().mo1250a(userAccountInfo);
        this.f10339d0 = mo1250a.mo1334a();
        this.f10340e0 = true;
        for (RemoteUserResultListener remoteUserResultListener : this.f10341f0) {
            remoteUserResultListener.mo741b(mo1250a);
        }
    }

    /* renamed from: p0 */
    public final void m724p0() {
        UserProfile.InterfaceC2377d edit = this.f10339d0.edit();
        String trim = this.f10344i0.getText().toString().trim();
        String trim2 = this.f10345j0.getText().toString().trim();
        String trim3 = this.f10346k0.getText().toString().trim();
        int i = this.f10343h0.f10349a;
        if (i != -1) {
            if (i == 0) {
                edit.mo1233b(trim);
            } else if (i == 1) {
                edit.mo1232c(trim);
            } else if (i == 2) {
                edit.mo1230e(trim);
            }
            this.f10338c0.m1447a(this.f9860b0.getString(C1444R.string.profile_state_updating), -1).mo7619m();
            edit.mo1214o().m1375a(this.f10347l0);
        } else if (!trim3.equals(trim2)) {
            this.f10338c0.m1447a(Anda.m1468W().getString(C1444R.string.user_password_no_match), -1).mo7619m();
        } else {
            this.f10338c0.m1447a(this.f9860b0.getString(C1444R.string.profile_state_updating), -1).mo7619m();
            edit.mo1215a(edit.mo1241h(), trim, trim2).m1375a(this.f10347l0);
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            m724p0();
        }
    }

    /* renamed from: c */
    public /* synthetic */ void m729c(Context context) {
        ((InputMethodManager) Objects.requireNonNull(context.getSystemService("input_method"))).toggleSoftInput(2, 0);
        this.f10346k0.selectAll();
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public View mo717a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(C1444R.layout.fragment_profile2, viewGroup, false);
        Toolbar toolbar = (Toolbar) viewGroup2.findViewById(C1444R.C1446id.toolbar);
        toolbar.setNavigationIcon(C1444R.C1445drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationContentDescription(C1444R.string.action_back);
        toolbar.setNavigationOnClickListener(this);
        toolbar.m6302c(C1444R.C1447menu.menu_profile);
        toolbar.setOnMenuItemClickListener(new Toolbar.InterfaceC0774f() { // from class: h.b.a.e.d.e1
            @Override // android.support.p067v7.widget.Toolbar.InterfaceC0774f
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return ProfileFragment.this.m725f(menuItem);
            }
        });
        BottomNavigationView bottomNavigationView = (BottomNavigationView) viewGroup2.findViewById(C1444R.C1446id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        mo735a(bottomNavigationView.getMenu().getItem(0));
        Anda.m1467X().m1400o().mo1282a(this);
        return viewGroup2;
    }

    /* renamed from: d */
    public final void m726d(Fragment fragment) {
        if (m7468j() == null) {
            return;
        }
        FragmentManager m7453p = m7453p();
        Fragment m736a = m736a(m7453p);
        if (m736a == null || m736a.getClass() != fragment.getClass()) {
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

    /* renamed from: a */
    public final void m734a(C2589b c2589b) {
        if (!this.f10340e0) {
            Context context = this.f9860b0;
            Toast.makeText(context, context.getString(C1444R.string.edit_field_no_connection), 0).show();
        } else if (!c2589b.f10350b) {
            Context context2 = this.f9860b0;
            Toast.makeText(context2, context2.getString(C1444R.string.edit_field_not_editable), 0).show();
        } else {
            this.f10343h0 = c2589b;
            final Context m7452q = m7452q();
            AlertDialog.C0325a c0325a = new AlertDialog.C0325a((Context) Objects.requireNonNull(m7452q));
            c0325a.m9131b(c2589b.f10351c);
            int applyDimension = (int) TypedValue.applyDimension(1, 21.0f, m7549B().getDisplayMetrics());
            LinearLayout linearLayout = new LinearLayout(m7452q);
            linearLayout.setOrientation(1);
            linearLayout.setPadding(applyDimension, applyDimension / 4, applyDimension, 0);
            this.f10344i0 = new EditText(m7452q);
            this.f10344i0.setSingleLine();
            this.f10344i0.setText(c2589b.f10352d);
            this.f10344i0.setImeOptions(6);
            if (c2589b.f10349a == 6) {
                this.f10344i0.setInputType(2);
            }
            this.f10344i0.setOnEditorActionListener(this);
            linearLayout.addView(this.f10344i0);
            if (c2589b.f10349a == 1) {
                TextView textView = new TextView(m7452q);
                textView.setText(C1444R.string.profile_action_change_logout);
                int i = applyDimension / 6;
                textView.setPadding(i, applyDimension / 8, i, 0);
                linearLayout.addView(textView);
            }
            if (c2589b.f10349a == -1) {
                this.f10344i0.setHint(m7452q.getString(C1444R.string.user_current_password));
                this.f10344i0.setInputType(Logger.DEFAULT_FULL_MESSAGE_LENGTH);
                this.f10344i0.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.f10345j0 = new EditText(m7452q);
                this.f10345j0.setHint(m7452q.getString(C1444R.string.user_password_new));
                this.f10345j0.setInputType(Logger.DEFAULT_FULL_MESSAGE_LENGTH);
                this.f10345j0.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.f10346k0 = new EditText(m7452q);
                this.f10346k0.setHint(m7452q.getString(C1444R.string.user_new_password_confirm));
                this.f10346k0.setInputType(Logger.DEFAULT_FULL_MESSAGE_LENGTH);
                this.f10346k0.setTransformationMethod(PasswordTransformationMethod.getInstance());
                linearLayout.addView(this.f10345j0);
                linearLayout.addView(this.f10346k0);
                this.f10345j0.post(new Runnable() { // from class: h.b.a.e.d.f1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ProfileFragment.this.m730b(m7452q);
                    }
                });
                this.f10346k0.post(new Runnable() { // from class: h.b.a.e.d.h1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ProfileFragment.this.m729c(m7452q);
                    }
                });
            }
            c0325a.m9132b(linearLayout);
            c0325a.m9133b(C1444R.string.user_action_save, this);
            c0325a.m9146a(17039360, this);
            c0325a.m9145a(this);
            this.f10342g0 = c0325a.m9129c();
            this.f10344i0.post(new Runnable() { // from class: h.b.a.e.d.g1
                @Override // java.lang.Runnable
                public final void run() {
                    ProfileFragment.this.m727d(m7452q);
                }
            });
        }
    }

    @Override // android.support.design.widget.BottomNavigationView.InterfaceC0564c
    /* renamed from: a */
    public boolean mo735a(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == C1444R.C1446id.payment) {
            m726d(new PaymentDataFragment());
            return true;
        } else if (itemId == C1444R.C1446id.personalData) {
            m726d(new PersonalDataFragment());
            return true;
        } else if (itemId != C1444R.C1446id.socialProfile) {
            return false;
        } else {
            m726d(new SocialProfilesFragment());
            return true;
        }
    }

    /* renamed from: a */
    public final Fragment m736a(FragmentManager fragmentManager) {
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
}
