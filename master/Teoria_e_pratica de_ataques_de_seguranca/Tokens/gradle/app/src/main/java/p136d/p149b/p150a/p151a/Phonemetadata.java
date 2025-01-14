package p136d.p149b.p150a.p151a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* renamed from: d.b.a.a.j */
/* loaded from: classes.dex */
public class Phonemetadata implements Externalizable {

    /* renamed from: d */
    public boolean f6763d;

    /* renamed from: g */
    public boolean f6766g;

    /* renamed from: a */
    public String f6760a = "";

    /* renamed from: b */
    public String f6761b = "";

    /* renamed from: c */
    public List<String> f6762c = new ArrayList();

    /* renamed from: e */
    public String f6764e = "";

    /* renamed from: f */
    public boolean f6765f = false;

    /* renamed from: h */
    public String f6767h = "";

    /* renamed from: a */
    public String m3786a() {
        return this.f6761b;
    }

    /* renamed from: b */
    public Phonemetadata m3781b(String str) {
        this.f6761b = str;
        return this;
    }

    /* renamed from: c */
    public Phonemetadata m3779c(String str) {
        this.f6763d = true;
        this.f6764e = str;
        return this;
    }

    /* renamed from: d */
    public String m3778d() {
        return this.f6760a;
    }

    /* renamed from: e */
    public int m3776e() {
        return this.f6762c.size();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        m3777d(objectInput.readUTF());
        m3781b(objectInput.readUTF());
        int readInt = objectInput.readInt();
        for (int i = 0; i < readInt; i++) {
            this.f6762c.add(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            m3779c(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            m3784a(objectInput.readUTF());
        }
        m3783a(objectInput.readBoolean());
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeUTF(this.f6760a);
        objectOutput.writeUTF(this.f6761b);
        int m3776e = m3776e();
        objectOutput.writeInt(m3776e);
        for (int i = 0; i < m3776e; i++) {
            objectOutput.writeUTF(this.f6762c.get(i));
        }
        objectOutput.writeBoolean(this.f6763d);
        if (this.f6763d) {
            objectOutput.writeUTF(this.f6764e);
        }
        objectOutput.writeBoolean(this.f6766g);
        if (this.f6766g) {
            objectOutput.writeUTF(this.f6767h);
        }
        objectOutput.writeBoolean(this.f6765f);
    }

    /* renamed from: a */
    public String m3785a(int i) {
        return this.f6762c.get(i);
    }

    /* renamed from: b */
    public String m3782b() {
        return this.f6764e;
    }

    /* renamed from: d */
    public Phonemetadata m3777d(String str) {
        this.f6760a = str;
        return this;
    }

    /* renamed from: a */
    public Phonemetadata m3783a(boolean z) {
        this.f6765f = z;
        return this;
    }

    /* renamed from: c */
    public boolean m3780c() {
        return this.f6765f;
    }

    /* renamed from: a */
    public Phonemetadata m3784a(String str) {
        this.f6766g = true;
        this.f6767h = str;
        return this;
    }
}
