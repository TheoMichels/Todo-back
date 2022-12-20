package fr.its4u.todo.mapper;

import java.util.List;

/**
 * Generic mapper interface.
 *
 * @author Theo Michels
 */
public interface GenericMapper<E, M> {

    /**
     * Mapper from model to entity.
     *
     * @param m model
     * @return entity
     */
    E toEntity(M m);

    /**
     * Mapper from entity to model.
     *
     * @param e entity
     * @return model
     */
    M toModel(E e);

    /**
     * Mapper from list of entities to list of models.
     *
     * @param entities list of entities
     * @return list of models
     */
    List<M> toListModel(List<E> entities);

    /**
     * Mapper from list of models to list of entities.
     *
     * @param models list of models
     * @return list of entities
     */
    List<E> toListEntity(List<M> models);
}