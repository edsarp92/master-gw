package co.id.collega.gw.web.rest;

import co.id.collega.gw.domain.response.ServiceResponse;
import co.id.collega.gw.security.CustomUserDetails;
import co.id.collega.gw.security.Token;
import co.id.collega.gw.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by edsarp on 10/30/16.
 */
@RestController
@RequestMapping(value="/api")
public class UserResource {

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public Token authorize(@RequestParam String username, @RequestParam String password) {

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = this.authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails details = this.userDetailsService.loadUserByUsername(username);
        return tokenProvider.createToken(details);
    }

    @RequestMapping(value="/loginUser", method=RequestMethod.GET)
    public ServiceResponse<UserResource> getAuthenticatedUser()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!= null)
        {
            Object userDetails = authentication.getPrincipal();
            if(userDetails != null && userDetails instanceof CustomUserDetails)
            {
                CustomUserDetails secUser = (CustomUserDetails) userDetails;
                String username = secUser.getUsername();
                List<String> roles = new ArrayList<>();
               /* Set<Role> rolesSet = secUser.getDomainUser().getRoles();
                for (Role role : rolesSet)
                {
                    roles.add(role.getName());
                }
                UserResource authenticatedUser = new UserResource();
                authenticatedUser.setEmail(username);
                authenticatedUser.setRoles(roles);*/
                //return new ServiceResponse<>(authenticatedUser);
            }
        }
        return new ServiceResponse<>(HttpStatus.UNAUTHORIZED);

    }
}
