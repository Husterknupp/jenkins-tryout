package de.schandera.jenkins_tryout;

import static de.schandera.jenkins_tryout.GeneratedClasses.Tables.POSTS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

public class Main {

	public static void main(String[] args) {

		Connection conn = null;

		String userName = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/guestbook";

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, userName, password);

			DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
			Result<Record> result = create.select().from(POSTS).fetch();

			for (Record record : result) {
				Long id = record.getValue(POSTS.ID);
				String title = record.getValue(POSTS.TITLE);
				String description = record.getValue(POSTS.BODY);

				System.out.println("ID: " + id + " title: " + title + " desciption: " + description);
			}
			// System.out.println("C");
		} catch (Exception e) {
			// You'll probably want to handle the exceptions in a real app
			// Don't ever do this silence catch(Exception e) thing. I've seen this in
			// live code and it is horrendous.
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ignore) {

				}
			}
		}
	}
}