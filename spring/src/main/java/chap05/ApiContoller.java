package chap05;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiContoller {
	
	@GetMapping("/api/test")
	public MemberVo test() {
		MemberVo vo = new MemberVo();
		vo.setName("홍길동");
		vo.setEmail("hong@gmail.com");
		vo.setNo(1);
		return vo;
	}
	
	@GetMapping("/api/list/{page}/{searchWord}")
	public List<MemberVo> list(@PathVariable int page, @PathVariable String searchWord){
		System.out.println("page :"+page);
		System.out.println("searchWord" +searchWord);
		
		List<MemberVo> list = new ArrayList<MemberVo>();
		MemberVo vo = new MemberVo();
		vo.setName("홍길동");
		vo.setEmail("hong@gmail.com");
		vo.setNo(1);
		list.add(vo);
		list.add(vo);
		return list;
	}
}
