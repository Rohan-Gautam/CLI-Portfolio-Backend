package app.rohangautam.cliportfolio.backend.dto;

import java.util.List;

/**
 * Everything that drives the terminal chrome rather than portfolio content —
 * themes, available commands, quotes and ascii art used to be 4 separate
 * DTOs/endpoints, merged since the frontend needs all of it on boot anyway.
 */
public record CliConfigResponse(
        List<ThemeInfo> themes,
        List<CommandInfo> commands,
        List<String> quotes,
        String asciiArt
) {

    public record ThemeInfo(
            String name,
            String background,
            String foreground,
            String accent
    ) {}

    public record CommandInfo(
            String command,
            String description,
            String usage
    ) {}
}
