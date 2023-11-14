package wordnet.genshin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import wordnet.genshin.dao.UserImageMapper;
import wordnet.genshin.service.*;
import wordnet.genshin.utils.MessageAndData;

import wordnet.genshin.domain.Images;
import wordnet.genshin.utils.PlanInfo;

import javax.servlet.http.HttpSession;
import java.util.*;

import wordnet.genshin.utils.Image;
import wordnet.genshin.utils.UserInfo;

@Controller

@RequestMapping(value = "/Users")
public class GuserController {
    @Autowired
    private GuserService guserService;

    @Autowired
    private TofelService tofelService;
    @Autowired
    private Tofel_lService tofelLService;
    @Autowired
    private IeltsService ieltsService;
    @Autowired
    private Ielts_lService ieltsLService;
    @Autowired
    private GreService greService;
    @Autowired
    private Gre_lService greLService;
    @Autowired
    private Cet4Service cet4Service;
    @Autowired
    private Cet4_lService cet4LService;
    @Autowired
    private Cet6Service cet6Service;
    @Autowired
    private Cet6_lService cet6LService;
    @Autowired
    private ZkService zkService;
    @Autowired
    private Zk_lService zkLService;
    @Autowired
    private GkService gkService;
    @Autowired
    private Gk_lService gkLService;
    @Autowired
    private ImageService imageService;
    @Autowired
   private CalendarService calendarService;


    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView optAdd(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "mail") String mail,
            HttpSession httpSession
    ){
        ModelAndView modelAndView=new ModelAndView();
        boolean status = guserService.addUser(name,password,mail);
//        if(status){
//            String targetUrl = (String) httpSession.getAttribute("targetUrl");
//            if (targetUrl != null && !targetUrl.isEmpty()) {
//                modelAndView.setViewName("redirect:" + targetUrl); //这里可能会重定向出问题
//            } else {
//                modelAndView.setViewName("redirect:../Home.html");
//            }
//        }
//        else {
//            //modelAndView.setViewName("redirect:../Login.html");
//            modelAndView.addObject("error", "该用户名已存在");
//        }
        return modelAndView;
    }
//    @RequestMapping(value = "/register",method = RequestMethod.GET)
//    public MessageAndData optAdd(Guser guser){
//        boolean b = guserService.addUser(guser.getUname(),guser.getUpassword(),guser.getUmail());
//        if(b){
//            return MessageAndData.success().setMessage("用户创建成功");
//        }else{
//            return MessageAndData.error().setMessage("已存在同名用户");
//        }
//    }
//    @RequestMapping("/login")
//    public ModelAndView login(Guser guser, HttpSession httpSession){
//        //ModelAndView  对象是spring封装model和view的通用容器
//        ModelAndView modelAndView = new ModelAndView();
//
//        //调用service进行登录验证
//        boolean status  = guserService.loginCheck(guser);
//        if(status){
//            //登录验证成功
//            //http是一个无状态协议，为了保持通信双方的身份识别，一般采用  session（cookie）
//            httpSession.setAttribute("EMP_SESSION",guser);
//            modelAndView.setViewName("redirect:../Home.html");//
//        }else{
//            //回到登录页面
//            modelAndView.setViewName("redirect:../Register.html");//设置视图页   , 默认springmvc使用了视图解析器，会自动填充前缀和后缀
//        }
//
//        return modelAndView;
//    }

@RequestMapping(value = "/login",method = RequestMethod.POST)
public ModelAndView login(
        @RequestParam("name") String name,
        @RequestParam("password") String password,
        HttpSession httpSession
) {
    ModelAndView modelAndView = new ModelAndView();
//Guser guser=new Guser();
//guser.setUname(name);
//guser.setUpassword(password);
    // 调用service进行登录验证
   // System.out.println(guser);
        System.out.println(name+" and "+password);
    boolean status = guserService.loginCheck_(name,password);
    //boolean status =true;
    if (status) {
        // 登录验证成功
        // 将用户对象存储在session中
        httpSession.setAttribute("UserName", name);

        String targetUrl = (String) httpSession.getAttribute("targetUrl");
        System.out.println("controller: "+targetUrl);
        if (targetUrl != null && !targetUrl.isEmpty()) {
            modelAndView.setViewName("redirect:.." + targetUrl);
        } else {
            modelAndView.setViewName("redirect:../Home.html");
        }
    }else {
        System.out.println("用户名或密码错误！");
        modelAndView.setViewName("redirect:../Login.html");
    }

    return modelAndView;
}

    @ResponseBody
    @RequestMapping(value = "/resetpassword",method = RequestMethod.POST)
    public ModelAndView resetPass(
            @RequestParam("name") String name,
            @RequestParam("prePassword") String prePassword,
            @RequestParam("newPassword") String newPassword,
            HttpSession httpSession
    ) {
        ModelAndView modelAndView = new ModelAndView();
      //  System.out.println(name+" and "+password);
        boolean status = guserService.loginCheck_(name,prePassword);
        if (status) {
            guserService.resetPass(name,newPassword);
            modelAndView.setViewName("redirect:../Login.html");
        }else {
            System.out.println("用户名或原密码错误！");
        }

        return modelAndView;
    }

    @RequestMapping("/setWordbook")
    public MessageAndData setWordbook(
            @RequestParam(value = "book") String book,
            @RequestParam(value = "daily",defaultValue = "30") Integer daily,
            HttpSession httpSession) {

        String username = (String) httpSession.getAttribute("UserName"); // 获取保存在session中的guser对象
    System.out.println(username);
    System.out.println(book);
        if (username != null) {

            // 在这里使用username和book进行后续操作
            boolean status = guserService.setWordbook(book, username,daily);//username一般放最后一个参数

            if (status) {
                return MessageAndData.success().setMessage("设置Wordbook成功");
            } else {
                return MessageAndData.error().setMessage("设置Wordbook失败");
            }
        } else {
            // 用户未登录或session失效，可以进行相应处理
            return MessageAndData.error().setMessage("用户未登录或session失效");
        }
    }

    @RequestMapping("setGoal")
    public MessageAndData setGoal(
            @RequestParam(value = "goal")Integer goal,
            HttpSession httpSession){
        String username = (String) httpSession.getAttribute("UserName");
        if(username!=null){
            boolean status=guserService.setUdaily(goal,username);
            if (status) {
                return MessageAndData.success().setMessage("设置Wordbook成功");
            } else {
                return MessageAndData.error().setMessage("设置Wordbook失败");}
        }else {
            // 用户未登录或session失效，可以进行相应处理
            return MessageAndData.error().setMessage("用户未登录或session失效");
        }
    }

    @ResponseBody
    @RequestMapping("/wordrecord")   //单词本关闭时调用，记录最后背的单词
    public MessageAndData wordRecord(
                                       HttpSession httpSession){
        String username = (String) httpSession.getAttribute("UserName");
         Long wid=(Long) httpSession.getAttribute("TodayFinal");
        boolean status=guserService.wordRecord(wid,username);
        if(status)
            return  MessageAndData.success().setMessage("记录更新成功");
        else
            return MessageAndData.error().setMessage("记录更新失败");

    }

    @RequestMapping("/checkWordnet")
    public ModelAndView checkWordnet(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView();
       String uname=(String) httpSession.getAttribute("UserName");
        String bookUrl=null;
        if(guserService.checkBook(uname)) {
            bookUrl = guserService.getWordnet(uname);
            modelAndView.setViewName("redirect:http://localhost:8080/SSM_war_exploded/table.html"); //跳转到对应单词本的地址
        }
        else
            modelAndView.setViewName("redirect:http://localhost:8080/SSM_war_exploded/Wordnetlist.html");

        return modelAndView;
    }

    @RequestMapping(value="tablet")  //已选择单词本情况下,每次刷新页面调用一次
    @ResponseBody
    public MessageAndData tablet(
            HttpSession httpSession
    ){
        String uname=(String) httpSession.getAttribute("UserName");
        Integer current=(Integer) httpSession.getAttribute("Current");
        Integer todayFinal=(Integer) httpSession.getAttribute("TodayFinal");
        System.out.println("current： "+current);
        Integer from=0;
        if(current!=null){
            from=current;
        }
        else {
            from = guserService.getUfinalword(uname).intValue()+1;
            current=from;
        }//取得最后记录的单词位置
        if(todayFinal==null){
            httpSession.setAttribute("TodayFinal",current);
            todayFinal=current;
        }
        int to=0;
        if(guserService.getUdaily(uname).toString().isEmpty()){
            to=30;
    }
        else {
            to= guserService.getUdaily(uname)+from;
        }//取得每日计划

        if (current>todayFinal){
            httpSession.setAttribute("TodayFianl",current);
        }

        String book=guserService.getWordnet(uname);
        List<?> dataList=new ArrayList<>();
        if (Objects.equals(book, "tofel")) {
        dataList=tofelService.selectMuti(from,to,uname);
        } else if (Objects.equals(book, "tofel_l")) {
            dataList=tofelLService.selectMuti(from,to,uname);
        } else if (Objects.equals(book, "gre")) {
            dataList = greService.selectMuti(from, to,uname);
        } else if (Objects.equals(book, "gre_l")) {
            dataList = greLService.selectMuti(from, to,uname);
        } else if (Objects.equals(book, "zk")) {
            dataList = zkService.selectMuti(from, to,uname);
        }else if (Objects.equals(book, "zk_l")) {
            dataList = zkLService.selectMuti(from, to,uname);
        } else if (Objects.equals(book, "gk")) {
            dataList = gkService.selectMuti(from, to,uname);
        } else if (Objects.equals(book, "gk_l")) {
            dataList = gkLService.selectMuti(from, to,uname);
        }else if (Objects.equals(book, "ielts")) {
            dataList = ieltsService.selectMuti(from, to,uname);
            System.out.println("ielts_l");
        } else if (Objects.equals(book, "ielts_l")) {
            dataList = ieltsLService.selectMuti(from, to,uname);
        }else if (Objects.equals(book, "cet4")) {
            dataList = cet4Service.selectMuti(from, to,uname);
        } else if (Objects.equals(book, "cet4_l")) {
            dataList = cet4LService.selectMuti(from, to,uname);
        }else if (Objects.equals(book, "cet6")) {
            dataList = cet6Service.selectMuti(from, to,uname);
        }else if (Objects.equals(book, "cet6_l")) {
            dataList = cet6LService.selectMuti(from, to,uname);}

        httpSession.setAttribute("Current",from);

        if (dataList != null) {
            return MessageAndData.success().add("datalist",dataList);
        }else
            return MessageAndData.error().setMessage("获取失败！");
    }

    @ResponseBody
    @RequestMapping(value="nextpage") //往后翻页
    public MessageAndData nextpage(HttpSession httpSession){
        String uname=(String) httpSession.getAttribute("UserName");
        Integer current=(Integer) httpSession.getAttribute("Current");
        System.out.println("current2: "+current);
        Integer next=guserService.getUdaily(uname);
        //未注册单词本用户默认30
        current += Objects.requireNonNullElse(next, 30);
        httpSession.setAttribute("Current",current);
        System.out.println("往后翻的current： "+current);
        return MessageAndData.success().setMessage("下一页");
    }

    @ResponseBody
    @RequestMapping(value="prepage")  //往前翻页
    public MessageAndData prepage(HttpSession httpSession){
        String uname=(String) httpSession.getAttribute("UserName");
        Integer current=(Integer) httpSession.getAttribute("Current");

        Integer next=guserService.getUdaily(uname);
        current -= Objects.requireNonNullElse(next, 30);

        httpSession.setAttribute("Current",current);
        return MessageAndData.success().setMessage("上一页");
    }

    @ResponseBody
    @RequestMapping(value="browser/nextone") //往前一个
    public MessageAndData nextone(HttpSession httpSession){
        String uname=(String) httpSession.getAttribute("UserName");
        Integer current=(Integer) httpSession.getAttribute("Current");
        Integer todayFinal=(Integer) httpSession.getAttribute("TodayFinal");
        Integer next=guserService.getUdaily(uname);
        current++;
        if (current>todayFinal){
            httpSession.setAttribute("TodayFianl",current);
        }
        httpSession.setAttribute("Current",current);
        return MessageAndData.success().setMessage("下一页");
    }

    @ResponseBody
    @RequestMapping(value="browser/preone")  //往后一个
    public MessageAndData preone(HttpSession httpSession){
        String uname=(String) httpSession.getAttribute("UserName");
        Integer current=(Integer) httpSession.getAttribute("Current");
        Integer next=guserService.getUdaily(uname);
        current--;
        System.out.println(current);
        httpSession.setAttribute("Current",current);
        return MessageAndData.success().setMessage("下一页");
    }

    @ResponseBody
    @RequestMapping(value = "plan")
    public MessageAndData showPlan(HttpSession httpSession){
        String uname=(String) httpSession.getAttribute("UserName");
        PlanInfo info=new PlanInfo();
        String bname= guserService.getWordnet(uname);
        info.setBookName(String.format("%s.jpg", bname));
        info.setGoal(guserService.getUdaily(uname));
        info.setLearned(guserService.getUfinalword(uname).intValue());
        System.out.println(bname);
        Image pic=new Image();
        pic.setFileName(bname);
        String base64ImageData = Base64.getEncoder().encodeToString(imageService.getBookImage(String.format("%s.jpg", bname)).getData());
        pic.setBase64ImageData(base64ImageData);
        info.setImage(pic);

        if(Objects.equals(bname, "tofel") || Objects.equals(bname, "tofel_l"))
            info.setSum(6974);
        if(Objects.equals(bname, "zk") || Objects.equals(bname, "zk_l"))
            info.setSum(1603);
        if(Objects.equals(bname, "gk") || Objects.equals(bname, "gk_l"))
            info.setSum(3677);
        if(Objects.equals(bname, "cet4") || Objects.equals(bname, "cet4_l"))
            info.setSum(3849);
        if(Objects.equals(bname, "cet6") || Objects.equals(bname, "cet6_l"))
            info.setSum(5407);
        if(Objects.equals(bname, "ielts") || Objects.equals(bname, "ielts_l"))
            info.setSum(5040);
        if(Objects.equals(bname, "gre") || Objects.equals(bname, "gre_l"))
            info.setSum(7504);

        return MessageAndData.success().add("PlanInfo",info);
    }

    @ResponseBody
    @RequestMapping(value = "information")
    public UserInfo showUserInfo(HttpSession httpSession){
        String uname=(String) httpSession.getAttribute("UserName");
        UserInfo userInfo=new UserInfo();

        userInfo.setCalendarList(calendarService.showByUser(uname));
        Image pic=new Image();
        // 将图像数据转换为Base64编码
        String base64ImageData = Base64.getEncoder().encodeToString(imageService.getSculptureByUname(uname).getData());
        pic.setBase64ImageData(base64ImageData);
        userInfo.setSculpture(pic);

        return userInfo;
    }


}
