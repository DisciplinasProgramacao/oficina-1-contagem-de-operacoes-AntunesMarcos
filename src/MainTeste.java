import java.io.FileWriter;
import java.io.IOException;

public class MainTeste {
    public static void main(String[] args) {
        System.out.println("Executando testes de tempo para os algoritmos...");
        try (FileWriter writer = new FileWriter("resultados.csv")) {
            writer.write("Algoritmo,Tamanho,Tempo(ns)\n");
            

            for (int tamanho : App.tamanhosTesteGrande) {
                int[] vetor = App.gerarVetor(tamanho);
                long inicio = System.nanoTime();
                App.codigo1(vetor);
                long fim = System.nanoTime();
                writer.write("Codigo1," + tamanho + "," + (fim - inicio) + "\n");
            }
            

            for (int tamanho : App.tamanhosTesteGrande) {
                int[] vetor = App.gerarVetor(tamanho);
                long inicio = System.nanoTime();
                App.codigo2(vetor);
                long fim = System.nanoTime();
                writer.write("Codigo2," + tamanho + "," + (fim - inicio) + "\n");
            }
            

            for (int tamanho : App.tamanhosTesteMedio) {
                int[] vetor = App.gerarVetor(tamanho);
                long inicio = System.nanoTime();
                App.codigo3(vetor);
                long fim = System.nanoTime();
                writer.write("Codigo3," + tamanho + "," + (fim - inicio) + "\n");
            }
            

            for (int tamanho : App.tamanhosTestePequeno) {
                long inicio = System.nanoTime();
                App.codigo4(tamanho);
                long fim = System.nanoTime();
                writer.write("Codigo4," + tamanho + "," + (fim - inicio) + "\n");
            }
            
            System.out.println("Resultados salvos em resultados.csv");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os resultados: " + e.getMessage());
        }
    }
}
