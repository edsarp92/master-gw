/*
package co.id.collega.gw.security;

import co.id.collega.gw.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;


*/
/**
 * Created by edsarp on 10/30/16.
 *//*

public class SecurityUser implements UserDetails
{
	private static final long serialVersionUID = 1L;
	private User domainUser;
	
	public SecurityUser(User user)
	{
		this.domainUser = user;
	}
	public User getDomainUser()
	{
		return domainUser;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		Set<Role> roles = domainUser.getRoles();
		String[] rolesList = new String[roles.size()];
		int counter = 0;
		for (Role role : roles)
		{
			rolesList[counter++] = role.getName();
		}
		return AuthorityUtils.createAuthorityList(rolesList);
	}

	@Override
	public String getPassword()
	{
		return domainUser.getPassword();
	}

	@Override
	public String getUsername()
	{
		return domainUser.getEmail();
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
	}

	@Override
	public boolean isEnabled()
	{
		return true;
	}

}
*/
