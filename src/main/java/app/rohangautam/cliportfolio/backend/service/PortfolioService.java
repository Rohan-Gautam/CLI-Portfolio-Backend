package app.rohangautam.cliportfolio.backend.service;

import app.rohangautam.cliportfolio.backend.dto.CliConfigResponse;
import app.rohangautam.cliportfolio.backend.dto.ExperienceResponse;
import app.rohangautam.cliportfolio.backend.dto.ProfileResponse;
import app.rohangautam.cliportfolio.backend.dto.ProjectResponse;
import app.rohangautam.cliportfolio.backend.dto.SkillResponse;

import java.util.List;

public interface PortfolioService {

    ProfileResponse getProfile();

    List<SkillResponse> getSkills();

    List<ProjectResponse> getProjects();

    List<ExperienceResponse> getExperience();

    CliConfigResponse getCliConfig();
}
