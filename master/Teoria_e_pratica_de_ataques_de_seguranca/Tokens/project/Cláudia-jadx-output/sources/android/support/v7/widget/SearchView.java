package android.support.v7.widget;

import a.b.g.k.u;
import a.b.h.k.f1;
import a.b.h.k.l1;
import a.b.h.k.n1;
import a.b.h.k.r0;
import a.b.h.k.t1;
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
/* loaded from: classes.dex */
public class SearchView extends r0 implements a.b.h.j.c {
    public static final k r0 = new k();
    public Rect A;
    public Rect B;
    public int[] C;
    public int[] D;
    public final ImageView E;
    public final Drawable F;
    public final int G;
    public final int H;
    public final Intent I;
    public final Intent J;
    public final CharSequence K;
    public m L;
    public l M;
    public View.OnFocusChangeListener N;
    public n O;
    public View.OnClickListener P;
    public boolean Q;
    public boolean R;
    public a.b.g.l.f S;
    public boolean T;
    public CharSequence U;
    public boolean V;
    public boolean W;
    public int a0;
    public boolean b0;
    public CharSequence c0;
    public CharSequence d0;
    public boolean e0;
    public int f0;
    public SearchableInfo g0;
    public Bundle h0;
    public final Runnable i0;
    public Runnable j0;
    public final WeakHashMap<String, Drawable.ConstantState> k0;
    public final View.OnClickListener l0;
    public View.OnKeyListener m0;
    public final TextView.OnEditorActionListener n0;
    public final AdapterView.OnItemClickListener o0;
    public final AdapterView.OnItemSelectedListener p0;
    public final SearchAutoComplete q;
    public TextWatcher q0;
    public final View r;
    public final View s;
    public final View t;
    public final ImageView u;
    public final ImageView v;
    public final ImageView w;
    public final ImageView x;
    public final View y;
    public p z;

    /* loaded from: classes.dex */
    public static class SearchAutoComplete extends a.b.h.k.e {

        /* renamed from: d  reason: collision with root package name */
        public int f2638d;

        /* renamed from: e  reason: collision with root package name */
        public SearchView f2639e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f2640f;

        /* renamed from: g  reason: collision with root package name */
        public final Runnable f2641g;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.b();
            }
        }

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i2 = configuration.screenWidthDp;
            int i3 = configuration.screenHeightDp;
            if (i2 < 960 || i3 < 720 || configuration.orientation != 2) {
                if (i2 < 600) {
                    return (i2 < 640 || i3 < 480) ? 160 : 192;
                }
                return 192;
            }
            return 256;
        }

        public boolean a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        public void b() {
            if (this.f2640f) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f2640f = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f2638d <= 0 || super.enoughToFilter();
        }

        @Override // a.b.h.k.e, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f2640f) {
                removeCallbacks(this.f2641g);
                post(this.f2641g);
            }
            return onCreateInputConnection;
        }

        @Override // android.view.View
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onFocusChanged(boolean z, int i2, Rect rect) {
            super.onFocusChanged(z, i2, rect);
            this.f2639e.m();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
            if (i2 == 4) {
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
                        this.f2639e.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i2, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f2639e.hasFocus() && getVisibility() == 0) {
                this.f2640f = true;
                if (SearchView.a(getContext())) {
                    SearchView.r0.a(this, true);
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
                this.f2640f = false;
                removeCallbacks(this.f2641g);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.f2640f = false;
                removeCallbacks(this.f2641g);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.f2640f = true;
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f2639e = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i2) {
            super.setThreshold(i2);
            this.f2638d = i2;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, a.b.h.b.a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.f2641g = new a();
            this.f2638d = getThreshold();
        }
    }

    /* loaded from: classes.dex */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            SearchView.this.c(charSequence);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.q();
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.b.g.l.f fVar = SearchView.this.S;
            if (fVar == null || !(fVar instanceof f1)) {
                return;
            }
            fVar.a((Cursor) null);
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnFocusChangeListener {
        public d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.N;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements View.OnLayoutChangeListener {
        public e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            SearchView.this.d();
        }
    }

    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.u) {
                searchView.k();
            } else if (view == searchView.w) {
                searchView.j();
            } else if (view == searchView.v) {
                searchView.l();
            } else if (view == searchView.x) {
                searchView.n();
            } else if (view == searchView.q) {
                searchView.f();
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements View.OnKeyListener {
        public g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.g0 == null) {
                return false;
            }
            if (searchView.q.isPopupShowing() && SearchView.this.q.getListSelection() != -1) {
                return SearchView.this.a(view, i2, keyEvent);
            }
            if (!SearchView.this.q.a() && keyEvent.hasNoModifiers() && keyEvent.getAction() == 1 && i2 == 66) {
                view.cancelLongPress();
                SearchView searchView2 = SearchView.this;
                searchView2.a(0, (String) null, searchView2.q.getText().toString());
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class h implements TextView.OnEditorActionListener {
        public h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            SearchView.this.l();
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class i implements AdapterView.OnItemClickListener {
        public i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            SearchView.this.b(i2, 0, null);
        }
    }

    /* loaded from: classes.dex */
    public class j implements AdapterView.OnItemSelectedListener {
        public j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
            SearchView.this.d(i2);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* loaded from: classes.dex */
    public interface l {
        boolean a();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean a(String str);

        boolean b(String str);
    }

    /* loaded from: classes.dex */
    public interface n {
        boolean a(int i2);

        boolean b(int i2);
    }

    /* loaded from: classes.dex */
    public static class o extends a.b.g.k.a {
        public static final Parcelable.Creator<o> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        public boolean f2656c;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<o> {
            @Override // android.os.Parcelable.Creator
            public o[] newArray(int i2) {
                return new o[i2];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public o createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new o(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public o createFromParcel(Parcel parcel) {
                return new o(parcel, null);
            }
        }

        public o(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f2656c + "}";
        }

        @Override // a.b.g.k.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeValue(Boolean.valueOf(this.f2656c));
        }

        public o(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2656c = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    /* loaded from: classes.dex */
    public static class p extends TouchDelegate {

        /* renamed from: a  reason: collision with root package name */
        public final View f2657a;

        /* renamed from: b  reason: collision with root package name */
        public final Rect f2658b;

        /* renamed from: c  reason: collision with root package name */
        public final Rect f2659c;

        /* renamed from: d  reason: collision with root package name */
        public final Rect f2660d;

        /* renamed from: e  reason: collision with root package name */
        public final int f2661e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f2662f;

        public p(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f2661e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f2658b = new Rect();
            this.f2660d = new Rect();
            this.f2659c = new Rect();
            a(rect, rect2);
            this.f2657a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f2658b.set(rect);
            this.f2660d.set(rect);
            Rect rect3 = this.f2660d;
            int i2 = this.f2661e;
            rect3.inset(-i2, -i2);
            this.f2659c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z2 = true;
            if (action == 0) {
                if (this.f2658b.contains(x, y)) {
                    this.f2662f = true;
                    z = true;
                }
                z = false;
            } else if (action == 1 || action == 2) {
                z = this.f2662f;
                if (z && !this.f2660d.contains(x, y)) {
                    z2 = false;
                }
            } else {
                if (action == 3) {
                    z = this.f2662f;
                    this.f2662f = false;
                }
                z = false;
            }
            if (z) {
                if (z2 && !this.f2659c.contains(x, y)) {
                    motionEvent.setLocation(this.f2657a.getWidth() / 2, this.f2657a.getHeight() / 2);
                } else {
                    Rect rect = this.f2659c;
                    motionEvent.setLocation(x - rect.left, y - rect.top);
                }
                return this.f2657a.dispatchTouchEvent(motionEvent);
            }
            return false;
        }
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(a.b.h.b.d.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(a.b.h.b.d.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence charSequence) {
        this.q.setText(charSequence);
        this.q.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public void a(CharSequence charSequence, boolean z) {
        this.q.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.q;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.d0 = charSequence;
        }
        if (!z || TextUtils.isEmpty(charSequence)) {
            return;
        }
        l();
    }

    public final void b(boolean z) {
        this.R = z;
        int i2 = 0;
        int i3 = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.q.getText());
        this.u.setVisibility(i3);
        a(z2);
        this.r.setVisibility(z ? 8 : 0);
        this.E.setVisibility((this.E.getDrawable() == null || this.Q) ? 8 : 8);
        p();
        c(!z2);
        t();
    }

    public final void c(boolean z) {
        int i2;
        if (this.b0 && !h() && z) {
            i2 = 0;
            this.v.setVisibility(8);
        } else {
            i2 = 8;
        }
        this.x.setVisibility(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.W = true;
        super.clearFocus();
        this.q.clearFocus();
        this.q.setImeVisibility(false);
        this.W = false;
    }

    public void d() {
        int i2;
        if (this.y.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.s.getPaddingLeft();
            Rect rect = new Rect();
            boolean a2 = t1.a(this);
            int dimensionPixelSize = this.Q ? resources.getDimensionPixelSize(a.b.h.b.d.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(a.b.h.b.d.abc_dropdownitem_text_padding_left) : 0;
            this.q.getDropDownBackground().getPadding(rect);
            if (a2) {
                i2 = -rect.left;
            } else {
                i2 = paddingLeft - (rect.left + dimensionPixelSize);
            }
            this.q.setDropDownHorizontalOffset(i2);
            this.q.setDropDownWidth((((this.y.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    public final void e() {
        this.q.dismissDropDown();
    }

    public void f() {
        r0.b(this.q);
        r0.a(this.q);
    }

    public final boolean g() {
        SearchableInfo searchableInfo = this.g0;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.g0.getVoiceSearchLaunchWebSearch()) {
            intent = this.I;
        } else if (this.g0.getVoiceSearchLaunchRecognizer()) {
            intent = this.J;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    public int getImeOptions() {
        return this.q.getImeOptions();
    }

    public int getInputType() {
        return this.q.getInputType();
    }

    public int getMaxWidth() {
        return this.a0;
    }

    public CharSequence getQuery() {
        return this.q.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.U;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.g0;
        if (searchableInfo != null && searchableInfo.getHintId() != 0) {
            return getContext().getText(this.g0.getHintId());
        }
        return this.K;
    }

    public int getSuggestionCommitIconResId() {
        return this.H;
    }

    public int getSuggestionRowLayout() {
        return this.G;
    }

    public a.b.g.l.f getSuggestionsAdapter() {
        return this.S;
    }

    public boolean h() {
        return this.R;
    }

    public final boolean i() {
        return (this.T || this.b0) && !h();
    }

    public void j() {
        if (TextUtils.isEmpty(this.q.getText())) {
            if (this.Q) {
                l lVar = this.M;
                if (lVar == null || !lVar.a()) {
                    clearFocus();
                    b(true);
                    return;
                }
                return;
            }
            return;
        }
        this.q.setText("");
        this.q.requestFocus();
        this.q.setImeVisibility(true);
    }

    public void k() {
        b(false);
        this.q.requestFocus();
        this.q.setImeVisibility(true);
        View.OnClickListener onClickListener = this.P;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void l() {
        Editable text = this.q.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        m mVar = this.L;
        if (mVar == null || !mVar.b(text.toString())) {
            if (this.g0 != null) {
                a(0, (String) null, text.toString());
            }
            this.q.setImeVisibility(false);
            e();
        }
    }

    public void m() {
        b(h());
        o();
        if (this.q.hasFocus()) {
            f();
        }
    }

    public void n() {
        SearchableInfo searchableInfo = this.g0;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(b(this.I, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(a(this.J, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    public final void o() {
        post(this.i0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.i0);
        post(this.j0);
        super.onDetachedFromWindow();
    }

    @Override // a.b.h.k.r0, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            a(this.q, this.A);
            Rect rect = this.B;
            Rect rect2 = this.A;
            rect.set(rect2.left, 0, rect2.right, i5 - i3);
            p pVar = this.z;
            if (pVar == null) {
                this.z = new p(this.B, this.A, this.q);
                setTouchDelegate(this.z);
                return;
            }
            pVar.a(this.B, this.A);
        }
    }

    @Override // a.b.h.k.r0, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        if (h()) {
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            int i5 = this.a0;
            size = i5 > 0 ? Math.min(i5, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.a0;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i4 = this.a0) > 0) {
            size = Math.min(i4, size);
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof o)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        o oVar = (o) parcelable;
        super.onRestoreInstanceState(oVar.a());
        b(oVar.f2656c);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        o oVar = new o(super.onSaveInstanceState());
        oVar.f2656c = h();
        return oVar;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        o();
    }

    public final void p() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.q.getText());
        if (!z2 && (!this.Q || this.e0)) {
            z = false;
        }
        this.w.setVisibility(z ? 0 : 8);
        Drawable drawable = this.w.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    public void q() {
        int[] iArr = this.q.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.s.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.t.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public final void r() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.q;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(a(queryHint));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i2, Rect rect) {
        if (!this.W && isFocusable()) {
            if (!h()) {
                boolean requestFocus = this.q.requestFocus(i2, rect);
                if (requestFocus) {
                    b(false);
                }
                return requestFocus;
            }
            return super.requestFocus(i2, rect);
        }
        return false;
    }

    public final void s() {
        this.q.setThreshold(this.g0.getSuggestThreshold());
        this.q.setImeOptions(this.g0.getImeOptions());
        int inputType = this.g0.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.g0.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.q.setInputType(inputType);
        a.b.g.l.f fVar = this.S;
        if (fVar != null) {
            fVar.a((Cursor) null);
        }
        if (this.g0.getSuggestAuthority() != null) {
            this.S = new f1(getContext(), this, this.g0, this.k0);
            this.q.setAdapter(this.S);
            ((f1) this.S).a(this.V ? 2 : 1);
        }
    }

    public void setAppSearchData(Bundle bundle) {
        this.h0 = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            j();
        } else {
            k();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.Q == z) {
            return;
        }
        this.Q = z;
        b(z);
        r();
    }

    public void setImeOptions(int i2) {
        this.q.setImeOptions(i2);
    }

    public void setInputType(int i2) {
        this.q.setInputType(i2);
    }

    public void setMaxWidth(int i2) {
        this.a0 = i2;
        requestLayout();
    }

    public void setOnCloseListener(l lVar) {
        this.M = lVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.N = onFocusChangeListener;
    }

    public void setOnQueryTextListener(m mVar) {
        this.L = mVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.P = onClickListener;
    }

    public void setOnSuggestionListener(n nVar) {
        this.O = nVar;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.U = charSequence;
        r();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.V = z;
        a.b.g.l.f fVar = this.S;
        if (fVar instanceof f1) {
            ((f1) fVar).a(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.g0 = searchableInfo;
        if (this.g0 != null) {
            s();
            r();
        }
        this.b0 = g();
        if (this.b0) {
            this.q.setPrivateImeOptions("nm");
        }
        b(h());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.T = z;
        b(h());
    }

    public void setSuggestionsAdapter(a.b.g.l.f fVar) {
        this.S = fVar;
        this.q.setAdapter(this.S);
    }

    public final void t() {
        this.t.setVisibility((i() && (this.v.getVisibility() == 0 || this.x.getVisibility() == 0)) ? 0 : 8);
    }

    /* loaded from: classes.dex */
    public static class k {

        /* renamed from: a  reason: collision with root package name */
        public Method f2653a;

        /* renamed from: b  reason: collision with root package name */
        public Method f2654b;

        /* renamed from: c  reason: collision with root package name */
        public Method f2655c;

        public k() {
            try {
                this.f2653a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f2653a.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                this.f2654b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f2654b.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                this.f2655c = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f2655c.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        public void a(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f2654b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        public void b(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f2653a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        public void a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            Method method = this.f2655c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.valueOf(z));
                } catch (Exception unused) {
                }
            }
        }
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.h.b.a.searchViewStyle);
    }

    public final void e(int i2) {
        Editable text = this.q.getText();
        Cursor a2 = this.S.a();
        if (a2 == null) {
            return;
        }
        if (a2.moveToPosition(i2)) {
            CharSequence b2 = this.S.b(a2);
            if (b2 != null) {
                setQuery(b2);
                return;
            } else {
                setQuery(text);
                return;
            }
        }
        setQuery(text);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.A = new Rect();
        this.B = new Rect();
        this.C = new int[2];
        this.D = new int[2];
        this.i0 = new b();
        this.j0 = new c();
        this.k0 = new WeakHashMap<>();
        this.l0 = new f();
        this.m0 = new g();
        this.n0 = new h();
        this.o0 = new i();
        this.p0 = new j();
        this.q0 = new a();
        l1 a2 = l1.a(context, attributeSet, a.b.h.b.j.SearchView, i2, 0);
        LayoutInflater.from(context).inflate(a2.g(a.b.h.b.j.SearchView_layout, a.b.h.b.g.abc_search_view), (ViewGroup) this, true);
        this.q = (SearchAutoComplete) findViewById(a.b.h.b.f.search_src_text);
        this.q.setSearchView(this);
        this.r = findViewById(a.b.h.b.f.search_edit_frame);
        this.s = findViewById(a.b.h.b.f.search_plate);
        this.t = findViewById(a.b.h.b.f.submit_area);
        this.u = (ImageView) findViewById(a.b.h.b.f.search_button);
        this.v = (ImageView) findViewById(a.b.h.b.f.search_go_btn);
        this.w = (ImageView) findViewById(a.b.h.b.f.search_close_btn);
        this.x = (ImageView) findViewById(a.b.h.b.f.search_voice_btn);
        this.E = (ImageView) findViewById(a.b.h.b.f.search_mag_icon);
        u.a(this.s, a2.b(a.b.h.b.j.SearchView_queryBackground));
        u.a(this.t, a2.b(a.b.h.b.j.SearchView_submitBackground));
        this.u.setImageDrawable(a2.b(a.b.h.b.j.SearchView_searchIcon));
        this.v.setImageDrawable(a2.b(a.b.h.b.j.SearchView_goIcon));
        this.w.setImageDrawable(a2.b(a.b.h.b.j.SearchView_closeIcon));
        this.x.setImageDrawable(a2.b(a.b.h.b.j.SearchView_voiceIcon));
        this.E.setImageDrawable(a2.b(a.b.h.b.j.SearchView_searchIcon));
        this.F = a2.b(a.b.h.b.j.SearchView_searchHintIcon);
        n1.a(this.u, getResources().getString(a.b.h.b.h.abc_searchview_description_search));
        this.G = a2.g(a.b.h.b.j.SearchView_suggestionRowLayout, a.b.h.b.g.abc_search_dropdown_item_icons_2line);
        this.H = a2.g(a.b.h.b.j.SearchView_commitIcon, 0);
        this.u.setOnClickListener(this.l0);
        this.w.setOnClickListener(this.l0);
        this.v.setOnClickListener(this.l0);
        this.x.setOnClickListener(this.l0);
        this.q.setOnClickListener(this.l0);
        this.q.addTextChangedListener(this.q0);
        this.q.setOnEditorActionListener(this.n0);
        this.q.setOnItemClickListener(this.o0);
        this.q.setOnItemSelectedListener(this.p0);
        this.q.setOnKeyListener(this.m0);
        this.q.setOnFocusChangeListener(new d());
        setIconifiedByDefault(a2.a(a.b.h.b.j.SearchView_iconifiedByDefault, true));
        int c2 = a2.c(a.b.h.b.j.SearchView_android_maxWidth, -1);
        if (c2 != -1) {
            setMaxWidth(c2);
        }
        this.K = a2.e(a.b.h.b.j.SearchView_defaultQueryHint);
        this.U = a2.e(a.b.h.b.j.SearchView_queryHint);
        int d2 = a2.d(a.b.h.b.j.SearchView_android_imeOptions, -1);
        if (d2 != -1) {
            setImeOptions(d2);
        }
        int d3 = a2.d(a.b.h.b.j.SearchView_android_inputType, -1);
        if (d3 != -1) {
            setInputType(d3);
        }
        setFocusable(a2.a(a.b.h.b.j.SearchView_android_focusable, true));
        a2.a();
        this.I = new Intent("android.speech.action.WEB_SEARCH");
        this.I.addFlags(268435456);
        this.I.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.J = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.J.addFlags(268435456);
        this.y = findViewById(this.q.getDropDownAnchor());
        View view = this.y;
        if (view != null) {
            view.addOnLayoutChangeListener(new e());
        }
        b(this.Q);
        r();
    }

    public void c(CharSequence charSequence) {
        Editable text = this.q.getText();
        this.d0 = text;
        boolean z = !TextUtils.isEmpty(text);
        a(z);
        c(!z);
        p();
        t();
        if (this.L != null && !TextUtils.equals(charSequence, this.c0)) {
            this.L.a(charSequence.toString());
        }
        this.c0 = charSequence.toString();
    }

    public final void a(View view, Rect rect) {
        view.getLocationInWindow(this.C);
        getLocationInWindow(this.D);
        int[] iArr = this.C;
        int i2 = iArr[1];
        int[] iArr2 = this.D;
        int i3 = i2 - iArr2[1];
        int i4 = iArr[0] - iArr2[0];
        rect.set(i4, i3, view.getWidth() + i4, view.getHeight() + i3);
    }

    public final void a(boolean z) {
        this.v.setVisibility((this.T && i() && hasFocus() && (z || !this.b0)) ? 0 : 8);
    }

    public void b(CharSequence charSequence) {
        setQuery(charSequence);
    }

    @Override // a.b.h.j.c
    public void b() {
        if (this.e0) {
            return;
        }
        this.e0 = true;
        this.f0 = this.q.getImeOptions();
        this.q.setImeOptions(this.f0 | 33554432);
        this.q.setText("");
        setIconified(false);
    }

    public boolean a(View view, int i2, KeyEvent keyEvent) {
        if (this.g0 != null && this.S != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i2 == 66 || i2 == 84 || i2 == 61) {
                return b(this.q.getListSelection(), 0, null);
            }
            if (i2 != 21 && i2 != 22) {
                if (i2 != 19 || this.q.getListSelection() == 0) {
                    return false;
                }
            } else {
                this.q.setSelection(i2 == 21 ? 0 : this.q.length());
                this.q.setListSelection(0);
                this.q.clearListSelection();
                r0.a(this.q, true);
                return true;
            }
        }
        return false;
    }

    @Override // a.b.h.j.c
    public void c() {
        a("", false);
        clearFocus();
        b(true);
        this.q.setImeOptions(this.f0);
        this.e0 = false;
    }

    public boolean d(int i2) {
        n nVar = this.O;
        if (nVar == null || !nVar.a(i2)) {
            e(i2);
            return true;
        }
        return false;
    }

    public boolean b(int i2, int i3, String str) {
        n nVar = this.O;
        if (nVar == null || !nVar.b(i2)) {
            a(i2, 0, (String) null);
            this.q.setImeVisibility(false);
            e();
            return true;
        }
        return false;
    }

    public final Intent b(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    public final CharSequence a(CharSequence charSequence) {
        if (!this.Q || this.F == null) {
            return charSequence;
        }
        int textSize = (int) (this.q.getTextSize() * 1.25d);
        this.F.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.F), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    public final boolean a(int i2, int i3, String str) {
        Cursor a2 = this.S.a();
        if (a2 == null || !a2.moveToPosition(i2)) {
            return false;
        }
        a(a(a2, i3, str));
        return true;
    }

    public final void a(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e2) {
            Log.e("SearchView", "Failed launch activity: " + intent, e2);
        }
    }

    public void a(int i2, String str, String str2) {
        getContext().startActivity(a("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i2, str));
    }

    public final Intent a(String str, Uri uri, String str2, String str3, int i2, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.d0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.h0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i2 != 0) {
            intent.putExtra("action_key", i2);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.g0.getSearchActivity());
        return intent;
    }

    public final Intent a(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.h0;
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

    public final Intent a(Cursor cursor, int i2, String str) {
        int i3;
        String a2;
        try {
            String a3 = f1.a(cursor, "suggest_intent_action");
            if (a3 == null) {
                a3 = this.g0.getSuggestIntentAction();
            }
            if (a3 == null) {
                a3 = "android.intent.action.SEARCH";
            }
            String str2 = a3;
            String a4 = f1.a(cursor, "suggest_intent_data");
            if (a4 == null) {
                a4 = this.g0.getSuggestIntentData();
            }
            if (a4 != null && (a2 = f1.a(cursor, "suggest_intent_data_id")) != null) {
                a4 = a4 + "/" + Uri.encode(a2);
            }
            return a(str2, a4 == null ? null : Uri.parse(a4), f1.a(cursor, "suggest_intent_extra_data"), f1.a(cursor, "suggest_intent_query"), i2, str);
        } catch (RuntimeException e2) {
            try {
                i3 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i3 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i3 + " returned exception.", e2);
            return null;
        }
    }

    public static boolean a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
}
