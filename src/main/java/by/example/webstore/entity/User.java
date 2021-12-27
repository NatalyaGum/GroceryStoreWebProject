package by.example.webstore.entity;


public class User extends AbstractEntity{
    public enum Role {ADMIN, USER}

    public enum Status {ACTIVE, BLOCKED}

    private long idUser;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String phone;
    private Role role;
    private Status status;


    public User(long idUser, String email, String password, String name, String surname, String phone, Role role, Status status) {
        this.idUser = idUser;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone=phone;
        this.role = role;
        this.status = status;
    }

       public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return idUser == user.idUser && (email != null ? email.equalsIgnoreCase(user.email) : user.email == null) &&
                (password != null ? password.equals(user.password) : user.password == null) &&
                (name != null ? name.equals(user.name) : user.name == null) &&
                (surname != null ? surname.equals(user.surname) : user.surname == null) &&
                (phone != null ? phone.equals(user.phone) : user.phone == null) &&
                role == user.role && status == user.status;
    }


    @Override
    public int hashCode() {
        int first = 31;
        int result = 1;
        result = result * first + (int) idUser;
        result = result * first + (email != null ? email.hashCode() : 0);
        result = result * first + (password != null ? password.hashCode() : 0);
        result = result * first + (name != null ? name.hashCode() : 0);
        result = result * first + (surname != null ? surname.hashCode() : 0);
        result = result * first + (phone != null ? phone.hashCode() : 0);
        result = result * first + (role != null ? role.hashCode() : 0);
        result = result * first + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString () {
        StringBuilder builder = new StringBuilder();
        builder.append("User{ ");
        builder.append("userId=").append(idUser);
        builder.append(", email=").append(email);
        builder.append(", password='").append(password);
        builder.append(", name=").append(name);
        builder.append(", surname=").append(surname);
        builder.append(", phone=").append(phone);
        builder.append(", userStatus=").append(status);
        builder.append(", userRoleId=").append(role);
        builder.append("}");
        return builder.toString();
    }

}