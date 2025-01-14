package a.b.h.a;

import a.b.g.k.e;
import a.b.h.j.b;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: AppCompatDialog.java */
/* loaded from: classes.dex */
public class h extends Dialog implements e {

    /* renamed from: a  reason: collision with root package name */
    public f f1314a;

    /* renamed from: b  reason: collision with root package name */
    public final e.a f1315b;

    /* compiled from: AppCompatDialog.java */
    /* loaded from: classes.dex */
    public class a implements e.a {
        public a() {
        }

        @Override // a.b.g.k.e.a
        public boolean a(KeyEvent keyEvent) {
            return h.this.a(keyEvent);
        }
    }

    public h(Context context, int i2) {
        super(context, a(context, i2));
        this.f1315b = new a();
        a().a((Bundle) null);
        a().a();
    }

    @Override // a.b.h.a.e
    public a.b.h.j.b a(b.a aVar) {
        return null;
    }

    @Override // a.b.h.a.e
    public void a(a.b.h.j.b bVar) {
    }

    public boolean a(int i2) {
        return a().b(i2);
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().a(view, layoutParams);
    }

    @Override // a.b.h.a.e
    public void b(a.b.h.j.b bVar) {
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return a.b.g.k.e.a(this.f1315b, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i2) {
        return (T) a().a(i2);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        a().e();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        a().d();
        super.onCreate(bundle);
        a().a(bundle);
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        a().i();
    }

    @Override // android.app.Dialog
    public void setContentView(int i2) {
        a().c(i2);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().a(charSequence);
    }

    public f a() {
        if (this.f1314a == null) {
            this.f1314a = f.a(this, this);
        }
        return this.f1314a;
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        a().a(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().b(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i2) {
        super.setTitle(i2);
        a().a(getContext().getString(i2));
    }

    public static int a(Context context, int i2) {
        if (i2 == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(a.b.h.b.a.dialogTheme, typedValue, true);
            return typedValue.resourceId;
        }
        return i2;
    }

    public boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
