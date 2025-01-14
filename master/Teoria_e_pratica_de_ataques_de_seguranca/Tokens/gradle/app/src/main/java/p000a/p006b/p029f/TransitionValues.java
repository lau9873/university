package p000a.p006b.p029f;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: a.b.f.s */
/* loaded from: classes.dex */
public class TransitionValues {

    /* renamed from: b */
    public View f1000b;

    /* renamed from: a */
    public final Map<String, Object> f999a = new HashMap();

    /* renamed from: c */
    public final ArrayList<Transition> f1001c = new ArrayList<>();

    public boolean equals(Object obj) {
        if (obj instanceof TransitionValues) {
            TransitionValues transitionValues = (TransitionValues) obj;
            return this.f1000b == transitionValues.f1000b && this.f999a.equals(transitionValues.f999a);
        }
        return false;
    }

    public int hashCode() {
        return (this.f1000b.hashCode() * 31) + this.f999a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f1000b + "\n") + "    values:";
        for (String str2 : this.f999a.keySet()) {
            str = str + "    " + str2 + ": " + this.f999a.get(str2) + "\n";
        }
        return str;
    }
}
