package ru.sibsutis.dormitory.server.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sibsutis.dormitory.server.model.entity.data.PaymentTypeEntity;

import java.util.Optional;

public interface PaymentTypeRepository extends JpaRepository<PaymentTypeEntity, Long> {

    Optional<PaymentTypeEntity> findById(final long paymentTypeId);

}
