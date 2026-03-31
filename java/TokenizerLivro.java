import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenizerLivro {

    public static boolean tokenizarESalvar(String caminhoEntrada, String caminhoSaida) {
        /* Parâmetros:
           - caminhoEntrada: Nome do arquivo (livro.txt)
           - caminhoSaida: Onde o resultado será salvo */
        boolean sucesso = false;
        List<String> tokens = new ArrayList<>();
        String regex = "[a-zA-ZÀ-ÿ_][a-zA-ZÀ-ÿ0-9_]*";
        Pattern pattern = Pattern.compile(regex);
        
        File arquivo = new File(caminhoEntrada);
        
        // --- O DIAGNÓSTICO ESTÁ AQUI ---
        if (!arquivo.exists()) {
            System.out.println("\n--- ERRO: ARQUIVO NÃO ENCONTRADO ---");
            System.out.println("O Java está procurando o arquivo neste caminho:");
            System.out.println(arquivo.getAbsolutePath());
            System.out.println("-------------------------------------\n");
        } else {
            try {
                byte[] bytes = Files.readAllBytes(Paths.get(caminhoEntrada));
                String texto = new String(bytes);
                Matcher matcher = pattern.matcher(texto);
                
                while (matcher.find()) {
                    tokens.add(matcher.group());
                }
                
                System.out.println("\n--- SUCESSO! TOKENS ENCONTRADOS ---");
                System.out.println(tokens.subList(0, Math.min(tokens.size(), 50)));
                System.out.println("\nTotal de tokens: " + tokens.size());

                Files.write(Paths.get(caminhoSaida), tokens.toString().getBytes());
                sucesso = true;
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo.");
            }
        }
        
        return sucesso; // Único return
    }

    public static void main(String[] args) {
        tokenizarESalvar("livro.txt", "saida_tokens_java.txt");
    }
}