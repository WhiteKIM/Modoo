package com.together.Modoo.dto.request.project;

import java.util.List;

public record RequestProject(
        String title,
        List<String> skills,
        List<Long> categoriesId,
        Long teamId
) {
}
