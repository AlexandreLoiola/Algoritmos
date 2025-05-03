# Fila Dupla

## 1. Introdução
Um deque (double-ended queue) é uma estrutura de dados que permite a inserção e remoção
de elementos em ambas as extremidades, tanto no início quanto no final. Assim, ele 
combina a funcionalidade de uma fila (`queue`) e uma pilha (`stack`).

## 2. Operações da Deque e suas Complexidades

| Operação        | Descrição                                                       | Complexidade Big O |
|-----------------|-----------------------------------------------------------------|:------------------:|
| addFront        | Adicionar um novo elemento no início da deque (head).           | O(1)               |
| addRear         | Adicionar um novo elemento no final da deque (tail).            | O(1)               |
| removeFront     | Remover o elemento do início da deque (head).                   | O(1)               |
| removeRear      | Remover o elemento do final da deque (tail).                    | O(1)               |
| peekFront       | Acessar o elemento no início da deque (head) sem removê-lo.     | O(1)               |
| peekRear        | Acessar o elemento no final da deque (tail) sem removê-lo.      | O(1)               |
| isEmpty         | Verificar se a deque está vazia.                                | O(1)               |
| size            | Obter o número de elementos na deque.                           | O(1)               |
| getAllElements  | Retornar todos os elementos da deque como uma lista.            | O(n)               |

### 2.1 Explicações

- **addFront**: Insere um novo elemento no início da fila. É realizada em tempo constante, pois apenas ajusta o ponteiro `head` para o novo elemento.


- **addRear**: Insere um novo elemento no final da fila. É realizada em tempo constante, pois apenas ajusta o ponteiro `tail` para o novo elemento.


- **removeFront**: Remove o elemento do início da fila. É realizada em tempo constante, pois apenas ajusta o ponteiro `head` para o próximo elemento na fila.


- **removeRear**: Remove o elemento do final da fila. É realizada em tempo constante, pois apenas ajusta o ponteiro `tail` para o elemento anterior na fila.


- **peekFront**: Permite acessar o elemento no início da filasem removê-lo. É  realizada em tempo constante, pois acessa diretamente o elemento referenciado por `head`.


- **peekRear**: Permite acessar o elemento no final da fila sem removê-lo. É realizada em tempo constante, pois acessa diretamente o elemento referenciado por `tail`.


- **isEmpty**: Verifica se a fila está vazia. É uma operação de tempo constante, pois verifica se `head` é `null`.


- **size**: Retorna o número de elementos na fila. Como a fila geralmente mantém um contador atualizado de seus elementos, a operação é realizada em tempo constante.


- **getAllElements**: Esta operação retorna todos os elementos da fila como uma lista. Ela itera por todos os elementos na fila, portanto, sua complexidade é linear em relação ao número de elementos na fila.