# Desafio Tunts

## DESAFIO
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



## -------------- Entrega -------------- ##

## EXECUTANDO O C�DIGO //TODO


## CONSEGUINDO SUA PR�PRIA CREDENCIAL NO GOOGLE
(in english, because it is parte of the deliverables
 there is a README file inside src\main\resources folder
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
