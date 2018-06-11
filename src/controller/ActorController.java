package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import da.ActorResource;
import model2.Actor;

/**
 * Servlet implementation class ActorController
 */
@WebServlet("/ActorController")
public class ActorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private static final String LIST_ACTORS="/actor.jsp";

	private static final String FORM_STUDENT = "/formactor.jsp";
	
	private ActorResource actorResourse ;


	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActorController() {
        super();
        actorResourse =new ActorResource();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String action=request.getParameter("myaction");
	 String forward="";
		
		if(action.equalsIgnoreCase("listOfActors"))
		{
			forward=LIST_ACTORS;
			List<Actor> list=actorResourse.getAll();
			request.setAttribute("actorim", list);
		}
		
		else if(action.equalsIgnoreCase("delete"))
		{
			forward=LIST_ACTORS;
			String actorID=request.getParameter("id");
			
			actorResourse.delete(Integer.parseInt(actorID));
			List<Actor> list=actorResourse.getAll();
			
			request.setAttribute("actorim", list);
		}
		else if(action.equalsIgnoreCase("update"))
		{
		  forward=FORM_STUDENT;
		  String actorID=request.getParameter("id");
		  Actor actor=actorResourse.getByID(Integer.parseInt(actorID));
		  request.setAttribute("sahkan", actor);
		  
		}
	 RequestDispatcher dispatcher=request.getRequestDispatcher(forward);
	 dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        request.setCharacterEncoding("UTF-8");
		
		String id=request.getParameter("id_param");
		String f_name=request.getParameter("f_name_param");
		String l_name=request.getParameter("l_name_param");
		String last_update=request.getParameter("update_param");

		Actor actor=actorResourse.getByID(Integer.parseInt(id));
		actor.setFirstName(f_name);
        actor.setLastName(l_name);
        actor.setLastUpdate(Timestamp.valueOf(last_update));
        actorResourse.update(actor);
        List<Actor> list=actorResourse.getAll();
		request.setAttribute("actorim", list);
		RequestDispatcher dispatcher=request.getRequestDispatcher(LIST_ACTORS);
		dispatcher.forward(request, response);

	}

}
