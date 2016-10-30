
package co.id.collega.gw.security;

import co.id.collega.gw.common.GlobalVariable;
import co.id.collega.gw.domain.User;
import co.id.collega.gw.domain.UserExample;
import co.id.collega.gw.domain.UserRole;
import co.id.collega.gw.mappers.UserMapper;
import co.id.collega.gw.mappers.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRoleMapper userRoleMapper;


    private GlobalVariable globel = GlobalVariable.getInstance();

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user=userMapper.selectByUserName(userName);
        if(null == user){
            throw new UsernameNotFoundException("No user present with username: "+userName);
        }else{
            List<UserRole> userRoles =userRoleMapper.selectUserRoleJoinRole(user.getUserId());
            List<String> role=new ArrayList<>();
            for(UserRole userRole :userRoles){
                role.add(userRole.getRole().getName());
            }
            globel.put(user.getUserName(),user);
            return new CustomUserDetails(user,role);
        }
    }

}

