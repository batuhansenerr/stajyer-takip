package com.batuhansener.stajyerTakip.dto.request;

import lombok.Builder;

@Builder
public record UpdateCommentRequest(
        String comment
) {
}
