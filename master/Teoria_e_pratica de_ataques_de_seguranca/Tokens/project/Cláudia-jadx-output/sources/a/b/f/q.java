package a.b.f;

import a.b.f.m;
import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: TransitionSet.java */
/* loaded from: classes.dex */
public class q extends m {
    public int M;
    public ArrayList<m> K = new ArrayList<>();
    public boolean L = true;
    public boolean N = false;
    public int O = 0;

    /* compiled from: TransitionSet.java */
    /* loaded from: classes.dex */
    public class a extends n {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f581a;

        public a(q qVar, m mVar) {
            this.f581a = mVar;
        }

        @Override // a.b.f.m.f
        public void b(m mVar) {
            this.f581a.p();
            mVar.b(this);
        }
    }

    /* compiled from: TransitionSet.java */
    /* loaded from: classes.dex */
    public static class b extends n {

        /* renamed from: a  reason: collision with root package name */
        public q f582a;

        public b(q qVar) {
            this.f582a = qVar;
        }

        @Override // a.b.f.m.f
        public void b(m mVar) {
            q qVar = this.f582a;
            qVar.M--;
            if (qVar.M == 0) {
                qVar.N = false;
                qVar.a();
            }
            mVar.b(this);
        }

        @Override // a.b.f.n, a.b.f.m.f
        public void c(m mVar) {
            q qVar = this.f582a;
            if (qVar.N) {
                return;
            }
            qVar.q();
            this.f582a.N = true;
        }
    }

    @Override // a.b.f.m
    public void c(s sVar) {
        if (b(sVar.f587b)) {
            Iterator<m> it = this.K.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next.b(sVar.f587b)) {
                    next.c(sVar);
                    sVar.f588c.add(next);
                }
            }
        }
    }

    @Override // a.b.f.m
    public void e(View view) {
        super.e(view);
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.K.get(i2).e(view);
        }
    }

    @Override // a.b.f.m
    public void p() {
        if (this.K.isEmpty()) {
            q();
            a();
            return;
        }
        t();
        if (!this.L) {
            for (int i2 = 1; i2 < this.K.size(); i2++) {
                this.K.get(i2 - 1).a(new a(this, this.K.get(i2)));
            }
            m mVar = this.K.get(0);
            if (mVar != null) {
                mVar.p();
                return;
            }
            return;
        }
        Iterator<m> it = this.K.iterator();
        while (it.hasNext()) {
            it.next().p();
        }
    }

    public int s() {
        return this.K.size();
    }

    public final void t() {
        b bVar = new b(this);
        Iterator<m> it = this.K.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        this.M = this.K.size();
    }

    @Override // a.b.f.m
    public m clone() {
        q qVar = (q) super.m4clone();
        qVar.K = new ArrayList<>();
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            qVar.a(this.K.get(i2).m4clone());
        }
        return qVar;
    }

    @Override // a.b.f.m
    public q d(View view) {
        for (int i2 = 0; i2 < this.K.size(); i2++) {
            this.K.get(i2).d(view);
        }
        super.d(view);
        return this;
    }

    @Override // a.b.f.m
    public /* bridge */ /* synthetic */ m a(long j) {
        a(j);
        return this;
    }

    public q b(int i2) {
        if (i2 == 0) {
            this.L = true;
        } else if (i2 == 1) {
            this.L = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i2);
        }
        return this;
    }

    public q a(m mVar) {
        this.K.add(mVar);
        mVar.s = this;
        long j = this.f559c;
        if (j >= 0) {
            mVar.a(j);
        }
        if ((this.O & 1) != 0) {
            mVar.a(d());
        }
        if ((this.O & 2) != 0) {
            mVar.a(g());
        }
        if ((this.O & 4) != 0) {
            mVar.a(f());
        }
        if ((this.O & 8) != 0) {
            mVar.a(c());
        }
        return this;
    }

    @Override // a.b.f.m
    public q b(long j) {
        super.b(j);
        return this;
    }

    @Override // a.b.f.m
    public void c(View view) {
        super.c(view);
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.K.get(i2).c(view);
        }
    }

    @Override // a.b.f.m
    public q b(m.f fVar) {
        super.b(fVar);
        return this;
    }

    @Override // a.b.f.m
    public void b(s sVar) {
        super.b(sVar);
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.K.get(i2).b(sVar);
        }
    }

    public m a(int i2) {
        if (i2 < 0 || i2 >= this.K.size()) {
            return null;
        }
        return this.K.get(i2);
    }

    @Override // a.b.f.m
    public q a(long j) {
        super.a(j);
        if (this.f559c >= 0) {
            int size = this.K.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.K.get(i2).a(j);
            }
        }
        return this;
    }

    @Override // a.b.f.m
    public q a(TimeInterpolator timeInterpolator) {
        this.O |= 1;
        ArrayList<m> arrayList = this.K;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.K.get(i2).a(timeInterpolator);
            }
        }
        super.a(timeInterpolator);
        return this;
    }

    @Override // a.b.f.m
    public q a(View view) {
        for (int i2 = 0; i2 < this.K.size(); i2++) {
            this.K.get(i2).a(view);
        }
        super.a(view);
        return this;
    }

    @Override // a.b.f.m
    public q a(m.f fVar) {
        super.a(fVar);
        return this;
    }

    @Override // a.b.f.m
    public void a(g gVar) {
        super.a(gVar);
        this.O |= 4;
        for (int i2 = 0; i2 < this.K.size(); i2++) {
            this.K.get(i2).a(gVar);
        }
    }

    @Override // a.b.f.m
    public void a(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        long h2 = h();
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            m mVar = this.K.get(i2);
            if (h2 > 0 && (this.L || i2 == 0)) {
                long h3 = mVar.h();
                if (h3 > 0) {
                    mVar.b(h3 + h2);
                } else {
                    mVar.b(h2);
                }
            }
            mVar.a(viewGroup, tVar, tVar2, arrayList, arrayList2);
        }
    }

    @Override // a.b.f.m
    public void a(s sVar) {
        if (b(sVar.f587b)) {
            Iterator<m> it = this.K.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next.b(sVar.f587b)) {
                    next.a(sVar);
                    sVar.f588c.add(next);
                }
            }
        }
    }

    @Override // a.b.f.m
    public void a(p pVar) {
        super.a(pVar);
        this.O |= 2;
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.K.get(i2).a(pVar);
        }
    }

    @Override // a.b.f.m
    public void a(m.e eVar) {
        super.a(eVar);
        this.O |= 8;
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.K.get(i2).a(eVar);
        }
    }

    @Override // a.b.f.m
    public String a(String str) {
        String a2 = super.a(str);
        for (int i2 = 0; i2 < this.K.size(); i2++) {
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            sb.append("\n");
            sb.append(this.K.get(i2).a(str + "  "));
            a2 = sb.toString();
        }
        return a2;
    }
}
