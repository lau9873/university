package com.hbb20;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import d.b.a.a.b;
import d.b.a.a.i;
/* loaded from: classes.dex */
public class InternationalPhoneTextWatcher implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    public i f4163a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4165c;

    /* renamed from: d  reason: collision with root package name */
    public b f4166d;

    /* renamed from: f  reason: collision with root package name */
    public int f4168f;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4164b = false;

    /* renamed from: e  reason: collision with root package name */
    public Editable f4167e = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4169g = false;

    public InternationalPhoneTextWatcher(Context context, String str, int i2) {
        if (str != null && str.length() != 0) {
            this.f4163a = i.a(context);
            a(str, i2);
            return;
        }
        throw new IllegalArgumentException();
    }

    public void a(String str, int i2) {
        this.f4168f = i2;
        this.f4166d = this.f4163a.a(str);
        this.f4166d.g();
        Editable editable = this.f4167e;
        if (editable != null) {
            this.f4169g = true;
            String c2 = i.c(editable);
            Editable editable2 = this.f4167e;
            editable2.replace(0, editable2.length(), c2, 0, c2.length());
            this.f4169g = false;
        }
    }

    @Override // android.text.TextWatcher
    public synchronized void afterTextChanged(Editable editable) {
        boolean z = true;
        if (this.f4165c) {
            if (editable.length() == 0) {
                z = false;
            }
            this.f4165c = z;
        } else if (!this.f4164b) {
            int selectionEnd = Selection.getSelectionEnd(editable);
            boolean z2 = selectionEnd == editable.length();
            String a2 = a(editable);
            if (!a2.equals(editable.toString())) {
                if (z2) {
                    selectionEnd = a2.length();
                } else {
                    int i2 = 0;
                    for (int i3 = 0; i3 < editable.length() && i3 < selectionEnd; i3++) {
                        if (PhoneNumberUtils.isNonSeparator(editable.charAt(i3))) {
                            i2++;
                        }
                    }
                    selectionEnd = 0;
                    int i4 = 0;
                    while (true) {
                        if (selectionEnd >= a2.length()) {
                            selectionEnd = 0;
                            break;
                        } else if (i4 == i2) {
                            break;
                        } else {
                            if (PhoneNumberUtils.isNonSeparator(a2.charAt(selectionEnd))) {
                                i4++;
                            }
                            selectionEnd++;
                        }
                    }
                }
            }
            if (!z2) {
                while (true) {
                    int i5 = selectionEnd - 1;
                    if (i5 <= 0 || PhoneNumberUtils.isNonSeparator(a2.charAt(i5))) {
                        break;
                    }
                    selectionEnd--;
                }
            }
            if (a2 != null) {
                this.f4164b = true;
                editable.replace(0, editable.length(), a2, 0, a2.length());
                this.f4164b = false;
                this.f4167e = editable;
                Selection.setSelection(editable, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (this.f4164b || this.f4165c || i3 <= 0 || !a(charSequence, i2, i3) || this.f4169g) {
            return;
        }
        a();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (this.f4164b || this.f4165c || i4 <= 0 || !a(charSequence, i2, i4)) {
            return;
        }
        a();
    }

    public final String a(CharSequence charSequence) {
        String str;
        this.f4166d.g();
        String str2 = "+" + this.f4168f;
        String str3 = str2 + ((Object) charSequence);
        int length = str3.length();
        String str4 = "";
        char c2 = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str3.charAt(i2);
            if (PhoneNumberUtils.isNonSeparator(charAt)) {
                if (c2 != 0) {
                    str4 = this.f4166d.a(c2);
                }
                c2 = charAt;
            }
        }
        if (c2 != 0) {
            str4 = this.f4166d.a(c2);
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

    public final void a() {
        this.f4165c = true;
        this.f4166d.g();
    }

    public final boolean a(CharSequence charSequence, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            if (!PhoneNumberUtils.isNonSeparator(charSequence.charAt(i4))) {
                return true;
            }
        }
        return false;
    }
}
