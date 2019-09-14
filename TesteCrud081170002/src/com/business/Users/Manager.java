package com.business.Users;
import com.commons.enums.Types;
import com.commons.enums.UserFunciton;

public class Manager extends UserBase {

    public Manager(String user, String password, String name) {
        super(user, password, name, UserFunciton.Manager);
    }

    @Override
    public Types Type() {
        return Types.Manager;
    }
}
