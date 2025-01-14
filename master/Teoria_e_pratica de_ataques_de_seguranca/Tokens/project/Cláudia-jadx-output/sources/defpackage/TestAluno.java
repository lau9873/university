package defpackage;
/* renamed from: TestAluno  reason: default package */
/* loaded from: TestAluno.class */
public class TestAluno {
    public static void main(String[] strArr) {
        System.out.println("contador = " + Aluno.contador);
        Aluno aluno = new Aluno();
        Aluno aluno2 = new Aluno();
        aluno2.nome = "modificado";
        Aluno aluno3 = new Aluno();
        Aluno aluno4 = new Aluno("Manuel", 201506234);
        System.out.println("d = " + aluno3);
        System.out.println("e = " + aluno4);
        System.out.println("b = " + aluno2);
        System.out.println("c = " + aluno2);
        System.out.println("a.nome = " + aluno.nome);
        System.out.println("a.numero = " + aluno.numero);
        System.out.println("a = " + aluno);
        System.out.println(new Aluno("Ana", 201408762).ano() + " " + new Aluno("Bruno", 201508145).ano());
        Aluno[] alunoArr = new Aluno[3];
        for (int i2 = 0; i2 < 3; i2++) {
            alunoArr[i2] = new Aluno();
            System.out.println("v[" + i2 + "] = " + alunoArr[i2]);
        }
        alunoArr[0].nome = "Pedro";
        System.out.println("contador = " + Aluno.contador);
    }
}
