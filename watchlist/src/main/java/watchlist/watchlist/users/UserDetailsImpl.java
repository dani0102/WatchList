package watchlist.watchlist.users;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import watchlist.watchlist.authority.Authority;
import watchlist.watchlist.role.Role;


/**
 * This class implements an additional layer of logic to the traditional entity
 * user.
 *
 * @author Belinda Schühle
 */
public class UserDetailsImpl implements UserDetails {
	
	private User user;
	
	/**
	 *
	 */
	public UserDetailsImpl() {
		super();
	}
	
	/**
	 * @param user
	 */
	@Autowired
	public UserDetailsImpl(User user) {
		super();
		this.user = user;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
		for (Role role : user.getRoles()) {
			for (Authority authority : role.getAuthorities()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
			}
		}
		return grantedAuthorities;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPassword() {
		return user.getPassword();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getUsername() {
		return user.getEmail();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
