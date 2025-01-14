package f;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* compiled from: InflaterSource.java */
/* loaded from: classes.dex */
public final class j implements r {

    /* renamed from: a  reason: collision with root package name */
    public final e f6014a;

    /* renamed from: b  reason: collision with root package name */
    public final Inflater f6015b;

    /* renamed from: c  reason: collision with root package name */
    public int f6016c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6017d;

    public j(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater != null) {
            this.f6014a = eVar;
            this.f6015b = inflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }

    @Override // f.r
    public long a(c cVar, long j) {
        n b2;
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 >= 0) {
            if (this.f6017d) {
                throw new IllegalStateException("closed");
            }
            if (i2 == 0) {
                return 0L;
            }
            while (true) {
                boolean i3 = i();
                try {
                    b2 = cVar.b(1);
                    int inflate = this.f6015b.inflate(b2.f6030a, b2.f6032c, 8192 - b2.f6032c);
                    if (inflate > 0) {
                        b2.f6032c += inflate;
                        long j2 = inflate;
                        cVar.f5999b += j2;
                        return j2;
                    } else if (this.f6015b.finished() || this.f6015b.needsDictionary()) {
                        break;
                    } else if (i3) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            j();
            if (b2.f6031b == b2.f6032c) {
                cVar.f5998a = b2.b();
                o.a(b2);
                return -1L;
            }
            return -1L;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // f.r
    public s b() {
        return this.f6014a.b();
    }

    @Override // f.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f6017d) {
            return;
        }
        this.f6015b.end();
        this.f6017d = true;
        this.f6014a.close();
    }

    public boolean i() {
        if (this.f6015b.needsInput()) {
            j();
            if (this.f6015b.getRemaining() == 0) {
                if (this.f6014a.e()) {
                    return true;
                }
                n nVar = this.f6014a.a().f5998a;
                int i2 = nVar.f6032c;
                int i3 = nVar.f6031b;
                this.f6016c = i2 - i3;
                this.f6015b.setInput(nVar.f6030a, i3, this.f6016c);
                return false;
            }
            throw new IllegalStateException("?");
        }
        return false;
    }

    public final void j() {
        int i2 = this.f6016c;
        if (i2 == 0) {
            return;
        }
        int remaining = i2 - this.f6015b.getRemaining();
        this.f6016c -= remaining;
        this.f6014a.skip(remaining);
    }
}
