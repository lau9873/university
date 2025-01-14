package defpackage;
/* compiled from: ED098.java */
/* renamed from: Doente  reason: default package */
/* loaded from: Doente.class */
class Doente {
    public String nome;
    public int chegada;
    public int atendimento;
    public int entrada = -1;

    Doente(String str, int i2, int i3) {
        this.nome = str;
        this.chegada = i2;
        this.atendimento = i3;
    }
}
