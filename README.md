# 🔹 Projet 1

## Gestion du Stock – Application Java Hibernate/JPA

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


- **Java** (JDK 8+ recommandé)
- **Maven** – gestion des dépendances
- **Hibernate** 5/6 + **JPA** (persistance)
- Base de données : MySQL  / H2 (configurable via `persistence.xml`)
- Patron **DAO** + entités JPA

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

