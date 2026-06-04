# Handoff

## Modo Atual

Modo de Arquitetura

## O Que Foi Feito

- Foi definido o desenho técnico mínimo da solução em arquitetura hexagonal para a primeira entrega do app CLI de tarefas.
- Foram explicitados os conceitos de domínio centrais, os casos de uso de criação e leitura e as portas de entrada e saída.
- Foram definidos os adaptadores primários de CLI e o adaptador secundário de persistência em arquivo Markdown único.
- Foram registradas estratégias de validação, persistência, tratamento de erros e os principais riscos da implementação.

## Decisões Tomadas

- A tarefa terá identificador gerado e estável, além de título e descrição.
- A leitura de tarefa será feita por identificador, não por título.
- Todas as tarefas continuarão em um único arquivo Markdown, tratado como fonte única de verdade nesta etapa.
- O repositório de persistência será responsável por criar pasta e arquivo base quando necessário.
- O arquivo Markdown será regravado integralmente a cada criação nesta primeira entrega, mantendo a solução simples.
- A descrição pode ser vazia nesta etapa, desde que seja persistida e exibida de forma previsível.

## Arquivos Atualizados

- `docs/ai-workflow/03-architecture.md`
- `docs/ai-workflow/06-handoff.md`

## Contexto Relevante Para o Próximo Modo

- A implementação deve preservar o isolamento entre domínio, casos de uso, adaptadores de CLI e persistência em arquivo.
- O próximo modo deve materializar as portas e adaptadores sem expandir o escopo para edição, exclusão, subtarefas ou múltiplos arquivos de tarefa.
- A persistência deve usar um formato Markdown simples e parseável que inclua identificador, título e descrição de cada tarefa.
- A abordagem escolhida permite testes futuros sem depender diretamente de terminal real ou sistema de arquivos real no nível unitário.

## Não Alterar

- Não expandir o escopo além de criação e leitura básica.
- Não remover a decisão de arquitetura hexagonal.
- Não trocar o armazenamento em arquivo Markdown único por banco de dados, memória ou múltiplos arquivos por tarefa.
- Não avançar automaticamente para implementação sem solicitação explícita do usuário.

## Pendências

- Detalhar no próximo modo a estrutura concreta de pacotes e classes compatível com esta arquitetura.
- Definir o formato exato dos comandos CLI na implementação, respeitando a leitura por identificador.
- Definir o formato Markdown final de serialização sem quebrar as decisões registradas neste modo.

## Próxima Ação Recomendada

Executar Modo de Implementação.
