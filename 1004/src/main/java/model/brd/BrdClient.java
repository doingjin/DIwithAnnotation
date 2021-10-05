package model.brd;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BrdClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		BrdService bs=(BrdService)factory.getBean("brdService");
		
		/*BrdVO vo=new BrdVO();
		vo.setTitle("제목입니다");
		vo.setWriter("qwe");
		vo.setContent("글 내용내용");
		bs.insertBrd(vo);*/
		
		ArrayList<BrdVO> datas=bs.selectAll();
		for(BrdVO data : datas) {
			System.out.println(data);
		}
		
		factory.close();
		
	}

}
