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
@Table(name = "room", schema = "data")
public class RoomEntity {

    /**
     * Идентификатор инвентаря
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Номер комнаты
     */
    @Column(name = "num_room")
    private int numRoom;

    /**
     * Площадь комнаты
     */
    @Column(name = "space")
    private double space;

    /**
     * Количество мест в комнате
     */
    @Column(name = "capacity")
    private int capacity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "section_id", nullable = false)
    private SectionEntity sectionEntity;

}
