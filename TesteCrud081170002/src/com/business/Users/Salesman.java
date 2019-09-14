package com.business.Users;

import com.commons.enums.Types;
import com.commons.enums.UserFunciton;

public class Salesman extends UserBase {

    public Salesman(String user, String password, String name) {
        super(user, password, name, UserFunciton.Salesman);
    }

    @Override
    public Types Type() {
        return Types.Salesman;
    }
}
