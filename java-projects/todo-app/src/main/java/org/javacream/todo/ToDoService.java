package org.javacream.todo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ToDoService {
    @Autowired private ToDoRepository repository;
    public ToDo create(String description, Integer priority, Boolean finished) {
        checkPriority(priority);
        return repository.save(new ToDo(description, priority, finished));
    }
    public List<ToDo> findAll() { return repository.findAll(); }
    public ToDo findById(Long id) { return repository.findById(id).orElse(null); }
    public ToDo update(Long id, String description, Integer priority, Boolean finished) {
        checkPriority(priority);
        ToDo todo = repository.findById(id).orElse(null);
        if (todo == null) return null;
        todo.setDescription(description);
        todo.setPriority(priority);
        todo.setFinished(finished);
        return repository.save(todo);
    }
    private void checkPriority(Integer priority) {
        if (priority == null || priority < 0 || priority > 10)
            throw new IllegalArgumentException("priority must be between 0 and 10");
    }
}
