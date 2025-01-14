package p205h.p208b.p209a.p212e.p216d;

import android.os.Build;
import android.view.Window;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Locale;
import java.util.Objects;
import p000a.p006b.p049h.p050a.AlertDialog;
import p205h.p208b.p209a.p212e.p216d.PaymentDataFragment;
import pt.card4b.backendbeacons.BackEnd;

/* compiled from: PaymentDataFragment.java */
/* renamed from: h.b.a.e.d.t3 */
/* loaded from: classes.dex */
public class C2557t3 extends WebViewClient {

    /* renamed from: a */
    public final /* synthetic */ AlertDialog f10272a;

    public C2557t3(PaymentDataFragment.View$OnClickListenerC2543g.C2544a c2544a, AlertDialog alertDialog) {
        this.f10272a = alertDialog;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        ((Window) Objects.requireNonNull(this.f10272a.getWindow())).setSoftInputMode(16);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (Build.VERSION.SDK_INT >= 23) {
            BackEnd.addToLog(String.format(Locale.getDefault(), "PaymentDataFragment: onReceivedError was invoked from the WebView.Error code: %d. Error description: %s", Integer.valueOf(webResourceError.getErrorCode()), webResourceError.getDescription()));
        } else {
            BackEnd.addToLog("PaymentDataFragment: onReceivedError was invoked from the WebView.");
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return false;
    }
}
