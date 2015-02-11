<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/config.jsp"%>
	<title>用户列表</title>
    <script type="text/javascript">
	    $(function() {
	    	/*$('#redeploy').button({
	    		icons: {
	    			primary: 'ui-icon-refresh'
	    		}
	    	});
	    	$('#deploy').button({
	    		icons: {
	    			primary: 'ui-icon-document'
	    		}
	    	}).click(function() {
	    		$('#deployFieldset').toggle('normal');
	    	});*/
	    	
	    	$("#deploy").click(function(){
	    		$("#uploadForm").dialog('open');
	    		return false;
	    	});
	    	
	    	$('#uploadForm').dialog({ 
	    		buttons:[{ 
	    			text:'发布', 
	    			iconCls:'icon-ok', 
	    			handler: function(){ 
	    				$('#uploadForm').submit();
	    			} 
	    		},{ 
	    			text:'关闭',
	    			iconCls:"icon-cancel", 
	    			handler:function(){ 
	    				$('#uploadForm').dialog('close'); 
	    			}
	    		}] 
	    	}); 
	    });
    </script>
</head>
<body>
	<c:if test="${not empty message}">
	<div class="ui-widget">
			<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;"> 
				<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
				<strong>提示：</strong>${message}</p>
			</div>
		</div>
	</c:if>
	
	<!-- 部署新流程窗口 -->
	<form id="uploadForm" class="easyui-dialog" title="部署新流程" style="width:400px; height:100px;padding:10px"
            data-options="iconCls: 'icon-save', buttons: '#dlg-buttons', closed: 'true'" action="${ctx }/workflow/deploy.do" method="post" enctype="multipart/form-data">
        <div><b>支持文件格式：</b>zip、bar、bpmn、bpmn20.xml</div>
		<input type="file" name="file" />
    </form>
    
    <table id="dg">
    </table>
    
    <script type="text/javascript">
        function changeP(){
            var dg = $('#dg');
            dg.datagrid('loadData',[]);
            dg.datagrid({pagePosition:$('#p-pos').val()});
            dg.datagrid('getPager').pagination({
                layout:['list','sep','first','prev','sep',$('#p-style').val(),'sep','next','last','sep','refresh']
            });
        }
        
		$('#dg').datagrid({
							title : '用户列表',
							loadMsg : '数据加载中,请稍后……',
							rownumbers : true,
							pagination : true,
							pageSize : 10,
							pageList : [ 5, 10, 15, 20 ],
							fitColumns : true,
							striped : true,
							nowrap : false,
							url : '${ctx}/emp/emp-list.do',
							idField : 'mediaId',
							toolbar: [{  
					            text: '发布',  
					            iconCls: 'icon-add',  
					            handler: function() {  
					            	$("#uploadForm").dialog('open');
					            }  
					        }, '-', {  
					            text: '挂起',  
					            iconCls: 'icon-edit',  
					            handler: function() {  
					                openDialog("add_dialog","edit");  
					            }  
					        }, '-',{  
					            text: '删除',  
					            iconCls: 'icon-remove',  
					            handler: function(){  
					            	if(window.confirm("确定删除？")){
					            		var deploymentId = $(".datagrid-cell-check").find(":checked").val();
					            		if(deploymentId){
						            		var url = '${ctx}/workflow/delete.do?deploymentId='+deploymentId;
						            		window.location = url;
					            		}
					            	}
					            }  
					        }],
							columns : [[
									{ 
										field : 'priNumber',
										checkbox : true
									},
									{
										field : 'empNo',
										title : '员工编号',
										width : 150
									},
									{
										field : 'empName',
										title : '员工名称',
										width : 150
									},
									{
										field : 'enterDate',
										title : '入职时间',
										width : 150
									},
									{
										field : 'status',
										title : '状态',
										formatter : function(value, row, index) {
											return value == 1 ? "在职":"离职";
										},
										width : 150
									},
									{
										field : 'orgName',
										title : '分公司',
										width : 150
									},
									{
										field : 'deptName',
										title : '部门',
										width : 150
									}, {
										field : 'officeName',
										title : '职位',
										width : 150
									} ] ],
									singleSelect: true,
									selectOnCheck: true,
									checkOnSelect: true
						});
		
		</script>
</body>
</html>