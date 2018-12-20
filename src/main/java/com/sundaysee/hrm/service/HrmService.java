package com.sundaysee.hrm.service;



import java.util.List;

import com.mysql.cj.protocol.x.Notice;
import com.sundaysee.hrm.entity.Dept;
import com.sundaysee.hrm.entity.Document;
import com.sundaysee.hrm.entity.Employee;
import com.sundaysee.hrm.entity.Job;
import com.sundaysee.hrm.entity.User;
import com.sundaysee.hrm.tag.PageModel;

public interface HrmService {

    /**
     * 用户登陆
     * @param loginname
     * @param password
     * @return User对象 
     */
    User login(String loginname,String password);

    /**
     * 根据id查询用户
     * @param id
     * @return 用户对象
     */
    User findUserById(Integer id);

    /**
     * 返回所有用户
     */
    List<User> findUser(User user,PageModel pageModel);

    /**
     * 根据id删除用户
     */
    void removeUserById(Integer id);

    /**
     * 修改用户
     */
    void modifyUser(User user);

    /**
     * 添加用户
     */
    void addUser(User user);

    /**
     * 获取所有员工
     * @param employee 查询条件
     * @param pageModel 分页对象
     * @return 员工集合
     */
    List<Employee> findEmployee(Employee employee,PageModel pageModel);

    /**
     * 根据id删除员工
     * @param id 
     */
    void removeEmployeeById(Integer id);

    /**
     * 根据id查询员工
     * @param id 
     * @return 员工对象
     */
    Employee findEmployeeById(Integer id);

    /**
     * 添加员工
     * @param employee 员工对象
     */
    void addEmployee(Employee employee);

    /**
     * 修改员工
     * @param 员工对象
     */
    void modifyEmployee(Employee employee);

    /**
     * 获取所有部门，分页查询
     * @return dept对象的集合
     */
    List<Dept> findDept(Dept dept,PageModel pageModel);

    /**
     * 获取所有的部门
     * @return dept对象集合
     */
    List<Dept> findAllDept();

    /**
     * 根据id删除部门
     * @param id
     */
    void removeDeptById(Integer id);

    /**
     * 添加部门
     * @param dept部门对象
     */
    void addDept(Dept dept);

    /**
     * 根据id查询部门
     * @param id
     * @return 部门对象
     */
    Dept findDeptById(Integer id);

    /**
     * 修改部门
     * @param dept
     */
    void modifyDept(Dept dept);

    /**
     * 获取所有职位
     * @return job对象的集合
     */
    List<Job> findAllJob();

    /**
     * 获取所有职位，分页查询
     * @return job对象的集合
     */
    List<Job> findJob(Job job,PageModel pageModel);

    /**
     * 根据id删除职位
     */
    void removeJobById(Integer id);

    /**
     * 添加职位
     * @param id
     */
    void addJob(Job job);

    /**
     * 根据id查询职位
     * @param id
     * @return job对象
     */
    Job findJobById(Integer id);

    /**
     * 修改职位
     */
    void modifyJob(Job job);

    /**
     * 获取所有公告
     */
    List<Notice> findNotice(Notice notice,PageModel pageModel);

    /**
     * 根据id查询公告
     */
    Notice findNoticeById(Integer id);

    /**
     * 根据id删除公告
     */
    void removeNoticeById(Integer id);

    /**
     * 添加公告
     */
    void addNotice(Notice notice);

    /**
     * 修改公告
     */
    void modifyNotice(Notice notice);

    /**
     * 分页获取所有文档
     */
    List<Document> findDocument(Document document,PageModel pageModel);

    /**
     * 添加文档
     */
    void addDocument(Document document);

    /**
     * 根据id查找文档
     */
    Document findDocumentById(Integer id);

    /**
     * 根据id删除文档
     */
    void removeDocumentById(Integer id);

    /**
     * 修改文档
     */
    void modifyDocument(Document document);

}