package com.leoli.md_server.controller.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class MdFileVo {
    private String id;
    private Timestamp createdOn;
    private Timestamp updatedOn;
    String title;
    String data;
}
