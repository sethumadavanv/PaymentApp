# PaymentApp — Project Reference

## Stack
- **Backend**: Java 11, Spring Boot 2.7.18, Maven
- **Frontend**: Plain HTML/CSS/JS — no build step, open `frontend/index.html` directly
- **Database**: PostgreSQL 14 (Homebrew), database name `paymentapp`, user `sethuvenkataraman`, no password
- **Target deployment**: AWS Elastic Beanstalk + RDS PostgreSQL, region `ap-southeast-2`

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

## AWS deployment
- CLI configured, account: 312695118270, user: sethu-admin, region: `ap-southeast-2`
- EB CLI installed, app: `paymentapp`, env: `paymentapp-env` (Corretto 11 / Amazon Linux 2023, t3.micro) — **creation in progress**
- RDS instance: `paymentapp-db.cz4gkgek2k6c.ap-southeast-2.rds.amazonaws.com`, db: `paymentapp`, user: `paymentapp`
- `application.properties` updated to use env vars: `DB_URL`, `DB_USERNAME`, `DB_PASSWORD`

## Next steps (pick up here in new session)
1. Wait for `eb create` to finish — check with `eb status`
2. Build the JAR: `cd backend && mvn package -DskipTests`
3. Deploy: `eb deploy`
4. Set env vars in EB so the app connects to RDS:
   ```bash
   eb setenv \
     DB_URL=jdbc:postgresql://paymentapp-db.cz4gkgek2k6c.ap-southeast-2.rds.amazonaws.com:5432/paymentapp \
     DB_USERNAME=paymentapp \
     DB_PASSWORD=<your-rds-password>
   ```
5. Open RDS security group to allow inbound 5432 from the EB instance security group
6. Verify: `eb open` — check `/api/transactions` returns data
