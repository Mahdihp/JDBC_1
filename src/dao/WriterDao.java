package dao;

import entity.Entity;
import entity.WriterEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WriterDao extends Dao<WriterEntity,Integer> {

    public WriterDao() throws Exception {

    }

    @Override
    public void create(WriterEntity writerEntity) throws SQLException {
        try {
            String sql = "INSERT INTO writer(id,name,age,style) VALUES(?,?,?,?);";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, writerEntity.getId());
            ps.setString(2, writerEntity.getName());
            ps.setInt(3, writerEntity.getAge());
            ps.setString(4, writerEntity.getStyle());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    @Override
    public WriterEntity read(Integer id) throws SQLException {
        String sql = "SELECT * FROM writer WHERE id=?;";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int idWriter = rs.getInt("id");
        String name = rs.getString("name");
        int age = rs.getInt("age");
        String style = rs.getString("style");
        return new WriterEntity(idWriter, name, age, style);
    }

    @Override
    public void update(WriterEntity writerEntity) throws SQLException {

        String sql = "UPDATE writer SET name=?,age=?,style=? WHERE id=?;";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, writerEntity.getName());
        ps.setInt(2, writerEntity.getAge());
        ps.setString(3, writerEntity.getStyle());
        ps.setInt(4, writerEntity.getId());
        ps.executeUpdate();
    }

    public void delete(Integer id) throws SQLException {

        String sql = "DELETE FROM writer WHERE id=?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public List<WriterEntity> readAll() throws SQLException {
        String sql = "SELECT * FROM writer";
        List<WriterEntity> writerEntityList = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int idWriter = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String style = rs.getString("style");
            writerEntityList.add(new WriterEntity(idWriter, name, age, style));

        }
        return writerEntityList;
    }

    public void empty() throws SQLException {
        String sql = "DELETE FROM writer";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.executeUpdate();

    }
}