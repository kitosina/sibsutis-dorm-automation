package ru.sibsutis.dormitory.server.model.entity.operations;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "repair_info")
@Table(name = "repair_info", schema = "operations")
public class RepairInfoEntity {

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "num_room", unique = true)
    private int numRoom;

    @Column(name = "section_name", unique = true)
    private String sectionName;

    @Column(name = "dorm_id", unique = true)
    private int dormId;
}
