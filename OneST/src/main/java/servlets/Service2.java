package servlets;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Pattern;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Area;
import models.Forecast;
import models.Item;
import models.WeatherForecast;

/**
 * Servlet implementation class Service2
 */
public class Service2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	WeatherForecast data = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		data = getAPIResult();
		request.setAttribute("area_data", data.getArea_data());
		RequestDispatcher dis = request.getRequestDispatcher("Service2.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String area = request.getParameter("areaname");
		data = getAPIResult();
		// Check if user input area name matches with the dataset
		for (Item i : data.getItem_data()) {
			for (Forecast f : i.getForecast_data()) {
				if (f.getAreaname().equals(area)) {
					request.setAttribute("area_name", f.getAreaname());
					request.setAttribute("area_forecast", f.getForecast());
					LocalDateTime time_s = null, time_e = null;
					try {
						// Convert date and time to reable format
						time_s = LocalDateTime.parse(i.getValid_period().getStart(),
								DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss+08:00"));
						time_e = LocalDateTime.parse(i.getValid_period().getEnd(),
								DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss+08:00"));
						String date = time_s.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
						String time_start = time_s.format(DateTimeFormatter.ofPattern("h:mm a"));
						String time_end = time_e.format(DateTimeFormatter.ofPattern("h:mm a"));
						request.setAttribute("date", date);
						request.setAttribute("time_start", time_start);
						request.setAttribute("time_end", time_end);
						break;
					} catch (Exception e) {
						System.out.println(e);
					}

				}
			}
		}
		RequestDispatcher dis = request.getRequestDispatcher("Service2Result.jsp");
		dis.forward(request, response);
	}

	// Get result from the API given
	private WeatherForecast getAPIResult() {
		try {
			URL url = new URL("https://api.data.gov.sg/v1/environment/2-hour-weather-forecast");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("accept", "application/json");
			String readLine;
			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuilder sb = new StringBuilder();
				while ((readLine = in.readLine()) != null) {
					sb.append(readLine);
				}
				in.close();
				// Parse json into java object
				Gson g = new Gson();
				WeatherForecast wobject = g.fromJson(sb.toString(), WeatherForecast.class);
				return wobject;
			}
		} catch (IOException e) {
			System.out.print(e);
		}
		return null;
	}

}
