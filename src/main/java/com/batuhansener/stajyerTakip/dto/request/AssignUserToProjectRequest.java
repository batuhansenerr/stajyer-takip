package com.batuhansener.stajyerTakip.dto.request;

public record AssignUserToProjectRequest(
        String user_id,
        String project_id
) {
}
