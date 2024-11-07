package day36_Proxy.demo7_CachingProxy;

public class DataServiceImpl implements DataService{
    @Override
    public String fetchData(int id) {
        // 模拟耗时操作，例如数据库查询
        try {
            Thread.sleep(1000); // 模拟耗时操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Data for ID: " + id;
    }
}
