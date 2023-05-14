# O que é API Rest?? 

Basta uma pesquisa rápida na internet sobre a pergunta acima e nos deparamos com a informação de que "API REST é uma interface de programação de aplicações que está em conformidade com as restrições do estilo de arquitetura REST, permitindo a interação com serviços web RESTful."

Tá, mas o que diabos significa "uma interface de programação?"

Se você for iniciante, esse termo não é nada amigável, se ainda por cima não for uma pessoa curiosa, dificilmente sequer pesquisará sobre o significado do termo.
Eis a questão, em minha luta num fim de semana do mês de maio para criar minha primeira API totalmente autoral, me frustrei por ter alguns blockers e alguns gaps no conhecimento, foi então que resolvi pesquisar afundo o que é uma API, o que é REST e quais seus respectivos significados.

Vamos as explicações.

---

## **Significado de API**
 as APIs - do inglês Application Programming Interface - são consideradas interfaces de programação porque fornecem um conjunto de métodos, funções e protocolos que permitem a comunicação e interação das diferentes camadas/objetos que compõem um software.  
Uma interface, no contexto da Programação Orientada a Objetos, é uma camada abstrata que define como os diferentes sistemas ou componentes devem interagir uns com os outros, ela disponibiliza para outras classes os métodos disponíveis, parâmetros esperados e também os tipos e formatos de dados utilizados na comunicação, vejamos um exemplo de interface:  
![Exemplo de interface em POO](/Estudos/BackEnd/markdown/assets/interface-exemplo.jpg)  
No exemplo acima, a interface define os métodos realizarPagamento recebendo um double relativo ao valor do pagamento, cancelarPagamento() e por fim obterSaldoDisponivel - que retorna um double com o saldo do usuário.  
Cada classe que desejar implementar essa interface, poderá definir qual a lógica a ser seguida dentro dos métodos, podendo realizar validações específicas para cada método, como por exemplo, checar o status do pedido antes de cancelarPagamento e verificar se a regra de negócio permite que o pagamento seja de fato cancelado, no entanto, cada classe que implementar essa interface terá como **obrigação** possuir os três métodos.

Num contexto mais geral, uma API define uma interface específica para um determinado software ou serviço. Ela permite que outras aplicações ou até mesmo desenvolvedores utilizem as funcionalidades disponíveis sem que precisem conhecer os detalhes de implementação.
Podemos enxergar uma API como um contrato onde as regras estão escritas e regem a relação entre cliente-servidor, tais regras devem ser respeitadas para que a interação seja bem sucedida.

---

## **REST**

REST não é um protocolo e nem um padrão. Trata-se de um conjunto de restrições de arquitetura, essas restrições possuem o objetivo de facilitar a criação de aplicações escaláveis e flexíveis.

REST foi proposto por Roy Fielding em sua tese de doutorado nos anos 2000, e desde então é amplamente utilizado nas construções de APIs na web.

Ela possui os seguintes princípios:

1. **Cliente-Servidor**: O sistema é dividido em duas partes distintas, de um lado está o cliente, que faz as solicitações, e do outro lado o servidor, que processa as solicitações que foram feitas e envia a resposta adequada.
1. **Sem estado - Stateless**: O servidor não armazena nenhuma informação sobre o estado do cliente ou histórico de interações passadas, portanto cada solicitação é tratada de forma independente, ou seja, em uma arquitetura stateless, cada solicitação contém **todas** as informações necessárias para que o servidor entenda e consiga processar aquela solicitação, sem depender de informações mantidas em sessões anteriores. 
1. **Cache**: As respostas do servidor podem ser armazenadas em cache no cliente ou em outros servidores, para que a carga seja reduzida no servidor em solicitações futuras.
1. **Interface uniforme**: O REST define uma interface uniforme consistente para interações entre o cliente e o servidor. Isso se dá pelo uso de recursos identificados através da URL, pelos métodos HTTP padronizados (GET, POST, PUT, DELETE), para manipular os recursos e os códigos HTTP indicam o resultado da solicitação.
1. **Sistema em camadas**: Ter um sistema de camadas que organiza os tipos de servidores que serão responsáveis por segurança, carregamento de carga envolvidos na recuperação de informações solicitadas.

### Exemplos de camadas em uma API rest
1. **Controller**: serve para mapear o endereço, que quando chamado, devolverá os usuários cadastrados (GET) ou possibilitará sua inserção, atualização ou remoção do sistema, utilizando respectivamente os verbos POST, PUT, DELETE.
1. **Service**: Camada responsável pela lógica dos métodos CRUD.
1. **Repository**: Camada responsável por encapsular a lógica relacionada com o acesso aos dados, dessa forma as classes de domínio não são impactadas pela forrma como os dados são armazenados. Essa camada facilita a comunicação entre a camada de domínio e a camada de acesso aos dados é feita através de interfaces.

Esses são alguns exemplos de camadas, em alguns projetos é comum encontrar uma camada de "Recursos" que em tese, seria o mesmo que a camada de serviços.
Essas camadas ajudam a organizar e separar as responsabilidades da API, proporcionando uma estrutura clara para o desenvolvimento.  

---

## Considerações finais
Como vimos, a compreensão dos termos, significado das palavras e toda a estruturação de uma API REST contribui para o entendimento correto sobre o que é e como implementar este modelo de software sem muitos sofrimentos.