package org.generation.todolist.service;

import org.generation.todolist.repository.entity.Todoitemlist;
import org.generation.todolist.repository.TodoitemlistRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TodoitemlistServiceMySQL implements TodoitemlistService{


    private final TodoitemlistRespository todoitemlistRespository;

    public TodoitemlistServiceMySQL(@Autowired TodoitemlistRespository todoitemlistRespository){
        this.todoitemlistRespository = todoitemlistRespository;
    }

    @Override
    public Todoitemlist save(Todoitemlist todoitemlist)
    {
        //Since we have done the dependency injection of the itemRepository, therefore now we can call any methods from the CRUDRepository class
       return this.todoitemlistRespository.save(todoitemlist);

    }

    @Override
    public ArrayList<Todoitemlist> all()
    {
        //Method 1 @Query - Query class provided by Springboot : select * from item
        //Method 2 Repository class provided by Springboot: we do not need to write a single query statement (Will use this)
        ArrayList<Todoitemlist> result = new ArrayList<>();
        todoitemlistRespository.findAll().forEach(result::add);
        return result;
    }
}
