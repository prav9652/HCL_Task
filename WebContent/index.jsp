<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ page import="com.example.Transaction" %>
<%@ page import="com.example.TransactionDAO" %>
<%@page import="java.util.*" %>

<%! static int value=0; %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">

<style type="text/css">
 table {
font-family: "Lato","sans-serif"; 
text-align:center;  }  

table.one {                                  
margin-bottom: 3em; 
border-collapse:collapse;   }   
 
td {                            
     
width: 10em;                    
padding: 1em;       }       
 
th {                              
text-align: center;                 
padding: 1em;
background-color: #e8503a;       
color: white;       }                
 
tr {    
height: 1em;    }
 
table tr:nth-child(even) {            
    background-color: #eee;     }
 
table tr:nth-child(odd) {            
background-color:#fff;      }
 
</style>
</head>
<body >
	<h2 align="center">Last Five Transactions</h2>
	
	<table class="center" >
	<tr>
	<th>TransactionId</th>
	<th>TransDates</th>
	<th>Credit</th>
	<th>Debit</th>
	<th>Balance</th>
	</tr>
<%
	long Ava_Bal=0;
	if(value!=0){
		
	try{@SuppressWarnings("unchecked")
	ArrayList<Transaction> std =(ArrayList<Transaction>)request.getAttribute("TransactionDAO"); 
	 	Ava_Bal=std.get(0).getBalance();
        for(Transaction s:std){%> 
        
        <%--This table only visible when the request is forwarded to server --%>
         <%-- The value sets to 1 indicated to visible --%>
        <%-- Arranging data in tabular form  --%> 
            <tr> 
                <td><%=s.getTransactionId()%></td> 
                 <td><%=s.getTransDate()%></td>
                <td><%=s.getCredit()%></td> 
                <td><%=s.getDebit()%></td>
                <td><%=s.getBalance() %> 
            </tr> 
            <%}}catch(Exception e){
            	e.printStackTrace();
            }
	%>
	
	<% 
	}
     else{%> 
<%
try{ 	
	
	List<Transaction> std = TransactionDAO.getMiniStatement();
	Ava_Bal=std.get(0).getBalance();
        for(Transaction s:std){%> 
        
            <tr> 
                <td><%=s.getTransactionId()%></td>
                <td><%=s.getTransDate()%></td>  
                <td><%=s.getCredit()%></td> 
                <td><%=s.getDebit()%></td>
                <td><%=s.getBalance() %> </td>
            </tr> 
            <%}
        }catch(Exception e){
            	e.printStackTrace();
           }
    
%>
</table>

<br><br>
		<form action="fundTransfer" method="GET" style="text-align:center">
		<% value=1;%>
			<input  type="submit" name="button" value="Transfer" >	
		</form>
		
		
<% }%>
</body>
</html>