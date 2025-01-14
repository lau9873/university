package h.b.a.e.d;

import android.annotation.SuppressLint;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import h.b.a.d.b;
import h.b.a.d.f;
import h.b.a.d.o;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import pt.card4b.backendbeacons.BackEnd;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: InspectionFragment.java */
/* loaded from: classes.dex */
public class p3 extends h3 implements o.c, b.a<h.b.a.d.y>, h.b.a.d.s {
    public h.b.a.c d0;
    public ViewGroup e0;
    public boolean f0;
    public ConstraintLayout g0;
    public ConstraintLayout h0;
    public TextView i0;
    public TextView j0;
    public TextView k0;
    public TextView l0;
    public TextView m0;
    public TextView n0;
    public TextView o0;
    public ImageView p0;
    public TextView q0;
    public ImageView r0;

    /* compiled from: InspectionFragment.java */
    /* loaded from: classes.dex */
    public class a implements h.b.a.d.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TextView f7304a;

        public a(p3 p3Var, TextView textView) {
            this.f7304a = textView;
        }

        @Override // h.b.a.d.g
        public void a(String str) {
            this.f7304a.setText(str);
        }

        @Override // h.b.a.d.g
        public void a(DataModels.Error error) {
            BackEnd.addToLog(String.format("[%s] Backend.getCardInfo returned onError! Error: %s", "InspectionFragment.class", error.getMessage()));
        }
    }

    /* compiled from: InspectionFragment.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DateFormat f7305a;

        public b(DateFormat dateFormat) {
            this.f7305a = dateFormat;
        }

        @Override // java.lang.Runnable
        public void run() {
            p3.this.j0.setText(this.f7305a.format(Calendar.getInstance().getTime()));
            p3.this.e0.postDelayed(this, 1000L);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void U() {
        this.d0.b(this);
        super.U();
    }

    @Override // h.b.a.d.o.c
    public void a(h.b.a.d.o oVar) {
    }

    @Override // h.b.a.d.o.c
    public void a(h.b.a.d.o oVar, f.a aVar) {
    }

    @Override // h.b.a.d.o.c
    public void a(h.b.a.d.o oVar, o.c.a aVar) {
    }

    @Override // h.b.a.d.o.c
    public void b(h.b.a.d.o oVar) {
    }

    @Override // h.b.a.e.d.h3, android.support.v4.app.Fragment
    public void c(Bundle bundle) {
        super.c(bundle);
        this.f0 = false;
        this.d0 = h.b.a.c.b(this.b0);
        this.d0.a(this);
    }

    @Override // h.b.a.d.o.c
    public void c(h.b.a.d.o oVar) {
    }

    @Override // h.b.a.d.o.c
    public void d(h.b.a.d.o oVar) {
        u0();
    }

    @Override // h.b.a.d.s
    @SuppressLint({"LongLogTag"})
    public void onError(DataModels.Error error) {
        Log.w("InspectionFragment.class", String.format("tryGetRemoteUser: onError was invoked with error: %s", error.getMessageToUser()));
    }

    @Override // h.b.a.d.s
    @SuppressLint({"LongLogTag"})
    public void onSuccess(DataModels.UserAccountInfo userAccountInfo) {
        Log.d("InspectionFragment.class", "tryGetRemoteUser: onSuccess was invoked");
        a(this.d0.o().b().a(userAccountInfo).a());
    }

    @Override // h.b.a.e.d.h3
    public void p0() {
        ViewGroup viewGroup = this.e0;
        if (viewGroup == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams();
        marginLayoutParams.bottomMargin = r0();
        this.e0.setLayoutParams(marginLayoutParams);
        d(-1);
        s0().b();
    }

    public final void t0() {
        this.g0.setVisibility(8);
        this.h0.setVisibility(0);
        this.f0 = false;
    }

    @SuppressLint({"SetTextI18n"})
    public final void u0() {
        h.b.a.d.w b2 = this.d0.m().b();
        if (b2.l() == 0) {
            return;
        }
        this.g0.setVisibility(0);
        this.h0.setVisibility(8);
        h.b.a.d.v d2 = b2.a(b2.l() - 1).d();
        h.b.a.d.v d3 = b2.c().d();
        this.p0.setImageDrawable(B().getDrawable(b2.b().c()));
        this.k0.setText(b2.h() == null ? "-" : b2.h().a());
        this.i0.setText(d3.c().equals("INIVG") ? "" : d3.a());
        this.n0.setText(d3.e() != null ? d3.e().a() : "-");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        this.l0.setText(simpleDateFormat.format(b2.m()));
        this.q0.setText(this.d0.o().b().b());
        a(d2);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault());
        simpleDateFormat2.setTimeZone(TimeZone.getDefault());
        this.e0.post(new b(simpleDateFormat2));
        this.f0 = true;
    }

    @Override // android.support.v4.app.Fragment
    @SuppressLint({"SetTextI18n"})
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TextView textView;
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(2131427381, viewGroup, false);
        this.e0 = viewGroup2;
        this.g0 = (ConstraintLayout) viewGroup2.findViewById(2131230927);
        this.h0 = (ConstraintLayout) viewGroup2.findViewById(2131230926);
        this.i0 = (TextView) viewGroup2.findViewById(2131230891);
        this.k0 = (TextView) viewGroup2.findViewById(2131230942);
        this.m0 = (TextView) viewGroup2.findViewById(2131230846);
        this.j0 = (TextView) viewGroup2.findViewById(2131230845);
        this.l0 = (TextView) viewGroup2.findViewById(2131231174);
        this.n0 = (TextView) viewGroup2.findViewById(2131231175);
        this.o0 = (TextView) viewGroup2.findViewById(2131230848);
        this.p0 = (ImageView) viewGroup2.findViewById(2131230981);
        this.q0 = (TextView) viewGroup2.findViewById(2131230928);
        this.r0 = (ImageView) viewGroup2.findViewById(2131231172);
        ((TextView) viewGroup2.findViewById(2131230908)).setText(this.b0.getString(2131755259) + " " + this.b0.getString(2131755260));
        ((TextView) viewGroup2.findViewById(2131230909)).setText(this.b0.getString(2131755258) + " " + this.b0.getString(2131755260));
        if (this.d0.A()) {
            textView = (TextView) viewGroup2.findViewById(2131230906);
            u0();
        } else {
            textView = (TextView) viewGroup2.findViewById(2131230904);
            t0();
        }
        this.d0.o().b().a(null).a(this);
        this.d0.a(new a(this, textView));
        return viewGroup2;
    }

    @SuppressLint({"SetTextI18n"})
    public final void a(h.b.a.d.v vVar) {
        this.o0.setText(vVar.e().a());
        if (vVar.c().equals("INIVG")) {
            return;
        }
        this.m0.setText(vVar.a());
    }

    @Override // h.b.a.d.o.c
    public void a(h.b.a.d.o oVar, h.b.a.d.q qVar) {
        if (!this.f0) {
            u0();
        }
        a(qVar.d());
    }

    @Override // h.b.a.d.o.c
    public void a(h.b.a.d.o oVar, o.a aVar) {
        t0();
    }

    @SuppressLint({"LongLogTag"})
    public final void a(h.b.a.d.y yVar) {
        if (yVar != null) {
            try {
                byte[] decode = Base64.decode(yVar.b(), 0);
                a.b.g.c.j.c a2 = a.b.g.c.j.d.a(B(), BitmapFactory.decodeByteArray(decode, 0, decode.length));
                a2.a(50.0f);
                this.r0.setImageDrawable(a2);
                return;
            } catch (Exception e2) {
                Log.e("InspectionFragment.class", "onAsyncResultReady: profile photo could not be decoded.", e2);
                return;
            }
        }
        Log.w("InspectionFragment.class", "onAsyncResultReady: profile returned null");
    }

    @Override // h.b.a.d.b.a
    @SuppressLint({"LongLogTag"})
    public void a(h.b.a.d.b<h.b.a.d.y> bVar) {
        a(bVar.a());
        this.d0.o().a(this);
    }
}
