# Handoff

## Modo Atual

Modo de Especificação

## O Que Foi Feito

- A tarefa atual foi lida a partir de `docs/ai-workflow/00-current-task.md`.
- A demanda foi transformada em uma especificação inicial clara, limitada e testável.
- O escopo foi restringido à base inicial do app CLI, criação de tarefas e leitura básica.
- A nova restrição de manter todas as tarefas criadas inicialmente no mesmo arquivo Markdown foi explicitada.
- Foram registrados requisitos, entradas, saídas, regras de negócio, casos de borda, suposições e perguntas em aberto.

## Decisões Tomadas

- A primeira entrega deve cobrir apenas criação e leitura básica de tarefas.
- Cada tarefa deve ter título e pode ter descrição simples.
- As tarefas não terão relações entre si nesta etapa.
- O armazenamento inicial deve manter todas as tarefas criadas no mesmo arquivo Markdown.
- O arquivo Markdown de tarefas deve ficar em uma estrutura de pastas local.
- Java 21 e arquitetura hexagonal permanecem como decisões já tomadas pela tarefa atual.
- Banco de dados em memória ou externo permanece fora de escopo.

## Arquivos Atualizados

- `docs/ai-workflow/01-spec.md`
- `docs/ai-workflow/06-handoff.md`

## Contexto Relevante Para o Próximo Modo

- A próxima etapa deve transformar a especificação em critérios de aceite e estratégia de testes, sem implementar código ainda.
- Ainda existem perguntas em aberto sobre comandos da CLI, identificação das tarefas dentro do arquivo Markdown, diretório de armazenamento, formato Markdown e necessidade de listagem.
- As perguntas em aberto devem ser respondidas ou convertidas em suposições antes da implementação.

## Não Alterar

- Não escrever código neste momento.
- Não criar testes neste momento.
- Não avançar automaticamente para o próximo modo.
- Não expandir o escopo para edição, exclusão, subtarefas, relações entre tarefas, banco de dados, API HTTP ou interface gráfica.
- Não alterar arquivos fora do workflow permitido para este modo.

## Pendências

- Responder ou converter em suposições as perguntas em aberto registradas em `docs/ai-workflow/01-spec.md`.
- Detalhar critérios de aceite e testes no Modo de Produto/Testes.

## Próxima Ação Recomendada

Executar Modo de Produto/Testes.
