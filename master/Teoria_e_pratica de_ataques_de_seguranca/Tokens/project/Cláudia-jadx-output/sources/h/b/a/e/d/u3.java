package h.b.a.e.d;

import a.b.h.a.c;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.LinearLayout;
import h.b.a.e.d.v3;
import java.util.Locale;
import pt.card4b.backendbeacons.BackEnd;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: PaymentMethodDialogFragment.java */
/* loaded from: classes.dex */
public class u3 implements BackendListeners.SelectPaymentMethodRequestListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ v3 f7372a;

    /* compiled from: PaymentMethodDialogFragment.java */
    /* loaded from: classes.dex */
    public class a extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.b.h.a.c f7373a;

        public a(u3 u3Var, a.b.h.a.c cVar) {
            this.f7373a = cVar;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            this.f7373a.getWindow().setSoftInputMode(16);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (Build.VERSION.SDK_INT >= 23) {
                BackEnd.addToLog(String.format(Locale.getDefault(), "ProfileFragment: onReceivedError was invoked from the WebView.Error code: %d. Error description: %s", Integer.valueOf(webResourceError.getErrorCode()), webResourceError.getDescription()));
            } else {
                BackEnd.addToLog("ProfileFragment: onReceivedError was invoked from the WebView.");
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return false;
        }
    }

    public u3(v3 v3Var) {
        this.f7372a = v3Var;
    }

    public /* synthetic */ void a(DialogInterface dialogInterface) {
        this.f7372a.l0.a();
        this.f7372a.m0 = null;
    }

    @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
    public void onError(DataModels.Error error) {
        h.b.a.c cVar;
        Context context;
        cVar = this.f7372a.j0;
        Locale locale = Locale.getDefault();
        context = this.f7372a.i0;
        cVar.a(String.format(locale, "%s: %s", context.getString(2131755195), error.getMessageToUser()), 0).m();
    }

    @Override // pt.card4b.backendbeacons.BackendListeners.SelectPaymentMethodRequestListener
    public void onSuccess(DataModels.PaymentAction paymentAction, DataModels.PaymentInfo paymentInfo) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        h.b.a.c cVar;
        this.f7372a.n0();
        if (paymentAction.name().equals(DataModels.PaymentAction.NO_ACTION_NEEDED.name())) {
            cVar = this.f7372a.j0;
            cVar.a(this.f7372a.a(2131755405), 0).m();
            this.f7372a.l0.f();
            return;
        }
        String procedureURL = paymentInfo.getProcedureURL();
        if (procedureURL != null) {
            context = this.f7372a.i0;
            c.a aVar = new c.a(context, 16973838);
            context2 = this.f7372a.i0;
            LinearLayout linearLayout = new LinearLayout(context2);
            linearLayout.setOrientation(1);
            context3 = this.f7372a.i0;
            EditText editText = new EditText(context3);
            context4 = this.f7372a.i0;
            WebView webView = new WebView(context4);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(procedureURL);
            v3 v3Var = this.f7372a;
            context5 = v3Var.i0;
            webView.addJavascriptInterface(new v3.b(context5), "Android");
            editText.setVisibility(8);
            editText.requestFocus();
            linearLayout.addView(webView);
            linearLayout.addView(editText);
            aVar.b(linearLayout);
            a.b.h.a.c a2 = aVar.a();
            webView.setWebViewClient(new a(this, a2));
            this.f7372a.m0 = a2;
            this.f7372a.m0.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: h.b.a.e.d.y0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    u3.this.a(dialogInterface);
                }
            });
            a2.show();
        }
    }
}
