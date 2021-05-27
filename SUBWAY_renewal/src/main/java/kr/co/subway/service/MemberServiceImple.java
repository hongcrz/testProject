package kr.co.subway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.subway.mapper.MemberMapper;
import kr.co.subway.security.domain.CustomUserDetails;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MemberServiceImple implements MemberService {
	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private PasswordEncoder pwencoder;
	
	@Override
	public int searchByID(String userid) {
		log.info("search By ID : " + userid);
		return mapper.searchByID(userid);
	}
	
	@Override
	public void register(CustomUserDetails user) {
		log.info("register USER : " + user);
		
		// password encode
		user.setUserpw(pwencoder.encode(user.getPassword())); 
		mapper.insert(user);
	}
	
	
}
