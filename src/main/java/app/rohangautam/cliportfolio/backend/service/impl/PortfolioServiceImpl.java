package app.rohangautam.cliportfolio.backend.service.impl;

import app.rohangautam.cliportfolio.backend.dto.CliConfigResponse;
import app.rohangautam.cliportfolio.backend.dto.ExperienceResponse;
import app.rohangautam.cliportfolio.backend.dto.ProfileResponse;
import app.rohangautam.cliportfolio.backend.dto.ProjectResponse;
import app.rohangautam.cliportfolio.backend.dto.SkillResponse;
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
                        new CliConfigResponse.ThemeInfo("nord", "#2e3440", "#d8dee9", "#88c0d0")
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
                List.of(
                        "Code is cheap, show me the deploy.",
                        "Ship it, then fix it.",
                        "Every bug is a lesson wearing a disguise."
                ),
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
