package org.generation.todolist.controller;


import org.generation.todolist.controller.dto.TodoitemlistDTO;
import org.generation.todolist.repository.entity.Todoitemlist;
import org.generation.todolist.service.TodoitemlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/todoitemlist")
public class TodoitemlistController {

    private final TodoitemlistService todoitemlistService;


    //Dependency Injection of the itemService object so that the Controller can call any methods in the ItemServiceMySQL Class
    public TodoitemlistController(@Autowired TodoitemlistService todoitemlistService) {
        this.todoitemlistService = todoitemlistService;
    }

    @CrossOrigin // to make localhost a valid domain
    @GetMapping("/all")
    public Iterable<Todoitemlist> getTodoitemlist()  //getItems API
    {
        //return in the Controller represents a response to the Client
        return this.todoitemlistService.all();
    }

    @CrossOrigin
    @PostMapping("/add")
    //@RequestParam - Get values from the front-end and store it into a variable
    public void save(@RequestParam(name = "title", required = true) String title,
                     @RequestParam(name = "description", required = true) String description,
                     @RequestParam(name = "targetdate", required = true) String targetdate
                     ) throws IOException {


        TodoitemlistDTO todoitemlistDTO = new TodoitemlistDTO(title, description, targetdate);
        Todoitemlist todoitemlist = new Todoitemlist(todoitemlistDTO);
        todoitemlistService.save(todoitemlist);
        //itemService.save(new Item(itemDto));
    }
}
