package com.marakana.contacts.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.enterprise.inject.New;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marakana.contacts.repositories.ContactsRepository;

@WebServlet("/contacts")
public class ContactListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final ContactsRepository contactRepository = new ContactsRepository();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			request.setAttribute("contacts", contactRepository.findAll());
			RequestDispatcher view = request
					.getRequestDispatcher("/jsp/contact.jsp");
			view.forward(request, response);
		} catch (SQLException e) {
			throw new ServletException(e);
		}

	}

}
