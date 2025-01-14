package p136d.p149b.p150a.p151a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Phonemetadata.java */
/* renamed from: d.b.a.a.m */
/* loaded from: classes.dex */
public class C1530m implements Externalizable {

    /* renamed from: a */
    public boolean f6824a;

    /* renamed from: e */
    public boolean f6828e;

    /* renamed from: b */
    public String f6825b = "";

    /* renamed from: c */
    public List<Integer> f6826c = new ArrayList();

    /* renamed from: d */
    public List<Integer> f6827d = new ArrayList();

    /* renamed from: f */
    public String f6829f = "";

    /* renamed from: a */
    public int m3718a(int i) {
        return this.f6826c.get(i).intValue();
    }

    /* renamed from: b */
    public String m3716b() {
        return this.f6825b;
    }

    /* renamed from: c */
    public int m3714c() {
        return this.f6826c.size();
    }

    /* renamed from: d */
    public List<Integer> m3713d() {
        return this.f6826c;
    }

    /* renamed from: e */
    public int m3712e() {
        return this.f6827d.size();
    }

    /* renamed from: f */
    public List<Integer> m3711f() {
        return this.f6827d;
    }

    /* renamed from: g */
    public boolean m3710g() {
        return this.f6828e;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        if (objectInput.readBoolean()) {
            m3715b(objectInput.readUTF());
        }
        int readInt = objectInput.readInt();
        for (int i = 0; i < readInt; i++) {
            this.f6826c.add(Integer.valueOf(objectInput.readInt()));
        }
        int readInt2 = objectInput.readInt();
        for (int i2 = 0; i2 < readInt2; i2++) {
            this.f6827d.add(Integer.valueOf(objectInput.readInt()));
        }
        if (objectInput.readBoolean()) {
            m3717a(objectInput.readUTF());
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeBoolean(this.f6824a);
        if (this.f6824a) {
            objectOutput.writeUTF(this.f6825b);
        }
        int m3714c = m3714c();
        objectOutput.writeInt(m3714c);
        for (int i = 0; i < m3714c; i++) {
            objectOutput.writeInt(this.f6826c.get(i).intValue());
        }
        int m3712e = m3712e();
        objectOutput.writeInt(m3712e);
        for (int i2 = 0; i2 < m3712e; i2++) {
            objectOutput.writeInt(this.f6827d.get(i2).intValue());
        }
        objectOutput.writeBoolean(this.f6828e);
        if (this.f6828e) {
            objectOutput.writeUTF(this.f6829f);
        }
    }

    /* renamed from: a */
    public String m3719a() {
        return this.f6829f;
    }

    /* renamed from: b */
    public C1530m m3715b(String str) {
        this.f6824a = true;
        this.f6825b = str;
        return this;
    }

    /* renamed from: a */
    public C1530m m3717a(String str) {
        this.f6828e = true;
        this.f6829f = str;
        return this;
    }
}
