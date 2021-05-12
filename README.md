# spaceinvaders

TP du jeu Space Invaders fait avec la méthode TDD.

# Sommaire

- [Semaine 1 : 28/04/2021 au 5/05/2021](#Semaine1)
- [Glossaire](#glossaire)

# Semaine 1 <a id="Semaine1"></a>

## Fonctionnalité 2

- Sprint n°1.1 : Positionner un nouveau vaisseau avec une dimension donnée

- Sprint n°1.2 : Faire en sorte qu'il soit impossible de positionner un nouveau vaisseau qui déborde de l'espace de jeu

### Diagramme de classe

![S1_DiagrammeDeClasse](/spaceInvaders/images/S1_modelUcls.png)

### Nuage de mots

![S1_NuageDeMots](/spaceInvaders/images/S1_CodeWordCloud.png)

### Difficultés rencontrées

Aucune

### Sprints et fonctionnalités réalisées

# Semaine 1 <a id="Semaine1"></a>

## Fonctionnalité 1

### Sprints et fonctionnalités réalisées

- Sprint n°1.1 : Créer un espace de jeu
  Un espace de jeu est créé aux dimensions données (2D) Cet espace de jeu est vide

- Sprint n°1.2 : Positionner un nouveau vaisseau dans l’espace de jeu
  Un nouveau vaisseau est créé Le vaisseau est positionné aux coordonnées transmises Si un nouveau vaisseau essaye d’être positionné en dehors des limites de l’espace jeu, alors une exception devra être levée. Contraintes : La position souhaitée est transmise par ses coordonnées x et y. Le coin supérieur gauche de l’espace jeu (point en haut à gauche) a pour coordonnées (0,0) La taille du vaisseau est réduite pour l'instant à son minimum (1 seul point)

- Sprint n°1.3 : Déplacer le vaisseau vers la droite dans l'espace de jeu
  Le vaisseau se déplace d'un pas vers la droite Si le vaisseau se trouve sur la bordure droite de l'espace de jeu, le vaisseau doit rester immobile (aucun déplacement, aucune exception levée : le vaisseau reste juste à sa position actuelle).

- Sprint n°1.4 : Déplacer le vaisseau vers la gauche dans l'espace de jeu
  Le vaisseau se déplace d'un pas vers la gauche Si le vaisseau se trouve sur la bordure gauche de l'espace de jeu, le vaisseau doit rester immobile (aucun déplacement, aucune exception levée : le vaisseau reste juste à sa position actuelle).

### Diagramme de classe

![S1_DiagrammeDeClasse](/spaceInvaders/images/S1_modelUcls.png)

### Nuage de mots

![S1_NuageDeMots](/spaceInvaders/images/S1_CodeWordCloud.png)

### Difficultés rencontrées

Aucune

### Remarques diverses

Pour pouvoir, mettre en place les tests, il a été nécessaire d’ajouter une fonctionnalité supplémentaire qui permet de représenter l’espace de jeu dans une chaîne ASCII.

# Glossaire <a   id="glossaire"></a>

- **Vaisseau** : véhicule commandé par le joueur, pouvant se déplacer de droite à gauche et ayant la possibilité de lancer des missiles destinés à détruire le(s) envahisseurs.

- **Envahisseur** : ennemi qui apparaît à l'écran, se déplace automatiquement et qui doit être détruit par un missile lancé depuis le vaisseau du joueur.

- **Missile** : projectile envoyé à la verticale par le vaisseau vers l'envahisseur dans le but de le détruire.
