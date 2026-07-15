package app.rohangautam.cliportfolio.backend.service.impl;

/*
  =============================================================================
                              API SERVICE LAYER
  =============================================================================

  This file is the ONLY communication layer between the React frontend and the
  Spring Boot backend.

  Architecture
  ------------
  UI Components
         │
         ▼
  useTerminal() / Hooks
         │
         ▼
  apiService (THIS FILE)
         │
         ▼
  Axios HTTP Client
         │
         ▼
  Spring Boot REST Controllers


  Every backend endpoint should have ONE matching function here.
  Components should NEVER call axios directly.


  =============================================================================
  HOW TO ADD A NEW BACKEND FEATURE
  =============================================================================

  Example:

  Spring Boot
  -----------------------------------
  @GetMapping("/api/achievements")
 * public List<AchievementDto> getAchievements() { ... }
 *
 *
 * Step 1. Create a TypeScript interface
 *
 * export interface AchievementResponse {
 *   title: string;
 *   year: string;
 *   description: string;
 * }
 *
 *
 * Step 2. Add an optional cache
 *
 * let achievementsCache: AchievementResponse[] | null = null;
 *
 *
 * Step 3. Create an API method
 *
 * getAchievements: async (): Promise<AchievementResponse[]> => {
 *   if (achievementsCache) {
 *     console.log("[API Cache] Serving achievements from memory.");
 *     return achievementsCache;
 *   }
 *
 *   console.log("[API Fetch] GET /api/achievements");
 *
 *   const response = await client.get<AchievementResponse[]>("/api/achievements");
 *
 *   achievementsCache = response.data;
 *   return response.data;
 * }
 *
 *
 * Step 4. Call it anywhere
 *
 * const data = await apiService.getAchievements();
 *
 *
 * =============================================================================
 * WHY USE THIS PATTERN?
 * =============================================================================
 *
 * ✓ One place to change API URLs.
 * ✓ One place for authentication headers.
 * ✓ One place for caching.
 * ✓ Prevents duplicate HTTP requests.
 * ✓ Keeps React components clean.
 * ✓ Makes adding new backend controllers take only a few minutes.
 *
 *
 * =============================================================================
 * RULES
 * =============================================================================
 *
 * • Never call axios from React components.
 * • Every REST endpoint gets one function here.
 * • Add interfaces in types.ts.
 * • Cache read-only endpoints whenever possible.
 * • Keep HTTP logic here and UI logic inside components/hooks.
 *
 * This file should grow alongside the backend. Whenever a new controller is
 * created in Spring Boot, simply expose a new function here and the rest of
 * the frontend can consume it through apiService.
 * =============================================================================
 */

import app.rohangautam.cliportfolio.backend.dto.*;
import app.rohangautam.cliportfolio.backend.service.PortfolioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Override
    public ProfileResponse getProfile() {
        return new ProfileResponse(
                "Rohan Gautam",
                "Backend Developer",
                "Java & Spring Boot backend engineer, building things that ship.",
                "Bhopal, India",
                "rohangautam.bee@gmail.com",
                "+91-7804016050",
                "CS graduate from VIT Bhopal building production backends with Spring Boot. " +
                        "Currently interning at Geoco building their e-commerce platform from the ground up, " +
                        "while chasing an MS in Germany on the side. Off the keyboard: skydiving, boxing, " +
                        "calisthenics, and solo travel.",
                "https://rohangautam.app/resume.pdf",
                "https://github.com/Rohan-Gautam",
                List.of(
                        new ProfileResponse.EducationEntry(
                                "VIT Bhopal University",
                                "B.Tech, Computer Science & Engineering",
                                "Bhopal, Madhya Pradesh",
                                "Sep 2022 - Sep 2026",
                                "8.62 CGPA",
                                List.of("OOP", "Data Structures & Algorithms", "DBMS", "Operating Systems",
                                        "Computer Networks", "Software Engineering")
                        )
                ),
                List.of(
                        new ProfileResponse.SocialLink("GitHub", "https://github.com/Rohan-Gautam", "Rohan-Gautam"),
                        new ProfileResponse.SocialLink("LinkedIn", "https://linkedin.com/in/rohan-gautam-b33695250", "rohan-gautam-b33695250"),
                        new ProfileResponse.SocialLink("Email", "mailto:rohangautam.bee@gmail.com", "rohangautam.bee@gmail.com")
                ),
                new ProfileResponse.NeofetchInfo(
                        "VIT-Bhopal-OS",
                        "rohan@backend-dev",
                        "spring-boot",
                        "3+ yrs coding",
                        List.of("Java", "Python", "SQL", "JavaScript"),
                        List.of("System Design", "Skydiving", "Boxing", "Calisthenics", "Travel")
                )
        );
    }

    @Override
    public List<SkillResponse> getSkills() {
        return List.of(
                new SkillResponse("Languages", List.of("Java", "Python", "SQL", "JavaScript")),
                new SkillResponse("Frameworks & Libraries", List.of(
                        "Spring Boot", "Spring Security", "Spring Data JPA", "Lombok", "Spring Validation")),
                new SkillResponse("Databases", List.of("PostgreSQL", "MySQL", "Redis", "Database Design & Query Optimization")),
                new SkillResponse("Security", List.of(
                        "JWT Authentication", "OAuth 2.0", "Role-Based Access Control", "DTO Validation")),
                new SkillResponse("Tools & DevOps", List.of(
                        "Git", "Gradle", "Maven", "Docker", "Postman", "CI/CD", "Render", "Vercel")),
                new SkillResponse("Concepts", List.of(
                        "REST API Design", "OOP", "Data Structures & Algorithms", "System Design (HLD/LLD)"))
        );
    }

    @Override
    public List<ProjectResponse> getProjects() {
        return List.of(
                new ProjectResponse(
                        "Geoco E-Commerce Backend",
                        "Production Spring Boot backend for a cleaning products e-commerce platform",
                        "Built as part of a backend developer internship: full commerce flow from " +
                                "catalog to checkout, with production-grade caching, rate limiting and observability.",
                        List.of("Spring Boot", "Spring Security", "PostgreSQL (Neon)", "Redis", "Razorpay",
                                "Resend API", "Bucket4j", "Docker", "Render"),
                        List.of(
                                "Implemented Google OAuth2 and JWT authentication with full user profile and address CRUD",
                                "Built cart, wishlist and orders modules; integrated Razorpay via the Strategy pattern " +
                                        "with a two-step create-then-verify payment flow",
                                "Added Redis caching with cache eviction logic across services for hot read paths",
                                "Migrated transactional email to the Resend API and added structured logging and " +
                                        "Bucket4j-based rate limiting",
                                "Fixed CSP, Referrer-Policy and CORS gaps found in a Mozilla Observatory security audit"
                        ),
                        null,
                        null,
                        "Jan 2026 - Present",
                        true
                ),
                new ProjectResponse(
                        "TaskSketch",
                        "Full-stack task management app with payments",
                        "A deployed Spring Boot + React todo app with dynamic filtering and paid features.",
                        List.of("Spring Boot", "Spring Security", "PostgreSQL", "JWT", "Razorpay", "React"),
                        List.of(
                                "Built a secure REST API with paginated todo endpoints backed by PostgreSQL",
                                "Implemented stateless JWT auth, role-based access control and strict DTO validation",
                                "Added dynamic JPA Specification-based filtering with custom priority sorting",
                                "Integrated Razorpay with server-side order creation and signature verification",
                                "Deployed backend on Render and frontend on Vercel with CI/CD"
                        ),
                        "https://github.com/Rohan-Gautam",
                        "https://tasksketch.rohangautam.app",
                        "2026",
                        true
                ),
                new ProjectResponse(
                        "Expense Splitter",
                        "Group expense and settlement backend",
                        "Backend system for managing group expenses and post-trip settlements between users.",
                        List.of("Spring Boot", "PostgreSQL", "REST API"),
                        List.of(
                                "Modelled complex financial relationships between users using PostgreSQL",
                                "Designed REST APIs for expense creation, group management and automated " +
                                        "debt-settlement calculation with transactional integrity"
                        ),
                        "https://github.com/Rohan-Gautam",
                        null,
                        "2026 - Present",
                        false
                ),
                new ProjectResponse(
                        "Smart Contract Property Registry",
                        "Full-stack property record management system",
                        "Role-based property registry with three user types and secure RESTful APIs.",
                        List.of("React.js", "Node.js", "Express.js", "MongoDB", "JWT"),
                        List.of(
                                "Built role-based authentication for three user types using JWT and input validation",
                                "Achieved ~200ms average API response time with MongoDB indexing",
                                "Designed a responsive React UI with hooks and state management"
                        ),
                        "https://github.com/Rohan-Gautam",
                        null,
                        "2024",
                        false
                )
        );
    }

    @Override
    public List<ExperienceResponse> getExperience() {
        return List.of(
                new ExperienceResponse(
                        "Geoco",
                        "Backend Developer Intern",
                        "Remote",
                        "Jan 2026",
                        "Present",
                        true,
                        "Cleaning products e-commerce company",
                        List.of(
                                "Building the core Spring Boot e-commerce backend end-to-end: catalog, cart, " +
                                        "wishlist, orders and admin APIs",
                                "Implemented Google OAuth2 and JWT authentication with role-based access control",
                                "Integrated Razorpay payments using the Strategy pattern with a two-step " +
                                        "order-creation-then-verification flow to guarantee tamper-proof transactions",
                                "Added Redis caching with cross-service cache eviction, Resend email integration, " +
                                        "structured logging and Bucket4j API rate limiting",
                                "Resolved a Mozilla Observatory security audit (raised score from a 70) by fixing " +
                                        "CSP, Referrer-Policy and CORS misconfigurations",
                                "Deployed and maintained the service on Render with Neon PostgreSQL"
                        ),
                        List.of("Spring Boot", "Spring Security", "PostgreSQL", "Redis", "Razorpay", "Resend", "Docker", "Render")
                )
        );
    }

    @Override
    public CliConfigResponse getCliConfig() {
        return new CliConfigResponse(
                List.of(
                        new CliConfigResponse.ThemeInfo("dracula", "#282a36", "#f8f8f2", "#bd93f9"),
                        new CliConfigResponse.ThemeInfo("matrix", "#000000", "#00ff41", "#00ff41"),
                        new CliConfigResponse.ThemeInfo("solarized", "#002b36", "#839496", "#268bd2"),
                        new CliConfigResponse.ThemeInfo("nord", "#2e3440", "#d8dee9", "#88c0d0"),

                        // Modern Popular Themes
                        new CliConfigResponse.ThemeInfo("tokyo-night", "#1a1b26", "#c0caf5", "#7aa2f7"),
                        new CliConfigResponse.ThemeInfo("catppuccin", "#1e1e2e", "#cdd6f4", "#f5c2e7"),
                        new CliConfigResponse.ThemeInfo("catppuccin-latte", "#eff1f5", "#4c4f69", "#dc8a78"),
                        new CliConfigResponse.ThemeInfo("gruvbox", "#282828", "#ebdbb2", "#fabd2f"),
                        new CliConfigResponse.ThemeInfo("one-dark", "#282c34", "#abb2bf", "#61afef"),
                        new CliConfigResponse.ThemeInfo("github-dark", "#0d1117", "#c9d1d9", "#58a6ff"),
                        new CliConfigResponse.ThemeInfo("github-light", "#ffffff", "#24292f", "#0969da"),
                        new CliConfigResponse.ThemeInfo("rose-pine", "#191724", "#e0def4", "#eb6f92"),
                        new CliConfigResponse.ThemeInfo("rose-pine-dawn", "#faf4ed", "#575279", "#d7827e"),
                        new CliConfigResponse.ThemeInfo("everforest", "#2b3339", "#d3c6aa", "#a7c080"),
                        new CliConfigResponse.ThemeInfo("kanagawa", "#1f1f28", "#dcd7ba", "#7e9cd8"),
                        new CliConfigResponse.ThemeInfo("material-ocean", "#0f111a", "#c3cee3", "#82aaff"),

                        // Retro CRT Themes
                        new CliConfigResponse.ThemeInfo("amber", "#120c00", "#ffb000", "#ff9900"),
                        new CliConfigResponse.ThemeInfo("phosphor", "#08140a", "#98fb98", "#00ff66"),
                        new CliConfigResponse.ThemeInfo("terminal-green", "#001100", "#33ff33", "#00ff00"),
                        new CliConfigResponse.ThemeInfo("dos", "#0000aa", "#ffffff", "#ffff55"),
                        new CliConfigResponse.ThemeInfo("commodore64", "#40318d", "#a4a0ff", "#ffffff"),

                        // Fun / Neon
                        new CliConfigResponse.ThemeInfo("cyberpunk", "#0d0221", "#ff71ce", "#05ffa1"),
                        new CliConfigResponse.ThemeInfo("synthwave", "#241b2f", "#f92aad", "#36f9f6"),
                        new CliConfigResponse.ThemeInfo("outrun", "#1b1032", "#ff6ac1", "#00f5ff"),

                        // Cute / Pastel
                        new CliConfigResponse.ThemeInfo("pastel", "#fff7fb", "#5c5470", "#ff8fab"),
                        new CliConfigResponse.ThemeInfo("strawberry-milk", "#fff0f5", "#6b4f4f", "#ff69b4"),
                        new CliConfigResponse.ThemeInfo("mint", "#ecfff7", "#24524a", "#56c596"),
                        new CliConfigResponse.ThemeInfo("lavender", "#f6f0ff", "#5b4b8a", "#9b7ede")
                ),
                List.of(
                        new CliConfigResponse.CommandInfo("whoami", "Show profile summary", "whoami"),
                        new CliConfigResponse.CommandInfo("skills", "List technical skills", "skills"),
                        new CliConfigResponse.CommandInfo("projects", "List projects", "projects [--featured]"),
                        new CliConfigResponse.CommandInfo("experience", "Show work experience", "experience"),
                        new CliConfigResponse.CommandInfo("theme", "Switch terminal theme", "theme <name>"),
                        new CliConfigResponse.CommandInfo("clear", "Clear the terminal", "clear"),
                        new CliConfigResponse.CommandInfo("help", "List available commands", "help")
                ),
                BootQuotes.QUOTES,
                """
                                                                                ____       _
                                                                               |  _ \\ ___ | |__   __ _ _ __
                                                                               | |_) / _ \\| '_ \\ / _` | '_ \\
                                                                               |  _ < (_) | | | | (_| | | | |
                                                                               |_| \\_\\___/|_| |_|\\__,_|_| |_|
                        """
        );
    }
}
