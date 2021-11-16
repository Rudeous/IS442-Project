package com.example.servingwebcontent.repository;

import db.MongoDbConnect;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

@Repository
public class IndiaRepository {

    public JSONObject getIndiaDataFromMongo() {
        return MongoDbConnect.retrieve("IndiaOilData", "IS442");
    }

}
