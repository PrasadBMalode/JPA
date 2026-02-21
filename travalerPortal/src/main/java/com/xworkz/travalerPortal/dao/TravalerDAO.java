package com.xworkz.travalerPortal.dao;

import com.xworkz.travalerPortal.entity.TravalerEntity;

import java.util.List;

public interface TravalerDAO {
    void saveDB(TravalerEntity travalerEntity);

    List<TravalerEntity> readPassangerData();
}
