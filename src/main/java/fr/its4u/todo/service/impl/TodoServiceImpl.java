package fr.its4u.todo.service.impl;

import fr.its4u.todo.dao.entity.PageEntity;
import fr.its4u.todo.dao.entity.TaskEntity;
import fr.its4u.todo.dao.repository.PageRepository;
import fr.its4u.todo.dao.repository.TaskRepository;
import fr.its4u.todo.exceptions.PageNotFoundException;
import fr.its4u.todo.exceptions.TaskNotFoundException;
import fr.its4u.todo.mapper.PageMapper;
import fr.its4u.todo.mapper.TaskMapper;
import fr.its4u.todo.rest.model.Page;
import fr.its4u.todo.rest.model.Task;
import fr.its4u.todo.service.TodoService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@Slf4j
public class TodoServiceImpl implements TodoService {

    /**
     * Todo Page Repository.
     */
    @Autowired
    private PageRepository pageRepository;

    /**
     * Todo Page Repository.
     */
    @Autowired
    private TaskRepository taskRepository;

    /**
     * Todo task mapper.
     */
    @Autowired
    private TaskMapper taskMapper;

    /**
     * Todo page mapper.
     */
    @Autowired
    private PageMapper pageMapper;

    /**
     * Retrieves all TodoPages.
     *
     * @return all todo pages
     */
    @Override
    public List<Page> retrieveAllTodoPages() {
        return pageMapper.toListModel(pageRepository.findAll());
    }

    /**
     * Create a new TodoPage.
     *
     * @param page todo page to create
     * @return created todo page
     */
    @Override
    public Page createNewPage(Page page) {
        PageEntity todoPageToCreate = pageMapper.toEntity(page);
        return pageMapper.toModel(pageRepository.save(todoPageToCreate));
    }

    /**
     * Update given todo page.
     *
     * @param page todo page to update
     */
    @Override
    public void updatePage(Page page) throws PageNotFoundException {
        PageEntity todoPageToUpdate = pageRepository.findById(page.getId()).orElseGet(null);

        if (todoPageToUpdate == null) {
            throw new PageNotFoundException();
        }

        todoPageToUpdate.setTitle(page.getTitle());
        pageRepository.save(todoPageToUpdate);
    }

    /**
     * Creates a new TodoTask for the given TodoPage.
     *
     * @param task todo task to create.
     * @param todoPageId     todo page to add task.
     * @return todo page with new task.
     */
    @Override
    public Page createNewTask(Task task, Long todoPageId) throws PageNotFoundException {

        PageEntity pageEntity = pageRepository.findById(todoPageId).orElse(null);

        if (pageEntity == null) {
            throw new PageNotFoundException();
        }

        pageEntity.getTasks().add(taskMapper.toEntity(task));

        return pageMapper.toModel(pageRepository.save(pageEntity));
    }

    /**
     * Update given task.
     *
     * @param task given todo task
     */
    @Override
    public void updateTask(Task task) throws TaskNotFoundException {

        TaskEntity todoTaskToUpdate = taskRepository.findById(task.getId()).orElseGet(null);

        if (todoTaskToUpdate == null) {
            throw new TaskNotFoundException();
        }

        todoTaskToUpdate.setTitle(task.getTitle());
        todoTaskToUpdate.setComplete(task.getComplete());
        todoTaskToUpdate.setDescription(task.getDescription());
        todoTaskToUpdate.setEndDate(task.getEndDate());

        taskRepository.save(todoTaskToUpdate);
    }

    /**
     * Delete given task.
     *
     * @param taskId task id
     */
    @Override
    public void deleteTask(Long taskId) throws TaskNotFoundException {
        if (taskRepository.findById(taskId).isEmpty()) {
            throw new TaskNotFoundException();
        }

        taskRepository.deleteById(taskId);
    }
}
