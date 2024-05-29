public class Selecao {
    public static int maxSelecao(int[] pSeq, int pInicio, int pFim) {
        int max = pInicio;
        for (int indice = pInicio + 1; indice <= pFim; indice++) {
            if (pSeq[indice] > pSeq[max]) {
                max = indice;
            }
        }
        return max;
    }

    public static int minSelecao(int[] pSeq, int pInicio, int pFim) {
        int min = pInicio;
        for (int indice = pInicio + 1; indice <= pFim; indice++) {
            if (pSeq[indice] < pSeq[min]) {
                min = indice;
            }
        }
        return min;
    }

    public static int primeiroSelecao(int[] pSeq, int pInicio, int pFim, int pVal) {
        for (int indice = pInicio; indice <= pFim; indice++) {
            if (pSeq[indice] <= pVal) {
                return indice;
            }
        }
        return -1;
    }

    public static int melhorSelecao(int[] pSeq, int pInicio, int pFim, int pVal) {
        int melhor = primeiroSelecao(pSeq, pInicio, pFim, pVal);
        if (melhor == -1) {
            return -1;
        }
        for (int indice = melhor + 1; indice <= pFim; indice++) {
            if (pSeq[indice] > pSeq[melhor] && pSeq[indice] <= pVal) {
                melhor = indice;
            }
        }
        return melhor;
    }

    public static int piorSelecao(int[] pSeq, int pInicio, int pFim, int pVal) {
        int pior = primeiroSelecao(pSeq, pInicio, pFim, pVal);
        if (pior == -1) {
            return -1;
        }
        for (int indice = pior + 1; indice <= pFim; indice++) {
            if (pSeq[indice] < pSeq[pior]) {
                pior = indice;
            }
        }
        return pior;
    }

    public static void kSelecao(int[] pSeq, int pInicio, int pFim, int pK) {
        int i = pInicio;
        int j = pFim;
        int pivot = pSeq[--pK];
        if (pInicio < pFim) {
            do {
                while (pSeq[i] < pivot)
                    i++;
                while (pSeq[j] > pivot)
                    j--;
                if (i < j) {
                    troca(pSeq, i, j);
                    i++;
                    j--;
                }
            } while (i < j);
        }
    }

    public static void troca(int[] pSeq, int pI, int pJ) {
        int temp = pSeq[pI];
        pSeq[pI] = pSeq[pJ];
        pSeq[pJ] = temp;
    }

    public static void main(String[] args) {
        int[] sequencia = {78, 100, 31, 23, 4, 300, 5, 55};
        int inicio = 0;
        int fim = sequencia.length - 1;
        int indiceMaior = maxSelecao(sequencia, inicio, fim);
        System.out.println("Índice do maior valor na sequência: " + indiceMaior);

        int indiceMenor = minSelecao(sequencia, inicio, fim);
        System.out.println("Índice do menor valor na sequência: " + indiceMenor);

        int valorBusca = 35;
        int primeiroProximo = primeiroSelecao(sequencia, inicio, fim, valorBusca);
        System.out.println("Índice do primeiro valor próximo de " + valorBusca + ": " + primeiroProximo);

        int melhorProximo = melhorSelecao(sequencia, inicio, fim, valorBusca);
        System.out.println("Índice do melhor valor próximo de " + valorBusca + ": " + melhorProximo);

        int piorProximo = piorSelecao(sequencia, inicio, fim, valorBusca);
        System.out.println("Índice do pior valor próximo de " + valorBusca + ": " + piorProximo);

        int k = 3;
        kSelecao(sequencia, inicio, fim, k);
        System.out.println("Após a k-ésima seleção: ");
        for (int num : sequencia) {
            System.out.print(num + " ");
        }
    }
}
