# PaymentApp

A payment dashboard that identifies personalised offers based on user spending patterns.

## Stack
- **Backend**: Java 11, Spring Boot 2.7, Maven
- **Frontend**: Plain HTML / CSS / JS (no build step)

## Run locally

### Backend
```bash
cd backend
mvn spring-boot:run
```
API available at `http://localhost:8080`

### Frontend
Open `frontend/index.html` directly in a browser (or serve with any static server).

## API Endpoints
| Method | Path | Description |
|--------|------|-------------|
| GET | `/api/transactions` | List all transactions |
| GET | `/api/offers` | Personalised offers based on spend |

## Roadmap
- [ ] Database integration (PostgreSQL)
- [ ] User authentication
- [ ] Data engineering pipeline
- [ ] AWS deployment
