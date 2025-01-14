Pequeno tutorial de como experimentar a nossa rede neuronal.
Como é habitual, o ficheiro principal é o IA04.java.

$ javac IA04.java
$ java IA04

Train file (path)
*introduzir path do ficheiro com os exemplos de treino*

.
 .
  .

Test file (path)
*introduzir path do ficheiro com os exemplos de teste*


Nota: 
	1) Como este código é desenvolvido em Java, existem alguns caracteres que
têm uma função específica. Assim sendo, convém ter cuidado com os caracteres
presentes no caminho absoluto dos ficheiros que serão lidos. Em Windows, o
caracter problemático é a barra ('\'), pelo que uma solução para que o ficheiro
seja lido sem qualquer problema é, por exemplo, duplicar as barras no path, algo
como:
	path original = C:\Users\anaca\Downloads\mnist_train.csv
	path aceite pelo Java = C:\\Users\\anaca\\Downloads\\mnist_train.csv
Pelos testes realizados em ambiente Linux, não parece haver problemas relativamente
aos caracteres presentes no path.

	2) Para experimentar a versão da rede com uma estrutura inspirada na
noação matricial, basta repetir o processo para o ficheiro IA04Simple.java