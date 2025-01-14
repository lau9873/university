package p000a.p006b.p012d.p019q;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import p000a.p006b.p049h.p061j.p062j.MenuBuilder;
import p000a.p006b.p049h.p061j.p062j.MenuItemImpl;
import p000a.p006b.p049h.p061j.p062j.MenuPresenter;
import p000a.p006b.p049h.p061j.p062j.SubMenuBuilder;

/* renamed from: a.b.d.q.d */
/* loaded from: classes.dex */
public class BottomNavigationPresenter implements MenuPresenter {

    /* renamed from: a */
    public MenuBuilder f528a;

    /* renamed from: b */
    public BottomNavigationMenuView f529b;

    /* renamed from: c */
    public boolean f530c = false;

    /* renamed from: d */
    public int f531d;

    /* compiled from: BottomNavigationPresenter.java */
    /* renamed from: a.b.d.q.d$a */
    /* loaded from: classes.dex */
    public static class C0058a implements Parcelable {
        public static final Parcelable.Creator<C0058a> CREATOR = new C0059a();

        /* renamed from: a */
        public int f532a;

        /* compiled from: BottomNavigationPresenter.java */
        /* renamed from: a.b.d.q.d$a$a */
        /* loaded from: classes.dex */
        public static class C0059a implements Parcelable.Creator<C0058a> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public C0058a createFromParcel(Parcel parcel) {
                return new C0058a(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public C0058a[] newArray(int i) {
                return new C0058a[i];
            }
        }

        public C0058a() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f532a);
        }

        public C0058a(Parcel parcel) {
            this.f532a = parcel.readInt();
        }
    }

    /* renamed from: a */
    public void m10871a(BottomNavigationMenuView bottomNavigationMenuView) {
        this.f529b = bottomNavigationMenuView;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public void mo6282a(MenuBuilder menuBuilder, boolean z) {
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public boolean mo6283a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public boolean mo6281a(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    /* renamed from: b */
    public void m10870b(boolean z) {
        this.f530c = z;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: b */
    public boolean mo6277b() {
        return false;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: b */
    public boolean mo6276b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: c */
    public Parcelable mo6275c() {
        C0058a c0058a = new C0058a();
        c0058a.f532a = this.f529b.getSelectedItemId();
        return c0058a;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public void mo6280a(Context context, MenuBuilder menuBuilder) {
        this.f528a = menuBuilder;
        this.f529b.mo7096a(this.f528a);
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public void mo6278a(boolean z) {
        if (this.f530c) {
            return;
        }
        if (z) {
            this.f529b.m10880a();
        } else {
            this.f529b.m10873c();
        }
    }

    /* renamed from: a */
    public void m10872a(int i) {
        this.f531d = i;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public int mo6284a() {
        return this.f531d;
    }

    @Override // p000a.p006b.p049h.p061j.p062j.MenuPresenter
    /* renamed from: a */
    public void mo6279a(Parcelable parcelable) {
        if (parcelable instanceof C0058a) {
            this.f529b.m10875b(((C0058a) parcelable).f532a);
        }
    }
}
