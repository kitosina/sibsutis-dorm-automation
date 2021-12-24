package ru.sibsutis.dormitory.server.model.entity.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "payment_type", schema = "data")
public class PaymentTypeEntity {

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Группы оплаты (Староста, льготник и тд)
     */
    @SuppressWarnings("checkstyle:magicnumber")
    @Column(name = "name_type", length = 100, unique = true)
    private String nameType;

    /**
     * Размер оплаты в процентах
     */
    @Column(name = "amount")
    private double amount;

    /**
     * Размер оплаты в рублях
     */
    @Column(name = "amount_rub")
    private String amountRub;

    /**
     * Размер оплаты в процентах для коммунальных услуг
     */
    @Column(name = "com_amount")
    private double comAmount;

    /**
     * Размер оплаты в рублях для коммунальных услуг
     */
    @Column(name = "com_amount_rub")
    private String comAmountRub;

}
