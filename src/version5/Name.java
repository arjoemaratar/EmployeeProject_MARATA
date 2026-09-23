package version5;

import java.util.Objects;

public class Name implements Cloneable {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name() {
        this("", "", "", "");
    }

    public Name(String firstName, String middleName, String lastName, String suffix) {
        this.firstName = firstName != null ? firstName : "";
        this.middleName = middleName != null ? middleName : "";
        this.lastName = lastName != null ? lastName : "";
        this.suffix = suffix != null ? suffix : "";
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName != null ? firstName : ""; }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName != null ? middleName : ""; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName != null ? lastName : ""; }

    public String getSuffix() { return suffix; }
    public void setSuffix(String suffix) { this.suffix = suffix != null ? suffix : ""; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(lastName);
        if (!lastName.isEmpty() && !firstName.isEmpty()) {
            sb.append(", ");
        }
        sb.append(firstName);
        if (!middleName.isEmpty()) {
            sb.append(" ").append(middleName.charAt(0)).append(".");
        }
        if (!suffix.isEmpty()) {
            sb.append(" ").append(suffix);
        }
        return sb.toString().trim();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Name other = (Name) obj;
        return firstName.equalsIgnoreCase(other.firstName) &&
                middleName.equalsIgnoreCase(other.middleName) &&
                lastName.equalsIgnoreCase(other.lastName) &&
                suffix.equalsIgnoreCase(other.suffix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName.toLowerCase(), middleName.toLowerCase(), lastName.toLowerCase(), suffix.toLowerCase());
    }

    @Override
    public Name clone() {
        try {
            return (Name) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}