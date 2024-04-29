package com.batuhansener.stajyerTakip.dto.request;

public record UpdateProjectRequest(
        String name,
        String project_status,
        String requirements,
        int score
) {
}
