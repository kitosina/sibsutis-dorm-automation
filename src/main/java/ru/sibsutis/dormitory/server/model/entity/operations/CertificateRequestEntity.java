package ru.sibsutis.dormitory.server.model.entity.operations;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    /**
     * Количество справок
     */
    @Column(name = "quantity")
    private int quantity;

    /**
     * Идентификатор жильца
     */
    @Column(name = "tenant_id")
    private int tenantId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "status_id", nullable = false)
    private RequestStatusEntity requestStatusEntity;

}
