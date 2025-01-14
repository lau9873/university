package g.a.a.l;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.AsyncTask;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import g.a.a.l.f;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ModelSpecificDistanceCalculator.java */
/* loaded from: classes.dex */
public class e implements c {

    /* renamed from: a  reason: collision with root package name */
    public Map<g.a.a.l.a, c> f6082a;

    /* renamed from: b  reason: collision with root package name */
    public g.a.a.l.a f6083b;

    /* renamed from: c  reason: collision with root package name */
    public c f6084c;

    /* renamed from: d  reason: collision with root package name */
    public g.a.a.l.a f6085d;

    /* renamed from: e  reason: collision with root package name */
    public g.a.a.l.a f6086e;

    /* renamed from: f  reason: collision with root package name */
    public String f6087f;

    /* renamed from: g  reason: collision with root package name */
    public Context f6088g;

    /* renamed from: h  reason: collision with root package name */
    public final ReentrantLock f6089h;

    /* compiled from: ModelSpecificDistanceCalculator.java */
    /* loaded from: classes.dex */
    public class a implements f.a {
        public a() {
        }

        @Override // g.a.a.l.f.a
        public void a(String str, Exception exc, int i2) {
            if (exc != null) {
                g.a.a.m.d.d("ModelSpecificDistanceCalculator", "Cannot updated distance models from online database at %s", exc, e.this.f6087f);
            } else if (i2 != 200) {
                g.a.a.m.d.d("ModelSpecificDistanceCalculator", "Cannot updated distance models from online database at %s due to HTTP status code %s", e.this.f6087f, Integer.valueOf(i2));
            } else {
                g.a.a.m.d.a("ModelSpecificDistanceCalculator", "Successfully downloaded distance models from online database", new Object[0]);
                try {
                    e.this.b(str);
                    if (e.this.c(str)) {
                        e.this.c();
                        e.this.f6084c = e.this.b(e.this.f6086e);
                        g.a.a.m.d.c("ModelSpecificDistanceCalculator", "Successfully updated distance model with latest from online database", new Object[0]);
                    }
                } catch (JSONException e2) {
                    g.a.a.m.d.b(e2, "ModelSpecificDistanceCalculator", "Cannot parse json from downloaded distance model", new Object[0]);
                }
            }
        }
    }

    public e(Context context, String str) {
        this(context, str, g.a.a.l.a.e());
    }

    @TargetApi(11)
    public final void d() {
        if (this.f6088g.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            g.a.a.m.d.d("ModelSpecificDistanceCalculator", "App has no android.permission.INTERNET permission.  Cannot check for distance model updates", new Object[0]);
        } else {
            new f(this.f6088g, this.f6087f, new a()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public e(Context context, String str, g.a.a.l.a aVar) {
        this.f6087f = null;
        this.f6089h = new ReentrantLock();
        this.f6086e = aVar;
        this.f6087f = str;
        this.f6088g = context;
        b();
        this.f6084c = b(aVar);
    }

    public c b(g.a.a.l.a aVar) {
        this.f6089h.lock();
        try {
            return a(aVar);
        } finally {
            this.f6089h.unlock();
        }
    }

    public final boolean c() {
        FileInputStream fileInputStream;
        File file = new File(this.f6088g.getFilesDir(), "model-distance-calculations.json");
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine != null) {
                                sb.append(readLine);
                                sb.append("\n");
                            } else {
                                try {
                                    break;
                                } catch (Exception unused) {
                                }
                            }
                        } catch (FileNotFoundException unused2) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused3) {
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception unused4) {
                                }
                            }
                            return false;
                        } catch (IOException e2) {
                            e = e2;
                            bufferedReader = bufferedReader2;
                            g.a.a.m.d.a(e, "ModelSpecificDistanceCalculator", "Cannot open distance model file %s", file);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused5) {
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception unused6) {
                                }
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused7) {
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception unused8) {
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedReader2.close();
                    try {
                        fileInputStream.close();
                    } catch (Exception unused9) {
                    }
                    try {
                        b(sb.toString());
                        return true;
                    } catch (JSONException e3) {
                        g.a.a.m.d.a(e3, "ModelSpecificDistanceCalculator", "Cannot update distance models from online database at %s with JSON: %s", this.f6087f, sb.toString());
                        return false;
                    }
                } catch (FileNotFoundException unused10) {
                } catch (IOException e4) {
                    e = e4;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException unused11) {
            fileInputStream = null;
        } catch (IOException e5) {
            e = e5;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    @Override // g.a.a.l.c
    public double a(int i2, double d2) {
        c cVar = this.f6084c;
        if (cVar == null) {
            g.a.a.m.d.d("ModelSpecificDistanceCalculator", "distance calculator has not been set", new Object[0]);
            return -1.0d;
        }
        return cVar.a(i2, d2);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String d(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "/"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 0
            java.lang.Class<g.a.a.l.e> r3 = g.a.a.l.e.class
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8a
            r4.<init>()     // Catch: java.lang.Throwable -> L8a
            r4.append(r0)     // Catch: java.lang.Throwable -> L8a
            r4.append(r7)     // Catch: java.lang.Throwable -> L8a
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L8a
            java.io.InputStream r3 = r3.getResourceAsStream(r4)     // Catch: java.lang.Throwable -> L8a
            if (r3 != 0) goto L3e
            java.lang.Class r4 = r6.getClass()     // Catch: java.lang.Throwable -> L3b
            java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch: java.lang.Throwable -> L3b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3b
            r5.<init>()     // Catch: java.lang.Throwable -> L3b
            r5.append(r0)     // Catch: java.lang.Throwable -> L3b
            r5.append(r7)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L3b
            java.io.InputStream r0 = r4.getResourceAsStream(r0)     // Catch: java.lang.Throwable -> L3b
            goto L3f
        L3b:
            r7 = move-exception
            r0 = r3
            goto L8c
        L3e:
            r0 = r3
        L3f:
            if (r0 == 0) goto L73
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L71
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L71
            java.lang.String r4 = "UTF-8"
            r3.<init>(r0, r4)     // Catch: java.lang.Throwable -> L71
            r7.<init>(r3)     // Catch: java.lang.Throwable -> L71
            java.lang.String r2 = r7.readLine()     // Catch: java.lang.Throwable -> L6d
        L51:
            if (r2 == 0) goto L60
            r1.append(r2)     // Catch: java.lang.Throwable -> L6d
            r2 = 10
            r1.append(r2)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r2 = r7.readLine()     // Catch: java.lang.Throwable -> L6d
            goto L51
        L60:
            r7.close()
            if (r0 == 0) goto L68
            r0.close()
        L68:
            java.lang.String r7 = r1.toString()
            return r7
        L6d:
            r1 = move-exception
            r2 = r7
            r7 = r1
            goto L8c
        L71:
            r7 = move-exception
            goto L8c
        L73:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L71
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71
            r3.<init>()     // Catch: java.lang.Throwable -> L71
            java.lang.String r4 = "Cannot load resource at "
            r3.append(r4)     // Catch: java.lang.Throwable -> L71
            r3.append(r7)     // Catch: java.lang.Throwable -> L71
            java.lang.String r7 = r3.toString()     // Catch: java.lang.Throwable -> L71
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L71
            throw r1     // Catch: java.lang.Throwable -> L71
        L8a:
            r7 = move-exception
            r0 = r2
        L8c:
            if (r2 == 0) goto L91
            r2.close()
        L91:
            if (r0 == 0) goto L96
            r0.close()
        L96:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.a.l.e.d(java.lang.String):java.lang.String");
    }

    public final void b() {
        boolean z;
        if (this.f6087f != null) {
            z = c();
            if (!z) {
                d();
            }
        } else {
            z = false;
        }
        if (!z) {
            a();
        }
        this.f6084c = b(this.f6086e);
    }

    public final c a(g.a.a.l.a aVar) {
        g.a.a.m.d.a("ModelSpecificDistanceCalculator", "Finding best distance calculator for %s, %s, %s, %s", aVar.d(), aVar.a(), aVar.c(), aVar.b());
        Map<g.a.a.l.a, c> map = this.f6082a;
        g.a.a.l.a aVar2 = null;
        if (map == null) {
            g.a.a.m.d.a("ModelSpecificDistanceCalculator", "Cannot get distance calculator because modelMap was never initialized", new Object[0]);
            return null;
        }
        int i2 = 0;
        for (g.a.a.l.a aVar3 : map.keySet()) {
            if (aVar3.a(aVar) > i2) {
                i2 = aVar3.a(aVar);
                aVar2 = aVar3;
            }
        }
        if (aVar2 != null) {
            g.a.a.m.d.a("ModelSpecificDistanceCalculator", "found a match with score %s", Integer.valueOf(i2));
            g.a.a.m.d.a("ModelSpecificDistanceCalculator", "Finding best distance calculator for %s, %s, %s, %s", aVar2.d(), aVar2.a(), aVar2.c(), aVar2.b());
            this.f6085d = aVar2;
        } else {
            this.f6085d = this.f6083b;
            g.a.a.m.d.d("ModelSpecificDistanceCalculator", "Cannot find match for this device.  Using default", new Object[0]);
        }
        return this.f6082a.get(this.f6085d);
    }

    public void b(String str) {
        this.f6089h.lock();
        try {
            a(str);
        } finally {
            this.f6089h.unlock();
        }
    }

    public final boolean c(String str) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                fileOutputStream = this.f6088g.openFileOutput("model-distance-calculations.json", 0);
                fileOutputStream.write(str.getBytes());
                fileOutputStream.close();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused) {
                    }
                }
                g.a.a.m.d.c("ModelSpecificDistanceCalculator", "Successfully saved new distance model file", new Object[0]);
                return true;
            } catch (Throwable th) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            g.a.a.m.d.b(e2, "ModelSpecificDistanceCalculator", "Cannot write updated distance model to local storage", new Object[0]);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception unused3) {
                }
            }
            return false;
        }
    }

    public final void a(String str) {
        HashMap hashMap = new HashMap();
        JSONArray jSONArray = new JSONObject(str).getJSONArray("models");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            boolean z = jSONObject.has("default") ? jSONObject.getBoolean("default") : false;
            Double valueOf = Double.valueOf(jSONObject.getDouble("coefficient1"));
            Double valueOf2 = Double.valueOf(jSONObject.getDouble("coefficient2"));
            Double valueOf3 = Double.valueOf(jSONObject.getDouble("coefficient3"));
            String string = jSONObject.getString(DatabaseFieldConfigLoader.FIELD_NAME_VERSION);
            String string2 = jSONObject.getString("build_number");
            String string3 = jSONObject.getString("model");
            String string4 = jSONObject.getString("manufacturer");
            b bVar = new b(valueOf.doubleValue(), valueOf2.doubleValue(), valueOf3.doubleValue());
            g.a.a.l.a aVar = new g.a.a.l.a(string, string2, string3, string4);
            hashMap.put(aVar, bVar);
            if (z) {
                this.f6083b = aVar;
            }
        }
        this.f6082a = hashMap;
    }

    public final void a() {
        try {
            a(d("model-distance-calculations.json"));
        } catch (Exception e2) {
            this.f6082a = new HashMap();
            g.a.a.m.d.a(e2, "ModelSpecificDistanceCalculator", "Cannot build model distance calculations", new Object[0]);
        }
    }
}
