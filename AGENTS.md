# AGENTS.md

## Propósito

Este repositório usa um workflow de pair programming com IA baseado em modos explícitos.

O assistente não deve atuar livremente em todas as responsabilidades ao mesmo tempo.
Ele deve operar conforme o modo selecionado e respeitar os documentos do workflow.

## Regra Central

Antes de trabalhar em qualquer tarefa não trivial, leia:

- `docs/ai-workflow/00-current-task.md`

Se o arquivo da tarefa atual não estiver preenchido, peça ao usuário para definir a tarefa ou ajude a criá-la.

## Idioma Obrigatório

Toda comunicação, documentação, comentários, nomes descritivos e explicações devem ser feitos em **português do Brasil**.

Exceções permitidas:

- palavras-chave da linguagem de programação
- APIs externas
- nomes técnicos já consolidados em inglês
- nomes de bibliotecas, frameworks, pacotes e comandos

## Arquivos do Workflow

O workflow fica em:

- `docs/ai-workflow/00-current-task.md`
- `docs/ai-workflow/01-spec.md`
- `docs/ai-workflow/02-product-and-tests.md`
- `docs/ai-workflow/03-architecture.md`
- `docs/ai-workflow/04-implementation-plan.md`
- `docs/ai-workflow/05-verification.md`
- `docs/ai-workflow/06-handoff.md`

Os prompts de modo ficam em:

- `prompts/spec-mode.md`
- `prompts/product-test-mode.md`
- `prompts/architecture-mode.md`
- `prompts/implementation-mode.md`
- `prompts/verification-refactor-mode.md`

## Modos

O assistente deve operar em apenas um modo por vez:

1. Modo de Especificação
2. Modo de Produto/Testes
3. Modo de Arquitetura
4. Modo de Implementação
5. Modo de Verificação/Refatoração

Não pule modos, exceto se o usuário pedir explicitamente.

Não misture responsabilidades entre modos.

## Regras Globais

- Prefira alterações pequenas e seguras.
- Não altere arquivos não relacionados.
- Não expanda o escopo.
- Não invente requisitos.
- Não enfraqueça testes para a implementação passar.
- Não esconda erros.
- Não faça grandes refatorações durante o modo de implementação.
- Mantenha a documentação alinhada ao código real.
- Atualize `docs/ai-workflow/06-handoff.md` ao final de cada modo.

## Preferência de Arquitetura

Prefira arquitetura hexagonal quando aplicável:

- O domínio não deve depender de infraestrutura.
- Casos de uso devem ser explícitos.
- Efeitos colaterais devem ficar isolados atrás de portas.
- Adaptadores devem depender para dentro.
- Testes devem focar comportamento, não detalhes de implementação.

## Preferência de Testes

Prefira desenvolvimento guiado por testes (TDD):

1. Entenda o comportamento esperado.
2. Defina critérios de aceite.
3. Escreva testes que falham.
4. Implemente o mínimo necessário para passar.
5. Refatore sem alterar comportamento.
6. Verifique contra a especificação original.

## Requisito de Handoff

Ao final de todo modo, atualize:

- `docs/ai-workflow/06-handoff.md`

O handoff deve conter:

- modo atual
- o que foi feito
- decisões tomadas
- arquivos atualizados
- contexto relevante para o próximo modo
- pendências
- próxima ação recomendada

## Condição de Parada

Pare quando o modo selecionado estiver completo.

Não avance automaticamente para o próximo modo, exceto se o usuário pedir explicitamente.