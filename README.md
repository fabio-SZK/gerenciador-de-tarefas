# PROJETO DE SISTEMA DE GERENCIADOR DE TAREFAS PARA EMPRESAS

# CLASSES -

Abstrato Tarefa: FILHAS(TarefaDePlanejamento, TarefaDeExecucao, TarefaDeRevisao)

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



***Requisitos funcionais***

|Identificador| Descrição| Prioridade|
| -------- | -------- | -------- |
|RF01|O sistema deve permitir o cadastro de usuário indicando nome, senha, e-mail e contato.|Alta|
|RF02|O sistema deve permitir aos usuários o login indicando e-mail e senha.|Alta|
|RF03|O sistema deve atribuir um perfil a cada usuário possuindo campos de nome de exibição obrigatório, descrição, contato, equipes e projetos opcionais.|Alta|
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



***Requisitos não funcionais***

|Identificador| Descrição| Tipo|
| -------- | -------- | -------- |
|RNF01|O sistema deve ser desenvolvido utilizando a linguagem de programação Java|Segurança|
|RNF02|O sistema deve funcionar para desktop.|Implementação|
|RNF03|O sistema deve ser desenvolvido utilizando as técnicas de Programação Orientada a Objetos.|Implementação|
|RNF04|O sistema deve criptografar as informações ao salvar os dados.|Segurança|
|RNF05|O sistema deve ter uma interface intuitiva, permitindo que novos usuários completem uma tarefa em menos de 3 minutos.|Facilidade de uso|
|RNF06|O sistema deve ser desenvolvido utilizando a linguagem de programação Java.|Implementação|


