package com.leoli.mongodb_server.Service;

import com.leoli.mongodb_server.entity.Cpm;
import com.leoli.mongodb_server.provider.MongoProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CpmService {

    @Autowired
    MongoProvider mongoProvider;

    public void save(){
        Cpm cpm = new Cpm();
        cpm.setId("1");
        cpm.setPassWord("123");
        cpm.setUserName("leo");
        mongoProvider.save(cpm);
    }
}
