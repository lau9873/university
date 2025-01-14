package android.support.p067v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import p000a.p006b.p030g.p044j.ArrayMap;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p049h.p051b.C0363j;
import p000a.p006b.p049h.p061j.ContextThemeWrapper;
import p000a.p006b.p049h.p063k.AppCompatAutoCompleteTextView;
import p000a.p006b.p049h.p063k.AppCompatButton;
import p000a.p006b.p049h.p063k.AppCompatCheckBox;
import p000a.p006b.p049h.p063k.AppCompatCheckedTextView;
import p000a.p006b.p049h.p063k.AppCompatEditText;
import p000a.p006b.p049h.p063k.AppCompatImageButton;
import p000a.p006b.p049h.p063k.AppCompatImageView;
import p000a.p006b.p049h.p063k.AppCompatMultiAutoCompleteTextView;
import p000a.p006b.p049h.p063k.AppCompatRadioButton;
import p000a.p006b.p049h.p063k.AppCompatRatingBar;
import p000a.p006b.p049h.p063k.AppCompatSeekBar;
import p000a.p006b.p049h.p063k.AppCompatSpinner;
import p000a.p006b.p049h.p063k.AppCompatTextView;
import p000a.p006b.p049h.p063k.TintContextWrapper;

/* renamed from: android.support.v7.app.AppCompatViewInflater */
/* loaded from: classes.dex */
public class AppCompatViewInflater {
    public static final String LOG_TAG = "AppCompatViewInflater";
    public final Object[] mConstructorArgs = new Object[2];
    public static final Class<?>[] sConstructorSignature = {Context.class, AttributeSet.class};
    public static final int[] sOnClickAttrs = {16843375};
    public static final String[] sClassPrefixList = {"android.widget.", "android.view.", "android.webkit."};
    public static final Map<String, Constructor<? extends View>> sConstructorMap = new ArrayMap();

    /* renamed from: android.support.v7.app.AppCompatViewInflater$a */
    /* loaded from: classes.dex */
    public static class View$OnClickListenerC0652a implements View.OnClickListener {

        /* renamed from: a */
        public final View f3819a;

        /* renamed from: b */
        public final String f3820b;

        /* renamed from: c */
        public Method f3821c;

        /* renamed from: d */
        public Context f3822d;

        public View$OnClickListenerC0652a(View view, String str) {
            this.f3819a = view;
            this.f3820b = str;
        }

        /* renamed from: a */
        public final void m7279a(Context context, String str) {
            int id;
            String str2;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f3820b, View.class)) != null) {
                        this.f3821c = method;
                        this.f3822d = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            if (this.f3819a.getId() == -1) {
                str2 = "";
            } else {
                str2 = " with id '" + this.f3819a.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f3820b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f3819a.getClass() + str2);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f3821c == null) {
                m7279a(this.f3819a.getContext(), this.f3820b);
            }
            try {
                this.f3821c.invoke(this.f3822d, view);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (InvocationTargetException e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }
    }

    private void checkOnClickListener(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (context instanceof ContextWrapper) {
            if (Build.VERSION.SDK_INT < 15 || ViewCompat.m9413t(view)) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, sOnClickAttrs);
                String string = obtainStyledAttributes.getString(0);
                if (string != null) {
                    view.setOnClickListener(new View$OnClickListenerC0652a(view, string));
                }
                obtainStyledAttributes.recycle();
            }
        }
    }

    private View createViewByPrefix(Context context, String str, String str2) {
        String str3;
        Constructor<? extends View> constructor = sConstructorMap.get(str);
        if (constructor == null) {
            try {
                ClassLoader classLoader = context.getClassLoader();
                if (str2 != null) {
                    str3 = str2 + str;
                } else {
                    str3 = str;
                }
                constructor = classLoader.loadClass(str3).asSubclass(View.class).getConstructor(sConstructorSignature);
                sConstructorMap.put(str, constructor);
            } catch (Exception unused) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.mConstructorArgs);
    }

    private View createViewFromTag(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.mConstructorArgs[0] = context;
            this.mConstructorArgs[1] = attributeSet;
            if (-1 == str.indexOf(46)) {
                for (int i = 0; i < sClassPrefixList.length; i++) {
                    View createViewByPrefix = createViewByPrefix(context, str, sClassPrefixList[i]);
                    if (createViewByPrefix != null) {
                        return createViewByPrefix;
                    }
                }
                return null;
            }
            return createViewByPrefix(context, str, null);
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr = this.mConstructorArgs;
            objArr[0] = null;
            objArr[1] = null;
        }
    }

    public static Context themifyContext(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0363j.View, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(C0363j.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = obtainStyledAttributes.getResourceId(C0363j.View_theme, 0)) != 0) {
            Log.i(LOG_TAG, "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? ((context instanceof ContextThemeWrapper) && ((ContextThemeWrapper) context).m8769b() == resourceId) ? context : new ContextThemeWrapper(context, resourceId) : context;
    }

    private void verifyNotNull(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    public AppCompatAutoCompleteTextView createAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatAutoCompleteTextView(context, attributeSet);
    }

    public AppCompatButton createButton(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    public AppCompatCheckBox createCheckBox(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckBox(context, attributeSet);
    }

    public AppCompatCheckedTextView createCheckedTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckedTextView(context, attributeSet);
    }

    public AppCompatEditText createEditText(Context context, AttributeSet attributeSet) {
        return new AppCompatEditText(context, attributeSet);
    }

    public AppCompatImageButton createImageButton(Context context, AttributeSet attributeSet) {
        return new AppCompatImageButton(context, attributeSet);
    }

    public AppCompatImageView createImageView(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    public AppCompatMultiAutoCompleteTextView createMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatMultiAutoCompleteTextView(context, attributeSet);
    }

    public AppCompatRadioButton createRadioButton(Context context, AttributeSet attributeSet) {
        return new AppCompatRadioButton(context, attributeSet);
    }

    public AppCompatRatingBar createRatingBar(Context context, AttributeSet attributeSet) {
        return new AppCompatRatingBar(context, attributeSet);
    }

    public AppCompatSeekBar createSeekBar(Context context, AttributeSet attributeSet) {
        return new AppCompatSeekBar(context, attributeSet);
    }

    public AppCompatSpinner createSpinner(Context context, AttributeSet attributeSet) {
        return new AppCompatSpinner(context, attributeSet);
    }

    public AppCompatTextView createTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    public View createView(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    public final View createView(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        View createTextView;
        Context context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = themifyContext(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = TintContextWrapper.m8342b(context2);
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c = 11;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c = '\b';
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c = '\n';
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c = 0;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c = 5;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c = '\f';
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c = 4;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c = 7;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c = 1;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c = '\t';
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c = 6;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c = 3;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                createTextView = createTextView(context2, attributeSet);
                verifyNotNull(createTextView, str);
                break;
            case 1:
                createTextView = createImageView(context2, attributeSet);
                verifyNotNull(createTextView, str);
                break;
            case 2:
                createTextView = createButton(context2, attributeSet);
                verifyNotNull(createTextView, str);
                break;
            case 3:
                createTextView = createEditText(context2, attributeSet);
                verifyNotNull(createTextView, str);
                break;
            case 4:
                createTextView = createSpinner(context2, attributeSet);
                verifyNotNull(createTextView, str);
                break;
            case 5:
                createTextView = createImageButton(context2, attributeSet);
                verifyNotNull(createTextView, str);
                break;
            case 6:
                createTextView = createCheckBox(context2, attributeSet);
                verifyNotNull(createTextView, str);
                break;
            case 7:
                createTextView = createRadioButton(context2, attributeSet);
                verifyNotNull(createTextView, str);
                break;
            case '\b':
                createTextView = createCheckedTextView(context2, attributeSet);
                verifyNotNull(createTextView, str);
                break;
            case '\t':
                createTextView = createAutoCompleteTextView(context2, attributeSet);
                verifyNotNull(createTextView, str);
                break;
            case '\n':
                createTextView = createMultiAutoCompleteTextView(context2, attributeSet);
                verifyNotNull(createTextView, str);
                break;
            case 11:
                createTextView = createRatingBar(context2, attributeSet);
                verifyNotNull(createTextView, str);
                break;
            case '\f':
                createTextView = createSeekBar(context2, attributeSet);
                verifyNotNull(createTextView, str);
                break;
            default:
                createTextView = createView(context2, str, attributeSet);
                break;
        }
        if (createTextView == null && context != context2) {
            createTextView = createViewFromTag(context2, str, attributeSet);
        }
        if (createTextView != null) {
            checkOnClickListener(createTextView, attributeSet);
        }
        return createTextView;
    }
}
