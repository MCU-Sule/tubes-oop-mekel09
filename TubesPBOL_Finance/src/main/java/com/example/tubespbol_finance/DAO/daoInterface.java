package com.example.tubespbol_finance.DAO;

import java.sql.SQLException;
import java.util.List;
//18720003-Edward Michael
//1872005-Michael Sebastian Gunadi
public interface daoInterface<E> {
    public int addData(E data);

    public int delData(E data);

    public int updateData(E data);

    public List<E> showData();
}
