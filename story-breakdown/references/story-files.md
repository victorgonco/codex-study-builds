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

Sim

## Observações

Informações relevantes já presentes na especificação.
```

Não use `Observações` para adicionar comportamento novo. Para história técnica, acrescente:

```text
Tipo: História técnica
```

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

## Índice `README.md`

Crie ou atualize o índice na mesma pasta. Ele não substitui os arquivos individuais.

```markdown
# Implementation Stories

| ID | História | Dependências | MVP | Status |
|---|---|---|---|---|
| US-001 | Registrar pedido | — | Sim | Ready |
| US-002 | Consultar pedido | US-001 | Sim | Ready |
| US-003 | Cancelar pedido | US-001 | Sim | Blocked |
```

O índice deve representar todos os arquivos atuais e preservar a ordem de implementação sugerida. Ao atualizar histórias existentes, não apague itens ou troque status sem evidência na especificação ou na implementação.

## Verificação final

Confirme antes de concluir:

- a especificação inteira foi lida;
- a pasta foi explicitamente indicada pelo usuário;
- cada história ocupa seu próprio arquivo;
- a decomposição segue comportamento, não camadas técnicas;
- cada história possui um objetivo claro, origem e critérios verificáveis;
- histórias grandes foram divididas e micro-histórias desnecessárias foram evitadas;
- todos os critérios importantes e o MVP foram preservados;
- lacunas viraram bloqueios, sem requisitos inventados;
- o `README.md` corresponde aos arquivos existentes;
- a ordem sugerida respeita dependências funcionais reais.
