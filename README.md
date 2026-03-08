# 🔹 Projet 1

## Gestion du Stock 

Application de gestion de stock simple développée avec **Java**, **Maven**, **Hibernate** (JPA) et une base de données relationnelle.

Ce projet fait partie du repository [Hibernate_Ev](https://github.com/IlyassOubaba/Hibernate_Ev) qui regroupe plusieurs petits projets d'apprentissage Hibernate/JPA.

---

## Fonctionnalités principales

- Gestion des produits (ajout, modification, suppression, consultation)
- Suivi des quantités en stock
- Recherche et filtrage des produits
- (potentiellement) gestion des catégories / fournisseurs / entrées-sorties

## Technologies utilisées

---


- **Java** (JDK 17.0.15)
- **Maven** – gestion des dépendances
- **Hibernate**  + **JPA** (persistance)
- Base de données : MySQL  / H2 (configurable via `persistence.xml`)
- Patron **DAO** + entités JPA

---

## Architecture du Projet


<img width="201" height="731" alt="gestioDuStock-Page-2 drawio" src="https://github.com/user-attachments/assets/8404241d-ae1e-49b9-b906-ffeaa78211ce" />



---

## Diagramme de classe

<img width="873" height="400" alt="image" src="https://github.com/user-attachments/assets/fc5df608-c4c9-418c-a69d-87b1f89033a8" />


---

## Video Demo

https://github.com/user-attachments/assets/f4dd0df1-d4d2-43c9-bd37-2093564b14a7

---

## Conclusion

Ce projet de gestion des commandes (produits, catégories, commandes et lignes de commande) a permis de mettre en pratique les concepts fondamentaux de la persistance avec **Hibernate** et **JPA** : 

- Modélisation d’entités avec relations (OneToMany, ManyToOne)
- Implémentation du pattern **DAO**
- Utilisation des services pour organiser la logique métier
- Configuration manuelle via `hibernate.cfg.xml`

Il s’agit d’une base solide pour comprendre le mapping objet-relationnel et les bonnes pratiques de séparation des couches (entity → dao → service).

---

# 🔹 Projet 2

# Gestion de Projets 

Application de gestion de projets et tâches développée avec **Java**, **Hibernate** (JPA) et **Maven**.

---

##  Objectif du projet

Permettre de gérer des projets, tâches, utilisateurs et leurs relations via une couche persistance ORM avec Hibernate.

Fonctionnalités principales (selon implémentation typique) :
  - Créer / modifier / supprimer des **projets**
  - Ajouter / assigner / suivre des **tâches**
  - Gérer des **utilisateurs** / membres / rôles
  - Suivi de l'état d'avancement (To Do → In Progress → Done)
  - Relations entre entités (projet ↔ tâches ↔ utilisateurs)

---

##  Technologies utilisées

- **Java** (JDK 17.0.15)
- **Hibernate** 
- **Maven** (gestion des dépendances)
- Base de données : **MySQL**
- Patron DAO / Service (architecture en couches)
- (éventuellement) : Log4j / SLF4J, JUnit

---

## Architecure du projet

<img width="201" height="731" alt="gestion_projet drawio" src="https://github.com/user-attachments/assets/2f1cc1ff-96e3-4c3d-9e32-2b5ab1dd2469" />





---


## Diagramme de classe

<img width="930" height="449" alt="image" src="https://github.com/user-attachments/assets/269df0f3-ebe6-4ed1-a9b5-39387bba55d4" />

---

## Video Demo

https://github.com/user-attachments/assets/1e3eaa81-b18f-44ba-b3de-b93161e7c0ce

---

## Conclusion

Ce projet de **Gestion de Projets** a permis de mettre en pratique les concepts fondamentaux de la persistance avec **Hibernate / JPA** : mapping objet-relationnel, gestion des relations (OneToMany, ManyToMany), transactions, DAO pattern et architecture en couches.

Il constitue une base solide pour comprendre comment construire une application Java persistante, testable et maintenable.

---

# 🔹 Projet 3

# Gestion d'État Civil 

Application Java de gestion simplifiée d'un registre d'état civil utilisant **Hibernate**, **JPA** et **Maven**.

---

##  Objectif du projet

Ce projet a pour but de mettre en pratique les concepts de **persistance objet-relationnelle** avec Hibernate/JPA à travers la gestion des informations typiques d'un état civil :
  -  Citoyens / Personnes
  -  Naissances, mariages, décès
  - Actes d'état civil
  - Relations familiales (parents, conjoints, enfants)

---

##  Technologies utilisées

- **Java** (JDK 17.0.15) 
- **Maven** (gestion des dépendances)
- **Hibernate** (ORM)
- **JPA** (API standard)
- Base de données : **MySQL** 

---

## Architecture du projet


<img width="201" height="731" alt="gestionEtatCivil drawio" src="https://github.com/user-attachments/assets/08b8ce35-2f3b-47ba-834d-38661f05c753" />




---

## Diagramme de classe

<img width="917" height="328" alt="image" src="https://github.com/user-attachments/assets/f878fd9e-ec34-40e8-986c-2d9b36237c1c" />

---

## Video Demo



https://github.com/user-attachments/assets/138d309d-dedc-4ee4-944a-458725dab38a

---

## Conclusion
Ce petit projet permet de consolider les bases de Hibernate & JPA dans un contexte concret et compréhensible : la gestion d’état civil.
Malgré sa simplicité, il couvre les points essentiels : entités, relations, DAO, transactions, configuration, et peut servir de base solide pour des fonctionnalités plus avancées.

