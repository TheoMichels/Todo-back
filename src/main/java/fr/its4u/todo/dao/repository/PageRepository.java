package fr.its4u.todo.dao.repository;

import fr.its4u.todo.dao.entity.PageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends JpaRepository<PageEntity, Long> {
}
