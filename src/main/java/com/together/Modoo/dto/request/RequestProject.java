package com.together.Modoo.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class RequestProject {
    private String title;
    private List<String> skills;
    private List<Long> categoriesId;
    private Long teamId;
}
