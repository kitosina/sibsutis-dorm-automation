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
@Entity(name = "certificate_request")
@Table(name = "certificate_request", schema = "operations")
public class CertificateRequestEntity {

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
}
