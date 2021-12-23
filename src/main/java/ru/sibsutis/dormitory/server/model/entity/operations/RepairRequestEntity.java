package ru.sibsutis.dormitory.server.model.entity.operations;

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
@Entity(name = "repair_request")
@Table(name = "repair_request", schema = "operations")
public class RepairRequestEntity {

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Комментарий
     */
    @Column(name = "comment")
    private String comment;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "status_id", nullable = false)
    private RequestStatusEntity requestStatusEntity;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "repair_type_id", nullable = false)
    private RepairTypeEntity repairTypeEntity;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "repair_info_id", nullable = false)
    private RepairInfoEntity repairInfoEntity;

}
