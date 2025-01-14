package a.b.h.k;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
/* compiled from: AppCompatCheckedTextView.java */
/* loaded from: classes.dex */
public class i extends CheckedTextView {

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f1739b = {16843016};

    /* renamed from: a  reason: collision with root package name */
    public final y f1740a;

    public i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        y yVar = this.f1740a;
        if (yVar != null) {
            yVar.a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        m.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i2) {
        setCheckMarkDrawable(a.b.h.d.a.a.c(getContext(), i2));
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(a.b.g.l.p.a(this, callback));
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        y yVar = this.f1740a;
        if (yVar != null) {
            yVar.a(context, i2);
        }
    }

    public i(Context context, AttributeSet attributeSet, int i2) {
        super(i1.b(context), attributeSet, i2);
        this.f1740a = new y(this);
        this.f1740a.a(attributeSet, i2);
        this.f1740a.a();
        l1 a2 = l1.a(getContext(), attributeSet, f1739b, i2, 0);
        setCheckMarkDrawable(a2.b(0));
        a2.a();
    }
}
