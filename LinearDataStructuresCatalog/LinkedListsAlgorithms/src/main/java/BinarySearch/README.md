# Busca Binária

## Sumário

1. [Introdução](#1-introdução)
2. [Algoritmos e Complexidades](#2-algoritmos-e-complexidades)
    - [Explicações](#21-explicações)
3. [Implementação](#3-implementação)
    - [Inicialização](#31-inicialização)
    - [Search](#32-search)
4. [Conclusão](#4-conclusão)


## 1. Introdução

A **Busca Binária** é um algoritmo de pesquisa que encontra a posição de um
elemento alvo em um array ordenado. Ela funciona dividindo repetidamente o espaço
de pesquisa pela metade, comparando o elemento do meio do array com o valor alvo
e ajustando os limites de pesquisa de acordo. 

Este algoritmo é muito mais rápido do que a busca linear para grandes conjuntos de dados.

## 2. Algoritmos e Complexidades

| Operação | Descrição                                     | Complexidade Big O |
|----------|-----------------------------------------------|:------------------:|
| Search   |Encontrar a posição de um elemento alvo em um array ordenado. |      O(log n)      |

### 2.1 Explicações

- **Search**:  Este algoritmo reduz o espaço de pesquisa pela metade em cada
iteração, comparando o elemento do meio do array com o valor alvo. Conforme a comparação, ajusta os limites de pesquisa para a metade esquerda ou direita, o processo é repetido até encontrar o elemento alvo ou esgotar o espaço de pesquisa.

## 3. Implementação
### 3.1 Inicialização

A classe é **`BinarySearch`** inicializada com um array ordenado de 100 posições.

```Java
public class BinarySearch {
    private Integer[] sortedArray;

    public BinarySearch() {
        this.sortedArray = new Integer[]{
                2, 5, 7, 12, 14, 19, 23, 25, 28, 32, 36, 40, 44, 48, 52, 56, 60, 64, 68,
                72, 76, 80, 84, 88, 92, 96, 100, 105, 110, 115, 120, 125, 130, 135, 140,
                145, 150, 155, 160, 165, 170, 175, 180, 185, 190, 195, 200, 205, 210, 215,
                220, 227, 230, 235, 240, 245, 250, 255, 260, 265, 270, 275, 280, 285, 293,
                295, 300, 305, 310, 315, 320, 325, 330, 335, 340, 345, 350, 355, 360, 365,
                372, 375, 380, 385, 390, 396, 400, 405, 410, 415, 420, 425, 430, 435, 440, 
                445, 450, 455, 460, 465
        };
    }
}
```

### 3.2 Search
Para encontrar um elemento em um array ordenado, o algoritmo segue estes passos:

1. Define-se o início (`left`) e o fim (`right`) do array.
2. Enquanto `left` for menor ou igual a `right`:
    - Calcula-se o índice do meio (`middle`).
    - Compara-se o valor do elemento no meio (`array[middle]`) com o valor alvo.
    - Se o valor do meio for igual ao alvo, retorna-se o índice do meio.
    - Se o valor do meio for menor que o alvo, ajusta-se `left` para `middle + 1`.
    - Se o valor do meio for maior que o alvo, ajusta-se `right` para `middle - 1`.
3. Se o alvo não for encontrado, retorna uma mensagem indicando que o elemento não está no array.

```Java
int search(int target) {
    int left = 0;
    int right = sortedArray.length - 1;

    while (left <= right){
        int middle = left + (right - left) / 2;

        if (sortedArray[middle] == target) {
            return middle;
        }

        if (sortedArray[middle] < target) {
            left = middle + 1;
        } else  {
            right = middle - 1;
        }
    }
    throw new RuntimeException(String.format("O elemento '%d' não está no array", target));
}
```
## 4. Conclusão
Devido à sua complexidade logarítmica, a busca binária é significativamente mais
rápida do que a busca linear para grandes conjuntos de dados. No entanto, ela só 
pode ser aplicada a arrays previamente ordenados. Em listas encadeadas, a busca
binária não é prática, pois requer acesso direto a elementos, o que não é possível
nessa estrutura de dados.