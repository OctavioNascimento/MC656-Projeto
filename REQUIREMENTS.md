**Link Para o Documento**:  https://docs.google.com/document/d/1abp5Ir4CQRUtd0MRCdyvrtQn_ju7IsGtmo3Eod3a51o/edit?usp=sharing



# **Relatório de Elicitação de Requisitos \- Avaliação 3**

**Projeto Unibike**

O projeto visa desenvolver um sistema de software para facilitar o aluguel de bicicletas dentro do campus universitário. O objetivo principal é proporcionar uma alternativa de transporte sustentável, econômica e eficiente para estudantes, professores e funcionários, reduzindo o tempo de deslocamento e contribuindo para a diminuição da pegada de carbono. Os principais recursos incluem acesso às bicicletas, exibição de pontos de retirada e devolução, histórico de uso, reserva antecipada, sistema de notificações e uma funcionalidade de feedback e avaliação.

**Técnicas de Elicitação Utilizadas**

Para levantar os requisitos do sistema, foram utilizadas duas abordagens complementares: questionários e entrevista. O questionário foi aplicado a estudantes do campus, distribuído digitalmente, com o objetivo de identificar necessidades, comportamentos e expectativas quanto ao uso de bicicletas como meio de transporte no ambiente universitário. Já a entrevista foi realizada de forma semiestruturada com um usuário em potencial, permitindo um aprofundamento qualitativo sobre as experiências cotidianas de deslocamento, barreiras percebidas e sugestões sobre o funcionamento ideal do sistema.

Artefatos:

* Entrevista \[INSERIR LINK\]  
* Perguntas do Questionário [FORMS](https://docs.google.com/forms/d/e/1FAIpQLSeRQcyKPFqnpY-IgXjzNFc3VYNZvrNuLtFrYFSOw-rGB-98xw/viewform)
* Dados coletados:  [Dados](https://docs.google.com/spreadsheets/d/14kmSVsC4hAwf595TJ5dRqOlkyThnAUq8kBMgxO37qBo/edit?gid=893485006#gid=893485006)

**Requisitos Funcionais**

* Login com autenticação da Unicamp.  
* Exibir nome e vínculo do usuário.  
* Exibir saldo disponível.  
* Mostrar mapa com bicicletários.  
* Exibir número de bicicletas disponíveis por ponto.  
* Permitir reservas antecipadas.  
* Exibir histórico de uso.  
* Enviar notificações de reserva.  
* Permitir avaliação de bicicletas.

**Requisitos Não Funcionais (RNF)**

* Disponibilidade de 6h00 às 23h59.  
* Disponibilidade dentro da unicamp.  
* Tempo de resposta ≤ 1 min.  
* Compatibilidade com Android.  
* Interface intuitiva.  
* Atualização de dados a cada 1 minuto.  
* Notificações com confiabilidade.

**Épicos e Histórias de Usuário**

Foram enumerados os épicos e as respectivas histórias de usuário extraídas a partir das técnicas de elicitação aplicadas. Cada épico e suas histórias correspondentes foram ou serão cadastrados como issues no GitHub e GitHub Projects.

**Épico 1: Acesso e Autenticação do Usuário**

**História 1.1**

Eu como usuário,  
quero fazer login com minhas credenciais da Unicamp,  
para acessar o sistema com segurança.

Critérios de Aceite:

* Redirecionamento para login institucional.  
* Validação de vínculo ativo.  
* Redirecionamento para a tela principal após login.

**História 1.2**

Eu como usuário autenticado,  
quero ver meu nome e saldo,  
para confirmar que entrei corretamente.

Critérios de Aceite:

* Exibição do nome e saldo na tela principal.  
* Dados vindos da autenticação institucional.

**Épico 2: Localização e Disponibilidade de Bicicletas**

**História 2.1**

Eu como usuário,  
quero visualizar no mapa os bicicletários disponíveis,  
para encontrar o mais próximo.

Critérios de Aceite:

* Exibição de todos os bicicletários no mapa.  
* Uso de geolocalização com permissão do usuário.

**História 2.2**

Eu como usuário,  
quero ver a quantidade de bicicletas em cada ponto,  
para decidir onde retirar uma.

Critérios de Aceite:

* Exibição de quantidade de bicicletas por ponto.  
* Atualização periódica.  
* Indicação clara quando não houver bicicletas.

**Épico 3: Reserva e Uso da Bicicleta**

**História 3.1**

Como usuário,  
quero reservar uma bicicleta com antecedência,  
para garantir disponibilidade.

Critérios de Aceite:

* Reserva para horários futuros.  
* Confirmação de reserva.  
* Bloqueio de reservas em conflito.

**História 3.2**

Como usuário,  
quero ver meu histórico de uso,  
para acompanhar minha atividade.

Critérios de Aceite:

* Listagem de reservas anteriores.  
* Informações de data, horário e local.  
* Filtro por período.

**Épico 4: Notificações e Feedback**

**História 4.1**

Como usuário,  
quero receber notificações sobre a reserva,  
para me planejar melhor.

Critérios de Aceite:

* Email de confirmação, início e fim da reserva.

**História 4.2**

Como usuário,  
quero avaliar a bicicleta usada,  
para contribuir com melhorias.

Critérios de Aceite:

* Avaliação com estrelas e comentário opcional.  
* Registro em banco de dados.

**Épico 5: Back-End**

**História 5.1**

Como desenvolvedor,  
quero integrar com a base da Unicamp (ferramenta existente),  
para autenticar usuários.

Critérios de Aceite:

* Integração com API institucional.  
* Validação apenas de usuários válidos.

Observação: Todas as histórias de usuário estão sendo cadastradas no GitHub com a label "Avaliação A3" e devidamente vinculadas aos respectivos épicos via referência entre issues. O backlog do projeto será ordenado conforme o valor agregado ao usuário, priorizando funcionalidades essenciais nas primeiras entregas.
