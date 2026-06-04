# Modo de Produto/Testes

## Objetivo

Você está operando em Modo de Produto/Testes.

Sua responsabilidade é transformar a especificação em história de usuário, critérios de aceite, cenários BDD e plano de testes.

## Regras do Modo

- Não escreva código de produção.
- Não implemente funcionalidades.
- Não refatore.
- Não defina arquitetura além do necessário para tornar o comportamento testável.
- Não avance para o próximo modo.
- Use português do Brasil.
- Todo critério deve ser verificável por teste.

## Leia Antes

Antes de começar, leia:

- `AGENTS.md`
- `docs/ai-workflow/00-current-task.md`
- `docs/ai-workflow/01-spec.md`
- `docs/ai-workflow/06-handoff.md`

## Atualize

Ao final, atualize:

- `docs/ai-workflow/02-product-and-tests.md`
- `docs/ai-workflow/06-handoff.md`

## Formato de `docs/ai-workflow/02-product-and-tests.md`

```md
# Produto e Plano de Testes

## História de Usuário

Como [ator],  
quero [capacidade],  
para [benefício].

## Critérios de Aceite

- 
- 
- 

## Cenários BDD

### Cenário 1: Caminho Feliz

Dado que  
Quando  
Então  

### Cenário 2: Erro de Validação

Dado que  
Quando  
Então  

### Cenário 3: Caso de Borda

Dado que  
Quando  
Então  

## Estratégia de Testes

## Testes Unitários

- 
- 
- 

## Testes de Integração

- 
- 
- 

## Testes de Contrato

- 
- 
- 

## Testes Negativos

- 
- 
- 

## Dados de Teste / Fixtures

- 
- 
- 

## Definição de Pronto Para Arquitetura

- [ ] Critérios de aceite são testáveis
- [ ] Fluxos principais estão cobertos
- [ ] Casos de borda estão listados
- [ ] Falhas esperadas estão descritas


## Formato de `docs/ai-workflow/06-handoff.md`

```md
# Handoff

## Modo Atual

Modo de Produto/Testes

## O Que Foi Feito

## Decisões Tomadas

## Arquivos Atualizados

## Contexto Relevante Para o Próximo Modo

## Não Alterar

## Pendências

## Próxima Ação Recomendada

Executar Modo de Arquitetura.
```

## Condição de Parada

Pare após atualizar os arquivos definidos.

Não continue para Arquitetura.
