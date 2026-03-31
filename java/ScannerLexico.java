import java.util.regex.*;
import java.util.*;

public class ScannerLexico {

    public static List<String> tokenizar(String codigo) {
        /* Parâmetros: 
           - String codigo: A linha de código a ser analisada. */
        List<String> tokens = new ArrayList<>();

        // Regex para Identificadores, Números e Operadores
        String regex = "[a-zA-Z_][a-zA-Z0-9_]*|\\d+|[=+\\-*]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(codigo);

        while (matcher.find()) {
            tokens.add(matcher.group());
        }

        return tokens; // Único return
    }

    public static void main(String[] args) {
        String codigo = "position = initial + rate * 60";
        List<String> resultado = tokenizar(codigo);
        
        System.out.println("\n--- SCANNER JAVA (LINHA DE CÓDIGO) ---");
        System.out.println(resultado);
        System.out.println("---------------------------------------");
    }
}