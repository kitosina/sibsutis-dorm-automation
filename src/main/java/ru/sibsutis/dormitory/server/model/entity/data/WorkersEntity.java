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
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "workers", schema = "data")
public class WorkersEntity {

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Имя работника
     */
    @Column(name = "name")
    private String name;

    /**
     * Фамилия работника
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * Отчество работника
     */
    @Column(name = "patronymic")
    private String patronymic;

    /**
     * Дата дня рождения сотрудника
     */
    @Column(name = "birth_date")
    private LocalDate birthDate;

    /**
     * Серия + Номер паспорта
     */
    @SuppressWarnings("checkstyle:magicnumber")
    @Column(name = "passport", length = 10)
    private String passport;

    /**
     * ИНН сотрудника
     */
    @SuppressWarnings("checkstyle:magicnumber")
    @Column(name = "inn", length = 14)
    private String inn;

    /**
     * Снилс сотрудника
     */
    @SuppressWarnings("checkstyle:magicnumber")
    @Column(name = "snils", length = 16)
    private String snils;

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
     * Email сотрудника
     */
    @Column(name = "email", unique = true)
    private String email;

    /**
     * Ссылка на сущность DormEntity
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dorm_id", nullable = false)
    private DormEntity dormEntity;

    /**
     * Ссылка на сущность WorkTypeEntity
     */
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "work_type_id", nullable = false)
    private WorkTypeEntity workTypeEntity;

}
