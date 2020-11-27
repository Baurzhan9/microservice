package com.example.course.controller;


import com.example.course.model.Course;
import com.example.course.model.CourseCont;
//import com.example.course.repository.CourseRepository;
import com.example.course.service.impl.CourseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/index")
public class CourseListController {

    @Autowired
    private CourseInfoService courseInfoService;


//    @GetMapping("/{userId}")
//    public ResponseEntity<?> getCourseList(@PathVariable Long userId){
//        List<Course> userCourses = courseInfoService.getUserCourses(userId);
//
//        List<CourseList> userCourseList = new ArrayList<>();
//        for(Course course: userCourses){
//            CourseList courseList = new CourseList();
//            courseList.setCourseId(course.getId());
//            courseList.setTitle(course.getTitle());
//            courseList.setDescription(course.getDescription());
//
////            Rating rating = courseRatingService.getCourseRating(course.getId());
////            courseList.setRating(rating.getRating());
//            userCourseList.add(courseList);
//        }
//        return ResponseEntity.ok(userCourseList);
//    }


    @RequestMapping(value = {"", "/index"})
//    @GetMapping("/home")
    public String home(Model model, HttpServletRequest request) {
//    public ResponseEntity<?> getCourseList(){
        List<Course> counts = courseInfoService.allCourse();
        List<CourseCont> courseLists = new ArrayList();

        for (Course course : counts) {
            CourseCont courseList = new CourseCont();
            courseList.setId(course.getId());
            courseList.setTitle(course.getTitle());
            courseList.setDescription(course.getDescription());

            courseLists.add(courseList);
        }


        model.addAttribute("courses", courseLists);

        return "index";
//        return ResponseEntity.ok(courseLists);
    }


    @RequestMapping("/courses")
//    @HystrixCommand(fallbackMethod = "planb", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")
//    })
    public String course(Model model) {
        List<Course> counts = courseInfoService.allCourse();
        List<CourseCont> courseLists = new ArrayList();

        for (Course course : counts) {
            CourseCont courseList = new CourseCont();
            courseList.setId(course.getId());
            courseList.setTitle(course.getTitle());
            courseList.setDescription(course.getDescription());
            courseLists.add(courseList);
        }

        model.addAttribute("courses", courseLists);

        return "courses";
    }


//    @GetMapping(value = {"/course/{id}"})
//    public String home(Model model, HttpServletRequest request, @PathVariable Long id) {
//        ResponseEntity<?> obj = courseInfoService.findById(id);
//        model.addAttribute("examName", obj.getTitle());
//        model.addAttribute("examDesc", obj.getDescription());
//        model.addAttribute("examId", obj.getId());
//        return "page3";
//    }

//    private String planb() {
//        return "Sorry our Systems are busy! try again later.";
//    }

}
