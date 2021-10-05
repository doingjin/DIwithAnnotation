package model.brd;

import java.util.ArrayList;

public interface BrdService {
	
	void insertBrd(BrdVO vo);
	ArrayList<BrdVO> selectAll();
	BrdVO selectOne(BrdVO vo);
	void updateBrd(BrdVO vo);
	void deleteBrd(BrdVO vo);
	
}
