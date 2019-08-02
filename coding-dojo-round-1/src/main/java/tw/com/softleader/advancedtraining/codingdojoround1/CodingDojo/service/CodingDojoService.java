package tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.service;

import java.util.List;
import java.util.Optional;

import tw.com.softleader.advancedtraining.codingdojoround1.CodingDojo.entity.CodingDojo;

public interface CodingDojoService {

  List<CodingDojo> queryAll();

  void save(CodingDojo form);

}
