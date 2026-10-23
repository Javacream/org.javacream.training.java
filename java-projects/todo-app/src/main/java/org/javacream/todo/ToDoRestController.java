package org.javacream.todo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/todos")
public class ToDoRestController {
    @Autowired private ToDoService service;
    @PostMapping
    public ToDo create(@RequestParam String description, @RequestParam Integer priority,
                       @RequestParam Boolean finished) {
        return service.create(description, priority, finished);
    }
    @PutMapping("/{id}")
    public ToDo update(@PathVariable Long id, @RequestParam String description,
                       @RequestParam Integer priority, @RequestParam Boolean finished) {
        return service.update(id, description, priority, finished);
    }
    @GetMapping
    public List<ToDo> findAll() { return service.findAll(); }
    @GetMapping("/{id}")
    public ToDo findById(@PathVariable Long id) { return service.findById(id); }
}
