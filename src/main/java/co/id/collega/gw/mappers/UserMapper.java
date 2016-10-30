package co.id.collega.gw.mappers;

import co.id.collega.gw.domain.User;
import co.id.collega.gw.domain.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends GenericMapper<User,UserExample,Integer> {

    List<User> selectAll();

    User selectByUserName(String userName);
}