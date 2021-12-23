package ru.sibsutis.dormitory.server.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.sibsutis.dormitory.server.model.entity.data.DormEntity;



@Repository
public interface DormRepository extends JpaRepository<DormEntity, Long> {

}
