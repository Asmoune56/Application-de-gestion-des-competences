#  ** Gestion des Compétences *

Cette application est une plateforme de **gestion des compétences et sous-compétences** des apprenants.  
Elle permet aux responsables pédagogiques de :

_ Créer, organiser et suivre les compétences et sous-compétences  
_ Visualiser la progression des apprenants  
_ Evaluer les acquis et identifier les axes à renforcer  
_ Exporter un rapport PDF des sous-compétences.

---

## * Technologies utilisées *

- **Backend** : Spring Boot, Spring Data JPA
- **Base de données** : MySQL / PostgreSQL
- **Test unitaire** : JUnit + Mockito
- **Conteneurisation** : Docker + Docker Compose
- **Documentation API** : Swagger (springdoc-openapi)
- **Génération PDF** : OpenPDF (librepdf)

---

##  Endpoints REST principaux

| Méthode | Endpoint                                     | Description                             |
|---------|----------------------------------------------|----------------------------------------|
| POST    | `/api/competences`                          | Créer une compétence                   |
| GET     | `/api/competences/{id}`                     | Consulter une compétence               |
| PUT     | `/api/competences/{id}`                     | Modifier le nom d'une compétence       |
| DELETE  | `/api/competences/{id}`                     | Supprimer une compétence               |
| POST    | `/api/souscompetences/create/{competenceId}`| Créer une sous-compétence              |
| PUT     | `/api/souscompetences/{id}/validation`      | Modifier validation d'une sous-comp.   |
| GET     | `/api/souscompetences/export/pdf`           | Exporter rapport PDF des sous-comp.    |

---

##  Démarrage rapide (Docker)

### Prérequis
- Docker et Docker Compose installés.

### Lancer l'application
```bash
docker-compose up --build
