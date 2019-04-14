package com.leoli.md_server.dao.Do;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class MdFileDo {
    private String id;
    private Timestamp createdOn;
    private Timestamp updatedOn;
    String title;
    String data;
}
