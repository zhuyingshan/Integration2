package dataservice;

/**
 * Created by 朱应山 on 2018/6/11.
 */
public class Test {
    public static void main(String []args) {
        SoftwareService softwareService = new SoftwareServiceImp();
        System.out.print(softwareService.getHistorySel("151250001").size());
    }
}
