package com.xworkz.ExcelStudent.external;


import com.xworkz.ExcelStudent.entity.StudentEntity;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.FileInputStream;
import java.io.IOException;


public class StudentRunner {
    public static void main(String[] args) {

        String excelPath = "C:\\Users\\Zidi\\OneDrive\\Documents\\student.xlsx";

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try (FileInputStream fileInputStream = new FileInputStream(excelPath);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            entityTransaction.begin();

            Sheet sheetAt = workbook.getSheetAt(0);

            for (int i = 1; i <= sheetAt.getLastRowNum(); i++) {
                Row row = sheetAt.getRow(i);

                StudentEntity studentEntity = new StudentEntity();

                studentEntity.setStudentId((int) row.getCell(0).getNumericCellValue());
                studentEntity.setStudentName(row.getCell(1).getStringCellValue());
                studentEntity.setStudentAge((int) row.getCell(2).getNumericCellValue());
                studentEntity.setPhNumber((long) row.getCell(3).getNumericCellValue());

                entityManager.persist(studentEntity);
            }
            entityTransaction.commit();
            System.out.println("Excel data inserted in DB using JPA successfully");

        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    } 

}
