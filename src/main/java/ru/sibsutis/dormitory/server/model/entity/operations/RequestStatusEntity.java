package ru.sibsutis.dormitory.server.model.entity.operations;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
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

    @AllArgsConstructor
    @Getter
    public enum RequestStatusName {
        PROCESSING("Ожидание"),
        DENIED("Отказано"),
        DONE("Выполнено");

        private String requestStatusName;
    }

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
    @Setter(AccessLevel.NONE)
    @Column(name = "request_status_name", length = 20, unique = true)
    private String requestStatusName;

}
