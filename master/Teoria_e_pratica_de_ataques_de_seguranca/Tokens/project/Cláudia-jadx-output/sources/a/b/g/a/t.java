package a.b.g.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* compiled from: FragmentTransitionImpl.java */
/* loaded from: classes.dex */
public abstract class t {

    /* compiled from: FragmentTransitionImpl.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f799a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f800b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ArrayList f801c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ArrayList f802d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ArrayList f803e;

        public a(t tVar, int i2, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f799a = i2;
            this.f800b = arrayList;
            this.f801c = arrayList2;
            this.f802d = arrayList3;
            this.f803e = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i2 = 0; i2 < this.f799a; i2++) {
                a.b.g.k.u.a((View) this.f800b.get(i2), (String) this.f801c.get(i2));
                a.b.g.k.u.a((View) this.f802d.get(i2), (String) this.f803e.get(i2));
            }
        }
    }

    /* compiled from: FragmentTransitionImpl.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ArrayList f804a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Map f805b;

        public b(t tVar, ArrayList arrayList, Map map) {
            this.f804a = arrayList;
            this.f805b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f804a.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) this.f804a.get(i2);
                String p = a.b.g.k.u.p(view);
                if (p != null) {
                    a.b.g.k.u.a(view, t.a(this.f805b, p));
                }
            }
        }
    }

    /* compiled from: FragmentTransitionImpl.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ArrayList f806a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Map f807b;

        public c(t tVar, ArrayList arrayList, Map map) {
            this.f806a = arrayList;
            this.f807b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f806a.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) this.f806a.get(i2);
                a.b.g.k.u.a(view, (String) this.f807b.get(a.b.g.k.u.p(view)));
            }
        }
    }

    public abstract Object a(Object obj, Object obj2, Object obj3);

    public void a(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    public abstract void a(ViewGroup viewGroup, Object obj);

    public abstract void a(Object obj, Rect rect);

    public abstract void a(Object obj, View view);

    public abstract void a(Object obj, View view, ArrayList<View> arrayList);

    public abstract void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void a(Object obj, ArrayList<View> arrayList);

    public abstract void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract boolean a(Object obj);

    public abstract Object b(Object obj);

    public abstract Object b(Object obj, Object obj2, Object obj3);

    public abstract void b(Object obj, View view);

    public abstract void b(Object obj, View view, ArrayList<View> arrayList);

    public abstract void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object c(Object obj);

    public abstract void c(Object obj, View view);

    public ArrayList<String> a(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = arrayList.get(i2);
            arrayList2.add(a.b.g.k.u.p(view));
            a.b.g.k.u.a(view, (String) null);
        }
        return arrayList2;
    }

    public void a(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = arrayList.get(i2);
            String p = a.b.g.k.u.p(view2);
            arrayList4.add(p);
            if (p != null) {
                a.b.g.k.u.a(view2, (String) null);
                String str = map.get(p);
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    } else if (str.equals(arrayList3.get(i3))) {
                        a.b.g.k.u.a(arrayList2.get(i3), p);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        c0.a(view, new a(this, size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public void a(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (a.b.g.k.w.a(viewGroup)) {
                    arrayList.add(viewGroup);
                    return;
                }
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    a(arrayList, viewGroup.getChildAt(i2));
                }
                return;
            }
            arrayList.add(view);
        }
    }

    public void a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String p = a.b.g.k.u.p(view);
            if (p != null) {
                map.put(p, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    a(map, viewGroup.getChildAt(i2));
                }
            }
        }
    }

    public void a(View view, ArrayList<View> arrayList, Map<String, String> map) {
        c0.a(view, new b(this, arrayList, map));
    }

    public void a(ViewGroup viewGroup, ArrayList<View> arrayList, Map<String, String> map) {
        c0.a(viewGroup, new c(this, arrayList, map));
    }

    public static void a(List<View> list, View view) {
        int size = list.size();
        if (a(list, view, size)) {
            return;
        }
        list.add(view);
        for (int i2 = size; i2 < list.size(); i2++) {
            View view2 = list.get(i2);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = viewGroup.getChildAt(i3);
                    if (!a(list, childAt, size)) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    public static boolean a(List<View> list, View view, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (list.get(i3) == view) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(List list) {
        return list == null || list.isEmpty();
    }

    public static String a(Map<String, String> map, String str) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
