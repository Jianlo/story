import com.jian.base.ResultData;
import com.jian.utils.IdGenerate;
import org.junit.Test;

import java.util.Date;

public class ResultDataTest {
    public static void main(String[] args) {
        ResultData resultData = new ResultData();
        System.out.println(resultData);
    }

    @Test
    public void timeTest(){
        System.out.println(IdGenerate.uid());
    }
}
