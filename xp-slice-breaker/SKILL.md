---
name: xp-slice-breaker
description: Divida uma User Story madura em slices verticais pequenos, incrementais, implementáveis e verificáveis segundo princípios de Extreme Programming. Use quando uma história estiver grande para implementação direta ou precisar de incrementos adequados a TDD; não use para descobrir requisitos, alterar escopo, definir arquitetura, implementar código ou decompor trabalho por camadas técnicas.
---

# XP Slice Breaker

Transforme uma User Story pronta para implementação em uma sequência de incrementos coerentes de comportamento. A história continua sendo a referência funcional; os slices não criam requisitos novos.

## Entradas e autoridade

Antes de gerar slices, identifique:

1. a User Story alvo;
2. sua especificação de origem, quando disponível;
3. a pasta de saída indicada pelo usuário.

Se a pasta de saída não foi informada, pergunte antes de criar arquivos. Não escolha um diretório silenciosamente. Crie a pasta quando necessário e grave os artefatos somente nela, salvo orientação explícita em contrário.

Leia integralmente a User Story. Consulte `MVPs.md` para preservar o marco executável ao qual ela pertence e consulte `spec.md`, `specs/**/*.md`, `duvidas.md`, `changelog.md`, `handoff.md` e `backlog.md` quando forem necessários para interpretá-la. A autoridade funcional é: **especificação atual → User Story → slices**. `MVPs.md` orienta limite e ordem de entrega; o backlog não cria comportamento. Se a história contradiz a especificação, registre o problema antes de criar slices e não resolva a inconsistência por conta própria.

Considere como diretório de controle aquele que contém `spec.md`, salvo indicação explícita do usuário. Mantenha nele o repasse e o backlog, mesmo que os slices sejam gravados em outra pasta.

## Impacto no workflow

Esta skill consome as histórias e o plano de MVPs produzidos pelo `story-breakdown`. Seus slices formam o contrato imediato do `tdd-implementer`: devem permitir implementação em passos pequenos sem perder o resultado executável prometido pelo MVP.

Não altere regras do discovery nem implemente código. Ao concluir, deixe no repasse o primeiro slice `Ready` para TDD ou encaminhe a lacuna à skill responsável.

## Princípio central

Quebre comportamento, não estrutura técnica. Cada slice deve atravessar as camadas necessárias para entregar um resultado observável. Não crie slices para endpoint, controller, service, repository, tabela, DTO ou teste técnico isolado.

Um slice deve ser o menor incremento vertical que possa ser implementado, testado e validado sem exigir a conclusão da história inteira. Procure um único objetivo, critérios claros, coerência funcional e um estado válido do sistema após sua conclusão.

## Aplicar a mentalidade XP

- **Small Steps:** prefira incrementos pequenos e não implemente comportamentos futuros antecipadamente.
- **Simple Design:** faça somente o necessário para o slice atual; evite abstrações e extensibilidade especulativas.
- **Fast Feedback:** ordene os primeiros slices para validar comportamento e reduzir incerteza cedo.
- **Working Software:** cada slice concluído deve deixar o sistema funcionando.
- **Incremental Development:** faça a história emergir progressivamente, começando pelo menor caminho útil.

Quando a história atravessar várias partes significativas, considere um walking skeleton: um fluxo mínimo real ponta a ponta que valide a integração essencial sem lógica complexa prematura. Não use código descartável como atalho.

## Mapear e fatiar

Antes de decompor, mapeie objetivo, ator, caminho feliz, regras de negócio, estados, alternativas, exceções, integrações, critérios de aceitação, dependências e edge cases.

Procure dimensões naturais de fatiamento:

- menor caminho feliz antes das expansões;
- regras adicionadas individualmente ou em grupos coerentes;
- dados mínimos antes de campos opcionais, tipos e formatos adicionais;
- comportamentos por estado;
- atores ou permissões com diferenças significativas;
- comportamento local antes da integração externa, somente quando tiver valor isolado;
- exceções com fluxo ou tratamento substancial próprio;
- edge cases após o fluxo principal, salvo quando representam risco fundamental.

Agrupe exceções simples com o comportamento principal. Separe-as quando possuírem regras, fluxo ou valor observável independente.

Um slice está grande demais quando possui vários objetivos, cenários complexos, regras independentes ou caminhos alternativos relevantes. Está pequeno demais quando representa somente uma classe, camada ou plumbing técnico, ou quando não tem valor sem outro slice.

## Ordenar a implementação

Ordene os slices considerando:

1. menor fluxo funcional ponta a ponta;
2. maior redução de incerteza;
3. regras centrais;
4. dependências funcionais necessárias;
5. fluxos alternativos;
6. integrações secundárias;
7. exceções e edge cases.

Quando duas ordens forem equivalentes, prefira a que produz software utilizável mais cedo. Registre apenas dependências funcionais reais e evite sequências artificiais por camada técnica.

## Preparar para TDD

Cada slice deve informar comportamento esperado, critérios de aceitação, regras envolvidas e limites de escopo. Isso deve permitir ciclos RED → GREEN → REFACTOR sem prescrever a estrutura do código.

Indique também o MVP ao qual o slice contribui e preserve uma sequência em que o sistema permaneça executável e testável após cada incremento. O último slice necessário de um MVP deve tornar possível validar o resultado executável descrito em `MVPs.md`.

Não determine testes unitários específicos, mocks, fixtures, classes ou frameworks. Descreva comportamento verificável; o implementador decide como testá-lo.

## Tratar lacunas

Não altere a User Story para facilitar o slicing. Classifique os problemas encontrados:

- **Discovery Gap:** falta definição funcional ou de negócio; devolver ao discovery.
- **Story Gap:** a definição existe na especificação, mas não foi incorporada corretamente à história; devolver ao story breakdown.
- **Slice Issue:** o problema está somente na decomposição; corrija nesta skill.

Para lacunas externas, registre um bloqueio com identificador `BLQ-001`, origem, problema, impacto e pergunta objetiva. Marque slices afetados como `Blocked` e nunca invente uma resposta.

## Criar os artefatos

Leia [references/slice-files.md](references/slice-files.md) antes de criar ou atualizar arquivos. É obrigatório gerar um arquivo Markdown para cada slice e um `README.md` como índice ordenado.

Use identificadores estáveis `SLICE-001`, `SLICE-002` e assim por diante. Não renumere slices existentes sem necessidade; ao adicionar novos, continue a sequência. Preserve nomes de arquivos quando o slice for apenas atualizado.

Use estes status:

- `Ready`: possui objetivo único, comportamento e critérios verificáveis, origem rastreável, escopo delimitado e dependências claras.
- `Blocked`: existe uma decisão funcional ou dependência externa pendente.
- `Implemented`: somente com evidência de que o comportamento foi implementado.

## Validar cobertura

Antes de concluir, confirme que toda a User Story está coberta; caminho feliz, regras, alternativas, exceções e edge cases relevantes estão distribuídos; nenhum slice representa apenas camada técnica; nenhum comportamento novo foi inventado; todos têm critérios verificáveis; dependências são reais; e a sequência permite evolução incremental.

Atualize `handoff.md` no diretório de controle com o ponto de parada, bloqueios e o próximo slice `Ready` para o `tdd-implementer`. Não promova itens do backlog a slices; devolva-os ao discovery quando o usuário decidir trazê-los para o escopo atual.

## Responder ao usuário

Informe somente:

- User Story processada;
- quantidade e ordem sugerida dos slices;
- bloqueios, classificados como Discovery Gap ou Story Gap;
- pasta e arquivos criados ou alterados;
- próximo repasse para o `tdd-implementer`.

Não reproduza na conversa o conteúdo completo dos slices já gravados.
