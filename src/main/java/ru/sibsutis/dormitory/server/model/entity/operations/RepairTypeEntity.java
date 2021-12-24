package ru.sibsutis.dormitory.server.model.entity.operations;

import lombok.AccessLevel;
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
@Entity(name = "repair_type")
@Table(name = "repair_type", schema = "operations")
public class RepairTypeEntity {

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Тип ремонта (сантехника, электрика и тд)
     */
    @SuppressWarnings("checkstyle:magicnumber")
    @Setter(AccessLevel.NONE)
    @Column(name = "repair_type_name", length = 30, unique = true)
    private String repairTypeName;

}
