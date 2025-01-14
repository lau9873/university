package c.e;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.futuremind.recyclerviewfastscroll.FastScroller;
import com.hbb20.CCPCountry;
import com.hbb20.CountryCodePicker;
import com.hbb20.R;
import java.lang.reflect.Field;
import java.util.List;
/* compiled from: CountryCodeDialog.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Field f3930a;

    /* renamed from: b  reason: collision with root package name */
    public static final Field f3931b;

    /* renamed from: c  reason: collision with root package name */
    public static final Field f3932c;

    /* compiled from: CountryCodeDialog.java */
    /* loaded from: classes.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f3933a;

        public a(Dialog dialog) {
            this.f3933a = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f3933a.dismiss();
        }
    }

    /* compiled from: CountryCodeDialog.java */
    /* renamed from: c.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class DialogInterface$OnDismissListenerC0070b implements DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f3934a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CountryCodePicker f3935b;

        public DialogInterface$OnDismissListenerC0070b(Context context, CountryCodePicker countryCodePicker) {
            this.f3934a = context;
            this.f3935b = countryCodePicker;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            b.b(this.f3934a);
            if (this.f3935b.getDialogEventsListener() != null) {
                this.f3935b.getDialogEventsListener().a(dialogInterface);
            }
        }
    }

    /* compiled from: CountryCodeDialog.java */
    /* loaded from: classes.dex */
    public static class c implements DialogInterface.OnCancelListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f3936a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CountryCodePicker f3937b;

        public c(Context context, CountryCodePicker countryCodePicker) {
            this.f3936a = context;
            this.f3937b = countryCodePicker;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            b.b(this.f3936a);
            if (this.f3937b.getDialogEventsListener() != null) {
                this.f3937b.getDialogEventsListener().b(dialogInterface);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
    static {
        /*
            r0 = 1
            r1 = 0
            java.lang.Class<android.widget.TextView> r2 = android.widget.TextView.class
            java.lang.String r3 = "mCursorDrawableRes"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch: java.lang.Exception -> L3c
            r2.setAccessible(r0)     // Catch: java.lang.Exception -> L3a
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L3a
            r4 = 16
            if (r3 >= r4) goto L17
            java.lang.Class<android.widget.TextView> r3 = android.widget.TextView.class
            r4 = r1
            goto L29
        L17:
            java.lang.Class<android.widget.TextView> r3 = android.widget.TextView.class
            java.lang.String r4 = "mEditor"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r4)     // Catch: java.lang.Exception -> L3a
            r3.setAccessible(r0)     // Catch: java.lang.Exception -> L38
            java.lang.Class r4 = r3.getType()     // Catch: java.lang.Exception -> L38
            r6 = r4
            r4 = r3
            r3 = r6
        L29:
            java.lang.String r5 = "mCursorDrawable"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r5)     // Catch: java.lang.Exception -> L36
            r3.setAccessible(r0)     // Catch: java.lang.Exception -> L34
            r0 = 0
            goto L3f
        L34:
            goto L3f
        L36:
            r3 = r1
            goto L3f
        L38:
            r4 = r3
            goto L36
        L3a:
            r3 = r1
            goto L3e
        L3c:
            r2 = r1
            r3 = r2
        L3e:
            r4 = r3
        L3f:
            if (r0 == 0) goto L48
            c.e.b.f3930a = r1
            c.e.b.f3931b = r1
            c.e.b.f3932c = r1
            goto L4e
        L48:
            c.e.b.f3930a = r4
            c.e.b.f3931b = r3
            c.e.b.f3932c = r2
        L4e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.b.<clinit>():void");
    }

    public static void b(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus == null) {
                currentFocus = new View(activity);
            }
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    public static void a(CountryCodePicker countryCodePicker) {
        Context context = countryCodePicker.getContext();
        Dialog dialog = new Dialog(context);
        countryCodePicker.m();
        countryCodePicker.n();
        List<CCPCountry> a2 = CCPCountry.a(context, countryCodePicker);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setContentView(R.layout.layout_picker_dialog);
        if (countryCodePicker.f() && countryCodePicker.e()) {
            dialog.getWindow().setSoftInputMode(4);
        } else {
            dialog.getWindow().setSoftInputMode(2);
        }
        RecyclerView recyclerView = (RecyclerView) dialog.findViewById(R.id.recycler_countryDialog);
        TextView textView = (TextView) dialog.findViewById(R.id.textView_title);
        RelativeLayout relativeLayout = (RelativeLayout) dialog.findViewById(R.id.rl_query_holder);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.img_clear_query);
        EditText editText = (EditText) dialog.findViewById(R.id.editText_search);
        TextView textView2 = (TextView) dialog.findViewById(R.id.textView_noresult);
        RelativeLayout relativeLayout2 = (RelativeLayout) dialog.findViewById(R.id.rl_holder);
        ImageView imageView2 = (ImageView) dialog.findViewById(R.id.img_dismiss);
        try {
            if (countryCodePicker.getDialogTypeFace() != null) {
                if (countryCodePicker.getDialogTypeFaceStyle() != -99) {
                    textView2.setTypeface(countryCodePicker.getDialogTypeFace(), countryCodePicker.getDialogTypeFaceStyle());
                    editText.setTypeface(countryCodePicker.getDialogTypeFace(), countryCodePicker.getDialogTypeFaceStyle());
                    textView.setTypeface(countryCodePicker.getDialogTypeFace(), countryCodePicker.getDialogTypeFaceStyle());
                } else {
                    textView2.setTypeface(countryCodePicker.getDialogTypeFace());
                    editText.setTypeface(countryCodePicker.getDialogTypeFace());
                    textView.setTypeface(countryCodePicker.getDialogTypeFace());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (countryCodePicker.getDialogBackgroundColor() != 0) {
            relativeLayout2.setBackgroundColor(countryCodePicker.getDialogBackgroundColor());
        }
        if (countryCodePicker.g()) {
            imageView2.setVisibility(0);
            imageView2.setOnClickListener(new a(dialog));
        } else {
            imageView2.setVisibility(8);
        }
        if (countryCodePicker.getDialogTextColor() != 0) {
            int dialogTextColor = countryCodePicker.getDialogTextColor();
            imageView.setColorFilter(dialogTextColor);
            imageView2.setColorFilter(dialogTextColor);
            textView.setTextColor(dialogTextColor);
            textView2.setTextColor(dialogTextColor);
            editText.setTextColor(dialogTextColor);
            editText.setHintTextColor(Color.argb(100, Color.red(dialogTextColor), Color.green(dialogTextColor), Color.blue(dialogTextColor)));
        }
        if (countryCodePicker.getDialogSearchEditTextTintColor() != 0 && Build.VERSION.SDK_INT >= 21) {
            editText.setBackgroundTintList(ColorStateList.valueOf(countryCodePicker.getDialogSearchEditTextTintColor()));
            a(editText, countryCodePicker.getDialogSearchEditTextTintColor());
        }
        textView.setText(countryCodePicker.getDialogTitle());
        editText.setHint(countryCodePicker.getSearchHintText());
        textView2.setText(countryCodePicker.getNoResultFoundText());
        if (!countryCodePicker.f()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) recyclerView.getLayoutParams();
            layoutParams.height = -2;
            recyclerView.setLayoutParams(layoutParams);
        }
        c.e.a aVar = new c.e.a(context, a2, countryCodePicker, relativeLayout, editText, textView2, dialog, imageView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(aVar);
        FastScroller fastScroller = (FastScroller) dialog.findViewById(R.id.fastscroll);
        fastScroller.setRecyclerView(recyclerView);
        if (countryCodePicker.h()) {
            if (countryCodePicker.getFastScrollerBubbleColor() != 0) {
                fastScroller.setBubbleColor(countryCodePicker.getFastScrollerBubbleColor());
            }
            if (countryCodePicker.getFastScrollerHandleColor() != 0) {
                fastScroller.setHandleColor(countryCodePicker.getFastScrollerHandleColor());
            }
            if (countryCodePicker.getFastScrollerBubbleTextAppearance() != 0) {
                try {
                    fastScroller.setBubbleTextAppearance(countryCodePicker.getFastScrollerBubbleTextAppearance());
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        } else {
            fastScroller.setVisibility(8);
        }
        dialog.setOnDismissListener(new DialogInterface$OnDismissListenerC0070b(context, countryCodePicker));
        dialog.setOnCancelListener(new c(context, countryCodePicker));
        dialog.show();
        if (countryCodePicker.getDialogEventsListener() != null) {
            countryCodePicker.getDialogEventsListener().a(dialog);
        }
    }

    public static void a(EditText editText, int i2) {
        if (f3931b == null) {
            return;
        }
        try {
            Drawable a2 = a(editText.getContext(), f3932c.getInt(editText));
            a2.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
            f3931b.set(Build.VERSION.SDK_INT < 16 ? editText : f3930a.get(editText), new Drawable[]{a2, a2});
        } catch (Exception unused) {
        }
    }

    public static Drawable a(Context context, int i2) {
        if (Build.VERSION.SDK_INT < 21) {
            return context.getResources().getDrawable(i2);
        }
        return context.getDrawable(i2);
    }
}
