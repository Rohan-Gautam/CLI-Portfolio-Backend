package app.rohangautam.cliportfolio.backend.controller;

import app.rohangautam.cliportfolio.backend.dto.CliConfigResponse;
import app.rohangautam.cliportfolio.backend.dto.ExperienceResponse;
import app.rohangautam.cliportfolio.backend.dto.ProfileResponse;
import app.rohangautam.cliportfolio.backend.dto.ProjectResponse;
import app.rohangautam.cliportfolio.backend.dto.SkillResponse;
import app.rohangautam.cliportfolio.backend.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PortfolioController {

    private final PortfolioService portfolioService;

    @GetMapping("/profile")
    public ProfileResponse getProfile() {
        return portfolioService.getProfile();
    }

    @GetMapping("/skills")
    public List<SkillResponse> getSkills() {
        return portfolioService.getSkills();
    }

    @GetMapping("/projects")
    public List<ProjectResponse> getProjects() {
        return portfolioService.getProjects();
    }

    @GetMapping("/experience")
    public List<ExperienceResponse> getExperience() {
        return portfolioService.getExperience();
    }

    @GetMapping("/cli-config")
    public CliConfigResponse getCliConfig() {
        return portfolioService.getCliConfig();
    }
}
