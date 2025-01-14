package p205h.p208b.p209a.p212e.p216d;

import com.hbb20.C1444R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import p205h.p208b.p209a.p210d.CountriesListener;
import p205h.p208b.p209a.p210d.UserProfile;
import p205h.p208b.p209a.p212e.p216d.PersonalDataFragment;
import pt.card4b.backendbeacons.DataModels;

/* compiled from: PersonalDataFragment.java */
/* renamed from: h.b.a.e.d.x3 */
/* loaded from: classes.dex */
public class C2583x3 implements CountriesListener {

    /* renamed from: a */
    public final /* synthetic */ UserProfile f10331a;

    /* renamed from: b */
    public final /* synthetic */ PersonalDataFragment.C2576c f10332b;

    public C2583x3(PersonalDataFragment.C2576c c2576c, UserProfile userProfile) {
        this.f10332b = c2576c;
        this.f10331a = userProfile;
    }

    @Override // p205h.p208b.p209a.p210d.CountriesListener
    /* renamed from: a */
    public void mo738a(List<DataModels.Language> list) {
        List list2;
        HashMap hashMap;
        List list3;
        List list4;
        List list5;
        List list6;
        List list7;
        List list8;
        List list9;
        List list10;
        List list11;
        List list12;
        List list13;
        List list14;
        List list15;
        HashMap hashMap2;
        List list16;
        HashMap hashMap3;
        List list17;
        list2 = PersonalDataFragment.this.f10312n0;
        if (!list2.isEmpty()) {
            list17 = PersonalDataFragment.this.f10312n0;
            list17.clear();
        }
        hashMap = PersonalDataFragment.this.f10311m0;
        if (!hashMap.isEmpty()) {
            hashMap3 = PersonalDataFragment.this.f10311m0;
            hashMap3.clear();
        }
        for (DataModels.Language language : list) {
            hashMap2 = PersonalDataFragment.this.f10311m0;
            hashMap2.put(language.getCode(), language);
            list16 = PersonalDataFragment.this.f10312n0;
            list16.add(new PersonalDataFragment.C2575b(7, language));
        }
        StringBuilder sb = new StringBuilder();
        if (this.f10331a.mo1245d().size() > 0) {
            StringBuilder sb2 = sb;
            for (int i = 0; i < this.f10331a.mo1245d().size(); i++) {
                UserProfile.InterfaceC2376c interfaceC2376c = this.f10331a.mo1245d().get(i);
                Date time = Calendar.getInstance().getTime();
                if (time.getTime() >= interfaceC2376c.mo1216c().getTime() && time.getTime() <= interfaceC2376c.mo1217b().getTime()) {
                    if (sb2.length() == 0) {
                        sb2 = new StringBuilder(this.f10331a.mo1245d().get(i).mo1218a());
                    } else {
                        sb2.append(" / ");
                        sb2.append(this.f10331a.mo1245d().get(i).mo1218a());
                    }
                }
            }
            sb = sb2;
        }
        String[] strArr = new String[5];
        strArr[0] = this.f10331a.mo1248a();
        strArr[1] = this.f10331a.mo1241h();
        strArr[2] = this.f10331a.mo1243f();
        strArr[3] = this.f10331a.mo1239j() != null ? this.f10331a.mo1239j().mo1224a() : PersonalDataFragment.this.f9860b0.getString(C1444R.string.user_no_active_payment_method);
        strArr[4] = sb.toString().equals("") ? PersonalDataFragment.this.f9860b0.getString(C1444R.string.user_no_active_social_tariff) : sb.toString();
        ArrayList arrayList = new ArrayList();
        list3 = this.f10332b.f10316c;
        if (list3.size() != 5) {
            list4 = this.f10332b.f10316c;
            list5 = this.f10332b.f10316c;
            list4.add(new PersonalDataFragment.C2578e(list5.size(), PersonalDataFragment.this.f9860b0.getString(C1444R.string.user_name), this.f10331a.mo1248a(), true));
            list6 = this.f10332b.f10316c;
            list7 = this.f10332b.f10316c;
            list6.add(new PersonalDataFragment.C2578e(list7.size(), PersonalDataFragment.this.f9860b0.getString(C1444R.string.user_email), this.f10331a.mo1241h(), false));
            list8 = this.f10332b.f10316c;
            list9 = this.f10332b.f10316c;
            list8.add(new PersonalDataFragment.C2578e(list9.size(), PersonalDataFragment.this.f9860b0.getString(C1444R.string.user_phone), this.f10331a.mo1243f(), false));
            list10 = this.f10332b.f10316c;
            list11 = this.f10332b.f10316c;
            list10.add(new PersonalDataFragment.C2578e(list11.size(), PersonalDataFragment.this.f9860b0.getString(C1444R.string.user_active_payment_method), this.f10331a.mo1239j() != null ? this.f10331a.mo1239j().mo1224a() : PersonalDataFragment.this.f9860b0.getString(C1444R.string.user_no_active_payment_method), false));
            list12 = this.f10332b.f10316c;
            list13 = this.f10332b.f10316c;
            list12.add(new PersonalDataFragment.C2578e(list13.size(), PersonalDataFragment.this.f9860b0.getString(C1444R.string.user_active_social_tariff), sb.toString().equals("") ? PersonalDataFragment.this.f9860b0.getString(C1444R.string.user_no_active_social_tariff) : sb.toString(), false));
            this.f10332b.m6756b(0, 5);
            return;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            list14 = this.f10332b.f10316c;
            PersonalDataFragment.C2578e c2578e = (PersonalDataFragment.C2578e) list14.get(i2);
            PersonalDataFragment.C2578e c2578e2 = new PersonalDataFragment.C2578e(i2, c2578e.f10323g, strArr[i2], c2578e.f10322f);
            if (!c2578e.equals(c2578e2)) {
                list15 = this.f10332b.f10316c;
                list15.set(i2, c2578e2);
                arrayList.add(Integer.valueOf(i2));
            }
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            this.f10332b.m6749d(((Integer) arrayList.get(i3)).intValue());
        }
    }

    @Override // p205h.p208b.p209a.p210d.CountriesListener
    /* renamed from: b */
    public void mo737b(List<DataModels.Country> list) {
    }
}
