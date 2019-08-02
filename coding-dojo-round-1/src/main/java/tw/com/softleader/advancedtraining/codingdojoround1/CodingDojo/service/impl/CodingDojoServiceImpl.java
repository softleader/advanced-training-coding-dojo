package tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.dao.CodingDojoDao;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.entity.CodingDojo;
import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.service.CodingDojoService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CodingDojoServiceImpl implements CodingDojoService {

    @Autowired
    private CodingDojoDao dao;

    public CodingDojoDao getDao() {
        return dao;
    }

    public void save(CodingDojo codingDojo) {
        dao.findTopByOrderBySeqNoDesc().ifPresent(o -> codingDojo.setSeqNo(o.getSeqNo() + 1L)
        );

        dao.save(codingDojo);
    }

    @Override
    public List<CodingDojo> queryAll() {
        return dao.findByOrderByCreatTimeDesc();
    }

}
