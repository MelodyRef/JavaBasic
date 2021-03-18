package ProxyDemo;

public class UserServiceImpl implements IUserService{
    @Override
    public void add(String name) {
        System.out.println("insert data in the dababase which name :"+name);
    }
}
