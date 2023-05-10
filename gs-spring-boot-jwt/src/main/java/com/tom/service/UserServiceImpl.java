package com.tom.service;

import com.tom.model.LoginUserVO;
import com.tom.model.UpdatePasswordUserVO;
import com.tom.model.UserException;
import com.tom.model.UserPO;
import com.tom.model.UserTokenDTO;
import com.tom.lib.JWTUtil;
import com.tom.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/8
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    final UserMapper userMapper;
    final RedisService redisService;

    @Override
    public String login(LoginUserVO loginUserVO) {
        //1.判断用户名密码是否正确
        UserPO userPO = userMapper.getByUsername(loginUserVO.getUsername());
        if (userPO == null) {
            throw new UserException(ErrorCodeEnum.TNP1001001);
        }
        if (!loginUserVO.getPassword().equals(userPO.getPassword())) {
            throw new UserException(ErrorCodeEnum.TNP1001002);
        }

        //2.用户名密码正确生成token
        UserTokenDTO userTokenDTO = new UserTokenDTO();
        BeanUtils.copyProperties(userTokenDTO, loginUserVO);
        userTokenDTO.setId(userPO.getId());
        userTokenDTO.setGmtCreate(System.currentTimeMillis());
        String token = JWTUtil.generateToken(userTokenDTO);

        //3.存入token至redis
        redisService.set(userPO.getId(), token);
        return token;
    }

    @Override
    public boolean loginOut(String id) {
        boolean result = redisService.delete(id);
        if (!redisService.delete(id)) {
            throw new UserException(ErrorCodeEnum.TNP1001003);
        }

        return result;
    }

    @Override
    public String updatePassword(UpdatePasswordUserVO updatePasswordUserVO) {
        //1.修改密码
        UserPO userPO = UserPO.builder().password(updatePasswordUserVO.getPassword())
                .id(updatePasswordUserVO.getId())
                .build();
        UserPO user = userMapper.getById(updatePasswordUserVO.getId());
        if (user == null) {
            throw new UserException(ErrorCodeEnum.TNP1001001);
        }

        if (userMapper.updatePassword(userPO) != 1) {
            throw new UserException(ErrorCodeEnum.TNP1001005);
        }
        //2.生成新的token
        UserTokenDTO userTokenDTO = UserTokenDTO.builder()
                .id(updatePasswordUserVO.getId())
                .username(user.getUsername())
                .gmtCreate(System.currentTimeMillis()).build();
        String token = JWTUtil.generateToken(userTokenDTO);
        //3.更新token
        redisService.set(user.getId(), token);
        return token;
    }
}
