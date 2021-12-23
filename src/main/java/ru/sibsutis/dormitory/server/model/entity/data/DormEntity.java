package ru.sibsutis.dormitory.server.model.entity.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity(name = "dorm")
@Table(name = "dorm", schema = "data")
public class DormEntity {

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Название общежития (Общежитие 1 и тд)
     */
    @SuppressWarnings("checkstyle:magicnumber")
    @Column(name = "name", length = 50, unique = true)
    private String name;

    /**
     * Жилая площадь
     */
    @Column(name = "living_space")
    private double livingSpace;

    /**
     * Количество комнат жилых
     */
    @Column(name = "count_room")
    private int countRoom;

}
