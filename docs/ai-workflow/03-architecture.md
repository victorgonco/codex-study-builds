# Plano de Arquitetura

## Resumo

A solução será organizada em arquitetura hexagonal com um núcleo de domínio simples para tarefas, dois casos de uso explícitos para criar e ler tarefa, um adaptador primário de CLI e um adaptador secundário de persistência em arquivo Markdown único. A infraestrutura ficará responsável por acesso ao sistema de arquivos e serialização Markdown, enquanto o domínio e os casos de uso permanecerão independentes desses detalhes.

## Conceitos de Domínio

- `Tarefa`: entidade de domínio com identificador estável, título e descrição.
- `IdentificadorDaTarefa`: valor único gerado na aplicação para evitar ambiguidade com títulos repetidos.
- `ColecaoDeTarefas`: representação lógica do conjunto de tarefas persistidas no único arquivo Markdown.

## Casos de Uso

- `CriarTarefa`: valida a entrada, garante a existência do armazenamento, gera identificador e adiciona a nova tarefa ao arquivo Markdown único.
- `LerTarefa`: recebe um identificador de tarefa, consulta o repositório e retorna os dados da tarefa ou erro controlado quando não encontrada.
- `InicializarArmazenamento`: responsabilidade interna do adaptador de persistência para criar pasta e arquivo base quando ainda não existirem.

## Portas

### Portas de Entrada

- `CriarTarefaUseCase`: contrato de aplicação para criação de tarefa a partir de dados vindos da CLI.
- `LerTarefaUseCase`: contrato de aplicação para leitura de tarefa por identificador.

### Portas de Saída

- `RepositorioDeTarefas`: abstrai operações de adicionar e buscar tarefas no armazenamento.
- `GeradorDeIdentificador`: abstrai a geração de identificadores para manter o caso de uso desacoplado.
- `SerializadorMarkdownDeTarefas`: abstrai conversão entre domínio e conteúdo Markdown.

## Adaptadores

### Adaptadores Primários

- `CLI de criação`: interpreta argumentos ou subcomando de criação, monta a entrada do caso de uso e apresenta sucesso ou erro no terminal.
- `CLI de leitura`: interpreta argumentos ou subcomando de leitura, chama o caso de uso e apresenta a tarefa encontrada no terminal.

### Adaptadores Secundários

- `RepositorioMarkdownEmArquivo`: implementa `RepositorioDeTarefas` lendo e escrevendo um único arquivo Markdown em pasta local.
- `GeradorDeUUID`: implementação simples de `GeradorDeIdentificador` usando recurso padrão da plataforma Java.
- `SerializadorMarkdownSimples`: converte a coleção de tarefas para um formato Markdown previsível e parseável.

## Fluxo de Dados

1. A pessoa usuária executa um comando CLI de criação ou leitura.
2. O adaptador primário valida formato básico de argumentos e chama o caso de uso apropriado.
3. O caso de uso aplica validações de negócio e aciona as portas de saída necessárias.
4. O repositório em arquivo garante pasta e arquivo base, lê o conteúdo atual, converte para domínio e executa a operação solicitada.
5. O serializador grava novamente o arquivo Markdown único quando houver criação.
6. O adaptador primário traduz o resultado em saída amigável no terminal.

## Tratamento de Erros

- Título vazio ou em branco deve resultar em erro de validação de domínio, sem escrita em arquivo.
- Tarefa não encontrada por identificador deve resultar em erro controlado de aplicação, sem stack trace como resposta principal da CLI.
- Falhas de leitura, escrita, criação de pasta ou arquivo devem ser encapsuladas como erro de infraestrutura traduzido pela camada de entrada.

## Estratégia de Validação

- Validações de regra de negócio ficam no caso de uso e no domínio, principalmente obrigatoriedade de título.
- O adaptador de CLI valida apenas presença e formato mínimo dos argumentos antes de montar a requisição.
- A descrição pode ser vazia nesta primeira etapa, mas deve ser normalizada para valor previsível para persistência e exibição.

## Estratégia de Persistência

- Todas as tarefas serão persistidas em um único arquivo Markdown dentro de um diretório dedicado da aplicação.
- O arquivo deve ser tratado como fonte única de verdade nesta etapa, sem banco, cache ou múltiplos arquivos por tarefa.
- O formato Markdown deve incluir o identificador de cada tarefa, permitindo leitura determinística mesmo com títulos repetidos.

## Dependências Externas

- Java 21 como base da implementação.
- Biblioteca de CLI apenas se realmente necessária para parsing; se não houver ganho claro, a primeira implementação pode usar recursos nativos da plataforma.
- Nenhuma dependência de banco de dados, framework web ou mecanismo externo de persistência.

## Arquivos Esperados Para Alteração

- `docs/ai-workflow/03-architecture.md`
- `docs/ai-workflow/06-handoff.md`
- `docs/ai-workflow/04-implementation-plan.md` no próximo modo, para decompor a implementação a partir desta arquitetura.

## Riscos

- Definir um formato Markdown ambíguo pode dificultar parse e evolução futura.
- Misturar parsing de CLI com regra de negócio pode quebrar o isolamento hexagonal se não houver disciplina na implementação.
- Regravar o arquivo inteiro a cada criação é simples para esta etapa, mas pode introduzir cuidado extra com consistência se o formato não for estável.

## Decisões Técnicas

- A leitura de tarefa será orientada por identificador gerado, não por título, para evitar colisões e comportamento indefinido.
- A persistência inicial regrava o arquivo Markdown completo a partir da coleção de tarefas em memória carregada pelo repositório.
- A criação de diretório e arquivo base será responsabilidade do adaptador secundário de persistência, não do domínio nem dos casos de uso.

## Gate de Arquitetura

- [x] Domínio está isolado
- [x] Efeitos colaterais estão isolados
- [x] Casos de uso estão explícitos
- [x] Dependências apontam para dentro
- [x] Testes podem ser escritos sem depender diretamente de infraestrutura
