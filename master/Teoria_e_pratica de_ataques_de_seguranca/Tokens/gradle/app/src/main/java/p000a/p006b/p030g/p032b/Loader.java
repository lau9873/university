package p000a.p006b.p030g.p032b;

import android.content.Context;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p000a.p006b.p030g.p044j.DebugUtils;

/* renamed from: a.b.g.b.c */
/* loaded from: classes.dex */
public class Loader<D> {
    public Context mContext;
    public int mId;
    public InterfaceC0193b<D> mListener;
    public InterfaceC0192a<D> mOnLoadCanceledListener;
    public boolean mStarted = false;
    public boolean mAbandoned = false;
    public boolean mReset = true;
    public boolean mContentChanged = false;
    public boolean mProcessingChange = false;

    /* compiled from: Loader.java */
    /* renamed from: a.b.g.b.c$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0192a<D> {
        /* renamed from: a */
        void m10015a(Loader<D> loader);
    }

    /* compiled from: Loader.java */
    /* renamed from: a.b.g.b.c$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0193b<D> {
        /* renamed from: a */
        void mo7428a(Loader<D> loader, D d);
    }

    public Loader(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void abandon() {
        this.mAbandoned = true;
        onAbandon();
    }

    public boolean cancelLoad() {
        return onCancelLoad();
    }

    public void commitContentChanged() {
        this.mProcessingChange = false;
    }

    public String dataToString(D d) {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.m9667a(d, sb);
        sb.append("}");
        return sb.toString();
    }

    public void deliverCancellation() {
        InterfaceC0192a<D> interfaceC0192a = this.mOnLoadCanceledListener;
        if (interfaceC0192a != null) {
            interfaceC0192a.m10015a(this);
        }
    }

    public void deliverResult(D d) {
        InterfaceC0193b<D> interfaceC0193b = this.mListener;
        if (interfaceC0193b != null) {
            interfaceC0193b.mo7428a(this, d);
        }
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.mId);
        printWriter.print(" mListener=");
        printWriter.println(this.mListener);
        if (this.mStarted || this.mContentChanged || this.mProcessingChange) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.mStarted);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.mContentChanged);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.mProcessingChange);
        }
        if (this.mAbandoned || this.mReset) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.mAbandoned);
            printWriter.print(" mReset=");
            printWriter.println(this.mReset);
        }
    }

    public void forceLoad() {
        onForceLoad();
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getId() {
        return this.mId;
    }

    public boolean isAbandoned() {
        return this.mAbandoned;
    }

    public boolean isReset() {
        return this.mReset;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public void onAbandon() {
    }

    public boolean onCancelLoad() {
        throw null;
    }

    public void onContentChanged() {
        if (this.mStarted) {
            forceLoad();
        } else {
            this.mContentChanged = true;
        }
    }

    public void onForceLoad() {
    }

    public void onReset() {
    }

    public void onStartLoading() {
        throw null;
    }

    public void onStopLoading() {
        throw null;
    }

    public void registerListener(int i, InterfaceC0193b<D> interfaceC0193b) {
        if (this.mListener == null) {
            this.mListener = interfaceC0193b;
            this.mId = i;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    public void registerOnLoadCanceledListener(InterfaceC0192a<D> interfaceC0192a) {
        if (this.mOnLoadCanceledListener == null) {
            this.mOnLoadCanceledListener = interfaceC0192a;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    public void reset() {
        onReset();
        this.mReset = true;
        this.mStarted = false;
        this.mAbandoned = false;
        this.mContentChanged = false;
        this.mProcessingChange = false;
    }

    public void rollbackContentChanged() {
        if (this.mProcessingChange) {
            onContentChanged();
        }
    }

    public final void startLoading() {
        this.mStarted = true;
        this.mReset = false;
        this.mAbandoned = false;
        onStartLoading();
    }

    public void stopLoading() {
        this.mStarted = false;
        onStopLoading();
    }

    public boolean takeContentChanged() {
        boolean z = this.mContentChanged;
        this.mContentChanged = false;
        this.mProcessingChange |= z;
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.m9667a(this, sb);
        sb.append(" id=");
        sb.append(this.mId);
        sb.append("}");
        return sb.toString();
    }

    public void unregisterListener(InterfaceC0193b<D> interfaceC0193b) {
        InterfaceC0193b<D> interfaceC0193b2 = this.mListener;
        if (interfaceC0193b2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (interfaceC0193b2 == interfaceC0193b) {
            this.mListener = null;
            return;
        }
        throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }

    public void unregisterOnLoadCanceledListener(InterfaceC0192a<D> interfaceC0192a) {
        InterfaceC0192a<D> interfaceC0192a2 = this.mOnLoadCanceledListener;
        if (interfaceC0192a2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (interfaceC0192a2 == interfaceC0192a) {
            this.mOnLoadCanceledListener = null;
            return;
        }
        throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }
}
