package pl.MR.javagdy.webbappka.controller;

import pl.MR.javagdy.webbappka.database.EntityDao;
import pl.MR.javagdy.webbappka.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/student/details")
public class StudentDetailsServlet extends HttpServlet {
    private final EntityDao<Student> studentEntityDao = new EntityDao<Student>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentIdString = req.getParameter("id");
        if (studentIdString == null) {
            resp.sendRedirect(req.getContextPath() + "/students");
            return;
        }
        Long studentId = Long.parseLong(studentIdString);
        Optional<Student> studentOptional = studentEntityDao.findById(studentId, Student.class);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();

            req.setAttribute("studentToDisplay", student);
            req.getRequestDispatcher("/student_details.jsp").forward(req, resp);
        }else{
            resp.sendRedirect(req.getContextPath() + "/students");
        }
    }
}
