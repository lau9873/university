package p000a.p001a.p005b;

import java.util.HashMap;

/* renamed from: a.a.b.p */
/* loaded from: classes.dex */
public class ViewModelStore {

    /* renamed from: a */
    public final HashMap<String, ViewModel> f49a = new HashMap<>();

    /* renamed from: a */
    public final void m11260a(String str, ViewModel viewModel) {
        ViewModel put = this.f49a.put(str, viewModel);
        if (put != null) {
            put.mo7434a();
        }
    }

    /* renamed from: a */
    public final ViewModel m11261a(String str) {
        return this.f49a.get(str);
    }

    /* renamed from: a */
    public final void m11262a() {
        for (ViewModel viewModel : this.f49a.values()) {
            viewModel.mo7434a();
        }
        this.f49a.clear();
    }
}
