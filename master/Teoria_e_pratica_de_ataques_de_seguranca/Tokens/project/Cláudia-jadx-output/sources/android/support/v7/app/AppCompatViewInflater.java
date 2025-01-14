package android.support.v7.app;

import a.b.g.k.u;
import a.b.h.b.j;
import a.b.h.j.d;
import a.b.h.k.e;
import a.b.h.k.g;
import a.b.h.k.h;
import a.b.h.k.i;
import a.b.h.k.i1;
import a.b.h.k.l;
import a.b.h.k.n;
import a.b.h.k.p;
import a.b.h.k.q;
import a.b.h.k.t;
import a.b.h.k.v;
import a.b.h.k.x;
import a.b.h.k.z;
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
/* loaded from: classes.dex */
public class AppCompatViewInflater {
    public static final String LOG_TAG = "AppCompatViewInflater";
    public final Object[] mConstructorArgs = new Object[2];
    public static final Class<?>[] sConstructorSignature = {Context.class, AttributeSet.class};
    public static final int[] sOnClickAttrs = {16843375};
    public static final String[] sClassPrefixList = {"android.widget.", "android.view.", "android.webkit."};
    public static final Map<String, Constructor<? extends View>> sConstructorMap = new a.b.g.j.a();

    /* loaded from: classes.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final View f2425a;

        /* renamed from: b  reason: collision with root package name */
        public final String f2426b;

        /* renamed from: c  reason: collision with root package name */
        public Method f2427c;

        /* renamed from: d  reason: collision with root package name */
        public Context f2428d;

        public a(View view, String str) {
            this.f2425a = view;
            this.f2426b = str;
        }

        public final void a(Context context, String str) {
            int id;
            String str2;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f2426b, View.class)) != null) {
                        this.f2427c = method;
                        this.f2428d = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            if (this.f2425a.getId() == -1) {
                str2 = "";
            } else {
                str2 = " with id '" + this.f2425a.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f2426b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f2425a.getClass() + str2);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f2427c == null) {
                a(this.f2425a.getContext(), this.f2426b);
            }
            try {
                this.f2427c.invoke(this.f2428d, view);
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
            } catch (InvocationTargetException e3) {
                throw new IllegalStateException("Could not execute method for android:onClick", e3);
            }
        }
    }

    private void checkOnClickListener(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (context instanceof ContextWrapper) {
            if (Build.VERSION.SDK_INT < 15 || u.t(view)) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, sOnClickAttrs);
                String string = obtainStyledAttributes.getString(0);
                if (string != null) {
                    view.setOnClickListener(new a(view, string));
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
                for (int i2 = 0; i2 < sClassPrefixList.length; i2++) {
                    View createViewByPrefix = createViewByPrefix(context, str, sClassPrefixList[i2]);
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.View, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(j.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = obtainStyledAttributes.getResourceId(j.View_theme, 0)) != 0) {
            Log.i(LOG_TAG, "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? ((context instanceof d) && ((d) context).b() == resourceId) ? context : new d(context, resourceId) : context;
    }

    private void verifyNotNull(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    public e createAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new e(context, attributeSet);
    }

    public g createButton(Context context, AttributeSet attributeSet) {
        return new g(context, attributeSet);
    }

    public h createCheckBox(Context context, AttributeSet attributeSet) {
        return new h(context, attributeSet);
    }

    public i createCheckedTextView(Context context, AttributeSet attributeSet) {
        return new i(context, attributeSet);
    }

    public l createEditText(Context context, AttributeSet attributeSet) {
        return new l(context, attributeSet);
    }

    public n createImageButton(Context context, AttributeSet attributeSet) {
        return new n(context, attributeSet);
    }

    public p createImageView(Context context, AttributeSet attributeSet) {
        return new p(context, attributeSet);
    }

    public q createMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new q(context, attributeSet);
    }

    public t createRadioButton(Context context, AttributeSet attributeSet) {
        return new t(context, attributeSet);
    }

    public a.b.h.k.u createRatingBar(Context context, AttributeSet attributeSet) {
        return new a.b.h.k.u(context, attributeSet);
    }

    public v createSeekBar(Context context, AttributeSet attributeSet) {
        return new v(context, attributeSet);
    }

    public x createSpinner(Context context, AttributeSet attributeSet) {
        return new x(context, attributeSet);
    }

    public z createTextView(Context context, AttributeSet attributeSet) {
        return new z(context, attributeSet);
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
            context2 = i1.b(context2);
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c2 = 11;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c2 = '\n';
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c2 = 0;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c2 = 5;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c2 = '\f';
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c2 = 4;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c2 = 3;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
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
