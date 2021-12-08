package junit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import chap07.BoardDao;
import chap07.BoardVo;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = chap07.MvcConfig.class)
public class Test2 {
	
	@Autowired
	WebApplicationContext ctx;
	private MockMvc mockMvc;

	@Autowired
	BoardDao boardDao;
	
	@Before
	public void before() {
		System.out.println("before");
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void boardDaoTest() {
		int cnt = boardDao.count(new BoardVo());
		System.out.println(cnt);
	}
}
