import java.io.FileWriter;
import java.io.IOException;

public class MainTeste {
    public static void main(String[] args) {
        System.out.println("Executando testes de tempo e contagem de operações para os algoritmos...");
        try (FileWriter writer = new FileWriter("resultados.csv")) {
            writer.write("Algoritmo,Tamanho,Tempo(ns),Operacoes\n");
            
            // Teste código 1
            for (int tamanho : App.tamanhosTesteGrande) {
                int[] vetor = App.gerarVetor(tamanho);
                App.operacoes = 0;
                long inicio = System.nanoTime();
                App.codigo1(vetor);
                long fim = System.nanoTime();
                writer.write("Codigo1," + tamanho + "," + (fim - inicio) + "," + App.operacoes + "\n");
            }
            
            // Teste código 2
            for (int tamanho : App.tamanhosTesteGrande) {
                int[] vetor = App.gerarVetor(tamanho);
                App.operacoes = 0;
                long inicio = System.nanoTime();
                App.codigo2(vetor);
                long fim = System.nanoTime();
                writer.write("Codigo2," + tamanho + "," + (fim - inicio) + "," + App.operacoes + "\n");
            }
            
            // Teste código 3
            for (int tamanho : App.tamanhosTesteMedio) {
                int[] vetor = App.gerarVetor(tamanho);
                App.operacoes = 0;
                long inicio = System.nanoTime();
                App.codigo3(vetor);
                long fim = System.nanoTime();
                writer.write("Codigo3," + tamanho + "," + (fim - inicio) + "," + App.operacoes + "\n");
            }
            
            // Teste código 4
            for (int tamanho : App.tamanhosTestePequeno) {
                App.operacoes = 0;
                long inicio = System.nanoTime();
                App.codigo4(tamanho);
                long fim = System.nanoTime();
                writer.write("Codigo4," + tamanho + "," + (fim - inicio) + "," + App.operacoes + "\n");
            }
            
            System.out.println("Resultados salvos em resultados.csv");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os resultados: " + e.getMessage());
        }
    }
}
