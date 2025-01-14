package p000a.p006b.p049h.p057f;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.p067v7.preference.internal.AbstractMultiSelectListPreference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import p000a.p006b.p049h.p050a.AlertDialog;

/* renamed from: a.b.h.f.d */
/* loaded from: classes.dex */
public class MultiSelectListPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {

    /* renamed from: q0 */
    public Set<String> f2127q0 = new HashSet();

    /* renamed from: r0 */
    public boolean f2128r0;

    /* renamed from: s0 */
    public CharSequence[] f2129s0;

    /* renamed from: t0 */
    public CharSequence[] f2130t0;

    /* compiled from: MultiSelectListPreferenceDialogFragmentCompat.java */
    /* renamed from: a.b.h.f.d$a */
    /* loaded from: classes.dex */
    public class DialogInterface$OnMultiChoiceClickListenerC0384a implements DialogInterface.OnMultiChoiceClickListener {
        public DialogInterface$OnMultiChoiceClickListenerC0384a() {
        }

        @Override // android.content.DialogInterface.OnMultiChoiceClickListener
        public void onClick(DialogInterface dialogInterface, int i, boolean z) {
            if (z) {
                MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat = MultiSelectListPreferenceDialogFragmentCompat.this;
                multiSelectListPreferenceDialogFragmentCompat.f2128r0 = multiSelectListPreferenceDialogFragmentCompat.f2127q0.add(multiSelectListPreferenceDialogFragmentCompat.f2130t0[i].toString()) | multiSelectListPreferenceDialogFragmentCompat.f2128r0;
                return;
            }
            MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat2 = MultiSelectListPreferenceDialogFragmentCompat.this;
            multiSelectListPreferenceDialogFragmentCompat2.f2128r0 = multiSelectListPreferenceDialogFragmentCompat2.f2127q0.remove(multiSelectListPreferenceDialogFragmentCompat2.f2130t0[i].toString()) | multiSelectListPreferenceDialogFragmentCompat2.f2128r0;
        }
    }

    /* renamed from: b */
    public static MultiSelectListPreferenceDialogFragmentCompat m8892b(String str) {
        MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat = new MultiSelectListPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        multiSelectListPreferenceDialogFragmentCompat.m7457m(bundle);
        return multiSelectListPreferenceDialogFragmentCompat;
    }

    @Override // p000a.p006b.p049h.p057f.PreferenceDialogFragmentCompat
    /* renamed from: a */
    public void mo8882a(AlertDialog.C0325a c0325a) {
        super.mo8882a(c0325a);
        int length = this.f2130t0.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            zArr[i] = this.f2127q0.contains(this.f2130t0[i].toString());
        }
        c0325a.m9136a(this.f2129s0, zArr, new DialogInterface$OnMultiChoiceClickListenerC0384a());
    }

    @Override // p000a.p006b.p049h.p057f.PreferenceDialogFragmentCompat, p000a.p006b.p030g.p031a.DialogFragment, android.support.p065v4.app.Fragment
    /* renamed from: c */
    public void mo728c(Bundle bundle) {
        super.mo728c(bundle);
        if (bundle == null) {
            AbstractMultiSelectListPreference m8891q0 = m8891q0();
            if (m8891q0.mo7148P() != null && m8891q0.mo7147Q() != null) {
                this.f2127q0.clear();
                this.f2127q0.addAll(m8891q0.mo7146R());
                this.f2128r0 = false;
                this.f2129s0 = m8891q0.mo7148P();
                this.f2130t0 = m8891q0.mo7147Q();
                return;
            }
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        this.f2127q0.clear();
        this.f2127q0.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
        this.f2128r0 = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
        this.f2129s0 = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
        this.f2130t0 = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
    }

    @Override // p000a.p006b.p049h.p057f.PreferenceDialogFragmentCompat, p000a.p006b.p030g.p031a.DialogFragment, android.support.p065v4.app.Fragment
    /* renamed from: e */
    public void mo924e(Bundle bundle) {
        super.mo924e(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList<>(this.f2127q0));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.f2128r0);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.f2129s0);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.f2130t0);
    }

    @Override // p000a.p006b.p049h.p057f.PreferenceDialogFragmentCompat
    /* renamed from: n */
    public void mo8878n(boolean z) {
        AbstractMultiSelectListPreference m8891q0 = m8891q0();
        if (z && this.f2128r0) {
            Set<String> set = this.f2127q0;
            if (m8891q0.m7240a((Object) set)) {
                m8891q0.mo7145c(set);
            }
        }
        this.f2128r0 = false;
    }

    /* renamed from: q0 */
    public final AbstractMultiSelectListPreference m8891q0() {
        return (AbstractMultiSelectListPreference) m8877o0();
    }
}
