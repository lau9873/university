package com.hbb20;

import android.content.Context;
import android.util.Log;
import com.hbb20.CountryCodePicker;
import com.j256.ormlite.android.AndroidLog;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import com.j256.ormlite.logger.Logger;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CCPCountry implements Comparable<CCPCountry> {

    /* renamed from: A */
    public static String f6154A = "664";

    /* renamed from: B */
    public static String f6155B = "787";

    /* renamed from: C */
    public static String f6156C = "721";

    /* renamed from: D */
    public static String f6157D = "649";

    /* renamed from: E */
    public static String f6158E = "868";

    /* renamed from: F */
    public static String f6159F = "784";

    /* renamed from: G */
    public static String f6160G = "284";

    /* renamed from: H */
    public static String f6161H = "340";

    /* renamed from: I */
    public static String f6162I = "1624";

    /* renamed from: f */
    public static int f6163f = -99;

    /* renamed from: g */
    public static String f6164g = "Class Country";

    /* renamed from: h */
    public static CountryCodePicker.Language f6165h = null;

    /* renamed from: i */
    public static String f6166i = null;

    /* renamed from: j */
    public static String f6167j = null;

    /* renamed from: k */
    public static String f6168k = null;

    /* renamed from: m */
    public static List<CCPCountry> f6169m = null;

    /* renamed from: n */
    public static String f6170n = "268";

    /* renamed from: o */
    public static String f6171o = "264";

    /* renamed from: p */
    public static String f6172p = "246";

    /* renamed from: q */
    public static String f6173q = "441";

    /* renamed from: r */
    public static String f6174r = "242";

    /* renamed from: s */
    public static String f6175s = "204/226/236/249/250/289/306/343/365/403/416/418/431/437/438/450/506/514/519/579/581/587/600/601/604/613/639/647/705/709/769/778/780/782/807/819/825/867/873/902/905/";

    /* renamed from: t */
    public static String f6176t = "767";

    /* renamed from: u */
    public static String f6177u = "809/829/849";

    /* renamed from: v */
    public static String f6178v = "473";

    /* renamed from: w */
    public static String f6179w = "876";

    /* renamed from: x */
    public static String f6180x = "869";

    /* renamed from: y */
    public static String f6181y = "345";

    /* renamed from: z */
    public static String f6182z = "758";

    /* renamed from: a */
    public String f6183a;

    /* renamed from: b */
    public String f6184b;

    /* renamed from: c */
    public String f6185c;

    /* renamed from: d */
    public String f6186d;

    /* renamed from: e */
    public int f6187e;

    public CCPCountry() {
        this.f6187e = f6163f;
    }

    /* renamed from: a */
    public static String m4328a(Context context, CountryCodePicker.Language language) {
        String str;
        CountryCodePicker.Language language2 = f6165h;
        if (language2 == null || language2 != language || (str = f6166i) == null || str.length() == 0) {
            m4306e(context, language);
        }
        return f6166i;
    }

    /* renamed from: b */
    public static CCPCountry m4318b(Context context, CountryCodePicker.Language language, List<CCPCountry> list, String str) {
        if (list != null && !list.isEmpty()) {
            for (CCPCountry cCPCountry : list) {
                if (cCPCountry.m4304f().equals(str)) {
                    return cCPCountry;
                }
            }
        }
        for (CCPCountry cCPCountry2 : m4319b(context, language)) {
            if (cCPCountry2.m4304f().equals(str)) {
                return cCPCountry2;
            }
        }
        return null;
    }

    /* renamed from: c */
    public static String m4314c(Context context, CountryCodePicker.Language language) {
        String str;
        CountryCodePicker.Language language2 = f6165h;
        if (language2 == null || language2 != language || (str = f6168k) == null || str.length() == 0) {
            m4306e(context, language);
        }
        return f6168k;
    }

    /* renamed from: d */
    public static String m4310d(Context context, CountryCodePicker.Language language) {
        String str;
        CountryCodePicker.Language language2 = f6165h;
        if (language2 == null || language2 != language || (str = f6167j) == null || str.length() == 0) {
            m4306e(context, language);
        }
        return f6167j;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00fc  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m4306e(android.content.Context r8, com.hbb20.CountryCodePicker.Language r9) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbb20.CCPCountry.m4306e(android.content.Context, com.hbb20.CountryCodePicker$Language):void");
    }

    /* renamed from: f */
    public static CCPCountry m4303f(String str) {
        for (CCPCountry cCPCountry : m4300h()) {
            if (cCPCountry.m4304f().equals(str)) {
                return cCPCountry;
            }
        }
        return null;
    }

    /* renamed from: g */
    public static CCPCountry m4301g(String str) {
        for (CCPCountry cCPCountry : m4300h()) {
            if (cCPCountry.m4307e().equalsIgnoreCase(str)) {
                return cCPCountry;
            }
        }
        return null;
    }

    /* renamed from: h */
    public static List<CCPCountry> m4300h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CCPCountry("ad", "376", "Andorra", f6163f));
        arrayList.add(new CCPCountry("ae", "971", "United Arab Emirates (UAE)", f6163f));
        arrayList.add(new CCPCountry("af", "93", "Afghanistan", f6163f));
        arrayList.add(new CCPCountry("ag", "1", "Antigua and Barbuda", f6163f));
        arrayList.add(new CCPCountry("ai", "1", "Anguilla", f6163f));
        arrayList.add(new CCPCountry("al", "355", "Albania", f6163f));
        arrayList.add(new CCPCountry("am", "374", "Armenia", f6163f));
        arrayList.add(new CCPCountry("ao", "244", "Angola", f6163f));
        arrayList.add(new CCPCountry("aq", "672", "Antarctica", f6163f));
        arrayList.add(new CCPCountry("ar", "54", "Argentina", f6163f));
        arrayList.add(new CCPCountry("at", "43", "Austria", f6163f));
        arrayList.add(new CCPCountry("au", "61", "Australia", f6163f));
        arrayList.add(new CCPCountry("aw", "297", "Aruba", f6163f));
        arrayList.add(new CCPCountry("az", "994", "Azerbaijan", f6163f));
        arrayList.add(new CCPCountry("ba", "387", "Bosnia And Herzegovina", f6163f));
        arrayList.add(new CCPCountry("bb", "1", "Barbados", f6163f));
        arrayList.add(new CCPCountry("bd", "880", "Bangladesh", f6163f));
        arrayList.add(new CCPCountry("be", "32", "Belgium", f6163f));
        arrayList.add(new CCPCountry("bf", "226", "Burkina Faso", f6163f));
        arrayList.add(new CCPCountry("bg", "359", "Bulgaria", f6163f));
        arrayList.add(new CCPCountry("bh", "973", "Bahrain", f6163f));
        arrayList.add(new CCPCountry("bi", "257", "Burundi", f6163f));
        arrayList.add(new CCPCountry("bj", "229", "Benin", f6163f));
        arrayList.add(new CCPCountry("bl", "590", "Saint Barthélemy", f6163f));
        arrayList.add(new CCPCountry("bm", "1", "Bermuda", f6163f));
        arrayList.add(new CCPCountry("bn", "673", "Brunei Darussalam", f6163f));
        arrayList.add(new CCPCountry("bo", "591", "Bolivia, Plurinational State Of", f6163f));
        arrayList.add(new CCPCountry("br", "55", "Brazil", f6163f));
        arrayList.add(new CCPCountry("bs", "1", "Bahamas", f6163f));
        arrayList.add(new CCPCountry("bt", "975", "Bhutan", f6163f));
        arrayList.add(new CCPCountry("bw", "267", "Botswana", f6163f));
        arrayList.add(new CCPCountry("by", "375", "Belarus", f6163f));
        arrayList.add(new CCPCountry("bz", "501", "Belize", f6163f));
        arrayList.add(new CCPCountry("ca", "1", "Canada", f6163f));
        arrayList.add(new CCPCountry("cc", "61", "Cocos (keeling) Islands", f6163f));
        arrayList.add(new CCPCountry("cd", "243", "Congo, The Democratic Republic Of The", f6163f));
        arrayList.add(new CCPCountry("cf", "236", "Central African Republic", f6163f));
        arrayList.add(new CCPCountry("cg", "242", "Congo", f6163f));
        arrayList.add(new CCPCountry("ch", "41", "Switzerland", f6163f));
        arrayList.add(new CCPCountry("ci", "225", "Côte D'ivoire", f6163f));
        arrayList.add(new CCPCountry("ck", "682", "Cook Islands", f6163f));
        arrayList.add(new CCPCountry("cl", "56", "Chile", f6163f));
        arrayList.add(new CCPCountry("cm", "237", "Cameroon", f6163f));
        arrayList.add(new CCPCountry("cn", "86", "China", f6163f));
        arrayList.add(new CCPCountry("co", "57", "Colombia", f6163f));
        arrayList.add(new CCPCountry("cr", "506", "Costa Rica", f6163f));
        arrayList.add(new CCPCountry("cu", "53", "Cuba", f6163f));
        arrayList.add(new CCPCountry("cv", "238", "Cape Verde", f6163f));
        arrayList.add(new CCPCountry("cx", "61", "Christmas Island", f6163f));
        arrayList.add(new CCPCountry("cy", "357", "Cyprus", f6163f));
        arrayList.add(new CCPCountry("cz", "420", "Czech Republic", f6163f));
        arrayList.add(new CCPCountry("de", "49", "Germany", f6163f));
        arrayList.add(new CCPCountry("dj", "253", "Djibouti", f6163f));
        arrayList.add(new CCPCountry("dk", "45", "Denmark", f6163f));
        arrayList.add(new CCPCountry("dm", "1", "Dominica", f6163f));
        arrayList.add(new CCPCountry("do", "1", "Dominican Republic", f6163f));
        arrayList.add(new CCPCountry("dz", "213", "Algeria", f6163f));
        arrayList.add(new CCPCountry("ec", "593", "Ecuador", f6163f));
        arrayList.add(new CCPCountry("ee", "372", "Estonia", f6163f));
        arrayList.add(new CCPCountry("eg", "20", "Egypt", f6163f));
        arrayList.add(new CCPCountry("er", "291", "Eritrea", f6163f));
        arrayList.add(new CCPCountry("es", "34", "Spain", f6163f));
        arrayList.add(new CCPCountry("et", "251", "Ethiopia", f6163f));
        arrayList.add(new CCPCountry("fi", "358", "Finland", f6163f));
        arrayList.add(new CCPCountry("fj", "679", "Fiji", f6163f));
        arrayList.add(new CCPCountry("fk", "500", "Falkland Islands (malvinas)", f6163f));
        arrayList.add(new CCPCountry("fm", "691", "Micronesia, Federated States Of", f6163f));
        arrayList.add(new CCPCountry("fo", "298", "Faroe Islands", f6163f));
        arrayList.add(new CCPCountry("fr", "33", "France", f6163f));
        arrayList.add(new CCPCountry("ga", "241", "Gabon", f6163f));
        arrayList.add(new CCPCountry("gb", "44", "United Kingdom", f6163f));
        arrayList.add(new CCPCountry("gd", "1", "Grenada", f6163f));
        arrayList.add(new CCPCountry("ge", "995", "Georgia", f6163f));
        arrayList.add(new CCPCountry("gf", "594", "French Guyana", f6163f));
        arrayList.add(new CCPCountry("gh", "233", "Ghana", f6163f));
        arrayList.add(new CCPCountry("gi", "350", "Gibraltar", f6163f));
        arrayList.add(new CCPCountry("gl", "299", "Greenland", f6163f));
        arrayList.add(new CCPCountry("gm", "220", "Gambia", f6163f));
        arrayList.add(new CCPCountry("gn", "224", "Guinea", f6163f));
        arrayList.add(new CCPCountry("gp", "450", "Guadeloupe", f6163f));
        arrayList.add(new CCPCountry("gq", "240", "Equatorial Guinea", f6163f));
        arrayList.add(new CCPCountry("gr", "30", "Greece", f6163f));
        arrayList.add(new CCPCountry("gt", "502", "Guatemala", f6163f));
        arrayList.add(new CCPCountry("gw", "245", "Guinea-bissau", f6163f));
        arrayList.add(new CCPCountry("gy", "592", "Guyana", f6163f));
        arrayList.add(new CCPCountry("hk", "852", "Hong Kong", f6163f));
        arrayList.add(new CCPCountry("hn", "504", "Honduras", f6163f));
        arrayList.add(new CCPCountry("hr", "385", "Croatia", f6163f));
        arrayList.add(new CCPCountry("ht", "509", "Haiti", f6163f));
        arrayList.add(new CCPCountry("hu", "36", "Hungary", f6163f));
        arrayList.add(new CCPCountry(DatabaseFieldConfigLoader.FIELD_NAME_ID, "62", "Indonesia", f6163f));
        arrayList.add(new CCPCountry("ie", "353", "Ireland", f6163f));
        arrayList.add(new CCPCountry("il", "972", "Israel", f6163f));
        arrayList.add(new CCPCountry("im", "44", "Isle Of Man", f6163f));
        arrayList.add(new CCPCountry("is", "354", "Iceland", f6163f));
        arrayList.add(new CCPCountry("in", "91", "India", f6163f));
        arrayList.add(new CCPCountry("iq", "964", "Iraq", f6163f));
        arrayList.add(new CCPCountry("ir", "98", "Iran, Islamic Republic Of", f6163f));
        arrayList.add(new CCPCountry("it", "39", "Italy", f6163f));
        arrayList.add(new CCPCountry("jm", "1", "Jamaica", f6163f));
        arrayList.add(new CCPCountry("jo", "962", "Jordan", f6163f));
        arrayList.add(new CCPCountry("jp", "81", "Japan", f6163f));
        arrayList.add(new CCPCountry("ke", "254", "Kenya", f6163f));
        arrayList.add(new CCPCountry("kg", "996", "Kyrgyzstan", f6163f));
        arrayList.add(new CCPCountry("kh", "855", "Cambodia", f6163f));
        arrayList.add(new CCPCountry("ki", "686", "Kiribati", f6163f));
        arrayList.add(new CCPCountry("km", "269", "Comoros", f6163f));
        arrayList.add(new CCPCountry("kn", "1", "Saint Kitts and Nevis", f6163f));
        arrayList.add(new CCPCountry("kp", "850", "North Korea", f6163f));
        arrayList.add(new CCPCountry("kr", "82", "South Korea", f6163f));
        arrayList.add(new CCPCountry("kw", "965", "Kuwait", f6163f));
        arrayList.add(new CCPCountry("ky", "1", "Cayman Islands", f6163f));
        arrayList.add(new CCPCountry("kz", "7", "Kazakhstan", f6163f));
        arrayList.add(new CCPCountry("la", "856", "Lao People's Democratic Republic", f6163f));
        arrayList.add(new CCPCountry("lb", "961", "Lebanon", f6163f));
        arrayList.add(new CCPCountry("lc", "1", "Saint Lucia", f6163f));
        arrayList.add(new CCPCountry("li", "423", "Liechtenstein", f6163f));
        arrayList.add(new CCPCountry("lk", "94", "Sri Lanka", f6163f));
        arrayList.add(new CCPCountry("lr", "231", "Liberia", f6163f));
        arrayList.add(new CCPCountry("ls", "266", "Lesotho", f6163f));
        arrayList.add(new CCPCountry("lt", "370", "Lithuania", f6163f));
        arrayList.add(new CCPCountry("lu", "352", "Luxembourg", f6163f));
        arrayList.add(new CCPCountry("lv", "371", "Latvia", f6163f));
        arrayList.add(new CCPCountry("ly", "218", "Libya", f6163f));
        arrayList.add(new CCPCountry("ma", "212", "Morocco", f6163f));
        arrayList.add(new CCPCountry("mc", "377", "Monaco", f6163f));
        arrayList.add(new CCPCountry("md", "373", "Moldova, Republic Of", f6163f));
        arrayList.add(new CCPCountry("me", "382", "Montenegro", f6163f));
        arrayList.add(new CCPCountry("mg", "261", "Madagascar", f6163f));
        arrayList.add(new CCPCountry("mh", "692", "Marshall Islands", f6163f));
        arrayList.add(new CCPCountry("mk", "389", "Macedonia, The Former Yugoslav Republic Of", f6163f));
        arrayList.add(new CCPCountry("ml", "223", "Mali", f6163f));
        arrayList.add(new CCPCountry("mm", "95", "Myanmar", f6163f));
        arrayList.add(new CCPCountry("mn", "976", "Mongolia", f6163f));
        arrayList.add(new CCPCountry("mo", "853", "Macao", f6163f));
        arrayList.add(new CCPCountry("mq", "596", "Martinique", f6163f));
        arrayList.add(new CCPCountry("mr", "222", "Mauritania", f6163f));
        arrayList.add(new CCPCountry("ms", "1", "Montserrat", f6163f));
        arrayList.add(new CCPCountry("mt", "356", "Malta", f6163f));
        arrayList.add(new CCPCountry("mu", "230", "Mauritius", f6163f));
        arrayList.add(new CCPCountry("mv", "960", "Maldives", f6163f));
        arrayList.add(new CCPCountry("mw", "265", "Malawi", f6163f));
        arrayList.add(new CCPCountry("mx", "52", "Mexico", f6163f));
        arrayList.add(new CCPCountry("my", "60", "Malaysia", f6163f));
        arrayList.add(new CCPCountry("mz", "258", "Mozambique", f6163f));
        arrayList.add(new CCPCountry("na", "264", "Namibia", f6163f));
        arrayList.add(new CCPCountry("nc", "687", "New Caledonia", f6163f));
        arrayList.add(new CCPCountry("ne", "227", "Niger", f6163f));
        arrayList.add(new CCPCountry("ng", "234", "Nigeria", f6163f));
        arrayList.add(new CCPCountry("ni", "505", "Nicaragua", f6163f));
        arrayList.add(new CCPCountry("nl", "31", "Netherlands", f6163f));
        arrayList.add(new CCPCountry("no", "47", "Norway", f6163f));
        arrayList.add(new CCPCountry("np", "977", "Nepal", f6163f));
        arrayList.add(new CCPCountry("nr", "674", "Nauru", f6163f));
        arrayList.add(new CCPCountry("nu", "683", "Niue", f6163f));
        arrayList.add(new CCPCountry("nz", "64", "New Zealand", f6163f));
        arrayList.add(new CCPCountry("om", "968", "Oman", f6163f));
        arrayList.add(new CCPCountry("pa", "507", "Panama", f6163f));
        arrayList.add(new CCPCountry("pe", "51", "Peru", f6163f));
        arrayList.add(new CCPCountry("pf", "689", "French Polynesia", f6163f));
        arrayList.add(new CCPCountry("pg", "675", "Papua New Guinea", f6163f));
        arrayList.add(new CCPCountry("ph", "63", "Philippines", f6163f));
        arrayList.add(new CCPCountry("pk", "92", "Pakistan", f6163f));
        arrayList.add(new CCPCountry("pl", "48", "Poland", f6163f));
        arrayList.add(new CCPCountry("pm", "508", "Saint Pierre And Miquelon", f6163f));
        arrayList.add(new CCPCountry("pn", "870", "Pitcairn", f6163f));
        arrayList.add(new CCPCountry("pr", "1", "Puerto Rico", f6163f));
        arrayList.add(new CCPCountry("ps", "970", "Palestine", f6163f));
        arrayList.add(new CCPCountry("pt", "351", "Portugal", f6163f));
        arrayList.add(new CCPCountry("pw", "680", "Palau", f6163f));
        arrayList.add(new CCPCountry("py", "595", "Paraguay", f6163f));
        arrayList.add(new CCPCountry("qa", "974", "Qatar", f6163f));
        arrayList.add(new CCPCountry("re", "262", "Réunion", f6163f));
        arrayList.add(new CCPCountry("ro", "40", "Romania", f6163f));
        arrayList.add(new CCPCountry("rs", "381", "Serbia", f6163f));
        arrayList.add(new CCPCountry("ru", "7", "Russian Federation", f6163f));
        arrayList.add(new CCPCountry("rw", "250", "Rwanda", f6163f));
        arrayList.add(new CCPCountry("sa", "966", "Saudi Arabia", f6163f));
        arrayList.add(new CCPCountry("sb", "677", "Solomon Islands", f6163f));
        arrayList.add(new CCPCountry("sc", "248", "Seychelles", f6163f));
        arrayList.add(new CCPCountry("sd", "249", "Sudan", f6163f));
        arrayList.add(new CCPCountry("se", "46", "Sweden", f6163f));
        arrayList.add(new CCPCountry("sg", "65", "Singapore", f6163f));
        arrayList.add(new CCPCountry("sh", "290", "Saint Helena, Ascension And Tristan Da Cunha", f6163f));
        arrayList.add(new CCPCountry("si", "386", "Slovenia", f6163f));
        arrayList.add(new CCPCountry("sk", "421", "Slovakia", f6163f));
        arrayList.add(new CCPCountry("sl", "232", "Sierra Leone", f6163f));
        arrayList.add(new CCPCountry("sm", "378", "San Marino", f6163f));
        arrayList.add(new CCPCountry("sn", "221", "Senegal", f6163f));
        arrayList.add(new CCPCountry("so", "252", "Somalia", f6163f));
        arrayList.add(new CCPCountry("sr", "597", "Suriname", f6163f));
        arrayList.add(new CCPCountry("st", "239", "Sao Tome And Principe", f6163f));
        arrayList.add(new CCPCountry("sv", "503", "El Salvador", f6163f));
        arrayList.add(new CCPCountry("sx", "1", "Sint Maarten", f6163f));
        arrayList.add(new CCPCountry("sy", "963", "Syrian Arab Republic", f6163f));
        arrayList.add(new CCPCountry("sz", "268", "Swaziland", f6163f));
        arrayList.add(new CCPCountry("tc", "1", "Turks and Caicos Islands", f6163f));
        arrayList.add(new CCPCountry("td", "235", "Chad", f6163f));
        arrayList.add(new CCPCountry("tg", "228", "Togo", f6163f));
        arrayList.add(new CCPCountry("th", "66", "Thailand", f6163f));
        arrayList.add(new CCPCountry("tj", "992", "Tajikistan", f6163f));
        arrayList.add(new CCPCountry("tk", "690", "Tokelau", f6163f));
        arrayList.add(new CCPCountry("tl", "670", "Timor-leste", f6163f));
        arrayList.add(new CCPCountry("tm", "993", "Turkmenistan", f6163f));
        arrayList.add(new CCPCountry("tn", "216", "Tunisia", f6163f));
        arrayList.add(new CCPCountry("to", "676", "Tonga", f6163f));
        arrayList.add(new CCPCountry("tr", "90", "Turkey", f6163f));
        arrayList.add(new CCPCountry("tt", "1", "Trinidad &amp; Tobago", f6163f));
        arrayList.add(new CCPCountry("tv", "688", "Tuvalu", f6163f));
        arrayList.add(new CCPCountry("tw", "886", "Taiwan", f6163f));
        arrayList.add(new CCPCountry("tz", "255", "Tanzania, United Republic Of", f6163f));
        arrayList.add(new CCPCountry("ua", "380", "Ukraine", f6163f));
        arrayList.add(new CCPCountry("ug", "256", "Uganda", f6163f));
        arrayList.add(new CCPCountry("us", "1", "United States", f6163f));
        arrayList.add(new CCPCountry("uy", "598", "Uruguay", f6163f));
        arrayList.add(new CCPCountry("uz", "998", "Uzbekistan", f6163f));
        arrayList.add(new CCPCountry("va", "379", "Holy See (vatican City State)", f6163f));
        arrayList.add(new CCPCountry("vc", "1", "Saint Vincent &amp; The Grenadines", f6163f));
        arrayList.add(new CCPCountry("ve", "58", "Venezuela, Bolivarian Republic Of", f6163f));
        arrayList.add(new CCPCountry("vg", "1", "British Virgin Islands", f6163f));
        arrayList.add(new CCPCountry("vi", "1", "US Virgin Islands", f6163f));
        arrayList.add(new CCPCountry("vn", "84", "Viet Nam", f6163f));
        arrayList.add(new CCPCountry("vu", "678", "Vanuatu", f6163f));
        arrayList.add(new CCPCountry("wf", "681", "Wallis And Futuna", f6163f));
        arrayList.add(new CCPCountry("ws", "685", "Samoa", f6163f));
        arrayList.add(new CCPCountry("xk", "383", "Kosovo", f6163f));
        arrayList.add(new CCPCountry("ye", "967", "Yemen", f6163f));
        arrayList.add(new CCPCountry("yt", "262", "Mayotte", f6163f));
        arrayList.add(new CCPCountry("za", "27", "South Africa", f6163f));
        arrayList.add(new CCPCountry("zm", "260", "Zambia", f6163f));
        arrayList.add(new CCPCountry("zw", "263", "Zimbabwe", f6163f));
        return arrayList;
    }

    public CCPCountry(String str, String str2, String str3, int i) {
        this.f6187e = f6163f;
        this.f6183a = str;
        this.f6184b = str2;
        this.f6185c = str3;
        this.f6187e = i;
    }

    /* renamed from: a */
    public static List<CCPCountry> m4324a(Context context, CountryCodePicker countryCodePicker) {
        countryCodePicker.m4272m();
        List<CCPCountry> list = countryCodePicker.f6210R;
        if (list != null && list.size() > 0) {
            return countryCodePicker.getCustomMasterCountriesList();
        }
        return m4319b(context, countryCodePicker.getLanguageToApply());
    }

    /* renamed from: c */
    public static CCPCountry m4313c(Context context, CountryCodePicker.Language language, List<CCPCountry> list, String str) {
        if (str.length() != 0) {
            int i = str.charAt(0) == '+' ? 1 : 0;
            for (int i2 = i; i2 < i + 4; i2++) {
                String substring = str.substring(i, i2);
                if (substring.equals("1")) {
                    return m4309d(context, language, list, str);
                }
                if (substring.equals("44")) {
                    CCPCountry m4325a = m4325a(context, language, list, str);
                    return m4325a != null ? m4325a : m4318b(context, language, list, substring);
                }
                CCPCountry m4318b = m4318b(context, language, list, substring);
                if (m4318b != null) {
                    return m4318b;
                }
            }
            return null;
        }
        return null;
    }

    /* renamed from: d */
    public static CCPCountry m4309d(Context context, CountryCodePicker.Language language, List<CCPCountry> list, String str) {
        String str2;
        String str3 = "";
        String replace = str.replace("+", "");
        if (replace.length() >= 4 && replace.charAt(0) == '1') {
            str3 = replace.substring(1, 4);
        }
        if (str3.length() != 3) {
            return m4318b(context, language, list, "1");
        }
        if (f6170n.contains(str3)) {
            str2 = "ag";
        } else if (f6171o.contains(str3)) {
            str2 = "ai";
        } else if (f6172p.contains(str3)) {
            str2 = "bb";
        } else if (f6173q.contains(str3)) {
            str2 = "bm";
        } else if (f6174r.contains(str3)) {
            str2 = "bs";
        } else if (f6175s.contains(str3)) {
            str2 = "ca";
        } else if (f6176t.contains(str3)) {
            str2 = "dm";
        } else if (f6177u.contains(str3)) {
            str2 = "do";
        } else if (f6178v.contains(str3)) {
            str2 = "gd";
        } else if (f6179w.contains(str3)) {
            str2 = "jm";
        } else if (f6180x.contains(str3)) {
            str2 = "kn";
        } else if (f6181y.contains(str3)) {
            str2 = "ky";
        } else if (f6182z.contains(str3)) {
            str2 = "lc";
        } else if (f6154A.contains(str3)) {
            str2 = "ms";
        } else if (f6155B.contains(str3)) {
            str2 = "pr";
        } else if (f6156C.contains(str3)) {
            str2 = "sx";
        } else if (f6157D.contains(str3)) {
            str2 = "tc";
        } else if (f6158E.contains(str3)) {
            str2 = "tt";
        } else if (f6159F.contains(str3)) {
            str2 = "vc";
        } else if (f6160G.contains(str3)) {
            str2 = "vg";
        } else {
            str2 = f6161H.contains(str3) ? "vi" : "us";
        }
        return m4327a(context, language, str2);
    }

    /* renamed from: f */
    public String m4304f() {
        return this.f6184b;
    }

    /* renamed from: g */
    public void m4302g() {
        try {
            String str = f6164g;
            Log.d(str, "Country->" + this.f6183a + ":" + this.f6184b + ":" + this.f6185c);
        } catch (NullPointerException unused) {
            Log.d(f6164g, "Null");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: b */
    public static int m4317b(CCPCountry cCPCountry) {
        char c;
        String lowerCase = cCPCountry.m4307e().toLowerCase();
        switch (lowerCase.hashCode()) {
            case 3107:
                if (lowerCase.equals("ad")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 3108:
                if (lowerCase.equals("ae")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3109:
                if (lowerCase.equals("af")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 3110:
                if (lowerCase.equals("ag")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 3112:
                if (lowerCase.equals("ai")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 3115:
                if (lowerCase.equals("al")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 3116:
                if (lowerCase.equals("am")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 3118:
                if (lowerCase.equals("ao")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 3120:
                if (lowerCase.equals("aq")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 3121:
                if (lowerCase.equals("ar")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 3123:
                if (lowerCase.equals("at")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 3124:
                if (lowerCase.equals("au")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 3126:
                if (lowerCase.equals("aw")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 3129:
                if (lowerCase.equals("az")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 3135:
                if (lowerCase.equals("ba")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 3136:
                if (lowerCase.equals("bb")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 3138:
                if (lowerCase.equals("bd")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 3139:
                if (lowerCase.equals("be")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 3140:
                if (lowerCase.equals("bf")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 3141:
                if (lowerCase.equals("bg")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 3142:
                if (lowerCase.equals("bh")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 3143:
                if (lowerCase.equals("bi")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 3144:
                if (lowerCase.equals("bj")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case 3146:
                if (lowerCase.equals("bl")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case 3147:
                if (lowerCase.equals("bm")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            case 3148:
                if (lowerCase.equals("bn")) {
                    c = 25;
                    break;
                }
                c = 65535;
                break;
            case 3149:
                if (lowerCase.equals("bo")) {
                    c = 26;
                    break;
                }
                c = 65535;
                break;
            case 3152:
                if (lowerCase.equals("br")) {
                    c = 27;
                    break;
                }
                c = 65535;
                break;
            case 3153:
                if (lowerCase.equals("bs")) {
                    c = 28;
                    break;
                }
                c = 65535;
                break;
            case 3154:
                if (lowerCase.equals("bt")) {
                    c = 29;
                    break;
                }
                c = 65535;
                break;
            case 3157:
                if (lowerCase.equals("bw")) {
                    c = 30;
                    break;
                }
                c = 65535;
                break;
            case 3159:
                if (lowerCase.equals("by")) {
                    c = 31;
                    break;
                }
                c = 65535;
                break;
            case 3160:
                if (lowerCase.equals("bz")) {
                    c = ' ';
                    break;
                }
                c = 65535;
                break;
            case 3166:
                if (lowerCase.equals("ca")) {
                    c = '!';
                    break;
                }
                c = 65535;
                break;
            case 3168:
                if (lowerCase.equals("cc")) {
                    c = '\"';
                    break;
                }
                c = 65535;
                break;
            case 3169:
                if (lowerCase.equals("cd")) {
                    c = '#';
                    break;
                }
                c = 65535;
                break;
            case 3171:
                if (lowerCase.equals("cf")) {
                    c = '$';
                    break;
                }
                c = 65535;
                break;
            case 3172:
                if (lowerCase.equals("cg")) {
                    c = '%';
                    break;
                }
                c = 65535;
                break;
            case 3173:
                if (lowerCase.equals("ch")) {
                    c = '&';
                    break;
                }
                c = 65535;
                break;
            case 3174:
                if (lowerCase.equals("ci")) {
                    c = '\'';
                    break;
                }
                c = 65535;
                break;
            case 3176:
                if (lowerCase.equals("ck")) {
                    c = '(';
                    break;
                }
                c = 65535;
                break;
            case 3177:
                if (lowerCase.equals("cl")) {
                    c = ')';
                    break;
                }
                c = 65535;
                break;
            case 3178:
                if (lowerCase.equals("cm")) {
                    c = '*';
                    break;
                }
                c = 65535;
                break;
            case 3179:
                if (lowerCase.equals("cn")) {
                    c = '+';
                    break;
                }
                c = 65535;
                break;
            case 3180:
                if (lowerCase.equals("co")) {
                    c = ',';
                    break;
                }
                c = 65535;
                break;
            case 3183:
                if (lowerCase.equals("cr")) {
                    c = '-';
                    break;
                }
                c = 65535;
                break;
            case 3186:
                if (lowerCase.equals("cu")) {
                    c = '.';
                    break;
                }
                c = 65535;
                break;
            case 3187:
                if (lowerCase.equals("cv")) {
                    c = '/';
                    break;
                }
                c = 65535;
                break;
            case 3189:
                if (lowerCase.equals("cx")) {
                    c = '0';
                    break;
                }
                c = 65535;
                break;
            case 3190:
                if (lowerCase.equals("cy")) {
                    c = '1';
                    break;
                }
                c = 65535;
                break;
            case 3191:
                if (lowerCase.equals("cz")) {
                    c = '2';
                    break;
                }
                c = 65535;
                break;
            case 3201:
                if (lowerCase.equals("de")) {
                    c = '3';
                    break;
                }
                c = 65535;
                break;
            case 3206:
                if (lowerCase.equals("dj")) {
                    c = '4';
                    break;
                }
                c = 65535;
                break;
            case 3207:
                if (lowerCase.equals("dk")) {
                    c = '5';
                    break;
                }
                c = 65535;
                break;
            case 3209:
                if (lowerCase.equals("dm")) {
                    c = '6';
                    break;
                }
                c = 65535;
                break;
            case 3211:
                if (lowerCase.equals("do")) {
                    c = '7';
                    break;
                }
                c = 65535;
                break;
            case 3222:
                if (lowerCase.equals("dz")) {
                    c = '8';
                    break;
                }
                c = 65535;
                break;
            case 3230:
                if (lowerCase.equals("ec")) {
                    c = '9';
                    break;
                }
                c = 65535;
                break;
            case 3232:
                if (lowerCase.equals("ee")) {
                    c = ':';
                    break;
                }
                c = 65535;
                break;
            case 3234:
                if (lowerCase.equals("eg")) {
                    c = ';';
                    break;
                }
                c = 65535;
                break;
            case 3245:
                if (lowerCase.equals("er")) {
                    c = '<';
                    break;
                }
                c = 65535;
                break;
            case 3246:
                if (lowerCase.equals("es")) {
                    c = '=';
                    break;
                }
                c = 65535;
                break;
            case 3247:
                if (lowerCase.equals("et")) {
                    c = '>';
                    break;
                }
                c = 65535;
                break;
            case 3267:
                if (lowerCase.equals("fi")) {
                    c = '?';
                    break;
                }
                c = 65535;
                break;
            case 3268:
                if (lowerCase.equals("fj")) {
                    c = '@';
                    break;
                }
                c = 65535;
                break;
            case 3269:
                if (lowerCase.equals("fk")) {
                    c = 'A';
                    break;
                }
                c = 65535;
                break;
            case 3271:
                if (lowerCase.equals("fm")) {
                    c = 'B';
                    break;
                }
                c = 65535;
                break;
            case 3273:
                if (lowerCase.equals("fo")) {
                    c = 'C';
                    break;
                }
                c = 65535;
                break;
            case 3276:
                if (lowerCase.equals("fr")) {
                    c = 'D';
                    break;
                }
                c = 65535;
                break;
            case 3290:
                if (lowerCase.equals("ga")) {
                    c = 'E';
                    break;
                }
                c = 65535;
                break;
            case 3291:
                if (lowerCase.equals("gb")) {
                    c = 'F';
                    break;
                }
                c = 65535;
                break;
            case 3293:
                if (lowerCase.equals("gd")) {
                    c = 'G';
                    break;
                }
                c = 65535;
                break;
            case 3294:
                if (lowerCase.equals("ge")) {
                    c = 'H';
                    break;
                }
                c = 65535;
                break;
            case 3295:
                if (lowerCase.equals("gf")) {
                    c = 'I';
                    break;
                }
                c = 65535;
                break;
            case 3297:
                if (lowerCase.equals("gh")) {
                    c = 'J';
                    break;
                }
                c = 65535;
                break;
            case 3298:
                if (lowerCase.equals("gi")) {
                    c = 'K';
                    break;
                }
                c = 65535;
                break;
            case 3301:
                if (lowerCase.equals("gl")) {
                    c = 'L';
                    break;
                }
                c = 65535;
                break;
            case 3302:
                if (lowerCase.equals("gm")) {
                    c = 'M';
                    break;
                }
                c = 65535;
                break;
            case 3303:
                if (lowerCase.equals("gn")) {
                    c = 'N';
                    break;
                }
                c = 65535;
                break;
            case 3305:
                if (lowerCase.equals("gp")) {
                    c = 'O';
                    break;
                }
                c = 65535;
                break;
            case 3306:
                if (lowerCase.equals("gq")) {
                    c = 'P';
                    break;
                }
                c = 65535;
                break;
            case 3307:
                if (lowerCase.equals("gr")) {
                    c = 'Q';
                    break;
                }
                c = 65535;
                break;
            case 3309:
                if (lowerCase.equals("gt")) {
                    c = 'R';
                    break;
                }
                c = 65535;
                break;
            case 3312:
                if (lowerCase.equals("gw")) {
                    c = 'S';
                    break;
                }
                c = 65535;
                break;
            case 3314:
                if (lowerCase.equals("gy")) {
                    c = 'T';
                    break;
                }
                c = 65535;
                break;
            case 3331:
                if (lowerCase.equals("hk")) {
                    c = 'U';
                    break;
                }
                c = 65535;
                break;
            case 3334:
                if (lowerCase.equals("hn")) {
                    c = 'V';
                    break;
                }
                c = 65535;
                break;
            case 3338:
                if (lowerCase.equals("hr")) {
                    c = 'W';
                    break;
                }
                c = 65535;
                break;
            case 3340:
                if (lowerCase.equals("ht")) {
                    c = 'X';
                    break;
                }
                c = 65535;
                break;
            case 3341:
                if (lowerCase.equals("hu")) {
                    c = 'Y';
                    break;
                }
                c = 65535;
                break;
            case 3355:
                if (lowerCase.equals(DatabaseFieldConfigLoader.FIELD_NAME_ID)) {
                    c = 'Z';
                    break;
                }
                c = 65535;
                break;
            case 3356:
                if (lowerCase.equals("ie")) {
                    c = '[';
                    break;
                }
                c = 65535;
                break;
            case 3363:
                if (lowerCase.equals("il")) {
                    c = '\\';
                    break;
                }
                c = 65535;
                break;
            case 3364:
                if (lowerCase.equals("im")) {
                    c = ']';
                    break;
                }
                c = 65535;
                break;
            case 3365:
                if (lowerCase.equals("in")) {
                    c = '_';
                    break;
                }
                c = 65535;
                break;
            case 3368:
                if (lowerCase.equals("iq")) {
                    c = '`';
                    break;
                }
                c = 65535;
                break;
            case 3369:
                if (lowerCase.equals("ir")) {
                    c = 'a';
                    break;
                }
                c = 65535;
                break;
            case 3370:
                if (lowerCase.equals("is")) {
                    c = '^';
                    break;
                }
                c = 65535;
                break;
            case 3371:
                if (lowerCase.equals("it")) {
                    c = 'b';
                    break;
                }
                c = 65535;
                break;
            case 3395:
                if (lowerCase.equals("jm")) {
                    c = 'c';
                    break;
                }
                c = 65535;
                break;
            case 3397:
                if (lowerCase.equals("jo")) {
                    c = 'd';
                    break;
                }
                c = 65535;
                break;
            case 3398:
                if (lowerCase.equals("jp")) {
                    c = 'e';
                    break;
                }
                c = 65535;
                break;
            case 3418:
                if (lowerCase.equals("ke")) {
                    c = 'f';
                    break;
                }
                c = 65535;
                break;
            case 3420:
                if (lowerCase.equals("kg")) {
                    c = 'g';
                    break;
                }
                c = 65535;
                break;
            case 3421:
                if (lowerCase.equals("kh")) {
                    c = 'h';
                    break;
                }
                c = 65535;
                break;
            case 3422:
                if (lowerCase.equals("ki")) {
                    c = 'i';
                    break;
                }
                c = 65535;
                break;
            case 3426:
                if (lowerCase.equals("km")) {
                    c = 'j';
                    break;
                }
                c = 65535;
                break;
            case 3427:
                if (lowerCase.equals("kn")) {
                    c = 'k';
                    break;
                }
                c = 65535;
                break;
            case 3429:
                if (lowerCase.equals("kp")) {
                    c = 'l';
                    break;
                }
                c = 65535;
                break;
            case 3431:
                if (lowerCase.equals("kr")) {
                    c = 'm';
                    break;
                }
                c = 65535;
                break;
            case 3436:
                if (lowerCase.equals("kw")) {
                    c = 'n';
                    break;
                }
                c = 65535;
                break;
            case 3438:
                if (lowerCase.equals("ky")) {
                    c = 'o';
                    break;
                }
                c = 65535;
                break;
            case 3439:
                if (lowerCase.equals("kz")) {
                    c = 'p';
                    break;
                }
                c = 65535;
                break;
            case 3445:
                if (lowerCase.equals("la")) {
                    c = 'q';
                    break;
                }
                c = 65535;
                break;
            case 3446:
                if (lowerCase.equals("lb")) {
                    c = 'r';
                    break;
                }
                c = 65535;
                break;
            case 3447:
                if (lowerCase.equals("lc")) {
                    c = 's';
                    break;
                }
                c = 65535;
                break;
            case 3453:
                if (lowerCase.equals("li")) {
                    c = 't';
                    break;
                }
                c = 65535;
                break;
            case 3455:
                if (lowerCase.equals("lk")) {
                    c = 'u';
                    break;
                }
                c = 65535;
                break;
            case 3462:
                if (lowerCase.equals("lr")) {
                    c = 'v';
                    break;
                }
                c = 65535;
                break;
            case 3463:
                if (lowerCase.equals("ls")) {
                    c = 'w';
                    break;
                }
                c = 65535;
                break;
            case 3464:
                if (lowerCase.equals("lt")) {
                    c = 'x';
                    break;
                }
                c = 65535;
                break;
            case 3465:
                if (lowerCase.equals("lu")) {
                    c = 'y';
                    break;
                }
                c = 65535;
                break;
            case 3466:
                if (lowerCase.equals("lv")) {
                    c = 'z';
                    break;
                }
                c = 65535;
                break;
            case 3469:
                if (lowerCase.equals("ly")) {
                    c = '{';
                    break;
                }
                c = 65535;
                break;
            case 3476:
                if (lowerCase.equals("ma")) {
                    c = '|';
                    break;
                }
                c = 65535;
                break;
            case 3478:
                if (lowerCase.equals("mc")) {
                    c = '}';
                    break;
                }
                c = 65535;
                break;
            case 3479:
                if (lowerCase.equals("md")) {
                    c = '~';
                    break;
                }
                c = 65535;
                break;
            case 3480:
                if (lowerCase.equals("me")) {
                    c = 127;
                    break;
                }
                c = 65535;
                break;
            case 3482:
                if (lowerCase.equals("mg")) {
                    c = 128;
                    break;
                }
                c = 65535;
                break;
            case 3483:
                if (lowerCase.equals("mh")) {
                    c = 129;
                    break;
                }
                c = 65535;
                break;
            case 3486:
                if (lowerCase.equals("mk")) {
                    c = 130;
                    break;
                }
                c = 65535;
                break;
            case 3487:
                if (lowerCase.equals("ml")) {
                    c = 131;
                    break;
                }
                c = 65535;
                break;
            case 3488:
                if (lowerCase.equals("mm")) {
                    c = 132;
                    break;
                }
                c = 65535;
                break;
            case 3489:
                if (lowerCase.equals("mn")) {
                    c = 133;
                    break;
                }
                c = 65535;
                break;
            case 3490:
                if (lowerCase.equals("mo")) {
                    c = 134;
                    break;
                }
                c = 65535;
                break;
            case 3492:
                if (lowerCase.equals("mq")) {
                    c = 135;
                    break;
                }
                c = 65535;
                break;
            case 3493:
                if (lowerCase.equals("mr")) {
                    c = 136;
                    break;
                }
                c = 65535;
                break;
            case 3494:
                if (lowerCase.equals("ms")) {
                    c = 137;
                    break;
                }
                c = 65535;
                break;
            case 3495:
                if (lowerCase.equals("mt")) {
                    c = 138;
                    break;
                }
                c = 65535;
                break;
            case 3496:
                if (lowerCase.equals("mu")) {
                    c = 139;
                    break;
                }
                c = 65535;
                break;
            case 3497:
                if (lowerCase.equals("mv")) {
                    c = 140;
                    break;
                }
                c = 65535;
                break;
            case 3498:
                if (lowerCase.equals("mw")) {
                    c = 141;
                    break;
                }
                c = 65535;
                break;
            case 3499:
                if (lowerCase.equals("mx")) {
                    c = 142;
                    break;
                }
                c = 65535;
                break;
            case 3500:
                if (lowerCase.equals("my")) {
                    c = 143;
                    break;
                }
                c = 65535;
                break;
            case 3501:
                if (lowerCase.equals("mz")) {
                    c = 144;
                    break;
                }
                c = 65535;
                break;
            case 3507:
                if (lowerCase.equals("na")) {
                    c = 145;
                    break;
                }
                c = 65535;
                break;
            case 3509:
                if (lowerCase.equals("nc")) {
                    c = 146;
                    break;
                }
                c = 65535;
                break;
            case 3511:
                if (lowerCase.equals("ne")) {
                    c = 147;
                    break;
                }
                c = 65535;
                break;
            case 3513:
                if (lowerCase.equals("ng")) {
                    c = 148;
                    break;
                }
                c = 65535;
                break;
            case 3515:
                if (lowerCase.equals("ni")) {
                    c = 149;
                    break;
                }
                c = 65535;
                break;
            case 3518:
                if (lowerCase.equals("nl")) {
                    c = 150;
                    break;
                }
                c = 65535;
                break;
            case 3521:
                if (lowerCase.equals("no")) {
                    c = 151;
                    break;
                }
                c = 65535;
                break;
            case 3522:
                if (lowerCase.equals("np")) {
                    c = 152;
                    break;
                }
                c = 65535;
                break;
            case 3524:
                if (lowerCase.equals("nr")) {
                    c = 153;
                    break;
                }
                c = 65535;
                break;
            case 3527:
                if (lowerCase.equals("nu")) {
                    c = 154;
                    break;
                }
                c = 65535;
                break;
            case 3532:
                if (lowerCase.equals("nz")) {
                    c = 155;
                    break;
                }
                c = 65535;
                break;
            case 3550:
                if (lowerCase.equals("om")) {
                    c = 156;
                    break;
                }
                c = 65535;
                break;
            case 3569:
                if (lowerCase.equals("pa")) {
                    c = 157;
                    break;
                }
                c = 65535;
                break;
            case 3573:
                if (lowerCase.equals("pe")) {
                    c = 158;
                    break;
                }
                c = 65535;
                break;
            case 3574:
                if (lowerCase.equals("pf")) {
                    c = 159;
                    break;
                }
                c = 65535;
                break;
            case 3575:
                if (lowerCase.equals("pg")) {
                    c = 160;
                    break;
                }
                c = 65535;
                break;
            case 3576:
                if (lowerCase.equals("ph")) {
                    c = 161;
                    break;
                }
                c = 65535;
                break;
            case 3579:
                if (lowerCase.equals("pk")) {
                    c = 162;
                    break;
                }
                c = 65535;
                break;
            case 3580:
                if (lowerCase.equals("pl")) {
                    c = 163;
                    break;
                }
                c = 65535;
                break;
            case 3581:
                if (lowerCase.equals("pm")) {
                    c = 164;
                    break;
                }
                c = 65535;
                break;
            case 3582:
                if (lowerCase.equals("pn")) {
                    c = 165;
                    break;
                }
                c = 65535;
                break;
            case 3586:
                if (lowerCase.equals("pr")) {
                    c = 166;
                    break;
                }
                c = 65535;
                break;
            case 3587:
                if (lowerCase.equals("ps")) {
                    c = 167;
                    break;
                }
                c = 65535;
                break;
            case 3588:
                if (lowerCase.equals("pt")) {
                    c = 168;
                    break;
                }
                c = 65535;
                break;
            case 3591:
                if (lowerCase.equals("pw")) {
                    c = 169;
                    break;
                }
                c = 65535;
                break;
            case 3593:
                if (lowerCase.equals("py")) {
                    c = 170;
                    break;
                }
                c = 65535;
                break;
            case 3600:
                if (lowerCase.equals("qa")) {
                    c = 171;
                    break;
                }
                c = 65535;
                break;
            case 3635:
                if (lowerCase.equals("re")) {
                    c = 172;
                    break;
                }
                c = 65535;
                break;
            case 3645:
                if (lowerCase.equals("ro")) {
                    c = 173;
                    break;
                }
                c = 65535;
                break;
            case 3649:
                if (lowerCase.equals("rs")) {
                    c = 174;
                    break;
                }
                c = 65535;
                break;
            case 3651:
                if (lowerCase.equals("ru")) {
                    c = 175;
                    break;
                }
                c = 65535;
                break;
            case 3653:
                if (lowerCase.equals("rw")) {
                    c = 176;
                    break;
                }
                c = 65535;
                break;
            case 3662:
                if (lowerCase.equals("sa")) {
                    c = 177;
                    break;
                }
                c = 65535;
                break;
            case 3663:
                if (lowerCase.equals("sb")) {
                    c = 178;
                    break;
                }
                c = 65535;
                break;
            case 3664:
                if (lowerCase.equals("sc")) {
                    c = 179;
                    break;
                }
                c = 65535;
                break;
            case 3665:
                if (lowerCase.equals("sd")) {
                    c = 180;
                    break;
                }
                c = 65535;
                break;
            case 3666:
                if (lowerCase.equals("se")) {
                    c = 181;
                    break;
                }
                c = 65535;
                break;
            case 3668:
                if (lowerCase.equals("sg")) {
                    c = 182;
                    break;
                }
                c = 65535;
                break;
            case 3669:
                if (lowerCase.equals("sh")) {
                    c = 183;
                    break;
                }
                c = 65535;
                break;
            case 3670:
                if (lowerCase.equals("si")) {
                    c = 184;
                    break;
                }
                c = 65535;
                break;
            case 3672:
                if (lowerCase.equals("sk")) {
                    c = 185;
                    break;
                }
                c = 65535;
                break;
            case 3673:
                if (lowerCase.equals("sl")) {
                    c = 186;
                    break;
                }
                c = 65535;
                break;
            case 3674:
                if (lowerCase.equals("sm")) {
                    c = 187;
                    break;
                }
                c = 65535;
                break;
            case 3675:
                if (lowerCase.equals("sn")) {
                    c = 188;
                    break;
                }
                c = 65535;
                break;
            case 3676:
                if (lowerCase.equals("so")) {
                    c = 189;
                    break;
                }
                c = 65535;
                break;
            case 3679:
                if (lowerCase.equals("sr")) {
                    c = 190;
                    break;
                }
                c = 65535;
                break;
            case 3681:
                if (lowerCase.equals("st")) {
                    c = 191;
                    break;
                }
                c = 65535;
                break;
            case 3683:
                if (lowerCase.equals("sv")) {
                    c = 192;
                    break;
                }
                c = 65535;
                break;
            case 3685:
                if (lowerCase.equals("sx")) {
                    c = 193;
                    break;
                }
                c = 65535;
                break;
            case 3686:
                if (lowerCase.equals("sy")) {
                    c = 194;
                    break;
                }
                c = 65535;
                break;
            case 3687:
                if (lowerCase.equals("sz")) {
                    c = 195;
                    break;
                }
                c = 65535;
                break;
            case 3695:
                if (lowerCase.equals("tc")) {
                    c = 196;
                    break;
                }
                c = 65535;
                break;
            case 3696:
                if (lowerCase.equals("td")) {
                    c = 197;
                    break;
                }
                c = 65535;
                break;
            case 3699:
                if (lowerCase.equals("tg")) {
                    c = 198;
                    break;
                }
                c = 65535;
                break;
            case 3700:
                if (lowerCase.equals("th")) {
                    c = 199;
                    break;
                }
                c = 65535;
                break;
            case 3702:
                if (lowerCase.equals("tj")) {
                    c = 200;
                    break;
                }
                c = 65535;
                break;
            case 3703:
                if (lowerCase.equals("tk")) {
                    c = 201;
                    break;
                }
                c = 65535;
                break;
            case 3704:
                if (lowerCase.equals("tl")) {
                    c = 202;
                    break;
                }
                c = 65535;
                break;
            case 3705:
                if (lowerCase.equals("tm")) {
                    c = 203;
                    break;
                }
                c = 65535;
                break;
            case 3706:
                if (lowerCase.equals("tn")) {
                    c = 204;
                    break;
                }
                c = 65535;
                break;
            case 3707:
                if (lowerCase.equals("to")) {
                    c = 205;
                    break;
                }
                c = 65535;
                break;
            case 3710:
                if (lowerCase.equals("tr")) {
                    c = 206;
                    break;
                }
                c = 65535;
                break;
            case 3712:
                if (lowerCase.equals("tt")) {
                    c = 207;
                    break;
                }
                c = 65535;
                break;
            case 3714:
                if (lowerCase.equals("tv")) {
                    c = 208;
                    break;
                }
                c = 65535;
                break;
            case 3715:
                if (lowerCase.equals("tw")) {
                    c = 209;
                    break;
                }
                c = 65535;
                break;
            case 3718:
                if (lowerCase.equals("tz")) {
                    c = 210;
                    break;
                }
                c = 65535;
                break;
            case 3724:
                if (lowerCase.equals("ua")) {
                    c = 211;
                    break;
                }
                c = 65535;
                break;
            case 3730:
                if (lowerCase.equals("ug")) {
                    c = 212;
                    break;
                }
                c = 65535;
                break;
            case 3742:
                if (lowerCase.equals("us")) {
                    c = 213;
                    break;
                }
                c = 65535;
                break;
            case 3748:
                if (lowerCase.equals("uy")) {
                    c = 214;
                    break;
                }
                c = 65535;
                break;
            case 3749:
                if (lowerCase.equals("uz")) {
                    c = 215;
                    break;
                }
                c = 65535;
                break;
            case 3755:
                if (lowerCase.equals("va")) {
                    c = 216;
                    break;
                }
                c = 65535;
                break;
            case 3757:
                if (lowerCase.equals("vc")) {
                    c = 217;
                    break;
                }
                c = 65535;
                break;
            case 3759:
                if (lowerCase.equals("ve")) {
                    c = 218;
                    break;
                }
                c = 65535;
                break;
            case 3761:
                if (lowerCase.equals("vg")) {
                    c = 219;
                    break;
                }
                c = 65535;
                break;
            case 3763:
                if (lowerCase.equals("vi")) {
                    c = 220;
                    break;
                }
                c = 65535;
                break;
            case 3768:
                if (lowerCase.equals("vn")) {
                    c = 221;
                    break;
                }
                c = 65535;
                break;
            case 3775:
                if (lowerCase.equals("vu")) {
                    c = 222;
                    break;
                }
                c = 65535;
                break;
            case 3791:
                if (lowerCase.equals("wf")) {
                    c = 223;
                    break;
                }
                c = 65535;
                break;
            case 3804:
                if (lowerCase.equals("ws")) {
                    c = 224;
                    break;
                }
                c = 65535;
                break;
            case 3827:
                if (lowerCase.equals("xk")) {
                    c = 225;
                    break;
                }
                c = 65535;
                break;
            case 3852:
                if (lowerCase.equals("ye")) {
                    c = 226;
                    break;
                }
                c = 65535;
                break;
            case 3867:
                if (lowerCase.equals("yt")) {
                    c = 227;
                    break;
                }
                c = 65535;
                break;
            case 3879:
                if (lowerCase.equals("za")) {
                    c = 228;
                    break;
                }
                c = 65535;
                break;
            case 3891:
                if (lowerCase.equals("zm")) {
                    c = 229;
                    break;
                }
                c = 65535;
                break;
            case 3901:
                if (lowerCase.equals("zw")) {
                    c = 230;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return C1444R.C1445drawable.flag_andorra;
            case 1:
                return C1444R.C1445drawable.flag_uae;
            case 2:
                return C1444R.C1445drawable.flag_afghanistan;
            case 3:
                return C1444R.C1445drawable.flag_antigua_and_barbuda;
            case 4:
                return C1444R.C1445drawable.flag_anguilla;
            case 5:
                return C1444R.C1445drawable.flag_albania;
            case 6:
                return C1444R.C1445drawable.flag_armenia;
            case 7:
                return C1444R.C1445drawable.flag_angola;
            case '\b':
                return C1444R.C1445drawable.flag_antarctica;
            case '\t':
                return C1444R.C1445drawable.flag_argentina;
            case '\n':
                return C1444R.C1445drawable.flag_austria;
            case 11:
                return C1444R.C1445drawable.flag_australia;
            case '\f':
                return C1444R.C1445drawable.flag_aruba;
            case '\r':
                return C1444R.C1445drawable.flag_azerbaijan;
            case 14:
                return C1444R.C1445drawable.flag_bosnia;
            case 15:
                return C1444R.C1445drawable.flag_barbados;
            case 16:
                return C1444R.C1445drawable.flag_bangladesh;
            case 17:
                return C1444R.C1445drawable.flag_belgium;
            case 18:
                return C1444R.C1445drawable.flag_burkina_faso;
            case 19:
                return C1444R.C1445drawable.flag_bulgaria;
            case 20:
                return C1444R.C1445drawable.flag_bahrain;
            case 21:
                return C1444R.C1445drawable.flag_burundi;
            case 22:
                return C1444R.C1445drawable.flag_benin;
            case 23:
                return C1444R.C1445drawable.flag_saint_barthelemy;
            case 24:
                return C1444R.C1445drawable.flag_bermuda;
            case 25:
                return C1444R.C1445drawable.flag_brunei;
            case 26:
                return C1444R.C1445drawable.flag_bolivia;
            case 27:
                return C1444R.C1445drawable.flag_brazil;
            case 28:
                return C1444R.C1445drawable.flag_bahamas;
            case 29:
                return C1444R.C1445drawable.flag_bhutan;
            case 30:
                return C1444R.C1445drawable.flag_botswana;
            case 31:
                return C1444R.C1445drawable.flag_belarus;
            case ' ':
                return C1444R.C1445drawable.flag_belize;
            case '!':
                return C1444R.C1445drawable.flag_canada;
            case '\"':
                return C1444R.C1445drawable.flag_cocos;
            case '#':
                return C1444R.C1445drawable.flag_democratic_republic_of_the_congo;
            case '$':
                return C1444R.C1445drawable.flag_central_african_republic;
            case '%':
                return C1444R.C1445drawable.flag_republic_of_the_congo;
            case '&':
                return C1444R.C1445drawable.flag_switzerland;
            case '\'':
                return C1444R.C1445drawable.flag_cote_divoire;
            case '(':
                return C1444R.C1445drawable.flag_cook_islands;
            case ')':
                return C1444R.C1445drawable.flag_chile;
            case '*':
                return C1444R.C1445drawable.flag_cameroon;
            case '+':
                return C1444R.C1445drawable.flag_china;
            case ',':
                return C1444R.C1445drawable.flag_colombia;
            case '-':
                return C1444R.C1445drawable.flag_costa_rica;
            case '.':
                return C1444R.C1445drawable.flag_cuba;
            case '/':
                return C1444R.C1445drawable.flag_cape_verde;
            case '0':
                return C1444R.C1445drawable.flag_christmas_island;
            case '1':
                return C1444R.C1445drawable.flag_cyprus;
            case '2':
                return C1444R.C1445drawable.flag_czech_republic;
            case '3':
                return C1444R.C1445drawable.flag_germany;
            case '4':
                return C1444R.C1445drawable.flag_djibouti;
            case '5':
                return C1444R.C1445drawable.flag_denmark;
            case '6':
                return C1444R.C1445drawable.flag_dominica;
            case '7':
                return C1444R.C1445drawable.flag_dominican_republic;
            case '8':
                return C1444R.C1445drawable.flag_algeria;
            case '9':
                return C1444R.C1445drawable.flag_ecuador;
            case ':':
                return C1444R.C1445drawable.flag_estonia;
            case ';':
                return C1444R.C1445drawable.flag_egypt;
            case '<':
                return C1444R.C1445drawable.flag_eritrea;
            case '=':
                return C1444R.C1445drawable.flag_spain;
            case '>':
                return C1444R.C1445drawable.flag_ethiopia;
            case '?':
                return C1444R.C1445drawable.flag_finland;
            case '@':
                return C1444R.C1445drawable.flag_fiji;
            case 'A':
                return C1444R.C1445drawable.flag_falkland_islands;
            case 'B':
                return C1444R.C1445drawable.flag_micronesia;
            case 'C':
                return C1444R.C1445drawable.flag_faroe_islands;
            case 'D':
                return C1444R.C1445drawable.flag_france;
            case 'E':
                return C1444R.C1445drawable.flag_gabon;
            case 'F':
                return C1444R.C1445drawable.flag_united_kingdom;
            case 'G':
                return C1444R.C1445drawable.flag_grenada;
            case 'H':
                return C1444R.C1445drawable.flag_georgia;
            case 'I':
                return C1444R.C1445drawable.flag_guyane;
            case 'J':
                return C1444R.C1445drawable.flag_ghana;
            case 'K':
                return C1444R.C1445drawable.flag_gibraltar;
            case 'L':
                return C1444R.C1445drawable.flag_greenland;
            case 'M':
                return C1444R.C1445drawable.flag_gambia;
            case 'N':
                return C1444R.C1445drawable.flag_guinea;
            case 'O':
                return C1444R.C1445drawable.flag_guadeloupe;
            case 'P':
                return C1444R.C1445drawable.flag_equatorial_guinea;
            case 'Q':
                return C1444R.C1445drawable.flag_greece;
            case 'R':
                return C1444R.C1445drawable.flag_guatemala;
            case 'S':
                return C1444R.C1445drawable.flag_guinea_bissau;
            case 'T':
                return C1444R.C1445drawable.flag_guyana;
            case 'U':
                return C1444R.C1445drawable.flag_hong_kong;
            case 'V':
                return C1444R.C1445drawable.flag_honduras;
            case 'W':
                return C1444R.C1445drawable.flag_croatia;
            case 'X':
                return C1444R.C1445drawable.flag_haiti;
            case 'Y':
                return C1444R.C1445drawable.flag_hungary;
            case 'Z':
                return C1444R.C1445drawable.flag_indonesia;
            case '[':
                return C1444R.C1445drawable.flag_ireland;
            case '\\':
                return C1444R.C1445drawable.flag_israel;
            case ']':
                return C1444R.C1445drawable.flag_isleof_man;
            case '^':
                return C1444R.C1445drawable.flag_iceland;
            case '_':
                return C1444R.C1445drawable.flag_india;
            case '`':
                return C1444R.C1445drawable.flag_iraq_new;
            case 'a':
                return C1444R.C1445drawable.flag_iran;
            case 'b':
                return C1444R.C1445drawable.flag_italy;
            case 'c':
                return C1444R.C1445drawable.flag_jamaica;
            case 'd':
                return C1444R.C1445drawable.flag_jordan;
            case 'e':
                return C1444R.C1445drawable.flag_japan;
            case 'f':
                return C1444R.C1445drawable.flag_kenya;
            case 'g':
                return C1444R.C1445drawable.flag_kyrgyzstan;
            case 'h':
                return C1444R.C1445drawable.flag_cambodia;
            case 'i':
                return C1444R.C1445drawable.flag_kiribati;
            case 'j':
                return C1444R.C1445drawable.flag_comoros;
            case 'k':
                return C1444R.C1445drawable.flag_saint_kitts_and_nevis;
            case 'l':
                return C1444R.C1445drawable.flag_north_korea;
            case 'm':
                return C1444R.C1445drawable.flag_south_korea;
            case 'n':
                return C1444R.C1445drawable.flag_kuwait;
            case 'o':
                return C1444R.C1445drawable.flag_cayman_islands;
            case 'p':
                return C1444R.C1445drawable.flag_kazakhstan;
            case 'q':
                return C1444R.C1445drawable.flag_laos;
            case 'r':
                return C1444R.C1445drawable.flag_lebanon;
            case 's':
                return C1444R.C1445drawable.flag_saint_lucia;
            case 't':
                return C1444R.C1445drawable.flag_liechtenstein;
            case 'u':
                return C1444R.C1445drawable.flag_sri_lanka;
            case 'v':
                return C1444R.C1445drawable.flag_liberia;
            case 'w':
                return C1444R.C1445drawable.flag_lesotho;
            case 'x':
                return C1444R.C1445drawable.flag_lithuania;
            case 'y':
                return C1444R.C1445drawable.flag_luxembourg;
            case 'z':
                return C1444R.C1445drawable.flag_latvia;
            case '{':
                return C1444R.C1445drawable.flag_libya;
            case '|':
                return C1444R.C1445drawable.flag_morocco;
            case '}':
                return C1444R.C1445drawable.flag_monaco;
            case '~':
                return C1444R.C1445drawable.flag_moldova;
            case 127:
                return C1444R.C1445drawable.flag_of_montenegro;
            case Logger.DEFAULT_FULL_MESSAGE_LENGTH /* 128 */:
                return C1444R.C1445drawable.flag_madagascar;
            case 129:
                return C1444R.C1445drawable.flag_marshall_islands;
            case 130:
                return C1444R.C1445drawable.flag_macedonia;
            case 131:
                return C1444R.C1445drawable.flag_mali;
            case 132:
                return C1444R.C1445drawable.flag_myanmar;
            case 133:
                return C1444R.C1445drawable.flag_mongolia;
            case 134:
                return C1444R.C1445drawable.flag_macao;
            case 135:
                return C1444R.C1445drawable.flag_martinique;
            case 136:
                return C1444R.C1445drawable.flag_mauritania;
            case 137:
                return C1444R.C1445drawable.flag_montserrat;
            case 138:
                return C1444R.C1445drawable.flag_malta;
            case 139:
                return C1444R.C1445drawable.flag_mauritius;
            case 140:
                return C1444R.C1445drawable.flag_maldives;
            case 141:
                return C1444R.C1445drawable.flag_malawi;
            case 142:
                return C1444R.C1445drawable.flag_mexico;
            case 143:
                return C1444R.C1445drawable.flag_malaysia;
            case 144:
                return C1444R.C1445drawable.flag_mozambique;
            case 145:
                return C1444R.C1445drawable.flag_namibia;
            case 146:
                return C1444R.C1445drawable.flag_new_caledonia;
            case 147:
                return C1444R.C1445drawable.flag_niger;
            case 148:
                return C1444R.C1445drawable.flag_nigeria;
            case 149:
                return C1444R.C1445drawable.flag_nicaragua;
            case 150:
                return C1444R.C1445drawable.flag_netherlands;
            case 151:
                return C1444R.C1445drawable.flag_norway;
            case 152:
                return C1444R.C1445drawable.flag_nepal;
            case 153:
                return C1444R.C1445drawable.flag_nauru;
            case 154:
                return C1444R.C1445drawable.flag_niue;
            case 155:
                return C1444R.C1445drawable.flag_new_zealand;
            case 156:
                return C1444R.C1445drawable.flag_oman;
            case 157:
                return C1444R.C1445drawable.flag_panama;
            case 158:
                return C1444R.C1445drawable.flag_peru;
            case 159:
                return C1444R.C1445drawable.flag_french_polynesia;
            case 160:
                return C1444R.C1445drawable.flag_papua_new_guinea;
            case 161:
                return C1444R.C1445drawable.flag_philippines;
            case 162:
                return C1444R.C1445drawable.flag_pakistan;
            case 163:
                return C1444R.C1445drawable.flag_poland;
            case 164:
                return C1444R.C1445drawable.flag_saint_pierre;
            case 165:
                return C1444R.C1445drawable.flag_pitcairn_islands;
            case 166:
                return C1444R.C1445drawable.flag_puerto_rico;
            case 167:
                return C1444R.C1445drawable.flag_palestine;
            case 168:
                return C1444R.C1445drawable.flag_portugal;
            case 169:
                return C1444R.C1445drawable.flag_palau;
            case 170:
                return C1444R.C1445drawable.flag_paraguay;
            case 171:
                return C1444R.C1445drawable.flag_qatar;
            case 172:
                return C1444R.C1445drawable.flag_martinique;
            case 173:
                return C1444R.C1445drawable.flag_romania;
            case 174:
                return C1444R.C1445drawable.flag_serbia;
            case 175:
                return C1444R.C1445drawable.flag_russian_federation;
            case 176:
                return C1444R.C1445drawable.flag_rwanda;
            case 177:
                return C1444R.C1445drawable.flag_saudi_arabia;
            case 178:
                return C1444R.C1445drawable.flag_soloman_islands;
            case 179:
                return C1444R.C1445drawable.flag_seychelles;
            case 180:
                return C1444R.C1445drawable.flag_sudan;
            case 181:
                return C1444R.C1445drawable.flag_sweden;
            case 182:
                return C1444R.C1445drawable.flag_singapore;
            case 183:
                return C1444R.C1445drawable.flag_saint_helena;
            case 184:
                return C1444R.C1445drawable.flag_slovenia;
            case 185:
                return C1444R.C1445drawable.flag_slovakia;
            case 186:
                return C1444R.C1445drawable.flag_sierra_leone;
            case 187:
                return C1444R.C1445drawable.flag_san_marino;
            case 188:
                return C1444R.C1445drawable.flag_senegal;
            case 189:
                return C1444R.C1445drawable.flag_somalia;
            case 190:
                return C1444R.C1445drawable.flag_suriname;
            case 191:
                return C1444R.C1445drawable.flag_sao_tome_and_principe;
            case 192:
                return C1444R.C1445drawable.flag_el_salvador;
            case 193:
                return C1444R.C1445drawable.flag_sint_maarten;
            case 194:
                return C1444R.C1445drawable.flag_syria;
            case 195:
                return C1444R.C1445drawable.flag_swaziland;
            case 196:
                return C1444R.C1445drawable.flag_turks_and_caicos_islands;
            case 197:
                return C1444R.C1445drawable.flag_chad;
            case 198:
                return C1444R.C1445drawable.flag_togo;
            case 199:
                return C1444R.C1445drawable.flag_thailand;
            case AndroidLog.REFRESH_LEVEL_CACHE_EVERY /* 200 */:
                return C1444R.C1445drawable.flag_tajikistan;
            case 201:
                return C1444R.C1445drawable.flag_tokelau;
            case 202:
                return C1444R.C1445drawable.flag_timor_leste;
            case 203:
                return C1444R.C1445drawable.flag_turkmenistan;
            case 204:
                return C1444R.C1445drawable.flag_tunisia;
            case 205:
                return C1444R.C1445drawable.flag_tonga;
            case 206:
                return C1444R.C1445drawable.flag_turkey;
            case 207:
                return C1444R.C1445drawable.flag_trinidad_and_tobago;
            case 208:
                return C1444R.C1445drawable.flag_tuvalu;
            case 209:
                return C1444R.C1445drawable.flag_taiwan;
            case 210:
                return C1444R.C1445drawable.flag_tanzania;
            case 211:
                return C1444R.C1445drawable.flag_ukraine;
            case 212:
                return C1444R.C1445drawable.flag_uganda;
            case 213:
                return C1444R.C1445drawable.flag_united_states_of_america;
            case 214:
                return C1444R.C1445drawable.flag_uruguay;
            case 215:
                return C1444R.C1445drawable.flag_uzbekistan;
            case 216:
                return C1444R.C1445drawable.flag_vatican_city;
            case 217:
                return C1444R.C1445drawable.flag_saint_vicent_and_the_grenadines;
            case 218:
                return C1444R.C1445drawable.flag_venezuela;
            case 219:
                return C1444R.C1445drawable.flag_british_virgin_islands;
            case 220:
                return C1444R.C1445drawable.flag_us_virgin_islands;
            case 221:
                return C1444R.C1445drawable.flag_vietnam;
            case 222:
                return C1444R.C1445drawable.flag_vanuatu;
            case 223:
                return C1444R.C1445drawable.flag_wallis_and_futuna;
            case 224:
                return C1444R.C1445drawable.flag_samoa;
            case 225:
                return C1444R.C1445drawable.flag_kosovo;
            case 226:
                return C1444R.C1445drawable.flag_yemen;
            case 227:
                return C1444R.C1445drawable.flag_martinique;
            case 228:
                return C1444R.C1445drawable.flag_south_africa;
            case 229:
                return C1444R.C1445drawable.flag_zambia;
            case 230:
                return C1444R.C1445drawable.flag_zimbabwe;
            default:
                return C1444R.C1445drawable.flag_transparent;
        }
    }

    /* renamed from: a */
    public static CCPCountry m4323a(Context context, List<CCPCountry> list, CountryCodePicker.Language language, String str) {
        if (list != null && list.size() != 0) {
            for (CCPCountry cCPCountry : list) {
                if (cCPCountry.m4307e().equalsIgnoreCase(str)) {
                    return cCPCountry;
                }
            }
            return null;
        }
        return m4327a(context, language, str);
    }

    /* renamed from: a */
    public static CCPCountry m4327a(Context context, CountryCodePicker.Language language, String str) {
        for (CCPCountry cCPCountry : m4319b(context, language)) {
            if (cCPCountry.m4307e().equalsIgnoreCase(str)) {
                return cCPCountry;
            }
        }
        return null;
    }

    /* renamed from: c */
    public int m4315c() {
        if (this.f6187e == -99) {
            this.f6187e = m4317b(this);
        }
        return this.f6187e;
    }

    /* renamed from: a */
    public static CCPCountry m4326a(Context context, CountryCodePicker.Language language, List<CCPCountry> list, int i) {
        return m4318b(context, language, list, i + "");
    }

    /* renamed from: a */
    public static CCPCountry m4325a(Context context, CountryCodePicker.Language language, List<CCPCountry> list, String str) {
        String str2 = "";
        String replace = str.replace("+", "");
        String str3 = f6164g;
        Log.d(str3, "getCountry44ForAreaCode: Phone is" + replace);
        if (replace.length() >= 6 && replace.startsWith("44")) {
            str2 = replace.substring(2, 6);
        }
        String str4 = f6164g;
        Log.d(str4, "getCountry44ForAreaCode: Area Code is" + str2);
        if (str2.length() != 4) {
            return null;
        }
        return m4327a(context, language, f6162I.contains(str2) ? "im" : "gb");
    }

    /* renamed from: c */
    public void m4312c(String str) {
        this.f6185c = str;
    }

    /* renamed from: a */
    public boolean m4321a(String str) {
        String lowerCase = str.toLowerCase();
        return m4311d().toLowerCase().contains(lowerCase) || m4307e().toLowerCase().contains(lowerCase) || m4304f().toLowerCase().contains(lowerCase) || m4320b().toLowerCase().contains(lowerCase);
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(CCPCountry cCPCountry) {
        return Collator.getInstance().compare(m4311d(), cCPCountry.m4311d());
    }

    /* renamed from: d */
    public void m4308d(String str) {
        this.f6183a = str;
    }

    /* renamed from: d */
    public String m4311d() {
        return this.f6185c;
    }

    /* renamed from: e */
    public String m4307e() {
        return this.f6183a;
    }

    /* renamed from: e */
    public void m4305e(String str) {
        this.f6184b = str;
    }

    /* renamed from: b */
    public static List<CCPCountry> m4319b(Context context, CountryCodePicker.Language language) {
        List<CCPCountry> list;
        CountryCodePicker.Language language2 = f6165h;
        if (language2 == null || language != language2 || (list = f6169m) == null || list.size() == 0) {
            m4306e(context, language);
        }
        return f6169m;
    }

    /* renamed from: b */
    public String m4320b() {
        return this.f6186d;
    }

    /* renamed from: b */
    public void m4316b(String str) {
        this.f6186d = str;
    }
}
