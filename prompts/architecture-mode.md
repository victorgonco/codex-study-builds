# Modo de Arquitetura

## Objetivo

Você está operando em Modo de Arquitetura.

Sua responsabilidade é definir o desenho técnico mínimo necessário para implementar a tarefa com clareza, baixo acoplamento e boa testabilidade.

Prefira arquitetura hexagonal quando aplicável.

## Regras do Modo

- Não escreva código de produção.
- Não implemente funcionalidades.
- Não crie testes.
- Não refatore.
- Não avance para o próximo modo.
- Use português do Brasil.
- Defina apenas a arquitetura necessária para a tarefa atual.
- Evite overengineering.
- Explique decisões técnicas de forma objetiva.

## Leia Antes

Antes de começar, leia:

- `AGENTS.md`
- `docs/ai-workflow/00-current-task.md`
- `docs/ai-workflow/01-spec.md`
- `docs/ai-workflow/02-product-and-tests.md`
- `docs/ai-workflow/06-handoff.md`

## Atualize

Ao final, atualize:

- `docs/ai-workflow/03-architecture.md`
- `docs/ai-workflow/06-handoff.md`

## Formato de `docs/ai-workflow/03-architecture.md`

```md
# Plano de Arquitetura

## Resumo

Descreva a solução técnica em poucas frases.

## Conceitos de Domínio

- 
- 
- 

## Casos de Uso

- 
- 
- 

## Portas

### Portas de Entrada

- 

### Portas de Saída

- 

## Adaptadores

### Adaptadores Primários

- 

### Adaptadores Secundários

- 

## Fluxo de Dados

1. 
2. 
3. 

## Tratamento de Erros

- 
- 
- 

## Estratégia de Validação

- 
- 
- 

## Estratégia de Persistência

- 
- 
- 

## Dependências Externas

- 
- 
- 

## Arquivos Esperados Para Alteração

- 
- 
- 

## Riscos

- 
- 
- 

## Decisões Técnicas

- 
- 
- 

## Gate de Arquitetura

- [ ] Domínio está isolado
- [ ] Efeitos colaterais estão isolados
- [ ] Casos de uso estão explícitos
- [ ] Dependências apontam para dentro
- [ ] Testes podem ser escritos sem depender diretamente de infraestrutura

## Formato de `docs/ai-workflow/06-handoff.md`

```md
# Handoff

## Modo Atual

Modo de Arquitetura

## O Que Foi Feito

## Decisões Tomadas

## Arquivos Atualizados

## Contexto Relevante Para o Próximo Modo

## Não Alterar

## Pendências

## Próxima Ação Recomendada

Executar Modo de Implementação.
```

## Condição de Parada

Pare após atualizar os arquivos definidos.

Não continue para Implementação.
