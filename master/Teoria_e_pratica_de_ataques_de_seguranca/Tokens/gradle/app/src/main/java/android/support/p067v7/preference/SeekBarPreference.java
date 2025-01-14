package android.support.p067v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p067v7.preference.Preference;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import p000a.p006b.p049h.p057f.C0399m;
import p000a.p006b.p049h.p057f.C0401o;
import p000a.p006b.p049h.p057f.C0405s;
import p000a.p006b.p049h.p057f.PreferenceViewHolder;

/* renamed from: android.support.v7.preference.SeekBarPreference */
/* loaded from: classes.dex */
public class SeekBarPreference extends Preference {

    /* renamed from: N */
    public int f3895N;

    /* renamed from: O */
    public int f3896O;

    /* renamed from: P */
    public int f3897P;

    /* renamed from: Q */
    public int f3898Q;

    /* renamed from: R */
    public boolean f3899R;

    /* renamed from: S */
    public SeekBar f3900S;

    /* renamed from: T */
    public TextView f3901T;

    /* renamed from: U */
    public boolean f3902U;

    /* renamed from: V */
    public boolean f3903V;

    /* renamed from: W */
    public SeekBar.OnSeekBarChangeListener f3904W;

    /* renamed from: X */
    public View.OnKeyListener f3905X;

    /* renamed from: android.support.v7.preference.SeekBarPreference$a */
    /* loaded from: classes.dex */
    public class C0671a implements SeekBar.OnSeekBarChangeListener {
        public C0671a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if (seekBarPreference.f3899R) {
                    return;
                }
                seekBarPreference.m7171a(seekBar);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.f3899R = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.f3899R = false;
            int progress = seekBar.getProgress();
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if (progress + seekBarPreference.f3896O != seekBarPreference.f3895N) {
                seekBarPreference.m7171a(seekBar);
            }
        }
    }

    /* renamed from: android.support.v7.preference.SeekBarPreference$b */
    /* loaded from: classes.dex */
    public class View$OnKeyListenerC0672b implements View.OnKeyListener {
        public View$OnKeyListenerC0672b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            if ((!SeekBarPreference.this.f3902U && (i == 21 || i == 22)) || i == 23 || i == 66) {
                return false;
            }
            SeekBar seekBar = SeekBarPreference.this.f3900S;
            if (seekBar == null) {
                Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
                return false;
            }
            return seekBar.onKeyDown(i, keyEvent);
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f3904W = new C0671a();
        this.f3905X = new View$OnKeyListenerC0672b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0405s.SeekBarPreference, i, i2);
        this.f3896O = obtainStyledAttributes.getInt(C0405s.SeekBarPreference_min, 0);
        m7170g(obtainStyledAttributes.getInt(C0405s.SeekBarPreference_android_max, 100));
        m7169h(obtainStyledAttributes.getInt(C0405s.SeekBarPreference_seekBarIncrement, 0));
        this.f3902U = obtainStyledAttributes.getBoolean(C0405s.SeekBarPreference_adjustable, true);
        this.f3903V = obtainStyledAttributes.getBoolean(C0405s.SeekBarPreference_showSeekBarValue, true);
        obtainStyledAttributes.recycle();
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: D */
    public Parcelable mo7160D() {
        Parcelable mo7160D = super.mo7160D();
        if (m7201v()) {
            return mo7160D;
        }
        C0673c c0673c = new C0673c(mo7160D);
        c0673c.f3908a = this.f3895N;
        c0673c.f3909b = this.f3896O;
        c0673c.f3910c = this.f3897P;
        return c0673c;
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: a */
    public void mo7167a(PreferenceViewHolder preferenceViewHolder) {
        super.mo7167a(preferenceViewHolder);
        preferenceViewHolder.f4213a.setOnKeyListener(this.f3905X);
        this.f3900S = (SeekBar) preferenceViewHolder.m8808c(C0401o.seekbar);
        this.f3901T = (TextView) preferenceViewHolder.m8808c(C0401o.seekbar_value);
        if (this.f3903V) {
            this.f3901T.setVisibility(0);
        } else {
            this.f3901T.setVisibility(8);
            this.f3901T = null;
        }
        SeekBar seekBar = this.f3900S;
        if (seekBar == null) {
            Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.f3904W);
        this.f3900S.setMax(this.f3897P - this.f3896O);
        int i = this.f3898Q;
        if (i != 0) {
            this.f3900S.setKeyProgressIncrement(i);
        } else {
            this.f3898Q = this.f3900S.getKeyProgressIncrement();
        }
        this.f3900S.setProgress(this.f3895N - this.f3896O);
        TextView textView = this.f3901T;
        if (textView != null) {
            textView.setText(String.valueOf(this.f3895N));
        }
        this.f3900S.setEnabled(mo7192u());
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: b */
    public void mo7153b(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        m7168i(m7253a(((Integer) obj).intValue()));
    }

    /* renamed from: g */
    public final void m7170g(int i) {
        int i2 = this.f3896O;
        if (i < i2) {
            i = i2;
        }
        if (i != this.f3897P) {
            this.f3897P = i;
            mo7198y();
        }
    }

    /* renamed from: h */
    public final void m7169h(int i) {
        if (i != this.f3898Q) {
            this.f3898Q = Math.min(this.f3897P - this.f3896O, Math.abs(i));
            mo7198y();
        }
    }

    /* renamed from: i */
    public void m7168i(int i) {
        m7172a(i, true);
    }

    /* renamed from: android.support.v7.preference.SeekBarPreference$c */
    /* loaded from: classes.dex */
    public static class C0673c extends Preference.C0661b {
        public static final Parcelable.Creator<C0673c> CREATOR = new C0674a();

        /* renamed from: a */
        public int f3908a;

        /* renamed from: b */
        public int f3909b;

        /* renamed from: c */
        public int f3910c;

        /* renamed from: android.support.v7.preference.SeekBarPreference$c$a */
        /* loaded from: classes.dex */
        public static class C0674a implements Parcelable.Creator<C0673c> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public C0673c createFromParcel(Parcel parcel) {
                return new C0673c(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public C0673c[] newArray(int i) {
                return new C0673c[i];
            }
        }

        public C0673c(Parcel parcel) {
            super(parcel);
            this.f3908a = parcel.readInt();
            this.f3909b = parcel.readInt();
            this.f3910c = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3908a);
            parcel.writeInt(this.f3909b);
            parcel.writeInt(this.f3910c);
        }

        public C0673c(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0399m.seekBarPreferenceStyle);
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: a */
    public Object mo7157a(TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInt(i, 0));
    }

    /* renamed from: a */
    public final void m7172a(int i, boolean z) {
        int i2 = this.f3896O;
        if (i < i2) {
            i = i2;
        }
        int i3 = this.f3897P;
        if (i > i3) {
            i = i3;
        }
        if (i != this.f3895N) {
            this.f3895N = i;
            TextView textView = this.f3901T;
            if (textView != null) {
                textView.setText(String.valueOf(this.f3895N));
            }
            m7234b(i);
            if (z) {
                mo7198y();
            }
        }
    }

    /* renamed from: a */
    public void m7171a(SeekBar seekBar) {
        int progress = this.f3896O + seekBar.getProgress();
        if (progress != this.f3895N) {
            if (m7240a(Integer.valueOf(progress))) {
                m7172a(progress, false);
            } else {
                seekBar.setProgress(this.f3895N - this.f3896O);
            }
        }
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: a */
    public void mo7156a(Parcelable parcelable) {
        if (!parcelable.getClass().equals(C0673c.class)) {
            super.mo7156a(parcelable);
            return;
        }
        C0673c c0673c = (C0673c) parcelable;
        super.mo7156a(c0673c.getSuperState());
        this.f3895N = c0673c.f3908a;
        this.f3896O = c0673c.f3909b;
        this.f3897P = c0673c.f3910c;
        mo7198y();
    }
}
