package dao;

import entity.BookEntity;
import entity.Entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao extends Dao<BookEntity, Integer> {

    public BookDao() throws Exception {

    }

    @Override
    public void create(BookEntity bookEntity) throws SQLException {

        String sql = "INSERT INTO book(id,bookName,isbn,writer_id) VALUES(?,?,?,?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, bookEntity.getId());
        ps.setString(2, bookEntity.getName());
        ps.setString(3, bookEntity.getIsbn());
        ps.setInt(4, bookEntity.getWriterId());
        ps.executeUpdate();

    }

    @Override
    public BookEntity read(Integer id) throws SQLException {
        String sql = "SELECT * FROM book WHERE id=?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int idBook = rs.getInt("id");
        String name = rs.getString("name");
        String isbn = rs.getString("isbn");
        int writer_id = rs.getInt("writer_id");
        return new BookEntity(idBook, name, isbn, writer_id);

    }

    @Override
    public void update(BookEntity bookEntity) throws SQLException {
        String sql = "UPDATE book SET name=?,isbn=?,writer_id=? WHERE id=?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, bookEntity.getName());
        ps.setString(2, bookEntity.getIsbn());
        ps.setInt(3, bookEntity.getWriterId());
        ps.setInt(4, bookEntity.getId());
        ps.executeUpdate();

    }

    @Override
    public void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM book WHERE id=?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();

    }

    @Override
    public List<BookEntity> readAll() throws SQLException {
        String sql = "SELECT * FROM book";
        List<BookEntity> entityList = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int idBook = rs.getInt("id");
            String name = rs.getString("name");
            String isbn = rs.getString("isbn");
            int writer_id = rs.getInt("writer_id");
            entityList.add(new BookEntity(idBook, name, isbn, writer_id));
        }
        return entityList;
    }

    @Override
    public void empty() throws SQLException {
        String sql = "DELETE FROM book";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.executeUpdate();

    }


}
