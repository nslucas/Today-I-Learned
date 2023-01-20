package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellerDaoJDBC implements SellerDAO {

    private Connection conn;

    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }
    public void insert(Seller obj) {

    }

    public void update(Seller obj) {

    }

    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                "SELECT seller.*, d.Name as DepName "
                        + "FROM seller INNER JOIN department d on seller.DepartmentId = d.Id\n" +
                        "WHERE seller.Id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Department dep = instantiateDepartment(rs);
                Seller obj = instantiateSeller(rs, dep);
                return obj;
            }
            return null;

        } catch(SQLException e) {
            throw new DbException("Error: " + e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }


    }

    private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
        Seller obj = new Seller();
        obj.setId(rs.getInt("Id"));
        obj.setName(rs.getString("Name"));
        obj.setEmail(rs.getString("Email"));
        obj.setBaseSalary(rs.getDouble("BaseSalary"));
        obj.setBirthDate(rs.getDate("BirthDate"));
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
    public List<Seller> findAll(){
        return null;
    }

    @Override
    public List<Seller> findByDepartment(Department department) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT seller.*, d.Name as DepName "
                    + "FROM seller INNER JOIN department d ON seller.DepartmentId = d.Id "
                    + "WHERE DepartmentId = ? "
                    + "ORDER BY Name");
            st.setInt(1, department.getId());
            rs = st.executeQuery();

            List<Seller> list = new ArrayList<>();
            Map<Integer,Department> map = new HashMap<>();

            while (rs.next()) {

                Department dep = map.get(rs.getInt("DepartmentId"));

                if(dep == null) {
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }

                Seller obj = instantiateSeller(rs, dep);
                list.add(obj);
            }
            return list;

        } catch(SQLException e) {
            throw new DbException("Error: " + e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

    }

}
