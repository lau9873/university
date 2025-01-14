package p000a.p006b.p049h.p050a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import p000a.p006b.p030g.p045k.KeyEventDispatcher;
import p000a.p006b.p049h.p051b.C0354a;
import p000a.p006b.p049h.p061j.ActionMode;

/* renamed from: a.b.h.a.h */
/* loaded from: classes.dex */
public class AppCompatDialog extends Dialog implements AppCompatCallback {

    /* renamed from: a */
    public AppCompatDelegate f1966a;

    /* renamed from: b */
    public final KeyEventDispatcher.InterfaceC0281a f1967b;

    /* compiled from: AppCompatDialog.java */
    /* renamed from: a.b.h.a.h$a */
    /* loaded from: classes.dex */
    public class C0343a implements KeyEventDispatcher.InterfaceC0281a {
        public C0343a() {
        }

        @Override // p000a.p006b.p030g.p045k.KeyEventDispatcher.InterfaceC0281a
        /* renamed from: a */
        public boolean mo9025a(KeyEvent keyEvent) {
            return AppCompatDialog.this.m9027a(keyEvent);
        }
    }

    public AppCompatDialog(Context context, int i) {
        super(context, m9028a(context, i));
        this.f1967b = new C0343a();
        m9032a().mo9100a((Bundle) null);
        m9032a().mo9112a();
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatCallback
    /* renamed from: a */
    public ActionMode mo9030a(ActionMode.InterfaceC0414a interfaceC0414a) {
        return null;
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatCallback
    /* renamed from: a */
    public void mo9029a(ActionMode actionMode) {
    }

    /* renamed from: a */
    public boolean m9031a(int i) {
        return m9032a().mo9089b(i);
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m9032a().mo9095a(view, layoutParams);
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatCallback
    /* renamed from: b */
    public void mo9026b(ActionMode actionMode) {
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return KeyEventDispatcher.m9569a(this.f1967b, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        return (T) m9032a().mo9111a(i);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        m9032a().mo9073e();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        m9032a().mo9076d();
        super.onCreate(bundle);
        m9032a().mo9100a(bundle);
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        m9032a().mo9064i();
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        m9032a().mo9080c(i);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        m9032a().mo9091a(charSequence);
    }

    /* renamed from: a */
    public AppCompatDelegate m9032a() {
        if (this.f1966a == null) {
            this.f1966a = AppCompatDelegate.m9115a(this, this);
        }
        return this.f1966a;
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        m9032a().mo9096a(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m9032a().mo9082b(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        m9032a().mo9091a(getContext().getString(i));
    }

    /* renamed from: a */
    public static int m9028a(Context context, int i) {
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(C0354a.dialogTheme, typedValue, true);
            return typedValue.resourceId;
        }
        return i;
    }

    /* renamed from: a */
    public boolean m9027a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
