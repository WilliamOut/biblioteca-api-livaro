package com.mobile.livaroapi.dto;

import java.util.List;

public record ErrorResponseDTO(
        int status,
        String error,
        String message,
        String path,
        List<String> details
) {
}
