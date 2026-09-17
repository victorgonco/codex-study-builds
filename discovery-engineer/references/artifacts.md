# Artefatos de discovery

Leia esta referência ao criar ou atualizar os artefatos persistentes do discovery.

## `spec.md`

É a fonte da verdade atual, não um diário da conversa. Use somente seções pertinentes:

```markdown
# Spec

## Contexto
## Problema
## Necessidade
## Objetivo
## Solução proposta
## Atores
## Escopo
### Dentro do escopo
### Fora do escopo
## Casos de uso
## Fluxos
### Fluxos principais
### Fluxos alternativos
### Fluxos de exceção
## Regras de negócio
## Requisitos funcionais
## Critérios de aceitação
## Dados envolvidos
## Integrações
## Requisitos não funcionais
## Edge Cases
## Inconsistências
## Hipóteses
## Decisões pendentes
## Sugestão de MVP
## Sugestões do agente
```

Não crie seções vazias. Separe itens confirmados das seguintes classificações:

- **Hipótese:** interpretação provisória ainda não validada.
- **Decisão necessária:** escolha ainda pendente.
- **Fora de escopo:** item conhecido, atualmente não contemplado.
- **Sugestão:** proposta do agente ainda não aceita.

### Identificadores estáveis

Use identificadores quando melhorarem a rastreabilidade:

| Item | Padrão |
|---|---|
| Caso de uso | `UC-001` |
| Regra de negócio | `RN-001` |
| Requisito funcional | `RF-001` |
| Fluxo principal, alternativo, exceção | `FL-001`, `FA-001`, `FE-001` |
| Inconsistência | `INC-001` |
| Hipótese | `H-001` |
| Decisão pendente | `DP-001` |
| Sugestão | `SUG-001` |

Não renumere itens existentes somente para reorganizar o documento.

### Formatos úteis

Caso de uso curto:

```markdown
### UC-001 — Registrar pedido

**Ator:** Operador

**Objetivo:** Registrar um novo pedido.
```

Requisito observável:

```text
RF-003 — O sistema deve permitir que um operador cancele um pedido ainda não processado.
```

Critério BDD, quando apropriado:

```gherkin
Scenario: Cancelar pedido ainda não processado
  Given que existe um pedido com status "Pendente"
  And o operador possui permissão de cancelamento
  When o operador solicitar o cancelamento
  Then o pedido deve assumir o status "Cancelado"
  And não deve seguir para processamento
```

Hipótese:

```markdown
### H-001

Supõe-se temporariamente que todos os operadores pertencem a uma única organização.

**Status:** Não confirmada
```

Sugestão:

```markdown
### SUG-001

**Sugestão:** Manter histórico de cancelamento.

**Motivo:** Facilita a rastreabilidade das operações.

**Pergunta:** Deseja incorporar esse comportamento?
```

Trate a sugestão de MVP como proposta até o usuário validá-la.

## `duvidas.md`

Registre perguntas e respostas que afetem comportamento, regra, escopo, fluxo, requisito, viabilidade arquitetural ou outra decisão relevante. Não registre cada pergunta da conversa e nunca apague uma dúvida resolvida.

```markdown
# Dúvidas

## D-001 — Pergunta

**Motivo:**  
Por que essa definição era necessária.

**Resposta do usuário:**  
Resposta recebida.

**Impacto:**  
Requisitos, regras ou fluxos afetados.

**Status:** Resolvida
```

## `changelog.md`

Registre apenas mudanças semânticas relevantes. Não registre ortografia, formatação, pequenas reescritas ou reorganização visual sem mudança de significado.

```markdown
# Changelog

## v0.1

- contexto inicial estruturado;
- UC-001 criado;
- RN-001 criada.

## v0.2

- D-003 respondida;
- RN-002 alterada;
- FA-001 criado;
- H-001 confirmada.
```
