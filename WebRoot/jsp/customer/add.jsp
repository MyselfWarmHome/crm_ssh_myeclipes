<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<STYLE type=text/css>
.info{
	color:red;
}
.access{
	color:green;
}
</STYLE>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<script type="text/javascript">
	$(function(){
		//发送ajax请求
		$.post("${pageContext.request.contextPath }/dict_findByCode.action",{"dict_type_code":"006"},function(data){
			//遍历
			$(data).each(function(i,n){
				//i代表索引 n代表json对象
				//alert(this.dict_item_name);
				//alert(i+":"+n.dict_item_name);
				$("#level").append("<option value='"+this.dict_id+"'>"+this.dict_item_name+"</option>");
			});
		},"json");
		
		//客户的来源
		$.post("${pageContext.request.contextPath }/dict_findByCode.action",{"dict_type_code":"002"},function(data){
			//遍历
			$(data).each(function(i,n){
				//i代表索引 n代表json对象
				//alert(this.dict_item_name);
				//alert(i+":"+n.dict_item_name);
				$("#sourceId").append("<option value='"+this.dict_id+"'>"+this.dict_item_name+"</option>");
			});
		},"json");
		
		//验证上传文件的后缀
		$(":file").change(function(){
			var filepath = $(this).val();
			var startIndex =filepath.lastIndexOf(".");
			var end = filepath.substring(startIndex, filepath.length);
			if(end != ".jpg"  &&　end != ".txt"){
				$("#tip").addClass("info");
			}else{
				$("#tip").addClass("access");
			}
		});
	});
</script>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/customer_add.action"
		method=post enctype="multipart/form-data">
		

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 添加客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
						  
						    
							<TR>
								<td>客户名称：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_name">
								</td>
								<td>客户级别 ：</td>
								<td>
								<select name="level.dict_id" id="level"></select> 
								</td>
							</TR>
							
							<TR>
								
								<td>信息来源 ：</td>
								<td>
									<select name="source.dict_id" id="sourceId"></select>
								</td>
								<td>联系人：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_linkman">
								</td>
							</TR>
							
							<TR>
								
								
								<td>固定电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_phone">
								</td>
								<td>移动电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_mobile">
								</td>
							</TR>
							
							<TR>
								<td>联系地址 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_address">
								</td>
								<td>邮政编码 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_zip">
								</td>
							</TR>
							<TR>
								<td>客户传真 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_fax">
								</td>
								<td>客户网址 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_website">
								</td>
							</TR>
							<tr>
								<td colspan="1">客户资历:</td>
								<td colspan="3" style="margin-left: auto">
									<INPUT type="file" name="upload"/> <font style="" id="tip"><b>(上传文件必须为.jpg或者.txt格式)</b>></font>
								</td>
							</tr>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value=" 保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
