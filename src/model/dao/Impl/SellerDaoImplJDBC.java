package model.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoImplJDBC implements SellerDao {

	private Connection conn;
	
	public SellerDaoImplJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"select a.*, DepName = b.Name "
				   +  "from seller a "
				   + "inner join department b on a.departmentId = b.id "
				   + "where a.id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next()) {
				return instantiateSeller(rs, instantiateDepartment(rs));
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
		
	}

	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
		Seller obj = new Seller();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBirthday(rs.getDate("BirthDate"));
		obj.setDepartment(dep);
		return obj;
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		return dep;
	}

	@Override
	public List<Seller> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"select a.*, DepName = b.Name "
				   +  "from seller a "
				   + "inner join department b on a.departmentId = b.id ");
			
			rs = st.executeQuery();
			
			List<Seller> lista = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();
			
			while (rs.next()) {
				Department dep = map.get(rs.getInt("DepartmentId"));
				
				if (dep == null) {
					dep = instantiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
				
				lista.add(instantiateSeller(rs, dep));
			}
			return lista;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"select a.*, DepName = b.Name "
				   +  "from seller a "
				   + "inner join department b on a.departmentId = b.id "
				   + "where a.DepartmentId = ?");
			
			st.setInt(1, department.getId());
			rs = st.executeQuery();
			
			List<Seller> lista = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();
			
			while (rs.next()) {
				Department dep = map.get(rs.getInt("DepartmentId"));
				
				if (dep == null) {
					dep = instantiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
				
				lista.add(instantiateSeller(rs, dep));
			}
			return lista;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

}
