package com.example;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
 
public class TransactionDAO {
	private static final String driverClassName = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/praveen";
    private static final String dbUsername = "root";
    private static final String dbPassword = "praveen9652";
 
    private static final String sql="SELECT * FROM transaction ORDER BY TransID DESC LIMIT 5";
 
    private static DataSource dataSource;
    
    public static DriverManagerDataSource getDataSource() {
    	 
    	  DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	 
    	  dataSource.setDriverClassName(driverClassName);
    	  
    	  dataSource.setUrl(DB_URL);
    	 
    	  dataSource.setUsername(dbUsername);
    	 
    	  dataSource.setPassword(dbPassword);
    	 
    	  return dataSource;
    	    }
    public static List<Transaction> getMiniStatement(){
    	 List<Transaction> trans = null;
    	
    	 try{	
         dataSource = getDataSource();
        
        JdbcTemplate template = new JdbcTemplate(dataSource);
       
        	trans=template.query(sql, new TransactionMapper());
       }
    	 catch(DataAccessException  exObj) {System.out.println("hai ERROR");}
        return trans;
    }
    
    
    	 
    public List<Transaction> doTransaction() throws Exception {
    	List<Transaction> trans = null;
     try {
        dataSource = getDataSource();
         
        JdbcTemplate template = new JdbcTemplate(dataSource);
        
        String sqlUpdateQuery = "select AvailbleBal from transaction order by TransID desc limit 1";
        int bal=template.queryForObject(sqlUpdateQuery,Integer.class);
        int updatedBal=bal-1000;
        String insertSql ="INSERT INTO transaction (TransDate,Credit,Debit,AvailbleBal) VALUES (?, ?, ?,?)";
        Object[] params = new Object[] {new Timestamp(System.currentTimeMillis()), 0, 1000, updatedBal };
        int[] types = new int[] { Types.TIMESTAMP, Types.INTEGER, Types.INTEGER, Types.INTEGER };
        template.update(insertSql, params, types);	 
        trans = template.query(sql, new TransactionMapper());
         
     }
     catch(DataAccessException  exObj)  {exObj.printStackTrace();}

     return trans;
    }
}