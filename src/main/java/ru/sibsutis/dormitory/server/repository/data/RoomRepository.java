package ru.sibsutis.dormitory.server.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.sibsutis.dormitory.server.model.entity.data.RoomEntity;
import ru.sibsutis.dormitory.server.model.entity.data.TenantEntity;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

    @Query("select new ru.sibsutis.dormitory.server.model.entity.data.RoomEntity(rm.id, rm.numRoom, rm.capacity) " +
            "from room rm " +
            "join rm.sectionEntity se " +
            "left join rm.tenantEntities te " +
            "where se.id = :section_id " +
            "group by rm.numRoom, te.roomEntity.id, rm.id, rm.capacity " +
            "having rm.capacity > count(rm) or rm.capacity > 0")
    Collection<RoomEntity> findAllFreeRoomBySectionId(@Param("section_id") long sectionId);

    Optional<RoomEntity> findById(final long roomId);

    @Query("select rm from room rm join fetch rm.sectionEntity " +
            "join rm.tenantEntities te where te.id = :tenant_id")
    Optional<RoomEntity> findByTenantEntities(@Param("tenant_id") final long tenantId);
}
