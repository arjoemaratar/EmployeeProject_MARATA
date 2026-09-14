package version2;

public class Name {
    public string firstName;
    public string middleName;
    public string lastName;

    public Name() {
    }

    public Name(string firstName, string lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Name(string firstName, string middleName, string lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public string getFirstName() {
        return firstName;
    }

    public void setFirstName(string firstName) {
        this.firstName = firstName;
    }

    public string getMiddleName() {
        return middleName;
    }

    public void setMiddleName(string middleName) {
        this.middleName = middleName;
    }

    public string getLastName() {
        return lastName;
    }

    public void setLastName(string lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        if(middleName == null || middleName.isEmpty()) {
            return String.format("%s, %s", lastName, firstName);
        }
        return String.format("%s, %s %s.", lastName, firstName, getMiddleName());

    }
}
