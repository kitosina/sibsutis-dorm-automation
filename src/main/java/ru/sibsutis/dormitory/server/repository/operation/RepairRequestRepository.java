package ru.sibsutis.dormitory.server.repository.operation;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sibsutis.dormitory.server.model.entity.operations.RepairRequestEntity;

public interface RepairRequestRepository extends JpaRepository<RepairRequestEntity, Long> {
}
