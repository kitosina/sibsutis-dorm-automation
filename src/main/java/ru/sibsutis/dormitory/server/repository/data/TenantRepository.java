package ru.sibsutis.dormitory.server.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.sibsutis.dormitory.server.model.entity.data.TenantEntity;

import java.util.Optional;

@Repository
public interface TenantRepository extends JpaRepository<TenantEntity, Long> {

    @Query("select te from tenant te " +
            "join fetch te.roomEntity rm " +
            "where te.email = :email")
    Optional<TenantEntity> findByEmail(@Param("email") final String email);

}
