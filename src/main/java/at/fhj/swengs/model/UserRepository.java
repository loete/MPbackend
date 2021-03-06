package at.fhj.swengs.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by loete on 31.01.2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    User findByUserName(String userName);

    User save(User user);
}
