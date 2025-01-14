package h.b.a.e.d;

import a.b.h.a.c;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import h.b.a.d.b;
import h.b.a.d.u;
import h.b.a.d.y;
import h.b.a.e.d.i3;
import h.b.a.e.d.w3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: PersonalDataFragment.java */
/* loaded from: classes.dex */
public class w3 extends g3 implements TextView.OnEditorActionListener, View.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnClickListener, h.b.a.d.s {
    public h.b.a.c c0;
    public Snackbar d0;
    public h.b.a.d.y g0;
    public ViewGroup h0;
    public EditText i0;
    public ProgressBar j0;
    public i3.a k0;
    public a.b.h.a.c l0;
    public boolean e0 = false;
    public List<h.b.a.d.t> f0 = new ArrayList();
    public HashMap<String, DataModels.Language> m0 = new HashMap<>();
    public List<i3.a> n0 = new ArrayList();
    public b.a<u.d> o0 = new a();

    /* compiled from: PersonalDataFragment.java */
    /* loaded from: classes.dex */
    public class a implements b.a<u.d> {
        public a() {
        }

        @Override // h.b.a.d.b.a
        public void a(h.b.a.d.b<u.d> bVar) {
            u.d a2 = bVar.a();
            if (a2.c()) {
                w3 w3Var = w3.this;
                w3Var.d0 = w3Var.c0.a(w3.this.b0.getString(2131755304), 0);
                w3.this.d0.m();
                h.b.a.c.b(w3.this.b0).o().a(w3.this);
            } else {
                w3 w3Var2 = w3.this;
                w3Var2.d0 = w3Var2.c0.a(a2.b(), -1);
                w3.this.d0.m();
            }
            w3.this.l0 = null;
            w3.this.i0 = null;
        }
    }

    /* compiled from: PersonalDataFragment.java */
    /* loaded from: classes.dex */
    public static class b extends i3.a {

        /* renamed from: f  reason: collision with root package name */
        public DataModels.Language f7389f;

        public b(int i2, DataModels.Language language) {
            super(i2, 1, language.getCode(), 0);
            this.f7389f = language;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && this.f7389f.getCode().equals(((b) obj).f7389f.getCode());
        }
    }

    /* compiled from: PersonalDataFragment.java */
    /* loaded from: classes.dex */
    public class c extends RecyclerView.g<h.b.a.e.f.a> implements b.a<h.b.a.d.y>, h.b.a.d.t {

        /* renamed from: c  reason: collision with root package name */
        public final List<i3.a> f7390c = new ArrayList();

        public c() {
            w3.this.a((h.b.a.d.t) this);
        }

        @Override // android.support.v7.widget.RecyclerView.g
        public int c(int i2) {
            return this.f7390c.get(i2).f7216c;
        }

        @Override // h.b.a.d.t
        @SuppressLint({"LongLogTag"})
        public void onError(DataModels.Error error) {
            Log.d("PersonalDataFragment.class", String.format("ProfileFragment: onError was invoked with error: %s", error.getMessage()));
            h.b.a.d.b<h.b.a.d.y> a2 = h.b.a.c.b(w3.this.b0).o().b().a(null);
            w3.this.e0 = false;
            a2.a(this);
        }

        @Override // android.support.v7.widget.RecyclerView.g
        /* renamed from: a */
        public void b(h.b.a.e.f.a aVar, int i2) {
            aVar.a(this.f7390c.get(i2));
        }

        @Override // android.support.v7.widget.RecyclerView.g
        public int a() {
            List<i3.a> list = this.f7390c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // h.b.a.d.t
        @SuppressLint({"LongLogTag"})
        public void b(h.b.a.d.b<h.b.a.d.y> bVar) {
            Log.d("PersonalDataFragment.class", "ProfileFragment: onSuccess() invoked");
            if (bVar != null) {
                w3.this.e0 = true;
                bVar.a(this);
            }
        }

        @Override // h.b.a.d.b.a
        public void a(h.b.a.d.b<h.b.a.d.y> bVar) {
            if (w3.this.K()) {
                final h.b.a.d.y a2 = bVar.a();
                w3.this.g0 = a2;
                h.b.a.c.b(w3.this.b0).o().a(new Runnable() { // from class: h.b.a.e.d.c1
                    @Override // java.lang.Runnable
                    public final void run() {
                        w3.c.this.b(a2);
                    }
                });
            }
        }

        @Override // android.support.v7.widget.RecyclerView.g
        public h.b.a.e.f.a b(ViewGroup viewGroup, int i2) {
            w3 w3Var = w3.this;
            return new d(LayoutInflater.from(w3Var.b0).inflate(2131427408, viewGroup, false));
        }

        public /* synthetic */ void a(h.b.a.d.y yVar) {
            h.b.a.c.b(w3.this.b0).b(new x3(this, yVar));
        }

        public /* synthetic */ void b(final h.b.a.d.y yVar) {
            w3.this.h0.post(new Runnable() { // from class: h.b.a.e.d.d1
                @Override // java.lang.Runnable
                public final void run() {
                    w3.c.this.a(yVar);
                }
            });
        }
    }

    /* compiled from: PersonalDataFragment.java */
    /* loaded from: classes.dex */
    public class d extends h.b.a.e.f.a implements View.OnClickListener {
        public final TextView u;
        public final TextView v;
        public e w;

        public d(View view) {
            super(view);
            this.u = (TextView) view.findViewById(2131230971);
            this.v = (TextView) view.findViewById(2131231176);
            view.setOnClickListener(this);
        }

        @Override // h.b.a.e.f.a
        public void a(i3.a aVar) {
            this.w = (e) aVar;
            this.u.setText(this.w.f7393g);
            this.v.setText(this.w.f7394h);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            w3.this.a(this.w);
        }
    }

    /* compiled from: PersonalDataFragment.java */
    /* loaded from: classes.dex */
    public static class e extends i3.a {

        /* renamed from: f  reason: collision with root package name */
        public final boolean f7392f;

        /* renamed from: g  reason: collision with root package name */
        public final String f7393g;

        /* renamed from: h  reason: collision with root package name */
        public final String f7394h;

        public e(int i2, String str, String str2, boolean z) {
            super(i2, 1, str == null ? "" : str, 0);
            this.f7393g = str;
            this.f7394h = str2;
            this.f7392f = z;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            if (obj instanceof e) {
                e eVar = (e) obj;
                if (this.f7392f == eVar.f7392f && (str = this.f7393g) != null && (str2 = eVar.f7393g) != null && this.f7394h != null && eVar.f7394h != null && str.equals(str2) && this.f7394h.equals(eVar.f7394h)) {
                    return true;
                }
            }
            return false;
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
            this.l0.dismiss();
            p0();
            return true;
        }
        return false;
    }

    @Override // h.b.a.d.s
    public void onError(DataModels.Error error) {
        this.j0.setVisibility(4);
        for (h.b.a.d.t tVar : this.f0) {
            tVar.onError(error);
        }
    }

    @Override // h.b.a.d.s
    public void onSuccess(DataModels.UserAccountInfo userAccountInfo) {
        this.j0.setVisibility(4);
        h.b.a.d.b<h.b.a.d.y> a2 = h.b.a.c.b(this.b0).o().b().a(userAccountInfo);
        for (h.b.a.d.t tVar : this.f0) {
            tVar.b(a2);
        }
    }

    @SuppressLint({"LongLogTag"})
    public final void p0() {
        y.d edit = this.g0.edit();
        String trim = this.k0.f7214a != 7 ? this.i0.getText().toString().trim() : "";
        int i2 = this.k0.f7214a;
        if (i2 != -1 && i2 == 0) {
            edit.b(trim);
        }
        this.d0 = this.c0.a(this.b0.getString(2131755307), -1);
        this.d0.m();
        edit.o().a(this.o0);
    }

    public /* synthetic */ void q0() {
        ((InputMethodManager) this.b0.getSystemService("input_method")).toggleSoftInput(2, 0);
        this.i0.selectAll();
    }

    @Override // android.support.v4.app.Fragment
    public void c(Bundle bundle) {
        super.c(bundle);
        this.c0 = h.b.a.c.b(this.b0);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        if (i2 == -1) {
            p0();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(2131427384, viewGroup, false);
        this.h0 = viewGroup2;
        RecyclerView recyclerView = (RecyclerView) viewGroup2.findViewById(2131230947);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.b0));
        this.j0 = (ProgressBar) viewGroup2.findViewById(2131231005);
        recyclerView.setAdapter(new c());
        h.b.a.c.X().o().a(this);
        return viewGroup2;
    }

    public final void a(e eVar) {
        if (!eVar.f7392f) {
            Context context = this.b0;
            Toast.makeText(context, context.getString(2131755117), 0).show();
        } else if (!this.e0) {
            Context context2 = this.b0;
            Toast.makeText(context2, context2.getString(2131755116), 0).show();
        } else {
            this.k0 = eVar;
            c.a aVar = new c.a(this.b0);
            aVar.b(eVar.f7393g);
            int applyDimension = (int) TypedValue.applyDimension(1, 21.0f, B().getDisplayMetrics());
            LinearLayout linearLayout = new LinearLayout(this.b0);
            linearLayout.setOrientation(1);
            linearLayout.setPadding(applyDimension, applyDimension / 4, applyDimension, 0);
            this.i0 = new EditText(this.b0);
            this.i0.setSingleLine();
            this.i0.setText(eVar.f7394h);
            this.i0.setImeOptions(6);
            if (eVar.f7214a == 6) {
                this.i0.setInputType(2);
            }
            this.i0.setOnEditorActionListener(this);
            linearLayout.addView(this.i0);
            if (eVar.f7214a == 1) {
                TextView textView = new TextView(this.b0);
                textView.setText(2131755303);
                int i2 = applyDimension / 6;
                textView.setPadding(i2, applyDimension / 8, i2, 0);
                linearLayout.addView(textView);
            }
            aVar.b(linearLayout);
            aVar.b(2131755378, this);
            aVar.a(17039360, this);
            aVar.a(this);
            this.l0 = aVar.c();
            this.i0.post(new Runnable() { // from class: h.b.a.e.d.b1
                @Override // java.lang.Runnable
                public final void run() {
                    w3.this.q0();
                }
            });
        }
    }

    public final void a(h.b.a.d.t tVar) {
        if (this.f0.contains(tVar)) {
            return;
        }
        this.f0.add(tVar);
    }
}
