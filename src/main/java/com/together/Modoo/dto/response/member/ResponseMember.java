package com.together.Modoo.dto.response.member;

import com.together.Modoo.dto.response.user.ResponseUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseMember {
    private Long id;
    private ResponseUser user;
    private String team;
}
