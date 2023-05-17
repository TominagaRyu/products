package products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import static jdk.internal.org.jline.keymap.KeyMap.del;

public class ProductDao {
    private Connection connection;

    public ProductDao(Connection connection) {
        this.connection = connection;
    }

    public ProductRecord findById(int findById) {
        ProductRecord PR = null;
        try (PreparedStatement stat = this.connection.prepareStatement("SELECT * FROM products where id = " + findById)) {
            ResultSet rs = stat.executeQuery();

            while (rs.next()) {
                PR = new ProductRecord(rs.getInt("id"), rs.getString("name"), rs.getInt("price"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return PR;
    }

    public List<ProductRecord> findByName(String name) {
        var list = new ArrayList<ProductRecord>();

        try (PreparedStatement stat = this.connection.prepareStatement("SELECT * FROM products where name LIKE '%" + name + "%'")) {
            ResultSet rs = stat.executeQuery();

            while (rs.next()) {
                var PR = new ProductRecord(rs.getInt("id"), rs.getString("name"), rs.getInt("price"));
                list.add(PR);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    /*
    引数で受け取った値でproductsテーブルに対してレコードをインサートする
    処理件数を戻り値で返す
     */
    public int insert(ProductRecord product) {
        String SQL = "INSERT INTO products VALUES(" + product.id() + ",'" + product.name() + "'," + product.price() + ")";
        var rs = 0;
        try (PreparedStatement stat = this.connection.prepareStatement(SQL)) {
            rs = stat.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    /*
    引数で受け取ったProductRecordのidをwhere句で指定し、nameとpriceをupdateする
    処理件数を戻り値で返す
     */
    public int update(ProductRecord product) {
        String SQL = "UPDATE products SET name = " + "'" + product.name() + "', price = " + product.price() + " WHERE " + " id =" + product.id();
        int rs = 0;
        try (PreparedStatement stat = this.connection.prepareStatement(SQL)) {
            rs = stat.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    /*
引数で受け取ったint型の変数をproductsのidとして指定し、deleteする
処理件数を戻り値で返す
     */
    public int delete(int del) {
        String SQL = "DELETE FROM products WHERE id = " + del;
        int rs = 0;
        try (PreparedStatement stat = this.connection.prepareStatement(SQL)) {
            rs = stat.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }
}
