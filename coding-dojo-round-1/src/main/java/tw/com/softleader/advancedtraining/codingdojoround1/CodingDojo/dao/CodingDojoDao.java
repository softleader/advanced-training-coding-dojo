package tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.entity.CodingDojo;

import java.util.List;
import java.util.Optional;

@Repository
public interface CodingDojoDao extends JpaRepository<CodingDojo, Long > {

    Optional<CodingDojo> findTopByOrderBySeqNoDesc();
    List<CodingDojo> findByOrderByCreatTimeDesc();
}
