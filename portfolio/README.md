# Rahul Yadav - Portfolio (React + Spring Boot + MySQL)

## Architecture
```
Browser -> Vercel (React/Vite static site)
              | HTTPS, VITE_API_BASE_URL
              v
          Spring Boot API (Render / Railway / any Java host, Docker)
              | JDBC
              v
          Managed MySQL
```
Vercel hosts only the frontend. The Spring Boot backend is deployed separately to a host that runs persistent Java apps.

## Structure
```
portfolio/
  frontend/   React + Vite (src/components, src/services, src/styles, src/data/profile.js, public/)
  backend/    Spring Boot 3.3 / Java 17 (controller, service, repository, entity, dto, exception, config)
              src/main/resources/db/schema.sql + data.sql, Dockerfile, .env.example
  README.md
```
Edit your content in `frontend/src/data/profile.js` (email, LinkedIn, GitHub, experience, education) and seed projects in `backend/src/main/resources/db/data.sql`. Items marked TODO are placeholders: nothing was invented.

**Versions:** Java 17, Maven 3.9+, Node 18+ (20 LTS recommended), MySQL 8.

## API
| Method | Path | Notes |
|---|---|---|
| GET | /api/health | `{"status":"UP"}` |
| GET | /api/skills | list skills |
| GET/POST | /api/projects | list / create (201) |
| GET/PUT/DELETE | /api/projects/{id} | 404 if missing, DELETE returns 204 |
| POST | /api/contact | 201 saved, 400 validation, 429 rate-limited |

Swagger UI: `http://localhost:8080/swagger-ui.html`

Example contact request:
```json
POST /api/contact
{"name":"Asha","email":"asha@example.com","subject":"Opportunity","message":"Hi Rahul, let's talk.","website":""}
```
Response `201`: `{"success":true,"message":"Thank you! Your message has been received."}`
Validation error `400`: `{"status":400,"error":"Validation failed","fieldErrors":{"email":"must be a well-formed email address"}}`

**Important:** `POST/PUT/DELETE /api/projects` are unauthenticated in this version (the site only reads projects). Before deploying publicly, either add Spring Security (e.g. HTTP Basic with credentials from env vars) on those methods or remove them. Do not leave write endpoints open on a public URL.

Spam protection: hidden honeypot field + max messages per IP per hour (`CONTACT_MAX_PER_HOUR`).

## Local setup (Windows)
1. Install: JDK 17 (Temurin), Maven, Node.js LTS, MySQL 8, Git. Verify: `java -version`, `mvn -v`, `node -v`.
2. MySQL (Command Prompt): `mysql -u root -p` then
   ```sql
   CREATE DATABASE portfolio_db CHARACTER SET utf8mb4;
   CREATE USER 'portfolio'@'localhost' IDENTIFIED BY 'choose_a_password';
   GRANT ALL ON portfolio_db.* TO 'portfolio'@'localhost';
   ```
3. Backend (tables and seed data are created automatically on startup):
   ```bat
   cd backend
   set DB_USERNAME=portfolio
   set DB_PASSWORD=choose_a_password
   mvn spring-boot:run
   ```
4. Frontend (new terminal):
   ```bat
   cd frontend
   copy .env.example .env.local
   npm install
   npm run dev
   ```
   Open http://localhost:5173 (API on http://localhost:8080).
5. Test: `curl http://localhost:8080/api/health`, `curl http://localhost:8080/api/projects`, then submit the contact form and check `SELECT * FROM portfolio_db.contact_messages;`.
6. Tests and builds: `cd backend && mvn test && mvn clean package` then `cd ../frontend && npm run build`.

Common fixes: *Access denied for user* -> recheck DB_USERNAME/DB_PASSWORD; *Port 8080 in use* -> `set PORT=8081` and update `VITE_API_BASE_URL`; *CORS error* -> `CORS_ALLOWED_ORIGINS` must exactly match the browser origin (scheme + host, no trailing slash); *Unsupported class version* -> you are not on JDK 17.

## Resume
Put your PDF at `frontend/public/Rahul_Yadav_Resume.pdf` (served at `/Rahul_Yadav_Resume.pdf`). Change the name in `src/data/profile.js` if needed.

## GitHub
```bash
cd portfolio
git init && git add . && git commit -m "Initial portfolio"
git branch -M main
git remote add origin https://github.com/<you>/portfolio.git
git push -u origin main
```

## Deploy backend + database (Render or Railway)
Check the provider's current pricing, free-tier limits and MySQL availability before choosing; they change and some do not offer managed MySQL, in which case use a separate managed MySQL provider and put its host in `DB_URL`.
1. Create a managed MySQL instance; note host, port, database, user, password.
2. Create a web service from your GitHub repo, root directory `backend`, runtime Docker (uses `backend/Dockerfile`).
3. Set environment variables in the dashboard (never in code): `DB_URL` (`jdbc:mysql://HOST:PORT/DBNAME?useSSL=true&serverTimezone=UTC`), `DB_USERNAME`, `DB_PASSWORD`, `CORS_ALLOWED_ORIGINS` (your Vercel URL), optionally `CONTACT_MAX_PER_HOUR`.
4. Deploy; verify `https://<backend-host>/api/health`.

## Deploy frontend (Vercel)
1. Vercel -> Add New Project -> import the GitHub repo.
2. Root Directory: `frontend`. Framework: Vite. Build: `npm run build`. Output: `dist`.
3. Environment variable: `VITE_API_BASE_URL=https://<backend-host>` (no trailing slash). Deploy.
4. Copy the Vercel URL into the backend's `CORS_ALLOWED_ORIGINS` (comma-separate multiple, e.g. a custom domain) and redeploy the backend. Vite env vars are baked in at build time, so redeploy the frontend after changing it.

## Troubleshooting
- **CORS blocked:** origin mismatch or backend not redeployed after changing `CORS_ALLOWED_ORIGINS`.
- **DB connection refused / timeout:** wrong host/port, DB not allowing the backend's network, or SSL settings; read the backend logs.
- **Vercel build fails:** root directory not `frontend`, or Node version below 18.
- **Frontend shows "Could not load projects":** wrong `VITE_API_BASE_URL` or backend asleep/crashed (free tiers may sleep; first request can be slow).
- **500 errors:** check backend logs; the API returns a generic message by design.

## Production checklist
- [ ] `/api/health` returns UP on the live backend
- [ ] Skills and projects load on the live site (no console errors)
- [ ] Contact form submits and the row appears in `contact_messages`
- [ ] Resume downloads
- [ ] Placeholder email/LinkedIn/GitHub/TODO text replaced
- [ ] Write endpoints on /api/projects secured or removed
- [ ] No secrets in the repo; mobile layout checked
