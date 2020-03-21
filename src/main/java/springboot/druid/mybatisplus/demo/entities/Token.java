package springboot.druid.mybatisplus.demo.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ouyangwei
 * @since 2020-03-21
 */
public class Token implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键：id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 令牌
     */
    private String token;

    /**
     * 到期时间
     */
    private LocalDateTime expiry;

    /**
     * 外键：用户表id
     */
    private Integer userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getExpiry() {
        return expiry;
    }

    public void setExpiry(LocalDateTime expiry) {
        this.expiry = expiry;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Token{" +
        "id=" + id +
        ", token=" + token +
        ", expiry=" + expiry +
        ", userId=" + userId +
        "}";
    }
}
