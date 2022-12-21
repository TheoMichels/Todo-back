package fr.its4u.todo.service;

import fr.its4u.todo.exceptions.PageNotFoundException;
import fr.its4u.todo.exceptions.TaskNotFoundException;
import fr.its4u.todo.rest.model.Page;
import fr.its4u.todo.rest.model.Task;

import java.util.List;

public interface TodoService {

    /**
     * Retrieves all TodoPages.
     *
     * @return all todo pages
     */
    List<Page> retrieveAllTodoPages();

    /**
     * Get page by id.
     *
     * @param pageId id of page
     * @return page
     */
    Page getPageById(Long pageId) throws PageNotFoundException;

    /**
     * Create a new TodoPage.
     *
     * @param page todo page to create
     * @return created todo page
     */
    Page createNewPage(Page page);

    /**
     * Update given todo page.
     *
     * @param page todo page to update
     */
    void updatePage(Page page) throws PageNotFoundException;

    /**
     * Creates a new TodoTask for the given TodoPage.
     *
     * @param task   todo task to create
     * @param todoPageId todo page to add task
     * @return todo page with new task
     */
    Page createNewTask(Task task, Long todoPageId) throws PageNotFoundException;

    /**
     * Completes the task corresponding to the given id.
     *
     * @param task given todo task
     */
    void updateTask(Task task) throws TaskNotFoundException;

    /**
     * Delete given task.
     *
     * @param taskId task id
     */
    void deleteTask(Long taskId) throws TaskNotFoundException;
}
