package junit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import chap07.BoardDao;
import chap07.BoardVo;

@WebAppConfiguration
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = chap07.MvcConfig.class)
public class Test3 {  
	@Autowired
	BoardDao dao;
	
	@Test
	void test() {
		int cnt = dao.count(new BoardVo());
		System.out.println(cnt);
	}
}
