package com.together.Modoo.dto.response.team;

import com.together.Modoo.dto.response.member.ResponseMember;
import com.together.Modoo.dto.response.project.ResponseProject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseTeam {
    private Long id;
    private String title;
    private List<ResponseMember> members;
    private List<ResponseProject> projects;
}
