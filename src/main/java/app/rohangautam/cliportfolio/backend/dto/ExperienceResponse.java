package app.rohangautam.cliportfolio.backend.dto;

import java.util.List;

public record ExperienceResponse(
        String company,
        String role,
        String location,
        String startDate,
        String endDate,
        boolean current,
        String companyDescription,
        List<String> responsibilities,
        List<String> techStack
) {}
