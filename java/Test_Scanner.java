import java.util.*;

public class Test_Scanner {

    public static boolean validar(String nome, String codigo, List<String> esperado) {
        /* Parâmetros:
           - nome: Identificação do teste (ex: "Teste de Atribuição")
           - codigo: A string que será processada pelo scanner
           - esperado: A lista de tokens que o scanner deve retornar */
        boolean passou = false;
        List<String> resultado = ScannerLexico.tokenizar(codigo);

        if (resultado.equals(esperado)) {
            System.out.println("[SUCESSO] " + nome);
            passou = true;
        } else {
            System.out.println("[ERRO] " + nome);
            System.out.println("  Esperado: " + esperado);
            System.out.println("  Recebido: " + resultado);
        }

        return passou; // Único return
    }

    public static void main(String[] args) {
        System.out.println("--- INICIANDO TESTES DO ANALISADOR LÉXICO ---");

        // Caso 1: Teste da string principal do laboratório
        validar("Atribuição Padrão", "position = initial + rate * 60", 
                Arrays.asList("position", "=", "initial", "+", "rate", "*", "60"));

        // Caso 2: Teste de colagem de tokens (sem espaços)
        validar("Tokens sem Espaço", "taxa=100", 
                Arrays.asList("taxa", "=", "100"));

        System.out.println("--- FIM DOS TESTES ---");
        return; // Único return (para void)
    }
}