package io.reactivex.exceptions;

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

    /* renamed from: a  reason: collision with root package name */
    public final List<Throwable> f7586a;

    /* renamed from: b  reason: collision with root package name */
    public final String f7587b;

    /* renamed from: c  reason: collision with root package name */
    public Throwable f7588c;

    /* loaded from: classes.dex */
    public static final class a extends RuntimeException {
        @Override // java.lang.Throwable
        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract void a(Object obj);
    }

    /* loaded from: classes.dex */
    public static final class c extends b {

        /* renamed from: a  reason: collision with root package name */
        public final PrintStream f7589a;

        public c(PrintStream printStream) {
            this.f7589a = printStream;
        }

        @Override // io.reactivex.exceptions.CompositeException.b
        public void a(Object obj) {
            this.f7589a.println(obj);
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends b {

        /* renamed from: a  reason: collision with root package name */
        public final PrintWriter f7590a;

        public d(PrintWriter printWriter) {
            this.f7590a = printWriter;
        }

        @Override // io.reactivex.exceptions.CompositeException.b
        public void a(Object obj) {
            this.f7590a.println(obj);
        }
    }

    public CompositeException(Throwable... thArr) {
        this(thArr == null ? Arrays.asList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    public List<Throwable> a() {
        return this.f7586a;
    }

    public final Throwable b(Throwable th) {
        Throwable cause = th.getCause();
        if (cause == null || this.f7588c == cause) {
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
        if (this.f7588c == null) {
            a aVar = new a();
            HashSet hashSet = new HashSet();
            Iterator<Throwable> it = this.f7586a.iterator();
            a aVar2 = aVar;
            while (it.hasNext()) {
                Throwable next = it.next();
                if (!hashSet.contains(next)) {
                    hashSet.add(next);
                    for (Throwable th : a(next)) {
                        if (hashSet.contains(th)) {
                            next = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        } else {
                            hashSet.add(th);
                        }
                    }
                    try {
                        aVar2.initCause(next);
                    } catch (Throwable unused) {
                    }
                    aVar2 = b(aVar2);
                }
            }
            this.f7588c = aVar;
        }
        return this.f7588c;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f7587b;
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
                    linkedHashSet.addAll(((CompositeException) th).a());
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
            this.f7586a = Collections.unmodifiableList(arrayList);
            this.f7587b = this.f7586a.size() + " exceptions occurred. ";
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }

    public final void a(b bVar) {
        StackTraceElement[] stackTrace;
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb.append("\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        int i2 = 1;
        for (Throwable th : this.f7586a) {
            sb.append("  ComposedException ");
            sb.append(i2);
            sb.append(" :\n");
            a(sb, th, "\t");
            i2++;
        }
        bVar.a(sb.toString());
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        a(new c(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        a(new d(printWriter));
    }

    public final void a(StringBuilder sb, Throwable th, String str) {
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
            a(sb, th.getCause(), "");
        }
    }

    public final List<Throwable> a(Throwable th) {
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
