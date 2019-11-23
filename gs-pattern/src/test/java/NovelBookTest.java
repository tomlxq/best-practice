import com.example.principle.ocp.IBook;
import com.example.principle.ocp.NovelBook;
import junit.framework.TestCase;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/13
 */
public class NovelBookTest extends TestCase {
    private String name = "平凡的世界";
    private int price = 6000;
    private String author = "路遥";
    private IBook novelBook = new NovelBook(name, price, author);

    //测试getPrice方法
    public void testGetPrice() {
//原价销售，根据输入和输出的值是否相等进行断言
        super.assertEquals(this.price, this.novelBook.getPrice());
    }
}