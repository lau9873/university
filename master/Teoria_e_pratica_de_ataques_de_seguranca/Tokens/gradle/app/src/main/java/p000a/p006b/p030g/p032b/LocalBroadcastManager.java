package p000a.p006b.p030g.p032b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.j256.ormlite.logger.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* renamed from: a.b.g.b.d */
/* loaded from: classes.dex */
public final class LocalBroadcastManager {

    /* renamed from: f */
    public static final Object f1356f = new Object();

    /* renamed from: g */
    public static LocalBroadcastManager f1357g;

    /* renamed from: a */
    public final Context f1358a;

    /* renamed from: b */
    public final HashMap<BroadcastReceiver, ArrayList<C0196c>> f1359b = new HashMap<>();

    /* renamed from: c */
    public final HashMap<String, ArrayList<C0196c>> f1360c = new HashMap<>();

    /* renamed from: d */
    public final ArrayList<C0195b> f1361d = new ArrayList<>();

    /* renamed from: e */
    public final Handler f1362e;

    /* compiled from: LocalBroadcastManager.java */
    /* renamed from: a.b.g.b.d$a */
    /* loaded from: classes.dex */
    public class HandlerC0194a extends Handler {
        public HandlerC0194a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                LocalBroadcastManager.this.m10014a();
            }
        }
    }

    /* compiled from: LocalBroadcastManager.java */
    /* renamed from: a.b.g.b.d$b */
    /* loaded from: classes.dex */
    public static final class C0195b {

        /* renamed from: a */
        public final Intent f1364a;

        /* renamed from: b */
        public final ArrayList<C0196c> f1365b;

        public C0195b(Intent intent, ArrayList<C0196c> arrayList) {
            this.f1364a = intent;
            this.f1365b = arrayList;
        }
    }

    /* compiled from: LocalBroadcastManager.java */
    /* renamed from: a.b.g.b.d$c */
    /* loaded from: classes.dex */
    public static final class C0196c {

        /* renamed from: a */
        public final IntentFilter f1366a;

        /* renamed from: b */
        public final BroadcastReceiver f1367b;

        /* renamed from: c */
        public boolean f1368c;

        /* renamed from: d */
        public boolean f1369d;

        public C0196c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f1366a = intentFilter;
            this.f1367b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((int) Logger.DEFAULT_FULL_MESSAGE_LENGTH);
            sb.append("Receiver{");
            sb.append(this.f1367b);
            sb.append(" filter=");
            sb.append(this.f1366a);
            if (this.f1369d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    public LocalBroadcastManager(Context context) {
        this.f1358a = context;
        this.f1362e = new HandlerC0194a(context.getMainLooper());
    }

    /* renamed from: a */
    public static LocalBroadcastManager m10011a(Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (f1356f) {
            if (f1357g == null) {
                f1357g = new LocalBroadcastManager(context.getApplicationContext());
            }
            localBroadcastManager = f1357g;
        }
        return localBroadcastManager;
    }

    /* renamed from: a */
    public void m10012a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f1359b) {
            C0196c c0196c = new C0196c(intentFilter, broadcastReceiver);
            ArrayList<C0196c> arrayList = this.f1359b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f1359b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(c0196c);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<C0196c> arrayList2 = this.f1360c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f1360c.put(action, arrayList2);
                }
                arrayList2.add(c0196c);
            }
        }
    }

    /* renamed from: a */
    public void m10013a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f1359b) {
            ArrayList<C0196c> remove = this.f1359b.remove(broadcastReceiver);
            if (remove == null) {
                return;
            }
            for (int size = remove.size() - 1; size >= 0; size--) {
                C0196c c0196c = remove.get(size);
                c0196c.f1369d = true;
                for (int i = 0; i < c0196c.f1366a.countActions(); i++) {
                    String action = c0196c.f1366a.getAction(i);
                    ArrayList<C0196c> arrayList = this.f1360c.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            C0196c c0196c2 = arrayList.get(size2);
                            if (c0196c2.f1367b == broadcastReceiver) {
                                c0196c2.f1369d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.f1360c.remove(action);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public boolean m10010a(Intent intent) {
        String str;
        ArrayList arrayList;
        int i;
        ArrayList<C0196c> arrayList2;
        String str2;
        synchronized (this.f1359b) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f1358a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<C0196c> arrayList3 = this.f1360c.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                }
                ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    C0196c c0196c = arrayList3.get(i2);
                    if (z) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + c0196c.f1366a);
                    }
                    if (c0196c.f1368c) {
                        if (z) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                        }
                        i = i2;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = resolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        str = action;
                        arrayList = arrayList4;
                        i = i2;
                        arrayList2 = arrayList3;
                        str2 = resolveTypeIfNeeded;
                        int match = c0196c.f1366a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(c0196c);
                            c0196c.f1368c = true;
                            i2 = i + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            resolveTypeIfNeeded = str2;
                        } else if (z) {
                            Log.v("LocalBroadcastManager", "  Filter did not match: " + (match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                        }
                    }
                    arrayList4 = arrayList;
                    i2 = i + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    resolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                        ((C0196c) arrayList5.get(i3)).f1368c = false;
                    }
                    this.f1361d.add(new C0195b(intent, arrayList5));
                    if (!this.f1362e.hasMessages(1)) {
                        this.f1362e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: a */
    public void m10014a() {
        C0195b[] c0195bArr;
        while (true) {
            synchronized (this.f1359b) {
                int size = this.f1361d.size();
                if (size <= 0) {
                    return;
                }
                c0195bArr = new C0195b[size];
                this.f1361d.toArray(c0195bArr);
                this.f1361d.clear();
            }
            for (C0195b c0195b : c0195bArr) {
                int size2 = c0195b.f1365b.size();
                for (int i = 0; i < size2; i++) {
                    C0196c c0196c = c0195b.f1365b.get(i);
                    if (!c0196c.f1369d) {
                        c0196c.f1367b.onReceive(this.f1358a, c0195b.f1364a);
                    }
                }
            }
        }
    }
}
