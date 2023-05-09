package org.generation.todolist.service;

import org.generation.todolist.repository.entity.Todoitemlist;

import java.util.ArrayList;

public interface TodoitemlistService {

    Todoitemlist save(Todoitemlist todoitemlist);


    //Read all item from database
    ArrayList<Todoitemlist> all();
}
