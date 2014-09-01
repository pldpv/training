package com.marakana.contacts.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marakana.contacts.entities.Address;
import com.marakana.contacts.entities.Contact;
import com.marakana.contacts.repositories.AddressRepository;
import com.marakana.contacts.repositories.ContactsRepository;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final AddressRepository addressRepository = new AddressRepository();
	private final ContactsRepository contactRepositor = new ContactsRepository();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			if (request.getParameter("add") != null) {
				request.getRequestDispatcher("/jsp/addContact.jsp").forward(
						request, response);
			} else {
				// get contact id from request and populate model with
				// contact and address
				populateModelFromContactId(request);
				
				// dispatch either to the edit page or to the contact view
				if (request.getParameter("edit") != null) {
					request.getRequestDispatcher("jsp/editContact.jsp")
					.forward(request, response);
				} else {
					request.getRequestDispatcher("jsp/viewContact.jsp")
							.forward(request, response);
				}
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}

	}

	private void populateModelFromContactId(HttpServletRequest request)
			throws SQLException {
		long id = Long.parseLong(request.getParameter("id"));
		Contact contact = contactRepositor.find(id);
		Address address = addressRepository.find(contact.getAddressId());
		request.setAttribute("contact", contact);
		request.setAttribute("address", address);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			if (request.getParameter("add") != null) {
				
				// create new contact and address from form parameters, and persist
				Address address = new Address(request.getParameter("street"),
						request.getParameter("city"),
						request.getParameter("state"),
						request.getParameter("zip"));

				addressRepository.create(address);
				Contact contact = new Contact(request.getParameter("name"),
						address.getId());
				contactRepositor.create(contact);
				
				// redirect to contact view page
				response.sendRedirect("contact?id=" + contact.getId());
			
			} else if (request.getParameter("edit") != null) {
				
				// looks up for exist contact and address, update and  persist
				long id = Long.parseLong(request.getParameter("id"));
				Contact contact = contactRepositor.find(id);
				Address address = addressRepository.find(contact.getAddressId());
				contact.setName(request.getParameter("name"));
				address.setStreet(request.getParameter("street"));
				address.setCity(request.getParameter("city"));
				address.setState(request.getParameter("state"));
				address.setZip(request.getParameter("zip"));
				addressRepository.update(address);
				contactRepositor.update(contact);
				
				// redirect to contact view page
				response.sendRedirect("contact?id=" + contact.getId());
			
			}else if(request.getParameter("delete") != null){
				long id = Long.parseLong(request.getParameter("id"));
				Contact contact = contactRepositor.find(id);
				Address address = addressRepository.find(contact.getAddressId());
				contactRepositor.delete(contact);
				addressRepository.delete(address);
				response.sendRedirect("contacts");
			}else {
				super.doPost(request, response);
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}

	}
}
