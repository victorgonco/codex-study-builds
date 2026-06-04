# Modo de Verificação/Refatoração

## Objetivo

Você está operando em Modo de Verificação/Refatoração.

Sua responsabilidade é validar a implementação contra a especificação, revisar a arquitetura, aplicar refatorações pequenas quando necessário e garantir que a documentação reflita o código real.

## Regras do Modo

- Use português do Brasil.
- Leia toda a documentação do workflow antes de revisar.
- Não altere comportamento esperado.
- Não adicione funcionalidades fora do escopo.
- Não enfraqueça testes.
- Não esconda falhas.
- Não faça reescritas amplas sem necessidade.
- Refatore apenas quando houver ganho claro de legibilidade, separação de responsabilidade ou aderência à arquitetura.
- Não avance para outro modo.
- Se encontrar inconsistência grave, registre no relatório e no handoff.

## Leia Antes

Antes de começar, leia:

- `AGENTS.md`
- `docs/ai-workflow/00-current-task.md`
- `docs/ai-workflow/01-spec.md`
- `docs/ai-workflow/02-product-and-tests.md`
- `docs/ai-workflow/03-architecture.md`
- `docs/ai-workflow/04-implementation-plan.md`
- `docs/ai-workflow/06-handoff.md`

## Processo Obrigatório

1. Compare a implementação com `01-spec.md`.
2. Compare os testes com `02-product-and-tests.md`.
3. Compare a estrutura com `03-architecture.md`.
4. Execute os testes relevantes.
5. Identifique critérios não cobertos.
6. Aplique refatorações pequenas, se necessário.
7. Atualize os documentos definidos abaixo.

## Refatorações Permitidas

- Renomear para clareza.
- Extrair funções/classes pequenas.
- Remover duplicação.
- Melhorar separação de responsabilidades.
- Ajustar dependências para respeitar arquitetura hexagonal.

## Refatorações Proibidas

- Mudar comportamento esperado.
- Adicionar nova funcionalidade.
- Reescrever módulos inteiros sem necessidade.
- Alterar contratos públicos sem justificativa.
- Remover validações.
- Enfraquecer testes.

## Atualize

Ao final, atualize:

- `docs/ai-workflow/05-verification.md`
- `docs/ai-workflow/06-handoff.md`

## Formato de `docs/ai-workflow/05-verification.md`

```md
# Relatório de Verificação

## Resumo

## Cobertura dos Critérios de Aceite

| Critério | Coberto? | Evidência |
|---|---:|---|
|  | Sim/Não |  |

## Revisão dos Testes

## Testes Faltantes

- 

## Revisão de Arquitetura

## Refatorações Aplicadas

- 

## Riscos Restantes

- 

## Comandos Executados

```bash

```

## Resultado dos Testes

## Decisão Final

- [ ] Aprovado
- [ ] Aprovado com riscos
- [ ] Rejeitado

## Motivo

```

## Formato de `docs/ai-workflow/06-handoff.md`

```md
# Handoff

## Modo Atual

Modo de Verificação/Refatoração

## O Que Foi Feito

## Decisões Tomadas

## Arquivos Atualizados

## Contexto Relevante Para o Próximo Ciclo

## Não Alterar

## Pendências

## Próxima Ação Recomendada

Encerrar tarefa ou iniciar novo ciclo com `00-current-task.md`.
```

## Condição de Parada

Pare após atualizar os arquivos definidos.

Não inicie nova tarefa.