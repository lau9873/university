// Codigo inicial para o problema [DAA 022] Arvores Red-Black
// Pedro Ribeiro (DCC/FCUP)

import java.util.Scanner;

// Estrutura para representar um no da arvore
class Node {
    boolean isBlack;  // No preto?
    boolean isNull;   // No nulo?
    int value;        // Valor
    Node left, right; // Filhos

    Node(int v) {
        isNull = (v == 0);
        isBlack = (v >= 0);
        value = Math.abs(v);
    }
}

public class daa022 {

    // Ler input em preorder
    static Node readPreOrder(Scanner in) {
        int v = in.nextInt();
        Node aux = new Node(v);
        if (v != 0) {
            aux.left = readPreOrder(in);
            aux.right = readPreOrder(in);
        }
        return aux;
    }

    // Menor valor da arvore
    static int minimum(Node t) {
        if (t.isNull) return Integer.MAX_VALUE;
        int minLeft = minimum(t.left);
        int minRight = minimum(t.right);
        return Math.min(t.value, Math.min(minLeft, minRight));
    }

    // Maior valor da arvore
    static int maximum(Node t) {
        if (t.isNull) return Integer.MIN_VALUE;
        int minLeft = maximum(t.left);
        int minRight = maximum(t.right);
        return Math.max(t.value, Math.max(minLeft, minRight));
    }

    // Quantidade de nos (internos)
    static int size(Node t) {
        if (t.isNull) return 0;
        return 1 + size(t.left) + size(t.right);
    }

    // ---------------------------------------------------
    static boolean redprop(Node t) {
        if (t.isNull) return true;
        else if (!t.isBlack && (!t.left.isBlack || !t.right.isBlack)) return false;
        return redprop(t.left) && redprop(t.right);
    }

    static boolean binary(Node t) {
        if (t.isNull && (t.left != null || t.right != null)) return false;
        else if (t.isNull && (t.left == null && t.right == null)) return true;
        else if (t.value < maximum(t.left) || t.value > minimum(t.right)) return false;
        return binary(t.left) && binary(t.right);
    }

    static int blackprop(Node t) {
        if (t.isNull && t.isBlack) return 1;
        if (t.isNull && !t.isBlack) return 0;
        if (t.isBlack && (blackprop(t.left) == blackprop(t.right)))
            return blackprop(t.left) + 1;
        if (!t.isBlack && (blackprop(t.left) == blackprop(t.right)))
            return blackprop(t.left);
        return -1;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            Node root = readPreOrder(in);
            //System.out.printf("Tree with %d nodes (min=%d, max=%d)\n", size(root), minimum(root), maximum(root));
            if (root.isBlack && redprop(root) && blackprop(root) != -1 && binary(root))
                System.out.println("SIM");
            else
                System.out.println("NAO");
        }
    }
}
