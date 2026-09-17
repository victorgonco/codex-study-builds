# Arquivos de slices

Use estes formatos ao criar ou atualizar slices na pasta indicada pelo usuário.

## Um slice por arquivo

Cada slice deve ocupar um arquivo Markdown separado. Use o padrão `SLICE-XXX-titulo-curto.md`, começando pelo identificador, com título curto em kebab-case e sem caracteres especiais.

```text
slices/US-003/
├── README.md
├── SLICE-001-cancelar-pedido-pendente.md
├── SLICE-002-impedir-cancelamento-duplicado.md
└── SLICE-003-validar-permissao.md
```

Não reutilize identificadores removidos. Preserve nomes existentes quando o slice for apenas atualizado.

## Estrutura de um slice

Inclua somente comportamento sustentado pela User Story ou por sua especificação de origem:

```markdown
# SLICE-001 — Cancelar pedido pendente

## Objetivo

Permitir o cancelamento de um pedido que ainda esteja pendente.

## História de origem

US-003 — Cancelar pedido

## Origem

- RF-007
- RN-004
- AC-001

## Comportamento

Dado um pedido pendente,
quando um operador autorizado solicitar seu cancelamento,
o pedido deve passar para o estado Cancelado.

## Critérios de aceitação

### AC-001 — Cancelamento válido

Given que existe um pedido com status "Pendente"
And o operador possui permissão para cancelar
When o cancelamento for solicitado
Then o pedido deve assumir o status "Cancelado"

## Inclui

- cancelamento de pedido pendente;
- alteração do estado;
- comportamento necessário para concluir esse cenário.

## Não inclui

- cancelamento de pedido já processado;
- controle avançado de permissões;
- motivo do cancelamento;
- integração com sistemas externos.

## Dependências

Nenhuma.

## Habilita

- SLICE-002
- SLICE-004

## Status

Ready
```

A seção `Não inclui` delimita o incremento e evita antecipar comportamentos de slices seguintes. Use `Habilita` somente quando houver uma relação clara. Dependências devem refletir comportamento, não a ordem técnica de alteração do código.

## Bloqueios

Registre bloqueios nos slices afetados ou em um arquivo auxiliar na pasta de saída quando uma lacuna afetar vários slices.

```markdown
## BLQ-001 — Regra de cancelamento indefinida

**Origem:** US-003

**Classificação:** Discovery Gap

**Problema:**  
A história não define se pedidos já processados podem ser cancelados.

**Impacto:**  
Não é possível definir o comportamento pós-processamento.

**Pergunta:**  
Pedidos processados podem ser cancelados?
```

Não invente a resposta. Marque o slice afetado como `Blocked`.

## Índice `README.md`

Crie ou atualize o índice na mesma pasta. A ordem deve representar a sequência sugerida de implementação.

```markdown
# US-003 — Slices

| Ordem | ID | Slice | Dependências | Status |
|---:|---|---|---|---|
| 1 | SLICE-001 | Cancelar pedido pendente | — | Ready |
| 2 | SLICE-002 | Impedir cancelamento duplicado | SLICE-001 | Ready |
| 3 | SLICE-003 | Validar permissão | SLICE-001 | Ready |
```

O índice não substitui os arquivos individuais. Não remova slices nem marque `Implemented` sem evidência.

## Verificação final

Antes de concluir, confirme:

- a User Story foi lida integralmente e a especificação foi consultada quando necessário;
- a pasta de saída foi indicada pelo usuário;
- existe um menor fluxo ponta a ponta;
- cada slice possui objetivo único, comportamento observável, critérios e origem;
- nenhum slice invade o escopo de outro ou representa apenas plumbing técnico;
- granularidade e dependências são adequadas;
- todos os comportamentos da história estão cobertos sem requisitos novos;
- lacunas foram classificadas e registradas como bloqueios;
- cada slice possui seu arquivo e o `README.md` representa a ordem atual.
