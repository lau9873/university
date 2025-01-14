package defpackage;
/* compiled from: ED234.java */
/* renamed from: avaliacao  reason: default package */
/* loaded from: avaliacao.class */
class avaliacao implements Comparable<avaliacao> {
    static String filme;
    static int nota;

    avaliacao(String str, int i2) {
        filme = str;
        nota = i2;
    }

    @Override // java.lang.Comparable
    public int compareTo(avaliacao avaliacaoVar) {
        return filme.compareTo(filme);
    }
}
