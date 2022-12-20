package fr.its4u.todo.rest.model;

import java.util.ArrayList;
import java.util.List;

//@Getter
//@Setter
public class Page {

    /**
     * Id.
     */
    private Long id;

    /**
     * Title.
     */
    private String title;

    /**
     * Tasks.
     */
    private List<Task> tasks = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
