package wordnet.genshin.controller;

//基于SpringMVC 框架的controller通过不同的路径映射不同的方法实现调用【路由】

//发布地址：  http://localhost:8080/ssmDemo_war/
// controller映射地址是  student  完整地址是http://localhost:8080/ssmDemo_war/student
// 方法名映射地址是     opt   整地址是http://localhost:8080/ssmDemo_war/student/opt
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import wordnet.genshin.domain.Student;
import wordnet.genshin.service.StudentService;
import wordnet.genshin.utils.MessageAndData;

@RestController    //支持RESTful风格，返回给前端  JSON
@RequestMapping(value = "student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "opt/{stid}",method = RequestMethod.GET)
    public MessageAndData cha(@PathVariable(value = "stid") int id){
        Student student = studentService.selectOne(id);
        //MessageAndData messageAndData = new MessageAndData();
        if (student == null){
          return MessageAndData.error().setMessage("查询学生信息失败");
        }else{
          return MessageAndData.success().add("stu",student);
        }
        //return messageAndData;
    }

    @RequestMapping(value = "delete/{stid}",method = RequestMethod.DELETE)
    public MessageAndData shan(@PathVariable(value = "stid")int id){
        Integer integer = studentService.deleteOne(id);
        return MessageAndData.success().add("ret",integer);
    }
}
