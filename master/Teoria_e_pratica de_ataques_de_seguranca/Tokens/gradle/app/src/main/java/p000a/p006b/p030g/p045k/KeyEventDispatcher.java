package p000a.p006b.p030g.p045k;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: a.b.g.k.e */
/* loaded from: classes.dex */
public class KeyEventDispatcher {

    /* renamed from: a */
    public static boolean f1618a = false;

    /* renamed from: b */
    public static Method f1619b = null;

    /* renamed from: c */
    public static boolean f1620c = false;

    /* renamed from: d */
    public static Field f1621d;

    /* compiled from: KeyEventDispatcher.java */
    /* renamed from: a.b.g.k.e$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0281a {
        /* renamed from: a */
        boolean mo9025a(KeyEvent keyEvent);
    }

    /* renamed from: a */
    public static boolean m9564a(View view, KeyEvent keyEvent) {
        return ViewCompat.m9438b(view, keyEvent);
    }

    /* renamed from: a */
    public static boolean m9569a(InterfaceC0281a interfaceC0281a, View view, Window.Callback callback, KeyEvent keyEvent) {
        if (interfaceC0281a == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return interfaceC0281a.mo9025a(keyEvent);
        }
        if (callback instanceof Activity) {
            return m9567a((Activity) callback, keyEvent);
        }
        if (callback instanceof Dialog) {
            return m9565a((Dialog) callback, keyEvent);
        }
        return (view != null && ViewCompat.m9446a(view, keyEvent)) || interfaceC0281a.mo9025a(keyEvent);
    }

    /* renamed from: a */
    public static boolean m9568a(ActionBar actionBar, KeyEvent keyEvent) {
        if (!f1618a) {
            try {
                f1619b = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
            } catch (NoSuchMethodException unused) {
            }
            f1618a = true;
        }
        Method method = f1619b;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(actionBar, keyEvent)).booleanValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m9567a(Activity activity, KeyEvent keyEvent) {
        activity.onUserInteraction();
        Window window = activity.getWindow();
        if (window.hasFeature(8)) {
            ActionBar actionBar = activity.getActionBar();
            if (keyEvent.getKeyCode() == 82 && actionBar != null && m9568a(actionBar, keyEvent)) {
                return true;
            }
        }
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (ViewCompat.m9446a(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
    }

    /* renamed from: a */
    public static DialogInterface.OnKeyListener m9566a(Dialog dialog) {
        if (!f1620c) {
            try {
                f1621d = Dialog.class.getDeclaredField("mOnKeyListener");
                f1621d.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f1620c = true;
        }
        Field field = f1621d;
        if (field != null) {
            try {
                return (DialogInterface.OnKeyListener) field.get(dialog);
            } catch (IllegalAccessException unused2) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m9565a(Dialog dialog, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener m9566a = m9566a(dialog);
        if (m9566a == null || !m9566a.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
            Window window = dialog.getWindow();
            if (window.superDispatchKeyEvent(keyEvent)) {
                return true;
            }
            View decorView = window.getDecorView();
            if (ViewCompat.m9446a(decorView, keyEvent)) {
                return true;
            }
            return keyEvent.dispatch(dialog, decorView != null ? decorView.getKeyDispatcherState() : null, dialog);
        }
        return true;
    }
}
