package com.example.ch8.to;

import java.util.Date;
import java.util.Objects;

public class UserDto {

   private String name;
   private String password;
   private String email;
   private Date birthDate;
   private Date regDate;
   private String sns;

    public UserDto() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(name, userDto.name) && Objects.equals(password, userDto.password) && Objects.equals(email, userDto.email) && Objects.equals(birthDate, userDto.birthDate) && Objects.equals(regDate, userDto.regDate) && Objects.equals(sns, userDto.sns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, email, birthDate, regDate, sns);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", regDate=" + regDate +
                ", sns='" + sns + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getSns() {
        return sns;
    }

    public void setSns(String sns) {
        this.sns = sns;
    }
}
