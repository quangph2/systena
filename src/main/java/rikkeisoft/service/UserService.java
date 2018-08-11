package rikkeisoft.service;

import java.util.List;

import rikkeisoft.domain.User;

public interface UserService {
	/**
	 * Find all User
	 * @return List<User> List Users
	 */
	public List<User> findAllOrderByName();
	/**
	 * Find user by id
	 * @param id
	 * @return User User information
	 */
	public User findById(Integer id);
	/**
	 * Insert
	 * @param user
	 * @return int Insert status
	 */
	public int insert(User user);
	/**
	 * Update user
	 * @param user
	 * @return int Update status
	 */
	public int update(User user);
	/**
	 * Delete user
	 * @param id
	 * @return int Delete status
	 */
	public int deleteById(Integer id);
}

