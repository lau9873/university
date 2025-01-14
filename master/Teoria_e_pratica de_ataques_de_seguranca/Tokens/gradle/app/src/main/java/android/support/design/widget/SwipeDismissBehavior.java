package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p030g.p048l.ViewDragHelper;

/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.AbstractC0575c<V> {

    /* renamed from: a */
    public ViewDragHelper f3377a;

    /* renamed from: b */
    public InterfaceC0589b f3378b;

    /* renamed from: c */
    public boolean f3379c;

    /* renamed from: e */
    public boolean f3381e;

    /* renamed from: d */
    public float f3380d = 0.0f;

    /* renamed from: f */
    public int f3382f = 2;

    /* renamed from: g */
    public float f3383g = 0.5f;

    /* renamed from: h */
    public float f3384h = 0.0f;

    /* renamed from: i */
    public float f3385i = 0.5f;

    /* renamed from: j */
    public final ViewDragHelper.AbstractC0320c f3386j = new C0588a();

    /* renamed from: android.support.design.widget.SwipeDismissBehavior$a */
    /* loaded from: classes.dex */
    public class C0588a extends ViewDragHelper.AbstractC0320c {

        /* renamed from: a */
        public int f3387a;

        /* renamed from: b */
        public int f3388b = -1;

        public C0588a() {
        }

        @Override // p000a.p006b.p030g.p048l.ViewDragHelper.AbstractC0320c
        /* renamed from: a */
        public void mo7598a(View view, int i) {
            this.f3388b = i;
            this.f3387a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // p000a.p006b.p030g.p048l.ViewDragHelper.AbstractC0320c
        /* renamed from: b */
        public boolean mo7595b(View view, int i) {
            return this.f3388b == -1 && SwipeDismissBehavior.this.mo7606a(view);
        }

        @Override // p000a.p006b.p030g.p048l.ViewDragHelper.AbstractC0320c
        /* renamed from: c */
        public void mo7593c(int i) {
            InterfaceC0589b interfaceC0589b = SwipeDismissBehavior.this.f3378b;
            if (interfaceC0589b != null) {
                interfaceC0589b.mo7592a(i);
            }
        }

        @Override // p000a.p006b.p030g.p048l.ViewDragHelper.AbstractC0320c
        /* renamed from: b */
        public int mo7594b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // p000a.p006b.p030g.p048l.ViewDragHelper.AbstractC0320c
        /* renamed from: a */
        public void mo7599a(View view, float f, float f2) {
            int i;
            boolean z;
            InterfaceC0589b interfaceC0589b;
            this.f3388b = -1;
            int width = view.getWidth();
            if (m7600a(view, f)) {
                int left = view.getLeft();
                int i2 = this.f3387a;
                i = left < i2 ? i2 - width : i2 + width;
                z = true;
            } else {
                i = this.f3387a;
                z = false;
            }
            if (SwipeDismissBehavior.this.f3377a.m9164d(i, view.getTop())) {
                ViewCompat.m9445a(view, new RunnableC0590c(view, z));
            } else if (!z || (interfaceC0589b = SwipeDismissBehavior.this.f3378b) == null) {
            } else {
                interfaceC0589b.mo7591a(view);
            }
        }

        /* renamed from: a */
        public final boolean m7600a(View view, float f) {
            int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            if (i == 0) {
                return Math.abs(view.getLeft() - this.f3387a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f3383g);
            }
            boolean z = ViewCompat.m9422k(view) == 1;
            int i2 = SwipeDismissBehavior.this.f3382f;
            if (i2 == 2) {
                return true;
            }
            if (i2 == 0) {
                if (z) {
                    if (f >= 0.0f) {
                        return false;
                    }
                } else if (i <= 0) {
                    return false;
                }
                return true;
            } else if (i2 == 1) {
                if (z) {
                    if (i <= 0) {
                        return false;
                    }
                } else if (f >= 0.0f) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        }

        @Override // p000a.p006b.p030g.p048l.ViewDragHelper.AbstractC0320c
        /* renamed from: a */
        public int mo7601a(View view) {
            return view.getWidth();
        }

        @Override // p000a.p006b.p030g.p048l.ViewDragHelper.AbstractC0320c
        /* renamed from: a */
        public int mo7597a(View view, int i, int i2) {
            int width;
            int width2;
            int width3;
            boolean z = ViewCompat.m9422k(view) == 1;
            int i3 = SwipeDismissBehavior.this.f3382f;
            if (i3 == 0) {
                if (z) {
                    width = this.f3387a - view.getWidth();
                    width2 = this.f3387a;
                } else {
                    width = this.f3387a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i3 != 1) {
                width = this.f3387a - view.getWidth();
                width2 = view.getWidth() + this.f3387a;
            } else if (z) {
                width = this.f3387a;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.f3387a - view.getWidth();
                width2 = this.f3387a;
            }
            return SwipeDismissBehavior.m7609a(width, i, width2);
        }

        @Override // p000a.p006b.p030g.p048l.ViewDragHelper.AbstractC0320c
        /* renamed from: a */
        public void mo7596a(View view, int i, int i2, int i3, int i4) {
            float width = this.f3387a + (view.getWidth() * SwipeDismissBehavior.this.f3384h);
            float width2 = this.f3387a + (view.getWidth() * SwipeDismissBehavior.this.f3385i);
            float f = i;
            if (f <= width) {
                view.setAlpha(1.0f);
            } else if (f >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.m7611a(0.0f, 1.0f - SwipeDismissBehavior.m7603b(width, width2, f), 1.0f));
            }
        }
    }

    /* renamed from: android.support.design.widget.SwipeDismissBehavior$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0589b {
        /* renamed from: a */
        void mo7592a(int i);

        /* renamed from: a */
        void mo7591a(View view);
    }

    /* renamed from: android.support.design.widget.SwipeDismissBehavior$c */
    /* loaded from: classes.dex */
    public class RunnableC0590c implements Runnable {

        /* renamed from: a */
        public final View f3390a;

        /* renamed from: b */
        public final boolean f3391b;

        public RunnableC0590c(View view, boolean z) {
            this.f3390a = view;
            this.f3391b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC0589b interfaceC0589b;
            ViewDragHelper viewDragHelper = SwipeDismissBehavior.this.f3377a;
            if (viewDragHelper != null && viewDragHelper.m9180a(true)) {
                ViewCompat.m9445a(this.f3390a, this);
            } else if (!this.f3391b || (interfaceC0589b = SwipeDismissBehavior.this.f3378b) == null) {
            } else {
                interfaceC0589b.mo7591a(this.f3390a);
            }
        }
    }

    /* renamed from: b */
    public static float m7603b(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    /* renamed from: a */
    public void m7607a(InterfaceC0589b interfaceC0589b) {
        this.f3378b = interfaceC0589b;
    }

    /* renamed from: a */
    public boolean mo7606a(View view) {
        return true;
    }

    /* renamed from: b */
    public void m7604b(float f) {
        this.f3384h = m7611a(0.0f, f, 1.0f);
    }

    /* renamed from: a */
    public void m7610a(int i) {
        this.f3382f = i;
    }

    @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
    /* renamed from: b */
    public boolean mo7602b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper = this.f3377a;
        if (viewDragHelper != null) {
            viewDragHelper.m9187a(motionEvent);
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void m7612a(float f) {
        this.f3385i = m7611a(0.0f, f, 1.0f);
    }

    @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
    /* renamed from: a */
    public boolean mo7608a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.f3379c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f3379c = coordinatorLayout.m7744a(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            z = this.f3379c;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f3379c = false;
        }
        if (z) {
            m7605a((ViewGroup) coordinatorLayout);
            return this.f3377a.m9167c(motionEvent);
        }
        return false;
    }

    /* renamed from: a */
    public final void m7605a(ViewGroup viewGroup) {
        ViewDragHelper m9181a;
        if (this.f3377a == null) {
            if (this.f3381e) {
                m9181a = ViewDragHelper.m9182a(viewGroup, this.f3380d, this.f3386j);
            } else {
                m9181a = ViewDragHelper.m9181a(viewGroup, this.f3386j);
            }
            this.f3377a = m9181a;
        }
    }

    /* renamed from: a */
    public static float m7611a(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    /* renamed from: a */
    public static int m7609a(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }
}
