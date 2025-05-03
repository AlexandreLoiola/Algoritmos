# Tabela Hash

## 1. Introdução

**Tabela hash** é uma estrutura de dados que mapeia chaves para valores. Ela utiliza uma `função hash` para converter uma `chave` em um índice em um array, onde o valor associado à `chave` é armazenado. Isso permite um acesso rápido aos dados, com complexidade média de tempo constante para as operações principais.

1. **Chave**: A chave é usada como entrada para a função hash. Pode ser de qualquer tipo que suporte uma operação de hash, como strings, inteiros, ou objetos.


2. **Valor**: O valor é o dado associado a uma chave específica. Pode ser qualquer tipo de dado, como números, strings, ou objetos complexos.


3. **Função Hash**: Uma função hash mapeia a chave para um índice em um array, distribuindo as chaves de maneira uniforme para minimizar colisões.


4. **Tratamento de Colisões**: Quando duas chaves diferentes mapeiam para o mesmo índice, a tabela hash deve resolver a colisão usando técnicas como encadeamento (listas vinculadas) ou endereçamento aberto (sondagem linear, quadrática, etc.).

Além desses componentes, a tabela hash mantém um array de buckets, onde cada bucket pode armazenar múltiplos pares chave-valor em caso de colisões.

## 2. Algoritmos e Complexidades

| Operação     | Descrição                                                                          | Complexidade Big O |
|--------------|------------------------------------------------------------------------------------|:------------------:|
| **Insert**   | Adicionar um novo par chave-valor na tabela hash.                                  | O(1)               |
| **Remove**   | Remover um par chave-valor da tabela hash.                                         | O(1)               |
| **Get**      | Recuperar o valor associado a uma chave.                                           | O(1)               |
| **ContainsKey** | Verificar se uma chave está presente na tabela hash.                            | O(1)               |
| **Size**     | Obter o número de pares chave-valor na tabela hash.                                | O(1)               |

### 2.1 Explicações

- **Insert**: Adiciona um novo par chave-valor na tabela hash. Utiliza a função hash para encontrar o índice apropriado e, em caso de colisão, resolve-a adicionando o novo par ao bucket correspondente. A inserção é geralmente realizada em tempo constante.


- **Remove**: Remove o par chave-valor associado a uma chave específica. Utiliza a função hash para encontrar o índice e, se a chave existir, remove o par do bucket. É realizada em tempo constante.


- **Get**: Recupera o valor associado a uma chave específica. Utiliza a função hash para encontrar o índice e retorna o valor se a chave existir no bucket correspondente. É realizada em tempo constante.


- **ContainsKey**: Verifica se uma chave está presente na tabela hash. Utiliza a função hash para encontrar o índice e verifica a presença da chave no bucket correspondente. É realizada em tempo constante.


- **Size**: Retorna o número de pares chave-valor atualmente armazenados na tabela hash. A tabela hash mantém um contador interno para acompanhar o número de elementos, permitindo que esta operação seja realizada em tempo constante.

## 3

Claro! O método getBucketIndex é usado para calcular o índice do bucket (ou balde) onde um par chave-valor deve ser armazenado na tabela hash. Vamos analisar cada parte do método em detalhes:

java
Copy code
private int getBucketIndex(String key) {
int hashCode = key.hashCode();
return Math.abs(hashCode) % numBuckets;
}
1. int hashCode = key.hashCode();
   key.hashCode(): Este método é chamado na chave (que é uma string, neste caso) para obter o valor do código hash da chave. O método hashCode() é um método nativo do Java disponível para todos os objetos (herdado da classe Object). Ele retorna um valor inteiro que é o código hash do objeto.
   Para strings, o método hashCode() é implementado de forma que gera um código hash com base no conteúdo da string. Duas strings iguais produzirão o mesmo código hash.
2. return Math.abs(hashCode) % numBuckets;
   Math.abs(hashCode): O método Math.abs é usado para obter o valor absoluto do código hash. Isso garante que o índice gerado seja um número positivo, pois o valor do código hash pode ser negativo.

Exemplo: se hashCode for -123456, então Math.abs(hashCode) será 123456.
% numBuckets: O operador de módulo % é usado para garantir que o índice resultante esteja dentro dos limites do array de buckets. numBuckets é o tamanho do array de buckets.

O índice gerado será um número entre 0 e numBuckets - 1.
Isso distribui uniformemente as chaves nos buckets, ajudando a minimizar colisões.
Resumo do Método
O método getBucketIndex converte a chave em um código hash, garante que o código hash seja positivo, e então usa o operador de módulo para obter um índice válido para o array de buckets da tabela hash. Este índice é usado para determinar onde armazenar ou buscar o par chave-valor na tabela hash.