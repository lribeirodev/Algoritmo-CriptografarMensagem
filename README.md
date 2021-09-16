# Algoritmo criptografia de mensagem

Este algoritmo foi criado no intuito de elaborar um sistema único de criptografia de mensagem

Criado em Linguagem Java

<h2>Lógica: </h2>
A lógica por trás do algoritmo trabalha na reordenação das palavras, através de um dicionario
o algoritmo faz um calculo matematico randomico, criando um novo indice para cada letra.

<h2>Funcionamento: </h2>
O usuário informa a chave e a mensagem, o algoritmo codifica a mensagem, gerando uma nova chave chamada de "KEY DNA" apenas quem possuir essa chave é capaz de quebrar o sigilo da mensagem.

<h2>Exemplo: </h2>
<b><h3>[ Chave Informada Pelo Usuário ]</h3>"Programador"</b>
  
<b><h3>[ Entrada do Usuário ]</h3>"Olá meu nome é Lucas Ribeiro sou programador Java"</b>

<b><h3>[ Sáida do Algoritmo ]</h3>"BcGTO2YTWHO2TÍTtYVQiTaXï2XXHTiHYTVXHjXQOQRHXT0QsQ"<b>

<h3>[ Key Dna ]</h3>
121 2 19 90 57 91 24 51 45 86 13 56 72 102 12 9 97 81 11 111
67 62 78 44 29 122 61 118 4 123 108 55 71 37 7 114 107 41 30 105
98 112 109 125 36 43 126 46 53 5 116 88 65 103 54 48 33 106 94 77
93 3 99 27 15 75 38 32 115 120 20 83 87 113 16 82 52 39 10 18
84 59 6 35 66 89 104 58 14 69 80 127 101 60 79 23 63 73 47 74
92 26 49 28 117 34 70 40 22 110 21 17 

<h2>Como usar:</h2>

<h3>Importar a classe para seu ambiente de desenvolvimento</h3>
  
```java
import com.ribeiro.codificar.app;
```
  
<h3>Criar uma nova Instancia da classe encoder</h3>
  
```java
Encoder ec = Encoder.getInstance();
```
  
<h3>Setar uma chave</h3>
  
```java
ec.setKey("Sua chave aqui");
```
  
<h3>Digite sua mensagem</h3>
  
```java
ec.setMsg("Sua mensagem aqui");
```
    
<h3>Gerar Mensagem Codificada</h3>
  
```java
ec.getEncodedMsg();
```

