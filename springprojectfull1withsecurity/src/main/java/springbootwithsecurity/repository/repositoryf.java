package springbootwithsecurity.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springbootwithsecurity.entity.user;

@Repository
public interface repositoryf extends JpaRepository<user, Integer>{

}
