package fr.its4u.todo.mapper;

import fr.its4u.todo.dao.entity.PageEntity;
import fr.its4u.todo.rest.model.Page;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PageMapper extends GenericMapper<PageEntity, Page> {

}
