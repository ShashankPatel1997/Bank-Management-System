package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import oracle.jdbc.OracleDriver;
public class Model {
	
	String name,cusid,pwd,email;
	int accno,balance,accno1,customer,deposit,transaction,amount;
	
	ArrayList al1=new ArrayList();
	ArrayList al2=new ArrayList();
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="SYSTEM";
	String pass="system";
	Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public int getCustomer() {
		return customer;
	}
	public void setCustomer(int customer) {
		this.customer = customer;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public int getTransaction() {
		return transaction;
	}
	public void setTransaction(int transaction) {
		this.transaction = transaction;
	}
	public int getAccno1() {
		return accno1;
	}
	public void setAccno1(int accno1) {
		this.accno1 = accno1;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCusid() {
		return cusid;
	}
	public void setCusid(String cusid) {
		this.cusid = cusid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public Model() throws Exception
	{
		DriverManager.deregisterDriver(new OracleDriver());
		con=DriverManager.getConnection(url,user,pass);
	
	}
	
	boolean login() throws SQLException
	{
		String s1="Select * from bank where cusid=? and pwd=?";
		pstmt=con.prepareStatement(s1);
		pstmt.setString(1,cusid);
		pstmt.setString(2,pwd);
		res=pstmt.executeQuery();
		
		while(res.next()==true)
		{
			name=res.getString(1);
			accno=res.getInt(2);
			cusid=res.getString(3);
			pwd=res.getString(4);
			balance=res.getInt(5);
			email=res.getString(6);
			
	// Fetching data for Statistics		
			String sql = "select * from bank";
			pstmt=con.prepareStatement(sql);
			res=pstmt.executeQuery();
			customer=0;
			deposit=0;
			while(res.next()==true)
			{		
				customer=customer+1;
				balance=res.getInt(5);
				deposit=deposit+balance;
			}
			String sql1 = "select * from GETSTATEMENT";
			pstmt=con.prepareStatement(sql1);
			res=pstmt.executeQuery();
			transaction=0;
			while(res.next()==true)
			{		
				amount=res.getInt(3);
				transaction=transaction+amount;
			}
				return true;
		}
		return false;
	}
	
	boolean checkBalance() throws SQLException
	{
		String s2="Select * from bank where accno=?";
		pstmt=con.prepareStatement(s2);
		pstmt.setInt(1,accno);
		res=pstmt.executeQuery();
		
		while(res.next()==true)
		{
			name=res.getString(1);
			accno=res.getInt(2);
			cusid=res.getString(3);
			pwd=res.getString(4);
			balance=res.getInt(5);
			email=res.getString(6);
			
			
			return true;
		}
		return false;
	}
	
	boolean applyLoan() throws SQLException
	{
		String s3="Select * from bank where accno=?";
		pstmt=con.prepareStatement(s3);
		pstmt.setInt(1,accno);
		res=pstmt.executeQuery();
		
		while(res.next()==true)
		{
			name=res.getString(1);
			accno=res.getInt(2);
			cusid=res.getString(3);
			pwd=res.getString(4);
			balance=res.getInt(5);
			email=res.getString(6);
			
			return true;
		}
		return false;
	}
	
	boolean changePwd() throws SQLException
	{
		String s4="update bank set pwd=? where accno=?";
		pstmt=con.prepareStatement(s4);
		pstmt.setString(1,pwd);
		pstmt.setInt(2,accno);
		int x=pstmt.executeUpdate();
		
		if(x==1)
		{
			
			return true;
		}
		return false;
	}
	
	boolean transfer() throws SQLException
	{
		String s5="select * from Bank where accno=?";
		pstmt=con.prepareStatement(s5);
		pstmt.setInt(1,accno1);
		res=pstmt.executeQuery();
		
		while(res.next()==true)
		{
			String s6="Update bank set balance=balance-? where accno=?";
			pstmt=con.prepareStatement(s6);
			pstmt.setInt(1,balance);
			
			pstmt.setInt(2, accno);
			int x=pstmt.executeUpdate();
			
			if(x==1)
			{
				String s7="Update bank set balance=balance+? where accno=?";
				pstmt=con.prepareStatement(s7);
				pstmt.setInt(1,balance);
				pstmt.setInt(2, accno1);
				int x2=pstmt.executeUpdate();
				
				if(x2==1)
				{
					String s8="Insert into GETSTATEMENT	 values(?,?,?)";
		
					pstmt=con.prepareStatement(s8);
					pstmt.setInt(1,accno);
					pstmt.setInt(2, accno1);
					pstmt.setInt(3, balance);
					int x3=pstmt.executeUpdate();
					if(x3==1)
					{
						// Fetching data for Statistics		
						String sql = "select * from bank";
						pstmt=con.prepareStatement(sql);
						res=pstmt.executeQuery();
						customer=0;
						deposit=0;
						while(res.next()==true)
						{		
							customer=customer+1;
							balance=res.getInt(5);
							deposit=deposit+balance;
						}
						String sql1 = "select * from GETSTATEMENT";
						pstmt=con.prepareStatement(sql1);
						res=pstmt.executeQuery();
						transaction=0;
						while(res.next()==true)
						{		
							amount=res.getInt(3);
							transaction=transaction+amount;
						}
						System.out.println(customer);
						
				 // Fetching data for Statistics	
						
						
						return true;
					}
					
				}
			}
			
		}
		return false;
		
	}
	
	ArrayList getStatement() throws SQLException
	{
		
		String s2="Select * from GETSTATEMENT where SENDERACC=?";
		pstmt=con.prepareStatement(s2);
		pstmt.setInt(1,accno);
		res=pstmt.executeQuery();
		
		while(res.next()==true)
		{
			al1.add(res.getInt(2));
			al2.add(res.getInt(3));
			
		}
		return al1;
		
	}
	
	boolean forgotpwd() throws SQLException
	{
		
		String s2="update bank set pwd=? where email=?";
		pstmt=con.prepareStatement(s2);
		pstmt.setString(1,pwd);
		pstmt.setString(2,email);
		int x=pstmt.executeUpdate();
		
		if(x==1)
		{
			return true;
		}
		return false;
		
	}
	
	

}
