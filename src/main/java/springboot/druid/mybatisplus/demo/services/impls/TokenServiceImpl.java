package springboot.druid.mybatisplus.demo.services.impls;

import springboot.druid.mybatisplus.demo.entities.Token;
import springboot.druid.mybatisplus.demo.mappers.TokenMapper;
import springboot.druid.mybatisplus.demo.services.TokenService;
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
public class TokenServiceImpl extends ServiceImpl<TokenMapper, Token> implements TokenService {

}
