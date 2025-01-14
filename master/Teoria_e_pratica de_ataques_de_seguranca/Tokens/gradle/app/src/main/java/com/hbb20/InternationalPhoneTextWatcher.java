package com.hbb20;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import p136d.p149b.p150a.p151a.AsYouTypeFormatter;
import p136d.p149b.p150a.p151a.PhoneNumberUtil;

/* loaded from: classes.dex */
public class InternationalPhoneTextWatcher implements TextWatcher {

    /* renamed from: a */
    public PhoneNumberUtil f6329a;

    /* renamed from: c */
    public boolean f6331c;

    /* renamed from: d */
    public AsYouTypeFormatter f6332d;

    /* renamed from: f */
    public int f6334f;

    /* renamed from: b */
    public boolean f6330b = false;

    /* renamed from: e */
    public Editable f6333e = null;

    /* renamed from: g */
    public boolean f6335g = false;

    public InternationalPhoneTextWatcher(Context context, String str, int i) {
        if (str != null && str.length() != 0) {
            this.f6329a = PhoneNumberUtil.m3827a(context);
            m4258a(str, i);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    public void m4258a(String str, int i) {
        this.f6334f = i;
        this.f6332d = this.f6329a.m3809a(str);
        this.f6332d.m3842g();
        Editable editable = this.f6333e;
        if (editable != null) {
            this.f6335g = true;
            String m3792c = PhoneNumberUtil.m3792c(editable);
            Editable editable2 = this.f6333e;
            editable2.replace(0, editable2.length(), m3792c, 0, m3792c.length());
            this.f6335g = false;
        }
    }

    @Override // android.text.TextWatcher
    public synchronized void afterTextChanged(Editable editable) {
        boolean z = true;
        if (this.f6331c) {
            if (editable.length() == 0) {
                z = false;
            }
            this.f6331c = z;
        } else if (!this.f6330b) {
            int selectionEnd = Selection.getSelectionEnd(editable);
            boolean z2 = selectionEnd == editable.length();
            String m4260a = m4260a(editable);
            if (!m4260a.equals(editable.toString())) {
                if (z2) {
                    selectionEnd = m4260a.length();
                } else {
                    int i = 0;
                    for (int i2 = 0; i2 < editable.length() && i2 < selectionEnd; i2++) {
                        if (PhoneNumberUtils.isNonSeparator(editable.charAt(i2))) {
                            i++;
                        }
                    }
                    selectionEnd = 0;
                    int i3 = 0;
                    while (true) {
                        if (selectionEnd >= m4260a.length()) {
                            selectionEnd = 0;
                            break;
                        } else if (i3 == i) {
                            break;
                        } else {
                            if (PhoneNumberUtils.isNonSeparator(m4260a.charAt(selectionEnd))) {
                                i3++;
                            }
                            selectionEnd++;
                        }
                    }
                }
            }
            if (!z2) {
                while (true) {
                    int i4 = selectionEnd - 1;
                    if (i4 <= 0 || PhoneNumberUtils.isNonSeparator(m4260a.charAt(i4))) {
                        break;
                    }
                    selectionEnd--;
                }
            }
            if (m4260a != null) {
                this.f6330b = true;
                editable.replace(0, editable.length(), m4260a, 0, m4260a.length());
                this.f6330b = false;
                this.f6333e = editable;
                Selection.setSelection(editable, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f6330b || this.f6331c || i2 <= 0 || !m4259a(charSequence, i, i2) || this.f6335g) {
            return;
        }
        m4261a();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f6330b || this.f6331c || i3 <= 0 || !m4259a(charSequence, i, i3)) {
            return;
        }
        m4261a();
    }

    /* renamed from: a */
    public final String m4260a(CharSequence charSequence) {
        String str;
        this.f6332d.m3842g();
        String str2 = "+" + this.f6334f;
        String str3 = str2 + ((Object) charSequence);
        int length = str3.length();
        String str4 = "";
        char c = 0;
        for (int i = 0; i < length; i++) {
            char charAt = str3.charAt(i);
            if (PhoneNumberUtils.isNonSeparator(charAt)) {
                if (c != 0) {
                    str4 = this.f6332d.m3859a(c);
                }
                c = charAt;
            }
        }
        if (c != 0) {
            str4 = this.f6332d.m3859a(c);
        }
        String trim = str4.trim();
        if (trim.length() <= str2.length()) {
            str = "";
        } else if (trim.charAt(str2.length()) == ' ') {
            str = trim.substring(str2.length() + 1);
        } else {
            str = trim.substring(str2.length());
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    /* renamed from: a */
    public final void m4261a() {
        this.f6331c = true;
        this.f6332d.m3842g();
    }

    /* renamed from: a */
    public final boolean m4259a(CharSequence charSequence, int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            if (!PhoneNumberUtils.isNonSeparator(charSequence.charAt(i3))) {
                return true;
            }
        }
        return false;
    }
}
