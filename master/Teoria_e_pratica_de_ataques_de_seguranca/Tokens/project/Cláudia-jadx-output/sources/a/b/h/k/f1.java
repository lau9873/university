package a.b.h.k;

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
import android.support.v7.widget.SearchView;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;
/* compiled from: SuggestionsAdapter.java */
/* loaded from: classes.dex */
public class f1 extends a.b.g.l.n implements View.OnClickListener {
    public final SearchView m;
    public final SearchableInfo n;
    public final Context o;
    public final WeakHashMap<String, Drawable.ConstantState> p;
    public final int q;
    public boolean r;
    public int s;
    public ColorStateList t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* compiled from: SuggestionsAdapter.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f1719a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f1720b;

        /* renamed from: c  reason: collision with root package name */
        public final ImageView f1721c;

        /* renamed from: d  reason: collision with root package name */
        public final ImageView f1722d;

        /* renamed from: e  reason: collision with root package name */
        public final ImageView f1723e;

        public a(View view) {
            this.f1719a = (TextView) view.findViewById(16908308);
            this.f1720b = (TextView) view.findViewById(16908309);
            this.f1721c = (ImageView) view.findViewById(16908295);
            this.f1722d = (ImageView) view.findViewById(16908296);
            this.f1723e = (ImageView) view.findViewById(a.b.h.b.f.edit_query);
        }
    }

    public f1(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.r = false;
        this.s = 1;
        this.u = -1;
        this.v = -1;
        this.w = -1;
        this.x = -1;
        this.y = -1;
        this.z = -1;
        SearchManager searchManager = (SearchManager) this.f1236d.getSystemService("search");
        this.m = searchView;
        this.n = searchableInfo;
        this.q = searchView.getSuggestionCommitIconResId();
        this.o = context;
        this.p = weakHashMap;
    }

    public void a(int i2) {
        this.s = i2;
    }

    @Override // a.b.g.l.n, a.b.g.l.f
    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        View b2 = super.b(context, cursor, viewGroup);
        b2.setTag(new a(b2));
        ((ImageView) b2.findViewById(a.b.h.b.f.edit_query)).setImageResource(this.q);
        return b2;
    }

    public final Drawable d(Cursor cursor) {
        Drawable b2 = b(this.n.getSearchActivity());
        return b2 != null ? b2 : this.f1236d.getPackageManager().getDefaultActivityIcon();
    }

    public final Drawable e(Cursor cursor) {
        int i2 = this.x;
        if (i2 == -1) {
            return null;
        }
        Drawable b2 = b(cursor.getString(i2));
        return b2 != null ? b2 : d(cursor);
    }

    public final Drawable f(Cursor cursor) {
        int i2 = this.y;
        if (i2 == -1) {
            return null;
        }
        return b(cursor.getString(i2));
    }

    public final void g(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    @Override // a.b.g.l.f, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View a2 = a(this.f1236d, this.f1235c, viewGroup);
            if (a2 != null) {
                ((a) a2.getTag()).f1719a.setText(e2.toString());
            }
            return a2;
        }
    }

    @Override // a.b.g.l.f, android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View b2 = b(this.f1236d, this.f1235c, viewGroup);
            if (b2 != null) {
                ((a) b2.getTag()).f1719a.setText(e2.toString());
            }
            return b2;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        g(a());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        g(a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.m.b((CharSequence) tag);
        }
    }

    @Override // a.b.g.l.g.a
    public Cursor a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.m.getVisibility() == 0 && this.m.getWindowVisibility() == 0) {
            try {
                Cursor a2 = a(this.n, charSequence2, 50);
                if (a2 != null) {
                    a2.getCount();
                    return a2;
                }
            } catch (RuntimeException e2) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e2);
            }
        }
        return null;
    }

    public final CharSequence b(CharSequence charSequence) {
        if (this.t == null) {
            TypedValue typedValue = new TypedValue();
            this.f1236d.getTheme().resolveAttribute(a.b.h.b.a.textColorSearchUrl, typedValue, true);
            this.t = this.f1236d.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.t, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    @Override // a.b.g.l.f, a.b.g.l.g.a
    public void a(Cursor cursor) {
        if (this.r) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.u = cursor.getColumnIndex("suggest_text_1");
                this.v = cursor.getColumnIndex("suggest_text_2");
                this.w = cursor.getColumnIndex("suggest_text_2_url");
                this.x = cursor.getColumnIndex("suggest_icon_1");
                this.y = cursor.getColumnIndex("suggest_icon_2");
                this.z = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e2);
        }
    }

    @Override // a.b.g.l.f, a.b.g.l.g.a
    public CharSequence b(Cursor cursor) {
        String a2;
        String a3;
        if (cursor == null) {
            return null;
        }
        String a4 = a(cursor, "suggest_intent_query");
        if (a4 != null) {
            return a4;
        }
        if (!this.n.shouldRewriteQueryFromData() || (a3 = a(cursor, "suggest_intent_data")) == null) {
            if (!this.n.shouldRewriteQueryFromText() || (a2 = a(cursor, "suggest_text_1")) == null) {
                return null;
            }
            return a2;
        }
        return a3;
    }

    public final Drawable b(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.o.getPackageName() + "/" + parseInt;
            Drawable a2 = a(str2);
            if (a2 != null) {
                return a2;
            }
            Drawable c2 = a.b.g.b.b.c(this.o, parseInt);
            a(str2, c2);
            return c2;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable a3 = a(str);
            if (a3 != null) {
                return a3;
            }
            Drawable a4 = a(Uri.parse(str));
            a(str, a4);
            return a4;
        }
    }

    @Override // a.b.g.l.f
    public void a(View view, Context context, Cursor cursor) {
        CharSequence a2;
        a aVar = (a) view.getTag();
        int i2 = this.z;
        int i3 = i2 != -1 ? cursor.getInt(i2) : 0;
        if (aVar.f1719a != null) {
            a(aVar.f1719a, a(cursor, this.u));
        }
        if (aVar.f1720b != null) {
            String a3 = a(cursor, this.w);
            if (a3 != null) {
                a2 = b((CharSequence) a3);
            } else {
                a2 = a(cursor, this.v);
            }
            if (TextUtils.isEmpty(a2)) {
                TextView textView = aVar.f1719a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f1719a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f1719a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f1719a.setMaxLines(1);
                }
            }
            a(aVar.f1720b, a2);
        }
        ImageView imageView = aVar.f1721c;
        if (imageView != null) {
            a(imageView, e(cursor), 4);
        }
        ImageView imageView2 = aVar.f1722d;
        if (imageView2 != null) {
            a(imageView2, f(cursor), 8);
        }
        int i4 = this.s;
        if (i4 != 2 && (i4 != 1 || (i3 & 1) == 0)) {
            aVar.f1723e.setVisibility(8);
            return;
        }
        aVar.f1723e.setVisibility(0);
        aVar.f1723e.setTag(aVar.f1719a.getText());
        aVar.f1723e.setOnClickListener(this);
    }

    public final Drawable b(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        if (this.p.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState = this.p.get(flattenToShortString);
            if (constantState == null) {
                return null;
            }
            return constantState.newDrawable(this.o.getResources());
        }
        Drawable a2 = a(componentName);
        this.p.put(flattenToShortString, a2 != null ? a2.getConstantState() : null);
        return a2;
    }

    public Drawable b(Uri uri) {
        int parseInt;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f1236d.getPackageManager().getResourcesForApplication(authority);
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

    public final void a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    public final void a(ImageView imageView, Drawable drawable, int i2) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i2);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public final Drawable a(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return b(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream openInputStream = this.o.getContentResolver().openInputStream(uri);
            if (openInputStream != null) {
                Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
                try {
                    openInputStream.close();
                } catch (IOException e2) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e2);
                }
                return createFromStream;
            }
            throw new FileNotFoundException("Failed to open " + uri);
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
        return null;
    }

    public final Drawable a(String str) {
        Drawable.ConstantState constantState = this.p.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    public final void a(String str, Drawable drawable) {
        if (drawable != null) {
            this.p.put(str, drawable.getConstantState());
        }
    }

    public final Drawable a(ComponentName componentName) {
        PackageManager packageManager = this.f1236d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
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
        } catch (PackageManager.NameNotFoundException e2) {
            Log.w("SuggestionsAdapter", e2.toString());
            return null;
        }
    }

    public static String a(Cursor cursor, String str) {
        return a(cursor, cursor.getColumnIndex(str));
    }

    public static String a(Cursor cursor, int i2) {
        if (i2 == -1) {
            return null;
        }
        try {
            return cursor.getString(i2);
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e2);
            return null;
        }
    }

    public Cursor a(SearchableInfo searchableInfo, String str, int i2) {
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
        if (i2 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i2));
        }
        return this.f1236d.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }
}
