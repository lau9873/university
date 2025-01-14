package a.b.h.j.j;

import a.b.h.a.c;
import a.b.h.j.j.p;
import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
/* compiled from: MenuDialogHelper.java */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, p.a {

    /* renamed from: a  reason: collision with root package name */
    public h f1590a;

    /* renamed from: b  reason: collision with root package name */
    public a.b.h.a.c f1591b;

    /* renamed from: c  reason: collision with root package name */
    public f f1592c;

    /* renamed from: d  reason: collision with root package name */
    public p.a f1593d;

    public i(h hVar) {
        this.f1590a = hVar;
    }

    public void a(IBinder iBinder) {
        h hVar = this.f1590a;
        c.a aVar = new c.a(hVar.e());
        this.f1592c = new f(aVar.b(), a.b.h.b.g.abc_list_menu_item_layout);
        this.f1592c.a(this);
        this.f1590a.a(this.f1592c);
        aVar.a(this.f1592c.d(), this);
        View i2 = hVar.i();
        if (i2 != null) {
            aVar.a(i2);
        } else {
            aVar.a(hVar.g());
            aVar.b(hVar.h());
        }
        aVar.a((DialogInterface.OnKeyListener) this);
        this.f1591b = aVar.a();
        this.f1591b.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f1591b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f1591b.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        this.f1590a.a((k) this.f1592c.d().getItem(i2), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f1592c.a(this.f1590a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i2 == 82 || i2 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f1591b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f1591b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f1590a.a(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f1590a.performShortcut(i2, keyEvent, 0);
    }

    public void a() {
        a.b.h.a.c cVar = this.f1591b;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    @Override // a.b.h.j.j.p.a
    public void a(h hVar, boolean z) {
        if (z || hVar == this.f1590a) {
            a();
        }
        p.a aVar = this.f1593d;
        if (aVar != null) {
            aVar.a(hVar, z);
        }
    }

    @Override // a.b.h.j.j.p.a
    public boolean a(h hVar) {
        p.a aVar = this.f1593d;
        if (aVar != null) {
            return aVar.a(hVar);
        }
        return false;
    }
}
