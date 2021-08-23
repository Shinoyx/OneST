package servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Service1
 */
public class Service1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Pre-defined list of entity types
	final List<String> entity_type = Arrays.asList("LP", "LL", "FC", "PF", "RF", "MQ", "MM", "NB", "CC", "CS", "MB",
			"FM", "GS", "DP", "CP", "NR", "CM", "CD", "MD", "HS", "VH", "CH", "MH", "CL", "XL", "CX", "RP", "TU", "TC",
			"FB", "FN", "PA", "PB", "SS", "MC", "SM", "GA", "GB");

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uen = request.getParameter("uen");
		request.setAttribute("uen", uen);
		request.setAttribute("result", (checkUEN(uen) ? "Valid format" : "Invalid format"));
		RequestDispatcher dis = request.getRequestDispatcher("Service1Result.jsp");
		dis.forward(request, response);
	}

	// Method to do regex check if it matches
	private boolean checkUEN(String value) {
		if (value.length() == 9) {
			// Type A UEN
			return Pattern.matches("^[0-9]{8}[A-Z]$", value);
		} else if (value.length() == 10) {
			// Type C UEN
			if (Pattern.matches("^[T|S|R][0-9]{2}[A-Z]{2}[0-9]{4}[A-Z]$", value)
					&& entity_type.contains(value.substring(3, 5))) {
				return true;
			}
			// Type B UEN
			else if (Pattern.matches("^[0-9]{9}[A-Z]$", value)) {
				return true;
			}
		}
		return false;
	}

}
