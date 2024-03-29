package com.batuhansener.stajyerTakip.dto.request;

import lombok.Builder;

@Builder
public record AssignInternToMentorRequest (
        String intern_id,
        String mentor_id
){
}
