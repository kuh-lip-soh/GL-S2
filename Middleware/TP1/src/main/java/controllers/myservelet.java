package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ConnectionBuilder;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class myservelet
 */
@WebServlet("/index")
public class myservelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public myservelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("index.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String nom = request.getParameter("carnet");
		ConnectToDB con=new ConnectToDB();
		Connection conn=con.getConnection();
		if(nom!=null) {
		try {
			PreparedStatement st=conn.prepareStatement("select nom from carnet where nom=?");
			st.setString(1, nom);
			ResultSet r=st.executeQuery();
			if(!r.next())
			{
				PreparedStatement st1=conn.prepareStatement("insert into carnet (nom) values(?)");
				st1.setString(1, nom);
				st1.executeUpdate();
			}
			PrintWriter out;
			try {
				out=response.getWriter();
				out.println("<!DOCTYPE html>\r\n"
						+ "<html>\r\n"
						+ "<head>\r\n"
						+ "<meta charset=\"ISO-8859-1\">\r\n"
						+ "<title>Insert title here</title>\r\n"
						+ "<style>\r\n"
						+ "  /* Centrer le formulaire */\r\n"
						+ "  form {\r\n"
						+ "    display: flex;\r\n"
						+ "    flex-direction: column;\r\n"
						+ "    align-items: center;\r\n"
						+ "    justify-content: center;\r\n"
						+ "    height: 100vh;\r\n"
						+ "    margin-top: -100px\r\n"
						+ "  }\r\n"
						+ "  \r\n"
						+ "  /* Style du champ \"carnet\" */\r\n"
						+ "  input[type=\"text\"] {\r\n"
						+ "    padding: 10px;\r\n"
						+ "    border: 1px solid #ccc;\r\n"
						+ "    border-radius: 4px;\r\n"
						+ "    font-size: 16px;\r\n"
						+ "    outline: none;\r\n"
						+ "  }\r\n"
						+ "\r\n"
						+ "  /* Style du champ \"adresse\" */\r\n"
						+ "  .adresse-input {\r\n"
						+ "    display: flex;\r\n"
						+ "    flex-direction: column;\r\n"
						+ "    align-items: center;\r\n"
						+ "    margin-bottom: 10px;\r\n"
						+ "  }\r\n"
						+ "\r\n"
						+ "  .adresse-input label {\r\n"
						+ "    font-size: 16px;\r\n"
						+ "    margin-bottom: 5px;\r\n"
						+ "  }\r\n"
						+ "\r\n"
						+ "  .adresse-input input[type=\"text\"] {\r\n"
						+ "    padding: 10px;\r\n"
						+ "    border: 1px solid #ccc;\r\n"
						+ "    border-radius: 4px;\r\n"
						+ "    font-size: 16px;\r\n"
						+ "    outline: none;\r\n"
						+ "    margin-bottom: 5px;\r\n"
						+ "  }\r\n"
						+ "\r\n"
						+ "  .adresse-input input[type=\"text\"]:last-child {\r\n"
						+ "    margin-bottom: 0;\r\n"
						+ "  }\r\n"
						+ "\r\n"
						+ "  /* Style du bouton \"Envoyer\" */\r\n"
						+ "  input[type=\"submit\"]{\r\n"
						+ "    background-color: #4CAF50;\r\n"
						+ "    color: white;\r\n"
						+ "    padding: 12px 20px;\r\n"
						+ "    border: none;\r\n"
						+ "    border-radius: 4px;\r\n"
						+ "    cursor: pointer;\r\n"
						+ "    font-size: 16px;\r\n"
						+ "  }\r\n"
						+ "\r\n"
						+ "  /* Hover du bouton \"Envoyer\" */\r\n"
						+ "  input[type=\"submit\"]:hover {\r\n"
						+ "    background-color: #45a049;\r\n"
						+ "  }\r\n"
						+ "</style>\r\n"
						+ "\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "\r\n"
						+ "<form action=\"index\" method=\"post\">\r\n"
						+ "\r\n"
						+"<div class=\"adresse-input\">\r\n"
						+ "  <h3 style=\"align-items: center;\">Ajouter adresse</h4>\r\n"
						+ "  <label>choisir carnet : </label>\r\n"
						+ "  <select style=\"width: 80px\" name=\"crn\">");
						PreparedStatement st2=conn.prepareStatement("select distinct nom from carnet");
						ResultSet r1=st2.executeQuery();
						while(r1.next())
						{out.println("<option>"+r1.getString("nom")+"</option>");}
				out.println("</select>\r\n"
						+ "  <label for=\"nom\">Nom :</label>\r\n"
						+ "    <input type=\"text\" id=\"nom\" name=\"nom\" required>\r\n"
						+ "    <label for=\"rue\">Rue :</label>\r\n"
						+ "    <input type=\"text\" id=\"rue\" name=\"rue\" required>\r\n"
						+ "    <label for=\"ville\">Ville :</label>\r\n"
						+ "    <input type=\"text\" id=\"ville\" name=\"ville\" required>\r\n"
						+ "    <br> \r\n"
						+ "    <input type=\"submit\" value=\"enregister\">\r\n"
						+ "  </div>"
						+ "  \r\n"
						+ "  \r\n"
						+ "</form>\r\n"
						+ "\r\n"
						+ "</body>\r\n"
						+ "</html>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}catch (Exception e) {
				e.printStackTrace();
			}}
				nom = request.getParameter("crn");
				
			    if(nom!=null) {
			    	String nomadresse = request.getParameter("nom");
				    int rue=Integer.parseInt(request.getParameter("rue"));
				    String nomville=request.getParameter("ville");
			    	try {
			    PreparedStatement st3=conn.prepareStatement("select nom from adresse where nom=?");
				st3.setString(1, nomadresse);
				ResultSet r3=st3.executeQuery();
				if(!r3.next())
				{
				   st3=conn.prepareStatement("insert into adresse values(?,?,?)");
					st3.setString(1, nomadresse);
					st3.setInt(2, rue);
					st3.setString(3, nomville);
					st3.executeUpdate();
					st3=conn.prepareStatement("insert into carnet  values(?,?)");
					st3.setString(2, nomadresse);
					st3.setString(1, nom);
					st3.executeUpdate();
				
					PrintWriter ou=response.getWriter();
				     ou.println("<!DOCTYPE html>\r\n"
				     		+ "<html>\r\n"
				     		+ "<head>\r\n"
				     		+ "<meta charset=\"ISO-8859-1\">\r\n"
				     		+ "<title>Insert title here</title>\r\n"
				     		
				     		+ "\r\n"
				     		+ "</head>\r\n"
				     		+ "<body>\r\n");
				     ou.println("<h3>carnet:  "+nom+"</h3>\r\n"
				     +"<h4>liste des adresses</h4>\r\n"
				     );
				     
				     PreparedStatement s=conn.prepareStatement("select adresse.nom,num,ville from adresse join carnet on adresse.nom=carnet.nomad and carnet.nom=?");
				     s.setString(1, nom);
						ResultSet rs=s.executeQuery();
				     		while(rs.next())
				     		{
				     			ou.println("<p><b>nom  : </b>"+rs.getString("adresse.nom")+"<b>   nom ville : </b>"+rs.getString("ville")+"<b>   numero de rue  </b>"+rs.getString("num")+"</p>\r\n");
				     		}
				     		
				     		
				     ou.println( "\r\n"
				     		+ "</body>\r\n"
				     		+ "</html>");
				     ou.close();
				     nom=null;
					conn.close();}}catch (Exception e) {
						e.printStackTrace();
					}
			    }}}
			
		
		
