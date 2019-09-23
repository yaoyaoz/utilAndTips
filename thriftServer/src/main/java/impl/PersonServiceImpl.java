package impl;

import generated.DataException;
import generated.Person;
import generated.PersonService;
import org.apache.thrift.TException;

/**
 * Created by yaoyao on 2019/8/28.
 */
public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("Got client Param:" + username);

        Person person = new Person();
        person.setUsername(username);
        person.setAge(32);
        person.setMarried(true);

        return person;
    }

    @Override
    public void savePerson(Person person) throws TException {
        System.out.println("Got Client Param: ");

        System.out.println(person.getUsername());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
