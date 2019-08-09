package tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.entity.CodingDojo;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.entity.ReplyMessage;

@Repository
public interface ReplyMessageDao extends JpaRepository<ReplyMessage, Long> {
  List<ReplyMessage> findByCodingDojoIdOrderByCreatTimeAsc(Long id);
}
