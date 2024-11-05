# Calculadora Android

Este projeto tem como objetivo desenvolver uma **calculadora simples** para Android, utilizando Kotlin ou Java para a lógica de cálculo e XML para o layout. A calculadora implementa as operações matemáticas básicas: adição, subtração, multiplicação, divisão, e inclui funcionalidades como limpar a tela (C) e calcular o resultado (=).

## Tecnologias Utilizadas
- **Android Studio** (IDE)
- **Kotlin** (para a lógica da calculadora)
- **XML** (para o layout da interface)
- **Componentes Android**: `LinearLayout`, `GridLayout`, `TextView`, `Button`

## Funcionalidades
- **Operações Matemáticas**: A calculadora permite a realização das operações básicas de adição, subtração, multiplicação e divisão.
- **Campo de Exibição**: Um campo de exibição (implementado com `TextView` ou `EditText`) mostra os valores inseridos e o resultado da operação em andamento.
- **Botões de 0 a 9**: A calculadora inclui os botões de 0 a 9 para os números.
- **Botões de Operações**: Os botões para as operações de adição, subtração, multiplicação e divisão.
- **Botão "C"**: O botão "C" limpa o campo de exibição, removendo todos os valores.
- **Botão "="**: O botão "=" calcula o resultado da operação em curso e exibe o resultado no campo de exibição.
- **Tratamento de Erros**: A calculadora trata erros como a tentativa de divisão por zero, evitando que a aplicação falhe.
- **Validação de Entradas**: A lógica da aplicação garante que não seja possível inserir operadores consecutivos, tornando a entrada de dados mais precisa e evitando erros de cálculo.
- **Layout Personalizado**: O layout da interface foi personalizado com cores e tamanhos de botões para tornar a interface mais amigável e agradável ao usuário.

## Como Rodar o Projeto

Para rodar o projeto localmente, siga os passos abaixo:

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/AlejandroGleles/app--calcula.git
