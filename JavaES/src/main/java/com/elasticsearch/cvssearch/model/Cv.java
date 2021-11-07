package com.elasticsearch.cvssearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName="cvs", shards = 1, createIndex = false)
public class Cv {

    @Id
    private String id;

    @Field(type = FieldType.Keyword)
    private String fullname;

    private String cv;

    public Cv(String fullname, String cv){
        this.fullname = fullname;
        this.cv = cv;
    }

    public String getFullname(){
        return this.fullname;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId() { return this.id; }

    public String getCV(){
        return this.cv;
    }

    public void setCV(String cv){
        this.cv = cv;
    }

}
