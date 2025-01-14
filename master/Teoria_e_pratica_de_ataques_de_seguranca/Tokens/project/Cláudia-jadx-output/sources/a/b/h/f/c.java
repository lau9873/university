package a.b.h.f;

import a.b.h.a.c;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.preference.ListPreference;
/* compiled from: ListPreferenceDialogFragmentCompat.java */
/* loaded from: classes.dex */
public class c extends f {
    public int q0;
    public CharSequence[] r0;
    public CharSequence[] s0;

    /* compiled from: ListPreferenceDialogFragmentCompat.java */
    /* loaded from: classes.dex */
    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            c cVar = c.this;
            cVar.q0 = i2;
            cVar.onClick(dialogInterface, -1);
            dialogInterface.dismiss();
        }
    }

    public static c b(String str) {
        c cVar = new c();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        cVar.m(bundle);
        return cVar;
    }

    @Override // a.b.h.f.f
    public void a(c.a aVar) {
        super.a(aVar);
        aVar.a(this.r0, this.q0, new a());
        aVar.b((CharSequence) null, (DialogInterface.OnClickListener) null);
    }

    @Override // a.b.h.f.f, a.b.g.a.f, android.support.v4.app.Fragment
    public void c(Bundle bundle) {
        super.c(bundle);
        if (bundle == null) {
            ListPreference q0 = q0();
            if (q0.P() != null && q0.R() != null) {
                this.q0 = q0.d(q0.S());
                this.r0 = q0.P();
                this.s0 = q0.R();
                return;
            }
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.q0 = bundle.getInt("ListPreferenceDialogFragment.index", 0);
        this.r0 = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
        this.s0 = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
    }

    @Override // a.b.h.f.f, a.b.g.a.f, android.support.v4.app.Fragment
    public void e(Bundle bundle) {
        super.e(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.q0);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.r0);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.s0);
    }

    @Override // a.b.h.f.f
    public void n(boolean z) {
        int i2;
        ListPreference q0 = q0();
        if (!z || (i2 = this.q0) < 0) {
            return;
        }
        String charSequence = this.s0[i2].toString();
        if (q0.a((Object) charSequence)) {
            q0.e(charSequence);
        }
    }

    public final ListPreference q0() {
        return (ListPreference) o0();
    }
}
