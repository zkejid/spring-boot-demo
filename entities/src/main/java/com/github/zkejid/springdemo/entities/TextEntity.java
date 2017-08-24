package com.github.zkejid.springdemo.entities;

import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.Date;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * TextEntity entity. Represents unit of textual data.
 */
@Entity
public class TextEntity extends AbstractPersistable<Long>{
    /**
     * Title of the text or short description.
     * String size is limited by 160 symbols. The '160' value is chosen with respect to traditions only:
     * https://softwareengineering.stackexchange.com/questions/148677/why-is-80-characters-the-standard-limit-for-code-width
     */
    @Size(max = 160)
    @NotNull
    private String title;
    /**
     * Data in textual format.
     */
    @NotNull
    private String content;

    /**
     * Date and time of entity creation with millisecond precision.
     */
    @NotNull
    private Date creationDate;

    protected TextEntity() {}

    public TextEntity(String title, String content, Date creationDate) {
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}