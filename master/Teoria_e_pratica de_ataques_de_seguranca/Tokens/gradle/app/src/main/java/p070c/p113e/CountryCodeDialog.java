package p070c.p113e;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p067v7.widget.LinearLayoutManager;
import android.support.p067v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.futuremind.recyclerviewfastscroll.FastScroller;
import com.hbb20.C1444R;
import com.hbb20.CCPCountry;
import com.hbb20.CountryCodePicker;
import java.lang.reflect.Field;
import java.util.List;

/* renamed from: c.e.b */
/* loaded from: classes.dex */
public class CountryCodeDialog {

    /* renamed from: a */
    public static final Field f5957a;

    /* renamed from: b */
    public static final Field f5958b;

    /* renamed from: c */
    public static final Field f5959c;

    /* compiled from: CountryCodeDialog.java */
    /* renamed from: c.e.b$a */
    /* loaded from: classes.dex */
    public static class View$OnClickListenerC1357a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ Dialog f5960a;

        public View$OnClickListenerC1357a(Dialog dialog) {
            this.f5960a = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f5960a.dismiss();
        }
    }

    /* compiled from: CountryCodeDialog.java */
    /* renamed from: c.e.b$b */
    /* loaded from: classes.dex */
    public static class DialogInterface$OnDismissListenerC1358b implements DialogInterface.OnDismissListener {

        /* renamed from: a */
        public final /* synthetic */ Context f5961a;

        /* renamed from: b */
        public final /* synthetic */ CountryCodePicker f5962b;

        public DialogInterface$OnDismissListenerC1358b(Context context, CountryCodePicker countryCodePicker) {
            this.f5961a = context;
            this.f5962b = countryCodePicker;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            CountryCodeDialog.m4662b(this.f5961a);
            if (this.f5962b.getDialogEventsListener() != null) {
                this.f5962b.getDialogEventsListener().mo787a(dialogInterface);
            }
        }
    }

    /* compiled from: CountryCodeDialog.java */
    /* renamed from: c.e.b$c */
    /* loaded from: classes.dex */
    public static class DialogInterface$OnCancelListenerC1359c implements DialogInterface.OnCancelListener {

        /* renamed from: a */
        public final /* synthetic */ Context f5963a;

        /* renamed from: b */
        public final /* synthetic */ CountryCodePicker f5964b;

        public DialogInterface$OnCancelListenerC1359c(Context context, CountryCodePicker countryCodePicker) {
            this.f5963a = context;
            this.f5964b = countryCodePicker;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            CountryCodeDialog.m4662b(this.f5963a);
            if (this.f5964b.getDialogEventsListener() != null) {
                this.f5964b.getDialogEventsListener().mo786b(dialogInterface);
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
            p070c.p113e.CountryCodeDialog.f5957a = r1
            p070c.p113e.CountryCodeDialog.f5958b = r1
            p070c.p113e.CountryCodeDialog.f5959c = r1
            goto L4e
        L48:
            p070c.p113e.CountryCodeDialog.f5957a = r4
            p070c.p113e.CountryCodeDialog.f5958b = r3
            p070c.p113e.CountryCodeDialog.f5959c = r2
        L4e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p070c.p113e.CountryCodeDialog.<clinit>():void");
    }

    /* renamed from: b */
    public static void m4662b(Context context) {
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

    /* renamed from: a */
    public static void m4663a(CountryCodePicker countryCodePicker) {
        Context context = countryCodePicker.getContext();
        Dialog dialog = new Dialog(context);
        countryCodePicker.m4272m();
        countryCodePicker.m4271n();
        List<CCPCountry> m4324a = CCPCountry.m4324a(context, countryCodePicker);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setContentView(C1444R.layout.layout_picker_dialog);
        if (countryCodePicker.m4279f() && countryCodePicker.m4280e()) {
            dialog.getWindow().setSoftInputMode(4);
        } else {
            dialog.getWindow().setSoftInputMode(2);
        }
        RecyclerView recyclerView = (RecyclerView) dialog.findViewById(C1444R.C1446id.recycler_countryDialog);
        TextView textView = (TextView) dialog.findViewById(C1444R.C1446id.textView_title);
        RelativeLayout relativeLayout = (RelativeLayout) dialog.findViewById(C1444R.C1446id.rl_query_holder);
        ImageView imageView = (ImageView) dialog.findViewById(C1444R.C1446id.img_clear_query);
        EditText editText = (EditText) dialog.findViewById(C1444R.C1446id.editText_search);
        TextView textView2 = (TextView) dialog.findViewById(C1444R.C1446id.textView_noresult);
        RelativeLayout relativeLayout2 = (RelativeLayout) dialog.findViewById(C1444R.C1446id.rl_holder);
        ImageView imageView2 = (ImageView) dialog.findViewById(C1444R.C1446id.img_dismiss);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (countryCodePicker.getDialogBackgroundColor() != 0) {
            relativeLayout2.setBackgroundColor(countryCodePicker.getDialogBackgroundColor());
        }
        if (countryCodePicker.m4278g()) {
            imageView2.setVisibility(0);
            imageView2.setOnClickListener(new View$OnClickListenerC1357a(dialog));
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
            m4664a(editText, countryCodePicker.getDialogSearchEditTextTintColor());
        }
        textView.setText(countryCodePicker.getDialogTitle());
        editText.setHint(countryCodePicker.getSearchHintText());
        textView2.setText(countryCodePicker.getNoResultFoundText());
        if (!countryCodePicker.m4279f()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) recyclerView.getLayoutParams();
            layoutParams.height = -2;
            recyclerView.setLayoutParams(layoutParams);
        }
        CountryCodeAdapter countryCodeAdapter = new CountryCodeAdapter(context, m4324a, countryCodePicker, relativeLayout, editText, textView2, dialog, imageView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(countryCodeAdapter);
        FastScroller fastScroller = (FastScroller) dialog.findViewById(C1444R.C1446id.fastscroll);
        fastScroller.setRecyclerView(recyclerView);
        if (countryCodePicker.m4277h()) {
            if (countryCodePicker.getFastScrollerBubbleColor() != 0) {
                fastScroller.setBubbleColor(countryCodePicker.getFastScrollerBubbleColor());
            }
            if (countryCodePicker.getFastScrollerHandleColor() != 0) {
                fastScroller.setHandleColor(countryCodePicker.getFastScrollerHandleColor());
            }
            if (countryCodePicker.getFastScrollerBubbleTextAppearance() != 0) {
                try {
                    fastScroller.setBubbleTextAppearance(countryCodePicker.getFastScrollerBubbleTextAppearance());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            fastScroller.setVisibility(8);
        }
        dialog.setOnDismissListener(new DialogInterface$OnDismissListenerC1358b(context, countryCodePicker));
        dialog.setOnCancelListener(new DialogInterface$OnCancelListenerC1359c(context, countryCodePicker));
        dialog.show();
        if (countryCodePicker.getDialogEventsListener() != null) {
            countryCodePicker.getDialogEventsListener().mo788a(dialog);
        }
    }

    /* renamed from: a */
    public static void m4664a(EditText editText, int i) {
        if (f5958b == null) {
            return;
        }
        try {
            Drawable m4665a = m4665a(editText.getContext(), f5959c.getInt(editText));
            m4665a.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            f5958b.set(Build.VERSION.SDK_INT < 16 ? editText : f5957a.get(editText), new Drawable[]{m4665a, m4665a});
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static Drawable m4665a(Context context, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            return context.getResources().getDrawable(i);
        }
        return context.getDrawable(i);
    }
}
