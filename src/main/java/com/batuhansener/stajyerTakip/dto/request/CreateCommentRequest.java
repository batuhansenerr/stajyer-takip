package com.batuhansener.stajyerTakip.dto.request;

import lombok.Builder;

@Builder
public record CreateCommentRequest(
        String comment,
        String project_id
) {
}
