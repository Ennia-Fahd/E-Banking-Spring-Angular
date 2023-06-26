![NewCustomer](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/31d41703-f0b7-478f-b184-82bfa5fd26c8)# E-Banking
1- Architecture : 

![architecture](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/ee8362fb-1f27-4758-92bf-60ce58ab721d)

L'architecture d'un projet Digital Banking avec Spring et Angular implique une interaction entre les différentes couches. Le frontend Angular communique avec le backend Java via des requêtes HTTP pour accéder aux fonctionnalités et aux données métier. Le backend utilise des entités, des repositories et des services pour gérer la logique métier et interagir avec la base de données. Les DTOs et les mappers facilitent l'échange de données entre le backend et le frontend. En résumé, le frontend envoie des requêtes au backend, qui les traite en utilisant ses services et repositories, puis renvoie une réponse au frontend. Cette architecture permet une séparation claire des responsabilités et facilite le développement d'une application bancaire numérique.

2- Les interfaces de l'application :

--> Interface Customers :

![Customers](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/193796fc-8001-49fe-a213-b810ab6c041f)

--> Interface Save Customer :

![NewCustomer](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/4c9a556a-20a7-45e3-b8aa-2ca961e166ca)

--> Interface Account :

![AccountCustomer](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/1600d821-d043-4b9a-9373-ef0455853799)

--> Interface Operations :

![Operations](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/1b59e993-4dda-457b-ace1-370829eafe4e)
![Operations2](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/bf82e5a8-8b61-487d-8c37-194343d4ffa7)

Serveur BACKEND 

1-Structure du projet :

![structureprojetbackend](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/bc4f34b9-5cd2-4e92-95f6-762dd5528bdf)

-Entities (Entités) : Les entités représentent les objets métier de l'application et sont utilisées pour représenter les tables de la base de données. Elles contiennent des attributs et des relations qui décrivent les données de l'application.

-Repositories (Répertoires) : Les repositories sont utilisés pour l'accès aux données. Ils fournissent des méthodes permettant d'effectuer des opérations CRUD (Create, Read, Update, Delete) sur les entités, facilitant ainsi l'interaction avec la base de données.

-DTOs (Data Transfer Objects) : Les DTOs sont utilisés pour transférer des données entre les différentes couches de l'application. Ils permettent de structurer et de transférer uniquement les données nécessaires, améliorant ainsi les performances et la sécurité.

-Mappers (Mappateurs) : Les mappers sont utilisés pour convertir les objets entre différentes représentations, par exemple entre les entités et les DTOs. Ils facilitent la transformation des données en effectuant des opérations de mapping appropriées.

-Web : La couche Web fournit des composants tels que les RestControllers qui exposent les fonctionnalités de l'application via des API REST. Elle gère les requêtes HTTP entrantes et renvoie les réponses appropriées.

-Service : La couche de service contient la logique métier de l'application. Elle traite les opérations complexes, effectue des validations, coordonne l'interaction entre les différentes entités et gère les transactions.

-Exception : Les exceptions sont utilisées pour gérer les erreurs et les situations exceptionnelles dans l'application. Elles permettent de gérer les cas d'échec, d'erreur de validation ou toute autre situation qui nécessite une gestion particulière.

2- Composants :

-->Entities : 

![Customer](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/8dc16693-291e-481e-8272-87b77296bcc8)

Cette classe "CurrentAccount" est une entité qui représente un compte courant dans l'application. Elle est annotée avec "@Entity" et hérite de la classe "BankAccount". La valeur de discrimination ("CA") spécifiée avec "@DiscriminatorValue" est utilisée pour différencier les enregistrements de comptes courants dans la base de données. Elle inclut également un attribut supplémentaire spécifique aux comptes courants, "overDraft" (découvert autorisé).

![BankAcocuntEntity](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/177c42cb-be9d-4b00-bd6b-fbca6751b375)

Cette classe "BankAccount" est une entité qui représente un compte bancaire dans l'application. Elle est annotée avec "@Entity" pour être persistée dans la base de données. Elle contient des attributs tels que "balance" (solde du compte), "Date_createdAt" (date de création), "status" (statut du compte) et est associée à un client via la relation "@ManyToOne". De plus, elle est liée à plusieurs opérations de compte via la relation "@OneToMany" et la propriété "mappedBy".

![SavingAccount](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/f94d4a53-0496-4eef-b4a0-262c617399cb)

Cette classe "SavingAccount" est une entité qui représente un compte d'épargne dans l'application. Elle hérite de la classe "BankAccount" et est annotée avec "@Entity". La valeur de discrimination ("SA") spécifiée avec "@DiscriminatorValue" est utilisée pour distinguer les enregistrements de comptes d'épargne dans la base de données. Elle contient un attribut supplémentaire "interestRate" (taux d'intérêt) spécifique aux comptes d'épargne.

![CurrentAccount](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/6a26b648-94fc-4970-b67f-9b2df5d2a526)

Cette classe "CurrentAccount" est une entité qui représente un compte courant dans l'application. Elle hérite de la classe "BankAccount" et est annotée avec "@Entity". La valeur de discrimination ("CA") spécifiée avec "@DiscriminatorValue" est utilisée pour distinguer les enregistrements de compte courant dans la base de données. Elle contient un attribut supplémentaire "overDraft" (découvert autorisé) spécifique aux comptes courants.

![AccountOperationEntity](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/e3688f16-484e-4648-bb2c-cb8ecba18b0d)

Cette classe "AccountOperation" est une entité qui représente une opération de compte dans l'application. Elle est annotée avec "@Entity" et contient des attributs tels que "operationDate" (date de l'opération), "amount" (montant de l'opération), "description" (description de l'opération) et "type" (type d'opération) qui est une énumération de type "OperationType". Elle est associée à un compte bancaire via la relation "@ManyToOne". L'identifiant de l'opération est généré automatiquement avec l'annotation "@GeneratedValue".

-->Enumérations :

![OperationType](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/72034e64-c43e-46a6-a65f-2c0b5babac5d)
![AccountStatut](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/bbb4b34a-2b12-4165-9ff0-0cfc7869fac1)

Le premier code représente une énumération "AccountStatus" qui définit les différents statuts possibles pour un compte bancaire. Les statuts sont "CREATED" (créé), "ACTIVATED" (activé) et "SUSPENDED" (suspendu). Cette énumération est utilisée pour représenter l'état d'un compte bancaire.

Le deuxième code représente une énumération "OperationType" qui définit les types d'opérations possibles pour un compte bancaire. Les types d'opérations sont "DEBIT" (débit) et "CREDIT" (crédit). Cette énumération est utilisée pour indiquer le type d'une opération effectuée sur un compte bancaire.

-->Exceptions :

![Exception1](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/2fed12ce-5791-4107-a2a0-9193661cc270)
![Exception2](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/122aa62a-9edf-498b-a045-757f29bf669d)
![Exception3](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/5997073a-afca-4841-a942-007e4a974b8f)

-->Repositories :

![CustomerRep](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/4b636553-3f77-4c9a-829e-eb5dd8ebf0c0)
![BankAccountRep](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/d6ee0161-3589-48e2-b160-a2c936f88358)
![AccountOperationRep](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/8c81c981-f478-4637-bd75-59090f721741)

-Le premier code représente une classe d'exception "BalanceNotSufficentException" qui est utilisée lorsque le solde d'un compte bancaire n'est pas suffisant pour effectuer une opération. Elle étend la classe "Exception" et prend un message en paramètre pour décrire l'exception.

-Le deuxième code représente une classe d'exception "BankAccountNotFoundException" qui est utilisée lorsqu'un compte bancaire n'est pas trouvé. Elle étend également la classe "Exception" et prend un message en paramètre pour décrire l'exception.

-Le troisième code représente une classe d'exception "CustomerNotFoundException" qui est utilisée lorsqu'un client n'est pas trouvé. Cette classe étend la classe "Exception" et prend un message en paramètre pour décrire l'exception. Cette exception est une exception surveillée (checked exception) car elle étend directement la classe "Exception".

-->DTOS :

![BankAccountDTO](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/fb543ac0-1b1a-4318-b508-9c98862b73f8)

Cette classe "BankAccountDTO" est un objet de transfert de données (DTO) utilisé pour transférer les informations d'un compte bancaire entre les couches de l'application. Elle est annotée avec "@Data" pour générer automatiquement les méthodes getters et setters. Elle contient un attribut "type" qui représente le type de compte bancaire.

![SavingBankAccountDTO](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/3e3cd230-6106-497d-a93c-36fbc83a3a3c)

Cette classe "SavingBankAccountDTO" est un objet de transfert de données (DTO) spécifique à un compte d'épargne. Elle étend la classe "BankAccountDTO" et contient des attributs supplémentaires tels que "id" (identifiant du compte), "balance" (solde du compte), "Date_createdAt" (date de création du compte), "status" (statut du compte) et "interestRate" (taux d'intérêt du compte). Elle contient également un objet "customerDTO" de type "CustomerDTO" qui représente les informations du client associé au compte, ainsi qu'une liste d'objets "accountOperations" de type "AccountOperation" représentant les opérations effectuées sur le compte.

![CurrentBankAccountDTO](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/fe7bc151-66d3-4477-9267-779391a2b48f)

Cette classe "CurrentBankAccountDTO" est un objet de transfert de données (DTO) spécifique à un compte courant. Elle étend la classe "BankAccountDTO" et contient des attributs supplémentaires tels que "id" (identifiant du compte), "balance" (solde du compte), "Date_createdAt" (date de création du compte), "status" (statut du compte) et "overDraft" (découvert autorisé du compte). Elle contient également un objet "customerDTO" de type "CustomerDTO" qui représente les informations du client associé au compte, ainsi qu'une liste d'objets "accountOperations" de type "AccountOperation" représentant les opérations effectuées sur le compte.

![CustomerDTO](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/bb8b8b89-e9f2-40b8-a4f3-bb4627914748)

Cette classe "CustomerDTO" est un objet de transfert de données (DTO) qui représente les informations d'un client dans l'application. Elle contient des attributs tels que "id" (identifiant du client), "name" (nom du client) et "email" (adresse e-mail du client). Cette classe est utilisée pour transférer les données du client entre les différentes couches de l'application, notamment lors des opérations liées aux comptes bancaires.

![AccountOperationDTO](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/007621cf-262f-4895-be95-22e75843e908)

Cette classe "AccountOperationDTO" est un objet de transfert de données (DTO) qui représente une opération de compte dans l'application. Elle contient des attributs tels que "id" (identifiant de l'opération), "operationDate" (date de l'opération), "amount" (montant de l'opération), "description" (description de l'opération) et "type" (type d'opération) qui est une énumération de type "OperationType". Cette classe est utilisée pour transférer les informations des opérations de compte entre les différentes couches de l'application, telles que la couche de service et la couche de présentation.

![CreditDTO](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/abf61246-9921-4470-b3f2-3d23342d464e)

Cette classe "CreditDTO" est un objet de transfert de données (DTO) utilisé pour représenter les informations d'une opération de crédit dans l'application. Elle contient des attributs tels que "accountId" (identifiant du compte), "amount" (montant du crédit) et "description" (description du crédit). Cette classe est utilisée pour transférer les informations de crédit entre les différentes couches de l'application, notamment lors de la création d'une opération de crédit.

![DebitDTO](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/4c8936f4-3a48-4aa7-b768-7547d4cbb268)

Cette classe "DebitDTO" est un objet de transfert de données (DTO) utilisé pour représenter les informations d'une opération de débit dans l'application. Elle contient des attributs tels que "accountId" (identifiant du compte), "amount" (montant du débit) et "description" (description du débit). Cette classe est utilisée pour transférer les informations de débit entre les différentes couches de l'application, notamment lors de la création d'une opération de débit.

![TransfertRequestDTO](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/c827b0cd-ccb3-4b1b-b551-f008acf01557)

Cette classe "TransferRequestDTO" est un objet de transfert de données (DTO) utilisé pour représenter les informations d'une demande de transfert de fonds dans l'application. Elle contient des attributs tels que "accountSource" (compte source du transfert), "accountDestination" (compte de destination du transfert) et "amount" (montant du transfert). Cette classe est utilisée pour transférer les informations de demande de transfert entre les différentes couches de l'application, notamment lors de la gestion des transferts de fonds.

![AccountHistoryDTOS](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/d2e5bf13-424e-4686-8e22-644fbd23c950)

Cette classe "AccountHistoryDTO" est un objet de transfert de données (DTO) utilisé pour représenter l'historique d'un compte bancaire dans l'application. Elle contient des attributs tels que "accountId" (identifiant du compte), "balance" (solde du compte), "currentPage" (page actuelle de l'historique), "totalPages" (nombre total de pages), "pageSize" (nombre d'éléments par page) et "accountOperationDTOS" (liste des opérations de compte sous forme de "AccountOperationDTO"). Cette classe est utilisée pour transférer les informations de l'historique du compte entre les différentes couches de l'application, notamment lors de l'affichage et de la manipulation de l'historique des opérations de compte.

-->Mappers :

![mappers1](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/07ecd9e8-b9f3-44a5-bbb9-9b866e04192a)
![mappers2](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/f8ca01d7-cfa8-490e-a2d8-f80ad9fc1dc8)

Cette classe "BankAccountMapperImpl" est une classe de mapping qui se charge de convertir les objets des entités (comme "Customer", "SavingAccount", "CurrentAccount", "AccountOperation") en objets DTO correspondants (comme "CustomerDTO", "SavingBankAccountDTO", "CurrentBankAccountDTO", "AccountOperationDTO"), et vice versa. Elle utilise la méthode "copyProperties" de la classe "BeanUtils" pour effectuer la copie des propriétés d'un objet à un autre. Cette classe est utilisée pour assurer la conversion des données entre les entités et les DTOs dans le projet.Voici l'explication de l'utilit" de quelque fonction :

-La fonction "fromCustomer" convertit un objet de l'entité "Customer" en un objet DTO "CustomerDTO". Elle utilise la méthode "copyProperties" pour copier les propriétés de l'objet "Customer" vers l'objet "CustomerDTO".

-La fonction "fromCustomerDTO" effectue l'opération inverse en convertissant un objet DTO "CustomerDTO" en un objet de l'entité "Customer". Elle utilise également la méthode "copyProperties" pour copier les propriétés de l'objet "CustomerDTO" vers l'objet "Customer".

-La fonction "fromSavingBankAccountDTO" convertit un objet DTO "SavingBankAccountDTO" en un objet de l'entité "SavingAccount". Elle copie les propriétés de l'objet DTO vers l'objet de l'entité et utilise la fonction "fromCustomerDTO" pour convertir l'objet DTO "CustomerDTO" associé en un objet de l'entité "Customer".

-La fonction "fromSavingBankAccount" effectue l'opération inverse en convertissant un objet de l'entité "SavingAccount" en un objet DTO "SavingBankAccountDTO". Elle copie les propriétés de l'objet de l'entité vers l'objet DTO et utilise la fonction "fromCustomer" pour convertir l'objet associé de l'entité "Customer" en un objet DTO "CustomerDTO".


-->Services :

--Interface BankAccountService :

![BankAccountService](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/6f396808-d446-42f1-8468-cc5c97fec6b8)
![BankAccountService2](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/6297e1b3-4f05-4b69-bbd5-f9c58df55888)

Le package com.example.ebanking.service contient une interface BankAccountService qui définit les opérations de service disponibles dans le système de gestion des comptes bancaires. Ces opérations incluent la création et la gestion des clients, des comptes courants et des comptes d'épargne, les opérations de débit, de crédit et de transfert, l'historique des comptes, etc. Les exceptions BalanceNotSufficentException, BankAccountNotFoundException et CustomerNotFoundException sont lancées en cas d'erreurs spécifiques lors de l'exécution de ces opérations.

--Class BankAccountServiceImpl : 

![Impl1](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/488e34bb-b95e-475a-b961-1f7c5fb20972)
![Impl2](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/b9d2af12-c654-477a-a58c-5585edad3cd2)
![Impl3](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/64c86cd9-fff3-4626-94bc-ecb85cd2d885)
![Impl4](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/3d2770d3-1853-490c-bb3f-c93cfc6f2a03)
![Impl5](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/bb7a4718-7de1-43b2-ba1c-d07a1101c502)
![Impl6](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/cbb45ecf-57aa-44eb-bc24-1da5d43dd85f)
![Impl7](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/a1c2a7a8-a452-400a-9300-58f7405476a2)

Le code fourni est une implémentation de l'interface BankAccountService dans la classe BankAccountServiceImpl. Cette classe fournit des fonctionnalités pour gérer les opérations liées aux comptes bancaires, y compris la création de clients, de comptes courants et de comptes d'épargne, les opérations de débit, de crédit et de transfert, la récupération des informations sur les comptes, l'historique des opérations, etc. Elle utilise également les repositorires CustomerRepository, BankAccountRepository et AccountOperationRepository pour accéder aux données persistantes.Voici l'explication de quelque fonction impléménté par cette classe :

-saveCustomer(CustomerDTO customerDTO): Cette fonction enregistre un nouveau client en utilisant les informations fournies dans l'objet CustomerDTO. Elle convertit l'objet DTO en entité Customer, le sauvegarde dans le référentiel customerRepository et renvoie une représentation DTO du client sauvegardé.

-saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId): Cette fonction crée un nouveau compte courant avec le solde initial, la limite de découvert et l'identifiant du client donnés. Elle récupère d'abord l'entité Customer correspondante à partir du référentiel customerRepository, puis crée un nouvel objet CurrentAccount avec les valeurs fournies. Le compte courant est ensuite sauvegardé dans le référentiel bankAccountRepository et une représentation DTO du compte sauvegardé est renvoyée.

-debit(String accountId, double amount, String description): Cette fonction effectue une opération de débit sur un compte bancaire donné. Elle récupère d'abord l'entité BankAccount correspondante à partir du référentiel bankAccountRepository. Ensuite, elle crée une nouvelle opération de compte avec le type de débit, le montant et la description spécifiés, et l'associe au compte bancaire. L'opération est sauvegardée dans le référentiel accountOperationRespository et le solde du compte est mis à jour en déduisant le montant.

-->Rest Controller : 

--Class BankAccountRestAPI :

![RestbankAccount1](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/9c3c9fce-abd9-414f-ae57-65aea8d8af89)
![RestbankAccount2](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/81e3ecc6-aff2-4c33-b4ff-d54f3174aeed)

Le code fourni est une classe BankAccountRestAPI qui expose des points de terminaison (endpoints) pour l'API REST liée aux opérations bancaires. Voici une brève explication des principales fonctions de cette classe :

1-getBankAccount(String accountId): Cette fonction est associée à la requête GET "/accounts/{accountId}" et renvoie les informations d'un compte bancaire spécifié par son identifiant.

2-listAccounts(): Cette fonction est associée à la requête GET "/accounts" et renvoie la liste de tous les comptes bancaires enregistrés.

3-getHistory(String accountId): Cette fonction est associée à la requête GET "/accounts/{accountId}/operations" et renvoie l'historique des opérations effectuées sur un compte bancaire spécifié.

4-getAccountHistory(String accountId, int page, int size): Cette fonction est associée à la requête GET "/accounts/{accountId}/pageOperations" et renvoie l'historique des opérations d'un compte bancaire spécifié, avec une pagination personnalisée.

debit(DebitDTO debitDTO): Cette fonction est associée à la requête POST "/accounts/debit" et effectue un débit sur un compte bancaire spécifié, en déduisant le montant spécifié.

5-credit(CreditDTO creditDTO): Cette fonction est associée à la requête POST "/accounts/credit" et effectue un crédit sur un compte bancaire spécifié, en ajoutant le montant spécifié.

6-transfer(TransferRequestDTO transferRequestDTO): Cette fonction est associée à la requête POST "/accounts/transfer" et effectue un transfert d'argent entre deux comptes bancaires, en débitant le compte source et en créditant le compte de destination.

7-getBankAccountCustomer(String customerId): Cette fonction est associée à la requête GET "/accounts/customer/{customerId}" et renvoie la liste des comptes bancaires associés à un client spécifié par son identifiant.

Ces fonctions permettent d'interagir avec les opérations bancaires via des requêtes HTTP et de fournir les résultats correspondants aux clients qui utilisent l'API.

--Class CustomerRestController :

![RestCustomer](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/272e56c9-3e2a-4467-b4f3-6e2f3cbb908b)
![RestCustomer2](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/de21ea4d-3b6f-4fb6-8b6f-bbd434e41980)

Le code fourni est une classe CustomerRestController qui expose des points de terminaison (endpoints) pour l'API REST liée à la gestion des clients bancaires. Voici une brève explication des principales fonctions de cette classe :

1-customers(): Cette fonction est associée à la requête GET "/customers" et renvoie la liste de tous les clients enregistrés.

2-searchCustomers(String keyword): Cette fonction est associée à la requête GET "/customers/search" et renvoie la liste des clients correspondant à un mot-clé spécifié.

3-getCustomer(Long customerId): Cette fonction est associée à la requête GET "/customers/{id}" et renvoie les informations d'un client spécifié par son identifiant.

4-saveCustomer(CustomerDTO customerDTO): Cette fonction est associée à la requête POST "/customers" et enregistre un nouveau client en utilisant les informations fournies.

5-updateCustomer(Long customerId, CustomerDTO customerDTO): Cette fonction est associée à la requête PUT "/customers/{customerId}" et met à jour les informations d'un client spécifié par son identifiant en utilisant les nouvelles informations fournies.

6-deleteCustomer(Long id): Cette fonction est associée à la requête DELETE "/customers/{id}" et supprime un client spécifié par son identifiant.

Ces fonctions permettent de gérer les opérations liées aux clients bancaires via des requêtes HTTP et de fournir les résultats correspondants aux clients qui utilisent l'API.

-->Fichier pom.xml :

![pom1](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/504f3019-a0af-459f-8342-2a2ffab7506e)
![pom2](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/12601034-b358-4df3-832e-038c62770bd5)

Les dépendances indiquées dans le code XML sont utilisées dans un projet Spring Boot avec des fonctionnalités spécifiques. Voici une brève explication des principales dépendances utilisées :

1-spring-boot-starter-data-jpa: Cette dépendance permet l'intégration de JPA (Java Persistence API) pour l'accès aux données et la gestion des entités.

2-spring-boot-starter-web: Cette dépendance fournit les fonctionnalités nécessaires pour développer des applications web avec Spring Boot, y compris le serveur web embarqué.

3-spring-boot-devtools: Cette dépendance fournit des outils de développement pour le rechargement automatique des modifications et une expérience de développement plus rapide.

4-mysql-connector-j: Cette dépendance permet la connexion à une base de données MySQL en utilisant le connecteur JDBC.

5-lombok: Cette dépendance simplifie le développement en générant automatiquement du code boilerplate tel que les accesseurs et les constructeurs.

6-springdoc-openapi-ui: Cette dépendance permet de générer automatiquement une documentation API basée sur OpenAPI (anciennement Swagger) et fournit une interface utilisateur pour explorer et tester l'API.

7-spring-boot-starter-test: Cette dépendance fournit les outils et les bibliothèques nécessaires pour écrire des tests unitaires et d'intégration dans les applications Spring Boot.

8-hibernate-validator: Cette dépendance fournit la validation des contraintes sur les objets métier en utilisant les annotations de validation de Hibernate.

Ces dépendances sont utilisées pour faciliter le développement d'une application Spring Boot avec des fonctionnalités telles que l'accès aux données, le développement web, la documentation de l'API et la validation des données.

-->Fichier de configuration application.properties :

![application](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/88bece9d-4757-457d-8c7f-280f3bc7c5b2)

Le code de configuration de l'application Spring Boot que vous avez partagé contient des propriétés essentielles pour la connexion à une base de données MySQL, la gestion du schéma et d'autres paramètres de l'application. Par exemple, la propriété spring.datasource.url définit l'URL de connexion à la base de données, tandis que spring.jpa.hibernate.ddl-auto spécifie le mode de gestion du schéma. De plus, la propriété server.port indique sur quel port le serveur web intégré écoutera les requêtes. Ces propriétés sont cruciales pour garantir une configuration adéquate de l'application et assurer son bon fonctionnement.

-->Main :

![main1](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/add67c49-cd56-46df-a027-eb99690e3c46)
![main2](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/64156cde-cfcc-4dad-a34e-725fe8a6038b)
![main3](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/4b4dd5e0-a0a2-42f2-a650-50025b0a7798)
![main4](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/6a9ca9fb-5d81-4a0b-8099-4e6ed807fe39)

Le code fourni est l'implémentation de la classe principale EBankingApplication dans une application Spring Boot. Cette classe contient une méthode main qui démarre l'application. De plus, elle définit deux méthodes commandLineRunner annotées avec @Bean, qui sont exécutées au démarrage de l'application.

La première méthode commandLineRunner utilise le service BankAccountService pour créer des clients, des comptes courants et des comptes d'épargne, et effectue des opérations de crédit et de débit sur ces comptes à des fins de test.

La deuxième méthode start utilise les référentiels CustomerRepository, BankAccountRepository et AccountOperationRepository pour créer des clients, des comptes courants et des comptes d'épargne en utilisant des entités de base de données. Elle effectue également des opérations de crédit et de débit sur les comptes créés.

Ces méthodes CommandLineRunner permettent de pré-remplir la base de données avec des données de test lors du démarrage de l'application. Cela facilite le développement et les tests.

--> Base de donnée MySQL :

![phpadmin1](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/30fc0be7-f871-4167-9e16-f4083e31df70)
![phpadmin2](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/247fd718-76b5-40ad-a6d3-c98e57896ee0)
![phpmyadmin3](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/25686b3a-a4d2-49df-9ddd-3cf2fc581f43)



                                                        Partie FRONT-END avec ANGULAR

1-Architecture Angular :

![architectureAngular](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/f1e9b884-3381-46c7-ba40-cac36e5ff0f9)


2- Strcuture d'un projet Angular :

![structureAngular](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/e45fc1aa-748a-4d98-97ac-8eaae7ed6a62)


---Fichier package.json ----

![packagejson](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/6e74d9cc-ca30-4365-9286-accfb22afea9)

---Fichier angular.json ----

![angularjson1](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/0ee09d0c-cef0-4116-853b-62740dfe9cae)

---app.component.html ----

![apphtml](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/59f5964a-16a0-4024-a4eb-ff7370ab9824)

---app.component.ts ----

![appts](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/9eb9f50d-8d85-4757-b17c-7d0142437d00)

---app-module.ts ----

![appmodule](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/23dd02c5-c993-4f2d-8fa9-b094ee9a0644)

---app-routing.module.ts ----

![approute](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/2cc68e64-a1e8-4da7-b263-483d68beb41c)


3-Variables d'Environnement :

![environement](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/cdd1cd37-d30c-4670-9086-1bcc9d9e3ee6)


4-Models :

![Customer](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/3eb3d3b2-2748-458d-87b9-ae9706e1f041)
![BankAccount](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/2e59eee2-7161-4548-aa84-efbcc265b2c9)
![accountdetail](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/0a60757f-6fc7-45de-af0c-29891589fe32)
![AccountOperation](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/78830dcf-9368-4a3d-883f-493f5f163803)


5-Services :

-accounts-service.ts :

![serviceaccount1](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/1f20eebf-933f-45bb-9e99-2e89bd98c6c1)
![serviceaccount2](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/83693a9c-8b8e-4a45-bfa7-e1befa9d9e04)

-customer-service.ts

![Customerservice](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/a65fa627-4cd9-4943-b8da-14a71b2f984f)


6-Les Composants :

--Explication : 



-->Navbar :

-navbar.component.html :

![navbarhtml](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/cd454407-e426-4fd3-8b6f-08fe26073d13)

-->Customers :

-customers.component.html :

![customerhtml1](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/410921ef-86d9-4a54-87eb-37eb59654297)
![customerhtml2](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/58e70788-10ce-445f-b11e-7a38c0d7fdc6)

-customers.component.ts :

![customerts1](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/fa3f4bca-5361-46dc-ad19-bba9e07f8441)
![customerts2](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/41756e54-cd26-44c6-a8e1-3a4265ee29f6)

-->New-Customer :

-new-customer.component.html :

![new-customerhtml](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/50ab5e39-acea-4774-b664-78a43a686c2b)

-new-customer.component.ts :

![new-customerts](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/8c992395-4e2d-4d07-a4fd-773435665b16)

-->Accounts :

-accounts.component.html :

![accounthtml](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/76139e20-4c90-4256-853f-faf7ae4bd2f1)
![accounthtml2](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/db57f02b-bf88-4c8c-b054-5154f1a831b6)
![accounthtml3](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/27b933b4-9c07-48ee-8781-b9d4a38b52a4)

-accounts.component.ts :

![accountts](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/9e1f0bf1-d9aa-408c-be51-ce528373eb2f)
![accountss](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/8561522f-a66f-44b5-85db-833c9e5ffcec)
![accountts2](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/f95884b9-15c9-4a6e-b73d-6a23fa92ad90)

-->Customer-Accounts :

---customer-accounts.component.html :

![accountcustomerhtml](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/ccd0fceb-ffac-4148-87ad-18a55707f459)

---customer-accounts.component.ts :

![accounts](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/a6bbcb8e-4f4d-4a2e-9ef1-d5ac056a4af1)



































































































