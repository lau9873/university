package android.support.design.widget;

import a.b.g.k.u;
import a.b.g.l.s;
import android.support.design.widget.CoordinatorLayout;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a  reason: collision with root package name */
    public s f2216a;

    /* renamed from: b  reason: collision with root package name */
    public b f2217b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2218c;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2220e;

    /* renamed from: d  reason: collision with root package name */
    public float f2219d = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public int f2221f = 2;

    /* renamed from: g  reason: collision with root package name */
    public float f2222g = 0.5f;

    /* renamed from: h  reason: collision with root package name */
    public float f2223h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    public float f2224i = 0.5f;
    public final s.c j = new a();

    /* loaded from: classes.dex */
    public class a extends s.c {

        /* renamed from: a  reason: collision with root package name */
        public int f2225a;

        /* renamed from: b  reason: collision with root package name */
        public int f2226b = -1;

        public a() {
        }

        @Override // a.b.g.l.s.c
        public void a(View view, int i2) {
            this.f2226b = i2;
            this.f2225a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // a.b.g.l.s.c
        public boolean b(View view, int i2) {
            return this.f2226b == -1 && SwipeDismissBehavior.this.a(view);
        }

        @Override // a.b.g.l.s.c
        public void c(int i2) {
            b bVar = SwipeDismissBehavior.this.f2217b;
            if (bVar != null) {
                bVar.a(i2);
            }
        }

        @Override // a.b.g.l.s.c
        public int b(View view, int i2, int i3) {
            return view.getTop();
        }

        @Override // a.b.g.l.s.c
        public void a(View view, float f2, float f3) {
            int i2;
            boolean z;
            b bVar;
            this.f2226b = -1;
            int width = view.getWidth();
            if (a(view, f2)) {
                int left = view.getLeft();
                int i3 = this.f2225a;
                i2 = left < i3 ? i3 - width : i3 + width;
                z = true;
            } else {
                i2 = this.f2225a;
                z = false;
            }
            if (SwipeDismissBehavior.this.f2216a.d(i2, view.getTop())) {
                u.a(view, new c(view, z));
            } else if (!z || (bVar = SwipeDismissBehavior.this.f2217b) == null) {
            } else {
                bVar.a(view);
            }
        }

        public final boolean a(View view, float f2) {
            int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i2 == 0) {
                return Math.abs(view.getLeft() - this.f2225a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f2222g);
            }
            boolean z = u.k(view) == 1;
            int i3 = SwipeDismissBehavior.this.f2221f;
            if (i3 == 2) {
                return true;
            }
            if (i3 == 0) {
                if (z) {
                    if (f2 >= 0.0f) {
                        return false;
                    }
                } else if (i2 <= 0) {
                    return false;
                }
                return true;
            } else if (i3 == 1) {
                if (z) {
                    if (i2 <= 0) {
                        return false;
                    }
                } else if (f2 >= 0.0f) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        }

        @Override // a.b.g.l.s.c
        public int a(View view) {
            return view.getWidth();
        }

        @Override // a.b.g.l.s.c
        public int a(View view, int i2, int i3) {
            int width;
            int width2;
            int width3;
            boolean z = u.k(view) == 1;
            int i4 = SwipeDismissBehavior.this.f2221f;
            if (i4 == 0) {
                if (z) {
                    width = this.f2225a - view.getWidth();
                    width2 = this.f2225a;
                } else {
                    width = this.f2225a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i4 != 1) {
                width = this.f2225a - view.getWidth();
                width2 = view.getWidth() + this.f2225a;
            } else if (z) {
                width = this.f2225a;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.f2225a - view.getWidth();
                width2 = this.f2225a;
            }
            return SwipeDismissBehavior.a(width, i2, width2);
        }

        @Override // a.b.g.l.s.c
        public void a(View view, int i2, int i3, int i4, int i5) {
            float width = this.f2225a + (view.getWidth() * SwipeDismissBehavior.this.f2223h);
            float width2 = this.f2225a + (view.getWidth() * SwipeDismissBehavior.this.f2224i);
            float f2 = i2;
            if (f2 <= width) {
                view.setAlpha(1.0f);
            } else if (f2 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.a(0.0f, 1.0f - SwipeDismissBehavior.b(width, width2, f2), 1.0f));
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i2);

        void a(View view);
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final View f2228a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f2229b;

        public c(View view, boolean z) {
            this.f2228a = view;
            this.f2229b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            s sVar = SwipeDismissBehavior.this.f2216a;
            if (sVar != null && sVar.a(true)) {
                u.a(this.f2228a, this);
            } else if (!this.f2229b || (bVar = SwipeDismissBehavior.this.f2217b) == null) {
            } else {
                bVar.a(this.f2228a);
            }
        }
    }

    public static float b(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    public void a(b bVar) {
        this.f2217b = bVar;
    }

    public boolean a(View view) {
        return true;
    }

    public void b(float f2) {
        this.f2223h = a(0.0f, f2, 1.0f);
    }

    public void a(int i2) {
        this.f2221f = i2;
    }

    @Override // android.support.design.widget.CoordinatorLayout.c
    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        s sVar = this.f2216a;
        if (sVar != null) {
            sVar.a(motionEvent);
            return true;
        }
        return false;
    }

    public void a(float f2) {
        this.f2224i = a(0.0f, f2, 1.0f);
    }

    @Override // android.support.design.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.f2218c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2218c = coordinatorLayout.a(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            z = this.f2218c;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f2218c = false;
        }
        if (z) {
            a((ViewGroup) coordinatorLayout);
            return this.f2216a.c(motionEvent);
        }
        return false;
    }

    public final void a(ViewGroup viewGroup) {
        s a2;
        if (this.f2216a == null) {
            if (this.f2220e) {
                a2 = s.a(viewGroup, this.f2219d, this.j);
            } else {
                a2 = s.a(viewGroup, this.j);
            }
            this.f2216a = a2;
        }
    }

    public static float a(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    public static int a(int i2, int i3, int i4) {
        return Math.min(Math.max(i2, i3), i4);
    }
}
