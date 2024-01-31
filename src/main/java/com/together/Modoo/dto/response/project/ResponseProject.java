package com.together.Modoo.dto.response.project;

import com.together.Modoo.dto.response.category.ResponseCategory;
import com.together.Modoo.dto.response.team.ResponseTeam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProject {
    private Long id;
    private String title;
    private List<String> skills;
    private List<ResponseCategory> categories;
    private ResponseTeam team;
}
