package a.b.h.j;

import a.b.g.j.n;
import a.b.h.j.b;
import a.b.h.j.j.r;
import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;
/* compiled from: SupportActionModeWrapper.java */
/* loaded from: classes.dex */
public class f extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1490a;

    /* renamed from: b  reason: collision with root package name */
    public final b f1491b;

    public f(Context context, b bVar) {
        this.f1490a = context;
        this.f1491b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f1491b.a();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f1491b.b();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return r.a(this.f1490a, (a.b.g.d.a.a) this.f1491b.c());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f1491b.d();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f1491b.e();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f1491b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f1491b.g();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f1491b.h();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f1491b.i();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f1491b.j();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f1491b.a(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f1491b.a(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f1491b.a(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f1491b.b(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.f1491b.a(z);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i2) {
        this.f1491b.a(i2);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i2) {
        this.f1491b.b(i2);
    }

    /* compiled from: SupportActionModeWrapper.java */
    /* loaded from: classes.dex */
    public static class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        public final ActionMode.Callback f1492a;

        /* renamed from: b  reason: collision with root package name */
        public final Context f1493b;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<f> f1494c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        public final n<Menu, Menu> f1495d = new n<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f1493b = context;
            this.f1492a = callback;
        }

        @Override // a.b.h.j.b.a
        public boolean a(b bVar, Menu menu) {
            return this.f1492a.onCreateActionMode(b(bVar), a(menu));
        }

        @Override // a.b.h.j.b.a
        public boolean b(b bVar, Menu menu) {
            return this.f1492a.onPrepareActionMode(b(bVar), a(menu));
        }

        @Override // a.b.h.j.b.a
        public boolean a(b bVar, MenuItem menuItem) {
            return this.f1492a.onActionItemClicked(b(bVar), r.a(this.f1493b, (a.b.g.d.a.b) menuItem));
        }

        public ActionMode b(b bVar) {
            int size = this.f1494c.size();
            for (int i2 = 0; i2 < size; i2++) {
                f fVar = this.f1494c.get(i2);
                if (fVar != null && fVar.f1491b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f1493b, bVar);
            this.f1494c.add(fVar2);
            return fVar2;
        }

        @Override // a.b.h.j.b.a
        public void a(b bVar) {
            this.f1492a.onDestroyActionMode(b(bVar));
        }

        public final Menu a(Menu menu) {
            Menu menu2 = this.f1495d.get(menu);
            if (menu2 == null) {
                Menu a2 = r.a(this.f1493b, (a.b.g.d.a.a) menu);
                this.f1495d.put(menu, a2);
                return a2;
            }
            return menu2;
        }
    }
}
