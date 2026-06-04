# Especificação

## Declaração do Problema

Construir a base inicial de um aplicativo CLI de lista de tarefas em Java 21, capaz de criar e ler tarefas persistidas em um único arquivo Markdown dentro de uma estrutura de pastas.

Nesta primeira etapa, o problema a resolver é permitir que uma pessoa registre tarefas simples, com título e descrição detalhada, e depois consulte as tarefas armazenadas sem depender de banco de dados.

## Usuário / Ator

Pessoa usuária do terminal que deseja organizar tarefas simples em arquivos Markdown locais.

## Objetivos

- Definir a base inicial do aplicativo CLI em Java 21.
- Definir as dependências iniciais necessárias para esta primeira entrega.
- Definir a estrutura base de pastas do projeto e do armazenamento em um único arquivo Markdown inicial.
- Permitir a criação de tarefas com título e descrição.
- Permitir a leitura básica das tarefas armazenadas.
- Manter a implementação compatível com a decisão já tomada de usar arquitetura hexagonal.

## Fora de Escopo

- Editar tarefas existentes.
- Excluir tarefas.
- Criar subtarefas ou qualquer relação entre tarefas.
- Criar dependências entre tarefas.
- Usar banco de dados em memória ou externo.
- Implementar sincronização, autenticação, interface gráfica ou API HTTP.
- Criar funcionalidades além da criação e leitura básica de tarefas.

## Requisitos Funcionais

- O aplicativo deve expor uma interface de linha de comando.
- O aplicativo deve permitir criar uma nova tarefa.
- Ao criar uma tarefa, a pessoa usuária deve informar um título.
- Ao criar uma tarefa, a pessoa usuária deve poder informar uma descrição textual simples.
- O aplicativo deve persistir todas as tarefas criadas inicialmente no mesmo arquivo Markdown.
- O aplicativo deve armazenar esse arquivo Markdown em uma estrutura de pastas local.
- O aplicativo deve permitir ler tarefas já armazenadas.
- A leitura básica deve permitir consultar o conteúdo salvo de uma tarefa.
- As tarefas desta etapa devem conter apenas título e descrição.
- As tarefas criadas nesta etapa não devem ter relação entre si.

## Requisitos Não Funcionais

- O aplicativo deve ser escrito em Java 21.
- O aplicativo deve respeitar a decisão já tomada de arquitetura hexagonal.
- O armazenamento deve usar um único arquivo Markdown inicial e pastas locais.
- O comportamento inicial deve ser simples, previsível e adequado para execução via terminal.
- A solução não deve depender de banco de dados.
- A documentação do workflow deve permanecer em português do Brasil.

## Entradas

- Comando ou ação de CLI para criar tarefa.
- Título da tarefa.
- Descrição da tarefa.
- Comando ou ação de CLI para ler tarefa.
- Identificador, título, posição no arquivo ou outro critério de seleção da tarefa a ser lida, se necessário.

## Saídas

- Arquivo Markdown criado ou atualizado para armazenar as tarefas.
- Confirmação no terminal quando uma tarefa for criada com sucesso.
- Conteúdo de uma tarefa exibido no terminal durante a leitura.
- Mensagem de erro ou orientação quando a leitura não encontrar a tarefa solicitada.

## Regras de Negócio

- Uma tarefa deve representar uma unidade independente de trabalho.
- Uma tarefa deve possuir título.
- Uma tarefa pode possuir descrição simples.
- Todas as tarefas criadas inicialmente devem ser persistidas no mesmo arquivo Markdown.
- Nenhuma tarefa deve depender de outra nesta etapa.
- O aplicativo não deve criar relações, hierarquias ou subtarefas nesta primeira entrega.

## Casos de Borda

- Tentativa de criar tarefa sem título.
- Tentativa de criar tarefa com descrição vazia.
- Tentativa de ler tarefa inexistente.
- Ausência da pasta de armazenamento no primeiro uso.
- Existência de arquivos Markdown inválidos, vazios ou fora do formato esperado.
- Títulos repetidos, caso o título seja usado direta ou indiretamente para identificar tarefas dentro do arquivo.
- Caracteres especiais no título ou na descrição.
- Falha de permissão ou escrita no diretório de armazenamento.

## Suposições

- A aplicação será executada localmente pelo terminal.
- O armazenamento será feito no sistema de arquivos local.
- A descrição da tarefa será texto simples, sem necessidade de campos estruturados adicionais.
- A definição exata do formato Markdown poderá ser detalhada nos próximos modos sem alterar o escopo funcional.
- A definição exata dos comandos da CLI poderá ser detalhada nos próximos modos sem alterar o escopo funcional.

## Perguntas em Aberto

- Qual deve ser o formato exato dos comandos da CLI para criar e ler tarefas?
- Como uma tarefa deve ser identificada para leitura: por título, identificador gerado, nome de arquivo ou listagem?
- Qual deve ser o diretório padrão de armazenamento do arquivo Markdown de tarefas?
- Qual deve ser o formato Markdown mínimo de uma tarefa?
- A descrição deve aceitar múltiplas linhas já nesta primeira entrega?
- Deve existir um comando de listagem de tarefas, ou apenas leitura direta de uma tarefa específica?

## Definição de Pronto

- [x] O problema está claro
- [x] O escopo está explícito
- [x] O fora de escopo está explícito
- [x] Os requisitos são testáveis
- [ ] As perguntas abertas foram respondidas ou convertidas em suposições
