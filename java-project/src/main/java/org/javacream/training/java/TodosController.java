package org.javacream.training.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TodosController {
	@Value("${todos.illegalIndexTemplate}")
	String INDEX_TEMPLATE;
	@Value("${todos.elementTemplate}")
	String ELEMENT_TEMPLATE;
	@Value("${todos.removeElementTemplate}")
	String REMOVE_ELEMENT_TEMPLATE;
	@Value("${todos.addElementTemplate}")
	String ADD_ELEMENT_TEMPLATE;
	@Value("${todos.clearTemplate}")
	String CLEAR_ELEMENT_TEMPLATE;

	//Für einen richtigen Service FALSCH, da muss eine Datenbank zur Datenhaltung genutzt werden
	Set<Todo> todos = new HashSet<>();

//	@GetMapping("/get_todo")
//	public String retrieveToDoFor(Integer index) {
//		var sizeOfTodos = todos.size();
//		if (index < sizeOfTodos && index >= 0) {
//			var todo = todos.get(index);
//			var result = ELEMENT_TEMPLATE.formatted(index, todo);
//			return result;
//		} else {
//			return INDEX_TEMPLATE.formatted(index, sizeOfTodos - 1);
//		}
//	}
	@GetMapping("/finish_todo")
	public String finishToDoFor(String element) {
		todos.remove(element);
		return "OK";
	}
	@GetMapping("/add_todo")
	public String addToDo(String description, Integer priority) {
		var newTodoEntry = new Todo(description, priority, Boolean.FALSE); 
		todos.add(newTodoEntry);
		return ADD_ELEMENT_TEMPLATE.formatted(newTodoEntry.description());
		
	}
	@GetMapping("/clear_todos")
	public String clearToDos() {
		todos.clear();
		return CLEAR_ELEMENT_TEMPLATE.formatted();
		
	}
	@GetMapping("/all_todos")
	public Set<Todo> allToDos() {
		return todos;
		
	}
}
