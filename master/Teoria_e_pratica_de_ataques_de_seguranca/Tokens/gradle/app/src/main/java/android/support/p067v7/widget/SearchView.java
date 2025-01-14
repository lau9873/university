package android.support.p067v7.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import p000a.p006b.p030g.p045k.AbsSavedState;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p030g.p048l.CursorAdapter;
import p000a.p006b.p049h.p051b.C0354a;
import p000a.p006b.p049h.p051b.C0357d;
import p000a.p006b.p049h.p051b.C0359f;
import p000a.p006b.p049h.p051b.C0360g;
import p000a.p006b.p049h.p051b.C0361h;
import p000a.p006b.p049h.p051b.C0363j;
import p000a.p006b.p049h.p061j.CollapsibleActionView;
import p000a.p006b.p049h.p063k.AppCompatAutoCompleteTextView;
import p000a.p006b.p049h.p063k.C0504t1;
import p000a.p006b.p049h.p063k.LinearLayoutCompat;
import p000a.p006b.p049h.p063k.SuggestionsAdapter;
import p000a.p006b.p049h.p063k.TintTypedArray;
import p000a.p006b.p049h.p063k.TooltipCompat;

/* renamed from: android.support.v7.widget.SearchView */
/* loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {

    /* renamed from: r0 */
    public static final C0752k f4289r0 = new C0752k();

    /* renamed from: A */
    public Rect f4290A;

    /* renamed from: B */
    public Rect f4291B;

    /* renamed from: C */
    public int[] f4292C;

    /* renamed from: D */
    public int[] f4293D;

    /* renamed from: E */
    public final ImageView f4294E;

    /* renamed from: F */
    public final Drawable f4295F;

    /* renamed from: G */
    public final int f4296G;

    /* renamed from: H */
    public final int f4297H;

    /* renamed from: I */
    public final Intent f4298I;

    /* renamed from: J */
    public final Intent f4299J;

    /* renamed from: K */
    public final CharSequence f4300K;

    /* renamed from: L */
    public InterfaceC0754m f4301L;

    /* renamed from: M */
    public InterfaceC0753l f4302M;

    /* renamed from: N */
    public View.OnFocusChangeListener f4303N;

    /* renamed from: O */
    public InterfaceC0755n f4304O;

    /* renamed from: P */
    public View.OnClickListener f4305P;

    /* renamed from: Q */
    public boolean f4306Q;

    /* renamed from: R */
    public boolean f4307R;

    /* renamed from: S */
    public CursorAdapter f4308S;

    /* renamed from: T */
    public boolean f4309T;

    /* renamed from: U */
    public CharSequence f4310U;

    /* renamed from: V */
    public boolean f4311V;

    /* renamed from: W */
    public boolean f4312W;

    /* renamed from: a0 */
    public int f4313a0;

    /* renamed from: b0 */
    public boolean f4314b0;

    /* renamed from: c0 */
    public CharSequence f4315c0;

    /* renamed from: d0 */
    public CharSequence f4316d0;

    /* renamed from: e0 */
    public boolean f4317e0;

    /* renamed from: f0 */
    public int f4318f0;

    /* renamed from: g0 */
    public SearchableInfo f4319g0;

    /* renamed from: h0 */
    public Bundle f4320h0;

    /* renamed from: i0 */
    public final Runnable f4321i0;

    /* renamed from: j0 */
    public Runnable f4322j0;

    /* renamed from: k0 */
    public final WeakHashMap<String, Drawable.ConstantState> f4323k0;

    /* renamed from: l0 */
    public final View.OnClickListener f4324l0;

    /* renamed from: m0 */
    public View.OnKeyListener f4325m0;

    /* renamed from: n0 */
    public final TextView.OnEditorActionListener f4326n0;

    /* renamed from: o0 */
    public final AdapterView.OnItemClickListener f4327o0;

    /* renamed from: p0 */
    public final AdapterView.OnItemSelectedListener f4328p0;

    /* renamed from: q */
    public final SearchAutoComplete f4329q;

    /* renamed from: q0 */
    public TextWatcher f4330q0;

    /* renamed from: r */
    public final View f4331r;

    /* renamed from: s */
    public final View f4332s;

    /* renamed from: t */
    public final View f4333t;

    /* renamed from: u */
    public final ImageView f4334u;

    /* renamed from: v */
    public final ImageView f4335v;

    /* renamed from: w */
    public final ImageView f4336w;

    /* renamed from: x */
    public final ImageView f4337x;

    /* renamed from: y */
    public final View f4338y;

    /* renamed from: z */
    public C0758p f4339z;

    /* renamed from: android.support.v7.widget.SearchView$SearchAutoComplete */
    /* loaded from: classes.dex */
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* renamed from: d */
        public int f4340d;

        /* renamed from: e */
        public SearchView f4341e;

        /* renamed from: f */
        public boolean f4342f;

        /* renamed from: g */
        public final Runnable f4343g;

        /* renamed from: android.support.v7.widget.SearchView$SearchAutoComplete$a */
        /* loaded from: classes.dex */
        public class RunnableC0741a implements Runnable {
            public RunnableC0741a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.m6488b();
            }
        }

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i < 960 || i2 < 720 || configuration.orientation != 2) {
                if (i < 600) {
                    return (i < 640 || i2 < 480) ? 160 : 192;
                }
                return 192;
            }
            return 256;
        }

        /* renamed from: a */
        public boolean m6489a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        /* renamed from: b */
        public void m6488b() {
            if (this.f4342f) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f4342f = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f4340d <= 0 || super.enoughToFilter();
        }

        @Override // p000a.p006b.p049h.p063k.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f4342f) {
                removeCallbacks(this.f4343g);
                post(this.f4343g);
            }
            return onCreateInputConnection;
        }

        @Override // android.view.View
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f4341e.m6497m();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f4341e.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f4341e.hasFocus() && getVisibility() == 0) {
                this.f4342f = true;
                if (SearchView.m6526a(getContext())) {
                    SearchView.f4289r0.m6486a(this, true);
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.f4342f = false;
                removeCallbacks(this.f4343g);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.f4342f = false;
                removeCallbacks(this.f4343g);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.f4342f = true;
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f4341e = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f4340d = i;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, C0354a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f4343g = new RunnableC0741a();
            this.f4340d = getThreshold();
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$a */
    /* loaded from: classes.dex */
    public class C0742a implements TextWatcher {
        public C0742a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SearchView.this.m6510c(charSequence);
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$b */
    /* loaded from: classes.dex */
    public class RunnableC0743b implements Runnable {
        public RunnableC0743b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.m6493q();
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$c */
    /* loaded from: classes.dex */
    public class RunnableC0744c implements Runnable {
        public RunnableC0744c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CursorAdapter cursorAdapter = SearchView.this.f4308S;
            if (cursorAdapter == null || !(cursorAdapter instanceof SuggestionsAdapter)) {
                return;
            }
            cursorAdapter.mo8396a((Cursor) null);
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$d */
    /* loaded from: classes.dex */
    public class View$OnFocusChangeListenerC0745d implements View.OnFocusChangeListener {
        public View$OnFocusChangeListenerC0745d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.f4303N;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z);
            }
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$e */
    /* loaded from: classes.dex */
    public class View$OnLayoutChangeListenerC0746e implements View.OnLayoutChangeListener {
        public View$OnLayoutChangeListenerC0746e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            SearchView.this.m6508d();
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$f */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0747f implements View.OnClickListener {
        public View$OnClickListenerC0747f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f4334u) {
                searchView.m6499k();
            } else if (view == searchView.f4336w) {
                searchView.m6500j();
            } else if (view == searchView.f4335v) {
                searchView.m6498l();
            } else if (view == searchView.f4337x) {
                searchView.m6496n();
            } else if (view == searchView.f4329q) {
                searchView.m6504f();
            }
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$g */
    /* loaded from: classes.dex */
    public class View$OnKeyListenerC0748g implements View.OnKeyListener {
        public View$OnKeyListenerC0748g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.f4319g0 == null) {
                return false;
            }
            if (searchView.f4329q.isPopupShowing() && SearchView.this.f4329q.getListSelection() != -1) {
                return SearchView.this.m6522a(view, i, keyEvent);
            }
            if (!SearchView.this.f4329q.m6489a() && keyEvent.hasNoModifiers() && keyEvent.getAction() == 1 && i == 66) {
                view.cancelLongPress();
                SearchView searchView2 = SearchView.this;
                searchView2.m6527a(0, (String) null, searchView2.f4329q.getText().toString());
                return true;
            }
            return false;
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$h */
    /* loaded from: classes.dex */
    public class C0749h implements TextView.OnEditorActionListener {
        public C0749h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            SearchView.this.m6498l();
            return true;
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$i */
    /* loaded from: classes.dex */
    public class C0750i implements AdapterView.OnItemClickListener {
        public C0750i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            SearchView.this.m6515b(i, 0, null);
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$j */
    /* loaded from: classes.dex */
    public class C0751j implements AdapterView.OnItemSelectedListener {
        public C0751j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            SearchView.this.m6507d(i);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$l */
    /* loaded from: classes.dex */
    public interface InterfaceC0753l {
        /* renamed from: a */
        boolean m6484a();
    }

    /* renamed from: android.support.v7.widget.SearchView$m */
    /* loaded from: classes.dex */
    public interface InterfaceC0754m {
        /* renamed from: a */
        boolean m6483a(String str);

        /* renamed from: b */
        boolean m6482b(String str);
    }

    /* renamed from: android.support.v7.widget.SearchView$n */
    /* loaded from: classes.dex */
    public interface InterfaceC0755n {
        /* renamed from: a */
        boolean m6481a(int i);

        /* renamed from: b */
        boolean m6480b(int i);
    }

    /* renamed from: android.support.v7.widget.SearchView$o */
    /* loaded from: classes.dex */
    public static class C0756o extends AbsSavedState {
        public static final Parcelable.Creator<C0756o> CREATOR = new C0757a();

        /* renamed from: c */
        public boolean f4358c;

        /* renamed from: android.support.v7.widget.SearchView$o$a */
        /* loaded from: classes.dex */
        public static class C0757a implements Parcelable.ClassLoaderCreator<C0756o> {
            @Override // android.os.Parcelable.Creator
            public C0756o[] newArray(int i) {
                return new C0756o[i];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public C0756o createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0756o(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public C0756o createFromParcel(Parcel parcel) {
                return new C0756o(parcel, null);
            }
        }

        public C0756o(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f4358c + "}";
        }

        @Override // p000a.p006b.p030g.p045k.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f4358c));
        }

        public C0756o(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f4358c = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$p */
    /* loaded from: classes.dex */
    public static class C0758p extends TouchDelegate {

        /* renamed from: a */
        public final View f4359a;

        /* renamed from: b */
        public final Rect f4360b;

        /* renamed from: c */
        public final Rect f4361c;

        /* renamed from: d */
        public final Rect f4362d;

        /* renamed from: e */
        public final int f4363e;

        /* renamed from: f */
        public boolean f4364f;

        public C0758p(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f4363e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f4360b = new Rect();
            this.f4362d = new Rect();
            this.f4361c = new Rect();
            m6479a(rect, rect2);
            this.f4359a = view;
        }

        /* renamed from: a */
        public void m6479a(Rect rect, Rect rect2) {
            this.f4360b.set(rect);
            this.f4362d.set(rect);
            Rect rect3 = this.f4362d;
            int i = this.f4363e;
            rect3.inset(-i, -i);
            this.f4361c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z2 = true;
            if (action == 0) {
                if (this.f4360b.contains(x, y)) {
                    this.f4364f = true;
                    z = true;
                }
                z = false;
            } else if (action == 1 || action == 2) {
                z = this.f4364f;
                if (z && !this.f4362d.contains(x, y)) {
                    z2 = false;
                }
            } else {
                if (action == 3) {
                    z = this.f4364f;
                    this.f4364f = false;
                }
                z = false;
            }
            if (z) {
                if (z2 && !this.f4361c.contains(x, y)) {
                    motionEvent.setLocation(this.f4359a.getWidth() / 2, this.f4359a.getHeight() / 2);
                } else {
                    Rect rect = this.f4361c;
                    motionEvent.setLocation(x - rect.left, y - rect.top);
                }
                return this.f4359a.dispatchTouchEvent(motionEvent);
            }
            return false;
        }
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(C0357d.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(C0357d.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence charSequence) {
        this.f4329q.setText(charSequence);
        this.f4329q.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    /* renamed from: a */
    public void m6519a(CharSequence charSequence, boolean z) {
        this.f4329q.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f4329q;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f4316d0 = charSequence;
        }
        if (!z || TextUtils.isEmpty(charSequence)) {
            return;
        }
        m6498l();
    }

    /* renamed from: b */
    public final void m6512b(boolean z) {
        this.f4307R = z;
        int i = 0;
        int i2 = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.f4329q.getText());
        this.f4334u.setVisibility(i2);
        m6517a(z2);
        this.f4331r.setVisibility(z ? 8 : 0);
        this.f4294E.setVisibility((this.f4294E.getDrawable() == null || this.f4306Q) ? 8 : 8);
        m6494p();
        m6509c(!z2);
        m6490t();
    }

    /* renamed from: c */
    public final void m6509c(boolean z) {
        int i;
        if (this.f4314b0 && !m6502h() && z) {
            i = 0;
            this.f4335v.setVisibility(8);
        } else {
            i = 8;
        }
        this.f4337x.setVisibility(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.f4312W = true;
        super.clearFocus();
        this.f4329q.clearFocus();
        this.f4329q.setImeVisibility(false);
        this.f4312W = false;
    }

    /* renamed from: d */
    public void m6508d() {
        int i;
        if (this.f4338y.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f4332s.getPaddingLeft();
            Rect rect = new Rect();
            boolean m8047a = C0504t1.m8047a(this);
            int dimensionPixelSize = this.f4306Q ? resources.getDimensionPixelSize(C0357d.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(C0357d.abc_dropdownitem_text_padding_left) : 0;
            this.f4329q.getDropDownBackground().getPadding(rect);
            if (m8047a) {
                i = -rect.left;
            } else {
                i = paddingLeft - (rect.left + dimensionPixelSize);
            }
            this.f4329q.setDropDownHorizontalOffset(i);
            this.f4329q.setDropDownWidth((((this.f4338y.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    /* renamed from: e */
    public final void m6506e() {
        this.f4329q.dismissDropDown();
    }

    /* renamed from: f */
    public void m6504f() {
        f4289r0.m6485b(this.f4329q);
        f4289r0.m6487a(this.f4329q);
    }

    /* renamed from: g */
    public final boolean m6503g() {
        SearchableInfo searchableInfo = this.f4319g0;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f4319g0.getVoiceSearchLaunchWebSearch()) {
            intent = this.f4298I;
        } else if (this.f4319g0.getVoiceSearchLaunchRecognizer()) {
            intent = this.f4299J;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    public int getImeOptions() {
        return this.f4329q.getImeOptions();
    }

    public int getInputType() {
        return this.f4329q.getInputType();
    }

    public int getMaxWidth() {
        return this.f4313a0;
    }

    public CharSequence getQuery() {
        return this.f4329q.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f4310U;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f4319g0;
        if (searchableInfo != null && searchableInfo.getHintId() != 0) {
            return getContext().getText(this.f4319g0.getHintId());
        }
        return this.f4300K;
    }

    public int getSuggestionCommitIconResId() {
        return this.f4297H;
    }

    public int getSuggestionRowLayout() {
        return this.f4296G;
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.f4308S;
    }

    /* renamed from: h */
    public boolean m6502h() {
        return this.f4307R;
    }

    /* renamed from: i */
    public final boolean m6501i() {
        return (this.f4309T || this.f4314b0) && !m6502h();
    }

    /* renamed from: j */
    public void m6500j() {
        if (TextUtils.isEmpty(this.f4329q.getText())) {
            if (this.f4306Q) {
                InterfaceC0753l interfaceC0753l = this.f4302M;
                if (interfaceC0753l == null || !interfaceC0753l.m6484a()) {
                    clearFocus();
                    m6512b(true);
                    return;
                }
                return;
            }
            return;
        }
        this.f4329q.setText("");
        this.f4329q.requestFocus();
        this.f4329q.setImeVisibility(true);
    }

    /* renamed from: k */
    public void m6499k() {
        m6512b(false);
        this.f4329q.requestFocus();
        this.f4329q.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f4305P;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    /* renamed from: l */
    public void m6498l() {
        Editable text = this.f4329q.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        InterfaceC0754m interfaceC0754m = this.f4301L;
        if (interfaceC0754m == null || !interfaceC0754m.m6482b(text.toString())) {
            if (this.f4319g0 != null) {
                m6527a(0, (String) null, text.toString());
            }
            this.f4329q.setImeVisibility(false);
            m6506e();
        }
    }

    /* renamed from: m */
    public void m6497m() {
        m6512b(m6502h());
        m6495o();
        if (this.f4329q.hasFocus()) {
            m6504f();
        }
    }

    /* renamed from: n */
    public void m6496n() {
        SearchableInfo searchableInfo = this.f4319g0;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(m6514b(this.f4298I, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(m6524a(this.f4299J, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    /* renamed from: o */
    public final void m6495o() {
        post(this.f4321i0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f4321i0);
        post(this.f4322j0);
        super.onDetachedFromWindow();
    }

    @Override // p000a.p006b.p049h.p063k.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            m6521a(this.f4329q, this.f4290A);
            Rect rect = this.f4291B;
            Rect rect2 = this.f4290A;
            rect.set(rect2.left, 0, rect2.right, i4 - i2);
            C0758p c0758p = this.f4339z;
            if (c0758p == null) {
                this.f4339z = new C0758p(this.f4291B, this.f4290A, this.f4329q);
                setTouchDelegate(this.f4339z);
                return;
            }
            c0758p.m6479a(this.f4291B, this.f4290A);
        }
    }

    @Override // p000a.p006b.p049h.p063k.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        if (m6502h()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            int i4 = this.f4313a0;
            size = i4 > 0 ? Math.min(i4, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f4313a0;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i3 = this.f4313a0) > 0) {
            size = Math.min(i3, size);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0756o)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0756o c0756o = (C0756o) parcelable;
        super.onRestoreInstanceState(c0756o.m9588a());
        m6512b(c0756o.f4358c);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        C0756o c0756o = new C0756o(super.onSaveInstanceState());
        c0756o.f4358c = m6502h();
        return c0756o;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m6495o();
    }

    /* renamed from: p */
    public final void m6494p() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f4329q.getText());
        if (!z2 && (!this.f4306Q || this.f4317e0)) {
            z = false;
        }
        this.f4336w.setVisibility(z ? 0 : 8);
        Drawable drawable = this.f4336w.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    /* renamed from: q */
    public void m6493q() {
        int[] iArr = this.f4329q.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f4332s.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f4333t.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    /* renamed from: r */
    public final void m6492r() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f4329q;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(m6520a(queryHint));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i, Rect rect) {
        if (!this.f4312W && isFocusable()) {
            if (!m6502h()) {
                boolean requestFocus = this.f4329q.requestFocus(i, rect);
                if (requestFocus) {
                    m6512b(false);
                }
                return requestFocus;
            }
            return super.requestFocus(i, rect);
        }
        return false;
    }

    /* renamed from: s */
    public final void m6491s() {
        this.f4329q.setThreshold(this.f4319g0.getSuggestThreshold());
        this.f4329q.setImeOptions(this.f4319g0.getImeOptions());
        int inputType = this.f4319g0.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f4319g0.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.f4329q.setInputType(inputType);
        CursorAdapter cursorAdapter = this.f4308S;
        if (cursorAdapter != null) {
            cursorAdapter.mo8396a((Cursor) null);
        }
        if (this.f4319g0.getSuggestAuthority() != null) {
            this.f4308S = new SuggestionsAdapter(getContext(), this, this.f4319g0, this.f4323k0);
            this.f4329q.setAdapter(this.f4308S);
            ((SuggestionsAdapter) this.f4308S).m8399a(this.f4311V ? 2 : 1);
        }
    }

    public void setAppSearchData(Bundle bundle) {
        this.f4320h0 = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            m6500j();
        } else {
            m6499k();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f4306Q == z) {
            return;
        }
        this.f4306Q = z;
        m6512b(z);
        m6492r();
    }

    public void setImeOptions(int i) {
        this.f4329q.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.f4329q.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.f4313a0 = i;
        requestLayout();
    }

    public void setOnCloseListener(InterfaceC0753l interfaceC0753l) {
        this.f4302M = interfaceC0753l;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f4303N = onFocusChangeListener;
    }

    public void setOnQueryTextListener(InterfaceC0754m interfaceC0754m) {
        this.f4301L = interfaceC0754m;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f4305P = onClickListener;
    }

    public void setOnSuggestionListener(InterfaceC0755n interfaceC0755n) {
        this.f4304O = interfaceC0755n;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f4310U = charSequence;
        m6492r();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.f4311V = z;
        CursorAdapter cursorAdapter = this.f4308S;
        if (cursorAdapter instanceof SuggestionsAdapter) {
            ((SuggestionsAdapter) cursorAdapter).m8399a(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f4319g0 = searchableInfo;
        if (this.f4319g0 != null) {
            m6491s();
            m6492r();
        }
        this.f4314b0 = m6503g();
        if (this.f4314b0) {
            this.f4329q.setPrivateImeOptions("nm");
        }
        m6512b(m6502h());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f4309T = z;
        m6512b(m6502h());
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.f4308S = cursorAdapter;
        this.f4329q.setAdapter(this.f4308S);
    }

    /* renamed from: t */
    public final void m6490t() {
        this.f4333t.setVisibility((m6501i() && (this.f4335v.getVisibility() == 0 || this.f4337x.getVisibility() == 0)) ? 0 : 8);
    }

    /* renamed from: android.support.v7.widget.SearchView$k */
    /* loaded from: classes.dex */
    public static class C0752k {

        /* renamed from: a */
        public Method f4355a;

        /* renamed from: b */
        public Method f4356b;

        /* renamed from: c */
        public Method f4357c;

        public C0752k() {
            try {
                this.f4355a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f4355a.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                this.f4356b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f4356b.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                this.f4357c = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f4357c.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        /* renamed from: a */
        public void m6487a(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f4356b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* renamed from: b */
        public void m6485b(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f4355a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* renamed from: a */
        public void m6486a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            Method method = this.f4357c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.valueOf(z));
                } catch (Exception unused) {
                }
            }
        }
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0354a.searchViewStyle);
    }

    /* renamed from: e */
    public final void m6505e(int i) {
        Editable text = this.f4329q.getText();
        Cursor mo9244a = this.f4308S.mo9244a();
        if (mo9244a == null) {
            return;
        }
        if (mo9244a.moveToPosition(i)) {
            CharSequence mo8384b = this.f4308S.mo8384b(mo9244a);
            if (mo8384b != null) {
                setQuery(mo8384b);
                return;
            } else {
                setQuery(text);
                return;
            }
        }
        setQuery(text);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4290A = new Rect();
        this.f4291B = new Rect();
        this.f4292C = new int[2];
        this.f4293D = new int[2];
        this.f4321i0 = new RunnableC0743b();
        this.f4322j0 = new RunnableC0744c();
        this.f4323k0 = new WeakHashMap<>();
        this.f4324l0 = new View$OnClickListenerC0747f();
        this.f4325m0 = new View$OnKeyListenerC0748g();
        this.f4326n0 = new C0749h();
        this.f4327o0 = new C0750i();
        this.f4328p0 = new C0751j();
        this.f4330q0 = new C0742a();
        TintTypedArray m8257a = TintTypedArray.m8257a(context, attributeSet, C0363j.SearchView, i, 0);
        LayoutInflater.from(context).inflate(m8257a.m8244g(C0363j.SearchView_layout, C0360g.abc_search_view), (ViewGroup) this, true);
        this.f4329q = (SearchAutoComplete) findViewById(C0359f.search_src_text);
        this.f4329q.setSearchView(this);
        this.f4331r = findViewById(C0359f.search_edit_frame);
        this.f4332s = findViewById(C0359f.search_plate);
        this.f4333t = findViewById(C0359f.submit_area);
        this.f4334u = (ImageView) findViewById(C0359f.search_button);
        this.f4335v = (ImageView) findViewById(C0359f.search_go_btn);
        this.f4336w = (ImageView) findViewById(C0359f.search_close_btn);
        this.f4337x = (ImageView) findViewById(C0359f.search_voice_btn);
        this.f4294E = (ImageView) findViewById(C0359f.search_mag_icon);
        ViewCompat.m9447a(this.f4332s, m8257a.m8256b(C0363j.SearchView_queryBackground));
        ViewCompat.m9447a(this.f4333t, m8257a.m8256b(C0363j.SearchView_submitBackground));
        this.f4334u.setImageDrawable(m8257a.m8256b(C0363j.SearchView_searchIcon));
        this.f4335v.setImageDrawable(m8257a.m8256b(C0363j.SearchView_goIcon));
        this.f4336w.setImageDrawable(m8257a.m8256b(C0363j.SearchView_closeIcon));
        this.f4337x.setImageDrawable(m8257a.m8256b(C0363j.SearchView_voiceIcon));
        this.f4294E.setImageDrawable(m8257a.m8256b(C0363j.SearchView_searchIcon));
        this.f4295F = m8257a.m8256b(C0363j.SearchView_searchHintIcon);
        TooltipCompat.m8181a(this.f4334u, getResources().getString(C0361h.abc_searchview_description_search));
        this.f4296G = m8257a.m8244g(C0363j.SearchView_suggestionRowLayout, C0360g.abc_search_dropdown_item_icons_2line);
        this.f4297H = m8257a.m8244g(C0363j.SearchView_commitIcon, 0);
        this.f4334u.setOnClickListener(this.f4324l0);
        this.f4336w.setOnClickListener(this.f4324l0);
        this.f4335v.setOnClickListener(this.f4324l0);
        this.f4337x.setOnClickListener(this.f4324l0);
        this.f4329q.setOnClickListener(this.f4324l0);
        this.f4329q.addTextChangedListener(this.f4330q0);
        this.f4329q.setOnEditorActionListener(this.f4326n0);
        this.f4329q.setOnItemClickListener(this.f4327o0);
        this.f4329q.setOnItemSelectedListener(this.f4328p0);
        this.f4329q.setOnKeyListener(this.f4325m0);
        this.f4329q.setOnFocusChangeListener(new View$OnFocusChangeListenerC0745d());
        setIconifiedByDefault(m8257a.m8260a(C0363j.SearchView_iconifiedByDefault, true));
        int m8252c = m8257a.m8252c(C0363j.SearchView_android_maxWidth, -1);
        if (m8252c != -1) {
            setMaxWidth(m8252c);
        }
        this.f4300K = m8257a.m8249e(C0363j.SearchView_defaultQueryHint);
        this.f4310U = m8257a.m8249e(C0363j.SearchView_queryHint);
        int m8250d = m8257a.m8250d(C0363j.SearchView_android_imeOptions, -1);
        if (m8250d != -1) {
            setImeOptions(m8250d);
        }
        int m8250d2 = m8257a.m8250d(C0363j.SearchView_android_inputType, -1);
        if (m8250d2 != -1) {
            setInputType(m8250d2);
        }
        setFocusable(m8257a.m8260a(C0363j.SearchView_android_focusable, true));
        m8257a.m8265a();
        this.f4298I = new Intent("android.speech.action.WEB_SEARCH");
        this.f4298I.addFlags(268435456);
        this.f4298I.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.f4299J = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f4299J.addFlags(268435456);
        this.f4338y = findViewById(this.f4329q.getDropDownAnchor());
        View view = this.f4338y;
        if (view != null) {
            view.addOnLayoutChangeListener(new View$OnLayoutChangeListenerC0746e());
        }
        m6512b(this.f4306Q);
        m6492r();
    }

    /* renamed from: c */
    public void m6510c(CharSequence charSequence) {
        Editable text = this.f4329q.getText();
        this.f4316d0 = text;
        boolean z = !TextUtils.isEmpty(text);
        m6517a(z);
        m6509c(!z);
        m6494p();
        m6490t();
        if (this.f4301L != null && !TextUtils.equals(charSequence, this.f4315c0)) {
            this.f4301L.m6483a(charSequence.toString());
        }
        this.f4315c0 = charSequence.toString();
    }

    /* renamed from: a */
    public final void m6521a(View view, Rect rect) {
        view.getLocationInWindow(this.f4292C);
        getLocationInWindow(this.f4293D);
        int[] iArr = this.f4292C;
        int i = iArr[1];
        int[] iArr2 = this.f4293D;
        int i2 = i - iArr2[1];
        int i3 = iArr[0] - iArr2[0];
        rect.set(i3, i2, view.getWidth() + i3, view.getHeight() + i2);
    }

    /* renamed from: a */
    public final void m6517a(boolean z) {
        this.f4335v.setVisibility((this.f4309T && m6501i() && hasFocus() && (z || !this.f4314b0)) ? 0 : 8);
    }

    /* renamed from: b */
    public void m6513b(CharSequence charSequence) {
        setQuery(charSequence);
    }

    @Override // p000a.p006b.p049h.p061j.CollapsibleActionView
    /* renamed from: b */
    public void mo6516b() {
        if (this.f4317e0) {
            return;
        }
        this.f4317e0 = true;
        this.f4318f0 = this.f4329q.getImeOptions();
        this.f4329q.setImeOptions(this.f4318f0 | 33554432);
        this.f4329q.setText("");
        setIconified(false);
    }

    /* renamed from: a */
    public boolean m6522a(View view, int i, KeyEvent keyEvent) {
        if (this.f4319g0 != null && this.f4308S != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i == 66 || i == 84 || i == 61) {
                return m6515b(this.f4329q.getListSelection(), 0, null);
            }
            if (i != 21 && i != 22) {
                if (i != 19 || this.f4329q.getListSelection() == 0) {
                    return false;
                }
            } else {
                this.f4329q.setSelection(i == 21 ? 0 : this.f4329q.length());
                this.f4329q.setListSelection(0);
                this.f4329q.clearListSelection();
                f4289r0.m6486a(this.f4329q, true);
                return true;
            }
        }
        return false;
    }

    @Override // p000a.p006b.p049h.p061j.CollapsibleActionView
    /* renamed from: c */
    public void mo6511c() {
        m6519a("", false);
        clearFocus();
        m6512b(true);
        this.f4329q.setImeOptions(this.f4318f0);
        this.f4317e0 = false;
    }

    /* renamed from: d */
    public boolean m6507d(int i) {
        InterfaceC0755n interfaceC0755n = this.f4304O;
        if (interfaceC0755n == null || !interfaceC0755n.m6481a(i)) {
            m6505e(i);
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public boolean m6515b(int i, int i2, String str) {
        InterfaceC0755n interfaceC0755n = this.f4304O;
        if (interfaceC0755n == null || !interfaceC0755n.m6480b(i)) {
            m6528a(i, 0, (String) null);
            this.f4329q.setImeVisibility(false);
            m6506e();
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public final Intent m6514b(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    /* renamed from: a */
    public final CharSequence m6520a(CharSequence charSequence) {
        if (!this.f4306Q || this.f4295F == null) {
            return charSequence;
        }
        int textSize = (int) (this.f4329q.getTextSize() * 1.25d);
        this.f4295F.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f4295F), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    /* renamed from: a */
    public final boolean m6528a(int i, int i2, String str) {
        Cursor mo9244a = this.f4308S.mo9244a();
        if (mo9244a == null || !mo9244a.moveToPosition(i)) {
            return false;
        }
        m6525a(m6523a(mo9244a, i2, str));
        return true;
    }

    /* renamed from: a */
    public final void m6525a(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e) {
            Log.e("SearchView", "Failed launch activity: " + intent, e);
        }
    }

    /* renamed from: a */
    public void m6527a(int i, String str, String str2) {
        getContext().startActivity(m6518a("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i, str));
    }

    /* renamed from: a */
    public final Intent m6518a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f4316d0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f4320h0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f4319g0.getSearchActivity());
        return intent;
    }

    /* renamed from: a */
    public final Intent m6524a(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f4320h0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    /* renamed from: a */
    public final Intent m6523a(Cursor cursor, int i, String str) {
        int i2;
        String m8394a;
        try {
            String m8394a2 = SuggestionsAdapter.m8394a(cursor, "suggest_intent_action");
            if (m8394a2 == null) {
                m8394a2 = this.f4319g0.getSuggestIntentAction();
            }
            if (m8394a2 == null) {
                m8394a2 = "android.intent.action.SEARCH";
            }
            String str2 = m8394a2;
            String m8394a3 = SuggestionsAdapter.m8394a(cursor, "suggest_intent_data");
            if (m8394a3 == null) {
                m8394a3 = this.f4319g0.getSuggestIntentData();
            }
            if (m8394a3 != null && (m8394a = SuggestionsAdapter.m8394a(cursor, "suggest_intent_data_id")) != null) {
                m8394a3 = m8394a3 + "/" + Uri.encode(m8394a);
            }
            return m6518a(str2, m8394a3 == null ? null : Uri.parse(m8394a3), SuggestionsAdapter.m8394a(cursor, "suggest_intent_extra_data"), SuggestionsAdapter.m8394a(cursor, "suggest_intent_query"), i, str);
        } catch (RuntimeException e) {
            try {
                i2 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i2 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i2 + " returned exception.", e);
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m6526a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
}
