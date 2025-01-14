package p000a.p006b.p030g.p031a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p030g.p045k.ViewGroupCompat;

/* renamed from: a.b.g.a.t */
/* loaded from: classes.dex */
public abstract class FragmentTransitionImpl {

    /* compiled from: FragmentTransitionImpl.java */
    /* renamed from: a.b.g.a.t$a */
    /* loaded from: classes.dex */
    public class RunnableC0181a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ int f1270a;

        /* renamed from: b */
        public final /* synthetic */ ArrayList f1271b;

        /* renamed from: c */
        public final /* synthetic */ ArrayList f1272c;

        /* renamed from: d */
        public final /* synthetic */ ArrayList f1273d;

        /* renamed from: e */
        public final /* synthetic */ ArrayList f1274e;

        public RunnableC0181a(FragmentTransitionImpl fragmentTransitionImpl, int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f1270a = i;
            this.f1271b = arrayList;
            this.f1272c = arrayList2;
            this.f1273d = arrayList3;
            this.f1274e = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i = 0; i < this.f1270a; i++) {
                ViewCompat.m9443a((View) this.f1271b.get(i), (String) this.f1272c.get(i));
                ViewCompat.m9443a((View) this.f1273d.get(i), (String) this.f1274e.get(i));
            }
        }
    }

    /* compiled from: FragmentTransitionImpl.java */
    /* renamed from: a.b.g.a.t$b */
    /* loaded from: classes.dex */
    public class RunnableC0182b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ ArrayList f1275a;

        /* renamed from: b */
        public final /* synthetic */ Map f1276b;

        public RunnableC0182b(FragmentTransitionImpl fragmentTransitionImpl, ArrayList arrayList, Map map) {
            this.f1275a = arrayList;
            this.f1276b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f1275a.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.f1275a.get(i);
                String m9417p = ViewCompat.m9417p(view);
                if (m9417p != null) {
                    ViewCompat.m9443a(view, FragmentTransitionImpl.m10088a(this.f1276b, m9417p));
                }
            }
        }
    }

    /* compiled from: FragmentTransitionImpl.java */
    /* renamed from: a.b.g.a.t$c */
    /* loaded from: classes.dex */
    public class RunnableC0183c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ ArrayList f1277a;

        /* renamed from: b */
        public final /* synthetic */ Map f1278b;

        public RunnableC0183c(FragmentTransitionImpl fragmentTransitionImpl, ArrayList arrayList, Map map) {
            this.f1277a = arrayList;
            this.f1278b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f1277a.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.f1277a.get(i);
                ViewCompat.m9443a(view, (String) this.f1278b.get(ViewCompat.m9417p(view)));
            }
        }
    }

    /* renamed from: a */
    public abstract Object mo10098a(Object obj, Object obj2, Object obj3);

    /* renamed from: a */
    public void m10107a(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    /* renamed from: a */
    public abstract void mo10104a(ViewGroup viewGroup, Object obj);

    /* renamed from: a */
    public abstract void mo10101a(Object obj, Rect rect);

    /* renamed from: a */
    public abstract void mo10100a(Object obj, View view);

    /* renamed from: a */
    public abstract void mo10099a(Object obj, View view, ArrayList<View> arrayList);

    /* renamed from: a */
    public abstract void mo10097a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    /* renamed from: a */
    public abstract void mo10096a(Object obj, ArrayList<View> arrayList);

    /* renamed from: a */
    public abstract void mo10095a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    /* renamed from: a */
    public abstract boolean mo10102a(Object obj);

    /* renamed from: b */
    public abstract Object mo10087b(Object obj);

    /* renamed from: b */
    public abstract Object mo10084b(Object obj, Object obj2, Object obj3);

    /* renamed from: b */
    public abstract void mo10086b(Object obj, View view);

    /* renamed from: b */
    public abstract void mo10085b(Object obj, View view, ArrayList<View> arrayList);

    /* renamed from: b */
    public abstract void mo10083b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    /* renamed from: c */
    public abstract Object mo10082c(Object obj);

    /* renamed from: c */
    public abstract void mo10081c(Object obj, View view);

    /* renamed from: a */
    public ArrayList<String> m10094a(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = arrayList.get(i);
            arrayList2.add(ViewCompat.m9417p(view));
            ViewCompat.m9443a(view, (String) null);
        }
        return arrayList2;
    }

    /* renamed from: a */
    public void m10106a(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = arrayList.get(i);
            String m9417p = ViewCompat.m9417p(view2);
            arrayList4.add(m9417p);
            if (m9417p != null) {
                ViewCompat.m9443a(view2, (String) null);
                String str = map.get(m9417p);
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (str.equals(arrayList3.get(i2))) {
                        ViewCompat.m9443a(arrayList2.get(i2), m9417p);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        OneShotPreDrawListener.m10363a(view, new RunnableC0181a(this, size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    /* renamed from: a */
    public void m10093a(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (ViewGroupCompat.m9393a(viewGroup)) {
                    arrayList.add(viewGroup);
                    return;
                }
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    m10093a(arrayList, viewGroup.getChildAt(i));
                }
                return;
            }
            arrayList.add(view);
        }
    }

    /* renamed from: a */
    public void m10089a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String m9417p = ViewCompat.m9417p(view);
            if (m9417p != null) {
                map.put(m9417p, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    m10089a(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    /* renamed from: a */
    public void m10105a(View view, ArrayList<View> arrayList, Map<String, String> map) {
        OneShotPreDrawListener.m10363a(view, new RunnableC0182b(this, arrayList, map));
    }

    /* renamed from: a */
    public void m10103a(ViewGroup viewGroup, ArrayList<View> arrayList, Map<String, String> map) {
        OneShotPreDrawListener.m10363a(viewGroup, new RunnableC0183c(this, arrayList, map));
    }

    /* renamed from: a */
    public static void m10091a(List<View> list, View view) {
        int size = list.size();
        if (m10090a(list, view, size)) {
            return;
        }
        list.add(view);
        for (int i = size; i < list.size(); i++) {
            View view2 = list.get(i);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (!m10090a(list, childAt, size)) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m10090a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m10092a(List list) {
        return list == null || list.isEmpty();
    }

    /* renamed from: a */
    public static String m10088a(Map<String, String> map, String str) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
