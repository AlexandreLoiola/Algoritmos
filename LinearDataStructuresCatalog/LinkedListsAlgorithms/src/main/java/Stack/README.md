# Pilha

## 1. Introdução

Uma **pilha** é uma estrutura de dados linear baseada no princípio LIFO (Last In, First Out), onde o último elemento adicionado é o primeiro a ser removido. Essa estrutura é frequentemente implementada usando uma lista encadeada simples. Em uma lista encadeada simples:

1. **Dados**: Cada elemento, ou nó, contém o dado a ser armazenado. Pode ser qualquer tipo de informação, como um número inteiro, uma string ou até mesmo um objeto complexo.


2. **Ponteiro**: Cada nó possui um ponteiro que aponta para o próximo nó na sequência. Essa conexão entre os nós é o que define a estrutura encadeada da lista.

Além dos nós que contêm dados, a lista mantém uma referência para o primeiro nó, chamado de `top` ou `head`, que marca o ponto de entrada ou o topo da pilha.

## 2. Algoritmos e Complexidades

| Operação     | Descrição                                                                          | Complexidade Big O |
|--------------|------------------------------------------------------------------------------------|:------------------:|
| **Push**     | Adicionar um novo elemento no topo da pilha.                                        | O(1)               |
| **Pop**      | Remover o elemento do topo da pilha.                                                | O(1)               |
| **Peek**     | Acessar o elemento no topo da pilha sem removê-lo.                                  | O(1)               |
| **isEmpty**  | Verificar se a pilha está vazia.                                                    | O(1)               |
| **Size**     | Obter o número de elementos na pilha.                                               | O(n)               |
| **getAllElements** | Retornar todos os elementos da pilha como uma lista.                                | O(n)               |

### 2.1 Explicações

- **Push**: Esta operação insere um novo elemento no topo da pilha. É uma operação muito eficiente, pois não importa quantos elementos existam na pilha, a inserção de um novo elemento no topo é sempre realizada em tempo constante.


- **Pop**: Esta operação remove o elemento do topo da pilha. Assim como o `push`, é realizada em tempo constante, pois apenas o elemento no topo da pilha é removido e o ponteiro do topo é atualizado.


- **Peek**: Esta operação permite visualizar o elemento no topo da pilha sem removê-lo. É eficiente, realizada em tempo constante, porque apenas acessa o elemento no topo da pilha.


- **isEmpty**: Esta operação verifica se a pilha está vazia. É uma operação de tempo constante, pois apenas verifica se o ponteiro do topo é `null`.


- **Size**: Esta operação retorna o número de elementos na pilha. Como ela itera por todos os elementos na pilha para contar quantos existem, a complexidade é linear, O(n).


- **getAllElements**: Esta operação retorna todos os elementos na pilha como uma lista. Ela itera por todos os elementos na pilha para coletá-los em uma lista, portanto, sua complexidade também é linear, O(n).

## 3. Implementação
### 3.1 Classe Node

A classe `Node` representa cada elemento da lista.

```Java
public class Node {
    private int data;
    private Node next;
}
```

Ela armazena os valores:
- `data` que representa o dado armazenado no node, neste caso será do tipo `int`;

- `next` que será o ponteiro para o nó da adjacente a ele, armazena o próprio objeto `Node`;

O construtor `Node(int data)` inicializa um novo nó com o valor de `data` especificado
e com `next` sendo nulo, portanto não aponta para nenhum outro nó da lista.

```Java
public Node(int data) {
    this.data = data;
    this.next = null;
}
```
### 3.2 Push

Para adicionar um novo elemento no topo da pilha:

1. Cria-se um novo nó com o dado especificado;
2. O próximo nó do novo nó é configurado para apontar para o atual topo da pilha;
3. O ponteiro `top` é atualizado para apontar para o novo nó, tornando-o o novo topo da pilha.
4. Incrementa-se o tamanho da pilha;

```Java
void push(int data) {
    Node newNode = new Node(data);
    newNode.setNext(top);
    top = newNode;
    size++;
}
```
### 3.3 Pop
Para remover o elemento no topo da pilha:

1. Verifica-se se a pilha está vazia. Se estiver, uma exceção é lançada;
2. Atualiza-se o ponteiro `top` para apontar para o próximo nó da pilha, removendo assim o nó atual do topo.
3. Decrementa-se o tamanho da pilha.

```Java
void pop() {
    if (isEmpty()) {
        throw new RuntimeException("A pilha está vazia. Não há o que remover.");
    }
    top = top.getNext();
    size--;
}
```

### 3.4 GetAllElements
Para obter todos os elementos da pilha, utiliza-se o seguinte método:

1. Inicializa-se uma lista vazia `elements` para armazenar os nós;
2. Define-se um ponteiro `current` que começa no topo da pilha;
3. Percorre-se a pilha utilizando um laço enquanto o ponteiro `current` não for nulo:
    - Adiciona-se o nó atual à lista `elements`;
    - Atualiza-se o ponteiro `current` para apontar para o próximo nó;
4. Retorna-se a lista `elements`, que contém todos os nós da pilha.

```Java
List<Node> getAllElements() {
    List<Node> elements = new ArrayList<>();
    Node current = top;
    while (current != null) {
        elements.add(current);
        current = current.getNext();
    }
    return elements;
}
```

## 4. Conclusão
Pilhas são uma escolha adequada para gerenciar dados e operações em uma sequência específica, como em cenários de:

1. **Ordem Reversa**:
   - Quando é necessário acessar os elementos na ordem inversa da sua inserção. Pilhas permitem remover e acessar o último elemento inserido de forma eficiente.


2. **Controle de Fluxo**:
   - Quando o controle de fluxo precisa ser gerenciado de forma que as operações mais recentes sejam completadas primeiro. Isso é útil para implementar funcionalidades como desfazer e refazer ações.


3. **Recursão**:
   - Quando a implementação de algoritmos recursivos é necessária. Pilhas podem simular a pilha de chamadas de funções, permitindo que algoritmos recursivos sejam convertidos para iterativos.


4. **Análise de Expressões**:
   - Quando é necessário analisar e processar expressões matemáticas ou sintáticas onde operações e operandos são processados em uma ordem específica.


5. **Armazenamento Temporário**:
   - Quando há necessidade de armazenar temporariamente dados durante o processamento, de forma que os dados armazenados mais recentemente sejam os primeiros a serem recuperados.


Ao deletar um nó de uma pilha implementada com listas encadeadas em Java, o Garbage Collector libera a memória ocupada pelo nó, desde que todas as referências a ele sejam removidas. Isso garante a eficiência na gestão de memória, permitindo que a pilha cresça e diminua dinamicamente sem intervenção manual.