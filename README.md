# PUC-SP - Ciência da Computação
## Disciplina: Compiladores
### LAB 1 - Lex regexp scanner

**Equipe:**
* João Gabriel Vianna
* Matheus Giampaoli Silva
* Tulio Goncalves Vieira

---

## 1. Documentação das Atividades

* **Atividade 1 (Bash/Scanner):** Utilizamos um script Bash (`scanner_simples.sh`) para ler um character stream, empregando o comando `tr -d ' \t\r'` para higienizar a entrada, removendo espaços e tabulações antes da análise.
* **Atividades 2 e 3 (Regex):** Formulamos autômatos via expressões regulares no Regex101 e realizamos processamento de dados usando técnicas de *Find/Replace* para limpeza de código e formatação de planilhas CSV.
* **Atividade 4 (Python e Java):** Desenvolvemos analisadores léxicos simples (`scanner.py` e `ScannerLexico.java`) para tokenizar um código-fonte utilizando Regex.
* **Atividade 5 (Autômatos Finitos):** Estruturamos DFAs e NFAs através da ferramenta JFLAP para validar o funcionamento lógico por trás da análise léxica.
* **Atividade 7 (Tokenização do Livro):** Construímos scripts (`tokenizer_livro.py` e `TokenizerLivro.java`) que efetuam a leitura de uma obra literária em `.txt`, separam as palavras e pontuações de acordo com as regras do português e exportam listas estruturadas em arquivos `.txt` isolados.

---

## 2. Evidências Visuais (Printscreens)

* **Regex online (Regex101 / Regexr):** `![Regex101](img/regex101.png)`
Utilizamos uma expressão regular composta por alternâncias (|) para identificar identificadores, números e operadores simultaneamente. A flag global foi ativada para garantir que o motor de busca não parasse no primeiro token encontrado. Assim, o scanner consegue decompor a string completa em lexemas individuais para a próxima fase do compilador
* **Bash Terminal:** `![Bash](img/Imagembash.png)`
* **JFLAP (Autômatos):** `![JFLAP](img/jflap.png)`
* **FAT:** `![FAT](img/fat.png)`
* **Códigos em Execução:** 
#### **Scanner em Python**
> O script Python utiliza expressões regulares para identificar tokens e gerar uma lista estruturada de lexemas.
![Execução Python](img/print_python.jpg)

---

#### **Scanner em Java**
> A implementação em Java foca na performance e na estrutura de classes para representar o fluxo de caracteres e a tabela de símbolos.
![Execução Java](img/print_java.jpg)

---

## 3. Respostas Teóricas

### OpenAI Tokenizer × Tokens de Compilador
A segmentação realizada pela OpenAI (como dividir `position` em `pos` e `ition`) ocorre pelo uso de algoritmos probabilísticos, cNome da Duplaomo o Byte Pair Encoding (BPE), que agrupam caracteres baseados na frequência estatística para poupar processamento computacional. Por outro lado, um scanner de compilador obedece a gramáticas regulares rigorosas (Tipo 3 da hierarquia de Chomsky) para classificar os dados de maneira determinística, assegurando que a análise sintática subsequente receba informações exatas.

### IA e Gramática Regular no Português
**Seria possível a IA criar um reconhecedor de língua portuguesa usando regexp/autômato finito?**
**Não.** A língua portuguesa não é classificada como uma linguagem regular. Expressões regulares e autômatos finitos carecem de memória de contexto (como uma estrutura de pilha). Dessa forma, um Regex pode reconhecer que "canto" é uma palavra válida, mas é incapaz de discernir se atua como substantivo ou verbo na oração. Para alcançar tal nível de análise sintática e semântica, exige-se no mínimo uma Gramática Livre de Contexto (Tipo 2).

---

## 4. Conclusão Individual
*O que há de interessante no analisador léxico, autômato finito e gramática regular?*

**João Gabriel :**
*O ponto mais interessante é observar como a teoria dos Autômatos Finitos — que muitas vezes parece um conceito puramente abstrato — se transforma na espinha dorsal da eficiência de um compilador. Implementar o scanner me permitiu visualizar como a Gramática Regular funciona como um filtro lógico rigoroso, capaz de converter um fluxo caótico de caracteres em uma sequência estruturada de tokens. Para quem se interessa por arquitetura de software e otimização, entender que o analisador léxico é o primeiro passo para garantir a integridade de um sistema é fundamental, unindo o rigor matemático à utilidade prática no desenvolvimento.*

**Matheus:**
*A experiência com o analisador léxico destacou a elegância das Expressões Regulares como uma linguagem de busca de padrões. É fascinante notar como um Autônomo Finito, através de uma série de transições de estados simples, consegue tomar decisões complexas sobre a validade de uma palavra. Ver isso funcionar na prática, seja no simulador JFLAP ou no código Java e Python, torna o conceito de "reconhecimento de linguagem" muito mais palpável, mostrando que a base teórica da computação é o que permite a criação de ferramentas modernas e versáteis.*

**Tulio :**
*O que mais me chamou a atenção foi o papel do analisador léxico como "limpador" de ruídos no processo de tradução. Perceber que ele é o responsável por ignorar o que é irrelevante para a máquina (espaços e comentários) e focar apenas na essência da Gramática Regular é essencial para entender a hierarquia de um compilador. A transição entre estados de um autônomo demonstra que a lógica computacional é, acima de tudo, uma questão de organização e categorização, transformando texto bruto em unidades de significado que o computador pode finalmente começar a processar.*
