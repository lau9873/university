package h.b.a.e.d;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import h.b.a.d.b;
import h.b.a.d.u;
import java.util.Objects;
/* compiled from: RegisterFragment.java */
/* loaded from: classes.dex */
public class a4 extends g3 implements View.OnClickListener, h.b.a.e.e.a {
    public a.b.g.k.x c0;
    public z3 d0;
    public b4 e0;
    public FloatingActionButton f0;
    public ProgressBar g0;

    /* compiled from: RegisterFragment.java */
    /* loaded from: classes.dex */
    public class a extends a.b.g.a.p {
        public a(a.b.g.a.k kVar) {
            super(kVar);
        }

        @Override // a.b.g.k.q
        public int a() {
            return 2;
        }

        @Override // a.b.g.a.p
        public Fragment b(int i2) {
            if (i2 == 0) {
                if (a4.this.d0 == null) {
                    a4.this.d0 = new z3();
                    a4.this.d0.a((h.b.a.e.e.a) a4.this);
                }
                return a4.this.d0;
            } else if (i2 == 1) {
                if (a4.this.e0 == null) {
                    a4.this.e0 = new b4();
                }
                return a4.this.e0;
            } else {
                return null;
            }
        }
    }

    @Override // h.b.a.e.e.a
    public void g() {
        int currentItem = this.c0.getCurrentItem();
        if (currentItem == 0) {
            this.c0.setCurrentItem(currentItem + 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f0) {
            h.b.a.c b2 = h.b.a.c.b(this.b0);
            int currentItem = this.c0.getCurrentItem();
            if (currentItem == 0) {
                a(b2);
            } else if (currentItem != 1) {
            } else {
                a(b2);
            }
        } else if (this.c0.getCurrentItem() == 0) {
            n0();
        } else {
            a.b.g.k.x xVar = this.c0;
            xVar.setCurrentItem(xVar.getCurrentItem() - 1);
        }
    }

    public final boolean p0() {
        boolean a2 = a(this.d0.u0(), this.d0.t0(), this.d0.v0(), this.d0.w0(), this.d0.x0());
        boolean i2 = this.d0.r0().i();
        if (!i2) {
            this.d0.x0().setError(a(2131755231));
        }
        return a2 && a(this.d0.s0()) && i2;
    }

    @SuppressLint({"ApplySharedPref"})
    public final void q0() {
        if (p0() && this.d0.q0() && this.d0.p0()) {
            a(false, this.d0.u0(), this.d0.t0(), this.d0.v0(), this.d0.w0(), this.d0.x0(), this.e0.s0(), this.e0.u0(), this.e0.w0(), this.e0.r0(), this.f0, this.e0.p0(), this.e0.v0());
            final a.b.g.k.f0.c cVar = h.b.a.e.b.b.f7086b;
            this.g0.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setInterpolator(cVar);
            String fullNumberWithPlus = this.d0.r0().getFullNumberWithPlus();
            u.b e2 = h.b.a.c.b(this.b0).o().e();
            e2.b(((EditText) Objects.requireNonNull(this.d0.u0().getEditText())).getText().toString());
            e2.c(((EditText) Objects.requireNonNull(this.d0.t0().getEditText())).getText().toString());
            e2.i(((EditText) Objects.requireNonNull(this.d0.v0().getEditText())).getText().toString());
            e2.e(fullNumberWithPlus);
            e2.g(((EditText) Objects.requireNonNull(this.e0.s0().getEditText())).getText().toString());
            e2.d(((EditText) Objects.requireNonNull(this.e0.r0().getEditText())).getText().toString());
            e2.f(((EditText) Objects.requireNonNull(this.e0.w0().getEditText())).getText().toString());
            e2.h(((EditText) Objects.requireNonNull(this.e0.t0().getEditText())).getText().toString());
            e2.a(this.e0.q0());
            try {
                e2.j(((EditText) Objects.requireNonNull(this.e0.u0().getEditText())).getText().toString());
            } catch (NumberFormatException unused) {
                e2.j("");
            }
            e2.a(((EditText) Objects.requireNonNull(this.e0.v0().getEditText())).getText().toString());
            e2.p();
            e2.n().a(new b.a() { // from class: h.b.a.e.d.t1
                @Override // h.b.a.d.b.a
                public final void a(h.b.a.d.b bVar) {
                    a4.this.a(cVar, bVar);
                }
            });
            return;
        }
        this.c0.setCurrentItem(0);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.b.a.c.b(this.b0).a(j(), false);
        View inflate = layoutInflater.inflate(2131427387, viewGroup, false);
        Toolbar toolbar = (Toolbar) inflate.findViewById(2131231152);
        toolbar.setNavigationIcon(2131165559);
        toolbar.setNavigationContentDescription(2131755050);
        toolbar.setNavigationOnClickListener(this);
        this.c0 = (a.b.g.k.x) inflate.findViewById(2131230985);
        this.c0.setAdapter(new a(p()));
        this.f0 = (FloatingActionButton) inflate.findViewById(2131231015);
        this.f0.setOnClickListener(this);
        this.g0 = (ProgressBar) inflate.findViewById(2131231005);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.a(new Explode());
        }
    }

    public final void a(h.b.a.c cVar) {
        if (cVar.s()) {
            Toast.makeText(j(), 2131755205, 0).show();
        } else if (cVar.p()) {
            Toast.makeText(j(), 2131755204, 0).show();
        } else if (this.d0.B0()) {
            Toast.makeText(j(), 2131755238, 0).show();
        } else {
            q0();
        }
    }

    public /* synthetic */ void a(a.b.g.k.f0.c cVar, h.b.a.d.b bVar) {
        if (j() == null) {
            return;
        }
        u.c cVar2 = (u.c) bVar.a();
        if (cVar2.c()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.b0);
            builder.setTitle(2131755377);
            builder.setMessage(2131755376);
            builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
            builder.show();
            if (Build.VERSION.SDK_INT >= 21) {
                b(new Slide(a.b.g.k.d.a(8388613, B().getConfiguration().getLayoutDirection())));
            }
            PreferenceManager.getDefaultSharedPreferences(this.b0).edit().putString("lastUsername", this.d0.t0().getEditText().getText().toString()).commit();
            n0();
            b((Fragment) new r3(this.d0.t0().getEditText().getText().toString(), this.d0.v0().getEditText().getText().toString()));
            return;
        }
        a(true, this.d0.u0(), this.d0.t0(), this.d0.v0(), this.d0.w0(), this.d0.x0(), this.e0.s0(), this.e0.u0(), this.e0.w0(), this.e0.r0(), this.f0, this.e0.p0(), this.e0.v0());
        this.g0.animate().scaleX(0.8f).scaleY(0.8f).alpha(0.0f).setInterpolator(cVar);
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this.b0);
        String b2 = cVar2.b();
        if (b2 == null || b2.length() == 0) {
            b2 = cVar2.a();
        }
        if (b2 != null && b2.length() != 0) {
            builder2.setMessage(b2);
        } else {
            builder2.setTitle(2131755195);
        }
        builder2.setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
        builder2.show();
    }

    public final void a(boolean z, View... viewArr) {
        for (View view : viewArr) {
            view.setEnabled(z);
        }
    }

    public final boolean a(TextInputLayout... textInputLayoutArr) {
        boolean z = true;
        for (TextInputLayout textInputLayout : textInputLayoutArr) {
            if (textInputLayout.getEditText().getText().length() == 0) {
                textInputLayout.setError(this.b0.getString(2131755230));
                z = false;
            } else {
                textInputLayout.setError(null);
            }
        }
        return z;
    }

    public final boolean a(CheckBox... checkBoxArr) {
        boolean z = true;
        for (CheckBox checkBox : checkBoxArr) {
            if (!checkBox.isChecked()) {
                checkBox.setError(this.b0.getString(2131755232));
                z = false;
            } else {
                checkBox.setError(null);
            }
        }
        return z;
    }
}
