package com.hbb20;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Build;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import d.b.a.a.i;
import d.b.a.a.n;
import io.michaelrocks.libphonenumber.android.NumberParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class CountryCodePicker extends RelativeLayout {
    public static int A0 = 1;
    public static int B0 = 0;
    public static String C0 = "http://schemas.android.com/apk/res/android";
    public static String y0 = "CCP";
    public static int z0 = 91;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public PhoneNumberType H;
    public String I;
    public int J;
    public int K;
    public Typeface L;
    public int M;
    public List<CCPCountry> N;
    public int O;
    public String P;
    public int Q;
    public List<CCPCountry> R;
    public String S;
    public String T;
    public Language U;
    public Language V;
    public boolean W;

    /* renamed from: a  reason: collision with root package name */
    public String f4117a;
    public boolean a0;

    /* renamed from: b  reason: collision with root package name */
    public int f4118b;
    public boolean b0;

    /* renamed from: c  reason: collision with root package name */
    public String f4119c;
    public boolean c0;

    /* renamed from: d  reason: collision with root package name */
    public Context f4120d;
    public boolean d0;

    /* renamed from: e  reason: collision with root package name */
    public View f4121e;
    public boolean e0;

    /* renamed from: f  reason: collision with root package name */
    public LayoutInflater f4122f;
    public String f0;

    /* renamed from: g  reason: collision with root package name */
    public TextView f4123g;
    public TextWatcher g0;

    /* renamed from: h  reason: collision with root package name */
    public EditText f4124h;
    public InternationalPhoneTextWatcher h0;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f4125i;
    public boolean i0;
    public ImageView j;
    public TextWatcher j0;
    public ImageView k;
    public boolean k0;
    public String l0;
    public LinearLayout m;
    public OnCountryChangeListener m0;
    public LinearLayout n;
    public PhoneNumberValidityChangeListener n0;
    public CCPCountry o;
    public FailureListener o0;
    public CCPCountry p;
    public DialogEventsListener p0;
    public RelativeLayout q;
    public int q0;
    public CountryCodePicker r;
    public int r0;
    public TextGravity s;
    public int s0;
    public AutoDetectionPref t;
    public int t0;
    public i u;
    public int u0;
    public boolean v;
    public View.OnClickListener v0;
    public boolean w;
    public int w0;
    public boolean x;
    public boolean x0;
    public boolean y;
    public boolean z;

    /* loaded from: classes.dex */
    public enum AutoDetectionPref {
        SIM_ONLY("1"),
        NETWORK_ONLY("2"),
        LOCALE_ONLY("3"),
        SIM_NETWORK("12"),
        NETWORK_SIM("21"),
        SIM_LOCALE("13"),
        LOCALE_SIM("31"),
        NETWORK_LOCALE("23"),
        LOCALE_NETWORK("32"),
        SIM_NETWORK_LOCALE("123"),
        SIM_LOCALE_NETWORK("132"),
        NETWORK_SIM_LOCALE("213"),
        NETWORK_LOCALE_SIM("231"),
        LOCALE_SIM_NETWORK("312"),
        LOCALE_NETWORK_SIM("321");
        

        /* renamed from: a  reason: collision with root package name */
        public String f4134a;

        AutoDetectionPref(String str) {
            this.f4134a = str;
        }

        public static AutoDetectionPref a(String str) {
            AutoDetectionPref[] values;
            for (AutoDetectionPref autoDetectionPref : values()) {
                if (autoDetectionPref.f4134a.equals(str)) {
                    return autoDetectionPref;
                }
            }
            return SIM_NETWORK_LOCALE;
        }
    }

    /* loaded from: classes.dex */
    public interface DialogEventsListener {
        void a(Dialog dialog);

        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);
    }

    /* loaded from: classes.dex */
    public interface FailureListener {
        void a();
    }

    /* loaded from: classes.dex */
    public enum Language {
        ARABIC("ar"),
        BENGALI("bn"),
        CHINESE_SIMPLIFIED("zh"),
        CHINESE_TRADITIONAL("zh"),
        DUTCH("nl"),
        ENGLISH("en"),
        FRENCH("fr"),
        GERMAN("de"),
        GUJARATI("gu"),
        HEBREW("iw"),
        HINDI("hi"),
        INDONESIA("in"),
        ITALIAN("it"),
        JAPANESE("ja"),
        KOREAN("ko"),
        PORTUGUESE("pt"),
        PUNJABI("pa"),
        RUSSIAN("ru"),
        SPANISH("es"),
        SWEDISH("sv"),
        TURKISH("tr"),
        UKRAINIAN("uk");
        

        /* renamed from: a  reason: collision with root package name */
        public String f4143a;

        Language(String str) {
            this.f4143a = str;
        }

        public String b() {
            return this.f4143a;
        }
    }

    /* loaded from: classes.dex */
    public interface OnCountryChangeListener {
        void a();
    }

    /* loaded from: classes.dex */
    public enum PhoneNumberType {
        MOBILE,
        FIXED_LINE,
        FIXED_LINE_OR_MOBILE,
        TOLL_FREE,
        PREMIUM_RATE,
        SHARED_COST,
        VOIP,
        PERSONAL_NUMBER,
        PAGER,
        UAN,
        VOICEMAIL,
        UNKNOWN
    }

    /* loaded from: classes.dex */
    public interface PhoneNumberValidityChangeListener {
        void a(boolean z);
    }

    /* loaded from: classes.dex */
    public enum TextGravity {
        LEFT(-1),
        CENTER(0),
        RIGHT(1);
        

        /* renamed from: a  reason: collision with root package name */
        public int f4157a;

        TextGravity(int i2) {
            this.f4157a = i2;
        }
    }

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CountryCodePicker.this.c()) {
                CountryCodePicker.this.j();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        public String f4159a = null;

        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            String str = CountryCodePicker.y0;
            Log.d(str, "onTextChanged: I am changed again cursor position" + Selection.getSelectionEnd(charSequence));
            CCPCountry selectedCountry = CountryCodePicker.this.getSelectedCountry();
            if (selectedCountry != null) {
                String str2 = this.f4159a;
                if ((str2 == null || !str2.equals(charSequence.toString())) && CountryCodePicker.this.k0) {
                    if (selectedCountry.f().equals("1")) {
                        String obj = CountryCodePicker.this.getEditText_registeredCarrierNumber().getText().toString();
                        if (obj.length() >= 3) {
                            String c2 = i.c((CharSequence) obj);
                            if (c2.length() >= 3) {
                                String substring = c2.substring(0, 3);
                                if (!substring.equals(CountryCodePicker.this.l0)) {
                                    CountryCodePicker countryCodePicker = CountryCodePicker.this;
                                    Context context = countryCodePicker.f4120d;
                                    Language languageToApply = countryCodePicker.getLanguageToApply();
                                    CCPCountry d2 = CCPCountry.d(context, languageToApply, null, 1 + c2);
                                    if (!d2.equals(selectedCountry)) {
                                        CountryCodePicker countryCodePicker2 = CountryCodePicker.this;
                                        countryCodePicker2.x0 = true;
                                        countryCodePicker2.w0 = Selection.getSelectionEnd(charSequence);
                                        String str3 = CountryCodePicker.y0;
                                        Log.d(str3, "onTextChanged: remembered position " + CountryCodePicker.this.w0);
                                        CountryCodePicker.this.setSelectedCountry(d2);
                                    }
                                    CountryCodePicker.this.l0 = substring;
                                }
                            }
                        }
                    } else if (selectedCountry.f().equals("44")) {
                        String obj2 = CountryCodePicker.this.getEditText_registeredCarrierNumber().getText().toString();
                        if (obj2.length() >= 4) {
                            String c3 = i.c((CharSequence) obj2);
                            if (c3.length() >= 4) {
                                String substring2 = c3.substring(0, 4);
                                if (!substring2.equals(CountryCodePicker.this.l0)) {
                                    CountryCodePicker countryCodePicker3 = CountryCodePicker.this;
                                    Context context2 = countryCodePicker3.f4120d;
                                    Language languageToApply2 = countryCodePicker3.getLanguageToApply();
                                    CCPCountry a2 = CCPCountry.a(context2, languageToApply2, (List<CCPCountry>) null, 44 + c3);
                                    if (a2 != null && !a2.equals(selectedCountry)) {
                                        CountryCodePicker countryCodePicker4 = CountryCodePicker.this;
                                        countryCodePicker4.x0 = true;
                                        countryCodePicker4.w0 = Selection.getSelectionEnd(charSequence);
                                        CountryCodePicker.this.setSelectedCountry(a2);
                                    }
                                    CountryCodePicker.this.l0 = substring2;
                                }
                            }
                        }
                    }
                    this.f4159a = charSequence.toString();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (CountryCodePicker.this.n0 != null) {
                boolean i2 = CountryCodePicker.this.i();
                CountryCodePicker countryCodePicker = CountryCodePicker.this;
                if (i2 != countryCodePicker.i0) {
                    countryCodePicker.i0 = i2;
                    countryCodePicker.n0.a(CountryCodePicker.this.i0);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f4162a = new int[PhoneNumberType.values().length];

        static {
            try {
                f4162a[PhoneNumberType.MOBILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4162a[PhoneNumberType.FIXED_LINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4162a[PhoneNumberType.FIXED_LINE_OR_MOBILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4162a[PhoneNumberType.TOLL_FREE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4162a[PhoneNumberType.PREMIUM_RATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4162a[PhoneNumberType.SHARED_COST.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4162a[PhoneNumberType.VOIP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4162a[PhoneNumberType.PERSONAL_NUMBER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4162a[PhoneNumberType.PAGER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4162a[PhoneNumberType.UAN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f4162a[PhoneNumberType.VOICEMAIL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f4162a[PhoneNumberType.UNKNOWN.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public CountryCodePicker(Context context) {
        super(context);
        this.f4117a = "CCP_PREF_FILE";
        this.v = false;
        this.w = true;
        this.x = true;
        this.y = true;
        this.z = false;
        this.B = true;
        this.C = true;
        this.D = false;
        this.E = false;
        this.F = true;
        this.G = true;
        this.H = PhoneNumberType.MOBILE;
        this.I = "ccp_last_selection";
        this.O = B0;
        this.Q = 0;
        Language language = Language.ENGLISH;
        this.U = language;
        this.V = language;
        this.W = true;
        this.a0 = true;
        this.f0 = "notSet";
        this.l0 = null;
        this.v0 = new a();
        this.w0 = 0;
        this.x0 = false;
        this.f4120d = context;
        b((AttributeSet) null);
    }

    private Language getCCPLanguageFromLocale() {
        Language[] values;
        Locale locale = this.f4120d.getResources().getConfiguration().locale;
        Log.d(y0, "getCCPLanguageFromLocale: current locale language" + locale.getLanguage());
        for (Language language : Language.values()) {
            if (language.b().equalsIgnoreCase(locale.getLanguage())) {
                return language;
            }
        }
        return null;
    }

    private View.OnClickListener getCountryCodeHolderClickListener() {
        return this.v0;
    }

    private TextWatcher getCountryDetectorTextWatcher() {
        if (this.f4124h != null && this.j0 == null) {
            this.j0 = new b();
        }
        return this.j0;
    }

    private CCPCountry getDefaultCountry() {
        return this.p;
    }

    private RelativeLayout getHolder() {
        return this.f4125i;
    }

    private View getHolderView() {
        return this.f4121e;
    }

    private i getPhoneUtil() {
        if (this.u == null) {
            this.u = i.a(this.f4120d);
        }
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CCPCountry getSelectedCountry() {
        if (this.o == null) {
            setSelectedCountry(getDefaultCountry());
        }
        return this.o;
    }

    private i.c getSelectedHintNumberType() {
        switch (d.f4162a[this.H.ordinal()]) {
            case 1:
                return i.c.MOBILE;
            case 2:
                return i.c.FIXED_LINE;
            case 3:
                return i.c.FIXED_LINE_OR_MOBILE;
            case 4:
                return i.c.TOLL_FREE;
            case 5:
                return i.c.PREMIUM_RATE;
            case 6:
                return i.c.SHARED_COST;
            case 7:
                return i.c.VOIP;
            case 8:
                return i.c.PERSONAL_NUMBER;
            case 9:
                return i.c.PAGER;
            case 10:
                return i.c.UAN;
            case 11:
                return i.c.VOICEMAIL;
            case 12:
                return i.c.UNKNOWN;
            default:
                return i.c.MOBILE;
        }
    }

    private LayoutInflater getmInflater() {
        return this.f4122f;
    }

    private void setCustomDefaultLanguage(Language language) {
        this.U = language;
        r();
        setSelectedCountry(CCPCountry.a(this.f4120d, getLanguageToApply(), this.o.e()));
    }

    private void setDefaultCountry(CCPCountry cCPCountry) {
        this.p = cCPCountry;
    }

    private void setHolder(RelativeLayout relativeLayout) {
        this.f4125i = relativeLayout;
    }

    private void setHolderView(View view) {
        this.f4121e = view;
    }

    public boolean c() {
        return this.a0;
    }

    public boolean d() {
        return this.x;
    }

    public boolean e() {
        return this.W;
    }

    public boolean f() {
        return this.B;
    }

    public boolean g() {
        return this.D;
    }

    public boolean getCcpDialogShowNameCode() {
        return this.G;
    }

    public int getContentColor() {
        return this.J;
    }

    public TextGravity getCurrentTextGravity() {
        return this.s;
    }

    public Language getCustomDefaultLanguage() {
        return this.U;
    }

    public List<CCPCountry> getCustomMasterCountriesList() {
        return this.R;
    }

    public String getCustomMasterCountriesParam() {
        return this.S;
    }

    public String getDefaultCountryCode() {
        return this.p.f4113b;
    }

    public int getDefaultCountryCodeAsInt() {
        try {
            return Integer.parseInt(getDefaultCountryCode());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public String getDefaultCountryCodeWithPlus() {
        return "+" + getDefaultCountryCode();
    }

    public String getDefaultCountryName() {
        return getDefaultCountry().f4114c;
    }

    public String getDefaultCountryNameCode() {
        return getDefaultCountry().f4112a.toUpperCase();
    }

    public int getDialogBackgroundColor() {
        return this.r0;
    }

    public DialogEventsListener getDialogEventsListener() {
        return this.p0;
    }

    public int getDialogSearchEditTextTintColor() {
        return this.t0;
    }

    public int getDialogTextColor() {
        return this.s0;
    }

    public String getDialogTitle() {
        return CCPCountry.a(this.f4120d, getLanguageToApply());
    }

    public Typeface getDialogTypeFace() {
        return this.L;
    }

    public int getDialogTypeFaceStyle() {
        return this.M;
    }

    public EditText getEditText_registeredCarrierNumber() {
        Log.d(y0, "getEditText_registeredCarrierNumber");
        return this.f4124h;
    }

    public int getFastScrollerBubbleColor() {
        return this.Q;
    }

    public int getFastScrollerBubbleTextAppearance() {
        return this.u0;
    }

    public int getFastScrollerHandleColor() {
        return this.q0;
    }

    public String getFormattedFullNumber() {
        if (this.f4124h != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return PhoneNumberUtils.formatNumber(getFullNumberWithPlus(), getSelectedCountryCode());
            }
            return PhoneNumberUtils.formatNumber(getFullNumberWithPlus());
        }
        String f2 = getSelectedCountry().f();
        Log.w(y0, "EditText for carrier number is not registered. Register it using registerCarrierNumberEditText() before getFullNumber() or setFullNumber().");
        return f2;
    }

    public String getFullNumber() {
        String selectedCountryCode = getSelectedCountryCode();
        if (this.f4124h != null) {
            i phoneUtil = getPhoneUtil();
            try {
                getSelectedCountryCode();
                n b2 = phoneUtil.b(i.c((CharSequence) this.f4124h.getText().toString()), getSelectedCountryNameCode());
                return "" + b2.b() + b2.e();
            } catch (NumberParseException e2) {
                e2.printStackTrace();
                return selectedCountryCode;
            }
        }
        return selectedCountryCode;
    }

    public String getFullNumberWithPlus() {
        return "+" + getFullNumber();
    }

    public ImageView getImageViewFlag() {
        return this.k;
    }

    public Language getLanguageToApply() {
        if (this.V == null) {
            r();
        }
        return this.V;
    }

    public String getNoResultFoundText() {
        return CCPCountry.c(this.f4120d, getLanguageToApply());
    }

    public String getSearchHintText() {
        return CCPCountry.d(this.f4120d, getLanguageToApply());
    }

    public String getSelectedCountryCode() {
        return getSelectedCountry().f4113b;
    }

    public int getSelectedCountryCodeAsInt() {
        try {
            return Integer.parseInt(getSelectedCountryCode());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public String getSelectedCountryCodeWithPlus() {
        return "+" + getSelectedCountryCode();
    }

    public String getSelectedCountryEnglishName() {
        return getSelectedCountry().b();
    }

    public String getSelectedCountryName() {
        return getSelectedCountry().f4114c;
    }

    public String getSelectedCountryNameCode() {
        return getSelectedCountry().f4112a.toUpperCase();
    }

    public TextView getTextView_selectedCountry() {
        return this.f4123g;
    }

    public boolean h() {
        return this.A;
    }

    public boolean i() {
        if (getEditText_registeredCarrierNumber() != null && getEditText_registeredCarrierNumber().getText().length() != 0) {
            i phoneUtil = getPhoneUtil();
            return getPhoneUtil().c(phoneUtil.b("+" + this.o.f() + getEditText_registeredCarrierNumber().getText().toString(), this.o.e()));
        }
        if (getEditText_registeredCarrierNumber() == null) {
            Toast.makeText(this.f4120d, "No editText for Carrier number found.", 0).show();
        }
        return false;
    }

    public void j() {
        c.e.b.a(this.r);
    }

    public final void k() {
        String string = this.f4120d.getSharedPreferences(this.f4117a, 0).getString(this.I, null);
        if (string != null) {
            setCountryForNameCode(string);
        }
    }

    public final void l() {
        if (this.C) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    public void m() {
        String str = this.S;
        if (str != null && str.length() != 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : this.S.split(",")) {
                CCPCountry a2 = CCPCountry.a(getContext(), getLanguageToApply(), str2);
                if (a2 != null && !a(a2, arrayList)) {
                    arrayList.add(a2);
                }
            }
            if (arrayList.size() == 0) {
                this.R = null;
            } else {
                this.R = arrayList;
            }
        } else {
            String str3 = this.T;
            if (str3 != null && str3.length() != 0) {
                this.T = this.T.toLowerCase();
                List<CCPCountry> b2 = CCPCountry.b(this.f4120d, getLanguageToApply());
                ArrayList arrayList2 = new ArrayList();
                for (CCPCountry cCPCountry : b2) {
                    if (!this.T.contains(cCPCountry.e().toLowerCase())) {
                        arrayList2.add(cCPCountry);
                    }
                }
                if (arrayList2.size() > 0) {
                    this.R = arrayList2;
                } else {
                    this.R = null;
                }
            } else {
                this.R = null;
            }
        }
        List<CCPCountry> list = this.R;
        if (list != null) {
            for (CCPCountry cCPCountry2 : list) {
                cCPCountry2.g();
            }
        }
    }

    public void n() {
        String str = this.P;
        if (str != null && str.length() != 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : this.P.split(",")) {
                CCPCountry a2 = CCPCountry.a(getContext(), this.R, getLanguageToApply(), str2);
                if (a2 != null && !a(a2, arrayList)) {
                    arrayList.add(a2);
                }
            }
            if (arrayList.size() == 0) {
                this.N = null;
            } else {
                this.N = arrayList;
            }
        } else {
            this.N = null;
        }
        List<CCPCountry> list = this.N;
        if (list != null) {
            for (CCPCountry cCPCountry : list) {
                cCPCountry.g();
            }
        }
    }

    public void o() {
        this.p = CCPCountry.a(getContext(), getLanguageToApply(), getDefaultCountryNameCode());
        setSelectedCountry(this.p);
    }

    public final void p() {
        if (this.f4124h != null && this.o != null) {
            String str = y0;
            Log.d(str, "updateFormattingTextWatcher: " + this.I);
            String c2 = i.c((CharSequence) getEditText_registeredCarrierNumber().getText().toString());
            InternationalPhoneTextWatcher internationalPhoneTextWatcher = this.h0;
            if (internationalPhoneTextWatcher != null) {
                this.f4124h.removeTextChangedListener(internationalPhoneTextWatcher);
            }
            TextWatcher textWatcher = this.j0;
            if (textWatcher != null) {
                this.f4124h.removeTextChangedListener(textWatcher);
            }
            if (this.d0) {
                this.h0 = new InternationalPhoneTextWatcher(this.f4120d, getSelectedCountryNameCode(), getSelectedCountryCodeAsInt());
                this.f4124h.addTextChangedListener(this.h0);
            }
            if (this.F) {
                this.j0 = getCountryDetectorTextWatcher();
                this.f4124h.addTextChangedListener(this.j0);
            }
            this.f4124h.setText("");
            this.f4124h.setText(c2);
            EditText editText = this.f4124h;
            editText.setSelection(editText.getText().length());
        } else if (this.f4124h == null) {
            String str2 = y0;
            Log.d(str2, "updateFormattingTextWatcher: EditText not registered " + this.I);
        } else {
            String str3 = y0;
            Log.d(str3, "updateFormattingTextWatcher: selected country is null " + this.I);
        }
    }

    public final void q() {
        n a2;
        String formatNumber;
        if (this.f4124h == null || !this.e0) {
            return;
        }
        String str = "";
        if (getPhoneUtil().a(getSelectedCountryNameCode(), getSelectedHintNumberType()) != null) {
            String str2 = a2.e() + "";
            Log.d(y0, "updateHint: " + str2);
            if (Build.VERSION.SDK_INT >= 21) {
                formatNumber = PhoneNumberUtils.formatNumber(getSelectedCountryCodeWithPlus() + str2, getSelectedCountryNameCode());
            } else {
                formatNumber = PhoneNumberUtils.formatNumber(getSelectedCountryCodeWithPlus() + str2 + str2);
            }
            str = formatNumber.substring(getSelectedCountryCodeWithPlus().length()).trim();
            Log.d(y0, "updateHint: after format " + str + " " + this.I);
        } else {
            Log.w(y0, "updateHint: No example number found for this country (" + getSelectedCountryNameCode() + ") or this type (" + this.H.name() + ").");
        }
        this.f4124h.setHint(str);
    }

    public final void r() {
        if (isInEditMode()) {
            Language language = this.U;
            if (language != null) {
                this.V = language;
            } else {
                this.V = Language.ENGLISH;
            }
        } else if (b()) {
            Language cCPLanguageFromLocale = getCCPLanguageFromLocale();
            if (cCPLanguageFromLocale == null) {
                if (getCustomDefaultLanguage() != null) {
                    this.V = getCustomDefaultLanguage();
                } else {
                    this.V = Language.ENGLISH;
                }
            } else {
                this.V = cCPLanguageFromLocale;
            }
        } else if (getCustomDefaultLanguage() != null) {
            this.V = this.U;
        } else {
            this.V = Language.ENGLISH;
        }
        String str = y0;
        Log.d(str, "updateLanguageToApply: " + this.V);
    }

    public final void s() {
        try {
            this.f4124h.removeTextChangedListener(this.g0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.i0 = i();
        PhoneNumberValidityChangeListener phoneNumberValidityChangeListener = this.n0;
        if (phoneNumberValidityChangeListener != null) {
            phoneNumberValidityChangeListener.a(this.i0);
        }
        this.g0 = new c();
        this.f4124h.addTextChangedListener(this.g0);
    }

    public void setArrowSize(int i2) {
        if (i2 > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.width = i2;
            layoutParams.height = i2;
            this.j.setLayoutParams(layoutParams);
        }
    }

    public void setAutoDetectedCountry(boolean z) {
        boolean z2 = false;
        for (int i2 = 0; i2 < this.t.f4134a.length(); i2++) {
            try {
                switch (this.t.f4134a.charAt(i2)) {
                    case '1':
                        Log.d(y0, "setAutoDetectedCountry: Setting using SIM");
                        z2 = c(false);
                        String str = y0;
                        Log.d(str, "setAutoDetectedCountry: Result of sim country detection:" + z2 + " current country:" + getSelectedCountryNameCode());
                        break;
                    case '2':
                        Log.d(y0, "setAutoDetectedCountry: Setting using NETWORK");
                        z2 = b(false);
                        String str2 = y0;
                        Log.d(str2, "setAutoDetectedCountry: Result of network country detection:" + z2 + " current country:" + getSelectedCountryNameCode());
                        break;
                    case '3':
                        Log.d(y0, "setAutoDetectedCountry: Setting using LOCALE");
                        z2 = a(false);
                        String str3 = y0;
                        Log.d(str3, "setAutoDetectedCountry: Result of LOCALE country detection:" + z2 + " current country:" + getSelectedCountryNameCode());
                        break;
                }
                if (z2) {
                    if (z2 && z) {
                        o();
                        return;
                    }
                }
                if (this.o0 != null) {
                    this.o0.a();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                String str4 = y0;
                Log.w(str4, "setAutoDetectCountry: Exception" + e2.getMessage());
                if (z) {
                    o();
                    return;
                }
                return;
            }
        }
        if (z2) {
        }
    }

    public void setCcpClickable(boolean z) {
        this.a0 = z;
        if (!z) {
            this.q.setOnClickListener(null);
            this.q.setClickable(false);
            this.q.setEnabled(false);
            return;
        }
        this.q.setOnClickListener(this.v0);
        this.q.setClickable(true);
        this.q.setEnabled(true);
    }

    public void setCcpDialogShowNameCode(boolean z) {
        this.G = z;
    }

    public void setCcpDialogShowPhoneCode(boolean z) {
        this.x = z;
    }

    public void setContentColor(int i2) {
        this.J = i2;
        this.f4123g.setTextColor(this.J);
        this.j.setColorFilter(this.J, PorterDuff.Mode.SRC_IN);
    }

    public void setCountryAutoDetectionPref(AutoDetectionPref autoDetectionPref) {
        this.t = autoDetectionPref;
    }

    public void setCountryForNameCode(String str) {
        CCPCountry a2 = CCPCountry.a(getContext(), getLanguageToApply(), str);
        if (a2 == null) {
            if (this.p == null) {
                this.p = CCPCountry.a(getContext(), getLanguageToApply(), this.N, this.f4118b);
            }
            setSelectedCountry(this.p);
            return;
        }
        setSelectedCountry(a2);
    }

    public void setCountryForPhoneCode(int i2) {
        CCPCountry a2 = CCPCountry.a(getContext(), getLanguageToApply(), this.N, i2);
        if (a2 == null) {
            if (this.p == null) {
                this.p = CCPCountry.a(getContext(), getLanguageToApply(), this.N, this.f4118b);
            }
            setSelectedCountry(this.p);
            return;
        }
        setSelectedCountry(a2);
    }

    public void setCountryPreference(String str) {
        this.P = str;
    }

    public void setCurrentTextGravity(TextGravity textGravity) {
        this.s = textGravity;
        a(textGravity.f4157a);
    }

    public void setCustomMasterCountries(String str) {
        this.S = str;
    }

    public void setCustomMasterCountriesList(List<CCPCountry> list) {
        this.R = list;
    }

    public void setDefaultCountryUsingNameCode(String str) {
        CCPCountry a2 = CCPCountry.a(getContext(), getLanguageToApply(), str);
        if (a2 == null) {
            return;
        }
        this.f4119c = a2.e();
        setDefaultCountry(a2);
    }

    @Deprecated
    public void setDefaultCountryUsingPhoneCode(int i2) {
        CCPCountry a2 = CCPCountry.a(getContext(), getLanguageToApply(), this.N, i2);
        if (a2 == null) {
            return;
        }
        this.f4118b = i2;
        setDefaultCountry(a2);
    }

    public void setDetectCountryWithAreaCode(boolean z) {
        this.F = z;
        p();
    }

    public void setDialogBackgroundColor(int i2) {
        this.r0 = i2;
    }

    public void setDialogEventsListener(DialogEventsListener dialogEventsListener) {
        this.p0 = dialogEventsListener;
    }

    public void setDialogKeyboardAutoPopup(boolean z) {
        this.W = z;
    }

    public void setDialogSearchEditTextTintColor(int i2) {
        this.t0 = i2;
    }

    public void setDialogTextColor(int i2) {
        this.s0 = i2;
    }

    public void setDialogTypeFace(Typeface typeface) {
        try {
            this.L = typeface;
            this.M = -99;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setEditText_registeredCarrierNumber(EditText editText) {
        this.f4124h = editText;
        String str = y0;
        Log.d(str, "setEditText_registeredCarrierNumber: carrierEditTextAttached " + this.I);
        s();
        p();
        q();
    }

    public void setExcludedCountries(String str) {
        this.T = str;
        m();
    }

    public void setFastScrollerBubbleColor(int i2) {
        this.Q = i2;
    }

    public void setFastScrollerBubbleTextAppearance(int i2) {
        this.u0 = i2;
    }

    public void setFastScrollerHandleColor(int i2) {
        this.q0 = i2;
    }

    public void setFlagBorderColor(int i2) {
        this.K = i2;
        this.m.setBackgroundColor(this.K);
    }

    public void setFlagSize(int i2) {
        this.k.getLayoutParams().height = i2;
        this.k.requestLayout();
    }

    public void setFullNumber(String str) {
        CCPCountry c2 = CCPCountry.c(getContext(), getLanguageToApply(), this.N, str);
        if (c2 == null) {
            c2 = getDefaultCountry();
        }
        setSelectedCountry(c2);
        String a2 = a(str, c2);
        if (getEditText_registeredCarrierNumber() != null) {
            getEditText_registeredCarrierNumber().setText(a2);
            p();
            return;
        }
        Log.w(y0, "EditText for carrier number is not registered. Register it using registerCarrierNumberEditText() before getFullNumber() or setFullNumber().");
    }

    public void setHintExampleNumberEnabled(boolean z) {
        this.e0 = z;
        q();
    }

    public void setHintExampleNumberType(PhoneNumberType phoneNumberType) {
        this.H = phoneNumberType;
        q();
    }

    public void setImageViewFlag(ImageView imageView) {
        this.k = imageView;
    }

    public void setLanguageToApply(Language language) {
        this.V = language;
    }

    public void setNumberAutoFormattingEnabled(boolean z) {
        this.d0 = z;
        if (this.f4124h != null) {
            p();
        }
    }

    public void setOnCountryChangeListener(OnCountryChangeListener onCountryChangeListener) {
        this.m0 = onCountryChangeListener;
    }

    public void setPhoneNumberValidityChangeListener(PhoneNumberValidityChangeListener phoneNumberValidityChangeListener) {
        this.n0 = phoneNumberValidityChangeListener;
        if (this.f4124h != null) {
            this.i0 = i();
            phoneNumberValidityChangeListener.a(this.i0);
        }
    }

    public void setSearchAllowed(boolean z) {
        this.B = z;
    }

    public void setSelectedCountry(CCPCountry cCPCountry) {
        this.k0 = false;
        String str = "";
        this.l0 = "";
        if (cCPCountry == null) {
            cCPCountry = CCPCountry.a(getContext(), getLanguageToApply(), this.N, this.f4118b);
        }
        this.o = cCPCountry;
        if (this.z) {
            str = "" + cCPCountry.d();
        }
        if (this.v) {
            if (this.z) {
                str = str + " (" + cCPCountry.e().toUpperCase() + ")";
            } else {
                str = str + " " + cCPCountry.e().toUpperCase();
            }
        }
        if (this.w) {
            if (str.length() > 0) {
                str = str + "  ";
            }
            str = str + "+" + cCPCountry.f();
        }
        this.f4123g.setText(str);
        if (!this.y && str.length() == 0) {
            this.f4123g.setText(str + "+" + cCPCountry.f());
        }
        OnCountryChangeListener onCountryChangeListener = this.m0;
        if (onCountryChangeListener != null) {
            onCountryChangeListener.a();
        }
        this.k.setImageResource(cCPCountry.c());
        p();
        q();
        if (this.f4124h != null && this.n0 != null) {
            this.i0 = i();
            this.n0.a(this.i0);
        }
        this.k0 = true;
        if (this.x0) {
            try {
                this.f4124h.setSelection(this.w0);
                this.x0 = false;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setShowFastScroller(boolean z) {
        this.A = z;
    }

    public void setShowPhoneCode(boolean z) {
        this.w = z;
        setSelectedCountry(this.o);
    }

    public void setTextSize(int i2) {
        if (i2 > 0) {
            this.f4123g.setTextSize(0, i2);
            setArrowSize(i2);
            setFlagSize(i2);
        }
    }

    public void setTextView_selectedCountry(TextView textView) {
        this.f4123g = textView;
    }

    public void setTypeFace(Typeface typeface) {
        try {
            this.f4123g.setTypeface(typeface);
            setDialogTypeFace(typeface);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(AttributeSet attributeSet) {
        boolean z;
        int color;
        int color2;
        TypedArray obtainStyledAttributes = this.f4120d.getTheme().obtainStyledAttributes(attributeSet, R.styleable.CountryCodePicker, 0, 0);
        try {
            try {
                this.v = obtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_showNameCode, true);
                this.d0 = obtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_autoFormatNumber, true);
                this.w = obtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_showPhoneCode, true);
                this.x = obtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccpDialog_showPhoneCode, this.w);
                this.G = obtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccpDialog_showNameCode, true);
                this.z = obtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_showFullName, false);
                this.A = obtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccpDialog_showFastScroller, true);
                this.Q = obtainStyledAttributes.getColor(R.styleable.CountryCodePicker_ccpDialog_fastScroller_bubbleColor, 0);
                this.q0 = obtainStyledAttributes.getColor(R.styleable.CountryCodePicker_ccpDialog_fastScroller_handleColor, 0);
                this.u0 = obtainStyledAttributes.getResourceId(R.styleable.CountryCodePicker_ccpDialog_fastScroller_bubbleTextAppearance, 0);
                this.b0 = obtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_autoDetectLanguage, false);
                this.F = obtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_areaCodeDetectedCountry, true);
                this.E = obtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_rememberLastSelection, false);
                this.e0 = obtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_hintExampleNumber, false);
                this.H = PhoneNumberType.values()[obtainStyledAttributes.getInt(R.styleable.CountryCodePicker_ccp_hintExampleNumberType, 0)];
                this.I = obtainStyledAttributes.getString(R.styleable.CountryCodePicker_ccp_selectionMemoryTag);
                if (this.I == null) {
                    this.I = "CCP_last_selection";
                }
                this.t = AutoDetectionPref.a(String.valueOf(obtainStyledAttributes.getInt(R.styleable.CountryCodePicker_ccp_countryAutoDetectionPref, 123)));
                this.c0 = obtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_autoDetectCountry, false);
                this.C = obtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_showArrow, true);
                l();
                this.D = obtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccpDialog_showCloseIcon, false);
                d(obtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_showFlag, true));
                setDialogKeyboardAutoPopup(obtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccpDialog_keyboardAutoPopup, true));
                this.U = b(obtainStyledAttributes.getInt(R.styleable.CountryCodePicker_ccp_defaultLanguage, Language.ENGLISH.ordinal()));
                r();
                this.S = obtainStyledAttributes.getString(R.styleable.CountryCodePicker_ccp_customMasterCountries);
                this.T = obtainStyledAttributes.getString(R.styleable.CountryCodePicker_ccp_excludedCountries);
                if (!isInEditMode()) {
                    m();
                }
                this.P = obtainStyledAttributes.getString(R.styleable.CountryCodePicker_ccp_countryPreference);
                if (!isInEditMode()) {
                    n();
                }
                if (obtainStyledAttributes.hasValue(R.styleable.CountryCodePicker_ccp_textGravity)) {
                    this.O = obtainStyledAttributes.getInt(R.styleable.CountryCodePicker_ccp_textGravity, A0);
                }
                a(this.O);
                this.f4119c = obtainStyledAttributes.getString(R.styleable.CountryCodePicker_ccp_defaultNameCode);
                if (this.f4119c == null || this.f4119c.length() == 0) {
                    z = false;
                } else {
                    if (!isInEditMode()) {
                        if (CCPCountry.a(getContext(), getLanguageToApply(), this.f4119c) != null) {
                            setDefaultCountry(CCPCountry.a(getContext(), getLanguageToApply(), this.f4119c));
                            setSelectedCountry(this.p);
                            z = true;
                        }
                        z = false;
                    } else {
                        if (CCPCountry.g(this.f4119c) != null) {
                            setDefaultCountry(CCPCountry.g(this.f4119c));
                            setSelectedCountry(this.p);
                            z = true;
                        }
                        z = false;
                    }
                    if (!z) {
                        setDefaultCountry(CCPCountry.g("IN"));
                        setSelectedCountry(this.p);
                        z = true;
                    }
                }
                int integer = obtainStyledAttributes.getInteger(R.styleable.CountryCodePicker_ccp_defaultPhoneCode, -1);
                if (!z && integer != -1) {
                    if (!isInEditMode()) {
                        if (integer != -1 && CCPCountry.a(getContext(), getLanguageToApply(), this.N, integer) == null) {
                            integer = z0;
                        }
                        setDefaultCountryUsingPhoneCode(integer);
                        setSelectedCountry(this.p);
                    } else {
                        CCPCountry f2 = CCPCountry.f(integer + "");
                        if (f2 == null) {
                            f2 = CCPCountry.f(z0 + "");
                        }
                        setDefaultCountry(f2);
                        setSelectedCountry(f2);
                    }
                }
                if (getDefaultCountry() == null) {
                    setDefaultCountry(CCPCountry.g("IN"));
                    if (getSelectedCountry() == null) {
                        setSelectedCountry(this.p);
                    }
                }
                if (a() && !isInEditMode()) {
                    setAutoDetectedCountry(true);
                }
                if (this.E && !isInEditMode()) {
                    k();
                }
                if (isInEditMode()) {
                    color = obtainStyledAttributes.getColor(R.styleable.CountryCodePicker_ccp_contentColor, 0);
                } else {
                    color = obtainStyledAttributes.getColor(R.styleable.CountryCodePicker_ccp_contentColor, this.f4120d.getResources().getColor(R.color.defaultContentColor));
                }
                if (color != 0) {
                    setContentColor(color);
                }
                if (isInEditMode()) {
                    color2 = obtainStyledAttributes.getColor(R.styleable.CountryCodePicker_ccp_flagBorderColor, 0);
                } else {
                    color2 = obtainStyledAttributes.getColor(R.styleable.CountryCodePicker_ccp_flagBorderColor, this.f4120d.getResources().getColor(R.color.defaultBorderFlagColor));
                }
                if (color2 != 0) {
                    setFlagBorderColor(color2);
                }
                setDialogBackgroundColor(obtainStyledAttributes.getColor(R.styleable.CountryCodePicker_ccpDialog_backgroundColor, 0));
                setDialogTextColor(obtainStyledAttributes.getColor(R.styleable.CountryCodePicker_ccpDialog_textColor, 0));
                setDialogSearchEditTextTintColor(obtainStyledAttributes.getColor(R.styleable.CountryCodePicker_ccpDialog_searchEditTextTint, 0));
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CountryCodePicker_ccp_textSize, 0);
                if (dimensionPixelSize > 0) {
                    this.f4123g.setTextSize(0, dimensionPixelSize);
                    setFlagSize(dimensionPixelSize);
                    setArrowSize(dimensionPixelSize);
                }
                int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CountryCodePicker_ccp_arrowSize, 0);
                if (dimensionPixelSize2 > 0) {
                    setArrowSize(dimensionPixelSize2);
                }
                this.B = obtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccpDialog_allowSearch, true);
                setCcpClickable(obtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_clickable, true));
            } catch (Exception e2) {
                this.f4123g.setTextSize(10.0f);
                this.f4123g.setText(e2.toString());
            }
            obtainStyledAttributes.recycle();
            String str = y0;
            Log.d(str, "end:xmlWidth " + this.f0);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void b(AttributeSet attributeSet) {
        this.f4122f = LayoutInflater.from(this.f4120d);
        this.f0 = attributeSet.getAttributeValue(C0, "layout_width");
        String str = y0;
        Log.d(str, "init:xmlWidth " + this.f0);
        removeAllViewsInLayout();
        String str2 = this.f0;
        if (str2 != null && (str2.equals("-1") || this.f0.equals("-1") || this.f0.equals("fill_parent") || this.f0.equals("match_parent"))) {
            this.f4121e = this.f4122f.inflate(R.layout.layout_full_width_code_picker, (ViewGroup) this, true);
        } else {
            this.f4121e = this.f4122f.inflate(R.layout.layout_code_picker, (ViewGroup) this, true);
        }
        this.f4123g = (TextView) this.f4121e.findViewById(R.id.textView_selectedCountry);
        this.f4125i = (RelativeLayout) this.f4121e.findViewById(R.id.countryCodeHolder);
        this.j = (ImageView) this.f4121e.findViewById(R.id.imageView_arrow);
        this.k = (ImageView) this.f4121e.findViewById(R.id.image_flag);
        this.n = (LinearLayout) this.f4121e.findViewById(R.id.linear_flag_holder);
        this.m = (LinearLayout) this.f4121e.findViewById(R.id.linear_flag_border);
        this.q = (RelativeLayout) this.f4121e.findViewById(R.id.rlClickConsumer);
        this.r = this;
        a(attributeSet);
        this.q.setOnClickListener(this.v0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
        o();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean c(boolean r5) {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = r4.f4120d     // Catch: java.lang.Exception -> L2f
            java.lang.String r2 = "phone"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch: java.lang.Exception -> L2f
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch: java.lang.Exception -> L2f
            java.lang.String r1 = r1.getSimCountryIso()     // Catch: java.lang.Exception -> L2f
            if (r1 == 0) goto L29
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Exception -> L2f
            if (r2 == 0) goto L18
            goto L29
        L18:
            android.content.Context r2 = r4.getContext()     // Catch: java.lang.Exception -> L2f
            com.hbb20.CountryCodePicker$Language r3 = r4.getLanguageToApply()     // Catch: java.lang.Exception -> L2f
            com.hbb20.CCPCountry r1 = com.hbb20.CCPCountry.a(r2, r3, r1)     // Catch: java.lang.Exception -> L2f
            r4.setSelectedCountry(r1)     // Catch: java.lang.Exception -> L2f
            r5 = 1
            return r5
        L29:
            if (r5 == 0) goto L2e
            r4.o()     // Catch: java.lang.Exception -> L2f
        L2e:
            return r0
        L2f:
            r1 = move-exception
            r1.printStackTrace()
            if (r5 == 0) goto L38
            r4.o()
        L38:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbb20.CountryCodePicker.c(boolean):boolean");
    }

    public void d(boolean z) {
        this.y = z;
        if (z) {
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(8);
        }
    }

    public void setPhoneNumberValidityChangeListener(FailureListener failureListener) {
        this.o0 = failureListener;
    }

    public boolean b() {
        return this.b0;
    }

    public final Language b(int i2) {
        if (i2 < Language.values().length) {
            return Language.values()[i2];
        }
        return Language.ENGLISH;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
        o();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b(boolean r5) {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = r4.f4120d     // Catch: java.lang.Exception -> L2f
            java.lang.String r2 = "phone"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch: java.lang.Exception -> L2f
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch: java.lang.Exception -> L2f
            java.lang.String r1 = r1.getNetworkCountryIso()     // Catch: java.lang.Exception -> L2f
            if (r1 == 0) goto L29
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Exception -> L2f
            if (r2 == 0) goto L18
            goto L29
        L18:
            android.content.Context r2 = r4.getContext()     // Catch: java.lang.Exception -> L2f
            com.hbb20.CountryCodePicker$Language r3 = r4.getLanguageToApply()     // Catch: java.lang.Exception -> L2f
            com.hbb20.CCPCountry r1 = com.hbb20.CCPCountry.a(r2, r3, r1)     // Catch: java.lang.Exception -> L2f
            r4.setSelectedCountry(r1)     // Catch: java.lang.Exception -> L2f
            r5 = 1
            return r5
        L29:
            if (r5 == 0) goto L2e
            r4.o()     // Catch: java.lang.Exception -> L2f
        L2e:
            return r0
        L2f:
            r1 = move-exception
            r1.printStackTrace()
            if (r5 == 0) goto L38
            r4.o()
        L38:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbb20.CountryCodePicker.b(boolean):boolean");
    }

    public CountryCodePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4117a = "CCP_PREF_FILE";
        this.v = false;
        this.w = true;
        this.x = true;
        this.y = true;
        this.z = false;
        this.B = true;
        this.C = true;
        this.D = false;
        this.E = false;
        this.F = true;
        this.G = true;
        this.H = PhoneNumberType.MOBILE;
        this.I = "ccp_last_selection";
        this.O = B0;
        this.Q = 0;
        Language language = Language.ENGLISH;
        this.U = language;
        this.V = language;
        this.W = true;
        this.a0 = true;
        this.f0 = "notSet";
        this.l0 = null;
        this.v0 = new a();
        this.w0 = 0;
        this.x0 = false;
        this.f4120d = context;
        b(attributeSet);
    }

    public CountryCodePicker(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4117a = "CCP_PREF_FILE";
        this.v = false;
        this.w = true;
        this.x = true;
        this.y = true;
        this.z = false;
        this.B = true;
        this.C = true;
        this.D = false;
        this.E = false;
        this.F = true;
        this.G = true;
        this.H = PhoneNumberType.MOBILE;
        this.I = "ccp_last_selection";
        this.O = B0;
        this.Q = 0;
        Language language = Language.ENGLISH;
        this.U = language;
        this.V = language;
        this.W = true;
        this.a0 = true;
        this.f0 = "notSet";
        this.l0 = null;
        this.v0 = new a();
        this.w0 = 0;
        this.x0 = false;
        this.f4120d = context;
        b(attributeSet);
    }

    public void a(String str) {
        SharedPreferences.Editor edit = this.f4120d.getSharedPreferences(this.f4117a, 0).edit();
        edit.putString(this.I, str);
        edit.apply();
    }

    public final void a(int i2) {
        if (i2 == TextGravity.LEFT.f4157a) {
            this.f4123g.setGravity(3);
        } else if (i2 == TextGravity.CENTER.f4157a) {
            this.f4123g.setGravity(17);
        } else {
            this.f4123g.setGravity(5);
        }
    }

    public boolean a() {
        return this.c0;
    }

    public final boolean a(CCPCountry cCPCountry, List<CCPCountry> list) {
        if (cCPCountry == null || list == null) {
            return false;
        }
        for (CCPCountry cCPCountry2 : list) {
            if (cCPCountry2.e().equalsIgnoreCase(cCPCountry.e())) {
                return true;
            }
        }
        return false;
    }

    public final String a(String str, CCPCountry cCPCountry) {
        int indexOf;
        return (cCPCountry == null || str == null || str.isEmpty() || (indexOf = str.indexOf(cCPCountry.f())) == -1) ? str : str.substring(indexOf + cCPCountry.f().length());
    }

    public void a(EditText editText) {
        setEditText_registeredCarrierNumber(editText);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
        o();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(boolean r5) {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = r4.f4120d     // Catch: java.lang.Exception -> L31
            android.content.res.Resources r1 = r1.getResources()     // Catch: java.lang.Exception -> L31
            android.content.res.Configuration r1 = r1.getConfiguration()     // Catch: java.lang.Exception -> L31
            java.util.Locale r1 = r1.locale     // Catch: java.lang.Exception -> L31
            java.lang.String r1 = r1.getCountry()     // Catch: java.lang.Exception -> L31
            if (r1 == 0) goto L2b
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Exception -> L31
            if (r2 == 0) goto L1a
            goto L2b
        L1a:
            android.content.Context r2 = r4.getContext()     // Catch: java.lang.Exception -> L31
            com.hbb20.CountryCodePicker$Language r3 = r4.getLanguageToApply()     // Catch: java.lang.Exception -> L31
            com.hbb20.CCPCountry r1 = com.hbb20.CCPCountry.a(r2, r3, r1)     // Catch: java.lang.Exception -> L31
            r4.setSelectedCountry(r1)     // Catch: java.lang.Exception -> L31
            r5 = 1
            return r5
        L2b:
            if (r5 == 0) goto L30
            r4.o()     // Catch: java.lang.Exception -> L31
        L30:
            return r0
        L31:
            r1 = move-exception
            r1.printStackTrace()
            if (r5 == 0) goto L3a
            r4.o()
        L3a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbb20.CountryCodePicker.a(boolean):boolean");
    }

    public void a(CCPCountry cCPCountry) {
        CountryCodePicker countryCodePicker = this.r;
        if (countryCodePicker.E) {
            countryCodePicker.a(cCPCountry.e());
        }
        setSelectedCountry(cCPCountry);
    }
}
