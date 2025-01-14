package d.b.a.a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
/* compiled from: Phonemetadata.java */
/* loaded from: classes.dex */
public class j implements Externalizable {

    /* renamed from: d  reason: collision with root package name */
    public boolean f4520d;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4523g;

    /* renamed from: a  reason: collision with root package name */
    public String f4517a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f4518b = "";

    /* renamed from: c  reason: collision with root package name */
    public List<String> f4519c = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public String f4521e = "";

    /* renamed from: f  reason: collision with root package name */
    public boolean f4522f = false;

    /* renamed from: h  reason: collision with root package name */
    public String f4524h = "";

    public String a() {
        return this.f4518b;
    }

    public j b(String str) {
        this.f4518b = str;
        return this;
    }

    public j c(String str) {
        this.f4520d = true;
        this.f4521e = str;
        return this;
    }

    public String d() {
        return this.f4517a;
    }

    public int e() {
        return this.f4519c.size();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        d(objectInput.readUTF());
        b(objectInput.readUTF());
        int readInt = objectInput.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f4519c.add(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            c(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            a(objectInput.readUTF());
        }
        a(objectInput.readBoolean());
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeUTF(this.f4517a);
        objectOutput.writeUTF(this.f4518b);
        int e2 = e();
        objectOutput.writeInt(e2);
        for (int i2 = 0; i2 < e2; i2++) {
            objectOutput.writeUTF(this.f4519c.get(i2));
        }
        objectOutput.writeBoolean(this.f4520d);
        if (this.f4520d) {
            objectOutput.writeUTF(this.f4521e);
        }
        objectOutput.writeBoolean(this.f4523g);
        if (this.f4523g) {
            objectOutput.writeUTF(this.f4524h);
        }
        objectOutput.writeBoolean(this.f4522f);
    }

    public String a(int i2) {
        return this.f4519c.get(i2);
    }

    public String b() {
        return this.f4521e;
    }

    public j d(String str) {
        this.f4517a = str;
        return this;
    }

    public j a(boolean z) {
        this.f4522f = z;
        return this;
    }

    public boolean c() {
        return this.f4522f;
    }

    public j a(String str) {
        this.f4523g = true;
        this.f4524h = str;
        return this;
    }
}
