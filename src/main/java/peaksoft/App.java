package peaksoft;

import peaksoft.models.Course;
import peaksoft.service.CourseService;
import peaksoft.service.impl.CourseServiceImpl;

import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      CourseServiceImpl courseService = new CourseServiceImpl();

      //courseService.createTableCourse();
        //System.out.println(courseService.saveCourse(new Course("Kani","bad",9)));
        //System.out.println(courseService.getById(new Scanner(System.in).nextLong()));
        //System.out.println(courseService.deleteCourse(new Scanner(System.in).nextLong()));
       // System.out.println(courseService.updateCourse(new Scanner(System.in).nextLong(),new Course("Arslan","Good",12)));
        //System.out.println(courseService.groupCourseByName("Arslan"));
        //System.out.println(courseService.getLongestCourse());

    }



}
