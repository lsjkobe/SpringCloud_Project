package com.leoli.mongodb_server.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MongoProvider {
    @Autowired
    MongoTemplate mongoTemplate;

    public void save(Object o){
        mongoTemplate.save(o);
    }
}
