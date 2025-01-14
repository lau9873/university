package defpackage;
/* compiled from: ED098.java */
/* renamed from: Equipa  reason: default package */
/* loaded from: Equipa.class */
class Equipa {
    int numDoentes = 0;
    int totalAtendimento = 0;
    int livre = 0;

    void novoDoente(Doente doente, int i2) {
        this.numDoentes++;
        this.totalAtendimento += i2;
        this.livre = 0;
    }
}
