# Árvore Binária

## Sumário
1. [Introdução](#1-introdução)
2. [Algoritmos e Complexidades](#2-algoritmos-e-complexidades)
    - [2.1 Operações Fundamentais](#21-operações-fundamentais)
3. [Implementação](#3-implementação)
    - [3.1 Classe TreeNode](#31-classe-treenode)
    - [3.2 Inserção de Nós](#32-inserção-de-nós)
    - [3.3 Busca de um Elemento](#33-busca-de-um-elemento)
    - [3.4 Remoção de um Elemento](#34-remoção-de-um-elemento)
4. [Conclusão](#4-conclusão)

## 1. Introdução

Uma **Árvore Binária** é uma estrutura de dados hierárquica, não linear, composta por nós, onde cada nó pode ter até dois filhos: um à esquerda e um à direita. Esta estrutura é caracterizada por diversas propriedades fundamentais:

1. **Nó Raiz**: É o nó inicial da árvore a partir do qual todos os outros nós são acessados. Uma árvore binária tem exatamente um nó raiz.

2. **Nós e Folhas**: Os nós são elementos individuais dentro da árvore que podem conter um valor e apontar para outros nós. As folhas são nós sem filhos, ou seja, que não têm nós subsequentes.

3. **Subárvore**: Cada nó em uma árvore pode ser raiz de uma subárvore, que é uma estrutura de árvore completa por si só.

4. **Altura da Árvore**: A altura de uma árvore é a medida do maior caminho possível da raiz até uma folha. Em uma árvore binária balanceada, a altura é aproximadamente logarítmica em relação ao número de nós.

5. **Grau de um Nó**: O grau de um nó é o número de subárvores que ele possui. No caso de uma árvore binária, o grau máximo de um nó é dois.

6. **Ordem de Traversal**: Existem várias maneiras de percorrer uma árvore binária, incluindo **pré-ordem**, **em ordem** e **pós-ordem**, que determinam a ordem na qual os nós são visitados.

7. **Balanceamento**: Uma árvore binária pode ser balanceada ou desbalanceada. Árvores balanceadas garantem que a altura da subárvore esquerda e direita de qualquer nó difira em no máximo uma altura.

| Operação             | Descrição                                               |               Big O Complexidade                |
|----------------------|---------------------------------------------------------|:-----------------------------------------------:|
| **Insertion**        | Adicionar um novo nó na árvore binária.                 |   O(log n) no melhor caso, O(n) no pior caso    |
| **Search**           | Procurar um elemento na árvore binária.                 |   O(log n) no melhor caso, O(n) no pior caso    |
| **Deletion**         | Remover um nó específico da árvore binária.             |   O(log n) no melhor caso, O(n) no pior caso    |
| **Traversals**       | Percorrer todos os nós da árvore em ordens específicas. |                      O(n)                       |

### 2.1 Operações Fundamentais

- **Insertion**: Adiciona um novo nó na árvore binária. A complexidade varia dependendo da estrutura da árvore, sendo mais eficiente quando a árvore está balanceada.


- **Search**: Procura por um elemento específico na árvore binária. A complexidade também varia, sendo mais rápida em árvores balanceadas onde a altura é menor.


- **Deletion**: Esta operação remove um nó específico da árvore binária. A complexidade depende da estrutura da árvore e pode envolver reorganização dos nós.


- **Traversals**: São métodos para percorrer todos os nós da árvore em uma ordem específica, como pré-ordem, em-ordem e pós-ordem. A complexidade é linear, O(n), pois visita cada nó uma vez.

## 3. Implementação

### 3.1 Classe TreeNode

A classe `TreeNode` representa cada nó da árvore binária.

```java
public class TreeNode {
    private int data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    // Getters e Setters
}
```

### 3.2 Inserção de Nós

```Java
public void insert(int value) {
root = insertRecursive(root, value);
}

private TreeNode insertRecursive(TreeNode current, int value) {
    if (current == null) {
        return new TreeNode(value);
    }
    if (value < current.data) {
        current.left = insertRecursive(current.left, value);
    } else if (value > current.data) {
        current.right = insertRecursive(current.right, value);
    }
    return current;
}
```

### 3.3 Busca de um Elemento
```Java
public boolean search(int value) {
    return searchRecursive(root, value);
}

private boolean searchRecursive(TreeNode current, int value) {
    if (current == null) {
        return false;
    }
    if (value == current.data) {
        return true;
    }
    return value < current.data
        ? searchRecursive(current.left, value)
        : searchRecursive(current.right, value);
}
```

### 3.4 Remoção de um Elemento
```Java
public void delete(int value) {
    root = deleteRecursive(root, value);
}

private TreeNode deleteRecursive(TreeNode current, int value) {
    if (current == null) {
        return null;
    }
    if (value == current.data) {
        // Caso 1 e 2: Nó sem filhos ou com apenas um filho
        if (current.left == null) {
            return current.right;
        } else if (current.right == null) {
            return current.left;
        }
        // Caso 3: Nó com dois filhos
        current.data = findMin(current.right);
        current.right = deleteRecursive(current.right, current.data);
        return current;
    }

    if (value < current.data) {
        current.left = deleteRecursive(current.left, value);
    } else {
        current.right = deleteRecursive(current.right, value);
    }
    return current;
}

private int findMin(TreeNode root) {
    return root.left == null ? root.data : findMin(root.left);
}
```

## 4. Conclusão