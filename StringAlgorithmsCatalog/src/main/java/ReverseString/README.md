# Inversão de String

Este algoritmo tem como objetivo inverter uma string através de recursão e iteração.

## Índice

- [Introdução](#1-introdução)
- [Método 1: Recursão](#2-método-1-recursão)
  - [Teoria](#21-teoria)
  - [Exemplo de Execução](#22-exemplo-de-execução)
- [Método 2: Iteração](#3-método-2-iteração)
  - [Teoria](#31-teoria)
  - [Exemplo de Execução](#32-exemplo-de-execução)
- [Conclusão](#4-conclusão)

## 1. Introdução

Compile e execute a classe `ReverseString`. O programa solicitará que seja insirida uma string, a qual será invertida usando um método recursivo.

```java
public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira uma String:");
        String name = scanner.nextLine();
        System.out.println(reverseStringWithRecursion(name));
    }
}
```
## 2. Método 1: Recursão
O método `reverseStringWithRecursion` usa recursão para inverter a string de entrada.

### 2.1 Teoria
Recursão é uma técnica onde uma função chama a si mesma para resolver instâncias menores do mesmo problema até atingir um caso base. Neste exemplo, o caso base é quando a string de entrada está vazia.

```java
public static String reverseStringWithRecursion(String str) {
    if (str.isEmpty()) return str;  // Caso base: string vazia
    return reverseStringWithRecursion(str.substring(1)) + str.charAt(0);
}
```

### 2.2 Exemplo de Execução
Considerando a String **"Java"** como entrada:

1. **Chamada Inicial**: `reverseStringWithRecursion("java")`
  - Não está vazia, chama com `"ava"` e adiciona `'j'` ao final.
2. **Primeira Chamada Recursiva**: `reverseStringWithRecursion("ava")`
  - Não está vazia, chama com `"va"` e adiciona `'a'` ao final.
3. **Segunda Chamada Recursiva**: `reverseStringWithRecursion("va")`
  - Não está vazia, chama com `"a"` e adiciona `'v'` ao final.
4. **Terceira Chamada Recursiva**: `reverseStringWithRecursion("a")`
  - Não está vazia, chama com `""` e adiciona `'a'` ao final.
5. **Caso Base**: `reverseStringWithRecursion("")`
  - Está vazia, retorna `""`.

A função agora retorna concatenando os caracteres na ordem inversa:

- Retorna `"" + 'a'` -> `"a"`
- Retorna `"a" + 'v'` -> `"av"`
- Retorna `"av" + 'a'` -> `"ava"`
- Retorna `"ava" + 'j'` -> `"avaj"`

Portanto, "Java" é invertido para "avaJ".

## 3. Método 2: Iteração
O método `reverseString` usa um laço para inverter a string de entrada.

### 3.1 Teoria
Iteração é um processo onde um conjunto de instruções é repetido sequencialmente até que uma condição específica seja atendida. Neste exemplo, a condição é percorrer todos os caracteres da string usando um laço `for` até que todos os índices sejam iterados.
```java
public static String reverseStringWithIteration(String str) {
    String reversedString = new String();
    for (int i = 1; i <= str.length(); i ++) { // Caso base: 
        char lastChar = str.charAt(str.length() - i);
        reversedString = reversedString + lastChar;
    }
    return reversedString;
}
```
### 3.2 Exemplo de Execução

Considerando a String "Java" como entrada:

1. **Iteração 1**:
  - `i = 1`
  - `lastChar = str.charAt(str.length() - 1) = 'a'`
  - `reversedString = "" + 'a' = "a"`

2. **Iteração 2**:
  - `i = 2`
  - `lastChar = str.charAt(str.length() - 2) = 'v'`
  - `reversedString = "a" + 'v' = "av"`

3. **Iteração 3**:
  - `i = 3`
  - `lastChar = str.charAt(str.length() - 3) = 'a'`
  - `reversedString = "av" + 'a' = "ava"`

4. **Iteração 4**:
  - `i = 4`
  - `lastChar = str.charAt(str.length() - 4) = 'J'`
  - `reversedString = "ava" + 'J' = "avaJ"`

Portanto, "Java" é invertido para "avaJ".

## 4. Conclusão
Tanto a recursão quanto a iteração são métodos eficazes para inverter uma string. A recursão é mais elegante e fácil de entender conceitualmente, enquanto a iteração é mais eficiente em termos de uso de memória.