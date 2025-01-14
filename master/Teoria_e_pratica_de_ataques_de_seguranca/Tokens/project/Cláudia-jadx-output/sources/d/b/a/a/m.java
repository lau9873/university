package d.b.a.a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
/* compiled from: Phonemetadata.java */
/* loaded from: classes.dex */
public class m implements Externalizable {

    /* renamed from: a  reason: collision with root package name */
    public boolean f4535a;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4539e;

    /* renamed from: b  reason: collision with root package name */
    public String f4536b = "";

    /* renamed from: c  reason: collision with root package name */
    public List<Integer> f4537c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f4538d = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public String f4540f = "";

    public int a(int i2) {
        return this.f4537c.get(i2).intValue();
    }

    public String b() {
        return this.f4536b;
    }

    public int c() {
        return this.f4537c.size();
    }

    public List<Integer> d() {
        return this.f4537c;
    }

    public int e() {
        return this.f4538d.size();
    }

    public List<Integer> f() {
        return this.f4538d;
    }

    public boolean g() {
        return this.f4539e;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        if (objectInput.readBoolean()) {
            b(objectInput.readUTF());
        }
        int readInt = objectInput.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f4537c.add(Integer.valueOf(objectInput.readInt()));
        }
        int readInt2 = objectInput.readInt();
        for (int i3 = 0; i3 < readInt2; i3++) {
            this.f4538d.add(Integer.valueOf(objectInput.readInt()));
        }
        if (objectInput.readBoolean()) {
            a(objectInput.readUTF());
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeBoolean(this.f4535a);
        if (this.f4535a) {
            objectOutput.writeUTF(this.f4536b);
        }
        int c2 = c();
        objectOutput.writeInt(c2);
        for (int i2 = 0; i2 < c2; i2++) {
            objectOutput.writeInt(this.f4537c.get(i2).intValue());
        }
        int e2 = e();
        objectOutput.writeInt(e2);
        for (int i3 = 0; i3 < e2; i3++) {
            objectOutput.writeInt(this.f4538d.get(i3).intValue());
        }
        objectOutput.writeBoolean(this.f4539e);
        if (this.f4539e) {
            objectOutput.writeUTF(this.f4540f);
        }
    }

    public String a() {
        return this.f4540f;
    }

    public m b(String str) {
        this.f4535a = true;
        this.f4536b = str;
        return this;
    }

    public m a(String str) {
        this.f4539e = true;
        this.f4540f = str;
        return this;
    }
}
