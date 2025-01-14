package p193g.p194a.p195a.p197l;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.AsyncTask;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
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
import p193g.p194a.p195a.p197l.ModelSpecificDistanceUpdater;
import p193g.p194a.p195a.p198m.LogManager;

/* renamed from: g.a.a.l.e */
/* loaded from: classes.dex */
public class ModelSpecificDistanceCalculator implements DistanceCalculator {

    /* renamed from: a */
    public Map<AndroidModel, DistanceCalculator> f8544a;

    /* renamed from: b */
    public AndroidModel f8545b;

    /* renamed from: c */
    public DistanceCalculator f8546c;

    /* renamed from: d */
    public AndroidModel f8547d;

    /* renamed from: e */
    public AndroidModel f8548e;

    /* renamed from: f */
    public String f8549f;

    /* renamed from: g */
    public Context f8550g;

    /* renamed from: h */
    public final ReentrantLock f8551h;

    /* compiled from: ModelSpecificDistanceCalculator.java */
    /* renamed from: g.a.a.l.e$a */
    /* loaded from: classes.dex */
    public class C1833a implements ModelSpecificDistanceUpdater.InterfaceC1834a {
        public C1833a() {
        }

        @Override // p193g.p194a.p195a.p197l.ModelSpecificDistanceUpdater.InterfaceC1834a
        /* renamed from: a */
        public void mo2435a(String str, Exception exc, int i) {
            if (exc != null) {
                LogManager.m2427d("ModelSpecificDistanceCalculator", "Cannot updated distance models from online database at %s", exc, ModelSpecificDistanceCalculator.this.f8549f);
            } else if (i != 200) {
                LogManager.m2427d("ModelSpecificDistanceCalculator", "Cannot updated distance models from online database at %s due to HTTP status code %s", ModelSpecificDistanceCalculator.this.f8549f, Integer.valueOf(i));
            } else {
                LogManager.m2432a("ModelSpecificDistanceCalculator", "Successfully downloaded distance models from online database", new Object[0]);
                try {
                    ModelSpecificDistanceCalculator.this.m2447b(str);
                    if (ModelSpecificDistanceCalculator.this.m2444c(str)) {
                        ModelSpecificDistanceCalculator.this.m2446c();
                        ModelSpecificDistanceCalculator.this.f8546c = ModelSpecificDistanceCalculator.this.m2449b(ModelSpecificDistanceCalculator.this.f8548e);
                        LogManager.m2428c("ModelSpecificDistanceCalculator", "Successfully updated distance model with latest from online database", new Object[0]);
                    }
                } catch (JSONException e) {
                    LogManager.m2429b(e, "ModelSpecificDistanceCalculator", "Cannot parse json from downloaded distance model", new Object[0]);
                }
            }
        }
    }

    public ModelSpecificDistanceCalculator(Context context, String str) {
        this(context, str, AndroidModel.m2462e());
    }

    @TargetApi(11)
    /* renamed from: d */
    public final void m2443d() {
        if (this.f8550g.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            LogManager.m2427d("ModelSpecificDistanceCalculator", "App has no android.permission.INTERNET permission.  Cannot check for distance model updates", new Object[0]);
        } else {
            new ModelSpecificDistanceUpdater(this.f8550g, this.f8549f, new C1833a()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public ModelSpecificDistanceCalculator(Context context, String str, AndroidModel androidModel) {
        this.f8549f = null;
        this.f8551h = new ReentrantLock();
        this.f8548e = androidModel;
        this.f8549f = str;
        this.f8550g = context;
        m2450b();
        this.f8546c = m2449b(androidModel);
    }

    /* renamed from: b */
    public DistanceCalculator m2449b(AndroidModel androidModel) {
        this.f8551h.lock();
        try {
            return m2455a(androidModel);
        } finally {
            this.f8551h.unlock();
        }
    }

    /* renamed from: c */
    public final boolean m2446c() {
        FileInputStream fileInputStream;
        File file = new File(this.f8550g.getFilesDir(), "model-distance-calculations.json");
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
                        } catch (IOException e) {
                            e = e;
                            bufferedReader = bufferedReader2;
                            LogManager.m2431a(e, "ModelSpecificDistanceCalculator", "Cannot open distance model file %s", file);
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
                        m2447b(sb.toString());
                        return true;
                    } catch (JSONException e2) {
                        LogManager.m2431a(e2, "ModelSpecificDistanceCalculator", "Cannot update distance models from online database at %s with JSON: %s", this.f8549f, sb.toString());
                        return false;
                    }
                } catch (FileNotFoundException unused10) {
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (FileNotFoundException unused11) {
                fileInputStream = null;
            } catch (IOException e4) {
                e = e4;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // p193g.p194a.p195a.p197l.DistanceCalculator
    /* renamed from: a */
    public double mo2456a(int i, double d) {
        DistanceCalculator distanceCalculator = this.f8546c;
        if (distanceCalculator == null) {
            LogManager.m2427d("ModelSpecificDistanceCalculator", "distance calculator has not been set", new Object[0]);
            return -1.0d;
        }
        return distanceCalculator.mo2456a(i, d);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0093  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m2442d(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "/"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 0
            java.lang.Class<g.a.a.l.e> r3 = p193g.p194a.p195a.p197l.ModelSpecificDistanceCalculator.class
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
        throw new UnsupportedOperationException("Method not decompiled: p193g.p194a.p195a.p197l.ModelSpecificDistanceCalculator.m2442d(java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    public final void m2450b() {
        boolean z;
        if (this.f8549f != null) {
            z = m2446c();
            if (!z) {
                m2443d();
            }
        } else {
            z = false;
        }
        if (!z) {
            m2457a();
        }
        this.f8546c = m2449b(this.f8548e);
    }

    /* renamed from: a */
    public final DistanceCalculator m2455a(AndroidModel androidModel) {
        LogManager.m2432a("ModelSpecificDistanceCalculator", "Finding best distance calculator for %s, %s, %s, %s", androidModel.m2463d(), androidModel.m2467a(), androidModel.m2464c(), androidModel.m2465b());
        Map<AndroidModel, DistanceCalculator> map = this.f8544a;
        AndroidModel androidModel2 = null;
        if (map == null) {
            LogManager.m2432a("ModelSpecificDistanceCalculator", "Cannot get distance calculator because modelMap was never initialized", new Object[0]);
            return null;
        }
        int i = 0;
        for (AndroidModel androidModel3 : map.keySet()) {
            if (androidModel3.m2466a(androidModel) > i) {
                i = androidModel3.m2466a(androidModel);
                androidModel2 = androidModel3;
            }
        }
        if (androidModel2 != null) {
            LogManager.m2432a("ModelSpecificDistanceCalculator", "found a match with score %s", Integer.valueOf(i));
            LogManager.m2432a("ModelSpecificDistanceCalculator", "Finding best distance calculator for %s, %s, %s, %s", androidModel2.m2463d(), androidModel2.m2467a(), androidModel2.m2464c(), androidModel2.m2465b());
            this.f8547d = androidModel2;
        } else {
            this.f8547d = this.f8545b;
            LogManager.m2427d("ModelSpecificDistanceCalculator", "Cannot find match for this device.  Using default", new Object[0]);
        }
        return this.f8544a.get(this.f8547d);
    }

    /* renamed from: b */
    public void m2447b(String str) {
        this.f8551h.lock();
        try {
            m2451a(str);
        } finally {
            this.f8551h.unlock();
        }
    }

    /* renamed from: c */
    public final boolean m2444c(String str) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                fileOutputStream = this.f8550g.openFileOutput("model-distance-calculations.json", 0);
                fileOutputStream.write(str.getBytes());
                fileOutputStream.close();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused) {
                    }
                }
                LogManager.m2428c("ModelSpecificDistanceCalculator", "Successfully saved new distance model file", new Object[0]);
                return true;
            } catch (Exception e) {
                LogManager.m2429b(e, "ModelSpecificDistanceCalculator", "Cannot write updated distance model to local storage", new Object[0]);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused2) {
                    }
                }
                return false;
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception unused3) {
                }
            }
            throw th;
        }
    }

    /* renamed from: a */
    public final void m2451a(String str) {
        HashMap hashMap = new HashMap();
        JSONArray jSONArray = new JSONObject(str).getJSONArray("models");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            boolean z = jSONObject.has("default") ? jSONObject.getBoolean("default") : false;
            Double valueOf = Double.valueOf(jSONObject.getDouble("coefficient1"));
            Double valueOf2 = Double.valueOf(jSONObject.getDouble("coefficient2"));
            Double valueOf3 = Double.valueOf(jSONObject.getDouble("coefficient3"));
            String string = jSONObject.getString(DatabaseFieldConfigLoader.FIELD_NAME_VERSION);
            String string2 = jSONObject.getString("build_number");
            String string3 = jSONObject.getString("model");
            String string4 = jSONObject.getString("manufacturer");
            CurveFittedDistanceCalculator curveFittedDistanceCalculator = new CurveFittedDistanceCalculator(valueOf.doubleValue(), valueOf2.doubleValue(), valueOf3.doubleValue());
            AndroidModel androidModel = new AndroidModel(string, string2, string3, string4);
            hashMap.put(androidModel, curveFittedDistanceCalculator);
            if (z) {
                this.f8545b = androidModel;
            }
        }
        this.f8544a = hashMap;
    }

    /* renamed from: a */
    public final void m2457a() {
        try {
            m2451a(m2442d("model-distance-calculations.json"));
        } catch (Exception e) {
            this.f8544a = new HashMap();
            LogManager.m2431a(e, "ModelSpecificDistanceCalculator", "Cannot build model distance calculations", new Object[0]);
        }
    }
}
