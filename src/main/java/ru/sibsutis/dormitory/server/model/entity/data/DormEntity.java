package ru.sibsutis.dormitory.server.model.entity.data;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "dorm", schema = "data")
public class DormEntity {

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Название общежития (Общежитие 1 и тд)
     */
    @SuppressWarnings("checkstyle:magicnumber")
    @Column(name = "name", length = 50, unique = true)
    private String name;

    /**
     * Жилая площадь
     */
    @Column(name = "living_space")
    private double livingSpace;

    /**
     * Количество комнат жилых
     */
    @Column(name = "count_room")
    private int countRoom;

}
