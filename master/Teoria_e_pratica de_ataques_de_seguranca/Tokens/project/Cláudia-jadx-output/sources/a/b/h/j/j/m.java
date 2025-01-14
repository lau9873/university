package a.b.h.j.j;

import a.b.g.k.c;
import a.b.h.j.j.l;
import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
/* compiled from: MenuItemWrapperJB.java */
/* loaded from: classes.dex */
public class m extends l {

    /* compiled from: MenuItemWrapperJB.java */
    /* loaded from: classes.dex */
    public class a extends l.a implements ActionProvider.VisibilityListener {

        /* renamed from: d  reason: collision with root package name */
        public c.b f1610d;

        public a(m mVar, Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // a.b.g.k.c
        public View a(MenuItem menuItem) {
            return this.f1605b.onCreateActionView(menuItem);
        }

        @Override // a.b.g.k.c
        public boolean b() {
            return this.f1605b.isVisible();
        }

        @Override // a.b.g.k.c
        public boolean e() {
            return this.f1605b.overridesItemVisibility();
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            c.b bVar = this.f1610d;
            if (bVar != null) {
                bVar.onActionProviderVisibilityChanged(z);
            }
        }

        @Override // a.b.g.k.c
        public void a(c.b bVar) {
            this.f1610d = bVar;
            this.f1605b.setVisibilityListener(bVar != null ? this : null);
        }
    }

    public m(Context context, a.b.g.d.a.b bVar) {
        super(context, bVar);
    }

    @Override // a.b.h.j.j.l
    public l.a a(ActionProvider actionProvider) {
        return new a(this, this.f1542b, actionProvider);
    }
}
