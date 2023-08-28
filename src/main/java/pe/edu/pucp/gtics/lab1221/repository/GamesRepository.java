package pe.edu.pucp.gtics.lab1221.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.pucp.gtics.lab1221.entity.Games;

@Repository
public interface GamesRepository extends JpaRepository<Games, Integer> {

}
