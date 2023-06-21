package com.dizertatie.reactiveinvestigations.repository;

import com.dizertatie.reactiveinvestigations.persistance.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Long> {

}
