package hello.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;


public class User {

    @Id
    public ObjectId _id;

    public String firstName;
    public String lastName;
    public String age;

    // Constructor
    public User() {}

    public User(ObjectId _id, String firstName, String lastName, String age) {
        this._id = _id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAge() { return age; }
    public void setAge(String age) { this.age = age; }




}