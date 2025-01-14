package g.a.a;

import android.bluetooth.BluetoothDevice;
import org.altbeacon.beacon.BeaconParser;
/* compiled from: AltBeaconParser.java */
/* loaded from: classes.dex */
public class b extends BeaconParser {
    public b() {
        this.w = new int[]{280};
        a("m:2-3=beac,i:4-19,i:20-21,i:22-23,p:24-24,d:25-25");
        this.v = "altbeacon";
    }

    @Override // org.altbeacon.beacon.BeaconParser
    public c a(byte[] bArr, int i2, BluetoothDevice bluetoothDevice) {
        return a(bArr, i2, bluetoothDevice, new a());
    }
}
