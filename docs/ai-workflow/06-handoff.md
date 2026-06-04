# Handoff

## Modo Atual

Modo de Produto/Testes

## O Que Foi Feito

- A especificação foi transformada em história de usuário, critérios de aceite, cenários BDD e plano de testes.
- Foram definidos critérios verificáveis para criação e leitura básica de tarefas pelo CLI.
- Foram definidos cenários para caminho feliz, erro de validação e persistência de múltiplas tarefas no mesmo arquivo Markdown.
- Foram listados testes unitários, de integração, de contrato, negativos e dados de teste.

## Decisões Tomadas

- A primeira entrega deve cobrir apenas criação e leitura básica de tarefas.
- Cada tarefa deve ter título e pode ter descrição simples.
- As tarefas não terão relações entre si nesta etapa.
- O armazenamento inicial deve manter todas as tarefas criadas no mesmo arquivo Markdown.
- O arquivo Markdown de tarefas deve ficar em uma estrutura de pastas local.
- Java 21 e arquitetura hexagonal permanecem como decisões já tomadas pela tarefa atual.
- Banco de dados em memória ou externo permanece fora de escopo.
- Os testes devem priorizar comportamento observável e regras de produto.
- Testes unitários devem evitar dependência direta de terminal real ou sistema de arquivos real.
- Testes de integração devem validar o uso de arquivos e pastas locais em ambiente temporário controlado.

## Arquivos Atualizados

- `docs/ai-workflow/02-product-and-tests.md`
- `docs/ai-workflow/06-handoff.md`

## Contexto Relevante Para o Próximo Modo

- A próxima etapa deve definir arquitetura sem implementar código.
- A arquitetura deve preservar a decisão de Java 21, CLI, arquitetura hexagonal e armazenamento inicial em um único arquivo Markdown.
- Ainda é necessário definir o contrato exato dos comandos da CLI, o formato Markdown mínimo, o diretório padrão de armazenamento e a forma de identificar tarefas para leitura.
- A definição de arquitetura deve viabilizar testes unitários sem terminal real ou sistema de arquivos real e testes de integração com diretório temporário.

## Não Alterar

- Não implementar código neste momento.
- Não criar arquivos de teste neste momento.
- Não avançar automaticamente para o próximo modo.
- Não expandir o escopo para edição, exclusão, subtarefas, relações entre tarefas, banco de dados, API HTTP ou interface gráfica.
- Não alterar arquivos fora do workflow permitido para este modo.

## Pendências

- Definir o formato exato dos comandos da CLI.
- Definir como uma tarefa será identificada para leitura.
- Definir o diretório padrão de armazenamento.
- Definir o formato Markdown mínimo para uma tarefa.
- Definir se descrição vazia é aceita ou rejeitada.
- Definir se haverá comando de listagem nesta primeira entrega.

## Próxima Ação Recomendada

Executar Modo de Arquitetura.
