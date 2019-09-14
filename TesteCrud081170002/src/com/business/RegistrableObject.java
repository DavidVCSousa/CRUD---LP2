package com.business;

import com.commons.Util.Json.JSONObject;
import com.commons.enums.Types;

import java.io.IOException;


public abstract class RegistrableObject {
    public abstract void register(RegistrableObject obj) throws IOException;
    public  abstract Types Type();
    public  abstract JSONObject ToJson();
}
