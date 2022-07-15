package com.mx.server.dao;

import com.mx.server.entity.UserGraphql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGraphqlDao extends JpaRepository<UserGraphql,String> {

    UserGraphql findByNickName(String nickname);
}
