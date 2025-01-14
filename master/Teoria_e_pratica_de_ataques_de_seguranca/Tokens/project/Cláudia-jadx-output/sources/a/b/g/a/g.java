package a.b.g.a;

import a.a.b.c;
import a.b.g.a.a;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* compiled from: FragmentActivity.java */
/* loaded from: classes.dex */
public class g extends g0 implements a.a.b.q, a.b, a.d {

    /* renamed from: d  reason: collision with root package name */
    public a.a.b.p f672d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f673e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f674f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f676h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f677i;
    public boolean j;
    public int k;
    public a.b.g.j.o<String> m;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f670b = new a();

    /* renamed from: c  reason: collision with root package name */
    public final i f671c = i.a(new b());

    /* renamed from: g  reason: collision with root package name */
    public boolean f675g = true;

    /* compiled from: FragmentActivity.java */
    /* loaded from: classes.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 2) {
                super.handleMessage(message);
                return;
            }
            g.this.h();
            g.this.f671c.i();
        }
    }

    /* compiled from: FragmentActivity.java */
    /* loaded from: classes.dex */
    public class b extends j<g> {
        public b() {
            super(g.this);
        }

        @Override // a.b.g.a.j
        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            g.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // a.b.g.a.j
        public boolean b(Fragment fragment) {
            return !g.this.isFinishing();
        }

        @Override // a.b.g.a.j
        public LayoutInflater f() {
            return g.this.getLayoutInflater().cloneInContext(g.this);
        }

        @Override // a.b.g.a.j
        public int g() {
            Window window = g.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        @Override // a.b.g.a.j
        public boolean h() {
            return g.this.getWindow() != null;
        }

        @Override // a.b.g.a.j
        public void i() {
            g.this.j();
        }

        @Override // a.b.g.a.j
        public void a(Fragment fragment, Intent intent, int i2, Bundle bundle) {
            g.this.a(fragment, intent, i2, bundle);
        }

        @Override // a.b.g.a.j
        public void a(Fragment fragment, String[] strArr, int i2) {
            g.this.a(fragment, strArr, i2);
        }

        @Override // a.b.g.a.j
        public void a(Fragment fragment) {
            g.this.c(fragment);
        }

        @Override // a.b.g.a.h
        public View a(int i2) {
            return g.this.findViewById(i2);
        }

        @Override // a.b.g.a.h
        public boolean a() {
            Window window = g.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    /* compiled from: FragmentActivity.java */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public a.a.b.p f680a;

        /* renamed from: b  reason: collision with root package name */
        public m f681b;
    }

    public static void b(int i2) {
        if ((i2 & (-65536)) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    @Override // a.b.g.a.g0, a.a.b.e
    public a.a.b.c a() {
        return super.a();
    }

    public void c(Fragment fragment) {
    }

    @Override // a.a.b.q
    public a.a.b.p d() {
        if (getApplication() != null) {
            if (this.f672d == null) {
                c cVar = (c) getLastNonConfigurationInstance();
                if (cVar != null) {
                    this.f672d = cVar.f680a;
                }
                if (this.f672d == null) {
                    this.f672d = new a.a.b.p();
                }
            }
            return this.f672d;
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
        printWriter.print(this.f673e);
        printWriter.print(" mResumed=");
        printWriter.print(this.f674f);
        printWriter.print(" mStopped=");
        printWriter.print(this.f675g);
        if (getApplication() != null) {
            v.a(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.f671c.j().a(str, fileDescriptor, printWriter, strArr);
    }

    public k f() {
        return this.f671c.j();
    }

    public final void g() {
        do {
        } while (a(f(), c.b.CREATED));
    }

    public void h() {
        this.f671c.f();
    }

    public Object i() {
        return null;
    }

    @Deprecated
    public void j() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.f671c.k();
        int i4 = i2 >> 16;
        if (i4 != 0) {
            int i5 = i4 - 1;
            String b2 = this.m.b(i5);
            this.m.e(i5);
            if (b2 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a2 = this.f671c.a(b2);
            if (a2 == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + b2);
                return;
            }
            a2.a(i2 & 65535, i3, intent);
            return;
        }
        a.c a3 = a.b.g.a.a.a();
        if (a3 == null || !a3.a(this, i2, i3, intent)) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        k j = this.f671c.j();
        boolean d2 = j.d();
        if (!d2 || Build.VERSION.SDK_INT > 25) {
            if (d2 || !j.f()) {
                super.onBackPressed();
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f671c.k();
        this.f671c.a(configuration);
    }

    @Override // a.b.g.a.g0, android.app.Activity
    public void onCreate(Bundle bundle) {
        a.a.b.p pVar;
        this.f671c.a((Fragment) null);
        super.onCreate(bundle);
        c cVar = (c) getLastNonConfigurationInstance();
        if (cVar != null && (pVar = cVar.f680a) != null && this.f672d == null) {
            this.f672d = pVar;
        }
        if (bundle != null) {
            this.f671c.a(bundle.getParcelable("android:support:fragments"), cVar != null ? cVar.f681b : null);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.k = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray != null && stringArray != null && intArray.length == stringArray.length) {
                    this.m = new a.b.g.j.o<>(intArray.length);
                    for (int i2 = 0; i2 < intArray.length; i2++) {
                        this.m.c(intArray[i2], stringArray[i2]);
                    }
                } else {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                }
            }
        }
        if (this.m == null) {
            this.m = new a.b.g.j.o<>();
            this.k = 0;
        }
        this.f671c.b();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        if (i2 == 0) {
            return super.onCreatePanelMenu(i2, menu) | this.f671c.a(menu, getMenuInflater());
        }
        return super.onCreatePanelMenu(i2, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a2 = a(view, str, context, attributeSet);
        return a2 == null ? super.onCreateView(view, str, context, attributeSet) : a2;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f672d != null && !isChangingConfigurations()) {
            this.f672d.a();
        }
        this.f671c.c();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.f671c.d();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 != 0) {
            if (i2 != 6) {
                return false;
            }
            return this.f671c.a(menuItem);
        }
        return this.f671c.b(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.f671c.a(z);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f671c.k();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        if (i2 == 0) {
            this.f671c.a(menu);
        }
        super.onPanelClosed(i2, menu);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.f674f = false;
        if (this.f670b.hasMessages(2)) {
            this.f670b.removeMessages(2);
            h();
        }
        this.f671c.e();
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.f671c.b(z);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.f670b.removeMessages(2);
        h();
        this.f671c.i();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        if (i2 == 0 && menu != null) {
            return a(view, menu) | this.f671c.b(menu);
        }
        return super.onPreparePanel(i2, view, menu);
    }

    @Override // android.app.Activity, a.b.g.a.a.b
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.f671c.k();
        int i3 = (i2 >> 16) & 65535;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String b2 = this.m.b(i4);
            this.m.e(i4);
            if (b2 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a2 = this.f671c.a(b2);
            if (a2 == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + b2);
                return;
            }
            a2.a(i2 & 65535, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f670b.sendEmptyMessage(2);
        this.f674f = true;
        this.f671c.i();
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        Object i2 = i();
        m l = this.f671c.l();
        if (l == null && this.f672d == null && i2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.f680a = this.f672d;
        cVar.f681b = l;
        return cVar;
    }

    @Override // a.b.g.a.g0, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        g();
        Parcelable m = this.f671c.m();
        if (m != null) {
            bundle.putParcelable("android:support:fragments", m);
        }
        if (this.m.c() > 0) {
            bundle.putInt("android:support:next_request_index", this.k);
            int[] iArr = new int[this.m.c()];
            String[] strArr = new String[this.m.c()];
            for (int i2 = 0; i2 < this.m.c(); i2++) {
                iArr[i2] = this.m.d(i2);
                strArr[i2] = this.m.f(i2);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.f675g = false;
        if (!this.f673e) {
            this.f673e = true;
            this.f671c.a();
        }
        this.f671c.k();
        this.f671c.i();
        this.f671c.g();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.f671c.k();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.f675g = true;
        g();
        this.f671c.h();
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i2) {
        if (!this.j && i2 != -1) {
            b(i2);
        }
        super.startActivityForResult(intent, i2);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) {
        if (!this.f677i && i2 != -1) {
            b(i2);
        }
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
    }

    public final View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f671c.a(view, str, context, attributeSet);
    }

    public final int b(Fragment fragment) {
        if (this.m.c() < 65534) {
            while (this.m.c(this.k) >= 0) {
                this.k = (this.k + 1) % 65534;
            }
            int i2 = this.k;
            this.m.c(i2, fragment.f2253f);
            this.k = (this.k + 1) % 65534;
            return i2;
        }
        throw new IllegalStateException("Too many pending Fragment activity results.");
    }

    public boolean a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View a2 = a((View) null, str, context, attributeSet);
        return a2 == null ? super.onCreateView(str, context, attributeSet) : a2;
    }

    @Override // a.b.g.a.a.d
    public final void a(int i2) {
        if (this.f676h || i2 == -1) {
            return;
        }
        b(i2);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        if (!this.j && i2 != -1) {
            b(i2);
        }
        super.startActivityForResult(intent, i2, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        if (!this.f677i && i2 != -1) {
            b(i2);
        }
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }

    public void a(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        this.j = true;
        try {
            if (i2 == -1) {
                a.b.g.a.a.a(this, intent, -1, bundle);
                return;
            }
            b(i2);
            a.b.g.a.a.a(this, intent, ((b(fragment) + 1) << 16) + (i2 & 65535), bundle);
        } finally {
            this.j = false;
        }
    }

    public void a(Fragment fragment, String[] strArr, int i2) {
        if (i2 == -1) {
            a.b.g.a.a.a(this, strArr, i2);
            return;
        }
        b(i2);
        try {
            this.f676h = true;
            a.b.g.a.a.a(this, strArr, ((b(fragment) + 1) << 16) + (i2 & 65535));
        } finally {
            this.f676h = false;
        }
    }

    public static boolean a(k kVar, c.b bVar) {
        boolean z = false;
        for (Fragment fragment : kVar.c()) {
            if (fragment != null) {
                if (fragment.a().a().a(c.b.STARTED)) {
                    fragment.T.a(bVar);
                    z = true;
                }
                k c0 = fragment.c0();
                if (c0 != null) {
                    z |= a(c0, bVar);
                }
            }
        }
        return z;
    }
}
