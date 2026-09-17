---
name: story-breakdown
description: Decomponha uma especificação madura de software em histórias pequenas, rastreáveis, ordenáveis e prontas para implementação, gravando cada história em um arquivo Markdown separado e mantendo um índice. Use para planejar uma implementação ou reorganizar histórias existentes; não use para descobrir requisitos, alterar regras de negócio, escolher arquitetura ou implementar código.
---

# Story Breakdown

Transforme a especificação existente em histórias implementáveis. A especificação continua sendo a fonte da verdade; as histórias são uma decomposição dela, não uma nova especificação.

## Pré-condições e fontes

Antes de gerar arquivos, obtenha:

1. o caminho da especificação;
2. a pasta de saída indicada pelo usuário.

Se a pasta não foi informada, pergunte antes de criar arquivos. Não escolha um diretório silenciosamente. Crie a pasta indicada quando ela ainda não existir e grave todos os artefatos do breakdown exclusivamente nela, salvo orientação explícita em contrário.

Leia integralmente `spec.md` e, quando existirem, `specs/**/*.md`, `duvidas.md` e `changelog.md`. Use a especificação atual como fonte de requisitos; use dúvidas e changelog apenas para entender decisões e mudanças. Em caso de conflito, a especificação atual prevalece sobre o histórico.

Se a especificação não estiver madura, registre as lacunas como bloqueios e encaminhe-as de volta ao discovery. Não invente requisitos nem decida comportamentos para tornar uma história implementável.

## Mapear antes de decompor

Leia o conjunto completo antes de criar histórias. Mapeie problema, objetivo, atores, casos de uso, fluxos, regras, requisitos funcionais, critérios de aceitação, integrações, requisitos não funcionais, edge cases, MVP, dependências e decisões pendentes.

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

## Dependências, MVP e bloqueios

Registre dependências funcionais reais entre histórias. Se duas histórias estiverem excessivamente acopladas, reavalie se deveriam ser uma só ou se o acoplamento surgiu de decomposição técnica.

Quando houver MVP confirmado, marque cada história com `MVP: Sim` ou `MVP: Não` sem alterar seu escopo. Se houver apenas uma sugestão de MVP, preserve essa incerteza.

Quando faltar informação necessária:

1. identifique a lacuna;
2. indique as histórias afetadas;
3. registre um bloqueio com identificador `BLQ-001`;
4. formule uma pergunta objetiva;
5. defina o status como `Blocked` ou `Needs Refinement`, conforme o caso.

Nunca escolha silenciosamente uma resposta.

## Gerar os artefatos

Leia [references/story-files.md](references/story-files.md) antes de criar ou atualizar arquivos. É obrigatório gerar um arquivo `.md` por história e um `README.md` como índice. Preserve nomes estáveis ao atualizar histórias existentes.

Use apenas estes status:

- `Ready`: informação suficiente para implementação.
- `Blocked`: uma decisão externa impede o avanço.
- `Needs Refinement`: o comportamento ainda não está suficientemente definido.
- `Implemented`: somente com evidência de implementação existente.

Não associe automaticamente histórias a sprints e não estime esforço ou duração sem solicitação explícita.

## Ordenar e validar cobertura

Sugira uma ordem de implementação considerando dependências funcionais, capacidades fundamentais, fluxo principal, feedback antecipado, MVP, integrações, fluxos alternativos e edge cases.

Antes de concluir, confira que casos de uso, requisitos funcionais, regras relevantes, critérios, MVP, integrações e edge cases possuem cobertura; nenhuma história introduz comportamento novo; bloqueios registram lacunas restantes; cada história possui objetivo, origem e critérios verificáveis; e o índice corresponde aos arquivos existentes. Registre explicitamente qualquer requisito sem história correspondente.

## Responder ao usuário

Informe somente um resumo com:

- quantidade de epics, capabilities, histórias, histórias técnicas e bloqueios;
- requisitos ou casos de uso sem cobertura;
- decisões que precisam voltar ao discovery;
- pasta usada e arquivos criados ou atualizados.

Não reproduza na conversa o conteúdo completo das histórias já gravadas.
