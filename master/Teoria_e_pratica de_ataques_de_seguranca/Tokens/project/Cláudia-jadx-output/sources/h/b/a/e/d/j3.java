package h.b.a.e.d;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/* compiled from: ContactsFragment.java */
/* loaded from: classes.dex */
public class j3 extends g3 implements View.OnClickListener {
    public Toolbar c0;
    public TextView d0;
    public TextView e0;
    public TextView f0;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(2131427377, viewGroup, false);
        this.c0 = (Toolbar) viewGroup2.findViewById(2131231152);
        this.c0.setNavigationIcon(2131165559);
        this.c0.setNavigationContentDescription(2131755050);
        this.c0.setNavigationOnClickListener(this);
        this.d0 = (TextView) viewGroup2.findViewById(2131230997);
        this.e0 = (TextView) viewGroup2.findViewById(2131230998);
        this.f0 = (TextView) viewGroup2.findViewById(2131230869);
        this.d0.setText(Html.fromHtml(a(2131755104)));
        this.e0.setText(Html.fromHtml(a(2131755105)));
        this.f0.setText(Html.fromHtml(a(2131755102)));
        this.d0.setMovementMethod(LinkMovementMethod.getInstance());
        this.e0.setMovementMethod(LinkMovementMethod.getInstance());
        this.f0.setMovementMethod(LinkMovementMethod.getInstance());
        return viewGroup2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        n0();
    }
}
