package az.edu.ada.wm2.connectivity;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.servlet.annotation.*;

@WebServlet("/database-servlet")
public class DBServlet extends HttpServlet {

    private DataSource ds;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            Context context = new InitialContext();
            // Context webContext = (Context) context.lookup("java:/comp/env");
            ds = (DataSource) context.lookup("java:/comp/env/jdbc/wm2_db");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        Float gpa = Float.valueOf(req.getParameter("gpa"));
        String school = req.getParameter("school");

        try (Connection conn = ds.getConnection()) {

            try (PreparedStatement ps = conn
                    .prepareStatement("insert into students(fname, lname, gpa, school) values(?,?,?,?)")) {

                ps.setString(1, fname);
                ps.setString(2, lname);
                ps.setFloat(3, gpa);
                ps.setString(4, school);

                int rowsUpdated = ps.executeUpdate();

                PrintWriter pw = resp.getWriter();

                pw.write("<html><head></head><body>");
                pw.write("<h3>" + rowsUpdated + " number of rows inserted.</h3>");
                pw.write("</body></html>");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            String school = req.getParameter("school");

            Connection conn = ds.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM students where school = ?");

            ps.setString(1, school);

            ResultSet rs = ps.executeQuery();

            // printing the results to console
            // System.out.printf("%11s%20s%20s%10s%20s\n", "id", "fname", "lname", "gpa",
            // "school");
            // while (rs.next()) {
            // System.out.printf("%11d%20s%20s%10.2f\n", rs.getInt(1), rs.getString(2),
            // rs.getString(3),
            // rs.getFloat(4), rs.getString(5));
            // }

            StringBuffer sb = new StringBuffer();

            sb.append("<html><head></head><body>");
            sb.append("<h2>List of students</h2>");

            sb.append("<table style=border-spacing:15px;>");
            sb.append("<tr>");
            sb.append("<th>ID</th>");
            sb.append("<th>First Name</th>");
            sb.append("<th>Last Name</th>");
            sb.append("<th>GPA</th>");
            sb.append("<th>School</th>");
            sb.append("</tr>");

            while (rs.next()) {
                sb.append("<tr>");
                sb.append("<td>" + rs.getInt(1) + "</td>");
                sb.append("<td>" + rs.getString(2) + "</td>");
                sb.append("<td>" + rs.getString(3) + "</td>");
                sb.append("<td>" + rs.getFloat(4) + "</td>");
                sb.append("<td>" + rs.getString(5) + "</td>");

            }
            sb.append("</table></body></html>");

            resp.getWriter().write(sb.toString());

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
