package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

class TransactionMapper implements RowMapper<Transaction> {
	 @Override
	  public Transaction mapRow(ResultSet rs, int arg1) throws SQLException {
		Transaction user = new Transaction();
	    user.setTransactionId((long)rs.getInt("TransID"));
	    user.setTransDate((java.sql.Timestamp)rs.getTimestamp("TransDate"));
	    user.setCredit((long)rs.getInt("Credit"));
	    user.setDebit((long)rs.getInt("Debit"));
	    user.setBalance((long)rs.getInt("AvailbleBal"));
	    return user;
	  }
}