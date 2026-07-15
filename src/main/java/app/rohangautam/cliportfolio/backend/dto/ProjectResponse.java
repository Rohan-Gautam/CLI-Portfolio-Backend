package app.rohangautam.cliportfolio.backend.dto;

import java.util.List;

public record ProjectResponse(
        String title,
        String tagline,
        String description,
        List<String> techStack,
        List<String> highlights,
        String githubUrl,
        String liveUrl,
        String duration,
        boolean featured
) {}
