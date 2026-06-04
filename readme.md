# Workflow de Pair Programming com IA

Este repositório usa um workflow de desenvolvimento com IA baseado em **modos**.

Pense no Codex como um time pequeno, mas com uma regra:
ele só pode usar **um chapéu por vez**.

---

## Ideia Central

Não peça para a IA “resolver tudo”.

Peça para ela passar por etapas:

```txt
Especificar → Planejar testes → Desenhar arquitetura → Implementar → Verificar
```

Cada etapa gera um artefato.
Cada artefato vira contexto para a próxima etapa.

Menos improviso.
Menos retrabalho.
Menos token desperdiçado.

---

## Estrutura

```txt
AGENTS.md
docs/ai-workflow/
  00-current-task.md
  01-spec.md
  02-product-and-tests.md
  03-architecture.md
  04-implementation-plan.md
  05-verification.md
  06-handoff.md

prompts/
  spec-mode.md
  product-test-mode.md
  architecture-mode.md
  implementation-mode.md
  verification-refactor-mode.md
```

---

## Papel de Cada Arquivo

### `AGENTS.md`

Regras permanentes do repositório.

O Codex deve seguir este arquivo sempre.

---

### `00-current-task.md`

A missão atual.

Preencha este arquivo antes de começar uma tarefa real.

Ele responde:

* o que será feito
* por que será feito
* o que está dentro do escopo
* o que está fora do escopo
* quais restrições existem

---

### `01-spec.md`

A especificação da demanda.

Aqui a ideia ainda não vira código.
Ela vira clareza.

---

### `02-product-and-tests.md`

A demanda vira história de usuário, critérios de aceite e plano de testes.

Aqui nasce o comportamento esperado.

---

### `03-architecture.md`

A solução ganha forma técnica.

Aqui são definidos:

* domínio
* casos de uso
* portas
* adaptadores
* fluxo de dados
* riscos

---

### `04-implementation-plan.md`

Registro do que foi implementado.

Aqui entram:

* arquivos alterados
* testes criados
* comandos executados
* resultado dos testes

---

### `05-verification.md`

Auditoria final.

Aqui se verifica se o código realmente bate com a especificação, os testes e a arquitetura.

---

### `06-handoff.md`

O bastão da corrida.

Cada modo atualiza este arquivo para o próximo modo saber:

* o que foi feito
* quais decisões foram tomadas
* o que não deve ser alterado
* quais pendências existem
* qual é a próxima ação

---

## Como Usar

### 1. Defina a tarefa

Preencha:

```txt
docs/ai-workflow/00-current-task.md
```

Não precisa escrever uma tese.
Precisa ser claro.

---

### 2. Rode o Modo de Especificação

Prompt para o Codex:

```txt
Leia AGENTS.md.

Opere em Modo de Especificação usando:
prompts/spec-mode.md

A tarefa atual está em:
docs/ai-workflow/00-current-task.md

Atualize apenas:
docs/ai-workflow/01-spec.md
docs/ai-workflow/06-handoff.md

Não escreva código.
Não crie testes.
Não avance para o próximo modo.
```

---

### 3. Rode o Modo de Produto/Testes

```txt
Leia AGENTS.md.

Opere em Modo de Produto/Testes usando:
prompts/product-test-mode.md

Atualize apenas:
docs/ai-workflow/02-product-and-tests.md
docs/ai-workflow/06-handoff.md

Não implemente código.
Não avance para arquitetura.
```

---

### 4. Rode o Modo de Arquitetura

```txt
Leia AGENTS.md.

Opere em Modo de Arquitetura usando:
prompts/architecture-mode.md

Atualize apenas:
docs/ai-workflow/03-architecture.md
docs/ai-workflow/06-handoff.md

Não escreva código.
Não crie testes.
```

---

### 5. Rode o Modo de Implementação

```txt
Leia AGENTS.md.

Opere em Modo de Implementação usando:
prompts/implementation-mode.md

Siga a especificação, o plano de testes e a arquitetura.

Atualize:
docs/ai-workflow/04-implementation-plan.md
docs/ai-workflow/06-handoff.md

Implemente apenas o necessário.
Não refatore fora do escopo.
```

---

### 6. Rode o Modo de Verificação/Refatoração

```txt
Leia AGENTS.md.

Opere em Modo de Verificação/Refatoração usando:
prompts/verification-refactor-mode.md

Verifique código, testes, arquitetura e documentação.

Atualize:
docs/ai-workflow/05-verification.md
docs/ai-workflow/06-handoff.md

Não altere comportamento esperado.
```

---

## Regra de Ouro

A IA não deve ser um gênio solto no repo.

Ela deve ser uma esteira:

```txt
clareza → teste → arquitetura → código → verificação
```

Se ela pular etapa, corrija.

Se ela inventar escopo, pare.

Se ela começar a “melhorar tudo”, mande voltar para o modo correto.

---

## Quando Usar

Use este workflow para:

* features novas
* refatorações relevantes
* bugs importantes
* mudanças com risco
* tarefas que precisam de documentação

Não precisa usar para:

* typo
* ajuste visual trivial
* renome simples
* alteração óbvia de configuração

---

## Princípio Final

O objetivo não é criar burocracia.

O objetivo é forçar a IA a pensar na ordem certa.

## Exemplo de Fatiamento

Veja um exemplo prático de uso do workflow de como quebrar uma POC de TODO CLI em tarefas pequenas:

- `docs/ai-workflow/examples/todo-cli-slicing.md`