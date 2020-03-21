package springboot.druid.mybatisplus.demo.services.impls;

import springboot.druid.mybatisplus.demo.entities.User;
import springboot.druid.mybatisplus.demo.mappers.UserMapper;
import springboot.druid.mybatisplus.demo.services.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ouyangwei
 * @since 2020-03-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
