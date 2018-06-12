package dataservice;

import blservice.BlService;
import blservice.BlServiceImp;

/**
 * Created by 朱应山 on 2018/6/11.
 */
public class Test {
    public static void main(String []args) {
        BlService softwareService = new BlServiceImp();
        System.out.print(softwareService.login("151250001","戚蓉"));

    }
}
