package android.support.p067v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import p000a.p006b.p030g.p032b.p033g.TypedArrayUtils;
import p000a.p006b.p049h.p057f.C0399m;
import p000a.p006b.p049h.p057f.C0405s;

/* renamed from: android.support.v7.preference.DialogPreference */
/* loaded from: classes.dex */
public abstract class DialogPreference extends Preference {

    /* renamed from: N */
    public CharSequence f3827N;

    /* renamed from: O */
    public CharSequence f3828O;

    /* renamed from: P */
    public Drawable f3829P;

    /* renamed from: Q */
    public CharSequence f3830Q;

    /* renamed from: R */
    public CharSequence f3831R;

    /* renamed from: S */
    public int f3832S;

    /* renamed from: android.support.v7.preference.DialogPreference$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0654a {
        /* renamed from: a */
        Preference mo7270a(CharSequence charSequence);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0405s.DialogPreference, i, i2);
        this.f3827N = TypedArrayUtils.m9935b(obtainStyledAttributes, C0405s.DialogPreference_dialogTitle, C0405s.DialogPreference_android_dialogTitle);
        if (this.f3827N == null) {
            this.f3827N = m7204r();
        }
        this.f3828O = TypedArrayUtils.m9935b(obtainStyledAttributes, C0405s.DialogPreference_dialogMessage, C0405s.DialogPreference_android_dialogMessage);
        this.f3829P = TypedArrayUtils.m9944a(obtainStyledAttributes, C0405s.DialogPreference_dialogIcon, C0405s.DialogPreference_android_dialogIcon);
        this.f3830Q = TypedArrayUtils.m9935b(obtainStyledAttributes, C0405s.DialogPreference_positiveButtonText, C0405s.DialogPreference_android_positiveButtonText);
        this.f3831R = TypedArrayUtils.m9935b(obtainStyledAttributes, C0405s.DialogPreference_negativeButtonText, C0405s.DialogPreference_android_negativeButtonText);
        this.f3832S = TypedArrayUtils.m9934b(obtainStyledAttributes, C0405s.DialogPreference_dialogLayout, C0405s.DialogPreference_android_dialogLayout, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: B */
    public void mo7161B() {
        m7207o().m8829a(this);
    }

    /* renamed from: J */
    public Drawable m7276J() {
        return this.f3829P;
    }

    /* renamed from: K */
    public int m7275K() {
        return this.f3832S;
    }

    /* renamed from: L */
    public CharSequence m7274L() {
        return this.f3828O;
    }

    /* renamed from: M */
    public CharSequence m7273M() {
        return this.f3827N;
    }

    /* renamed from: N */
    public CharSequence m7272N() {
        return this.f3831R;
    }

    /* renamed from: O */
    public CharSequence m7271O() {
        return this.f3830Q;
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.m9946a(context, C0399m.dialogPreferenceStyle, 16842897));
    }
}
