package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
                " SELECT seller.*, d.Name as DepName\n"
                        + "FROM seller INNER JOIN department d on seller.DepartmentId = d.Id\n" +
                        "WHERE seller.Id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Department dep = new Department();
                dep.setId(rs.getInt("DepartmentId"));
                dep.setName(rs.getString("DepName"));
                Seller obj = new Seller();
                obj.setId(rs.getInt("Id"));
                obj.setName(rs.getString("Name"));
                obj.setEmail(rs.getString("Email"));
                obj.setBaseSalary(rs.getDouble("BaseSalary"));
                obj.setBirthDate(rs.getDate("BirthDate"));
                obj.setDepartment(dep);
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

    @Override
    public List<Seller> findAll(){
        return null;
    }

}
