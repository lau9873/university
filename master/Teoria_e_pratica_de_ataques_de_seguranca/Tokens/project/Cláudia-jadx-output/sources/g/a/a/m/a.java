package g.a.a.m;
/* compiled from: AbstractAndroidLogger.java */
/* loaded from: classes.dex */
public abstract class a implements e {
    public String a(String str, Object... objArr) {
        return objArr.length == 0 ? str : String.format(str, objArr);
    }
}
