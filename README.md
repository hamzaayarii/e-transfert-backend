# E-Trade - Backend Microservices

## 🚀 Description

Backend microservices pour la plateforme E-Trade de gestion des transferts bancaires internationaux. Architecture basée sur Spring Boot avec Spring Cloud pour la gestion des microservices.

## 🏗️ Architecture

### Microservices

- **config-server** (Port 8888) - Serveur de configuration centralisé
- **eureka-server** (Port 8761) - Service discovery et registry
- **api-gateway** (Port 9000) - Point d'entrée unique pour toutes les API
- **auth-service** (Port 8081) - Authentification et gestion des utilisateurs
- **user-service** (Port 8082) - Gestion des utilisateurs et profils
- **appointment-service** (Port 8083) - Gestion des rendez-vous
- **transfer-service** (Port 8084) - Gestion des transferts bancaires
- **notification-service** (Port 8085) - Service de notifications

### Module commun

- **common-lib** - Bibliothèque partagée (JWT utils, models communs, etc.)

## 🛠️ Technologies

- **Spring Boot 3.2.4** - Framework principal
- **Spring Cloud** - Microservices infrastructure
  - Eureka - Service discovery
  - Config Server - Configuration centralisée
  - Gateway - Routage et filtrage
- **Spring Security** - Sécurité et JWT
- **PostgreSQL** - Base de données
- **Maven** - Gestion des dépendances
- **Docker** - Containerisation
- **Kubernetes** - Orchestration (optionnel)

## 🔧 Configuration

### Prérequis

- Java 17+
- Maven 3.6+
- PostgreSQL 12+
- Docker (optionnel)

### Variables d'environnement

Créer un fichier `config-server.env` à la racine :

```env
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/etrade
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=your_password
JWT_SECRET=your_jwt_secret_key
```

## 🚀 Lancement

### Avec Docker Compose (Recommandé)

```bash
# Construire et démarrer tous les services
docker-compose up -d

# Vérifier les logs
docker-compose logs -f

# Arrêter les services
docker-compose down
```

### Sans Docker

Démarrer les services dans l'ordre suivant :

```bash
# 1. Config Server
cd config-server
mvn spring-boot:run

# 2. Eureka Server
cd eureka-server
mvn spring-boot:run

# 3. API Gateway
cd api-gateway
mvn spring-boot:run

# 4. Services métiers (dans n'importe quel ordre)
cd auth-service && mvn spring-boot:run
cd user-service && mvn spring-boot:run
cd appointment-service && mvn spring-boot:run
cd transfer-service && mvn spring-boot:run
cd notification-service && mvn spring-boot:run
```

## 📡 API Endpoints

Toutes les requêtes passent par l'API Gateway (http://localhost:9000)

### Authentification

- `POST /api/auth/register` - Inscription
- `POST /api/auth/login` - Connexion
- `GET /api/auth/me` - Profil utilisateur

### Utilisateurs

- `GET /api/users` - Liste des utilisateurs (Admin)
- `GET /api/users/{id}` - Détails utilisateur
- `PUT /api/users/{id}` - Modifier utilisateur
- `DELETE /api/users/{id}` - Supprimer utilisateur (Admin)

### Rendez-vous

- `GET /api/appointments` - Liste des rendez-vous
- `POST /api/appointments` - Créer un rendez-vous
- `GET /api/appointments/{id}` - Détails rendez-vous
- `PUT /api/appointments/{id}` - Modifier rendez-vous
- `DELETE /api/appointments/{id}` - Annuler rendez-vous

### Transferts

- `GET /api/transfers` - Liste des transferts
- `POST /api/transfers` - Créer un transfert
- `GET /api/transfers/{id}` - Détails transfert
- `PUT /api/transfers/{id}` - Modifier transfert
- `DELETE /api/transfers/{id}` - Supprimer transfert

## 🔐 Sécurité

- **JWT Authentication** - Tokens avec expiration
- **Role-Based Access Control** - CLIENT, CHARGE_CLIENTELE, ADMIN
- **Spring Security** - Protection des endpoints
- **CORS** - Configuration pour le frontend

## 📊 Monitoring

- **Eureka Dashboard** : http://localhost:8761
- **Config Server** : http://localhost:8888
- **API Gateway** : http://localhost:9000

## 🗄️ Base de données

Schémas SQL disponibles dans chaque service :
- `appointment-service/schema.sql`
- `transfer-service/schema.sql`
- `notification-service/schema.sql`

## 🐳 Docker

### Build des images

```bash
# Build toutes les images
docker-compose build

# Build un service spécifique
docker build -t etrade/auth-service ./auth-service
```

### Registry Docker

```bash
# Tag et push vers registry
docker tag etrade/auth-service registry.example.com/etrade/auth-service
docker push registry.example.com/etrade/auth-service
```

## 📝 Structure des projets

```
etrade-microservices/
├── config-server/          # Configuration centralisée
├── eureka-server/          # Service discovery
├── api-gateway/            # Point d'entrée API
├── auth-service/           # Authentification
├── user-service/           # Gestion utilisateurs
├── appointment-service/    # Gestion rendez-vous
├── transfer-service/       # Gestion transferts
├── notification-service/   # Notifications
├── common-lib/             # Bibliothèque partagée
├── docker-compose.yml      # Configuration Docker
└── README.md
```

## 🚀 Déploiement

### Production avec Kubernetes

```bash
# Appliquer les configurations Kubernetes
kubectl apply -f k8s/

# Vérifier les pods
kubectl get pods

# Voir les logs
kubectl logs -f <pod-name>
```

### Variables d'environnement production

- `SPRING_PROFILES_ACTIVE=prod`
- `EUREKA_SERVER_URL=http://eureka-server:8761`
- `CONFIG_SERVER_URL=http://config-server:8888`
- Base de données PostgreSQL externe

## 📞 Support

- Vérifier que PostgreSQL est démarré
- Consulter les logs Eureka pour le registry des services
- Vérifier la configuration dans Config Server
- Tester les endpoints via API Gateway

---

**Version** : 1.0.0  
**Spring Boot** : 3.2.4  
**Java** : 17+  
**Architecture** : Microservices avec Spring Cloud
