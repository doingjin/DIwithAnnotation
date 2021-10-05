package model.brd;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("brdService")
public class BrdServiceImpl implements BrdService{
	
	@Autowired
	private BrdDAO brdDAO;
	
	@Override
	public void insertBrd(BrdVO vo) {
		brdDAO.insertBrd(vo);
	}

	@Override
	public ArrayList<BrdVO> selectAll() {
		return brdDAO.selectAll();
	}

	@Override
	public BrdVO selectOne(BrdVO vo) {
		return brdDAO.selectOne(vo);
	}

	@Override
	public void updateBrd(BrdVO vo) {
		brdDAO.updateBrd(vo);
	}

	@Override
	public void deleteBrd(BrdVO vo) {
		brdDAO.deleteBrd(vo);
	}

}
