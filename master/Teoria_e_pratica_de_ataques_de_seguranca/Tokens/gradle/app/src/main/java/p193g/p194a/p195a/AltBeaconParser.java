package p193g.p194a.p195a;

import android.bluetooth.BluetoothDevice;
import org.altbeacon.beacon.BeaconParser;

/* renamed from: g.a.a.b */
/* loaded from: classes.dex */
public class AltBeaconParser extends BeaconParser {
    public AltBeaconParser() {
        this.f10630w = new int[]{280};
        m429a("m:2-3=beac,i:4-19,i:20-21,i:22-23,p:24-24,d:25-25");
        this.f10629v = "altbeacon";
    }

    @Override // org.altbeacon.beacon.BeaconParser
    /* renamed from: a */
    public Beacon mo425a(byte[] bArr, int i, BluetoothDevice bluetoothDevice) {
        return m424a(bArr, i, bluetoothDevice, new AltBeacon());
    }
}
