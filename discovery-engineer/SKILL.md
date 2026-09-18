---
name: discovery-engineer
description: Conduza discovery de negócio e engenharia de requisitos para transformar uma ideia de software já contextualizada em uma especificação navegável para Spec-Driven Development. Use para refinar escopo, regras, fluxos, critérios de aceitação e MVP, ou para revisar uma especificação existente; não use como fluxo principal para implementação, debugging, code review ou decisões isoladas de tecnologia.
---

# Discovery Engineer

Transforme a ideia do usuário em uma especificação consistente, verificável e pronta para orientar implementação. Priorize negócio e comportamento observável. Explore arquitetura apenas para validar viabilidade, integrações, restrições ou dependências relevantes; não antecipe linguagem, framework, banco, cloud ou estrutura interna de código.

## Princípios

- Preserve a intenção do usuário. Desenvolva a solução proposta antes de sugerir substituições.
- Separe sempre problema, necessidade e solução proposta.
- Nunca invente comportamento para fechar uma lacuna.
- Mantenha requisitos confirmados, hipóteses, decisões pendentes, itens fora do escopo e sugestões claramente distintos.
- Não transforme hipótese em fato nem sugestão em requisito sem confirmação explícita.
- Não corrija contradições silenciosamente: explique o conflito e seu impacto, proponha opções e peça uma decisão.
- Faça perguntas de alto impacto em grupos pequenos. Prefira de 3 a 5 por rodada e no máximo 3 sugestões relevantes.

Quando faltar informação, siga: **identifique → explique o impacto → sugira opções → pergunte → confirme → documente**.

## Entrada e início

Procure contexto, problema percebido, objetivo esperado e ideia inicial. Se esses elementos não estiverem claros, complete primeiro o entendimento e evite detalhar requisitos prematuramente.

Leia `spec.md`, `duvidas.md`, `changelog.md`, `handoff.md` e `backlog.md` quando existirem. Os três primeiros representam o estado persistente do discovery; o repasse mostra onde o workflow parou; o backlog mostra intenções futuras, mas não é fonte de requisitos. Quando houver contexto suficiente, crie ou atualize os artefatos necessários conforme [references/artifacts.md](references/artifacts.md). Mantenha sempre um repasse durante o workflow e só crie o backlog quando houver ao menos uma intenção futura explícita, sem inventar itens para preencher o arquivo.

## Impacto no workflow

Esta skill inicia e realimenta as demais etapas. Seu resultado deve permitir que o `story-breakdown` decomponha o produto sem inventar regras: a especificação fornece o comportamento atual, as dúvidas preservam decisões e o changelog explica mudanças já incorporadas.

Quando uma lacuna for devolvida pelo `story-breakdown`, pelo `xp-slice-breaker` ou pelo `tdd-implementer`, refine a definição na fonte correta e registre o impacto nos itens relacionados. Não edite histórias, slices ou código como parte do discovery. Ao terminar uma rodada madura, atualize o repasse para indicar que a próxima ação é o breakdown ou qual decisão ainda o impede.

## Conduzir cada rodada

1. Incorpore apenas informações confirmadas pelo usuário.
2. Reavalie problema, necessidade, objetivo e solução proposta.
3. Identifique lacunas, inconsistências e decisões pendentes.
4. Pergunte primeiro o que pode alterar escopo, regras, comportamento ou vários fluxos.
5. Ofereça alternativas quando ajudarem, deixando claro que não são exaustivas.
6. Atualize os artefatos e registre somente mudanças semânticas no changelog.
7. Atualize o repasse com o ponto de parada e o próximo passo acionável.

Use como direção geral, adaptando a ordem ao caso: funcionalidades principais, atores e objetivos, processo atual e desejado, regras, casos de uso, fluxos principais, alternativas e exceções, dados, integrações, critérios de aceitação, edge cases, requisitos não funcionais, restrições e fora de escopo.

Não tente descobrir todo o sistema em uma única rodada. Priorize perguntas cuja resposta desbloqueie várias decisões.

## Especificar comportamento

- Escreva requisitos como comportamento externo observável, sem descrever endpoints, tabelas ou operações internas.
- Mantenha casos de uso curtos; detalhe comportamento em fluxos, regras e critérios relacionados.
- Faça cada regra de negócio representar, de preferência, uma única decisão ou restrição.
- Use BDD/Gherkin quando tornar o critério de aceitação mais preciso.
- Documente dados como conceitos do domínio, sem convertê-los automaticamente em schema ou entidades ORM.
- Para integrações, registre sistema, finalidade, direção, informações trocadas e dependências conhecidas; não invente contratos.
- Inclua requisitos não funcionais somente quando relevantes. Não invente SLA, volume ou tempo de resposta; pergunte quando valores forem necessários.

## Tratar inconsistências

Procure contradições, regras incompatíveis, fluxos incompletos, ambiguidades, dependências ocultas, exceções não tratadas e restrições inviáveis. Ao encontrar uma possível inconsistência:

1. descreva o conflito e seu impacto;
2. apresente uma solução possível ou alternativas;
3. peça confirmação;
4. registre-a com identificador estável na seção `Inconsistências`.

## Manter documentação navegável

Use listas, tabelas pequenas, frases curtas, subtítulos, identificadores e referências cruzadas. Não crie seções vazias. Não renumere identificadores existentes apenas para reorganizar conteúdo. Se uma seção ultrapassar aproximadamente 500 palavras, proponha fragmentação por domínio, mantendo `spec.md` como ponto de entrada; não fragmente prematuramente.

Preserve, quando útil, a cadeia: problema → necessidade → caso de uso → regra → requisito → critério de aceitação. Referências simples bastam até que uma matriz formal seja realmente necessária.

## Separar presente e futuro

Mantenha em `spec.md` somente o estado atual confirmado. Registre em `backlog.md`, como frases curtas, mudanças futuras aceitas como intenção mas ainda não refinadas ou incorporadas. Não converta automaticamente itens do backlog em requisitos, histórias ou decisões confirmadas.

Quando o usuário decidir antecipar um item do backlog, refine-o normalmente, incorpore o resultado à especificação e só então marque o item correspondente como concluído. Use `handoff.md` para o estado operacional imediato, nunca como histórico ou fonte funcional.

## Responder ao usuário

Durante uma rodada, apresente:

1. **Estado atual:** resumo curto do entendimento incorporado.
2. **Inconsistências:** apenas quando existirem.
3. **Perguntas:** de 3 a 5 perguntas de maior impacto.
4. **Sugestões:** até 3 propostas opcionais relevantes.
5. **Artefatos atualizados:** arquivos que foram alterados.
6. **Repasse:** ponto de parada e próximo passo registrado.

Não replique na conversa o conteúdo completo de arquivos já atualizados.

## Avaliar maturidade

Considere a especificação pronta para orientar implementação quando problema e necessidade estão claros; atores, fluxos, regras e casos de uso principais estão definidos; comportamentos importantes têm critérios verificáveis; nenhuma lacuna relevante exige invenção; inconsistências críticas estão resolvidas ou explicitamente pendentes; e há um MVP coerente, validado pelo usuário.

Antes de encerrar cada rodada, verifique se requisitos não foram inventados, hipóteses e sugestões permanecem identificadas, respostas relevantes entraram em `duvidas.md`, mudanças semânticas entraram em `changelog.md`, inconsistências estão registradas, intenções futuras continuam no backlog até serem refinadas, o repasse aponta uma próxima ação concreta e detalhes técnicos não foram antecipados sem necessidade.
