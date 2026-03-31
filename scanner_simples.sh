#!/bin/bash

# Em vez de 'true', testamos se o 'read' conseguiu ler algo
while read -r linha; do
    echo "[SCANNER] Linha recebida: '$linha'"
    
    # Processamento (remover espaços, tabs e carriage returns)
    echo "$linha" | tr -d ' \t\r'
done