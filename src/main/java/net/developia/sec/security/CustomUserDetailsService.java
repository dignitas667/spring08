package net.developia.sec.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import net.developia.sec.domain.CustomUser;
import net.developia.sec.domain.MemberVO;
import net.developia.sec.mapper.MemberMapper;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {
	@Setter(onMethod_ = {@Autowired})
	private MemberMapper membermapper;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		log.warn("Load User By UserName :" +userName);
		
		MemberVO vo = membermapper.read(userName);		
		log.warn("Query by memebr maper :" +vo);
			
		return vo == null ? null : new CustomUser(vo);
	}
}

