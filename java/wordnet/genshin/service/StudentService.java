package wordnet.genshin.service;

import wordnet.genshin.domain.Student;

public interface StudentService {
    // 按照主键查询一名学生信息
    public Student selectOne(Integer id);
    // 按照主键删除一名学生以及对应的成绩信息
    public Integer deleteOne(Integer id);
}