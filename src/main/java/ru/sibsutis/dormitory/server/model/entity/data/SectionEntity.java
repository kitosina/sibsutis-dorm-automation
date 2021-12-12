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

@Getter
@Setter
@Entity
@Table(name = "section", schema = "data")
public class SectionEntity {

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * диапазон комнат для общежития (Например: 701-708 или 801-808)
     */
    @SuppressWarnings("checkstyle:magicnumber")
    @Column(name = "name", length = 20)
    private String name;

    /**
     * Ссылка на сущность DormEntity
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dorm_id", nullable = false)
    private DormEntity dormEntity;

}
