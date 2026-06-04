# Produto e Plano de Testes

## História de Usuário

Como pessoa usuária do terminal,  
quero criar e ler tarefas simples em um app CLI,  
para manter uma lista local de tarefas registrada em um único arquivo Markdown.

## Critérios de Aceite

- O aplicativo deve permitir criar uma tarefa informando título e descrição.
- Ao criar uma tarefa válida, o aplicativo deve registrar a tarefa no arquivo Markdown único de armazenamento.
- Ao criar mais de uma tarefa, todas devem permanecer no mesmo arquivo Markdown.
- O aplicativo deve permitir ler uma tarefa já registrada.
- A leitura deve exibir o título e a descrição da tarefa solicitada.
- O aplicativo deve rejeitar a criação de tarefa sem título.
- O aplicativo deve tratar a tentativa de leitura de tarefa inexistente com mensagem clara de erro ou orientação.
- O aplicativo deve criar ou preparar o armazenamento local quando a pasta ou o arquivo Markdown ainda não existir.
- O aplicativo não deve criar relações entre tarefas, subtarefas, edição, exclusão, API HTTP, interface gráfica ou banco de dados.

## Cenários BDD

### Cenário 1: Caminho Feliz

Dado que a pessoa usuária possui acesso ao terminal e não há tarefa registrada ainda  
Quando ela cria uma tarefa com título "Comprar café" e descrição "Comprar café para a semana"  
Então o aplicativo confirma a criação da tarefa  
E a tarefa fica registrada no arquivo Markdown único de armazenamento  
E a leitura dessa tarefa exibe o título "Comprar café" e a descrição "Comprar café para a semana"

### Cenário 2: Erro de Validação

Dado que a pessoa usuária está criando uma tarefa pelo terminal  
Quando ela envia uma tarefa sem título  
Então o aplicativo rejeita a criação  
E informa que o título é obrigatório  
E nenhuma nova tarefa é registrada no arquivo Markdown de armazenamento

### Cenário 3: Caso de Borda

Dado que já existe uma tarefa registrada no arquivo Markdown único  
Quando a pessoa usuária cria uma segunda tarefa válida  
Então o aplicativo mantém a tarefa anterior  
E adiciona a nova tarefa no mesmo arquivo Markdown  
E a leitura deve conseguir recuperar as tarefas registradas sem criar arquivos Markdown separados para cada tarefa

## Estratégia de Testes

Os testes devem priorizar comportamento observável e regras de produto. A implementação futura deve permitir testar a criação e leitura de tarefas sem depender diretamente do terminal real ou do sistema de arquivos real em testes unitários.

Os testes automatizados devem cobrir o fluxo principal, validações, persistência no mesmo arquivo Markdown e falhas esperadas. Os testes de integração devem validar a interação com arquivos e pastas locais usando ambiente temporário controlado.

## Testes Unitários

- Criar tarefa válida deve produzir uma tarefa com título e descrição preservados.
- Criar tarefa sem título deve falhar com erro de validação.
- Criar tarefa com descrição vazia deve ser permitido ou rejeitado conforme decisão final do produto antes da implementação.
- Ler tarefa existente deve retornar título e descrição corretos.
- Ler tarefa inexistente deve retornar erro ou resultado vazio controlado, sem falha inesperada.
- Adicionar nova tarefa não deve remover tarefas já existentes da coleção de tarefas em memória usada pelo caso de uso.
- A lógica de criação e leitura não deve criar relações, subtarefas ou dependências entre tarefas.

## Testes de Integração

- Criar uma primeira tarefa deve criar ou atualizar o arquivo Markdown único no diretório de armazenamento configurado para o teste.
- Criar duas tarefas deve manter ambas no mesmo arquivo Markdown.
- Ler tarefa registrada no arquivo Markdown deve retornar os dados esperados.
- Tentar ler quando o arquivo Markdown ainda não existe deve retornar mensagem controlada ou lista vazia, conforme contrato definido antes da implementação.
- Falha de permissão ou escrita no diretório de armazenamento deve ser tratada com erro claro.

## Testes de Contrato

- O contrato do comando de criação deve definir entradas obrigatórias para título e descrição.
- O contrato do comando de leitura deve definir como a tarefa será selecionada para leitura.
- O contrato de saída de criação deve incluir confirmação de sucesso ou erro de validação.
- O contrato de saída de leitura deve incluir título e descrição quando a tarefa existir.
- O contrato de armazenamento deve garantir que todas as tarefas iniciais sejam mantidas em um único arquivo Markdown.

## Testes Negativos

- Criar tarefa sem título.
- Ler tarefa inexistente.
- Ler a partir de arquivo Markdown vazio.
- Ler a partir de arquivo Markdown inválido ou fora do formato esperado.
- Criar tarefa quando o diretório de armazenamento não puder ser criado.
- Criar tarefa quando o arquivo Markdown não puder ser escrito.
- Criar tarefas com títulos repetidos, caso o identificador final use título ou posição.

## Dados de Teste / Fixtures

- Tarefa válida: título "Comprar café", descrição "Comprar café para a semana".
- Tarefa válida adicional: título "Estudar Java", descrição "Revisar fundamentos de Java 21".
- Tarefa inválida: título vazio, descrição "Descrição sem título".
- Arquivo Markdown vazio.
- Arquivo Markdown com uma tarefa válida.
- Arquivo Markdown com duas tarefas válidas no mesmo arquivo.
- Arquivo Markdown com conteúdo fora do formato esperado.
- Diretório temporário sem arquivo Markdown inicial.

## Definição de Pronto Para Arquitetura

- [x] Critérios de aceite são testáveis
- [x] Fluxos principais estão cobertos
- [x] Casos de borda estão listados
- [x] Falhas esperadas estão descritas
