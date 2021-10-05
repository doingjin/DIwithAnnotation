package model.brd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

// DAO -> driver, CP, MyBatis, JPA,...
// Service에서 DAO 객체를 이용하여 CRUD 기능을 제공할 예정!
// 
@Repository("brdDAO")
public class BrdDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String insertSQL="INSERT INTO BRD VALUES ((SELECT (NVL(MAX(ID),0)+1) FROM BRD),?,?,?,SYSDATE)";
	private final String selectAll="SELECT * FROM BRD";
	private final String selectOne="SELECT * FROM BRD WHERE ID=?";
	private final String updateSQL="UPDATE BRD SET TITLE=?, CONTENT=? WHERE ID=?";
	private final String deleteSQL="DELETE FROM BRD WHERE ID=?";
	
	// C = INSERT INTO BRD VALUES ((SELECT (NVL(MAX,0)+1) FROM BRD),?,?,?,SYSDATE)
	public void insertBrd(BrdVO vo) {
		System.out.println("dao로 insertBrd");
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(insertSQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	// R = SELECT * FROM BRD
	public ArrayList<BrdVO> selectAll() {
		System.out.println("dao로 selectAll");
		conn=JDBC.getConnection();
		ArrayList<BrdVO> datas=new ArrayList<BrdVO>();
		try {
			pstmt=conn.prepareStatement(selectAll);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BrdVO data=new BrdVO();
				data.setId(rs.getInt("id"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
				datas.add(data);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt, rs);
		}
		return datas;
	}
	// R = SELECT * FROM BRD WHERE ID=?
	public BrdVO selectOne(BrdVO vo) {
		System.out.println("dao로 selectOne");
		conn=JDBC.getConnection();
		BrdVO data=null;
		try {
			pstmt=conn.prepareStatement(selectOne);
			pstmt.setInt(1, vo.getId());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new BrdVO();
				data.setId(rs.getInt("id"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("date"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt, rs);
		}
		return data;
	}
	
	// U = UPDATE BRD SET TITLE=?, CONTENT=? WHERE ID=?
	public void updateBrd(BrdVO vo) {
		System.out.println("dao로 updateBrd");
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(updateSQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getId());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	// D = DELETE FROM BRD WHERE ID=?
	public void deleteBrd(BrdVO vo) {
		System.out.println("dao로 deleteBrd");
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(deleteSQL);
			pstmt.setInt(1, vo.getId());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
	}



	
	
}
