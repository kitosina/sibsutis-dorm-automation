package ru.sibsutis.dormitory.server.repository.operation;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sibsutis.dormitory.server.model.entity.operations.RepairTypeEntity;

public interface RepairTypeRepository extends JpaRepository<RepairTypeEntity, Long> {
}
