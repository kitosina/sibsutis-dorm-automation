package ru.sibsutis.dormitory.server.model.entity.data;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tenant", schema = "data")
public class TenantEntity {

    /**
     * Идентификатор инвентаря
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Имя жильца
     */
    @Column(name = "name")
    private String name;

    /**
     * Фамилия жильца
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * Отчество жильца
     */
    @Column(name = "patronymic")
    private String patronymic;

    /**
     * Дата дня рождения жильца
     */
    @Column(name = "birth_day")
    @Temporal(TemporalType.DATE)
    private Date birthDay;

    /**
     * Дата начала контракта сотрудника
     */
    @Column(name = "contract_begin")
    @Temporal(TemporalType.DATE)
    private Date contractBegin;

    /**
     * Дата окончания контракта сотрудника
     */
    @Column(name = "contract_end")
    @Temporal(TemporalType.DATE)
    private Date contractEnd;

    /**
     * Серия + Номер паспорта
     */
    @SuppressWarnings("checkstyle:magicnumber")
    @Column(name = "passport", length = 10)
    private String passport;

    /**
     * Ссылка на таблицу со сканами паспорта
     */
    @SuppressWarnings("checkstyle:magicnumber")
    @Column(name = "passport_ref", length = 10)
    private String passportRef;

    /**
     * Ссылка на таблицу со сканами регистрации
     */
    @SuppressWarnings("checkstyle:magicnumber")
    @Column(name = "reg_ref", length = 10)
    private String regRef;

    /**
     * Email жильца
     */
    @Column(name = "email", unique = true)
    private String email;

    /**
     * Ссылка на сущность PaymentTypeEntity
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_type_id", nullable = false)
    private PaymentTypeEntity paymentTypeEntity;

    /**
     * Ссылка на сущность RoomEntity
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity roomEntity;

}
