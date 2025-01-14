package a.b.h.f;

import android.content.Context;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* compiled from: CollapsiblePreferenceGroupController.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final h f1403a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f1404b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1405c = false;

    /* compiled from: CollapsiblePreferenceGroupController.java */
    /* renamed from: a.b.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0040a implements Preference.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PreferenceGroup f1406a;

        public C0040a(PreferenceGroup preferenceGroup) {
            this.f1406a = preferenceGroup;
        }

        @Override // android.support.v7.preference.Preference.e
        public boolean a(Preference preference) {
            this.f1406a.h(Integer.MAX_VALUE);
            a.this.f1403a.a(preference);
            PreferenceGroup.b K = this.f1406a.K();
            if (K != null) {
                K.a();
                return true;
            }
            return true;
        }
    }

    public a(PreferenceGroup preferenceGroup, h hVar) {
        this.f1403a = hVar;
        this.f1404b = preferenceGroup.d();
    }

    public final List<Preference> a(PreferenceGroup preferenceGroup) {
        this.f1405c = false;
        boolean z = preferenceGroup.J() != Integer.MAX_VALUE;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int L = preferenceGroup.L();
        int i2 = 0;
        for (int i3 = 0; i3 < L; i3++) {
            Preference g2 = preferenceGroup.g(i3);
            if (g2.x()) {
                if (z && i2 >= preferenceGroup.J()) {
                    arrayList2.add(g2);
                } else {
                    arrayList.add(g2);
                }
                if (g2 instanceof PreferenceGroup) {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) g2;
                    if (preferenceGroup2.M()) {
                        List<Preference> a2 = a(preferenceGroup2);
                        if (z && this.f1405c) {
                            throw new IllegalArgumentException("Nested expand buttons are not supported!");
                        }
                        for (Preference preference : a2) {
                            if (z && i2 >= preferenceGroup.J()) {
                                arrayList2.add(preference);
                            } else {
                                arrayList.add(preference);
                            }
                            i2++;
                        }
                    } else {
                        continue;
                    }
                } else {
                    i2++;
                }
            }
        }
        if (z && i2 > preferenceGroup.J()) {
            arrayList.add(a(preferenceGroup, arrayList2));
        }
        this.f1405c |= z;
        return arrayList;
    }

    public List<Preference> b(PreferenceGroup preferenceGroup) {
        return a(preferenceGroup);
    }

    /* compiled from: CollapsiblePreferenceGroupController.java */
    /* loaded from: classes.dex */
    public static class b extends Preference {
        public long N;

        public b(Context context, List<Preference> list, long j) {
            super(context);
            J();
            a(list);
            this.N = j + 1000000;
        }

        public final void J() {
            d(p.expand_button);
            c(n.ic_arrow_down_24dp);
            f(q.expand_button_title);
            e(999);
        }

        public final void a(List<Preference> list) {
            ArrayList arrayList = new ArrayList();
            CharSequence charSequence = null;
            for (Preference preference : list) {
                CharSequence r = preference.r();
                boolean z = preference instanceof PreferenceGroup;
                if (z && !TextUtils.isEmpty(r)) {
                    arrayList.add((PreferenceGroup) preference);
                }
                if (arrayList.contains(preference.m())) {
                    if (z) {
                        arrayList.add((PreferenceGroup) preference);
                    }
                } else if (!TextUtils.isEmpty(r)) {
                    charSequence = charSequence == null ? r : d().getString(q.summary_collapsed_preference_list, charSequence, r);
                }
            }
            a(charSequence);
        }

        @Override // android.support.v7.preference.Preference
        public long h() {
            return this.N;
        }

        @Override // android.support.v7.preference.Preference
        public void a(l lVar) {
            super.a(lVar);
            lVar.b(false);
        }
    }

    public final b a(PreferenceGroup preferenceGroup, List<Preference> list) {
        b bVar = new b(this.f1404b, list, preferenceGroup.h());
        bVar.a((Preference.e) new C0040a(preferenceGroup));
        return bVar;
    }
}
