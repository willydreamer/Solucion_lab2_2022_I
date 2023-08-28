package pe.edu.pucp.gtics.lab1221.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.pucp.gtics.lab1221.entity.Platforms;

import javax.persistence.Entity;

@Repository
public interface PlatformsRepository extends JpaRepository<Platforms, Integer> {

}
