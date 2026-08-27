# Personal Finance Tracker

A full-stack expense tracking application with a Java/Spring Boot REST API backend and a React frontend. Supports full CRUD for expenses and categories, with a real one-to-many entity relationship between them.

## Features

- Create, read, update, and delete expenses
- Create and list categories; each expense belongs to a category (many-to-one relationship)
- Category dropdown in the UI (no manual ID entry)
- Partial updates — only modifies fields explicitly included in the request
- Business validation (expense amounts must be greater than zero, category names cannot be blank)
- Automatic timestamp tracking (`createdAt`) via JPA lifecycle hooks
- Centralized exception handling with clean JSON error responses
- Responsive, styled UI built with React

## Tech Stack

**Backend**
- Java 21, Spring Boot, Spring Data JPA / Hibernate
- H2 (in-memory relational database)
- Maven
- JUnit 5 / Mockito for unit testing

**Frontend**
- React (via Vite)
- Vanilla CSS
- Native `fetch` API for backend communication

## Architecture

Backend follows a layered Controller-Service-Repository pattern:
- **Controller** — handles HTTP requests/responses
- **Service** — business logic and validation, including cross-entity lookups (e.g., resolving a category by ID before attaching it to an expense)
- **Repository** — Spring Data JPA interfaces for database operations
- **Model** — JPA entities (`Expense`, `Category`) with a `@ManyToOne` relationship

Frontend is a single-page React app using `useState`/`useEffect` for state and data fetching, with controlled form inputs for creating and editing expenses.

## API Endpoints

| Method | Endpoint          | Description                  |
|--------|-------------------|-------------------------------|
| POST   | `/expenses`       | Create an expense (`?categoryId=`) |
| GET    | `/expenses`       | List all expenses            |
| GET    | `/expenses/{id}`  | Get an expense by ID         |
| PUT    | `/expenses/{id}`  | Update an expense (partial)  |
| DELETE | `/expenses/{id}`  | Delete an expense by ID      |
| POST   | `/categories`     | Create a category            |
| GET    | `/categories`     | List all categories          |
| GET    | `/categories/{id}`| Get a category by ID         |

## Running Locally

**Backend**
1. Open the backend folder in IntelliJ (or any Maven-compatible IDE)
2. Run `PersonalFinanceTrackerApplication.java`
3. API available at `http://localhost:8080`

**Frontend**
1. In the frontend folder, run `npm install` (first time only)
2. Run `npm run dev`
3. App available at `http://localhost:5173`

Both must be running simultaneously for the app to function.

## Testing

### Unit Tests
Core business logic in `ExpenseService` is covered by unit tests using JUnit 5 and Mockito, with both `ExpenseRepository` and `CategoryRepository` mocked to test logic in isolation. Tests cover:
- Exception handling when a referenced category does not exist
- Successful expense creation with correct category attachment

Run tests via IntelliJ's built-in test runner (right-click the test class or method → Run).

### Manual Testing
Backend endpoints were manually tested via Postman throughout development. The full CRUD flow (create, read, update, delete) was also manually verified end-to-end through the live React UI.

## Planned Improvements

- Budget tracking per category
- Data visualization (spending by category/time)
- Bank sync integration (e.g., via Plaid) for automatic transaction import
- Deployment (frontend on Vercel, backend on a persistent-database host)

## Author

Al-Farouq Mohamed — Incoming CS Freshman, Virginia Tech
https://github.com/alfarouq18