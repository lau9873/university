package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {
    public static final PorterDuff.Mode j = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    public int f2281a;

    /* renamed from: b  reason: collision with root package name */
    public Object f2282b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f2283c;

    /* renamed from: d  reason: collision with root package name */
    public Parcelable f2284d;

    /* renamed from: e  reason: collision with root package name */
    public int f2285e;

    /* renamed from: f  reason: collision with root package name */
    public int f2286f;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f2287g = null;

    /* renamed from: h  reason: collision with root package name */
    public PorterDuff.Mode f2288h = j;

    /* renamed from: i  reason: collision with root package name */
    public String f2289i;

    public static String a(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "UNKNOWN" : "BITMAP_MASKABLE" : "URI" : "DATA" : "RESOURCE" : "BITMAP";
    }

    public int a() {
        if (this.f2281a == -1 && Build.VERSION.SDK_INT >= 23) {
            return a((Icon) this.f2282b);
        }
        if (this.f2281a == 2) {
            return this.f2285e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String b() {
        if (this.f2281a == -1 && Build.VERSION.SDK_INT >= 23) {
            return b((Icon) this.f2282b);
        }
        if (this.f2281a == 2) {
            return ((String) this.f2282b).split(":", -1)[0];
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public void c() {
        this.f2288h = PorterDuff.Mode.valueOf(this.f2289i);
        int i2 = this.f2281a;
        if (i2 != -1) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        this.f2282b = this.f2283c;
                        return;
                    } else if (i2 != 4) {
                        if (i2 != 5) {
                            return;
                        }
                    }
                }
                this.f2282b = new String(this.f2283c, Charset.forName("UTF-16"));
                return;
            }
            Parcelable parcelable = this.f2284d;
            if (parcelable != null) {
                this.f2282b = parcelable;
                return;
            }
            byte[] bArr = this.f2283c;
            this.f2282b = bArr;
            this.f2281a = 3;
            this.f2285e = 0;
            this.f2286f = bArr.length;
            return;
        }
        Parcelable parcelable2 = this.f2284d;
        if (parcelable2 != null) {
            this.f2282b = parcelable2;
            return;
        }
        throw new IllegalArgumentException("Invalid icon");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r1 != 5) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r4 = this;
            int r0 = r4.f2281a
            r1 = -1
            if (r0 != r1) goto Lc
            java.lang.Object r0 = r4.f2282b
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        Lc:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Icon(typ="
            r0.<init>(r1)
            int r1 = r4.f2281a
            java.lang.String r1 = a(r1)
            r0.append(r1)
            int r1 = r4.f2281a
            r2 = 1
            if (r1 == r2) goto L7a
            r3 = 2
            if (r1 == r3) goto L52
            r2 = 3
            if (r1 == r2) goto L39
            r2 = 4
            if (r1 == r2) goto L2e
            r2 = 5
            if (r1 == r2) goto L7a
            goto L9a
        L2e:
            java.lang.String r1 = " uri="
            r0.append(r1)
            java.lang.Object r1 = r4.f2282b
            r0.append(r1)
            goto L9a
        L39:
            java.lang.String r1 = " len="
            r0.append(r1)
            int r1 = r4.f2285e
            r0.append(r1)
            int r1 = r4.f2286f
            if (r1 == 0) goto L9a
            java.lang.String r1 = " off="
            r0.append(r1)
            int r1 = r4.f2286f
            r0.append(r1)
            goto L9a
        L52:
            java.lang.String r1 = " pkg="
            r0.append(r1)
            java.lang.String r1 = r4.b()
            r0.append(r1)
            java.lang.String r1 = " id="
            r0.append(r1)
            java.lang.Object[] r1 = new java.lang.Object[r2]
            r2 = 0
            int r3 = r4.a()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1[r2] = r3
            java.lang.String r2 = "0x%08x"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            r0.append(r1)
            goto L9a
        L7a:
            java.lang.String r1 = " size="
            r0.append(r1)
            java.lang.Object r1 = r4.f2282b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getWidth()
            r0.append(r1)
            java.lang.String r1 = "x"
            r0.append(r1)
            java.lang.Object r1 = r4.f2282b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getHeight()
            r0.append(r1)
        L9a:
            android.content.res.ColorStateList r1 = r4.f2287g
            if (r1 == 0) goto La8
            java.lang.String r1 = " tint="
            r0.append(r1)
            android.content.res.ColorStateList r1 = r4.f2287g
            r0.append(r1)
        La8:
            android.graphics.PorterDuff$Mode r1 = r4.f2288h
            android.graphics.PorterDuff$Mode r2 = android.support.v4.graphics.drawable.IconCompat.j
            if (r1 == r2) goto Lb8
            java.lang.String r1 = " mode="
            r0.append(r1)
            android.graphics.PorterDuff$Mode r1 = r4.f2288h
            r0.append(r1)
        Lb8:
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.drawable.IconCompat.toString():java.lang.String");
    }

    public static String b(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon package", e2);
            return null;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon package", e3);
            return null;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon package", e4);
            return null;
        }
    }

    public void a(boolean z) {
        this.f2289i = this.f2288h.name();
        int i2 = this.f2281a;
        if (i2 == -1) {
            if (!z) {
                this.f2284d = (Parcelable) this.f2282b;
                return;
            }
            throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
        }
        if (i2 != 1) {
            if (i2 == 2) {
                this.f2283c = ((String) this.f2282b).getBytes(Charset.forName("UTF-16"));
                return;
            } else if (i2 == 3) {
                this.f2283c = (byte[]) this.f2282b;
                return;
            } else if (i2 == 4) {
                this.f2283c = this.f2282b.toString().getBytes(Charset.forName("UTF-16"));
                return;
            } else if (i2 != 5) {
                return;
            }
        }
        if (z) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ((Bitmap) this.f2282b).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
            this.f2283c = byteArrayOutputStream.toByteArray();
            return;
        }
        this.f2284d = (Parcelable) this.f2282b;
    }

    public static int a(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon resource", e4);
            return 0;
        }
    }
}
