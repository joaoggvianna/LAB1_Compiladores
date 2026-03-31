import re

def processar_texto_livro(caminho_entrada):
    """
    Parâmetros:
    - caminho_entrada: Nome do arquivo (ex: 'livro.txt')
    """
    sucesso = False
    regex_palavras = r"[a-zA-ZÀ-ÿ]+" # Captura palavras com acento

    try:
        # Abre o arquivo do livro
        with open(caminho_entrada, "r", encoding="utf-8") as f:
            conteudo = f.read()
            # Encontra todas as palavras (tokens)
            tokens = re.findall(regex_palavras, conteudo)

        # AGORA ELE PRINTA NA TELA PARA O SEU PRINT
        print("\n--- LISTA DE TOKENS DO LIVRO (EXEMPLO) ---")
        print(tokens[:30])  # Mostra os primeiros 30 para o print não ficar gigante
        print(f"\nTotal de tokens encontrados: {len(tokens)}")
        print("------------------------------------------")

        sucesso = True
    except FileNotFoundError:
        print(f"Erro: O arquivo '{caminho_entrada}' não está nesta pasta.")
    except Exception as e:
        print(f"Ocorreu um erro: {e}")

    return sucesso # Único return conforme sua regra