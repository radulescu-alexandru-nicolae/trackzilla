package com.keysoft.bucktrackerjpa.entity;

import javax.persistence.Entity;

@Entity
public class Enhancement extends Ticket {
    private Boolean duplicate;
    private String priority;

    public Enhancement() {
    }

    public Enhancement(Boolean duplicate, String priority) {
        this.duplicate = duplicate;
        this.priority = priority;
    }

    public Enhancement(Integer id, String title, String description, Application application, Release release, String status, Boolean duplicate, String priority) {
        super(id, title, description, application, release, status);
        this.duplicate = duplicate;
        this.priority = priority;
    }

    public Boolean getDuplicate() {
        return duplicate;
    }

    public void setDuplicate(Boolean duplicate) {
        this.duplicate = duplicate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
