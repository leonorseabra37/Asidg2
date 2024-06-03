package com.asidG1.studentservice.model.entity;

import com.asidG1.studentservice.model.entity.base.BaseEntityWithIdLong;
import com.asidG1.studentservice.model.entity.enums.MarkEnum;

import jakarta.persistence.*;

@Entity
@Table(name = "marks")
public class Mark extends BaseEntityWithIdLong {

    @Enumerated(EnumType.STRING)
    private MarkEnum mark;

    public MarkEnum getMark() {
        return mark;
    }

    public void setMark(MarkEnum mark) {
        this.mark = mark;
    }
}
