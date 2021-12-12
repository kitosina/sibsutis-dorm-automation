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
@Table(name = "inventarisation", schema = "data")
public class InventarisationEntity {

    /**
     * Идентификатор инвентаря
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * количество инвентаря
     */
    @Column(name = "quantity")
    private int quantity;

    /**
     * Ссылка на сущность RoomEntity
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity roomEntity;

    /**
     * Ссылка на сущность InventoryEntity
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "inventory_id", nullable = false)
    private InventoryEntity inventoryEntity;

}
