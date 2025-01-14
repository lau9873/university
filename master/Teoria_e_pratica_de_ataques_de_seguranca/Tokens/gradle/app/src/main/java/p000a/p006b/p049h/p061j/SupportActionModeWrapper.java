package p000a.p006b.p049h.p061j;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;
import p000a.p006b.p030g.p036d.p037a.SupportMenu;
import p000a.p006b.p030g.p036d.p037a.SupportMenuItem;
import p000a.p006b.p030g.p044j.SimpleArrayMap;
import p000a.p006b.p049h.p061j.ActionMode;
import p000a.p006b.p049h.p061j.p062j.MenuWrapperFactory;

/* renamed from: a.b.h.j.f */
/* loaded from: classes.dex */
public class SupportActionModeWrapper extends ActionMode {

    /* renamed from: a */
    public final Context f2240a;

    /* renamed from: b */
    public final ActionMode f2241b;

    public SupportActionModeWrapper(Context context, ActionMode actionMode) {
        this.f2240a = context;
        this.f2241b = actionMode;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f2241b.mo8767a();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f2241b.mo8762b();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return MenuWrapperFactory.m8592a(this.f2240a, (SupportMenu) this.f2241b.mo8759c());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f2241b.mo8758d();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f2241b.mo8757e();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f2241b.m8773f();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f2241b.mo8756g();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f2241b.m8772h();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f2241b.mo8755i();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f2241b.mo8754j();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f2241b.mo8765a(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f2241b.mo8764a(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f2241b.m8774a(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f2241b.mo8760b(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.f2241b.mo8763a(z);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.f2241b.mo8766a(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.f2241b.mo8761b(i);
    }

    /* compiled from: SupportActionModeWrapper.java */
    /* renamed from: a.b.h.j.f$a */
    /* loaded from: classes.dex */
    public static class C0415a implements ActionMode.InterfaceC0414a {

        /* renamed from: a */
        public final ActionMode.Callback f2242a;

        /* renamed from: b */
        public final Context f2243b;

        /* renamed from: c */
        public final ArrayList<SupportActionModeWrapper> f2244c = new ArrayList<>();

        /* renamed from: d */
        public final SimpleArrayMap<Menu, Menu> f2245d = new SimpleArrayMap<>();

        public C0415a(Context context, ActionMode.Callback callback) {
            this.f2243b = context;
            this.f2242a = callback;
        }

        @Override // p000a.p006b.p049h.p061j.ActionMode.InterfaceC0414a
        /* renamed from: a */
        public boolean mo8752a(ActionMode actionMode, Menu menu) {
            return this.f2242a.onCreateActionMode(m8749b(actionMode), m8750a(menu));
        }

        @Override // p000a.p006b.p049h.p061j.ActionMode.InterfaceC0414a
        /* renamed from: b */
        public boolean mo8748b(ActionMode actionMode, Menu menu) {
            return this.f2242a.onPrepareActionMode(m8749b(actionMode), m8750a(menu));
        }

        @Override // p000a.p006b.p049h.p061j.ActionMode.InterfaceC0414a
        /* renamed from: a */
        public boolean mo8751a(ActionMode actionMode, MenuItem menuItem) {
            return this.f2242a.onActionItemClicked(m8749b(actionMode), MenuWrapperFactory.m8591a(this.f2243b, (SupportMenuItem) menuItem));
        }

        /* renamed from: b */
        public android.view.ActionMode m8749b(ActionMode actionMode) {
            int size = this.f2244c.size();
            for (int i = 0; i < size; i++) {
                SupportActionModeWrapper supportActionModeWrapper = this.f2244c.get(i);
                if (supportActionModeWrapper != null && supportActionModeWrapper.f2241b == actionMode) {
                    return supportActionModeWrapper;
                }
            }
            SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper(this.f2243b, actionMode);
            this.f2244c.add(supportActionModeWrapper2);
            return supportActionModeWrapper2;
        }

        @Override // p000a.p006b.p049h.p061j.ActionMode.InterfaceC0414a
        /* renamed from: a */
        public void mo8753a(ActionMode actionMode) {
            this.f2242a.onDestroyActionMode(m8749b(actionMode));
        }

        /* renamed from: a */
        public final Menu m8750a(Menu menu) {
            Menu menu2 = this.f2245d.get(menu);
            if (menu2 == null) {
                Menu m8592a = MenuWrapperFactory.m8592a(this.f2243b, (SupportMenu) menu);
                this.f2245d.put(menu, m8592a);
                return m8592a;
            }
            return menu2;
        }
    }
}
