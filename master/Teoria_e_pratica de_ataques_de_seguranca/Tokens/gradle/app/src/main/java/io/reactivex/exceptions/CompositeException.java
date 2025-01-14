package io.reactivex.exceptions;

import com.j256.ormlite.logger.Logger;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class CompositeException extends RuntimeException {

    /* renamed from: a */
    public final List<Throwable> f10563a;

    /* renamed from: b */
    public final String f10564b;

    /* renamed from: c */
    public Throwable f10565c;

    /* renamed from: io.reactivex.exceptions.CompositeException$a */
    /* loaded from: classes.dex */
    public static final class C2653a extends RuntimeException {
        @Override // java.lang.Throwable
        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }
    }

    /* renamed from: io.reactivex.exceptions.CompositeException$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractC2654b {
        /* renamed from: a */
        public abstract void mo494a(Object obj);
    }

    /* renamed from: io.reactivex.exceptions.CompositeException$c */
    /* loaded from: classes.dex */
    public static final class C2655c extends AbstractC2654b {

        /* renamed from: a */
        public final PrintStream f10566a;

        public C2655c(PrintStream printStream) {
            this.f10566a = printStream;
        }

        @Override // io.reactivex.exceptions.CompositeException.AbstractC2654b
        /* renamed from: a */
        public void mo494a(Object obj) {
            this.f10566a.println(obj);
        }
    }

    /* renamed from: io.reactivex.exceptions.CompositeException$d */
    /* loaded from: classes.dex */
    public static final class C2656d extends AbstractC2654b {

        /* renamed from: a */
        public final PrintWriter f10567a;

        public C2656d(PrintWriter printWriter) {
            this.f10567a = printWriter;
        }

        @Override // io.reactivex.exceptions.CompositeException.AbstractC2654b
        /* renamed from: a */
        public void mo494a(Object obj) {
            this.f10567a.println(obj);
        }
    }

    public CompositeException(Throwable... thArr) {
        this(thArr == null ? Arrays.asList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    /* renamed from: a */
    public List<Throwable> m499a() {
        return this.f10563a;
    }

    /* renamed from: b */
    public final Throwable m495b(Throwable th) {
        Throwable cause = th.getCause();
        if (cause == null || this.f10565c == cause) {
            return th;
        }
        while (true) {
            Throwable cause2 = cause.getCause();
            if (cause2 == null || cause2 == cause) {
                break;
            }
            cause = cause2;
        }
        return cause;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        if (this.f10565c == null) {
            C2653a c2653a = new C2653a();
            HashSet hashSet = new HashSet();
            Iterator<Throwable> it = this.f10563a.iterator();
            C2653a c2653a2 = c2653a;
            while (it.hasNext()) {
                Throwable next = it.next();
                if (!hashSet.contains(next)) {
                    hashSet.add(next);
                    for (Throwable th : m496a(next)) {
                        if (hashSet.contains(th)) {
                            next = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        } else {
                            hashSet.add(th);
                        }
                    }
                    try {
                        c2653a2.initCause(next);
                    } catch (Throwable unused) {
                    }
                    c2653a2 = m495b(c2653a2);
                }
            }
            this.f10565c = c2653a;
        }
        return this.f10565c;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f10564b;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public CompositeException(Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (iterable != null) {
            for (Throwable th : iterable) {
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).m499a());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (!linkedHashSet.isEmpty()) {
            arrayList.addAll(linkedHashSet);
            this.f10563a = Collections.unmodifiableList(arrayList);
            this.f10564b = this.f10563a.size() + " exceptions occurred. ";
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }

    /* renamed from: a */
    public final void m498a(AbstractC2654b abstractC2654b) {
        StackTraceElement[] stackTrace;
        StringBuilder sb = new StringBuilder((int) Logger.DEFAULT_FULL_MESSAGE_LENGTH);
        sb.append(this);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb.append("\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        int i = 1;
        for (Throwable th : this.f10563a) {
            sb.append("  ComposedException ");
            sb.append(i);
            sb.append(" :\n");
            m497a(sb, th, "\t");
            i++;
        }
        abstractC2654b.mo494a(sb.toString());
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        m498a(new C2655c(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        m498a(new C2656d(printWriter));
    }

    /* renamed from: a */
    public final void m497a(StringBuilder sb, Throwable th, String str) {
        StackTraceElement[] stackTrace;
        sb.append(str);
        sb.append(th);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append("\t\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            m497a(sb, th.getCause(), "");
        }
    }

    /* renamed from: a */
    public final List<Throwable> m496a(Throwable th) {
        ArrayList arrayList = new ArrayList();
        Throwable cause = th.getCause();
        if (cause != null && cause != th) {
            while (true) {
                arrayList.add(cause);
                Throwable cause2 = cause.getCause();
                if (cause2 == null || cause2 == cause) {
                    break;
                }
                cause = cause2;
            }
        }
        return arrayList;
    }
}
