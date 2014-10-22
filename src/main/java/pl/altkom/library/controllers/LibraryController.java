package pl.altkom.library.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.altkom.library.dao.LibraryDao;
import pl.altkom.library.model.Book;


@Controller
public class LibraryController {

	@Autowired
	private LibraryDao md;

	@RequestMapping(value = "/library", method = RequestMethod.GET)
	public String library(Locale locale, Model model, HttpServletRequest request) {
		boolean zmiana = false;
		int id = 0;
		int atrybut = 0;
		String wyrazenie = "";
		
		if (request.getParameter("filter") != null) {
			System.out.println(request.getParameter("wyrazenie"));
			atrybut = Integer.parseInt(request.getParameter("kategoria"));
			wyrazenie = request.getParameter("wyrazenie");
		}
		
		if ((request.getParameter("sort") != null)) {
			md.setSort(Integer.parseInt(request.getParameter("sort")));
		}

		if ((request.getParameter("id") != null)
				&& (request.getParameter("action") != null)) {
			if (request.getParameter("action").equals("delete")) {
				md.removeBook(Integer.parseInt(request.getParameter("id")));
			}
			if (request.getParameter("action").equals("update")) {
				zmiana = true;
				id = Integer.parseInt(request.getParameter("id"));
				model.addAttribute("book", md.getBook(id));
			}
		}

		
		model.addAttribute("library", md.getAllSortedBook(atrybut, wyrazenie));
		model.addAttribute(new Book());
		return "library";
	}

	@RequestMapping(value = "/library", method = RequestMethod.POST)
	public String libraryDodaj(Locale locale, @Valid @ModelAttribute  
                Book book, BindingResult result,Model model) {
            if (result.hasErrors()) {
            model.addAttribute("library", md.getAllSortedBook(0, ""));
            return "library";
            }
                       System.out.println(book);
		md.addBook(book);
		model.addAttribute("library", md.getAllSortedBook(0, ""));
		model.addAttribute(new Book());
		return "library";
	}

	@RequestMapping(value = "/libraryzmien", method = RequestMethod.GET)
	public String libraryDodaj(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		model.addAttribute(md.getBook(id));
		return "libraryzmien";
	}

	@RequestMapping(value = "/libraryzmien", method = RequestMethod.POST)
	public String libraryDodaj(@ModelAttribute Book book, Model model) {
		md.updateBook(book);
		model.addAttribute(new Book());
		model.addAttribute("library", md.getAllSortedBook(0, ""));
		model.addAttribute(new Book());
		return "library";
	}

}
