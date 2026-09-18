# Conclusão do slice

Use esta referência depois que a implementação e os testes estiverem concluídos.

## Atualizar o arquivo do slice

Altere o status para `Implemented` somente quando houver evidência de que:

- todo comportamento pertencente ao slice foi implementado;
- os critérios de aceitação aplicáveis foram satisfeitos;
- testes novos ou ajustados protegem o comportamento;
- testes relacionados estão verdes;
- regressões relevantes foram verificadas;
- não há bloqueio conhecido que impeça o comportamento.

Acrescente uma seção curta, sem transformar o slice em documentação detalhada do código:

```markdown
## Implementação

**Status:** Implemented

**Principais mudanças:**
- comportamento X implementado;
- validação Y adicionada;
- persistência Z ajustada.

**Testes:**
- cenário A;
- cenário B.

**Validação:**
- testes relacionados executados com sucesso.
```

O Git permanece responsável pelo histórico técnico. Não copie diffs, detalhes internos ou uma narrativa completa da implementação para o slice.

## Atualizar o MVP

Consulte `MVPs.md` depois de concluir o slice. Só marque um MVP como `Implemented` quando todas as histórias e slices necessários estiverem implementados, a aplicação puder ser executada no ambiente suportado e a validação comportamental do marco tiver sido realizada. Registre evidência curta dos comandos ou procedimentos executados; não considere a soma de status suficiente sem validar o resultado integrado.

## Atualizar o repasse

Mantenha `handoff.md` no diretório de controle como uma checklist operacional, não como histórico:

```markdown
# Repasse

- [x] SLICE-001 implementado e validado.
- [ ] Aguardando: implementar SLICE-002.
- [ ] Próximo passo: executar `tdd-implementer` para SLICE-002.
```

Quando não houver outro slice `Ready`, a próxima ação deve apontar para o `xp-slice-breaker`, o `story-breakdown` ou o `discovery-engineer`, conforme a classificação da lacuna. Preserve `backlog.md` como lista de futuro; não implemente nem marque suas frases apenas porque seriam convenientes ao código atual.

## Definition of Done

Considere o slice concluído quando:

```text
Comportamento implementado
+ critérios satisfeitos
+ testes adicionados ou ajustados
+ testes verdes
+ regressões relevantes verificadas
+ refatoração necessária concluída
+ nenhum requisito futuro antecipado
```

Se algum teste relevante falhar ou um bloqueio impedir o comportamento, mantenha o status anterior e informe a causa.

## Verificação final

Confirme antes de encerrar:

- somente o slice solicitado foi implementado;
- critérios de aceitação e `Não inclui` foram respeitados;
- cada comportamento novo começou com um RED válido;
- GREEN contém a menor implementação correta;
- REFACTOR preservou o comportamento;
- todos os testes pertinentes continuam verdes;
- nenhuma abstração ou funcionalidade futura foi antecipada;
- nenhuma regra de negócio foi inventada;
- dúvidas foram classificadas como Discovery Gap, Story Gap, Slice Gap ou Technical Blocker;
- o status `Implemented` está sustentado por evidência.
- um MVP concluído possui evidência de execução e validação integrada.
- o repasse registra o ponto de parada e uma próxima ação concreta.
