package CallerTrue.data.repository;

import CallerTrue.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepImpl implements UserRep {
    private int count;
    List<User> customer = new ArrayList<>();

    @Override
    public User save(User user) {
//        user.setPassword("0909");
        count++;
        customer.add(user);
        return user;
    }


    @Override
    public User delete(User user) {
        user.setPassword("0909");
        customer.remove(user);

return user;
    }


    @Override
    public User findByEmail(String user) {
        for (User use : customer) {
            if (use.getEmail().equals(user))  {
                return use;
            }
        }
        return null;
    }


    @Override
    public  void deleteByEmail(String user) {
        var delete = findByEmail(user);
        customer.remove(delete);

    }

    @Override
    public List<User> findByFirstName(String firstName) {
                return customer;
            }



    @Override
    public List<User> viewAlL() {
        return null;
    }

    @Override
    public int counter() {

        return customer.size();
    }

    @Override
    public String toString() {
        return "NewUser{" +
                "count=" + count +
                ", customer=" + customer +
                '}';
    }
}
