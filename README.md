## 📐 Arquitetura do Projeto — Consulta à API do TheMealDB
### 🎯 Objetivo

Construir uma aplicação Java em console que:

1. Solicite ao usuário o nome de uma receita. 
2. Faça uma consulta HTTP na API pública TheMealDB. 
3. Parseie o JSON recebido e converta em objetos Java. 
4. Exiba as informações formatadas no terminal.
___

### 1. Estrutura de pacotes

```less
src/
└── com.mealdb.app
├── Main.java               // Ponto de entrada do programa
│
├── domain/                 // Objetos de domínio (modelo da receita)
│   └── Meal.java
│
├── service/                // Regras de negócio
│   └── MealService.java    // Faz a busca de receitas (chama a API)
│
├── infra/                  // Infraestrutura: comunicação com API
│   └── HttpClientProvider.java // Configuração centralizada de HttpClient
│
└── util/                   // Utilitários de parsing e helpers
└── MealParser.java     // Converte JSON em objetos Meal
```
___

### 2. Responsabilidade de cada camada
### Main

- Responsável por:

  - Ler a entrada do usuário.

  - Delegar a busca para MealService.

  - Exibir os resultados formatados.
  (_Não deve conter regra de negócio ou chamada direta à API — só orquestra o fluxo_).
___

### domain (modelo de dados)

- `Meal.java` → Representa uma receita.

    - Campos principais: `name`, `category`, `instructions`, `ingredients (lista)`.

___
### service (regra de negócio)

- `MealService.java`:

  - Constrói a URL da API a partir do nome digitado.

  - Faz a chamada via `HttpClientProvider`.

  - Recebe JSON e delega para `MealParser`.

  - Retorna uma lista de `Meal` para o `Main`.

___
### infra (infraestrutura técnica)

- `HttpClientProvider.java`:

  - Cria e mantém instância de `HttpClient`.

  - Evita duplicação de código de configuração.

  - Facilita testes futuros e manutenibilidade.

___
### util (utilitários)

- `MealParser.java`:

  - Usa uma lib de parsing (ex: Jackson ou org.json).

  - Converte JSON da API em objetos `Meal`.

  - Trata casos de resposta nula (quando a API não encontra nada).

___

### 3. Fluxo da aplicação

1. Usuário abre programa (`Main`). 
2. `Main` pede o nome da receita. 
3. `MealService` constrói a URL da API e busca os dados. 
4. `HttpClientProvider` executa a chamada HTTP. 
5. `MealParser` converte JSON em objetos `Meal`. 
6. `MealService` retorna lista de receitas para `Main`. 
7. `Main` exibe informações formatadas.
___

### 4. Exemplo de interação
```yaml
Digite o nome da receita: Arrabiata

📌 Receita encontrada:
- Nome: Spicy Arrabiata Penne
- Categoria: Vegetarian
- Ingredientes:
   • Penne rigate
   • Olive oil
   • Garlic
   • Chopped tomatoes
   • Red chile flakes
- Instruções:
  Bring a large pot of water to a boil...
```
___
### 5. Orientações para você, júnior 🚀

- **Comece simples**: primeiro faça só a chamada HTTP e imprima a resposta JSON no console. 
- **Depois evolua**: crie o `Meal` e o `MealParser` para organizar os dados. 
- **Valide erros**: se o usuário digitar algo que não existe, exiba `"Nenhuma receita encontrada."`. 
- **Boas práticas**:
  - Não misture lógica de rede (`HttpClient`) com lógica de exibição (`System.out.println`). 
  - Use nomes claros e consistentes. 
  - Trate exceções (`try/catch`) sempre que chamar a API.
