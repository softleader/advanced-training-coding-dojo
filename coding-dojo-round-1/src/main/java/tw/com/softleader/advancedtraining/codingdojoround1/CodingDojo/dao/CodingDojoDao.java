package tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.entity.CodingDojo;

public interface CodingDojoDao extends JpaRepository<CodingDojo, Long > {

}
