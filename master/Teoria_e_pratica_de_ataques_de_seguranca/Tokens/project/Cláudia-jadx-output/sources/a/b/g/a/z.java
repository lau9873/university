package a.b.g.a;

import a.b.g.a.y;
import android.app.Notification;
import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: NotificationCompatBuilder.java */
/* loaded from: classes.dex */
public class z implements x {

    /* renamed from: a  reason: collision with root package name */
    public final Notification.Builder f840a;

    /* renamed from: b  reason: collision with root package name */
    public final y.c f841b;

    /* renamed from: c  reason: collision with root package name */
    public RemoteViews f842c;

    /* renamed from: d  reason: collision with root package name */
    public RemoteViews f843d;

    /* renamed from: e  reason: collision with root package name */
    public final List<Bundle> f844e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final Bundle f845f = new Bundle();

    /* renamed from: g  reason: collision with root package name */
    public int f846g;

    /* renamed from: h  reason: collision with root package name */
    public RemoteViews f847h;

    public z(y.c cVar) {
        ArrayList<String> arrayList;
        this.f841b = cVar;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f840a = new Notification.Builder(cVar.f827a, cVar.I);
        } else {
            this.f840a = new Notification.Builder(cVar.f827a);
        }
        Notification notification = cVar.N;
        this.f840a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, cVar.f834h).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(cVar.f830d).setContentText(cVar.f831e).setContentInfo(cVar.j).setContentIntent(cVar.f832f).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(cVar.f833g, (notification.flags & 128) != 0).setLargeIcon(cVar.f835i).setNumber(cVar.k).setProgress(cVar.r, cVar.s, cVar.t);
        if (Build.VERSION.SDK_INT < 21) {
            this.f840a.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f840a.setSubText(cVar.p).setUsesChronometer(cVar.n).setPriority(cVar.l);
            Iterator<y.a> it = cVar.f828b.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            Bundle bundle = cVar.B;
            if (bundle != null) {
                this.f845f.putAll(bundle);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (cVar.x) {
                    this.f845f.putBoolean("android.support.localOnly", true);
                }
                String str = cVar.u;
                if (str != null) {
                    this.f845f.putString("android.support.groupKey", str);
                    if (cVar.v) {
                        this.f845f.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f845f.putBoolean("android.support.useSideChannel", true);
                    }
                }
                String str2 = cVar.w;
                if (str2 != null) {
                    this.f845f.putString("android.support.sortKey", str2);
                }
            }
            this.f842c = cVar.F;
            this.f843d = cVar.G;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.f840a.setShowWhen(cVar.m);
            if (Build.VERSION.SDK_INT < 21 && (arrayList = cVar.O) != null && !arrayList.isEmpty()) {
                Bundle bundle2 = this.f845f;
                ArrayList<String> arrayList2 = cVar.O;
                bundle2.putStringArray("android.people", (String[]) arrayList2.toArray(new String[arrayList2.size()]));
            }
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f840a.setLocalOnly(cVar.x).setGroup(cVar.u).setGroupSummary(cVar.v).setSortKey(cVar.w);
            this.f846g = cVar.M;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f840a.setCategory(cVar.A).setColor(cVar.C).setVisibility(cVar.D).setPublicVersion(cVar.E).setSound(notification.sound, notification.audioAttributes);
            Iterator<String> it2 = cVar.O.iterator();
            while (it2.hasNext()) {
                this.f840a.addPerson(it2.next());
            }
            this.f847h = cVar.H;
            if (cVar.f829c.size() > 0) {
                Bundle bundle3 = cVar.b().getBundle("android.car.EXTENSIONS");
                bundle3 = bundle3 == null ? new Bundle() : bundle3;
                Bundle bundle4 = new Bundle();
                for (int i2 = 0; i2 < cVar.f829c.size(); i2++) {
                    bundle4.putBundle(Integer.toString(i2), a0.a(cVar.f829c.get(i2)));
                }
                bundle3.putBundle("invisible_actions", bundle4);
                cVar.b().putBundle("android.car.EXTENSIONS", bundle3);
                this.f845f.putBundle("android.car.EXTENSIONS", bundle3);
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f840a.setExtras(cVar.B).setRemoteInputHistory(cVar.q);
            RemoteViews remoteViews = cVar.F;
            if (remoteViews != null) {
                this.f840a.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = cVar.G;
            if (remoteViews2 != null) {
                this.f840a.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = cVar.H;
            if (remoteViews3 != null) {
                this.f840a.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f840a.setBadgeIconType(cVar.J).setShortcutId(cVar.K).setTimeoutAfter(cVar.L).setGroupAlertBehavior(cVar.M);
            if (cVar.z) {
                this.f840a.setColorized(cVar.y);
            }
            if (TextUtils.isEmpty(cVar.I)) {
                return;
            }
            this.f840a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
    }

    @Override // a.b.g.a.x
    public Notification.Builder a() {
        return this.f840a;
    }

    public Notification b() {
        Bundle a2;
        RemoteViews d2;
        RemoteViews b2;
        y.d dVar = this.f841b.o;
        if (dVar != null) {
            dVar.a(this);
        }
        RemoteViews c2 = dVar != null ? dVar.c(this) : null;
        Notification c3 = c();
        if (c2 != null) {
            c3.contentView = c2;
        } else {
            RemoteViews remoteViews = this.f841b.F;
            if (remoteViews != null) {
                c3.contentView = remoteViews;
            }
        }
        if (Build.VERSION.SDK_INT >= 16 && dVar != null && (b2 = dVar.b(this)) != null) {
            c3.bigContentView = b2;
        }
        if (Build.VERSION.SDK_INT >= 21 && dVar != null && (d2 = this.f841b.o.d(this)) != null) {
            c3.headsUpContentView = d2;
        }
        if (Build.VERSION.SDK_INT >= 16 && dVar != null && (a2 = y.a(c3)) != null) {
            dVar.a(a2);
        }
        return c3;
    }

    public Notification c() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            return this.f840a.build();
        }
        if (i2 >= 24) {
            Notification build = this.f840a.build();
            if (this.f846g != 0) {
                if (build.getGroup() != null && (build.flags & 512) != 0 && this.f846g == 2) {
                    a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f846g == 1) {
                    a(build);
                }
            }
            return build;
        } else if (i2 >= 21) {
            this.f840a.setExtras(this.f845f);
            Notification build2 = this.f840a.build();
            RemoteViews remoteViews = this.f842c;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f843d;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.f847h;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.f846g != 0) {
                if (build2.getGroup() != null && (build2.flags & 512) != 0 && this.f846g == 2) {
                    a(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.f846g == 1) {
                    a(build2);
                }
            }
            return build2;
        } else if (i2 >= 20) {
            this.f840a.setExtras(this.f845f);
            Notification build3 = this.f840a.build();
            RemoteViews remoteViews4 = this.f842c;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f843d;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.f846g != 0) {
                if (build3.getGroup() != null && (build3.flags & 512) != 0 && this.f846g == 2) {
                    a(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.f846g == 1) {
                    a(build3);
                }
            }
            return build3;
        } else if (i2 >= 19) {
            SparseArray<Bundle> a2 = a0.a(this.f844e);
            if (a2 != null) {
                this.f845f.putSparseParcelableArray("android.support.actionExtras", a2);
            }
            this.f840a.setExtras(this.f845f);
            Notification build4 = this.f840a.build();
            RemoteViews remoteViews6 = this.f842c;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.f843d;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        } else if (i2 >= 16) {
            Notification build5 = this.f840a.build();
            Bundle a3 = y.a(build5);
            Bundle bundle = new Bundle(this.f845f);
            for (String str : this.f845f.keySet()) {
                if (a3.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a3.putAll(bundle);
            SparseArray<Bundle> a4 = a0.a(this.f844e);
            if (a4 != null) {
                y.a(build5).putSparseParcelableArray("android.support.actionExtras", a4);
            }
            RemoteViews remoteViews8 = this.f842c;
            if (remoteViews8 != null) {
                build5.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.f843d;
            if (remoteViews9 != null) {
                build5.bigContentView = remoteViews9;
            }
            return build5;
        } else {
            return this.f840a.getNotification();
        }
    }

    public final void a(y.a aVar) {
        Bundle bundle;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 20) {
            if (i2 >= 16) {
                this.f844e.add(a0.a(this.f840a, aVar));
                return;
            }
            return;
        }
        Notification.Action.Builder builder = new Notification.Action.Builder(aVar.e(), aVar.i(), aVar.a());
        if (aVar.f() != null) {
            for (RemoteInput remoteInput : d0.a(aVar.f())) {
                builder.addRemoteInput(remoteInput);
            }
        }
        if (aVar.d() != null) {
            bundle = new Bundle(aVar.d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        if (Build.VERSION.SDK_INT >= 24) {
            builder.setAllowGeneratedReplies(aVar.b());
        }
        bundle.putInt("android.support.action.semanticAction", aVar.g());
        if (Build.VERSION.SDK_INT >= 28) {
            builder.setSemanticAction(aVar.g());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.h());
        builder.addExtras(bundle);
        this.f840a.addAction(builder.build());
    }

    public final void a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
