package h.b.a.e.d;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
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
import h.b.a.d.b;
import h.b.a.d.u;
import pt.card4b.backendbeacons.BackEnd;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: LoginFragment.java */
/* loaded from: classes.dex */
public class r3 extends g3 implements View.OnClickListener, b.a<u.a>, TextView.OnEditorActionListener {
    public h.b.a.c c0;
    public Interpolator d0;
    public TextInputLayout e0;
    public boolean f0 = false;
    public int g0 = 0;

    /* compiled from: LoginFragment.java */
    /* loaded from: classes.dex */
    public class a implements BackendListeners.ResetPasswordRequestListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f7319a;

        public a(View view) {
            this.f7319a = view;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            TextView textView = (TextView) r3.this.H().findViewById(2131230875);
            textView.setText(error.getMessageToUser());
            textView.setVisibility(0);
            textView.setTranslationY(-textView.getHeight());
            textView.animate().alpha(1.0f).translationY(0.0f).setInterpolator(h.b.a.e.b.b.f7086b).setDuration(120L);
            r3.this.a(this.f7319a, new a.b.g.k.f0.a(), (View) null, false);
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.ResetPasswordRequestListener
        public void onSuccess() {
            Toast.makeText(r3.this.b0, 2131755372, 1).show();
            r3.this.a(this.f7319a, new a.b.g.k.f0.a(), (View) null, false);
        }
    }

    /* compiled from: LoginFragment.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r3.this.s0();
        }
    }

    public r3() {
    }

    public static /* synthetic */ void b(DialogInterface dialogInterface, int i2) {
    }

    @Override // android.support.v4.app.Fragment
    public void Z() {
        super.Z();
        a.b.g.a.g j = j();
        if (j != null) {
            j.getWindow().setSoftInputMode(32);
        }
    }

    public /* synthetic */ void b(h.b.a.d.b bVar) {
        c((h.b.a.d.b<u.a>) bVar);
    }

    @Override // android.support.v4.app.Fragment
    public void c(Bundle bundle) {
        super.c(bundle);
        this.c0 = h.b.a.c.b(this.b0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.d0 == null) {
            this.d0 = h.b.a.e.b.b.f7085a;
        }
        if (view != null && view.getId() != 2131230951) {
            if (view.getId() == 2131231010) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this.b0);
                builder.setTitle(2131755320);
                builder.setMessage(a(2131755321));
                builder.setCancelable(false);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: h.b.a.e.d.k0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        r3.this.a(dialogInterface, i2);
                    }
                });
                builder.setNegativeButton(17039360, i0.f7211a);
                builder.show();
            } else if (view.getId() == 2131230836) {
            } else {
                t0();
            }
        } else if (Build.VERSION.SDK_INT >= 23 && a.b.g.b.b.a(this.b0, "android.permission.READ_PHONE_STATE") != 0) {
            a(new String[]{"android.permission.READ_PHONE_STATE"}, 1);
        } else if (this.f0) {
            v0();
        } else {
            h.b.a.c b2 = h.b.a.c.b(this.b0);
            if (b2.s()) {
                Toast.makeText(j(), 2131755205, 0).show();
            } else if (b2.p()) {
                if (!b2.s() && !b2.B()) {
                    b2.N();
                }
                Toast.makeText(j(), 2131755204, 0).show();
            } else {
                u0();
            }
        }
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
        if (i2 == 2) {
            onClick(null);
            return true;
        }
        return false;
    }

    /* renamed from: r0 */
    public final void q0() {
        View H = H();
        if (H == null) {
            return;
        }
        a.b.g.k.f0.a aVar = new a.b.g.k.f0.a();
        View findViewById = H.findViewById(2131231177);
        H.findViewById(2131231005).animate().scaleX(0.8f).scaleY(0.8f).alpha(0.0f).setInterpolator(aVar);
        ((FloatingActionButton) H.findViewById(2131230951)).setBackgroundTintList(ColorStateList.valueOf(-13070788));
        findViewById.animate().translationX(H.getWidth()).setDuration(800L).setInterpolator(h.b.a.e.b.b.f7086b).withEndAction(new b());
    }

    public final void s0() {
        if (Build.VERSION.SDK_INT >= 21) {
            b(new Slide(a.b.g.k.d.a(8388613, B().getConfiguration().getLayoutDirection())));
        }
        final View H = H();
        H.findViewById(2131231015).setVisibility(8);
        H.post(new Runnable() { // from class: h.b.a.e.d.m0
            @Override // java.lang.Runnable
            public final void run() {
                r3.this.c(H);
            }
        });
    }

    public void t0() {
        a4 a4Var = new a4();
        a4Var.a((Object) null);
        b((Fragment) a4Var);
    }

    public void u0() {
        final View H = H();
        TextInputLayout textInputLayout = (TextInputLayout) H.findViewById(2131231173);
        TextInputLayout textInputLayout2 = (TextInputLayout) H.findViewById(2131230991);
        a.b.g.k.f0.c cVar = h.b.a.e.b.b.f7086b;
        a(H, textInputLayout, textInputLayout2, cVar);
        View findViewById = H.findViewById(2131230900);
        findViewById.setVisibility(0);
        findViewById.animate().alpha(1.0f);
        View findViewById2 = H.findViewById(2131231177);
        findViewById2.setVisibility(0);
        findViewById2.setAlpha(1.0f);
        findViewById2.setTranslationY(0.0f);
        findViewById2.setTranslationX(-findViewById2.getWidth());
        findViewById2.animate().translationX((H.getWidth() / 3) - (findViewById2.getWidth() / 2)).setDuration(800L).setInterpolator(this.d0);
        a(H, cVar);
        this.c0.o().a(textInputLayout.getEditText().getText().toString(), textInputLayout2.getEditText().getText().toString()).a(new b.a() { // from class: h.b.a.e.d.f0
            @Override // h.b.a.d.b.a
            public final void a(h.b.a.d.b bVar) {
                r3.this.c(H, bVar);
            }
        });
    }

    public final void v0() {
        View H = H();
        TextInputLayout textInputLayout = (TextInputLayout) H.findViewById(2131231173);
        if (textInputLayout.getEditText().getText().toString().isEmpty()) {
            Toast.makeText(this.b0, 2131755374, 1).show();
            return;
        }
        a.b.g.k.f0.c cVar = h.b.a.e.b.b.f7086b;
        a(H, cVar);
        a(H, textInputLayout, this.e0, cVar);
        BackEnd.resetUserPassword(textInputLayout.getEditText().getText().toString(), new a(H));
    }

    public /* synthetic */ void b(View view, h.b.a.d.b bVar) {
        view.post(new Runnable() { // from class: h.b.a.e.d.e0
            @Override // java.lang.Runnable
            public final void run() {
                r3.this.q0();
            }
        });
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2131427383, viewGroup, false);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(2131231015);
        if (h.b.a.c.b(this.b0).k() != null) {
            linearLayout.setVisibility(4);
        } else {
            linearLayout.setOnClickListener(this);
            inflate.findViewById(2131230810).setOnClickListener(this);
        }
        inflate.findViewById(2131230951).setOnClickListener(this);
        inflate.findViewById(2131231010).setOnClickListener(this);
        final TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(2131231173);
        this.e0 = (TextInputLayout) inflate.findViewById(2131230991);
        EditText editText = this.e0.getEditText();
        editText.setOnEditorActionListener(this);
        Bundle o = o();
        if (o == null) {
            String string = PreferenceManager.getDefaultSharedPreferences(this.b0).getString("lastUsername", null);
            if (string != null) {
                textInputLayout.setEnabled(false);
                textInputLayout.getEditText().setText(string);
            }
        } else {
            textInputLayout.getEditText().setText(o.getString("username"));
            textInputLayout.setEnabled(false);
            editText.setText(o.getString("password"));
        }
        final Transition transition = (Transition) r();
        inflate.postDelayed(new Runnable() { // from class: h.b.a.e.d.p0
            @Override // java.lang.Runnable
            public final void run() {
                r3.this.a(transition, textInputLayout);
            }
        }, 500L);
        return inflate;
    }

    public /* synthetic */ void b(View view) {
        view.post(new Runnable() { // from class: h.b.a.e.d.a
            @Override // java.lang.Runnable
            public final void run() {
                r3.this.n0();
            }
        });
    }

    public /* synthetic */ void c(View view, final h.b.a.d.b bVar) {
        view.post(new Runnable() { // from class: h.b.a.e.d.g0
            @Override // java.lang.Runnable
            public final void run() {
                r3.this.b(bVar);
            }
        });
    }

    @SuppressLint({"ValidFragment"})
    public r3(String str, String str2) {
        Bundle bundle = new Bundle(2);
        bundle.putString("username", str);
        bundle.putString("password", str2);
        m(bundle);
    }

    @SuppressLint({"ApplySharedPref"})
    public final void c(h.b.a.d.b<u.a> bVar) {
        final View H = H();
        if (H == null) {
            return;
        }
        a.b.g.k.f0.a aVar = new a.b.g.k.f0.a();
        View findViewById = H.findViewById(2131231177);
        u.a a2 = bVar.a();
        if (a2.c()) {
            findViewById.animate().translationX(((H.getWidth() * 2) / 3) - (findViewById.getWidth() / 2)).setDuration(800L).setInterpolator(this.d0);
            PreferenceManager.getDefaultSharedPreferences(this.b0).edit().putString("lastUsername", a2.d()).commit();
            this.c0.o().b().a(null).a(new b.a() { // from class: h.b.a.e.d.h0
                @Override // h.b.a.d.b.a
                public final void a(h.b.a.d.b bVar2) {
                    r3.this.a(H, bVar2);
                }
            });
            return;
        }
        this.g0++;
        if (this.g0 == 3) {
            a.b.g.a.k v = v();
            if (v != null) {
                c4 c4Var = new c4();
                c4Var.b(H());
                c4Var.a(v, "report");
            }
            this.g0 = 0;
        }
        h.b.a.c.b(this.b0).k();
        a(H, aVar, findViewById, false);
        TextView textView = (TextView) H.findViewById(2131230875);
        String b2 = a2.b();
        if (b2 != null && b2.length() > 0) {
            textView.setText(b2);
        } else {
            textView.setText(2131755195);
        }
        textView.setVisibility(0);
        textView.setTranslationY(-textView.getHeight());
        textView.animate().alpha(1.0f).translationY(0.0f).setInterpolator(h.b.a.e.b.b.f7086b).setDuration(120L);
    }

    public /* synthetic */ void a(Transition transition, TextInputLayout textInputLayout) {
        if (transition != null) {
            transition.setStartDelay(0L);
        }
        if (j() == null) {
            return;
        }
        textInputLayout.setHint(this.b0.getString(2131755387));
        this.e0.setHint(this.b0.getString(2131755396));
    }

    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        v0();
    }

    public void a(View view, a.b.g.k.f0.c cVar) {
        final View findViewById = view.findViewById(2131230875);
        if (findViewById.getAlpha() > 0.0f) {
            findViewById.animate().alpha(0.0f).translationY(-findViewById.getHeight()).setInterpolator(cVar).withEndAction(new Runnable() { // from class: h.b.a.e.d.l0
                @Override // java.lang.Runnable
                public final void run() {
                    findViewById.setVisibility(8);
                }
            });
        }
    }

    public /* synthetic */ void c(final View view) {
        view.post(new Runnable() { // from class: h.b.a.e.d.o0
            @Override // java.lang.Runnable
            public final void run() {
                r3.this.b(view);
            }
        });
    }

    public void a(View view, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, a.b.g.k.f0.c cVar) {
        textInputLayout.setEnabled(false);
        textInputLayout2.setEnabled(false);
        view.findViewById(2131230951).setEnabled(false);
        view.findViewById(2131231010).setEnabled(false);
        if (Build.VERSION.SDK_INT >= 21) {
            view.findViewById(2131231005).animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setInterpolator(cVar);
        } else {
            view.findViewById(2131231005).animate().scaleX(1.2f).scaleY(1.2f).alpha(1.0f).setInterpolator(cVar);
        }
        View findViewById = view.findViewById(2131231015);
        findViewById.animate().alpha(0.0f).translationY(findViewById.getHeight()).setDuration(160L).setInterpolator(cVar);
    }

    public /* synthetic */ void a(View view, h.b.a.d.b bVar) {
        view.post(new Runnable() { // from class: h.b.a.e.d.n0
            @Override // java.lang.Runnable
            public final void run() {
                r3.this.p0();
            }
        });
    }

    @Override // h.b.a.d.b.a
    @SuppressLint({"ApplySharedPref"})
    public void a(h.b.a.d.b<u.a> bVar) {
        final View H = H();
        if (H == null) {
            return;
        }
        a.b.g.k.f0.a aVar = new a.b.g.k.f0.a();
        View findViewById = H.findViewById(2131231177);
        u.a a2 = bVar.a();
        if (a2.c()) {
            findViewById.animate().translationX(((H.getWidth() * 2) / 3) - (findViewById.getWidth() / 2)).setDuration(800L).setInterpolator(this.d0);
            PreferenceManager.getDefaultSharedPreferences(this.b0).edit().putString("lastUsername", a2.d()).commit();
            this.c0.o().b().a(null).a(new b.a() { // from class: h.b.a.e.d.j0
                @Override // h.b.a.d.b.a
                public final void a(h.b.a.d.b bVar2) {
                    r3.this.b(H, bVar2);
                }
            });
            return;
        }
        a(H, aVar, findViewById, false);
        TextView textView = (TextView) H.findViewById(2131230875);
        String b2 = a2.b();
        if (b2 != null && b2.length() > 0) {
            textView.setText(b2);
        } else {
            textView.setText(2131755195);
        }
        textView.setVisibility(0);
        textView.setTranslationY(-textView.getHeight());
        textView.animate().alpha(1.0f).translationY(0.0f).setInterpolator(h.b.a.e.b.b.f7086b).setDuration(120L);
    }

    public final void a(View view, a.b.g.k.f0.a aVar, View view2, boolean z) {
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(2131231173);
        TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(2131230991);
        if (z) {
            textInputLayout.setEnabled(true);
        }
        textInputLayout2.setEnabled(true);
        view.findViewById(2131230951).setEnabled(true);
        view.findViewById(2131231010).setEnabled(true);
        view.findViewById(2131231005).animate().scaleX(0.8f).scaleY(0.8f).alpha(0.0f).setInterpolator(aVar);
        view.findViewById(2131231015).animate().alpha(1.0f).translationY(0.0f).setDuration(160L).setInterpolator(aVar);
        if (view2 != null) {
            view.findViewById(2131230900).animate().alpha(0.0f);
            view2.animate().alpha(0.0f).translationY(view2.getHeight()).setDuration(80L).setInterpolator(this.d0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void a(int i2, String[] strArr, int[] iArr) {
        if (i2 == 1) {
            if (iArr.length == 1 && iArr[0] == 0) {
                onClick(null);
                return;
            }
            TextView textView = (TextView) H().findViewById(2131230875);
            textView.setText(2131755369);
            textView.setVisibility(0);
            textView.setTranslationY(-textView.getHeight());
            textView.animate().alpha(1.0f).translationY(0.0f).setInterpolator(h.b.a.e.b.b.f7086b).setDuration(120L);
            return;
        }
        super.a(i2, strArr, iArr);
    }
}
