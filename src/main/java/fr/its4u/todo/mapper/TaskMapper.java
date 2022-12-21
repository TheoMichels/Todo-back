package fr.its4u.todo.mapper;

import fr.its4u.todo.dao.entity.TaskEntity;
import fr.its4u.todo.rest.model.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper extends GenericMapper<TaskEntity, Task> {
}