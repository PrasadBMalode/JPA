package com.xworkz.xworkz_Prasad_Modules.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "userFile_tb")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userFileId;

    private String file;
    private String contentType;
    private Long size;
    private String path;

    @OneToOne(mappedBy = "fileEntity")
    private UserEntity user;

}



