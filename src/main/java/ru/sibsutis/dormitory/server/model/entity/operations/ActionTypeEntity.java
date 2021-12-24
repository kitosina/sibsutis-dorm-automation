package ru.sibsutis.dormitory.server.model.entity.operations;

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
@Entity(name = "action_type")
@Table(name = "action_type", schema = "operations")
public class ActionTypeEntity {

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    /**
     * Тип операции (заселение, выселение и тд)
     */
    @SuppressWarnings("checkstyle:magicnumber")
    @Column(name = "action_type_name", length = 30, unique = true)
    private String actionTypeName;

}
