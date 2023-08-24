package com.yupi.project.provider;

import com.yupi.project.model.entity.User;
import com.yupi.project.service.InnerUserService;
import org.springframework.stereotype.Service;

/**
 * InnerUserService
 *
 * @author xlhl
 * @version 1.0
 * @description 內部查詢用户接口实现类
 */
@Service
public class InnerUserServiceImpl implements InnerUserService {

    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword) {
        return 0;
    }

    @Override
    public User getInvokeUser(String ak, String sk) {
        return null;
    }
}
