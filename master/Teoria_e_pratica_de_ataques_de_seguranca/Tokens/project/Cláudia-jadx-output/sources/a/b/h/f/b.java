package a.b.h.f;

import android.os.Bundle;
import android.support.v7.preference.EditTextPreference;
import android.view.View;
import android.widget.EditText;
/* compiled from: EditTextPreferenceDialogFragmentCompat.java */
/* loaded from: classes.dex */
public class b extends f {
    public EditText q0;
    public CharSequence r0;

    public static b b(String str) {
        b bVar = new b();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        bVar.m(bundle);
        return bVar;
    }

    @Override // a.b.h.f.f, a.b.g.a.f, android.support.v4.app.Fragment
    public void c(Bundle bundle) {
        super.c(bundle);
        if (bundle == null) {
            this.r0 = q0().P();
        } else {
            this.r0 = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    @Override // a.b.h.f.f, a.b.g.a.f, android.support.v4.app.Fragment
    public void e(Bundle bundle) {
        super.e(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.r0);
    }

    @Override // a.b.h.f.f
    public void n(boolean z) {
        if (z) {
            String obj = this.q0.getText().toString();
            if (q0().a((Object) obj)) {
                q0().d(obj);
            }
        }
    }

    @Override // a.b.h.f.f
    public boolean p0() {
        return true;
    }

    public final EditTextPreference q0() {
        return (EditTextPreference) o0();
    }

    @Override // a.b.h.f.f
    public void b(View view) {
        super.b(view);
        this.q0 = (EditText) view.findViewById(16908291);
        this.q0.requestFocus();
        EditText editText = this.q0;
        if (editText != null) {
            editText.setText(this.r0);
            EditText editText2 = this.q0;
            editText2.setSelection(editText2.getText().length());
            return;
        }
        throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
    }
}
