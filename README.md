**Membros do Grupo:**
- Octávio Nascimento - 241327
- Udson C B Junior - 244899
- Gustavo de Luca Souza - 241321
- Jorge Felipe Lopes Pereira - 251771
- Renilson Conceição de Luna Junior - 247358

# **Descrição da Arquitetura do projeto \- Avaliação 4**

  Como a visão do grupo é de criar um aplicativo, a estrutura de micro serviços parece mais adequada uma vez que ela permite que ele seja separado em partes menores e independentes. Com isso, entendemos que será mais fácil e ágil, não apenas de implementar, mas também de propor manutenção do software. Nossa escolha se dá também pela possibilidade de replicação dos diferentes serviços. Além disso, essa estrutura deve permitir mais independência entre partes, o que minimiza a chance de cair todo o aplicativo quando algum micro serviço cair.
  
  Com isso em mente, foi proposto um diagrama C4-Nível 3 que, alinhado aos requisitos, demonstrasse um aplicativo minimamente funcional. Isto é, um aplicativo em que você consegue fazer login, pedir e devolver um bike. Categorizamos as funcionalidades básicas do aplicativo de forma a serem componentes do diagrama, conforme segue abaixo.
  
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
