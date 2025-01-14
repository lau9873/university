package android.support.v7.preference;

import a.b.h.f.l;
import a.b.h.f.m;
import a.b.h.f.o;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
/* loaded from: classes.dex */
public class DropDownPreference extends ListPreference {
    public final Context Y;
    public final ArrayAdapter Z;
    public Spinner a0;
    public final AdapterView.OnItemSelectedListener b0;

    /* loaded from: classes.dex */
    public class a implements AdapterView.OnItemSelectedListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
            if (i2 >= 0) {
                String charSequence = DropDownPreference.this.R()[i2].toString();
                if (charSequence.equals(DropDownPreference.this.S()) || !DropDownPreference.this.a((Object) charSequence)) {
                    return;
                }
                DropDownPreference.this.e(charSequence);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m.dropdownPreferenceStyle);
    }

    @Override // android.support.v7.preference.DialogPreference, android.support.v7.preference.Preference
    public void B() {
        this.a0.performClick();
    }

    public ArrayAdapter U() {
        return new ArrayAdapter(this.Y, 17367049);
    }

    public final void V() {
        this.Z.clear();
        if (P() != null) {
            for (CharSequence charSequence : P()) {
                this.Z.add(charSequence.toString());
            }
        }
    }

    @Override // android.support.v7.preference.Preference
    public void a(l lVar) {
        this.a0 = (Spinner) lVar.f2580a.findViewById(o.spinner);
        this.a0.setAdapter((SpinnerAdapter) this.Z);
        this.a0.setOnItemSelectedListener(this.b0);
        this.a0.setSelection(f(S()));
        super.a(lVar);
    }

    public int f(String str) {
        CharSequence[] R = R();
        if (str == null || R == null) {
            return -1;
        }
        for (int length = R.length - 1; length >= 0; length--) {
            if (R[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    @Override // android.support.v7.preference.Preference
    public void y() {
        super.y();
        this.Z.notifyDataSetChanged();
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.b0 = new a();
        this.Y = context;
        this.Z = U();
        V();
    }
}
