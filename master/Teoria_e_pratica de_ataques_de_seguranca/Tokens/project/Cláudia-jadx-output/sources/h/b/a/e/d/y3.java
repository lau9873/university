package h.b.a.e.d;

import a.b.h.a.c;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
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
import h.b.a.d.b;
import h.b.a.d.u;
import h.b.a.d.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: ProfileFragment.java */
/* loaded from: classes.dex */
public class y3 extends g3 implements View.OnClickListener, DialogInterface.OnClickListener, TextView.OnEditorActionListener, DialogInterface.OnDismissListener, h.b.a.d.s, BottomNavigationView.c {
    public h.b.a.c c0;
    public h.b.a.d.y d0;
    public boolean e0 = false;
    public List<h.b.a.d.t> f0 = new ArrayList();
    public a.b.h.a.c g0;
    public b h0;
    public EditText i0;
    public EditText j0;
    public EditText k0;
    public b.a<u.d> l0;

    /* compiled from: ProfileFragment.java */
    /* loaded from: classes.dex */
    public class a implements b.a<u.d> {
        public a() {
        }

        @Override // h.b.a.d.b.a
        public void a(h.b.a.d.b<u.d> bVar) {
            u.d a2 = bVar.a();
            if (!a2.c()) {
                y3.this.c0.a(a2.b(), -1).m();
            } else {
                h.b.a.c.b(y3.this.b0).o().a(y3.this);
                y3.this.c0.a(y3.this.b0.getString(2131755304), 0).m();
            }
            y3.this.g0 = null;
            y3.this.i0 = null;
        }
    }

    /* compiled from: ProfileFragment.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f7409a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f7410b;

        /* renamed from: c  reason: collision with root package name */
        public final String f7411c;

        /* renamed from: d  reason: collision with root package name */
        public final String f7412d;

        public b(int i2, String str, String str2, boolean z) {
            this.f7409a = i2;
            this.f7411c = str;
            this.f7412d = str2;
            this.f7410b = z;
        }
    }

    static {
        new HashMap(2);
    }

    public y3() {
        new HashMap(2);
        this.l0 = new a();
    }

    public /* synthetic */ void b(Context context) {
        ((InputMethodManager) Objects.requireNonNull(context.getSystemService("input_method"))).toggleSoftInput(2, 0);
        this.j0.selectAll();
    }

    @Override // android.support.v4.app.Fragment
    public void c(Bundle bundle) {
        super.c(bundle);
        this.c0 = h.b.a.c.b(this.b0);
    }

    public /* synthetic */ void d(Context context) {
        ((InputMethodManager) Objects.requireNonNull(context.getSystemService("input_method"))).toggleSoftInput(2, 0);
        this.i0.selectAll();
    }

    public /* synthetic */ boolean f(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 2131230866) {
            Toast.makeText(this.b0, 2131755306, 0).show();
            return true;
        } else if (itemId == 2131230957) {
            h.b.a.c.b(this.b0).o().b().a();
            n0();
            return true;
        } else if (itemId != 2131230991) {
            return false;
        } else {
            a(new b(-1, this.b0.getString(2131755396), "", true));
            return true;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        n0();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        ((InputMethodManager) this.b0.getSystemService("input_method")).toggleSoftInput(1, 0);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
        if (i2 == 6) {
            this.g0.dismiss();
            p0();
            return true;
        }
        return false;
    }

    @Override // h.b.a.d.s
    public void onError(DataModels.Error error) {
        this.e0 = false;
        for (h.b.a.d.t tVar : this.f0) {
            tVar.onError(error);
        }
    }

    @Override // h.b.a.d.s
    public void onSuccess(DataModels.UserAccountInfo userAccountInfo) {
        h.b.a.d.b<h.b.a.d.y> a2 = h.b.a.c.X().o().b().a(userAccountInfo);
        this.d0 = a2.a();
        this.e0 = true;
        for (h.b.a.d.t tVar : this.f0) {
            tVar.b(a2);
        }
    }

    public final void p0() {
        y.d edit = this.d0.edit();
        String trim = this.i0.getText().toString().trim();
        String trim2 = this.j0.getText().toString().trim();
        String trim3 = this.k0.getText().toString().trim();
        int i2 = this.h0.f7409a;
        if (i2 != -1) {
            if (i2 == 0) {
                edit.b(trim);
            } else if (i2 == 1) {
                edit.c(trim);
            } else if (i2 == 2) {
                edit.e(trim);
            }
            this.c0.a(this.b0.getString(2131755307), -1).m();
            edit.o().a(this.l0);
        } else if (!trim3.equals(trim2)) {
            this.c0.a(h.b.a.c.W().getString(2131755399), -1).m();
        } else {
            this.c0.a(this.b0.getString(2131755307), -1).m();
            edit.a(edit.h(), trim, trim2).a(this.l0);
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        if (i2 == -1) {
            p0();
        }
    }

    public /* synthetic */ void c(Context context) {
        ((InputMethodManager) Objects.requireNonNull(context.getSystemService("input_method"))).toggleSoftInput(2, 0);
        this.k0.selectAll();
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(2131427386, viewGroup, false);
        Toolbar toolbar = (Toolbar) viewGroup2.findViewById(2131231152);
        toolbar.setNavigationIcon(2131165559);
        toolbar.setNavigationContentDescription(2131755050);
        toolbar.setNavigationOnClickListener(this);
        toolbar.c(2131492866);
        toolbar.setOnMenuItemClickListener(new Toolbar.f() { // from class: h.b.a.e.d.e1
            @Override // android.support.v7.widget.Toolbar.f
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return y3.this.f(menuItem);
            }
        });
        BottomNavigationView bottomNavigationView = (BottomNavigationView) viewGroup2.findViewById(2131230972);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        a(bottomNavigationView.getMenu().getItem(0));
        h.b.a.c.X().o().a(this);
        return viewGroup2;
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

    public final void a(b bVar) {
        if (!this.e0) {
            Context context = this.b0;
            Toast.makeText(context, context.getString(2131755116), 0).show();
        } else if (!bVar.f7410b) {
            Context context2 = this.b0;
            Toast.makeText(context2, context2.getString(2131755117), 0).show();
        } else {
            this.h0 = bVar;
            final Context q = q();
            c.a aVar = new c.a((Context) Objects.requireNonNull(q));
            aVar.b(bVar.f7411c);
            int applyDimension = (int) TypedValue.applyDimension(1, 21.0f, B().getDisplayMetrics());
            LinearLayout linearLayout = new LinearLayout(q);
            linearLayout.setOrientation(1);
            linearLayout.setPadding(applyDimension, applyDimension / 4, applyDimension, 0);
            this.i0 = new EditText(q);
            this.i0.setSingleLine();
            this.i0.setText(bVar.f7412d);
            this.i0.setImeOptions(6);
            if (bVar.f7409a == 6) {
                this.i0.setInputType(2);
            }
            this.i0.setOnEditorActionListener(this);
            linearLayout.addView(this.i0);
            if (bVar.f7409a == 1) {
                TextView textView = new TextView(q);
                textView.setText(2131755303);
                int i2 = applyDimension / 6;
                textView.setPadding(i2, applyDimension / 8, i2, 0);
                linearLayout.addView(textView);
            }
            if (bVar.f7409a == -1) {
                this.i0.setHint(q.getString(2131755386));
                this.i0.setInputType(128);
                this.i0.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.j0 = new EditText(q);
                this.j0.setHint(q.getString(2131755398));
                this.j0.setInputType(128);
                this.j0.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.k0 = new EditText(q);
                this.k0.setHint(q.getString(2131755393));
                this.k0.setInputType(128);
                this.k0.setTransformationMethod(PasswordTransformationMethod.getInstance());
                linearLayout.addView(this.j0);
                linearLayout.addView(this.k0);
                this.j0.post(new Runnable() { // from class: h.b.a.e.d.f1
                    @Override // java.lang.Runnable
                    public final void run() {
                        y3.this.b(q);
                    }
                });
                this.k0.post(new Runnable() { // from class: h.b.a.e.d.h1
                    @Override // java.lang.Runnable
                    public final void run() {
                        y3.this.c(q);
                    }
                });
            }
            aVar.b(linearLayout);
            aVar.b(2131755378, this);
            aVar.a(17039360, this);
            aVar.a(this);
            this.g0 = aVar.c();
            this.i0.post(new Runnable() { // from class: h.b.a.e.d.g1
                @Override // java.lang.Runnable
                public final void run() {
                    y3.this.d(q);
                }
            });
        }
    }

    @Override // android.support.design.widget.BottomNavigationView.c
    public boolean a(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 2131230993) {
            d(new s3());
            return true;
        } else if (itemId == 2131230996) {
            d(new w3());
            return true;
        } else if (itemId != 2131231077) {
            return false;
        } else {
            d(new f4());
            return true;
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
}
