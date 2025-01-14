package p205h.p208b.p209a.p212e.p216d;

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
import com.hbb20.C1444R;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import p000a.p006b.p030g.p034c.p035j.RoundedBitmapDrawable;
import p000a.p006b.p030g.p034c.p035j.RoundedBitmapDrawableFactory;
import p205h.p208b.p209a.Anda;
import p205h.p208b.p209a.p210d.AsyncResult;
import p205h.p208b.p209a.p210d.ErrorListener;
import p205h.p208b.p209a.p210d.HceCardInfoListener;
import p205h.p208b.p209a.p210d.OngoingTrip;
import p205h.p208b.p209a.p210d.Passing;
import p205h.p208b.p209a.p210d.RemoteUserListener;
import p205h.p208b.p209a.p210d.Stop;
import p205h.p208b.p209a.p210d.Trip;
import p205h.p208b.p209a.p210d.UserProfile;
import pt.card4b.backendbeacons.BackEnd;
import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.b.a.e.d.p3 */
/* loaded from: classes.dex */
public class InspectionFragment extends AbstractHomeFragment implements OngoingTrip.InterfaceC2364c, AsyncResult.InterfaceC2279a<UserProfile>, RemoteUserListener {

    /* renamed from: d0 */
    public Anda f10135d0;

    /* renamed from: e0 */
    public ViewGroup f10136e0;

    /* renamed from: f0 */
    public boolean f10137f0;

    /* renamed from: g0 */
    public ConstraintLayout f10138g0;

    /* renamed from: h0 */
    public ConstraintLayout f10139h0;

    /* renamed from: i0 */
    public TextView f10140i0;

    /* renamed from: j0 */
    public TextView f10141j0;

    /* renamed from: k0 */
    public TextView f10142k0;

    /* renamed from: l0 */
    public TextView f10143l0;

    /* renamed from: m0 */
    public TextView f10144m0;

    /* renamed from: n0 */
    public TextView f10145n0;

    /* renamed from: o0 */
    public TextView f10146o0;

    /* renamed from: p0 */
    public ImageView f10147p0;

    /* renamed from: q0 */
    public TextView f10148q0;

    /* renamed from: r0 */
    public ImageView f10149r0;

    /* compiled from: InspectionFragment.java */
    /* renamed from: h.b.a.e.d.p3$a */
    /* loaded from: classes.dex */
    public class C2518a implements HceCardInfoListener {

        /* renamed from: a */
        public final /* synthetic */ TextView f10150a;

        public C2518a(InspectionFragment inspectionFragment, TextView textView) {
            this.f10150a = textView;
        }

        @Override // p205h.p208b.p209a.p210d.HceCardInfoListener
        /* renamed from: a */
        public void mo889a(String str) {
            this.f10150a.setText(str);
        }

        @Override // p205h.p208b.p209a.p210d.HceCardInfoListener
        /* renamed from: a */
        public void mo888a(DataModels.Error error) {
            BackEnd.addToLog(String.format("[%s] Backend.getCardInfo returned onError! Error: %s", "InspectionFragment.class", error.getMessage()));
        }
    }

    /* compiled from: InspectionFragment.java */
    /* renamed from: h.b.a.e.d.p3$b */
    /* loaded from: classes.dex */
    public class RunnableC2519b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ DateFormat f10151a;

        public RunnableC2519b(DateFormat dateFormat) {
            this.f10151a = dateFormat;
        }

        @Override // java.lang.Runnable
        public void run() {
            InspectionFragment.this.f10141j0.setText(this.f10151a.format(Calendar.getInstance().getTime()));
            InspectionFragment.this.f10136e0.postDelayed(this, 1000L);
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: U */
    public void mo897U() {
        this.f10135d0.m1435b(this);
        super.mo897U();
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo30a(OngoingTrip ongoingTrip) {
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo29a(OngoingTrip ongoingTrip, ErrorListener.C2358a c2358a) {
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo27a(OngoingTrip ongoingTrip, OngoingTrip.InterfaceC2364c.AbstractRunnableC2365a abstractRunnableC2365a) {
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: b */
    public void mo16b(OngoingTrip ongoingTrip) {
    }

    @Override // p205h.p208b.p209a.p212e.p216d.AbstractHomeFragment, android.support.p065v4.app.Fragment
    /* renamed from: c */
    public void mo728c(Bundle bundle) {
        super.mo728c(bundle);
        this.f10137f0 = false;
        this.f10135d0 = Anda.m1443b(this.f9860b0);
        this.f10135d0.m1450a(this);
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: c */
    public void mo12c(OngoingTrip ongoingTrip) {
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: d */
    public void mo10d(OngoingTrip ongoingTrip) {
        m890u0();
    }

    @Override // p205h.p208b.p209a.p210d.RemoteUserListener
    @SuppressLint({"LongLogTag"})
    public void onError(DataModels.Error error) {
        Log.w("InspectionFragment.class", String.format("tryGetRemoteUser: onError was invoked with error: %s", error.getMessageToUser()));
    }

    @Override // p205h.p208b.p209a.p210d.RemoteUserListener
    @SuppressLint({"LongLogTag"})
    public void onSuccess(DataModels.UserAccountInfo userAccountInfo) {
        Log.d("InspectionFragment.class", "tryGetRemoteUser: onSuccess was invoked");
        m895a(this.f10135d0.m1400o().mo1278b().mo1250a(userAccountInfo).mo1334a());
    }

    @Override // p205h.p208b.p209a.p212e.p216d.AbstractHomeFragment
    /* renamed from: p0 */
    public void mo892p0() {
        ViewGroup viewGroup = this.f10136e0;
        if (viewGroup == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams();
        marginLayoutParams.bottomMargin = m995r0();
        this.f10136e0.setLayoutParams(marginLayoutParams);
        m997d(-1);
        m994s0().mo898b();
    }

    /* renamed from: t0 */
    public final void m891t0() {
        this.f10138g0.setVisibility(8);
        this.f10139h0.setVisibility(0);
        this.f10137f0 = false;
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: u0 */
    public final void m890u0() {
        Trip mo1300b = this.f10135d0.m1404m().mo1300b();
        if (mo1300b.mo1253l() == 0) {
            return;
        }
        this.f10138g0.setVisibility(0);
        this.f10139h0.setVisibility(8);
        Stop mo1285d = mo1300b.mo1264a(mo1300b.mo1253l() - 1).mo1285d();
        Stop mo1285d2 = mo1300b.mo1262c().mo1285d();
        this.f10147p0.setImageDrawable(m7549B().getDrawable(mo1300b.mo1263b().mo1289c()));
        this.f10142k0.setText(mo1300b.mo1257h() == null ? "-" : mo1300b.mo1257h().mo1313a());
        this.f10140i0.setText(mo1285d2.mo1266c().equals("INIVG") ? "" : mo1285d2.mo1267a());
        this.f10145n0.setText(mo1285d2.mo1265e() != null ? mo1285d2.mo1265e().mo1331a() : "-");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        this.f10143l0.setText(simpleDateFormat.format(mo1300b.mo1252m()));
        this.f10148q0.setText(this.f10135d0.m1400o().mo1278b().mo1249b());
        m896a(mo1285d);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault());
        simpleDateFormat2.setTimeZone(TimeZone.getDefault());
        this.f10136e0.post(new RunnableC2519b(simpleDateFormat2));
        this.f10137f0 = true;
    }

    @Override // android.support.p065v4.app.Fragment
    @SuppressLint({"SetTextI18n"})
    /* renamed from: a */
    public View mo717a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TextView textView;
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(C1444R.layout.fragment_inspection, viewGroup, false);
        this.f10136e0 = viewGroup2;
        this.f10138g0 = (ConstraintLayout) viewGroup2.findViewById(C1444R.C1446id.inspectionTripModeLayout);
        this.f10139h0 = (ConstraintLayout) viewGroup2.findViewById(C1444R.C1446id.inspectionNonTripModeLayout);
        this.f10140i0 = (TextView) viewGroup2.findViewById(C1444R.C1446id.firstStation);
        this.f10142k0 = (TextView) viewGroup2.findViewById(C1444R.C1446id.line);
        this.f10144m0 = (TextView) viewGroup2.findViewById(C1444R.C1446id.currentStation);
        this.f10141j0 = (TextView) viewGroup2.findViewById(C1444R.C1446id.currentDate);
        this.f10143l0 = (TextView) viewGroup2.findViewById(C1444R.C1446id.validationTime);
        this.f10145n0 = (TextView) viewGroup2.findViewById(C1444R.C1446id.validationZone);
        this.f10146o0 = (TextView) viewGroup2.findViewById(C1444R.C1446id.currentZone);
        this.f10147p0 = (ImageView) viewGroup2.findViewById(C1444R.C1446id.operator);
        this.f10148q0 = (TextView) viewGroup2.findViewById(C1444R.C1446id.inspectionUsername);
        this.f10149r0 = (ImageView) viewGroup2.findViewById(C1444R.C1446id.userPicture);
        ((TextView) viewGroup2.findViewById(C1444R.C1446id.help)).setText(this.f9860b0.getString(C1444R.string.inspection_help_1_onTrip) + " " + this.f9860b0.getString(C1444R.string.inspection_help_2));
        ((TextView) viewGroup2.findViewById(C1444R.C1446id.hint)).setText(this.f9860b0.getString(C1444R.string.inspection_help_1) + " " + this.f9860b0.getString(C1444R.string.inspection_help_2));
        if (this.f10135d0.m1492A()) {
            textView = (TextView) viewGroup2.findViewById(C1444R.C1446id.hceCardTrip);
            m890u0();
        } else {
            textView = (TextView) viewGroup2.findViewById(C1444R.C1446id.hceCardNonTrip);
            m891t0();
        }
        this.f10135d0.m1400o().mo1278b().mo1250a(null).m1375a(this);
        this.f10135d0.m1453a(new C2518a(this, textView));
        return viewGroup2;
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: a */
    public final void m896a(Stop stop) {
        this.f10146o0.setText(stop.mo1265e().mo1331a());
        if (stop.mo1266c().equals("INIVG")) {
            return;
        }
        this.f10144m0.setText(stop.mo1267a());
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo26a(OngoingTrip ongoingTrip, Passing passing) {
        if (!this.f10137f0) {
            m890u0();
        }
        m896a(passing.mo1285d());
    }

    @Override // p205h.p208b.p209a.p210d.OngoingTrip.InterfaceC2364c
    /* renamed from: a */
    public void mo28a(OngoingTrip ongoingTrip, OngoingTrip.C2362a c2362a) {
        m891t0();
    }

    @SuppressLint({"LongLogTag"})
    /* renamed from: a */
    public final void m895a(UserProfile userProfile) {
        if (userProfile != null) {
            try {
                byte[] decode = Base64.decode(userProfile.mo1247b(), 0);
                RoundedBitmapDrawable m9841a = RoundedBitmapDrawableFactory.m9841a(m7549B(), BitmapFactory.decodeByteArray(decode, 0, decode.length));
                m9841a.m9846a(50.0f);
                this.f10149r0.setImageDrawable(m9841a);
                return;
            } catch (Exception e) {
                Log.e("InspectionFragment.class", "onAsyncResultReady: profile photo could not be decoded.", e);
                return;
            }
        }
        Log.w("InspectionFragment.class", "onAsyncResultReady: profile returned null");
    }

    @Override // p205h.p208b.p209a.p210d.AsyncResult.InterfaceC2279a
    @SuppressLint({"LongLogTag"})
    /* renamed from: a */
    public void mo723a(AsyncResult<UserProfile> asyncResult) {
        m895a(asyncResult.mo1334a());
        this.f10135d0.m1400o().mo1282a(this);
    }
}
