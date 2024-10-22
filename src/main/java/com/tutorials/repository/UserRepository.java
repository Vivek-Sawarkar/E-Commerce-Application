package com.tutorials.repository;

import com.tutorials.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    //HERE WE CAN CREATE CUSTOM FINDER METHOD ACCORDING TO OUR REQUIREMENT..

    public Optional<User> findByEmail(String email);

    public Optional<User> findByName(String name);

    public Optional<User> findByEmailAndPassword(String email,String password);

    public  List<User> findByActiveTrue();

    public List<User> findByAboutIsNotNull();

    public List<User> findByNameStartingWith(String prefix);

    public List<User> findByNameContaining(String infix);

    //pattern example "viv%"
    public List<User> findByNameLike(String likePattern);

    //for ascending order by name
    public List<User> findAllByOrderByNameAsc();

    //for descending order by name
    public List<User> findAllByOrderByNameDesc();

    //if you want top 4 user by id then
    public List<User> findTop4ByOrderByUserIdAsc();


    //WE CAN CREATE HERE JPQL QUERY ALSO.....

    @Query("select u from User u where u.userId= :userId")
    public User getUserByUserId(int userId);

    @Query("select u from User u where u.email = :email")
    public User getUserByEmail(@Param("email")  String abc);

    @Query("select u from User u where u.email = :email and u.userId= :userId")
    public User getUserByEmail(@Param("email")  String abc, int userId);
/*
    WE CAN USE BELOW JPQL QUERY FOR ASCENDING AND DESCENDING ORDER BY NAME

    // For ascending order by name
    @Query("SELECT u FROM User u ORDER BY u.name ASC")
    public List<User> findAllByOrderByNameAsc();


    // For descending order by name
    @Query("SELECT u FROM User u ORDER BY u.name DESC")
    public List<User> findAllByOrderByNameDesc();
*/

    //we can create here NATIVE  query also (But native query is specific for particular database means dependent for database but JPQL is for all database.)

    @Query(value = "select u from User u where u.userId= :userId",nativeQuery = true)
    public User getByUserId(int userId);
}
