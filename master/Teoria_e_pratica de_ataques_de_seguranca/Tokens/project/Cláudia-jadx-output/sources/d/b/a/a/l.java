package d.b.a.a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
/* compiled from: Phonemetadata.java */
/* loaded from: classes.dex */
public class l implements Externalizable {

    /* renamed from: a  reason: collision with root package name */
    public List<k> f4534a = new ArrayList();

    public int a() {
        return this.f4534a.size();
    }

    public List<k> b() {
        return this.f4534a;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        int readInt = objectInput.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            k kVar = new k();
            kVar.readExternal(objectInput);
            this.f4534a.add(kVar);
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        int a2 = a();
        objectOutput.writeInt(a2);
        for (int i2 = 0; i2 < a2; i2++) {
            this.f4534a.get(i2).writeExternal(objectOutput);
        }
    }
}
