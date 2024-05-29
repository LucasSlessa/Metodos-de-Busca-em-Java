public class ForcaBruta {
    public static int ForcaBruta(String T, String P) {
        int n = T.length();
        int m = P.length();
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && T.charAt(i + j) == P.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i; // Padrão encontrado, retornando a posição inicial
            }
        }
        return -1; // Padrão não encontrado
    }

    public static void main(String[] args) {
        String T = "Aula na Univap, sábado";
        String P = "Univap";
        int posicao = ForcaBruta(T, P);
        if (posicao != -1) {
            System.out.println("Padrão encontrado na posição: " + posicao);
        } else {
            System.out.println("Padrão não encontrado.");
        }
    }
}
