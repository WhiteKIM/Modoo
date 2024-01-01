package com.together.Modoo.global;

import jakarta.persistence.EntityListeners;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.ZonedDateTime;

@EntityListeners(AuditingEntityListener.class)
public class BaseTime {
    @CreatedDate
    private ZonedDateTime createTime;
    @LastModifiedDate
    private ZonedDateTime lastUpdateTime;
}
