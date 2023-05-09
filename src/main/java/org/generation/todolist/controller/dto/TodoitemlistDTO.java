package org.generation.todolist.controller.dto;

public class TodoitemlistDTO {

    private String title;

    private String description;

    private String targetdate;


    public TodoitemlistDTO(String title, String description, String targetdate) {
        this.title = title;
        this.description = description;
        this.targetdate = targetdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTargetdate() {
        return targetdate;
    }

    public void setTargetdate(String targetdate) {
        this.targetdate = targetdate;
    }
}
