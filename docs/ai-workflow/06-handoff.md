# Handoff

## Modo Atual

Modo de Implementação

## O Que Foi Feito

- Foi criada a base inicial do projeto Java 21 com Maven e JUnit 5.
- Foram escritos testes para criação de tarefa, leitura de tarefa, fluxo básico de CLI e persistência em arquivo Markdown único.
- Foi implementado o domínio `Tarefa`, os casos de uso `CriarTarefa` e `LerTarefa`, as portas de entrada e saída e os adaptadores mínimos de CLI e persistência.
- Foi implementado um repositório em arquivo Markdown único com criação automática de diretório e arquivo quando necessário.
- A suíte de testes foi executada com sucesso ao final da implementação.

## Decisões Tomadas

- O build foi padronizado com Maven e dependência única de teste via JUnit 5.
- A CLI inicial foi mantida sem biblioteca externa, usando argumentos no formato `criar --arquivo=... --titulo=... --descricao=...` e `ler --arquivo=... --id=...`.
- A leitura continua orientada por identificador gerado.
- O armazenamento permanece em um único arquivo Markdown regravado a cada criação.
- A descrição vazia continua permitida e é normalizada para string vazia.
- O repositório Maven local de execução foi direcionado para `.m2` dentro do workspace para permitir os testes neste ambiente.

## Arquivos Atualizados

- `pom.xml`
- `src/main/java/br/com/cafeina/todo/domain/Tarefa.java`
- `src/main/java/br/com/cafeina/todo/domain/exception/ValidacaoException.java`
- `src/main/java/br/com/cafeina/todo/domain/exception/TarefaNaoEncontradaException.java`
- `src/main/java/br/com/cafeina/todo/application/CriarTarefaCommand.java`
- `src/main/java/br/com/cafeina/todo/application/LerTarefaCommand.java`
- `src/main/java/br/com/cafeina/todo/application/CriarTarefaService.java`
- `src/main/java/br/com/cafeina/todo/application/LerTarefaService.java`
- `src/main/java/br/com/cafeina/todo/application/port/in/CriarTarefaUseCase.java`
- `src/main/java/br/com/cafeina/todo/application/port/in/LerTarefaUseCase.java`
- `src/main/java/br/com/cafeina/todo/application/port/out/GeradorDeIdentificador.java`
- `src/main/java/br/com/cafeina/todo/application/port/out/RepositorioDeTarefas.java`
- `src/main/java/br/com/cafeina/todo/application/port/out/SerializadorMarkdownDeTarefas.java`
- `src/main/java/br/com/cafeina/todo/adapter/in/TodoCliApp.java`
- `src/main/java/br/com/cafeina/todo/adapter/out/GeradorDeUuid.java`
- `src/main/java/br/com/cafeina/todo/adapter/out/RepositorioMarkdownEmArquivo.java`
- `src/main/java/br/com/cafeina/todo/adapter/out/SerializadorMarkdownSimples.java`
- `src/test/java/br/com/cafeina/todo/application/CriarTarefaServiceTest.java`
- `src/test/java/br/com/cafeina/todo/application/LerTarefaServiceTest.java`
- `src/test/java/br/com/cafeina/todo/adapter/in/TodoCliAppTest.java`
- `src/test/java/br/com/cafeina/todo/adapter/out/RepositorioMarkdownEmArquivoTest.java`
- `docs/ai-workflow/04-implementation-plan.md`
- `docs/ai-workflow/06-handoff.md`

## Contexto Relevante Para o Próximo Modo

- O comportamento coberto por testes já inclui criação, leitura, validação de título obrigatório e persistência de múltiplas tarefas no mesmo arquivo.
- O formato Markdown implementado é simples e parseável, com blocos por tarefa contendo `id`, `titulo` e `descricao`.
- A suíte validada no ambiente foi `mvn "-Dmaven.repo.local=.m2" test`.
- O teste de persistência precisa permanecer com nome compatível com a suíte padrão, ou a configuração do Maven deverá ser ajustada em etapa futura.

## Não Alterar

- Não expandir o escopo além de criação e leitura básica.
- Não remover a decisão de arquitetura hexagonal.
- Não trocar o armazenamento em arquivo Markdown único por banco de dados, memória ou múltiplos arquivos por tarefa.
- Não refatorar amplamente a CLI, o formato de persistência ou a estrutura de portas sem necessidade validada no próximo modo.

## Pendências

- Verificar aderência do código à especificação, ao plano de testes e à arquitetura definida.
- Avaliar se o tratamento de erros de infraestrutura precisa de cobertura adicional no modo de verificação.
- Revisar se o formato Markdown simples atende bem à evolução futura sem sair do escopo atual.

## Próxima Ação Recomendada

Executar Modo de Verificação/Refatoração.
