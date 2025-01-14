package p205h.p208b.p209a.p210d;

import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.b.a.d.s */
/* loaded from: classes.dex */
public interface RemoteUserListener {
    void onError(DataModels.Error error);

    void onSuccess(DataModels.UserAccountInfo userAccountInfo);
}
