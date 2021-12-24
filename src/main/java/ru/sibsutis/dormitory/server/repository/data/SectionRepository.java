package ru.sibsutis.dormitory.server.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.sibsutis.dormitory.server.model.entity.data.SectionEntity;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface SectionRepository extends JpaRepository<SectionEntity, Long> {

    @Query("select se from section se join se.dormEntity dr where dr.id = :dorm_id")
    Collection<SectionEntity> findAllSectionByDormId(@Param("dorm_id") final long dormId);

    @Query("select se from section se join fetch se.dormEntity "
            + "join se.roomEntities rm where rm.id = :room_id")
    Optional<SectionEntity> findByRoomEntities(@Param("room_id") final long roomId);

}
