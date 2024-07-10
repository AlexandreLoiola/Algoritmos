# Palíndromo de Inteiro

Este algoritmo tem como objetivo verificar se um número inteiro é um palíndromo através de iteração.

## Índice

- [Introdução](#1-introdução)
- [Teoria](#2-teoria)
- [Exemplo de Execução](#3-exemplo-de-execução)
- [Conclusão](#4-conclusão)

## 1. Introdução
 
Compile e execute a classe `PalindromeInteger`. O programa solicitará que seja inserido um número inteiro e verificará se o número é um palíndromo.

```java
import java.util.Scanner;

public class PalindromeInteger {
    public static void main(String args[]) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Insira um número inteiro: ");
            if (scanner.hasNextInt()) {
                System.out.println(isIntPalindrome(scanner.nextInt()));
            } else {
                throw new RuntimeException("Entrada inválida. Por favor, insira um número inteiro.");
            }
        }
    }
}
```

## 2. Implementação

### 2.1 Método de verificação de palíndromo

A verificação de palíndromo de um número inteiro é feita através da reversão do número e comparação com o valor original.

```Java
private static boolean isIntPalindrome(int x) {
    if (x < 0) {
        return false; // Números negativos não são palíndromos
    }
    int originalValue = x;
    int reversedValue = 0;
    while (x != 0) {
        int digit = x % 10; // Obtém o dígito mais à direita
        reversedValue = reversedValue * 10 + digit; // Adiciona o dígito ao número invertido
        x /= 10; // Remove o dígito mais à direita do número original
    }
    return originalValue == reversedValue;
}
```
### Explicação:

1. Se o número for negativo, retorna `false` (números negativos não são considerados palíndromos).
2. Armazena o valor original do número.
3. Inicializa `reversedValue` como 0.
4. Enquanto o número não for 0:
    - Obtém o dígito mais à direita (`x % 10`).
    - Adiciona o dígito ao `reversedValue` multiplicado por 10.
    - Remove o dígito mais à direita do número original (`x /= 10`).
5. Compara o valor original com o valor invertido.
6. Retorna `true` se forem iguais, caso contrário, retorna `false`.

## 3. Conclusão

A iteração é um método direto e prático para verificar se um número inteiro é um palíndromo. Em comparação com a conversão do número em uma string, que pode exigir manipulações adicionais de caracteres, a abordagem iterativa utiliza operações aritméticas simples diretamente no número.

Além de sua simplicidade, a iteração é vantajosa em termos de uso de memória e tempo de execução. Não requer a criação de novas estruturas de dados como strings adicionais e elimina a necessidade de chamadas recursivas, o que simplifica o código e melhora sua eficiência.