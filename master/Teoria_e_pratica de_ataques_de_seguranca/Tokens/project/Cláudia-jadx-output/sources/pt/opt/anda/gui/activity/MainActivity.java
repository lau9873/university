package pt.opt.anda.gui.activity;

import a.b.g.a.k;
import a.b.h.a.c;
import a.b.h.a.d;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.view.Window;
import android.webkit.MimeTypeMap;
import android.widget.TextView;
import d.c.p;
import h.b.a.c;
import h.b.a.d.a;
import h.b.a.d.f;
import h.b.a.d.o;
import h.b.a.d.q;
import h.b.a.e.a.h;
import h.b.a.e.d.g3;
import h.b.a.e.d.n3;
import h.b.a.e.d.q3;
import java.io.File;
import java.text.DateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;
import pt.opt.anda.gui.activity.MainActivity;
/* loaded from: classes.dex */
public class MainActivity extends d implements h, f, a, o.c {
    public c q;
    public DateFormat r;
    public boolean s = false;
    public boolean t = false;
    public boolean u;
    public a.b.h.a.c v;
    public a.b.h.a.c w;

    public static /* synthetic */ void d(Window window, p pVar) {
        window.clearFlags(6815744);
        pVar.a();
    }

    @Override // h.b.a.d.o.c
    public void a(o oVar) {
    }

    @Override // h.b.a.d.o.c
    public void a(o oVar, f.a aVar) {
    }

    @Override // h.b.a.d.o.c
    public void a(o oVar, o.c.a aVar) {
    }

    @Override // h.b.a.d.o.c
    public void a(o oVar, q qVar) {
    }

    @Override // h.b.a.e.a.h
    public void a(g3 g3Var, Fragment fragment, boolean z) {
        if (this.u) {
            a.b.g.a.q a2 = f().a();
            a2.b(2131231041, fragment);
            if (fragment.r() == null) {
                a2.a(16973825);
            }
            if (z) {
                a2.a((String) null);
            }
            a2.a();
        }
    }

    @Override // h.b.a.d.a
    public void a(boolean z, boolean z2) {
    }

    @Override // h.b.a.d.a
    public void b() {
    }

    public /* synthetic */ void b(View view) {
        r();
    }

    @Override // h.b.a.d.f
    public void b(f.b bVar) {
    }

    @Override // h.b.a.d.o.c
    public void b(o oVar) {
    }

    @SuppressLint({"RestrictedApi"})
    public final void c(Intent intent) {
        if (intent.getIntExtra("p", 0) != 0) {
            for (Fragment fragment : f().c()) {
                if (fragment instanceof n3) {
                    if (intent.getBooleanExtra(g.a.b.c.j, false)) {
                        ((n3) fragment).q0();
                        return;
                    } else if (!intent.hasExtra("ce")) {
                        ((n3) fragment).C0();
                        return;
                    } else {
                        ((n3) fragment).d(intent.getIntExtra("ce", 0));
                        return;
                    }
                }
            }
        }
    }

    @Override // h.b.a.d.o.c
    public void c(o oVar) {
    }

    @Override // h.b.a.d.o.c
    public void d(o oVar) {
    }

    public boolean o() {
        return this.s;
    }

    @Override // a.b.g.a.g, android.app.Activity
    public void onBackPressed() {
        if (this.t) {
            this.q.d();
        } else {
            super.onBackPressed();
        }
    }

    @Override // a.b.h.a.d, a.b.g.a.g, a.b.g.a.g0, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().requestFeature(12);
        this.q = c.b((Context) this);
        this.q.a((f) this);
        this.q.a((a) this);
        this.q.a((o.c) this);
        this.q.b((a) this);
        setContentView(2131427356);
        if (bundle == null) {
            a.b.g.a.q a2 = f().a();
            a2.b(2131231041, this.q.o().a() ? new n3() : new q3());
            a2.a();
            new Handler().post(new Runnable() { // from class: h.b.a.e.a.a
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.this.p();
                }
            });
        }
    }

    @Override // a.b.h.a.d, a.b.g.a.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.q.b((f) this);
        this.q.b((o.c) this);
        this.q.U();
    }

    @Override // a.b.g.a.g, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        c(intent);
    }

    @Override // a.b.g.a.g, android.app.Activity
    public void onPause() {
        this.s = false;
        this.u = false;
        super.onPause();
    }

    @Override // a.b.h.a.d, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    @Override // a.b.h.a.d, a.b.g.a.g, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.u = true;
    }

    @Override // a.b.g.a.g, android.app.Activity
    public void onResume() {
        super.onResume();
        this.s = true;
        this.q.c();
    }

    @Override // a.b.h.a.d, a.b.g.a.g, a.b.g.a.g0, android.app.Activity
    @SuppressLint({"MissingSuperCall"})
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // h.b.a.d.a
    public void onTripAppActivityBlocked() {
    }

    @Override // h.b.a.d.a
    @SuppressLint({"CheckResult"})
    public void onWakeUpRequired() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(131072);
        startActivityIfNeeded(intent, 100, null);
        v();
    }

    public /* synthetic */ void p() {
        c(getIntent());
    }

    public void q() {
        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 101);
    }

    public void r() {
        startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }

    public void s() {
        startActivity(new Intent("android.settings.NFC_SETTINGS"));
    }

    public final void t() {
        if (this.v == null) {
            this.v = a(this, 2131755202, getString(2131755203).replace("\n", " "), new View.OnClickListener() { // from class: h.b.a.e.a.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.this.a(view);
                }
            });
        }
        this.v.show();
    }

    public final void u() {
        if (this.w == null) {
            this.w = a(this, 2131755219, getString(2131755220).replace("\n", " "), new View.OnClickListener() { // from class: h.b.a.e.a.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.this.b(view);
                }
            });
        }
        this.w.show();
    }

    public final void v() {
        final Window window = getWindow();
        d.c.o.a(d.c.o.a(new d.c.q() { // from class: h.b.a.e.a.d
            @Override // d.c.q
            public final void a(p pVar) {
                MainActivity.this.a(window, pVar);
            }
        }), d.c.o.b(2L, TimeUnit.SECONDS), d.c.o.a(new d.c.q() { // from class: h.b.a.e.a.g
            @Override // d.c.q
            public final void a(p pVar) {
                MainActivity.this.b(window, pVar);
            }
        })).d();
    }

    public /* synthetic */ void b(final Window window, final p pVar) {
        runOnUiThread(new Runnable() { // from class: h.b.a.e.a.c
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.d(window, pVar);
            }
        });
    }

    @Override // h.b.a.e.a.h
    public void a(Fragment fragment) {
        if (this.s) {
            try {
                f().f();
            } catch (Exception unused) {
                f().e();
            }
        }
    }

    @Override // h.b.a.e.a.h
    public DateFormat c() {
        this.r = android.text.format.DateFormat.getTimeFormat(this);
        return this.r;
    }

    public static /* synthetic */ void c(Window window, p pVar) {
        window.addFlags(6815744);
        pVar.a();
    }

    @Override // h.b.a.e.a.h
    public void a(g3 g3Var, Fragment fragment) {
        k f2 = f();
        for (int i2 = 0; i2 < f2.b(); i2++) {
            f2.e();
        }
        List<Fragment> c2 = f2.c();
        a.b.g.a.q a2 = f2.a();
        if (c2 != null) {
            for (Fragment fragment2 : c2) {
                if (fragment2 != null) {
                    a2.a(fragment2);
                }
            }
        }
        a2.b(2131231041, fragment);
        a2.a();
    }

    @Override // h.b.a.e.a.h
    public void a(boolean z) {
        this.t = z;
    }

    public static Intent a(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("p", 1);
        return intent;
    }

    public static Intent a(Context context, int i2) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("p", 1);
        intent.putExtra("ce", i2);
        return intent;
    }

    public static Intent a(Context context, String str, String str2) {
        Uri a2 = FileProvider.a(context, str2, new File(str));
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(a2.toString()).toLowerCase());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(a2, mimeTypeFromExtension);
        intent.addFlags(1);
        return intent;
    }

    @Override // h.b.a.d.f
    public void a(f.a aVar) {
        if (this.q.A() || this.q.C()) {
            f.a.EnumC0164a b2 = aVar.b();
            if (b2 == f.a.EnumC0164a.bluetoothOff) {
                t();
            } else if (b2 != f.a.EnumC0164a.locationOff) {
                return;
            } else {
                u();
            }
            if (this.s) {
                aVar.e();
            }
        }
    }

    @Override // h.b.a.d.f
    public void a(f.b bVar) {
        a.b.h.a.c cVar;
        a.b.h.a.c cVar2;
        if (bVar == f.b.bluetooth && (cVar2 = this.v) != null) {
            cVar2.dismiss();
        } else if (bVar != f.b.location || (cVar = this.w) == null) {
        } else {
            cVar.dismiss();
        }
    }

    public /* synthetic */ void a(View view) {
        q();
    }

    public static a.b.h.a.c a(Context context, int i2, String str, View.OnClickListener onClickListener) {
        c.a aVar = new c.a(context);
        aVar.b(i2);
        View inflate = View.inflate(context, 2131427374, null);
        TextView textView = (TextView) inflate.findViewById(2131230961);
        textView.setText(str);
        textView.setOnClickListener(onClickListener);
        inflate.findViewById(2131230821).setOnClickListener(onClickListener);
        aVar.b(inflate);
        aVar.a(false);
        return aVar.a();
    }

    public /* synthetic */ void a(final Window window, final p pVar) {
        runOnUiThread(new Runnable() { // from class: h.b.a.e.a.e
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.c(window, pVar);
            }
        });
    }

    @Override // h.b.a.d.a
    public Snackbar a(String str, int i2) {
        return Snackbar.a(findViewById(16908290), str, i2);
    }

    @Override // h.b.a.d.o.c
    public void a(o oVar, o.a aVar) {
        a.b.h.a.c cVar = this.v;
        if (cVar != null) {
            cVar.dismiss();
        }
        a.b.h.a.c cVar2 = this.w;
        if (cVar2 != null) {
            cVar2.dismiss();
        }
    }
}
