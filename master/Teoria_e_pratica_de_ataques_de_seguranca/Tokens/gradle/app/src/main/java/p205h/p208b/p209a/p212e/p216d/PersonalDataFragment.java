package p205h.p208b.p209a.p212e.p216d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.p067v7.widget.LinearLayoutManager;
import android.support.p067v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.hbb20.C1444R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import p000a.p006b.p049h.p050a.AlertDialog;
import p205h.p208b.p209a.Anda;
import p205h.p208b.p209a.p210d.AsyncResult;
import p205h.p208b.p209a.p210d.RemoteUserListener;
import p205h.p208b.p209a.p210d.RemoteUserResultListener;
import p205h.p208b.p209a.p210d.Session;
import p205h.p208b.p209a.p210d.UserProfile;
import p205h.p208b.p209a.p212e.p216d.AbstractTimeFramedListFragment;
import p205h.p208b.p209a.p212e.p216d.PersonalDataFragment;
import p205h.p208b.p209a.p212e.p218f.BaseItemView;
import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.b.a.e.d.w3 */
/* loaded from: classes.dex */
public class PersonalDataFragment extends AbstractFragment implements TextView.OnEditorActionListener, View.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnClickListener, RemoteUserListener {

    /* renamed from: c0 */
    public Anda f10301c0;

    /* renamed from: d0 */
    public Snackbar f10302d0;

    /* renamed from: g0 */
    public UserProfile f10305g0;

    /* renamed from: h0 */
    public ViewGroup f10306h0;

    /* renamed from: i0 */
    public EditText f10307i0;

    /* renamed from: j0 */
    public ProgressBar f10308j0;

    /* renamed from: k0 */
    public AbstractTimeFramedListFragment.C2463a f10309k0;

    /* renamed from: l0 */
    public AlertDialog f10310l0;

    /* renamed from: e0 */
    public boolean f10303e0 = false;

    /* renamed from: f0 */
    public List<RemoteUserResultListener> f10304f0 = new ArrayList();

    /* renamed from: m0 */
    public HashMap<String, DataModels.Language> f10311m0 = new HashMap<>();

    /* renamed from: n0 */
    public List<AbstractTimeFramedListFragment.C2463a> f10312n0 = new ArrayList();

    /* renamed from: o0 */
    public AsyncResult.InterfaceC2279a<Session.AbstractC2369d> f10313o0 = new C2574a();

    /* compiled from: PersonalDataFragment.java */
    /* renamed from: h.b.a.e.d.w3$a */
    /* loaded from: classes.dex */
    public class C2574a implements AsyncResult.InterfaceC2279a<Session.AbstractC2369d> {
        public C2574a() {
        }

        @Override // p205h.p208b.p209a.p210d.AsyncResult.InterfaceC2279a
        /* renamed from: a */
        public void mo723a(AsyncResult<Session.AbstractC2369d> asyncResult) {
            Session.AbstractC2369d mo1334a = asyncResult.mo1334a();
            if (mo1334a.m1268c()) {
                PersonalDataFragment personalDataFragment = PersonalDataFragment.this;
                personalDataFragment.f10302d0 = personalDataFragment.f10301c0.m1447a(PersonalDataFragment.this.f9860b0.getString(C1444R.string.profile_action_change_success), 0);
                PersonalDataFragment.this.f10302d0.mo7619m();
                Anda.m1443b(PersonalDataFragment.this.f9860b0).m1400o().mo1282a(PersonalDataFragment.this);
            } else {
                PersonalDataFragment personalDataFragment2 = PersonalDataFragment.this;
                personalDataFragment2.f10302d0 = personalDataFragment2.f10301c0.m1447a(mo1334a.mo1269b(), -1);
                PersonalDataFragment.this.f10302d0.mo7619m();
            }
            PersonalDataFragment.this.f10310l0 = null;
            PersonalDataFragment.this.f10307i0 = null;
        }
    }

    /* compiled from: PersonalDataFragment.java */
    /* renamed from: h.b.a.e.d.w3$b */
    /* loaded from: classes.dex */
    public static class C2575b extends AbstractTimeFramedListFragment.C2463a {

        /* renamed from: f */
        public DataModels.Language f10315f;

        public C2575b(int i, DataModels.Language language) {
            super(i, 1, language.getCode(), 0);
            this.f10315f = language;
        }

        public boolean equals(Object obj) {
            return (obj instanceof C2575b) && this.f10315f.getCode().equals(((C2575b) obj).f10315f.getCode());
        }
    }

    /* compiled from: PersonalDataFragment.java */
    /* renamed from: h.b.a.e.d.w3$c */
    /* loaded from: classes.dex */
    public class C2576c extends RecyclerView.AbstractC0711g<BaseItemView> implements AsyncResult.InterfaceC2279a<UserProfile>, RemoteUserResultListener {

        /* renamed from: c */
        public final List<AbstractTimeFramedListFragment.C2463a> f10316c = new ArrayList();

        public C2576c() {
            PersonalDataFragment.this.m763a((RemoteUserResultListener) this);
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: c */
        public int mo739c(int i) {
            return this.f10316c.get(i).f9967c;
        }

        @Override // p205h.p208b.p209a.p210d.RemoteUserResultListener
        @SuppressLint({"LongLogTag"})
        public void onError(DataModels.Error error) {
            Log.d("PersonalDataFragment.class", String.format("ProfileFragment: onError was invoked with error: %s", error.getMessage()));
            AsyncResult<UserProfile> mo1250a = Anda.m1443b(PersonalDataFragment.this.f9860b0).m1400o().mo1278b().mo1250a(null);
            PersonalDataFragment.this.f10303e0 = false;
            mo1250a.m1375a(this);
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: a */
        public void mo743b(BaseItemView baseItemView, int i) {
            baseItemView.mo692a(this.f10316c.get(i));
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: a */
        public int mo747a() {
            List<AbstractTimeFramedListFragment.C2463a> list = this.f10316c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // p205h.p208b.p209a.p210d.RemoteUserResultListener
        @SuppressLint({"LongLogTag"})
        /* renamed from: b */
        public void mo741b(AsyncResult<UserProfile> asyncResult) {
            Log.d("PersonalDataFragment.class", "ProfileFragment: onSuccess() invoked");
            if (asyncResult != null) {
                PersonalDataFragment.this.f10303e0 = true;
                asyncResult.m1375a(this);
            }
        }

        @Override // p205h.p208b.p209a.p210d.AsyncResult.InterfaceC2279a
        /* renamed from: a */
        public void mo723a(AsyncResult<UserProfile> asyncResult) {
            if (PersonalDataFragment.this.m7540K()) {
                final UserProfile mo1334a = asyncResult.mo1334a();
                PersonalDataFragment.this.f10305g0 = mo1334a;
                Anda.m1443b(PersonalDataFragment.this.f9860b0).m1400o().mo1280a(new Runnable() { // from class: h.b.a.e.d.c1
                    @Override // java.lang.Runnable
                    public final void run() {
                        PersonalDataFragment.C2576c.this.m740b(mo1334a);
                    }
                });
            }
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: b  reason: avoid collision after fix types in other method */
        public BaseItemView mo742b(ViewGroup viewGroup, int i) {
            PersonalDataFragment personalDataFragment = PersonalDataFragment.this;
            return new View$OnClickListenerC2577d(LayoutInflater.from(personalDataFragment.f9860b0).inflate(C1444R.layout.item_profile_field, viewGroup, false));
        }

        /* renamed from: a */
        public /* synthetic */ void m746a(UserProfile userProfile) {
            Anda.m1443b(PersonalDataFragment.this.f9860b0).m1438b(new C2583x3(this, userProfile));
        }

        /* renamed from: b */
        public /* synthetic */ void m740b(final UserProfile userProfile) {
            PersonalDataFragment.this.f10306h0.post(new Runnable() { // from class: h.b.a.e.d.d1
                @Override // java.lang.Runnable
                public final void run() {
                    PersonalDataFragment.C2576c.this.m746a(userProfile);
                }
            });
        }
    }

    /* compiled from: PersonalDataFragment.java */
    /* renamed from: h.b.a.e.d.w3$d */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC2577d extends BaseItemView implements View.OnClickListener {

        /* renamed from: u */
        public final TextView f10318u;

        /* renamed from: v */
        public final TextView f10319v;

        /* renamed from: w */
        public C2578e f10320w;

        public View$OnClickListenerC2577d(View view) {
            super(view);
            this.f10318u = (TextView) view.findViewById(C1444R.C1446id.name);
            this.f10319v = (TextView) view.findViewById(C1444R.C1446id.value);
            view.setOnClickListener(this);
        }

        @Override // p205h.p208b.p209a.p212e.p218f.BaseItemView
        /* renamed from: a */
        public void mo692a(AbstractTimeFramedListFragment.C2463a c2463a) {
            this.f10320w = (C2578e) c2463a;
            this.f10318u.setText(this.f10320w.f10323g);
            this.f10319v.setText(this.f10320w.f10324h);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonalDataFragment.this.m762a(this.f10320w);
        }
    }

    /* compiled from: PersonalDataFragment.java */
    /* renamed from: h.b.a.e.d.w3$e */
    /* loaded from: classes.dex */
    public static class C2578e extends AbstractTimeFramedListFragment.C2463a {

        /* renamed from: f */
        public final boolean f10322f;

        /* renamed from: g */
        public final String f10323g;

        /* renamed from: h */
        public final String f10324h;

        public C2578e(int i, String str, String str2, boolean z) {
            super(i, 1, str == null ? "" : str, 0);
            this.f10323g = str;
            this.f10324h = str2;
            this.f10322f = z;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            if (obj instanceof C2578e) {
                C2578e c2578e = (C2578e) obj;
                if (this.f10322f == c2578e.f10322f && (str = this.f10323g) != null && (str2 = c2578e.f10323g) != null && this.f10324h != null && c2578e.f10324h != null && str.equals(str2) && this.f10324h.equals(c2578e.f10324h)) {
                    return true;
                }
            }
            return false;
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
            this.f10310l0.dismiss();
            m749p0();
            return true;
        }
        return false;
    }

    @Override // p205h.p208b.p209a.p210d.RemoteUserListener
    public void onError(DataModels.Error error) {
        this.f10308j0.setVisibility(4);
        for (RemoteUserResultListener remoteUserResultListener : this.f10304f0) {
            remoteUserResultListener.onError(error);
        }
    }

    @Override // p205h.p208b.p209a.p210d.RemoteUserListener
    public void onSuccess(DataModels.UserAccountInfo userAccountInfo) {
        this.f10308j0.setVisibility(4);
        AsyncResult<UserProfile> mo1250a = Anda.m1443b(this.f9860b0).m1400o().mo1278b().mo1250a(userAccountInfo);
        for (RemoteUserResultListener remoteUserResultListener : this.f10304f0) {
            remoteUserResultListener.mo741b(mo1250a);
        }
    }

    @SuppressLint({"LongLogTag"})
    /* renamed from: p0 */
    public final void m749p0() {
        UserProfile.InterfaceC2377d edit = this.f10305g0.edit();
        String trim = this.f10309k0.f9965a != 7 ? this.f10307i0.getText().toString().trim() : "";
        int i = this.f10309k0.f9965a;
        if (i != -1 && i == 0) {
            edit.mo1233b(trim);
        }
        this.f10302d0 = this.f10301c0.m1447a(this.f9860b0.getString(C1444R.string.profile_state_updating), -1);
        this.f10302d0.mo7619m();
        edit.mo1214o().m1375a(this.f10313o0);
    }

    /* renamed from: q0 */
    public /* synthetic */ void m748q0() {
        ((InputMethodManager) this.f9860b0.getSystemService("input_method")).toggleSoftInput(2, 0);
        this.f10307i0.selectAll();
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: c */
    public void mo728c(Bundle bundle) {
        super.mo728c(bundle);
        this.f10301c0 = Anda.m1443b(this.f9860b0);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            m749p0();
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public View mo717a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(C1444R.layout.fragment_personal_data, viewGroup, false);
        this.f10306h0 = viewGroup2;
        RecyclerView recyclerView = (RecyclerView) viewGroup2.findViewById(C1444R.C1446id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f9860b0));
        this.f10308j0 = (ProgressBar) viewGroup2.findViewById(C1444R.C1446id.progress);
        recyclerView.setAdapter(new C2576c());
        Anda.m1467X().m1400o().mo1282a(this);
        return viewGroup2;
    }

    /* renamed from: a */
    public final void m762a(C2578e c2578e) {
        if (!c2578e.f10322f) {
            Context context = this.f9860b0;
            Toast.makeText(context, context.getString(C1444R.string.edit_field_not_editable), 0).show();
        } else if (!this.f10303e0) {
            Context context2 = this.f9860b0;
            Toast.makeText(context2, context2.getString(C1444R.string.edit_field_no_connection), 0).show();
        } else {
            this.f10309k0 = c2578e;
            AlertDialog.C0325a c0325a = new AlertDialog.C0325a(this.f9860b0);
            c0325a.m9131b(c2578e.f10323g);
            int applyDimension = (int) TypedValue.applyDimension(1, 21.0f, m7549B().getDisplayMetrics());
            LinearLayout linearLayout = new LinearLayout(this.f9860b0);
            linearLayout.setOrientation(1);
            linearLayout.setPadding(applyDimension, applyDimension / 4, applyDimension, 0);
            this.f10307i0 = new EditText(this.f9860b0);
            this.f10307i0.setSingleLine();
            this.f10307i0.setText(c2578e.f10324h);
            this.f10307i0.setImeOptions(6);
            if (c2578e.f9965a == 6) {
                this.f10307i0.setInputType(2);
            }
            this.f10307i0.setOnEditorActionListener(this);
            linearLayout.addView(this.f10307i0);
            if (c2578e.f9965a == 1) {
                TextView textView = new TextView(this.f9860b0);
                textView.setText(C1444R.string.profile_action_change_logout);
                int i = applyDimension / 6;
                textView.setPadding(i, applyDimension / 8, i, 0);
                linearLayout.addView(textView);
            }
            c0325a.m9132b(linearLayout);
            c0325a.m9133b(C1444R.string.user_action_save, this);
            c0325a.m9146a(17039360, this);
            c0325a.m9145a(this);
            this.f10310l0 = c0325a.m9129c();
            this.f10307i0.post(new Runnable() { // from class: h.b.a.e.d.b1
                @Override // java.lang.Runnable
                public final void run() {
                    PersonalDataFragment.this.m748q0();
                }
            });
        }
    }

    /* renamed from: a */
    public final void m763a(RemoteUserResultListener remoteUserResultListener) {
        if (this.f10304f0.contains(remoteUserResultListener)) {
            return;
        }
        this.f10304f0.add(remoteUserResultListener);
    }
}
