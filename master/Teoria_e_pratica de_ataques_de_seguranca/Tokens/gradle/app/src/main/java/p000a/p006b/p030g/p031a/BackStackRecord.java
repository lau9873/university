package p000a.p006b.p030g.p031a;

import android.support.p065v4.app.Fragment;
import android.util.Log;
import com.j256.ormlite.logger.Logger;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import p000a.p006b.p030g.p031a.FragmentManager;
import p000a.p006b.p030g.p031a.LayoutInflater$Factory2C0152l;
import p000a.p006b.p030g.p044j.LogWriter;

/* renamed from: a.b.g.a.c */
/* loaded from: classes.dex */
public final class BackStackRecord extends FragmentTransaction implements FragmentManager.InterfaceC0149a, LayoutInflater$Factory2C0152l.InterfaceC0166l {

    /* renamed from: a */
    public final LayoutInflater$Factory2C0152l f1048a;

    /* renamed from: c */
    public int f1050c;

    /* renamed from: d */
    public int f1051d;

    /* renamed from: e */
    public int f1052e;

    /* renamed from: f */
    public int f1053f;

    /* renamed from: g */
    public int f1054g;

    /* renamed from: h */
    public int f1055h;

    /* renamed from: i */
    public boolean f1056i;

    /* renamed from: k */
    public String f1058k;

    /* renamed from: l */
    public boolean f1059l;

    /* renamed from: n */
    public int f1061n;

    /* renamed from: o */
    public CharSequence f1062o;

    /* renamed from: p */
    public int f1063p;

    /* renamed from: q */
    public CharSequence f1064q;

    /* renamed from: r */
    public ArrayList<String> f1065r;

    /* renamed from: s */
    public ArrayList<String> f1066s;

    /* renamed from: u */
    public ArrayList<Runnable> f1068u;

    /* renamed from: b */
    public ArrayList<C0141a> f1049b = new ArrayList<>();

    /* renamed from: j */
    public boolean f1057j = true;

    /* renamed from: m */
    public int f1060m = -1;

    /* renamed from: t */
    public boolean f1067t = false;

    /* compiled from: BackStackRecord.java */
    /* renamed from: a.b.g.a.c$a */
    /* loaded from: classes.dex */
    public static final class C0141a {

        /* renamed from: a */
        public int f1069a;

        /* renamed from: b */
        public Fragment f1070b;

        /* renamed from: c */
        public int f1071c;

        /* renamed from: d */
        public int f1072d;

        /* renamed from: e */
        public int f1073e;

        /* renamed from: f */
        public int f1074f;

        public C0141a() {
        }

        public C0141a(int i, Fragment fragment) {
            this.f1069a = i;
            this.f1070b = fragment;
        }
    }

    public BackStackRecord(LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l) {
        this.f1048a = layoutInflater$Factory2C0152l;
    }

    /* renamed from: a */
    public void m10379a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        m10378a(str, printWriter, true);
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransaction
    /* renamed from: b */
    public FragmentTransaction mo10139b(int i, Fragment fragment) {
        m10383a(i, fragment, (String) null);
        return this;
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransaction
    /* renamed from: c */
    public void mo10138c() {
        m10369d();
        this.f1048a.m10219b((LayoutInflater$Factory2C0152l.InterfaceC0166l) this, true);
    }

    /* renamed from: d */
    public FragmentTransaction m10369d() {
        if (!this.f1056i) {
            this.f1057j = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    /* renamed from: e */
    public void m10368e() {
        int size = this.f1049b.size();
        for (int i = 0; i < size; i++) {
            C0141a c0141a = this.f1049b.get(i);
            Fragment fragment = c0141a.f1070b;
            if (fragment != null) {
                fragment.m7527a(this.f1054g, this.f1055h);
            }
            switch (c0141a.f1069a) {
                case 1:
                    fragment.m7505b(c0141a.f1071c);
                    this.f1048a.m10238a(fragment, false);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0141a.f1069a);
                case 3:
                    fragment.m7505b(c0141a.f1072d);
                    this.f1048a.m10172m(fragment);
                    break;
                case 4:
                    fragment.m7505b(c0141a.f1072d);
                    this.f1048a.m10186g(fragment);
                    break;
                case 5:
                    fragment.m7505b(c0141a.f1071c);
                    this.f1048a.m10164q(fragment);
                    break;
                case 6:
                    fragment.m7505b(c0141a.f1072d);
                    this.f1048a.m10197d(fragment);
                    break;
                case 7:
                    fragment.m7505b(c0141a.f1071c);
                    this.f1048a.m10217b(fragment);
                    break;
                case 8:
                    this.f1048a.m10166p(fragment);
                    break;
                case 9:
                    this.f1048a.m10166p(null);
                    break;
            }
            if (!this.f1067t && c0141a.f1069a != 1 && fragment != null) {
                this.f1048a.m10178j(fragment);
            }
        }
        if (this.f1067t) {
            return;
        }
        LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f1048a;
        layoutInflater$Factory2C0152l.m10260a(layoutInflater$Factory2C0152l.f1150m, true);
    }

    /* renamed from: f */
    public String m10367f() {
        return this.f1058k;
    }

    /* renamed from: g */
    public boolean m10366g() {
        for (int i = 0; i < this.f1049b.size(); i++) {
            if (m10373b(this.f1049b.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    public void m10365h() {
        ArrayList<Runnable> arrayList = this.f1068u;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.f1068u.get(i).run();
            }
            this.f1068u = null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((int) Logger.DEFAULT_FULL_MESSAGE_LENGTH);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f1060m >= 0) {
            sb.append(" #");
            sb.append(this.f1060m);
        }
        if (this.f1058k != null) {
            sb.append(" ");
            sb.append(this.f1058k);
        }
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    public void m10378a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f1058k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f1060m);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f1059l);
            if (this.f1054g != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1054g));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f1055h));
            }
            if (this.f1050c != 0 || this.f1051d != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1050c));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1051d));
            }
            if (this.f1052e != 0 || this.f1053f != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1052e));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1053f));
            }
            if (this.f1061n != 0 || this.f1062o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1061n));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f1062o);
            }
            if (this.f1063p != 0 || this.f1064q != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1063p));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f1064q);
            }
        }
        if (this.f1049b.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        String str3 = str + "    ";
        int size = this.f1049b.size();
        for (int i = 0; i < size; i++) {
            C0141a c0141a = this.f1049b.get(i);
            switch (c0141a.f1069a) {
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
                    str2 = "cmd=" + c0141a.f1069a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(c0141a.f1070b);
            if (z) {
                if (c0141a.f1071c != 0 || c0141a.f1072d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(c0141a.f1071c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(c0141a.f1072d));
                }
                if (c0141a.f1073e != 0 || c0141a.f1074f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(c0141a.f1073e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(c0141a.f1074f));
                }
            }
        }
    }

    /* renamed from: b */
    public void m10374b(int i) {
        C0141a c0141a;
        if (this.f1056i) {
            if (LayoutInflater$Factory2C0152l.f1130F) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.f1049b.size();
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment = this.f1049b.get(i2).f1070b;
                if (fragment != null) {
                    fragment.f3503r += i;
                    if (LayoutInflater$Factory2C0152l.f1130F) {
                        Log.v("FragmentManager", "Bump nesting of " + c0141a.f1070b + " to " + c0141a.f1070b.f3503r);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public boolean m10370c(int i) {
        int size = this.f1049b.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.f1049b.get(i2).f1070b;
            int i3 = fragment != null ? fragment.f3511z : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransaction
    /* renamed from: b */
    public int mo10140b() {
        return m10375a(true);
    }

    /* renamed from: b */
    public void m10371b(boolean z) {
        for (int size = this.f1049b.size() - 1; size >= 0; size--) {
            C0141a c0141a = this.f1049b.get(size);
            Fragment fragment = c0141a.f1070b;
            if (fragment != null) {
                fragment.m7527a(LayoutInflater$Factory2C0152l.m10193e(this.f1054g), this.f1055h);
            }
            switch (c0141a.f1069a) {
                case 1:
                    fragment.m7505b(c0141a.f1074f);
                    this.f1048a.m10172m(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0141a.f1069a);
                case 3:
                    fragment.m7505b(c0141a.f1073e);
                    this.f1048a.m10238a(fragment, false);
                    break;
                case 4:
                    fragment.m7505b(c0141a.f1073e);
                    this.f1048a.m10164q(fragment);
                    break;
                case 5:
                    fragment.m7505b(c0141a.f1074f);
                    this.f1048a.m10186g(fragment);
                    break;
                case 6:
                    fragment.m7505b(c0141a.f1073e);
                    this.f1048a.m10217b(fragment);
                    break;
                case 7:
                    fragment.m7505b(c0141a.f1074f);
                    this.f1048a.m10197d(fragment);
                    break;
                case 8:
                    this.f1048a.m10166p(null);
                    break;
                case 9:
                    this.f1048a.m10166p(fragment);
                    break;
            }
            if (!this.f1067t && c0141a.f1069a != 3 && fragment != null) {
                this.f1048a.m10178j(fragment);
            }
        }
        if (this.f1067t || !z) {
            return;
        }
        LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f1048a;
        layoutInflater$Factory2C0152l.m10260a(layoutInflater$Factory2C0152l.f1150m, true);
    }

    /* renamed from: b */
    public Fragment m10372b(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int i = 0; i < this.f1049b.size(); i++) {
            C0141a c0141a = this.f1049b.get(i);
            int i2 = c0141a.f1069a;
            if (i2 != 1) {
                if (i2 != 3) {
                    switch (i2) {
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = c0141a.f1070b;
                            break;
                    }
                }
                arrayList.add(c0141a.f1070b);
            }
            arrayList.remove(c0141a.f1070b);
        }
        return fragment;
    }

    /* renamed from: b */
    public static boolean m10373b(C0141a c0141a) {
        Fragment fragment = c0141a.f1070b;
        return (fragment == null || !fragment.f3497k || fragment.f3473J == null || fragment.f3466C || fragment.f3465B || !fragment.m7536O()) ? false : true;
    }

    /* renamed from: a */
    public void m10381a(C0141a c0141a) {
        this.f1049b.add(c0141a);
        c0141a.f1071c = this.f1050c;
        c0141a.f1072d = this.f1051d;
        c0141a.f1073e = this.f1052e;
        c0141a.f1074f = this.f1053f;
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransaction
    /* renamed from: a */
    public FragmentTransaction mo10142a(Fragment fragment, String str) {
        m10382a(0, fragment, str, 1);
        return this;
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransaction
    /* renamed from: a */
    public FragmentTransaction mo10144a(int i, Fragment fragment) {
        m10382a(i, fragment, (String) null, 1);
        return this;
    }

    /* renamed from: a */
    public final void m10382a(int i, Fragment fragment, String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (!cls.isAnonymousClass() && Modifier.isPublic(modifiers) && (!cls.isMemberClass() || Modifier.isStatic(modifiers))) {
            fragment.f3504s = this.f1048a;
            if (str != null) {
                String str2 = fragment.f3464A;
                if (str2 != null && !str.equals(str2)) {
                    throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.f3464A + " now " + str);
                }
                fragment.f3464A = str;
            }
            if (i != 0) {
                if (i != -1) {
                    int i3 = fragment.f3510y;
                    if (i3 != 0 && i3 != i) {
                        throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.f3510y + " now " + i);
                    }
                    fragment.f3510y = i;
                    fragment.f3511z = i;
                } else {
                    throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
                }
            }
            m10381a(new C0141a(i2, fragment));
            return;
        }
        throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }

    /* renamed from: a */
    public FragmentTransaction m10383a(int i, Fragment fragment, String str) {
        if (i != 0) {
            m10382a(i, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransaction
    /* renamed from: a */
    public FragmentTransaction mo10143a(Fragment fragment) {
        m10381a(new C0141a(3, fragment));
        return this;
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransaction
    /* renamed from: a */
    public FragmentTransaction mo10145a(int i) {
        this.f1055h = i;
        return this;
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransaction
    /* renamed from: a */
    public FragmentTransaction mo10141a(String str) {
        if (this.f1057j) {
            this.f1056i = true;
            this.f1058k = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransaction
    /* renamed from: a */
    public int mo10146a() {
        return m10375a(false);
    }

    /* renamed from: a */
    public int m10375a(boolean z) {
        if (!this.f1059l) {
            if (LayoutInflater$Factory2C0152l.f1130F) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
                m10379a("  ", (FileDescriptor) null, printWriter, (String[]) null);
                printWriter.close();
            }
            this.f1059l = true;
            if (this.f1056i) {
                this.f1060m = this.f1048a.m10220b(this);
            } else {
                this.f1060m = -1;
            }
            this.f1048a.m10255a(this, z);
            return this.f1060m;
        }
        throw new IllegalStateException("commit already called");
    }

    @Override // p000a.p006b.p030g.p031a.LayoutInflater$Factory2C0152l.InterfaceC0166l
    /* renamed from: a */
    public boolean mo10154a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (LayoutInflater$Factory2C0152l.f1130F) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (this.f1056i) {
            this.f1048a.m10259a(this);
            return true;
        }
        return true;
    }

    /* renamed from: a */
    public boolean m10377a(ArrayList<BackStackRecord> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f1049b.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = this.f1049b.get(i4).f1070b;
            int i5 = fragment != null ? fragment.f3511z : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = i; i6 < i2; i6++) {
                    BackStackRecord backStackRecord = arrayList.get(i6);
                    int size2 = backStackRecord.f1049b.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        Fragment fragment2 = backStackRecord.f1049b.get(i7).f1070b;
                        if ((fragment2 != null ? fragment2.f3511z : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    /* renamed from: a */
    public Fragment m10376a(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i = 0;
        while (i < this.f1049b.size()) {
            C0141a c0141a = this.f1049b.get(i);
            int i2 = c0141a.f1069a;
            if (i2 != 1) {
                if (i2 == 2) {
                    Fragment fragment3 = c0141a.f1070b;
                    int i3 = fragment3.f3511z;
                    Fragment fragment4 = fragment2;
                    int i4 = i;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment5 = arrayList.get(size);
                        if (fragment5.f3511z == i3) {
                            if (fragment5 == fragment3) {
                                z = true;
                            } else {
                                if (fragment5 == fragment4) {
                                    this.f1049b.add(i4, new C0141a(9, fragment5));
                                    i4++;
                                    fragment4 = null;
                                }
                                C0141a c0141a2 = new C0141a(3, fragment5);
                                c0141a2.f1071c = c0141a.f1071c;
                                c0141a2.f1073e = c0141a.f1073e;
                                c0141a2.f1072d = c0141a.f1072d;
                                c0141a2.f1074f = c0141a.f1074f;
                                this.f1049b.add(i4, c0141a2);
                                arrayList.remove(fragment5);
                                i4++;
                            }
                        }
                    }
                    if (z) {
                        this.f1049b.remove(i4);
                        i4--;
                    } else {
                        c0141a.f1069a = 1;
                        arrayList.add(fragment3);
                    }
                    i = i4;
                    fragment2 = fragment4;
                } else if (i2 == 3 || i2 == 6) {
                    arrayList.remove(c0141a.f1070b);
                    Fragment fragment6 = c0141a.f1070b;
                    if (fragment6 == fragment2) {
                        this.f1049b.add(i, new C0141a(9, fragment6));
                        i++;
                        fragment2 = null;
                    }
                } else if (i2 != 7) {
                    if (i2 == 8) {
                        this.f1049b.add(i, new C0141a(9, fragment2));
                        i++;
                        fragment2 = c0141a.f1070b;
                    }
                }
                i++;
            }
            arrayList.add(c0141a.f1070b);
            i++;
        }
        return fragment2;
    }

    /* renamed from: a */
    public void m10380a(Fragment.InterfaceC0605e interfaceC0605e) {
        for (int i = 0; i < this.f1049b.size(); i++) {
            C0141a c0141a = this.f1049b.get(i);
            if (m10373b(c0141a)) {
                c0141a.f1070b.m7513a(interfaceC0605e);
            }
        }
    }
}
