package org.javacream.training.java;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodosController {
	@Value("${todos.illegalIndexTemplate}") String INDEX_TEMPLATE;
	@Value("${todos.elementTemplate}") String ELEMENT_TEMPLATE;
    @GetMapping("/todo")
    public String retrieveToDoFor(Integer index) {
		List<String> todos = List.of("Essen", "Trinken", "Schlafen");
		var sizeOfTodos = todos.size();
		if (index < sizeOfTodos && index >= 0) {
			var todo = todos.get(index);
			var result = ELEMENT_TEMPLATE.formatted(index, todo); 
			return result;
		}else {
	        return INDEX_TEMPLATE.formatted(index, sizeOfTodos - 1);
		}
    }
}
