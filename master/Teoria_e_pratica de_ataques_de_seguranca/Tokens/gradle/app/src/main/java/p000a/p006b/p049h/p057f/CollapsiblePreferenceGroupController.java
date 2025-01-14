package p000a.p006b.p049h.p057f;

import android.content.Context;
import android.support.p067v7.preference.Preference;
import android.support.p067v7.preference.PreferenceGroup;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: a.b.h.f.a */
/* loaded from: classes.dex */
public final class CollapsiblePreferenceGroupController {

    /* renamed from: a */
    public final PreferenceGroupAdapter f2115a;

    /* renamed from: b */
    public final Context f2116b;

    /* renamed from: c */
    public boolean f2117c = false;

    /* compiled from: CollapsiblePreferenceGroupController.java */
    /* renamed from: a.b.h.f.a$a */
    /* loaded from: classes.dex */
    public class C0381a implements Preference.InterfaceC0665e {

        /* renamed from: a */
        public final /* synthetic */ PreferenceGroup f2118a;

        public C0381a(PreferenceGroup preferenceGroup) {
            this.f2118a = preferenceGroup;
        }

        @Override // android.support.p067v7.preference.Preference.InterfaceC0665e
        /* renamed from: a */
        public boolean mo764a(Preference preference) {
            this.f2118a.m7176h(Integer.MAX_VALUE);
            CollapsiblePreferenceGroupController.this.f2115a.mo7196a(preference);
            PreferenceGroup.InterfaceC0667b m7188K = this.f2118a.m7188K();
            if (m7188K != null) {
                m7188K.m7175a();
                return true;
            }
            return true;
        }
    }

    public CollapsiblePreferenceGroupController(PreferenceGroup preferenceGroup, PreferenceGroupAdapter preferenceGroupAdapter) {
        this.f2115a = preferenceGroupAdapter;
        this.f2116b = preferenceGroup.m7222d();
    }

    /* renamed from: a */
    public final List<Preference> m8901a(PreferenceGroup preferenceGroup) {
        this.f2117c = false;
        boolean z = preferenceGroup.m7189J() != Integer.MAX_VALUE;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int m7187L = preferenceGroup.m7187L();
        int i = 0;
        for (int i2 = 0; i2 < m7187L; i2++) {
            Preference m7177g = preferenceGroup.m7177g(i2);
            if (m7177g.m7199x()) {
                if (z && i >= preferenceGroup.m7189J()) {
                    arrayList2.add(m7177g);
                } else {
                    arrayList.add(m7177g);
                }
                if (m7177g instanceof PreferenceGroup) {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) m7177g;
                    if (preferenceGroup2.mo7174M()) {
                        List<Preference> m8901a = m8901a(preferenceGroup2);
                        if (z && this.f2117c) {
                            throw new IllegalArgumentException("Nested expand buttons are not supported!");
                        }
                        for (Preference preference : m8901a) {
                            if (z && i >= preferenceGroup.m7189J()) {
                                arrayList2.add(preference);
                            } else {
                                arrayList.add(preference);
                            }
                            i++;
                        }
                    } else {
                        continue;
                    }
                } else {
                    i++;
                }
            }
        }
        if (z && i > preferenceGroup.m7189J()) {
            arrayList.add(m8900a(preferenceGroup, arrayList2));
        }
        this.f2117c |= z;
        return arrayList;
    }

    /* renamed from: b */
    public List<Preference> m8899b(PreferenceGroup preferenceGroup) {
        return m8901a(preferenceGroup);
    }

    /* compiled from: CollapsiblePreferenceGroupController.java */
    /* renamed from: a.b.h.f.a$b */
    /* loaded from: classes.dex */
    public static class C0382b extends Preference {

        /* renamed from: N */
        public long f2120N;

        public C0382b(Context context, List<Preference> list, long j) {
            super(context);
            m8898J();
            m8897a(list);
            this.f2120N = j + 1000000;
        }

        /* renamed from: J */
        public final void m8898J() {
            m7221d(C0402p.expand_button);
            m7227c(C0400n.ic_arrow_down_24dp);
            m7216f(C0403q.expand_button_title);
            m7218e(999);
        }

        /* renamed from: a */
        public final void m8897a(List<Preference> list) {
            ArrayList arrayList = new ArrayList();
            CharSequence charSequence = null;
            for (Preference preference : list) {
                CharSequence m7204r = preference.m7204r();
                boolean z = preference instanceof PreferenceGroup;
                if (z && !TextUtils.isEmpty(m7204r)) {
                    arrayList.add((PreferenceGroup) preference);
                }
                if (arrayList.contains(preference.m7209m())) {
                    if (z) {
                        arrayList.add((PreferenceGroup) preference);
                    }
                } else if (!TextUtils.isEmpty(m7204r)) {
                    charSequence = charSequence == null ? m7204r : m7222d().getString(C0403q.summary_collapsed_preference_list, charSequence, m7204r);
                }
            }
            mo7241a(charSequence);
        }

        @Override // android.support.p067v7.preference.Preference
        /* renamed from: h */
        public long mo7214h() {
            return this.f2120N;
        }

        @Override // android.support.p067v7.preference.Preference
        /* renamed from: a */
        public void mo7167a(PreferenceViewHolder preferenceViewHolder) {
            super.mo7167a(preferenceViewHolder);
            preferenceViewHolder.m8809b(false);
        }
    }

    /* renamed from: a */
    public final C0382b m8900a(PreferenceGroup preferenceGroup, List<Preference> list) {
        C0382b c0382b = new C0382b(this.f2116b, list, preferenceGroup.mo7214h());
        c0382b.m7246a((Preference.InterfaceC0665e) new C0381a(preferenceGroup));
        return c0382b;
    }
}
