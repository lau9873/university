package a.b.g.b;

import a.b.g.j.p;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.os.OperationCanceledException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
/* compiled from: AsyncTaskLoader.java */
/* loaded from: classes.dex */
public abstract class a<D> extends c<D> {
    public static final boolean DEBUG = false;
    public static final String TAG = "AsyncTaskLoader";
    public volatile a<D>.RunnableC0018a mCancellingTask;
    public final Executor mExecutor;
    public Handler mHandler;
    public long mLastLoadCompleteTime;
    public volatile a<D>.RunnableC0018a mTask;
    public long mUpdateThrottle;

    /* compiled from: AsyncTaskLoader.java */
    /* renamed from: a.b.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class RunnableC0018a extends e<Void, Void, D> implements Runnable {
        public final CountDownLatch j = new CountDownLatch(1);
        public boolean k;

        public RunnableC0018a() {
        }

        @Override // a.b.g.b.e
        public void b(D d2) {
            try {
                a.this.dispatchOnCancelled(this, d2);
            } finally {
                this.j.countDown();
            }
        }

        @Override // a.b.g.b.e
        public void c(D d2) {
            try {
                a.this.dispatchOnLoadComplete(this, d2);
            } finally {
                this.j.countDown();
            }
        }

        public void e() {
            try {
                this.j.await();
            } catch (InterruptedException unused) {
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.k = false;
            a.this.executePendingTask();
        }

        @Override // a.b.g.b.e
        public D a(Void... voidArr) {
            try {
                return (D) a.this.onLoadInBackground();
            } catch (OperationCanceledException e2) {
                if (a()) {
                    return null;
                }
                throw e2;
            }
        }
    }

    public a(Context context) {
        this(context, e.f866h);
    }

    public void cancelLoadInBackground() {
    }

    public void dispatchOnCancelled(a<D>.RunnableC0018a runnableC0018a, D d2) {
        onCanceled(d2);
        if (this.mCancellingTask == runnableC0018a) {
            rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            deliverCancellation();
            executePendingTask();
        }
    }

    public void dispatchOnLoadComplete(a<D>.RunnableC0018a runnableC0018a, D d2) {
        if (this.mTask != runnableC0018a) {
            dispatchOnCancelled(runnableC0018a, d2);
        } else if (isAbandoned()) {
            onCanceled(d2);
        } else {
            commitContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mTask = null;
            deliverResult(d2);
        }
    }

    @Override // a.b.g.b.c
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.mTask != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.mTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mTask.k);
        }
        if (this.mCancellingTask != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.mCancellingTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mCancellingTask.k);
        }
        if (this.mUpdateThrottle != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            p.a(this.mUpdateThrottle, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            p.a(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    public void executePendingTask() {
        if (this.mCancellingTask != null || this.mTask == null) {
            return;
        }
        if (this.mTask.k) {
            this.mTask.k = false;
            this.mHandler.removeCallbacks(this.mTask);
        }
        if (this.mUpdateThrottle > 0 && SystemClock.uptimeMillis() < this.mLastLoadCompleteTime + this.mUpdateThrottle) {
            this.mTask.k = true;
            this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
            return;
        }
        this.mTask.a(this.mExecutor, null);
    }

    public boolean isLoadInBackgroundCanceled() {
        return this.mCancellingTask != null;
    }

    public abstract D loadInBackground();

    @Override // a.b.g.b.c
    public boolean onCancelLoad() {
        if (this.mTask != null) {
            if (!this.mStarted) {
                this.mContentChanged = true;
            }
            if (this.mCancellingTask != null) {
                if (this.mTask.k) {
                    this.mTask.k = false;
                    this.mHandler.removeCallbacks(this.mTask);
                }
                this.mTask = null;
                return false;
            } else if (this.mTask.k) {
                this.mTask.k = false;
                this.mHandler.removeCallbacks(this.mTask);
                this.mTask = null;
                return false;
            } else {
                boolean a2 = this.mTask.a(false);
                if (a2) {
                    this.mCancellingTask = this.mTask;
                    cancelLoadInBackground();
                }
                this.mTask = null;
                return a2;
            }
        }
        return false;
    }

    public abstract void onCanceled(D d2);

    @Override // a.b.g.b.c
    public void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.mTask = new RunnableC0018a();
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
        a<D>.RunnableC0018a runnableC0018a = this.mTask;
        if (runnableC0018a != null) {
            runnableC0018a.e();
        }
    }

    public a(Context context, Executor executor) {
        super(context);
        this.mLastLoadCompleteTime = -10000L;
        this.mExecutor = executor;
    }
}
