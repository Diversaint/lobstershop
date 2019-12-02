<%
	int row = Integer.parseInt(request.getParameter("row"));
	int column = Integer.parseInt(request.getParameter("column"));
	String width = request.getParameter("width");
	String height = request.getParameter("height");
	String settingsTable = "<table align = 'center' border = '1'>";
	String settings = " align ='center' width= '" + width + "' height = '" + height + "' >";
	String columnTable = "<td" + settings;
	String yellow = "<td bgcolor = 'yellow'" + settings;
	String green = "<td bgcolor = 'green'" + settings;
	String blue = "<td bgcolor = 'blue'" + settings;
	String [][]array = new String [row][column];
	if(row > 0 && column > 0 && Integer.parseInt(height) > 0 && Integer.parseInt(width) > 0){
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				array[i][j] = "" + i + j;
			}
		}
		out.write("<h1 align ='center'><font color='green'>Table was created</font></h1>");
		out.write(settingsTable);
 		int k = 0;
		for (int i = 0; i < row; i++) {
			out.write("<tr>");
			for(int j = 0; j < column; j++){
				boolean isYellow = (i% 3 == 0 && i!= 0) || (j% 3 == 0 && j != 0);
				if(isYellow && j == k)
					out.write(green + array[i][j] + " </td>");
				else if(isYellow)
					out.write(yellow + array[i][j] + " </td>");
				else if(j == k)
					out.write(blue + array[i][j] + " </td>");
				else
					out.write(columnTable + array[i][j] + " </td>");
			}
			out.write("</tr>");
			k++;
		}
		out.write("</table>");
	} else {
		out.write("<h1 align = 'center'><font color = 'red'> Wrong data</font></h1>");
	}
	%>
