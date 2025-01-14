package p205h.p208b.p209a.p212e.p216d;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.hbb20.C1444R;
import java.util.Locale;
import p000a.p006b.p049h.p050a.AlertDialog;
import p205h.p208b.p209a.Anda;
import p205h.p208b.p209a.p212e.p216d.C2567v3;
import pt.card4b.backendbeacons.BackEnd;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.b.a.e.d.u3 */
/* loaded from: classes.dex */
public class PaymentMethodDialogFragment implements BackendListeners.SelectPaymentMethodRequestListener {

    /* renamed from: a */
    public final /* synthetic */ C2567v3 f10279a;

    /* compiled from: PaymentMethodDialogFragment.java */
    /* renamed from: h.b.a.e.d.u3$a */
    /* loaded from: classes.dex */
    public class C2562a extends WebViewClient {

        /* renamed from: a */
        public final /* synthetic */ AlertDialog f10280a;

        public C2562a(PaymentMethodDialogFragment paymentMethodDialogFragment, AlertDialog alertDialog) {
            this.f10280a = alertDialog;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            this.f10280a.getWindow().setSoftInputMode(16);
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

    public PaymentMethodDialogFragment(C2567v3 c2567v3) {
        this.f10279a = c2567v3;
    }

    /* renamed from: a */
    public /* synthetic */ void m780a(DialogInterface dialogInterface) {
        this.f10279a.f10290l0.mo810a();
        this.f10279a.f10291m0 = null;
    }

    @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
    public void onError(DataModels.Error error) {
        Anda anda;
        Context context;
        anda = this.f10279a.f10288j0;
        Locale locale = Locale.getDefault();
        context = this.f10279a.f10287i0;
        anda.m1447a(String.format(locale, "%s: %s", context.getString(C1444R.string.error), error.getMessageToUser()), 0).mo7619m();
    }

    @Override // pt.card4b.backendbeacons.BackendListeners.SelectPaymentMethodRequestListener
    public void onSuccess(DataModels.PaymentAction paymentAction, DataModels.PaymentInfo paymentInfo) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Anda anda;
        this.f10279a.m10343n0();
        if (paymentAction.name().equals(DataModels.PaymentAction.NO_ACTION_NEEDED.name())) {
            anda = this.f10279a.f10288j0;
            anda.m1447a(this.f10279a.m7528a(C1444R.string.user_paymentdata_updated_success), 0).mo7619m();
            this.f10279a.f10290l0.mo805f();
            return;
        }
        String procedureURL = paymentInfo.getProcedureURL();
        if (procedureURL != null) {
            context = this.f10279a.f10287i0;
            AlertDialog.C0325a c0325a = new AlertDialog.C0325a(context, 16973838);
            context2 = this.f10279a.f10287i0;
            LinearLayout linearLayout = new LinearLayout(context2);
            linearLayout.setOrientation(1);
            context3 = this.f10279a.f10287i0;
            EditText editText = new EditText(context3);
            context4 = this.f10279a.f10287i0;
            WebView webView = new WebView(context4);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(procedureURL);
            C2567v3 c2567v3 = this.f10279a;
            context5 = c2567v3.f10287i0;
            webView.addJavascriptInterface(new C2567v3.C2569b(context5), "Android");
            editText.setVisibility(8);
            editText.requestFocus();
            linearLayout.addView(webView);
            linearLayout.addView(editText);
            c0325a.m9132b(linearLayout);
            AlertDialog m9148a = c0325a.m9148a();
            webView.setWebViewClient(new C2562a(this, m9148a));
            this.f10279a.f10291m0 = m9148a;
            this.f10279a.f10291m0.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: h.b.a.e.d.y0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    PaymentMethodDialogFragment.this.m780a(dialogInterface);
                }
            });
            m9148a.show();
        }
    }
}
