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
@Entity(name = "request_status")
@Table(name = "request_status", schema = "operations")
public class RequestStatusEntity {

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Статус операции (Выполнено, не выполнено и тд)
     */
    @SuppressWarnings("checkstyle:magicnumber")
    @Column(name = "request_status_name", length = 10, unique = true)
    private String requestStatusName;

}
