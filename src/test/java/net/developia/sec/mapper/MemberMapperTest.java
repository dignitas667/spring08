package net.developia.sec.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import net.developia.sec.domain.AuthVO;
import net.developia.sec.domain.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class MemberMapperTest {
	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Test
	public void testRead() {
		MemberVO vo = mapper.read("admin99");	
		log.info("~~~~~~~~~~~~~~~~~~~~~~~ : " + vo);		
		
		for ( AuthVO  authVO: vo.getAuthList()  ) {
			log.info("vo : " + authVO);			
		}
	}
}

