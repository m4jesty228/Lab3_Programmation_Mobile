# Laboratoire 3 – Application Navigation (Android Studio)

**Cours :** Programmation Mobile  
**Date :** 23 Mars 2026  

---

## 1. Introduction

Dans ce troisième laboratoire, j'ai développé une application Android appelée **Navigation**. L'objectif était de créer un formulaire de saisie sur un premier écran, puis d'afficher un récapitulatif des informations saisies sur un deuxième écran en utilisant la navigation entre activités.

L'application contient les fonctionnalités suivantes :
- Saisir les informations d'un contact (Nom & Prénom, Email, Téléphone, Adresse, Ville)
- Valider les champs avant l'envoi
- Naviguer vers un écran de récapitulatif avec les données saisies
- Partager le récapitulatif via email, SMS ou d'autres applications
- Réinitialiser le formulaire au retour sur l'écran principal

---

## 2. Environnement de travail

- **IDE :** Android Studio
- **Langage :** Java
- **Gestion de version :** Git + GitHub (via Git Bash)
- **Émulateur :** Pixel 6 Pro API 36.0

---

## 3. Structure du projet

Le projet suit la structure standard d'un projet Android avec deux activités :

```
Navigation/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/navigation/
│   │       │   ├── MainActivity.java
│   │       │   └── Screen2_Activity.java
│   │       ├── res/
│   │       │   ├── layout/
│   │       │   │   ├── activity_main.xml
│   │       │   │   └── activity_screen2.xml
│   │       │   └── values/
│   │       │       ├── strings.xml
│   │       │       └── themes.xml
│   │       └── AndroidManifest.xml
```

---

## 4. Interface graphique

L'application est composée de deux écrans distincts.

### Écran 1 – Formulaire (activity_main.xml)

Le premier écran est enveloppé dans un `ScrollView` pour permettre le défilement si le clavier prend de la place. À l'intérieur se trouve un `LinearLayout` vertical contenant tous les éléments du formulaire.

- **Nom & Prénom** : champ de saisie texte avec hint indicatif
- **Email** : champ de saisie avec clavier adapté aux adresses email
- **Phone** : champ de saisie numérique adapté aux numéros de téléphone
- **Adresse** : champ de saisie texte pour l'adresse postale
- **Ville** : liste déroulante (`Spinner`) avec plusieurs villes prédéfinies
- **Bouton Envoyer** : déclenche la validation et la navigation vers l'écran 2

L'image ci-dessous montre l'aperçu du formulaire dans Android Studio.

> <img width="1919" height="1129" alt="image" src="https://github.com/user-attachments/assets/5f5746ff-8e0a-482f-83b8-419fb23ef457" />

### Écran 2 – Récapitulatif (activity_screen2.xml)

Le deuxième écran affiche un résumé de toutes les informations saisies dans le formulaire, avec deux boutons : un pour revenir à l'écran précédent et un pour partager le récapitulatif.

## 5. Navigation entre activités

La navigation entre les deux écrans est gérée grâce aux **Intents explicites** d'Android.

### De l'écran 1 vers l'écran 2

Lorsque l'utilisateur clique sur **Envoyer**, un `Intent` est créé pour naviguer de `MainActivity` vers `Screen2_Activity`. Les données du formulaire sont attachées à cet Intent via `putExtra()` sous forme de paires clé/valeur. `Screen2_Activity` les récupère ensuite avec `getStringExtra()`.

### Retour de l'écran 2 vers l'écran 1

Le bouton **Retour** de l'écran 2 appelle simplement `finish()`, ce qui ferme `Screen2_Activity` et revient automatiquement à `MainActivity`.

### Déclaration dans le Manifest

`MainActivity` est déclarée comme point d'entrée de l'application avec un `intent-filter`. `Screen2_Activity` est simplement déclarée sans `intent-filter` car elle n'est accessible que depuis l'intérieur de l'application.

Voici l'application au lancement avec le formulaire vide.

> <img width="959" height="565" alt="image" src="https://github.com/user-attachments/assets/59f47ad2-b071-43b6-8973-12d52416c18d" />

Après avoir rempli les champs et cliqué sur **Envoyer**, l'écran 2 s'affiche avec le récapitulatif des informations.

> <img width="1919" height="1133" alt="image" src="https://github.com/user-attachments/assets/5beadaa8-7540-4a65-a6eb-60b2b9205f53" />


---

## 6. Fonctionnalités supplémentaires

### Validation des champs

Avant de naviguer vers l'écran 2, l'application effectue deux validations :
- Elle vérifie que le **Nom** et l'**Email** ne sont pas vides, et affiche un Toast si c'est le cas.
- Elle vérifie que l'**Email** respecte le format standard grâce à `Patterns.EMAIL_ADDRESS`, et affiche un Toast si le format est invalide.

> Validation du nom et de l'email <img width="1919" height="1128" alt="image" src="https://github.com/user-attachments/assets/b1227c5e-25fa-4868-b83f-7805d98f973f" />
> Validation de l'email <img width="1919" height="1129" alt="image" src="https://github.com/user-attachments/assets/1a2b36b7-51b6-44ad-a33d-17775393b1c1" />


### Réinitialisation du formulaire

La méthode `onResume()` de `MainActivity` est utilisée pour vider tous les champs à chaque retour sur l'écran 1. Cela évite que les données de la saisie précédente restent affichées.

### Partage du récapitulatif

Un bouton **Partager** sur l'écran 2 permet d'envoyer le récapitulatif via n'importe quelle application installée sur l'appareil (email, SMS, WhatsApp, etc.) grâce à un `Intent ACTION_SEND`.

> <img width="1919" height="1128" alt="image" src="https://github.com/user-attachments/assets/6b24e07f-b334-491b-93fc-cbd95629c0c2" />


---

## 7. Mise en ligne sur GitHub

Pour versionner et partager mon projet, j'ai utilisé **Git Bash** de la même façon que pour les laboratoires précédents.

> <img width="888" height="276" alt="image" src="https://github.com/user-attachments/assets/28a14a5a-5d06-4d02-9ed0-3900f9ca8b6f" />

La capture ci-dessus montre le résultat du push dans Git Bash. On peut confirmer que le projet a bien été envoyé sur le repository GitHub sans erreur.

Le projet est accessible à l'adresse suivante :  
🔗 [https://github.com/m4jesty228/Lab3_Programmation_Mobile](https://github.com/m4jesty228/Lab3_Programmation_Mobile)

---

## 8. Résultat final

L'application fonctionne correctement :
- Le formulaire valide bien les champs avant l'envoi.
- La navigation entre les deux écrans fonctionne correctement via les Intents.
- Le récapitulatif affiche bien toutes les informations saisies.
- Le bouton Partager ouvre bien le sélecteur d'applications.
- Le formulaire se réinitialise bien au retour sur l'écran 1.

---
