package com.leoli.md_server.model.serviceImpl.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

@Document
@Data
public class MdFileDto {
    private String id;
    private Timestamp createdOn;
    private Timestamp updatedOn;
    String title;
    String data;
}
