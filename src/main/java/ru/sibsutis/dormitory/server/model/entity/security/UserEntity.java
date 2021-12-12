package ru.sibsutis.dormitory.server.model.entity.security;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@Table(name = "users", schema = "security")
public class UserEntity {

    /**
     * An id field for DB identification
     * @see Id
     * @see GeneratedValue
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * password field for DB
     * @see Column
     */
    @Column
    private String password;

    /**
     * email field for DB
     * @see Column
     */
    @Column(unique = true, nullable = false)
    private String email;

    /**
     * User role field for using in authorities in Spring security
     * creates and wires with User_role field.
     * user identifies by user_id field in table
     *
     * @see CollectionTable
     * @see Role
     * @see Enumerated
     * @see JoinColumn
     * @see ElementCollection
     */
    @ElementCollection(targetClass = Role.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "user_role", schema = "security", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

}
