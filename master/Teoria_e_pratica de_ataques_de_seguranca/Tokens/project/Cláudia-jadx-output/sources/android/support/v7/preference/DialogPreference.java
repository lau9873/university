package android.support.v7.preference;

import a.b.g.b.g.g;
import a.b.h.f.m;
import a.b.h.f.s;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public abstract class DialogPreference extends Preference {
    public CharSequence N;
    public CharSequence O;
    public Drawable P;
    public CharSequence Q;
    public CharSequence R;
    public int S;

    /* loaded from: classes.dex */
    public interface a {
        Preference a(CharSequence charSequence);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.DialogPreference, i2, i3);
        this.N = g.b(obtainStyledAttributes, s.DialogPreference_dialogTitle, s.DialogPreference_android_dialogTitle);
        if (this.N == null) {
            this.N = r();
        }
        this.O = g.b(obtainStyledAttributes, s.DialogPreference_dialogMessage, s.DialogPreference_android_dialogMessage);
        this.P = g.a(obtainStyledAttributes, s.DialogPreference_dialogIcon, s.DialogPreference_android_dialogIcon);
        this.Q = g.b(obtainStyledAttributes, s.DialogPreference_positiveButtonText, s.DialogPreference_android_positiveButtonText);
        this.R = g.b(obtainStyledAttributes, s.DialogPreference_negativeButtonText, s.DialogPreference_android_negativeButtonText);
        this.S = g.b(obtainStyledAttributes, s.DialogPreference_dialogLayout, s.DialogPreference_android_dialogLayout, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.support.v7.preference.Preference
    public void B() {
        o().a(this);
    }

    public Drawable J() {
        return this.P;
    }

    public int K() {
        return this.S;
    }

    public CharSequence L() {
        return this.O;
    }

    public CharSequence M() {
        return this.N;
    }

    public CharSequence N() {
        return this.R;
    }

    public CharSequence O() {
        return this.Q;
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a(context, m.dialogPreferenceStyle, 16842897));
    }
}
