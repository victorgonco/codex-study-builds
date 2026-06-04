# Modo de Implementação

## Objetivo

Você está operando em Modo de Implementação.

Sua responsabilidade é criar ou atualizar os testes planejados e implementar o menor código correto possível para fazê-los passar.

## Regras do Modo

- Use português do Brasil.
- Leia a documentação do workflow antes de alterar código.
- Não expanda escopo.
- Não altere arquivos não relacionados.
- Não faça grandes refatorações.
- Não enfraqueça testes.
- Não remova testes para fazer a implementação passar.
- Não esconda erros.
- Não avance para o próximo modo.
- Implemente apenas o necessário para a tarefa atual.
- Se a arquitetura planejada for inviável, registre o problema no handoff antes de adaptar.

## Leia Antes

Antes de começar, leia:

- `AGENTS.md`
- `docs/ai-workflow/00-current-task.md`
- `docs/ai-workflow/01-spec.md`
- `docs/ai-workflow/02-product-and-tests.md`
- `docs/ai-workflow/03-architecture.md`
- `docs/ai-workflow/06-handoff.md`

## Processo Obrigatório

1. Identifique os arquivos relevantes.
2. Crie ou atualize os testes conforme `02-product-and-tests.md`.
3. Execute os testes.
4. Confirme que os testes falham pelo motivo esperado.
5. Implemente o menor código necessário.
6. Execute os testes novamente.
7. Corrija apenas falhas relacionadas à tarefa.
8. Atualize os documentos definidos abaixo.

## Atualize

Ao final, atualize:

- `docs/ai-workflow/04-implementation-plan.md`
- `docs/ai-workflow/06-handoff.md`

## Formato de `docs/ai-workflow/04-implementation-plan.md`

```md
# Relatório de Implementação

## Arquivos Alterados

- 

## Testes Criados

- 

## Testes Atualizados

- 

## Resumo da Implementação

## Comandos Executados

```bash

```

## Resultado dos Testes

## Limitações Conhecidas

## Fora de Escopo

## Gate de Implementação

- [ ] Testes foram criados ou atualizados antes/durante a implementação
- [ ] Testes falharam pelo motivo esperado antes da implementação
- [ ] Testes relacionados passam após a implementação
- [ ] Nenhuma alteração fora do escopo foi feita
- [ ] Nenhuma refatoração ampla foi feita
```

## Formato de `docs/ai-workflow/06-handoff.md`

```md
# Handoff

## Modo Atual

Modo de Implementação

## O Que Foi Feito

## Decisões Tomadas

## Arquivos Atualizados

## Contexto Relevante Para o Próximo Modo

## Não Alterar

## Pendências

## Próxima Ação Recomendada

Executar Modo de Verificação/Refatoração.
```

## Condição de Parada

Pare após atualizar os arquivos definidos.

Não continue para Verificação/Refatoração.