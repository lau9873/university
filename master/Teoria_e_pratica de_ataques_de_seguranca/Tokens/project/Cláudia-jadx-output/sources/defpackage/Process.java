package defpackage;
/* compiled from: ED237.java */
/* renamed from: Process  reason: default package */
/* loaded from: Process.class */
class Process {
    private String name;
    private int time;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Process(String str, int i2) {
        this.name = str;
        this.time = i2;
    }

    public int getTime() {
        return this.time;
    }

    public String getName() {
        return this.name;
    }

    public void time(int i2) {
        this.time = i2;
    }

    public void name(String str) {
        this.name = str;
    }
}
