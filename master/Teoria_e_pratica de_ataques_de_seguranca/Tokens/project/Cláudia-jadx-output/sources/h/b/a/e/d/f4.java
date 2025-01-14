package h.b.a.e.d;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import h.b.a.d.y;
import h.b.a.e.d.i3;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: SocialProfilesFragment.java */
/* loaded from: classes.dex */
public class f4 extends g3 implements h.b.a.d.s {
    public h.b.a.c c0;
    public List<h.b.a.d.t> d0 = new ArrayList();
    public h.b.a.d.y e0;
    public ProgressBar f0;

    /* compiled from: SocialProfilesFragment.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f7146a = new int[b.values().length];

        static {
            try {
                f7146a[b.CURRENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7146a[b.FUTURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: SocialProfilesFragment.java */
    /* loaded from: classes.dex */
    public enum b {
        CURRENT,
        FUTURE,
        NORMAL
    }

    /* compiled from: SocialProfilesFragment.java */
    /* loaded from: classes.dex */
    public static class c extends i3.a {

        /* renamed from: f  reason: collision with root package name */
        public final CharSequence f7151f;

        /* renamed from: g  reason: collision with root package name */
        public final CharSequence f7152g;

        /* renamed from: h  reason: collision with root package name */
        public b f7153h;

        /* renamed from: i  reason: collision with root package name */
        public SimpleDateFormat f7154i;

        public c(y.c cVar) {
            super(3, cVar.a(), 0);
            this.f7153h = b.NORMAL;
            this.f7154i = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
            this.f7151f = this.f7154i.format(cVar.c());
            this.f7152g = this.f7154i.format(cVar.b());
        }
    }

    /* compiled from: SocialProfilesFragment.java */
    /* loaded from: classes.dex */
    public class d extends h.b.a.e.f.a {
        public final LinearLayout u;
        public final TextView v;
        public final TextView w;
        public final TextView x;
        public final TextView y;
        public final View z;

        public d(View view) {
            super(view);
            this.u = (LinearLayout) view.findViewById(2131230931);
            this.v = (TextView) view.findViewById(2131231123);
            this.y = (TextView) view.findViewById(2131231124);
            this.w = (TextView) view.findViewById(2131231104);
            this.x = (TextView) view.findViewById(2131231103);
            this.z = view.findViewById(2131230819);
        }

        @Override // h.b.a.e.f.a
        public void a(i3.a aVar) {
            c cVar = (c) aVar;
            this.v.setText(cVar.f7217d);
            this.w.setText(cVar.f7151f);
            this.x.setText(cVar.f7152g);
            if (cVar.f7153h != b.NORMAL) {
                this.y.setVisibility(0);
            }
            int i2 = a.f7146a[cVar.f7153h.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    return;
                }
                this.y.setText(String.format("%s %s", f4.this.b0.getString(2131755072), cVar.f7151f));
                return;
            }
            LinearLayout linearLayout = this.u;
            linearLayout.setPadding(linearLayout.getPaddingLeft(), this.u.getPaddingTop(), this.u.getPaddingRight(), 0);
            this.y.setText(f4.this.b0.getString(2131755108));
            this.z.setVisibility(0);
        }
    }

    /* compiled from: SocialProfilesFragment.java */
    /* loaded from: classes.dex */
    public class e extends RecyclerView.g<h.b.a.e.f.a> implements h.b.a.d.t {

        /* renamed from: c  reason: collision with root package name */
        public final List<i3.a> f7155c = new ArrayList();

        public e() {
            f4.this.a((h.b.a.d.t) this);
        }

        @Override // android.support.v7.widget.RecyclerView.g
        public int c(int i2) {
            return this.f7155c.get(i2).f7216c;
        }

        public final void e() {
            if (f4.this.K()) {
                List<y.c> d2 = f4.this.e0.d();
                if (d2 == null) {
                    f4.this.c0.a(f4.this.b0.getString(2131755284), -1).m();
                    return;
                }
                Date time = Calendar.getInstance().getTime();
                y.c cVar = null;
                this.f7155c.add(new f(f4.this.b0.getString(2131755331)));
                for (y.c cVar2 : d2) {
                    if (cVar2.c().before(time) && cVar2.b().after(time)) {
                        cVar = cVar2;
                    }
                }
                if (cVar != null) {
                    c cVar3 = new c(cVar);
                    cVar3.f7153h = b.CURRENT;
                    this.f7155c.add(cVar3);
                    d2.remove(cVar);
                }
                Collections.sort(d2, Collections.reverseOrder(x1.f7399a));
                for (y.c cVar4 : d2) {
                    c cVar5 = new c(cVar4);
                    if (cVar4.c().after(time)) {
                        cVar5.f7153h = b.FUTURE;
                    }
                    this.f7155c.add(cVar5);
                }
                int a2 = a();
                b(0, a2 - (a2 == 1 ? 0 : 1));
            }
        }

        @Override // h.b.a.d.t
        public void onError(DataModels.Error error) {
            f4.this.c0.a(String.format(Locale.getDefault(), "%s: %s", f4.this.b0.getString(2131755195), error.getMessageToUser()), 0).m();
        }

        @Override // android.support.v7.widget.RecyclerView.g
        /* renamed from: a */
        public void b(h.b.a.e.f.a aVar, int i2) {
            aVar.a(this.f7155c.get(i2));
        }

        @Override // android.support.v7.widget.RecyclerView.g
        public int a() {
            return this.f7155c.size();
        }

        @Override // android.support.v7.widget.RecyclerView.g
        public h.b.a.e.f.a b(ViewGroup viewGroup, int i2) {
            if (i2 == 2) {
                f4 f4Var = f4.this;
                return new g(f4Var, LayoutInflater.from(f4Var.b0).inflate(2131427400, viewGroup, false));
            } else if (i2 == 3) {
                f4 f4Var2 = f4.this;
                return new d(LayoutInflater.from(f4Var2.b0).inflate(2131427410, viewGroup, false));
            } else {
                return null;
            }
        }

        @Override // h.b.a.d.t
        public void b(h.b.a.d.b<h.b.a.d.y> bVar) {
            f4.this.e0 = bVar.a();
            e();
        }
    }

    /* compiled from: SocialProfilesFragment.java */
    /* loaded from: classes.dex */
    public static class f extends i3.a {
        public f(CharSequence charSequence) {
            super(2, charSequence, 0);
        }
    }

    /* compiled from: SocialProfilesFragment.java */
    /* loaded from: classes.dex */
    public class g extends h.b.a.e.f.a {
        public final TextView u;

        public g(f4 f4Var, View view) {
            super(view);
            this.u = (TextView) view.findViewById(2131231149);
        }

        @Override // h.b.a.e.f.a
        public void a(i3.a aVar) {
            this.u.setText(((f) aVar).f7217d);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void c(Bundle bundle) {
        super.c(bundle);
        this.c0 = h.b.a.c.b(this.b0);
    }

    @Override // h.b.a.d.s
    public void onError(DataModels.Error error) {
        this.f0.setVisibility(4);
        for (h.b.a.d.t tVar : this.d0) {
            tVar.onError(error);
        }
    }

    @Override // h.b.a.d.s
    public void onSuccess(DataModels.UserAccountInfo userAccountInfo) {
        this.f0.setVisibility(4);
        h.b.a.d.b<h.b.a.d.y> a2 = h.b.a.c.b(this.b0).o().b().a(userAccountInfo);
        for (h.b.a.d.t tVar : this.d0) {
            tVar.b(a2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(2131427384, viewGroup, false);
        RecyclerView recyclerView = (RecyclerView) viewGroup2.findViewById(2131230947);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.b0));
        this.f0 = (ProgressBar) viewGroup2.findViewById(2131231005);
        recyclerView.setAdapter(new e());
        h.b.a.c.b(this.b0).o().a(this);
        return viewGroup2;
    }

    public final void a(h.b.a.d.t tVar) {
        if (this.d0.contains(tVar)) {
            return;
        }
        this.d0.add(tVar);
    }
}
