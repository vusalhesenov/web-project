package Constants;

public final class SqlConstants {

    public static String SAVE_PRODUCT = "INSERT INTO PRODUCT(NAME,PRICE,PRODUCT_TYPE_ID,UNIT_ID) VALUES (?,?,?,?)";

    public static String FIND_BY_PRODUCT = "SELECT pro.name,pro.price,cat.name,unit.name FROM product pro join category cat \n" +
                                                   "on pro.product_type_id = cat.id join unit on pro.unit_id = unit.id where pro.id=?";
}
