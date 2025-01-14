package p000a.p006b.p030g.p031a;

import android.app.Notification;
import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import com.j256.ormlite.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p000a.p006b.p030g.p031a.NotificationCompat;

/* renamed from: a.b.g.a.z */
/* loaded from: classes.dex */
public class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {

    /* renamed from: a */
    public final Notification.Builder f1343a;

    /* renamed from: b */
    public final NotificationCompat.C0189c f1344b;

    /* renamed from: c */
    public RemoteViews f1345c;

    /* renamed from: d */
    public RemoteViews f1346d;

    /* renamed from: e */
    public final List<Bundle> f1347e = new ArrayList();

    /* renamed from: f */
    public final Bundle f1348f = new Bundle();

    /* renamed from: g */
    public int f1349g;

    /* renamed from: h */
    public RemoteViews f1350h;

    public NotificationCompatBuilder(NotificationCompat.C0189c c0189c) {
        ArrayList<String> arrayList;
        this.f1344b = c0189c;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1343a = new Notification.Builder(c0189c.f1313a, c0189c.f1306I);
        } else {
            this.f1343a = new Notification.Builder(c0189c.f1313a);
        }
        Notification notification = c0189c.f1311N;
        this.f1343a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, c0189c.f1320h).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(c0189c.f1316d).setContentText(c0189c.f1317e).setContentInfo(c0189c.f1322j).setContentIntent(c0189c.f1318f).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(c0189c.f1319g, (notification.flags & Logger.DEFAULT_FULL_MESSAGE_LENGTH) != 0).setLargeIcon(c0189c.f1321i).setNumber(c0189c.f1323k).setProgress(c0189c.f1330r, c0189c.f1331s, c0189c.f1332t);
        if (Build.VERSION.SDK_INT < 21) {
            this.f1343a.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1343a.setSubText(c0189c.f1328p).setUsesChronometer(c0189c.f1326n).setPriority(c0189c.f1324l);
            Iterator<NotificationCompat.C0186a> it = c0189c.f1314b.iterator();
            while (it.hasNext()) {
                m10029a(it.next());
            }
            Bundle bundle = c0189c.f1299B;
            if (bundle != null) {
                this.f1348f.putAll(bundle);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (c0189c.f1336x) {
                    this.f1348f.putBoolean("android.support.localOnly", true);
                }
                String str = c0189c.f1333u;
                if (str != null) {
                    this.f1348f.putString("android.support.groupKey", str);
                    if (c0189c.f1334v) {
                        this.f1348f.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f1348f.putBoolean("android.support.useSideChannel", true);
                    }
                }
                String str2 = c0189c.f1335w;
                if (str2 != null) {
                    this.f1348f.putString("android.support.sortKey", str2);
                }
            }
            this.f1345c = c0189c.f1303F;
            this.f1346d = c0189c.f1304G;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1343a.setShowWhen(c0189c.f1325m);
            if (Build.VERSION.SDK_INT < 21 && (arrayList = c0189c.f1312O) != null && !arrayList.isEmpty()) {
                Bundle bundle2 = this.f1348f;
                ArrayList<String> arrayList2 = c0189c.f1312O;
                bundle2.putStringArray("android.people", (String[]) arrayList2.toArray(new String[arrayList2.size()]));
            }
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f1343a.setLocalOnly(c0189c.f1336x).setGroup(c0189c.f1333u).setGroupSummary(c0189c.f1334v).setSortKey(c0189c.f1335w);
            this.f1349g = c0189c.f1310M;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1343a.setCategory(c0189c.f1298A).setColor(c0189c.f1300C).setVisibility(c0189c.f1301D).setPublicVersion(c0189c.f1302E).setSound(notification.sound, notification.audioAttributes);
            Iterator<String> it2 = c0189c.f1312O.iterator();
            while (it2.hasNext()) {
                this.f1343a.addPerson(it2.next());
            }
            this.f1350h = c0189c.f1305H;
            if (c0189c.f1315c.size() > 0) {
                Bundle bundle3 = c0189c.m10046b().getBundle("android.car.EXTENSIONS");
                bundle3 = bundle3 == null ? new Bundle() : bundle3;
                Bundle bundle4 = new Bundle();
                for (int i = 0; i < c0189c.f1315c.size(); i++) {
                    bundle4.putBundle(Integer.toString(i), NotificationCompatJellybean.m10409a(c0189c.f1315c.get(i)));
                }
                bundle3.putBundle("invisible_actions", bundle4);
                c0189c.m10046b().putBundle("android.car.EXTENSIONS", bundle3);
                this.f1348f.putBundle("android.car.EXTENSIONS", bundle3);
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f1343a.setExtras(c0189c.f1299B).setRemoteInputHistory(c0189c.f1329q);
            RemoteViews remoteViews = c0189c.f1303F;
            if (remoteViews != null) {
                this.f1343a.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = c0189c.f1304G;
            if (remoteViews2 != null) {
                this.f1343a.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = c0189c.f1305H;
            if (remoteViews3 != null) {
                this.f1343a.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1343a.setBadgeIconType(c0189c.f1307J).setShortcutId(c0189c.f1308K).setTimeoutAfter(c0189c.f1309L).setGroupAlertBehavior(c0189c.f1310M);
            if (c0189c.f1338z) {
                this.f1343a.setColorized(c0189c.f1337y);
            }
            if (TextUtils.isEmpty(c0189c.f1306I)) {
                return;
            }
            this.f1343a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
    }

    @Override // p000a.p006b.p030g.p031a.NotificationBuilderWithBuilderAccessor
    /* renamed from: a */
    public Notification.Builder mo10030a() {
        return this.f1343a;
    }

    /* renamed from: b */
    public Notification m10027b() {
        Bundle m10069a;
        RemoteViews m10031d;
        RemoteViews m10033b;
        NotificationCompat.AbstractC0190d abstractC0190d = this.f1344b.f1327o;
        if (abstractC0190d != null) {
            abstractC0190d.mo10036a(this);
        }
        RemoteViews m10032c = abstractC0190d != null ? abstractC0190d.m10032c(this) : null;
        Notification m10026c = m10026c();
        if (m10032c != null) {
            m10026c.contentView = m10032c;
        } else {
            RemoteViews remoteViews = this.f1344b.f1303F;
            if (remoteViews != null) {
                m10026c.contentView = remoteViews;
            }
        }
        if (Build.VERSION.SDK_INT >= 16 && abstractC0190d != null && (m10033b = abstractC0190d.m10033b(this)) != null) {
            m10026c.bigContentView = m10033b;
        }
        if (Build.VERSION.SDK_INT >= 21 && abstractC0190d != null && (m10031d = this.f1344b.f1327o.m10031d(this)) != null) {
            m10026c.headsUpContentView = m10031d;
        }
        if (Build.VERSION.SDK_INT >= 16 && abstractC0190d != null && (m10069a = NotificationCompat.m10069a(m10026c)) != null) {
            abstractC0190d.m10034a(m10069a);
        }
        return m10026c;
    }

    /* renamed from: c */
    public Notification m10026c() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            return this.f1343a.build();
        }
        if (i >= 24) {
            Notification build = this.f1343a.build();
            if (this.f1349g != 0) {
                if (build.getGroup() != null && (build.flags & 512) != 0 && this.f1349g == 2) {
                    m10028a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f1349g == 1) {
                    m10028a(build);
                }
            }
            return build;
        } else if (i >= 21) {
            this.f1343a.setExtras(this.f1348f);
            Notification build2 = this.f1343a.build();
            RemoteViews remoteViews = this.f1345c;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f1346d;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.f1350h;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.f1349g != 0) {
                if (build2.getGroup() != null && (build2.flags & 512) != 0 && this.f1349g == 2) {
                    m10028a(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.f1349g == 1) {
                    m10028a(build2);
                }
            }
            return build2;
        } else if (i >= 20) {
            this.f1343a.setExtras(this.f1348f);
            Notification build3 = this.f1343a.build();
            RemoteViews remoteViews4 = this.f1345c;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f1346d;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.f1349g != 0) {
                if (build3.getGroup() != null && (build3.flags & 512) != 0 && this.f1349g == 2) {
                    m10028a(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.f1349g == 1) {
                    m10028a(build3);
                }
            }
            return build3;
        } else if (i >= 19) {
            SparseArray<Bundle> m10406a = NotificationCompatJellybean.m10406a(this.f1347e);
            if (m10406a != null) {
                this.f1348f.putSparseParcelableArray("android.support.actionExtras", m10406a);
            }
            this.f1343a.setExtras(this.f1348f);
            Notification build4 = this.f1343a.build();
            RemoteViews remoteViews6 = this.f1345c;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.f1346d;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        } else if (i >= 16) {
            Notification build5 = this.f1343a.build();
            Bundle m10069a = NotificationCompat.m10069a(build5);
            Bundle bundle = new Bundle(this.f1348f);
            for (String str : this.f1348f.keySet()) {
                if (m10069a.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            m10069a.putAll(bundle);
            SparseArray<Bundle> m10406a2 = NotificationCompatJellybean.m10406a(this.f1347e);
            if (m10406a2 != null) {
                NotificationCompat.m10069a(build5).putSparseParcelableArray("android.support.actionExtras", m10406a2);
            }
            RemoteViews remoteViews8 = this.f1345c;
            if (remoteViews8 != null) {
                build5.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.f1346d;
            if (remoteViews9 != null) {
                build5.bigContentView = remoteViews9;
            }
            return build5;
        } else {
            return this.f1343a.getNotification();
        }
    }

    /* renamed from: a */
    public final void m10029a(NotificationCompat.C0186a c0186a) {
        Bundle bundle;
        int i = Build.VERSION.SDK_INT;
        if (i < 20) {
            if (i >= 16) {
                this.f1347e.add(NotificationCompatJellybean.m10408a(this.f1343a, c0186a));
                return;
            }
            return;
        }
        Notification.Action.Builder builder = new Notification.Action.Builder(c0186a.m10064e(), c0186a.m10060i(), c0186a.m10068a());
        if (c0186a.m10063f() != null) {
            for (RemoteInput remoteInput : RemoteInput.m10359a(c0186a.m10063f())) {
                builder.addRemoteInput(remoteInput);
            }
        }
        if (c0186a.m10065d() != null) {
            bundle = new Bundle(c0186a.m10065d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", c0186a.m10067b());
        if (Build.VERSION.SDK_INT >= 24) {
            builder.setAllowGeneratedReplies(c0186a.m10067b());
        }
        bundle.putInt("android.support.action.semanticAction", c0186a.m10062g());
        if (Build.VERSION.SDK_INT >= 28) {
            builder.setSemanticAction(c0186a.m10062g());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", c0186a.m10061h());
        builder.addExtras(bundle);
        this.f1343a.addAction(builder.build());
    }

    /* renamed from: a */
    public final void m10028a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
