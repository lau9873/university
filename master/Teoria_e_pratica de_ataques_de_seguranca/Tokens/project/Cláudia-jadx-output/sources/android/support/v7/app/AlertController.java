package android.support.v7.app;

import a.b.g.k.u;
import a.b.h.b.j;
import a.b.h.k.r0;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.NestedScrollView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class AlertController {
    public NestedScrollView A;
    public Drawable C;
    public ImageView D;
    public TextView E;
    public TextView F;
    public View G;
    public ListAdapter H;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public boolean P;
    public Handler R;

    /* renamed from: a  reason: collision with root package name */
    public final Context f2381a;

    /* renamed from: b  reason: collision with root package name */
    public final a.b.h.a.h f2382b;

    /* renamed from: c  reason: collision with root package name */
    public final Window f2383c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2384d;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f2385e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f2386f;

    /* renamed from: g  reason: collision with root package name */
    public ListView f2387g;

    /* renamed from: h  reason: collision with root package name */
    public View f2388h;

    /* renamed from: i  reason: collision with root package name */
    public int f2389i;
    public int j;
    public int k;
    public int l;
    public int m;
    public Button o;
    public CharSequence p;
    public Message q;
    public Drawable r;
    public Button s;
    public CharSequence t;
    public Message u;
    public Drawable v;
    public Button w;
    public CharSequence x;
    public Message y;
    public Drawable z;
    public boolean n = false;
    public int B = 0;
    public int I = -1;
    public int Q = 0;
    public final View.OnClickListener S = new a();

    /* loaded from: classes.dex */
    public static class RecycleListView extends ListView {

        /* renamed from: a  reason: collision with root package name */
        public final int f2390a;

        /* renamed from: b  reason: collision with root package name */
        public final int f2391b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public void a(boolean z, boolean z2) {
            if (z2 && z) {
                return;
            }
            setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f2390a, getPaddingRight(), z2 ? getPaddingBottom() : this.f2391b);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.RecycleListView);
            this.f2391b = obtainStyledAttributes.getDimensionPixelOffset(j.RecycleListView_paddingBottomNoButtons, -1);
            this.f2390a = obtainStyledAttributes.getDimensionPixelOffset(j.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message obtain;
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            if (view == alertController.o && (message3 = alertController.q) != null) {
                obtain = Message.obtain(message3);
            } else {
                AlertController alertController2 = AlertController.this;
                if (view == alertController2.s && (message2 = alertController2.u) != null) {
                    obtain = Message.obtain(message2);
                } else {
                    AlertController alertController3 = AlertController.this;
                    obtain = (view != alertController3.w || (message = alertController3.y) == null) ? null : Message.obtain(message);
                }
            }
            if (obtain != null) {
                obtain.sendToTarget();
            }
            AlertController alertController4 = AlertController.this;
            alertController4.R.obtainMessage(1, alertController4.f2382b).sendToTarget();
        }
    }

    /* loaded from: classes.dex */
    public class b implements NestedScrollView.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f2393a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f2394b;

        public b(AlertController alertController, View view, View view2) {
            this.f2393a = view;
            this.f2394b = view2;
        }

        @Override // android.support.v4.widget.NestedScrollView.b
        public void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
            AlertController.a(nestedScrollView, this.f2393a, this.f2394b);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f2395a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f2396b;

        public c(View view, View view2) {
            this.f2395a = view;
            this.f2396b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.a(AlertController.this.A, this.f2395a, this.f2396b);
        }
    }

    /* loaded from: classes.dex */
    public class d implements AbsListView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f2398a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f2399b;

        public d(AlertController alertController, View view, View view2) {
            this.f2398a = view;
            this.f2399b = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            AlertController.a(absListView, this.f2398a, this.f2399b);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f2400a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f2401b;

        public e(View view, View view2) {
            this.f2400a = view;
            this.f2401b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.a(AlertController.this.f2387g, this.f2400a, this.f2401b);
        }
    }

    /* loaded from: classes.dex */
    public static class f {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public e O;

        /* renamed from: a  reason: collision with root package name */
        public final Context f2403a;

        /* renamed from: b  reason: collision with root package name */
        public final LayoutInflater f2404b;

        /* renamed from: d  reason: collision with root package name */
        public Drawable f2406d;

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f2408f;

        /* renamed from: g  reason: collision with root package name */
        public View f2409g;

        /* renamed from: h  reason: collision with root package name */
        public CharSequence f2410h;

        /* renamed from: i  reason: collision with root package name */
        public CharSequence f2411i;
        public Drawable j;
        public DialogInterface.OnClickListener k;
        public CharSequence l;
        public Drawable m;
        public DialogInterface.OnClickListener n;
        public CharSequence o;
        public Drawable p;
        public DialogInterface.OnClickListener q;
        public DialogInterface.OnCancelListener s;
        public DialogInterface.OnDismissListener t;
        public DialogInterface.OnKeyListener u;
        public CharSequence[] v;
        public ListAdapter w;
        public DialogInterface.OnClickListener x;
        public int y;
        public View z;

        /* renamed from: c  reason: collision with root package name */
        public int f2405c = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f2407e = 0;
        public boolean E = false;
        public int I = -1;
        public boolean r = true;

        /* loaded from: classes.dex */
        public class a extends ArrayAdapter<CharSequence> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RecycleListView f2412a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Context context, int i2, int i3, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i2, i3, charSequenceArr);
                this.f2412a = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i2, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i2, view, viewGroup);
                boolean[] zArr = f.this.F;
                if (zArr != null && zArr[i2]) {
                    this.f2412a.setItemChecked(i2, true);
                }
                return view2;
            }
        }

        /* loaded from: classes.dex */
        public class b extends CursorAdapter {

            /* renamed from: a  reason: collision with root package name */
            public final int f2414a;

            /* renamed from: b  reason: collision with root package name */
            public final int f2415b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ RecycleListView f2416c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ AlertController f2417d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Context context, Cursor cursor, boolean z, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z);
                this.f2416c = recycleListView;
                this.f2417d = alertController;
                Cursor cursor2 = getCursor();
                this.f2414a = cursor2.getColumnIndexOrThrow(f.this.L);
                this.f2415b = cursor2.getColumnIndexOrThrow(f.this.M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f2414a));
                this.f2416c.setItemChecked(cursor.getPosition(), cursor.getInt(this.f2415b) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return f.this.f2404b.inflate(this.f2417d.M, viewGroup, false);
            }
        }

        /* loaded from: classes.dex */
        public class c implements AdapterView.OnItemClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AlertController f2419a;

            public c(AlertController alertController) {
                this.f2419a = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                f.this.x.onClick(this.f2419a.f2382b, i2);
                if (f.this.H) {
                    return;
                }
                this.f2419a.f2382b.dismiss();
            }
        }

        /* loaded from: classes.dex */
        public class d implements AdapterView.OnItemClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RecycleListView f2421a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ AlertController f2422b;

            public d(RecycleListView recycleListView, AlertController alertController) {
                this.f2421a = recycleListView;
                this.f2422b = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                boolean[] zArr = f.this.F;
                if (zArr != null) {
                    zArr[i2] = this.f2421a.isItemChecked(i2);
                }
                f.this.J.onClick(this.f2422b.f2382b, i2, this.f2421a.isItemChecked(i2));
            }
        }

        /* loaded from: classes.dex */
        public interface e {
            void a(ListView listView);
        }

        public f(Context context) {
            this.f2403a = context;
            this.f2404b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void a(AlertController alertController) {
            View view = this.f2409g;
            if (view != null) {
                alertController.a(view);
            } else {
                CharSequence charSequence = this.f2408f;
                if (charSequence != null) {
                    alertController.b(charSequence);
                }
                Drawable drawable = this.f2406d;
                if (drawable != null) {
                    alertController.a(drawable);
                }
                int i2 = this.f2405c;
                if (i2 != 0) {
                    alertController.b(i2);
                }
                int i3 = this.f2407e;
                if (i3 != 0) {
                    alertController.b(alertController.a(i3));
                }
            }
            CharSequence charSequence2 = this.f2410h;
            if (charSequence2 != null) {
                alertController.a(charSequence2);
            }
            if (this.f2411i != null || this.j != null) {
                alertController.a(-1, this.f2411i, this.k, (Message) null, this.j);
            }
            if (this.l != null || this.m != null) {
                alertController.a(-2, this.l, this.n, (Message) null, this.m);
            }
            if (this.o != null || this.p != null) {
                alertController.a(-3, this.o, this.q, (Message) null, this.p);
            }
            if (this.v != null || this.K != null || this.w != null) {
                b(alertController);
            }
            View view2 = this.z;
            if (view2 != null) {
                if (this.E) {
                    alertController.a(view2, this.A, this.B, this.C, this.D);
                    return;
                } else {
                    alertController.b(view2);
                    return;
                }
            }
            int i4 = this.y;
            if (i4 != 0) {
                alertController.c(i4);
            }
        }

        public final void b(AlertController alertController) {
            int i2;
            ListAdapter listAdapter;
            RecycleListView recycleListView = (RecycleListView) this.f2404b.inflate(alertController.L, (ViewGroup) null);
            if (this.G) {
                Cursor cursor = this.K;
                if (cursor == null) {
                    listAdapter = new a(this.f2403a, alertController.M, 16908308, this.v, recycleListView);
                } else {
                    listAdapter = new b(this.f2403a, cursor, false, recycleListView, alertController);
                }
            } else {
                if (this.H) {
                    i2 = alertController.N;
                } else {
                    i2 = alertController.O;
                }
                int i3 = i2;
                Cursor cursor2 = this.K;
                if (cursor2 != null) {
                    listAdapter = new SimpleCursorAdapter(this.f2403a, i3, cursor2, new String[]{this.L}, new int[]{16908308});
                } else {
                    listAdapter = this.w;
                    if (listAdapter == null) {
                        listAdapter = new h(this.f2403a, i3, 16908308, this.v);
                    }
                }
            }
            e eVar = this.O;
            if (eVar != null) {
                eVar.a(recycleListView);
            }
            alertController.H = listAdapter;
            alertController.I = this.I;
            if (this.x != null) {
                recycleListView.setOnItemClickListener(new c(alertController));
            } else if (this.J != null) {
                recycleListView.setOnItemClickListener(new d(recycleListView, alertController));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.N;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.H) {
                recycleListView.setChoiceMode(1);
            } else if (this.G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f2387g = recycleListView;
        }
    }

    /* loaded from: classes.dex */
    public static final class g extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<DialogInterface> f2424a;

        public g(DialogInterface dialogInterface) {
            this.f2424a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == -3 || i2 == -2 || i2 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f2424a.get(), message.what);
            } else if (i2 != 1) {
            } else {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class h extends ArrayAdapter<CharSequence> {
        public h(Context context, int i2, int i3, CharSequence[] charSequenceArr) {
            super(context, i2, i3, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, a.b.h.a.h hVar, Window window) {
        this.f2381a = context;
        this.f2382b = hVar;
        this.f2383c = window;
        this.R = new g(hVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, j.AlertDialog, a.b.h.b.a.alertDialogStyle, 0);
        this.J = obtainStyledAttributes.getResourceId(j.AlertDialog_android_layout, 0);
        this.K = obtainStyledAttributes.getResourceId(j.AlertDialog_buttonPanelSideLayout, 0);
        this.L = obtainStyledAttributes.getResourceId(j.AlertDialog_listLayout, 0);
        this.M = obtainStyledAttributes.getResourceId(j.AlertDialog_multiChoiceItemLayout, 0);
        this.N = obtainStyledAttributes.getResourceId(j.AlertDialog_singleChoiceItemLayout, 0);
        this.O = obtainStyledAttributes.getResourceId(j.AlertDialog_listItemLayout, 0);
        this.P = obtainStyledAttributes.getBoolean(j.AlertDialog_showTitle, true);
        this.f2384d = obtainStyledAttributes.getDimensionPixelSize(j.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        hVar.a(1);
    }

    public static boolean a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.b.h.b.a.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    public static boolean c(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            while (childCount > 0) {
                childCount--;
                if (c(viewGroup.getChildAt(childCount))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final int b() {
        int i2 = this.K;
        if (i2 == 0) {
            return this.J;
        }
        return this.Q == 1 ? i2 : this.J;
    }

    public final void d(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f2383c.findViewById(a.b.h.b.f.title_template).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f2383c.findViewById(16908294);
        if ((!TextUtils.isEmpty(this.f2385e)) && this.P) {
            this.E = (TextView) this.f2383c.findViewById(a.b.h.b.f.alertTitle);
            this.E.setText(this.f2385e);
            int i2 = this.B;
            if (i2 != 0) {
                this.D.setImageResource(i2);
                return;
            }
            Drawable drawable = this.C;
            if (drawable != null) {
                this.D.setImageDrawable(drawable);
                return;
            }
            this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
            this.D.setVisibility(8);
            return;
        }
        this.f2383c.findViewById(a.b.h.b.f.title_template).setVisibility(8);
        this.D.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    public void a() {
        this.f2382b.setContentView(b());
        c();
    }

    public void b(CharSequence charSequence) {
        this.f2385e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void a(View view) {
        this.G = view;
    }

    public void c(int i2) {
        this.f2388h = null;
        this.f2389i = i2;
        this.n = false;
    }

    public void a(CharSequence charSequence) {
        this.f2386f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void b(View view) {
        this.f2388h = view;
        this.f2389i = 0;
        this.n = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        View findViewById;
        ListAdapter listAdapter;
        View findViewById2;
        View findViewById3 = this.f2383c.findViewById(a.b.h.b.f.parentPanel);
        View findViewById4 = findViewById3.findViewById(a.b.h.b.f.topPanel);
        View findViewById5 = findViewById3.findViewById(a.b.h.b.f.contentPanel);
        View findViewById6 = findViewById3.findViewById(a.b.h.b.f.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(a.b.h.b.f.customPanel);
        c(viewGroup);
        View findViewById7 = viewGroup.findViewById(a.b.h.b.f.topPanel);
        View findViewById8 = viewGroup.findViewById(a.b.h.b.f.contentPanel);
        View findViewById9 = viewGroup.findViewById(a.b.h.b.f.buttonPanel);
        ViewGroup a2 = a(findViewById7, findViewById4);
        ViewGroup a3 = a(findViewById8, findViewById5);
        ViewGroup a4 = a(findViewById9, findViewById6);
        b(a3);
        a(a4);
        d(a2);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (a2 == null || a2.getVisibility() == 8) ? 0 : 1;
        boolean z3 = (a4 == null || a4.getVisibility() == 8) ? false : true;
        if (!z3 && a3 != null && (findViewById2 = a3.findViewById(a.b.h.b.f.textSpacerNoButtons)) != null) {
            findViewById2.setVisibility(0);
        }
        if (z2) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View view = null;
            if (this.f2386f != null || this.f2387g != null) {
                view = a2.findViewById(a.b.h.b.f.titleDividerNoCustom);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (a3 != null && (findViewById = a3.findViewById(a.b.h.b.f.textSpacerNoTitle)) != null) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f2387g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z2, z3);
        }
        if (!z) {
            View view2 = this.f2387g;
            if (view2 == null) {
                view2 = this.A;
            }
            if (view2 != null) {
                a(a3, view2, z2 | (z3 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f2387g;
        if (listView2 == null || (listAdapter = this.H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i2 = this.I;
        if (i2 > -1) {
            listView2.setItemChecked(i2, true);
            listView2.setSelection(i2);
        }
    }

    public void a(View view, int i2, int i3, int i4, int i5) {
        this.f2388h = view;
        this.f2389i = 0;
        this.n = true;
        this.j = i2;
        this.k = i3;
        this.l = i4;
        this.m = i5;
    }

    public void b(int i2) {
        this.C = null;
        this.B = i2;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (i2 != 0) {
                imageView.setVisibility(0);
                this.D.setImageResource(this.B);
                return;
            }
            imageView.setVisibility(8);
        }
    }

    public boolean b(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.a(keyEvent);
    }

    public void a(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i2, onClickListener);
        }
        if (i2 == -3) {
            this.x = charSequence;
            this.y = message;
            this.z = drawable;
        } else if (i2 == -2) {
            this.t = charSequence;
            this.u = message;
            this.v = drawable;
        } else if (i2 == -1) {
            this.p = charSequence;
            this.q = message;
            this.r = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public final void b(ViewGroup viewGroup) {
        this.A = (NestedScrollView) this.f2383c.findViewById(a.b.h.b.f.scrollView);
        this.A.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        this.F = (TextView) viewGroup.findViewById(16908299);
        TextView textView = this.F;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f2386f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.A.removeView(this.F);
        if (this.f2387g != null) {
            ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
            int indexOfChild = viewGroup2.indexOfChild(this.A);
            viewGroup2.removeViewAt(indexOfChild);
            viewGroup2.addView(this.f2387g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        viewGroup.setVisibility(8);
    }

    public void a(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (drawable != null) {
                imageView.setVisibility(0);
                this.D.setImageDrawable(drawable);
                return;
            }
            imageView.setVisibility(8);
        }
    }

    public int a(int i2) {
        TypedValue typedValue = new TypedValue();
        this.f2381a.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId;
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.a(keyEvent);
    }

    public final ViewGroup a(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final void c(ViewGroup viewGroup) {
        View view = this.f2388h;
        if (view == null) {
            view = this.f2389i != 0 ? LayoutInflater.from(this.f2381a).inflate(this.f2389i, viewGroup, false) : null;
        }
        boolean z = view != null;
        if (!z || !c(view)) {
            this.f2383c.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f2383c.findViewById(a.b.h.b.f.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.n) {
                frameLayout.setPadding(this.j, this.k, this.l, this.m);
            }
            if (this.f2387g != null) {
                ((r0.a) viewGroup.getLayoutParams()).f1929a = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    public final void a(ViewGroup viewGroup, View view, int i2, int i3) {
        View findViewById = this.f2383c.findViewById(a.b.h.b.f.scrollIndicatorUp);
        View findViewById2 = this.f2383c.findViewById(a.b.h.b.f.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            u.a(view, i2, i3);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        View view2 = null;
        if (findViewById != null && (i2 & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i2 & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById == null && view2 == null) {
            return;
        }
        if (this.f2386f != null) {
            this.A.setOnScrollChangeListener(new b(this, findViewById, view2));
            this.A.post(new c(findViewById, view2));
            return;
        }
        ListView listView = this.f2387g;
        if (listView != null) {
            listView.setOnScrollListener(new d(this, findViewById, view2));
            this.f2387g.post(new e(findViewById, view2));
            return;
        }
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        if (view2 != null) {
            viewGroup.removeView(view2);
        }
    }

    public static void a(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    public final void a(ViewGroup viewGroup) {
        boolean z;
        this.o = (Button) viewGroup.findViewById(16908313);
        this.o.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.p) && this.r == null) {
            this.o.setVisibility(8);
            z = false;
        } else {
            this.o.setText(this.p);
            Drawable drawable = this.r;
            if (drawable != null) {
                int i2 = this.f2384d;
                drawable.setBounds(0, 0, i2, i2);
                this.o.setCompoundDrawables(this.r, null, null, null);
            }
            this.o.setVisibility(0);
            z = true;
        }
        this.s = (Button) viewGroup.findViewById(16908314);
        this.s.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.t) && this.v == null) {
            this.s.setVisibility(8);
        } else {
            this.s.setText(this.t);
            Drawable drawable2 = this.v;
            if (drawable2 != null) {
                int i3 = this.f2384d;
                drawable2.setBounds(0, 0, i3, i3);
                this.s.setCompoundDrawables(this.v, null, null, null);
            }
            this.s.setVisibility(0);
            z |= true;
        }
        this.w = (Button) viewGroup.findViewById(16908315);
        this.w.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.x) && this.z == null) {
            this.w.setVisibility(8);
        } else {
            this.w.setText(this.x);
            Drawable drawable3 = this.r;
            if (drawable3 != null) {
                int i4 = this.f2384d;
                drawable3.setBounds(0, 0, i4, i4);
                this.o.setCompoundDrawables(this.r, null, null, null);
            }
            this.w.setVisibility(0);
            z |= true;
        }
        if (a(this.f2381a)) {
            if (z) {
                a(this.o);
            } else if (z) {
                a(this.s);
            } else if (z) {
                a(this.w);
            }
        }
        if (z) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    public final void a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }
}
