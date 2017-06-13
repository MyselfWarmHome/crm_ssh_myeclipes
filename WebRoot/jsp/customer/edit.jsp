<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>

<script type="text/javascript">
	$(function(){
		//发送ajax请求
		$.post("${pageContext.request.contextPath }/dict_findByCode.action",{"dict_type_code":"006"},function(data){
			//遍历
			$(data).each(function(i,n){
				//i代表索引 n代表json对象
				//alert(this.dict_item_name);
				//alert(i+":"+n.dict_item_name);
				
				//获取值栈中的值
				var $vsId = "${model.level.dict_id}";
				//值栈中的id和遍历的id相同，让其option处于选中的状态
				if($vsId == this.dict_id){
					$("#level").append("<option value='"+this.dict_id+"' selected>"+this.dict_item_name+"</option>");
				}else{
					$("#level").append("<option value='"+this.dict_id+"'>"+this.dict_item_name+"</option>");
				}
			});
		},"json");
		
		//客户的来源
		$.post("${pageContext.request.contextPath }/dict_findByCode.action",{"dict_type_code":"002"},function(data){
			//遍历
			$(data).each(function(i,n){
				//i代表索引 n代表json对象
				//alert(this.dict_item_name);
				//alert(i+":"+n.dict_item_name);
				
				//获取值栈中的值
				var $vsId = "${model.source.dict_id}";
				//值栈中的id和遍历的id相同，让其option处于选中的状态
				if($vsId == this.dict_id){
					$("#sourceId").append("<option value='"+this.dict_id+"' selected>"+this.dict_item_name+"</option>");
				}else{
					$("#sourceId").append("<option value='"+this.dict_id+"'>"+this.dict_item_name+"</option>");
				}
				
			});
		},"json");
	});

</script>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<!-- 需要上传文件 -->
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/customer_update.action"
		method=post enctype="multipart/form-data">
		<input type="hidden" name="cust_id" value="${model.cust_id }"/>
		<!-- 隐藏上传文件的路径  -->
		<input type="hidden" name="filepath" value="${model.filepath }"/>
		
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background=${pageContext.request.contextPath }/images/new_020.jpg
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
								<TD class=manageHead>当前位置：客户管理 &gt; 修改客户</TD>
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
											style="WIDTH: 180px" maxLength=50 name="cust_name" value="${model.cust_name }">
								</td>
								<td>客户级别 ：</td>
								<td>
								<select name="level.dict_id" id="level"></select> 
								</td>
							</TR>
							
							<TR>
								<td>信息来源：</td>
								<td>
									<select name="source.dict_id" id="sourceId"></select>
								</td>
								<td>联系人：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_linkman" value="${model.cust_linkman }">
								</td>
							</TR>
							<TR>
								
								
								<td>固定电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_phone" value="${model.cust_phone }">
								</td>
								<td>移动电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_mobile" value="${model.cust_mobile }">
								</td>
							</TR>
							
							<TR>
								<td>联系地址 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_address" value="${model.cust_address }">
								</td>
								<td>邮政编码 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_zip" value="${model.cust_zip }">
								</td>
							</TR>
							<TR>
								<td>客户传真 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_fax" value="${model.cust_fax }">
								</td>
								<td>客户网址 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_website" value="${model.cust_website }">
								</td>
							</TR>
							
							<tr>
								<td colspan="1">客户资历:</td>
								<td colspan="3" style="margin-left: auto">
									<INPUT type="file" name="upload"/>
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
