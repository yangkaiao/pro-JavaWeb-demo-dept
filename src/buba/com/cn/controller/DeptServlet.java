package buba.com.cn.controller;

import buba.com.cn.entity.Department;
import buba.com.cn.service.DeptService;
import buba.com.cn.service.Impl.DeptServiceImpl;
import buba.com.cn.utils.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class DeptServlet extends ViewBaseServlet {
    DeptService deptService = new DeptServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        if (req.getParameter("method").equals("findDepartments")){
            this.findDepartments(req, resp);
        }
        if (req.getParameter("method").equals("addDept")){
            processTemplate("add",req,resp);
        }
        if (req.getParameter("method").equals("addsubmit")){
            this.addsubmit(req, resp);
        }
        if (req.getParameter("method").equals("delDept")){
            this.delDept(req, resp);
        }
        if (req.getParameter("method").equals("upDept")){
            this.upDept(req, resp);
        }
    }


    ///获取指定页码上的库存列表信息.每页显示5条 分页查询
    private void findDepartments(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //分页查询
        int pageNo = 1;
        String pageNoStr = req.getParameter("pageNo");
        if(pageNoStr!=null){
            pageNo = Integer.parseInt(pageNoStr);
        }
        HttpSession session = req.getSession();
        session.setAttribute("pageNo",pageNo);

        //统计一共有多少页
        int count = deptService.DeptCount();//总条数
        //表中所有数据，总共条数，以下是设置的尾页
        System.out.println(count);
        int pageCount = (count+5-1)/5; //这个计算过程是，统计能够分出多少页 如果总条数有8条，（8+5-1）/5 = 2 ，意思就是最多有两页
        System.out.println(pageCount);
        session.setAttribute("pageCount",pageCount);


        List<Department> departments = deptService.findDepartments(pageNo);
        req.setAttribute("deptList",departments);
        processTemplate("select",req,resp);
    }


    private void addsubmit(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String[] submits = req.getParameterValues("submit");
        for (String submitted : submits){
            System.out.println(submitted);
            if(submitted.equals("保存")){
                String id = req.getParameter("id");
                String num = req.getParameter("num");
                String name = req.getParameter("name");
                String pro = req.getParameter("pro");
                String peo = req.getParameter("peo");
                String des = req.getParameter("des");
                Department department = new Department(Integer.valueOf(id),num,name,pro,Integer.valueOf(peo),des);
                deptService.addDept(department);
                this.findDepartments(req,resp);
            }
            if(submitted.equals("取消")){

                this.findDepartments(req, resp);
            }
        }
    }

    //删除和编辑都调这个方法
    private void delDept(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] delUps = req.getParameterValues("DelUp");//点击提交的是 编辑和删除按钮 分别点击哪个

        String[] checkids = req.getParameterValues("checkid");//这个是获取多选框选中的id进行编辑或删除

        for(String del : delUps){
            if(del.equals("删除")){

                if (checkids!=null) {
                    for(String checkid : checkids){
                        deptService.delDept(Integer.valueOf(checkid));
                        System.out.println(checkid);
                    }
                    this.findDepartments(req, resp);
                }else{
                    this.findDepartments(req, resp);
                }
            }
            if(del.equals("编辑")){
                System.out.println("正在编辑");

                if (checkids!=null) {
                    for(String checkid : checkids){
                        //查询一条数据
                        Department departmentByDeptId = deptService.findDepartmentByDeptId(Integer.valueOf(checkid));
                        System.out.println(checkid);
                        req.setAttribute("selList",departmentByDeptId);
                        System.out.println(departmentByDeptId);
                        processTemplate("update",req,resp);

                    }
                }

            }

        }


    }
    private void upDept(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String[] submits = req.getParameterValues("submit");
        for (String submitted : submits){
            System.out.println(submitted);
            if(submitted.equals("保存")){
                String id = req.getParameter("id");
                String num = req.getParameter("num");
                String name = req.getParameter("name");
                String pro = req.getParameter("pro");
                String peo = req.getParameter("peo");
                String des = req.getParameter("des");
                Department department = new Department(Integer.valueOf(id),num,name,pro,Integer.valueOf(peo),des);
                int i = deptService.upDept(department);
                this.findDepartments(req,resp);
            }
            if(submitted.equals("取消")){
                this.findDepartments(req, resp);
            }
        }
    }
}
