# Projeto de Programação

## Informações Técnicas:
> Nome: Antônio Gabriel dos Santos Barbosa
> 
> Matrícula: 2557088
>
> Disciplina: Projeto de Programação
>
> Professor: Amaury Nogueira Neto
>
## Como executar o código:
Back-end: Abra a pasta com o terminal e digite mvn spring-boot:run

Front-end: Abara a pasta que o front está, com o terminal, e digite "python3 -m http.server 3000" para conseguir acessar o "localhost:3000"

## Lista de End-Points:
Urls da API
>Post
>
>contas, GET
>
>contas
>
## Arquitetura do Sistema:
O sistema foi desenvolvido seguindo uma arquitetura padrão MVC, separando as responsabilidades de cada parte do código para que fique mais organizado e seja de fácil leitura/entendimento.
>Camada Model — representa os dados do sistema. A classe Conta é abstrata e serve de base para ContaCorrente e ContaPoupanca. Cada conta é uma entidade JPA, ou seja, vira uma tabela no banco de dados SQLite automaticamente.
>
>Camada Repository — é a ponte entre o sistema e o banco de dados. Usando Spring Data JPA, não foi necessário escrever SQL manualmente — o próprio Spring gera as consultas a partir dos métodos da interface ContaRepository.
>
>Camada Service — contém todas as regras de negócio, como criar conta, depositar, sacar, transferir e calcular tributo. Ela fica no meio do caminho entre o Controller e o Repository, garantindo que a lógica não fique misturada com as rotas da API.
>
>Camada Controller — define os endpoints REST que o frontend consome. Cada método responde a uma URL específica, recebe os dados em formato JSON e repassa para o Service processar.
>
>View — desenvolvido em HTML, CSS ( interno, dentro do próprio HTML) e JavaScript puro, consome a API através da Fetch API. O usuário interage com a interface e os dados trafegam em JSON entre o navegador e o backend.
>
>Banco de dados — foi escolhido o SQLite por ser simples de configurar, não exigir instalação de servidor separado e ser suficiente para o escopo do projeto.
