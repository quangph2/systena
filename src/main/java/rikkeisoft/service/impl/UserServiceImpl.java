package rikkeisoft.service.impl;

import java.util.List;

import org.seasar.doma.jdbc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rikkeisoft.constants.CrudStatus;
import rikkeisoft.dao.UserDao;
import rikkeisoft.domain.User;
import rikkeisoft.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> findAllOrderByName() {
		return userDao.findAllOrderyName();
	}

	@Override
	public User findById(Integer id) {
		User l_user = userDao.findById(id);
		return l_user;
	}

	@Override
	public int insert(User user) {
		Result<User> result = userDao.insert(user);
		if (result.getCount() > 0)
		{
			return CrudStatus.SUCCESS;
		}
		return CrudStatus.FAILED;
	}

	@Override
	public int update(User user) {
		Result<User> result = userDao.update(user);
		if (result.getCount() > 0)
		{
			return CrudStatus.SUCCESS;
		}
		return CrudStatus.FAILED;
	}

	@Override
	public int deleteById(Integer id) {
		int result = userDao.deleteById(id);
		if (result > 0)
		{
			return CrudStatus.SUCCESS;
		}
		return CrudStatus.FAILED;
	}

}
