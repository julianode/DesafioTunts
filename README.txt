# Desafio Tunts
## -------------- Entrega -------------- ##

A minha planilha est� no endere�o:
 https://docs.google.com/spreadsheets/d/1FefNWWy06XGLzil4GPIfgErGSb5ZhNVH_cuVYnLNIHo/

Esta � a planilha por padr�o (default) que a applica��o vai ler, calcular e escrever nela.
Ao usar outra planilha, a mesma deve seguir o mesmo padr�o de layout da mostrada acima.
Afinal, o aplicativo espera ler e escrever em colunas definidas.


## O que a aplica��o faz

Ao inicializar o programa vai perguntar se voc� quer ler outra planilha. 

Se a reposta for n�o (digite a letra "n" e tecle enter), ele vai ler a planilha padr�o.

Sugiro que algu�m deve usar a aplica��o em planilhas das quais se � o dono, ou tem permiss�o de editar.

No caso deste exerc�cio, a panilha que est� como padr�o � minha.
Mas deixei a permiss�o de editar para qualquer pessoa.

Quando o programa pedir para inserir o ID da planilha que voc� quer usar, digite "y" e tecle enter.

Insira ent�o o ID da planilha, que � uma parte dentro do endere�o.
Ex.:  https://docs.google.com/spreadsheets/d/AQUI_EST�_O_ID_DA_PLANILHA/

Depois, tecle enter e o aplicativo vai rodar.

O seu navegador padr�o ir� abrir e o Google pedir� para que fa�a login e d� permiss�o ao aplicativo para editar os documentos no Google DRIVE.
Use as op��es avan�adas da p�gina de seguran�a. Essas s�o as letras mi�das no fim da tela.

Com a permiss�o concedida, uma tela com uma frase dizendo que a janela pode ser fechada ser� emitida.

O programa vai continuar rodando.
Sem a autentica��o no navegador, o programa n�o vai seguir para a leitura e edi��o.

Com a leitura bem sucedida, ele vai mostrar na tela os dados lidos.
Depois, ele mostrar� logs de acompanhamento de quantos c�lculos est�o prontos.
Por fim, ele deixar� na tela quantas c�lulas foram alteradas.


## EXECUTANDO O C�DIGO

1 - no Windows, sem ferramentas de desenvolvedor, sem ver logs.

Fa�a o download do reposit�rio. Extraia o mesmo.
Entre na pasta build/distributions e encontre o arquivo DesafioTunts.zip.
Apenas esse arquivo � o suficiente para executar a aplica��o.

Extraia DesafioTunts.zip, entre na pasta "bin" (de bin�rio, arquivos bin�rios).
Execute o arquivo DesafioTunts.bat.

Siga o roteiro acima "O que a aplica��o faz".
A janela da aplica��o vai fechar assim que terminar de trabalhar.
Pronto, sua planilha est� calculada.


2 - no Windows, sem ferramentas de desenvolvedor, PODENDO VER OS logs.

Fa�a o download do reposit�rio. Extraia o mesmo.
Entre na pasta build/distributions e encontre o arquivo DesafioTunts.zip.
Apenas esse arquivo � o suficiente para executar a aplica��o.

Extraia DesafioTunts.zip, entre na pasta "bin" (de bin�rio, arquivos bin�rios).
Na janela aperto do windows, clique na barra de endere�os e digite "cmd" sem as aspas.
O windows vai abrir o prompt de comando na pasta aberta.
Digite "DesafioTunts.bat" sem aspas e tecle enter.

Siga o roteiro acima "O que a aplica��o faz".
A janela da aplica��o vai ficar aberta para poder rolar a barra lateral e ver os logs.
Assim pode-se saber tudo o que ela fez.
Pronto, sua planilha est� calculada.


3 - COM ferramentas de desenvolvedor, PODENDO VER TUDO.

Se voc� tem ferramentas de desenvolverdor insaladas, tem alguma experi�ncia em TI.
Portanto, serei menos detalhista.

Tenha instalado Gradle e uma JDK (JDK do Java 8 no m�nimo) do seu computador.
Recomento InteliJ IDEA (IDE) tamb�m para navegar pelo c�digo fonte.

Voc� precisar� ter sua pr�pria credencial da API do Google.
Por quest�es de seguran�a a minha n�o est� do reposit�rio, pois ela n�o ficaria "escondida" dentro da aplica��o.
Quando subo o c�digo fonte para o repositorio deixo arquivos de fora propositalmente.
Ver ".gitignore".
Abaixo tem uma se��o de como conseguir a sua pr�pria credencial.

Com isso pronto, segue-se.
Clone o reposit�rio, e dentro da pasta ra�z da aplica��o use o comando "gradle run" no prompt de comando.

Se voc� apenas usar "gradle run" sem as credenciais, aparecer� o erro java.io.FileNotFoundException apontanto para o arquivo "credentials.json".
Ent�o, busque as credenciais.


## CONSEGUINDO SUA PR�PRIA CREDENCIAL NO GOOGLE

(In english, because it is parte of the deliverables
 to have english content. There is a README file inside "src\main\resources" folder
 which gives those directions too)

Go to https://console.developers.google.com/

Login with your google username and password.

On the leftside menu, click on "Credentials". New screen loaded.
Use the "+ Create Credentials" button and select the OAuth Id client option.

After making your own ID, download the .json file.
(the Google's platform gives you this option at creation time
 otherwise, go back to the "Credentials" menu screen, select the credential,
 and download it from there)

Place the .json file insite the src\main\resources.
The name of the file must be "credentials.json" (hard coded this way).



## DESAFIO (enunciado do texto original)
Criar uma aplica��o em uma linguagem de programa��o de sua prefer�ncia (caso esteja se candidatando a uma vaga de linguagem de programa��o espec�fica, exemplo: programador node.js, utilizar a linguagem/tecnologia espec�fica da vaga). A aplica��o deve ser capaz de ler uma planilha do google sheets, buscar as informa��es necess�rias, calcular e escrever o resultado na planilha.

## REGRAS: 
Calcular a situa��o de cada aluno baseado na m�dia das 3 provas (P1, P2 e P3), conforme a tabela: 

M�dia (m) | Situa��o
m<5         Reprovado por Nota
5<=m<7      Exame Final
m>=7        Aprovado


Caso o n�mero de faltas ultrapasse 25% do n�mero total de aulas o aluno ter� a situa��o "Reprovado por Falta", independente da m�dia.

Caso a situa��o seja "Exame Final" � necess�rio calcular a "Nota para Aprova��o Final"(naf) de cada aluno de acordo com seguinte f�rmula: 
5 <= (m + naf)/2
Caso a situa��o do aluno seja diferente de "Exame Final", preencha o campo "Nota para Aprova��o Final" com 0.

Arredondar o resultado para o pr�ximo n�mero inteiro (aumentar) caso necess�rio.

Utilizar linhas de logs para acompanhamento das atividades da aplica��o.

Os textos do c�digo fonte (atributos, classes, fun��es, coment�rios e afins) devem ser escritos em ingl�s, salvo os identificadores e textos pr�-definidos nesse desafio.

O candidato deve especificar os comandos que devem ser utilizados para execu��o da aplica��o. Exemplo de uma aplica��o node.js:
1.      npm install
2.      npm start
O candidato deve publicar o c�digo fonte em um reposit�rio git de sua prefer�ncia (exemplo: github, gitlab, bitbucket e etc).

## ENTREG�VEIS
�	Link p�blico do reposit�rio git escolhido;
�	Comandos para rodar a aplica��o;
�	Link p�blico da planilha copiada.
## REFER�NCIA
Documenta��o da Google Sheets: https://developers.google.com/sheets/api/guides/concepts




