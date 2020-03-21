package springboot.druid.mybatisplus.demo.services.impls;

import springboot.druid.mybatisplus.demo.entities.Permission;
import springboot.druid.mybatisplus.demo.mappers.PermissionMapper;
import springboot.druid.mybatisplus.demo.services.PermissionService;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

}
