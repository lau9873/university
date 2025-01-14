package h.b.a.d.b0;

import android.util.Log;
import h.b.a.d.a0;
import h.b.a.d.b;
import h.b.a.d.f;
import h.b.a.d.p;
import h.b.a.d.q;
import h.b.a.d.v;
import h.b.a.d.w;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import pt.card4b.backendbeacons.BackEnd;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: TipHistory.java */
/* loaded from: classes.dex */
public class c implements h.b.a.d.h {

    /* compiled from: TipHistory.java */
    /* loaded from: classes.dex */
    public static class a implements w {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h.b.a.d.k f6905a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DataModels.StageInfo f6906b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ q f6907c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ q f6908d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f6909e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ q f6910f;

        /* compiled from: TipHistory.java */
        /* renamed from: h.b.a.d.b0.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0158a implements Iterator<q> {
            public C0158a(a aVar) {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public q next() {
                return null;
            }
        }

        public a(h.b.a.d.k kVar, DataModels.StageInfo stageInfo, q qVar, q qVar2, q qVar3, q qVar4) {
            this.f6905a = kVar;
            this.f6906b = stageInfo;
            this.f6907c = qVar;
            this.f6908d = qVar2;
            this.f6909e = qVar3;
            this.f6910f = qVar4;
        }

        @Override // h.b.a.d.w
        public q a(int i2) {
            return null;
        }

        @Override // h.b.a.d.w
        public p b() {
            return h.b.a.d.b0.g.a(this.f6906b.getTransportOperatorRef());
        }

        @Override // h.b.a.d.w
        public q c() {
            return this.f6907c;
        }

        @Override // h.b.a.d.w
        public String d() {
            return this.f6906b.getTripId();
        }

        @Override // h.b.a.d.w
        public long e() {
            return this.f6906b.getStartDate().getTime();
        }

        @Override // h.b.a.d.w
        public q f() {
            return this.f6908d;
        }

        @Override // h.b.a.d.w
        public boolean g() {
            return this.f6906b.getIsPartialStage();
        }

        @Override // h.b.a.d.w
        public h.b.a.d.k h() {
            return this.f6905a;
        }

        @Override // h.b.a.d.w
        public int i() {
            return 0;
        }

        @Override // java.lang.Iterable
        public Iterator<q> iterator() {
            return new C0158a(this);
        }

        @Override // h.b.a.d.w
        public q j() {
            return this.f6910f;
        }

        @Override // h.b.a.d.w
        public q k() {
            return this.f6909e;
        }

        @Override // h.b.a.d.w
        public int l() {
            return 0;
        }

        @Override // h.b.a.d.w
        public Date m() {
            return null;
        }
    }

    /* compiled from: TipHistory.java */
    /* loaded from: classes.dex */
    public static class b implements h.b.a.d.k {

        /* renamed from: a  reason: collision with root package name */
        public final p f6911a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DataModels.StageInfo f6912b;

        public b(DataModels.StageInfo stageInfo) {
            this.f6912b = stageInfo;
            this.f6911a = h.b.a.d.b0.g.a(this.f6912b.getTransportOperatorRef());
        }

        @Override // h.b.a.d.k
        public String a() {
            return this.f6912b.getLineName();
        }

        @Override // h.b.a.d.k
        public p b() {
            return this.f6911a;
        }

        @Override // h.b.a.d.k
        public String c() {
            String a2 = a();
            return this.f6911a == h.b.a.d.b0.g.p ? a2.replace("Linha ", "") : a2;
        }

        @Override // h.b.a.d.k
        public DataModels.StageInfo d() {
            return this.f6912b;
        }

        @Override // h.b.a.d.k
        public String e() {
            return null;
        }
    }

    /* compiled from: TipHistory.java */
    /* renamed from: h.b.a.d.b0.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0159c implements v {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataModels.StageInfo f6913a;

        public C0159c(DataModels.StageInfo stageInfo) {
            this.f6913a = stageInfo;
        }

        @Override // h.b.a.d.v
        public String a() {
            return this.f6913a.getStartStopName();
        }

        @Override // h.b.a.d.v
        public String c() {
            return a();
        }

        @Override // h.b.a.d.v
        public a0 e() {
            return null;
        }

        @Override // h.b.a.d.v
        public int getType() {
            return 0;
        }
    }

    /* compiled from: TipHistory.java */
    /* loaded from: classes.dex */
    public static class d implements q {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v f6914a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DataModels.StageInfo f6915b;

        public d(v vVar, DataModels.StageInfo stageInfo) {
            this.f6914a = vVar;
            this.f6915b = stageInfo;
        }

        @Override // h.b.a.d.q
        public long a() {
            return this.f6915b.getStartDate().getTime();
        }

        @Override // h.b.a.d.q
        public v d() {
            return this.f6914a;
        }
    }

    /* compiled from: TipHistory.java */
    /* loaded from: classes.dex */
    public static class e implements v {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataModels.StageInfo f6916a;

        public e(DataModels.StageInfo stageInfo) {
            this.f6916a = stageInfo;
        }

        @Override // h.b.a.d.v
        public String a() {
            return this.f6916a.getStartPassingStopName();
        }

        @Override // h.b.a.d.v
        public String c() {
            return a();
        }

        @Override // h.b.a.d.v
        public a0 e() {
            return null;
        }

        @Override // h.b.a.d.v
        public int getType() {
            return 0;
        }
    }

    /* compiled from: TipHistory.java */
    /* loaded from: classes.dex */
    public static class f implements q {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v f6917a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DataModels.StageInfo f6918b;

        public f(v vVar, DataModels.StageInfo stageInfo) {
            this.f6917a = vVar;
            this.f6918b = stageInfo;
        }

        @Override // h.b.a.d.q
        public long a() {
            return this.f6918b.getStartPassingTime().getTime();
        }

        @Override // h.b.a.d.q
        public v d() {
            return this.f6917a;
        }
    }

    /* compiled from: TipHistory.java */
    /* loaded from: classes.dex */
    public static class g implements v {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataModels.StageInfo f6919a;

        public g(DataModels.StageInfo stageInfo) {
            this.f6919a = stageInfo;
        }

        @Override // h.b.a.d.v
        public String a() {
            return this.f6919a.getEndPassingStopName();
        }

        @Override // h.b.a.d.v
        public String c() {
            return a();
        }

        @Override // h.b.a.d.v
        public a0 e() {
            return null;
        }

        @Override // h.b.a.d.v
        public int getType() {
            return 0;
        }
    }

    /* compiled from: TipHistory.java */
    /* loaded from: classes.dex */
    public static class h implements q {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v f6920a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DataModels.StageInfo f6921b;

        public h(v vVar, DataModels.StageInfo stageInfo) {
            this.f6920a = vVar;
            this.f6921b = stageInfo;
        }

        @Override // h.b.a.d.q
        public long a() {
            return this.f6921b.getEndPassingTime().getTime();
        }

        @Override // h.b.a.d.q
        public v d() {
            return this.f6920a;
        }
    }

    /* compiled from: TipHistory.java */
    /* loaded from: classes.dex */
    public static class i implements v {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataModels.StageInfo f6922a;

        public i(DataModels.StageInfo stageInfo) {
            this.f6922a = stageInfo;
        }

        @Override // h.b.a.d.v
        public String a() {
            String finishStopName = this.f6922a.getFinishStopName();
            return (finishStopName == null || finishStopName.length() == 0) ? this.f6922a.getStartStopName() : finishStopName;
        }

        @Override // h.b.a.d.v
        public String c() {
            return a();
        }

        @Override // h.b.a.d.v
        public a0 e() {
            return null;
        }

        @Override // h.b.a.d.v
        public int getType() {
            return 0;
        }
    }

    /* compiled from: TipHistory.java */
    /* loaded from: classes.dex */
    public static class j implements q {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v f6923a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DataModels.StageInfo f6924b;

        public j(v vVar, DataModels.StageInfo stageInfo) {
            this.f6923a = vVar;
            this.f6924b = stageInfo;
        }

        @Override // h.b.a.d.q
        public long a() {
            Date finishDate = this.f6924b.getFinishDate();
            if (finishDate == null) {
                finishDate = this.f6924b.getStartDate();
            }
            return finishDate.getTime();
        }

        @Override // h.b.a.d.q
        public v d() {
            return this.f6923a;
        }
    }

    /* compiled from: TipHistory.java */
    /* loaded from: classes.dex */
    public static class k extends b.AbstractC0157b<List<w>> implements BackendListeners.HistoricInfoRequestListener {

        /* renamed from: b  reason: collision with root package name */
        public final List<w> f6925b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public boolean f6926c = false;

        /* renamed from: d  reason: collision with root package name */
        public f.a f6927d = null;

        public k(long j, long j2) {
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

        @Override // h.b.a.d.b
        public boolean b() {
            return this.f6926c;
        }

        @Override // h.b.a.d.b.AbstractC0157b
        public f.a d() {
            return this.f6927d;
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
            this.f6927d = h.b.a.d.b0.b.a(error);
            this.f6926c = true;
            c();
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.HistoricInfoRequestListener
        public void onSuccess(List<DataModels.StageInfo> list) {
            for (DataModels.StageInfo stageInfo : list) {
                this.f6925b.add(c.a(stageInfo));
            }
            this.f6926c = true;
            c();
        }

        @Override // h.b.a.d.b
        public List<w> a() {
            return this.f6925b;
        }
    }

    @Override // h.b.a.d.h
    public b.AbstractC0157b<List<w>> a(long j2, long j3) {
        return new k(j2, j3);
    }

    public static w a(DataModels.StageInfo stageInfo) {
        return new a(new b(stageInfo), stageInfo, new d(new C0159c(stageInfo), stageInfo), new j(new i(stageInfo), stageInfo), new f(new e(stageInfo), stageInfo), new h(new g(stageInfo), stageInfo));
    }
}
