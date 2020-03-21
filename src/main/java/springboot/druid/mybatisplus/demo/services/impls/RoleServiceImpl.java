package springboot.druid.mybatisplus.demo.services.impls;

import springboot.druid.mybatisplus.demo.entities.Role;
import springboot.druid.mybatisplus.demo.mappers.RoleMapper;
import springboot.druid.mybatisplus.demo.services.RoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
