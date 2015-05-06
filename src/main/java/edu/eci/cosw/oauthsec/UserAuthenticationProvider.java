/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.eci.cosw.oauthsec;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author hcadavid
 */
public class UserAuthenticationProvider implements AuthenticationProvider{

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String user=authentication.getPrincipal().toString();
        String pwd=authentication.getCredentials().toString();
        
        //PUT Auth Bean here
        
        boolean result=user.equals("myuser") && pwd.equals("mypassword");

        
        if (result) {
            List<GrantedAuthority> grantedAuthorities
                    = new ArrayList<>();
            UserAuthenticationToken auth
                    = new UserAuthenticationToken(authentication.getPrincipal(),
                            authentication.getCredentials(), grantedAuthorities);

            return auth;
        } else {
            throw new BadCredentialsException("Bad User Credentials.");
        }
        
    }

    @Override
    public boolean supports(Class<?> type) {
        return true;
    }
    
    

}

class UserAuthenticationToken extends AbstractAuthenticationToken {
 
    private static final long serialVersionUID = -1092219614309982278L;
    private final Object principal;
    private Object credentials;
 
    public UserAuthenticationToken(Object principal, Object credentials,
            Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        super.setAuthenticated(true);
    }
 
    @Override
    public Object getCredentials() {
        return this.credentials;
    }
 
    @Override
    public Object getPrincipal() {
        return this.principal;
    }
}