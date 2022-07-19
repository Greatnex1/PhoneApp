package CallerTrue.services;

import CallerTrue.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class NewUser implements UserRep {
    private int count;
    List<User> customer = new ArrayList<>();

    @Override
    public User save(User user) {
        user.setPassword("0909");
        customer.add(user);
        return user;
    }


    @Override
    public void delete(User user) {

    }

    @Override
    public User findByPassword(User user) {
        return null;
    }

    @Override
    public User deleteByPassWord(User user) {
        return null;
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<User> viewAlL() {
        return null;
    }
}
