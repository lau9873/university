package defpackage;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
/* renamed from: ED098  reason: default package */
/* loaded from: ED098.class */
class ED098 {
    private static final int NUM_CORES = 5;
    private static final String[] CORES = {"Vermelho", "Laranja", "Amarelo", "Verde", "Azul"};
    private static int numEquipas;
    private static int numDoentes;
    private static FilaAtendimento[] emEspera;
    private static LinkedList<Doente> atendidos;
    private static Equipa[] equipas;

    ED098() {
    }

    private static int indiceCor(String str) {
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            if (CORES[i3].equals(str)) {
                i2 = i3;
            }
        }
        return i2;
    }

    private static void lerDoentes(Scanner scanner) {
        while (scanner.hasNext()) {
            System.out.printf("Li [%s,%s,%d,%d]%n", scanner.next(), scanner.next(), Integer.valueOf(scanner.nextInt()), Integer.valueOf(scanner.nextInt()));
        }
    }

    private static void mostrarCores() {
        System.out.println("------------");
        System.out.println("Cores     ND");
        System.out.println("------------");
    }

    private static void mostrarAtendidos() {
        System.out.println("---------------------------");
        System.out.println("Lista dos doentes atendidos");
        System.out.println("---------------------------");
        Iterator<Doente> it = atendidos.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().nome);
        }
        System.out.println("---------------------------");
    }

    private static void mostrarEquipas() {
        System.out.println("-----------------------");
        System.out.println("Equipa NDoentes MediaTA");
        System.out.println("-----------------------");
    }

    private static int proximaEquipaLivre() {
        return -1;
    }

    private static int proximoDoente(int i2) {
        return -1;
    }

    private static void simular() {
    }

    private static void inicializar() {
        numDoentes = 0;
        emEspera = new FilaAtendimento[5];
        for (int i2 = 0; i2 < 5; i2++) {
            emEspera[i2] = new FilaAtendimento();
        }
        atendidos = new LinkedList<>();
        equipas = new Equipa[numEquipas];
        for (int i3 = 0; i3 < numEquipas; i3++) {
            equipas[i3] = new Equipa();
        }
    }

    public static void main(String[] strArr) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        numEquipas = scanner.nextInt();
        inicializar();
        lerDoentes(scanner);
        if (nextInt == 0) {
            mostrarCores();
            return;
        }
        simular();
        if (nextInt == 2) {
            mostrarEquipas();
        }
        mostrarAtendidos();
    }
}
