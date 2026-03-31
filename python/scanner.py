import re

def analisar_lexico_arquivo(caminho_do_arquivo):
    """
    Parâmetros:
    - caminho_do_arquivo: Nome do arquivo TXT (ex: 'livro.txt').
    """
    tokens_extraidos = []
    regex_padrao = r"[a-zA-ZÀ-ÿ_][a-zA-ZÀ-ÿ0-9_]*|\d+|[=+\-*]"

    try:
        with open(caminho_do_arquivo, "r", encoding="utf-8") as arquivo:
            conteudo = arquivo.read()
            tokens_extraidos = re.findall(regex_padrao, conteudo)
            
        print(f"\n--- SCANNER EXECUTADO NO ARQUIVO: {caminho_do_arquivo} ---")
        print(tokens_extraidos[:50]) 
        print(f"\nTotal de tokens identificados: {len(tokens_extraidos)}")
        print("--------------------------------------------------")

    except FileNotFoundError:
        print(f"Erro: O arquivo '{caminho_do_arquivo}' não foi encontrado.")
    except Exception as e:
        print(f"Erro inesperado: {e}")

    return tokens_extraidos 

if __name__ == "__main__":
    analisar_lexico_arquivo("livro.txt")