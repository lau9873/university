package p000a.p006b.p049h.p057f;

import android.os.Bundle;
import android.support.p067v7.preference.EditTextPreference;
import android.view.View;
import android.widget.EditText;

/* renamed from: a.b.h.f.b */
/* loaded from: classes.dex */
public class EditTextPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {

    /* renamed from: q0 */
    public EditText f2121q0;

    /* renamed from: r0 */
    public CharSequence f2122r0;

    /* renamed from: b */
    public static EditTextPreferenceDialogFragmentCompat m8896b(String str) {
        EditTextPreferenceDialogFragmentCompat editTextPreferenceDialogFragmentCompat = new EditTextPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        editTextPreferenceDialogFragmentCompat.m7457m(bundle);
        return editTextPreferenceDialogFragmentCompat;
    }

    @Override // p000a.p006b.p049h.p057f.PreferenceDialogFragmentCompat, p000a.p006b.p030g.p031a.DialogFragment, android.support.p065v4.app.Fragment
    /* renamed from: c */
    public void mo728c(Bundle bundle) {
        super.mo728c(bundle);
        if (bundle == null) {
            this.f2122r0 = m8895q0().m7266P();
        } else {
            this.f2122r0 = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    @Override // p000a.p006b.p049h.p057f.PreferenceDialogFragmentCompat, p000a.p006b.p030g.p031a.DialogFragment, android.support.p065v4.app.Fragment
    /* renamed from: e */
    public void mo924e(Bundle bundle) {
        super.mo924e(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.f2122r0);
    }

    @Override // p000a.p006b.p049h.p057f.PreferenceDialogFragmentCompat
    /* renamed from: n */
    public void mo8878n(boolean z) {
        if (z) {
            String obj = this.f2121q0.getText().toString();
            if (m8895q0().m7240a((Object) obj)) {
                m8895q0().m7265d(obj);
            }
        }
    }

    @Override // p000a.p006b.p049h.p057f.PreferenceDialogFragmentCompat
    /* renamed from: p0 */
    public boolean mo8876p0() {
        return true;
    }

    /* renamed from: q0 */
    public final EditTextPreference m8895q0() {
        return (EditTextPreference) m8877o0();
    }

    @Override // p000a.p006b.p049h.p057f.PreferenceDialogFragmentCompat
    /* renamed from: b */
    public void mo8879b(View view) {
        super.mo8879b(view);
        this.f2121q0 = (EditText) view.findViewById(16908291);
        this.f2121q0.requestFocus();
        EditText editText = this.f2121q0;
        if (editText != null) {
            editText.setText(this.f2122r0);
            EditText editText2 = this.f2121q0;
            editText2.setSelection(editText2.getText().length());
            return;
        }
        throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
    }
}
