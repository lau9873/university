package p000a.p006b.p049h.p063k;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* renamed from: a.b.h.k.m */
/* loaded from: classes.dex */
public class AppCompatHintHelper {
    /* renamed from: a */
    public static InputConnection m8243a(InputConnection inputConnection, EditorInfo editorInfo, View view) {
        if (inputConnection != null && editorInfo.hintText == null) {
            ViewParent parent = view.getParent();
            while (true) {
                if (!(parent instanceof View)) {
                    break;
                } else if (parent instanceof WithHint) {
                    editorInfo.hintText = ((WithHint) parent).m8037a();
                    break;
                } else {
                    parent = parent.getParent();
                }
            }
        }
        return inputConnection;
    }
}
