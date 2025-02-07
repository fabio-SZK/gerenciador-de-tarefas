<h1 align="center"> Tasky </h1>

## Objetivo:

É um gerenciador de tarefas que tem como objetivo otimizar a organização e o acompanhamento das atividades empresariais e pessoais, promovendo maior eficiência e integração nos processos internos.

## Alunos: 

2576147 - Álefh Trindade Luz De Lima

2576198 - Fábio Massashi Suzuki

2576201 – Gabriel Batistela Da Silva

## ✔️Tecnologias utilizadas:
- ``Java``
- ``Astah UML``
- ``SGDB PostgreSQL``

# CLASSES -

Abstrato Tarefa: FILHAS(TarefaPessoal, TarefaAcademica, TarefaTrabalho)

Usuario

Formulario (Tarefa, Projeto, principal, lista, etc.)

Projeto

Interface PessoaResponsavel

Equipe

Perfil

# PRINCIPAIS FUNCIONALIDADES -

Criar, consultar, excluir e alterar tarefas, equipes e projetos

Gerenciar tarefas pessoais

Adicionar ou remover tarefas de um projeto

Adicionar ou remover usuários responsáveis por uma tarefa 

Adicionar  ou remover usuários a um projeto

Adicionar ou remover usuários de uma equipe

Definir usuários adiministradores de uma equipe

Relacionar projetos a uma ou mais equipes, ou a um ou mais usuários

Listar tarefas do usuário

Listar tarefas do projeto

Listar projetos que o usuário participa

Listar equipes e usuários que estão ligados a um projeto

Listar equipes que o usuário participa

Cadastrar usuário

Fazer login

Alterar perfil

Visualizar perfis de outros usuarios



## ***Requisitos funcionais***

|Identificador| Descrição| Prioridade|
| -------- | -------- | -------- |
|RF01|O sistema deve permitir o cadastro de usuário indicando nome, senha, e-mail e contato.|Alta|
|RF02|O sistema deve permitir aos usuários o login indicando e-mail e senha.|Alta|
|RF03|O sistema deve atribuir um perfil a cada usuário possuindo campos de nome de exibição obrigatório, descrição, equipes e projetos opcionais.|Alta|
|RF04|O sistema deve permitir ao usuário adicionar ou remover tarefas.|Alta|
|RF05|O sistema deve alertar por notificação sobre tarefas pendentes.|Média|
|RF06|O sistema deve permitir ao usuário a criação de projetos indicando data de criação, objetivo, nome, data limite, usuários ou equipes participantes.|Alta|
|RF07|O sistema deve permitir ao usuário criação de equipes independentes do projeto podendo vincular posteriormente.|Alta|
|RF08|O sistema deve permitir ao usuário criação de equipes indicando nome, função, usuários participantes e o administrador da equipe.|Alta|
|RF09|O sistema deve listar as tarefas por ordem de prioridade que é especificada pelo usuário.|Alta|
|RF10|O sistema deve guardar o histórico de tarefas registradas do usuário.|Média|
|RF11|O sistema deve permitir ao usuário que criou o projeto definir um ou mais administradores.|Média|
|RF12|O sistema deve permitir ao usuário adicionar tarefas indicando prioridade, data limite, nome e descrição.|Alta|
|RF13|O sistema deve permitir aos administradores de um projeto atribuir tarefas aos usuários ou equipes participantes.|Alta|
|RF14|O sistema deve permitir ao usuário definir a prioridade de uma tarefa em baixa, média, alta ou urgente.|Alta|
|RF15|O sistema deve apresentar ao usuário um calendário permitindo ao usuário consultar tarefas que estão relacionadas a um dia.|Média|
|RF16|O sistema deve mostrar ao usuário o tempo que falta até chegar a data limite de suas tarefas.|Média|



## ***Requisitos não funcionais***

|Identificador| Descrição| Tipo|
| -------- | -------- | -------- |
|RNF01|O sistema deve ser desenvolvido utilizando a linguagem de programação Java|Segurança|
|RNF02|O sistema deve funcionar para desktop.|Implementação|
|RNF03|O sistema deve ser desenvolvido utilizando as técnicas de Programação Orientada a Objetos.|Implementação|
|RNF04|O sistema deve criptografar as informações ao salvar os dados.|Segurança|
|RNF05|O sistema deve ter uma interface intuitiva, permitindo que novos usuários completem uma tarefa em menos de 3 minutos.|Facilidade de uso|
|RNF06|O sistema deve ser desenvolvido utilizando a linguagem de programação Java.|Implementação|

## ***Relação de Atores***

|ID| Nome do ator| Descrição|
| -------- | -------- | -------- |
|A1|Usuário|Responsável por cadastrar Usuário, definir responsável pela tarefa, Gerenciar Projeto, Gerenciar Tarefa e Consultar Usuários|
|A2|Administrador|Responsável por Gerenciar Equipe e Gerenciar Projeto|

## ***Relação dos Casos de Uso***

| ID    | Nome do Caso de Uso                 |
|-------|-------------------------------------|
| UC1   | Cadastrar Usuário                   |
| UC2   | Gerenciar Perfil                    |
| UC3   | Fazer Login                         |
| UC4   | Definir Responsável pela Tarefa     |
| UC5   | Gerenciar Tarefa                    |
| UC5.1 | Consultar Tarefa                    |
| UC5.2 | Gerenciar Tarefa                    |
| UC5.3 | Excluir Tarefa                      |
| UC5.4 | Alterar Tarefa                      |
| UC5.5 | Listar Tarefa                       |
| UC5.6 | Criar Tarefa                        |
| UC5.7 | Criar Tarefa de Revisão             |
| UC5.8 | Criar Tarefa de Planejamento        |
| UC5.9 | Criar Tarefa de Execução            |
| UC5.10| Aceitar Tarefa                      |
| UC5.11| Recusar Tarefa                      |
| UC6   | Gerenciar Equipe                    |
| UC6.1 | Criar Equipe                        |
| UC6.2 | Alterar Equipe                      |
| UC6.3 | Excluir Equipe                      |
| UC6.4 | Consultar Equipe                    |
| UC6.5 | Listar Equipe                       |
| UC6.6 | Adicionar Usuário                   |
| UC7   | Gerenciar Projeto                   |
| UC7.1 | Criar Projeto                       |
| UC7.2 | Alterar Projeto                     |
| UC7.3 | Consultar Projeto                   |
| UC7.4 | Visualizar Projeto                  |
| UC7.5 | Gerenciar Equipe                    |

## ***Especificação dos Casos de Uso***

Fluxo Normal:
| ID do Caso de Uso | ID do Cenário | Nome do Cenário           | Sequência de Eventos                                                                                                                                                                                                                   |
|-------------------|---------------|---------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| UC5.6             | UC5           | Criar Tarefa               | 1) O usuário solicita a criação de uma nova tarefa. <br> 2) O usuário insere os dados da tarefa (nome, descrição, prazo, responsável, prioridade e projeto associado). <br> 3) O sistema verifica se já existe uma tarefa com o mesmo nome no mesmo projeto. <br> 4) O sistema valida os dados da tarefa. <br> 5) O sistema salva os dados da tarefa e gera um identificador único para a tarefa. <br> 6) O sistema emite uma mensagem de sucesso, confirmando a criação da tarefa. <br> 7) O sistema pergunta se o usuário deseja cadastrar outra tarefa. |
| UC7.1             | UC7           | Criar Projeto              | 1) O usuário solicita a criação de um novo projeto. <br> 2) O usuário insere os dados do projeto (nome do projeto, descrição, prazo, membros envolvidos e líder do projeto) no sistema. <br> 3) O sistema verifica se já existe um projeto com o mesmo nome. <br> 4) O sistema valida os dados inseridos. <br> 5) O sistema salva os dados do projeto e gera um número identificador para o projeto. <br> 6) O sistema emite uma mensagem de sucesso, confirmando a criação do projeto. <br> 7) O sistema pergunta se o usuário deseja adicionar mais membros ao projeto ou criar um novo projeto. |
| UC6.1             | UC6           | Criar Equipe               | 1) O administrador solicita a criação de uma nova equipe. <br> 2) O administrador insere os dados da equipe (nome da equipe, descrição, membros iniciais, líder da equipe, e área de atuação) no sistema. <br> 3) O sistema verifica se o nome da equipe já existe. <br> 4) O sistema valida os dados inseridos. <br> 5) O sistema salva os dados da equipe e gera um identificador único para a equipe. <br> 6) O sistema emite uma mensagem de sucesso, confirmando a criação da equipe. <br> 7) O sistema pergunta se o administrador deseja adicionar mais membros à equipe ou criar uma nova equipe. |
| UC2               | UC2           | Gerenciar Perfil           | 1) O usuário acessa a opção de gerenciamento de perfil. <br> 2) O sistema exibe as informações atuais do perfil do usuário (nome, e-mail, etc.). <br> 3) O usuário atualiza as informações desejadas (nome, e-mail, senha, foto, etc.). <br> 4) O sistema valida as novas informações fornecidas. <br> 5) O sistema verifica se o e-mail ou nome de usuário atualizado já existe no banco de dados. <br> 6) O sistema salva as alterações no perfil. <br> 7) O sistema emite uma mensagem de sucesso, confirmando que o perfil foi atualizado. <br> 8) O sistema pergunta se o usuário deseja realizar mais alguma alteração no perfil. |
| UC4               | UC4           | Definir Responsável pela Tarefa | 1) O usuário (gerente ou líder de projeto) acessa a opção de gerenciamento de tarefas. <br> 2) O sistema exibe a lista de tarefas disponíveis. <br> 3) O usuário seleciona a tarefa para a qual deseja definir um responsável. <br> 4) O sistema exibe a lista de membros da equipe. <br> 5) O usuário escolhe o membro que será o responsável pela tarefa. <br> 6) O sistema verifica se o membro selecionado já possui outras tarefas atribuídas e alerta, caso necessário. <br> 7) O sistema atualiza a tarefa com o responsável definido. <br> 8) O sistema emite uma mensagem de sucesso, confirmando que o responsável pela tarefa foi definido. <br> 9) O sistema pergunta se o usuário deseja definir outro responsável para uma nova tarefa. |

## Caminhos alternativos:

| ID do Caminho Alternativo | Descrição                                                                                                                                                                                                 |
|---------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1                         | Se algum dos dados obrigatórios (tarefa ou responsável) não for informado, o sistema emite um aviso informando o erro, e a ação de definir o responsável não é efetuada. O usuário é redirecionado para corrigir as informações.                |
| 2                         | Se o responsável selecionado já estiver designado para outra tarefa que conflitue em prazo ou recursos, o sistema emite um aviso e a definição do responsável não é efetuada. O usuário é solicitado a escolher outro membro da equipe ou ajustar a tarefa. |
| 3                         | Se o sistema detectar que já existe um responsável atribuído à mesma tarefa, um aviso é emitido e o cadastro não é atualizado. O usuário pode optar por substituir o responsável atual ou manter a configuração existente.                        |


