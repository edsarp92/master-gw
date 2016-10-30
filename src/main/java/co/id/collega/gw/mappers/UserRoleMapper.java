package co.id.collega.gw.mappers;

import co.id.collega.gw.domain.UserRoleExample;
import co.id.collega.gw.domain.UserRole;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper extends GenericMapper<UserRole,UserRoleExample,UserRole> {

    List<UserRole> selectUserRoleJoinRole(Long userId);
}