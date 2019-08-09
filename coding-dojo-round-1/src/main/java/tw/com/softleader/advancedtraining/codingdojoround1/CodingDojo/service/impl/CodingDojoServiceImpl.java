package tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.dao.CodingDojoDao;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.entity.CodingDojo;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.service.CodingDojoService;

@Service
@Transactional
public class CodingDojoServiceImpl implements CodingDojoService {

    @Autowired
    private CodingDojoDao dao;

    public CodingDojoDao getDao() {
        return dao;
    }

    public CodingDojo save(CodingDojo codingDojo) {
        dao.findTopByOrderBySeqNoDesc()
          .ifPresent(o -> codingDojo.setSeqNo(o.getSeqNo() + 1L));

        return dao.save(codingDojo);
    }

    @Override
    public List<CodingDojo> queryAll() {
        return dao.findByOrderByCreatTimeDesc();
    }

}
