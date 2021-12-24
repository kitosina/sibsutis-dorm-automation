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
@Table(name = "inventory", schema = "data")
public class InventoryEntity {

    /**
     * Идентификатор инвентаря
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Название инвентаря (стол, стул и тд)
     */
    @SuppressWarnings("checkstyle:magicnumber")
    @Column(name = "name", length = 30, unique = true)
    private String name;

}
