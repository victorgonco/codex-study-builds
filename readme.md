# Workflow de desenvolvimento com XP

Este repositório reúne quatro skills que transformam uma ideia em software executável e testado por meio de entregas incrementais:

1. `discovery-engineer` esclarece o produto e mantém a especificação atual.
2. `story-breakdown` converte a especificação em histórias e organiza MVPs executáveis e testáveis.
3. `xp-slice-breaker` divide cada história em slices verticais pequenos, preservando o MVP ao qual pertencem.
4. `tdd-implementer` implementa um slice por vez com TDD e registra a evidência da entrega.

O fluxo de artefatos é:

```text
ideia
  → spec.md / duvidas.md / changelog.md
  → histórias / README.md / MVPs.md
  → slices / README.md
  → código executável + testes
```

Cada etapa deve explicitar o impacto sobre a seguinte. A especificação é a autoridade funcional; histórias e slices apenas a decompõem; a implementação fornece a evidência executável de que o comportamento foi entregue.

## Controle externo do workflow

Além dos artefatos internos de cada etapa, o workflow mantém dois arquivos no diretório de controle, normalmente ao lado de `spec.md`:

- `handoff.md`: repasse operacional curto, em checklist, mostrando o que foi concluído, onde o trabalho parou, o que está aguardando e qual é o próximo passo executável;
- `backlog.md`: lista simples de frases sobre mudanças e próximos passos futuros que ainda não fazem parte do estado atual da especificação.

O `backlog.md` não é fonte de requisitos. Um item futuro somente passa a orientar histórias e implementação depois de ser refinado no discovery e incorporado à especificação. Assim, os documentos internos podem representar corretamente o produto de hoje enquanto o backlog torna visível que ele deverá evoluir depois.

O `changelog.md` continua com outra responsabilidade: registrar mudanças semânticas que já aconteceram. Ele não substitui o repasse atual nem o horizonte futuro.
