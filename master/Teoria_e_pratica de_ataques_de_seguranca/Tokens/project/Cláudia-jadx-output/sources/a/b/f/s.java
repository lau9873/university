package a.b.f;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* compiled from: TransitionValues.java */
/* loaded from: classes.dex */
public class s {

    /* renamed from: b  reason: collision with root package name */
    public View f587b;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f586a = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<m> f588c = new ArrayList<>();

    public boolean equals(Object obj) {
        if (obj instanceof s) {
            s sVar = (s) obj;
            return this.f587b == sVar.f587b && this.f586a.equals(sVar.f586a);
        }
        return false;
    }

    public int hashCode() {
        return (this.f587b.hashCode() * 31) + this.f586a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f587b + "\n") + "    values:";
        for (String str2 : this.f586a.keySet()) {
            str = str + "    " + str2 + ": " + this.f586a.get(str2) + "\n";
        }
        return str;
    }
}
