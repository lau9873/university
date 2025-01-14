package h.b.a.e.d;

import android.os.Build;
import android.view.Window;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import h.b.a.e.d.s3;
import java.util.Locale;
import java.util.Objects;
import pt.card4b.backendbeacons.BackEnd;
/* compiled from: PaymentDataFragment.java */
/* loaded from: classes.dex */
public class t3 extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.b.h.a.c f7365a;

    public t3(s3.g.a aVar, a.b.h.a.c cVar) {
        this.f7365a = cVar;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        ((Window) Objects.requireNonNull(this.f7365a.getWindow())).setSoftInputMode(16);
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
