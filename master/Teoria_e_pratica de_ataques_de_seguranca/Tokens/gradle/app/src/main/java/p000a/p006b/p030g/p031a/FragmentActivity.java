package p000a.p006b.p030g.p031a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.p065v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p000a.p001a.p005b.Lifecycle;
import p000a.p001a.p005b.ViewModelStore;
import p000a.p001a.p005b.ViewModelStoreOwner;
import p000a.p006b.p030g.p031a.ActivityCompat;
import p000a.p006b.p030g.p044j.SparseArrayCompat;

/* renamed from: a.b.g.a.g */
/* loaded from: classes.dex */
public class FragmentActivity extends ComponentActivity implements ViewModelStoreOwner, ActivityCompat.InterfaceC0132b, ActivityCompat.InterfaceC0134d {

    /* renamed from: d */
    public ViewModelStore f1109d;

    /* renamed from: e */
    public boolean f1110e;

    /* renamed from: f */
    public boolean f1111f;

    /* renamed from: h */
    public boolean f1113h;

    /* renamed from: i */
    public boolean f1114i;

    /* renamed from: j */
    public boolean f1115j;

    /* renamed from: k */
    public int f1116k;

    /* renamed from: m */
    public SparseArrayCompat<String> f1117m;

    /* renamed from: b */
    public final Handler f1107b = new HandlerC0145a();

    /* renamed from: c */
    public final FragmentController f1108c = FragmentController.m10322a(new C0146b());

    /* renamed from: g */
    public boolean f1112g = true;

    /* compiled from: FragmentActivity.java */
    /* renamed from: a.b.g.a.g$a */
    /* loaded from: classes.dex */
    public class HandlerC0145a extends Handler {
        public HandlerC0145a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 2) {
                super.handleMessage(message);
                return;
            }
            FragmentActivity.this.m10331h();
            FragmentActivity.this.f1108c.m10302i();
        }
    }

    /* compiled from: FragmentActivity.java */
    /* renamed from: a.b.g.a.g$b */
    /* loaded from: classes.dex */
    public class C0146b extends FragmentHostCallback<FragmentActivity> {
        public C0146b() {
            super(FragmentActivity.this);
        }

        @Override // p000a.p006b.p030g.p031a.FragmentHostCallback
        /* renamed from: a */
        public void mo10294a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // p000a.p006b.p030g.p031a.FragmentHostCallback
        /* renamed from: b */
        public boolean mo10292b(Fragment fragment) {
            return !FragmentActivity.this.isFinishing();
        }

        @Override // p000a.p006b.p030g.p031a.FragmentHostCallback
        /* renamed from: f */
        public LayoutInflater mo10288f() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        @Override // p000a.p006b.p030g.p031a.FragmentHostCallback
        /* renamed from: g */
        public int mo10287g() {
            Window window = FragmentActivity.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        @Override // p000a.p006b.p030g.p031a.FragmentHostCallback
        /* renamed from: h */
        public boolean mo10286h() {
            return FragmentActivity.this.getWindow() != null;
        }

        @Override // p000a.p006b.p030g.p031a.FragmentHostCallback
        /* renamed from: i */
        public void mo10285i() {
            FragmentActivity.this.mo9121j();
        }

        @Override // p000a.p006b.p030g.p031a.FragmentHostCallback
        /* renamed from: a */
        public void mo10296a(Fragment fragment, Intent intent, int i, Bundle bundle) {
            FragmentActivity.this.m10340a(fragment, intent, i, bundle);
        }

        @Override // p000a.p006b.p030g.p031a.FragmentHostCallback
        /* renamed from: a */
        public void mo10295a(Fragment fragment, String[] strArr, int i) {
            FragmentActivity.this.m10339a(fragment, strArr, i);
        }

        @Override // p000a.p006b.p030g.p031a.FragmentHostCallback
        /* renamed from: a */
        public void mo10297a(Fragment fragment) {
            FragmentActivity.this.m10334c(fragment);
        }

        @Override // p000a.p006b.p030g.p031a.FragmentContainer
        /* renamed from: a */
        public View mo7441a(int i) {
            return FragmentActivity.this.findViewById(i);
        }

        @Override // p000a.p006b.p030g.p031a.FragmentContainer
        /* renamed from: a */
        public boolean mo7442a() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    /* compiled from: FragmentActivity.java */
    /* renamed from: a.b.g.a.g$c */
    /* loaded from: classes.dex */
    public static final class C0147c {

        /* renamed from: a */
        public ViewModelStore f1120a;

        /* renamed from: b */
        public FragmentManagerNonConfig f1121b;
    }

    /* renamed from: b */
    public static void m10336b(int i) {
        if ((i & (-65536)) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    @Override // p000a.p006b.p030g.p031a.ComponentActivity, p000a.p001a.p005b.LifecycleOwner
    /* renamed from: a */
    public Lifecycle mo7439a() {
        return super.mo7439a();
    }

    /* renamed from: c */
    public void m10334c(Fragment fragment) {
    }

    @Override // p000a.p001a.p005b.ViewModelStoreOwner
    /* renamed from: d */
    public ViewModelStore mo7491d() {
        if (getApplication() != null) {
            if (this.f1109d == null) {
                C0147c c0147c = (C0147c) getLastNonConfigurationInstance();
                if (c0147c != null) {
                    this.f1109d = c0147c.f1120a;
                }
                if (this.f1109d == null) {
                    this.f1109d = new ViewModelStore();
                }
            }
            return this.f1109d;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f1110e);
        printWriter.print(" mResumed=");
        printWriter.print(this.f1111f);
        printWriter.print(" mStopped=");
        printWriter.print(this.f1112g);
        if (getApplication() != null) {
            LoaderManager.m10076a(this).mo7435a(str2, fileDescriptor, printWriter, strArr);
        }
        this.f1108c.m10301j().mo10229a(str, fileDescriptor, printWriter, strArr);
    }

    /* renamed from: f */
    public FragmentManager m10333f() {
        return this.f1108c.m10301j();
    }

    /* renamed from: g */
    public final void m10332g() {
        do {
        } while (m10341a(m10333f(), Lifecycle.EnumC0012b.CREATED));
    }

    /* renamed from: h */
    public void m10331h() {
        this.f1108c.m10305f();
    }

    /* renamed from: i */
    public Object m10330i() {
        return null;
    }

    @Deprecated
    /* renamed from: j */
    public void mo9121j() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.f1108c.m10300k();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String m9602b = this.f1117m.m9602b(i4);
            this.f1117m.m9596e(i4);
            if (m9602b == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment m10314a = this.f1108c.m10314a(m9602b);
            if (m10314a == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + m9602b);
                return;
            }
            m10314a.mo1127a(i & 65535, i2, intent);
            return;
        }
        ActivityCompat.InterfaceC0133c m10417a = ActivityCompat.m10417a();
        if (m10417a == null || !m10417a.m10412a(this, i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        FragmentManager m10301j = this.f1108c.m10301j();
        boolean mo10199d = m10301j.mo10199d();
        if (!mo10199d || Build.VERSION.SDK_INT > 25) {
            if (mo10199d || !m10301j.mo10190f()) {
                super.onBackPressed();
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1108c.m10300k();
        this.f1108c.m10321a(configuration);
    }

    @Override // p000a.p006b.p030g.p031a.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ViewModelStore viewModelStore;
        this.f1108c.m10319a((Fragment) null);
        super.onCreate(bundle);
        C0147c c0147c = (C0147c) getLastNonConfigurationInstance();
        if (c0147c != null && (viewModelStore = c0147c.f1120a) != null && this.f1109d == null) {
            this.f1109d = viewModelStore;
        }
        if (bundle != null) {
            this.f1108c.m10320a(bundle.getParcelable("android:support:fragments"), c0147c != null ? c0147c.f1121b : null);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.f1116k = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray != null && stringArray != null && intArray.length == stringArray.length) {
                    this.f1117m = new SparseArrayCompat<>(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.f1117m.m9598c(intArray[i], stringArray[i]);
                    }
                } else {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                }
            }
        }
        if (this.f1117m == null) {
            this.f1117m = new SparseArrayCompat<>();
            this.f1116k = 0;
        }
        this.f1108c.m10312b();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i == 0) {
            return super.onCreatePanelMenu(i, menu) | this.f1108c.m10317a(menu, getMenuInflater());
        }
        return super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View m10337a = m10337a(view, str, context, attributeSet);
        return m10337a == null ? super.onCreateView(view, str, context, attributeSet) : m10337a;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f1109d != null && !isChangingConfigurations()) {
            this.f1109d.m11262a();
        }
        this.f1108c.m10308c();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.f1108c.m10307d();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i != 0) {
            if (i != 6) {
                return false;
            }
            return this.f1108c.m10316a(menuItem);
        }
        return this.f1108c.m10310b(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.f1108c.m10313a(z);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f1108c.m10300k();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.f1108c.m10318a(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.f1111f = false;
        if (this.f1107b.hasMessages(2)) {
            this.f1107b.removeMessages(2);
            m10331h();
        }
        this.f1108c.m10306e();
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.f1108c.m10309b(z);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.f1107b.removeMessages(2);
        m10331h();
        this.f1108c.m10302i();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i == 0 && menu != null) {
            return m10338a(view, menu) | this.f1108c.m10311b(menu);
        }
        return super.onPreparePanel(i, view, menu);
    }

    @Override // android.app.Activity, p000a.p006b.p030g.p031a.ActivityCompat.InterfaceC0132b
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.f1108c.m10300k();
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String m9602b = this.f1117m.m9602b(i3);
            this.f1117m.m9596e(i3);
            if (m9602b == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment m10314a = this.f1108c.m10314a(m9602b);
            if (m10314a == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + m9602b);
                return;
            }
            m10314a.mo872a(i & 65535, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f1107b.sendEmptyMessage(2);
        this.f1111f = true;
        this.f1108c.m10302i();
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        Object m10330i = m10330i();
        FragmentManagerNonConfig m10299l = this.f1108c.m10299l();
        if (m10299l == null && this.f1109d == null && m10330i == null) {
            return null;
        }
        C0147c c0147c = new C0147c();
        c0147c.f1120a = this.f1109d;
        c0147c.f1121b = m10299l;
        return c0147c;
    }

    @Override // p000a.p006b.p030g.p031a.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        m10332g();
        Parcelable m10298m = this.f1108c.m10298m();
        if (m10298m != null) {
            bundle.putParcelable("android:support:fragments", m10298m);
        }
        if (this.f1117m.m9600c() > 0) {
            bundle.putInt("android:support:next_request_index", this.f1116k);
            int[] iArr = new int[this.f1117m.m9600c()];
            String[] strArr = new String[this.f1117m.m9600c()];
            for (int i = 0; i < this.f1117m.m9600c(); i++) {
                iArr[i] = this.f1117m.m9597d(i);
                strArr[i] = this.f1117m.m9595f(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.f1112g = false;
        if (!this.f1110e) {
            this.f1110e = true;
            this.f1108c.m10323a();
        }
        this.f1108c.m10300k();
        this.f1108c.m10302i();
        this.f1108c.m10304g();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.f1108c.m10300k();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.f1112g = true;
        m10332g();
        this.f1108c.m10303h();
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        if (!this.f1115j && i != -1) {
            m10336b(i);
        }
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        if (!this.f1114i && i != -1) {
            m10336b(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    /* renamed from: a */
    public final View m10337a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f1108c.m10315a(view, str, context, attributeSet);
    }

    /* renamed from: b */
    public final int m10335b(Fragment fragment) {
        if (this.f1117m.m9600c() < 65534) {
            while (this.f1117m.m9599c(this.f1116k) >= 0) {
                this.f1116k = (this.f1116k + 1) % 65534;
            }
            int i = this.f1116k;
            this.f1117m.m9598c(i, fragment.f3492f);
            this.f1116k = (this.f1116k + 1) % 65534;
            return i;
        }
        throw new IllegalStateException("Too many pending Fragment activity results.");
    }

    /* renamed from: a */
    public boolean m10338a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View m10337a = m10337a((View) null, str, context, attributeSet);
        return m10337a == null ? super.onCreateView(str, context, attributeSet) : m10337a;
    }

    @Override // p000a.p006b.p030g.p031a.ActivityCompat.InterfaceC0134d
    /* renamed from: a */
    public final void mo10342a(int i) {
        if (this.f1113h || i == -1) {
            return;
        }
        m10336b(i);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (!this.f1115j && i != -1) {
            m10336b(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (!this.f1114i && i != -1) {
            m10336b(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    /* renamed from: a */
    public void m10340a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        this.f1115j = true;
        try {
            if (i == -1) {
                ActivityCompat.m10415a(this, intent, -1, bundle);
                return;
            }
            m10336b(i);
            ActivityCompat.m10415a(this, intent, ((m10335b(fragment) + 1) << 16) + (i & 65535), bundle);
        } finally {
            this.f1115j = false;
        }
    }

    /* renamed from: a */
    public void m10339a(Fragment fragment, String[] strArr, int i) {
        if (i == -1) {
            ActivityCompat.m10413a(this, strArr, i);
            return;
        }
        m10336b(i);
        try {
            this.f1113h = true;
            ActivityCompat.m10413a(this, strArr, ((m10335b(fragment) + 1) << 16) + (i & 65535));
        } finally {
            this.f1113h = false;
        }
    }

    /* renamed from: a */
    public static boolean m10341a(FragmentManager fragmentManager, Lifecycle.EnumC0012b enumC0012b) {
        boolean z = false;
        for (Fragment fragment : fragmentManager.mo10206c()) {
            if (fragment != null) {
                if (fragment.mo7439a().mo11298a().m11299a(Lifecycle.EnumC0012b.STARTED)) {
                    fragment.f3483T.m11296a(enumC0012b);
                    z = true;
                }
                FragmentManager m7492c0 = fragment.m7492c0();
                if (m7492c0 != null) {
                    z |= m10341a(m7492c0, enumC0012b);
                }
            }
        }
        return z;
    }
}
