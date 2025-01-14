package a.b.g.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
/* compiled from: LocalBroadcastManager.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: f  reason: collision with root package name */
    public static final Object f850f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public static d f851g;

    /* renamed from: a  reason: collision with root package name */
    public final Context f852a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<BroadcastReceiver, ArrayList<c>> f853b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<String, ArrayList<c>> f854c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<b> f855d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public final Handler f856e;

    /* compiled from: LocalBroadcastManager.java */
    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                d.this.a();
            }
        }
    }

    /* compiled from: LocalBroadcastManager.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Intent f858a;

        /* renamed from: b  reason: collision with root package name */
        public final ArrayList<c> f859b;

        public b(Intent intent, ArrayList<c> arrayList) {
            this.f858a = intent;
            this.f859b = arrayList;
        }
    }

    /* compiled from: LocalBroadcastManager.java */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final IntentFilter f860a;

        /* renamed from: b  reason: collision with root package name */
        public final BroadcastReceiver f861b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f862c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f863d;

        public c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f860a = intentFilter;
            this.f861b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f861b);
            sb.append(" filter=");
            sb.append(this.f860a);
            if (this.f863d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    public d(Context context) {
        this.f852a = context;
        this.f856e = new a(context.getMainLooper());
    }

    public static d a(Context context) {
        d dVar;
        synchronized (f850f) {
            if (f851g == null) {
                f851g = new d(context.getApplicationContext());
            }
            dVar = f851g;
        }
        return dVar;
    }

    public void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f853b) {
            c cVar = new c(intentFilter, broadcastReceiver);
            ArrayList<c> arrayList = this.f853b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f853b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(cVar);
            for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                String action = intentFilter.getAction(i2);
                ArrayList<c> arrayList2 = this.f854c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f854c.put(action, arrayList2);
                }
                arrayList2.add(cVar);
            }
        }
    }

    public void a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f853b) {
            ArrayList<c> remove = this.f853b.remove(broadcastReceiver);
            if (remove == null) {
                return;
            }
            for (int size = remove.size() - 1; size >= 0; size--) {
                c cVar = remove.get(size);
                cVar.f863d = true;
                for (int i2 = 0; i2 < cVar.f860a.countActions(); i2++) {
                    String action = cVar.f860a.getAction(i2);
                    ArrayList<c> arrayList = this.f854c.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            c cVar2 = arrayList.get(size2);
                            if (cVar2.f861b == broadcastReceiver) {
                                cVar2.f863d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.f854c.remove(action);
                        }
                    }
                }
            }
        }
    }

    public boolean a(Intent intent) {
        String str;
        ArrayList arrayList;
        int i2;
        ArrayList<c> arrayList2;
        String str2;
        synchronized (this.f853b) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f852a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<c> arrayList3 = this.f854c.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                }
                ArrayList arrayList4 = null;
                int i3 = 0;
                while (i3 < arrayList3.size()) {
                    c cVar = arrayList3.get(i3);
                    if (z) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + cVar.f860a);
                    }
                    if (cVar.f862c) {
                        if (z) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                        }
                        i2 = i3;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = resolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        str = action;
                        arrayList = arrayList4;
                        i2 = i3;
                        arrayList2 = arrayList3;
                        str2 = resolveTypeIfNeeded;
                        int match = cVar.f860a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(cVar);
                            cVar.f862c = true;
                            i3 = i2 + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            resolveTypeIfNeeded = str2;
                        } else if (z) {
                            Log.v("LocalBroadcastManager", "  Filter did not match: " + (match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                        }
                    }
                    arrayList4 = arrayList;
                    i3 = i2 + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    resolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i4 = 0; i4 < arrayList5.size(); i4++) {
                        ((c) arrayList5.get(i4)).f862c = false;
                    }
                    this.f855d.add(new b(intent, arrayList5));
                    if (!this.f856e.hasMessages(1)) {
                        this.f856e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void a() {
        b[] bVarArr;
        while (true) {
            synchronized (this.f853b) {
                int size = this.f855d.size();
                if (size <= 0) {
                    return;
                }
                bVarArr = new b[size];
                this.f855d.toArray(bVarArr);
                this.f855d.clear();
            }
            for (b bVar : bVarArr) {
                int size2 = bVar.f859b.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    c cVar = bVar.f859b.get(i2);
                    if (!cVar.f863d) {
                        cVar.f861b.onReceive(this.f852a, bVar.f858a);
                    }
                }
            }
        }
    }
}
