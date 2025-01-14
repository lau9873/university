package a.b.g.a;

import a.b.g.a.k;
import a.b.g.a.l;
import android.support.v4.app.Fragment;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
/* compiled from: BackStackRecord.java */
/* loaded from: classes.dex */
public final class c extends q implements k.a, l.InterfaceC0015l {

    /* renamed from: a  reason: collision with root package name */
    public final l f635a;

    /* renamed from: c  reason: collision with root package name */
    public int f637c;

    /* renamed from: d  reason: collision with root package name */
    public int f638d;

    /* renamed from: e  reason: collision with root package name */
    public int f639e;

    /* renamed from: f  reason: collision with root package name */
    public int f640f;

    /* renamed from: g  reason: collision with root package name */
    public int f641g;

    /* renamed from: h  reason: collision with root package name */
    public int f642h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f643i;
    public String k;
    public boolean l;
    public int n;
    public CharSequence o;
    public int p;
    public CharSequence q;
    public ArrayList<String> r;
    public ArrayList<String> s;
    public ArrayList<Runnable> u;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f636b = new ArrayList<>();
    public boolean j = true;
    public int m = -1;
    public boolean t = false;

    /* compiled from: BackStackRecord.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f644a;

        /* renamed from: b  reason: collision with root package name */
        public Fragment f645b;

        /* renamed from: c  reason: collision with root package name */
        public int f646c;

        /* renamed from: d  reason: collision with root package name */
        public int f647d;

        /* renamed from: e  reason: collision with root package name */
        public int f648e;

        /* renamed from: f  reason: collision with root package name */
        public int f649f;

        public a() {
        }

        public a(int i2, Fragment fragment) {
            this.f644a = i2;
            this.f645b = fragment;
        }
    }

    public c(l lVar) {
        this.f635a = lVar;
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        a(str, printWriter, true);
    }

    @Override // a.b.g.a.q
    public q b(int i2, Fragment fragment) {
        a(i2, fragment, (String) null);
        return this;
    }

    @Override // a.b.g.a.q
    public void c() {
        d();
        this.f635a.b((l.InterfaceC0015l) this, true);
    }

    public q d() {
        if (!this.f643i) {
            this.j = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    public void e() {
        int size = this.f636b.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.f636b.get(i2);
            Fragment fragment = aVar.f645b;
            if (fragment != null) {
                fragment.a(this.f641g, this.f642h);
            }
            switch (aVar.f644a) {
                case 1:
                    fragment.b(aVar.f646c);
                    this.f635a.a(fragment, false);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f644a);
                case 3:
                    fragment.b(aVar.f647d);
                    this.f635a.m(fragment);
                    break;
                case 4:
                    fragment.b(aVar.f647d);
                    this.f635a.g(fragment);
                    break;
                case 5:
                    fragment.b(aVar.f646c);
                    this.f635a.q(fragment);
                    break;
                case 6:
                    fragment.b(aVar.f647d);
                    this.f635a.d(fragment);
                    break;
                case 7:
                    fragment.b(aVar.f646c);
                    this.f635a.b(fragment);
                    break;
                case 8:
                    this.f635a.p(fragment);
                    break;
                case 9:
                    this.f635a.p(null);
                    break;
            }
            if (!this.t && aVar.f644a != 1 && fragment != null) {
                this.f635a.j(fragment);
            }
        }
        if (this.t) {
            return;
        }
        l lVar = this.f635a;
        lVar.a(lVar.m, true);
    }

    public String f() {
        return this.k;
    }

    public boolean g() {
        for (int i2 = 0; i2 < this.f636b.size(); i2++) {
            if (b(this.f636b.get(i2))) {
                return true;
            }
        }
        return false;
    }

    public void h() {
        ArrayList<Runnable> arrayList = this.u;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.u.get(i2).run();
            }
            this.u = null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.m >= 0) {
            sb.append(" #");
            sb.append(this.m);
        }
        if (this.k != null) {
            sb.append(" ");
            sb.append(this.k);
        }
        sb.append("}");
        return sb.toString();
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.k);
            printWriter.print(" mIndex=");
            printWriter.print(this.m);
            printWriter.print(" mCommitted=");
            printWriter.println(this.l);
            if (this.f641g != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f641g));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f642h));
            }
            if (this.f637c != 0 || this.f638d != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f637c));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f638d));
            }
            if (this.f639e != 0 || this.f640f != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f639e));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f640f));
            }
            if (this.n != 0 || this.o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.n));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.o);
            }
            if (this.p != 0 || this.q != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.p));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.q);
            }
        }
        if (this.f636b.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        String str3 = str + "    ";
        int size = this.f636b.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.f636b.get(i2);
            switch (aVar.f644a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                default:
                    str2 = "cmd=" + aVar.f644a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i2);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f645b);
            if (z) {
                if (aVar.f646c != 0 || aVar.f647d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f646c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f647d));
                }
                if (aVar.f648e != 0 || aVar.f649f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f648e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f649f));
                }
            }
        }
    }

    public void b(int i2) {
        a aVar;
        if (this.f643i) {
            if (l.F) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i2);
            }
            int size = this.f636b.size();
            for (int i3 = 0; i3 < size; i3++) {
                Fragment fragment = this.f636b.get(i3).f645b;
                if (fragment != null) {
                    fragment.r += i2;
                    if (l.F) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f645b + " to " + aVar.f645b.r);
                    }
                }
            }
        }
    }

    public boolean c(int i2) {
        int size = this.f636b.size();
        for (int i3 = 0; i3 < size; i3++) {
            Fragment fragment = this.f636b.get(i3).f645b;
            int i4 = fragment != null ? fragment.z : 0;
            if (i4 != 0 && i4 == i2) {
                return true;
            }
        }
        return false;
    }

    @Override // a.b.g.a.q
    public int b() {
        return a(true);
    }

    public void b(boolean z) {
        for (int size = this.f636b.size() - 1; size >= 0; size--) {
            a aVar = this.f636b.get(size);
            Fragment fragment = aVar.f645b;
            if (fragment != null) {
                fragment.a(l.e(this.f641g), this.f642h);
            }
            switch (aVar.f644a) {
                case 1:
                    fragment.b(aVar.f649f);
                    this.f635a.m(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f644a);
                case 3:
                    fragment.b(aVar.f648e);
                    this.f635a.a(fragment, false);
                    break;
                case 4:
                    fragment.b(aVar.f648e);
                    this.f635a.q(fragment);
                    break;
                case 5:
                    fragment.b(aVar.f649f);
                    this.f635a.g(fragment);
                    break;
                case 6:
                    fragment.b(aVar.f648e);
                    this.f635a.b(fragment);
                    break;
                case 7:
                    fragment.b(aVar.f649f);
                    this.f635a.d(fragment);
                    break;
                case 8:
                    this.f635a.p(null);
                    break;
                case 9:
                    this.f635a.p(fragment);
                    break;
            }
            if (!this.t && aVar.f644a != 3 && fragment != null) {
                this.f635a.j(fragment);
            }
        }
        if (this.t || !z) {
            return;
        }
        l lVar = this.f635a;
        lVar.a(lVar.m, true);
    }

    public Fragment b(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int i2 = 0; i2 < this.f636b.size(); i2++) {
            a aVar = this.f636b.get(i2);
            int i3 = aVar.f644a;
            if (i3 != 1) {
                if (i3 != 3) {
                    switch (i3) {
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f645b;
                            break;
                    }
                }
                arrayList.add(aVar.f645b);
            }
            arrayList.remove(aVar.f645b);
        }
        return fragment;
    }

    public static boolean b(a aVar) {
        Fragment fragment = aVar.f645b;
        return (fragment == null || !fragment.k || fragment.J == null || fragment.C || fragment.B || !fragment.O()) ? false : true;
    }

    public void a(a aVar) {
        this.f636b.add(aVar);
        aVar.f646c = this.f637c;
        aVar.f647d = this.f638d;
        aVar.f648e = this.f639e;
        aVar.f649f = this.f640f;
    }

    @Override // a.b.g.a.q
    public q a(Fragment fragment, String str) {
        a(0, fragment, str, 1);
        return this;
    }

    @Override // a.b.g.a.q
    public q a(int i2, Fragment fragment) {
        a(i2, fragment, (String) null, 1);
        return this;
    }

    public final void a(int i2, Fragment fragment, String str, int i3) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (!cls.isAnonymousClass() && Modifier.isPublic(modifiers) && (!cls.isMemberClass() || Modifier.isStatic(modifiers))) {
            fragment.s = this.f635a;
            if (str != null) {
                String str2 = fragment.A;
                if (str2 != null && !str.equals(str2)) {
                    throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.A + " now " + str);
                }
                fragment.A = str;
            }
            if (i2 != 0) {
                if (i2 != -1) {
                    int i4 = fragment.y;
                    if (i4 != 0 && i4 != i2) {
                        throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.y + " now " + i2);
                    }
                    fragment.y = i2;
                    fragment.z = i2;
                } else {
                    throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
                }
            }
            a(new a(i3, fragment));
            return;
        }
        throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }

    public q a(int i2, Fragment fragment, String str) {
        if (i2 != 0) {
            a(i2, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    @Override // a.b.g.a.q
    public q a(Fragment fragment) {
        a(new a(3, fragment));
        return this;
    }

    @Override // a.b.g.a.q
    public q a(int i2) {
        this.f642h = i2;
        return this;
    }

    @Override // a.b.g.a.q
    public q a(String str) {
        if (this.j) {
            this.f643i = true;
            this.k = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    @Override // a.b.g.a.q
    public int a() {
        return a(false);
    }

    public int a(boolean z) {
        if (!this.l) {
            if (l.F) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new a.b.g.j.e("FragmentManager"));
                a("  ", (FileDescriptor) null, printWriter, (String[]) null);
                printWriter.close();
            }
            this.l = true;
            if (this.f643i) {
                this.m = this.f635a.b(this);
            } else {
                this.m = -1;
            }
            this.f635a.a(this, z);
            return this.m;
        }
        throw new IllegalStateException("commit already called");
    }

    @Override // a.b.g.a.l.InterfaceC0015l
    public boolean a(ArrayList<c> arrayList, ArrayList<Boolean> arrayList2) {
        if (l.F) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (this.f643i) {
            this.f635a.a(this);
            return true;
        }
        return true;
    }

    public boolean a(ArrayList<c> arrayList, int i2, int i3) {
        if (i3 == i2) {
            return false;
        }
        int size = this.f636b.size();
        int i4 = -1;
        for (int i5 = 0; i5 < size; i5++) {
            Fragment fragment = this.f636b.get(i5).f645b;
            int i6 = fragment != null ? fragment.z : 0;
            if (i6 != 0 && i6 != i4) {
                for (int i7 = i2; i7 < i3; i7++) {
                    c cVar = arrayList.get(i7);
                    int size2 = cVar.f636b.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        Fragment fragment2 = cVar.f636b.get(i8).f645b;
                        if ((fragment2 != null ? fragment2.z : 0) == i6) {
                            return true;
                        }
                    }
                }
                i4 = i6;
            }
        }
        return false;
    }

    public Fragment a(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i2 = 0;
        while (i2 < this.f636b.size()) {
            a aVar = this.f636b.get(i2);
            int i3 = aVar.f644a;
            if (i3 != 1) {
                if (i3 == 2) {
                    Fragment fragment3 = aVar.f645b;
                    int i4 = fragment3.z;
                    Fragment fragment4 = fragment2;
                    int i5 = i2;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment5 = arrayList.get(size);
                        if (fragment5.z == i4) {
                            if (fragment5 == fragment3) {
                                z = true;
                            } else {
                                if (fragment5 == fragment4) {
                                    this.f636b.add(i5, new a(9, fragment5));
                                    i5++;
                                    fragment4 = null;
                                }
                                a aVar2 = new a(3, fragment5);
                                aVar2.f646c = aVar.f646c;
                                aVar2.f648e = aVar.f648e;
                                aVar2.f647d = aVar.f647d;
                                aVar2.f649f = aVar.f649f;
                                this.f636b.add(i5, aVar2);
                                arrayList.remove(fragment5);
                                i5++;
                            }
                        }
                    }
                    if (z) {
                        this.f636b.remove(i5);
                        i5--;
                    } else {
                        aVar.f644a = 1;
                        arrayList.add(fragment3);
                    }
                    i2 = i5;
                    fragment2 = fragment4;
                } else if (i3 == 3 || i3 == 6) {
                    arrayList.remove(aVar.f645b);
                    Fragment fragment6 = aVar.f645b;
                    if (fragment6 == fragment2) {
                        this.f636b.add(i2, new a(9, fragment6));
                        i2++;
                        fragment2 = null;
                    }
                } else if (i3 != 7) {
                    if (i3 == 8) {
                        this.f636b.add(i2, new a(9, fragment2));
                        i2++;
                        fragment2 = aVar.f645b;
                    }
                }
                i2++;
            }
            arrayList.add(aVar.f645b);
            i2++;
        }
        return fragment2;
    }

    public void a(Fragment.e eVar) {
        for (int i2 = 0; i2 < this.f636b.size(); i2++) {
            a aVar = this.f636b.get(i2);
            if (b(aVar)) {
                aVar.f645b.a(eVar);
            }
        }
    }
}
