package pl.MR.javagdy.webbappka.controller;

import pl.MR.javagdy.webbappka.database.EntityDao;
import pl.MR.javagdy.webbappka.model.Grade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@WebServlet("/grade/remove")
public class GradeRemoveServlet extends HttpServlet {

    EntityDao<Grade> gradeEntityDao = new EntityDao<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idGradeString = req.getParameter("id");

        Long gradeId = Long.parseLong(idGradeString);
        Long studentId = null;
        Optional<Grade> gradeOptional = gradeEntityDao.findById(gradeId, Grade.class);
        if (gradeOptional.isPresent()) {
            Grade grade = gradeOptional.get();
            studentId = grade.getStudent().getId();
            gradeEntityDao.delete(grade);

        }

        if (studentId != null) {
            resp.sendRedirect(req.getContextPath() + "/student/details?id="+studentId);
        }else{
            resp.sendRedirect(req.getContextPath() + "/students");
        }


    }
}
