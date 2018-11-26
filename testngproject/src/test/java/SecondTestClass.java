import org.testng.annotations.Test;

public class SecondTestClass {
    @Test(groups = {"other"})
    public void OtherTest(){
        System.out.println("Other test started");
    }
}
