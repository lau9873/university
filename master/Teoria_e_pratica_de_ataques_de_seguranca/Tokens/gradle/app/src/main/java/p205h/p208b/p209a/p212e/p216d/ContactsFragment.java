package p205h.p208b.p209a.p212e.p216d;

import android.os.Bundle;
import android.support.p067v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbb20.C1444R;

/* renamed from: h.b.a.e.d.j3 */
/* loaded from: classes.dex */
public class ContactsFragment extends AbstractFragment implements View.OnClickListener {

    /* renamed from: c0 */
    public Toolbar f9979c0;

    /* renamed from: d0 */
    public TextView f9980d0;

    /* renamed from: e0 */
    public TextView f9981e0;

    /* renamed from: f0 */
    public TextView f9982f0;

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public View mo717a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(C1444R.layout.fragment_contacts, viewGroup, false);
        this.f9979c0 = (Toolbar) viewGroup2.findViewById(C1444R.C1446id.toolbar);
        this.f9979c0.setNavigationIcon(C1444R.C1445drawable.ic_arrow_back_white_24dp);
        this.f9979c0.setNavigationContentDescription(C1444R.string.action_back);
        this.f9979c0.setNavigationOnClickListener(this);
        this.f9980d0 = (TextView) viewGroup2.findViewById(C1444R.C1446id.phone);
        this.f9981e0 = (TextView) viewGroup2.findViewById(C1444R.C1446id.phone2);
        this.f9982f0 = (TextView) viewGroup2.findViewById(C1444R.C1446id.email);
        this.f9980d0.setText(Html.fromHtml(m7528a(C1444R.string.contacts_linhandante_phone)));
        this.f9981e0.setText(Html.fromHtml(m7528a(C1444R.string.contacts_linhandante_phone2)));
        this.f9982f0.setText(Html.fromHtml(m7528a(C1444R.string.contacts_email_andante_email)));
        this.f9980d0.setMovementMethod(LinkMovementMethod.getInstance());
        this.f9981e0.setMovementMethod(LinkMovementMethod.getInstance());
        this.f9982f0.setMovementMethod(LinkMovementMethod.getInstance());
        return viewGroup2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m1151n0();
    }
}
