package products;

import java.io.InvalidClassException;
import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args){
        //ProductServiceのクラスのインスタンスを作成
        ProductService service = new ProductService();

        //findByIdメソッドの動作確認
        var id = 102;
        ProductRecord PR = service.findById(id);
        System.out.println("IDの検索結果：" + PR);

        //findByNameメソッドの動作確認
        var Name = "地球儀";
        List<ProductRecord> list = service.findByName(Name);
        System.out.println("Nameの検索結果：" + list);

        //insertメソッドの動作確認
        ProductRecord NR = new ProductRecord(105,"筆箱",900);
        int insert = service.insert(NR);
        System.out.println("追加内容："+ insert);

        //updateメソッドの動作確認
        ProductRecord UP = new ProductRecord(102,"消しゴム",100);
        int Update = service.update(UP);
        System.out.println("更新内容："+ Update);

        //deleteメソッドの動作確認
        var DeleteId = 103;
        var Del = service.delete(DeleteId);
        System.out.println("削除内容："+ Del);
    }

}






//        Connection con = DbUtl.getConnection();
//        ProductDao Dao = new ProductDao(con);
//        System.out.println(Dao.findById(106));
//        try{
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e1) {
//            e1.printStackTrace();
////            throw new RuntimeException();
//        }
//        System.out.println(Dao.findByName("鉛筆"));
////        ProductRecord product = new ProductRecord(104,"教科書",1500);
////        System.out.println(Dao.insert(product));
////        ProductRecord product = new ProductRecord(101,"シャーペン",700);
////        System.out.println(Dao.update(product));
//        System.out.println(Dao.delete(101));
