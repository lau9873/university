package a.b.h.f;

import a.b.h.a.c;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.preference.internal.AbstractMultiSelectListPreference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* compiled from: MultiSelectListPreferenceDialogFragmentCompat.java */
/* loaded from: classes.dex */
public class d extends f {
    public Set<String> q0 = new HashSet();
    public boolean r0;
    public CharSequence[] s0;
    public CharSequence[] t0;

    /* compiled from: MultiSelectListPreferenceDialogFragmentCompat.java */
    /* loaded from: classes.dex */
    public class a implements DialogInterface.OnMultiChoiceClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnMultiChoiceClickListener
        public void onClick(DialogInterface dialogInterface, int i2, boolean z) {
            if (z) {
                d dVar = d.this;
                dVar.r0 = dVar.q0.add(dVar.t0[i2].toString()) | dVar.r0;
                return;
            }
            d dVar2 = d.this;
            dVar2.r0 = dVar2.q0.remove(dVar2.t0[i2].toString()) | dVar2.r0;
        }
    }

    public static d b(String str) {
        d dVar = new d();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        dVar.m(bundle);
        return dVar;
    }

    @Override // a.b.h.f.f
    public void a(c.a aVar) {
        super.a(aVar);
        int length = this.t0.length;
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            zArr[i2] = this.q0.contains(this.t0[i2].toString());
        }
        aVar.a(this.s0, zArr, new a());
    }

    @Override // a.b.h.f.f, a.b.g.a.f, android.support.v4.app.Fragment
    public void c(Bundle bundle) {
        super.c(bundle);
        if (bundle == null) {
            AbstractMultiSelectListPreference q0 = q0();
            if (q0.P() != null && q0.Q() != null) {
                this.q0.clear();
                this.q0.addAll(q0.R());
                this.r0 = false;
                this.s0 = q0.P();
                this.t0 = q0.Q();
                return;
            }
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        this.q0.clear();
        this.q0.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
        this.r0 = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
        this.s0 = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
        this.t0 = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
    }

    @Override // a.b.h.f.f, a.b.g.a.f, android.support.v4.app.Fragment
    public void e(Bundle bundle) {
        super.e(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList<>(this.q0));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.r0);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.s0);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.t0);
    }

    @Override // a.b.h.f.f
    public void n(boolean z) {
        AbstractMultiSelectListPreference q0 = q0();
        if (z && this.r0) {
            Set<String> set = this.q0;
            if (q0.a((Object) set)) {
                q0.c(set);
            }
        }
        this.r0 = false;
    }

    public final AbstractMultiSelectListPreference q0() {
        return (AbstractMultiSelectListPreference) o0();
    }
}
