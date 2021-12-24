package ru.sibsutis.dormitory.server.model.entity.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "tenant")
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
    @Column(name = "birth_date")
    private LocalDate birthDate;

    /**
     * Дата начала контракта сотрудника
     */
    @Column(name = "contract_begin")
    private LocalDate contractBegin;

    /**
     * Дата окончания контракта сотрудника
     */
    @Column(name = "contract_end")
    private LocalDate contractEnd;

    /**
     * Серия + Номер паспорта
     */
    @SuppressWarnings("checkstyle:magicnumber")
    @Column(name = "passport", length = 10)
    private String passport;

    /**
     * Ссылка на таблицу со сканами паспорта
     */
    @Column(name = "passport_scan")
    private byte[] passportScan;

    /**
     * Ссылка на таблицу со сканами регистрации
     */
    @Column(name = "reg_scan")
    private byte[] regScan;

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
