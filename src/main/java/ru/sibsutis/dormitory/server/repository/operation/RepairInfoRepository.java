package ru.sibsutis.dormitory.server.repository.operation;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sibsutis.dormitory.server.model.entity.operations.RepairInfoEntity;

import java.util.Optional;

public interface RepairInfoRepository extends JpaRepository<RepairInfoEntity, Long> {

    Optional<RepairInfoEntity> findByNumRoomAndSectionNameAndDormId(final int numRoom, final String sectionName,
                                                                    final int dormId);
}
