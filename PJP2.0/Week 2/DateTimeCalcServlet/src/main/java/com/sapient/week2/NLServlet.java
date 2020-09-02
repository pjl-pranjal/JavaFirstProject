package com.sapient.week2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/nl")
public class NLServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private NaturalLangEngine nlEngine;
	private HistoryStore store;
	
	public NLServlet() {
		super();
		this.nlEngine = new NaturalLangEngine();
		this.store = new HistoryStore();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("nl.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String phrase = request.getParameter("phrase");
		
		String result = "";
		try {
			this.nlEngine.computeFromNLPhrase(phrase);
			result = this.nlEngine.result.toString();
		} catch (Exception e) {
			result = "Couldn't process this phrase!";
		}
		
		CalcOperation record = new CalcOperation();
		record.setType("nl");
		record.setPhrase(phrase);
		record.setOutput(result);
		try {
			this.store.addRecord(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("nl.jsp");
		dispatcher.forward(request, response);
	}
}