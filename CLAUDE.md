# PaymentApp — Project Reference

## Stack
- **Backend**: Java 11, Spring Boot 2.7.18, Maven
- **Frontend**: Plain HTML/CSS/JS — no build step, open `frontend/index.html` directly
- **Database**: PostgreSQL 14 (Homebrew), database name `paymentapp`, user `sethuvenkataraman`, no password
- **Target deployment**: AWS Elastic Beanstalk + RDS PostgreSQL, region TBD

## Run locally
```bash
# Start PostgreSQL (if not running)
brew services start postgresql@14

# Start backend
cd backend && mvn spring-boot:run

# Open frontend
open frontend/index.html
```

## API endpoints
| Method | Path | Description |
|--------|------|-------------|
| GET | `/api/transactions` | All transactions |
| POST | `/api/transactions` | Add transaction `{merchant, category, amount, date}` |
| GET | `/api/offers` | Personalised offers ranked by spend category |

## Package structure
```
com.paymentapp
├── controller/   TransactionController, OfferController
├── model/        Transaction (@Entity), Offer, TransactionRequest (DTO)
├── repository/   TransactionRepository (JpaRepository)
└── service/      TransactionService (seeds DB on first run), OfferService
```

## Categories
Shopping, Food, Fuel, Entertainment, Groceries

## Git / GitHub
- Remote: https://github.com/sethumadavanv/PaymentApp
- Branch: main
- Convention: commit + push at end of every session

## AWS (in progress)
- CLI configured, account: 312695118270, user: sethu-admin
- EB CLI installed
- Region: TBD, RDS instance: db.t3.micro
