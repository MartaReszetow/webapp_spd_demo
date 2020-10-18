package pl.MR.javagdy.webbappka.controller;

import pl.MR.javagdy.webbappka.database.EntityDao;
import pl.MR.javagdy.webbappka.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// http://localhost:8080/webappka/students->doGet
@WebServlet("/students") // <-nie zapomnij o sashu na początku bo nei zadziała
                        // <- nie zpaomnij o adnotacji bo nie zadziałą
public class StudentListServlet extends HttpServlet {

// zmienna z bazy danych
private final EntityDao<Student> studentEntityDao = new EntityDao<Student>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //przetwarzamy zapytanie
        //przekazujemy do request dispatcher'a, żeby da nas przetworzył stronę "student_list" i zwrócił ją użytkownikowi

        // pobieramy z bazy danych listę studentów, ładujemy je do atrybutów(żeby wyświetlić w html/jsp)
        List<Student> listOfStudents = studentEntityDao.findAll(Student.class);
        req.setAttribute("students",listOfStudents);

        req.getRequestDispatcher("/student_list.jsp").forward(req,resp);
    }


}
