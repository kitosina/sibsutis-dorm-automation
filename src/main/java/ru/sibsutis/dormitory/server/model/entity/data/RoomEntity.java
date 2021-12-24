package ru.sibsutis.dormitory.server.model.entity.data;

import lombok.AllArgsConstructor;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "room")
@Table(name = "room", schema = "data")
public class RoomEntity {

    /**
     * Идентификатор комнаты
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

    @OneToMany(mappedBy = "roomEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TenantEntity> tenantEntities;

    public RoomEntity(final long id, final int numRoom, final int capacity) {
        this.id = id;
        this.numRoom = numRoom;
        this.capacity = capacity;
    }

}
