package p205h.p208b.p209a.p212e.p216d;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbb20.C1444R;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import p000a.p006b.p030g.p031a.DialogFragment;
import p000a.p006b.p030g.p032b.ContextCompat;
import p000a.p006b.p049h.p050a.AlertDialog;
import p205h.p208b.p209a.Anda;
import p205h.p208b.p209a.p210d.PaymentMethodsListener;
import p205h.p208b.p209a.p210d.UserProfile;
import p205h.p208b.p209a.p212e.p216d.C2567v3;
import pt.card4b.backendbeacons.BackEnd;
import pt.card4b.backendbeacons.DataModels;

/* compiled from: PaymentMethodDialogFragment.java */
/* renamed from: h.b.a.e.d.v3 */
/* loaded from: classes.dex */
public class C2567v3 extends DialogFragment {

    /* renamed from: n0 */
    public static final HashMap<String, Bitmap> f10286n0 = new HashMap<>(2);

    /* renamed from: i0 */
    public Context f10287i0;

    /* renamed from: j0 */
    public Anda f10288j0;

    /* renamed from: k0 */
    public final HashMap<String, RunnableC2568a> f10289k0 = new HashMap<>(2);

    /* renamed from: l0 */
    public PaymentMethodsListener f10290l0;

    /* renamed from: m0 */
    public AlertDialog f10291m0;

    /* compiled from: PaymentMethodDialogFragment.java */
    /* renamed from: h.b.a.e.d.v3$b */
    /* loaded from: classes.dex */
    public class C2569b {
        public C2569b(Context context) {
        }

        @JavascriptInterface
        public void closeWebView() {
            if (C2567v3.this.f10291m0 != null) {
                C2567v3.this.f10291m0.dismiss();
            }
        }
    }

    @Override // p000a.p006b.p030g.p031a.DialogFragment, android.support.p065v4.app.Fragment
    /* renamed from: X */
    public void mo779X() {
        super.mo779X();
    }

    @Override // p000a.p006b.p030g.p031a.DialogFragment
    @SuppressLint({"SetJavaScriptEnabled", "SetTextI18n"})
    /* renamed from: n */
    public Dialog mo769n(Bundle bundle) {
        boolean z;
        UserProfile.InterfaceC2373b mo1239j;
        AlertDialog.C0325a c0325a = new AlertDialog.C0325a(this.f10287i0);
        LinearLayout linearLayout = new LinearLayout(this.f10287i0);
        linearLayout.setOrientation(1);
        String mo1222c = (!this.f10290l0.mo806e() || (mo1239j = this.f10290l0.mo809b().mo1239j()) == null) ? "" : mo1239j.mo1222c();
        int i = 0;
        for (final DataModels.PaymentMethod paymentMethod : this.f10290l0.mo808c()) {
            View inflate = View.inflate(this.f10287i0, C1444R.layout.item_paymentmethod, null);
            ImageView imageView = (ImageView) inflate.findViewById(C1444R.C1446id.check);
            ImageView imageView2 = (ImageView) inflate.findViewById(C1444R.C1446id.logo);
            TextView textView = (TextView) inflate.findViewById(C1444R.C1446id.methodName);
            String thumbnailURL = paymentMethod.getThumbnailURL();
            if (f10286n0.containsKey(thumbnailURL)) {
                if (this.f10289k0.get(thumbnailURL) != null ? this.f10289k0.get(thumbnailURL).m766a(i, thumbnailURL, imageView2) : true) {
                    imageView2.setImageBitmap(f10286n0.get(thumbnailURL));
                }
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (this.f10289k0.get(thumbnailURL) != null ? this.f10289k0.get(thumbnailURL).m766a(i, thumbnailURL, imageView2) : true) {
                    RunnableC2568a runnableC2568a = new RunnableC2568a(i, thumbnailURL, imageView2);
                    this.f10289k0.put(thumbnailURL, runnableC2568a);
                    Anda.m1467X().m1449a(runnableC2568a);
                }
            }
            if (this.f10290l0.mo806e() && mo1222c.equals(paymentMethod.getCode())) {
                imageView.setImageDrawable(ContextCompat.m10016c(this.f10287i0, C1444R.C1445drawable.ic_check_black_24dp));
            }
            textView.setText(paymentMethod.getName());
            inflate.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.a1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C2567v3.this.m774a(paymentMethod, view);
                }
            });
            i++;
            if (i == 1) {
                linearLayout.setPadding(0, inflate.getPaddingTop() * 2, 0, 0);
            }
            linearLayout.addView(inflate);
        }
        c0325a.m9132b(linearLayout);
        c0325a.m9134b(C1444R.string.user_paymentMethods);
        c0325a.m9146a(17039360, (DialogInterface.OnClickListener) null);
        return c0325a.m9148a();
    }

    @Override // p000a.p006b.p030g.p031a.DialogFragment, android.support.p065v4.app.Fragment
    /* renamed from: c */
    public void mo728c(Bundle bundle) {
        super.mo728c(bundle);
        this.f10288j0 = Anda.m1443b(this.f10287i0);
    }

    /* compiled from: PaymentMethodDialogFragment.java */
    /* renamed from: h.b.a.e.d.v3$a */
    /* loaded from: classes.dex */
    public class RunnableC2568a implements Runnable {

        /* renamed from: a */
        public final int f10292a;

        /* renamed from: b */
        public final String f10293b;

        /* renamed from: c */
        public ImageView f10294c;

        public RunnableC2568a(int i, String str, ImageView imageView) {
            this.f10292a = i;
            this.f10293b = str;
            this.f10294c = imageView;
        }

        /* renamed from: a */
        public void m767a() {
        }

        /* renamed from: a */
        public boolean m766a(int i, String str, ImageView imageView) {
            if (this.f10292a == i && str.equals(this.f10293b)) {
                this.f10294c = imageView;
                return false;
            }
            m767a();
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                final Bitmap decodeStream = BitmapFactory.decodeStream(new URL(this.f10293b).openConnection().getInputStream());
                C2567v3.this.f10290l0.mo807d().post(new Runnable() { // from class: h.b.a.e.d.z0
                    @Override // java.lang.Runnable
                    public final void run() {
                        C2567v3.RunnableC2568a.this.m765a(decodeStream);
                    }
                });
            } catch (IOException unused) {
            }
        }

        /* renamed from: a */
        public /* synthetic */ void m765a(Bitmap bitmap) {
            C2567v3.f10286n0.put(this.f10293b, bitmap);
            this.f10294c.setImageBitmap(bitmap);
            C2567v3.this.f10289k0.remove(this.f10293b);
        }
    }

    /* renamed from: a */
    public void m777a(PaymentMethodsListener paymentMethodsListener) {
        this.f10290l0 = paymentMethodsListener;
    }

    @Override // p000a.p006b.p030g.p031a.DialogFragment, android.support.p065v4.app.Fragment
    /* renamed from: a */
    public void mo778a(Context context) {
        super.mo778a(context);
        this.f10287i0 = context;
    }

    /* renamed from: a */
    public /* synthetic */ void m774a(DataModels.PaymentMethod paymentMethod, View view) {
        BackEnd.selectPaymentMethod(paymentMethod, new PaymentMethodDialogFragment(this));
    }
}
