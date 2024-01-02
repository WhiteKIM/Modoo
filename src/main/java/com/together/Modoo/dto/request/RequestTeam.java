package com.together.Modoo.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class RequestTeam {
    private String title;
    private List<Long> membersId;
}
