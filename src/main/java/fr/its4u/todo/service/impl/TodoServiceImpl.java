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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = {PageNotFoundException.class, TaskNotFoundException.class})
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
     * Get page by id.
     *
     * @param pageId id of page
     * @return page
     */
    @Override
    public Page getPageById(Long pageId) throws PageNotFoundException {
        PageEntity pageEntity = pageRepository.findById(pageId).orElse(null);

        if (pageEntity == null) {
            throw new PageNotFoundException();
        }

        return pageMapper.toModel(pageEntity);
    }

    /**
     * Create a new TodoPage.
     *
     * @param page todo page to create
     * @return created todo page
     */
    @Override
    public Page createNewPage(Page page) {
        PageEntity pageToCreate = pageMapper.toEntity(page);
        return pageMapper.toModel(pageRepository.save(pageToCreate));
    }

    /**
     * Update given todo page.
     *
     * @param page todo page to update
     */
    @Override
    public void updatePage(Page page) throws PageNotFoundException {
        PageEntity pageToUpdate = pageRepository.findById(page.getId()).orElse(null);

        if (pageToUpdate == null) {
            throw new PageNotFoundException();
        }

        pageToUpdate.setTitle(page.getTitle());
        pageRepository.save(pageToUpdate);
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

        TaskEntity taskToUpdate = taskRepository.findById(task.getId()).orElse(null);

        if (taskToUpdate == null) {
            throw new TaskNotFoundException();
        }

        taskToUpdate.setTitle(task.getTitle());
        taskToUpdate.setComplete(task.getComplete());
        taskToUpdate.setDescription(task.getDescription());
        taskToUpdate.setEndDate(task.getEndDate());

        taskRepository.save(taskToUpdate);
    }

    /**
     * Delete given task.
     *
     * @param taskId task id
     */
    @Override
    public void deleteTask(Long taskId) throws TaskNotFoundException {
        if (!taskRepository.existsById(taskId)) {
            throw new TaskNotFoundException();
        }

        taskRepository.deleteById(taskId);
    }
}
