package org.javacream.todo;
import jakarta.persistence.*;
@Entity
@Table(name = "todos")
public class ToDo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer priority;
    private Boolean finished;
    protected ToDo() {}
    public ToDo(String description, Integer priority, Boolean finished) {
        this.description = description; this.priority = priority; this.finished = finished;
    }
    public Long getId() { return id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getPriority() { return priority; }
    public void setPriority(Integer priority) { this.priority = priority; }
    public Boolean getFinished() { return finished; }
    public void setFinished(Boolean finished) { this.finished = finished; }
}
