# Desafio Tunts

## DESAFIO
Criar uma aplicação em uma linguagem de programação de sua preferência (caso esteja se candidatando a uma vaga de linguagem de programação específica, exemplo: programador node.js, utilizar a linguagem/tecnologia específica da vaga). A aplicação deve ser capaz de ler uma planilha do google sheets, buscar as informações necessárias, calcular e escrever o resultado na planilha.

## REGRAS: 
Calcular a situação de cada aluno baseado na média das 3 provas (P1, P2 e P3), conforme a tabela: 

Média (m) | Situação
m<5         Reprovado por Nota
5<=m<7      Exame Final
m>=7        Aprovado


Caso o número de faltas ultrapasse 25% do número total de aulas o aluno terá a situação "Reprovado por Falta", independente da média.

Caso a situação seja "Exame Final" é necessário calcular a "Nota para Aprovação Final"(naf) de cada aluno de acordo com seguinte fórmula: 
5 <= (m + naf)/2
Caso a situação do aluno seja diferente de "Exame Final", preencha o campo "Nota para Aprovação Final" com 0.

Arredondar o resultado para o próximo número inteiro (aumentar) caso necessário.

Utilizar linhas de logs para acompanhamento das atividades da aplicação.

Os textos do código fonte (atributos, classes, funções, comentários e afins) devem ser escritos em inglês, salvo os identificadores e textos pré-definidos nesse desafio.

O candidato deve especificar os comandos que devem ser utilizados para execução da aplicação. Exemplo de uma aplicação node.js:
1.      npm install
2.      npm start
O candidato deve publicar o código fonte em um repositório git de sua preferência (exemplo: github, gitlab, bitbucket e etc).

## ENTREGÁVEIS
•	Link público do repositório git escolhido;
•	Comandos para rodar a aplicação;
•	Link público da planilha copiada.
## REFERÊNCIA
Documentação da Google Sheets: https://developers.google.com/sheets/api/guides/concepts



## -------------- Entrega -------------- ##

## EXECUTANDO O CÓDIGO //TODO


## CONSEGUINDO SUA PRÓPRIA CREDENCIAL NO GOOGLE
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
