package android.support.p067v7.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import p000a.p006b.p049h.p057f.C0399m;
import p000a.p006b.p049h.p057f.C0401o;
import p000a.p006b.p049h.p057f.PreferenceViewHolder;

/* renamed from: android.support.v7.preference.DropDownPreference */
/* loaded from: classes.dex */
public class DropDownPreference extends ListPreference {

    /* renamed from: Y */
    public final Context f3833Y;

    /* renamed from: Z */
    public final ArrayAdapter f3834Z;

    /* renamed from: a0 */
    public Spinner f3835a0;

    /* renamed from: b0 */
    public final AdapterView.OnItemSelectedListener f3836b0;

    /* renamed from: android.support.v7.preference.DropDownPreference$a */
    /* loaded from: classes.dex */
    public class C0655a implements AdapterView.OnItemSelectedListener {
        public C0655a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i >= 0) {
                String charSequence = DropDownPreference.this.m7262R()[i].toString();
                if (charSequence.equals(DropDownPreference.this.m7261S()) || !DropDownPreference.this.m7240a((Object) charSequence)) {
                    return;
                }
                DropDownPreference.this.m7258e(charSequence);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0399m.dropdownPreferenceStyle);
    }

    @Override // android.support.p067v7.preference.DialogPreference, android.support.p067v7.preference.Preference
    /* renamed from: B */
    public void mo7161B() {
        this.f3835a0.performClick();
    }

    /* renamed from: U */
    public ArrayAdapter m7269U() {
        return new ArrayAdapter(this.f3833Y, 17367049);
    }

    /* renamed from: V */
    public final void m7268V() {
        this.f3834Z.clear();
        if (m7264P() != null) {
            for (CharSequence charSequence : m7264P()) {
                this.f3834Z.add(charSequence.toString());
            }
        }
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: a */
    public void mo7167a(PreferenceViewHolder preferenceViewHolder) {
        this.f3835a0 = (Spinner) preferenceViewHolder.f4213a.findViewById(C0401o.spinner);
        this.f3835a0.setAdapter((SpinnerAdapter) this.f3834Z);
        this.f3835a0.setOnItemSelectedListener(this.f3836b0);
        this.f3835a0.setSelection(m7267f(m7261S()));
        super.mo7167a(preferenceViewHolder);
    }

    /* renamed from: f */
    public int m7267f(String str) {
        CharSequence[] m7262R = m7262R();
        if (str == null || m7262R == null) {
            return -1;
        }
        for (int length = m7262R.length - 1; length >= 0; length--) {
            if (m7262R[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: y */
    public void mo7198y() {
        super.mo7198y();
        this.f3834Z.notifyDataSetChanged();
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f3836b0 = new C0655a();
        this.f3833Y = context;
        this.f3834Z = m7269U();
        m7268V();
    }
}
