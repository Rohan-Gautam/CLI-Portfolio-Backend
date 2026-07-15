package app.rohangautam.cliportfolio.backend.dto;

import java.util.List;

/**
 * Everything identity-related in one payload: home, about, contact,
 * education and socials used to live in 6 separate DTOs — merged here
 * since a CLI portfolio only ever needs one "whoami" call for all of it.
 */
public record ProfileResponse(
        String name,
        String title,
        String tagline,
        String location,
        String email,
        String phone,
        String about,
        String resumeUrl,
        String githubUrl,
        List<EducationEntry> education,
        List<SocialLink> socials,
        NeofetchInfo neofetch
) {

    public record EducationEntry(
            String institution,
            String degree,
            String location,
            String duration,
            String cgpa,
            List<String> coursework
    ) {}

    public record SocialLink(
            String platform,
            String url,
            String handle
    ) {}

    /** Powers the `neofetch` command in the terminal UI. */
    public record NeofetchInfo(
            String os,
            String host,
            String shell,
            String uptime,
            List<String> languages,
            List<String> interests
    ) {}
}
