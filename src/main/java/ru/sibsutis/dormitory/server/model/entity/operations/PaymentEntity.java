package ru.sibsutis.dormitory.server.model.entity.operations;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "payment")
@Table(name = "payment", schema = "operations")
public class PaymentEntity {

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Конец периода оплаты
     */
    @Column(name = "payment_end")
    private LocalDate paymentEnd;

    /**
     * Идентификатор жильца
     */
    @Column(name = "tenant_id")
    private int tenantId;
}
