package com.example.phanthanhphuongcsis3275;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SessionAttributes({"id","name","dep","year","type","errMsg","errorMessage"})
@RequestMapping
@Controller
public class savingsController {
    DatabaseService service1;

    @Autowired
    Connection123 connect;
    //a mapping when someone enters file
    @RequestMapping(value = "/savingstable", method = RequestMethod.GET)
    public String showSavingsPage(ModelMap model, @RequestParam(defaultValue = "") String id) throws ClassNotFoundException, SQLException {

        service1 = new DatabaseService(connect.connect());
        model.addAttribute("todos",service1.display());
        List<Savingstable> filteredTodos = new ArrayList<Savingstable>();
        filteredTodos = (List) model.get("todos");
        model.put("id",filteredTodos.get(0).getCustno());
        model.put("name",filteredTodos.get(0).getCustname());
        model.put("dep",filteredTodos.get(0).getCdep());
        model.put("year",filteredTodos.get(0).getNyears());
        model.put("type",filteredTodos.get(0).getSavtype());
        return "savingstable";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showSavingsPage2(ModelMap model)  throws ClassNotFoundException, SQLException  {
        service1 = new DatabaseService(connect.connect());
        model.addAttribute("todos",service1.display());
        List<Savingstable> filteredTodos = new ArrayList<Savingstable>();
        filteredTodos = (List) model.get("todos");
        model.put("id",filteredTodos.get(0).getCustno());
        model.put("name",filteredTodos.get(0).getCustname());
        model.put("dep",filteredTodos.get(0).getCdep());
        model.put("year",filteredTodos.get(0).getNyears());
        model.put("type",filteredTodos.get(0).getSavtype());
        return "savingstable";
    }
    @RequestMapping(value ="/add-todo", method = RequestMethod.GET)
    public String showtodopage(){
        return "Savingser";
    }

    @RequestMapping(value ="/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @RequestParam String custno, @RequestParam String custname
    , @RequestParam double cdep, @RequestParam int nyears, @RequestParam String savtype) throws SQLException, ClassNotFoundException{
        if (!((service1.search(custno)) ==null)){
            model.put("errorMessage","Record Existing");
            return "redirect:/savingstable";
        }
        Savingstable cc = new Savingstable(custno, custname,cdep,nyears,savtype );
        service1.add(cc);
        model.clear();
        return "redirect:/savingstable";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(ModelMap model,  @RequestParam(defaultValue = "") String id) throws SQLException, ClassNotFoundException{

        model.put("id", id);
        Savingstable cc = service1.search(id);
        model.put("id",cc.getCustno());
        model.put("name",cc.getCustname());
        model.put("dep",cc.getCdep());
        model.put("year",cc.getNyears());
        model.put("type",cc.getSavtype());

        return "Savingsedit";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String showUpdate(ModelMap model,   @RequestParam String custno, @RequestParam String custname
            , @RequestParam double cdep, @RequestParam int nyears, @RequestParam String savtype) throws SQLException, ClassNotFoundException{
        String iid = (String) model.get("id");
        Savingstable cc = new Savingstable(custno,custname,cdep,nyears,savtype);
        service1.edit(cc,iid);
        return "redirect:/";
    }

    public String deleteTodo(ModelMap model, @RequestParam String id) throws SQLException, ClassNotFoundException {

        service1.delete(id);
        model.clear();
        return "redirect:/";
    }



}
