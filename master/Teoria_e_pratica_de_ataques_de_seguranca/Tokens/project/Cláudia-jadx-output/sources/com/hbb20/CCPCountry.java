package com.hbb20;

import android.content.Context;
import android.util.Log;
import com.hbb20.CountryCodePicker;
import com.j256.ormlite.android.AndroidLog;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class CCPCountry implements Comparable<CCPCountry> {
    public static String A = "664";
    public static String B = "787";
    public static String C = "721";
    public static String D = "649";
    public static String E = "868";
    public static String F = "784";
    public static String G = "284";
    public static String H = "340";
    public static String I = "1624";

    /* renamed from: f  reason: collision with root package name */
    public static int f4108f = -99;

    /* renamed from: g  reason: collision with root package name */
    public static String f4109g = "Class Country";

    /* renamed from: h  reason: collision with root package name */
    public static CountryCodePicker.Language f4110h = null;

    /* renamed from: i  reason: collision with root package name */
    public static String f4111i = null;
    public static String j = null;
    public static String k = null;
    public static List<CCPCountry> m = null;
    public static String n = "268";
    public static String o = "264";
    public static String p = "246";
    public static String q = "441";
    public static String r = "242";
    public static String s = "204/226/236/249/250/289/306/343/365/403/416/418/431/437/438/450/506/514/519/579/581/587/600/601/604/613/639/647/705/709/769/778/780/782/807/819/825/867/873/902/905/";
    public static String t = "767";
    public static String u = "809/829/849";
    public static String v = "473";
    public static String w = "876";
    public static String x = "869";
    public static String y = "345";
    public static String z = "758";

    /* renamed from: a  reason: collision with root package name */
    public String f4112a;

    /* renamed from: b  reason: collision with root package name */
    public String f4113b;

    /* renamed from: c  reason: collision with root package name */
    public String f4114c;

    /* renamed from: d  reason: collision with root package name */
    public String f4115d;

    /* renamed from: e  reason: collision with root package name */
    public int f4116e;

    public CCPCountry() {
        this.f4116e = f4108f;
    }

    public static String a(Context context, CountryCodePicker.Language language) {
        String str;
        CountryCodePicker.Language language2 = f4110h;
        if (language2 == null || language2 != language || (str = f4111i) == null || str.length() == 0) {
            e(context, language);
        }
        return f4111i;
    }

    public static CCPCountry b(Context context, CountryCodePicker.Language language, List<CCPCountry> list, String str) {
        if (list != null && !list.isEmpty()) {
            for (CCPCountry cCPCountry : list) {
                if (cCPCountry.f().equals(str)) {
                    return cCPCountry;
                }
            }
        }
        for (CCPCountry cCPCountry2 : b(context, language)) {
            if (cCPCountry2.f().equals(str)) {
                return cCPCountry2;
            }
        }
        return null;
    }

    public static String c(Context context, CountryCodePicker.Language language) {
        String str;
        CountryCodePicker.Language language2 = f4110h;
        if (language2 == null || language2 != language || (str = k) == null || str.length() == 0) {
            e(context, language);
        }
        return k;
    }

    public static String d(Context context, CountryCodePicker.Language language) {
        String str;
        CountryCodePicker.Language language2 = f4110h;
        if (language2 == null || language2 != language || (str = j) == null || str.length() == 0) {
            e(context, language);
        }
        return j;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(android.content.Context r8, com.hbb20.CountryCodePicker.Language r9) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbb20.CCPCountry.e(android.content.Context, com.hbb20.CountryCodePicker$Language):void");
    }

    public static CCPCountry f(String str) {
        for (CCPCountry cCPCountry : h()) {
            if (cCPCountry.f().equals(str)) {
                return cCPCountry;
            }
        }
        return null;
    }

    public static CCPCountry g(String str) {
        for (CCPCountry cCPCountry : h()) {
            if (cCPCountry.e().equalsIgnoreCase(str)) {
                return cCPCountry;
            }
        }
        return null;
    }

    public static List<CCPCountry> h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CCPCountry("ad", "376", "Andorra", f4108f));
        arrayList.add(new CCPCountry("ae", "971", "United Arab Emirates (UAE)", f4108f));
        arrayList.add(new CCPCountry("af", "93", "Afghanistan", f4108f));
        arrayList.add(new CCPCountry("ag", "1", "Antigua and Barbuda", f4108f));
        arrayList.add(new CCPCountry("ai", "1", "Anguilla", f4108f));
        arrayList.add(new CCPCountry("al", "355", "Albania", f4108f));
        arrayList.add(new CCPCountry("am", "374", "Armenia", f4108f));
        arrayList.add(new CCPCountry("ao", "244", "Angola", f4108f));
        arrayList.add(new CCPCountry("aq", "672", "Antarctica", f4108f));
        arrayList.add(new CCPCountry("ar", "54", "Argentina", f4108f));
        arrayList.add(new CCPCountry("at", "43", "Austria", f4108f));
        arrayList.add(new CCPCountry("au", "61", "Australia", f4108f));
        arrayList.add(new CCPCountry("aw", "297", "Aruba", f4108f));
        arrayList.add(new CCPCountry("az", "994", "Azerbaijan", f4108f));
        arrayList.add(new CCPCountry("ba", "387", "Bosnia And Herzegovina", f4108f));
        arrayList.add(new CCPCountry("bb", "1", "Barbados", f4108f));
        arrayList.add(new CCPCountry("bd", "880", "Bangladesh", f4108f));
        arrayList.add(new CCPCountry("be", "32", "Belgium", f4108f));
        arrayList.add(new CCPCountry("bf", "226", "Burkina Faso", f4108f));
        arrayList.add(new CCPCountry("bg", "359", "Bulgaria", f4108f));
        arrayList.add(new CCPCountry("bh", "973", "Bahrain", f4108f));
        arrayList.add(new CCPCountry("bi", "257", "Burundi", f4108f));
        arrayList.add(new CCPCountry("bj", "229", "Benin", f4108f));
        arrayList.add(new CCPCountry("bl", "590", "Saint Barthélemy", f4108f));
        arrayList.add(new CCPCountry("bm", "1", "Bermuda", f4108f));
        arrayList.add(new CCPCountry("bn", "673", "Brunei Darussalam", f4108f));
        arrayList.add(new CCPCountry("bo", "591", "Bolivia, Plurinational State Of", f4108f));
        arrayList.add(new CCPCountry("br", "55", "Brazil", f4108f));
        arrayList.add(new CCPCountry("bs", "1", "Bahamas", f4108f));
        arrayList.add(new CCPCountry("bt", "975", "Bhutan", f4108f));
        arrayList.add(new CCPCountry("bw", "267", "Botswana", f4108f));
        arrayList.add(new CCPCountry("by", "375", "Belarus", f4108f));
        arrayList.add(new CCPCountry("bz", "501", "Belize", f4108f));
        arrayList.add(new CCPCountry("ca", "1", "Canada", f4108f));
        arrayList.add(new CCPCountry("cc", "61", "Cocos (keeling) Islands", f4108f));
        arrayList.add(new CCPCountry("cd", "243", "Congo, The Democratic Republic Of The", f4108f));
        arrayList.add(new CCPCountry("cf", "236", "Central African Republic", f4108f));
        arrayList.add(new CCPCountry("cg", "242", "Congo", f4108f));
        arrayList.add(new CCPCountry("ch", "41", "Switzerland", f4108f));
        arrayList.add(new CCPCountry("ci", "225", "Côte D'ivoire", f4108f));
        arrayList.add(new CCPCountry("ck", "682", "Cook Islands", f4108f));
        arrayList.add(new CCPCountry("cl", "56", "Chile", f4108f));
        arrayList.add(new CCPCountry("cm", "237", "Cameroon", f4108f));
        arrayList.add(new CCPCountry("cn", "86", "China", f4108f));
        arrayList.add(new CCPCountry("co", "57", "Colombia", f4108f));
        arrayList.add(new CCPCountry("cr", "506", "Costa Rica", f4108f));
        arrayList.add(new CCPCountry("cu", "53", "Cuba", f4108f));
        arrayList.add(new CCPCountry("cv", "238", "Cape Verde", f4108f));
        arrayList.add(new CCPCountry("cx", "61", "Christmas Island", f4108f));
        arrayList.add(new CCPCountry("cy", "357", "Cyprus", f4108f));
        arrayList.add(new CCPCountry("cz", "420", "Czech Republic", f4108f));
        arrayList.add(new CCPCountry("de", "49", "Germany", f4108f));
        arrayList.add(new CCPCountry("dj", "253", "Djibouti", f4108f));
        arrayList.add(new CCPCountry("dk", "45", "Denmark", f4108f));
        arrayList.add(new CCPCountry("dm", "1", "Dominica", f4108f));
        arrayList.add(new CCPCountry("do", "1", "Dominican Republic", f4108f));
        arrayList.add(new CCPCountry("dz", "213", "Algeria", f4108f));
        arrayList.add(new CCPCountry("ec", "593", "Ecuador", f4108f));
        arrayList.add(new CCPCountry("ee", "372", "Estonia", f4108f));
        arrayList.add(new CCPCountry("eg", "20", "Egypt", f4108f));
        arrayList.add(new CCPCountry("er", "291", "Eritrea", f4108f));
        arrayList.add(new CCPCountry("es", "34", "Spain", f4108f));
        arrayList.add(new CCPCountry("et", "251", "Ethiopia", f4108f));
        arrayList.add(new CCPCountry("fi", "358", "Finland", f4108f));
        arrayList.add(new CCPCountry("fj", "679", "Fiji", f4108f));
        arrayList.add(new CCPCountry("fk", "500", "Falkland Islands (malvinas)", f4108f));
        arrayList.add(new CCPCountry("fm", "691", "Micronesia, Federated States Of", f4108f));
        arrayList.add(new CCPCountry("fo", "298", "Faroe Islands", f4108f));
        arrayList.add(new CCPCountry("fr", "33", "France", f4108f));
        arrayList.add(new CCPCountry("ga", "241", "Gabon", f4108f));
        arrayList.add(new CCPCountry("gb", "44", "United Kingdom", f4108f));
        arrayList.add(new CCPCountry("gd", "1", "Grenada", f4108f));
        arrayList.add(new CCPCountry("ge", "995", "Georgia", f4108f));
        arrayList.add(new CCPCountry("gf", "594", "French Guyana", f4108f));
        arrayList.add(new CCPCountry("gh", "233", "Ghana", f4108f));
        arrayList.add(new CCPCountry("gi", "350", "Gibraltar", f4108f));
        arrayList.add(new CCPCountry("gl", "299", "Greenland", f4108f));
        arrayList.add(new CCPCountry("gm", "220", "Gambia", f4108f));
        arrayList.add(new CCPCountry("gn", "224", "Guinea", f4108f));
        arrayList.add(new CCPCountry("gp", "450", "Guadeloupe", f4108f));
        arrayList.add(new CCPCountry("gq", "240", "Equatorial Guinea", f4108f));
        arrayList.add(new CCPCountry("gr", "30", "Greece", f4108f));
        arrayList.add(new CCPCountry("gt", "502", "Guatemala", f4108f));
        arrayList.add(new CCPCountry("gw", "245", "Guinea-bissau", f4108f));
        arrayList.add(new CCPCountry("gy", "592", "Guyana", f4108f));
        arrayList.add(new CCPCountry("hk", "852", "Hong Kong", f4108f));
        arrayList.add(new CCPCountry("hn", "504", "Honduras", f4108f));
        arrayList.add(new CCPCountry("hr", "385", "Croatia", f4108f));
        arrayList.add(new CCPCountry("ht", "509", "Haiti", f4108f));
        arrayList.add(new CCPCountry("hu", "36", "Hungary", f4108f));
        arrayList.add(new CCPCountry(DatabaseFieldConfigLoader.FIELD_NAME_ID, "62", "Indonesia", f4108f));
        arrayList.add(new CCPCountry("ie", "353", "Ireland", f4108f));
        arrayList.add(new CCPCountry("il", "972", "Israel", f4108f));
        arrayList.add(new CCPCountry("im", "44", "Isle Of Man", f4108f));
        arrayList.add(new CCPCountry("is", "354", "Iceland", f4108f));
        arrayList.add(new CCPCountry("in", "91", "India", f4108f));
        arrayList.add(new CCPCountry("iq", "964", "Iraq", f4108f));
        arrayList.add(new CCPCountry("ir", "98", "Iran, Islamic Republic Of", f4108f));
        arrayList.add(new CCPCountry("it", "39", "Italy", f4108f));
        arrayList.add(new CCPCountry("jm", "1", "Jamaica", f4108f));
        arrayList.add(new CCPCountry("jo", "962", "Jordan", f4108f));
        arrayList.add(new CCPCountry("jp", "81", "Japan", f4108f));
        arrayList.add(new CCPCountry("ke", "254", "Kenya", f4108f));
        arrayList.add(new CCPCountry("kg", "996", "Kyrgyzstan", f4108f));
        arrayList.add(new CCPCountry("kh", "855", "Cambodia", f4108f));
        arrayList.add(new CCPCountry("ki", "686", "Kiribati", f4108f));
        arrayList.add(new CCPCountry("km", "269", "Comoros", f4108f));
        arrayList.add(new CCPCountry("kn", "1", "Saint Kitts and Nevis", f4108f));
        arrayList.add(new CCPCountry("kp", "850", "North Korea", f4108f));
        arrayList.add(new CCPCountry("kr", "82", "South Korea", f4108f));
        arrayList.add(new CCPCountry("kw", "965", "Kuwait", f4108f));
        arrayList.add(new CCPCountry("ky", "1", "Cayman Islands", f4108f));
        arrayList.add(new CCPCountry("kz", "7", "Kazakhstan", f4108f));
        arrayList.add(new CCPCountry("la", "856", "Lao People's Democratic Republic", f4108f));
        arrayList.add(new CCPCountry("lb", "961", "Lebanon", f4108f));
        arrayList.add(new CCPCountry("lc", "1", "Saint Lucia", f4108f));
        arrayList.add(new CCPCountry("li", "423", "Liechtenstein", f4108f));
        arrayList.add(new CCPCountry("lk", "94", "Sri Lanka", f4108f));
        arrayList.add(new CCPCountry("lr", "231", "Liberia", f4108f));
        arrayList.add(new CCPCountry("ls", "266", "Lesotho", f4108f));
        arrayList.add(new CCPCountry("lt", "370", "Lithuania", f4108f));
        arrayList.add(new CCPCountry("lu", "352", "Luxembourg", f4108f));
        arrayList.add(new CCPCountry("lv", "371", "Latvia", f4108f));
        arrayList.add(new CCPCountry("ly", "218", "Libya", f4108f));
        arrayList.add(new CCPCountry("ma", "212", "Morocco", f4108f));
        arrayList.add(new CCPCountry("mc", "377", "Monaco", f4108f));
        arrayList.add(new CCPCountry("md", "373", "Moldova, Republic Of", f4108f));
        arrayList.add(new CCPCountry("me", "382", "Montenegro", f4108f));
        arrayList.add(new CCPCountry("mg", "261", "Madagascar", f4108f));
        arrayList.add(new CCPCountry("mh", "692", "Marshall Islands", f4108f));
        arrayList.add(new CCPCountry("mk", "389", "Macedonia, The Former Yugoslav Republic Of", f4108f));
        arrayList.add(new CCPCountry("ml", "223", "Mali", f4108f));
        arrayList.add(new CCPCountry("mm", "95", "Myanmar", f4108f));
        arrayList.add(new CCPCountry("mn", "976", "Mongolia", f4108f));
        arrayList.add(new CCPCountry("mo", "853", "Macao", f4108f));
        arrayList.add(new CCPCountry("mq", "596", "Martinique", f4108f));
        arrayList.add(new CCPCountry("mr", "222", "Mauritania", f4108f));
        arrayList.add(new CCPCountry("ms", "1", "Montserrat", f4108f));
        arrayList.add(new CCPCountry("mt", "356", "Malta", f4108f));
        arrayList.add(new CCPCountry("mu", "230", "Mauritius", f4108f));
        arrayList.add(new CCPCountry("mv", "960", "Maldives", f4108f));
        arrayList.add(new CCPCountry("mw", "265", "Malawi", f4108f));
        arrayList.add(new CCPCountry("mx", "52", "Mexico", f4108f));
        arrayList.add(new CCPCountry("my", "60", "Malaysia", f4108f));
        arrayList.add(new CCPCountry("mz", "258", "Mozambique", f4108f));
        arrayList.add(new CCPCountry("na", "264", "Namibia", f4108f));
        arrayList.add(new CCPCountry("nc", "687", "New Caledonia", f4108f));
        arrayList.add(new CCPCountry("ne", "227", "Niger", f4108f));
        arrayList.add(new CCPCountry("ng", "234", "Nigeria", f4108f));
        arrayList.add(new CCPCountry("ni", "505", "Nicaragua", f4108f));
        arrayList.add(new CCPCountry("nl", "31", "Netherlands", f4108f));
        arrayList.add(new CCPCountry("no", "47", "Norway", f4108f));
        arrayList.add(new CCPCountry("np", "977", "Nepal", f4108f));
        arrayList.add(new CCPCountry("nr", "674", "Nauru", f4108f));
        arrayList.add(new CCPCountry("nu", "683", "Niue", f4108f));
        arrayList.add(new CCPCountry("nz", "64", "New Zealand", f4108f));
        arrayList.add(new CCPCountry("om", "968", "Oman", f4108f));
        arrayList.add(new CCPCountry("pa", "507", "Panama", f4108f));
        arrayList.add(new CCPCountry("pe", "51", "Peru", f4108f));
        arrayList.add(new CCPCountry("pf", "689", "French Polynesia", f4108f));
        arrayList.add(new CCPCountry("pg", "675", "Papua New Guinea", f4108f));
        arrayList.add(new CCPCountry("ph", "63", "Philippines", f4108f));
        arrayList.add(new CCPCountry("pk", "92", "Pakistan", f4108f));
        arrayList.add(new CCPCountry("pl", "48", "Poland", f4108f));
        arrayList.add(new CCPCountry("pm", "508", "Saint Pierre And Miquelon", f4108f));
        arrayList.add(new CCPCountry("pn", "870", "Pitcairn", f4108f));
        arrayList.add(new CCPCountry("pr", "1", "Puerto Rico", f4108f));
        arrayList.add(new CCPCountry("ps", "970", "Palestine", f4108f));
        arrayList.add(new CCPCountry("pt", "351", "Portugal", f4108f));
        arrayList.add(new CCPCountry("pw", "680", "Palau", f4108f));
        arrayList.add(new CCPCountry("py", "595", "Paraguay", f4108f));
        arrayList.add(new CCPCountry("qa", "974", "Qatar", f4108f));
        arrayList.add(new CCPCountry("re", "262", "Réunion", f4108f));
        arrayList.add(new CCPCountry("ro", "40", "Romania", f4108f));
        arrayList.add(new CCPCountry("rs", "381", "Serbia", f4108f));
        arrayList.add(new CCPCountry("ru", "7", "Russian Federation", f4108f));
        arrayList.add(new CCPCountry("rw", "250", "Rwanda", f4108f));
        arrayList.add(new CCPCountry("sa", "966", "Saudi Arabia", f4108f));
        arrayList.add(new CCPCountry("sb", "677", "Solomon Islands", f4108f));
        arrayList.add(new CCPCountry("sc", "248", "Seychelles", f4108f));
        arrayList.add(new CCPCountry("sd", "249", "Sudan", f4108f));
        arrayList.add(new CCPCountry("se", "46", "Sweden", f4108f));
        arrayList.add(new CCPCountry("sg", "65", "Singapore", f4108f));
        arrayList.add(new CCPCountry("sh", "290", "Saint Helena, Ascension And Tristan Da Cunha", f4108f));
        arrayList.add(new CCPCountry("si", "386", "Slovenia", f4108f));
        arrayList.add(new CCPCountry("sk", "421", "Slovakia", f4108f));
        arrayList.add(new CCPCountry("sl", "232", "Sierra Leone", f4108f));
        arrayList.add(new CCPCountry("sm", "378", "San Marino", f4108f));
        arrayList.add(new CCPCountry("sn", "221", "Senegal", f4108f));
        arrayList.add(new CCPCountry("so", "252", "Somalia", f4108f));
        arrayList.add(new CCPCountry("sr", "597", "Suriname", f4108f));
        arrayList.add(new CCPCountry("st", "239", "Sao Tome And Principe", f4108f));
        arrayList.add(new CCPCountry("sv", "503", "El Salvador", f4108f));
        arrayList.add(new CCPCountry("sx", "1", "Sint Maarten", f4108f));
        arrayList.add(new CCPCountry("sy", "963", "Syrian Arab Republic", f4108f));
        arrayList.add(new CCPCountry("sz", "268", "Swaziland", f4108f));
        arrayList.add(new CCPCountry("tc", "1", "Turks and Caicos Islands", f4108f));
        arrayList.add(new CCPCountry("td", "235", "Chad", f4108f));
        arrayList.add(new CCPCountry("tg", "228", "Togo", f4108f));
        arrayList.add(new CCPCountry("th", "66", "Thailand", f4108f));
        arrayList.add(new CCPCountry("tj", "992", "Tajikistan", f4108f));
        arrayList.add(new CCPCountry("tk", "690", "Tokelau", f4108f));
        arrayList.add(new CCPCountry("tl", "670", "Timor-leste", f4108f));
        arrayList.add(new CCPCountry("tm", "993", "Turkmenistan", f4108f));
        arrayList.add(new CCPCountry("tn", "216", "Tunisia", f4108f));
        arrayList.add(new CCPCountry("to", "676", "Tonga", f4108f));
        arrayList.add(new CCPCountry("tr", "90", "Turkey", f4108f));
        arrayList.add(new CCPCountry("tt", "1", "Trinidad &amp; Tobago", f4108f));
        arrayList.add(new CCPCountry("tv", "688", "Tuvalu", f4108f));
        arrayList.add(new CCPCountry("tw", "886", "Taiwan", f4108f));
        arrayList.add(new CCPCountry("tz", "255", "Tanzania, United Republic Of", f4108f));
        arrayList.add(new CCPCountry("ua", "380", "Ukraine", f4108f));
        arrayList.add(new CCPCountry("ug", "256", "Uganda", f4108f));
        arrayList.add(new CCPCountry("us", "1", "United States", f4108f));
        arrayList.add(new CCPCountry("uy", "598", "Uruguay", f4108f));
        arrayList.add(new CCPCountry("uz", "998", "Uzbekistan", f4108f));
        arrayList.add(new CCPCountry("va", "379", "Holy See (vatican City State)", f4108f));
        arrayList.add(new CCPCountry("vc", "1", "Saint Vincent &amp; The Grenadines", f4108f));
        arrayList.add(new CCPCountry("ve", "58", "Venezuela, Bolivarian Republic Of", f4108f));
        arrayList.add(new CCPCountry("vg", "1", "British Virgin Islands", f4108f));
        arrayList.add(new CCPCountry("vi", "1", "US Virgin Islands", f4108f));
        arrayList.add(new CCPCountry("vn", "84", "Viet Nam", f4108f));
        arrayList.add(new CCPCountry("vu", "678", "Vanuatu", f4108f));
        arrayList.add(new CCPCountry("wf", "681", "Wallis And Futuna", f4108f));
        arrayList.add(new CCPCountry("ws", "685", "Samoa", f4108f));
        arrayList.add(new CCPCountry("xk", "383", "Kosovo", f4108f));
        arrayList.add(new CCPCountry("ye", "967", "Yemen", f4108f));
        arrayList.add(new CCPCountry("yt", "262", "Mayotte", f4108f));
        arrayList.add(new CCPCountry("za", "27", "South Africa", f4108f));
        arrayList.add(new CCPCountry("zm", "260", "Zambia", f4108f));
        arrayList.add(new CCPCountry("zw", "263", "Zimbabwe", f4108f));
        return arrayList;
    }

    public CCPCountry(String str, String str2, String str3, int i2) {
        this.f4116e = f4108f;
        this.f4112a = str;
        this.f4113b = str2;
        this.f4114c = str3;
        this.f4116e = i2;
    }

    public static List<CCPCountry> a(Context context, CountryCodePicker countryCodePicker) {
        countryCodePicker.m();
        List<CCPCountry> list = countryCodePicker.R;
        if (list != null && list.size() > 0) {
            return countryCodePicker.getCustomMasterCountriesList();
        }
        return b(context, countryCodePicker.getLanguageToApply());
    }

    public static CCPCountry c(Context context, CountryCodePicker.Language language, List<CCPCountry> list, String str) {
        if (str.length() != 0) {
            int i2 = str.charAt(0) == '+' ? 1 : 0;
            for (int i3 = i2; i3 < i2 + 4; i3++) {
                String substring = str.substring(i2, i3);
                if (substring.equals("1")) {
                    return d(context, language, list, str);
                }
                if (substring.equals("44")) {
                    CCPCountry a2 = a(context, language, list, str);
                    return a2 != null ? a2 : b(context, language, list, substring);
                }
                CCPCountry b2 = b(context, language, list, substring);
                if (b2 != null) {
                    return b2;
                }
            }
            return null;
        }
        return null;
    }

    public static CCPCountry d(Context context, CountryCodePicker.Language language, List<CCPCountry> list, String str) {
        String str2;
        String str3 = "";
        String replace = str.replace("+", "");
        if (replace.length() >= 4 && replace.charAt(0) == '1') {
            str3 = replace.substring(1, 4);
        }
        if (str3.length() != 3) {
            return b(context, language, list, "1");
        }
        if (n.contains(str3)) {
            str2 = "ag";
        } else if (o.contains(str3)) {
            str2 = "ai";
        } else if (p.contains(str3)) {
            str2 = "bb";
        } else if (q.contains(str3)) {
            str2 = "bm";
        } else if (r.contains(str3)) {
            str2 = "bs";
        } else if (s.contains(str3)) {
            str2 = "ca";
        } else if (t.contains(str3)) {
            str2 = "dm";
        } else if (u.contains(str3)) {
            str2 = "do";
        } else if (v.contains(str3)) {
            str2 = "gd";
        } else if (w.contains(str3)) {
            str2 = "jm";
        } else if (x.contains(str3)) {
            str2 = "kn";
        } else if (y.contains(str3)) {
            str2 = "ky";
        } else if (z.contains(str3)) {
            str2 = "lc";
        } else if (A.contains(str3)) {
            str2 = "ms";
        } else if (B.contains(str3)) {
            str2 = "pr";
        } else if (C.contains(str3)) {
            str2 = "sx";
        } else if (D.contains(str3)) {
            str2 = "tc";
        } else if (E.contains(str3)) {
            str2 = "tt";
        } else if (F.contains(str3)) {
            str2 = "vc";
        } else if (G.contains(str3)) {
            str2 = "vg";
        } else {
            str2 = H.contains(str3) ? "vi" : "us";
        }
        return a(context, language, str2);
    }

    public String f() {
        return this.f4113b;
    }

    public void g() {
        try {
            String str = f4109g;
            Log.d(str, "Country->" + this.f4112a + ":" + this.f4113b + ":" + this.f4114c);
        } catch (NullPointerException unused) {
            Log.d(f4109g, "Null");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int b(CCPCountry cCPCountry) {
        char c2;
        String lowerCase = cCPCountry.e().toLowerCase();
        switch (lowerCase.hashCode()) {
            case 3107:
                if (lowerCase.equals("ad")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 3108:
                if (lowerCase.equals("ae")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 3109:
                if (lowerCase.equals("af")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 3110:
                if (lowerCase.equals("ag")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 3112:
                if (lowerCase.equals("ai")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 3115:
                if (lowerCase.equals("al")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 3116:
                if (lowerCase.equals("am")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 3118:
                if (lowerCase.equals("ao")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 3120:
                if (lowerCase.equals("aq")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 3121:
                if (lowerCase.equals("ar")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case 3123:
                if (lowerCase.equals("at")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case 3124:
                if (lowerCase.equals("au")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case 3126:
                if (lowerCase.equals("aw")) {
                    c2 = '\f';
                    break;
                }
                c2 = 65535;
                break;
            case 3129:
                if (lowerCase.equals("az")) {
                    c2 = '\r';
                    break;
                }
                c2 = 65535;
                break;
            case 3135:
                if (lowerCase.equals("ba")) {
                    c2 = 14;
                    break;
                }
                c2 = 65535;
                break;
            case 3136:
                if (lowerCase.equals("bb")) {
                    c2 = 15;
                    break;
                }
                c2 = 65535;
                break;
            case 3138:
                if (lowerCase.equals("bd")) {
                    c2 = 16;
                    break;
                }
                c2 = 65535;
                break;
            case 3139:
                if (lowerCase.equals("be")) {
                    c2 = 17;
                    break;
                }
                c2 = 65535;
                break;
            case 3140:
                if (lowerCase.equals("bf")) {
                    c2 = 18;
                    break;
                }
                c2 = 65535;
                break;
            case 3141:
                if (lowerCase.equals("bg")) {
                    c2 = 19;
                    break;
                }
                c2 = 65535;
                break;
            case 3142:
                if (lowerCase.equals("bh")) {
                    c2 = 20;
                    break;
                }
                c2 = 65535;
                break;
            case 3143:
                if (lowerCase.equals("bi")) {
                    c2 = 21;
                    break;
                }
                c2 = 65535;
                break;
            case 3144:
                if (lowerCase.equals("bj")) {
                    c2 = 22;
                    break;
                }
                c2 = 65535;
                break;
            case 3146:
                if (lowerCase.equals("bl")) {
                    c2 = 23;
                    break;
                }
                c2 = 65535;
                break;
            case 3147:
                if (lowerCase.equals("bm")) {
                    c2 = 24;
                    break;
                }
                c2 = 65535;
                break;
            case 3148:
                if (lowerCase.equals("bn")) {
                    c2 = 25;
                    break;
                }
                c2 = 65535;
                break;
            case 3149:
                if (lowerCase.equals("bo")) {
                    c2 = 26;
                    break;
                }
                c2 = 65535;
                break;
            case 3152:
                if (lowerCase.equals("br")) {
                    c2 = 27;
                    break;
                }
                c2 = 65535;
                break;
            case 3153:
                if (lowerCase.equals("bs")) {
                    c2 = 28;
                    break;
                }
                c2 = 65535;
                break;
            case 3154:
                if (lowerCase.equals("bt")) {
                    c2 = 29;
                    break;
                }
                c2 = 65535;
                break;
            case 3157:
                if (lowerCase.equals("bw")) {
                    c2 = 30;
                    break;
                }
                c2 = 65535;
                break;
            case 3159:
                if (lowerCase.equals("by")) {
                    c2 = 31;
                    break;
                }
                c2 = 65535;
                break;
            case 3160:
                if (lowerCase.equals("bz")) {
                    c2 = ' ';
                    break;
                }
                c2 = 65535;
                break;
            case 3166:
                if (lowerCase.equals("ca")) {
                    c2 = '!';
                    break;
                }
                c2 = 65535;
                break;
            case 3168:
                if (lowerCase.equals("cc")) {
                    c2 = '\"';
                    break;
                }
                c2 = 65535;
                break;
            case 3169:
                if (lowerCase.equals("cd")) {
                    c2 = '#';
                    break;
                }
                c2 = 65535;
                break;
            case 3171:
                if (lowerCase.equals("cf")) {
                    c2 = '$';
                    break;
                }
                c2 = 65535;
                break;
            case 3172:
                if (lowerCase.equals("cg")) {
                    c2 = '%';
                    break;
                }
                c2 = 65535;
                break;
            case 3173:
                if (lowerCase.equals("ch")) {
                    c2 = '&';
                    break;
                }
                c2 = 65535;
                break;
            case 3174:
                if (lowerCase.equals("ci")) {
                    c2 = '\'';
                    break;
                }
                c2 = 65535;
                break;
            case 3176:
                if (lowerCase.equals("ck")) {
                    c2 = '(';
                    break;
                }
                c2 = 65535;
                break;
            case 3177:
                if (lowerCase.equals("cl")) {
                    c2 = ')';
                    break;
                }
                c2 = 65535;
                break;
            case 3178:
                if (lowerCase.equals("cm")) {
                    c2 = '*';
                    break;
                }
                c2 = 65535;
                break;
            case 3179:
                if (lowerCase.equals("cn")) {
                    c2 = '+';
                    break;
                }
                c2 = 65535;
                break;
            case 3180:
                if (lowerCase.equals("co")) {
                    c2 = ',';
                    break;
                }
                c2 = 65535;
                break;
            case 3183:
                if (lowerCase.equals("cr")) {
                    c2 = '-';
                    break;
                }
                c2 = 65535;
                break;
            case 3186:
                if (lowerCase.equals("cu")) {
                    c2 = '.';
                    break;
                }
                c2 = 65535;
                break;
            case 3187:
                if (lowerCase.equals("cv")) {
                    c2 = '/';
                    break;
                }
                c2 = 65535;
                break;
            case 3189:
                if (lowerCase.equals("cx")) {
                    c2 = '0';
                    break;
                }
                c2 = 65535;
                break;
            case 3190:
                if (lowerCase.equals("cy")) {
                    c2 = '1';
                    break;
                }
                c2 = 65535;
                break;
            case 3191:
                if (lowerCase.equals("cz")) {
                    c2 = '2';
                    break;
                }
                c2 = 65535;
                break;
            case 3201:
                if (lowerCase.equals("de")) {
                    c2 = '3';
                    break;
                }
                c2 = 65535;
                break;
            case 3206:
                if (lowerCase.equals("dj")) {
                    c2 = '4';
                    break;
                }
                c2 = 65535;
                break;
            case 3207:
                if (lowerCase.equals("dk")) {
                    c2 = '5';
                    break;
                }
                c2 = 65535;
                break;
            case 3209:
                if (lowerCase.equals("dm")) {
                    c2 = '6';
                    break;
                }
                c2 = 65535;
                break;
            case 3211:
                if (lowerCase.equals("do")) {
                    c2 = '7';
                    break;
                }
                c2 = 65535;
                break;
            case 3222:
                if (lowerCase.equals("dz")) {
                    c2 = '8';
                    break;
                }
                c2 = 65535;
                break;
            case 3230:
                if (lowerCase.equals("ec")) {
                    c2 = '9';
                    break;
                }
                c2 = 65535;
                break;
            case 3232:
                if (lowerCase.equals("ee")) {
                    c2 = ':';
                    break;
                }
                c2 = 65535;
                break;
            case 3234:
                if (lowerCase.equals("eg")) {
                    c2 = ';';
                    break;
                }
                c2 = 65535;
                break;
            case 3245:
                if (lowerCase.equals("er")) {
                    c2 = '<';
                    break;
                }
                c2 = 65535;
                break;
            case 3246:
                if (lowerCase.equals("es")) {
                    c2 = '=';
                    break;
                }
                c2 = 65535;
                break;
            case 3247:
                if (lowerCase.equals("et")) {
                    c2 = '>';
                    break;
                }
                c2 = 65535;
                break;
            case 3267:
                if (lowerCase.equals("fi")) {
                    c2 = '?';
                    break;
                }
                c2 = 65535;
                break;
            case 3268:
                if (lowerCase.equals("fj")) {
                    c2 = '@';
                    break;
                }
                c2 = 65535;
                break;
            case 3269:
                if (lowerCase.equals("fk")) {
                    c2 = 'A';
                    break;
                }
                c2 = 65535;
                break;
            case 3271:
                if (lowerCase.equals("fm")) {
                    c2 = 'B';
                    break;
                }
                c2 = 65535;
                break;
            case 3273:
                if (lowerCase.equals("fo")) {
                    c2 = 'C';
                    break;
                }
                c2 = 65535;
                break;
            case 3276:
                if (lowerCase.equals("fr")) {
                    c2 = 'D';
                    break;
                }
                c2 = 65535;
                break;
            case 3290:
                if (lowerCase.equals("ga")) {
                    c2 = 'E';
                    break;
                }
                c2 = 65535;
                break;
            case 3291:
                if (lowerCase.equals("gb")) {
                    c2 = 'F';
                    break;
                }
                c2 = 65535;
                break;
            case 3293:
                if (lowerCase.equals("gd")) {
                    c2 = 'G';
                    break;
                }
                c2 = 65535;
                break;
            case 3294:
                if (lowerCase.equals("ge")) {
                    c2 = 'H';
                    break;
                }
                c2 = 65535;
                break;
            case 3295:
                if (lowerCase.equals("gf")) {
                    c2 = 'I';
                    break;
                }
                c2 = 65535;
                break;
            case 3297:
                if (lowerCase.equals("gh")) {
                    c2 = 'J';
                    break;
                }
                c2 = 65535;
                break;
            case 3298:
                if (lowerCase.equals("gi")) {
                    c2 = 'K';
                    break;
                }
                c2 = 65535;
                break;
            case 3301:
                if (lowerCase.equals("gl")) {
                    c2 = 'L';
                    break;
                }
                c2 = 65535;
                break;
            case 3302:
                if (lowerCase.equals("gm")) {
                    c2 = 'M';
                    break;
                }
                c2 = 65535;
                break;
            case 3303:
                if (lowerCase.equals("gn")) {
                    c2 = 'N';
                    break;
                }
                c2 = 65535;
                break;
            case 3305:
                if (lowerCase.equals("gp")) {
                    c2 = 'O';
                    break;
                }
                c2 = 65535;
                break;
            case 3306:
                if (lowerCase.equals("gq")) {
                    c2 = 'P';
                    break;
                }
                c2 = 65535;
                break;
            case 3307:
                if (lowerCase.equals("gr")) {
                    c2 = 'Q';
                    break;
                }
                c2 = 65535;
                break;
            case 3309:
                if (lowerCase.equals("gt")) {
                    c2 = 'R';
                    break;
                }
                c2 = 65535;
                break;
            case 3312:
                if (lowerCase.equals("gw")) {
                    c2 = 'S';
                    break;
                }
                c2 = 65535;
                break;
            case 3314:
                if (lowerCase.equals("gy")) {
                    c2 = 'T';
                    break;
                }
                c2 = 65535;
                break;
            case 3331:
                if (lowerCase.equals("hk")) {
                    c2 = 'U';
                    break;
                }
                c2 = 65535;
                break;
            case 3334:
                if (lowerCase.equals("hn")) {
                    c2 = 'V';
                    break;
                }
                c2 = 65535;
                break;
            case 3338:
                if (lowerCase.equals("hr")) {
                    c2 = 'W';
                    break;
                }
                c2 = 65535;
                break;
            case 3340:
                if (lowerCase.equals("ht")) {
                    c2 = 'X';
                    break;
                }
                c2 = 65535;
                break;
            case 3341:
                if (lowerCase.equals("hu")) {
                    c2 = 'Y';
                    break;
                }
                c2 = 65535;
                break;
            case 3355:
                if (lowerCase.equals(DatabaseFieldConfigLoader.FIELD_NAME_ID)) {
                    c2 = 'Z';
                    break;
                }
                c2 = 65535;
                break;
            case 3356:
                if (lowerCase.equals("ie")) {
                    c2 = '[';
                    break;
                }
                c2 = 65535;
                break;
            case 3363:
                if (lowerCase.equals("il")) {
                    c2 = '\\';
                    break;
                }
                c2 = 65535;
                break;
            case 3364:
                if (lowerCase.equals("im")) {
                    c2 = ']';
                    break;
                }
                c2 = 65535;
                break;
            case 3365:
                if (lowerCase.equals("in")) {
                    c2 = '_';
                    break;
                }
                c2 = 65535;
                break;
            case 3368:
                if (lowerCase.equals("iq")) {
                    c2 = '`';
                    break;
                }
                c2 = 65535;
                break;
            case 3369:
                if (lowerCase.equals("ir")) {
                    c2 = 'a';
                    break;
                }
                c2 = 65535;
                break;
            case 3370:
                if (lowerCase.equals("is")) {
                    c2 = '^';
                    break;
                }
                c2 = 65535;
                break;
            case 3371:
                if (lowerCase.equals("it")) {
                    c2 = 'b';
                    break;
                }
                c2 = 65535;
                break;
            case 3395:
                if (lowerCase.equals("jm")) {
                    c2 = 'c';
                    break;
                }
                c2 = 65535;
                break;
            case 3397:
                if (lowerCase.equals("jo")) {
                    c2 = 'd';
                    break;
                }
                c2 = 65535;
                break;
            case 3398:
                if (lowerCase.equals("jp")) {
                    c2 = 'e';
                    break;
                }
                c2 = 65535;
                break;
            case 3418:
                if (lowerCase.equals("ke")) {
                    c2 = 'f';
                    break;
                }
                c2 = 65535;
                break;
            case 3420:
                if (lowerCase.equals("kg")) {
                    c2 = 'g';
                    break;
                }
                c2 = 65535;
                break;
            case 3421:
                if (lowerCase.equals("kh")) {
                    c2 = 'h';
                    break;
                }
                c2 = 65535;
                break;
            case 3422:
                if (lowerCase.equals("ki")) {
                    c2 = 'i';
                    break;
                }
                c2 = 65535;
                break;
            case 3426:
                if (lowerCase.equals("km")) {
                    c2 = 'j';
                    break;
                }
                c2 = 65535;
                break;
            case 3427:
                if (lowerCase.equals("kn")) {
                    c2 = 'k';
                    break;
                }
                c2 = 65535;
                break;
            case 3429:
                if (lowerCase.equals("kp")) {
                    c2 = 'l';
                    break;
                }
                c2 = 65535;
                break;
            case 3431:
                if (lowerCase.equals("kr")) {
                    c2 = 'm';
                    break;
                }
                c2 = 65535;
                break;
            case 3436:
                if (lowerCase.equals("kw")) {
                    c2 = 'n';
                    break;
                }
                c2 = 65535;
                break;
            case 3438:
                if (lowerCase.equals("ky")) {
                    c2 = 'o';
                    break;
                }
                c2 = 65535;
                break;
            case 3439:
                if (lowerCase.equals("kz")) {
                    c2 = 'p';
                    break;
                }
                c2 = 65535;
                break;
            case 3445:
                if (lowerCase.equals("la")) {
                    c2 = 'q';
                    break;
                }
                c2 = 65535;
                break;
            case 3446:
                if (lowerCase.equals("lb")) {
                    c2 = 'r';
                    break;
                }
                c2 = 65535;
                break;
            case 3447:
                if (lowerCase.equals("lc")) {
                    c2 = 's';
                    break;
                }
                c2 = 65535;
                break;
            case 3453:
                if (lowerCase.equals("li")) {
                    c2 = 't';
                    break;
                }
                c2 = 65535;
                break;
            case 3455:
                if (lowerCase.equals("lk")) {
                    c2 = 'u';
                    break;
                }
                c2 = 65535;
                break;
            case 3462:
                if (lowerCase.equals("lr")) {
                    c2 = 'v';
                    break;
                }
                c2 = 65535;
                break;
            case 3463:
                if (lowerCase.equals("ls")) {
                    c2 = 'w';
                    break;
                }
                c2 = 65535;
                break;
            case 3464:
                if (lowerCase.equals("lt")) {
                    c2 = 'x';
                    break;
                }
                c2 = 65535;
                break;
            case 3465:
                if (lowerCase.equals("lu")) {
                    c2 = 'y';
                    break;
                }
                c2 = 65535;
                break;
            case 3466:
                if (lowerCase.equals("lv")) {
                    c2 = 'z';
                    break;
                }
                c2 = 65535;
                break;
            case 3469:
                if (lowerCase.equals("ly")) {
                    c2 = '{';
                    break;
                }
                c2 = 65535;
                break;
            case 3476:
                if (lowerCase.equals("ma")) {
                    c2 = '|';
                    break;
                }
                c2 = 65535;
                break;
            case 3478:
                if (lowerCase.equals("mc")) {
                    c2 = '}';
                    break;
                }
                c2 = 65535;
                break;
            case 3479:
                if (lowerCase.equals("md")) {
                    c2 = '~';
                    break;
                }
                c2 = 65535;
                break;
            case 3480:
                if (lowerCase.equals("me")) {
                    c2 = 127;
                    break;
                }
                c2 = 65535;
                break;
            case 3482:
                if (lowerCase.equals("mg")) {
                    c2 = 128;
                    break;
                }
                c2 = 65535;
                break;
            case 3483:
                if (lowerCase.equals("mh")) {
                    c2 = 129;
                    break;
                }
                c2 = 65535;
                break;
            case 3486:
                if (lowerCase.equals("mk")) {
                    c2 = 130;
                    break;
                }
                c2 = 65535;
                break;
            case 3487:
                if (lowerCase.equals("ml")) {
                    c2 = 131;
                    break;
                }
                c2 = 65535;
                break;
            case 3488:
                if (lowerCase.equals("mm")) {
                    c2 = 132;
                    break;
                }
                c2 = 65535;
                break;
            case 3489:
                if (lowerCase.equals("mn")) {
                    c2 = 133;
                    break;
                }
                c2 = 65535;
                break;
            case 3490:
                if (lowerCase.equals("mo")) {
                    c2 = 134;
                    break;
                }
                c2 = 65535;
                break;
            case 3492:
                if (lowerCase.equals("mq")) {
                    c2 = 135;
                    break;
                }
                c2 = 65535;
                break;
            case 3493:
                if (lowerCase.equals("mr")) {
                    c2 = 136;
                    break;
                }
                c2 = 65535;
                break;
            case 3494:
                if (lowerCase.equals("ms")) {
                    c2 = 137;
                    break;
                }
                c2 = 65535;
                break;
            case 3495:
                if (lowerCase.equals("mt")) {
                    c2 = 138;
                    break;
                }
                c2 = 65535;
                break;
            case 3496:
                if (lowerCase.equals("mu")) {
                    c2 = 139;
                    break;
                }
                c2 = 65535;
                break;
            case 3497:
                if (lowerCase.equals("mv")) {
                    c2 = 140;
                    break;
                }
                c2 = 65535;
                break;
            case 3498:
                if (lowerCase.equals("mw")) {
                    c2 = 141;
                    break;
                }
                c2 = 65535;
                break;
            case 3499:
                if (lowerCase.equals("mx")) {
                    c2 = 142;
                    break;
                }
                c2 = 65535;
                break;
            case 3500:
                if (lowerCase.equals("my")) {
                    c2 = 143;
                    break;
                }
                c2 = 65535;
                break;
            case 3501:
                if (lowerCase.equals("mz")) {
                    c2 = 144;
                    break;
                }
                c2 = 65535;
                break;
            case 3507:
                if (lowerCase.equals("na")) {
                    c2 = 145;
                    break;
                }
                c2 = 65535;
                break;
            case 3509:
                if (lowerCase.equals("nc")) {
                    c2 = 146;
                    break;
                }
                c2 = 65535;
                break;
            case 3511:
                if (lowerCase.equals("ne")) {
                    c2 = 147;
                    break;
                }
                c2 = 65535;
                break;
            case 3513:
                if (lowerCase.equals("ng")) {
                    c2 = 148;
                    break;
                }
                c2 = 65535;
                break;
            case 3515:
                if (lowerCase.equals("ni")) {
                    c2 = 149;
                    break;
                }
                c2 = 65535;
                break;
            case 3518:
                if (lowerCase.equals("nl")) {
                    c2 = 150;
                    break;
                }
                c2 = 65535;
                break;
            case 3521:
                if (lowerCase.equals("no")) {
                    c2 = 151;
                    break;
                }
                c2 = 65535;
                break;
            case 3522:
                if (lowerCase.equals("np")) {
                    c2 = 152;
                    break;
                }
                c2 = 65535;
                break;
            case 3524:
                if (lowerCase.equals("nr")) {
                    c2 = 153;
                    break;
                }
                c2 = 65535;
                break;
            case 3527:
                if (lowerCase.equals("nu")) {
                    c2 = 154;
                    break;
                }
                c2 = 65535;
                break;
            case 3532:
                if (lowerCase.equals("nz")) {
                    c2 = 155;
                    break;
                }
                c2 = 65535;
                break;
            case 3550:
                if (lowerCase.equals("om")) {
                    c2 = 156;
                    break;
                }
                c2 = 65535;
                break;
            case 3569:
                if (lowerCase.equals("pa")) {
                    c2 = 157;
                    break;
                }
                c2 = 65535;
                break;
            case 3573:
                if (lowerCase.equals("pe")) {
                    c2 = 158;
                    break;
                }
                c2 = 65535;
                break;
            case 3574:
                if (lowerCase.equals("pf")) {
                    c2 = 159;
                    break;
                }
                c2 = 65535;
                break;
            case 3575:
                if (lowerCase.equals("pg")) {
                    c2 = 160;
                    break;
                }
                c2 = 65535;
                break;
            case 3576:
                if (lowerCase.equals("ph")) {
                    c2 = 161;
                    break;
                }
                c2 = 65535;
                break;
            case 3579:
                if (lowerCase.equals("pk")) {
                    c2 = 162;
                    break;
                }
                c2 = 65535;
                break;
            case 3580:
                if (lowerCase.equals("pl")) {
                    c2 = 163;
                    break;
                }
                c2 = 65535;
                break;
            case 3581:
                if (lowerCase.equals("pm")) {
                    c2 = 164;
                    break;
                }
                c2 = 65535;
                break;
            case 3582:
                if (lowerCase.equals("pn")) {
                    c2 = 165;
                    break;
                }
                c2 = 65535;
                break;
            case 3586:
                if (lowerCase.equals("pr")) {
                    c2 = 166;
                    break;
                }
                c2 = 65535;
                break;
            case 3587:
                if (lowerCase.equals("ps")) {
                    c2 = 167;
                    break;
                }
                c2 = 65535;
                break;
            case 3588:
                if (lowerCase.equals("pt")) {
                    c2 = 168;
                    break;
                }
                c2 = 65535;
                break;
            case 3591:
                if (lowerCase.equals("pw")) {
                    c2 = 169;
                    break;
                }
                c2 = 65535;
                break;
            case 3593:
                if (lowerCase.equals("py")) {
                    c2 = 170;
                    break;
                }
                c2 = 65535;
                break;
            case 3600:
                if (lowerCase.equals("qa")) {
                    c2 = 171;
                    break;
                }
                c2 = 65535;
                break;
            case 3635:
                if (lowerCase.equals("re")) {
                    c2 = 172;
                    break;
                }
                c2 = 65535;
                break;
            case 3645:
                if (lowerCase.equals("ro")) {
                    c2 = 173;
                    break;
                }
                c2 = 65535;
                break;
            case 3649:
                if (lowerCase.equals("rs")) {
                    c2 = 174;
                    break;
                }
                c2 = 65535;
                break;
            case 3651:
                if (lowerCase.equals("ru")) {
                    c2 = 175;
                    break;
                }
                c2 = 65535;
                break;
            case 3653:
                if (lowerCase.equals("rw")) {
                    c2 = 176;
                    break;
                }
                c2 = 65535;
                break;
            case 3662:
                if (lowerCase.equals("sa")) {
                    c2 = 177;
                    break;
                }
                c2 = 65535;
                break;
            case 3663:
                if (lowerCase.equals("sb")) {
                    c2 = 178;
                    break;
                }
                c2 = 65535;
                break;
            case 3664:
                if (lowerCase.equals("sc")) {
                    c2 = 179;
                    break;
                }
                c2 = 65535;
                break;
            case 3665:
                if (lowerCase.equals("sd")) {
                    c2 = 180;
                    break;
                }
                c2 = 65535;
                break;
            case 3666:
                if (lowerCase.equals("se")) {
                    c2 = 181;
                    break;
                }
                c2 = 65535;
                break;
            case 3668:
                if (lowerCase.equals("sg")) {
                    c2 = 182;
                    break;
                }
                c2 = 65535;
                break;
            case 3669:
                if (lowerCase.equals("sh")) {
                    c2 = 183;
                    break;
                }
                c2 = 65535;
                break;
            case 3670:
                if (lowerCase.equals("si")) {
                    c2 = 184;
                    break;
                }
                c2 = 65535;
                break;
            case 3672:
                if (lowerCase.equals("sk")) {
                    c2 = 185;
                    break;
                }
                c2 = 65535;
                break;
            case 3673:
                if (lowerCase.equals("sl")) {
                    c2 = 186;
                    break;
                }
                c2 = 65535;
                break;
            case 3674:
                if (lowerCase.equals("sm")) {
                    c2 = 187;
                    break;
                }
                c2 = 65535;
                break;
            case 3675:
                if (lowerCase.equals("sn")) {
                    c2 = 188;
                    break;
                }
                c2 = 65535;
                break;
            case 3676:
                if (lowerCase.equals("so")) {
                    c2 = 189;
                    break;
                }
                c2 = 65535;
                break;
            case 3679:
                if (lowerCase.equals("sr")) {
                    c2 = 190;
                    break;
                }
                c2 = 65535;
                break;
            case 3681:
                if (lowerCase.equals("st")) {
                    c2 = 191;
                    break;
                }
                c2 = 65535;
                break;
            case 3683:
                if (lowerCase.equals("sv")) {
                    c2 = 192;
                    break;
                }
                c2 = 65535;
                break;
            case 3685:
                if (lowerCase.equals("sx")) {
                    c2 = 193;
                    break;
                }
                c2 = 65535;
                break;
            case 3686:
                if (lowerCase.equals("sy")) {
                    c2 = 194;
                    break;
                }
                c2 = 65535;
                break;
            case 3687:
                if (lowerCase.equals("sz")) {
                    c2 = 195;
                    break;
                }
                c2 = 65535;
                break;
            case 3695:
                if (lowerCase.equals("tc")) {
                    c2 = 196;
                    break;
                }
                c2 = 65535;
                break;
            case 3696:
                if (lowerCase.equals("td")) {
                    c2 = 197;
                    break;
                }
                c2 = 65535;
                break;
            case 3699:
                if (lowerCase.equals("tg")) {
                    c2 = 198;
                    break;
                }
                c2 = 65535;
                break;
            case 3700:
                if (lowerCase.equals("th")) {
                    c2 = 199;
                    break;
                }
                c2 = 65535;
                break;
            case 3702:
                if (lowerCase.equals("tj")) {
                    c2 = 200;
                    break;
                }
                c2 = 65535;
                break;
            case 3703:
                if (lowerCase.equals("tk")) {
                    c2 = 201;
                    break;
                }
                c2 = 65535;
                break;
            case 3704:
                if (lowerCase.equals("tl")) {
                    c2 = 202;
                    break;
                }
                c2 = 65535;
                break;
            case 3705:
                if (lowerCase.equals("tm")) {
                    c2 = 203;
                    break;
                }
                c2 = 65535;
                break;
            case 3706:
                if (lowerCase.equals("tn")) {
                    c2 = 204;
                    break;
                }
                c2 = 65535;
                break;
            case 3707:
                if (lowerCase.equals("to")) {
                    c2 = 205;
                    break;
                }
                c2 = 65535;
                break;
            case 3710:
                if (lowerCase.equals("tr")) {
                    c2 = 206;
                    break;
                }
                c2 = 65535;
                break;
            case 3712:
                if (lowerCase.equals("tt")) {
                    c2 = 207;
                    break;
                }
                c2 = 65535;
                break;
            case 3714:
                if (lowerCase.equals("tv")) {
                    c2 = 208;
                    break;
                }
                c2 = 65535;
                break;
            case 3715:
                if (lowerCase.equals("tw")) {
                    c2 = 209;
                    break;
                }
                c2 = 65535;
                break;
            case 3718:
                if (lowerCase.equals("tz")) {
                    c2 = 210;
                    break;
                }
                c2 = 65535;
                break;
            case 3724:
                if (lowerCase.equals("ua")) {
                    c2 = 211;
                    break;
                }
                c2 = 65535;
                break;
            case 3730:
                if (lowerCase.equals("ug")) {
                    c2 = 212;
                    break;
                }
                c2 = 65535;
                break;
            case 3742:
                if (lowerCase.equals("us")) {
                    c2 = 213;
                    break;
                }
                c2 = 65535;
                break;
            case 3748:
                if (lowerCase.equals("uy")) {
                    c2 = 214;
                    break;
                }
                c2 = 65535;
                break;
            case 3749:
                if (lowerCase.equals("uz")) {
                    c2 = 215;
                    break;
                }
                c2 = 65535;
                break;
            case 3755:
                if (lowerCase.equals("va")) {
                    c2 = 216;
                    break;
                }
                c2 = 65535;
                break;
            case 3757:
                if (lowerCase.equals("vc")) {
                    c2 = 217;
                    break;
                }
                c2 = 65535;
                break;
            case 3759:
                if (lowerCase.equals("ve")) {
                    c2 = 218;
                    break;
                }
                c2 = 65535;
                break;
            case 3761:
                if (lowerCase.equals("vg")) {
                    c2 = 219;
                    break;
                }
                c2 = 65535;
                break;
            case 3763:
                if (lowerCase.equals("vi")) {
                    c2 = 220;
                    break;
                }
                c2 = 65535;
                break;
            case 3768:
                if (lowerCase.equals("vn")) {
                    c2 = 221;
                    break;
                }
                c2 = 65535;
                break;
            case 3775:
                if (lowerCase.equals("vu")) {
                    c2 = 222;
                    break;
                }
                c2 = 65535;
                break;
            case 3791:
                if (lowerCase.equals("wf")) {
                    c2 = 223;
                    break;
                }
                c2 = 65535;
                break;
            case 3804:
                if (lowerCase.equals("ws")) {
                    c2 = 224;
                    break;
                }
                c2 = 65535;
                break;
            case 3827:
                if (lowerCase.equals("xk")) {
                    c2 = 225;
                    break;
                }
                c2 = 65535;
                break;
            case 3852:
                if (lowerCase.equals("ye")) {
                    c2 = 226;
                    break;
                }
                c2 = 65535;
                break;
            case 3867:
                if (lowerCase.equals("yt")) {
                    c2 = 227;
                    break;
                }
                c2 = 65535;
                break;
            case 3879:
                if (lowerCase.equals("za")) {
                    c2 = 228;
                    break;
                }
                c2 = 65535;
                break;
            case 3891:
                if (lowerCase.equals("zm")) {
                    c2 = 229;
                    break;
                }
                c2 = 65535;
                break;
            case 3901:
                if (lowerCase.equals("zw")) {
                    c2 = 230;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                return R.drawable.flag_andorra;
            case 1:
                return R.drawable.flag_uae;
            case 2:
                return R.drawable.flag_afghanistan;
            case 3:
                return R.drawable.flag_antigua_and_barbuda;
            case 4:
                return R.drawable.flag_anguilla;
            case 5:
                return R.drawable.flag_albania;
            case 6:
                return R.drawable.flag_armenia;
            case 7:
                return R.drawable.flag_angola;
            case '\b':
                return R.drawable.flag_antarctica;
            case '\t':
                return R.drawable.flag_argentina;
            case '\n':
                return R.drawable.flag_austria;
            case 11:
                return R.drawable.flag_australia;
            case '\f':
                return R.drawable.flag_aruba;
            case '\r':
                return R.drawable.flag_azerbaijan;
            case 14:
                return R.drawable.flag_bosnia;
            case 15:
                return R.drawable.flag_barbados;
            case 16:
                return R.drawable.flag_bangladesh;
            case 17:
                return R.drawable.flag_belgium;
            case 18:
                return R.drawable.flag_burkina_faso;
            case 19:
                return R.drawable.flag_bulgaria;
            case 20:
                return R.drawable.flag_bahrain;
            case 21:
                return R.drawable.flag_burundi;
            case 22:
                return R.drawable.flag_benin;
            case 23:
                return R.drawable.flag_saint_barthelemy;
            case 24:
                return R.drawable.flag_bermuda;
            case 25:
                return R.drawable.flag_brunei;
            case 26:
                return R.drawable.flag_bolivia;
            case 27:
                return R.drawable.flag_brazil;
            case 28:
                return R.drawable.flag_bahamas;
            case 29:
                return R.drawable.flag_bhutan;
            case 30:
                return R.drawable.flag_botswana;
            case 31:
                return R.drawable.flag_belarus;
            case ' ':
                return R.drawable.flag_belize;
            case '!':
                return R.drawable.flag_canada;
            case '\"':
                return R.drawable.flag_cocos;
            case '#':
                return R.drawable.flag_democratic_republic_of_the_congo;
            case '$':
                return R.drawable.flag_central_african_republic;
            case '%':
                return R.drawable.flag_republic_of_the_congo;
            case '&':
                return R.drawable.flag_switzerland;
            case '\'':
                return R.drawable.flag_cote_divoire;
            case '(':
                return R.drawable.flag_cook_islands;
            case ')':
                return R.drawable.flag_chile;
            case '*':
                return R.drawable.flag_cameroon;
            case '+':
                return R.drawable.flag_china;
            case ',':
                return R.drawable.flag_colombia;
            case '-':
                return R.drawable.flag_costa_rica;
            case '.':
                return R.drawable.flag_cuba;
            case '/':
                return R.drawable.flag_cape_verde;
            case '0':
                return R.drawable.flag_christmas_island;
            case '1':
                return R.drawable.flag_cyprus;
            case '2':
                return R.drawable.flag_czech_republic;
            case '3':
                return R.drawable.flag_germany;
            case '4':
                return R.drawable.flag_djibouti;
            case '5':
                return R.drawable.flag_denmark;
            case '6':
                return R.drawable.flag_dominica;
            case '7':
                return R.drawable.flag_dominican_republic;
            case '8':
                return R.drawable.flag_algeria;
            case '9':
                return R.drawable.flag_ecuador;
            case ':':
                return R.drawable.flag_estonia;
            case ';':
                return R.drawable.flag_egypt;
            case '<':
                return R.drawable.flag_eritrea;
            case '=':
                return R.drawable.flag_spain;
            case '>':
                return R.drawable.flag_ethiopia;
            case '?':
                return R.drawable.flag_finland;
            case '@':
                return R.drawable.flag_fiji;
            case 'A':
                return R.drawable.flag_falkland_islands;
            case 'B':
                return R.drawable.flag_micronesia;
            case 'C':
                return R.drawable.flag_faroe_islands;
            case 'D':
                return R.drawable.flag_france;
            case 'E':
                return R.drawable.flag_gabon;
            case 'F':
                return R.drawable.flag_united_kingdom;
            case 'G':
                return R.drawable.flag_grenada;
            case 'H':
                return R.drawable.flag_georgia;
            case 'I':
                return R.drawable.flag_guyane;
            case 'J':
                return R.drawable.flag_ghana;
            case 'K':
                return R.drawable.flag_gibraltar;
            case 'L':
                return R.drawable.flag_greenland;
            case 'M':
                return R.drawable.flag_gambia;
            case 'N':
                return R.drawable.flag_guinea;
            case 'O':
                return R.drawable.flag_guadeloupe;
            case 'P':
                return R.drawable.flag_equatorial_guinea;
            case 'Q':
                return R.drawable.flag_greece;
            case 'R':
                return R.drawable.flag_guatemala;
            case 'S':
                return R.drawable.flag_guinea_bissau;
            case 'T':
                return R.drawable.flag_guyana;
            case 'U':
                return R.drawable.flag_hong_kong;
            case 'V':
                return R.drawable.flag_honduras;
            case 'W':
                return R.drawable.flag_croatia;
            case 'X':
                return R.drawable.flag_haiti;
            case 'Y':
                return R.drawable.flag_hungary;
            case 'Z':
                return R.drawable.flag_indonesia;
            case '[':
                return R.drawable.flag_ireland;
            case '\\':
                return R.drawable.flag_israel;
            case ']':
                return R.drawable.flag_isleof_man;
            case '^':
                return R.drawable.flag_iceland;
            case '_':
                return R.drawable.flag_india;
            case '`':
                return R.drawable.flag_iraq_new;
            case 'a':
                return R.drawable.flag_iran;
            case 'b':
                return R.drawable.flag_italy;
            case 'c':
                return R.drawable.flag_jamaica;
            case 'd':
                return R.drawable.flag_jordan;
            case 'e':
                return R.drawable.flag_japan;
            case 'f':
                return R.drawable.flag_kenya;
            case 'g':
                return R.drawable.flag_kyrgyzstan;
            case 'h':
                return R.drawable.flag_cambodia;
            case 'i':
                return R.drawable.flag_kiribati;
            case 'j':
                return R.drawable.flag_comoros;
            case 'k':
                return R.drawable.flag_saint_kitts_and_nevis;
            case 'l':
                return R.drawable.flag_north_korea;
            case 'm':
                return R.drawable.flag_south_korea;
            case 'n':
                return R.drawable.flag_kuwait;
            case 'o':
                return R.drawable.flag_cayman_islands;
            case 'p':
                return R.drawable.flag_kazakhstan;
            case 'q':
                return R.drawable.flag_laos;
            case 'r':
                return R.drawable.flag_lebanon;
            case 's':
                return R.drawable.flag_saint_lucia;
            case 't':
                return R.drawable.flag_liechtenstein;
            case 'u':
                return R.drawable.flag_sri_lanka;
            case 'v':
                return R.drawable.flag_liberia;
            case 'w':
                return R.drawable.flag_lesotho;
            case 'x':
                return R.drawable.flag_lithuania;
            case 'y':
                return R.drawable.flag_luxembourg;
            case 'z':
                return R.drawable.flag_latvia;
            case '{':
                return R.drawable.flag_libya;
            case '|':
                return R.drawable.flag_morocco;
            case '}':
                return R.drawable.flag_monaco;
            case '~':
                return R.drawable.flag_moldova;
            case 127:
                return R.drawable.flag_of_montenegro;
            case 128:
                return R.drawable.flag_madagascar;
            case 129:
                return R.drawable.flag_marshall_islands;
            case 130:
                return R.drawable.flag_macedonia;
            case 131:
                return R.drawable.flag_mali;
            case 132:
                return R.drawable.flag_myanmar;
            case 133:
                return R.drawable.flag_mongolia;
            case 134:
                return R.drawable.flag_macao;
            case 135:
                return R.drawable.flag_martinique;
            case 136:
                return R.drawable.flag_mauritania;
            case 137:
                return R.drawable.flag_montserrat;
            case 138:
                return R.drawable.flag_malta;
            case 139:
                return R.drawable.flag_mauritius;
            case 140:
                return R.drawable.flag_maldives;
            case 141:
                return R.drawable.flag_malawi;
            case 142:
                return R.drawable.flag_mexico;
            case 143:
                return R.drawable.flag_malaysia;
            case 144:
                return R.drawable.flag_mozambique;
            case 145:
                return R.drawable.flag_namibia;
            case 146:
                return R.drawable.flag_new_caledonia;
            case 147:
                return R.drawable.flag_niger;
            case 148:
                return R.drawable.flag_nigeria;
            case 149:
                return R.drawable.flag_nicaragua;
            case 150:
                return R.drawable.flag_netherlands;
            case 151:
                return R.drawable.flag_norway;
            case 152:
                return R.drawable.flag_nepal;
            case 153:
                return R.drawable.flag_nauru;
            case 154:
                return R.drawable.flag_niue;
            case 155:
                return R.drawable.flag_new_zealand;
            case 156:
                return R.drawable.flag_oman;
            case 157:
                return R.drawable.flag_panama;
            case 158:
                return R.drawable.flag_peru;
            case 159:
                return R.drawable.flag_french_polynesia;
            case 160:
                return R.drawable.flag_papua_new_guinea;
            case 161:
                return R.drawable.flag_philippines;
            case 162:
                return R.drawable.flag_pakistan;
            case 163:
                return R.drawable.flag_poland;
            case 164:
                return R.drawable.flag_saint_pierre;
            case 165:
                return R.drawable.flag_pitcairn_islands;
            case 166:
                return R.drawable.flag_puerto_rico;
            case 167:
                return R.drawable.flag_palestine;
            case 168:
                return R.drawable.flag_portugal;
            case 169:
                return R.drawable.flag_palau;
            case 170:
                return R.drawable.flag_paraguay;
            case 171:
                return R.drawable.flag_qatar;
            case 172:
                return R.drawable.flag_martinique;
            case 173:
                return R.drawable.flag_romania;
            case 174:
                return R.drawable.flag_serbia;
            case 175:
                return R.drawable.flag_russian_federation;
            case 176:
                return R.drawable.flag_rwanda;
            case 177:
                return R.drawable.flag_saudi_arabia;
            case 178:
                return R.drawable.flag_soloman_islands;
            case 179:
                return R.drawable.flag_seychelles;
            case 180:
                return R.drawable.flag_sudan;
            case 181:
                return R.drawable.flag_sweden;
            case 182:
                return R.drawable.flag_singapore;
            case 183:
                return R.drawable.flag_saint_helena;
            case 184:
                return R.drawable.flag_slovenia;
            case 185:
                return R.drawable.flag_slovakia;
            case 186:
                return R.drawable.flag_sierra_leone;
            case 187:
                return R.drawable.flag_san_marino;
            case 188:
                return R.drawable.flag_senegal;
            case 189:
                return R.drawable.flag_somalia;
            case 190:
                return R.drawable.flag_suriname;
            case 191:
                return R.drawable.flag_sao_tome_and_principe;
            case 192:
                return R.drawable.flag_el_salvador;
            case 193:
                return R.drawable.flag_sint_maarten;
            case 194:
                return R.drawable.flag_syria;
            case 195:
                return R.drawable.flag_swaziland;
            case 196:
                return R.drawable.flag_turks_and_caicos_islands;
            case 197:
                return R.drawable.flag_chad;
            case 198:
                return R.drawable.flag_togo;
            case 199:
                return R.drawable.flag_thailand;
            case AndroidLog.REFRESH_LEVEL_CACHE_EVERY /* 200 */:
                return R.drawable.flag_tajikistan;
            case 201:
                return R.drawable.flag_tokelau;
            case 202:
                return R.drawable.flag_timor_leste;
            case 203:
                return R.drawable.flag_turkmenistan;
            case 204:
                return R.drawable.flag_tunisia;
            case 205:
                return R.drawable.flag_tonga;
            case 206:
                return R.drawable.flag_turkey;
            case 207:
                return R.drawable.flag_trinidad_and_tobago;
            case 208:
                return R.drawable.flag_tuvalu;
            case 209:
                return R.drawable.flag_taiwan;
            case 210:
                return R.drawable.flag_tanzania;
            case 211:
                return R.drawable.flag_ukraine;
            case 212:
                return R.drawable.flag_uganda;
            case 213:
                return R.drawable.flag_united_states_of_america;
            case 214:
                return R.drawable.flag_uruguay;
            case 215:
                return R.drawable.flag_uzbekistan;
            case 216:
                return R.drawable.flag_vatican_city;
            case 217:
                return R.drawable.flag_saint_vicent_and_the_grenadines;
            case 218:
                return R.drawable.flag_venezuela;
            case 219:
                return R.drawable.flag_british_virgin_islands;
            case 220:
                return R.drawable.flag_us_virgin_islands;
            case 221:
                return R.drawable.flag_vietnam;
            case 222:
                return R.drawable.flag_vanuatu;
            case 223:
                return R.drawable.flag_wallis_and_futuna;
            case 224:
                return R.drawable.flag_samoa;
            case 225:
                return R.drawable.flag_kosovo;
            case 226:
                return R.drawable.flag_yemen;
            case 227:
                return R.drawable.flag_martinique;
            case 228:
                return R.drawable.flag_south_africa;
            case 229:
                return R.drawable.flag_zambia;
            case 230:
                return R.drawable.flag_zimbabwe;
            default:
                return R.drawable.flag_transparent;
        }
    }

    public static CCPCountry a(Context context, List<CCPCountry> list, CountryCodePicker.Language language, String str) {
        if (list != null && list.size() != 0) {
            for (CCPCountry cCPCountry : list) {
                if (cCPCountry.e().equalsIgnoreCase(str)) {
                    return cCPCountry;
                }
            }
            return null;
        }
        return a(context, language, str);
    }

    public static CCPCountry a(Context context, CountryCodePicker.Language language, String str) {
        for (CCPCountry cCPCountry : b(context, language)) {
            if (cCPCountry.e().equalsIgnoreCase(str)) {
                return cCPCountry;
            }
        }
        return null;
    }

    public int c() {
        if (this.f4116e == -99) {
            this.f4116e = b(this);
        }
        return this.f4116e;
    }

    public static CCPCountry a(Context context, CountryCodePicker.Language language, List<CCPCountry> list, int i2) {
        return b(context, language, list, i2 + "");
    }

    public static CCPCountry a(Context context, CountryCodePicker.Language language, List<CCPCountry> list, String str) {
        String str2 = "";
        String replace = str.replace("+", "");
        String str3 = f4109g;
        Log.d(str3, "getCountry44ForAreaCode: Phone is" + replace);
        if (replace.length() >= 6 && replace.startsWith("44")) {
            str2 = replace.substring(2, 6);
        }
        String str4 = f4109g;
        Log.d(str4, "getCountry44ForAreaCode: Area Code is" + str2);
        if (str2.length() != 4) {
            return null;
        }
        return a(context, language, I.contains(str2) ? "im" : "gb");
    }

    public void c(String str) {
        this.f4114c = str;
    }

    public boolean a(String str) {
        String lowerCase = str.toLowerCase();
        return d().toLowerCase().contains(lowerCase) || e().toLowerCase().contains(lowerCase) || f().toLowerCase().contains(lowerCase) || b().toLowerCase().contains(lowerCase);
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(CCPCountry cCPCountry) {
        return Collator.getInstance().compare(d(), cCPCountry.d());
    }

    public void d(String str) {
        this.f4112a = str;
    }

    public String d() {
        return this.f4114c;
    }

    public String e() {
        return this.f4112a;
    }

    public void e(String str) {
        this.f4113b = str;
    }

    public static List<CCPCountry> b(Context context, CountryCodePicker.Language language) {
        List<CCPCountry> list;
        CountryCodePicker.Language language2 = f4110h;
        if (language2 == null || language != language2 || (list = m) == null || list.size() == 0) {
            e(context, language);
        }
        return m;
    }

    public String b() {
        return this.f4115d;
    }

    public void b(String str) {
        this.f4115d = str;
    }
}
