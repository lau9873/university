package p205h.p208b.p209a.p212e.p216d;

import android.os.Bundle;
import android.support.p067v7.widget.LinearLayoutManager;
import android.support.p067v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.hbb20.C1444R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import p205h.p208b.p209a.Anda;
import p205h.p208b.p209a.p210d.AsyncResult;
import p205h.p208b.p209a.p210d.RemoteUserListener;
import p205h.p208b.p209a.p210d.RemoteUserResultListener;
import p205h.p208b.p209a.p210d.UserProfile;
import p205h.p208b.p209a.p212e.p216d.AbstractTimeFramedListFragment;
import p205h.p208b.p209a.p212e.p218f.BaseItemView;
import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.b.a.e.d.f4 */
/* loaded from: classes.dex */
public class SocialProfilesFragment extends AbstractFragment implements RemoteUserListener {

    /* renamed from: c0 */
    public Anda f9828c0;

    /* renamed from: d0 */
    public List<RemoteUserResultListener> f9829d0 = new ArrayList();

    /* renamed from: e0 */
    public UserProfile f9830e0;

    /* renamed from: f0 */
    public ProgressBar f9831f0;

    /* compiled from: SocialProfilesFragment.java */
    /* renamed from: h.b.a.e.d.f4$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C2423a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f9832a = new int[EnumC2424b.values().length];

        static {
            try {
                f9832a[EnumC2424b.CURRENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9832a[EnumC2424b.FUTURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: SocialProfilesFragment.java */
    /* renamed from: h.b.a.e.d.f4$b */
    /* loaded from: classes.dex */
    public enum EnumC2424b {
        CURRENT,
        FUTURE,
        NORMAL
    }

    /* compiled from: SocialProfilesFragment.java */
    /* renamed from: h.b.a.e.d.f4$c */
    /* loaded from: classes.dex */
    public static class C2425c extends AbstractTimeFramedListFragment.C2463a {

        /* renamed from: f */
        public final CharSequence f9837f;

        /* renamed from: g */
        public final CharSequence f9838g;

        /* renamed from: h */
        public EnumC2424b f9839h;

        /* renamed from: i */
        public SimpleDateFormat f9840i;

        public C2425c(UserProfile.InterfaceC2376c interfaceC2376c) {
            super(3, interfaceC2376c.mo1218a(), 0);
            this.f9839h = EnumC2424b.NORMAL;
            this.f9840i = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
            this.f9837f = this.f9840i.format(interfaceC2376c.mo1216c());
            this.f9838g = this.f9840i.format(interfaceC2376c.mo1217b());
        }
    }

    /* compiled from: SocialProfilesFragment.java */
    /* renamed from: h.b.a.e.d.f4$d */
    /* loaded from: classes.dex */
    public class C2426d extends BaseItemView {

        /* renamed from: u */
        public final LinearLayout f9842u;

        /* renamed from: v */
        public final TextView f9843v;

        /* renamed from: w */
        public final TextView f9844w;

        /* renamed from: x */
        public final TextView f9845x;

        /* renamed from: y */
        public final TextView f9846y;

        /* renamed from: z */
        public final View f9847z;

        public C2426d(View view) {
            super(view);
            this.f9842u = (LinearLayout) view.findViewById(C1444R.C1446id.itemMain);
            this.f9843v = (TextView) view.findViewById(C1444R.C1446id.tProfileName);
            this.f9846y = (TextView) view.findViewById(C1444R.C1446id.tProfileStatus);
            this.f9844w = (TextView) view.findViewById(C1444R.C1446id.tDateStart);
            this.f9845x = (TextView) view.findViewById(C1444R.C1446id.tDateEnd);
            this.f9847z = view.findViewById(C1444R.C1446id.bottomDivider);
        }

        @Override // p205h.p208b.p209a.p212e.p218f.BaseItemView
        /* renamed from: a */
        public void mo692a(AbstractTimeFramedListFragment.C2463a c2463a) {
            C2425c c2425c = (C2425c) c2463a;
            this.f9843v.setText(c2425c.f9968d);
            this.f9844w.setText(c2425c.f9837f);
            this.f9845x.setText(c2425c.f9838g);
            if (c2425c.f9839h != EnumC2424b.NORMAL) {
                this.f9846y.setVisibility(0);
            }
            int i = C2423a.f9832a[c2425c.f9839h.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                this.f9846y.setText(String.format("%s %s", SocialProfilesFragment.this.f9860b0.getString(C1444R.string.begins_at), c2425c.f9837f));
                return;
            }
            LinearLayout linearLayout = this.f9842u;
            linearLayout.setPadding(linearLayout.getPaddingLeft(), this.f9842u.getPaddingTop(), this.f9842u.getPaddingRight(), 0);
            this.f9846y.setText(SocialProfilesFragment.this.f9860b0.getString(C1444R.string.current_in_place));
            this.f9847z.setVisibility(0);
        }
    }

    /* compiled from: SocialProfilesFragment.java */
    /* renamed from: h.b.a.e.d.f4$e */
    /* loaded from: classes.dex */
    public class C2427e extends RecyclerView.AbstractC0711g<BaseItemView> implements RemoteUserResultListener {

        /* renamed from: c */
        public final List<AbstractTimeFramedListFragment.C2463a> f9848c = new ArrayList();

        public C2427e() {
            SocialProfilesFragment.this.m1166a((RemoteUserResultListener) this);
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: c */
        public int mo739c(int i) {
            return this.f9848c.get(i).f9967c;
        }

        /* renamed from: e */
        public final void m1155e() {
            if (SocialProfilesFragment.this.m7540K()) {
                List<UserProfile.InterfaceC2376c> mo1245d = SocialProfilesFragment.this.f9830e0.mo1245d();
                if (mo1245d == null) {
                    SocialProfilesFragment.this.f9828c0.m1447a(SocialProfilesFragment.this.f9860b0.getString(C1444R.string.no_available_info), -1).mo7619m();
                    return;
                }
                Date time = Calendar.getInstance().getTime();
                UserProfile.InterfaceC2376c interfaceC2376c = null;
                this.f9848c.add(new C2428f(SocialProfilesFragment.this.f9860b0.getString(C1444R.string.social_profile_header)));
                for (UserProfile.InterfaceC2376c interfaceC2376c2 : mo1245d) {
                    if (interfaceC2376c2.mo1216c().before(time) && interfaceC2376c2.mo1217b().after(time)) {
                        interfaceC2376c = interfaceC2376c2;
                    }
                }
                if (interfaceC2376c != null) {
                    C2425c c2425c = new C2425c(interfaceC2376c);
                    c2425c.f9839h = EnumC2424b.CURRENT;
                    this.f9848c.add(c2425c);
                    mo1245d.remove(interfaceC2376c);
                }
                Collections.sort(mo1245d, Collections.reverseOrder(C2581x1.f10329a));
                for (UserProfile.InterfaceC2376c interfaceC2376c3 : mo1245d) {
                    C2425c c2425c2 = new C2425c(interfaceC2376c3);
                    if (interfaceC2376c3.mo1216c().after(time)) {
                        c2425c2.f9839h = EnumC2424b.FUTURE;
                    }
                    this.f9848c.add(c2425c2);
                }
                int mo747a = mo747a();
                m6756b(0, mo747a - (mo747a == 1 ? 0 : 1));
            }
        }

        @Override // p205h.p208b.p209a.p210d.RemoteUserResultListener
        public void onError(DataModels.Error error) {
            SocialProfilesFragment.this.f9828c0.m1447a(String.format(Locale.getDefault(), "%s: %s", SocialProfilesFragment.this.f9860b0.getString(C1444R.string.error), error.getMessageToUser()), 0).mo7619m();
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: a */
        public void mo743b(BaseItemView baseItemView, int i) {
            baseItemView.mo692a(this.f9848c.get(i));
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: a */
        public int mo747a() {
            return this.f9848c.size();
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
        /* renamed from: b  reason: avoid collision after fix types in other method */
        public BaseItemView mo742b(ViewGroup viewGroup, int i) {
            if (i == 2) {
                SocialProfilesFragment socialProfilesFragment = SocialProfilesFragment.this;
                return new C2429g(socialProfilesFragment, LayoutInflater.from(socialProfilesFragment.f9860b0).inflate(C1444R.layout.item_history_day, viewGroup, false));
            } else if (i == 3) {
                SocialProfilesFragment socialProfilesFragment2 = SocialProfilesFragment.this;
                return new C2426d(LayoutInflater.from(socialProfilesFragment2.f9860b0).inflate(C1444R.layout.item_social_profile, viewGroup, false));
            } else {
                return null;
            }
        }

        @Override // p205h.p208b.p209a.p210d.RemoteUserResultListener
        /* renamed from: b */
        public void mo741b(AsyncResult<UserProfile> asyncResult) {
            SocialProfilesFragment.this.f9830e0 = asyncResult.mo1334a();
            m1155e();
        }
    }

    /* compiled from: SocialProfilesFragment.java */
    /* renamed from: h.b.a.e.d.f4$f */
    /* loaded from: classes.dex */
    public static class C2428f extends AbstractTimeFramedListFragment.C2463a {
        public C2428f(CharSequence charSequence) {
            super(2, charSequence, 0);
        }
    }

    /* compiled from: SocialProfilesFragment.java */
    /* renamed from: h.b.a.e.d.f4$g */
    /* loaded from: classes.dex */
    public class C2429g extends BaseItemView {

        /* renamed from: u */
        public final TextView f9850u;

        public C2429g(SocialProfilesFragment socialProfilesFragment, View view) {
            super(view);
            this.f9850u = (TextView) view.findViewById(C1444R.C1446id.title);
        }

        @Override // p205h.p208b.p209a.p212e.p218f.BaseItemView
        /* renamed from: a */
        public void mo692a(AbstractTimeFramedListFragment.C2463a c2463a) {
            this.f9850u.setText(((C2428f) c2463a).f9968d);
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: c */
    public void mo728c(Bundle bundle) {
        super.mo728c(bundle);
        this.f9828c0 = Anda.m1443b(this.f9860b0);
    }

    @Override // p205h.p208b.p209a.p210d.RemoteUserListener
    public void onError(DataModels.Error error) {
        this.f9831f0.setVisibility(4);
        for (RemoteUserResultListener remoteUserResultListener : this.f9829d0) {
            remoteUserResultListener.onError(error);
        }
    }

    @Override // p205h.p208b.p209a.p210d.RemoteUserListener
    public void onSuccess(DataModels.UserAccountInfo userAccountInfo) {
        this.f9831f0.setVisibility(4);
        AsyncResult<UserProfile> mo1250a = Anda.m1443b(this.f9860b0).m1400o().mo1278b().mo1250a(userAccountInfo);
        for (RemoteUserResultListener remoteUserResultListener : this.f9829d0) {
            remoteUserResultListener.mo741b(mo1250a);
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public View mo717a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(C1444R.layout.fragment_personal_data, viewGroup, false);
        RecyclerView recyclerView = (RecyclerView) viewGroup2.findViewById(C1444R.C1446id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f9860b0));
        this.f9831f0 = (ProgressBar) viewGroup2.findViewById(C1444R.C1446id.progress);
        recyclerView.setAdapter(new C2427e());
        Anda.m1443b(this.f9860b0).m1400o().mo1282a(this);
        return viewGroup2;
    }

    /* renamed from: a */
    public final void m1166a(RemoteUserResultListener remoteUserResultListener) {
        if (this.f9829d0.contains(remoteUserResultListener)) {
            return;
        }
        this.f9829d0.add(remoteUserResultListener);
    }
}
