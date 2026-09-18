---
name: story-breakdown
description: Decomponha uma especificação madura de software em MVPs executáveis e histórias pequenas, rastreáveis, ordenáveis e prontas para implementação. Use para planejar entregas incrementais ou reorganizar histórias existentes; não use para descobrir requisitos, alterar regras de negócio, escolher arquitetura ou implementar código.
---

# Story Breakdown

Transforme a especificação existente em histórias implementáveis. A especificação continua sendo a fonte da verdade; as histórias são uma decomposição dela, não uma nova especificação.

## Pré-condições e fontes

Antes de gerar arquivos, obtenha:

1. o caminho da especificação;
2. a pasta de saída indicada pelo usuário.

Se a pasta não foi informada, pergunte antes de criar arquivos. Não escolha um diretório silenciosamente. Crie a pasta indicada quando ela ainda não existir e grave todos os artefatos do breakdown exclusivamente nela, salvo orientação explícita em contrário.

Leia integralmente `spec.md` e, quando existirem, `specs/**/*.md`, `duvidas.md`, `changelog.md`, `handoff.md` e `backlog.md`. Use a especificação atual como fonte de requisitos; use dúvidas e changelog apenas para entender decisões e mudanças. O repasse orienta a retomada operacional. O backlog antecipa possíveis evoluções, mas não autoriza histórias nem critérios. Em caso de conflito, a especificação atual prevalece sobre o histórico.

Se a especificação não estiver madura, registre as lacunas como bloqueios e encaminhe-as de volta ao discovery. Não invente requisitos nem decida comportamentos para tornar uma história implementável.

Considere como diretório de controle aquele que contém `spec.md`, salvo indicação explícita do usuário. É nele que `handoff.md` e `backlog.md` devem ser lidos e atualizados, mesmo quando a pasta de histórias estiver em outro local.

## Impacto no workflow

Esta skill consome os artefatos do `discovery-engineer` e produz o plano funcional de entrega usado pelo `xp-slice-breaker`. Cada história deve manter referências para a especificação, e cada MVP deve agrupar histórias em um incremento que, depois de implementado pelo `tdd-implementer`, resulte em uma aplicação executável e testável.

Não implemente código nem prescreva slices. Ao concluir, deixe no repasse qual história `Ready` deve seguir para o `xp-slice-breaker`, ou qual lacuna deve retornar ao discovery.

## Mapear antes de decompor

Leia o conjunto completo antes de criar histórias. Mapeie problema, objetivo, atores, casos de uso, fluxos, regras, requisitos funcionais, critérios de aceitação, integrações, requisitos não funcionais, edge cases, MVPs, dependências e decisões pendentes.

Siga: **ler → mapear → decompor → validar → ordenar → gravar**.

## Decompor por comportamento

Prefira cortes verticais que entreguem comportamento observável ou capacidade utilizável. Uma história deve ser o menor comportamento coerente que possa ser implementado, validado e compreendido isoladamente sem perder valor funcional.

Não crie histórias separadas para tabela, repository, service, controller, DTO ou endpoint apenas porque essas camadas existem. Tais atividades podem virar tarefas técnicas internas de uma história.

Use INVEST como heurística: minimize dependências, preserve negociação, entregue valor, mantenha escopo estimável e pequeno e forneça critérios verificáveis. Não distorça o domínio apenas para satisfazer a heurística.

Quebre uma história quando houver vários objetivos independentes, atores com objetivos diferentes, fluxos grandes, conjuntos independentes de regras, integrações separáveis ou critérios excessivamente amplos. Evite micro-histórias sem valor comportamental.

Use a hierarquia `Epic → Capability → Story` somente quando o tamanho do projeto justificar. Projetos pequenos podem conter apenas histórias. Use identificadores estáveis `EP-001`, `CAP-001` e `US-001`; não reutilize identificadores removidos nem renumere itens existentes apenas para reorganização.

## Preservar rastreabilidade e significado

Toda história deve apontar para sua origem, como `UC-001`, `RF-003` e `RN-002`. Uma história sem origem identificável é suspeita: verifique se ela introduz requisito novo antes de mantê-la.

Reutilize ou reorganize critérios de aceitação sem alterar seu significado. Converta-os para Given/When/Then quando isso melhorar a verificabilidade. Evite detalhes de classe, método, framework, tabela ou implementação, exceto quando forem requisitos ou contratos explícitos da especificação.

Mantenha exceções na mesma história quando fizerem parte natural do comportamento. Separe-as quando possuírem fluxo, regras, valor ou implementação substancialmente independentes.

Não transforme automaticamente integrações ou requisitos não funcionais em histórias isoladas. Uma integração deve preferencialmente compor o comportamento completo. Um requisito não funcional pode ser critério transversal, história técnica ou restrição global, conforme a especificação.

Histórias técnicas são válidas para trabalho necessário sem ação direta do usuário, como migração, infraestrutura obrigatória, auditoria ou observabilidade. Marque-as explicitamente como `Tipo: História técnica`. Não as use para representar camadas da aplicação.

## Dependências, MVPs executáveis e bloqueios

Registre dependências funcionais reais entre histórias. Se duas histórias estiverem excessivamente acopladas, reavalie se deveriam ser uma só ou se o acoplamento surgiu de decomposição técnica.

Transforme o MVP confirmado no menor marco coerente que possa resultar em software executável e testável, sem confundir planejamento com implementação. Um MVP deve:

- validar uma hipótese, necessidade ou fluxo central explícito na especificação;
- agrupar o menor conjunto ordenado de histórias necessário para um resultado utilizável;
- declarar o estado observável da aplicação ao final;
- indicar como o resultado poderá ser executado e validado em termos de comportamento, sem escolher arquitetura ausente;
- possuir critérios de conclusão verificáveis.

Quando a evolução pedir mais de um marco, numere-os como `MVP-001`, `MVP-002` e assim por diante. O primeiro deve preservar a ideia central no menor fluxo real possível; os seguintes devem produzir novos estados executáveis, não apenas pacotes de trabalho técnico. Uma história pode pertencer a um único MVP principal; registre dependências entre MVPs quando existirem.

Se houver apenas uma sugestão de MVP no discovery, preserve a incerteza e marque o marco como `Needs Validation`. Não inclua uma intenção de `backlog.md` em um MVP até ela ser refinada e incorporada à especificação.

Quando faltar informação necessária:

1. identifique a lacuna;
2. indique as histórias afetadas;
3. registre um bloqueio com identificador `BLQ-001`;
4. formule uma pergunta objetiva;
5. defina o status como `Blocked` ou `Needs Refinement`, conforme o caso.

Nunca escolha silenciosamente uma resposta.

## Gerar os artefatos

Leia [references/story-files.md](references/story-files.md) antes de criar ou atualizar arquivos. É obrigatório gerar um arquivo `.md` por história, um `README.md` como índice e um `MVPs.md` com os marcos executáveis. Preserve nomes e identificadores estáveis ao atualizar artefatos existentes.

Para histórias, use apenas estes status:

- `Ready`: informação suficiente para implementação.
- `Blocked`: uma decisão externa impede o avanço.
- `Needs Refinement`: o comportamento ainda não está suficientemente definido.
- `Implemented`: somente com evidência de implementação existente.

Não associe automaticamente histórias a sprints e não estime esforço ou duração sem solicitação explícita.

## Ordenar e validar cobertura

Sugira uma ordem de implementação considerando dependências funcionais, capacidades fundamentais, fluxo principal, feedback antecipado, MVPs, integrações, fluxos alternativos e edge cases.

Antes de concluir, confira que casos de uso, requisitos funcionais, regras relevantes, critérios, MVPs, integrações e edge cases possuem cobertura; cada MVP termina em um resultado executável e testável; nenhuma história introduz comportamento novo; bloqueios registram lacunas restantes; cada história possui objetivo, origem e critérios verificáveis; e os índices correspondem aos arquivos existentes. Registre explicitamente qualquer requisito sem história correspondente.

Atualize `handoff.md` no diretório de controle com um checklist curto: breakdown concluído, ponto de parada, bloqueios ativos e próxima história `Ready` a ser processada pelo `xp-slice-breaker`. Preserve `backlog.md`; só marque um item quando houver evidência de que ele foi incorporado à especificação.

## Responder ao usuário

Informe somente um resumo com:

- quantidade de epics, capabilities, histórias, histórias técnicas, MVPs e bloqueios;
- requisitos ou casos de uso sem cobertura;
- decisões que precisam voltar ao discovery;
- pasta usada e arquivos criados ou atualizados;
- próximo repasse para o `xp-slice-breaker`.

Não reproduza na conversa o conteúdo completo das histórias já gravadas.
