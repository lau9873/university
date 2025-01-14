package p000a.p006b.p049h.p063k;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.p067v7.widget.SearchView;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.j256.ormlite.logger.Logger;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;
import p000a.p006b.p030g.p032b.ContextCompat;
import p000a.p006b.p030g.p048l.ResourceCursorAdapter;
import p000a.p006b.p049h.p051b.C0354a;
import p000a.p006b.p049h.p051b.C0359f;

/* renamed from: a.b.h.k.f1 */
/* loaded from: classes.dex */
public class SuggestionsAdapter extends ResourceCursorAdapter implements View.OnClickListener {

    /* renamed from: m */
    public final SearchView f2616m;

    /* renamed from: n */
    public final SearchableInfo f2617n;

    /* renamed from: o */
    public final Context f2618o;

    /* renamed from: p */
    public final WeakHashMap<String, Drawable.ConstantState> f2619p;

    /* renamed from: q */
    public final int f2620q;

    /* renamed from: r */
    public boolean f2621r;

    /* renamed from: s */
    public int f2622s;

    /* renamed from: t */
    public ColorStateList f2623t;

    /* renamed from: u */
    public int f2624u;

    /* renamed from: v */
    public int f2625v;

    /* renamed from: w */
    public int f2626w;

    /* renamed from: x */
    public int f2627x;

    /* renamed from: y */
    public int f2628y;

    /* renamed from: z */
    public int f2629z;

    /* compiled from: SuggestionsAdapter.java */
    /* renamed from: a.b.h.k.f1$a */
    /* loaded from: classes.dex */
    public static final class C0457a {

        /* renamed from: a */
        public final TextView f2630a;

        /* renamed from: b */
        public final TextView f2631b;

        /* renamed from: c */
        public final ImageView f2632c;

        /* renamed from: d */
        public final ImageView f2633d;

        /* renamed from: e */
        public final ImageView f2634e;

        public C0457a(View view) {
            this.f2630a = (TextView) view.findViewById(16908308);
            this.f2631b = (TextView) view.findViewById(16908309);
            this.f2632c = (ImageView) view.findViewById(16908295);
            this.f2633d = (ImageView) view.findViewById(16908296);
            this.f2634e = (ImageView) view.findViewById(C0359f.edit_query);
        }
    }

    public SuggestionsAdapter(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f2621r = false;
        this.f2622s = 1;
        this.f2624u = -1;
        this.f2625v = -1;
        this.f2626w = -1;
        this.f2627x = -1;
        this.f2628y = -1;
        this.f2629z = -1;
        SearchManager searchManager = (SearchManager) this.f1820d.getSystemService("search");
        this.f2616m = searchView;
        this.f2617n = searchableInfo;
        this.f2620q = searchView.getSuggestionCommitIconResId();
        this.f2618o = context;
        this.f2619p = weakHashMap;
    }

    /* renamed from: a */
    public void m8399a(int i) {
        this.f2622s = i;
    }

    @Override // p000a.p006b.p030g.p048l.ResourceCursorAdapter, p000a.p006b.p030g.p048l.CursorAdapter
    /* renamed from: b */
    public View mo8385b(Context context, Cursor cursor, ViewGroup viewGroup) {
        View mo8385b = super.mo8385b(context, cursor, viewGroup);
        mo8385b.setTag(new C0457a(mo8385b));
        ((ImageView) mo8385b.findViewById(C0359f.edit_query)).setImageResource(this.f2620q);
        return mo8385b;
    }

    /* renamed from: d */
    public final Drawable m8380d(Cursor cursor) {
        Drawable m8386b = m8386b(this.f2617n.getSearchActivity());
        return m8386b != null ? m8386b : this.f1820d.getPackageManager().getDefaultActivityIcon();
    }

    /* renamed from: e */
    public final Drawable m8379e(Cursor cursor) {
        int i = this.f2627x;
        if (i == -1) {
            return null;
        }
        Drawable m8381b = m8381b(cursor.getString(i));
        return m8381b != null ? m8381b : m8380d(cursor);
    }

    /* renamed from: f */
    public final Drawable m8378f(Cursor cursor) {
        int i = this.f2628y;
        if (i == -1) {
            return null;
        }
        return m8381b(cursor.getString(i));
    }

    /* renamed from: g */
    public final void m8377g(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    @Override // p000a.p006b.p030g.p048l.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View mo9219a = mo9219a(this.f1820d, this.f1819c, viewGroup);
            if (mo9219a != null) {
                ((C0457a) mo9219a.getTag()).f2630a.setText(e.toString());
            }
            return mo9219a;
        }
    }

    @Override // p000a.p006b.p030g.p048l.CursorAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View mo8385b = mo8385b(this.f1820d, this.f1819c, viewGroup);
            if (mo8385b != null) {
                ((C0457a) mo8385b.getTag()).f2630a.setText(e.toString());
            }
            return mo8385b;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m8377g(mo9244a());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m8377g(mo9244a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f2616m.m6513b((CharSequence) tag);
        }
    }

    @Override // p000a.p006b.p030g.p048l.CursorFilter.InterfaceC0316a
    /* renamed from: a */
    public Cursor mo8389a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f2616m.getVisibility() == 0 && this.f2616m.getWindowVisibility() == 0) {
            try {
                Cursor m8398a = m8398a(this.f2617n, charSequence2, 50);
                if (m8398a != null) {
                    m8398a.getCount();
                    return m8398a;
                }
            } catch (RuntimeException e) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
            }
        }
        return null;
    }

    /* renamed from: b */
    public final CharSequence m8382b(CharSequence charSequence) {
        if (this.f2623t == null) {
            TypedValue typedValue = new TypedValue();
            this.f1820d.getTheme().resolveAttribute(C0354a.textColorSearchUrl, typedValue, true);
            this.f2623t = this.f1820d.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f2623t, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    @Override // p000a.p006b.p030g.p048l.CursorAdapter, p000a.p006b.p030g.p048l.CursorFilter.InterfaceC0316a
    /* renamed from: a */
    public void mo8396a(Cursor cursor) {
        if (this.f2621r) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.mo8396a(cursor);
            if (cursor != null) {
                this.f2624u = cursor.getColumnIndex("suggest_text_1");
                this.f2625v = cursor.getColumnIndex("suggest_text_2");
                this.f2626w = cursor.getColumnIndex("suggest_text_2_url");
                this.f2627x = cursor.getColumnIndex("suggest_icon_1");
                this.f2628y = cursor.getColumnIndex("suggest_icon_2");
                this.f2629z = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    @Override // p000a.p006b.p030g.p048l.CursorAdapter, p000a.p006b.p030g.p048l.CursorFilter.InterfaceC0316a
    /* renamed from: b */
    public CharSequence mo8384b(Cursor cursor) {
        String m8394a;
        String m8394a2;
        if (cursor == null) {
            return null;
        }
        String m8394a3 = m8394a(cursor, "suggest_intent_query");
        if (m8394a3 != null) {
            return m8394a3;
        }
        if (!this.f2617n.shouldRewriteQueryFromData() || (m8394a2 = m8394a(cursor, "suggest_intent_data")) == null) {
            if (!this.f2617n.shouldRewriteQueryFromText() || (m8394a = m8394a(cursor, "suggest_text_1")) == null) {
                return null;
            }
            return m8394a;
        }
        return m8394a2;
    }

    /* renamed from: b */
    public final Drawable m8381b(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f2618o.getPackageName() + "/" + parseInt;
            Drawable m8388a = m8388a(str2);
            if (m8388a != null) {
                return m8388a;
            }
            Drawable m10016c = ContextCompat.m10016c(this.f2618o, parseInt);
            m8387a(str2, m10016c);
            return m10016c;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable m8388a2 = m8388a(str);
            if (m8388a2 != null) {
                return m8388a2;
            }
            Drawable m8393a = m8393a(Uri.parse(str));
            m8387a(str, m8393a);
            return m8393a;
        }
    }

    @Override // p000a.p006b.p030g.p048l.CursorAdapter
    /* renamed from: a */
    public void mo8392a(View view, Context context, Cursor cursor) {
        CharSequence m8395a;
        C0457a c0457a = (C0457a) view.getTag();
        int i = this.f2629z;
        int i2 = i != -1 ? cursor.getInt(i) : 0;
        if (c0457a.f2630a != null) {
            m8390a(c0457a.f2630a, m8395a(cursor, this.f2624u));
        }
        if (c0457a.f2631b != null) {
            String m8395a2 = m8395a(cursor, this.f2626w);
            if (m8395a2 != null) {
                m8395a = m8382b((CharSequence) m8395a2);
            } else {
                m8395a = m8395a(cursor, this.f2625v);
            }
            if (TextUtils.isEmpty(m8395a)) {
                TextView textView = c0457a.f2630a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    c0457a.f2630a.setMaxLines(2);
                }
            } else {
                TextView textView2 = c0457a.f2630a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    c0457a.f2630a.setMaxLines(1);
                }
            }
            m8390a(c0457a.f2631b, m8395a);
        }
        ImageView imageView = c0457a.f2632c;
        if (imageView != null) {
            m8391a(imageView, m8379e(cursor), 4);
        }
        ImageView imageView2 = c0457a.f2633d;
        if (imageView2 != null) {
            m8391a(imageView2, m8378f(cursor), 8);
        }
        int i3 = this.f2622s;
        if (i3 != 2 && (i3 != 1 || (i2 & 1) == 0)) {
            c0457a.f2634e.setVisibility(8);
            return;
        }
        c0457a.f2634e.setVisibility(0);
        c0457a.f2634e.setTag(c0457a.f2630a.getText());
        c0457a.f2634e.setOnClickListener(this);
    }

    /* renamed from: b */
    public final Drawable m8386b(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        if (this.f2619p.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState = this.f2619p.get(flattenToShortString);
            if (constantState == null) {
                return null;
            }
            return constantState.newDrawable(this.f2618o.getResources());
        }
        Drawable m8397a = m8397a(componentName);
        this.f2619p.put(flattenToShortString, m8397a != null ? m8397a.getConstantState() : null);
        return m8397a;
    }

    /* renamed from: b */
    public Drawable m8383b(Uri uri) {
        int parseInt;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f1820d.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            parseInt = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (parseInt != 0) {
                        return resourcesForApplication.getDrawable(parseInt);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        }
        throw new FileNotFoundException("No authority: " + uri);
    }

    /* renamed from: a */
    public final void m8390a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    /* renamed from: a */
    public final void m8391a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    /* renamed from: a */
    public final Drawable m8393a(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return m8383b(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream openInputStream = this.f2618o.getContentResolver().openInputStream(uri);
            if (openInputStream != null) {
                Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
                try {
                    openInputStream.close();
                } catch (IOException e) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e);
                }
                return createFromStream;
            }
            throw new FileNotFoundException("Failed to open " + uri);
        } catch (FileNotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e2.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e2.getMessage());
        return null;
    }

    /* renamed from: a */
    public final Drawable m8388a(String str) {
        Drawable.ConstantState constantState = this.f2619p.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    /* renamed from: a */
    public final void m8387a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f2619p.put(str, drawable.getConstantState());
        }
    }

    /* renamed from: a */
    public final Drawable m8397a(ComponentName componentName) {
        PackageManager packageManager = this.f1820d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, Logger.DEFAULT_FULL_MESSAGE_LENGTH);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable == null) {
                Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
                return null;
            }
            return drawable;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    /* renamed from: a */
    public static String m8394a(Cursor cursor, String str) {
        return m8395a(cursor, cursor.getColumnIndex(str));
    }

    /* renamed from: a */
    public static String m8395a(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    /* renamed from: a */
    public Cursor m8398a(SearchableInfo searchableInfo, String str, int i) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.f1820d.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }
}
