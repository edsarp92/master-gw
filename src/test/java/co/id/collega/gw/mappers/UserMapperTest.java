package co.id.collega.gw.mappers;

import co.id.collega.gw.GatewayApplication;
import co.id.collega.gw.domain.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.constraints.AssertTrue;
import java.util.List;

/**
 * Created by edsarp on 10/30/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(GatewayApplication.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findAll(){

        PageHelper.startPage(1, 5);
        List<User> users=userMapper.selectAll();
        PageInfo<User> page = new PageInfo<User>(users);
        Assert.assertEquals(5, page.getSize());

    }
}
