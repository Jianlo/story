import com.jian.base.ResultData;
import org.junit.Test;

import java.util.Date;

public class ResultDataTest {
    public static void main(String[] args) {
        ResultData resultData = new ResultData();
        System.out.println(resultData);
    }

    @Test
    public void timeTest(){
        Date date = new Date();
        System.out.println(date);
    }
}
