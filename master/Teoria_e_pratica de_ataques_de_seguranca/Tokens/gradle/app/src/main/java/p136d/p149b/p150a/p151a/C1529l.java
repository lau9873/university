package p136d.p149b.p150a.p151a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Phonemetadata.java */
/* renamed from: d.b.a.a.l */
/* loaded from: classes.dex */
public class C1529l implements Externalizable {

    /* renamed from: a */
    public List<C1528k> f6823a = new ArrayList();

    /* renamed from: a */
    public int m3721a() {
        return this.f6823a.size();
    }

    /* renamed from: b */
    public List<C1528k> m3720b() {
        return this.f6823a;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        int readInt = objectInput.readInt();
        for (int i = 0; i < readInt; i++) {
            C1528k c1528k = new C1528k();
            c1528k.readExternal(objectInput);
            this.f6823a.add(c1528k);
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        int m3721a = m3721a();
        objectOutput.writeInt(m3721a);
        for (int i = 0; i < m3721a; i++) {
            this.f6823a.get(i).writeExternal(objectOutput);
        }
    }
}
