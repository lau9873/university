package p000a.p006b.p049h.p061j.p062j;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import p000a.p006b.p049h.p050a.AlertDialog;
import p000a.p006b.p049h.p051b.C0360g;
import p000a.p006b.p049h.p061j.p062j.MenuPresenter;

/* renamed from: a.b.h.j.j.i */
/* loaded from: classes.dex */
public class MenuDialogHelper implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, MenuPresenter.InterfaceC0434a {

    /* renamed from: a */
    public MenuBuilder f2411a;

    /* renamed from: b */
    public AlertDialog f2412b;

    /* renamed from: c */
    public ListMenuPresenter f2413c;

    /* renamed from: d */
    public MenuPresenter.InterfaceC0434a f2414d;

    public MenuDialogHelper(MenuBuilder menuBuilder) {
        this.f2411a = menuBuilder;
    }

    /* renamed from: a */
    public void m8648a(IBinder iBinder) {
        MenuBuilder menuBuilder = this.f2411a;
        AlertDialog.C0325a c0325a = new AlertDialog.C0325a(menuBuilder.m8665e());
        this.f2413c = new ListMenuPresenter(c0325a.m9135b(), C0360g.abc_list_menu_item_layout);
        this.f2413c.mo8587a(this);
        this.f2411a.m8692a(this.f2413c);
        c0325a.m9141a(this.f2413c.m8705d(), this);
        View m8656i = menuBuilder.m8656i();
        if (m8656i != null) {
            c0325a.m9142a(m8656i);
        } else {
            c0325a.m9143a(menuBuilder.m8658g());
            c0325a.m9131b(menuBuilder.m8657h());
        }
        c0325a.m9144a((DialogInterface.OnKeyListener) this);
        this.f2412b = c0325a.m9148a();
        this.f2412b.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f2412b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f2412b.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2411a.m8686a((MenuItemImpl) this.f2413c.m8705d().getItem(i), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f2413c.mo6282a(this.f2411a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f2412b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f2412b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f2411a.m8680a(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f2411a.performShortcut(i, keyEvent, 0);
    }

    /* renamed from: a */
    public void m8649a() {
        AlertDialog alertDialog = this.f2412b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter.InterfaceC0434a
    /* renamed from: a */
    public void mo7079a(MenuBuilder menuBuilder, boolean z) {
        if (z || menuBuilder == this.f2411a) {
            m8649a();
        }
        MenuPresenter.InterfaceC0434a interfaceC0434a = this.f2414d;
        if (interfaceC0434a != null) {
            interfaceC0434a.mo7079a(menuBuilder, z);
        }
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter.InterfaceC0434a
    /* renamed from: a */
    public boolean mo7080a(MenuBuilder menuBuilder) {
        MenuPresenter.InterfaceC0434a interfaceC0434a = this.f2414d;
        if (interfaceC0434a != null) {
            return interfaceC0434a.mo7080a(menuBuilder);
        }
        return false;
    }
}
