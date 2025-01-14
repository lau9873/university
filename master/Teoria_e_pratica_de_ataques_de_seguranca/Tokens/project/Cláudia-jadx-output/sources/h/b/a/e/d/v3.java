package h.b.a.e.d;

import a.b.h.a.c;
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
import h.b.a.d.y;
import h.b.a.e.d.v3;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import pt.card4b.backendbeacons.BackEnd;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: PaymentMethodDialogFragment.java */
/* loaded from: classes.dex */
public class v3 extends a.b.g.a.f {
    public static final HashMap<String, Bitmap> n0 = new HashMap<>(2);
    public Context i0;
    public h.b.a.c j0;
    public final HashMap<String, a> k0 = new HashMap<>(2);
    public h.b.a.d.r l0;
    public a.b.h.a.c m0;

    /* compiled from: PaymentMethodDialogFragment.java */
    /* loaded from: classes.dex */
    public class b {
        public b(Context context) {
        }

        @JavascriptInterface
        public void closeWebView() {
            if (v3.this.m0 != null) {
                v3.this.m0.dismiss();
            }
        }
    }

    @Override // a.b.g.a.f, android.support.v4.app.Fragment
    public void X() {
        super.X();
    }

    @Override // a.b.g.a.f
    @SuppressLint({"SetJavaScriptEnabled", "SetTextI18n"})
    public Dialog n(Bundle bundle) {
        boolean z;
        y.b j;
        c.a aVar = new c.a(this.i0);
        LinearLayout linearLayout = new LinearLayout(this.i0);
        linearLayout.setOrientation(1);
        String c2 = (!this.l0.e() || (j = this.l0.b().j()) == null) ? "" : j.c();
        int i2 = 0;
        for (final DataModels.PaymentMethod paymentMethod : this.l0.c()) {
            View inflate = View.inflate(this.i0, 2131427407, null);
            ImageView imageView = (ImageView) inflate.findViewById(2131230831);
            ImageView imageView2 = (ImageView) inflate.findViewById(2131230952);
            TextView textView = (TextView) inflate.findViewById(2131230963);
            String thumbnailURL = paymentMethod.getThumbnailURL();
            if (n0.containsKey(thumbnailURL)) {
                if (this.k0.get(thumbnailURL) != null ? this.k0.get(thumbnailURL).a(i2, thumbnailURL, imageView2) : true) {
                    imageView2.setImageBitmap(n0.get(thumbnailURL));
                }
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (this.k0.get(thumbnailURL) != null ? this.k0.get(thumbnailURL).a(i2, thumbnailURL, imageView2) : true) {
                    a aVar2 = new a(i2, thumbnailURL, imageView2);
                    this.k0.put(thumbnailURL, aVar2);
                    h.b.a.c.X().a(aVar2);
                }
            }
            if (this.l0.e() && c2.equals(paymentMethod.getCode())) {
                imageView.setImageDrawable(a.b.g.b.b.c(this.i0, 2131165567));
            }
            textView.setText(paymentMethod.getName());
            inflate.setOnClickListener(new View.OnClickListener() { // from class: h.b.a.e.d.a1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v3.this.a(paymentMethod, view);
                }
            });
            i2++;
            if (i2 == 1) {
                linearLayout.setPadding(0, inflate.getPaddingTop() * 2, 0, 0);
            }
            linearLayout.addView(inflate);
        }
        aVar.b(linearLayout);
        aVar.b(2131755401);
        aVar.a(17039360, (DialogInterface.OnClickListener) null);
        return aVar.a();
    }

    @Override // a.b.g.a.f, android.support.v4.app.Fragment
    public void c(Bundle bundle) {
        super.c(bundle);
        this.j0 = h.b.a.c.b(this.i0);
    }

    /* compiled from: PaymentMethodDialogFragment.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final int f7379a;

        /* renamed from: b  reason: collision with root package name */
        public final String f7380b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f7381c;

        public a(int i2, String str, ImageView imageView) {
            this.f7379a = i2;
            this.f7380b = str;
            this.f7381c = imageView;
        }

        public void a() {
        }

        public boolean a(int i2, String str, ImageView imageView) {
            if (this.f7379a == i2 && str.equals(this.f7380b)) {
                this.f7381c = imageView;
                return false;
            }
            a();
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                final Bitmap decodeStream = BitmapFactory.decodeStream(new URL(this.f7380b).openConnection().getInputStream());
                v3.this.l0.d().post(new Runnable() { // from class: h.b.a.e.d.z0
                    @Override // java.lang.Runnable
                    public final void run() {
                        v3.a.this.a(decodeStream);
                    }
                });
            } catch (IOException unused) {
            }
        }

        public /* synthetic */ void a(Bitmap bitmap) {
            v3.n0.put(this.f7380b, bitmap);
            this.f7381c.setImageBitmap(bitmap);
            v3.this.k0.remove(this.f7380b);
        }
    }

    public void a(h.b.a.d.r rVar) {
        this.l0 = rVar;
    }

    @Override // a.b.g.a.f, android.support.v4.app.Fragment
    public void a(Context context) {
        super.a(context);
        this.i0 = context;
    }

    public /* synthetic */ void a(DataModels.PaymentMethod paymentMethod, View view) {
        BackEnd.selectPaymentMethod(paymentMethod, new u3(this));
    }
}
