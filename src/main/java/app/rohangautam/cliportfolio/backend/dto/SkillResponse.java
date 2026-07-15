package app.rohangautam.cliportfolio.backend.dto;

import java.util.List;

/** One category (Languages, Frameworks, etc.) with its skills — service returns List<SkillResponse>. */
public record SkillResponse(
        String category,
        List<String> items
) {}
