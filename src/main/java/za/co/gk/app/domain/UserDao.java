package za.co.gk.app.domain;

import org.springframework.data.repository.CrudRepository;
import za.co.gk.app.model.User;

import java.util.List;

/**
 * Created by DevMachine on 2016/08/22.
 */
public interface UserDao extends CrudRepository<User,Long>{

    List<User> findAll();
//    void save(User user);
//    void update(User user);
//    void delete (User user);
//    User findByUserId(Long id);
//    List<User> findAll();

}
