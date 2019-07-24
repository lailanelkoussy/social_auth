package com.social.auth.persistence;
//
//import com.social.auth.model.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//public interface UserDao extends JpaRepository<User, Integer> {
//
//	@Query("SELECT DISTINCT u FROM User u WHERE u.userName = :username")
//	User findByUsername(@Param("username") String username);
//}