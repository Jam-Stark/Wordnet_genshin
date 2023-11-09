package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.epss.dao.ScoreMapper;
import vip.epss.dao.StudentMapper;
import vip.epss.domain.ScoreExample;
import vip.epss.domain.Student;
import vip.epss.service.StudentService;
@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired   //自动注入IOC中的对象（单例）
    private StudentMapper studentMapper;
    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public Student selectOne(Integer id) {
        // dao  采用  ORM   框架  MyBatis，  通过动态代理，框架启动时自动生成实现类而且注入了    spring   IOC容器中，拿来即用

        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer deleteOne(Integer id) {
        //1 删 成绩表对应记录
        //1.1   创建条件类
        ScoreExample scoreExample = new ScoreExample();
        ScoreExample.Criteria criteria = scoreExample.createCriteria();
        criteria.andFstidEqualTo(id);//拼接条件
        //1.2   执行条件对应的sql
        scoreMapper.deleteByExample(scoreExample);

        //System.out.println(9/0);
        //2 删 学生表信息
        int i = studentMapper.deleteByPrimaryKey(id);
        return i;
    }
}
