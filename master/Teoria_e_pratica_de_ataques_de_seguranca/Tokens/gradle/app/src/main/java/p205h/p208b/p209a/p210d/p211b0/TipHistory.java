package p205h.p208b.p209a.p210d.p211b0;

import android.util.Log;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import p205h.p208b.p209a.p210d.AsyncResult;
import p205h.p208b.p209a.p210d.ErrorListener;
import p205h.p208b.p209a.p210d.History;
import p205h.p208b.p209a.p210d.Line;
import p205h.p208b.p209a.p210d.Operator;
import p205h.p208b.p209a.p210d.Passing;
import p205h.p208b.p209a.p210d.Stop;
import p205h.p208b.p209a.p210d.Trip;
import p205h.p208b.p209a.p210d.Zone;
import pt.card4b.backendbeacons.BackEnd;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.b.a.d.b0.c */
/* loaded from: classes.dex */
public class TipHistory implements History {

    /* compiled from: TipHistory.java */
    /* renamed from: h.b.a.d.b0.c$a */
    /* loaded from: classes.dex */
    public static class C2283a implements Trip {

        /* renamed from: a */
        public final /* synthetic */ Line f9535a;

        /* renamed from: b */
        public final /* synthetic */ DataModels.StageInfo f9536b;

        /* renamed from: c */
        public final /* synthetic */ Passing f9537c;

        /* renamed from: d */
        public final /* synthetic */ Passing f9538d;

        /* renamed from: e */
        public final /* synthetic */ Passing f9539e;

        /* renamed from: f */
        public final /* synthetic */ Passing f9540f;

        /* compiled from: TipHistory.java */
        /* renamed from: h.b.a.d.b0.c$a$a */
        /* loaded from: classes.dex */
        public class C2284a implements Iterator<Passing> {
            public C2284a(C2283a c2283a) {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public Passing next() {
                return null;
            }
        }

        public C2283a(Line line, DataModels.StageInfo stageInfo, Passing passing, Passing passing2, Passing passing3, Passing passing4) {
            this.f9535a = line;
            this.f9536b = stageInfo;
            this.f9537c = passing;
            this.f9538d = passing2;
            this.f9539e = passing3;
            this.f9540f = passing4;
        }

        @Override // p205h.p208b.p209a.p210d.Trip
        /* renamed from: a */
        public Passing mo1264a(int i) {
            return null;
        }

        @Override // p205h.p208b.p209a.p210d.Trip
        /* renamed from: b */
        public Operator mo1263b() {
            return TipOperators.m1365a(this.f9536b.getTransportOperatorRef());
        }

        @Override // p205h.p208b.p209a.p210d.Trip
        /* renamed from: c */
        public Passing mo1262c() {
            return this.f9537c;
        }

        @Override // p205h.p208b.p209a.p210d.Trip
        /* renamed from: d */
        public String mo1261d() {
            return this.f9536b.getTripId();
        }

        @Override // p205h.p208b.p209a.p210d.Trip
        /* renamed from: e */
        public long mo1260e() {
            return this.f9536b.getStartDate().getTime();
        }

        @Override // p205h.p208b.p209a.p210d.Trip
        /* renamed from: f */
        public Passing mo1259f() {
            return this.f9538d;
        }

        @Override // p205h.p208b.p209a.p210d.Trip
        /* renamed from: g */
        public boolean mo1258g() {
            return this.f9536b.getIsPartialStage();
        }

        @Override // p205h.p208b.p209a.p210d.Trip
        /* renamed from: h */
        public Line mo1257h() {
            return this.f9535a;
        }

        @Override // p205h.p208b.p209a.p210d.Trip
        /* renamed from: i */
        public int mo1256i() {
            return 0;
        }

        @Override // java.lang.Iterable
        public Iterator<Passing> iterator() {
            return new C2284a(this);
        }

        @Override // p205h.p208b.p209a.p210d.Trip
        /* renamed from: j */
        public Passing mo1255j() {
            return this.f9540f;
        }

        @Override // p205h.p208b.p209a.p210d.Trip
        /* renamed from: k */
        public Passing mo1254k() {
            return this.f9539e;
        }

        @Override // p205h.p208b.p209a.p210d.Trip
        /* renamed from: l */
        public int mo1253l() {
            return 0;
        }

        @Override // p205h.p208b.p209a.p210d.Trip
        /* renamed from: m */
        public Date mo1252m() {
            return null;
        }
    }

    /* compiled from: TipHistory.java */
    /* renamed from: h.b.a.d.b0.c$b */
    /* loaded from: classes.dex */
    public static class C2285b implements Line {

        /* renamed from: a */
        public final Operator f9541a;

        /* renamed from: b */
        public final /* synthetic */ DataModels.StageInfo f9542b;

        public C2285b(DataModels.StageInfo stageInfo) {
            this.f9542b = stageInfo;
            this.f9541a = TipOperators.m1365a(this.f9542b.getTransportOperatorRef());
        }

        @Override // p205h.p208b.p209a.p210d.Line
        /* renamed from: a */
        public String mo1313a() {
            return this.f9542b.getLineName();
        }

        @Override // p205h.p208b.p209a.p210d.Line
        /* renamed from: b */
        public Operator mo1312b() {
            return this.f9541a;
        }

        @Override // p205h.p208b.p209a.p210d.Line
        /* renamed from: c */
        public String mo1311c() {
            String mo1313a = mo1313a();
            return this.f9541a == TipOperators.f9577p ? mo1313a.replace("Linha ", "") : mo1313a;
        }

        @Override // p205h.p208b.p209a.p210d.Line
        /* renamed from: d */
        public DataModels.StageInfo mo1310d() {
            return this.f9542b;
        }

        @Override // p205h.p208b.p209a.p210d.Line
        /* renamed from: e */
        public String mo1309e() {
            return null;
        }
    }

    /* compiled from: TipHistory.java */
    /* renamed from: h.b.a.d.b0.c$c */
    /* loaded from: classes.dex */
    public static class C2286c implements Stop {

        /* renamed from: a */
        public final /* synthetic */ DataModels.StageInfo f9543a;

        public C2286c(DataModels.StageInfo stageInfo) {
            this.f9543a = stageInfo;
        }

        @Override // p205h.p208b.p209a.p210d.Stop
        /* renamed from: a */
        public String mo1267a() {
            return this.f9543a.getStartStopName();
        }

        @Override // p205h.p208b.p209a.p210d.Stop
        /* renamed from: c */
        public String mo1266c() {
            return mo1267a();
        }

        @Override // p205h.p208b.p209a.p210d.Stop
        /* renamed from: e */
        public Zone mo1265e() {
            return null;
        }

        @Override // p205h.p208b.p209a.p210d.Stop
        public int getType() {
            return 0;
        }
    }

    /* compiled from: TipHistory.java */
    /* renamed from: h.b.a.d.b0.c$d */
    /* loaded from: classes.dex */
    public static class C2287d implements Passing {

        /* renamed from: a */
        public final /* synthetic */ Stop f9544a;

        /* renamed from: b */
        public final /* synthetic */ DataModels.StageInfo f9545b;

        public C2287d(Stop stop, DataModels.StageInfo stageInfo) {
            this.f9544a = stop;
            this.f9545b = stageInfo;
        }

        @Override // p205h.p208b.p209a.p210d.Passing
        /* renamed from: a */
        public long mo1286a() {
            return this.f9545b.getStartDate().getTime();
        }

        @Override // p205h.p208b.p209a.p210d.Passing
        /* renamed from: d */
        public Stop mo1285d() {
            return this.f9544a;
        }
    }

    /* compiled from: TipHistory.java */
    /* renamed from: h.b.a.d.b0.c$e */
    /* loaded from: classes.dex */
    public static class C2288e implements Stop {

        /* renamed from: a */
        public final /* synthetic */ DataModels.StageInfo f9546a;

        public C2288e(DataModels.StageInfo stageInfo) {
            this.f9546a = stageInfo;
        }

        @Override // p205h.p208b.p209a.p210d.Stop
        /* renamed from: a */
        public String mo1267a() {
            return this.f9546a.getStartPassingStopName();
        }

        @Override // p205h.p208b.p209a.p210d.Stop
        /* renamed from: c */
        public String mo1266c() {
            return mo1267a();
        }

        @Override // p205h.p208b.p209a.p210d.Stop
        /* renamed from: e */
        public Zone mo1265e() {
            return null;
        }

        @Override // p205h.p208b.p209a.p210d.Stop
        public int getType() {
            return 0;
        }
    }

    /* compiled from: TipHistory.java */
    /* renamed from: h.b.a.d.b0.c$f */
    /* loaded from: classes.dex */
    public static class C2289f implements Passing {

        /* renamed from: a */
        public final /* synthetic */ Stop f9547a;

        /* renamed from: b */
        public final /* synthetic */ DataModels.StageInfo f9548b;

        public C2289f(Stop stop, DataModels.StageInfo stageInfo) {
            this.f9547a = stop;
            this.f9548b = stageInfo;
        }

        @Override // p205h.p208b.p209a.p210d.Passing
        /* renamed from: a */
        public long mo1286a() {
            return this.f9548b.getStartPassingTime().getTime();
        }

        @Override // p205h.p208b.p209a.p210d.Passing
        /* renamed from: d */
        public Stop mo1285d() {
            return this.f9547a;
        }
    }

    /* compiled from: TipHistory.java */
    /* renamed from: h.b.a.d.b0.c$g */
    /* loaded from: classes.dex */
    public static class C2290g implements Stop {

        /* renamed from: a */
        public final /* synthetic */ DataModels.StageInfo f9549a;

        public C2290g(DataModels.StageInfo stageInfo) {
            this.f9549a = stageInfo;
        }

        @Override // p205h.p208b.p209a.p210d.Stop
        /* renamed from: a */
        public String mo1267a() {
            return this.f9549a.getEndPassingStopName();
        }

        @Override // p205h.p208b.p209a.p210d.Stop
        /* renamed from: c */
        public String mo1266c() {
            return mo1267a();
        }

        @Override // p205h.p208b.p209a.p210d.Stop
        /* renamed from: e */
        public Zone mo1265e() {
            return null;
        }

        @Override // p205h.p208b.p209a.p210d.Stop
        public int getType() {
            return 0;
        }
    }

    /* compiled from: TipHistory.java */
    /* renamed from: h.b.a.d.b0.c$h */
    /* loaded from: classes.dex */
    public static class C2291h implements Passing {

        /* renamed from: a */
        public final /* synthetic */ Stop f9550a;

        /* renamed from: b */
        public final /* synthetic */ DataModels.StageInfo f9551b;

        public C2291h(Stop stop, DataModels.StageInfo stageInfo) {
            this.f9550a = stop;
            this.f9551b = stageInfo;
        }

        @Override // p205h.p208b.p209a.p210d.Passing
        /* renamed from: a */
        public long mo1286a() {
            return this.f9551b.getEndPassingTime().getTime();
        }

        @Override // p205h.p208b.p209a.p210d.Passing
        /* renamed from: d */
        public Stop mo1285d() {
            return this.f9550a;
        }
    }

    /* compiled from: TipHistory.java */
    /* renamed from: h.b.a.d.b0.c$i */
    /* loaded from: classes.dex */
    public static class C2292i implements Stop {

        /* renamed from: a */
        public final /* synthetic */ DataModels.StageInfo f9552a;

        public C2292i(DataModels.StageInfo stageInfo) {
            this.f9552a = stageInfo;
        }

        @Override // p205h.p208b.p209a.p210d.Stop
        /* renamed from: a */
        public String mo1267a() {
            String finishStopName = this.f9552a.getFinishStopName();
            return (finishStopName == null || finishStopName.length() == 0) ? this.f9552a.getStartStopName() : finishStopName;
        }

        @Override // p205h.p208b.p209a.p210d.Stop
        /* renamed from: c */
        public String mo1266c() {
            return mo1267a();
        }

        @Override // p205h.p208b.p209a.p210d.Stop
        /* renamed from: e */
        public Zone mo1265e() {
            return null;
        }

        @Override // p205h.p208b.p209a.p210d.Stop
        public int getType() {
            return 0;
        }
    }

    /* compiled from: TipHistory.java */
    /* renamed from: h.b.a.d.b0.c$j */
    /* loaded from: classes.dex */
    public static class C2293j implements Passing {

        /* renamed from: a */
        public final /* synthetic */ Stop f9553a;

        /* renamed from: b */
        public final /* synthetic */ DataModels.StageInfo f9554b;

        public C2293j(Stop stop, DataModels.StageInfo stageInfo) {
            this.f9553a = stop;
            this.f9554b = stageInfo;
        }

        @Override // p205h.p208b.p209a.p210d.Passing
        /* renamed from: a */
        public long mo1286a() {
            Date finishDate = this.f9554b.getFinishDate();
            if (finishDate == null) {
                finishDate = this.f9554b.getStartDate();
            }
            return finishDate.getTime();
        }

        @Override // p205h.p208b.p209a.p210d.Passing
        /* renamed from: d */
        public Stop mo1285d() {
            return this.f9553a;
        }
    }

    /* compiled from: TipHistory.java */
    /* renamed from: h.b.a.d.b0.c$k */
    /* loaded from: classes.dex */
    public static class C2294k extends AsyncResult.AbstractC2280b<List<Trip>> implements BackendListeners.HistoricInfoRequestListener {

        /* renamed from: b */
        public final List<Trip> f9555b = new ArrayList();

        /* renamed from: c */
        public boolean f9556c = false;

        /* renamed from: d */
        public ErrorListener.C2358a f9557d = null;

        public C2294k(long j, long j2) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            calendar.set(5, 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            Date time = calendar.getTime();
            Log.d("Anda:History", "HistoryRequest: " + time);
            BackEnd.getHistoricStageInfo(time, this);
        }

        @Override // p205h.p208b.p209a.p210d.AsyncResult
        /* renamed from: b */
        public boolean mo1333b() {
            return this.f9556c;
        }

        @Override // p205h.p208b.p209a.p210d.AsyncResult.AbstractC2280b
        /* renamed from: d */
        public ErrorListener.C2358a mo1349d() {
            return this.f9557d;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("Error:");
            if (error == null) {
                str = "null";
            } else {
                str = error.getMessage() + ": " + error.getMessageToUser();
            }
            sb.append(str);
            Log.e("Anda:History", sb.toString());
            this.f9557d = TipErrorConverter.m1372a(error);
            this.f9556c = true;
            m1374c();
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.HistoricInfoRequestListener
        public void onSuccess(List<DataModels.StageInfo> list) {
            for (DataModels.StageInfo stageInfo : list) {
                this.f9555b.add(TipHistory.m1371a(stageInfo));
            }
            this.f9556c = true;
            m1374c();
        }

        @Override // p205h.p208b.p209a.p210d.AsyncResult
        /* renamed from: a */
        public List<Trip> mo1334a() {
            return this.f9555b;
        }
    }

    @Override // p205h.p208b.p209a.p210d.History
    /* renamed from: a */
    public AsyncResult.AbstractC2280b<List<Trip>> mo1319a(long j, long j2) {
        return new C2294k(j, j2);
    }

    /* renamed from: a */
    public static Trip m1371a(DataModels.StageInfo stageInfo) {
        return new C2283a(new C2285b(stageInfo), stageInfo, new C2287d(new C2286c(stageInfo), stageInfo), new C2293j(new C2292i(stageInfo), stageInfo), new C2289f(new C2288e(stageInfo), stageInfo), new C2291h(new C2290g(stageInfo), stageInfo));
    }
}
