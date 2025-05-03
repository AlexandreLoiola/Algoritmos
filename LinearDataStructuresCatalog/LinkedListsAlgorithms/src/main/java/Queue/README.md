## Filas

### 1. Introdução

Uma fila (queue) é uma estrutura de dados que segue o princípio FIFO (First-In-First-Out), onde o primeiro elemento inserido é o primeiro a ser removido. Ela possui dois pontos principais: o **head** (cabeça), que representa o início da fila onde os elementos são removidos, e o **tail** (cauda), que é o final da fila onde novos elementos são adicionados.

### 2. Operações da Fila (Queue) e suas Complexidades

| Operação         | Descrição                                                                          | Complexidade Big O |
|------------------|------------------------------------------------------------------------------------|:------------------:|
| Enqueue          | Adicionar um novo elemento no final da fila (tail).                                  | O(1)               |
| Dequeue          | Remover o elemento do início da fila (head).                                         | O(1)               |
| Front            | Acessar o elemento no início da fila (head) sem removê-lo.                          | O(1)               |
| isEmpty          | Verificar se a fila está vazia.                                                      | O(1)               |
| Size             | Obter o número de elementos na fila.                                                 | O(1)               |
| getAllElements  | Retornar todos os elementos da fila como uma lista.                                  | O(n)               |

### 2.1 Explicações

- **Enqueue**: Esta operação insere um novo elemento no final da fila (tail). É uma operação eficiente, realizada em tempo constante, pois apenas ajusta o ponteiro `tail` para o novo elemento.


- **Dequeue**: Esta operação remove o elemento no início da fila (head). Também é eficiente, realizada em tempo constante, pois apenas ajusta o ponteiro `head` para o próximo elemento na fila.


- **Peek**: Esta operação permite acessar o elemento no início da fila (head) sem removê-lo. É eficiente, realizada em tempo constante, pois acessa diretamente o elemento referenciado por `head`.


- **isEmpty**: Esta operação verifica se a fila está vazia. É uma operação de tempo constante, pois verifica se `head` é `null`.


- **Size**: Esta operação retorna o número de elementos na fila. Como a fila geralmente mantém um contador atualizado de seus elementos, a operação é realizada em tempo constante.


- **getAllElements**: Esta operação retorna todos os elementos da fila como uma lista. Ela itera por todos os elementos na fila para coletá-los em uma lista, portanto, sua complexidade é linear em relação ao número de elementos na fila.
