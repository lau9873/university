package android.support.p065v4.graphics.drawable;

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

/* renamed from: android.support.v4.graphics.drawable.IconCompat */
/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: j */
    public static final PorterDuff.Mode f3552j = PorterDuff.Mode.SRC_IN;

    /* renamed from: a */
    public int f3553a;

    /* renamed from: b */
    public Object f3554b;

    /* renamed from: c */
    public byte[] f3555c;

    /* renamed from: d */
    public Parcelable f3556d;

    /* renamed from: e */
    public int f3557e;

    /* renamed from: f */
    public int f3558f;

    /* renamed from: g */
    public ColorStateList f3559g = null;

    /* renamed from: h */
    public PorterDuff.Mode f3560h = f3552j;

    /* renamed from: i */
    public String f3561i;

    /* renamed from: a */
    public static String m7406a(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "UNKNOWN" : "BITMAP_MASKABLE" : "URI" : "DATA" : "RESOURCE" : "BITMAP";
    }

    /* renamed from: a */
    public int m7407a() {
        if (this.f3553a == -1 && Build.VERSION.SDK_INT >= 23) {
            return m7405a((Icon) this.f3554b);
        }
        if (this.f3553a == 2) {
            return this.f3557e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    /* renamed from: b */
    public String m7403b() {
        if (this.f3553a == -1 && Build.VERSION.SDK_INT >= 23) {
            return m7402b((Icon) this.f3554b);
        }
        if (this.f3553a == 2) {
            return ((String) this.f3554b).split(":", -1)[0];
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    /* renamed from: c */
    public void m7401c() {
        this.f3560h = PorterDuff.Mode.valueOf(this.f3561i);
        int i = this.f3553a;
        if (i != -1) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.f3554b = this.f3555c;
                        return;
                    } else if (i != 4) {
                        if (i != 5) {
                            return;
                        }
                    }
                }
                this.f3554b = new String(this.f3555c, Charset.forName("UTF-16"));
                return;
            }
            Parcelable parcelable = this.f3556d;
            if (parcelable != null) {
                this.f3554b = parcelable;
                return;
            }
            byte[] bArr = this.f3555c;
            this.f3554b = bArr;
            this.f3553a = 3;
            this.f3557e = 0;
            this.f3558f = bArr.length;
            return;
        }
        Parcelable parcelable2 = this.f3556d;
        if (parcelable2 != null) {
            this.f3554b = parcelable2;
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
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r4 = this;
            int r0 = r4.f3553a
            r1 = -1
            if (r0 != r1) goto Lc
            java.lang.Object r0 = r4.f3554b
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        Lc:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Icon(typ="
            r0.<init>(r1)
            int r1 = r4.f3553a
            java.lang.String r1 = m7406a(r1)
            r0.append(r1)
            int r1 = r4.f3553a
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
            java.lang.Object r1 = r4.f3554b
            r0.append(r1)
            goto L9a
        L39:
            java.lang.String r1 = " len="
            r0.append(r1)
            int r1 = r4.f3557e
            r0.append(r1)
            int r1 = r4.f3558f
            if (r1 == 0) goto L9a
            java.lang.String r1 = " off="
            r0.append(r1)
            int r1 = r4.f3558f
            r0.append(r1)
            goto L9a
        L52:
            java.lang.String r1 = " pkg="
            r0.append(r1)
            java.lang.String r1 = r4.m7403b()
            r0.append(r1)
            java.lang.String r1 = " id="
            r0.append(r1)
            java.lang.Object[] r1 = new java.lang.Object[r2]
            r2 = 0
            int r3 = r4.m7407a()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1[r2] = r3
            java.lang.String r2 = "0x%08x"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            r0.append(r1)
            goto L9a
        L7a:
            java.lang.String r1 = " size="
            r0.append(r1)
            java.lang.Object r1 = r4.f3554b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getWidth()
            r0.append(r1)
            java.lang.String r1 = "x"
            r0.append(r1)
            java.lang.Object r1 = r4.f3554b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getHeight()
            r0.append(r1)
        L9a:
            android.content.res.ColorStateList r1 = r4.f3559g
            if (r1 == 0) goto La8
            java.lang.String r1 = " tint="
            r0.append(r1)
            android.content.res.ColorStateList r1 = r4.f3559g
            r0.append(r1)
        La8:
            android.graphics.PorterDuff$Mode r1 = r4.f3560h
            android.graphics.PorterDuff$Mode r2 = android.support.p065v4.graphics.drawable.IconCompat.f3552j
            if (r1 == r2) goto Lb8
            java.lang.String r1 = " mode="
            r0.append(r1)
            android.graphics.PorterDuff$Mode r1 = r4.f3560h
            r0.append(r1)
        Lb8:
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p065v4.graphics.drawable.IconCompat.toString():java.lang.String");
    }

    /* renamed from: b */
    public static String m7402b(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon package", e);
            return null;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon package", e2);
            return null;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon package", e3);
            return null;
        }
    }

    /* renamed from: a */
    public void m7404a(boolean z) {
        this.f3561i = this.f3560h.name();
        int i = this.f3553a;
        if (i == -1) {
            if (!z) {
                this.f3556d = (Parcelable) this.f3554b;
                return;
            }
            throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
        }
        if (i != 1) {
            if (i == 2) {
                this.f3555c = ((String) this.f3554b).getBytes(Charset.forName("UTF-16"));
                return;
            } else if (i == 3) {
                this.f3555c = (byte[]) this.f3554b;
                return;
            } else if (i == 4) {
                this.f3555c = this.f3554b.toString().getBytes(Charset.forName("UTF-16"));
                return;
            } else if (i != 5) {
                return;
            }
        }
        if (z) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ((Bitmap) this.f3554b).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
            this.f3555c = byteArrayOutputStream.toByteArray();
            return;
        }
        this.f3556d = (Parcelable) this.f3554b;
    }

    /* renamed from: a */
    public static int m7405a(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon resource", e);
            return 0;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        }
    }
}
