package chap07.user;

public class Test {

	public static void main(String[] args) {
		/*
		 * 번호:1
		 * 아이디:hong
		 * 비밀번호:1234
		 * 이름:홍길동
		 */
		UserVo uv = new UserVo();
		uv.setUserno(1);
		uv.setId("hong");
		uv.setPwd("1234");
		uv.setName("홍길동");
		
		//UserVo uv2 = new UserVo().setUserno(1).setId("hong").setPwd("1234").setName("홍길동");
	}

}
