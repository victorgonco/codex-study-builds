# Modo de Especificação

## Objetivo

Você está operando em Modo de Especificação.

Sua responsabilidade é transformar uma demanda bruta em uma especificação clara, limitada e testável.

## Regras do Modo

- Não escreva código.
- Não crie testes.
- Não defina arquitetura técnica ainda.
- Não avance para o próximo modo.
- Não invente requisitos.
- Registre dúvidas como perguntas abertas.
- Registre suposições quando precisar avançar sem confirmação.
- Use português do Brasil.

## Leia Antes

Antes de começar, leia:

- `AGENTS.md`
- `docs/ai-workflow/00-current-task.md`
- `docs/ai-workflow/06-handoff.md`, se existir conteúdo relevante

## Atualize

Ao final, atualize:

- `docs/ai-workflow/01-spec.md`
- `docs/ai-workflow/06-handoff.md`

## Formato de `docs/ai-workflow/01-spec.md`

```md
# Especificação

## Declaração do Problema

Descreva claramente o problema que será resolvido.

## Usuário / Ator

Quem usa ou é afetado por esta funcionalidade?

## Objetivos

- 
- 
- 

## Fora de Escopo

- 
- 
- 

## Requisitos Funcionais

- 
- 
- 

## Requisitos Não Funcionais

- 
- 
- 

## Entradas

- 
- 
- 

## Saídas

- 
- 
- 

## Regras de Negócio

- 
- 
- 

## Casos de Borda

- 
- 
- 

## Suposições

- 
- 
- 

## Perguntas em Aberto

- 
- 
- 

## Definição de Pronto

A especificação está pronta para o Modo de Produto/Testes quando:

- [ ] O problema está claro
- [ ] O escopo está explícito
- [ ] O fora de escopo está explícito
- [ ] Os requisitos são testáveis
- [ ] As perguntas abertas foram respondidas ou convertidas em suposições


## Formato de `docs/ai-workflow/06-handoff.md`

```md
# Handoff

## Modo Atual

Modo de Especificação

## O Que Foi Feito

## Decisões Tomadas

## Arquivos Atualizados

## Contexto Relevante Para o Próximo Modo

## Não Alterar

## Pendências

## Próxima Ação Recomendada

Executar Modo de Produto/Testes.
```

## Condição de Parada

Pare após atualizar os arquivos definidos.

Não continue para Produto/Testes.
