package item_management_crud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import item_management_crud.dto.itemRequestDto;
import item_management_crud.dto.itemResponseDto;
import item_management_crud.modal.itemBean;
import item_management_crud.persistence.dao.itemDao;

/**
 * Servlet implementation class updateItemServlet
 */
@WebServlet("/updateItemServlet")
public class updateItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		itemDao dao = new itemDao();
		itemRequestDto req = new itemRequestDto();
		req.setItemCode(code);
		itemResponseDto res = dao.selectOne(req);
		request.setAttribute("res", res);
		request.getRequestDispatcher("update_item.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		itemBean bean = new itemBean();
		bean.setItemCode(request.getParameter("code"));
		bean.setItemName(request.getParameter("name"));
		bean.setItemPrice(request.getParameter("price"));
		
		//Validation
		if(bean.getItemCode().equals("") || bean.getItemName().equals("") || bean.getItemPrice().equals("")) {
			request.setAttribute("error", "Fields cannot be blank!!");
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("update_item.jsp").forward(request, response);
		}else {
			itemDao dao = new itemDao();
			itemRequestDto dto = new itemRequestDto();
			dto.setItemCode(bean.getItemCode());
			dto.setItemName(bean.getItemName());
			dto.setItemPrice(Double.valueOf(bean.getItemPrice()));
			dao.updateData(dto);
			response.sendRedirect("displayItemServlet");
		}
	}

}
