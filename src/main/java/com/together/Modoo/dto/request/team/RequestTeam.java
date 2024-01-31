package com.together.Modoo.dto.request.team;

import java.util.List;

public record RequestTeam(String title, List<Long> membersId) {
}
