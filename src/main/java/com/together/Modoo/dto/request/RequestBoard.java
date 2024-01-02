package com.together.Modoo.dto.request;

import lombok.Data;

@Data
public class RequestBoard {
    private String title;
    private String content;
    private Long userId;
}
