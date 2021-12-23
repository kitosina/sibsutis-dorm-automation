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
@Entity(name = "living")
@Table(name = "living", schema = "operations")
public class LivingEntity {


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

    /**
     * Идентификатор жильца
     */
    @Column(name = "tenant_id")
    private int tenantId;

    /**
     * Ссылка на сущность ActionTypeEntity
     */
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "action_type_id", nullable = false)
    private ActionTypeEntity actionTypeEntity;

}
