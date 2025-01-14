package p000a.p006b.p030g.p032b;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.p065v4.p066os.OperationCanceledException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import p000a.p006b.p030g.p044j.TimeUtils;

/* renamed from: a.b.g.b.a */
/* loaded from: classes.dex */
public abstract class AsyncTaskLoader<D> extends Loader<D> {
    public static final boolean DEBUG = false;
    public static final String TAG = "AsyncTaskLoader";
    public volatile AsyncTaskLoader<D>.RunnableC0191a mCancellingTask;
    public final Executor mExecutor;
    public Handler mHandler;
    public long mLastLoadCompleteTime;
    public volatile AsyncTaskLoader<D>.RunnableC0191a mTask;
    public long mUpdateThrottle;

    /* compiled from: AsyncTaskLoader.java */
    /* renamed from: a.b.g.b.a$a */
    /* loaded from: classes.dex */
    public final class RunnableC0191a extends ModernAsyncTask<Void, Void, D> implements Runnable {

        /* renamed from: j */
        public final CountDownLatch f1351j = new CountDownLatch(1);

        /* renamed from: k */
        public boolean f1352k;

        public RunnableC0191a() {
        }

        @Override // p000a.p006b.p030g.p032b.ModernAsyncTask
        /* renamed from: b */
        public void mo10003b(D d) {
            try {
                AsyncTaskLoader.this.dispatchOnCancelled(this, d);
            } finally {
                this.f1351j.countDown();
            }
        }

        @Override // p000a.p006b.p030g.p032b.ModernAsyncTask
        /* renamed from: c */
        public void mo10000c(D d) {
            try {
                AsyncTaskLoader.this.dispatchOnLoadComplete(this, d);
            } finally {
                this.f1351j.countDown();
            }
        }

        /* renamed from: e */
        public void m10024e() {
            try {
                this.f1351j.await();
            } catch (InterruptedException unused) {
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1352k = false;
            AsyncTaskLoader.this.executePendingTask();
        }

        @Override // p000a.p006b.p030g.p032b.ModernAsyncTask
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public D mo10005a(Void... voidArr) {
            try {
                return (D) AsyncTaskLoader.this.onLoadInBackground();
            } catch (OperationCanceledException e) {
                if (m10009a()) {
                    return null;
                }
                throw e;
            }
        }
    }

    public AsyncTaskLoader(Context context) {
        this(context, ModernAsyncTask.f1372h);
    }

    public void cancelLoadInBackground() {
    }

    public void dispatchOnCancelled(AsyncTaskLoader<D>.RunnableC0191a runnableC0191a, D d) {
        onCanceled(d);
        if (this.mCancellingTask == runnableC0191a) {
            rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            deliverCancellation();
            executePendingTask();
        }
    }

    public void dispatchOnLoadComplete(AsyncTaskLoader<D>.RunnableC0191a runnableC0191a, D d) {
        if (this.mTask != runnableC0191a) {
            dispatchOnCancelled(runnableC0191a, d);
        } else if (isAbandoned()) {
            onCanceled(d);
        } else {
            commitContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mTask = null;
            deliverResult(d);
        }
    }

    @Override // p000a.p006b.p030g.p032b.Loader
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.mTask != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.mTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mTask.f1352k);
        }
        if (this.mCancellingTask != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.mCancellingTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mCancellingTask.f1352k);
        }
        if (this.mUpdateThrottle != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            TimeUtils.m9591a(this.mUpdateThrottle, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            TimeUtils.m9592a(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    public void executePendingTask() {
        if (this.mCancellingTask != null || this.mTask == null) {
            return;
        }
        if (this.mTask.f1352k) {
            this.mTask.f1352k = false;
            this.mHandler.removeCallbacks(this.mTask);
        }
        if (this.mUpdateThrottle > 0 && SystemClock.uptimeMillis() < this.mLastLoadCompleteTime + this.mUpdateThrottle) {
            this.mTask.f1352k = true;
            this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
            return;
        }
        this.mTask.m10007a(this.mExecutor, null);
    }

    public boolean isLoadInBackgroundCanceled() {
        return this.mCancellingTask != null;
    }

    public abstract D loadInBackground();

    @Override // p000a.p006b.p030g.p032b.Loader
    public boolean onCancelLoad() {
        if (this.mTask != null) {
            if (!this.mStarted) {
                this.mContentChanged = true;
            }
            if (this.mCancellingTask != null) {
                if (this.mTask.f1352k) {
                    this.mTask.f1352k = false;
                    this.mHandler.removeCallbacks(this.mTask);
                }
                this.mTask = null;
                return false;
            } else if (this.mTask.f1352k) {
                this.mTask.f1352k = false;
                this.mHandler.removeCallbacks(this.mTask);
                this.mTask = null;
                return false;
            } else {
                boolean m10006a = this.mTask.m10006a(false);
                if (m10006a) {
                    this.mCancellingTask = this.mTask;
                    cancelLoadInBackground();
                }
                this.mTask = null;
                return m10006a;
            }
        }
        return false;
    }

    public abstract void onCanceled(D d);

    @Override // p000a.p006b.p030g.p032b.Loader
    public void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.mTask = new RunnableC0191a();
        executePendingTask();
    }

    public D onLoadInBackground() {
        return loadInBackground();
    }

    public void setUpdateThrottle(long j) {
        this.mUpdateThrottle = j;
        if (j != 0) {
            this.mHandler = new Handler();
        }
    }

    public void waitForLoader() {
        AsyncTaskLoader<D>.RunnableC0191a runnableC0191a = this.mTask;
        if (runnableC0191a != null) {
            runnableC0191a.m10024e();
        }
    }

    public AsyncTaskLoader(Context context, Executor executor) {
        super(context);
        this.mLastLoadCompleteTime = -10000L;
        this.mExecutor = executor;
    }
}
