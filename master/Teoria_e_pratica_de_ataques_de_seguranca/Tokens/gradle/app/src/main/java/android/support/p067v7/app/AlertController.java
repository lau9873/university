package android.support.p067v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.p065v4.widget.NestedScrollView;
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
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p049h.p050a.AppCompatDialog;
import p000a.p006b.p049h.p051b.C0354a;
import p000a.p006b.p049h.p051b.C0359f;
import p000a.p006b.p049h.p051b.C0363j;
import p000a.p006b.p049h.p063k.LinearLayoutCompat;

/* renamed from: android.support.v7.app.AlertController */
/* loaded from: classes.dex */
public class AlertController {

    /* renamed from: A */
    public NestedScrollView f3707A;

    /* renamed from: C */
    public Drawable f3709C;

    /* renamed from: D */
    public ImageView f3710D;

    /* renamed from: E */
    public TextView f3711E;

    /* renamed from: F */
    public TextView f3712F;

    /* renamed from: G */
    public View f3713G;

    /* renamed from: H */
    public ListAdapter f3714H;

    /* renamed from: J */
    public int f3716J;

    /* renamed from: K */
    public int f3717K;

    /* renamed from: L */
    public int f3718L;

    /* renamed from: M */
    public int f3719M;

    /* renamed from: N */
    public int f3720N;

    /* renamed from: O */
    public int f3721O;

    /* renamed from: P */
    public boolean f3722P;

    /* renamed from: R */
    public Handler f3724R;

    /* renamed from: a */
    public final Context f3726a;

    /* renamed from: b */
    public final AppCompatDialog f3727b;

    /* renamed from: c */
    public final Window f3728c;

    /* renamed from: d */
    public final int f3729d;

    /* renamed from: e */
    public CharSequence f3730e;

    /* renamed from: f */
    public CharSequence f3731f;

    /* renamed from: g */
    public ListView f3732g;

    /* renamed from: h */
    public View f3733h;

    /* renamed from: i */
    public int f3734i;

    /* renamed from: j */
    public int f3735j;

    /* renamed from: k */
    public int f3736k;

    /* renamed from: l */
    public int f3737l;

    /* renamed from: m */
    public int f3738m;

    /* renamed from: o */
    public Button f3740o;

    /* renamed from: p */
    public CharSequence f3741p;

    /* renamed from: q */
    public Message f3742q;

    /* renamed from: r */
    public Drawable f3743r;

    /* renamed from: s */
    public Button f3744s;

    /* renamed from: t */
    public CharSequence f3745t;

    /* renamed from: u */
    public Message f3746u;

    /* renamed from: v */
    public Drawable f3747v;

    /* renamed from: w */
    public Button f3748w;

    /* renamed from: x */
    public CharSequence f3749x;

    /* renamed from: y */
    public Message f3750y;

    /* renamed from: z */
    public Drawable f3751z;

    /* renamed from: n */
    public boolean f3739n = false;

    /* renamed from: B */
    public int f3708B = 0;

    /* renamed from: I */
    public int f3715I = -1;

    /* renamed from: Q */
    public int f3723Q = 0;

    /* renamed from: S */
    public final View.OnClickListener f3725S = new View$OnClickListenerC0639a();

    /* renamed from: android.support.v7.app.AlertController$RecycleListView */
    /* loaded from: classes.dex */
    public static class RecycleListView extends ListView {

        /* renamed from: a */
        public final int f3752a;

        /* renamed from: b */
        public final int f3753b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        /* renamed from: a */
        public void m7284a(boolean z, boolean z2) {
            if (z2 && z) {
                return;
            }
            setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f3752a, getPaddingRight(), z2 ? getPaddingBottom() : this.f3753b);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0363j.RecycleListView);
            this.f3753b = obtainStyledAttributes.getDimensionPixelOffset(C0363j.RecycleListView_paddingBottomNoButtons, -1);
            this.f3752a = obtainStyledAttributes.getDimensionPixelOffset(C0363j.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    /* renamed from: android.support.v7.app.AlertController$a */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0639a implements View.OnClickListener {
        public View$OnClickListenerC0639a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message obtain;
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            if (view == alertController.f3740o && (message3 = alertController.f3742q) != null) {
                obtain = Message.obtain(message3);
            } else {
                AlertController alertController2 = AlertController.this;
                if (view == alertController2.f3744s && (message2 = alertController2.f3746u) != null) {
                    obtain = Message.obtain(message2);
                } else {
                    AlertController alertController3 = AlertController.this;
                    obtain = (view != alertController3.f3748w || (message = alertController3.f3750y) == null) ? null : Message.obtain(message);
                }
            }
            if (obtain != null) {
                obtain.sendToTarget();
            }
            AlertController alertController4 = AlertController.this;
            alertController4.f3724R.obtainMessage(1, alertController4.f3727b).sendToTarget();
        }
    }

    /* renamed from: android.support.v7.app.AlertController$b */
    /* loaded from: classes.dex */
    public class C0640b implements NestedScrollView.InterfaceC0626b {

        /* renamed from: a */
        public final /* synthetic */ View f3755a;

        /* renamed from: b */
        public final /* synthetic */ View f3756b;

        public C0640b(AlertController alertController, View view, View view2) {
            this.f3755a = view;
            this.f3756b = view2;
        }

        @Override // android.support.p065v4.widget.NestedScrollView.InterfaceC0626b
        /* renamed from: a */
        public void mo7283a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
            AlertController.m7300a(nestedScrollView, this.f3755a, this.f3756b);
        }
    }

    /* renamed from: android.support.v7.app.AlertController$c */
    /* loaded from: classes.dex */
    public class RunnableC0641c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ View f3757a;

        /* renamed from: b */
        public final /* synthetic */ View f3758b;

        public RunnableC0641c(View view, View view2) {
            this.f3757a = view;
            this.f3758b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.m7300a(AlertController.this.f3707A, this.f3757a, this.f3758b);
        }
    }

    /* renamed from: android.support.v7.app.AlertController$d */
    /* loaded from: classes.dex */
    public class C0642d implements AbsListView.OnScrollListener {

        /* renamed from: a */
        public final /* synthetic */ View f3760a;

        /* renamed from: b */
        public final /* synthetic */ View f3761b;

        public C0642d(AlertController alertController, View view, View view2) {
            this.f3760a = view;
            this.f3761b = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AlertController.m7300a(absListView, this.f3760a, this.f3761b);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    /* renamed from: android.support.v7.app.AlertController$e */
    /* loaded from: classes.dex */
    public class RunnableC0643e implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ View f3762a;

        /* renamed from: b */
        public final /* synthetic */ View f3763b;

        public RunnableC0643e(View view, View view2) {
            this.f3762a = view;
            this.f3763b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.m7300a(AlertController.this.f3732g, this.f3762a, this.f3763b);
        }
    }

    /* renamed from: android.support.v7.app.AlertController$f */
    /* loaded from: classes.dex */
    public static class C0644f {

        /* renamed from: A */
        public int f3765A;

        /* renamed from: B */
        public int f3766B;

        /* renamed from: C */
        public int f3767C;

        /* renamed from: D */
        public int f3768D;

        /* renamed from: F */
        public boolean[] f3770F;

        /* renamed from: G */
        public boolean f3771G;

        /* renamed from: H */
        public boolean f3772H;

        /* renamed from: J */
        public DialogInterface.OnMultiChoiceClickListener f3774J;

        /* renamed from: K */
        public Cursor f3775K;

        /* renamed from: L */
        public String f3776L;

        /* renamed from: M */
        public String f3777M;

        /* renamed from: N */
        public AdapterView.OnItemSelectedListener f3778N;

        /* renamed from: O */
        public InterfaceC0649e f3779O;

        /* renamed from: a */
        public final Context f3780a;

        /* renamed from: b */
        public final LayoutInflater f3781b;

        /* renamed from: d */
        public Drawable f3783d;

        /* renamed from: f */
        public CharSequence f3785f;

        /* renamed from: g */
        public View f3786g;

        /* renamed from: h */
        public CharSequence f3787h;

        /* renamed from: i */
        public CharSequence f3788i;

        /* renamed from: j */
        public Drawable f3789j;

        /* renamed from: k */
        public DialogInterface.OnClickListener f3790k;

        /* renamed from: l */
        public CharSequence f3791l;

        /* renamed from: m */
        public Drawable f3792m;

        /* renamed from: n */
        public DialogInterface.OnClickListener f3793n;

        /* renamed from: o */
        public CharSequence f3794o;

        /* renamed from: p */
        public Drawable f3795p;

        /* renamed from: q */
        public DialogInterface.OnClickListener f3796q;

        /* renamed from: s */
        public DialogInterface.OnCancelListener f3798s;

        /* renamed from: t */
        public DialogInterface.OnDismissListener f3799t;

        /* renamed from: u */
        public DialogInterface.OnKeyListener f3800u;

        /* renamed from: v */
        public CharSequence[] f3801v;

        /* renamed from: w */
        public ListAdapter f3802w;

        /* renamed from: x */
        public DialogInterface.OnClickListener f3803x;

        /* renamed from: y */
        public int f3804y;

        /* renamed from: z */
        public View f3805z;

        /* renamed from: c */
        public int f3782c = 0;

        /* renamed from: e */
        public int f3784e = 0;

        /* renamed from: E */
        public boolean f3769E = false;

        /* renamed from: I */
        public int f3773I = -1;

        /* renamed from: r */
        public boolean f3797r = true;

        /* renamed from: android.support.v7.app.AlertController$f$a */
        /* loaded from: classes.dex */
        public class C0645a extends ArrayAdapter<CharSequence> {

            /* renamed from: a */
            public final /* synthetic */ RecycleListView f3806a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0645a(Context context, int i, int i2, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i, i2, charSequenceArr);
                this.f3806a = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, view, viewGroup);
                boolean[] zArr = C0644f.this.f3770F;
                if (zArr != null && zArr[i]) {
                    this.f3806a.setItemChecked(i, true);
                }
                return view2;
            }
        }

        /* renamed from: android.support.v7.app.AlertController$f$b */
        /* loaded from: classes.dex */
        public class C0646b extends CursorAdapter {

            /* renamed from: a */
            public final int f3808a;

            /* renamed from: b */
            public final int f3809b;

            /* renamed from: c */
            public final /* synthetic */ RecycleListView f3810c;

            /* renamed from: d */
            public final /* synthetic */ AlertController f3811d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0646b(Context context, Cursor cursor, boolean z, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z);
                this.f3810c = recycleListView;
                this.f3811d = alertController;
                Cursor cursor2 = getCursor();
                this.f3808a = cursor2.getColumnIndexOrThrow(C0644f.this.f3776L);
                this.f3809b = cursor2.getColumnIndexOrThrow(C0644f.this.f3777M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f3808a));
                this.f3810c.setItemChecked(cursor.getPosition(), cursor.getInt(this.f3809b) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return C0644f.this.f3781b.inflate(this.f3811d.f3719M, viewGroup, false);
            }
        }

        /* renamed from: android.support.v7.app.AlertController$f$c */
        /* loaded from: classes.dex */
        public class C0647c implements AdapterView.OnItemClickListener {

            /* renamed from: a */
            public final /* synthetic */ AlertController f3813a;

            public C0647c(AlertController alertController) {
                this.f3813a = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                C0644f.this.f3803x.onClick(this.f3813a.f3727b, i);
                if (C0644f.this.f3772H) {
                    return;
                }
                this.f3813a.f3727b.dismiss();
            }
        }

        /* renamed from: android.support.v7.app.AlertController$f$d */
        /* loaded from: classes.dex */
        public class C0648d implements AdapterView.OnItemClickListener {

            /* renamed from: a */
            public final /* synthetic */ RecycleListView f3815a;

            /* renamed from: b */
            public final /* synthetic */ AlertController f3816b;

            public C0648d(RecycleListView recycleListView, AlertController alertController) {
                this.f3815a = recycleListView;
                this.f3816b = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                boolean[] zArr = C0644f.this.f3770F;
                if (zArr != null) {
                    zArr[i] = this.f3815a.isItemChecked(i);
                }
                C0644f.this.f3774J.onClick(this.f3816b.f3727b, i, this.f3815a.isItemChecked(i));
            }
        }

        /* renamed from: android.support.v7.app.AlertController$f$e */
        /* loaded from: classes.dex */
        public interface InterfaceC0649e {
            /* renamed from: a */
            void m7280a(ListView listView);
        }

        public C0644f(Context context) {
            this.f3780a = context;
            this.f3781b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* renamed from: a */
        public void m7282a(AlertController alertController) {
            View view = this.f3786g;
            if (view != null) {
                alertController.m7303a(view);
            } else {
                CharSequence charSequence = this.f3785f;
                if (charSequence != null) {
                    alertController.m7290b(charSequence);
                }
                Drawable drawable = this.f3783d;
                if (drawable != null) {
                    alertController.m7304a(drawable);
                }
                int i = this.f3782c;
                if (i != 0) {
                    alertController.m7294b(i);
                }
                int i2 = this.f3784e;
                if (i2 != 0) {
                    alertController.m7294b(alertController.m7308a(i2));
                }
            }
            CharSequence charSequence2 = this.f3787h;
            if (charSequence2 != null) {
                alertController.m7296a(charSequence2);
            }
            if (this.f3788i != null || this.f3789j != null) {
                alertController.m7306a(-1, this.f3788i, this.f3790k, (Message) null, this.f3789j);
            }
            if (this.f3791l != null || this.f3792m != null) {
                alertController.m7306a(-2, this.f3791l, this.f3793n, (Message) null, this.f3792m);
            }
            if (this.f3794o != null || this.f3795p != null) {
                alertController.m7306a(-3, this.f3794o, this.f3796q, (Message) null, this.f3795p);
            }
            if (this.f3801v != null || this.f3775K != null || this.f3802w != null) {
                m7281b(alertController);
            }
            View view2 = this.f3805z;
            if (view2 != null) {
                if (this.f3769E) {
                    alertController.m7302a(view2, this.f3765A, this.f3766B, this.f3767C, this.f3768D);
                    return;
                } else {
                    alertController.m7292b(view2);
                    return;
                }
            }
            int i3 = this.f3804y;
            if (i3 != 0) {
                alertController.m7288c(i3);
            }
        }

        /* renamed from: b */
        public final void m7281b(AlertController alertController) {
            int i;
            ListAdapter listAdapter;
            RecycleListView recycleListView = (RecycleListView) this.f3781b.inflate(alertController.f3718L, (ViewGroup) null);
            if (this.f3771G) {
                Cursor cursor = this.f3775K;
                if (cursor == null) {
                    listAdapter = new C0645a(this.f3780a, alertController.f3719M, 16908308, this.f3801v, recycleListView);
                } else {
                    listAdapter = new C0646b(this.f3780a, cursor, false, recycleListView, alertController);
                }
            } else {
                if (this.f3772H) {
                    i = alertController.f3720N;
                } else {
                    i = alertController.f3721O;
                }
                int i2 = i;
                Cursor cursor2 = this.f3775K;
                if (cursor2 != null) {
                    listAdapter = new SimpleCursorAdapter(this.f3780a, i2, cursor2, new String[]{this.f3776L}, new int[]{16908308});
                } else {
                    listAdapter = this.f3802w;
                    if (listAdapter == null) {
                        listAdapter = new C0651h(this.f3780a, i2, 16908308, this.f3801v);
                    }
                }
            }
            InterfaceC0649e interfaceC0649e = this.f3779O;
            if (interfaceC0649e != null) {
                interfaceC0649e.m7280a(recycleListView);
            }
            alertController.f3714H = listAdapter;
            alertController.f3715I = this.f3773I;
            if (this.f3803x != null) {
                recycleListView.setOnItemClickListener(new C0647c(alertController));
            } else if (this.f3774J != null) {
                recycleListView.setOnItemClickListener(new C0648d(recycleListView, alertController));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f3778N;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.f3772H) {
                recycleListView.setChoiceMode(1);
            } else if (this.f3771G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f3732g = recycleListView;
        }
    }

    /* renamed from: android.support.v7.app.AlertController$g */
    /* loaded from: classes.dex */
    public static final class HandlerC0650g extends Handler {

        /* renamed from: a */
        public WeakReference<DialogInterface> f3818a;

        public HandlerC0650g(DialogInterface dialogInterface) {
            this.f3818a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == -3 || i == -2 || i == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f3818a.get(), message.what);
            } else if (i != 1) {
            } else {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* renamed from: android.support.v7.app.AlertController$h */
    /* loaded from: classes.dex */
    public static class C0651h extends ArrayAdapter<CharSequence> {
        public C0651h(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        this.f3726a = context;
        this.f3727b = appCompatDialog;
        this.f3728c = window;
        this.f3724R = new HandlerC0650g(appCompatDialog);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, C0363j.AlertDialog, C0354a.alertDialogStyle, 0);
        this.f3716J = obtainStyledAttributes.getResourceId(C0363j.AlertDialog_android_layout, 0);
        this.f3717K = obtainStyledAttributes.getResourceId(C0363j.AlertDialog_buttonPanelSideLayout, 0);
        this.f3718L = obtainStyledAttributes.getResourceId(C0363j.AlertDialog_listLayout, 0);
        this.f3719M = obtainStyledAttributes.getResourceId(C0363j.AlertDialog_multiChoiceItemLayout, 0);
        this.f3720N = obtainStyledAttributes.getResourceId(C0363j.AlertDialog_singleChoiceItemLayout, 0);
        this.f3721O = obtainStyledAttributes.getResourceId(C0363j.AlertDialog_listItemLayout, 0);
        this.f3722P = obtainStyledAttributes.getBoolean(C0363j.AlertDialog_showTitle, true);
        this.f3729d = obtainStyledAttributes.getDimensionPixelSize(C0363j.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        appCompatDialog.m9031a(1);
    }

    /* renamed from: a */
    public static boolean m7305a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0354a.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    /* renamed from: c */
    public static boolean m7287c(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            while (childCount > 0) {
                childCount--;
                if (m7287c(viewGroup.getChildAt(childCount))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* renamed from: b */
    public final int m7295b() {
        int i = this.f3717K;
        if (i == 0) {
            return this.f3716J;
        }
        return this.f3723Q == 1 ? i : this.f3716J;
    }

    /* renamed from: d */
    public final void m7285d(ViewGroup viewGroup) {
        if (this.f3713G != null) {
            viewGroup.addView(this.f3713G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f3728c.findViewById(C0359f.title_template).setVisibility(8);
            return;
        }
        this.f3710D = (ImageView) this.f3728c.findViewById(16908294);
        if ((!TextUtils.isEmpty(this.f3730e)) && this.f3722P) {
            this.f3711E = (TextView) this.f3728c.findViewById(C0359f.alertTitle);
            this.f3711E.setText(this.f3730e);
            int i = this.f3708B;
            if (i != 0) {
                this.f3710D.setImageResource(i);
                return;
            }
            Drawable drawable = this.f3709C;
            if (drawable != null) {
                this.f3710D.setImageDrawable(drawable);
                return;
            }
            this.f3711E.setPadding(this.f3710D.getPaddingLeft(), this.f3710D.getPaddingTop(), this.f3710D.getPaddingRight(), this.f3710D.getPaddingBottom());
            this.f3710D.setVisibility(8);
            return;
        }
        this.f3728c.findViewById(C0359f.title_template).setVisibility(8);
        this.f3710D.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    /* renamed from: a */
    public void m7309a() {
        this.f3727b.setContentView(m7295b());
        m7289c();
    }

    /* renamed from: b */
    public void m7290b(CharSequence charSequence) {
        this.f3730e = charSequence;
        TextView textView = this.f3711E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* renamed from: a */
    public void m7303a(View view) {
        this.f3713G = view;
    }

    /* renamed from: c */
    public void m7288c(int i) {
        this.f3733h = null;
        this.f3734i = i;
        this.f3739n = false;
    }

    /* renamed from: a */
    public void m7296a(CharSequence charSequence) {
        this.f3731f = charSequence;
        TextView textView = this.f3712F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* renamed from: b */
    public void m7292b(View view) {
        this.f3733h = view;
        this.f3734i = 0;
        this.f3739n = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    public final void m7289c() {
        View findViewById;
        ListAdapter listAdapter;
        View findViewById2;
        View findViewById3 = this.f3728c.findViewById(C0359f.parentPanel);
        View findViewById4 = findViewById3.findViewById(C0359f.topPanel);
        View findViewById5 = findViewById3.findViewById(C0359f.contentPanel);
        View findViewById6 = findViewById3.findViewById(C0359f.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(C0359f.customPanel);
        m7286c(viewGroup);
        View findViewById7 = viewGroup.findViewById(C0359f.topPanel);
        View findViewById8 = viewGroup.findViewById(C0359f.contentPanel);
        View findViewById9 = viewGroup.findViewById(C0359f.buttonPanel);
        ViewGroup m7301a = m7301a(findViewById7, findViewById4);
        ViewGroup m7301a2 = m7301a(findViewById8, findViewById5);
        ViewGroup m7301a3 = m7301a(findViewById9, findViewById6);
        m7291b(m7301a2);
        m7299a(m7301a3);
        m7285d(m7301a);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (m7301a == null || m7301a.getVisibility() == 8) ? 0 : 1;
        boolean z3 = (m7301a3 == null || m7301a3.getVisibility() == 8) ? false : true;
        if (!z3 && m7301a2 != null && (findViewById2 = m7301a2.findViewById(C0359f.textSpacerNoButtons)) != null) {
            findViewById2.setVisibility(0);
        }
        if (z2) {
            NestedScrollView nestedScrollView = this.f3707A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View view = null;
            if (this.f3731f != null || this.f3732g != null) {
                view = m7301a.findViewById(C0359f.titleDividerNoCustom);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (m7301a2 != null && (findViewById = m7301a2.findViewById(C0359f.textSpacerNoTitle)) != null) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f3732g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).m7284a(z2, z3);
        }
        if (!z) {
            View view2 = this.f3732g;
            if (view2 == null) {
                view2 = this.f3707A;
            }
            if (view2 != null) {
                m7298a(m7301a2, view2, z2 | (z3 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f3732g;
        if (listView2 == null || (listAdapter = this.f3714H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i = this.f3715I;
        if (i > -1) {
            listView2.setItemChecked(i, true);
            listView2.setSelection(i);
        }
    }

    /* renamed from: a */
    public void m7302a(View view, int i, int i2, int i3, int i4) {
        this.f3733h = view;
        this.f3734i = 0;
        this.f3739n = true;
        this.f3735j = i;
        this.f3736k = i2;
        this.f3737l = i3;
        this.f3738m = i4;
    }

    /* renamed from: b */
    public void m7294b(int i) {
        this.f3709C = null;
        this.f3708B = i;
        ImageView imageView = this.f3710D;
        if (imageView != null) {
            if (i != 0) {
                imageView.setVisibility(0);
                this.f3710D.setImageResource(this.f3708B);
                return;
            }
            imageView.setVisibility(8);
        }
    }

    /* renamed from: b */
    public boolean m7293b(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f3707A;
        return nestedScrollView != null && nestedScrollView.m7362a(keyEvent);
    }

    /* renamed from: a */
    public void m7306a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f3724R.obtainMessage(i, onClickListener);
        }
        if (i == -3) {
            this.f3749x = charSequence;
            this.f3750y = message;
            this.f3751z = drawable;
        } else if (i == -2) {
            this.f3745t = charSequence;
            this.f3746u = message;
            this.f3747v = drawable;
        } else if (i == -1) {
            this.f3741p = charSequence;
            this.f3742q = message;
            this.f3743r = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    /* renamed from: b */
    public final void m7291b(ViewGroup viewGroup) {
        this.f3707A = (NestedScrollView) this.f3728c.findViewById(C0359f.scrollView);
        this.f3707A.setFocusable(false);
        this.f3707A.setNestedScrollingEnabled(false);
        this.f3712F = (TextView) viewGroup.findViewById(16908299);
        TextView textView = this.f3712F;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f3731f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.f3707A.removeView(this.f3712F);
        if (this.f3732g != null) {
            ViewGroup viewGroup2 = (ViewGroup) this.f3707A.getParent();
            int indexOfChild = viewGroup2.indexOfChild(this.f3707A);
            viewGroup2.removeViewAt(indexOfChild);
            viewGroup2.addView(this.f3732g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* renamed from: a */
    public void m7304a(Drawable drawable) {
        this.f3709C = drawable;
        this.f3708B = 0;
        ImageView imageView = this.f3710D;
        if (imageView != null) {
            if (drawable != null) {
                imageView.setVisibility(0);
                this.f3710D.setImageDrawable(drawable);
                return;
            }
            imageView.setVisibility(8);
        }
    }

    /* renamed from: a */
    public int m7308a(int i) {
        TypedValue typedValue = new TypedValue();
        this.f3726a.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    /* renamed from: a */
    public boolean m7307a(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f3707A;
        return nestedScrollView != null && nestedScrollView.m7362a(keyEvent);
    }

    /* renamed from: a */
    public final ViewGroup m7301a(View view, View view2) {
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

    /* renamed from: c */
    public final void m7286c(ViewGroup viewGroup) {
        View view = this.f3733h;
        if (view == null) {
            view = this.f3734i != 0 ? LayoutInflater.from(this.f3726a).inflate(this.f3734i, viewGroup, false) : null;
        }
        boolean z = view != null;
        if (!z || !m7287c(view)) {
            this.f3728c.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f3728c.findViewById(C0359f.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.f3739n) {
                frameLayout.setPadding(this.f3735j, this.f3736k, this.f3737l, this.f3738m);
            }
            if (this.f3732g != null) {
                ((LinearLayoutCompat.C0492a) viewGroup.getLayoutParams()).f2899a = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* renamed from: a */
    public final void m7298a(ViewGroup viewGroup, View view, int i, int i2) {
        View findViewById = this.f3728c.findViewById(C0359f.scrollIndicatorUp);
        View findViewById2 = this.f3728c.findViewById(C0359f.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            ViewCompat.m9456a(view, i, i2);
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
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById == null && view2 == null) {
            return;
        }
        if (this.f3731f != null) {
            this.f3707A.setOnScrollChangeListener(new C0640b(this, findViewById, view2));
            this.f3707A.post(new RunnableC0641c(findViewById, view2));
            return;
        }
        ListView listView = this.f3732g;
        if (listView != null) {
            listView.setOnScrollListener(new C0642d(this, findViewById, view2));
            this.f3732g.post(new RunnableC0643e(findViewById, view2));
            return;
        }
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        if (view2 != null) {
            viewGroup.removeView(view2);
        }
    }

    /* renamed from: a */
    public static void m7300a(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    /* renamed from: a */
    public final void m7299a(ViewGroup viewGroup) {
        boolean z;
        this.f3740o = (Button) viewGroup.findViewById(16908313);
        this.f3740o.setOnClickListener(this.f3725S);
        if (TextUtils.isEmpty(this.f3741p) && this.f3743r == null) {
            this.f3740o.setVisibility(8);
            z = false;
        } else {
            this.f3740o.setText(this.f3741p);
            Drawable drawable = this.f3743r;
            if (drawable != null) {
                int i = this.f3729d;
                drawable.setBounds(0, 0, i, i);
                this.f3740o.setCompoundDrawables(this.f3743r, null, null, null);
            }
            this.f3740o.setVisibility(0);
            z = true;
        }
        this.f3744s = (Button) viewGroup.findViewById(16908314);
        this.f3744s.setOnClickListener(this.f3725S);
        if (TextUtils.isEmpty(this.f3745t) && this.f3747v == null) {
            this.f3744s.setVisibility(8);
        } else {
            this.f3744s.setText(this.f3745t);
            Drawable drawable2 = this.f3747v;
            if (drawable2 != null) {
                int i2 = this.f3729d;
                drawable2.setBounds(0, 0, i2, i2);
                this.f3744s.setCompoundDrawables(this.f3747v, null, null, null);
            }
            this.f3744s.setVisibility(0);
            z |= true;
        }
        this.f3748w = (Button) viewGroup.findViewById(16908315);
        this.f3748w.setOnClickListener(this.f3725S);
        if (TextUtils.isEmpty(this.f3749x) && this.f3751z == null) {
            this.f3748w.setVisibility(8);
        } else {
            this.f3748w.setText(this.f3749x);
            Drawable drawable3 = this.f3743r;
            if (drawable3 != null) {
                int i3 = this.f3729d;
                drawable3.setBounds(0, 0, i3, i3);
                this.f3740o.setCompoundDrawables(this.f3743r, null, null, null);
            }
            this.f3748w.setVisibility(0);
            z |= true;
        }
        if (m7305a(this.f3726a)) {
            if (z) {
                m7297a(this.f3740o);
            } else if (z) {
                m7297a(this.f3744s);
            } else if (z) {
                m7297a(this.f3748w);
            }
        }
        if (z) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* renamed from: a */
    public final void m7297a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }
}
