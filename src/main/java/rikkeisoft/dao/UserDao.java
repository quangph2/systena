package rikkeisoft.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import rikkeisoft.domain.User;

@ConfigAutowireable
@Dao
@Transactional
@Repository("userDao")
public interface UserDao {
	@Select
	public List<User> findAllOrderyName();

	@Select
	public User findById(Integer id);

	@Insert
	public Result<User> insert(User user);

	@Update
	public Result<User> update(User user);

	@Delete(sqlFile = true)
	public int deleteById(Integer id);
//	public Result<User> deleteById(User user);

}

