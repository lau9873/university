package h.b.a.e.d;

import h.b.a.d.y;
import h.b.a.e.d.w3;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: PersonalDataFragment.java */
/* loaded from: classes.dex */
public class x3 implements h.b.a.d.e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h.b.a.d.y f7401a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ w3.c f7402b;

    public x3(w3.c cVar, h.b.a.d.y yVar) {
        this.f7402b = cVar;
        this.f7401a = yVar;
    }

    @Override // h.b.a.d.e
    public void a(List<DataModels.Language> list) {
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
        list2 = w3.this.n0;
        if (!list2.isEmpty()) {
            list17 = w3.this.n0;
            list17.clear();
        }
        hashMap = w3.this.m0;
        if (!hashMap.isEmpty()) {
            hashMap3 = w3.this.m0;
            hashMap3.clear();
        }
        for (DataModels.Language language : list) {
            hashMap2 = w3.this.m0;
            hashMap2.put(language.getCode(), language);
            list16 = w3.this.n0;
            list16.add(new w3.b(7, language));
        }
        StringBuilder sb = new StringBuilder();
        if (this.f7401a.d().size() > 0) {
            StringBuilder sb2 = sb;
            for (int i2 = 0; i2 < this.f7401a.d().size(); i2++) {
                y.c cVar = this.f7401a.d().get(i2);
                Date time = Calendar.getInstance().getTime();
                if (time.getTime() >= cVar.c().getTime() && time.getTime() <= cVar.b().getTime()) {
                    if (sb2.length() == 0) {
                        sb2 = new StringBuilder(this.f7401a.d().get(i2).a());
                    } else {
                        sb2.append(" / ");
                        sb2.append(this.f7401a.d().get(i2).a());
                    }
                }
            }
            sb = sb2;
        }
        String[] strArr = new String[5];
        strArr[0] = this.f7401a.a();
        strArr[1] = this.f7401a.h();
        strArr[2] = this.f7401a.f();
        strArr[3] = this.f7401a.j() != null ? this.f7401a.j().a() : w3.this.b0.getString(2131755394);
        strArr[4] = sb.toString().equals("") ? w3.this.b0.getString(2131755395) : sb.toString();
        ArrayList arrayList = new ArrayList();
        list3 = this.f7402b.f7390c;
        if (list3.size() != 5) {
            list4 = this.f7402b.f7390c;
            list5 = this.f7402b.f7390c;
            list4.add(new w3.e(list5.size(), w3.this.b0.getString(2131755392), this.f7401a.a(), true));
            list6 = this.f7402b.f7390c;
            list7 = this.f7402b.f7390c;
            list6.add(new w3.e(list7.size(), w3.this.b0.getString(2131755387), this.f7401a.h(), false));
            list8 = this.f7402b.f7390c;
            list9 = this.f7402b.f7390c;
            list8.add(new w3.e(list9.size(), w3.this.b0.getString(2131755409), this.f7401a.f(), false));
            list10 = this.f7402b.f7390c;
            list11 = this.f7402b.f7390c;
            list10.add(new w3.e(list11.size(), w3.this.b0.getString(2131755379), this.f7401a.j() != null ? this.f7401a.j().a() : w3.this.b0.getString(2131755394), false));
            list12 = this.f7402b.f7390c;
            list13 = this.f7402b.f7390c;
            list12.add(new w3.e(list13.size(), w3.this.b0.getString(2131755380), sb.toString().equals("") ? w3.this.b0.getString(2131755395) : sb.toString(), false));
            this.f7402b.b(0, 5);
            return;
        }
        for (int i3 = 0; i3 < 5; i3++) {
            list14 = this.f7402b.f7390c;
            w3.e eVar = (w3.e) list14.get(i3);
            w3.e eVar2 = new w3.e(i3, eVar.f7393g, strArr[i3], eVar.f7392f);
            if (!eVar.equals(eVar2)) {
                list15 = this.f7402b.f7390c;
                list15.set(i3, eVar2);
                arrayList.add(Integer.valueOf(i3));
            }
        }
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            this.f7402b.d(((Integer) arrayList.get(i4)).intValue());
        }
    }

    @Override // h.b.a.d.e
    public void b(List<DataModels.Country> list) {
    }
}
