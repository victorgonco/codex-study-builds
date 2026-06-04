# Exemplo: Fatiando uma POC de TODO CLI

Este exemplo mostra como quebrar uma ideia de app em tarefas pequenas para usar com o workflow.

A regra é simples:

- `00-current-task.md` não é o sonho inteiro do produto.
- É a próxima fatia de trabalho.

---

## Visão do Produto

Criar uma aplicação CLI simples para gerenciar tarefas TODO.

A aplicação deve permitir, ao longo do tempo:

* listar tarefas
* criar tarefas
* concluir tarefas
* editar tarefas
* remover tarefas
* persistir tarefas localmente

Isso é a visão geral, não a tarefa atual.

---

## Forma Ruim

Evite colocar isso no `00-current-task.md`:

```md
# Tarefa Atual

Criar um aplicativo completo de TODO via CLI com CRUD, persistência, filtros, edição, remoção, conclusão de tarefas e arquitetura robusta.
```

Problema:

* escopo grande demais
* IA tende a implementar coisa antes da hora
* testes ficam genéricos
* arquitetura nasce pesada
* aumenta o uso de tokens
* dificulta verificação

---

## Forma Boa

Use uma fatia pequena por ciclo.

Cada fatia passa pelo workflow completo:

```txt
Especificação → Produto/Testes → Arquitetura → Implementação → Verificação
```

---

## Fatia 1: Estrutura Inicial e Listagem

### Objetivo

Criar a estrutura inicial do projeto e permitir listar tarefas via CLI.

### Escopo

* criar estrutura base de pastas
* definir ponto de entrada da CLI
* criar comando de listagem
* retornar lista vazia quando não houver tarefas
* adicionar testes do comportamento inicial

### Fora de Escopo

* criar tarefas
* editar tarefas
* concluir tarefas
* remover tarefas
* persistência definitiva
* filtros
* interface interativa

### Exemplo para `00-current-task.md`

```md
# Tarefa Atual

## Objetivo

Criar a estrutura inicial do projeto e permitir listar tarefas via CLI.

## Contexto

Estamos criando uma POC de um aplicativo TODO via linha de comando.  
Nesta primeira fatia, o objetivo é validar a estrutura mínima e o fluxo de leitura/listagem de tarefas.

## Escopo

- Criar estrutura inicial de pastas.
- Criar ponto de entrada da CLI.
- Implementar comando para listar tarefas.
- Exibir uma mensagem adequada quando não houver tarefas.
- Criar testes para o comportamento de listagem.

## Fora de Escopo

- Criar novas tarefas.
- Editar tarefas.
- Concluir tarefas.
- Remover tarefas.
- Persistência definitiva em arquivo ou banco.
- Filtros ou ordenação.

## Restrições

- Usar português do Brasil em documentação, mensagens e comentários.
- Manter implementação mínima.
- Não criar arquitetura maior que o necessário para a POC.
- Seguir o workflow definido em `AGENTS.md`.

## Arquivos Relevantes

- A definir pelo Modo de Arquitetura.

## Decisões Já Tomadas

- O app será uma CLI.
- A primeira entrega deve focar apenas na listagem.
- O desenvolvimento deve seguir TDD.

## Perguntas em Aberto

- Qual linguagem/runtime será usado?
- Qual framework de CLI será usado, se houver?
- As tarefas iniciais virão de memória, mock ou arquivo temporário?

## Etapa Atual

- [ ] Modo de Especificação
- [ ] Modo de Produto/Testes
- [ ] Modo de Arquitetura
- [ ] Modo de Implementação
- [ ] Modo de Verificação/Refatoração

## Próxima Ação

> Executar Modo de Especificação.
```

---

## Fatia 2: Criação de Tarefas

### Objetivo

Adicionar criação de tarefas via CLI.

### Escopo

* criar comando para adicionar tarefa
* validar descrição obrigatória
* armazenar tarefa no mecanismo definido na fatia anterior
* listar tarefa criada
* testar sucesso e erro de validação

### Fora de Escopo

* editar tarefas
* concluir tarefas
* remover tarefas
* filtros
* prioridades
* datas

---

## Fatia 3: Conclusão de Tarefas

### Objetivo

Permitir marcar uma tarefa como concluída.

### Escopo

* criar comando para concluir tarefa
* identificar tarefa por ID
* alterar status para concluída
* tratar ID inexistente
* testar fluxo feliz e erro

### Fora de Escopo

* reabrir tarefa
* editar descrição
* remover tarefa
* filtros por status

---

## Fatia 4: Persistência Local

### Objetivo

Persistir tarefas em arquivo local.

### Escopo

* definir formato de armazenamento
* salvar tarefas criadas
* carregar tarefas ao iniciar CLI
* tratar arquivo inexistente
* tratar arquivo inválido
* testar leitura e escrita

### Fora de Escopo

* banco de dados
* sincronização remota
* autenticação
* criptografia
* múltiplos usuários

---

## Fatia 5: Edição e Remoção

### Objetivo

Permitir editar e remover tarefas existentes.

### Escopo

* editar descrição de uma tarefa
* remover tarefa por ID
* tratar ID inexistente
* manter persistência funcionando
* testar edição, remoção e erros

### Fora de Escopo

* histórico de alterações
* lixeira
* desfazer ação
* permissões

---

## Regra Prática

Para cada nova fatia:

1. Atualize `00-current-task.md`.
2. Rode Modo de Especificação.
3. Rode Modo de Produto/Testes.
4. Rode Modo de Arquitetura.
5. Rode Modo de Implementação.
6. Rode Modo de Verificação/Refatoração.

Não coloque a visão inteira do produto na tarefa atual.

Coloque apenas a próxima fatia.
