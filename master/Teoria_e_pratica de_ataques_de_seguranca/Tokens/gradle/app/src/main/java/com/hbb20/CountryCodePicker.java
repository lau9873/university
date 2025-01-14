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
import io.michaelrocks.libphonenumber.android.NumberParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import p070c.p113e.CountryCodeDialog;
import p136d.p149b.p150a.p151a.PhoneNumberUtil;
import p136d.p149b.p150a.p151a.Phonenumber;

/* loaded from: classes.dex */
public class CountryCodePicker extends RelativeLayout {

    /* renamed from: A0 */
    public static int f6188A0 = 1;

    /* renamed from: B0 */
    public static int f6189B0 = 0;

    /* renamed from: C0 */
    public static String f6190C0 = "http://schemas.android.com/apk/res/android";

    /* renamed from: y0 */
    public static String f6191y0 = "CCP";

    /* renamed from: z0 */
    public static int f6192z0 = 91;

    /* renamed from: A */
    public boolean f6193A;

    /* renamed from: B */
    public boolean f6194B;

    /* renamed from: C */
    public boolean f6195C;

    /* renamed from: D */
    public boolean f6196D;

    /* renamed from: E */
    public boolean f6197E;

    /* renamed from: F */
    public boolean f6198F;

    /* renamed from: G */
    public boolean f6199G;

    /* renamed from: H */
    public PhoneNumberType f6200H;

    /* renamed from: I */
    public String f6201I;

    /* renamed from: J */
    public int f6202J;

    /* renamed from: K */
    public int f6203K;

    /* renamed from: L */
    public Typeface f6204L;

    /* renamed from: M */
    public int f6205M;

    /* renamed from: N */
    public List<CCPCountry> f6206N;

    /* renamed from: O */
    public int f6207O;

    /* renamed from: P */
    public String f6208P;

    /* renamed from: Q */
    public int f6209Q;

    /* renamed from: R */
    public List<CCPCountry> f6210R;

    /* renamed from: S */
    public String f6211S;

    /* renamed from: T */
    public String f6212T;

    /* renamed from: U */
    public Language f6213U;

    /* renamed from: V */
    public Language f6214V;

    /* renamed from: W */
    public boolean f6215W;

    /* renamed from: a */
    public String f6216a;

    /* renamed from: a0 */
    public boolean f6217a0;

    /* renamed from: b */
    public int f6218b;

    /* renamed from: b0 */
    public boolean f6219b0;

    /* renamed from: c */
    public String f6220c;

    /* renamed from: c0 */
    public boolean f6221c0;

    /* renamed from: d */
    public Context f6222d;

    /* renamed from: d0 */
    public boolean f6223d0;

    /* renamed from: e */
    public View f6224e;

    /* renamed from: e0 */
    public boolean f6225e0;

    /* renamed from: f */
    public LayoutInflater f6226f;

    /* renamed from: f0 */
    public String f6227f0;

    /* renamed from: g */
    public TextView f6228g;

    /* renamed from: g0 */
    public TextWatcher f6229g0;

    /* renamed from: h */
    public EditText f6230h;

    /* renamed from: h0 */
    public InternationalPhoneTextWatcher f6231h0;

    /* renamed from: i */
    public RelativeLayout f6232i;

    /* renamed from: i0 */
    public boolean f6233i0;

    /* renamed from: j */
    public ImageView f6234j;

    /* renamed from: j0 */
    public TextWatcher f6235j0;

    /* renamed from: k */
    public ImageView f6236k;

    /* renamed from: k0 */
    public boolean f6237k0;

    /* renamed from: l0 */
    public String f6238l0;

    /* renamed from: m */
    public LinearLayout f6239m;

    /* renamed from: m0 */
    public OnCountryChangeListener f6240m0;

    /* renamed from: n */
    public LinearLayout f6241n;

    /* renamed from: n0 */
    public PhoneNumberValidityChangeListener f6242n0;

    /* renamed from: o */
    public CCPCountry f6243o;

    /* renamed from: o0 */
    public FailureListener f6244o0;

    /* renamed from: p */
    public CCPCountry f6245p;

    /* renamed from: p0 */
    public DialogEventsListener f6246p0;

    /* renamed from: q */
    public RelativeLayout f6247q;

    /* renamed from: q0 */
    public int f6248q0;

    /* renamed from: r */
    public CountryCodePicker f6249r;

    /* renamed from: r0 */
    public int f6250r0;

    /* renamed from: s */
    public TextGravity f6251s;

    /* renamed from: s0 */
    public int f6252s0;

    /* renamed from: t */
    public AutoDetectionPref f6253t;

    /* renamed from: t0 */
    public int f6254t0;

    /* renamed from: u */
    public PhoneNumberUtil f6255u;

    /* renamed from: u0 */
    public int f6256u0;

    /* renamed from: v */
    public boolean f6257v;

    /* renamed from: v0 */
    public View.OnClickListener f6258v0;

    /* renamed from: w */
    public boolean f6259w;

    /* renamed from: w0 */
    public int f6260w0;

    /* renamed from: x */
    public boolean f6261x;

    /* renamed from: x0 */
    public boolean f6262x0;

    /* renamed from: y */
    public boolean f6263y;

    /* renamed from: z */
    public boolean f6264z;

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
        

        /* renamed from: a */
        public String f6281a;

        AutoDetectionPref(String str) {
            this.f6281a = str;
        }

        /* renamed from: a */
        public static AutoDetectionPref m4265a(String str) {
            AutoDetectionPref[] values;
            for (AutoDetectionPref autoDetectionPref : values()) {
                if (autoDetectionPref.f6281a.equals(str)) {
                    return autoDetectionPref;
                }
            }
            return SIM_NETWORK_LOCALE;
        }
    }

    /* loaded from: classes.dex */
    public interface DialogEventsListener {
        /* renamed from: a */
        void mo788a(Dialog dialog);

        /* renamed from: a */
        void mo787a(DialogInterface dialogInterface);

        /* renamed from: b */
        void mo786b(DialogInterface dialogInterface);
    }

    /* loaded from: classes.dex */
    public interface FailureListener {
        /* renamed from: a */
        void m4264a();
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
        

        /* renamed from: a */
        public String f6305a;

        Language(String str) {
            this.f6305a = str;
        }

        /* renamed from: b */
        public String m4263b() {
            return this.f6305a;
        }
    }

    /* loaded from: classes.dex */
    public interface OnCountryChangeListener {
        /* renamed from: a */
        void mo789a();
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
        /* renamed from: a */
        void m4262a(boolean z);
    }

    /* loaded from: classes.dex */
    public enum TextGravity {
        LEFT(-1),
        CENTER(0),
        RIGHT(1);
        

        /* renamed from: a */
        public int f6323a;

        TextGravity(int i) {
            this.f6323a = i;
        }
    }

    /* renamed from: com.hbb20.CountryCodePicker$a */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC1440a implements View.OnClickListener {
        public View$OnClickListenerC1440a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CountryCodePicker.this.m4284c()) {
                CountryCodePicker.this.m4275j();
            }
        }
    }

    /* renamed from: com.hbb20.CountryCodePicker$b */
    /* loaded from: classes.dex */
    public class C1441b implements TextWatcher {

        /* renamed from: a */
        public String f6325a = null;

        public C1441b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String str = CountryCodePicker.f6191y0;
            Log.d(str, "onTextChanged: I am changed again cursor position" + Selection.getSelectionEnd(charSequence));
            CCPCountry selectedCountry = CountryCodePicker.this.getSelectedCountry();
            if (selectedCountry != null) {
                String str2 = this.f6325a;
                if ((str2 == null || !str2.equals(charSequence.toString())) && CountryCodePicker.this.f6237k0) {
                    if (selectedCountry.m4304f().equals("1")) {
                        String obj = CountryCodePicker.this.getEditText_registeredCarrierNumber().getText().toString();
                        if (obj.length() >= 3) {
                            String m3792c = PhoneNumberUtil.m3792c((CharSequence) obj);
                            if (m3792c.length() >= 3) {
                                String substring = m3792c.substring(0, 3);
                                if (!substring.equals(CountryCodePicker.this.f6238l0)) {
                                    CountryCodePicker countryCodePicker = CountryCodePicker.this;
                                    Context context = countryCodePicker.f6222d;
                                    Language languageToApply = countryCodePicker.getLanguageToApply();
                                    CCPCountry m4309d = CCPCountry.m4309d(context, languageToApply, null, 1 + m3792c);
                                    if (!m4309d.equals(selectedCountry)) {
                                        CountryCodePicker countryCodePicker2 = CountryCodePicker.this;
                                        countryCodePicker2.f6262x0 = true;
                                        countryCodePicker2.f6260w0 = Selection.getSelectionEnd(charSequence);
                                        String str3 = CountryCodePicker.f6191y0;
                                        Log.d(str3, "onTextChanged: remembered position " + CountryCodePicker.this.f6260w0);
                                        CountryCodePicker.this.setSelectedCountry(m4309d);
                                    }
                                    CountryCodePicker.this.f6238l0 = substring;
                                }
                            }
                        }
                    } else if (selectedCountry.m4304f().equals("44")) {
                        String obj2 = CountryCodePicker.this.getEditText_registeredCarrierNumber().getText().toString();
                        if (obj2.length() >= 4) {
                            String m3792c2 = PhoneNumberUtil.m3792c((CharSequence) obj2);
                            if (m3792c2.length() >= 4) {
                                String substring2 = m3792c2.substring(0, 4);
                                if (!substring2.equals(CountryCodePicker.this.f6238l0)) {
                                    CountryCodePicker countryCodePicker3 = CountryCodePicker.this;
                                    Context context2 = countryCodePicker3.f6222d;
                                    Language languageToApply2 = countryCodePicker3.getLanguageToApply();
                                    CCPCountry m4325a = CCPCountry.m4325a(context2, languageToApply2, (List<CCPCountry>) null, 44 + m3792c2);
                                    if (m4325a != null && !m4325a.equals(selectedCountry)) {
                                        CountryCodePicker countryCodePicker4 = CountryCodePicker.this;
                                        countryCodePicker4.f6262x0 = true;
                                        countryCodePicker4.f6260w0 = Selection.getSelectionEnd(charSequence);
                                        CountryCodePicker.this.setSelectedCountry(m4325a);
                                    }
                                    CountryCodePicker.this.f6238l0 = substring2;
                                }
                            }
                        }
                    }
                    this.f6325a = charSequence.toString();
                }
            }
        }
    }

    /* renamed from: com.hbb20.CountryCodePicker$c */
    /* loaded from: classes.dex */
    public class C1442c implements TextWatcher {
        public C1442c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (CountryCodePicker.this.f6242n0 != null) {
                boolean m4276i = CountryCodePicker.this.m4276i();
                CountryCodePicker countryCodePicker = CountryCodePicker.this;
                if (m4276i != countryCodePicker.f6233i0) {
                    countryCodePicker.f6233i0 = m4276i;
                    countryCodePicker.f6242n0.m4262a(CountryCodePicker.this.f6233i0);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.hbb20.CountryCodePicker$d */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C1443d {

        /* renamed from: a */
        public static final /* synthetic */ int[] f6328a = new int[PhoneNumberType.values().length];

        static {
            try {
                f6328a[PhoneNumberType.MOBILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6328a[PhoneNumberType.FIXED_LINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6328a[PhoneNumberType.FIXED_LINE_OR_MOBILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6328a[PhoneNumberType.TOLL_FREE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6328a[PhoneNumberType.PREMIUM_RATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6328a[PhoneNumberType.SHARED_COST.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6328a[PhoneNumberType.VOIP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6328a[PhoneNumberType.PERSONAL_NUMBER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6328a[PhoneNumberType.PAGER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f6328a[PhoneNumberType.UAN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f6328a[PhoneNumberType.VOICEMAIL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f6328a[PhoneNumberType.UNKNOWN.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public CountryCodePicker(Context context) {
        super(context);
        this.f6216a = "CCP_PREF_FILE";
        this.f6257v = false;
        this.f6259w = true;
        this.f6261x = true;
        this.f6263y = true;
        this.f6264z = false;
        this.f6194B = true;
        this.f6195C = true;
        this.f6196D = false;
        this.f6197E = false;
        this.f6198F = true;
        this.f6199G = true;
        this.f6200H = PhoneNumberType.MOBILE;
        this.f6201I = "ccp_last_selection";
        this.f6207O = f6189B0;
        this.f6209Q = 0;
        Language language = Language.ENGLISH;
        this.f6213U = language;
        this.f6214V = language;
        this.f6215W = true;
        this.f6217a0 = true;
        this.f6227f0 = "notSet";
        this.f6238l0 = null;
        this.f6258v0 = new View$OnClickListenerC1440a();
        this.f6260w0 = 0;
        this.f6262x0 = false;
        this.f6222d = context;
        m4287b((AttributeSet) null);
    }

    private Language getCCPLanguageFromLocale() {
        Language[] values;
        Locale locale = this.f6222d.getResources().getConfiguration().locale;
        Log.d(f6191y0, "getCCPLanguageFromLocale: current locale language" + locale.getLanguage());
        for (Language language : Language.values()) {
            if (language.m4263b().equalsIgnoreCase(locale.getLanguage())) {
                return language;
            }
        }
        return null;
    }

    private View.OnClickListener getCountryCodeHolderClickListener() {
        return this.f6258v0;
    }

    private TextWatcher getCountryDetectorTextWatcher() {
        if (this.f6230h != null && this.f6235j0 == null) {
            this.f6235j0 = new C1441b();
        }
        return this.f6235j0;
    }

    private CCPCountry getDefaultCountry() {
        return this.f6245p;
    }

    private RelativeLayout getHolder() {
        return this.f6232i;
    }

    private View getHolderView() {
        return this.f6224e;
    }

    private PhoneNumberUtil getPhoneUtil() {
        if (this.f6255u == null) {
            this.f6255u = PhoneNumberUtil.m3827a(this.f6222d);
        }
        return this.f6255u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CCPCountry getSelectedCountry() {
        if (this.f6243o == null) {
            setSelectedCountry(getDefaultCountry());
        }
        return this.f6243o;
    }

    private PhoneNumberUtil.EnumC1526c getSelectedHintNumberType() {
        switch (C1443d.f6328a[this.f6200H.ordinal()]) {
            case 1:
                return PhoneNumberUtil.EnumC1526c.MOBILE;
            case 2:
                return PhoneNumberUtil.EnumC1526c.FIXED_LINE;
            case 3:
                return PhoneNumberUtil.EnumC1526c.FIXED_LINE_OR_MOBILE;
            case 4:
                return PhoneNumberUtil.EnumC1526c.TOLL_FREE;
            case 5:
                return PhoneNumberUtil.EnumC1526c.PREMIUM_RATE;
            case 6:
                return PhoneNumberUtil.EnumC1526c.SHARED_COST;
            case 7:
                return PhoneNumberUtil.EnumC1526c.VOIP;
            case 8:
                return PhoneNumberUtil.EnumC1526c.PERSONAL_NUMBER;
            case 9:
                return PhoneNumberUtil.EnumC1526c.PAGER;
            case 10:
                return PhoneNumberUtil.EnumC1526c.UAN;
            case 11:
                return PhoneNumberUtil.EnumC1526c.VOICEMAIL;
            case 12:
                return PhoneNumberUtil.EnumC1526c.UNKNOWN;
            default:
                return PhoneNumberUtil.EnumC1526c.MOBILE;
        }
    }

    private LayoutInflater getmInflater() {
        return this.f6226f;
    }

    private void setCustomDefaultLanguage(Language language) {
        this.f6213U = language;
        m4267r();
        setSelectedCountry(CCPCountry.m4327a(this.f6222d, getLanguageToApply(), this.f6243o.m4307e()));
    }

    private void setDefaultCountry(CCPCountry cCPCountry) {
        this.f6245p = cCPCountry;
    }

    private void setHolder(RelativeLayout relativeLayout) {
        this.f6232i = relativeLayout;
    }

    private void setHolderView(View view) {
        this.f6224e = view;
    }

    /* renamed from: c */
    public boolean m4284c() {
        return this.f6217a0;
    }

    /* renamed from: d */
    public boolean m4282d() {
        return this.f6261x;
    }

    /* renamed from: e */
    public boolean m4280e() {
        return this.f6215W;
    }

    /* renamed from: f */
    public boolean m4279f() {
        return this.f6194B;
    }

    /* renamed from: g */
    public boolean m4278g() {
        return this.f6196D;
    }

    public boolean getCcpDialogShowNameCode() {
        return this.f6199G;
    }

    public int getContentColor() {
        return this.f6202J;
    }

    public TextGravity getCurrentTextGravity() {
        return this.f6251s;
    }

    public Language getCustomDefaultLanguage() {
        return this.f6213U;
    }

    public List<CCPCountry> getCustomMasterCountriesList() {
        return this.f6210R;
    }

    public String getCustomMasterCountriesParam() {
        return this.f6211S;
    }

    public String getDefaultCountryCode() {
        return this.f6245p.f6184b;
    }

    public int getDefaultCountryCodeAsInt() {
        try {
            return Integer.parseInt(getDefaultCountryCode());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public String getDefaultCountryCodeWithPlus() {
        return "+" + getDefaultCountryCode();
    }

    public String getDefaultCountryName() {
        return getDefaultCountry().f6185c;
    }

    public String getDefaultCountryNameCode() {
        return getDefaultCountry().f6183a.toUpperCase();
    }

    public int getDialogBackgroundColor() {
        return this.f6250r0;
    }

    public DialogEventsListener getDialogEventsListener() {
        return this.f6246p0;
    }

    public int getDialogSearchEditTextTintColor() {
        return this.f6254t0;
    }

    public int getDialogTextColor() {
        return this.f6252s0;
    }

    public String getDialogTitle() {
        return CCPCountry.m4328a(this.f6222d, getLanguageToApply());
    }

    public Typeface getDialogTypeFace() {
        return this.f6204L;
    }

    public int getDialogTypeFaceStyle() {
        return this.f6205M;
    }

    public EditText getEditText_registeredCarrierNumber() {
        Log.d(f6191y0, "getEditText_registeredCarrierNumber");
        return this.f6230h;
    }

    public int getFastScrollerBubbleColor() {
        return this.f6209Q;
    }

    public int getFastScrollerBubbleTextAppearance() {
        return this.f6256u0;
    }

    public int getFastScrollerHandleColor() {
        return this.f6248q0;
    }

    public String getFormattedFullNumber() {
        if (this.f6230h != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return PhoneNumberUtils.formatNumber(getFullNumberWithPlus(), getSelectedCountryCode());
            }
            return PhoneNumberUtils.formatNumber(getFullNumberWithPlus());
        }
        String m4304f = getSelectedCountry().m4304f();
        Log.w(f6191y0, "EditText for carrier number is not registered. Register it using registerCarrierNumberEditText() before getFullNumber() or setFullNumber().");
        return m4304f;
    }

    public String getFullNumber() {
        String selectedCountryCode = getSelectedCountryCode();
        if (this.f6230h != null) {
            PhoneNumberUtil phoneUtil = getPhoneUtil();
            try {
                getSelectedCountryCode();
                Phonenumber m3796b = phoneUtil.m3796b(PhoneNumberUtil.m3792c((CharSequence) this.f6230h.getText().toString()), getSelectedCountryNameCode());
                return "" + m3796b.m3702b() + m3796b.m3696e();
            } catch (NumberParseException e) {
                e.printStackTrace();
                return selectedCountryCode;
            }
        }
        return selectedCountryCode;
    }

    public String getFullNumberWithPlus() {
        return "+" + getFullNumber();
    }

    public ImageView getImageViewFlag() {
        return this.f6236k;
    }

    public Language getLanguageToApply() {
        if (this.f6214V == null) {
            m4267r();
        }
        return this.f6214V;
    }

    public String getNoResultFoundText() {
        return CCPCountry.m4314c(this.f6222d, getLanguageToApply());
    }

    public String getSearchHintText() {
        return CCPCountry.m4310d(this.f6222d, getLanguageToApply());
    }

    public String getSelectedCountryCode() {
        return getSelectedCountry().f6184b;
    }

    public int getSelectedCountryCodeAsInt() {
        try {
            return Integer.parseInt(getSelectedCountryCode());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public String getSelectedCountryCodeWithPlus() {
        return "+" + getSelectedCountryCode();
    }

    public String getSelectedCountryEnglishName() {
        return getSelectedCountry().m4320b();
    }

    public String getSelectedCountryName() {
        return getSelectedCountry().f6185c;
    }

    public String getSelectedCountryNameCode() {
        return getSelectedCountry().f6183a.toUpperCase();
    }

    public TextView getTextView_selectedCountry() {
        return this.f6228g;
    }

    /* renamed from: h */
    public boolean m4277h() {
        return this.f6193A;
    }

    /* renamed from: i */
    public boolean m4276i() {
        if (getEditText_registeredCarrierNumber() != null && getEditText_registeredCarrierNumber().getText().length() != 0) {
            PhoneNumberUtil phoneUtil = getPhoneUtil();
            return getPhoneUtil().m3793c(phoneUtil.m3796b("+" + this.f6243o.m4304f() + getEditText_registeredCarrierNumber().getText().toString(), this.f6243o.m4307e()));
        }
        if (getEditText_registeredCarrierNumber() == null) {
            Toast.makeText(this.f6222d, "No editText for Carrier number found.", 0).show();
        }
        return false;
    }

    /* renamed from: j */
    public void m4275j() {
        CountryCodeDialog.m4663a(this.f6249r);
    }

    /* renamed from: k */
    public final void m4274k() {
        String string = this.f6222d.getSharedPreferences(this.f6216a, 0).getString(this.f6201I, null);
        if (string != null) {
            setCountryForNameCode(string);
        }
    }

    /* renamed from: l */
    public final void m4273l() {
        if (this.f6195C) {
            this.f6234j.setVisibility(0);
        } else {
            this.f6234j.setVisibility(8);
        }
    }

    /* renamed from: m */
    public void m4272m() {
        String str = this.f6211S;
        if (str != null && str.length() != 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : this.f6211S.split(",")) {
                CCPCountry m4327a = CCPCountry.m4327a(getContext(), getLanguageToApply(), str2);
                if (m4327a != null && !m4294a(m4327a, arrayList)) {
                    arrayList.add(m4327a);
                }
            }
            if (arrayList.size() == 0) {
                this.f6210R = null;
            } else {
                this.f6210R = arrayList;
            }
        } else {
            String str3 = this.f6212T;
            if (str3 != null && str3.length() != 0) {
                this.f6212T = this.f6212T.toLowerCase();
                List<CCPCountry> m4319b = CCPCountry.m4319b(this.f6222d, getLanguageToApply());
                ArrayList arrayList2 = new ArrayList();
                for (CCPCountry cCPCountry : m4319b) {
                    if (!this.f6212T.contains(cCPCountry.m4307e().toLowerCase())) {
                        arrayList2.add(cCPCountry);
                    }
                }
                if (arrayList2.size() > 0) {
                    this.f6210R = arrayList2;
                } else {
                    this.f6210R = null;
                }
            } else {
                this.f6210R = null;
            }
        }
        List<CCPCountry> list = this.f6210R;
        if (list != null) {
            for (CCPCountry cCPCountry2 : list) {
                cCPCountry2.m4302g();
            }
        }
    }

    /* renamed from: n */
    public void m4271n() {
        String str = this.f6208P;
        if (str != null && str.length() != 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : this.f6208P.split(",")) {
                CCPCountry m4323a = CCPCountry.m4323a(getContext(), this.f6210R, getLanguageToApply(), str2);
                if (m4323a != null && !m4294a(m4323a, arrayList)) {
                    arrayList.add(m4323a);
                }
            }
            if (arrayList.size() == 0) {
                this.f6206N = null;
            } else {
                this.f6206N = arrayList;
            }
        } else {
            this.f6206N = null;
        }
        List<CCPCountry> list = this.f6206N;
        if (list != null) {
            for (CCPCountry cCPCountry : list) {
                cCPCountry.m4302g();
            }
        }
    }

    /* renamed from: o */
    public void m4270o() {
        this.f6245p = CCPCountry.m4327a(getContext(), getLanguageToApply(), getDefaultCountryNameCode());
        setSelectedCountry(this.f6245p);
    }

    /* renamed from: p */
    public final void m4269p() {
        if (this.f6230h != null && this.f6243o != null) {
            String str = f6191y0;
            Log.d(str, "updateFormattingTextWatcher: " + this.f6201I);
            String m3792c = PhoneNumberUtil.m3792c((CharSequence) getEditText_registeredCarrierNumber().getText().toString());
            InternationalPhoneTextWatcher internationalPhoneTextWatcher = this.f6231h0;
            if (internationalPhoneTextWatcher != null) {
                this.f6230h.removeTextChangedListener(internationalPhoneTextWatcher);
            }
            TextWatcher textWatcher = this.f6235j0;
            if (textWatcher != null) {
                this.f6230h.removeTextChangedListener(textWatcher);
            }
            if (this.f6223d0) {
                this.f6231h0 = new InternationalPhoneTextWatcher(this.f6222d, getSelectedCountryNameCode(), getSelectedCountryCodeAsInt());
                this.f6230h.addTextChangedListener(this.f6231h0);
            }
            if (this.f6198F) {
                this.f6235j0 = getCountryDetectorTextWatcher();
                this.f6230h.addTextChangedListener(this.f6235j0);
            }
            this.f6230h.setText("");
            this.f6230h.setText(m3792c);
            EditText editText = this.f6230h;
            editText.setSelection(editText.getText().length());
        } else if (this.f6230h == null) {
            String str2 = f6191y0;
            Log.d(str2, "updateFormattingTextWatcher: EditText not registered " + this.f6201I);
        } else {
            String str3 = f6191y0;
            Log.d(str3, "updateFormattingTextWatcher: selected country is null " + this.f6201I);
        }
    }

    /* renamed from: q */
    public final void m4268q() {
        Phonenumber m3808a;
        String formatNumber;
        if (this.f6230h == null || !this.f6225e0) {
            return;
        }
        String str = "";
        if (getPhoneUtil().m3808a(getSelectedCountryNameCode(), getSelectedHintNumberType()) != null) {
            String str2 = m3808a.m3696e() + "";
            Log.d(f6191y0, "updateHint: " + str2);
            if (Build.VERSION.SDK_INT >= 21) {
                formatNumber = PhoneNumberUtils.formatNumber(getSelectedCountryCodeWithPlus() + str2, getSelectedCountryNameCode());
            } else {
                formatNumber = PhoneNumberUtils.formatNumber(getSelectedCountryCodeWithPlus() + str2 + str2);
            }
            str = formatNumber.substring(getSelectedCountryCodeWithPlus().length()).trim();
            Log.d(f6191y0, "updateHint: after format " + str + " " + this.f6201I);
        } else {
            Log.w(f6191y0, "updateHint: No example number found for this country (" + getSelectedCountryNameCode() + ") or this type (" + this.f6200H.name() + ").");
        }
        this.f6230h.setHint(str);
    }

    /* renamed from: r */
    public final void m4267r() {
        if (isInEditMode()) {
            Language language = this.f6213U;
            if (language != null) {
                this.f6214V = language;
            } else {
                this.f6214V = Language.ENGLISH;
            }
        } else if (m4289b()) {
            Language cCPLanguageFromLocale = getCCPLanguageFromLocale();
            if (cCPLanguageFromLocale == null) {
                if (getCustomDefaultLanguage() != null) {
                    this.f6214V = getCustomDefaultLanguage();
                } else {
                    this.f6214V = Language.ENGLISH;
                }
            } else {
                this.f6214V = cCPLanguageFromLocale;
            }
        } else if (getCustomDefaultLanguage() != null) {
            this.f6214V = this.f6213U;
        } else {
            this.f6214V = Language.ENGLISH;
        }
        String str = f6191y0;
        Log.d(str, "updateLanguageToApply: " + this.f6214V);
    }

    /* renamed from: s */
    public final void m4266s() {
        try {
            this.f6230h.removeTextChangedListener(this.f6229g0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f6233i0 = m4276i();
        PhoneNumberValidityChangeListener phoneNumberValidityChangeListener = this.f6242n0;
        if (phoneNumberValidityChangeListener != null) {
            phoneNumberValidityChangeListener.m4262a(this.f6233i0);
        }
        this.f6229g0 = new C1442c();
        this.f6230h.addTextChangedListener(this.f6229g0);
    }

    public void setArrowSize(int i) {
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f6234j.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i;
            this.f6234j.setLayoutParams(layoutParams);
        }
    }

    public void setAutoDetectedCountry(boolean z) {
        boolean z2 = false;
        for (int i = 0; i < this.f6253t.f6281a.length(); i++) {
            try {
                switch (this.f6253t.f6281a.charAt(i)) {
                    case '1':
                        Log.d(f6191y0, "setAutoDetectedCountry: Setting using SIM");
                        z2 = m4283c(false);
                        String str = f6191y0;
                        Log.d(str, "setAutoDetectedCountry: Result of sim country detection:" + z2 + " current country:" + getSelectedCountryNameCode());
                        break;
                    case '2':
                        Log.d(f6191y0, "setAutoDetectedCountry: Setting using NETWORK");
                        z2 = m4285b(false);
                        String str2 = f6191y0;
                        Log.d(str2, "setAutoDetectedCountry: Result of network country detection:" + z2 + " current country:" + getSelectedCountryNameCode());
                        break;
                    case '3':
                        Log.d(f6191y0, "setAutoDetectedCountry: Setting using LOCALE");
                        z2 = m4290a(false);
                        String str3 = f6191y0;
                        Log.d(str3, "setAutoDetectedCountry: Result of LOCALE country detection:" + z2 + " current country:" + getSelectedCountryNameCode());
                        break;
                }
                if (z2) {
                    if (z2 && z) {
                        m4270o();
                        return;
                    }
                }
                if (this.f6244o0 != null) {
                    this.f6244o0.m4264a();
                }
            } catch (Exception e) {
                e.printStackTrace();
                String str4 = f6191y0;
                Log.w(str4, "setAutoDetectCountry: Exception" + e.getMessage());
                if (z) {
                    m4270o();
                    return;
                }
                return;
            }
        }
        if (z2) {
        }
    }

    public void setCcpClickable(boolean z) {
        this.f6217a0 = z;
        if (!z) {
            this.f6247q.setOnClickListener(null);
            this.f6247q.setClickable(false);
            this.f6247q.setEnabled(false);
            return;
        }
        this.f6247q.setOnClickListener(this.f6258v0);
        this.f6247q.setClickable(true);
        this.f6247q.setEnabled(true);
    }

    public void setCcpDialogShowNameCode(boolean z) {
        this.f6199G = z;
    }

    public void setCcpDialogShowPhoneCode(boolean z) {
        this.f6261x = z;
    }

    public void setContentColor(int i) {
        this.f6202J = i;
        this.f6228g.setTextColor(this.f6202J);
        this.f6234j.setColorFilter(this.f6202J, PorterDuff.Mode.SRC_IN);
    }

    public void setCountryAutoDetectionPref(AutoDetectionPref autoDetectionPref) {
        this.f6253t = autoDetectionPref;
    }

    public void setCountryForNameCode(String str) {
        CCPCountry m4327a = CCPCountry.m4327a(getContext(), getLanguageToApply(), str);
        if (m4327a == null) {
            if (this.f6245p == null) {
                this.f6245p = CCPCountry.m4326a(getContext(), getLanguageToApply(), this.f6206N, this.f6218b);
            }
            setSelectedCountry(this.f6245p);
            return;
        }
        setSelectedCountry(m4327a);
    }

    public void setCountryForPhoneCode(int i) {
        CCPCountry m4326a = CCPCountry.m4326a(getContext(), getLanguageToApply(), this.f6206N, i);
        if (m4326a == null) {
            if (this.f6245p == null) {
                this.f6245p = CCPCountry.m4326a(getContext(), getLanguageToApply(), this.f6206N, this.f6218b);
            }
            setSelectedCountry(this.f6245p);
            return;
        }
        setSelectedCountry(m4326a);
    }

    public void setCountryPreference(String str) {
        this.f6208P = str;
    }

    public void setCurrentTextGravity(TextGravity textGravity) {
        this.f6251s = textGravity;
        m4298a(textGravity.f6323a);
    }

    public void setCustomMasterCountries(String str) {
        this.f6211S = str;
    }

    public void setCustomMasterCountriesList(List<CCPCountry> list) {
        this.f6210R = list;
    }

    public void setDefaultCountryUsingNameCode(String str) {
        CCPCountry m4327a = CCPCountry.m4327a(getContext(), getLanguageToApply(), str);
        if (m4327a == null) {
            return;
        }
        this.f6220c = m4327a.m4307e();
        setDefaultCountry(m4327a);
    }

    @Deprecated
    public void setDefaultCountryUsingPhoneCode(int i) {
        CCPCountry m4326a = CCPCountry.m4326a(getContext(), getLanguageToApply(), this.f6206N, i);
        if (m4326a == null) {
            return;
        }
        this.f6218b = i;
        setDefaultCountry(m4326a);
    }

    public void setDetectCountryWithAreaCode(boolean z) {
        this.f6198F = z;
        m4269p();
    }

    public void setDialogBackgroundColor(int i) {
        this.f6250r0 = i;
    }

    public void setDialogEventsListener(DialogEventsListener dialogEventsListener) {
        this.f6246p0 = dialogEventsListener;
    }

    public void setDialogKeyboardAutoPopup(boolean z) {
        this.f6215W = z;
    }

    public void setDialogSearchEditTextTintColor(int i) {
        this.f6254t0 = i;
    }

    public void setDialogTextColor(int i) {
        this.f6252s0 = i;
    }

    public void setDialogTypeFace(Typeface typeface) {
        try {
            this.f6204L = typeface;
            this.f6205M = -99;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEditText_registeredCarrierNumber(EditText editText) {
        this.f6230h = editText;
        String str = f6191y0;
        Log.d(str, "setEditText_registeredCarrierNumber: carrierEditTextAttached " + this.f6201I);
        m4266s();
        m4269p();
        m4268q();
    }

    public void setExcludedCountries(String str) {
        this.f6212T = str;
        m4272m();
    }

    public void setFastScrollerBubbleColor(int i) {
        this.f6209Q = i;
    }

    public void setFastScrollerBubbleTextAppearance(int i) {
        this.f6256u0 = i;
    }

    public void setFastScrollerHandleColor(int i) {
        this.f6248q0 = i;
    }

    public void setFlagBorderColor(int i) {
        this.f6203K = i;
        this.f6239m.setBackgroundColor(this.f6203K);
    }

    public void setFlagSize(int i) {
        this.f6236k.getLayoutParams().height = i;
        this.f6236k.requestLayout();
    }

    public void setFullNumber(String str) {
        CCPCountry m4313c = CCPCountry.m4313c(getContext(), getLanguageToApply(), this.f6206N, str);
        if (m4313c == null) {
            m4313c = getDefaultCountry();
        }
        setSelectedCountry(m4313c);
        String m4291a = m4291a(str, m4313c);
        if (getEditText_registeredCarrierNumber() != null) {
            getEditText_registeredCarrierNumber().setText(m4291a);
            m4269p();
            return;
        }
        Log.w(f6191y0, "EditText for carrier number is not registered. Register it using registerCarrierNumberEditText() before getFullNumber() or setFullNumber().");
    }

    public void setHintExampleNumberEnabled(boolean z) {
        this.f6225e0 = z;
        m4268q();
    }

    public void setHintExampleNumberType(PhoneNumberType phoneNumberType) {
        this.f6200H = phoneNumberType;
        m4268q();
    }

    public void setImageViewFlag(ImageView imageView) {
        this.f6236k = imageView;
    }

    public void setLanguageToApply(Language language) {
        this.f6214V = language;
    }

    public void setNumberAutoFormattingEnabled(boolean z) {
        this.f6223d0 = z;
        if (this.f6230h != null) {
            m4269p();
        }
    }

    public void setOnCountryChangeListener(OnCountryChangeListener onCountryChangeListener) {
        this.f6240m0 = onCountryChangeListener;
    }

    public void setPhoneNumberValidityChangeListener(PhoneNumberValidityChangeListener phoneNumberValidityChangeListener) {
        this.f6242n0 = phoneNumberValidityChangeListener;
        if (this.f6230h != null) {
            this.f6233i0 = m4276i();
            phoneNumberValidityChangeListener.m4262a(this.f6233i0);
        }
    }

    public void setSearchAllowed(boolean z) {
        this.f6194B = z;
    }

    public void setSelectedCountry(CCPCountry cCPCountry) {
        this.f6237k0 = false;
        String str = "";
        this.f6238l0 = "";
        if (cCPCountry == null) {
            cCPCountry = CCPCountry.m4326a(getContext(), getLanguageToApply(), this.f6206N, this.f6218b);
        }
        this.f6243o = cCPCountry;
        if (this.f6264z) {
            str = "" + cCPCountry.m4311d();
        }
        if (this.f6257v) {
            if (this.f6264z) {
                str = str + " (" + cCPCountry.m4307e().toUpperCase() + ")";
            } else {
                str = str + " " + cCPCountry.m4307e().toUpperCase();
            }
        }
        if (this.f6259w) {
            if (str.length() > 0) {
                str = str + "  ";
            }
            str = str + "+" + cCPCountry.m4304f();
        }
        this.f6228g.setText(str);
        if (!this.f6263y && str.length() == 0) {
            this.f6228g.setText(str + "+" + cCPCountry.m4304f());
        }
        OnCountryChangeListener onCountryChangeListener = this.f6240m0;
        if (onCountryChangeListener != null) {
            onCountryChangeListener.mo789a();
        }
        this.f6236k.setImageResource(cCPCountry.m4315c());
        m4269p();
        m4268q();
        if (this.f6230h != null && this.f6242n0 != null) {
            this.f6233i0 = m4276i();
            this.f6242n0.m4262a(this.f6233i0);
        }
        this.f6237k0 = true;
        if (this.f6262x0) {
            try {
                this.f6230h.setSelection(this.f6260w0);
                this.f6262x0 = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setShowFastScroller(boolean z) {
        this.f6193A = z;
    }

    public void setShowPhoneCode(boolean z) {
        this.f6259w = z;
        setSelectedCountry(this.f6243o);
    }

    public void setTextSize(int i) {
        if (i > 0) {
            this.f6228g.setTextSize(0, i);
            setArrowSize(i);
            setFlagSize(i);
        }
    }

    public void setTextView_selectedCountry(TextView textView) {
        this.f6228g = textView;
    }

    public void setTypeFace(Typeface typeface) {
        try {
            this.f6228g.setTypeface(typeface);
            setDialogTypeFace(typeface);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m4297a(AttributeSet attributeSet) {
        boolean z;
        int color;
        int color2;
        TypedArray obtainStyledAttributes = this.f6222d.getTheme().obtainStyledAttributes(attributeSet, C1444R.styleable.CountryCodePicker, 0, 0);
        try {
            try {
                this.f6257v = obtainStyledAttributes.getBoolean(C1444R.styleable.CountryCodePicker_ccp_showNameCode, true);
                this.f6223d0 = obtainStyledAttributes.getBoolean(C1444R.styleable.CountryCodePicker_ccp_autoFormatNumber, true);
                this.f6259w = obtainStyledAttributes.getBoolean(C1444R.styleable.CountryCodePicker_ccp_showPhoneCode, true);
                this.f6261x = obtainStyledAttributes.getBoolean(C1444R.styleable.CountryCodePicker_ccpDialog_showPhoneCode, this.f6259w);
                this.f6199G = obtainStyledAttributes.getBoolean(C1444R.styleable.CountryCodePicker_ccpDialog_showNameCode, true);
                this.f6264z = obtainStyledAttributes.getBoolean(C1444R.styleable.CountryCodePicker_ccp_showFullName, false);
                this.f6193A = obtainStyledAttributes.getBoolean(C1444R.styleable.CountryCodePicker_ccpDialog_showFastScroller, true);
                this.f6209Q = obtainStyledAttributes.getColor(C1444R.styleable.CountryCodePicker_ccpDialog_fastScroller_bubbleColor, 0);
                this.f6248q0 = obtainStyledAttributes.getColor(C1444R.styleable.CountryCodePicker_ccpDialog_fastScroller_handleColor, 0);
                this.f6256u0 = obtainStyledAttributes.getResourceId(C1444R.styleable.CountryCodePicker_ccpDialog_fastScroller_bubbleTextAppearance, 0);
                this.f6219b0 = obtainStyledAttributes.getBoolean(C1444R.styleable.CountryCodePicker_ccp_autoDetectLanguage, false);
                this.f6198F = obtainStyledAttributes.getBoolean(C1444R.styleable.CountryCodePicker_ccp_areaCodeDetectedCountry, true);
                this.f6197E = obtainStyledAttributes.getBoolean(C1444R.styleable.CountryCodePicker_ccp_rememberLastSelection, false);
                this.f6225e0 = obtainStyledAttributes.getBoolean(C1444R.styleable.CountryCodePicker_ccp_hintExampleNumber, false);
                this.f6200H = PhoneNumberType.values()[obtainStyledAttributes.getInt(C1444R.styleable.CountryCodePicker_ccp_hintExampleNumberType, 0)];
                this.f6201I = obtainStyledAttributes.getString(C1444R.styleable.CountryCodePicker_ccp_selectionMemoryTag);
                if (this.f6201I == null) {
                    this.f6201I = "CCP_last_selection";
                }
                this.f6253t = AutoDetectionPref.m4265a(String.valueOf(obtainStyledAttributes.getInt(C1444R.styleable.CountryCodePicker_ccp_countryAutoDetectionPref, 123)));
                this.f6221c0 = obtainStyledAttributes.getBoolean(C1444R.styleable.CountryCodePicker_ccp_autoDetectCountry, false);
                this.f6195C = obtainStyledAttributes.getBoolean(C1444R.styleable.CountryCodePicker_ccp_showArrow, true);
                m4273l();
                this.f6196D = obtainStyledAttributes.getBoolean(C1444R.styleable.CountryCodePicker_ccpDialog_showCloseIcon, false);
                m4281d(obtainStyledAttributes.getBoolean(C1444R.styleable.CountryCodePicker_ccp_showFlag, true));
                setDialogKeyboardAutoPopup(obtainStyledAttributes.getBoolean(C1444R.styleable.CountryCodePicker_ccpDialog_keyboardAutoPopup, true));
                this.f6213U = m4288b(obtainStyledAttributes.getInt(C1444R.styleable.CountryCodePicker_ccp_defaultLanguage, Language.ENGLISH.ordinal()));
                m4267r();
                this.f6211S = obtainStyledAttributes.getString(C1444R.styleable.CountryCodePicker_ccp_customMasterCountries);
                this.f6212T = obtainStyledAttributes.getString(C1444R.styleable.CountryCodePicker_ccp_excludedCountries);
                if (!isInEditMode()) {
                    m4272m();
                }
                this.f6208P = obtainStyledAttributes.getString(C1444R.styleable.CountryCodePicker_ccp_countryPreference);
                if (!isInEditMode()) {
                    m4271n();
                }
                if (obtainStyledAttributes.hasValue(C1444R.styleable.CountryCodePicker_ccp_textGravity)) {
                    this.f6207O = obtainStyledAttributes.getInt(C1444R.styleable.CountryCodePicker_ccp_textGravity, f6188A0);
                }
                m4298a(this.f6207O);
                this.f6220c = obtainStyledAttributes.getString(C1444R.styleable.CountryCodePicker_ccp_defaultNameCode);
                if (this.f6220c == null || this.f6220c.length() == 0) {
                    z = false;
                } else {
                    if (!isInEditMode()) {
                        if (CCPCountry.m4327a(getContext(), getLanguageToApply(), this.f6220c) != null) {
                            setDefaultCountry(CCPCountry.m4327a(getContext(), getLanguageToApply(), this.f6220c));
                            setSelectedCountry(this.f6245p);
                            z = true;
                        }
                        z = false;
                    } else {
                        if (CCPCountry.m4301g(this.f6220c) != null) {
                            setDefaultCountry(CCPCountry.m4301g(this.f6220c));
                            setSelectedCountry(this.f6245p);
                            z = true;
                        }
                        z = false;
                    }
                    if (!z) {
                        setDefaultCountry(CCPCountry.m4301g("IN"));
                        setSelectedCountry(this.f6245p);
                        z = true;
                    }
                }
                int integer = obtainStyledAttributes.getInteger(C1444R.styleable.CountryCodePicker_ccp_defaultPhoneCode, -1);
                if (!z && integer != -1) {
                    if (!isInEditMode()) {
                        if (integer != -1 && CCPCountry.m4326a(getContext(), getLanguageToApply(), this.f6206N, integer) == null) {
                            integer = f6192z0;
                        }
                        setDefaultCountryUsingPhoneCode(integer);
                        setSelectedCountry(this.f6245p);
                    } else {
                        CCPCountry m4303f = CCPCountry.m4303f(integer + "");
                        if (m4303f == null) {
                            m4303f = CCPCountry.m4303f(f6192z0 + "");
                        }
                        setDefaultCountry(m4303f);
                        setSelectedCountry(m4303f);
                    }
                }
                if (getDefaultCountry() == null) {
                    setDefaultCountry(CCPCountry.m4301g("IN"));
                    if (getSelectedCountry() == null) {
                        setSelectedCountry(this.f6245p);
                    }
                }
                if (m4299a() && !isInEditMode()) {
                    setAutoDetectedCountry(true);
                }
                if (this.f6197E && !isInEditMode()) {
                    m4274k();
                }
                if (isInEditMode()) {
                    color = obtainStyledAttributes.getColor(C1444R.styleable.CountryCodePicker_ccp_contentColor, 0);
                } else {
                    color = obtainStyledAttributes.getColor(C1444R.styleable.CountryCodePicker_ccp_contentColor, this.f6222d.getResources().getColor(C1444R.color.defaultContentColor));
                }
                if (color != 0) {
                    setContentColor(color);
                }
                if (isInEditMode()) {
                    color2 = obtainStyledAttributes.getColor(C1444R.styleable.CountryCodePicker_ccp_flagBorderColor, 0);
                } else {
                    color2 = obtainStyledAttributes.getColor(C1444R.styleable.CountryCodePicker_ccp_flagBorderColor, this.f6222d.getResources().getColor(C1444R.color.defaultBorderFlagColor));
                }
                if (color2 != 0) {
                    setFlagBorderColor(color2);
                }
                setDialogBackgroundColor(obtainStyledAttributes.getColor(C1444R.styleable.CountryCodePicker_ccpDialog_backgroundColor, 0));
                setDialogTextColor(obtainStyledAttributes.getColor(C1444R.styleable.CountryCodePicker_ccpDialog_textColor, 0));
                setDialogSearchEditTextTintColor(obtainStyledAttributes.getColor(C1444R.styleable.CountryCodePicker_ccpDialog_searchEditTextTint, 0));
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C1444R.styleable.CountryCodePicker_ccp_textSize, 0);
                if (dimensionPixelSize > 0) {
                    this.f6228g.setTextSize(0, dimensionPixelSize);
                    setFlagSize(dimensionPixelSize);
                    setArrowSize(dimensionPixelSize);
                }
                int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(C1444R.styleable.CountryCodePicker_ccp_arrowSize, 0);
                if (dimensionPixelSize2 > 0) {
                    setArrowSize(dimensionPixelSize2);
                }
                this.f6194B = obtainStyledAttributes.getBoolean(C1444R.styleable.CountryCodePicker_ccpDialog_allowSearch, true);
                setCcpClickable(obtainStyledAttributes.getBoolean(C1444R.styleable.CountryCodePicker_ccp_clickable, true));
            } catch (Exception e) {
                this.f6228g.setTextSize(10.0f);
                this.f6228g.setText(e.toString());
            }
            obtainStyledAttributes.recycle();
            String str = f6191y0;
            Log.d(str, "end:xmlWidth " + this.f6227f0);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* renamed from: b */
    public final void m4287b(AttributeSet attributeSet) {
        this.f6226f = LayoutInflater.from(this.f6222d);
        this.f6227f0 = attributeSet.getAttributeValue(f6190C0, "layout_width");
        String str = f6191y0;
        Log.d(str, "init:xmlWidth " + this.f6227f0);
        removeAllViewsInLayout();
        String str2 = this.f6227f0;
        if (str2 != null && (str2.equals("-1") || this.f6227f0.equals("-1") || this.f6227f0.equals("fill_parent") || this.f6227f0.equals("match_parent"))) {
            this.f6224e = this.f6226f.inflate(C1444R.layout.layout_full_width_code_picker, (ViewGroup) this, true);
        } else {
            this.f6224e = this.f6226f.inflate(C1444R.layout.layout_code_picker, (ViewGroup) this, true);
        }
        this.f6228g = (TextView) this.f6224e.findViewById(C1444R.C1446id.textView_selectedCountry);
        this.f6232i = (RelativeLayout) this.f6224e.findViewById(C1444R.C1446id.countryCodeHolder);
        this.f6234j = (ImageView) this.f6224e.findViewById(C1444R.C1446id.imageView_arrow);
        this.f6236k = (ImageView) this.f6224e.findViewById(C1444R.C1446id.image_flag);
        this.f6241n = (LinearLayout) this.f6224e.findViewById(C1444R.C1446id.linear_flag_holder);
        this.f6239m = (LinearLayout) this.f6224e.findViewById(C1444R.C1446id.linear_flag_border);
        this.f6247q = (RelativeLayout) this.f6224e.findViewById(C1444R.C1446id.rlClickConsumer);
        this.f6249r = this;
        m4297a(attributeSet);
        this.f6247q.setOnClickListener(this.f6258v0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
        m4270o();
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m4283c(boolean r5) {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = r4.f6222d     // Catch: java.lang.Exception -> L2f
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
            com.hbb20.CCPCountry r1 = com.hbb20.CCPCountry.m4327a(r2, r3, r1)     // Catch: java.lang.Exception -> L2f
            r4.setSelectedCountry(r1)     // Catch: java.lang.Exception -> L2f
            r5 = 1
            return r5
        L29:
            if (r5 == 0) goto L2e
            r4.m4270o()     // Catch: java.lang.Exception -> L2f
        L2e:
            return r0
        L2f:
            r1 = move-exception
            r1.printStackTrace()
            if (r5 == 0) goto L38
            r4.m4270o()
        L38:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbb20.CountryCodePicker.m4283c(boolean):boolean");
    }

    /* renamed from: d */
    public void m4281d(boolean z) {
        this.f6263y = z;
        if (z) {
            this.f6241n.setVisibility(0);
        } else {
            this.f6241n.setVisibility(8);
        }
    }

    public void setPhoneNumberValidityChangeListener(FailureListener failureListener) {
        this.f6244o0 = failureListener;
    }

    /* renamed from: b */
    public boolean m4289b() {
        return this.f6219b0;
    }

    /* renamed from: b */
    public final Language m4288b(int i) {
        if (i < Language.values().length) {
            return Language.values()[i];
        }
        return Language.ENGLISH;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
        m4270o();
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m4285b(boolean r5) {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = r4.f6222d     // Catch: java.lang.Exception -> L2f
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
            com.hbb20.CCPCountry r1 = com.hbb20.CCPCountry.m4327a(r2, r3, r1)     // Catch: java.lang.Exception -> L2f
            r4.setSelectedCountry(r1)     // Catch: java.lang.Exception -> L2f
            r5 = 1
            return r5
        L29:
            if (r5 == 0) goto L2e
            r4.m4270o()     // Catch: java.lang.Exception -> L2f
        L2e:
            return r0
        L2f:
            r1 = move-exception
            r1.printStackTrace()
            if (r5 == 0) goto L38
            r4.m4270o()
        L38:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbb20.CountryCodePicker.m4285b(boolean):boolean");
    }

    public CountryCodePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6216a = "CCP_PREF_FILE";
        this.f6257v = false;
        this.f6259w = true;
        this.f6261x = true;
        this.f6263y = true;
        this.f6264z = false;
        this.f6194B = true;
        this.f6195C = true;
        this.f6196D = false;
        this.f6197E = false;
        this.f6198F = true;
        this.f6199G = true;
        this.f6200H = PhoneNumberType.MOBILE;
        this.f6201I = "ccp_last_selection";
        this.f6207O = f6189B0;
        this.f6209Q = 0;
        Language language = Language.ENGLISH;
        this.f6213U = language;
        this.f6214V = language;
        this.f6215W = true;
        this.f6217a0 = true;
        this.f6227f0 = "notSet";
        this.f6238l0 = null;
        this.f6258v0 = new View$OnClickListenerC1440a();
        this.f6260w0 = 0;
        this.f6262x0 = false;
        this.f6222d = context;
        m4287b(attributeSet);
    }

    public CountryCodePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6216a = "CCP_PREF_FILE";
        this.f6257v = false;
        this.f6259w = true;
        this.f6261x = true;
        this.f6263y = true;
        this.f6264z = false;
        this.f6194B = true;
        this.f6195C = true;
        this.f6196D = false;
        this.f6197E = false;
        this.f6198F = true;
        this.f6199G = true;
        this.f6200H = PhoneNumberType.MOBILE;
        this.f6201I = "ccp_last_selection";
        this.f6207O = f6189B0;
        this.f6209Q = 0;
        Language language = Language.ENGLISH;
        this.f6213U = language;
        this.f6214V = language;
        this.f6215W = true;
        this.f6217a0 = true;
        this.f6227f0 = "notSet";
        this.f6238l0 = null;
        this.f6258v0 = new View$OnClickListenerC1440a();
        this.f6260w0 = 0;
        this.f6262x0 = false;
        this.f6222d = context;
        m4287b(attributeSet);
    }

    /* renamed from: a */
    public void m4292a(String str) {
        SharedPreferences.Editor edit = this.f6222d.getSharedPreferences(this.f6216a, 0).edit();
        edit.putString(this.f6201I, str);
        edit.apply();
    }

    /* renamed from: a */
    public final void m4298a(int i) {
        if (i == TextGravity.LEFT.f6323a) {
            this.f6228g.setGravity(3);
        } else if (i == TextGravity.CENTER.f6323a) {
            this.f6228g.setGravity(17);
        } else {
            this.f6228g.setGravity(5);
        }
    }

    /* renamed from: a */
    public boolean m4299a() {
        return this.f6221c0;
    }

    /* renamed from: a */
    public final boolean m4294a(CCPCountry cCPCountry, List<CCPCountry> list) {
        if (cCPCountry == null || list == null) {
            return false;
        }
        for (CCPCountry cCPCountry2 : list) {
            if (cCPCountry2.m4307e().equalsIgnoreCase(cCPCountry.m4307e())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final String m4291a(String str, CCPCountry cCPCountry) {
        int indexOf;
        return (cCPCountry == null || str == null || str.isEmpty() || (indexOf = str.indexOf(cCPCountry.m4304f())) == -1) ? str : str.substring(indexOf + cCPCountry.m4304f().length());
    }

    /* renamed from: a */
    public void m4296a(EditText editText) {
        setEditText_registeredCarrierNumber(editText);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
        m4270o();
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m4290a(boolean r5) {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = r4.f6222d     // Catch: java.lang.Exception -> L31
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
            com.hbb20.CCPCountry r1 = com.hbb20.CCPCountry.m4327a(r2, r3, r1)     // Catch: java.lang.Exception -> L31
            r4.setSelectedCountry(r1)     // Catch: java.lang.Exception -> L31
            r5 = 1
            return r5
        L2b:
            if (r5 == 0) goto L30
            r4.m4270o()     // Catch: java.lang.Exception -> L31
        L30:
            return r0
        L31:
            r1 = move-exception
            r1.printStackTrace()
            if (r5 == 0) goto L3a
            r4.m4270o()
        L3a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbb20.CountryCodePicker.m4290a(boolean):boolean");
    }

    /* renamed from: a */
    public void m4295a(CCPCountry cCPCountry) {
        CountryCodePicker countryCodePicker = this.f6249r;
        if (countryCodePicker.f6197E) {
            countryCodePicker.m4292a(cCPCountry.m4307e());
        }
        setSelectedCountry(cCPCountry);
    }
}
