package com.sapient.week2;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AdderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Adder adder;
	private final DateTimeFormatter dateFormat;
	private HistoryStore store;
	
	public AdderServlet() {
		super();
		this.adder = new Adder();
		this.store = new HistoryStore();
		this.dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomDate inputDate = new CustomDate(request.getParameter("input_date"), this.dateFormat);
		Integer valueToAdd = Integer.parseInt(request.getParameter("value_to_add"));
		Integer unitType = Integer.parseInt(request.getParameter("unit_type"));
		
		String result = this.adder.addByUnit(inputDate, valueToAdd, unitType).toString();
		request.setAttribute("result", result);
		
		CalcOperation record = new CalcOperation();
		record.setType("add");
		record.setInput(inputDate.toString());
		record.setUnitType(Integer.toString(unitType));
		record.setValue(Integer.toString(valueToAdd));
		record.setOutput(result);
		try {
			this.store.addRecord(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
		dispatcher.forward(request, response);
	}
}
