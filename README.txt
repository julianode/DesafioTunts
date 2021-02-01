# Desafio Tunts
## -------------- Entrega -------------- ##

A minha planilha está no endereço:
 https://docs.google.com/spreadsheets/d/1FefNWWy06XGLzil4GPIfgErGSb5ZhNVH_cuVYnLNIHo/

Esta é a planilha por padrão (default) que a applicação vai ler, calcular e escrever nela.
Ao usar outra planilha, a mesma deve seguir o mesmo padrão de layout da mostrada acima.
Afinal, o aplicativo espera ler e escrever em colunas definidas.


## O que a aplicação faz

Ao inicializar o programa vai perguntar se você quer ler outra planilha. 

Se a reposta for não (digite a letra "n" e tecle enter), ele vai ler a planilha padrão.

Sugiro que alguém deve usar a aplicação em planilhas das quais se é o dono, ou tem permissão de editar.

No caso deste exercício, a panilha que está como padrão é minha.
Mas deixei a permissão de editar para qualquer pessoa.

Quando o programa pedir para inserir o ID da planilha que você quer usar, digite "y" e tecle enter.

Insira então o ID da planilha, que é uma parte dentro do endereço.
Ex.:  https://docs.google.com/spreadsheets/d/AQUI_ESTÁ_O_ID_DA_PLANILHA/

Depois, tecle enter e o aplicativo vai rodar.

O seu navegador padrão irá abrir e o Google pedirá para que faça login e dê permissão ao aplicativo para editar os documentos no Google DRIVE.
Use as opções avançadas da página de segurança. Essas são as letras miúdas no fim da tela.

Com a permissão concedida, uma tela com uma frase dizendo que a janela pode ser fechada será emitida.

O programa vai continuar rodando.
Sem a autenticação no navegador, o programa não vai seguir para a leitura e edição.

Com a leitura bem sucedida, ele vai mostrar na tela os dados lidos.
Depois, ele mostrará logs de acompanhamento de quantos cálculos estão prontos.
Por fim, ele deixará na tela quantas células foram alteradas.


## EXECUTANDO O CÓDIGO

1 - no Windows, sem ferramentas de desenvolvedor, sem ver logs.

Faça o download do repositório. Extraia o mesmo.
Entre na pasta build/distributions e encontre o arquivo DesafioTunts.zip.
Apenas esse arquivo é o suficiente para executar a aplicação.

Extraia DesafioTunts.zip, entre na pasta "bin" (de binário, arquivos binários).
Execute o arquivo DesafioTunts.bat.

Siga o roteiro acima "O que a aplicação faz".
A janela da aplicação vai fechar assim que terminar de trabalhar.
Pronto, sua planilha está calculada.


2 - no Windows, sem ferramentas de desenvolvedor, PODENDO VER OS logs.

Faça o download do repositório. Extraia o mesmo.
Entre na pasta build/distributions e encontre o arquivo DesafioTunts.zip.
Apenas esse arquivo é o suficiente para executar a aplicação.

Extraia DesafioTunts.zip, entre na pasta "bin" (de binário, arquivos binários).
Na janela aperto do windows, clique na barra de endereços e digite "cmd" sem as aspas.
O windows vai abrir o prompt de comando na pasta aberta.
Digite "DesafioTunts.bat" sem aspas e tecle enter.

Siga o roteiro acima "O que a aplicação faz".
A janela da aplicação vai ficar aberta para poder rolar a barra lateral e ver os logs.
Assim pode-se saber tudo o que ela fez.
Pronto, sua planilha está calculada.


3 - COM ferramentas de desenvolvedor, PODENDO VER TUDO.

Se você tem ferramentas de desenvolverdor insaladas, tem alguma experiência em TI.
Portanto, serei menos detalhista.

Tenha instalado Gradle e uma JDK (JDK do Java 8 no mínimo) do seu computador.
Recomento InteliJ IDEA (IDE) também para navegar pelo código fonte.

Você precisará ter sua própria credencial da API do Google.
Por questões de segurança a minha não está do repositório, pois ela não ficaria "escondida" dentro da aplicação.
Quando subo o código fonte para o repositorio deixo arquivos de fora propositalmente.
Ver ".gitignore".
Abaixo tem uma seção de como conseguir a sua própria credencial.

Com isso pronto, segue-se.
Clone o repositório, e dentro da pasta raíz da aplicação use o comando "gradle run" no prompt de comando.

Se você apenas usar "gradle run" sem as credenciais, aparecerá o erro java.io.FileNotFoundException apontanto para o arquivo "credentials.json".
Então, busque as credenciais.


## CONSEGUINDO SUA PRÓPRIA CREDENCIAL NO GOOGLE

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




