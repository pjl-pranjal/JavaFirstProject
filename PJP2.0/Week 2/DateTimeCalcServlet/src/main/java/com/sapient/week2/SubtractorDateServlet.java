package com.sapient.week2;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/subtract-date")
public class SubtractorDateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Subtractor subtractor;
	private final DateTimeFormatter dateFormat;
	private HistoryStore store;
	
	public SubtractorDateServlet() {
		super();
		this.subtractor = new Subtractor();
		this.store = new HistoryStore();
		this.dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("subtract_date.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomDate inputDate1 = new CustomDate(request.getParameter("input_date1"), this.dateFormat);
		CustomDate inputDate2 = new CustomDate(request.getParameter("input_date2"), this.dateFormat);
		
		String result = this.subtractor.subtractDate(inputDate1, inputDate2).toString();
		request.setAttribute("result", result);
		
		CalcOperation record = new CalcOperation();
		record.setType("subtract-date");
		record.setInput(inputDate1.toString());
		record.setInput1(inputDate2.toString());
		record.setOutput(result);
		try {
			this.store.addRecord(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("subtract_date.jsp");
		dispatcher.forward(request, response);
	}
}