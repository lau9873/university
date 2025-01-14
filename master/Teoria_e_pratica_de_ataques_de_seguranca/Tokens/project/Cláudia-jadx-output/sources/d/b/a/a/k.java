package d.b.a.a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
/* compiled from: Phonemetadata.java */
/* loaded from: classes.dex */
public class k implements Externalizable {
    public boolean B;
    public boolean D;
    public boolean F;
    public boolean H;
    public boolean M;
    public boolean O;
    public boolean Q;
    public boolean S;
    public boolean U;

    /* renamed from: a  reason: collision with root package name */
    public boolean f4525a;
    public boolean a0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4527c;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4529e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4531g;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4533i;
    public boolean k;
    public boolean n;
    public boolean p;
    public boolean r;
    public boolean t;
    public boolean v;
    public boolean x;
    public boolean z;

    /* renamed from: b  reason: collision with root package name */
    public m f4526b = null;

    /* renamed from: d  reason: collision with root package name */
    public m f4528d = null;

    /* renamed from: f  reason: collision with root package name */
    public m f4530f = null;

    /* renamed from: h  reason: collision with root package name */
    public m f4532h = null;
    public m j = null;
    public m m = null;
    public m o = null;
    public m q = null;
    public m s = null;
    public m u = null;
    public m w = null;
    public m y = null;
    public m A = null;
    public m C = null;
    public m E = null;
    public m G = null;
    public m I = null;
    public String J = "";
    public int K = 0;
    public String L = "";
    public String N = "";
    public String P = "";
    public String R = "";
    public String T = "";
    public String V = "";
    public boolean W = false;
    public List<j> X = new ArrayList();
    public List<j> Y = new ArrayList();
    public boolean Z = false;
    public String b0 = "";
    public boolean c0 = false;
    public boolean d0 = false;

    public k a(m mVar) {
        if (mVar != null) {
            this.D = true;
            this.E = mVar;
            return this;
        }
        throw new NullPointerException();
    }

    public m b() {
        return this.f4528d;
    }

    public m c() {
        return this.f4526b;
    }

    public k d(m mVar) {
        if (mVar != null) {
            this.f4525a = true;
            this.f4526b = mVar;
            return this;
        }
        throw new NullPointerException();
    }

    public k e(m mVar) {
        if (mVar != null) {
            this.f4529e = true;
            this.f4530f = mVar;
            return this;
        }
        throw new NullPointerException();
    }

    public m f() {
        return this.f4530f;
    }

    public k g(m mVar) {
        if (mVar != null) {
            this.r = true;
            this.s = mVar;
            return this;
        }
        throw new NullPointerException();
    }

    public k h(m mVar) {
        if (mVar != null) {
            this.n = true;
            this.o = mVar;
            return this;
        }
        throw new NullPointerException();
    }

    public k i(m mVar) {
        if (mVar != null) {
            this.f4533i = true;
            this.j = mVar;
            return this;
        }
        throw new NullPointerException();
    }

    public k j(m mVar) {
        if (mVar != null) {
            this.k = true;
            this.m = mVar;
            return this;
        }
        throw new NullPointerException();
    }

    public m k() {
        return this.j;
    }

    public k l(m mVar) {
        if (mVar != null) {
            this.F = true;
            this.G = mVar;
            return this;
        }
        throw new NullPointerException();
    }

    public m m() {
        return this.m;
    }

    public m n() {
        return this.f4532h;
    }

    public m o() {
        return this.u;
    }

    public m p() {
        return this.y;
    }

    public m q() {
        return this.q;
    }

    public boolean r() {
        return this.a0;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        if (objectInput.readBoolean()) {
            m mVar = new m();
            mVar.readExternal(objectInput);
            d(mVar);
        }
        if (objectInput.readBoolean()) {
            m mVar2 = new m();
            mVar2.readExternal(objectInput);
            c(mVar2);
        }
        if (objectInput.readBoolean()) {
            m mVar3 = new m();
            mVar3.readExternal(objectInput);
            e(mVar3);
        }
        if (objectInput.readBoolean()) {
            m mVar4 = new m();
            mVar4.readExternal(objectInput);
            n(mVar4);
        }
        if (objectInput.readBoolean()) {
            m mVar5 = new m();
            mVar5.readExternal(objectInput);
            i(mVar5);
        }
        if (objectInput.readBoolean()) {
            m mVar6 = new m();
            mVar6.readExternal(objectInput);
            j(mVar6);
        }
        if (objectInput.readBoolean()) {
            m mVar7 = new m();
            mVar7.readExternal(objectInput);
            h(mVar7);
        }
        if (objectInput.readBoolean()) {
            m mVar8 = new m();
            mVar8.readExternal(objectInput);
            q(mVar8);
        }
        if (objectInput.readBoolean()) {
            m mVar9 = new m();
            mVar9.readExternal(objectInput);
            g(mVar9);
        }
        if (objectInput.readBoolean()) {
            m mVar10 = new m();
            mVar10.readExternal(objectInput);
            o(mVar10);
        }
        if (objectInput.readBoolean()) {
            m mVar11 = new m();
            mVar11.readExternal(objectInput);
            b(mVar11);
        }
        if (objectInput.readBoolean()) {
            m mVar12 = new m();
            mVar12.readExternal(objectInput);
            p(mVar12);
        }
        if (objectInput.readBoolean()) {
            m mVar13 = new m();
            mVar13.readExternal(objectInput);
            k(mVar13);
        }
        if (objectInput.readBoolean()) {
            m mVar14 = new m();
            mVar14.readExternal(objectInput);
            m(mVar14);
        }
        if (objectInput.readBoolean()) {
            m mVar15 = new m();
            mVar15.readExternal(objectInput);
            a(mVar15);
        }
        if (objectInput.readBoolean()) {
            m mVar16 = new m();
            mVar16.readExternal(objectInput);
            l(mVar16);
        }
        if (objectInput.readBoolean()) {
            m mVar17 = new m();
            mVar17.readExternal(objectInput);
            f(mVar17);
        }
        a(objectInput.readUTF());
        a(objectInput.readInt());
        b(objectInput.readUTF());
        if (objectInput.readBoolean()) {
            h(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            d(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            g(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            e(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            f(objectInput.readUTF());
        }
        d(objectInput.readBoolean());
        int readInt = objectInput.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            j jVar = new j();
            jVar.readExternal(objectInput);
            this.X.add(jVar);
        }
        int readInt2 = objectInput.readInt();
        for (int i3 = 0; i3 < readInt2; i3++) {
            j jVar2 = new j();
            jVar2.readExternal(objectInput);
            this.Y.add(jVar2);
        }
        b(objectInput.readBoolean());
        if (objectInput.readBoolean()) {
            c(objectInput.readUTF());
        }
        a(objectInput.readBoolean());
        c(objectInput.readBoolean());
    }

    public boolean s() {
        return this.O;
    }

    public boolean t() {
        return this.S;
    }

    public int u() {
        return this.Y.size();
    }

    public List<j> v() {
        return this.Y;
    }

    public int w() {
        return this.X.size();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeBoolean(this.f4525a);
        if (this.f4525a) {
            this.f4526b.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.f4527c);
        if (this.f4527c) {
            this.f4528d.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.f4529e);
        if (this.f4529e) {
            this.f4530f.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.f4531g);
        if (this.f4531g) {
            this.f4532h.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.f4533i);
        if (this.f4533i) {
            this.j.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.k);
        if (this.k) {
            this.m.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.n);
        if (this.n) {
            this.o.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.p);
        if (this.p) {
            this.q.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.r);
        if (this.r) {
            this.s.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.t);
        if (this.t) {
            this.u.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.v);
        if (this.v) {
            this.w.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.x);
        if (this.x) {
            this.y.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.z);
        if (this.z) {
            this.A.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.B);
        if (this.B) {
            this.C.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.D);
        if (this.D) {
            this.E.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.F);
        if (this.F) {
            this.G.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.H);
        if (this.H) {
            this.I.writeExternal(objectOutput);
        }
        objectOutput.writeUTF(this.J);
        objectOutput.writeInt(this.K);
        objectOutput.writeUTF(this.L);
        objectOutput.writeBoolean(this.M);
        if (this.M) {
            objectOutput.writeUTF(this.N);
        }
        objectOutput.writeBoolean(this.O);
        if (this.O) {
            objectOutput.writeUTF(this.P);
        }
        objectOutput.writeBoolean(this.Q);
        if (this.Q) {
            objectOutput.writeUTF(this.R);
        }
        objectOutput.writeBoolean(this.S);
        if (this.S) {
            objectOutput.writeUTF(this.T);
        }
        objectOutput.writeBoolean(this.U);
        if (this.U) {
            objectOutput.writeUTF(this.V);
        }
        objectOutput.writeBoolean(this.W);
        int w = w();
        objectOutput.writeInt(w);
        for (int i2 = 0; i2 < w; i2++) {
            this.X.get(i2).writeExternal(objectOutput);
        }
        int u = u();
        objectOutput.writeInt(u);
        for (int i3 = 0; i3 < u; i3++) {
            this.Y.get(i3).writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.Z);
        objectOutput.writeBoolean(this.a0);
        if (this.a0) {
            objectOutput.writeUTF(this.b0);
        }
        objectOutput.writeBoolean(this.c0);
        objectOutput.writeBoolean(this.d0);
    }

    public List<j> x() {
        return this.X;
    }

    public k b(m mVar) {
        if (mVar != null) {
            this.v = true;
            this.w = mVar;
            return this;
        }
        throw new NullPointerException();
    }

    public k c(m mVar) {
        if (mVar != null) {
            this.f4527c = true;
            this.f4528d = mVar;
            return this;
        }
        throw new NullPointerException();
    }

    public k f(m mVar) {
        if (mVar != null) {
            this.H = true;
            this.I = mVar;
            return this;
        }
        throw new NullPointerException();
    }

    public k k(m mVar) {
        if (mVar != null) {
            this.z = true;
            this.A = mVar;
            return this;
        }
        throw new NullPointerException();
    }

    public k m(m mVar) {
        if (mVar != null) {
            this.B = true;
            this.C = mVar;
            return this;
        }
        throw new NullPointerException();
    }

    public k n(m mVar) {
        if (mVar != null) {
            this.f4531g = true;
            this.f4532h = mVar;
            return this;
        }
        throw new NullPointerException();
    }

    public k o(m mVar) {
        if (mVar != null) {
            this.t = true;
            this.u = mVar;
            return this;
        }
        throw new NullPointerException();
    }

    public k p(m mVar) {
        if (mVar != null) {
            this.x = true;
            this.y = mVar;
            return this;
        }
        throw new NullPointerException();
    }

    public k q(m mVar) {
        if (mVar != null) {
            this.p = true;
            this.q = mVar;
            return this;
        }
        throw new NullPointerException();
    }

    public k a(String str) {
        this.J = str;
        return this;
    }

    public String d() {
        return this.L;
    }

    public k e(String str) {
        this.S = true;
        this.T = str;
        return this;
    }

    public k g(String str) {
        this.Q = true;
        this.R = str;
        return this;
    }

    public k h(String str) {
        this.M = true;
        this.N = str;
        return this;
    }

    public m i() {
        return this.s;
    }

    public m j() {
        return this.o;
    }

    public boolean l() {
        return this.W;
    }

    public int a() {
        return this.K;
    }

    public k b(String str) {
        this.L = str;
        return this;
    }

    public k c(String str) {
        this.a0 = true;
        this.b0 = str;
        return this;
    }

    public k d(String str) {
        this.O = true;
        this.P = str;
        return this;
    }

    public k f(String str) {
        this.U = true;
        this.V = str;
        return this;
    }

    public k a(int i2) {
        this.K = i2;
        return this;
    }

    public k b(boolean z) {
        this.Z = z;
        return this;
    }

    public String e() {
        return this.b0;
    }

    public String g() {
        return this.T;
    }

    public String h() {
        return this.V;
    }

    public k a(boolean z) {
        this.c0 = z;
        return this;
    }

    public k c(boolean z) {
        this.d0 = z;
        return this;
    }

    public k d(boolean z) {
        this.W = z;
        return this;
    }
}
