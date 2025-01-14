package android.support.v7.preference;

import a.b.h.f.l;
import a.b.h.f.m;
import a.b.h.f.o;
import a.b.h.f.s;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.preference.Preference;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
/* loaded from: classes.dex */
public class SeekBarPreference extends Preference {
    public int N;
    public int O;
    public int P;
    public int Q;
    public boolean R;
    public SeekBar S;
    public TextView T;
    public boolean U;
    public boolean V;
    public SeekBar.OnSeekBarChangeListener W;
    public View.OnKeyListener X;

    /* loaded from: classes.dex */
    public class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z) {
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if (seekBarPreference.R) {
                    return;
                }
                seekBarPreference.a(seekBar);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.R = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.R = false;
            int progress = seekBar.getProgress();
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if (progress + seekBarPreference.O != seekBarPreference.N) {
                seekBarPreference.a(seekBar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnKeyListener {
        public b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            if ((!SeekBarPreference.this.U && (i2 == 21 || i2 == 22)) || i2 == 23 || i2 == 66) {
                return false;
            }
            SeekBar seekBar = SeekBarPreference.this.S;
            if (seekBar == null) {
                Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
                return false;
            }
            return seekBar.onKeyDown(i2, keyEvent);
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.W = new a();
        this.X = new b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.SeekBarPreference, i2, i3);
        this.O = obtainStyledAttributes.getInt(s.SeekBarPreference_min, 0);
        g(obtainStyledAttributes.getInt(s.SeekBarPreference_android_max, 100));
        h(obtainStyledAttributes.getInt(s.SeekBarPreference_seekBarIncrement, 0));
        this.U = obtainStyledAttributes.getBoolean(s.SeekBarPreference_adjustable, true);
        this.V = obtainStyledAttributes.getBoolean(s.SeekBarPreference_showSeekBarValue, true);
        obtainStyledAttributes.recycle();
    }

    @Override // android.support.v7.preference.Preference
    public Parcelable D() {
        Parcelable D = super.D();
        if (v()) {
            return D;
        }
        c cVar = new c(D);
        cVar.f2449a = this.N;
        cVar.f2450b = this.O;
        cVar.f2451c = this.P;
        return cVar;
    }

    @Override // android.support.v7.preference.Preference
    public void a(l lVar) {
        super.a(lVar);
        lVar.f2580a.setOnKeyListener(this.X);
        this.S = (SeekBar) lVar.c(o.seekbar);
        this.T = (TextView) lVar.c(o.seekbar_value);
        if (this.V) {
            this.T.setVisibility(0);
        } else {
            this.T.setVisibility(8);
            this.T = null;
        }
        SeekBar seekBar = this.S;
        if (seekBar == null) {
            Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.W);
        this.S.setMax(this.P - this.O);
        int i2 = this.Q;
        if (i2 != 0) {
            this.S.setKeyProgressIncrement(i2);
        } else {
            this.Q = this.S.getKeyProgressIncrement();
        }
        this.S.setProgress(this.N - this.O);
        TextView textView = this.T;
        if (textView != null) {
            textView.setText(String.valueOf(this.N));
        }
        this.S.setEnabled(u());
    }

    @Override // android.support.v7.preference.Preference
    public void b(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        i(a(((Integer) obj).intValue()));
    }

    public final void g(int i2) {
        int i3 = this.O;
        if (i2 < i3) {
            i2 = i3;
        }
        if (i2 != this.P) {
            this.P = i2;
            y();
        }
    }

    public final void h(int i2) {
        if (i2 != this.Q) {
            this.Q = Math.min(this.P - this.O, Math.abs(i2));
            y();
        }
    }

    public void i(int i2) {
        a(i2, true);
    }

    /* loaded from: classes.dex */
    public static class c extends Preference.b {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public int f2449a;

        /* renamed from: b  reason: collision with root package name */
        public int f2450b;

        /* renamed from: c  reason: collision with root package name */
        public int f2451c;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.Creator<c> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public c[] newArray(int i2) {
                return new c[i2];
            }
        }

        public c(Parcel parcel) {
            super(parcel);
            this.f2449a = parcel.readInt();
            this.f2450b = parcel.readInt();
            this.f2451c = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f2449a);
            parcel.writeInt(this.f2450b);
            parcel.writeInt(this.f2451c);
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m.seekBarPreferenceStyle);
    }

    @Override // android.support.v7.preference.Preference
    public Object a(TypedArray typedArray, int i2) {
        return Integer.valueOf(typedArray.getInt(i2, 0));
    }

    public final void a(int i2, boolean z) {
        int i3 = this.O;
        if (i2 < i3) {
            i2 = i3;
        }
        int i4 = this.P;
        if (i2 > i4) {
            i2 = i4;
        }
        if (i2 != this.N) {
            this.N = i2;
            TextView textView = this.T;
            if (textView != null) {
                textView.setText(String.valueOf(this.N));
            }
            b(i2);
            if (z) {
                y();
            }
        }
    }

    public void a(SeekBar seekBar) {
        int progress = this.O + seekBar.getProgress();
        if (progress != this.N) {
            if (a(Integer.valueOf(progress))) {
                a(progress, false);
            } else {
                seekBar.setProgress(this.N - this.O);
            }
        }
    }

    @Override // android.support.v7.preference.Preference
    public void a(Parcelable parcelable) {
        if (!parcelable.getClass().equals(c.class)) {
            super.a(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.a(cVar.getSuperState());
        this.N = cVar.f2449a;
        this.O = cVar.f2450b;
        this.P = cVar.f2451c;
        y();
    }
}
