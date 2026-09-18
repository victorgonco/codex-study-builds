# Arquivos do breakdown

Use estes formatos ao criar ou atualizar histórias e o índice na pasta indicada pelo usuário.

## Nomes de arquivo

Cada história deve ocupar um arquivo Markdown separado:

```text
US-001-criar-pedido.md
US-002-consultar-pedido.md
US-003-cancelar-pedido.md
```

O nome deve começar pelo identificador, usar título curto em kebab-case e evitar caracteres especiais. Não reutilize nomes de histórias antigas. Mantenha o nome quando uma história existente for apenas atualizada.

## Estrutura de uma história

Inclua somente informações sustentadas pela especificação:

```markdown
# US-001 — Criar pedido

## Objetivo

Permitir que um operador registre um novo pedido válido.

## História

Como operador,
quero registrar um pedido,
para que ele possa entrar no fluxo de processamento.

## Origem

- UC-001
- RF-001
- RN-001
- RN-003

## Escopo

Inclui:

- preenchimento dos dados obrigatórios;
- validação das regras aplicáveis;
- criação do pedido.

Não inclui:

- processamento;
- cancelamento;
- edição posterior.

## Regras relacionadas

- RN-001
- RN-003

## Critérios de aceitação

### AC-001 — Pedido válido

Given que o operador possui permissão
And informa todos os dados obrigatórios
When solicita o registro
Then o pedido deve ser criado.

### AC-002 — Dados obrigatórios ausentes

Given que existem dados obrigatórios não informados
When o operador solicita o registro
Then o pedido não deve ser criado
And o problema deve ser informado.

## Dependências

Nenhuma.

## Status

Ready

## MVP

MVP-001

## Observações

Informações relevantes já presentes na especificação.
```

Não use `Observações` para adicionar comportamento novo. Para história técnica, acrescente:

```text
Tipo: História técnica
```

Em `MVP`, use o identificador do marco principal ao qual a história pertence. Use `Não planejado` quando uma história sustentada pela especificação ainda não fizer parte de nenhum MVP atual; não use `Sim` ou `Não`, pois isso perde a rastreabilidade entre a história e o marco.

## Bloqueios

Registre o bloqueio na história afetada. Use um arquivo auxiliar dentro da pasta de saída somente quando a mesma lacuna afetar várias histórias.

```markdown
## Bloqueio

### BLQ-001 — Comportamento de cancelamento indefinido

**Problema:**  
A especificação permite cancelamento, mas não define o comportamento para pedidos já processados.

**Histórias afetadas:**  
US-003, US-006.

**Pergunta:**  
Pedidos processados podem ser cancelados?
```

Use `Status: Blocked` quando uma decisão externa impede o avanço. Use `Needs Refinement` quando a especificação ainda não permite compreender suficientemente o comportamento.

## Plano `MVPs.md`

Crie este arquivo na pasta das histórias. Ele descreve marcos funcionais de entrega, não versões comerciais nem fases técnicas.

```markdown
# MVPs

## MVP-001 — Registrar o primeiro pedido

**Objetivo de validação:** Confirmar que um operador consegue colocar um pedido válido no fluxo.

**Resultado executável:** Aplicação inicia e permite registrar e consultar um pedido com os dados mínimos.

**Histórias, na ordem:**

1. US-001 — Registrar pedido
2. US-002 — Consultar pedido

**Como validar:**

- executar a aplicação pelo procedimento documentado no projeto;
- registrar um pedido válido;
- consultar o pedido criado;
- executar os testes automatizados relacionados.

**Critérios de conclusão:**

- comportamento das histórias do marco implementado;
- aplicação executável no ambiente suportado pelo projeto;
- testes dos fluxos do marco verdes;
- nenhum bloqueio aberto nas histórias que compõem o marco.

**Dependências:** Nenhuma.

**Status:** Ready
```

Use `Needs Validation` quando o MVP ainda for apenas uma sugestão do discovery, `Ready` quando escopo e validação estiverem claros, `Blocked` quando uma decisão impedir o marco e `Implemented` somente com evidência do código e dos testes. Não invente comandos de execução que a especificação ou o projeto não sustentem; descreva a validação comportamental e deixe o comando como pendência quando necessário.

Em MVPs posteriores, explicite o novo resultado executável em relação ao marco anterior. Não use MVPs para agrupar apenas banco, API, interface ou infraestrutura sem comportamento utilizável.

## Índice `README.md`

Crie ou atualize o índice na mesma pasta. Ele não substitui os arquivos individuais.

```markdown
# Implementation Stories

| ID | História | Dependências | MVP | Status |
|---|---|---|---|---|
| US-001 | Registrar pedido | — | MVP-001 | Ready |
| US-002 | Consultar pedido | US-001 | MVP-001 | Ready |
| US-003 | Cancelar pedido | US-001 | MVP-002 | Blocked |
```

O índice deve representar todos os arquivos atuais e preservar a ordem de implementação sugerida. Ao atualizar histórias existentes, não apague itens ou troque status sem evidência na especificação ou na implementação.

## Controle externo

Atualize `handoff.md` no diretório que contém `spec.md`, usando uma lista curta de checkboxes:

```markdown
# Repasse

- [x] MVP-001 decomposto em histórias.
- [ ] Aguardando: criar os slices de US-001.
- [ ] Próximo passo: executar `xp-slice-breaker` para US-001.
```

Leia `backlog.md` para conhecer a direção futura, mas não gere histórias a partir dele. Preserve seu formato como uma lista simples de frases `- [ ] ...`; um item só pode ser marcado depois de incorporado à especificação.

## Verificação final

Confirme antes de concluir:

- a especificação inteira foi lida;
- a pasta foi explicitamente indicada pelo usuário;
- cada história ocupa seu próprio arquivo;
- a decomposição segue comportamento, não camadas técnicas;
- cada história possui um objetivo claro, origem e critérios verificáveis;
- histórias grandes foram divididas e micro-histórias desnecessárias foram evitadas;
- todos os critérios importantes e os MVPs foram preservados;
- cada MVP possui resultado executável, validação e critérios de conclusão;
- lacunas viraram bloqueios, sem requisitos inventados;
- `README.md` e `MVPs.md` correspondem aos arquivos existentes;
- a ordem sugerida respeita dependências funcionais reais.
- o repasse aponta a próxima história pronta ou um bloqueio explícito.
