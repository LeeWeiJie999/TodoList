package org.generation.todolist.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.generation.todolist.controller.dto.TodoitemlistDTO;

@Entity
public class Todoitemlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  //retrieve customer by ID - has to be an object

    private String title;

    private String description;

    private String targetdate;

    public Todoitemlist(){}

    public Todoitemlist(TodoitemlistDTO todoitemlistDTO)
    {
        //Transfer the object (with the data) to Entity Class for mapping with the
        // database table columns and to be able to save the data in the columns
        this.title = todoitemlistDTO.getTitle();
        this.description = todoitemlistDTO.getDescription();
        this.targetdate = todoitemlistDTO.getTargetdate();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer idTodoitemlist) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Todoitemlist{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", targetdate='" + targetdate + '\'' +
                '}';
    }
}
