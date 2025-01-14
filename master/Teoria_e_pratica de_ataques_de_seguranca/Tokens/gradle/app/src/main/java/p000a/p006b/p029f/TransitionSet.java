package p000a.p006b.p029f;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import p000a.p006b.p029f.Transition;

/* renamed from: a.b.f.q */
/* loaded from: classes.dex */
public class TransitionSet extends Transition {

    /* renamed from: M */
    public int f991M;

    /* renamed from: K */
    public ArrayList<Transition> f989K = new ArrayList<>();

    /* renamed from: L */
    public boolean f990L = true;

    /* renamed from: N */
    public boolean f992N = false;

    /* renamed from: O */
    public int f993O = 0;

    /* compiled from: TransitionSet.java */
    /* renamed from: a.b.f.q$a */
    /* loaded from: classes.dex */
    public class C0128a extends TransitionListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ Transition f994a;

        public C0128a(TransitionSet transitionSet, Transition transition) {
            this.f994a = transition;
        }

        @Override // p000a.p006b.p029f.Transition.InterfaceC0125f
        /* renamed from: b */
        public void mo10433b(Transition transition) {
            this.f994a.mo10436p();
            transition.mo10442b(this);
        }
    }

    /* compiled from: TransitionSet.java */
    /* renamed from: a.b.f.q$b */
    /* loaded from: classes.dex */
    public static class C0129b extends TransitionListenerAdapter {

        /* renamed from: a */
        public TransitionSet f995a;

        public C0129b(TransitionSet transitionSet) {
            this.f995a = transitionSet;
        }

        @Override // p000a.p006b.p029f.Transition.InterfaceC0125f
        /* renamed from: b */
        public void mo10433b(Transition transition) {
            TransitionSet transitionSet = this.f995a;
            transitionSet.f991M--;
            if (transitionSet.f991M == 0) {
                transitionSet.f992N = false;
                transitionSet.m10501a();
            }
            transition.mo10442b(this);
        }

        @Override // p000a.p006b.p029f.TransitionListenerAdapter, p000a.p006b.p029f.Transition.InterfaceC0125f
        /* renamed from: c */
        public void mo10432c(Transition transition) {
            TransitionSet transitionSet = this.f995a;
            if (transitionSet.f992N) {
                return;
            }
            transitionSet.m10469q();
            this.f995a.f992N = true;
        }
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: c */
    public void mo10440c(TransitionValues transitionValues) {
        if (m10483b(transitionValues.f1000b)) {
            Iterator<Transition> it = this.f989K.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.m10483b(transitionValues.f1000b)) {
                    next.mo10440c(transitionValues);
                    transitionValues.f1001c.add(next);
                }
            }
        }
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: e */
    public void mo10437e(View view) {
        super.mo10437e(view);
        int size = this.f989K.size();
        for (int i = 0; i < size; i++) {
            this.f989K.get(i).mo10437e(view);
        }
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: p */
    public void mo10436p() {
        if (this.f989K.isEmpty()) {
            m10469q();
            m10501a();
            return;
        }
        m10434t();
        if (!this.f990L) {
            for (int i = 1; i < this.f989K.size(); i++) {
                this.f989K.get(i - 1).mo10452a(new C0128a(this, this.f989K.get(i)));
            }
            Transition transition = this.f989K.get(0);
            if (transition != null) {
                transition.mo10436p();
                return;
            }
            return;
        }
        Iterator<Transition> it = this.f989K.iterator();
        while (it.hasNext()) {
            it.next().mo10436p();
        }
    }

    /* renamed from: s */
    public int m10435s() {
        return this.f989K.size();
    }

    /* renamed from: t */
    public final void m10434t() {
        C0129b c0129b = new C0129b(this);
        Iterator<Transition> it = this.f989K.iterator();
        while (it.hasNext()) {
            it.next().mo10452a(c0129b);
        }
        this.f991M = this.f989K.size();
    }

    @Override // p000a.p006b.p029f.Transition
    public Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.m11327clone();
        transitionSet.f989K = new ArrayList<>();
        int size = this.f989K.size();
        for (int i = 0; i < size; i++) {
            transitionSet.m10451a(this.f989K.get(i).m11327clone());
        }
        return transitionSet;
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: d */
    public TransitionSet mo10438d(View view) {
        for (int i = 0; i < this.f989K.size(); i++) {
            this.f989K.get(i).mo10438d(view);
        }
        super.mo10438d(view);
        return this;
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: a */
    public /* bridge */ /* synthetic */ Transition mo10455a(long j) {
        mo10455a(j);
        return this;
    }

    /* renamed from: b */
    public TransitionSet m10444b(int i) {
        if (i == 0) {
            this.f990L = true;
        } else if (i == 1) {
            this.f990L = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        }
        return this;
    }

    /* renamed from: a */
    public TransitionSet m10451a(Transition transition) {
        this.f989K.add(transition);
        transition.f966s = this;
        long j = this.f951c;
        if (j >= 0) {
            transition.mo10455a(j);
        }
        if ((this.f993O & 1) != 0) {
            transition.mo10448a(m10479d());
        }
        if ((this.f993O & 2) != 0) {
            transition.mo10450a(m10476g());
        }
        if ((this.f993O & 4) != 0) {
            transition.mo10454a(m10477f());
        }
        if ((this.f993O & 8) != 0) {
            transition.mo10453a(m10481c());
        }
        return this;
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: b */
    public TransitionSet mo10443b(long j) {
        super.mo10443b(j);
        return this;
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: c */
    public void mo10439c(View view) {
        super.mo10439c(view);
        int size = this.f989K.size();
        for (int i = 0; i < size; i++) {
            this.f989K.get(i).mo10439c(view);
        }
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: b */
    public TransitionSet mo10442b(Transition.InterfaceC0125f interfaceC0125f) {
        super.mo10442b(interfaceC0125f);
        return this;
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: b */
    public void mo10441b(TransitionValues transitionValues) {
        super.mo10441b(transitionValues);
        int size = this.f989K.size();
        for (int i = 0; i < size; i++) {
            this.f989K.get(i).mo10441b(transitionValues);
        }
    }

    /* renamed from: a */
    public Transition m10456a(int i) {
        if (i < 0 || i >= this.f989K.size()) {
            return null;
        }
        return this.f989K.get(i);
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: a */
    public TransitionSet mo10455a(long j) {
        super.mo10455a(j);
        if (this.f951c >= 0) {
            int size = this.f989K.size();
            for (int i = 0; i < size; i++) {
                this.f989K.get(i).mo10455a(j);
            }
        }
        return this;
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: a */
    public TransitionSet mo10448a(TimeInterpolator timeInterpolator) {
        this.f993O |= 1;
        ArrayList<Transition> arrayList = this.f989K;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.f989K.get(i).mo10448a(timeInterpolator);
            }
        }
        super.mo10448a(timeInterpolator);
        return this;
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: a */
    public TransitionSet mo10447a(View view) {
        for (int i = 0; i < this.f989K.size(); i++) {
            this.f989K.get(i).mo10447a(view);
        }
        super.mo10447a(view);
        return this;
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: a */
    public TransitionSet mo10452a(Transition.InterfaceC0125f interfaceC0125f) {
        super.mo10452a(interfaceC0125f);
        return this;
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: a */
    public void mo10454a(PathMotion pathMotion) {
        super.mo10454a(pathMotion);
        this.f993O |= 4;
        for (int i = 0; i < this.f989K.size(); i++) {
            this.f989K.get(i).mo10454a(pathMotion);
        }
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: a */
    public void mo10446a(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        long m10475h = m10475h();
        int size = this.f989K.size();
        for (int i = 0; i < size; i++) {
            Transition transition = this.f989K.get(i);
            if (m10475h > 0 && (this.f990L || i == 0)) {
                long m10475h2 = transition.m10475h();
                if (m10475h2 > 0) {
                    transition.mo10443b(m10475h2 + m10475h);
                } else {
                    transition.mo10443b(m10475h);
                }
            }
            transition.mo10446a(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
        }
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: a */
    public void mo10449a(TransitionValues transitionValues) {
        if (m10483b(transitionValues.f1000b)) {
            Iterator<Transition> it = this.f989K.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.m10483b(transitionValues.f1000b)) {
                    next.mo10449a(transitionValues);
                    transitionValues.f1001c.add(next);
                }
            }
        }
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: a */
    public void mo10450a(TransitionPropagation transitionPropagation) {
        super.mo10450a(transitionPropagation);
        this.f993O |= 2;
        int size = this.f989K.size();
        for (int i = 0; i < size; i++) {
            this.f989K.get(i).mo10450a(transitionPropagation);
        }
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: a */
    public void mo10453a(Transition.AbstractC0124e abstractC0124e) {
        super.mo10453a(abstractC0124e);
        this.f993O |= 8;
        int size = this.f989K.size();
        for (int i = 0; i < size; i++) {
            this.f989K.get(i).mo10453a(abstractC0124e);
        }
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: a */
    public String mo10445a(String str) {
        String mo10445a = super.mo10445a(str);
        for (int i = 0; i < this.f989K.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(mo10445a);
            sb.append("\n");
            sb.append(this.f989K.get(i).mo10445a(str + "  "));
            mo10445a = sb.toString();
        }
        return mo10445a;
    }
}
