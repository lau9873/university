package defpackage;

import org.apache.tools.bzip2.BZip2Constants;
/* compiled from: TestAluno.java */
/* renamed from: Aluno  reason: default package */
/* loaded from: Aluno.class */
class Aluno {
    String nome;
    int numero;
    public static int contador = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Aluno() {
        this.nome = "indefinido";
        this.numero = -1;
        contador++;
    }

    public String toString() {
        return "(" + this.nome + "," + this.numero + ")";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Aluno(String str, int i2) {
        this.nome = str;
        this.numero = i2;
        contador++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ano() {
        return this.numero / BZip2Constants.baseBlockSize;
    }
}
