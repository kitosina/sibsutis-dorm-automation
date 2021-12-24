package ru.sibsutis.dormitory.server.repository.operation;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sibsutis.dormitory.server.model.entity.operations.RequestStatusEntity;

import java.util.Optional;

public interface RequestStatusRepository extends JpaRepository<RequestStatusEntity, Long> {

    Optional<RequestStatusEntity> findByRequestStatusName(final String requestStatusName);
}
