---
name: tdd-implementer
description: Implemente um slice funcional Ready por vez usando ciclos curtos de Test-Driven Development, lendo a User Story, a especificação e o código existente para preservar comportamento e convenções. Use quando o usuário pedir a implementação de um slice preparado pelo XP Slice Breaker; não use para discovery, redefinição de histórias, decomposição de slices ou mudanças sem critérios verificáveis.
---

# TDD Implementer

Implemente somente o comportamento do slice indicado, com o menor código correto e proteção adequada por testes. Não antecipe slices futuros, requisitos, abstrações ou melhorias arquiteturais sem necessidade concreta.

Siga: **entender → RED → GREEN → REFACTOR → validar**.

## Pré-condições e fontes

Use esta skill quando existir um slice `Ready` com objetivo, comportamento, critérios de aceitação, origem, escopo e limites. Por padrão, implemente apenas um slice por execução. Implemente vários somente quando o usuário pedir explicitamente.

Leia integralmente:

1. o slice alvo, incluindo `Não inclui`;
2. a User Story e a especificação relacionadas, quando necessárias;
3. `AGENTS.md`, README, documentação técnica e configurações do projeto aplicáveis;
4. o código e os testes existentes na área afetada.

Para comportamento funcional, a autoridade é: **especificação atual → User Story → slice → código**. O slice define o escopo atual. Se houver contradição, não escolha silenciosamente; classifique e reporte a lacuna.

## Compreender o código existente

Antes de editar, localize o ponto de entrada, comportamento atual, domínio afetado, testes, convenções, dependências e impacto esperado. Procure estruturas equivalentes antes de criar outras. Siga os padrões, nomes, organização e estratégia de testes já adotados no projeto.

Não introduza outro padrão arquitetural somente por preferência. Se a arquitetura impedir materialmente a implementação ou a testabilidade, registre o impedimento.

## Executar ciclos TDD pequenos

Repita RED → GREEN → REFACTOR para cada comportamento independente do slice. Não implemente todos os critérios antes de escrever os testes.

### RED

Crie ou altere um teste que demonstre a ausência do comportamento atual. Execute-o e confirme que falha pela razão esperada. A falha deve provar que o comportamento ainda não existe; erro acidental de compilação, configuração quebrada, dependência ausente ou teste incorreto não constitui RED válido.

### GREEN

Implemente o menor código necessário para o teste passar. Evite abstrações, generalizações, otimizações, refatorações extensas e comportamentos adicionais. Execute novamente o teste e depois os testes relacionados.

### REFACTOR

Com os testes verdes, melhore legibilidade, simplicidade, nomes, responsabilidades e duplicação quando houver ganho concreto. Não altere comportamento. Reexecute os testes após cada refatoração significativa.

## Escolher testes adequados

Use os critérios do slice como referência comportamental; os testes não precisam copiar Gherkin literalmente. Escolha o menor nível que prove corretamente o comportamento: domínio, unidade, componente, integração, funcional ou API.

Prefira validar entradas, saídas, estado resultante e efeitos observáveis. Evite acoplamento a métodos privados, estrutura de classes, ordem interna de chamadas e mocks indiscriminados. Use doubles para isolar fronteiras relevantes, seguindo a estratégia do projeto.

Para banco, filas e serviços externos, avalie a infraestrutura de testes existente antes de escolher banco de teste, container, fake, stub, servidor local ou fixture. Não introduza infraestrutura complexa para um cenário simples.

Não remova testes válidos, enfraqueça asserts, ignore falhas, marque testes como skip ou altere comportamento esperado somente para obter uma suíte verde. Se um teste existente contradiz a especificação atual, registre a divergência.

## Manter o escopo mínimo

Trate `Não inclui` como barreira de escopo. Aplique YAGNI: não crie interfaces, factories, strategies, generalizações ou extensibilidade hipotética. Adicione abstrações quando o código atual demonstrar necessidade.

Corrija problemas diretamente relacionados quando forem necessários para concluir o slice com segurança. Não transforme a implementação em limpeza geral. Diferencie dívida necessária para o slice de melhoria desejável; implemente a primeira e apenas sinalize a segunda.

Siga a estratégia existente para persistência e migrações. Preserve compatibilidade quando exigida e respeite requisitos não funcionais relacionados ao slice, como auditoria ou segurança. Não invente requisitos adicionais.

## Classificar impedimentos

Não tome decisões de produto ausentes, como status, permissões, obrigatoriedade de campos ou política de sobrescrita. Classifique os bloqueios:

- **Discovery Gap:** falta definição funcional ou de negócio; retornar ao discovery.
- **Story Gap:** a definição existe na especificação, mas a história não a representa; retornar ao story breakdown.
- **Slice Gap:** a história está clara, mas o slice está incompleto ou incorreto; retornar ao XP Slice Breaker.
- **Technical Blocker:** o comportamento está claro, mas dependência, configuração, infraestrutura ou incompatibilidade impede a execução.

Registre objetivamente o problema, impacto e decisão necessária. Não invente a resposta.

## Validar e concluir

Depois que o slice estiver verde:

1. execute os testes diretamente relacionados;
2. execute a suíte apropriada do componente;
3. quando viável e proporcional, execute a suíte geral relevante;
4. investigue qualquer regressão antes de concluir;
5. confira todos os critérios de aceitação e o escopo negativo.

O slice só está concluído quando comportamento e critérios foram atendidos, novos comportamentos têm testes, regressões relevantes foram verificadas, a refatoração necessária terminou e nenhum requisito futuro foi antecipado.

Leia [references/completion.md](references/completion.md) antes de atualizar o arquivo do slice. Marque `Implemented` somente com evidência de código implementado, testes relevantes verdes e critérios satisfeitos.

Não crie commits, salvo solicitação explícita do usuário. Quando solicitado, mantenha-os pequenos, coerentes com o slice e sem alterações não relacionadas.

## Responder ao usuário

Informe de forma curta:

- slice implementado;
- comportamentos cobertos pelos ciclos TDD;
- principais arquivos ou componentes alterados;
- testes executados e resultados;
- bloqueios, com a classificação correspondente;
- status final `Implemented` ou motivo pelo qual permanece bloqueado.

Resuma os ciclos realizados sem narrar cada edição interna.
