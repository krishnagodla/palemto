package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class Employee implements java.io.Serializable {
	Connection con;
	public int empno;
	public String name;
	public float salary;
	public String job;

	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Employee() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
			System.out.println("connection established");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public Employee(int a)
	{
		this.empno=a;
	}
	public void setEmpno(int empno) {
		this.empno = empno;//7934
		// results();
	}
	public int getEmpno() {
		return this.empno;//7934
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public float getSalary() {
		return this.salary;
	}

	public void results() {
		try {
			ArrayList list = new ArrayList();
			// HashMap list = new HashMap();
			Statement s = con.createStatement();
			ResultSet rs = s
					.executeQuery("select ename, empno,job from emp where empno="
							+ getEmpno());
			while (rs.next()) {
				name = rs.getString(1);
				empno = rs.getInt(2);
				job = rs.getString(3);
				list.add(name);
				list.add(String.valueOf((empno)));
				list.add(String.valueOf((job)));
				System.out.println(list);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}// results
	public void deleteOne() {
		try {
			int i;
			String str = "delete from emp where empno=" + getEmpno();
			ArrayList list = new ArrayList();
			Statement s = con.createStatement();
			s.executeUpdate(str);
			i = s.getUpdateCount();
			System.out.println(i);
		} catch (Exception e) {
			System.out.println(e);
		}
	}// results

	public void updateOne() {
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("UPDATE emp SET ename=? WHERE empno=? ");
			stm.setString(1, getName());
			stm.setInt(2, getEmpno());
			int r = stm.executeUpdate();// this returns no of rows been update.
			System.out.println(r);
		} catch (Exception ext) {
			System.out.println(ext);
		}
	}

	public static void main(String agrs[]) {
		Employee em = new Employee();
		// em.setName("B Abel");
		em.setEmpno(2);
		// em.updateOne();
		// em.deleteOne();
		em.results();
	}
}// main
