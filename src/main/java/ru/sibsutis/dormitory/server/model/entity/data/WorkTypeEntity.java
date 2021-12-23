package ru.sibsutis.dormitory.server.model.entity.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "work_type", schema = "data")
public class WorkTypeEntity {

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Тип работы (сантехника, электрика и тд)
     */
    @SuppressWarnings("checkstyle:magicnumber")
    @Column(name = "name_type", length = 100, unique = true)
    private String nameType;

}
