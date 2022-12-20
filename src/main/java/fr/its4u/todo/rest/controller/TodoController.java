package fr.its4u.todo.rest.controller;

import fr.its4u.todo.exceptions.PageNotFoundException;
import fr.its4u.todo.exceptions.TaskNotFoundException;
import fr.its4u.todo.rest.model.Page;
import fr.its4u.todo.rest.model.Task;
import fr.its4u.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    /**
     * Todo Service.
     */
    @Autowired
    private TodoService todoService;

    /**
     * Retrieves all TodoPages.
     *
     * @return all todo pages
     */
    @GetMapping("/pages")
    public List<Page> retrieveAllTodoPages() {
        return todoService.retrieveAllTodoPages();
    }

    /**
     * Update given todo page.
     *
     * @param page todo page to create
     * @return created todo page
     */
    @PostMapping("/pages/create")
    public Page createPage(@RequestBody Page page) {
        return todoService.createNewPage(page);
    }

    /**
     * Update given page.
     *
     * @param page given todo page
     */
    @PutMapping("/pages/update")
    void updatePage(@RequestBody Page page) throws PageNotFoundException {
        todoService.updatePage(page);
    }

    /**
     * Creates a new TodoTask for the given TodoPage.
     *
     * @param task todo task to create.
     * @param pageId todo page to add task.
     * @return todo page with new task.
     */
    @PostMapping("pages/{page_id}/tasks/create")
    Page createTask(@RequestBody Task task, @PathVariable("page_id") Long pageId) throws PageNotFoundException {
        return todoService.createNewTask(task, pageId);
    }

    /**
     * Update given task.
     *
     * @param task given todo task
     */
    @PutMapping("pages/tasks/update")
    void updateTask(@RequestBody Task task) throws TaskNotFoundException {
        todoService.updateTask(task);
    }

    @DeleteMapping("pages/tasks/{task_id}/delete")
    void deleteTask(@PathVariable("task_id") Long taskId) throws TaskNotFoundException {
        todoService.deleteTask(taskId);
    }
}
