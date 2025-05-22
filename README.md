**Membros do Grupo:**
- Octávio Nascimento - 241327
- Udson C B Junior - 244899
- Gustavo de Luca Souza - 241321
- Jorge Felipe Lopes Pereira - 251771
- Renilson Conceição de Luna Junior - 247358

# **Descrição da Arquitetura do projeto \- Avaliação 4**

   No projeto proposto, o grupo se dispôs a desenvolver um aplicativo relacionado à mobilidade urbana no campus. Para organizar melhor a estrutura do sistema, foi adotada a arquitetura em camadas, realizando uma separação entre front-end e back-end. Essa divisão facilita o desenvolvimento independente de cada parte da aplicação. No back-end (aplicação), foi aplicada a arquitetura de microsserviços, permitindo dividir o sistema em partes menores, independentes e especializadas. Essa abordagem agiliza o processo de implementação e manutenção do software, além de oferecer maior escalabilidade e potencial de reutilização dos serviços. Outro fator relevante foi a resiliência proporcionada por essa arquitetura, pois falhas em um serviço específico não comprometem o funcionamento do sistema como um todo. No front-end (camada de aplicação), optamos por utilizar o framework React, que facilita a construção de interfaces de usuário.
  
   Com isso em mente, foram desenvolvidos diagramas C4 dos níveis 1 a 3 como parte do processo, que, alinhados aos requisitos, representam o sistema em diferentes níveis de detalhamento. O diagrama de Nível 3, em particular, demonstra um aplicativo minimamente funcional — ou seja, um aplicativo que permite ao usuário fazer login, solicitar e devolver uma bicicleta. As funcionalidades básicas do aplicativo foram organizadas e categorizadas como componentes do diagrama, conforme detalhado a seguir.



![C1](https://github.com/user-attachments/assets/85ab0682-fe56-4640-aacc-3f472aa465fa)


  
![C2](https://github.com/user-attachments/assets/5269443b-3085-46ad-9821-ae382d9c0db0)


  
![C4final](https://github.com/user-attachments/assets/b215f4d0-7ab2-44c2-8a47-69c2e3e228d7)

**Descrição dos componentes**

* **Controle de acesso a conta**
  
	A estrutura de acesso ao aplicativo visa a utilização do sistema de autenticação da Unicamp para validar o acesso apenas de estudantes, professores e trabalhadores da universidade, visando garantir o uso da comunidade.
	Após a permissão, o usuário deve ser redirecionado para a tela inicial em que será possível ver possíveis bikes disponíveis a serem emprestadas.
	Trata-se portanto de um sistema de controle e validação de quem tem acesso ao aplicativo e consequentemente as bicicletas.

* **Sistema de checagem**
  
  O sistema de checagem é uma série de verificações que ocorrem após o pedido de empréstimo feito no aplicativo.
	Ele deve verificar se o usuário possui saldo para efetuar o empréstimo de uma bike pelos 5 minutos iniciais. Verifica também se no caso de já ter efetuado empréstimo anteriormente, o usuário utilizou todo seu saldo e ficou devendo para o banco do aplicativo.
	Esse sistema coordena junto com o sistema de liberação a fim de analisar se pode ocorrer a liberação da bicicleta ou não.

* **Controle de liberação**

  No sistema, o usuário deve ser capaz de selecionar uma bicicleta e solicitar sua liberação do bicicletário, utilizando o sistema de checagem para verificar a possibilidade de liberação. 
  Após o serviço de checagem, ocorre a liberação da bicicleta selecionada e por fim a atualização do banco de dados contendo todas as informações dos bicicletários e suas correspondentes bicicletas.

* **Controle de devolução**

  O usuário solicita a devolução da bicicleta. Inicialmente, ele o faz por meio do escaneamento do QRcode dela e do bicicletário correspondente. Por fim a bike é posta no local sinalizado e o banco de dados do sistema do bicicletário atualizado.




# **Padrões de Projeto**

Para lidar com problemas comuns de implementação e auxiliar na organização e na facilidade de manutenção, o grupo elencou alguns padrões de projeto:

* **Singleton (Padrão Criacional):**

Será utilizado para garantir que exista apenas uma instância do usuário ativo durante a execução do sistema. Essa instância será criada e armazenada no componente principal da aplicação, permitindo que outras partes do sistema acessem e manipulem o estado do usuário de forma centralizada e controlada.

* **Facade (Padrão Estrutural):**

Esse padrão será adotado para encapsular e simplificar interações com subsistemas complexos, como os serviços de autenticação, checagem e liberação de bicicletas. A ideia é fornecer uma interface unificada e mais simples para o front-end interagir com esses processos, ocultando a complexidade das implementações internas.

* **Observer (Padrão Comportamental):**

Será utilizado para permitir que componentes do sistema sejam notificados automaticamente sobre mudanças em determinados estados, como a disponibilidade de bicicletas ou o saldo do usuário. Isso melhora a reatividade da interface e mantém os dados sempre atualizados para o usuário.

* **Mediator (Padrão Comportamental):**

Esse padrão será empregado para coordenar a comunicação entre diferentes componentes de forma centralizada. Em vez de permitir que componentes se comuniquem diretamente entre si, o *Mediator* gerencia essa interação, reduzindo o acoplamento e aumentando a coesão da aplicação. Um exemplo prático de uso será a criação de uma classe mediadora responsável por intermediar a comunicação entre uma classe de tratamento e exibição de dados na interface e uma classe DAO, responsável pelo acesso e modificação de dados no banco. Essa abordagem centraliza a lógica de interação entre as partes, promovendo maior organização interna e complementando a arquitetura de microsserviços definida pelo grupo.


# **Aplicação: Padrão de Projeto "Mediator"**

Para a implementação do componente do Sistema Bicicletário, foi adotada uma abordagem orientada a objetos, priorizando encapsulamento e baixo acoplamento entre os elementos do sistema. O padrão de projeto Mediator foi aplicado para centralizar a comunicação entre os objetos, eliminando dependências diretas e facilitando a manutenção. A arquitetura é composta por três principais responsabilidades: intermediação das operações, acesso a dados e tratamento para exibição. A classe intermediadora coordena as interações entre os componentes, promovendo desacoplamento. A classe de acesso a dados encapsula a persistência e recuperação de informações, enquanto a classe de tratamento para exibição formata os dados para apresentação, mantendo-se isolada das regras de negócio. Essa organização garante que cada componente seja coeso e encapsulado, resultando em uma estrutura modular e alinhada as arquiteturas delimitadas.
