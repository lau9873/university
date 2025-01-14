package p192f;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: f.k */
/* loaded from: classes.dex */
public final class Okio {

    /* renamed from: a */
    public static final Logger f8469a = Logger.getLogger(Okio.class.getName());

    /* compiled from: Okio.java */
    /* renamed from: f.k$b */
    /* loaded from: classes.dex */
    public class C1824b implements Source {

        /* renamed from: a */
        public final /* synthetic */ Timeout f8472a;

        /* renamed from: b */
        public final /* synthetic */ InputStream f8473b;

        public C1824b(Timeout timeout, InputStream inputStream) {
            this.f8472a = timeout;
            this.f8473b = inputStream;
        }

        @Override // p192f.Source
        /* renamed from: a */
        public long mo673a(Buffer buffer, long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (i == 0) {
                return 0L;
            } else {
                try {
                    this.f8472a.mo2520e();
                    Segment m2618b = buffer.m2618b(1);
                    int read = this.f8473b.read(m2618b.f8482a, m2618b.f8484c, (int) Math.min(j, 8192 - m2618b.f8484c));
                    if (read == -1) {
                        return -1L;
                    }
                    m2618b.f8484c += read;
                    long j2 = read;
                    buffer.f8450b += j2;
                    return j2;
                } catch (AssertionError e) {
                    if (Okio.m2581a(e)) {
                        throw new IOException(e);
                    }
                    throw e;
                }
            }
        }

        @Override // p192f.Source
        /* renamed from: b */
        public Timeout mo2528b() {
            return this.f8472a;
        }

        @Override // p192f.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f8473b.close();
        }

        public String toString() {
            return "source(" + this.f8473b + ")";
        }
    }

    /* compiled from: Okio.java */
    /* renamed from: f.k$c */
    /* loaded from: classes.dex */
    public class C1825c extends AsyncTimeout {

        /* renamed from: k */
        public final /* synthetic */ Socket f8474k;

        public C1825c(Socket socket) {
            this.f8474k = socket;
        }

        @Override // p192f.AsyncTimeout
        /* renamed from: b */
        public IOException mo2577b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // p192f.AsyncTimeout
        /* renamed from: i */
        public void mo2576i() {
            try {
                this.f8474k.close();
            } catch (AssertionError e) {
                if (Okio.m2581a(e)) {
                    Logger logger = Okio.f8469a;
                    Level level = Level.WARNING;
                    logger.log(level, "Failed to close timed out socket " + this.f8474k, (Throwable) e);
                    return;
                }
                throw e;
            } catch (Exception e2) {
                Logger logger2 = Okio.f8469a;
                Level level2 = Level.WARNING;
                logger2.log(level2, "Failed to close timed out socket " + this.f8474k, (Throwable) e2);
            }
        }
    }

    /* renamed from: a */
    public static BufferedSource m2586a(Source source) {
        return new RealBufferedSource(source);
    }

    /* renamed from: b */
    public static Source m2579b(Socket socket) {
        if (socket != null) {
            AsyncTimeout m2578c = m2578c(socket);
            return m2578c.m2635a(m2583a(socket.getInputStream(), m2578c));
        }
        throw new IllegalArgumentException("socket == null");
    }

    /* renamed from: c */
    public static AsyncTimeout m2578c(Socket socket) {
        return new C1825c(socket);
    }

    /* renamed from: a */
    public static BufferedSink m2587a(Sink sink) {
        return new RealBufferedSink(sink);
    }

    /* renamed from: a */
    public static Sink m2582a(OutputStream outputStream, Timeout timeout) {
        if (outputStream != null) {
            if (timeout != null) {
                return new C1823a(timeout, outputStream);
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("out == null");
    }

    /* renamed from: a */
    public static Sink m2580a(Socket socket) {
        if (socket != null) {
            AsyncTimeout m2578c = m2578c(socket);
            return m2578c.m2636a(m2582a(socket.getOutputStream(), m2578c));
        }
        throw new IllegalArgumentException("socket == null");
    }

    /* compiled from: Okio.java */
    /* renamed from: f.k$a */
    /* loaded from: classes.dex */
    public class C1823a implements Sink {

        /* renamed from: a */
        public final /* synthetic */ Timeout f8470a;

        /* renamed from: b */
        public final /* synthetic */ OutputStream f8471b;

        public C1823a(Timeout timeout, OutputStream outputStream) {
            this.f8470a = timeout;
            this.f8471b = outputStream;
        }

        @Override // p192f.Sink
        /* renamed from: b */
        public void mo2529b(Buffer buffer, long j) {
            C1828t.m2518a(buffer.f8450b, 0L, j);
            while (j > 0) {
                this.f8470a.mo2520e();
                Segment segment = buffer.f8449a;
                int min = (int) Math.min(j, segment.f8484c - segment.f8483b);
                this.f8471b.write(segment.f8482a, segment.f8483b, min);
                segment.f8483b += min;
                long j2 = min;
                j -= j2;
                buffer.f8450b -= j2;
                if (segment.f8483b == segment.f8484c) {
                    buffer.f8449a = segment.m2548b();
                    SegmentPool.m2546a(segment);
                }
            }
        }

        @Override // p192f.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f8471b.close();
        }

        @Override // p192f.Sink, java.io.Flushable
        public void flush() {
            this.f8471b.flush();
        }

        public String toString() {
            return "sink(" + this.f8471b + ")";
        }

        @Override // p192f.Sink
        /* renamed from: b */
        public Timeout mo2530b() {
            return this.f8470a;
        }
    }

    /* renamed from: a */
    public static Source m2584a(InputStream inputStream) {
        return m2583a(inputStream, new Timeout());
    }

    /* renamed from: a */
    public static Source m2583a(InputStream inputStream, Timeout timeout) {
        if (inputStream != null) {
            if (timeout != null) {
                return new C1824b(timeout, inputStream);
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("in == null");
    }

    /* renamed from: a */
    public static Source m2585a(File file) {
        if (file != null) {
            return m2584a(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    /* renamed from: a */
    public static boolean m2581a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
