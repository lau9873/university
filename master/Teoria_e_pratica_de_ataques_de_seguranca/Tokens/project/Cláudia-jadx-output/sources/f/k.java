package f;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
/* compiled from: Okio.java */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f6018a = Logger.getLogger(k.class.getName());

    /* compiled from: Okio.java */
    /* loaded from: classes.dex */
    public class b implements r {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s f6021a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ InputStream f6022b;

        public b(s sVar, InputStream inputStream) {
            this.f6021a = sVar;
            this.f6022b = inputStream;
        }

        @Override // f.r
        public long a(f.c cVar, long j) {
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (i2 == 0) {
                return 0L;
            } else {
                try {
                    this.f6021a.e();
                    n b2 = cVar.b(1);
                    int read = this.f6022b.read(b2.f6030a, b2.f6032c, (int) Math.min(j, 8192 - b2.f6032c));
                    if (read == -1) {
                        return -1L;
                    }
                    b2.f6032c += read;
                    long j2 = read;
                    cVar.f5999b += j2;
                    return j2;
                } catch (AssertionError e2) {
                    if (k.a(e2)) {
                        throw new IOException(e2);
                    }
                    throw e2;
                }
            }
        }

        @Override // f.r
        public s b() {
            return this.f6021a;
        }

        @Override // f.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f6022b.close();
        }

        public String toString() {
            return "source(" + this.f6022b + ")";
        }
    }

    /* compiled from: Okio.java */
    /* loaded from: classes.dex */
    public class c extends f.a {
        public final /* synthetic */ Socket k;

        public c(Socket socket) {
            this.k = socket;
        }

        @Override // f.a
        public IOException b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // f.a
        public void i() {
            try {
                this.k.close();
            } catch (AssertionError e2) {
                if (k.a(e2)) {
                    Logger logger = k.f6018a;
                    Level level = Level.WARNING;
                    logger.log(level, "Failed to close timed out socket " + this.k, (Throwable) e2);
                    return;
                }
                throw e2;
            } catch (Exception e3) {
                Logger logger2 = k.f6018a;
                Level level2 = Level.WARNING;
                logger2.log(level2, "Failed to close timed out socket " + this.k, (Throwable) e3);
            }
        }
    }

    public static e a(r rVar) {
        return new m(rVar);
    }

    public static r b(Socket socket) {
        if (socket != null) {
            f.a c2 = c(socket);
            return c2.a(a(socket.getInputStream(), c2));
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static f.a c(Socket socket) {
        return new c(socket);
    }

    public static d a(q qVar) {
        return new l(qVar);
    }

    public static q a(OutputStream outputStream, s sVar) {
        if (outputStream != null) {
            if (sVar != null) {
                return new a(sVar, outputStream);
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("out == null");
    }

    public static q a(Socket socket) {
        if (socket != null) {
            f.a c2 = c(socket);
            return c2.a(a(socket.getOutputStream(), c2));
        }
        throw new IllegalArgumentException("socket == null");
    }

    /* compiled from: Okio.java */
    /* loaded from: classes.dex */
    public class a implements q {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s f6019a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OutputStream f6020b;

        public a(s sVar, OutputStream outputStream) {
            this.f6019a = sVar;
            this.f6020b = outputStream;
        }

        @Override // f.q
        public void b(f.c cVar, long j) {
            t.a(cVar.f5999b, 0L, j);
            while (j > 0) {
                this.f6019a.e();
                n nVar = cVar.f5998a;
                int min = (int) Math.min(j, nVar.f6032c - nVar.f6031b);
                this.f6020b.write(nVar.f6030a, nVar.f6031b, min);
                nVar.f6031b += min;
                long j2 = min;
                j -= j2;
                cVar.f5999b -= j2;
                if (nVar.f6031b == nVar.f6032c) {
                    cVar.f5998a = nVar.b();
                    o.a(nVar);
                }
            }
        }

        @Override // f.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f6020b.close();
        }

        @Override // f.q, java.io.Flushable
        public void flush() {
            this.f6020b.flush();
        }

        public String toString() {
            return "sink(" + this.f6020b + ")";
        }

        @Override // f.q
        public s b() {
            return this.f6019a;
        }
    }

    public static r a(InputStream inputStream) {
        return a(inputStream, new s());
    }

    public static r a(InputStream inputStream, s sVar) {
        if (inputStream != null) {
            if (sVar != null) {
                return new b(sVar, inputStream);
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("in == null");
    }

    public static r a(File file) {
        if (file != null) {
            return a(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
