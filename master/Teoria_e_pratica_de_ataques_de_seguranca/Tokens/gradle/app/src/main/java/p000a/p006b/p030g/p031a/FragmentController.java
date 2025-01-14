package p000a.p006b.p030g.p031a;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.p065v4.app.Fragment;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* renamed from: a.b.g.a.i */
/* loaded from: classes.dex */
public class FragmentController {

    /* renamed from: a */
    public final FragmentHostCallback<?> f1125a;

    public FragmentController(FragmentHostCallback<?> fragmentHostCallback) {
        this.f1125a = fragmentHostCallback;
    }

    /* renamed from: a */
    public static FragmentController m10322a(FragmentHostCallback<?> fragmentHostCallback) {
        return new FragmentController(fragmentHostCallback);
    }

    /* renamed from: b */
    public void m10312b() {
        this.f1125a.f1129d.m10177k();
    }

    /* renamed from: c */
    public void m10308c() {
        this.f1125a.f1129d.m10175l();
    }

    /* renamed from: d */
    public void m10307d() {
        this.f1125a.f1129d.m10171n();
    }

    /* renamed from: e */
    public void m10306e() {
        this.f1125a.f1129d.m10169o();
    }

    /* renamed from: f */
    public void m10305f() {
        this.f1125a.f1129d.m10167p();
    }

    /* renamed from: g */
    public void m10304g() {
        this.f1125a.f1129d.m10165q();
    }

    /* renamed from: h */
    public void m10303h() {
        this.f1125a.f1129d.m10163r();
    }

    /* renamed from: i */
    public boolean m10302i() {
        return this.f1125a.f1129d.m10160u();
    }

    /* renamed from: j */
    public FragmentManager m10301j() {
        return this.f1125a.m10290d();
    }

    /* renamed from: k */
    public void m10300k() {
        this.f1125a.f1129d.m10156y();
    }

    /* renamed from: l */
    public FragmentManagerNonConfig m10299l() {
        return this.f1125a.f1129d.m10269A();
    }

    /* renamed from: m */
    public Parcelable m10298m() {
        return this.f1125a.f1129d.m10268B();
    }

    /* renamed from: a */
    public Fragment m10314a(String str) {
        return this.f1125a.f1129d.m10210b(str);
    }

    /* renamed from: b */
    public void m10309b(boolean z) {
        this.f1125a.f1129d.m10207b(z);
    }

    /* renamed from: a */
    public void m10319a(Fragment fragment) {
        FragmentHostCallback<?> fragmentHostCallback = this.f1125a;
        fragmentHostCallback.f1129d.m10257a(fragmentHostCallback, fragmentHostCallback, fragment);
    }

    /* renamed from: b */
    public boolean m10311b(Menu menu) {
        return this.f1125a.f1129d.m10213b(menu);
    }

    /* renamed from: a */
    public View m10315a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f1125a.f1129d.onCreateView(view, str, context, attributeSet);
    }

    /* renamed from: b */
    public boolean m10310b(MenuItem menuItem) {
        return this.f1125a.f1129d.m10212b(menuItem);
    }

    /* renamed from: a */
    public void m10320a(Parcelable parcelable, FragmentManagerNonConfig fragmentManagerNonConfig) {
        this.f1125a.f1129d.m10246a(parcelable, fragmentManagerNonConfig);
    }

    /* renamed from: a */
    public void m10323a() {
        this.f1125a.f1129d.m10179j();
    }

    /* renamed from: a */
    public void m10313a(boolean z) {
        this.f1125a.f1129d.m10224a(z);
    }

    /* renamed from: a */
    public void m10321a(Configuration configuration) {
        this.f1125a.f1129d.m10249a(configuration);
    }

    /* renamed from: a */
    public boolean m10317a(Menu menu, MenuInflater menuInflater) {
        return this.f1125a.f1129d.m10236a(menu, menuInflater);
    }

    /* renamed from: a */
    public boolean m10316a(MenuItem menuItem) {
        return this.f1125a.f1129d.m10235a(menuItem);
    }

    /* renamed from: a */
    public void m10318a(Menu menu) {
        this.f1125a.f1129d.m10237a(menu);
    }
}
