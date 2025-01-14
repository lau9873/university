package p000a.p006b.p049h.p057f;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.p067v7.preference.ListPreference;
import p000a.p006b.p049h.p050a.AlertDialog;

/* renamed from: a.b.h.f.c */
/* loaded from: classes.dex */
public class ListPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {

    /* renamed from: q0 */
    public int f2123q0;

    /* renamed from: r0 */
    public CharSequence[] f2124r0;

    /* renamed from: s0 */
    public CharSequence[] f2125s0;

    /* compiled from: ListPreferenceDialogFragmentCompat.java */
    /* renamed from: a.b.h.f.c$a */
    /* loaded from: classes.dex */
    public class DialogInterface$OnClickListenerC0383a implements DialogInterface.OnClickListener {
        public DialogInterface$OnClickListenerC0383a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ListPreferenceDialogFragmentCompat listPreferenceDialogFragmentCompat = ListPreferenceDialogFragmentCompat.this;
            listPreferenceDialogFragmentCompat.f2123q0 = i;
            listPreferenceDialogFragmentCompat.onClick(dialogInterface, -1);
            dialogInterface.dismiss();
        }
    }

    /* renamed from: b */
    public static ListPreferenceDialogFragmentCompat m8894b(String str) {
        ListPreferenceDialogFragmentCompat listPreferenceDialogFragmentCompat = new ListPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        listPreferenceDialogFragmentCompat.m7457m(bundle);
        return listPreferenceDialogFragmentCompat;
    }

    @Override // p000a.p006b.p049h.p057f.PreferenceDialogFragmentCompat
    /* renamed from: a */
    public void mo8882a(AlertDialog.C0325a c0325a) {
        super.mo8882a(c0325a);
        c0325a.m9137a(this.f2124r0, this.f2123q0, new DialogInterface$OnClickListenerC0383a());
        c0325a.m9130b((CharSequence) null, (DialogInterface.OnClickListener) null);
    }

    @Override // p000a.p006b.p049h.p057f.PreferenceDialogFragmentCompat, p000a.p006b.p030g.p031a.DialogFragment, android.support.p065v4.app.Fragment
    /* renamed from: c */
    public void mo728c(Bundle bundle) {
        super.mo728c(bundle);
        if (bundle == null) {
            ListPreference m8893q0 = m8893q0();
            if (m8893q0.m7264P() != null && m8893q0.m7262R() != null) {
                this.f2123q0 = m8893q0.m7259d(m8893q0.m7261S());
                this.f2124r0 = m8893q0.m7264P();
                this.f2125s0 = m8893q0.m7262R();
                return;
            }
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.f2123q0 = bundle.getInt("ListPreferenceDialogFragment.index", 0);
        this.f2124r0 = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
        this.f2125s0 = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
    }

    @Override // p000a.p006b.p049h.p057f.PreferenceDialogFragmentCompat, p000a.p006b.p030g.p031a.DialogFragment, android.support.p065v4.app.Fragment
    /* renamed from: e */
    public void mo924e(Bundle bundle) {
        super.mo924e(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.f2123q0);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.f2124r0);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.f2125s0);
    }

    @Override // p000a.p006b.p049h.p057f.PreferenceDialogFragmentCompat
    /* renamed from: n */
    public void mo8878n(boolean z) {
        int i;
        ListPreference m8893q0 = m8893q0();
        if (!z || (i = this.f2123q0) < 0) {
            return;
        }
        String charSequence = this.f2125s0[i].toString();
        if (m8893q0.m7240a((Object) charSequence)) {
            m8893q0.m7258e(charSequence);
        }
    }

    /* renamed from: q0 */
    public final ListPreference m8893q0() {
        return (ListPreference) m8877o0();
    }
}
