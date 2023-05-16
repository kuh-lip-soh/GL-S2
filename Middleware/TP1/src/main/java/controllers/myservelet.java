package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class myservelet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public myservelet() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Carnet d'adresses</title>");
        out.println("<style>");
        out.println("form {");
        out.println("    display: flex;");
        out.println("    flex-direction: column;");
        out.println("    align-items: center;");
        out.println("    justify-content: center;");
        out.println("    height: 100vh;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action=\"index\" method=\"post\">");
        out.println("<div>");
        out.println("<h3>Ajouter une adresse</h3>");
        out.println("<label>Choisir le carnet :</label>");
        out.println("<select name=\"crn\">");
        
        // Récupérer la liste des carnets depuis la base de données
        ConnectToDB con = new ConnectToDB();
        Connection conn = con.getConnection();
        try {
            PreparedStatement st2 = conn.prepareStatement("SELECT DISTINCT nom FROM carnet");
            ResultSet r1 = st2.executeQuery();
            while (r1.next()) {
                out.println("<option>" + r1.getString("nom") + "</option>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        out.println("</select>");
        out.println("<label for=\"nom\">Nom :</label>");
        out.println("<input type=\"text\" id=\"nom\" name=\"nom\" required>");
        out.println("<label for=\"rue\">Rue :</label>");
        out.println("<input type=\"text\" id=\"rue\" name=\"rue\" required>");
        out.println("<label for=\"ville\">Ville :</label>");
        out.println("<input type=\"text\" id=\"ville\" name=\"ville\" required>");
        out.println("<br>");
        out.println("<input type=\"submit\" value=\"Enregistrer\">");
        out.println("</div>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String nom = request.getParameter("crn");
        String nomAdresse = request.getParameter("nom");
        int rue = Integer.parseInt(request.getParameter("rue"));
        String nomVille = request.getParameter("ville");

        ConnectToDB con = new ConnectToDB();
        Connection conn = con.getConnection();

        try {
            PreparedStatement st = conn.prepareStatement("SELECT nom FROM carnet WHERE nom = ?");
            st.setString(1, nom);
            ResultSet r = st.executeQuery();
            if (!r.next()) {
                PreparedStatement st1 = conn                .prepareStatement("INSERT INTO carnet (nom) VALUES (?)");
                st1.setString(1, nom);
                st1.executeUpdate();
            }

            PreparedStatement st2 = conn.prepareStatement("INSERT INTO adresse (nom, rue, ville) VALUES (?, ?, ?)");
            st2.setString(1, nomAdresse);
            st2.setInt(2, rue);
            st2.setString(3, nomVille);
            st2.executeUpdate();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Succès</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Enregistrement réussi !</h3>");
            out.println("</body>");
            out.println("</html>");

            out.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
			
		
		
