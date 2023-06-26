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
![BankAcocuntEntity](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/177c42cb-be9d-4b00-bd6b-fbca6751b375)
![SavingAccount](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/f94d4a53-0496-4eef-b4a0-262c617399cb)
![CurrentAccount](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/6a26b648-94fc-4970-b67f-9b2df5d2a526)
![AccountOperationEntity](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/e3688f16-484e-4648-bb2c-cb8ecba18b0d)

-->Enumérations :

![OperationType](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/72034e64-c43e-46a6-a65f-2c0b5babac5d)
![AccountStatut](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/bbb4b34a-2b12-4165-9ff0-0cfc7869fac1)

-->Exceptions :

![Exception1](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/2fed12ce-5791-4107-a2a0-9193661cc270)
![Exception2](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/122aa62a-9edf-498b-a045-757f29bf669d)
![Exception3](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/5997073a-afca-4841-a942-007e4a974b8f)

-->Repositories :

![CustomerRep](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/4b636553-3f77-4c9a-829e-eb5dd8ebf0c0)
![BankAccountRep](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/d6ee0161-3589-48e2-b160-a2c936f88358)
![AccountOperationRep](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/8c81c981-f478-4637-bd75-59090f721741)

-->DTOS :

![BankAccountDTO](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/fb543ac0-1b1a-4318-b508-9c98862b73f8)
![SavingBankAccountDTO](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/3e3cd230-6106-497d-a93c-36fbc83a3a3c)
![CustomerDTO](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/bb8b8b89-e9f2-40b8-a4f3-bb4627914748)
![AccountOperationDTO](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/007621cf-262f-4895-be95-22e75843e908)
![CreditDTO](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/abf61246-9921-4470-b3f2-3d23342d464e)
![DebitDTO](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/4c8936f4-3a48-4aa7-b768-7547d4cbb268)
![TransfertRequestDTO](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/c827b0cd-ccb3-4b1b-b551-f008acf01557)
![AccountHistoryDTOS](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/d2e5bf13-424e-4686-8e22-644fbd23c950)
![AccountOperationDTO](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/032a1530-255b-426f-8dc0-4d9dc73ce3fd)

-->Mappers :

![mappers1](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/07ecd9e8-b9f3-44a5-bbb9-9b866e04192a)
![mappers2](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/f8ca01d7-cfa8-490e-a2d8-f80ad9fc1dc8)

-->Services :

--Interface BankAccountService :

![BankAccountService](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/6f396808-d446-42f1-8468-cc5c97fec6b8)
![BankAccountService2](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/6297e1b3-4f05-4b69-bbd5-f9c58df55888)

--Class BankAccountServiceImpl : 

![Impl1](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/488e34bb-b95e-475a-b961-1f7c5fb20972)
![Impl2](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/b9d2af12-c654-477a-a58c-5585edad3cd2)
![Impl3](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/64c86cd9-fff3-4626-94bc-ecb85cd2d885)
![Impl4](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/3d2770d3-1853-490c-bb3f-c93cfc6f2a03)
![Impl5](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/bb7a4718-7de1-43b2-ba1c-d07a1101c502)
![Impl6](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/cbb45ecf-57aa-44eb-bc24-1da5d43dd85f)
![Impl7](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/a1c2a7a8-a452-400a-9300-58f7405476a2)

-->Rest Controller : 

--Class BankAccountRestAPI :
![RestbankAccount1](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/9c3c9fce-abd9-414f-ae57-65aea8d8af89)
![RestbankAccount2](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/81e3ecc6-aff2-4c33-b4ff-d54f3174aeed)

--Class CustomerRestController :

![RestCustomer](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/272e56c9-3e2a-4467-b4f3-6e2f3cbb908b)
![RestCustomer2](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/de21ea4d-3b6f-4fb6-8b6f-bbd434e41980)

-->Fichier pom.xml :

![pom1](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/504f3019-a0af-459f-8342-2a2ffab7506e)
![pom2](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/12601034-b358-4df3-832e-038c62770bd5)

-->Fichier de configuration application.properties :

![application](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/88bece9d-4757-457d-8c7f-280f3bc7c5b2)


-->Main :

![main1](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/add67c49-cd56-46df-a027-eb99690e3c46)
![main2](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/64156cde-cfcc-4dad-a34e-725fe8a6038b)
![main3](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/4b4dd5e0-a0a2-42f2-a650-50025b0a7798)
![main4](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/6a9ca9fb-5d81-4a0b-8099-4e6ed807fe39)

--> Base de donnée MySQL :

![phpadmin1](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/30fc0be7-f871-4167-9e16-f4083e31df70)
![phpadmin2](https://github.com/Ennia-Fahd/E-Banking/assets/92646945/247fd718-76b5-40ad-a6d3-c98e57896ee0)
































































