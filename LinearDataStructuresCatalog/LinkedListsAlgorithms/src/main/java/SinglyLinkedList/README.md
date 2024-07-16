# Lista Encadeda Simples

## Índice

1. [Introdução](#1-introdução)
2. [Algoritmos e Complexidades](#2-algoritmos-e-complexidades)
    - [Explicações](#21-explicações)
3. [Implementação](#3-implementação)
    - [Classe common.Node](#31-classe-node)
    - [Operações no início da lista](#32-operações-no-início-da-lista)
        - [Inserção](#321-inserção)
        - [Deleção](#322-deleção)
    - [Operações no meio da lista](#33-operações-no-meio-da-lista)
        - [Inserção](#331-inserção)
        - [Deleção](#332-deleção)
    - [Operações no fim da lista](#34-operações-no-fim-da-lista)
        - [Inserção](#341-inserção)
        - [Deleção](#342-deleção)
    - [Operação de Busca](#35-operação-de-busca)
        - [Execução](#351-execução)
4. [Conclusão](#4-conclusão)

## 1. Introdução

Uma **lista encadeada simples** é uma estrutura de dados linear composta por uma
sequência de elementos que não estão necessariamente alocados de forma sequencial
na memória. Cada elemento, ou nó, contém dois componentes principais:

1. **Dados**: A informação armazenada no nó, que pode ser de qualquer tipo (inteiro, string, objeto, etc.).
2. **Ponteiro**: Uma referência que aponta para o próximo nó na sequência.

Além dos nós que contêm dados, a lista mantém uma referência para o primeiro nó, chamado de `head`, que marca o início da lista encadeada.

## 2. Algoritmos e Complexidades
| Operação                       | Descrição                                                                                                                                         | Complexidade Big O |
|--------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------|:------------------:|
| **Indexação**                  | Acessar um elemento em uma posição específica requer percorrer a lista desde o início até a posição desejada.                                       | O(n)               |
| **Inserir no início**          | Adicionar um novo nó no início da lista, simplesmente atualizando o ponteiro inicial para apontar para o novo nó.                                   | O(1)               |
| **Deletar no início**          | Remover o primeiro nó da lista, atualizando o ponteiro inicial para apontar para o segundo nó.                                                      | O(1)               |
| **Inserir no meio**            | Inserir um nó em uma posição específica requer percorrer a lista até essa posição e ajustar os ponteiros dos nós adjacentes.                         | O(n)               |
| **Deletar no meio**            | Remover um nó de uma posição específica requer percorrer a lista até essa posição e ajustar os ponteiros dos nós adjacentes.                         | O(n)               |
| **Inserir no final**           | Adicionar um novo nó no final da lista. Se houver um ponteiro para o último nó, a inserção pode ser feita em tempo constante.                       | O(1)               |
| **Deletar no final**           | Remover o último nó requer percorrer a lista até o penúltimo nó, a menos que haja um ponteiro para o penúltimo nó.                                   | O(n)               |
| **Busca**                      | Encontrar um nó com um valor específico requer percorrer a lista até encontrar o nó ou chegar ao final da lista.                                    | O(n)               |

### 2.1 Explicações

- **Indexação**: Diferente de arrays, as listas encadeadas simples não têm acesso direto aos elementos, então a indexação é uma operação linear.


- **Inserção e Deleção no Início**: Essas operações são eficientes em listas encadeadas simples, pois apenas envolvem a atualização de um ponteiro.


- **Inserção e Deleção no Meio**: São menos eficientes devido à necessidade de percorrer a lista até o ponto de inserção/deleção.


- **Inserção no Final**: Se a lista mantém um ponteiro para o último nó, essa operação pode ser feita em tempo constante. Caso contrário, é linear.


- **Busca**: A busca é linear porque, no pior caso, é necessário percorrer toda a lista para encontrar o nó desejado.

## 3. Implementação
### 3.1 Classe common.Node

A classe `common.Node` representa cada elemento da lista.

```Java
public class Node {
    private int data;
    private common.Node next;
}
```
 
Ela armazena os valores: 
- `data` que representa o dado armazenado no node, neste caso será do tipo `int`; 
- `next` que será o ponteiro para o nó da adjacente a ele, armazena o próprio objeto `common.Node`;

O construtor `common.Node(int data)` inicializa um novo nó com o valor de `data` especificado
e com `next` sendo nulo, portanto não aponta para nenhum outro nó da lista.

```Java
public Node(int data) {
    this.data = data;
    this.next = null;
}
```

### 3.2 Operações no início da lista
 As operaçãoes no início da lista envolvem encontrar o nó `head` e então manipular
 a referencia deste ponteiro.

#### 3.2.1 Inserção
Para inserir um novo nó no início da lista:

1. Cria-se um novo nó com o dado especificado;
2. Este novo nó é configurado para apontar para o atual `head` da lista;
3. O `head` é atualizado para apontar para o novo nó, tornando-o o novo início da lista encadeada.

```Java
import common.Node;

public void insertInHead(int data) {
    Node newNode = new Node(data);
    newNode.setNext(head);
    head = newNode;
}
```

#### 3.2.2 Deleção
Para deletar o nó do início da lista:

1. O `head` é atualizado para apontar para o próximo nó da lista.

```Java
public void deleteFromHead() {
    head = head.getNext();
}
```

### 3.3 Operações no meio da lista
Para operações no meio da lista ligada, é comum utilizar a estratégia "Tortoise and Hare" onde há dois ponteiros:
- `slowPointer`: Este ponteiro avança um nó por vez na lista ligada;


- `fastPointer`:  Este ponteiro avança dois nós por vez na lista ligada;

Além disso, pode-se utilizar um ponteiro auxiliar:
- `prevSlowPointer`: mantém a referência ao nó anterior ao `slowPointer`;
#### 3.3.1 Inserção

Passo a Passo da Inserção no Meio da Lista:

1. Cria um novo nó com o dado especificado;


2. Inicializa `slowPointer` e `fastPointer` no início da lista;


3. Avança os ponteiros;


4. O `slowPointer` estará na posição onde o novo nó deve ser inserido;


5. Insere o novo nó após o `slowPointer`, ajustando as referências.

```Java
import common.Node;

public void insertInMiddle(int data) {
    Node newNode = new Node(data);
    Node slowPointer = head;
    Node fastPointer = head;
    while (fastPointer != null && fastPointer.getNext() != null) {
        slowPointer = slowPointer.getNext();
        fastPointer = fastPointer.getNext().getNext();
    }
    newNode.setNext(slowPointer.getNext());
    slowPointer.setNext(newNode);
}
```
#### 3.3.2 Deleção
Passo a Passo da Deleção no Meio da Lista:

1. Verifica se a lista está vazia ou tem apenas um nó; se sim, remove esse nó definindo `head` como `null`.


2. Inicializa `slowPointer`, `fastPointer` e `prevSlowPointer`.


3. Avança os ponteiros.


4. Quando `fastPointer` chega ao final (ou quase), `slowPointer` está no nó a ser removido.


5. Remove o nó atualizando as referências, fazendo com que `prevSlowPointer` aponte diretamente para o nó seguinte ao `slowPointer`.

```Java
import common.Node;

public void deleteFromMiddle() {
    if (head == null || head.getNext() == null) {
        head = null;
        return;
    }
    Node slowPointer = head;
    Node fastPointer = head;
    Node prevSlowPointer = null;
    while (fastPointer != null && fastPointer.getNext() != null) {
        prevSlowPointer = slowPointer;
        slowPointer = slowPointer.getNext();
        fastPointer = fastPointer.getNext().getNext();
    }
    prevSlowPointer.setNext(slowPointer.getNext());
}
```

### 3.4 Operações no fim da lista
Para operações no fim da lista ligada, utilizamos um ponteiro:

- `current`: Este ponteiro é usado para percorrer a lista até o final.

#### 3.4.1 Inserção
Passo a Passo da Inserção no Fim da Lista:

1. Cria um novo nó com o dado especificado.


1. Verifica se a lista está vazia; se sim, define o novo nó como `head`.


2. Inicializa `current` no `head` e avança até o último nó da lista.


3. Insere o novo nó no final da lista, ajustando a referência do último nó para apontar para o novo nó.

```Java
import common.Node;

public void insertInTail(int data) {
    Node newNode = new Node(data);
    if (head == null) {
        head = newNode;
        return;
    }
    Node current = head;
    while (current.getNext() != null) {
        current = current.getNext();
    }
    current.setNext(newNode);
}
```

#### 3.4.2 Deleção
Passo a Passo da Deleção do Fim da Lista:

1. Verifica se a lista está vazia ou tem apenas um nó; se sim, define `head` como `null`.


2. Inicializa `current` no `head`.


3. Avança `current` até o penúltimo nó da lista.


4. Remove o último nó ajustando a referência do penúltimo nó para `null`.

```Java
import common.Node;

public void deleteFromTail() {
    if (head == null || head.getNext() == null) {
        head = null;
        return;
    }
    Node current = head;
    while (current.getNext().getNext() != null) {
        current = current.getNext();
    }
    current.setNext(null);
}
```
### 3.5 Operação de Busca
Para a operação de busca na lista ligada, utilizamos um ponteiro:

- `current`: Este ponteiro é utilizado para percorrer a lista, começando do `head`.

#### 3.5.1 Execução
Passo a Passo da Busca:

1. Inicializa `current` no `head` da lista.


2. Enquanto `current` não for nulo, verifica se o valor do nó atual "`current.getData()`" é igual ao valor procurado.


3. Se encontrar o valor, retorna o nó atual.


4. Caso contrário, avança para o próximo nó na lista.


5. Retorna `null` se o valor não for encontrado na lista.

```Java
import common.Node;

public Node search(int value) {
    Node current = head;
    while (current != null) {
        if (current.getData() == value) {
            return current;
        }
        current = current.getNext();
    }
    return null;
}
```

## 4. Conclusão
Listas ligadas simples oferecem flexibilidade na manipulação de dados e são 
particularmente úteis quando a estrutura dos dados pode ser dinâmica e o tamanho
pode variar ao longo do tempo.

Ao deletar um nó em uma lista ligada em Java, quando todas as referências a esse
nó são removidas da estrutura de dados, o `Garbage Collector` deve eventualmente 
liberar a memória ocupada por esse nó, se não houver mais referências a ele. Isso
ocorre automaticamente, sem necessidade de intervenção manual.