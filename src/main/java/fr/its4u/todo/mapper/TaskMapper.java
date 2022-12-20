package fr.its4u.todo.mapper;

import fr.its4u.todo.dao.entity.TaskEntity;
import fr.its4u.todo.rest.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper extends GenericMapper<TaskEntity, Task> {

    @Mapping(source = "page.id", target = "pageId")
    Task toModel(TaskEntity taskEntity);
}