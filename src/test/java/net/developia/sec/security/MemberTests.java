package net.developia.sec.security;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml" })
@Log4j
public class MemberTests {

	@Setter(onMethod_ = @Autowired)
	private PasswordEncoder pwencoder;

	@Setter(onMethod_ = @Autowired)
	private DataSource ds;

	@Test
	public void testInsertMember() {	// insert user

		String sql = 
			"insert into tbl_member(userid, userpw, username)"+
			"values(?,?,?)";

		for (int i = 0; i < 100; i++) {
			
			try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
				
				pstmt.setString(2, pwencoder.encode("pw" + i));

				if (i < 80) {
					pstmt.setString(1, "user" + i);
					pstmt.setString(3, "일반사용자" + i);
				} else if (i < 90) {
					pstmt.setString(1, "manager" + i);
					pstmt.setString(3, "운영자" + i);
				} else {
					pstmt.setString(1, "admin" + i);
					pstmt.setString(3, "관리자" + i);
				}
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
	
	  
	@Test
	public void testInsertAuth() {		// insert role
		String sql ="insert into tbl_member_auth (userid, auth)" +
					"values (?,?)";

		for (int i = 0; i < 100; i++) {
			
			try(Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

				if (i < 80) {
					pstmt.setString(1, "user" + i);
					pstmt.setString(2, "ROLE_USER");
				} else if (i < 90) {
					pstmt.setString(1, "manager" + i);
					pstmt.setString(2, "ROLE_MEMBER");
				} else {
					pstmt.setString(1, "admin" + i);
					pstmt.setString(2, "ROLE_ADMIN");
				} 
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} // end try
		} // end for
	}
}
