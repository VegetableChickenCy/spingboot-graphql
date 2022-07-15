package com.mx.server.service;

import com.mx.server.dao.UserGraphqlDao;
import com.mx.server.entity.UserGraphql;
import com.mx.server.entity.input.AddUserInput;
import com.mx.server.entity.response.ResponseBuilder;
import com.mx.server.entity.response.Result;
import com.mx.server.util.CommonUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserGraphqlDao userGraphqlDao;

    private static final Logger logger = LogManager.getLogger(UserService.class.getName());

    public UserGraphql getUserByNickname(String nickname){
        logger.info("Service ==> getUserByNickname");
        return userGraphqlDao.findByNickName(nickname);
    }

    public List<UserGraphql> listUsers(){
        logger.info("Service ==> listUsers");
        return userGraphqlDao.findAll();
    }

    public Result addUser(String mail, String nickname, String password, String description){
        logger.info("Service ==> getUser");

        UserGraphql userGraphqlDb = userGraphqlDao.findByNickName(nickname);
        if (null != userGraphqlDb){
            return ResponseBuilder.getRespCodeMsg(-110, "用户昵称存在");
        }

        UserGraphql addUserGraphql = new UserGraphql();
        addUserGraphql.setId(CommonUtils.getUUID());
        addUserGraphql.setMail(mail);
        addUserGraphql.setNickName(nickname);
        addUserGraphql.setPassword(password);
        addUserGraphql.setDescription(description);

        userGraphqlDao.save(addUserGraphql);

        return ResponseBuilder.getRespCodeMsg(100, "Success");
    }

    public Result deleteUser(String id){
        logger.info("Service ==> deleteUser");

        UserGraphql userGraphql = userGraphqlDao.getOne(id);
        if (null == userGraphql){
            return ResponseBuilder.getRespCodeMsg(-500, "数据不存在");
        }

        userGraphqlDao.deleteById(id);
        return ResponseBuilder.getRespCodeMsg(100, "Success");
    }

    public UserGraphql updateUser(String id, String mail, String nickname, String description){
        logger.info("Service ==> updateUser");
        UserGraphql one = userGraphqlDao.getOne(id);
        if (StringUtils.isEmpty(id) || null == one) {
            throw new RuntimeException("id不正确");
        }
        UserGraphql updateUserGraphql = new UserGraphql();
        updateUserGraphql.setId(id);
        updateUserGraphql.setMail(mail);
        updateUserGraphql.setNickName(nickname);
        updateUserGraphql.setDescription(description);

        userGraphqlDao.save(updateUserGraphql);
        return updateUserGraphql;
    }

    public UserGraphql addUserInput(AddUserInput addUserInput){
        logger.info("Service ==> addUserInput");
        UserGraphql addUserGraphql = new UserGraphql();
        addUserGraphql.setId(CommonUtils.getUUID());
        addUserGraphql.setMail(addUserInput.getMail());
        addUserGraphql.setNickName(addUserInput.getNickName());
        addUserGraphql.setPassword(addUserInput.getPassword());
        addUserGraphql.setDescription(addUserInput.getDescription());
        if (null != addUserInput.getSaveTime()) {
            addUserGraphql.setSaveTime(addUserInput.getSaveTime());
        }else {
            addUserGraphql.setSaveTime(new Timestamp(System.currentTimeMillis()));
        }
        userGraphqlDao.save(addUserGraphql);
        return addUserGraphql;
    }
}
