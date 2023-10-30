package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wordnet.genshin.dao.DepartmentMapper;
import wordnet.genshin.domain.Department;
import wordnet.genshin.service.DepartmentService;

import java.util.List;

@Service(value = "departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> selectAll() {
        return departmentMapper.selectByExample(null);
    }

    @Override
    public Integer deleteOne(Integer eid) {
        return null;
    }
}
